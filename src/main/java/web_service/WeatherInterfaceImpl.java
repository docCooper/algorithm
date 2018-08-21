package web_service;

import javax.jws.WebService;

/**
 * Create By 曹通
 * 2018/7/31 10:21
 */
@WebService
public class WeatherInterfaceImpl implements WeatherInterface {
    @Override
    public String queryWeather(String cityName) {
        System.out.println("获取城市名"+cityName);
        String weather="暴雨";
        return weather;
    }
}
