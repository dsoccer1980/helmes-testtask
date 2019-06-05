package com.dsoccer1980.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sector {

    @Id
    private int id;

    @Column(name = "parent_id")
    private int parentId;

    private String name;
}
