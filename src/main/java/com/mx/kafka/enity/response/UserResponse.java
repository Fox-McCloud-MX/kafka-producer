package com.mx.kafka.enity.response;

import com.mx.kafka.enity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class UserResponse {
	private HttpStatus status;
	private String message;
	private User user;
}
