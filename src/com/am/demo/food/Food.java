package com.am.demo.food;

import com.am.demo.Main;
import com.am.demo.panes.Block;
import com.am.demo.panes.Field;
import com.am.demo.snake.Snake;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

import java.util.Random;

public class Food extends Block
{
    private int positionX;
    private int positionY;
    private Field field;
    private Snake snake;


    public Food(int x, int y, Field field, Snake snake) {
        super(x, y, null,field);
        positionX= x;
        positionY= y;
        this.field= field;
        this.snake= snake;
        super.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));

        setTranslateX(x * Main.blockSize);
        setTranslateY(y * Main.blockSize);
    }

    public void moveFood(){
        boolean loopStop= false;
        boolean isReserved;
        Random random= new Random();

        while(!loopStop){

            int posX= random.nextInt(field.getFieldWidth());
            int posY= random.nextInt(field.getFieldHeight());
            for(Block block: snake.getBlocks()){
                isReserved= isReservedPosition(posX, posY, block);
                if(isReserved) {
                    loopStop= false;
                    break;
                }
                else
                {
                    loopStop= true;
                    this.setPositionX(posX);
                    this.setPositionY(posY);
                }
            }
        }

        this.setTranslateX(this.getPositionX()* Main.blockSize);
        this.setTranslateY(this.getPositionY()* Main.blockSize);
    }

    private boolean isReservedPosition(int posX, int posY, Block block){
        return block.getPositionX()== posX && block.getPositionY()== posY;
    }


    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    @Override
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    @Override
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}
