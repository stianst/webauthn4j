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

package com.webauthn4j.converter.jackson.serializer.cbor;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.webauthn4j.converter.AuthenticatorDataConverter;
import com.webauthn4j.converter.util.ObjectConverter;
import com.webauthn4j.data.attestation.authenticator.AuthenticatorData;
import com.webauthn4j.data.extension.authenticator.ExtensionAuthenticatorInput;
import com.webauthn4j.util.AssertUtil;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * Jackson Serializer for {@link AuthenticatorData}
 */
public class AuthenticatorDataSerializer extends StdSerializer<AuthenticatorData<? extends ExtensionAuthenticatorInput>> {

    private final ObjectConverter objectConverter;

    public AuthenticatorDataSerializer(ObjectConverter objectConverter) {
        super(AuthenticatorData.class, false);

        AssertUtil.notNull(objectConverter, "objectConverter must not be null");

        this.objectConverter = objectConverter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void serialize(@NotNull AuthenticatorData<? extends ExtensionAuthenticatorInput> value, @NotNull JsonGenerator gen, @NotNull SerializerProvider provider) throws IOException {
        gen.writeBinary(new AuthenticatorDataConverter(objectConverter).convert(value));
    }

}
