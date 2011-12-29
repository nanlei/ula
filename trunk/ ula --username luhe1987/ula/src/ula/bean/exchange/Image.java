package ula.bean.exchange;

import java.io.Serializable;

public class Image implements Serializable {

	private static final long serialVersionUID = 1L;
	private String title;
	private String url;
	private String link;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
