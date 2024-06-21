package es.imh.core.utils;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

@UtilityClass
public class ImhStringUtils {

  public String concatTrimming(String separator, String... fields) {
    return Optional.ofNullable(fields)
        .filter(ObjectUtils::anyNotNull)
        .flatMap(
            l ->
                Arrays.stream(l)
                    .reduce(
                        (a, b) ->
                            Objects.toString(a, "").trim()
                                + Optional.ofNullable(b).map(s -> separator + s.trim()).orElse("")))
        .map(String::trim)
        .orElse(null);
  }

  public String removeEndIgnoreCase(String str, String... suffixes) {
    return Optional.ofNullable(suffixes)
        .filter(ArrayUtils::isNotEmpty)
        .map(Stream::of)
        .flatMap(
            s ->
                Stream.concat(Stream.of(str), s)
                    .reduce((src, pref) -> StringUtils.removeEndIgnoreCase(str, pref)))
        .orElse(str);
  }
}
