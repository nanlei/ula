package ula.bean.exchange;

import java.io.Serializable;

/**
 * 构造汇率对象<br>
 * 解析地址：http://themoneyconverter.com/rss-feed/RUB/rss.xml
 * 
 * @author Nanlei
 * 
 */
public class ExchangeRateResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private Channel channel;

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

}
