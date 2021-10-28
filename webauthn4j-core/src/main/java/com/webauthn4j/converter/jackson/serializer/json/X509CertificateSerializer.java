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

package com.webauthn4j.converter.jackson.serializer.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.webauthn4j.util.Base64Util;
import com.webauthn4j.util.exception.UnexpectedCheckedException;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.io.IOException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

/**
 * Jackson Serializer for {@link X509Certificate}
 */
public class X509CertificateSerializer extends StdSerializer<X509Certificate> {

    public X509CertificateSerializer() {
        super(X509Certificate.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void serialize(@NonNull X509Certificate value, @NonNull JsonGenerator gen, @NonNull SerializerProvider provider) throws IOException {
        try {
            String str= Base64Util.encodeToString(value.getEncoded());
            gen.writeString(str);
        } catch (CertificateEncodingException e) {
            throw new UnexpectedCheckedException(e);
        }
    }
}
