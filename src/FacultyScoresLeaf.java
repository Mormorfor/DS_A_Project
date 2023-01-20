public class FacultyScoresLeaf extends InnerFacultyScoresNode implements DoubleLeaf{
    FacultyScoresLeaf rightN;
    FacultyScoresLeaf leftN;

    Faculty faculty;


    public FacultyScoresLeaf(){
        this.scoreId = 0;
    }
    public FacultyScoresLeaf(Faculty faculty) {
        this.scoreId = 0;
        this.faculty = faculty;
        this.id = faculty.getId();
    }
    public Faculty getFaculty() {
        return faculty;
    }
    @Override
    public DoubleLeaf getRightN() {
        return rightN;
    }
    @Override
    public void setRightN(DoubleLeaf rightN) {
        this.rightN = (FacultyScoresLeaf) rightN;
    }
    @Override
    public DoubleLeaf getLeftN() {
        return leftN;
    }
    @Override
    public void setLeftN(DoubleLeaf leftN) {
        this.leftN = (FacultyScoresLeaf) leftN;
    }
}

