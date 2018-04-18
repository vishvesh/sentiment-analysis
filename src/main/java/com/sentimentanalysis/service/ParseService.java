package com.sentimentanalysis.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.springframework.stereotype.Service;

import com.sentimentanalysis.model.SentimentAnalysisResponse;
import com.sentimentanalysis.model.URLParsingRequest;
import com.sentimentanalysis.service.callables.ParseCallable;

@Service
public class ParseService implements IParseService {
	
	@Override
	public Future<SentimentAnalysisResponse> parseHTMLDocument(final ExecutorService executor, final URLParsingRequest request) {
		return executor.submit(new ParseCallable(request));
	}
}
