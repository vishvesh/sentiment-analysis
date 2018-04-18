package com.sentimentanalysis.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sentimentanalysis.entity.SentimentAnalysisEntity;
import com.sentimentanalysis.model.SentimentAnalysisResponse;
import com.sentimentanalysis.model.URLParsingRequest;
import com.sentimentanalysis.repository.SentimentAnalysisRepository;
import com.sentimentanalysis.util.ResponseUtil;

@Service
public class SentimentAnalysisService extends ResponseUtil implements ISentimentAnalysisService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IParseService parseService;
	
	@Autowired
	private IAylienService aylienService;
	
	@Autowired
	private SentimentAnalysisRepository sentimentAnalysisRepository;
	
	private final ExecutorService executor = Executors.newCachedThreadPool();

	@Override
	public SentimentAnalysisResponse analyzeSentimentForURL(URLParsingRequest request) {
		logger.info("Analyzing URL Document for Sentiment - "+request.getUrl());
		
		/** Step 1. Parse the page with the given URL for page title, page description, author */
		Future<SentimentAnalysisResponse> parseFuture = parseService.parseHTMLDocument(executor, request);
		Future<SentimentAnalysisResponse> sentimentFuture = aylienService.analyzeSentimentForURL(executor, request);
		SentimentAnalysisResponse parsedResponse = null;
		try {
			parsedResponse = parseFuture.get(10, TimeUnit.SECONDS);
			logger.info("Parsed HTML Document = "+parsedResponse.toString());
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}
		
		/** TODO: Step 2. Use aylein.com's sentiment analysis API - retrieve polarity, subjectivity, related confidence numbers */
		SentimentAnalysisResponse sentimentResponse = null;
		try {
			sentimentResponse = sentimentFuture.get(10, TimeUnit.SECONDS);
			logger.info("Got Sentiment = "+sentimentFuture.toString());
			
			parsedResponse.setText(sentimentResponse.getText());
			parsedResponse.setPolarity(sentimentResponse.getPolarity());
			parsedResponse.setSubjectivity(sentimentResponse.getSubjectivity());
			parsedResponse.setPolarityConfidence(sentimentResponse.getPolarityConfidence());
			parsedResponse.setSubjectivityConfidence(sentimentResponse.getSubjectivityConfidence());
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}
		
		/** Store the information in the DB and return the Response back -- */
		SentimentAnalysisEntity entity = sentimentAnalysisResponseToEntity(parsedResponse);
		sentimentAnalysisRepository.save(entity);
		return parsedResponse;
	}

	@Override
	public SentimentAnalysisResponse findAnalyzedSentimentForURL(String url) {
		SentimentAnalysisEntity entity = sentimentAnalysisRepository.findOne(url);
		logger.info("Sentiment Analysis Entity = "+entity.toString());
		return toSentimentAnalysisResponse(entity);
	}
}
