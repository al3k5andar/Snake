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
    private int blockCounter;
    private int initialSize;

    public Snake(int initialSize, Field field) {
        this.field = field;
        this.initialSize= initialSize;
        int posX= field.getFieldWidth()/2;
        int posY= field.getFieldHeight()/2;

        head= new Block(posX, posY, null, field);
        blocks.add(head);
        Block previous= head;

        for (int i = 1; i < initialSize; i++) {
            Block block= new Block(posX + i, posY, previous, field);
            blocks.add(block);
            previous= block;
        }
        blockCounter= blocks.size()-1;
    }

    public void updateSnake(){
        Block last= blocks.get(blocks.size()-1);
        blocks.add(new Block(last.getOldPositionX(), last.getOldPositionY(),last, field));
        blockCounter++;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public int getBlockCounter() {
        return blockCounter;
    }

    public int getInitialSize() {
        return initialSize;
    }
}
