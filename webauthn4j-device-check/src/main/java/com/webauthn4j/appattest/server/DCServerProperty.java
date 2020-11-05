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

package com.webauthn4j.appattest.server;

import com.webauthn4j.data.client.challenge.Challenge;
import com.webauthn4j.server.CoreServerProperty;

public class DCServerProperty extends CoreServerProperty {

    /**
     * Constructor of {@link DCServerProperty}
     *
     * @param rpId      rpId or in other words, App ID, which is the concatenation of your 10-digit team identifier, a period, and your app’s CFBundleIdentifier value.
     * @param challenge challenge
     */
    public DCServerProperty(String rpId, Challenge challenge) {
        super(rpId, challenge);
    }

    /**
     * Constructor of {@link DCServerProperty}
     *
     * @param teamIdentifier     10-digit team identifier
     * @param cfBundleIdentifier CFBundleIdentifier
     * @param challenge          challenge
     */
    public DCServerProperty(String teamIdentifier, String cfBundleIdentifier, Challenge challenge) {
        super(String.format("%s.%s", teamIdentifier, cfBundleIdentifier), challenge);
    }

}

