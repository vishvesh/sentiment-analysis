package com.sentimentanalysis.service.callables;

import java.net.URL;
import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aylien.textapi.TextAPIClient;
import com.aylien.textapi.parameters.SentimentParams;
import com.aylien.textapi.responses.Sentiment;
import com.sentimentanalysis.model.SentimentAnalysisResponse;
import com.sentimentanalysis.model.URLParsingRequest;

/**
 * Worker Callable class to perform the Sentiment Analysis based on Input Text - 
 *  
 * @author Vishvesh
 */
public class AylienSentimentCallable implements Callable<SentimentAnalysisResponse> {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	final URLParsingRequest request;
	final TextAPIClient aylienClient;

	public AylienSentimentCallable(URLParsingRequest request, TextAPIClient aylienClient) {
		this.request = request;
		this.aylienClient = aylienClient;
	}

	@Override
	public SentimentAnalysisResponse call() throws Exception {
		if (this.request.getUrl() == null)
			return null;
		
		SentimentParams.Builder builder = SentimentParams.newBuilder();
	    builder.setUrl(new URL(this.request.getUrl()));
	    Sentiment sentiment = this.aylienClient.sentiment(builder.build());
	    logger.info(sentiment.toString());
		
		SentimentAnalysisResponse response = new SentimentAnalysisResponse();
		response.setPolarity(sentiment.getPolarity());
		response.setText(sentiment.getText());
		response.setPolarityConfidence(Double.toString(sentiment.getPolarityConfidence()));
		response.setSubjectivity(sentiment.getSubjectivity());
		response.setSubjectivityConfidence(Double.toString(sentiment.getSubjectivityConfidence()));
		return response;
	}
}
