package com.shadowdev.journalApp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.shadowdev.journalApp.entity.JournalEntry;
import com.shadowdev.journalApp.repository.JournalEntryRepository;

public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;
    
    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }
    
    
}
