package com.external.publisher;

import com.domain.boundary.MessageHandlerInterface;
import com.domain.entities.dto.DomainRequestEntity;
import com.domain.entities.dto.DomainResponseEntity;
import com.external.exception.WebClientException;
import com.google.api.core.ApiFuture;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Log4j2
public class PublishWithCustomAttributesService implements MessageHandlerInterface {

    @Autowired
    DomainResponseEntity domainResponseEntity;

    @Value("${spring.cloud.gcp.project-id}")
    String projectId;

    @Value("${spring.cloud.gcp.pub.topicName}")
    String topicName;

    String messageId = null;

    Gson gson = new GsonBuilder().create();

    public void publish(DomainRequestEntity domainRequestEntity)
            throws Exception {
        TopicName topicName = TopicName.of(projectId, this.topicName);
        Publisher publisher = null;

        try {

            // Create a publisher instance with default settings bound to the topic
            publisher = Publisher.newBuilder(topicName).build();

            log.info("domainRequestEntity: " + domainRequestEntity.toString() );

            PubsubMessage pubsubMessage =
                    PubsubMessage.newBuilder()
                            .setData(ByteString.copyFromUtf8(gson.toJson(domainRequestEntity)))
                            .build();

            log.info("Message to be published: " + pubsubMessage.toString() );

            // Once published, returns a server-assigned message id (unique within the topic)
            ApiFuture<String> messageIdFuture = publisher.publish(pubsubMessage);
            messageId = messageIdFuture.get();
            log.info("Published a message with custom attributes: " + messageId );

            if(messageId == null){
                throw new WebClientException("Publish Service Web Client Exception!", "99");
            }

        } finally {
//            if (publisher != null) {
//                // When finished with the publisher, shutdown to free up resources.
//                log.info("Publisher shout down started");
//                publisher.shutdown();
//                log.info("Publisher shout down done");
//                //publisher.awaitTermination(1, TimeUnit.MINUTES);
//                publisher.awaitTermination(1, TimeUnit.SECONDS);
//                log.info("Publisher awaitTermination done");
//            }
        }
    }
}
