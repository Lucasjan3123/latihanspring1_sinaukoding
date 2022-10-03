package com.example.sinaukoding.Entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponsAuthDTO {
    private Long id;

    private String username;

    private String profileName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String token;
}
