/**
 * Created by maxim on 24.04.2021.
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by maxim on 24.04.2021.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String url = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";
        String jsonObj = proccesRequest(url);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Currency[] currencies = gson.fromJson(jsonObj, Currency[].class);
        Configuration configuration = new Configuration();
        SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        for (Currency c: currencies) {
            session.save(c);
        }
        session.getTransaction().commit();
        sessionFactory.close();
        session.close();

    }

    private static String proccesRequest(String urlStr) throws IOException{
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

