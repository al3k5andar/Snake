package com.am.demo.threads;

import com.am.demo.panes.Field;
import com.am.demo.snake.Snake;
import com.am.demo.snake.SpeedRegulator;

public class BlockMovement implements Runnable
{
    private Field field;
    private String direction;
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
//            If the snake head is on same position like food, eats the food, in other way continue further
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

//    Direction is set in MyKeyListener
    public void setDirection(String direction){
        this.direction= direction;
    }

//    If snake is crashed while loop in run method stops and program ends, on the other hand the game is continues
    private void checkIsCrashed(boolean isCrashed, String direction){
        if(isCrashed)
            gamePlayRunning = false;
        else
            field.update(direction);
    }
}
