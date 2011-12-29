package ula.quartz.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.MappingJsonFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import ula.util.MapUtil;

/**
 * 天气预报定时更新Service
 * 
 * @author Nanlei
 * 
 */
public class WeatherUpdateService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private static final String SQL_GET_DEFAULT_CITY_CODE = "select CITYCODE from weather order by TAG desc";

	private ArrayList<String> getDefaultCityCode() {
		return (ArrayList<String>) jdbcTemplate.queryForList(
				SQL_GET_DEFAULT_CITY_CODE, String.class);
	}

	private static final String SQL_UPDATE_WEATHER = "update weather set TEMP1=?, TEMP2=?, IMG1=?, IMG2=?, IMG3=?, IMG4=?, UPDATETIME=now() where CITYCODE=?";

	private void updateDBInfo(Map<String, String> paramters, String cityCode) {
		Object[] params = MapUtil.getObjectArrayFromMap(paramters,
				"temp1,temp2,img1,img2,img3,img4");
		jdbcTemplate.update(SQL_UPDATE_WEATHER, ArrayUtils
				.add(params, cityCode));
	}

	private String getJSONText(String queryURL) throws HttpException,
			IOException {
		String jsonText = null;
		HttpClient client = new HttpClient();
		GetMethod httpGet = new GetMethod(queryURL);
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
			jsonText = sb.toString();
		}
		return jsonText;
	}

	public void updateWeather() throws Exception {
		ArrayList<String> cityCodes = getDefaultCityCode();
		for (String cityCode : cityCodes) {
			String queryURL = "http://m.weather.com.cn/data/" + cityCode
					+ ".html";
			String jsonText = getJSONText(queryURL);
			if (StringUtils.isNotEmpty(jsonText)) {
				JsonFactory jsonFactory = new MappingJsonFactory();
				// Json解析器
				JsonParser jsonParser = jsonFactory.createJsonParser(jsonText);
				// 跳到结果集的开始
				jsonParser.nextToken();
				// 接受结果的HashMap
				HashMap<String, String> map = new HashMap<String, String>();
				// while循环遍历Json结果
				while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
					// 跳转到Value
					jsonParser.nextToken();
					// 将Json中的值装入Map中
					map.put(jsonParser.getCurrentName(), jsonParser.getText());
				}
				// 处理数据
				updateDBInfo(map, cityCode);
			}
		}
		logger
				.info("Update " + cityCodes.size()
						+ " city(cities) weather info");
	}
}
