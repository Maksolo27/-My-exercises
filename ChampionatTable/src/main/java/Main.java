import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

/**
 * Created by maxim on 06.04.2021.
 */
public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество сыгранных матчей");
        int quantity = scanner.nextInt();
        for (int i = 0; i < quantity; i++) {
            scanner = new Scanner(System.in);
            System.out.println("Введите имя первой команды");
            String team1 = scanner.nextLine();
            scanner = new Scanner(System.in);
            System.out.println("Введите имя второй команды");
            String team2 = scanner.nextLine();
            System.out.println("Введите количество забитых голов командой " + team1);
            int goals1 = scanner.nextInt();
            scanner = new Scanner(System.in);
            System.out.println("Введите количество забитых голов командой " + team2);
            int goals2 = scanner.nextInt();
            System.out.println("Матч введеный вами:");
            System.out.println(team1 + " " + goals1 + " : " + goals2 + " "+ team2);
            System.out.println("Напишите: Да | Нет");
            scanner = new Scanner(System.in);
            String check = scanner.nextLine();
            if(check.equals("Нет")){
                i = i - 1;
                continue;
            }
            Matches match = new Matches();
            match.setId(i);
            match.setTeam1(team1);
            match.setGoals1(goals1);
            match.setGoals2(goals2);
            match.setTeam2(team2);
            Configuration configuration = new Configuration();

            SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();

            Session session = factory.openSession();

            session.beginTransaction();
            session.save(match);
            session.getTransaction().commit();

            factory.close();
            session.close();
        }


    }
}
