package pl.sdacademy.springdemo.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sdacademy.springdemo.model.Error;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@RestController
public class MyErrorController implements ErrorController {

	@RequestMapping(value = "/error", produces = MediaType.APPLICATION_JSON_VALUE)
	public Error handleError(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

		if (status != null) {
			int statusCode = Integer.parseInt(status.toString());

			HttpStatus statusHttp = HttpStatus.valueOf(statusCode);
			switch (statusHttp) {
			case UNAUTHORIZED, FORBIDDEN:
				return new Error(404, "Nie masz uprawnień");
			case NOT_FOUND:
				return new Error(404, "Nie ma takiego zasobu");
			case METHOD_NOT_ALLOWED:
				return new Error(405, "Sprawdź typ zapytania");
			default:
				return new Error(-1, "Nieznany błąd!");
			}

		}
		return new Error(-1, "Nieznany błąd!");
	}
}
