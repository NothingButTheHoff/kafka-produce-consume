package net.pefi.kafka.kafka;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Map;

import net.pefi.kafka.model.SimpleMessage;
import org.apache.kafka.common.serialization.Serializer;

public class SimpleMessageSerializer implements Serializer<SimpleMessage> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public byte[] serialize(String topic, SimpleMessage data) {
            if (data == null)
                return null;
            else {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutput out;
                try {
                    out = new ObjectOutputStream(bos);
                    out.writeObject(data);
                    out.flush();
                    return bos.toByteArray();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        bos.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
            return null;
    }

    @Override
    public void close() {
    }
}
