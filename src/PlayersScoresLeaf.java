public class PlayersScoresLeaf extends InnerPlayersScoresNode implements DoubleLeaf{
    PlayersScoresLeaf rightN;
    PlayersScoresLeaf leftN;

    Player player;


    public PlayersScoresLeaf(){
        this.scoreId = 0;
    }
    public PlayersScoresLeaf(Player player) {
        this.scoreId = 0;
        this.id = player.getId();
        this.player = player;
    }
    public Player getPlayer() {
        return player;
    }
    @Override
    public DoubleLeaf getRightN() {
        return rightN;
    }
    @Override
    public void setRightN(DoubleLeaf rightN) {
        this.rightN = (PlayersScoresLeaf) rightN;
    }
    @Override
    public DoubleLeaf getLeftN() {
        return leftN;
    }
    @Override
    public void setLeftN(DoubleLeaf leftN) {
        this.leftN = (PlayersScoresLeaf) leftN;
    }
}
