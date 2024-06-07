public class Square extends Rect {
    private int lado;
    public Square(int x, int y, int lado) {
        super(x, y, lado, lado);
        this.lado = lado;
    }
    public Square() {
        super(0, 0, 100, 100);
    }
    public Square(Square other){
        super(other.getX(),other.getY(),other.getLado(),other.getLado());
    }

    public int getLado() {
        return lado;
    }
    public void setLado(int lado) {
        this.lado = lado;
    }
}








