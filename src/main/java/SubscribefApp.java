import org.eclipse.paho.client.mqttv3.*;

public class SubscribefApp {
    public static void main(String[] args) throws MqttException {
        String broker = "tcp://localhost:1883";
        String clientId = "JavaSubscriber";
        String topic = "test/topic";

        MqttClient client = new MqttClient(broker, clientId);

        client.setCallback(new MqttCallback() {
            @Override
            public void connectionLost(Throwable throwable) {
                System.out.println("Bağlantı kayboldu: " + throwable.getMessage());
            }
            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception {
                System.out.println("Yeni mesaj geldi. Topic: " + topic + ", Mesaj: " + message.toString());
            }
            @Override
            public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {}
        });

        client.connect();
        System.out.println("Subscriber broker'a bağlandı.");

        client.subscribe(topic);
        System.out.println("Subscriber " + topic + " topic'ine abone oldu.");

        while(true){}

    }
}
