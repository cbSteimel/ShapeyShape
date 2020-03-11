import java.awt.*;

public abstract class Sprite {
    Color color;
    int x,y,width,height;
    int eControl=2,elControl=0;
    double dx,dy;
    double nextLeft=x+dx;
    double nextRight=(x+width)+dx;
    double nextTop=y+dy;
    double nextBottom=(y+height)+dy;
    boolean remove = false,check = true,negY,negX,posY,posX;
    Board board;
    public Sprite(Color color, int x, int y, int width, int height,Board board){
        this.color=color;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.board = board;
        while((int)dx == 0 || (int)dy==0){
            double angle = 2*Math.PI*(Math.random()+1);
            double speed = (STATS.getRangeSpeed()*Math.random()+STATS.getLowSpeed());
            dx=Math.cos(angle)*speed;
            dy=Math.sin(angle)*speed;

        }

    }
    //@Override
    public void move(boolean boarder,int numX,int numY, int control, Board board){

        //predictive movement


        if(getNextTop()<0||getNextBottom()>(double)board.getHeight()){
            dy*=-1;
        }
        if(getNextLeft()<0||getNextRight()>(double)board.getWidth()){
            dx*=-1;
        }
        //if(other instanceof Player) {
        //    x = game.getPositionX() - (getWidth() / 2);
        //  y = game.getPositionY() - 25 - (getHeight() / 2);
        // }
        //else if(num<=0) {
        x += dx;
        y += dy;
        //}
    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,width,height);
    }
    public Rectangle getBoundsP(){
        return new Rectangle((int)(x+dx),(int)(y+dy),width,height);
    }
    public boolean collidesWithP(Sprite other){
        return getBoundsP().intersects(other.getBounds());
    }

    public boolean collidesWith(Sprite other){
        return getBounds().intersects(other.getBounds());
    }
    public boolean collidesWithNext(Sprite other,double x,double y,int width, int height){
        return getNextBounds(x,y,height,width).intersects(other.getBounds());
    }
    public abstract void paint(Graphics g);
    public Rectangle getNextBounds(double x,double y,int width, int height){
        return new Rectangle((int)x,(int)y,width,height);
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public boolean isCheck(Sprite other, Sprite other2){
        //((other.getNextLeft()<other2.getNextLeft()||other.getNextRight()>other2.getNextLeft())&&(other.getNextTop()<other2.getNextTop()&&other.getNextBottom()>other2.getNextBottom()))
        // ((other.getNextBottom()>other2.getNextTop()||other.getNextTop()<other2.getNextBottom())&&(other.getNextLeft()<other2.getNextLeft()&&other.getNextRight()>other2.getNextRight()))
        if((other.getNextLeft()<=other2.getNextRight()&&other.getNextLeft()>other2.getNextLeft()&&other2.getNextBottom()>=other.getNextTop()&&other.getNextTop()>=other2.getNextTop()-40)||(other.getNextRight()>=other2.getNextLeft()&&other.getNextRight()<other2.getNextRight()&&other.getNextBottom()>=other2.getNextTop()&&other.getNextBottom()<=other2.getNextBottom()-40)){
            check=false;
            System.out.println("hit");
        }
        //else if(check){
        //    check=true;
        //    System.out.println("miss");

        //}
        return check;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }
    public void setxP() {

    }
    public void setyP() {

    }
    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isRemove() {
        return remove;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public void setRemove() {
        this.remove = true;
    }

    public double getNextLeft() {
        nextLeft=x+dx;
        return nextLeft;
    }

    public double getNextRight() {
        nextRight=(x+width)+dx;
        return nextRight;
    }

    public double getNextTop() {
        nextTop=y+dy;
        return nextTop;
    }

    public double getNextBottom() {
        nextBottom=(y+height)+dy;
        return nextBottom;
    }

    public void setDx(double dx) {
        this.dx *= dx;
    }

    public void setDy(double dy) {
        this.dy *= dy;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
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
