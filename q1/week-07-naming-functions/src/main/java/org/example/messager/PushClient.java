package org.example.messager;

public interface PushClient {
    boolean send(String uid, String x);
}
