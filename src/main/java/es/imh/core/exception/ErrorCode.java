package es.imh.core.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(makeFinal=true, level = AccessLevel.PRIVATE)
public enum ErrorCode {

  UNDEFINED_ERROR(0, "Undefined error."),
  VALIDATION_ERROR(1, "Client Resource validation error."),
  RESOURCE_NOT_FOUND(2, "Client Resource not found."),
  CONFIGURATION_ERROR(3, "Configuration error."),
  DATA_NOT_FOUND(4, "Requested data not found error."),
  INVALID_REQUESTED_PARAM(5, "Requested parameter is not valid."),
  UNAUTHORIZED_REQUEST(6, "Unauthorized request for current capabilities."),
  UNAUTHORIZED_TOKEN(7, "Unauthorized due to a validation on the session token"),
  ERROR_DB_CALL(8, "Error in a database call"),
  UNIMPLEMENTED_REQUEST(9, "Unimplemented requested resource"),
  PROCESS_ERROR(10, "Process error"),
  CONFLICT_ERROR(11, "Conflict error"),
  FORBIDDEN_ERROR(12, "Forbidden error"),
  TOO_MANY_REQUESTS_ERROR(13, "Too many requests error");

  int code;
  String description;

  @Override
  public String toString() {
    return code + ": " + description;
  }
}
