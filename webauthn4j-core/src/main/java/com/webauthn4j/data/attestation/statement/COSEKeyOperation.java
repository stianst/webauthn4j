/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.webauthn4j.data.attestation.statement;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.jetbrains.annotations.NotNull;

public enum COSEKeyOperation {
    SIGN(1),
    VERIFY(2),
    ENCRYPT(3),
    DECRYPT(4),
    WRAP_KEY(5),
    UNWRAP_KEY(6),
    DERIVE_KEY(7),
    DERIVE_BITS(8),
    MAC_CREATE(9),
    MAC_VERIFY(10);

    private final int value;

    COSEKeyOperation(int value) {
        this.value = value;
    }

    public static @NotNull COSEKeyOperation create(int value) {
        switch (value) {
            case 1:
                return COSEKeyOperation.SIGN;
            case 2:
                return COSEKeyOperation.VERIFY;
            case 3:
                return COSEKeyOperation.ENCRYPT;
            case 4:
                return COSEKeyOperation.DECRYPT;
            case 5:
                return COSEKeyOperation.WRAP_KEY;
            case 6:
                return COSEKeyOperation.UNWRAP_KEY;
            case 7:
                return COSEKeyOperation.DERIVE_KEY;
            case 8:
                return COSEKeyOperation.DERIVE_BITS;
            case 9:
                return COSEKeyOperation.MAC_CREATE;
            case 10:
                return COSEKeyOperation.MAC_VERIFY;
            default:
                throw new IllegalArgumentException("value '" + value + "' is out of range");

        }
    }

    @JsonCreator
    private static @NotNull COSEKeyOperation deserialize(int value) throws InvalidFormatException {
        try {
            return create(value);
        } catch (IllegalArgumentException e) {
            throw new InvalidFormatException(null, "value is out of range", value, COSEKeyOperation.class);
        }
    }

    @JsonValue
    public int getValue() {
        return value;
    }
}
