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

    @Override
    public void insert(Leaf node){
        InnerNode x = this.root;
        while( !(x instanceof Leaf)){
            if(compareKeys(node, x.getLeft()))
                x = x.getLeft();
            else if (compareKeys(node, x.getMiddle()))
                x = x.getMiddle();
            else
                x = x.getRight();
        }
        InnerNode y = x.getParent();
        InnerNode z = insertAndSplit(y,node);
        while (!(y.equals(this.root))) {
            y = y.getParent();
            if (z != null){
                z = insertAndSplit(y,z);
            }
            else
                updateKey(y);
        }
        if(z != null){
            InnerNode w =  createANode();
            setChildren(w,y,z,null);
            root = w;
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

        InnerNode y = createANode();
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

    @Override
    public void delete(Leaf node){
        super.delete(node);
        ((DoubleLeaf) node).getRightN().setLeftN(((DoubleLeaf) node).getLeftN());
        ((DoubleLeaf) node).getLeftN().setRightN(((DoubleLeaf) node).getRightN());
        ((DoubleLeaf) node).setLeftN(null);
        ((DoubleLeaf) node).setRightN(null);
    }
}

