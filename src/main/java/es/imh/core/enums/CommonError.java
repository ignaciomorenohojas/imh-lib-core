package es.imh.core.enums;

import es.imh.core.exception.ErrorCode;
import es.imh.core.exception.ServiceException;
import java.util.Arrays;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(makeFinal=true, level = AccessLevel.PRIVATE)
@AllArgsConstructor
public enum CommonError {
  DATA_NOT_FOUND("data_not_found", ErrorCode.DATA_NOT_FOUND),
  CONFIGURATION_ERROR("configuration_error", ErrorCode.CONFIGURATION_ERROR);

  String messageKey;
  ErrorCode errorCode;

  public static CommonError getCommonErrorFromMessageKey(String messageKey) {
    return Arrays.stream(CommonError.values())
        .filter(e -> e.messageKey.equals(messageKey))
        .findFirst()
        .orElseThrow(
            () ->
                new ServiceException(
                    String.format("key %s in not an existing common key", messageKey),
                    CONFIGURATION_ERROR));
  }
}
