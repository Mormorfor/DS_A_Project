public class FacultyScoresTree extends TwoThreeDoubleKeyTree {
    public FacultyScoresTree() {
        InnerFacultyScoresNode root = new InnerFacultyScoresNode();
        FacultyScoresLeaf left  = new FacultyScoresLeaf();
        FacultyScoresLeaf middle  = new FacultyScoresLeaf();


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
        InnerFacultyScoresNode firstNode = (InnerFacultyScoresNode) one;
        InnerFacultyScoresNode secondNode = (InnerFacultyScoresNode) two;
        if(firstNode.getScoreId() == secondNode.getScoreId()){
            return (firstNode.getId() > secondNode.getId());
        }
        return(firstNode.getScoreId() < secondNode.getScoreId());
    }
}
