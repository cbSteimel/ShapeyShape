import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Player extends Sprite implements ActionListener {

        Game game;
        int[] xP;
        int[] yP;
        Timer timer;
        Board board;
        int num=0,num2=0;
    public Player(Color color, int x, int y, int width, int height, Board board, Game game) {
        super(color, x, y, width, height, board);
        this.game = game;
        xP = new int[] {x,x+getWidth()/2,x};
        yP = new int[]{y,y+getHeight()/2,y+getHeight()};
        timer = new Timer(1000/60,this);
        timer.start();
    }

        //@Override
        public void move(boolean boarder,int numX,int numY,int control, Board board) {
        if(x>board.getWidth()-25&&control==2){
            x-=board.getWidth();
        }
        if(y>board.getHeight()-25&&control==3){
            y-=board.getHeight();
        }
        if(x<-15&&control==0&&(y<=360||y>=420)){
            x+=board.getWidth();
        }
        if(x>1040&&control==2&&(y<=360||y>=420)){
            x+=board.getWidth();
        }
        else if(x<-40&&control==0){
            x+=board.getWidth()+40;

        }
        if(y<-15&&control==1){
            y+=board.getHeight();
        }

        if (control == 0) {
            dx = -3;
            dy = 0;
            x += dx;
            xP = new int[]{x, x + getWidth() / 2, x};
            yP = new int[]{(y + numY), y + getHeight() / 2, (y + (getHeight() - numY))};
        }
        if (control == 1) {
            dy = -3;
            dx = 0;

            y += dy;
            xP = new int[]{x + numX, x + getWidth() / 2, (x + (getWidth() - numX))};
            yP = new int[]{y, y + getHeight() / 2, y};
        }
        if (control == 2) {
            dx = 3;
            dy = 0;

            x += dx;
            xP = new int[]{x + getWidth(), x + getWidth() / 2, x + getWidth()};
            yP = new int[]{(y + numY), y + getHeight() / 2, (y + (getHeight() - numY))};
        }
        if (control == 3) {
            dy = 3;
            dx = 0;

            y += dy;
            xP = new int[]{x + numX, x + getWidth() / 2, (x + (getWidth() - numX))};
            yP = new int[]{y + getHeight(), y + getHeight() / 2, y + getHeight()};
        }
    }


        // System.out.println(dx+"\n"+dy+"\n"+x+"\n"+y);

        @Override
        public void actionPerformed(ActionEvent actionEvent) {


    }


        public void setxP() {
        xP[0]-=dx*2;
        xP[1]-=dx*2;
        xP[2]-=dx*2;
    }
        public void setyP() {
        yP[0]-=dy*2;
        yP[1]-=dy*2;
        yP[2]-=dy*2;
    }

        @Override
        public void paint(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getX(), getY(), getWidth(), getHeight());
        g.setColor(Color.BLACK);

        g.fillPolygon(xP,yP,3);
    }



    }