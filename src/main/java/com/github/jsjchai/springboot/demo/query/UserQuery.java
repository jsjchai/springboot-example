package com.github.jsjchai.springboot.demo.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserQuery {

    @Schema(description = "id")
    private Long id;
}
