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

package com.webauthn4j.converter.jackson.deserializer.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.webauthn4j.data.client.challenge.Challenge;
import com.webauthn4j.data.client.challenge.DefaultChallenge;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * Jackson Deserializer for {@link Challenge}
 */
public class ChallengeDeserializer extends StdDeserializer<Challenge> {

    public ChallengeDeserializer() {
        super(Challenge.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public @NotNull Challenge deserialize(@NotNull JsonParser p, @NotNull DeserializationContext ctxt) throws IOException {
        String str = p.getValueAsString();
        try {
            return new DefaultChallenge(str);
        } catch (IllegalArgumentException e) {
            throw new InvalidFormatException(null, "value is out of range", str, DefaultChallenge.class);
        }
    }
}
