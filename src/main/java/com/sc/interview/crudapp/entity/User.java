package com.sc.interview.crudapp.entity;

import com.sc.interview.crudapp.constant.SchemaConstant;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.UUID;

@Table(name = "USER", schema = SchemaConstant.SchemaName)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private UUID id;

    @Column(name = "FIRST_NAME", nullable = false)
    @Size(max = 50)
    private String firstName;

    @Column(name = "MIDDLE_NAME")
    @Size(max = 50)
    private String middleName;

    @Column(name = "LAST_NAME", nullable = false)
    @Size(max = 50)
    private String lastName;

    @Column(name = "DATE_OF_BIRTH", nullable = false)
    private Date dob;

    @Column(name = "MOBILE", nullable = false)
    @Size(max = 15)
    private String mobile;

    @Enumerated(EnumType.STRING)
    @Column(name = "GENDER", nullable = false)
    private Gender gender;

    @Column(name = "CUSTOMER_NUMBER", nullable = false, unique = true)
    @Size(max = 20)
    private String customerNumber;

    @Column(name = "COUNTRY_BIRTH", nullable = false)
    @Size(max = 50)
    private String countryOfBirth;

    @Column(name = "COUNTRY_RESIDENCE", nullable = false)
    @Size(max = 50)
    private String countryOfResidence;

    @Enumerated(EnumType.STRING)
    @Column(name = "CUSTOMER_SEGMENT", nullable = false)
    private CustomerSegment customerSegment;

}
