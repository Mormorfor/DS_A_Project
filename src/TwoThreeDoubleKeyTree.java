public abstract class TwoThreeDoubleKeyTree extends TwoThreeTree{
    DoubleLeaf maxScorer;
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

    protected void setNeighbours(DoubleLeaf l, DoubleLeaf m, DoubleLeaf r){
       l.setRightN(m);
       m.setLeftN(l);
       m.setRightN(r);
       r.setLeftN(m);
       if((r.getScoreId() == Integer.MAX_VALUE) && (r.getId() == Integer.MIN_VALUE)){
           maxScorer = m;
       }
    }

    public DoubleLeaf getMaxScorer() {
        return maxScorer;
    }
}

