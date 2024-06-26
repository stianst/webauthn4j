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

package com.webauthn4j;


import com.webauthn4j.anchor.TrustAnchorRepository;
import com.webauthn4j.test.TestAttestationUtil;
import com.webauthn4j.validator.attestation.statement.androidkey.AndroidKeyAttestationStatementValidator;
import com.webauthn4j.validator.attestation.statement.none.NoneAttestationStatementValidator;
import com.webauthn4j.validator.attestation.statement.packed.PackedAttestationStatementValidator;
import com.webauthn4j.validator.attestation.statement.u2f.FIDOU2FAttestationStatementValidator;
import com.webauthn4j.validator.attestation.trustworthiness.certpath.DefaultCertPathTrustworthinessValidator;
import com.webauthn4j.validator.attestation.trustworthiness.self.DefaultSelfAttestationTrustworthinessValidator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WebAuthnManagerTest {

    @Test
    void constructor_test() {
        NoneAttestationStatementValidator noneAttestationStatementValidator = new NoneAttestationStatementValidator();
        PackedAttestationStatementValidator packedAttestationStatementValidator = new PackedAttestationStatementValidator();
        FIDOU2FAttestationStatementValidator fidoU2FAttestationStatementValidator = new FIDOU2FAttestationStatementValidator();
        AndroidKeyAttestationStatementValidator androidKeyAttestationStatementValidator = new AndroidKeyAttestationStatementValidator();
        TrustAnchorRepository trustAnchorRepository = TestAttestationUtil.createTrustAnchorRepositoryWith3tierTestRootCACertificate();
        WebAuthnManager webAuthnManager = new WebAuthnManager(
                Arrays.asList(
                        noneAttestationStatementValidator,
                        packedAttestationStatementValidator,
                        fidoU2FAttestationStatementValidator,
                        androidKeyAttestationStatementValidator),
                new DefaultCertPathTrustworthinessValidator(trustAnchorRepository),
                new DefaultSelfAttestationTrustworthinessValidator()
        );
        assertThat(webAuthnManager).isNotNull();
    }

    @Test
    void createNonStrictWebAuthnManager_test() {
        assertThat(WebAuthnManager.createNonStrictWebAuthnManager()).isNotNull();
    }

    @Test
    void getter_test() {
        WebAuthnManager webAuthnManager = WebAuthnManager.createNonStrictWebAuthnManager();
        assertThat(webAuthnManager.getRegistrationDataValidator()).isNotNull();
        assertThat(webAuthnManager.getAuthenticationDataValidator()).isNotNull();
    }

}