package com.sentimentanalysis.service.callables;

import java.io.IOException;
import java.util.concurrent.Callable;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.sentimentanalysis.model.SentimentAnalysisResponse;
import com.sentimentanalysis.model.URLParsingRequest;

/**
 * Worker Callable class to perform the HTML/DOM Parsing - 
 *  
 * @author Vishvesh
 */
public class ParseCallable implements Callable<SentimentAnalysisResponse> {
	final URLParsingRequest request;

	public ParseCallable(final URLParsingRequest request) {
		this.request = request;
	}

	@Override
	public SentimentAnalysisResponse call() throws Exception {
		if (request.getUrl() == null)
			return null;
		Document doc;
		SentimentAnalysisResponse response = null;
		try {
			doc = Jsoup.connect(request.getUrl()).get();

			/** Get page title */
			String author = "", description = "";
			String title = doc.title();

			Elements descriptionElems = doc.select("meta[name=description]");
			if (descriptionElems != null && !descriptionElems.isEmpty()) {
				description = descriptionElems.get(0).attr("content");
			}

			Elements authorElems = doc.select("meta[name=author]");
			if (authorElems != null && !authorElems.isEmpty()) {
				author = authorElems.get(0).attr("content");
			}

			response = new SentimentAnalysisResponse();
			response.setUrl(request.getUrl());
			response.setCallbackUrl(request.getCallbackUrl());
			response.setText(description);
			response.setPageTitle(title);
			response.setAuthor(author);
			response.setDescription(description);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}
}
