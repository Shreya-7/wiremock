/*
 * Copyright (C) 2021-2022 Thomas Akehurst
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
package com.github.tomakehurst.wiremock.extension.responsetemplating.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RandomHelperTest extends HandlebarsHelperTestBase {

  RandomHelper helper;

  @BeforeEach
  public void init() {
    helper = new RandomHelper();
  }

  @Test
  public void rendersAMeaningfulErrorWhenExpressionIsInvalid() {
    testHelperError(
            helper,
            "something really random",
            "umm",
            is("[ERROR: Unable to evaluate the expression something really random]"));
  }

  @Test
  public void returnsRandomValue() throws Exception {
    assertThat(renderHelperValue(helper, "Name.first_name"), is(any(String.class)));
  }
}
