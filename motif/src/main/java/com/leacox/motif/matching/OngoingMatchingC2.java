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

package com.leacox.motif.matching;

import com.leacox.motif.extract.Extractor2;
import com.leacox.motif.function.Consumer2;

/**
 * Fluent API for specifying an action to take on a match with 2 parameters.
 *
 * @author John Leacox
 */
public final class OngoingMatchingC2<T, U extends T, A, B> extends Matching2<T, U, A, B> {
  private final FluentMatchingC<T> fluentMatchingC;

  OngoingMatchingC2(FluentMatchingC<T> fluentMatchingC, Extractor2<U, A, B> extractor) {
    super(extractor);

    this.fluentMatchingC = fluentMatchingC;
  }

  /**
   * Sets a {@link Consumer2} to execute if this matches.
   */
  public FluentMatchingC<T> then(Consumer2<A, B> consumer) {
    return then(fluentMatchingC, consumer);
  }
}
