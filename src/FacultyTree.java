public  class FacultyTree {
    InnerFacultyNode root;

    public InnerFacultyNode getRoot() {
        return root;
    }

    public FacultyTree() {
        InnerFacultyNode root = new InnerFacultyNode();
        FacultyLeaf left  = new FacultyLeaf();
        FacultyLeaf middle  = new FacultyLeaf();

        left.setId(Integer.MIN_VALUE);
        middle.setId(Integer.MAX_VALUE);
        left.parent = root;
        middle.parent = root;
        root.setId(Integer.MAX_VALUE);
        root.left = left;
        root.middle =middle;

        this.root = root;
    }

    public void insert(FacultyLeaf node){
        InnerFacultyNode x = this.root;
        while( !(x instanceof FacultyLeaf)){
            if(node.getId() < x.left.getId())
                x = x.left;
            else if (node.getId() < x.middle.getId())
                x = x.middle;
            else
                x = x.right;
        }
        InnerFacultyNode y = x.parent;
        InnerFacultyNode z = insertAndSplit(y,node);
        while (!(y.equals(this.root))) {
            y = y.parent;
            if (z != null){
                z = insertAndSplit(y,z);
            }
            else
                updateKey(y);
        }
    }

    private void updateKey(InnerFacultyNode x){
        x.setId(x.left.getId());
        if (x.middle != null)
            x.setId(x.middle.getId());
        if( x.right != null)
            x.setId(x.right.getId());
    }

    private InnerFacultyNode insertAndSplit(InnerFacultyNode x, InnerFacultyNode z){
        InnerFacultyNode l = x.left;
        InnerFacultyNode m = x.middle;
        InnerFacultyNode r = x.right;

        if (r == null){
            if (z.getId() < l.getId()){
                setChildren(x,z,l,m);
            }
            else if (z.getId() < m.getId()){
                setChildren(x,l,z,m);
            }
            else
                setChildren(x,l,m,z);
            return null;
        }
        InnerFacultyNode y = new InnerFacultyNode();
        if (z.getId() < l.getId()){
            setChildren(x,z,l,null);
            setChildren(y,m,r,null);
        }
        else if (z.getId() < m.getId()){
            setChildren(x,l,z,null);
            setChildren(y,m,r,null);
        }
        else if (z.getId() < r.getId()){
            setChildren(x,l,m, null);
            setChildren(y,z,r,null);
        }
        else {
            setChildren(x, l, m,null);
            setChildren(y, r, z, null);
        }
        return y;
    }

    private void setChildren(InnerFacultyNode x, InnerFacultyNode l, InnerFacultyNode m, InnerFacultyNode r){
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

    public void delete (FacultyLeaf node){
       InnerFacultyNode y = node.parent;
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

    private InnerFacultyNode borrowOrMerge(InnerFacultyNode y){

    }

}
