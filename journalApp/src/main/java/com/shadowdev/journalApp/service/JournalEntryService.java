package com.shadowdev.journalApp.service;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.shadowdev.journalApp.entity.JournalEntry;
import com.shadowdev.journalApp.repository.JournalEntryRepository;

@Component
public class JournalEntryService  {
    @Autowired
    private JournalEntryRepository journalEntryRepository;
    
    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }
    
    public List<JournalEntry>getAll(){
        return journalEntryRepository.findAll();
    }
    public JournalEntry getById(ObjectId id) {
        return journalEntryRepository.findById(id).orElse(null);
    }

    public void deleteById(ObjectId myId) {
        journalEntryRepository.deleteById(myId);
    }
    
}
