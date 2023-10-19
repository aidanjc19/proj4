import java.awt.Color;
import java.awt.Graphics;

public class Sunflower {

    private final Color COLOR_CENTER = new Color(97, 54, 23);
    private final Color COLOR_PETALS = new Color(252, 206, 1);
    private final Color COLOR_BACKGROUND_TOP = new Color(218, 227, 243);
    private final Color COLOR_BACKGROUND_BOTTOM = new Color(143, 170, 220);
    private int drawingSize;
    private int centerRadius;
    private int petalCount;

    public Sunflower(int drawingSize, int centerRadius, int petalCount) {
        if (drawingSize < 1) {
            throw new IllegalArgumentException("Drawing size must not be less than 1");
        }
        this.drawingSize = drawingSize;
        this.centerRadius = centerRadius;
        this.petalCount = petalCount;

    }

    public void draw() {
        DrawingPanel dp = new DrawingPanel(drawingSize, drawingSize);
        Graphics graphics = dp.getGraphics();

        drawGradientBackground(graphics, drawingSize);

        int drawingCenter = (int)(drawingSize / 2.0);
        Circle center = new Circle(COLOR_CENTER, drawingCenter, drawingCenter, centerRadius);
        center.draw(graphics, drawingSize);

        double petalRadius = centerRadius / 2.0;
        double angleIncrement = 2 * Math.PI / petalCount;
        for (double angle = 0; angle <= 2 * Math.PI; angle += angleIncrement) {
            double petalCenterX = drawingCenter + (centerRadius + petalRadius) * Math.cos(angle);
            double petalCenterY = drawingCenter + (centerRadius + petalRadius) * Math.sin(angle);
            Circle petal = new Circle(COLOR_PETALS, petalCenterX, petalCenterY, petalRadius);
            petal.draw(graphics, drawingSize);
        }
    }

    public void drawGradientBackground(Graphics graphics, int drawingSize) {
        graphics.setColor(COLOR_BACKGROUND_TOP);
        double redIncrement = ((double)Math.max(COLOR_BACKGROUND_TOP.getRed(), COLOR_BACKGROUND_BOTTOM.getRed()) -
                                (double)Math.min(COLOR_BACKGROUND_TOP.getRed(), COLOR_BACKGROUND_BOTTOM.getRed()))
                                / drawingSize;
        double greenIncrement = ((double)Math.max(COLOR_BACKGROUND_TOP.getGreen(), COLOR_BACKGROUND_BOTTOM.getGreen()) -
                                (double)Math.min(COLOR_BACKGROUND_TOP.getGreen(), COLOR_BACKGROUND_BOTTOM.getGreen()))
                                / drawingSize;
        double blueIncrement = ((double)Math.max(COLOR_BACKGROUND_TOP.getBlue(), COLOR_BACKGROUND_BOTTOM.getBlue()) -
                                (double)Math.min(COLOR_BACKGROUND_TOP.getBlue(), COLOR_BACKGROUND_BOTTOM.getBlue()))
                                / drawingSize;
        if (COLOR_BACKGROUND_BOTTOM.getRed() > COLOR_BACKGROUND_TOP.getRed()) { redIncrement *= -1;}
        if (COLOR_BACKGROUND_BOTTOM.getGreen() > COLOR_BACKGROUND_TOP.getGreen()) { greenIncrement *= -1;}
        if (COLOR_BACKGROUND_BOTTOM.getBlue() > COLOR_BACKGROUND_TOP.getBlue()) { blueIncrement *= -1;}

        for (int line = 0; line < drawingSize; line++) {
            double tempColorRed = (double)COLOR_BACKGROUND_TOP.getRed() - line * redIncrement;
            double tempColorGreen = (double)COLOR_BACKGROUND_TOP.getGreen() - line * greenIncrement;
            double tempColorBlue = (double)COLOR_BACKGROUND_TOP.getBlue() - line * blueIncrement;

            if (COLOR_BACKGROUND_TOP.getRed() > COLOR_BACKGROUND_BOTTOM.getRed()) {

            }

            Color tempColor = new Color((int)tempColorRed, (int)tempColorGreen, (int)tempColorBlue);
            graphics.setColor(tempColor);
            graphics.drawLine(0, line, drawingSize - 1, line);

            System.out.println(tempColor);


        }



    }

    private void sleepHalfSecond() {

    }
}
