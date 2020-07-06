package org.soyphea;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ApiResponse<T> {

    String code;
    String message;
    T body;

    public static ApiResponse success(){
        return ApiResponse.builder().code("S0001").message("success").build();
    }

}
