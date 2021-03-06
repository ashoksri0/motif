/*
 * Copyright (C) 2015 John Leacox
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.leacox.motif.cases;

import com.leacox.motif.extract.FieldExtractor;
import com.leacox.motif.tuple.Tuple1;

import java.util.List;
import java.util.Optional;

/**
 * Field extractor for {@link Tuple1}.
 *
 * @author John Leacox
 */
final class Tuple1FieldExtractor<A> implements FieldExtractor<Tuple1<A>> {
  private final Tuple1Extractor<A> tuple1Extractor = Tuple1Extractor.create();

  @Override
  public Optional<List<Object>> unapply(Tuple1<A> value) {
    Optional<A> opt = tuple1Extractor.unapply(value);
    if (!opt.isPresent()) {
      return Optional.empty();
    }

    return Optional.of(value.toList());
  }

  @Override
  public Class<?> getExtractorClass() {
    return tuple1Extractor.getExtractorClass();
  }
}
