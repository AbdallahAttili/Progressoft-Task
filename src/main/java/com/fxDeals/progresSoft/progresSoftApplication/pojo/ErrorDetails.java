package com.fxDeals.progresSoft.progresSoftApplication.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * POJO defining the structure of a response sent back to the client when an exception occurs.
 * <p>
 * This class encapsulates the details about an error that can be serialized into a JSON response,
 * providing a standardized format for sending error information back to the client. It includes
 * a message describing the error and the date and time when the error occurred.
 * </p>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDetails {
    private HttpStatus status;
    private String message;
    private List<String> errors;
}
