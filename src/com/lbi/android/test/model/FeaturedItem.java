package com.lbi.android.test.model;

public class FeaturedItem 
{
	private CharSequence title;
	private CharSequence subTitle;
	private String imgUrl;
	private String contentType;
	
	public CharSequence getTitle() {
		return title;
	}
	public void setTitle(CharSequence title) {
		this.title = title;
	}
	public CharSequence getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(CharSequence subTitle) {
		this.subTitle = subTitle;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
}
