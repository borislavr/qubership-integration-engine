/*
 * Copyright 2024-2025 NetCracker Technology Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.qubership.integration.platform.engine.util;

import java.net.MalformedURLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleHttpUriUtils {
    private static final String PROTOCOL_DOMAIN_REGEX = "^https?://[^:/]+(:\\d{1,5})?";
    private static final String PROTOCOL_ADDRESS_REGEX = "^[^:/]+(:\\d{1,5})?";
    private static final Pattern PROTOCOL_DOMAIN_PATTERN = Pattern.compile(PROTOCOL_DOMAIN_REGEX);
    private static final Pattern PROTOCOL_ADDRESS_PATTERN = Pattern.compile(PROTOCOL_ADDRESS_REGEX);


    public static String formatUri(String uri) throws MalformedURLException {
        if (uri == null) {
            return null;
        }

        Matcher matcher = PROTOCOL_DOMAIN_PATTERN.matcher(uri);
        if (matcher.find()) {
            return uri;
        }

        matcher = PROTOCOL_ADDRESS_PATTERN.matcher(uri);
        if (matcher.find()) {
            return "https://" + uri;
        }

        throw new MalformedURLException("URI " + uri + " invalid, failed to format");
    }
}

