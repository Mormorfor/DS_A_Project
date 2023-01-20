import java.util.ArrayList;

public class TechnionTournament implements Tournament{

    FacultyTree faclTree;
    PlayersTree playersTree;

    TechnionTournament(){};


    @Override
    public void init() {
        faclTree = new FacultyTree();
        playersTree = new PlayersTree();
    }

    @Override
    public void addFacultyToTournament(Faculty faculty) {
        Faculty facl = new Faculty(faculty.getId(), faculty.getName());
        FacultyLeaf newFaculty = new FacultyLeaf(facl);
        faclTree.insert(newFaculty);
    }


    @Override
    public void removeFacultyFromTournament(int faculty_id){
        FacultyLeaf facl = faclTree.search(faculty_id);
        PlayersLeaf[] player = facl.players;
        for(int i = 0; i < facl.index; i++ ){
            facl.removePlayer(player[i]);
        }
        faclTree.delete(facl);

    }

    @Override
    public void addPlayerToFaculty(int faculty_id,Player player) {
        Player plr = new Player(player.getId(), player.getName());
        PlayersLeaf newPlayer = new PlayersLeaf(plr);
        playersTree.insert(newPlayer);

        FacultyLeaf relevantFacl = faclTree.search(faculty_id);
        if(relevantFacl == null)
            return;
        relevantFacl.addPlayer(newPlayer);

    }

    @Override
    public void removePlayerFromFaculty(int faculty_id, int player_id) {
        FacultyLeaf facl = faclTree.search(faculty_id);
        PlayersLeaf[] player = facl.players;

        for(int i = 0; i < facl.index; i++ ){
            if(player[i].getId() == player_id){
                facl.removePlayer(player[i]);
            }
        }
    }





    @Override
    public void playGame(int faculty_id1, int faculty_id2, int winner,
                         ArrayList<Integer> faculty1_goals, ArrayList<Integer> faculty2_goals) {

    }

    @Override
    public void getTopScorer(Player player) {

    }

    @Override
    public void getTopScorerInFaculty(int faculty_id, Player player) {

    }

    @Override
    public void getTopKFaculties(ArrayList<Faculty> faculties, int k, boolean ascending) {

    }

    @Override
    public void getTopKScorers(ArrayList<Player> players, int k, boolean ascending) {

    }

    @Override
    public void getTheWinner(Faculty faculty) {

    }

    ///TODO - add below your own variables and methods
}
