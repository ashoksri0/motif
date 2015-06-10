package com.leacox.motif.cases;

import static com.leacox.motif.matchers.ArgumentMatchers.eq;

import com.leacox.motif.extractor.Extractor0;
import com.leacox.motif.extractor.Extractor1;
import com.leacox.motif.matchers.ArgumentMatcher;
import com.leacox.motif.matching.MatchingExtractor0;
import com.leacox.motif.matching.MatchingExtractor1;

import java.util.Optional;

/**
 * @author John Leacox
 */
public final class OptionalCases {
  private OptionalCases() {
  }

  public static <T> MatchingExtractor1<Optional<T>, T> caseSome(T a) {
    return caseSome(eq(a));
  }

  public static <T> MatchingExtractor1<Optional<T>, T> caseSome(ArgumentMatcher<T> a) {
    Extractor1<Optional<T>, T> extractor = new Extractor1<Optional<T>, T>() {
      //@Override
      //public Optional<T> apply(T t) {
      //  return Optional.ofNullable(t);
      //}

      @Override
      public Optional<T> unapply(Optional<T> t) {
        if (t.isPresent()) {
          return t;
        } else {
          return Optional.empty();
        }
      }

      @Override
      public Class getExtractorClass() {
        return Optional.class;
      }
    };

    return MatchingExtractor1.create(extractor, a);
  }

  public static <T> MatchingExtractor0<Optional<T>> caseNone() {
    Extractor0<Optional<T>> extractor = new Extractor0<Optional<T>>() {
      //@Override
      //public Optional<T> apply() {
      //  return Optional.empty();
      //}

      @Override
      public boolean unapply(Optional<T> t) {
        return !t.isPresent();
      }

      @Override
      public Class<Optional> getExtractorClass() {
        return Optional.class;
      }
    };

    return MatchingExtractor0.create(extractor);
  }
}