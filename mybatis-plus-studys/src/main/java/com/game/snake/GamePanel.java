package com.game.snake;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
//    int[] snakeX = new int[500];//贪吃蛇横坐标
//    int[] snakeY = new int[500];//贪吃蛇纵坐标
//    int foodX;//食物横坐标
//    int foodY;//食物蛇纵坐标
//    int length;//贪吃蛇的长度
//    String  direction;//贪吃蛇头方向
//    int score;//积分
//    Random r = new Random();
//    Timer timer = new Timer(100,this);
//    boolean isStart;
//    boolean isFail;
//    //构造函数
//    public GamePanel(){
//        init();
//        this.setFocusable(true);
//        this.addKeyListener(this);
//        timer.start();
//    }
//    private void init(){
//        length=3;
//        snakeX[0]=100;snakeY[0]=100;
//        snakeX[1]=75;snakeY[1]=100;
//        snakeX[2]=50;snakeY[2]=100;
//        direction = "R";
//        eat(foodX,foodY);
//        isStart = false;
//        isFail = false;
//        score = 0;
//
//    }
//    private void eat(int x,int y){
//        x= 25 + 25*r.nextInt(34);
//        y= 75 + 25*r.nextInt(24);
//        for (int i = 0; i < length; i++) {
//            if(snakeX[i]==x&&snakeY[i]==y){
//                x = 25 + 25*r.nextInt(34);
//                y = 75 + 25*r.nextInt(24);
//            }
//        }
//        foodX = x;foodY = y;
//    }
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        this.setBackground(Color.white);//设置背景板为白色
//        //画标题
//        g.setColor(Color.GREEN);
//        g.setFont(new Font("幼圆",Font.BOLD,50));
//        g.drawString("贪吃蛇游戏",300,60);
//        //绘制游戏区域
//        g.setColor(Color.GRAY);
//        g.fillRect(25,75,850,600);
//        //画贪吃蛇头部
//        if(direction=="R"){
//            Data.right.paintIcon(this,g,snakeX[0],snakeY[0]);
//        }
//        else if(direction=="L"){
//            Data.left.paintIcon(this,g,snakeX[0],snakeY[0]);
//        }
//        if(direction=="U"){
//            Data.up.paintIcon(this,g,snakeX[0],snakeY[0]);
//        }
//        else if(direction=="D"){
//            Data.down.paintIcon(this,g,snakeX[0],snakeY[0]);
//        }
//        //画身体
//        for (int i = 1; i < length ; i++) {
//            Data.body.paintIcon(this,g,snakeX[i],snakeY[i]);
//        }
//        //画食物
//        Data.food.paintIcon(this,g,foodX,foodY);
//        //绘制积分栏
//        g.setColor(Color.BLACK);
//        g.setFont(new Font("幼圆",Font.BOLD,20));
//        g.drawString("长度："+length,730,30);
//        g.drawString("得分："+score,730,60);
//        //游戏开始提醒
//        if(isStart==false){
//            g.setColor(Color.BLACK);
//            g.setFont(new Font("幼圆",Font.BOLD,40));
//            g.drawString("按空格键开始游戏",300,300);
//        }
//        //失败判断
//        if(isFail){
//            g.setColor(Color.RED);
//            g.setFont(new Font("幼圆",Font.BOLD,40));
//            g.drawString("游戏失败，按空格键重新开始",300,300);
//        }
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//        int keyCode = e.getKeyCode();//获取按下的按键
//        //判断空格
//        if(keyCode==KeyEvent.VK_SPACE){
//            if(isFail){
//                isFail = false;
//                init();
//            }
//            else{
//                isStart = !isStart;
//            }
//            repaint();
//        }
//        //判断方向
//        if(keyCode==KeyEvent.VK_LEFT&&direction!="R"){
//            direction = "L";
//        }
//        else if(keyCode==KeyEvent.VK_RIGHT&&direction!="L"){
//            direction = "R";
//        }
//        else if(keyCode==KeyEvent.VK_UP&&direction!="D"){
//            direction = "U";
//        }
//        else if(keyCode==KeyEvent.VK_DOWN&&direction!="U"){
//            direction = "D";
//        }
//    }
//    @Override
//    public void keyReleased(KeyEvent e) {
//
//    }
//    @Override
//    public void keyTyped(KeyEvent e) {
//    }
//
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        //判断游戏状态
//        if(isStart&&!isFail){
//            //移动身体
//            for (int i = length-1; i > 0 ; i--) {
//                snakeX[i] = snakeX[i-1];
//                snakeY[i] = snakeY[i-1];
//            }
//            //移动头部
//            if(direction=="R"){
//                snakeX[0] += 25;
//                if(snakeX[0]>850){
//                    snakeX[0] = 25;
//                }
//            }
//            else  if(direction=="L"){
//                snakeX[0] -= 25;
//                if(snakeX[0]<25){
//                    snakeX[0] = 850;
//                }
//            }
//            else  if(direction=="U"){
//                snakeY[0] -= 25;
//                if(snakeY[0]<75){
//                    snakeY[0] = 650;
//                }
//            }
//            else  if(direction=="D"){
//                snakeY[0] += 25;
//                if(snakeY[0]>650){
//                    snakeY[0] = 75;
//                }
//            }
//            //吃食物
//            if(snakeX[0]==foodX&&snakeY[0]==foodY){
//                length++;
//                score += 10;
//                eat(foodX,foodY);
//            }
//            //死亡判定
//            for (int i = 1; i < length; i++) {
//                if(snakeX[0]==snakeX[i]&&snakeY[0]==snakeY[i]){
//                    isFail=true;
//                }
//            }
//            repaint();
//        }
//        timer.start();
//    }

    int length;//蛇的长度
    int[] snakeX=new int[600];
    int[] snakeY=new int[500];//蛇的坐标
    String dir;//脑袋方向
    boolean isStart=false;
    Timer timer =new Timer(50,this);//定时器
    int foodX;int foodY;//定义食物坐标
    Random random=new Random();//随机数类
    boolean isFail=false;//死亡判断
    int score;//积分系统

    //构造器
    public GamePanel(){
        init();
        //获取键盘的监听事件
        this.setFocusable(true);//聚集键盘焦点在游戏界面
        this.addKeyListener(this);//添加监听
        timer.start();//令时间开始动起来
    }

    //初始化
    public void init(){
        length=3;
        snakeX[0]=100;snakeY[0]=100;//头部坐标
        snakeX[1]=snakeX[0]-25;snakeY[1]=snakeY[0];//第一节身体坐标
        snakeX[2]=snakeX[0]-50;snakeY[2]=snakeY[0];//第二节身体坐标
        dir="R";
        foodX=25+25*random.nextInt(34);
        foodY=75+25*random.nextInt(24);//食物随机坐标
        score=0;
    }

    //画板（画界面、画蛇）
    @Override
    protected void paintComponent(Graphics g) {         //Graphics：画笔
        super.paintComponent(g);//清屏
        this.setBackground(Color.darkGray);//设置背景颜色
//        Data.header.paintIcon(this,g,25,11);//绘制头部广告栏
        g.fillRect(25,75,850,600);//绘制游戏区域
        //绘制静态小蛇
        if (dir.equals("R")) {
            Data.right.paintIcon(this,g,snakeX[0],snakeY[0]);
        } else if (dir.equals("L")){
            Data.left.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if (dir.equals("U")){
            Data.up.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if (dir.equals("D")){
            Data.down.paintIcon(this,g,snakeX[0],snakeY[0]);
        }//脑袋(上下左右4个方向)
        for (int i = 1; i < length; i++) {
            Data.body.paintIcon(this,g,snakeX[i],snakeY[i]);
        }//通过循环绘制身体长度
        if(isStart==false){//游戏提示：是否开始
            g.setColor(Color.ORANGE); //设置画笔颜色
            g.setFont(new Font("黑体",Font.BOLD,40));//设置字体
            g.drawString("按下空格开始游戏",300,300);  //画一个文字
        }
        //绘制食物
        Data.food.paintIcon(this,g,foodX,foodY);
        //失败提醒
        if (isFail){
            g.setColor(Color.red); //设置画笔颜色
            g.setFont(new Font("楷体",Font.BOLD,40));//设置字体
            g.drawString("  游戏失败",335,300);  //画一个文字
            g.drawString("你的分数 "+score,333,350);
            g.drawString("按空格重新开始",310,400);
        }
        //积分
        g.setColor(Color.CYAN); //设置画笔颜色
        g.setFont(new Font("方正粗黑宋简体",Font.BOLD,20));//设置字体
        g.drawString("长度："+length,750,34);  //画一个文字
        g.drawString("分数："+score,750,59);
    }

    //接收键盘输入：监听
    @Override
    public void keyPressed(KeyEvent e) {   //键盘按下未释放
        int keyCode = e.getKeyCode();
        if(keyCode==KeyEvent.VK_SPACE){//空格键
            if (isFail){
                isFail=false;
                init();//重新初始化
            }else {//暂停游戏
                isStart=!isStart;
            }
            repaint();//刷新界面
        }
        if (keyCode==KeyEvent.VK_UP||keyCode==KeyEvent.VK_W){
            if (!dir.equals("D")){
                dir="U";
            }
        }else if (keyCode==KeyEvent.VK_DOWN||keyCode==KeyEvent.VK_S){
            if (!dir.equals("U")){
                dir="D";
            }
        }else if (keyCode==KeyEvent.VK_LEFT||keyCode==KeyEvent.VK_A){
            if (!dir.equals("R")){
                dir="L";
            }
        }else if (keyCode==KeyEvent.VK_RIGHT||keyCode==KeyEvent.VK_D) {
            if (!dir.equals("L")) {
                dir = "R";
            }
        }

    }

    //定时器，监听时间，帧：执行定时操作
    @Override
    public void actionPerformed(ActionEvent e) {
        if(isStart && isFail==false){//游戏处于开始状态并且游戏没有失败
            for (int i = length-1; i >0; i--) {
                snakeX[i]=snakeX[i-1];
                snakeY[i]=snakeY[i-1];//身体移动
            }
            if (dir.equals("R")) {
                snakeX[0]=snakeX[0]+25;//脑袋移动
                //if (snakeX[0]>850){snakeX[0]=25;}//边界判断
            } else if (dir.equals("L")){
                snakeX[0]=snakeX[0]-25;
                //if (snakeX[0]<25){snakeX[0]=850;}//边界判断
            } else if (dir.equals("U")){
                snakeY[0]=snakeY[0]-25;
                // if (snakeY[0]<75){snakeY[0]=650;}//边界判断
            } else if (dir.equals("D")){
                snakeY[0]=snakeY[0]+25;
                //if (snakeY[0]>650){snakeY[0]=75;}//边界判断
            }
            if (snakeX[0]>=850||snakeX[0]<=25||snakeY[0]<=75||snakeY[0]>=650){
                isFail=true;
            }//设定撞墙失败
            if (snakeX[0]==foodX&&snakeY[0]==foodY){//脑袋和食物坐标重合
                length++;//长度+1
                score+=10;
                foodX=25+25*random.nextInt(34);
                foodY=75+25*random.nextInt(24);//重新生成食物
            }
            //失败判断
            for (int j = 1; j < length; j++) {
                if (snakeX[j]==snakeX[0]&&snakeY[j]==snakeY[0]){
                    isFail=true;
                }
            }
            repaint();
        }
        timer.start();//令时间开始动起来
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }//键盘按下弹起
    @Override
    public void keyReleased(KeyEvent e) {
    }//键盘释放
}


