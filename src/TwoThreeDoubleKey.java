public abstract class TwoThreeDoubleKey extends TwoThreeTree{
    @Override
    protected void updateKey(InnerNode x){
        InnerDoubleNode y = (InnerDoubleNode) x;
        y.setId(y.getLeft().getId());
        y.setScoreId(y.getLeft().getScoreId());
        if (y.getMiddle() != null) {
            y.setId(y.getMiddle().getId());
            y.setScoreId(y.getMiddle().getScoreId());
        }
        if( y.getRight() != null) {
            y.setId(y.getRight().getId());
            y.setScoreId(y.getRight().getScoreId());
        }
    }
}
