public class PlayersScoresTree extends TwoThreeDoubleKeyTree {
    public PlayersScoresTree() {
        InnerPlayersScoresNode root = new InnerPlayersScoresNode();
        PlayersScoresLeaf left  = new PlayersScoresLeaf();
        PlayersScoresLeaf middle  = new PlayersScoresLeaf();

        left.setScoreId(Integer.MIN_VALUE);
        middle.setScoreId(Integer.MAX_VALUE);
        left.setId(Integer.MAX_VALUE);
        middle.setId(Integer.MIN_VALUE);
        left.parent = root;
        middle.parent = root;
        root.setScoreId(Integer.MAX_VALUE);
        root.setId(Integer.MIN_VALUE);
        root.left = left;
        root.middle = middle;
        left.setRightN(middle);
        middle.setLeftN(left);
        maxScorer = left;
        this.root = root;
    }
    @Override
    public boolean compareKeys(InnerNode one, InnerNode two){
        InnerPlayersScoresNode firstNode = (InnerPlayersScoresNode) one;
        InnerPlayersScoresNode secondNode = (InnerPlayersScoresNode) two;
        if(firstNode.getScoreId() == secondNode.getScoreId()){
            return (firstNode.getId() > secondNode.getId());
        }
        return(firstNode.getScoreId() < secondNode.getScoreId());
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
            InnerNode w =  new InnerPlayersScoresNode();
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
        InnerNode y = new InnerPlayersScoresNode();
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

}
