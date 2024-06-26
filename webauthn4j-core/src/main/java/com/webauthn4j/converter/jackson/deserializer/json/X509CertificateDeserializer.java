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
import com.webauthn4j.util.Base64Util;
import com.webauthn4j.util.CertificateUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.security.cert.X509Certificate;

/**
 * Jackson Deserializer for {@link X509Certificate}
 */
public class X509CertificateDeserializer extends StdDeserializer<X509Certificate> {


    public X509CertificateDeserializer() {
        super(X509Certificate.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public @Nullable X509Certificate deserialize(@NotNull JsonParser p, @NotNull DeserializationContext ctxt) throws IOException {
        String value = p.getValueAsString();
        byte[] bytes = Base64Util.decode(value);
        if (bytes.length == 0) {
            return null;
        }
        return CertificateUtil.generateX509Certificate(bytes);
    }
}
