package com.sentimentanalysis.util;

import java.util.function.Function;

import com.sentimentanalysis.entity.SentimentAnalysisEntity;
import com.sentimentanalysis.model.SentimentAnalysisResponse;

public class ResponseUtil {

	public static Function<SentimentAnalysisEntity, SentimentAnalysisResponse> TO_SENTIMENT_RESPONSE = new Function<SentimentAnalysisEntity, SentimentAnalysisResponse>() {
		@Override
		public SentimentAnalysisResponse apply(SentimentAnalysisEntity entity) {
			if(entity != null) {
				return new SentimentAnalysisResponse(entity);
			}
			return null;
		}
	};
	
	public static Function<SentimentAnalysisResponse, SentimentAnalysisEntity> SENTIMENT_RESPONSE_TO_ENTITY = new Function<SentimentAnalysisResponse, SentimentAnalysisEntity>() {
		@Override
		public SentimentAnalysisEntity apply(SentimentAnalysisResponse response) {
			if(response != null) {
				return new SentimentAnalysisEntity(response);
			}
			return null;
		}
	};
	
	public static SentimentAnalysisEntity sentimentAnalysisResponseToEntity(SentimentAnalysisResponse response) {
		if(response == null) {
			return null;
		}
		return SENTIMENT_RESPONSE_TO_ENTITY.apply(response);
	}
	
	public static SentimentAnalysisResponse toSentimentAnalysisResponse(SentimentAnalysisEntity entity) {
		if(entity == null) {
			return null;
		}
		return TO_SENTIMENT_RESPONSE.apply(entity);
	}
}
