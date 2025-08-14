import org.eclipse.paho.client.mqttv3.*;

public class PublisherApp {
    public static void main(String[] args) throws MqttException {
        String broker = "tcp://localhost:1883";
        String clientId = "JavaPublisher";
        String topic = "test/topic";
        String messageContent = "Test message!";

        MqttMessage message = new MqttMessage(messageContent.getBytes());
        MqttClient client = new MqttClient(broker, clientId);

        message.setQos(0);
        client.connect();

        client.publish(topic, message);
        System.out.println("Mesaj gönderildi: " + messageContent);
        client.disconnect();
        System.out.println("Bağlantı kapatıldı!");

        System.out.println("Broker: " + broker);
        System.out.println("Client ID: " + clientId);
        System.out.println("Topic: " + topic);

    }
}
