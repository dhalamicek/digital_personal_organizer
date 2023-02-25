package com.dlniemann.digitalpersonalorganizer.handling;

import com.dlniemann.digitalpersonalorganizer.controllers.FileController;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandling {
    @ExceptionHandler(FileController.FileNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public problem handleException(final FileController.FileNotFoundException ex) {
        return new Problem("internal_server_error", "An unexpected error occurred", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());

    }

    public record Problem(String type, String title, String detail, int status) {}
}

