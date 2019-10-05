package com.sc.interview.crudapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sc.interview.crudapp.entity.AddressType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressDto {

    private int id;

    @NotNull
    @JsonProperty("type")
    private AddressType addressType;

    @NotNull
    @JsonProperty("addr-line1")
    @Size(max = 50, message = "Address Line 1 cannot be more than 50 characters in length.")
    private String line1;

    @JsonProperty("addr-line2")
    @Size(max = 50, message = "Address Line 2 cannot be more than 50 characters in length.")
    private String line2;

    @JsonProperty("addr-line3")
    @Size(max = 50, message = "Address Line 3 cannot be more than 50 characters in length.")
    private String line3;

    @JsonProperty("addr-line4")
    @Size(max = 50, message = "Address Line 4 cannot be more than 50 characters in length.")
    private String line4;

    @NotNull
    @JsonProperty("country-code")
    @Size(max = 5, message = "Country code cannot be more than 5 characters in length.")
    private String countryCode;

    @NotNull
    @JsonProperty("zipcode")
    @Min(value = 0, message = "ZipCode cannot be negative.")
    private int zipcode;

    @NotNull
    @JsonProperty("state")
    @Size(max = 50, message = "State cannot be more than 50 characters in length.")
    private String state;

    @NotNull
    @JsonProperty("city")
    @Size(max = 50, message = "State cannot be more than 50 characters in length.")
    private String city;

}
