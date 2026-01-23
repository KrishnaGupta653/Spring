package com.shadowdev.journalApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.shadowdev.journalApp.entity.JournalEntry;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, String> {
    

}
