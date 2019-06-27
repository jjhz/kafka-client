package com.jiang;

import java.util.Properties;
import java.util.concurrent.Future;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class Producer <PK,VAL> {

  private KafkaProducer producer;

  public Producer (Properties config){
    producer = new KafkaProducer(config);
  }

  public Future<RecordMetadata> sendRecord(String topicName, PK partitionKey, VAL value){
    return producer.send(new ProducerRecord<>(topicName, createKey(partitionKey), value));
  }

  private String createKey(PK id){
    return Integer.toString(id.hashCode());
  }

}
