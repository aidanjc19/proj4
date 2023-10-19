import java.awt.Color;
import java.awt.Graphics;

public class Circle {

    private Color color;

    private double centerX;

    private double centerY;

    private double radius;

    public Circle(Color color, double centerX, double centerY, double radius) {
        setColor(color);
        setCenterX(centerX);
        setCenterY(centerY);
        setRadius(radius);
    }

    public Color getColor() {
        return color;
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }
    public double getRadius() {
        return radius;
    }

    public void setColor(Color color) {
        if (color == null) {
            throw new IllegalArgumentException("Color must not be null.");
        }
        this.color = color;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    public void setRadius(double radius) {
        if (centerX < 0) {
            throw new IllegalArgumentException("Radius must not be negative.");
        }
        this.radius = radius;
    }

    public void draw(Graphics graphics, int drawSize) {
        graphics.setColor(color);
        graphics.fillOval((int)(centerX - radius), (int)(centerY - radius),
                (int)(2 * radius), (int)(2 * radius));
    }

    public String toString() {
        return "Circle centered at (" + centerX + ", " + centerY + ") with radius " + radius +
                " and color java.awt.Color[r=" + color.getRed() + ", g=" + color.getGreen() +
                ", b=" + color.getBlue() + "]";
    }

    private static double cartesianXToGraphicsX(int drawWidth, double x) {

        return 999.9;
    }

    private static double cartesianYToGraphicsY(int drawHeight, double y) {
        return 999.9;
    }

}
