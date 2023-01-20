public class FacultyLeaf extends InnerFacultyNode implements Leaf {
    Faculty faculty;
    public PlayersLeaf[] players;
    private static final int MAX_NUM_PLAYERS = 11;
    public int index;

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
        if(index == MAX_NUM_PLAYERS-1){
            System.out.println("Out of players space!");
            return;
        }
        else{
            players[index+1] = pl;
            index++;
        }
    }

    public void removePlayer(PlayersLeaf pl){
        if(index == 0){
            return;
        }
        for(int i = 0; i <= index; i++){
            if(players[i] == pl){
                players[i] = players[index];
                players[index] = null;
                return;
            }
        }
    }
}
