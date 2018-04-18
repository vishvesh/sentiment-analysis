package com.sentimentanalysis.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Request Body from the Client which provides the URL and the Callback-URL in POST Request..
 *  
 * @author Vishvesh
 */
public class URLParsingRequest {

	@NotNull(message = "Please provide a valid Non-Null URL Input")
	@JsonProperty(required = true)
	private String url;

	@JsonProperty(required = false)
	private String callbackUrl;

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

	@Override
	public String toString() {
		return "URLParsingRequest [url=" + url + ", callbackUrl=" + callbackUrl + "]";
	}
}
