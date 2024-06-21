package es.imh.core.exception;

import static es.imh.core.exception.ErrorCode.UNDEFINED_ERROR;

import es.imh.core.enums.CommonError;
import es.imh.core.utils.ImhMessageUtils.Message;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Class for handling service layer exceptions in a common way.
 *
 * @since 1.0.0
 * @author PS2-IaC [SP.DG.IT.PS2_IaC@securitasdirect.es]
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ServiceException extends RuntimeException {

  private static final long serialVersionUID = -4953784122262260598L;

  ErrorCode code;
  String messageKey;

  /**
   * Constructs an {@code ServiceException} with the specified detail message and no root cause.
   *
   * @param message The detail message (which is saved for later retrieval by the {@link
   *     #getMessage()} method)
   */
  public ServiceException(String message) {
    this(message, UNDEFINED_ERROR);
  }

  /**
   * Constructs an {@code ServiceException} with the specified error code and no root cause.
   *
   * @param code The error code identifying the business exception
   */
  public ServiceException(ErrorCode code) {
    super();
    this.code = code;
    this.messageKey = null;
  }

  /**
   * Constructs an {@code ServiceException} with the specified detail message and no root cause.
   *
   * @param message The detail message (which is saved for later retrieval by the {@link
   *     #getMessage()} method)
   * @param code The error code identifying the business exception
   */
  public ServiceException(String message, ErrorCode code) {
    super(message);
    this.code = code;
    this.messageKey = null;
  }

  /**
   * Constructs an {@code ServiceException} with the specified root cause.
   *
   * <p>Note that the detail message associated with {@code cause} is <i>not</i> automatically
   * incorporated into this exception's detail message.
   *
   * @param cause The cause (which is saved for later retrieval by the {@link #getCause()} method).
   *     (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
   * @param code The error code identifying the business exception
   */
  public ServiceException(Throwable cause, ErrorCode code) {
    super(cause);
    this.code = code;
    this.messageKey = null;
  }

  /**
   * Constructs an {@code ServiceException} with the specified detail message and root cause.
   *
   * <p>Note that the detail message associated with {@code cause} is <i>not</i> automatically
   * incorporated into this exception's detail message.
   *
   * @param message The detail message (which is saved for later retrieval by the {@link
   *     #getMessage()} method)
   * @param cause The cause (which is saved for later retrieval by the {@link #getCause()} method).
   *     (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
   * @param code The error code identifying the business exception
   */
  public ServiceException(String message, Throwable cause, ErrorCode code) {
    super(message, cause);
    this.code = code;
    this.messageKey = null;
  }

  /**
   * Constructs an {@code ServiceException} with the specified common error.
   *
   * <p>Note that the detail message associated with {@code cause} is <i>not</i> automatically
   * incorporated into this exception's detail message.
   *
   * @param commonError The {@code CommonError} containing error code and message key
   */
  public ServiceException(CommonError commonError) {
    this.code = commonError.getErrorCode();
    this.messageKey = commonError.getMessageKey();
  }

  /**
   * Constructs an {@code ServiceException} with the specified common error.
   *
   * <p>Note that the detail message associated with {@code cause} is <i>not</i> automatically
   * incorporated into this exception's detail message.
   *
   * @param message The detail message (which is saved for later retrieval by the {@link
   *     #getMessage()} method)
   * @param commonError The {@code CommonError} containing error code and message key
   */
  public ServiceException(String message, CommonError commonError) {
    super(message);
    this.code = commonError.getErrorCode();
    this.messageKey = commonError.getMessageKey();
  }

  /**
   * Constructs an {@code ServiceException} with the specified root cause and common error.
   *
   * <p>Note that the detail message associated with {@code cause} is <i>not</i> automatically
   * incorporated into this exception's detail message.
   *
   * @param cause The cause (which is saved for later retrieval by the {@link #getCause()} method).
   *     (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
   * @param commonError The {@code CommonError} containing error code and message key
   */
  public ServiceException(Throwable cause, CommonError commonError) {
    super(cause);
    this.code = commonError.getErrorCode();
    this.messageKey = commonError.getMessageKey();
  }

  /**
   * Constructs an {@code ServiceException} with the specified message.
   *
   * <p>Note that the detail message associated with {@code cause} is <i>not</i> automatically
   * incorporated into this exception's detail message.
   *
   * @param message The {@code Message} containing message key and error code
   */
  public ServiceException(Message message) {
    this.code = message.getErrorCode();
    this.messageKey = message.getKey();
  }

  /**
   * Constructs an {@code ServiceException} with the specified message.
   *
   * <p>Note that the detail message associated with {@code cause} is <i>not</i> automatically
   * incorporated into this exception's detail message.
   *
   * @param detailMessage The detail message (which is saved for later retrieval by the {@link
   *     #getMessage()} method)
   * @param message The {@code Message} containing message key and error code
   */
  public ServiceException(String detailMessage, Message message) {
    super(detailMessage);
    this.code = message.getErrorCode();
    this.messageKey = message.getKey();
  }

  /**
   * Constructs an {@code ServiceException} with the specified message.
   *
   * <p>Note that the detail message associated with {@code cause} is <i>not</i> automatically
   * incorporated into this exception's detail message.
   *
   * @param cause The cause (which is saved for later retrieval by the {@link #getCause()} method).
   *     (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
   * @param message The {@code Message} containing message key and error code
   */
  public ServiceException(Throwable cause, Message message) {
    super(cause);
    this.code = message.getErrorCode();
    this.messageKey = message.getKey();
  }
}
