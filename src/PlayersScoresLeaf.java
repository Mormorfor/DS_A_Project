public class PlayersScoresLeaf extends InnerPlayersScoresNode implements DoubleLeaf{
    PlayersScoresLeaf rightN;
    PlayersScoresLeaf leftN;
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
