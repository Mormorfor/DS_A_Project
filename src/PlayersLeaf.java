public class PlayersLeaf extends InnerPlayersNode implements Leaf{
    Player player;
    PlayersScoresLeaf plScore;

    public PlayersScoresLeaf getPlScore() {
        return plScore;
    }

    public void setPlScore(PlayersScoresLeaf plScore) {
        this.plScore = plScore;
    }
    PlayersLeaf(){}
    PlayersLeaf(Player player) {
        this.player = player;
        this.setId(player.getId());
    }

}
