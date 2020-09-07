package com.am.demo.threads;

import com.am.demo.panes.Field;

public class BlockMovement implements Runnable
{
    private Field field;
    private String direction;
    boolean threadRunning= true;

    public BlockMovement(Field field){
        this.field= field;
    }

    @Override
    public void run() {
        direction= "LEFT";
        while (threadRunning){
            switch (direction){
                case "UP":
                    checkIsCrashed(field.isCrashed(),"UP");
                    break;
                case "DOWN":
                    checkIsCrashed(field.isCrashed(),"DOWN");
                    break;
                case "LEFT":
                    checkIsCrashed(field.isCrashed(),"LEFT");
                    break;
                case "RIGHT":
                    checkIsCrashed(field.isCrashed(),"RIGHT");
                    break;
            }
            field.eatBiteDiagnostic();
            try{
                Thread.sleep(100);
            }
            catch (InterruptedException e){}
        }
        System.out.println("GAME OVER");
    }
    public void setDirection(String direction){
        this.direction= direction;
    }

    private void checkIsCrashed(boolean isCrashed, String direction){
        if(isCrashed)
            threadRunning= false;
        else
            field.update(direction);
    }
}
