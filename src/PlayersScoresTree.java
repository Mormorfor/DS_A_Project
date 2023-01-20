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
        super.insert(node);
    }

}
