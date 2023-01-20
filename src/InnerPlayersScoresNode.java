public class InnerPlayersScoresNode implements InnerDoubleNode{
    protected int scoreId;
    protected int id;
    protected InnerPlayersScoresNode left;
    protected InnerPlayersScoresNode middle;
    protected InnerPlayersScoresNode right;
    protected InnerPlayersScoresNode parent;
    @Override
    public void setLeft(InnerNode left) {
        this.left = (InnerPlayersScoresNode) left;
    }
    @Override
    public void setMiddle(InnerNode middle) {
        this.middle =  (InnerPlayersScoresNode)middle;
    }
    @Override
    public void setRight(InnerNode right) {
        this.right = (InnerPlayersScoresNode) right;
    }
    @Override
    public void setParent(InnerNode parent) {
        this.parent =  (InnerPlayersScoresNode)parent;
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

