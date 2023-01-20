public class FacultyScoresLeaf extends FacultyScoresInnerNode implements DoubleLeaf{
    FacultyScoresLeaf rightN;
    FacultyScoresLeaf leftN;
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

