package com.shadowdev.journalApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shadowdev.journalApp.entity.JournalEntry;
import com.shadowdev.journalApp.service.JournalEntryService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.*;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {
    //private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @Autowired
    private JournalEntryService journalEntryService;


    @GetMapping
    public List<JournalEntry> getAll() {
        return journalEntryService.getAll();
    }
    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry) {
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return myEntry;
    }
    @GetMapping("id/{myId}") 
    public JournalEntry getJournalEntryById(@PathVariable ObjectId myId) {
        return journalEntryService.getById(myId);
    }
    @PutMapping("/id/{myId}")
    public JournalEntry updateJournalById(@PathVariable ObjectId myId, @RequestBody JournalEntry newEntry) {
        JournalEntry old = journalEntryService.getById(myId); 
        if (old!=null) {
            old.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
        }
        journalEntryService.saveEntry(old);
        return old; 
    }
    @DeleteMapping("id/{myId}")
    public boolean deleteJournalEntrybyId(@PathVariable ObjectId myId) {
        journalEntryService.deleteById(myId);
        return true;
    }

    
}
