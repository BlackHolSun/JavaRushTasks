package com.javarush.task.task24.task2413;

/**
 * Base class for all base objects
 */
public abstract class BaseObject {
    //coordinates
    protected double x;
    protected double y;
    //object radius
    protected double radius;

    protected BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Method to draw object on a canvas | Метод рисует свой объект на "канвасе".
     */
    abstract void draw(Canvas canvas);

    /**
     * make a move
     */
    abstract void move();

    /**
     * Check if (x, y) is inside borders | Проверяем - не выходит ли (x,y) за границы.
     */
    void checkBorders(double minx, double maxx, double miny, double maxy) {
        if (x < minx) x = minx;
        if (x > maxx) x = maxx;
        if (y < miny) y = miny;
        if (y > maxy) y = maxy;
    }

    /**
     * Check passed object (o) and (this) objects intersection | Проверяем - пересекаются ли переданный(o) и наш(this) объекты.
     */
    boolean isIntersec(BaseObject o) {
        double dx = x - o.x;
        double dy = y - o.y;
        double destination = Math.sqrt(dx * dx + dy * dy);
        double destination2 = Math.max(radius, o.radius);
        return destination <= destination2;
    }
}
