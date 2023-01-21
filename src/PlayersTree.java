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
    protected InnerNode createANode(){
        return new InnerPlayersNode();
    }



}
