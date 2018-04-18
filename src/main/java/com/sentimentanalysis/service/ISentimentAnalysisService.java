package com.sentimentanalysis.service;

import org.springframework.stereotype.Service;

import com.sentimentanalysis.model.SentimentAnalysisResponse;
import com.sentimentanalysis.model.URLParsingRequest;

@Service
public interface ISentimentAnalysisService {

	SentimentAnalysisResponse findAnalyzedSentimentForURL(String url);
	SentimentAnalysisResponse analyzeSentimentForURL(URLParsingRequest request);
}
