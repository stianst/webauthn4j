/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.webauthn4j.converter.jackson.serializer;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AAGUIDSerializerTest {

    private AAGUIDSerializer aaguidSerializer = new AAGUIDSerializer();

    @SuppressWarnings("ConstantConditions")
    @Test
    void null_test() throws IOException {
        // Custom jackson serializer doesn't need to handle null value as Jackson doesn't call custom serializer when the value is null.
        assertThatThrownBy(() -> aaguidSerializer.serialize(null, null, null)).isInstanceOf(IllegalArgumentException.class);
    }


}