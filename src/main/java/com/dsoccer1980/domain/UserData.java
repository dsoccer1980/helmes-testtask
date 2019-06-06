package com.dsoccer1980.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserData {
    public static final int START_SEQ = 10000;

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    private int id;

    private String name;

    @Column(name = "is_agree")
    private boolean isAgree;

    private String sectors;

    public UserData(String name, boolean isAgree, String sectors) {
        this.name = name;
        this.isAgree = isAgree;
        this.sectors = sectors;
    }
}
