public class Faculty {
    private int faculty_id;
    private String faculty_name;

    Faculty(int id, String name){
        this.faculty_id = id;
        this.faculty_name = name;
    }

    public int getId() {
        return this.faculty_id;
    }
    public void setId(int id){
        this.faculty_id = id;
    }

    public String getName(){
        return this.faculty_name;
    }

    public void setName(String name){
        this.faculty_name = name;
    }
}

