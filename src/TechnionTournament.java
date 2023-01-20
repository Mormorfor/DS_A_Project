import java.util.ArrayList;

public class TechnionTournament implements Tournament{

    FacultyTree faclTree;
    PlayersTree playersTree;

    FacultyScoresTree facScoreTree;

    PlayersScoresTree playScoreTree;
    TechnionTournament(){};


    @Override
    public void init() {
        faclTree = new FacultyTree();
        playersTree = new PlayersTree();
        facScoreTree = new FacultyScoresTree();
        playScoreTree = new PlayersScoresTree();
    }

    @Override
    public void addFacultyToTournament(Faculty faculty) {
        Faculty facl = new Faculty(faculty.getId(), faculty.getName());
        FacultyLeaf newFaculty = new FacultyLeaf(facl);
        FacultyScoresLeaf newFacultyScores = new FacultyScoresLeaf(facl);
        newFaculty.setFacScore(newFacultyScores);
        faclTree.insert(newFaculty);
        facScoreTree.insert(newFacultyScores);
    }


    @Override
    public void removeFacultyFromTournament(int faculty_id){
        FacultyLeaf facl = faclTree.search(faculty_id);
        facScoreTree.delete(facl.getFacScore());
        faclTree.delete(facl);
    }

    @Override
    public void addPlayerToFaculty(int faculty_id,Player player) {
        Player plr = new Player(player.getId(), player.getName());
        PlayersLeaf newPlayer = new PlayersLeaf(plr);
        playersTree.insert(newPlayer);
        PlayersScoresLeaf newPlayerScoreLeaf = new PlayersScoresLeaf(plr);
        playScoreTree.insert(newPlayerScoreLeaf);
        newPlayer.setPlScore(newPlayerScoreLeaf);

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
        if(winner == 1){
            changeFacultyScore(faculty_id1, 3);
        }
        else if(winner == 2){
            changeFacultyScore(faculty_id2, 3);
        }
        else{
            changeFacultyScore(faculty_id1, 1);
            changeFacultyScore(faculty_id2, 1);
        }
        for (Integer goalID : faculty1_goals){
            changePlayerScore(goalID);
        }
        for (Integer goalID : faculty2_goals){
            changePlayerScore(goalID);
        }
    }
    private void changeFacultyScore(int id, int points){
        FacultyLeaf facl1 = faclTree.search(id);
        FacultyScoresLeaf faclScore1 = facl1.getFacScore();
        facScoreTree.delete(faclScore1);
        faclScore1.setScoreId(faclScore1.getScoreId() + points);
        facScoreTree.insert(faclScore1);
    }
    private void changePlayerScore(int id){
        PlayersLeaf pl = playersTree.search(id);
        PlayersScoresLeaf plScoree1 = pl.getPlScore();
        playScoreTree.delete(plScoree1);
        plScoree1.setScoreId(plScoree1.getScoreId() + 1);
        facScoreTree.insert(plScoree1);
    }
    @Override
    public void getTopScorer(Player player) {
        PlayersScoresLeaf bestPlayer = (PlayersScoresLeaf)playScoreTree.getMaxScorer();
        player = bestPlayer.getPlayer();

    }

    @Override
    public void getTopScorerInFaculty(int faculty_id, Player player) {
        FacultyLeaf fac = faclTree.search(faculty_id);
        PlayersLeaf[] players = fac.players;
        Player play = players[0].getPlScore().getPlayer();
        int max = -1;
        for(PlayersLeaf pl : players){
            if(max<pl.getPlScore().getScoreId()){
                play = pl.getPlScore().getPlayer();
            }
            else if(max == pl.getPlScore().getScoreId()){
                if(play.getId()>pl.getPlScore().getPlayer().getId()){
                    play = pl.getPlScore().getPlayer();
                }
            }
        }
        player = play;
    }

    @Override
    public void getTopKFaculties(ArrayList<Faculty> faculties, int k, boolean ascending) {
        FacultyScoresLeaf currentFaculty = (FacultyScoresLeaf)facScoreTree.getMaxScorer();
        if(ascending) {
            for (int i = k-1; i >= 0; i--) {
                faculties.set(i,currentFaculty.getFaculty());
                currentFaculty = (FacultyScoresLeaf)currentFaculty.getLeftN();
            }
        }
        else{
            for (int i = 0; i < k; i++) {
                faculties.set(i,currentFaculty.getFaculty());
                currentFaculty = (FacultyScoresLeaf)currentFaculty.getLeftN();
            }
        }
    }

    @Override
    public void getTopKScorers(ArrayList<Player> players, int k, boolean ascending) {
        PlayersScoresLeaf currentPlayer = (PlayersScoresLeaf)playScoreTree.getMaxScorer();
        if(ascending) {
            for (int i = k-1; i >= 0; i--) {
                players.set(i,currentPlayer.getPlayer());
                currentPlayer = (PlayersScoresLeaf)currentPlayer.getLeftN();
            }
        }
        else{
            for (int i = 0; i < k; i++) {
                players.set(i,currentPlayer.getPlayer());
                currentPlayer = (PlayersScoresLeaf)currentPlayer.getLeftN();
            }
        }
    }

    @Override
    public void getTheWinner(Faculty faculty) {
        FacultyScoresLeaf winner = (FacultyScoresLeaf) facScoreTree.getMaxScorer();
        faculty = winner.getFaculty();
    }



}
