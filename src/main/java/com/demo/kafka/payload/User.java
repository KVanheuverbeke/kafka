package com.demo.kafka.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class User {
    private int id;
    @Schema(description = "first name", example = "Karl")
    private String firstName;
    private String lastName;
}
