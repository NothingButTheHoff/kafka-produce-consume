package net.pefi.kafka.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SimpleMessage implements Serializable {

    private String text;
    private String sender;

    @JsonCreator
    public SimpleMessage(@JsonProperty("text") String text,
                         @JsonProperty("sender") String sender) {
        this.text = text;
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public String getSender() {
        return sender;
    }

}
