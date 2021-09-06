package ru.job4j.tracker.oop;

public class BallStory {
    public static void main(String[] args) {
        Hare hare = new Hare();
        Fox fox = new Fox();
        Wolf wolf = new Wolf();
        Ball ball = new Ball();
        Hare.tryEat(ball);
        Ball.sings(hare);
        Wolf.tryEat(ball);
        Ball.sings(wolf);
        Fox.tryEat(ball);
        Ball.sings(fox);
        Fox.ate(ball);
    }
}
