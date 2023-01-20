public class PlayersLeaf extends InnerPlayersNode implements Leaf{
    Player player;

    PlayersLeaf(){}
    PlayersLeaf(Player player) {
        this.player = player;
        this.setId(player.getId());
    }

}
