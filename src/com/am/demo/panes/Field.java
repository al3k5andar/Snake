package com.am.demo.panes;

import com.am.demo.Main;
import com.am.demo.food.Food;
import com.am.demo.snake.Snake;
import javafx.application.Platform;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Field extends Pane
{
    private int fieldWidth;
    private int fieldHeight;
    private List<Block> blocks= new ArrayList<>();
    private boolean isCrashed= false;

    private Snake snake;
    private Food food;

    public Field(int width, int height){
        this.fieldWidth= width;
        this.fieldHeight= height;
        this.setMinSize(fieldWidth* Main.blockSize, fieldHeight * Main.blockSize);
        this.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
    }

    public void addSnake(Snake snake){
        this.snake= snake;
        for(Block block: snake.getBlocks())
            this.addSnakeBlocks(block);
    }

    private void addSnakeBlocks(Block block){
        blocks.add(block);
        this.getChildren().add(block);
    }

    public void update(String direction){
        if(!isCrashed) {
            for (Block block : blocks) {
                isCrashed = snakeCrash();
                block.update(direction);
            }
        }
    }

    public boolean snakeCrash(){
        Block head= blocks.get(0);

        for (int i = 1; i < blocks.size(); i++) {
            Block block= blocks.get(i);
            if(head.getPositionX()== block.getPositionX() && head.getPositionY()== block.getPositionY()) {
                System.out.println("Contact");
                return true;
            }
        }
        return false;
    }

    public void addFood(Food food){
        this.food= food;
        this.getChildren().add(food);
    }

    public void blockUpdate(){
        Block last= snake.getBlocks().get(snake.getBlocks().size()-1);
        blocks.add(last);
        this.getChildren().add(last);
    }



    public void eatBiteDiagnostic(){
        Block head= blocks.get(0);
        Field field= this;
        if(head.getPositionX()== food.getPositionX() && head.getPositionY()== food.getPositionY())
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    food.moveFood();
                    snake.updateSnake();
                    field.blockUpdate();
                }
            });
    }



    public int getFieldWidth() {
        return fieldWidth;
    }

    public int getFieldHeight() {
        return fieldHeight;
    }

    public Snake getSnake() {
        return snake;
    }

    public boolean isCrashed() {
        return isCrashed;
    }
}
