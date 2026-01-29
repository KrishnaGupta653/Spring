package com.shadowdev.journalApp.entity;
import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "journalEntries")    // Marks this class as a MongoDB document entity it means this class will be mapped to a collection in MongoDB
public class JournalEntry {
    @Id // Marks this field as the primary key for the document 
    // @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private String title;
    private String content;
    private LocalDateTime date;
    
    public ObjectId getId() {
        return id;
    }
    public void setId(ObjectId id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime  date) {
        this.date = date;
    }

    
    
}
