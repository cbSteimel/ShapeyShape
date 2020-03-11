import java.awt.*;

public class Enemy extends Sprite {
    int eControl=0,elControl=0;
    public Enemy(Color color, int x, int y, int width, int height, Board board){
        super(color,x,y,width,height,board);
    }

    public void move(boolean boarder,int numX,int numY,int control, Board board) {
        if(x>board.getWidth()-25&&control==2){
            x-=board.getWidth();
        }
        if(y>board.getHeight()-25&&control==3){
            y-=board.getHeight();
        }
        if(x<0&&control==0){
            // dx*=-1;
            setElControl(control);
            seteControl(2);
        }
        if(x>960&&control==2){
            //dx*=-1;
            setElControl(control);
            seteControl(0);
        }
        if(y<-15&&control==1){
            y+=board.getHeight();
        }
        if (boarder) {
            if (control == 0) {
                dx = -3;
                dy = 0;
                x += dx;

            }
            if (control == 1) {
                dy = -3;
                dx = 0;

                y += dy;

            }
            if (control == 2) {
                dx = 3;
                dy = 0;

                x += dx;

            }
            if (control == 3) {
                dy = 3;
                dx = 0;

                y += dy;

            }
        }
    }


    @Override
    public void paint(Graphics g) {
        g.setColor(getColor());
        width = 40;
        height=40;
        g.fillOval(getX(),getY(),40,26);
        g.fillRect(getX(),getY()+13,40,27);

    }

    public int geteControl() {
        return eControl;
    }

    public void seteControl(int eControl) {
        this.eControl = eControl;
    }

    public int getElControl() {
        return elControl;
    }

    public void setElControl(int elControl) {
        this.elControl = elControl;
    }
}