public class Block {
    private Position position = new Position(0, 0);
    private int status = 0;     //0代表没占用，1代表占用

    public Block() {

    }
    public Block(Position p) {
        this.position = p;
    }

    public Position getPosition() {
        return position;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
