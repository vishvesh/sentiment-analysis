package com.sentimentanalysis.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aylien.textapi.TextAPIClient;
import com.sentimentanalysis.model.SentimentAnalysisResponse;
import com.sentimentanalysis.model.URLParsingRequest;
import com.sentimentanalysis.service.callables.AylienSentimentCallable;

@Service
public class AylienService implements IAylienService {
	
	@Value("${aylien.api.key}")
	private String aylienApiKey;
	
	@Value("${aylien.api.appid}")
	private String aylienApiAppId;
	
	private TextAPIClient aylienClient;
	
	@PostConstruct
	void initializeAylienClient() {
		aylienClient = new TextAPIClient(aylienApiAppId, aylienApiKey);
	}

	@Override
	public Future<SentimentAnalysisResponse> analyzeSentimentForURL(final ExecutorService executor, final URLParsingRequest request) {
		return executor.submit(new AylienSentimentCallable(request, aylienClient));
	}
}
