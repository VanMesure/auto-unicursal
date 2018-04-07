public class Main {
    public static void main(String[] args){
        //随便找了一关来做测试
        Map m = new Map(5, 6);
        m.setStart(new Position(3, 5));
        m.setStatus(1, 2);
        m.setStatus(3, 3);
        m.setStatus(3, 4);
        m.setStatus(5, 1);
        m.setStatus(5, 4);
        ALU a = new ALU(m);
        a.run();

    }
}
