import com.typesafe.config.ConfigFactory

object KafkaConfig {
  private val config = ConfigFactory.load()
  val kafkaTopic: String = config.getString("kafka.topic")
  val kafkaGroupId: String = config.getString("kafka.groupId")
  val kafkaKeySerializer: String = config.getString("kafka.keySerializer")
  val kafkaValueSerializer: String = config.getString("kafka.valueSerializer")
  val kafkaKeyDeSerializer: String = config.getString("kafka.keyDeserializer")
  val kafkaValueDeSerializer: String = config.getString("kafka.valueDeserializer")
  val kafkaServer: String = config.getString("kafka.server")
  val kafkaOffsetReset: String = config.getString("kafka.offsetReset")
}
