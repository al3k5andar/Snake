package com.am.demo.snake;

public class SpeedRegulator
{
    private Snake snake;
    private int snakeLength;

    public SpeedRegulator(Snake snake) {
        this.snake = snake;
        snakeLength= snake.getBlocks().size()-1;
    }

//    Get snake speed
    public int regulator(){
        return countSpeed(this.getSnakeLength());
    }

//    Calculate the snake speed, speed is depend of the snake length and is calculated in milliseconds
    private int countSpeed(int snakeLength) {
        int speed= 160;
        if (snakeLength >= 10 && snakeLength < 13)
            speed= 150;
        else if(snakeLength >= 13 && snakeLength< 20)
            speed= 120;
        else if(snakeLength>= 20 && snakeLength< 31)
            speed= 100;
        else if (snakeLength>= 31 && snakeLength< 44)
            speed= 85;
        else if (snakeLength>= 44 && snakeLength< 57)
            speed= 70;
        else if (snakeLength>= 57 && snakeLength< 70)
            speed= 60;
        else if (snakeLength>= 70)
            speed= 50;
        return speed;
    }

    public int getSnakeLength() {
        return snakeLength;
    }

    public void setSnakeLength(int snakeLength) {
        this.snakeLength = snakeLength;
    }
}
