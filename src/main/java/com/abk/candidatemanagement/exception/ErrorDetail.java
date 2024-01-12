package com.abk.candidatemanagement.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetail {

	private LocalDateTime time;
	private String messgae, path, errorCode;
}
