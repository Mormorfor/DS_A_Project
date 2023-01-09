import java.util.ArrayList;

public class TechnionTournament implements Tournament{

    FTeamNode root;

    TechnionTournament(){};


    @Override
    public void init() {
        FTeamNode root = new FTeamNode();
        FTeamNode left  = new FTeamNode();
        FTeamNode middle  = new FTeamNode();
        left.setFaculty_id(Integer.MIN_VALUE);
        middle.setFaculty_id(Integer.MAX_VALUE);
        left.setParent(root);
        middle.setParent(root);
        root.setFaculty_id(Integer.MAX_VALUE);
        root.setLeft(left);
        root.setMiddle(middle);

        this.root = root;
    }

    @Override
    public void addFacultyToTournament(Faculty faculty) {
        FTeamNode facl = new FacultyTeam(faculty.getId());
        FTeamNode x = this.root;
        while( !(x instanceof FacultyTeam)){
            if(facl.getFaculty_id() < x.left.getFaculty_id())
                x = x.left;
            else if (facl.getFaculty_id() < x.middle.getFaculty_id())
                x = x.middle;
            else
                x = x.right;
        }
        FTeamNode y = x.parent;
        FTeamNode z = insertAndSplit(y,facl);
        while (!(y.equals(this.root))) {
            y = y.parent;
            if (z != null){
                z = insertAndSplit(y,z);
            }
            else
                updateKey(y);
        }
    }

    private void updateKey(FTeamNode x){
        x.setFaculty_id(x.left.getFaculty_id());
        if (x.middle != null)
            x.setFaculty_id(x.middle.getFaculty_id());
        if( x.right != null)
            x.setFaculty_id(x.right.getFaculty_id());
    }

    private FTeamNode insertAndSplit(FTeamNode x, FTeamNode z){
        FTeamNode l = x.left;
        FTeamNode m = x.middle;
        FTeamNode r = x.right;

        if (r == null){
            if (z.getFaculty_id() < l.getFaculty_id()){
                setChildren(x,z,l,m);
            }
            else if (z.getFaculty_id() < m.getFaculty_id()){
                setChildren(x,l,z,m);
            }
            else
                setChildren(x,l,m,z);
            return null;
        }
        FTeamNode y = new FTeamNode();
        if (z.getFaculty_id() < l.getFaculty_id()){
            setChildren(x,z,l,null);
            setChildren(y,m,r,null);
        }
        else if (z.getFaculty_id() < m.getFaculty_id()){
            setChildren(x,l,z,null);
            setChildren(y,m,r,null);
        }
        else if (z.getFaculty_id() < r.getFaculty_id()){
            setChildren(x,l,m, null);
            setChildren(y,z,r,null);
        }
        else {
            setChildren(x, l, m,null);
            setChildren(y, r, z, null);
        }
        return y;
    }

    private void setChildren(FTeamNode x, FTeamNode l, FTeamNode m, FTeamNode r){
        x.setLeft(l);
        x.setMiddle(m);
        x.setRight(r);
        l.setParent(x);
        if (m != null){
            m.setParent(x);
        }
        if (r != null){
            r.setParent(x);
        }
        updateKey(x);
    }


    @Override
    public void removeFacultyFromTournament(int faculty_id){
		
    }

    @Override
    public void addPlayerToFaculty(int faculty_id,Player player) {

    }

    @Override
    public void removePlayerFromFaculty(int faculty_id, int player_id) {

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
