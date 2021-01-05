package com.tacticalwolves.eventservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EventImage")
public class EventImage {
    @Id
    @GeneratedValue
    private int Id;
    //aanpassen zodra amazon s3 opgezet is
    String FileLocation;
}
