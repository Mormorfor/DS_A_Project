public class PlayersTree extends TwoThreeTree{
    //InnerPlayersNode root;

    public InnerPlayersNode getRoot() {
        return (InnerPlayersNode) root;
    }

    public PlayersTree() {
        InnerPlayersNode root = new InnerPlayersNode();
        PlayersLeaf left  = new PlayersLeaf();
        PlayersLeaf middle  = new PlayersLeaf();

        left.setId(Integer.MIN_VALUE);
        middle.setId(Integer.MAX_VALUE);
        left.parent = root;
        middle.parent = root;
        root.setId(Integer.MAX_VALUE);

        root.left = left;
        root.middle =middle;

        this.root = root;
    }
    public PlayersLeaf search(int playerId){
        return SearchHelper((InnerPlayersNode)this.root, playerId);
    }

    private PlayersLeaf SearchHelper(InnerPlayersNode x, int id){
        if(x instanceof PlayersLeaf){
            if(x.getId() == id)
                return (PlayersLeaf) x;
            else
                return null;
        }
        if(id <= x.left.getId()){
            return SearchHelper(x.left, id);
        }
        else if (id <= x.middle.getId()){
            return SearchHelper(x.middle, id);
        }
        else
            return SearchHelper(x.right, id);
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
            InnerNode w =  new InnerPlayersNode();
            setChildren(w,y,z,null);
            root = w;
        }
    }

    @Override
    protected InnerNode insertAndSplit(InnerNode x, InnerNode z){
        InnerNode l = x.getLeft();
        InnerNode m = x.getMiddle();
        InnerNode r = x.getRight();

        if (r == null){
            if (compareKeys(z,l)){
                setChildren(x,z,l,m);
            }
            else if (compareKeys(z,m)){
                setChildren(x,l,z,m);
            }
            else
                setChildren(x,l,m,z);
            return null;
        }
        InnerNode y = new InnerPlayersNode();
        if (compareKeys(z,l)){
            setChildren(x,z,l,null);
            setChildren(y,m,r,null);
        }
        else if (compareKeys(z,m)){
            setChildren(x,l,z,null);
            setChildren(y,m,r,null);
        }
        else if (compareKeys(z,r)){
            setChildren(x,l,m, null);
            setChildren(y,z,r,null);
        }
        else {
            setChildren(x, l, m,null);
            setChildren(y, r, z, null);
        }
        return y;
    }
}
