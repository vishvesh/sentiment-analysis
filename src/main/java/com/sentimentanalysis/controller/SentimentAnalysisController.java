package com.sentimentanalysis.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sentimentanalysis.model.SentimentAnalysisResponse;
import com.sentimentanalysis.model.URLParsingRequest;
import com.sentimentanalysis.service.ISentimentAnalysisService;

/**
 * Controller class which exposes POST and GET Endpoints for Sentiment Analysis based on {@link URLParsingRequest} Request. 
 *  
 * @author Vishvesh
 */
@RestController
public class SentimentAnalysisController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ISentimentAnalysisService sentimentAnalysisService;

	@GetMapping("/data")
	public ResponseEntity<SentimentAnalysisResponse> findAnalyzedSentimentForURL(final @RequestParam("url") String url) throws Exception {
		if(url == null)
			return ResponseEntity.badRequest().body(null);
		SentimentAnalysisResponse analyzedURL = sentimentAnalysisService.findAnalyzedSentimentForURL(url);
		return ResponseEntity.ok().body(analyzedURL);
	}
	
	@PostMapping("/data")
	public ResponseEntity<SentimentAnalysisResponse> analyzeSentimentForURL(final @Valid @RequestBody URLParsingRequest request) {
		logger.info("Performing Sentiment Analysis for Request : "+request.toString());
		SentimentAnalysisResponse analyzedResponse = sentimentAnalysisService.analyzeSentimentForURL(request);
		return ResponseEntity.ok().body(analyzedResponse);
	}
}
