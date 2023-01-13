public class FacultyLeaf extends InnerFacultyNode {
    Faculty faculty;
    Player[] players;
    private static final int MAX_NUM_PLAYERS = 11;
    private int index;

    FacultyLeaf(){
        players = new Player[11];
        index = 0;
    }
    FacultyLeaf(Faculty faculty){
        players = new Player[11];
        index = 0;
        this.faculty = faculty;
        setId(faculty.getId());
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void addPlayer(Player pl){
        if(index == MAX_NUM_PLAYERS-1){
            System.out.println("Out of players space!");
            return;
        }
        else{
            players[index+1] = pl;
            index++;
        }
    }

    public void removePlayer(Player pl){
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
