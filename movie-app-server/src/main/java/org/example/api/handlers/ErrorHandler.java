package org.example.api.handlers;

import org.apache.commons.lang3.StringUtils;

public class ErrorHandler {
    public static Error getErrorResponse(Exception ex) {
        if (ex == null) {
            return new Error().message("Error occurred...");
        } //if
        return new Error().message(ex.getMessage());
    }
    public static Error getErrorResponse(String message) {
        if (StringUtils.isBlank(message)) {
            return new Error().message("Error occurred...");
        } //if
        return new Error().message(message);
    }
}