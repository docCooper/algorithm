package web_service;

import javax.xml.ws.Endpoint;

/**
 * Create By 曹通
 * 2018/7/31 10:22
 */
public class WeatherServer {
    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:12345/weather", new WeatherInterfaceImpl());
    }
}
