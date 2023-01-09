import java.util.ArrayList;

public class FacultyTeam extends FTeamNode {
    private int faculty_id;
    private ArrayList<Player> players;

    public FacultyTeam(int faculty_id){
        this.faculty_id = faculty_id;
    }

    public void addPlayer(Player pl){
        if(players.size() == 11){
            System.out.println("No more spots!");
            return;
        }
        this.players.add(pl);
    }

    public void removePlayer(Player pl){
        if(players.size() == 2){
            System.out.println("Not enough players!");
            return;
        }
        for (Player player : players){
            if(player.equals(pl)) {
                players.remove(pl);
                return;
            }
        }
    }
}
