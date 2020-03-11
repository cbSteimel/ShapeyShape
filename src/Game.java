import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Game extends JFrame implements MouseMotionListener,KeyListener {

        Board board;
        Point p;
        int x, y;
        int positionX,positionY;
        boolean right, left, up, down, enter;

        Timer moment;

    public Game(){

        setTitle("ShapeyShape");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setResizable(false);
        board = new Board(this);
        add(board);


        addKeyListener(this);
        addMouseMotionListener(this);
        pack();


        setLocationRelativeTo(null);

    }



        public static void main(String[] args){
        Game game = new Game();
        game.board.setup();
    }







        public int getPositionX() {
        return positionX;
    }


        public int getPositionY() {
        return positionY;
    }

        @Override
        public void mouseDragged(MouseEvent e) {

    }

        @Override
        public void mouseMoved(MouseEvent e) {

    }

        @Override
        public void keyTyped(KeyEvent keyEvent) {

    }

        @Override
        public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D)
            right = true;
        if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A)
            left = true;
        if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W)
            up = true;
        if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S)
            down = true;
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
            enter = true;
    }

        @Override
        public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D)
            right = false;
        if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A)
            left = false;
        if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W)
            up = false;
        if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S)
            down = false;
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
            enter = false;
    }
        public boolean isRight() {
        // System.out.println(right);
        return right;
    }

        public boolean isLeft() {
        //System.out.println(left);

        return left;
    }

        public boolean isUp() {
        // System.out.println(up);

        return up;
    }

        public boolean isDown() {
        // System.out.println(down);

        return down;
    }

        public boolean isEnter() {
        return enter;
    }
    }
