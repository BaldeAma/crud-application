package com.formation.crud_application.model;

import jakarta.persistence.*;
import lombok.*;

import java.beans.ConstructorProperties;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    @NonNull private String firstName;
    @Column(name = "last_name")
    @NonNull private String lastName;
    @Column(name = "email_id")
    @NonNull private String emailId;

}
