package com.proximitylab.app.model;

import lombok.*;

@Data
@Builder
@Setter
@Getter
@AllArgsConstructor
public class ApiResponse<T> {
    private String statusCode;
    private T data;
    private Long numberOfItems;
    private int numberOfPages;
}
