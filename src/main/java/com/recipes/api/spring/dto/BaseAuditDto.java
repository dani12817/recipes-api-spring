package com.recipes.api.spring.dto;

import java.io.Serial;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public abstract class BaseAuditDto extends BaseDto {

    @Serial
    private static final long serialVersionUID = -6083043870727114273L;

    protected LocalDateTime createdAt;

    protected LocalDateTime updatedAt;

}
