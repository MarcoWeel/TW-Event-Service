package com.tacticalwolves.eventservice.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Event")
public class Event {
    @Id
    @GeneratedValue
    private int Id;
    private String Name;
    private String Location;
    private String LocationUrl;
    private Date dateTime;
    
}
