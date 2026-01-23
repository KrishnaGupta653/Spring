
package com.shadowdev.journalApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shadowdev.journalApp.entity.JournalEntry;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {
    private Map<Long, JournalEntry> journalEntries = new HashMap<>();
    @GetMapping
    public List<JournalEntry> getAll() {
        return null;
    }
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry) {
        return (Boolean) null;
    }
    @GetMapping("id/{myId}") 
    public JournalEntry getJournalEntryById(@PathVariable long myId) {
        return null;
    }
    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalEntrybyId(@PathVariable long myId) {
        return null;
    }

    
}
