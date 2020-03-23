package com.tasklist.tasklist.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Task implements AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O campo titulo e obrigatorio")
    @Column(nullable = false)
    private String title;

    private String status;

    private String description;

    private LocalDate creationDate;

    private LocalDate updateDate;

    private LocalDate conclusionDate;
}
