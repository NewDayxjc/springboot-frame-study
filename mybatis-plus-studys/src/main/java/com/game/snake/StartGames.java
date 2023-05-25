package com.game.snake;

import javax.swing.*;

import javax.swing.*;
public class StartGames {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Greedy Snake");//绘制一个静态窗口
        jFrame.setBounds(10,10,900,720);//设置界面大小
        jFrame.setResizable(false);//窗口大小不可改变
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置窗口关闭事件
        jFrame.setVisible(true);//窗口显示
        jFrame.add(new GamePanel());//面板添加到窗口
    }
}
