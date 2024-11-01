package weatherforecast;

import client.WeatherWSLocator;
import client.WeatherWSSoap_PortType;

public class Weather {

    public static void main(String[] args) {
        try {
            WeatherWSLocator locator = new WeatherWSLocator();
            WeatherWSSoap_PortType port = locator.getWeatherWSSoap(new java.net.URL("http://ws.webxml.com.cn/WebServices/WeatherWS.asmx?wsdl"));

            String cityName;
            if (args.length > 0) {
                cityName = args[0];
            } else {
                System.out.print("请输入城市名称：");
                cityName = new java.util.Scanner(System.in).nextLine();
            }

            String[] weatherData = port.getWeather(cityName, "");

            System.out.println("\n天气预报信息：");
            for (String data : weatherData) {
                System.out.println(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}