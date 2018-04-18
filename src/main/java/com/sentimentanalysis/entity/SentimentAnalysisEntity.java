package com.sentimentanalysis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sentimentanalysis.model.SentimentAnalysisResponse;

/**
 * An entity SentimentAnalysis composed by it's fields ! The Entity annotation indicates
 * that this class is a JPA entity. The Table annotation specifies the name for the table in the db.
 *
 * @author Vishvesh Deshmukh
 */
@Entity
@Table(name = "sentimentanalysis")
public class SentimentAnalysisEntity {

	@Id
	@Column(name = "url")
	private String url;

	@Column(name = "callback_url")
	private String callbackUrl;

	@Column(name = "page_title")
	private String pageTitle;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "polarity")
	private String polarity;
	
	@Column(name = "subjectivity")
	private String subjectivity;
	
	@Column(name = "text")
	private String text;
	
	@Column(name = "polarity_confidence")
	//Convert to BigDecimal/Double value while returning
	private String polarityConfidence;
	
	@Column(name = "subjectivity_confidence")
	//Convert to BigDecimal/Double value while returning
	private String subjectivityConfidence;
	
	public SentimentAnalysisEntity() {}

	public SentimentAnalysisEntity(SentimentAnalysisResponse response) {
		this.setUrl(response.getUrl());
		this.setText(response.getText());
		this.setCallbackUrl(response.getCallbackUrl());
		this.setAuthor(response.getAuthor());
		this.setDescription(response.getDescription());
		this.setPageTitle(response.getPageTitle());
		this.setSubjectivity(response.getSubjectivity());
		this.setSubjectivityConfidence(response.getSubjectivityConfidence());
		this.setPolarity(response.getPolarity());
		this.setPolarityConfidence(response.getPolarityConfidence());
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
