package Main;

public class Team implements Comparable<Team> {
    String[] matches;
    String name;
    int score = 0;
    public int score(String[] matches){
        for (int i = 0; i < matches.length; i++) {
            String[] match = matches[i].split(":");
            int teamGoals = 0;
            int enemyGoals = 0;
            for (int j = 0; j <match.length ; j++) {
                if(j == 0){
                    teamGoals = Integer.valueOf(match[j]);
                }
                if(j == 1){
                    enemyGoals = Integer.valueOf(match[j]);
                }
            }
            if(teamGoals > enemyGoals){
                this.score += 3;
            }
            else if(teamGoals == enemyGoals){
                this.score += 1;
            }
            else if(teamGoals < enemyGoals){
                this.score += 0;
            }
        }
        return score;

    }


    @Override
    public int compareTo(Team t) {
        return  t.score - score;
    }


    public String toString() {
        return  name + " " + score;
    }
}
