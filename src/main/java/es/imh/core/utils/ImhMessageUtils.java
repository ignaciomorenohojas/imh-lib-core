package es.imh.core.utils;

import es.imh.core.dictionaries.StringDic;
import es.imh.core.enums.CommonError;
import es.imh.core.exception.ErrorCode;
import es.imh.core.exception.ServiceException;
import java.util.Arrays;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

@UtilityClass
public class ImhMessageUtils {

  private final String COMMON_MESSAGES_PREFIX = "commons.";
  private final String APPS_PREFIX = "imh-";

  @Getter private String applicationMessagesPrefix;

  public void setApplicationMessagesPrefix(String appName, String profiles) {
    applicationMessagesPrefix =
        Optional.ofNullable(appName)
            .map(n -> StringUtils.removeStartIgnoreCase(n, APPS_PREFIX))
            .map(n -> ImhMessageUtils.cleanApplicationMessagesSuffix(n, profiles))
            .map(n -> n + StringDic.DOT)
            .orElse(null);
  }

  public String cleanApplicationMessagesSuffix(String applicationMessageKey, String profiles) {
    return Optional.ofNullable(profiles)
        .map(p -> p.split(String.valueOf(StringDic.COMMA)))
        .map(l -> Arrays.stream(l).map(s -> StringDic.HYPHEN + s).toArray(String[]::new))
        .map(l -> ImhStringUtils.removeEndIgnoreCase(applicationMessageKey, l))
        .orElse(applicationMessageKey);
  }

  public Message getMessage(String key) {
    return getMessage(key, null);
  }

  public Message getMessage(String key, ErrorCode errorCode) {
    Optional<String> optKey = Optional.ofNullable(key);
    return optKey
        .filter(k -> k.startsWith(COMMON_MESSAGES_PREFIX))
        .map(k -> k.substring(COMMON_MESSAGES_PREFIX.length()))
        .map(CommonError::getCommonErrorFromMessageKey)
        .map(c -> new Message(COMMON_MESSAGES_PREFIX + c.getMessageKey(), c.getErrorCode()))
        .orElseGet(
            () ->
                optKey
                    .filter(k -> k.startsWith(applicationMessagesPrefix))
                    .map(k -> new Message(k, errorCode))
                    .orElseThrow(
                        () ->
                            new ServiceException(
                                String.format(
                                    "key %s in not valid into the current application", key),
                                CommonError.CONFIGURATION_ERROR)));
  }

  @Getter
  @AllArgsConstructor(access = AccessLevel.PRIVATE)
  public static class Message {
    String key;
    ErrorCode errorCode;
  }
}
