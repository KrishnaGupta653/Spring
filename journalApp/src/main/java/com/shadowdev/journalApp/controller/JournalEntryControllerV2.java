package com.shadowdev.journalApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.shadowdev.journalApp.entity.JournalEntry;
import com.shadowdev.journalApp.entity.User;
import com.shadowdev.journalApp.service.JournalEntryService;
import com.shadowdev.journalApp.service.UserService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {
    //private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @Autowired
    private JournalEntryService journalEntryService;
    @Autowired
    private UserService userService;


    // @GetMapping
    // public List<JournalEntry> getAll() {
    //     return journalEntryService.getAll();
    // }

    @GetMapping("/{username}")
    public ResponseEntity<?> getAllJournalEntriesOfUser(@PathVariable String username){
        User user=userService.getUserByUsername(username);
        List<JournalEntry> all=user.getJournalEntries();
        if(all!=null && !all.isEmpty()) {
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    


    // @PostMapping
    // public JournalEntry createEntry(@RequestBody JournalEntry myEntry) {
    //     myEntry.setDate(LocalDateTime.now());
    //     journalEntryService.saveEntry(myEntry);
    //     return myEntry;
    // }
    @PostMapping("/{username}")
    public JournalEntry createEntry(@PathVariable String username, @RequestBody JournalEntry myEntry) { 
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry,username);
        return myEntry;
    } 
    @GetMapping("id/{myId}") 
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId myId) {
        Optional<JournalEntry> journalEntry = journalEntryService.getById(myId);
        if(journalEntry.isPresent()) {
            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }
    
    

    // @PutMapping("/id/{myId}")
    // public JournalEntry updateJournalById(@PathVariable ObjectId myId, @RequestBody JournalEntry newEntry) {
    //     JournalEntry old = journalEntryService.getById(myId).orElse(null); 
    //     if (old!=null) {
    //         old.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
    //     }
    //     journalEntryService.saveEntry(old);
    //     return old; 
    // }
    @PutMapping("{username}/id/{id}")
    public String updateJournalById(@PathVariable String username, @PathVariable ObjectId id, @RequestBody JournalEntry newEntry) {
        
        return ;
    }

    // @DeleteMapping("id/{myId}")
    // public ResponseEntity<Void> deleteJournalEntrybyId(@PathVariable ObjectId myId) {
    //     journalEntryService.deleteById(myId);
    //     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }

    @DeleteMapping("{username}/id/{myId}")
        public ResponseEntity<Void> deleteJournalEntrybyId(@PathVariable String username, @PathVariable ObjectId myId) {
            
            journalEntryService.deleteById(myId, username);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    
}
