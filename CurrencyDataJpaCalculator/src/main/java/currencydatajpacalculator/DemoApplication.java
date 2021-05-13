package currencydatajpacalculator;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import currency.Currency;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import service.CurrencyService;
import service.CurrencyServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		CurrencyService service = ctx.getBean(CurrencyService.class);

		String url = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";
		String jsonObj = proccesRequest(url);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Currency[] currencies = gson.fromJson(jsonObj, Currency[].class);
		for (Currency c: currencies) {
			service.save(c);
		}
	}


	private static String proccesRequest(String urlStr) throws IOException {
		URL url = new URL(urlStr);
		StringBuilder stringBuilder = new StringBuilder();

		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		String line;
		while ((line = bufferedReader.readLine()) != null){
			stringBuilder.append(line).append("\n");
		}
		return stringBuilder.toString();
	}

}
