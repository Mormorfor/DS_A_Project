public interface InnerDoubleNode extends InnerNode {
    public void setScoreId(int scoreID);
    public int getScoreId();
    @Override
    public InnerDoubleNode getLeft();
    @Override
    public InnerDoubleNode getRight();
    @Override
    public InnerDoubleNode getMiddle();
    @Override
    public InnerDoubleNode getParent();
}
