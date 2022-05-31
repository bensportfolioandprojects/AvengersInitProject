package com.qa.AvengersInitiativeProject.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Avenger does not exist with that ID")
public class AvengerNotFoundException extends NoSuchElementException {

}
