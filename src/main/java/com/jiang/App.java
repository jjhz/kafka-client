package com.jiang;

import java.sql.SQLSyntaxErrorException;
import java.util.Properties;
import java.util.concurrent.Future;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) throws Exception{

        Properties config = new Properties();
        config.put("client.id", "Java Producer");
        config.put("bootstrap.servers", "node01:6667");
        config.put("acks", "-1");
        config.put("retries", 5);
        config.setProperty("key.serializer", StringSerializer.class.getName());
        config.setProperty("value.serializer", StringSerializer.class.getName());

        System.out.println( "Started !!" );

        Producer<String,String> producer = new Producer<>(config);
        for(int i=0;i<Integer.MAX_VALUE;i++){
            Future<RecordMetadata> recordMetadataFuture = producer.sendRecord("nifi4","123","Hello + " + i);
            try{
                recordMetadataFuture.get();
            }catch (Exception e){
                System.out.println(e);
            }

            Thread.sleep(500);
        }
    }

}
