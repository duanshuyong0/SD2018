package com.loonxi.channel.testxxx;

/**
 * Created by xyy on 2017/1/14.
 */
public class Client implements ABCApi{
    private ABCApi abcApi;

    public Client(String token) {

        abcApi = new ABCApiImpl(token);
    }

    @Override
    public String get() {
        return abcApi.get();
    }

    public static void main(String[] args) {
        Client client = new Client("abc");
        System.out.println(client.get());
    }



}
