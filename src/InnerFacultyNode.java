public class InnerFacultyNode implements InnerNode {

    protected int id;
    protected InnerFacultyNode left;
    protected InnerFacultyNode middle;
    protected InnerFacultyNode right;
    protected InnerFacultyNode parent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public InnerFacultyNode getLeft() {
        return left;
    }

    @Override
    public InnerFacultyNode getMiddle() {
        return middle;
    }

    @Override
    public InnerFacultyNode getRight() {
        return right;
    }

    @Override
    public InnerFacultyNode getParent() {
        return parent;
    }

    @Override
    public void setLeft(InnerNode left) {
        this.left = (InnerFacultyNode) left;
    }
    @Override
    public void setMiddle(InnerNode middle) {
        this.middle =  (InnerFacultyNode)middle;
    }
    @Override
    public void setRight(InnerNode right) {
        this.right = (InnerFacultyNode) right;
    }
    @Override
    public void setParent(InnerNode parent) {
        this.parent =  (InnerFacultyNode)parent;
    }
}
