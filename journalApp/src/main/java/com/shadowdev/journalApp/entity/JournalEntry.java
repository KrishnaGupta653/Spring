package com.shadowdev.journalApp.entity;
import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor // No-argument constructor
@Document(collection = "journalEntries")    // Marks this class as a MongoDB document entity it means this class will be mapped to a collection in MongoDB
public class JournalEntry {
    @Id // Marks this field as the primary key for the document 
    // @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private String title;
    private String content;
    private LocalDateTime date;

    
}
