package com.shadowdev.journalApp.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.shadowdev.journalApp.entity.JournalEntry;
import com.shadowdev.journalApp.entity.User;
import com.shadowdev.journalApp.repository.JournalEntryRepository;

@Component
public class JournalEntryService  {
    @Autowired
    private JournalEntryRepository journalEntryRepository;
    @Autowired
    private UserService userService;
    
    // public void saveEntry(JournalEntry journalEntry) {
    //     journalEntryRepository.save(journalEntry);
    // }
    public void saveEntry(JournalEntry journalEntry, String username) {
    
        User user=userService.getUserByUsername(username);
        JournalEntry savedEntry=journalEntryRepository.save(journalEntry); //returns saved entry with id
        //System.out.println("Saved Entry ID: " + savedEntry);
        user.getJournalEntries().add(savedEntry);
        userService.saveUser(user); //update user with new journal entry
    }
    
    public List<JournalEntry>getAll(){
        return journalEntryRepository.findAll();
    }
    public Optional<JournalEntry> getById(ObjectId myId) {
        return journalEntryRepository.findById(myId);
    }

    public void deleteById(ObjectId myId, String username) {
        journalEntryRepository.deleteById(myId);//delete from journal entries collection
        
        //also remove reference from user's journal entries list
        User user=userService.getUserByUsername(username);
        List<JournalEntry> entries=user.getJournalEntries();
        entries.removeIf(entry->entry.getId().equals(myId));
        userService.saveUser(user); //update user after removing journal entry
    }
    
}
