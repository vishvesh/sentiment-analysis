package com.sentimentanalysis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sentimentanalysis.entity.SentimentAnalysisEntity;

public class SentimentAnalysisResponse {
	@JsonIgnore
	private String url;
	@JsonIgnore
	private String callbackUrl;
	private String pageTitle;
	private String description;
	private String author;
	private String polarity;
	private String subjectivity;
	private String text;
	
	//Convert to BigDecimal/Double value while returning
	@JsonProperty("polarity_confidence")
	private String polarityConfidence;
	
	//Convert to BigDecimal/Double value while returning
	@JsonProperty("subjectivity_confidence")
	private String subjectivityConfidence;
	
	public SentimentAnalysisResponse() {}

	public SentimentAnalysisResponse(SentimentAnalysisEntity entity) {
		this.setUrl(entity.getUrl());
		this.setText(entity.getText());
		this.setCallbackUrl(entity.getCallbackUrl());
		this.setAuthor(entity.getAuthor());
		this.setDescription(entity.getDescription());
		this.setPageTitle(entity.getPageTitle());
		this.setSubjectivity(entity.getSubjectivity());
		this.setSubjectivityConfidence(entity.getSubjectivityConfidence());
		this.setPolarity(entity.getPolarity());
		this.setPolarityConfidence(entity.getPolarityConfidence());
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPolarity() {
		return polarity;
	}

	public void setPolarity(String polarity) {
		this.polarity = polarity;
	}

	public String getSubjectivity() {
		return subjectivity;
	}

	public void setSubjectivity(String subjectivity) {
		this.subjectivity = subjectivity;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPolarityConfidence() {
		return polarityConfidence;
	}

	public void setPolarityConfidence(String polarityConfidence) {
		this.polarityConfidence = polarityConfidence;
	}

	public String getSubjectivityConfidence() {
		return subjectivityConfidence;
	}

	public void setSubjectivityConfidence(String subjectivityConfidence) {
		this.subjectivityConfidence = subjectivityConfidence;
	}

	@Override
	public String toString() {
		return "SentimentAnalysisEntity [url=" + url + ", callbackUrl=" + callbackUrl + ", pageTitle=" + pageTitle
				+ ", description=" + description + ", author=" + author + ", polarity=" + polarity + ", subjectivity="
				+ subjectivity + ", text=" + text + ", polarityConfidence=" + polarityConfidence
				+ ", subjectivityConfidence=" + subjectivityConfidence + "]";
	}
}
