package br.com.cidadeAcolhedora.CidadeAcolhedora.ResponseDefault;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.http.HttpStatus;

public class ResponseDefault {

	private String message;
	private HttpStatus statusCode;
	private LocalDateTime time;
	
	public ResponseDefault() {
		time = LocalDateTime.now();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(message, statusCode, time);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponseDefault other = (ResponseDefault) obj;
		return Objects.equals(message, other.message) && Objects.equals(statusCode, other.statusCode)
				&& Objects.equals(time, other.time);
	}

	@Override
	public String toString() {
		return "ResponseDefault [message=" + message + ", statusCode=" + statusCode + ", time=" + time + "]";
	}

}
