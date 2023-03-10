public class FacultyLeaf extends InnerFacultyNode implements Leaf {
    Faculty faculty;
    public PlayersLeaf[] players;

    public int index;

    protected FacultyScoresLeaf facScore;

    FacultyLeaf(){
        players = new PlayersLeaf[11];
        index = 0;
    }
    FacultyLeaf(Faculty faculty){
        players = new PlayersLeaf[11];
        index = 0;
        this.faculty = faculty;
        setId(faculty.getId());
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void addPlayer(PlayersLeaf pl){
       players[index] = pl;
       index++;

    }

    public void removePlayer(PlayersLeaf pl){

        for(int i = 0; i < index; i++){
            if(players[i] == pl){
                index--;
                players[i] = players[index];
                players[index] = null;
                return;
            }
        }
    }

    public FacultyScoresLeaf getFacScore() {
        return facScore;
    }

    public void setFacScore(FacultyScoresLeaf facScore) {
        this.facScore = facScore;
    }

    public int getIndex() {
        return index;
    }
}
