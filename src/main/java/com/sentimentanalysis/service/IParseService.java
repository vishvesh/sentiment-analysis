package com.sentimentanalysis.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.springframework.stereotype.Service;

import com.sentimentanalysis.model.SentimentAnalysisResponse;
import com.sentimentanalysis.model.URLParsingRequest;

@Service
public interface IParseService {

	Future<SentimentAnalysisResponse> parseHTMLDocument(ExecutorService executor, URLParsingRequest request);
}
