package com.am.demo.panes;

import com.am.demo.Main;

public class Block extends BlockPane
{
    private int positionX;
    private int positionY;
    private Block previous;
    private Field field;
    private int oldPositionX;
    private int oldPositionY;
    private String inverseDirection= "RIGHT";

    public Block(int positionX, int positionY, Block previous, Field field){
        super(positionX, positionY);
        this.positionX= positionX;
        this.positionY= positionY;
        this.previous= previous;
        this.field= field;

        this.setTranslateX(positionX * Main.blockSize);
        this.setTranslateY(positionY * Main.blockSize);
    }

    public void update(String direction){
        oldPositionX= positionX;
        oldPositionY= positionY;

        if(this.getPrevious()== null){
            switch (direction){
                case "UP":
                    if(inverseDirection.equals(direction)) {
                        goDown();
                        break;
                    }
                    else
                        goUp();
                    break;
                case "DOWN":
                    if(inverseDirection.equals(direction)) {
                        goUp();
                        break;
                    }
                    else
                        goDown();
                    break;
                case "LEFT":
                    if(inverseDirection.equals(direction)) {
                        goRight();
                        break;
                    }
                    else
                        goLeft();
                    break;
                case "RIGHT":
                    if(inverseDirection.equals(direction)) {
                        goLeft();
                        break;
                    }
                    else
                        goRight();
                    break;
            }
        }
        else {
            this.setPositionX(previous.oldPositionX);
            this.setPositionY(previous.oldPositionY);
            System.out.println("Other: "+ this.getPositionX()+" / "+ this.getPositionY());
        }
        setTranslation(this.getPositionX(), this.getPositionY());
    }

    private void setTranslation(int x, int y){
        this.setTranslateX((x * Main.blockSize));
        this.setTranslateY((y * Main.blockSize));
    }

    public void goLeft(){
        inverseDirection= "RIGHT";
        this.setPositionX(this.getPositionX()- 1);
        if(this.getPositionX()< 0)
            this.setPositionX(field.getFieldWidth()-1);
    }
    public void goRight(){
        inverseDirection= "LEFT";
        this.setPositionX(this.getPositionX() + 1);
        if(this.getPositionX()> field.getFieldWidth()-1)
            this.setPositionX(0);
    }
    public void goUp(){
        inverseDirection= "DOWN";
        this.setPositionY(this.getPositionY()- 1);
        if(this.getPositionY()< 0){
            this.setPositionY(field.getFieldHeight()-1);
        }
    }
    public void goDown(){
        inverseDirection= "UP";
        this.setPositionY(this.getPositionY()+ 1);
        if(this.getPositionY()> field.getFieldHeight()-1)
            this.setPositionY(0);
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public Block getPrevious() {
        return previous;
    }

    public void setPrevious(Block previous) {
        this.previous = previous;
    }

}
