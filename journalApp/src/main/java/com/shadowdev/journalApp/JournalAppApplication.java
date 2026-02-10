package com.shadowdev.journalApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mongodb.client.MongoDatabase;

@SpringBootApplication
@EnableTransactionManagement
public class JournalAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(JournalAppApplication.class, args);
	}
	@Bean //->we can do all this in the same class or we can create a separate configuration class for transaction management. It's often a good practice to keep configuration classes separate for better organization and maintainability, but it's not strictly necessary. In this case, since we only have one bean related to transaction management, it's fine to include it in the main application class.
	public PlatformTransactionManager transactionManager(MongoDatabaseFactory DbFactory) {
		return new MongoTransactionManager(DbFactory);
	}
}
//PlatformTransactionManager 
//MongoTransactionManager
//these are the transaction managers that Spring uses to manage transactions. By enabling @EnableTransactionManagement, Spring will automatically look for these transaction managers and use them to manage transactions in your application. PlatformTransactionManager is a general interface for transaction management in Spring, while MongoTransactionManager is specifically designed for managing transactions in MongoDB. When you perform operations that require transactions (like saving a journal entry and updating the user's journal entries list), Spring will use the appropriate transaction manager to ensure that all operations are executed atomically.
//  In the context of a MongoDB application, MongoTransactionManager is used to manage transactions when performing operations on the database.