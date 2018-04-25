package com.example.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountEditForm {
    @NotNull
    @Size(min = 1, max = 10)
    private String name;
    @NotNull
    @Size(min = 5, max = 200)
    private String address;
}
