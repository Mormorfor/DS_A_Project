public class PlayersLeaf extends InnerPlayersNode{
    Player player;

    PlayersLeaf(){}
    PlayersLeaf(Player player, int faclId) {
        this.player = player;
        this.faculId = faclId;
        this.playerId = player.getId();
    }

}
