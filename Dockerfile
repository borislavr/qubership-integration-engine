# Copyright 2024-2025 NetCracker Technology Corporation
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

# FROM eclipse-temurin:21-jre-alpine
FROM alpine/java:22-jre

RUN chmod -R 755 /opt/java/openjdk && \
    apk add --no-cache curl

USER 10001

WORKDIR /app

VOLUME /tmp

EXPOSE 8080

COPY --chown=10001:0 target/qip-engine-*-exec.jar /app/qip-engine.jar

CMD ["/opt/java/openjdk/bin/java", "-Xmx832m", "-Djava.security.egd=file:/dev/./urandom", "-Dfile.encoding=UTF-8", "-jar", "/app/qip-engine.jar"]