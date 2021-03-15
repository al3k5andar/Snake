package com.am.demo.snake;

import com.am.demo.panes.Block;
import com.am.demo.panes.Field;

import java.util.ArrayList;
import java.util.List;

public class Snake
{
    private Field field;
    private List<Block> blocks= new ArrayList<>();
    private Block head;
    private int initialSize;

    public Snake(int initialSize, Field field) {
        this.field = field;
        this.initialSize= initialSize;
        int posX= field.getFieldWidth()/2;
        int posY= field.getFieldHeight()/2;

//        Create snake head
        head= new Block(posX, posY, null, field);
        blocks.add(head);
        Block previous= head;

//        Create the snake body
        for (int i = 1; i < initialSize; i++) {
            Block block= new Block(posX + i, posY, previous, field);
            blocks.add(block);
            previous= block;
        }
    }

    public void addBlockOnTheSnakeEnd(){
        Block last= blocks.get(blocks.size()-1);
        blocks.add(new Block(last.getOldPositionX(), last.getOldPositionY(),last, field));
    }

    public List<Block> getBlocks() {
        return blocks;
    }

}
