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

import com.leacox.motif.generate.CasesGenerator;
import com.leacox.motif.generate.Match3MethodSpec;
import com.leacox.motif.tuple.Tuple3;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeVariableName;

import java.io.IOException;

/**
 * Generator for {@link Tuple3} match cases.
 *
 * @author John Leacox
 */
final class Tuple3CasesGenerator {
  private Tuple3CasesGenerator() {
  }

  public static void main(String[] args) {
    TypeName A = TypeVariableName.get("A");
    TypeName B = TypeVariableName.get("B");
    TypeName C = TypeVariableName.get("C");
    TypeName t = ParameterizedTypeName.get(ClassName.get(Tuple3.class), A, B, C);

    Match3MethodSpec tuple3Match = Match3MethodSpec.builder()
        .withName("tuple3").withSummaryJavadoc("Matches a tuple of 2 elements.\n")
        .withMatchExtractor(Tuple3FieldExtractor.class).withParamA(A, "a")
        .withParamB(B, "b").withParamC(C, "c").build();

    JavaFile tuple3CasesFile = CasesGenerator.newBuilder(
        "com.leacox.motif.cases", "Tuple3Cases", t)
        .addFileComment(Copyright.COPYRIGHT_NOTICE)
        .addJavadoc("Motif cases for matching a {@link Tuple3}.\n")
        .addMatch3Method(tuple3Match)
        .build().generate();

    try {
      tuple3CasesFile.writeTo(System.out);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
