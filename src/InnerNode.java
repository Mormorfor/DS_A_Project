public interface InnerNode {
    public int getId();
    public void setId(int id);

    public InnerNode getLeft();
    public InnerNode getRight();
    public InnerNode getMiddle();
    public InnerNode getParent();

    public void setLeft(InnerNode node);
    public void setRight(InnerNode node);
    public void setMiddle(InnerNode node);
    public void setParent(InnerNode node);

}
