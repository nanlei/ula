package ula.bean.exchange;

import java.io.Serializable;

public class Item implements Serializable {

	private static final long serialVersionUID = 1L;
	private String title;
	private String link;
	private String guid;
	private String pubDate;
	private String description;
	private String category;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Item [category=" + category + ", description=" + description
				+ ", guid=" + guid + ", link=" + link + ", pubDate=" + pubDate
				+ ", title=" + title + "]";
	}

}
