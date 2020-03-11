import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.util.ArrayList;

public class Board extends JPanel implements ActionListener{
    Game game;
    long moment;
    long nextMoment,currentTime,timePressed,currentTime2,timePressed3,timePressed2;
    Timer timer;
    ArrayList<Sprite>actors;
    Color[] colors;
    int num=0,num2=0,control=4,lControl=0,eControl=2,elControl=0,num3 = 0;;
    boolean stop=true, stop2=true;
    public Board(Game game){
        this.game = game;
        setPreferredSize(new Dimension(1000, 800));
        setBackground(Color.BLACK);
    }





    public void setup(){
        timePressed2=System.currentTimeMillis();

        colors = new Color[]{Color.RED,Color.pink,Color.ORANGE,Color.CYAN};
        actors = new ArrayList<>();
        actors.add(new Player(Color.YELLOW,getWidth()/2-20,getHeight()/2+65,40,40,this, game));
        for(int i=0; i<STATS.getNumFood();i++){
            actors.add(new Food(Color.ORANGE,(int)(Math.random()*(getWidth()-25)+25),(int)(Math.random()*(getHeight()-25)+25),25,25,this));
        }

        actors.add(new Boarder(Color.blue,0,0,getWidth(),25,this));
        actors.add(new Boarder(Color.blue,0,0,25,(getHeight()/2)-30,this));
        actors.add(new Boarder(Color.blue,getWidth()-25,0,25,(getHeight()/2)-30,this));
        actors.add(new Boarder(Color.blue,0,(getHeight()/2)+30,25,(getHeight()/2)-12,this));
        actors.add(new Boarder(Color.blue,getWidth()-25,(getHeight()/2)+30,25,(getHeight()/2)-12,this));
        actors.add(new Boarder(Color.blue,0,(getHeight()/2)+30,190,98,this));
        actors.add(new Boarder(Color.blue,0,(getHeight()/2)-130,190,100,this));
        actors.add(new Boarder(Color.blue,getWidth()-190,(getHeight()/2)+30,190,95,this));
        actors.add(new Boarder(Color.blue,getWidth()-190,(getHeight()/2)-130,190,100,this));
        actors.add(new Boarder(Color.blue,getWidth()/2-12,0,25,150,this));
        actors.add(new Boarder(Color.blue,0,getHeight()-25,getWidth(),25,this));
        actors.add(new Boarder(Color.blue,0,(getHeight()/2)+238,90,30,this));
        actors.add(new Boarder(Color.blue,70,(getHeight()/2)+173,118,20,this));
        actors.add(new Boarder(Color.blue,190-52,(getHeight()/2)+173,50,95,this));
        actors.add(new Boarder(Color.blue,375,335,250,115,this));
        actors.add(new Boarder(Color.blue,70,713,305,18,this));
        actors.add(new Boarder(Color.blue,282-12,640,25,91,this));
        actors.add(new Boarder(Color.blue,270,573,105,22,this));
        actors.add(new Boarder(Color.blue,270,430,25,95,this));
        actors.add(new Boarder(Color.blue,270,197,25,173,this));
        actors.add(new Boarder(Color.blue,270,268,105,22,this));
        actors.add(new Boarder(Color.blue,270,71,105,79,this));
        actors.add(new Boarder(Color.blue,85,71,105,79,this));
        actors.add(new Boarder(Color.blue,85,195,105,30,this));
        actors.add(new Boarder(Color.blue,1000-90,(getHeight()/2)+238,90,30,this));
        actors.add(new Boarder(Color.blue,1000-(70+118),(getHeight()/2)+173,118,20,this));
        actors.add(new Boarder(Color.blue,1000-(190-52+50),(getHeight()/2)+173,50,95,this));
        actors.add(new Boarder(Color.blue,1000-(375+250),335,250,115,this));
        actors.add(new Boarder(Color.blue,1000-(70+305),713,305,18,this));
        actors.add(new Boarder(Color.blue,1000-(282-12+25),640,25,91,this));
        actors.add(new Boarder(Color.blue,1000-(270+105),573,105,22,this));
        actors.add(new Boarder(Color.blue,1000-(270+25),430,25,95,this));
        actors.add(new Boarder(Color.blue,1000-(270+25),197,25,173,this));
        actors.add(new Boarder(Color.blue,1000-(270+105),268,105,22,this));
        actors.add(new Boarder(Color.blue,1000-(270+105),71,105,79,this));
        actors.add(new Boarder(Color.blue,1000-(85+105),71,105,79,this));
        actors.add(new Boarder(Color.blue,1000-(85+105),195,105,30,this));
        actors.add(new Boarder(Color.blue,375,195,250,20,this));
        actors.add(new Boarder(Color.blue,475,195,50,90,this));
        actors.add(new Boarder(Color.blue,375,507,250,20,this));
        actors.add(new Boarder(Color.blue,475,507,50,88,this));
        actors.add(new Boarder(Color.blue,375,640,250,25,this));
        actors.add(new Boarder(Color.blue,475,640,50,86,this));



        timer = new Timer(1000/70,this);
        timer.start();
    }

    public void checkCollisions(){
        nextMoment = System.currentTimeMillis();
        currentTime2=System.currentTimeMillis();
        for(int i = 1; i < actors.size(); i++){

            if(actors.get(i) instanceof Enemy) {//||actors.get(i) instanceof Boarder){
                for (int j = 0; j < actors.size(); j++) {
                    if (actors.get(j) instanceof Boarder) {
                        if (actors.get(i).collidesWith(actors.get(j))) {
                            //if(nextMoment-timePressed2>50){
                            //  if(eControl!=elControl){
                            //    elControl=eControl;
                            //}
                            //}
                            actors.get(i).setX((int) (actors.get(i).getX() - actors.get(i).getDx()));
                            actors.get(i).setY((int) (actors.get(i).getY() - actors.get(i).getDy()));
                            actors.get(i).setDx(0);
                            actors.get(i).setDy(0);
                            if(currentTime2-timePressed3<100){
                                actors.get(i).seteControl(actors.get(i).getElControl());
                            }
                            else {

                                actors.get(i).setElControl(actors.get(i).geteControl());
                                //System.out.println(elControl);
                                //if(nextMoment-timePressed<40){
                                //  eControl=elControl;
                                //System.out.println(control);
                                // }
                                if (actors.get(i).geteControl() == actors.get(i).getElControl()) {
                                    actors.get(i).seteControl((int) (Math.random() * 5 - 1));
                                    timePressed2 = System.currentTimeMillis();
                                    // System.out.println(eControl);
                                }
                            }
                            stop2 = false;
                        }
                    }
                }
            }
            else if(actors.get(0).collidesWith(actors.get(i))){
                System.out.println((int)(actors.get(0).getX()-(actors.get(0).getDx()*2)));
                if(control==0) {
                    actors.get(0).setX((int) ((actors.get(0).getX() + 0) - (actors.get(0).getDx() * 2)));
                    actors.get(0).setY((int) (actors.get(0).getY() - (actors.get(0).getDy() * 2)));
                }
                if(control==1) {
                    actors.get(0).setX((int) (actors.get(0).getX() - (actors.get(0).getDx() * 2)));
                    actors.get(0).setY((int) ((actors.get(0).getY()+0)- (actors.get(0).getDy() * 2)));
                }
                if(control==2) {
                    actors.get(0).setX((int) ((actors.get(0).getX() - 0) - (actors.get(0).getDx() * 2)));
                    actors.get(0).setY((int) (actors.get(0).getY() - (actors.get(0).getDy() * 2)));
                }
                if(control==3) {
                    actors.get(0).setX((int) ((actors.get(0).getX()) -(actors.get(0).getDx() * 2)));
                    actors.get(0).setY((int) ((actors.get(0).getY()-0) - (actors.get(0).getDy() * 2)));
                }
                actors.get(0).setxP();
                actors.get(0).setyP();

                actors.get(0).setDx(0);
                actors.get(0).setDy(0);
                if(nextMoment-timePressed<40){
                    control=lControl;
                    //System.out.println(control);
                }
                else {
                    control = 4;
                    stop = false;
                }
            }
        }

        for(int i = 1; i < actors.size(); i++) {
            if (actors.get(0).collidesWithP(actors.get(i))) {

            }
        }
        for(int i = actors.size()-1; i >= 0; i--){
            if(actors.get(i).isRemove()){
                actors.remove(i);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        nextMoment = System.currentTimeMillis();
        checkCollisions();

        for (int j = 0; j < actors.size(); j++) {
            if (actors.get(j) instanceof Enemy) {
                ;
                //System.out.println("i happen");
            }
        }
        //System.out.println(num3);
        //System.out.println(num3 < STATS.getNumEnemies());
        if (num3 < STATS.getNumEnemies() && nextMoment - timePressed2 > ((int) ((Math.random() * 4000) + 1000))) {
            int num4 = (int) ((Math.random() * 2 + 1));

            if (num4 == 1) {

                actors.add(new Enemy(colors[num3], -40, 380, 50, 50, this));
                timePressed2 = System.currentTimeMillis();
                num3 += 1;
                //actors.get(actors.size()).seteControl(2);
            }
            if (num4 == 2) {

                actors.add(new Enemy(colors[num3], 999, 380, 50, 50, this));
                timePressed2 = System.currentTimeMillis();
                num3 += 1;
                actors.get(actors.size()-1).seteControl(0);

            }
        }
        if(num3 > STATS.getNumEnemies() &&nextMoment-timePressed3>((int) ((Math.random() * 4000) + 2000))){
            for(int i = 1; i < actors.size(); i++) {

                if (actors.get(i) instanceof Enemy) {
                    actors.get(i).setElControl(actors.get(i).geteControl());
                    // System.out.println(elControl);
                    //if(nextMoment-timePressed<40){
                    //  eControl=elControl;
                    //System.out.println(control);
                    // }
                    if (actors.get(i).geteControl() == actors.get(i).getElControl()) {
                        actors.get(i).seteControl((int) (Math.random() * 5 - 1));
                        timePressed3=System.currentTimeMillis();
                        // System.out.println(eControl);
                    }
                }
            }
        }

        // long currentTime
        for (int i = 0; i < actors.size(); i++) {
            int x;
            int y;
            if (!(actors.get(i) instanceof Boarder)) {
                for (int j = 0; j < actors.size(); j++) {
                    if(nextMoment-timePressed>40){
                        if(control!=lControl){
                            lControl=control;
                        }
                    }

                    // int control=4;
                    if (game.isUp()) {
                        timePressed=System.currentTimeMillis();


                        control = 1;
                    }
                    if (game.isDown()) {
                        timePressed=System.currentTimeMillis();

                        control = 3;
                    }
                    if (game.isRight()) {
                        timePressed=System.currentTimeMillis();

                        control = 2;
                    }
                    if (game.isLeft()) {
                        timePressed=System.currentTimeMillis();

                        control = 0;
                    }
                    if (nextMoment - currentTime >= 1) {//&&(game.isLeft()||game.isRight()||game.isUp()||game.isDown())) {

                        if (num2 == 0) {
                            actors.get(i).move(stop,num, num, control,this);
                            num++;
                            if (num == 20) {
                                num2++;
                            }
                        }
                        if (num2 == 1) {
                            actors.get(i).move(stop, num, num, control,this);
                            num--;
                            if (num == 0) {
                                num2--;
                            }
                        }
                        stop=true;
                        currentTime = System.currentTimeMillis();
                    }
                }

                if (!(actors.get(i) instanceof Player)) {
                    actors.get(i).move(stop2, 0, 0, actors.get(i).geteControl(),this);
                    stop2=true;
                }
            }




        }
        if (actors.size() <= STATS.getNumEnemies() + 1) {
        }
        repaint();
    }


    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        for(Sprite thisGuy: actors){
            thisGuy.paint(g);
        }

    }

    public void setControl(int control) {
        this.control = control;
    }
}