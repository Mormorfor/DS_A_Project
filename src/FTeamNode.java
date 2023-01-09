public class FTeamNode {
    public FTeamNode left;
    public FTeamNode middle;
    public FTeamNode right;
    public FTeamNode parent;
    public int faculty_id;



    public int getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(int faculty_id) {
        this.faculty_id = faculty_id;
    }

    public FTeamNode getLeft() {
        return left;
    }

    public FTeamNode getMiddle() {
        return middle;
    }

    public FTeamNode getRight() {
        return right;
    }

    public FTeamNode getParent() {
        return parent;
    }

    public void setLeft(FTeamNode left) {
        this.left = left;
    }

    public void setMiddle(FTeamNode middle) {
        this.middle = middle;
    }

    public void setRight(FTeamNode right) {
        this.right = right;
    }

    public void setParent(FTeamNode parent) {
        this.parent = parent;
    }

}
