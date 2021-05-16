package com.company.design.singleton;

public class SocketClient {

    //싱글톤은 자기 자신을 객체로 가지고 있어야 한다.
    private static SocketClient socketClient = null;

    //기본 생성자를 private으로 막아야 한다.
    private SocketClient() {

    }

    public static SocketClient getInstance() {

        if(socketClient == null) {
            socketClient = new SocketClient();
        }
        return socketClient;
    }

    public void connect() {
        System.out.println("connect");
    }
}
