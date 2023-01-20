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
    @Override
    protected InnerNode insertAndSplit(InnerNode x, InnerNode z) {
        InnerNode l = x.getLeft();
        InnerNode m = x.getMiddle();
        InnerNode r = x.getRight();

        if (r == null) {
            if (compareKeys(z, l)) {
                setChildren(x, z, l, m);
                if (z instanceof DoubleLeaf) {
                    setNeighbours(((DoubleLeaf) l).getLeftN(), (DoubleLeaf) z, (DoubleLeaf) l);
                }
            } else if (compareKeys(z, m)) {
                setChildren(x, l, z, m);
                if (z instanceof DoubleLeaf) {
                    setNeighbours((DoubleLeaf) l, (DoubleLeaf) z, (DoubleLeaf) m);
                }
            } else {
                setChildren(x, l, m, z);
                if (z instanceof DoubleLeaf) {
                    setNeighbours((DoubleLeaf) m, (DoubleLeaf) z, ((DoubleLeaf) m).getRightN());
                }
            }
                return null;
        }
        InnerFacultyNode y = new InnerFacultyNode();
        if (compareKeys(z, l)) {
            setChildren(x, z, l, null);
            if (z instanceof DoubleLeaf) {
                setNeighbours(((DoubleLeaf) l).getLeftN(), (DoubleLeaf) z, (DoubleLeaf) l);
            }
            setChildren(y, m, r, null);

        } else if (compareKeys(z, m)) {
            setChildren(x, l, z, null);
            setChildren(y, m, r, null);
            if (z instanceof DoubleLeaf) {
                setNeighbours((DoubleLeaf) l, (DoubleLeaf) z, (DoubleLeaf) m);
            }
        } else if (compareKeys(z, r)) {
            setChildren(x, l, m, null);
            setChildren(y, z, r, null);
            if (z instanceof DoubleLeaf) {
                setNeighbours((DoubleLeaf) m, (DoubleLeaf) z, (DoubleLeaf) r);
            }
        } else {
            setChildren(x, l, m, null);
            setChildren(y, r, z, null);
            if (z instanceof DoubleLeaf) {
                setNeighbours((DoubleLeaf) r, (DoubleLeaf) z, ((DoubleLeaf) r).getRightN());
            }
        }
        return y;
    }
    private void setNeighbours(DoubleLeaf l, DoubleLeaf m, DoubleLeaf r){
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

