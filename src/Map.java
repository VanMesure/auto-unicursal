import javafx.geometry.Pos;

public class Map {
    private Block[][] blocks;
    private Block nowBlock;
    private int row;
    private int col;
    private int size;

    private Map(){}
    public Map(int r, int c){
        if(r > 0 && c > 0){
            this.row = r + 2;
            this.col = c + 2;
            this.size = r * c;
            blocks = new Block[c + 2][r + 2];   //注意行列是反着的
            init();
        }else{
            throw new IllegalArgumentException("行列数必须大于0");
        }
    }
    private void init(){
        //设置边界格子，边界格子与边界外默认有一个虚拟链接
        for(int i = 0; i < col; i ++){
            blocks[i][0] = null;
            blocks[i][row - 1] = null;
        }
        for(int i = 0; i < row ; i ++){
            blocks[0][i] = null;
            blocks[col -1][i] = null;
        }

        //设置nomal 这里行列数减去2，代表实际的nomal
        for(int i = 1; i <= row - 2; i++) {
            for (int j = 1; j <= col - 2; j++) {
                Block b =  new Block( new Position(i, j));
                blocks[j][i] = b;
            }
        }
    }

    public void setStatus(int r, int c){
        blocks[c][r].setStatus(1);
        size -- ;
    }

    public int size(){
            return size;
    }

    public void setStart(Position start) {
        Block b = new Block(start);
        b.setStatus(1);
        this.nowBlock = b;
        blocks[start.getCol()][start.getRow()] = b;
    }

    public Block getBlock(Position p){
        return blocks[p.getCol()][p.getRow()];
    }

    public Block getBlock(int r, int c){
        return blocks[c][r];
    }

    public Block getNowBlock(){
        return nowBlock;
    }

    public void setNowBlock(Block nowBlock) {
        this.nowBlock = nowBlock;
        nowBlock.setStatus(1);
    }
}
