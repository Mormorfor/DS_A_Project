public class PlayersTree extends TwoThreeTree{
    InnerPlayersNode root;

    public InnerPlayersNode getRoot() {
        return root;
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


}
