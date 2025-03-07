package com.example.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	/*
	@Autowired
	private JobBuilder jobBuilder;
	
	@Autowired
	private StepBuilder stepBuilder;
	*/
	
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired 
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job imprimeJob() {
		return jobBuilderFactory
				.get("imprimeJob")
				.start(imprimeOlaStep())
				.build();
	}

	public Step imprimeOlaStep() {
		return stepBuilderFactory
				.get("imprimeJob")
				.tasklet(new Tasklet() {
					
					@Override
					public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
						System.out.println("Olá, mundo!");
						return RepeatStatus.FINISHED;
					}
				})
				.build();
	}
	
	
	
	
	
}
