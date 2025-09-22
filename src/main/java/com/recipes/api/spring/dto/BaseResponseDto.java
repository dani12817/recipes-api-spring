package com.recipes.api.spring.dto;

import java.io.Serial;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponseDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -7234992900702533827L;

    protected String message;

}
