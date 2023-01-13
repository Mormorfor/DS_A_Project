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


    public void delete(PlayersLeaf node){
        InnerPlayersNode y = node.parent;
        if(node == y.left) {
            setChildren(y, y.middle, y.right, null);
        }
        else if (node == y.middle){
            setChildren(y, y.left, y.right, null);
        }
        else setChildren(y, y.left, y.middle, null);
        while(y != null) {
            if (y.middle == null) {
                if(y != this.root){
                    y = borrowOrMerge(y);
                }
                else{
                    this.root = y.left;
                    y.left.parent = null;
                    return;
                }
            }
            else{
                updateKey(y);
                y = y.parent;
            }
        }
    }

    private InnerPlayersNode borrowOrMerge(InnerPlayersNode y){
        InnerPlayersNode z = y.parent;
        InnerPlayersNode x;
        if(y == z.left){
            x = z.middle;
            if(x.right !=  null){
                setChildren(y,y.left,x.left,null);
                setChildren(x,x.middle,x.right, null);
            }
            else{
                setChildren(x, y.left, x.left, x.middle);
                setChildren(z,x,z.right, null);
            }
            return z;
        }
        if (y == z.middle){
            x = z.left;
            if(x.right != null){
                setChildren(y, x.right, y.left, null);
                setChildren(x,x.left, x.middle, null);
            }
            else{
                setChildren(x,x.left,x.middle, y.left);
                setChildren(z,x,z.right,null);
            }
            return z;
        }
        x = z.middle;
        if(x.right != null){
            setChildren(y,x.right,y.left, null);
            setChildren(x, x.left, x.middle, null);
        }
        else{
            setChildren(x, x.left, x.middle,y.left);
            setChildren(z,z.left, x, null);
        }
        return z;
    }

}
