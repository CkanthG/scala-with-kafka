import java.time.Duration
import java.util.{Collections, Properties}
import org.apache.kafka.clients.consumer.KafkaConsumer
import scala.jdk.CollectionConverters._

/**
 * This Kafka Consumer is responsible for read messages from kafka topic.
 */
object KafkaScalaConsumer {

  def main(args: Array[String]): Unit = {
    // Kafka properties
    val props = new Properties()
    props.put("bootstrap.servers", KafkaConfig.kafkaServer)
    props.put("group.id", KafkaConfig.kafkaGroupId)
    props.put("key.deserializer", KafkaConfig.kafkaKeyDeSerializer)
    props.put("value.deserializer", KafkaConfig.kafkaValueDeSerializer)
    props.put("auto.offset.reset", KafkaConfig.kafkaOffsetReset)

    // Create a Kafka consumer
    val consumer = new KafkaConsumer[String, String](props)

    // Subscribe to the topic
    consumer.subscribe(Collections.singletonList(KafkaConfig.kafkaTopic))

    // Continuously listen for new messages
    while (true) {
      val records = consumer.poll(Duration.ofMillis(1000))
      for (record <- records.asScala) {
        println(s"Consumed record with key ${record.key()} and value ${record.value()}, partition: ${record.partition()}, offset: ${record.offset()}")
      }
    }
  }
}
