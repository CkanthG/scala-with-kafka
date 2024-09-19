import java.util.Properties
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

/**
 * This Kafka Publisher is responsible for publish messages and exit.
 */
object KafkaScalaProducer {

  def main(args: Array[String]): Unit = {
    // Kafka properties
    val props = new Properties()
    props.put("bootstrap.servers", KafkaConfig.kafkaServer)
    props.put("key.serializer", KafkaConfig.kafkaKeySerializer)
    props.put("value.serializer", KafkaConfig.kafkaValueSerializer)

    // Create a Kafka producer
    val producer = new KafkaProducer[String, String](props)

    // Produce messages
    for (i <- 1 to 100) {
      val key = s"key-$i"
      val value = s"Claim Event $i: Customer filed insurance claim."
      val record = new ProducerRecord[String, String](KafkaConfig.kafkaTopic, key, value)
      producer.send(record)
      println(s"Sent record with key $key and value $value")
    }

    // Close producer
    producer.close()
  }
}

