public class Player {
    private int player_id;
    private String player_name;

    Player(int id, String name){
        this.player_id = id;
        this.player_name = name;
    }

    public int getId() {
        return this.player_id;
    }
    public void setId(int id){
        this.player_id = id;
    }

    public String getName(){
        return this.player_name;
    }

    public void setName(String name){
        this.player_name = name;
    }
}
