/*
 * Copyright 2013-2023 the original author or authors.
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
package io.awspring.cloud.sqs.operations;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import org.springframework.messaging.Message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

/**
 * The result of a send operation.
 * @param <T> the message payload type.
 */
@RequiredArgsConstructor
@Getter
@Accessors(fluent = true)
public class SendResult<T> {

    private final UUID messageId;

    private final String endpoint;

    private final Message<T> message;

    private final Map<String, Object> additionalInformation;

    /**
	 * The result of a batch send operation.
	 * @param successful the {@link SendResult} for messages successfully sent.
	 * @param failed the {@link SendResult} for messages that failed to be sent.
	 * @param <T> the message payload type.
	 */
    @RequiredArgsConstructor
    @Getter
	public static class Batch<T> {
	    private final Collection<SendResult<T>> successful;

	    private final Collection<SendResult.Failed<T>> failed;
	}

	/**
	 * The result of a failed send operation.
	 * @param errorMessage a message with information on the error.
	 * @param <T> the message payload type.
	 */
    @RequiredArgsConstructor
    @Getter
	public static class Failed<T> {
	    private String errorMessage;

	    private String endpoint;

	    private Message<T> message;

	    private Map<String, Object> additionalInformation;
	}

}
