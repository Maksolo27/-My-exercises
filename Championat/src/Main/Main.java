package Main;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("C:\\Users\\maxim\\IdeaProjects\\-My-exercises\\Championat\\src\\Championat.csv")) {
            StringBuilder text = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                text.append((char) c);
            }
            List<String> championatWithQuantity = Arrays.asList(text.toString().split(","));
            int quantity = 0;
            List<String> championat = new ArrayList<>();
            for (int i = 0; i < championatWithQuantity.size(); i++) {
                if (i == 0) {
                    quantity = Integer.parseInt(championatWithQuantity.get(i));
                }else {
                    championat.add(championatWithQuantity.get(i));
                }
            }
            int i = 0;
            int j = 0;
            List<Team> teamsTable = new LinkedList<>();
            while (i < quantity) {
                Team team = new Team();
                List<String> matches = new ArrayList<>();
                while (j < championat.size()) {
                    Pattern p = Pattern.compile("[a-z]+");
                    Matcher m = p.matcher(championat.get(j));
                    if (m.find()) {
                        team.name = championat.get(j);
                        System.out.println(championat.get(j));
                    }
                    p = Pattern.compile("\\d");
                    m = p.matcher(championat.get(j));
                    if (m.find()) {
                        matches.add(championat.get(j));
                        System.out.println(championat.get(j));
                    }
                    j++;
                    if(j % 11 == 0){
                        break;
                    }
                }
                team.matches = matches.toArray(new String[0]);
                teamsTable.add(team);
                i++;

            }
            for (int k = 0; k < teamsTable.size(); k++) {
                teamsTable.get(k).score(teamsTable.get(k).matches);
            }
            teamsTable.sort(Team::compareTo);
            for (int k = 0; k < teamsTable.size(); k++) {
                    FileWriter writer = new FileWriter("C:\\Users\\maxim\\IdeaProjects\\-My-exercises\\Championat\\src\\TournamentTable.csv", true);
                    System.out.println(teamsTable.get(k).toString());
                    writer.append(teamsTable.get(k).toString());
                    writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
