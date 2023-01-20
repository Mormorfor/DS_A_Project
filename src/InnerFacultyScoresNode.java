public class InnerFacultyScoresNode implements InnerDoubleNode{
    protected int scoreId;
    protected int id;
    protected InnerFacultyScoresNode left;
    protected InnerFacultyScoresNode middle;
    protected InnerFacultyScoresNode right;
    protected InnerFacultyScoresNode parent;


    @Override
    public void setLeft(InnerNode left) {
        this.left = (InnerFacultyScoresNode) left;
    }
    @Override
    public void setMiddle(InnerNode middle) {
        this.middle =  (InnerFacultyScoresNode)middle;
    }
    @Override
    public void setRight(InnerNode right) {
        this.right = (InnerFacultyScoresNode) right;
    }
    @Override
    public void setParent(InnerNode parent) {
        this.parent =  (InnerFacultyScoresNode)parent;
    }

    @Override
    public void setScoreId(int scoreID) {
        this.scoreId = scoreID;
    }

    @Override
    public int getScoreId() {
        return scoreId;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;

    }

    @Override
    public InnerDoubleNode getLeft() {
        return this.left;
    }

    @Override
    public InnerDoubleNode getRight() {
        return this.right;
    }

    @Override
    public InnerDoubleNode getMiddle() {
        return this.middle;
    }

    @Override
    public InnerDoubleNode getParent() {
        return this.parent;
    }
}


