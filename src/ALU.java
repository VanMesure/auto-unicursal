import com.sun.istack.internal.NotNull;

import java.util.Stack;

public class ALU {
    private Map map;
    private Stack<Position> record = new Stack<>(); //用来记录步骤
    private int count = 0;
    public ALU(@NotNull Map map){
        this.map = map;
    }

    public void run(){
        Block nowBlock = map.getNowBlock(); //获取当前格子
        Position p = nowBlock.getPosition();//获取当前格子的坐标
        Block up = map.getBlock(p.getRow() - 1, p.getCol());//判断上方向可不可以走
        if(null != up && up.getStatus() == 0){
            record.push(map.getNowBlock().getPosition());
            map.setNowBlock(up);
            count ++;
            run();
        }

         nowBlock = map.getNowBlock();
         p = nowBlock.getPosition();
         Block down = map.getBlock(p.getRow() + 1, p.getCol());
        if(null != down && down.getStatus() == 0){
            record.push(map.getNowBlock().getPosition());
            map.setNowBlock(down);
            count ++;
            run();
        }

        nowBlock = map.getNowBlock();
        p = nowBlock.getPosition();
        Block left = map.getBlock(p.getRow(), p.getCol() - 1);
        if(null != left && left.getStatus() == 0){
            record.push(map.getNowBlock().getPosition());
            map.setNowBlock(left);
            count ++;
            run();
        }

        nowBlock = map.getNowBlock();
        p = nowBlock.getPosition();
        Block right = map.getBlock(p.getRow(), p.getCol() + 1);
        if(null != right && right.getStatus() == 0){
            record.push(map.getNowBlock().getPosition());
            map.setNowBlock(right);
            count ++;
            run();
        }

        //运行到这一步说明无路可走了
        //判断是不是找到了正确路径
        if(count == map.size() - 1){
            record.push(nowBlock.getPosition());
            System.out.println("找到了（以下结果为倒序输出）");
            out();
            System.exit(0);
        }
        //判断是否无解
        if(record.empty()){
            System.out.println("无解");
            System.exit(0);
        }

        //回退到上一步
        nowBlock.setStatus(0);
        map.setNowBlock(map.getBlock(record.pop()));
        count --;
    }

    private void out(){
        for (Position p:
             record) {
            System.out.println(p);
        }

    }
}
