public class PlayersTree {
    InnerPlayersNode root;

    public InnerPlayersNode getRoot() {
        return root;
    }

    public PlayersTree() {
        InnerPlayersNode root = new InnerPlayersNode();
        PlayersLeaf left  = new PlayersLeaf();
        PlayersLeaf middle  = new PlayersLeaf();

        left.setPlayerId(Integer.MIN_VALUE);
        left.setFaculId(Integer.MIN_VALUE);

        middle.setFaculId(Integer.MAX_VALUE);
        middle.setPlayerId(Integer.MAX_VALUE);

        left.parent = root;
        middle.parent = root;
        root.setFaculId(Integer.MAX_VALUE);
        root.setPlayerId(Integer.MAX_VALUE);

        root.left = left;
        root.middle =middle;

        this.root = root;
    }

    public void insert(PlayersLeaf node){
        InnerPlayersNode x = this.root;
        while( !(x instanceof PlayersLeaf)){
            if(x.comparePlayerKeys(x.left,node))
                x = x.left;
            else  if(x.comparePlayerKeys(x.middle,node))
                x = x.middle;
            else
                x = x.right;
        }
        InnerPlayersNode y = x.parent;
        InnerPlayersNode z = insertAndSplit(y,node);
        while (!(y.equals(this.root))) {
            y = y.parent;
            if (z != null){
                z = insertAndSplit(y,z);
            }
            else
                updateKey(y);
        }
    }

    private void updateKey(InnerPlayersNode x){
        x.setPlayerId(x.left.getPlayerId());
        x.setFaculId(x.left.getFaculId());

        if (x.middle != null) {
            x.setPlayerId(x.middle.getPlayerId());
            x.setFaculId(x.middle.getFaculId());
        }
        if( x.right != null) {
            x.setPlayerId(x.right.getPlayerId());
            x.setFaculId(x.right.getFaculId());
        }
    }


    private InnerPlayersNode insertAndSplit(InnerPlayersNode x, InnerPlayersNode z){
        InnerPlayersNode l = x.left;
        InnerPlayersNode m = x.middle;
        InnerPlayersNode r = x.right;

        if (r == null){

            if (x.comparePlayerKeys(l,z)){
                setChildren(x,z,l,m);
            }
            else if (x.comparePlayerKeys(m,z)){
                setChildren(x,l,z,m);
            }
            else
                setChildren(x,l,m,z);
            return null;
        }
        InnerPlayersNode y = new InnerPlayersNode();
        if (x.comparePlayerKeys(l,z)){
            setChildren(x,z,l,null);
            setChildren(y,m,r,null);
        }
        else if (x.comparePlayerKeys(m,z)){
            setChildren(x,l,z,null);
            setChildren(y,m,r,null);
        }
        else if (x.comparePlayerKeys(r,z)){
            setChildren(x,l,m, null);
            setChildren(y,z,r,null);
        }
        else {
            setChildren(x, l, m,null);
            setChildren(y, r, z, null);
        }
        return y;
    }

    private void setChildren(InnerPlayersNode x, InnerPlayersNode l, InnerPlayersNode m, InnerPlayersNode r){
        x.left = l;
        x.middle = m;
        x.right = r;
        l.parent = x;
        if (m != null){
            m.parent = x;
        }
        if (r != null){
            r.parent = x;
        }
        updateKey(x);
    }
}
