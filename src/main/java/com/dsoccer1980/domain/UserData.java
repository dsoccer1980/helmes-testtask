package com.dsoccer1980.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_data")
public class UserData {
    public static final int START_SEQ = 10000;

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    private int id;

    @Column(name = "name")
    @NotBlank
    @Size(max = 50)
    private String name;

    @Column(name = "is_agree")
    private boolean isAgree;

    @Column(name = "sectors")
    @NotBlank
    private String sectors;

    public UserData(String name, boolean isAgree, String sectors) {
        this.name = name;
        this.isAgree = isAgree;
        this.sectors = sectors;
    }
}
