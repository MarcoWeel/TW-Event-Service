package com.tacticalwolves.eventservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.File;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EventLocation")
public class EventLocation {
    @Id
    @GeneratedValue
    private int Id;
    private String name;
    private String FileLocation;
}
