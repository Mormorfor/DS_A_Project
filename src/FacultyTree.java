public  class FacultyTree extends TwoThreeTree {
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


    public FacultyLeaf search(int faclId){
        return SearchHelper(this.root, faclId);
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


}