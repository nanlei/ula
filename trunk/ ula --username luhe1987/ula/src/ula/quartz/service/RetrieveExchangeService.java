package ula.quartz.service;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.channels.Channel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import ula.bean.exchange.ExchangeRateResponse;
import ula.bean.exchange.Item;
import ula.util.CalendarUtil;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * 获取汇率Service
 * 
 * @author Nanlei
 * 
 */
public class RetrieveExchangeService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private String RSS_URL = "http://themoneyconverter.com/rss-feed/RUB/rss.xml";

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private String getRSSResponse() throws HttpException, IOException {
		String xmlResponse = null;
		HttpClient client = new HttpClient();
		GetMethod httpGet = new GetMethod(RSS_URL);
		int status = client.executeMethod(httpGet);
		if (status == HttpStatus.SC_OK) {// HTTP 200 OK
			InputStream is = httpGet.getResponseBodyAsStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is,
					"UTF-8"));
			String tmpStr;
			StringBuffer sb = new StringBuffer(100);
			while ((tmpStr = br.readLine()) != null) {
				sb.append(tmpStr);
			}
			xmlResponse = sb.toString();
		}
		return xmlResponse;
	}

	private XStream constructXStream() {
		XStream xstream = new XStream(new DomDriver());
		xstream.useAttributeFor(String.class);
		xstream.alias("rss", ExchangeRateResponse.class);
		xstream.alias("channel", Channel.class);
		xstream.alias("image", Image.class);
		xstream.alias("item", Item.class);
		return xstream;
	}

	private static final String SQL_UPDATE_EXCHANGE_RATE = "update exchange_rate set LINK=?, PUB_DATE=?, VALUE=?, DESCRIPTION=?, UPDATETIME=now() where TITLE=?";

	public void retrieveExchange() throws Exception {
		String xmlResponse = getRSSResponse();
		StringBuffer xmlBuffer = new StringBuffer();
		// 重新拼装XML，生成符合解析规范的格式
		xmlBuffer.append(
				xmlResponse.substring(0, xmlResponse.indexOf("<item>")))
				.append("<items>").append(
						xmlResponse.substring(xmlResponse.indexOf("<item>"),
								xmlResponse.lastIndexOf("</channel>"))).append(
						"</items></channel></rss>");
		XStream xstream = constructXStream();
		if (StringUtils.isNotEmpty(xmlResponse)) {
			ExchangeRateResponse response = (ExchangeRateResponse) xstream
					.fromXML(xmlBuffer.toString());
			final List<Item> items = response.getChannel().getItems();
			jdbcTemplate.batchUpdate(SQL_UPDATE_EXCHANGE_RATE,
					new BatchPreparedStatementSetter() {
						public void setValues(PreparedStatement ps, int i)
								throws SQLException {
							Item item = items.get(i);
							String tempValue[] = item
									.getDescription()
									.substring(
											item.getDescription().indexOf("=") + 1)
									.trim().split(" ");
							String tempPubDate[] = item.getPubDate().split(" ");
							ps.setObject(1, item.getLink());
							ps.setObject(2, CalendarUtil.getDate() + " "
									+ tempPubDate[4]);
							ps.setObject(3, tempValue[0]);
							ps.setObject(4, item.getDescription());
							ps.setObject(5, item.getTitle());
						}

						public int getBatchSize() {
							return items.size();
						}
					});
			logger.info("Update {} exchange rate", items.size());
		}
	}

}
