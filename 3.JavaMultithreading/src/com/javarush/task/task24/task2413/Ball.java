package com.javarush.task.task24.task2413;

/**
 * Ball class
 */
public class Ball extends BaseObject {
    // speed
    private double speed;
    // direction  (from 0 to 360 degrees)
    private double direction;

    // current direction vector | текущее значение вектора движения (dx,dy)
    private double dx;
    private double dy;

    // if an object is frozen or can move | заморожен ли объект или может двигаться
    private boolean isFrozen;

    public Ball(double x, double y, double speed, double direction) {
        super(x, y, 1);

        this.direction = direction;
        this.speed = speed;

        this.isFrozen = true;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDirection() {
        return direction;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    /**
     * Set new direction | Устанавливаем новое направление движения.
     * Calculate  new vector | Тут же вычисляем и новый вектор.
     * Такой подход удобно использовать при отскоках от стен.
     */
    void setDirection(double direction) {
        this.direction = direction;

        double angle = Math.toRadians(direction);
        dx = Math.cos(angle) * speed;
        dy = -Math.sin(angle) * speed;
    }

    /**
     * Draw on canvas
     */
    @Override
    void draw(Canvas canvas) {
        canvas.setPoint(x, y, 'O');
    }

    /**
     * Make one step.
     */
    public void move() {
        if (isFrozen) return;

        x += dx;
        y += dy;

        checkRebound(1, Arkanoid.game.getWidth(), 1, Arkanoid.game.getHeight() + 5);
    }

    /**
     * Check if the ball is out of the border
     * If so reflect it
     */
    void checkRebound(int minx, int maxx, int miny, int maxy) {
        if (x < minx) {
            x = minx + (minx - x);
            dx = -dx;
        }

        if (x > maxx) {
            x = maxx - (x - maxx);
            dx = -dx;
        }

        if (y < miny) {
            y = miny + (miny - y);
            dy = -dy;
        }

        if (y > maxy) {
            y = maxy - (y - maxy);
            dy = -dy;
        }
    }

    /**
     * Launch the ball.
     * isFrozen = false.
     * Vector recalculating | Пересчитываем вектор движения (dx,dy).
     */
    void start() {
        this.setDirection(direction);
        this.isFrozen = false;
    }
}
