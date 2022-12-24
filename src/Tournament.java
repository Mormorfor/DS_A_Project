import java.lang.String;
import java.util.ArrayList;

public interface Tournament {

    public void init();

    public void addFacultyToTournament(Faculty faculty);

    public void removeFacultyFromTournament(int faculty_id);

    public void addPlayerToFaculty(int faculty_id, Player player);

    public void removePlayerFromFaculty(int faculty_id, int player_id);

    public void playGame(int faculty_id1, int faculty_id2, int winner, ArrayList<Integer> faculty1_goals, ArrayList<Integer> faculty2_goals);

    public void getTopScorer(Player player);

    public void getTopScorerInFaculty(int faculty_id, Player player);

    public void getTopKFaculties(ArrayList<Faculty> faculties, int k, boolean ascending);

    public void getTopKScorers(ArrayList<Player> players, int k, boolean ascending);

    public void getTheWinner(Faculty faculty);

}

