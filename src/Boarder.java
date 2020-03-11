import java.awt.*;

public class Boarder extends Sprite {
    int width=25;
    public Boarder(Color color, int x, int y, int width, int height, Board board){
        super(color,x,y,width,height,board);

    }
    public void paint(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }
}