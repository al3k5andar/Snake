package com.am.demo.listeners;

import com.am.demo.threads.BlockMovement;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class MyKeyListener implements EventHandler<KeyEvent>
{
    private BlockMovement blockMovement;

    public MyKeyListener(BlockMovement blockMovement){
        this.blockMovement = blockMovement;
    }

//    Key listener, set in which direction is snake going
    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()){
            case UP:
                blockMovement.setDirection("UP");
                break;
            case DOWN:
                blockMovement.setDirection("DOWN");
                break;
            case LEFT:
                blockMovement.setDirection("LEFT");
                break;
            case RIGHT:
                blockMovement.setDirection("RIGHT");
                break;
        }
    }

}
