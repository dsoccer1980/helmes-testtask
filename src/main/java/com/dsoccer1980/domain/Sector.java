package com.dsoccer1980.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sector")
public class Sector {

    @Id
    private int id;

    @Column(name = "parent_id")
    @Range(min = 0)
    private int parentId;

    @NotBlank
    @Size(max = 100)
    @Column(name = "name")
    private String name;
}
