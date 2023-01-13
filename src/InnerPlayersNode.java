public class InnerPlayersNode {

    int faculId;
    int playerId;

    public InnerPlayersNode left;
    public InnerPlayersNode middle;
    public InnerPlayersNode right;
    public InnerPlayersNode parent;

    public int getFaculId() {
        return faculId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setFaculId(int faculId) {
        this.faculId = faculId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public boolean comparePlayerKeys(InnerPlayersNode node1, InnerPlayersNode node2){
        if(node1.getFaculId() == node2.getFaculId()){
            return node1.getPlayerId() > node2.getPlayerId();
        }

        return node1.getFaculId() > node2.getFaculId();
    }
}
