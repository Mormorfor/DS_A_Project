public  class FacultyTree extends TwoThreeTree {
//    InnerFacultyNode root;

    public InnerFacultyNode getRoot() {
        return (InnerFacultyNode) root;
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


    public FacultyLeaf search(int faclId){
        return SearchHelper((InnerFacultyNode)this.root, faclId);
    }

    private FacultyLeaf SearchHelper(InnerFacultyNode x, int id){
        if(x instanceof FacultyLeaf){
            if(x.getId() == id)
                return (FacultyLeaf) x;
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
            InnerNode w =  new InnerFacultyNode();
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
        InnerNode y = new InnerFacultyNode();
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