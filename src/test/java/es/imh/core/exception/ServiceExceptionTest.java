package es.imh.core.exception;

import es.imh.core.enums.CommonError;
import es.imh.core.utils.ImhMessageUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class ServiceExceptionTest {

  @Test
  void serviceExceptionTest() {
    ServiceException serviceException = new ServiceException(ErrorCode.UNDEFINED_ERROR);
    ServiceException serviceExceptionWithNullMessage =
        new ServiceException((String) null, ErrorCode.UNDEFINED_ERROR);
    ServiceException serviceExceptionWithCause =
        new ServiceException(serviceException, ErrorCode.UNDEFINED_ERROR);
    ServiceException serviceExceptionWithCauseAndNullMessage =
        new ServiceException(null, serviceException, ErrorCode.UNDEFINED_ERROR);
    ServiceException serviceExceptionWithCommonError =
        new ServiceException(CommonError.CONFIGURATION_ERROR);
    ServiceException serviceExceptionWithCommonErrorAndMessage =
        new ServiceException("custom message", CommonError.CONFIGURATION_ERROR);
    ServiceException serviceExceptionWithCommonErrorAndCause =
        new ServiceException(serviceException, CommonError.CONFIGURATION_ERROR);
    ServiceException serviceExceptionWithMessageAndErrorCode =
        new ServiceException(
                ImhMessageUtils.getMessage(
                "commons.data_not_found", ErrorCode.CONFIGURATION_ERROR));
    ServiceException serviceExceptionWithMessageAndDetail =
        new ServiceException(
            "custom message",
                ImhMessageUtils.getMessage(
                "commons.data_not_found", ErrorCode.CONFIGURATION_ERROR));
    ServiceException serviceExceptionWithMessageAndCause =
        new ServiceException(
            serviceException,
                ImhMessageUtils.getMessage(
                "commons.data_not_found", ErrorCode.CONFIGURATION_ERROR));

    assertEquals(ErrorCode.UNDEFINED_ERROR, serviceException.getCode());
    assertNull(serviceException.getMessageKey());
    assertEquals(serviceException.getMessage(), serviceExceptionWithNullMessage.getMessage());
    assertNull(serviceExceptionWithNullMessage.getMessageKey());
    assertNotNull(serviceExceptionWithCause.getMessage());
    assertNull(serviceExceptionWithCause.getMessageKey());
    assertNull(serviceExceptionWithCauseAndNullMessage.getMessage());
    assertNull(serviceExceptionWithCauseAndNullMessage.getMessageKey());
    assertEquals(
        CommonError.CONFIGURATION_ERROR.getErrorCode(), serviceExceptionWithCommonError.getCode());
    assertNull(serviceExceptionWithCommonError.getMessage());
    assertNotNull(serviceExceptionWithCommonError.getMessageKey());
    assertEquals(
        CommonError.CONFIGURATION_ERROR.getErrorCode(),
        serviceExceptionWithCommonErrorAndMessage.getCode());
    assertNotNull(serviceExceptionWithCommonErrorAndMessage.getMessage());
    assertNotNull(serviceExceptionWithCommonErrorAndMessage.getMessageKey());
    assertEquals(
        CommonError.CONFIGURATION_ERROR.getErrorCode(),
        serviceExceptionWithCommonErrorAndCause.getCode());
    assertNotNull(serviceExceptionWithCommonErrorAndCause.getMessage());
    assertNotNull(serviceExceptionWithCommonErrorAndCause.getMessageKey());
    assertEquals(
        CommonError.DATA_NOT_FOUND.getErrorCode(),
        serviceExceptionWithMessageAndErrorCode.getCode());
    assertNull(serviceExceptionWithMessageAndErrorCode.getMessage());
    assertNotNull(serviceExceptionWithMessageAndErrorCode.getMessageKey());
    assertNotNull(serviceExceptionWithMessageAndDetail.getMessage());
    assertNotNull(serviceExceptionWithMessageAndDetail.getMessageKey());
    assertNotNull(serviceExceptionWithMessageAndCause.getMessage());
    assertNotNull(serviceExceptionWithMessageAndCause.getMessageKey());
  }
}
