public abstract class TwoThreeTree {
    InnerNode root;

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

    }    protected void updateKey(InnerNode x){
        x.setId(x.getLeft().getId());
        if (x.getMiddle() != null)
            x.setId(x.getMiddle().getId());
        if( x.getRight() != null)
            x.setId(x.getRight().getId());

    }

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
        InnerNode y = createANode();
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

    protected void setChildren(InnerNode x, InnerNode l, InnerNode m, InnerNode r){
        x.setLeft(l);
        x.setMiddle(m);
        x.setRight(r);
        l.setParent(x);
        if (m != null){
            m.setParent(x);
        }
        if (r != null){
            r.setParent(x);
        }
        updateKey(x);
    }

    public void delete(Leaf node){
        InnerNode y = node.getParent();
        if(node == y.getLeft()) {
            setChildren(y, y.getMiddle(), y.getRight(), null);
        }
        else if (node == y.getMiddle()){
            setChildren(y, y.getLeft(), y.getRight(), null);
        }
        else setChildren(y, y.getLeft(), y.getMiddle(), null);
        while(y != null) {
            if (y.getMiddle() == null) {
                if(y != this.root){
                    y = borrowOrMerge(y);
                }
                else{
                    this.root = y.getLeft();
                    y.getLeft().setParent(null);
                    return;
                }
            }
            else{
                updateKey(y);
                y = y.getParent();
            }
        }
    }

    protected InnerNode borrowOrMerge(InnerNode y){
        InnerNode z = y.getParent();
        InnerNode x;
        if(y == z.getLeft()){
            x = z.getMiddle();
            if(x.getRight() !=  null){
                setChildren(y,y.getLeft(),x.getLeft(),null);
                setChildren(x,x.getMiddle(),x.getRight(), null);
            }
            else{
                setChildren(x, y.getLeft(), x.getLeft(), x.getMiddle());
                setChildren(z,x,z.getRight(), null);
            }
            return z;
        }
        if (y == z.getMiddle()){
            x = z.getLeft();
            if(x.getRight() != null){
                setChildren(y, x.getRight(), y.getLeft(), null);
                setChildren(x,x.getLeft(), x.getMiddle(), null);
            }
            else{
                setChildren(x,x.getLeft(),x.getMiddle(), y.getLeft());
                setChildren(z,x,z.getRight(),null);
            }
            return z;
        }
        x = z.getMiddle();
        if(x.getRight() != null){
            setChildren(y,x.getRight(),y.getLeft(), null);
            setChildren(x, x.getLeft(), x.getMiddle(), null);
        }
        else{
            setChildren(x, x.getLeft(), x.getMiddle(),y.getLeft());
            setChildren(z,z.getLeft(), x, null);
        }
        return z;
    }

    public boolean compareKeys(InnerNode one, InnerNode two){
        return(one.getId()< two.getId());
    }

    protected abstract InnerNode createANode();


}