package es.imh.core.exception;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ErrorCodeTest {

  @Test
  void errorCodeMustBeUniqueTest() {
    assertEquals(
        ErrorCode.values().length,
        Arrays.stream(ErrorCode.values()).map(ErrorCode::getCode).distinct().count());
  }

  @Test
  void descriptionMustBeInformedTest() {
    Arrays.stream(ErrorCode.values()).forEach(e -> assertNotNull(e.getDescription()));
  }

  @Test
  void toStringContainsCodeAndDescriptionTest() {
    Arrays.stream(ErrorCode.values())
        .forEach(
            e -> {
              List<String> keywords = List.of(String.valueOf(e.getCode()), e.getDescription());
              assertTrue(keywords.stream().allMatch(e.toString()::contains));
            });
  }
}
