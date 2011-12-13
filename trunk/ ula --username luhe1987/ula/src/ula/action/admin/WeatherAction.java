package ula.action.admin;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.MappingJsonFactory;

import ula.action.CommonAction;
import ula.common.PagingList;
import ula.constant.AlertMessage;

/**
 * 天气预报
 * 
 * @author Nanlei
 * 
 */
public class WeatherAction extends CommonAction {
	private PagingList weatherList;

	public PagingList getWeatherList() {
		return weatherList;
	}

	public String admin() throws Exception {
		weatherList = getServiceManager().getWeatherService().getAllWeather();
		return "admin";
	}

	public String update() {
		Map<String, Object> weather = getServiceManager().getWeatherService()
				.getWeatherById(getParametersAsMap());
		String cityCode = (String) weather.get("CITYCODE");
		String cityName = (String) weather.get("CITYNAME");
		String queryURL = "http://m.weather.com.cn/data/" + cityCode + ".html";
		String jsonText = null;
		HttpClient client = new HttpClient();
		GetMethod httpGet = new GetMethod(queryURL);
		try {
			int status = client.executeMethod(httpGet);
			if (status == HttpStatus.SC_OK) {// HTTP 200 OK
				InputStream is = httpGet.getResponseBodyAsStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(
						is, "UTF-8"));
				String tmpStr;
				StringBuffer sb = new StringBuffer(100);
				while ((tmpStr = br.readLine()) != null) {
					sb.append(tmpStr);
				}
				jsonText = sb.toString();
			}
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
				getServiceManager().getWeatherService()
						.updateWeatherByCityCode(map, cityCode);
				setResult(SUCCESS);
				addMessage(cityName + AlertMessage.WEATHER_UPDATE_SUCCESS);
				addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_WEATHER);
			} else {
				setResult(ERROR);
				addMessage(cityName + AlertMessage.WEATHER_UPDATE_FAILURE);
				addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
			}
		} catch (ConnectException conne) {
			log.error(ExceptionUtils.getStackTrace(conne));
			setResult(ERROR);
			addMessage(AlertMessage.WEATHER_CONNECT_TIMEOUT);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			setResult(ERROR);
			addMessage(cityName + AlertMessage.WEATHER_UPDATE_FAILURE);
			addRedirURL(AlertMessage.GO_BACK, AlertMessage.URL_GO_BACK);
		}
		return EXECUTE_RESULT;
	}

	public String setToDefault() {
		try {
			getServiceManager().getWeatherService().setDefaulyCity(
					getParametersAsMap());
			setAlertMessage(AlertMessage.WEATHER_DEFAULT_CITY_SUCCESS);
			return SUCCESS;
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			setAlertMessage(AlertMessage.WEATHER_DEFAULT_CITY_FAILURE);
			return ERROR;
		}
	}

}
