public class Position {
    private int r;
    private int c;

    public Position(){}
    public Position(int r, int c){
        this.r = r;
        this.c = c;
    }

    public int getRow() {
        return r;
    }

    public int getCol() {
        return c;
    }

    @Override
    public String toString() {
        return r + "," + c;
    }
}
