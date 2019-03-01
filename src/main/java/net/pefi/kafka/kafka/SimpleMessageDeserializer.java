package net.pefi.kafka.kafka;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.Map;

import net.pefi.kafka.model.SimpleMessage;
import org.apache.kafka.common.serialization.Deserializer;

public class SimpleMessageDeserializer implements Deserializer<SimpleMessage> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public SimpleMessage deserialize(String topic, byte[] data) {
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        ObjectInput in = null;
        try {
            in = new ObjectInputStream(bis);
            return (SimpleMessage) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void close() {
    }
}
