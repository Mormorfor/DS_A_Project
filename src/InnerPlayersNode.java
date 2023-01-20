public class InnerPlayersNode implements InnerNode{

    protected int id;
    protected InnerPlayersNode left;
    protected InnerPlayersNode middle;
    protected InnerPlayersNode right;
    protected InnerPlayersNode parent;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public InnerPlayersNode getLeft() {
        return left;
    }

    @Override
    public InnerPlayersNode getMiddle() {
        return middle;
    }

    @Override
    public InnerPlayersNode getRight() {
        return right;
    }

    @Override
    public InnerPlayersNode getParent() {
        return parent;
    }


    @Override
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public void setLeft(InnerNode left) {
        this.left = (InnerPlayersNode) left;
    }
    @Override
    public void setMiddle(InnerNode middle) {
        this.middle = (InnerPlayersNode) middle;
    }
    @Override
    public void setRight(InnerNode right) {
        this.right = (InnerPlayersNode) right;
    }
    @Override
    public void setParent(InnerNode parent) {
        this.parent = (InnerPlayersNode) parent;
    }
}
