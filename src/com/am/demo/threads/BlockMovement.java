package com.am.demo.threads;

import com.am.demo.panes.Field;
import com.am.demo.snake.Snake;
import com.am.demo.snake.SpeedRegulator;

public class BlockMovement implements Runnable
{
    private Field field;
    private String direction;
    static boolean masterThreadRunning= true;
    private boolean gamePlayRunning = true;
    private SpeedRegulator speedRegulator;
    private Snake snake;

    public BlockMovement(Field field, SpeedRegulator speedRegulator, Snake snake){
        this.field= field;
        this.speedRegulator= speedRegulator;
        this.snake= snake;
    }

    @Override
    public void run() {
        direction= "LEFT";
        while (gamePlayRunning) {
            switch (direction) {
                case "UP":
                    checkIsCrashed(field.isCrashed(), "UP");
                    break;
                case "DOWN":
                    checkIsCrashed(field.isCrashed(), "DOWN");
                    break;
                case "LEFT":
                    checkIsCrashed(field.isCrashed(), "LEFT");
                    break;
                case "RIGHT":
                    checkIsCrashed(field.isCrashed(), "RIGHT");
                    break;
            }
            field.eatBiteDiagnostic();
            try {
                speedRegulator.setSnakeLength(snake.getBlocks().size() - 1);
                System.out.println("REGULATOR: " + speedRegulator.regulator());
                Thread.sleep(speedRegulator.regulator());
            } catch (InterruptedException e) {
            }
        }

        System.out.println("GAME OVER");

    }
    public void setDirection(String direction){
        this.direction= direction;
    }

    private void checkIsCrashed(boolean isCrashed, String direction){
        if(isCrashed)
            gamePlayRunning = false;
        else
            field.update(direction);
    }
}
