package com.sc.interview.crudapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sc.interview.crudapp.entity.Address;
import com.sc.interview.crudapp.entity.CustomerSegment;
import com.sc.interview.crudapp.entity.Gender;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private int id;

    @NotNull
    @Size(max = 50, message = "First Name cannot be more than 50 characters long.")
    @JsonProperty("first-name")
    private String firstName;

    @JsonProperty("middle-name")
    @Size(max = 50, message = "Middle Name cannot be more than 50 characters long.")
    private String middleName;

    @NotNull
    @JsonProperty("last-name")
    @Size(max = 50, message = "Last Name cannot be more than 50 characters long.")
    private String lastName;

    @NotNull
    @JsonProperty("date-of-birth")
    private Date dob;

    @NotNull
    @JsonProperty("mobile-number")
    @Size(max = 15, message = "Mobile number cannot have more than 15 characters.")
    private String mobile;

    @NotNull
    @JsonProperty("gender")
    private Gender gender;

    @JsonProperty("customer-number")
    private String customerNumber;

    @JsonProperty("country-of-birth")
    @NotNull
    @Size(max = 50, message = "Country of birth cannot have length more than 50 characters.")
    private String countryOfBirth;

    @JsonProperty("country-of-residence")
    @NotNull
    @Size(max = 50, message = "Country of residence cannot have length more than 50 characters.")
    private String countryOfResidence;

    @NotNull
    @JsonProperty("customer-segment")
    private CustomerSegment customerSegment;

    @JsonProperty("addresses")
    private List<Address> addressList;
}
