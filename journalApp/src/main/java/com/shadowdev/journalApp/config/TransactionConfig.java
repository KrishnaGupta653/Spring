package com.shadowdev.journalApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
//same as the transaction manager bean in the main application class but here we are keeping it separate for better organization and maintainability. This class is responsible for configuring transaction management in the application, specifically for MongoDB transactions. By defining the transactionManager bean, we are telling Spring how to manage transactions when performing operations on the MongoDB database. The @EnableTransactionManagement annotation enables Spring's annotation-driven transaction management capability, allowing us to use @Transactional annotations in our service methods to ensure that operations are executed within a transactional context.
@Configuration
@EnableTransactionManagement
public class TransactionConfig {
    @Bean
	public PlatformTransactionManager transactionManager(MongoDatabaseFactory DbFactory) {
		return new MongoTransactionManager(DbFactory);
	}
    
}
