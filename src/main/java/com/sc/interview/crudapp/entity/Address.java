package com.sc.interview.crudapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sc.interview.crudapp.constant.SchemaConstant;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "ADDRESS", schema = SchemaConstant.SchemaName)
public class Address {

    @Id
    @Column(name = "ID", nullable = false)
    private UUID id;

    @JoinColumn(name = "USER_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "ADDRESS_TYPE", nullable = false)
    private AddressType addressType;

    @Column(name = "LINE_1", nullable = false)
    @Size(max = 50)
    private String line1;

    @Column(name = "LINE_2")
    @Size(max = 50)
    private String line2;

    @Column(name = "LINE_3")
    @Size(max = 50)
    private String line3;

    @Column(name = "LINE_4")
    @Size(max = 50)
    private String line4;

    @Column(name = "COUNTRY_CODE", nullable = false)
    @Size(max = 5)
    private String countryCode;

    @Column(name = "ZIP_CODE", nullable = false)
    @Min(0)
    private int zipcode;

    @Column(name = "STATE", nullable = false)
    @Size(max = 50)
    private String state;

    @Column(name = "CITY", nullable = false)
    @Size(max = 50)
    private String city;

    @Column(name = "CREATED_TIMESTAMP", insertable = false, updatable = false, nullable = false)
    private Timestamp createdTimestamp;

    @Column(name = "UPDATED_TIMESTAMP", insertable = false, updatable = false, nullable = false)
    private Timestamp updatedTimestamp;
}
