package com.idorasi.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "visits")
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Visit extends BaseEntityClass {

    private UUID publicIdentifier;
    private LocalDate visitDate;
    private String description;
    private Pet pet;

}
