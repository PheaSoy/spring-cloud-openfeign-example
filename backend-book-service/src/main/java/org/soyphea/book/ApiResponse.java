package org.soyphea.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ApiResponse<T> {

    String code;
    String message;
    @JsonProperty("data")
    T body;

    public static ApiResponse success() {
        return ApiResponse.builder().code("S0001").message("success").build();
    }

    public static ApiResponse fail(String msg) {
        return ApiResponse.builder().message(msg).code("E0001").build();
    }
}
