

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by maxim on 25.04.2021.
 */
public class Main {

    public static void main(String[] args) {
        CurrencyDB currencyDB = new CurrencyDB();
        List<Currency> currencies = currencyDB.getCurrencyList();
        Scanner scanner = new Scanner(System.in);
        double course = 0;
        while (true) {
            System.out.println("Введите валюту в которую хотите конвертировать: ");
            String index = scanner.nextLine();
            boolean flag = false;
            for (int i = 0; i < currencies.size(); i++) {
                if (index.equals(currencies.get(i).getCc())) {
                    course = currencies.get(i).getRate();
                    flag = true;
                }
            }
            if(flag){
               break;
            }
            System.out.println("Такого индекса валют не существует");
        }
        scanner = new Scanner(System.in);
        System.out.println("Введите cумму, которую хотите конвертировать: ");
        int value = scanner.nextInt();
        int result = (int) (value * course);
        System.out.println(result);

    }
}
