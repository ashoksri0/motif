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

import java.util.function.Function;

/**
 * A pattern used internally to pair up matchers and actions.
 *
 * @author John Leacox
 */
interface Pattern<T, R> {
  boolean matches(T value);

  R apply(T value);

  static <T, R> Pattern<T, R> of(Function<T, Boolean> matcher, Function<T, R> function) {
    return new Pattern<T, R>() {
      @Override
      public boolean matches(T value) {
        return matcher.apply(value);
      }

      @Override
      public R apply(T value) {
        return function.apply(value);
      }
    };
  }
}
