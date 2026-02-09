package com.neoris.excepciones;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
	private String message;
	private int statusCode;
}
