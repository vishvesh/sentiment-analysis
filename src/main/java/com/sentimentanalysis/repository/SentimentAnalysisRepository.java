package com.sentimentanalysis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sentimentanalysis.entity.SentimentAnalysisEntity;

@Repository
@Transactional
public interface SentimentAnalysisRepository extends JpaRepository<SentimentAnalysisEntity, String> {
	
}
