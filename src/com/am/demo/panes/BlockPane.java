package com.am.demo.panes;

import com.am.demo.Main;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class BlockPane extends Pane
{
//    Create a single block for snake
    public BlockPane(int x, int y){
        this.setPrefWidth(Main.blockSize);
        this.setPrefHeight(Main.blockSize);
        this.setBackground(new Background(new BackgroundFill(Color.BLACK,null,null)));
        this.setBorder(new Border(new BorderStroke(Color.RED,BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
    }

}
