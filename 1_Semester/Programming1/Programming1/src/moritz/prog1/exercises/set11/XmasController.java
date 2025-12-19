package moritz.prog1.exercises.set11;

import rl.util.painttool.AbstractController;
import rl.util.painttool.DrawableObject;
import rl.util.painttool.PaintTool;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * This class implements a controller for the Paint Tool. Its main purpose is to
 * demonstrate some of the features of the Paint Tool.
 * 
 * @author Ruediger Lunde
 * 
 */
public class XmasController extends AbstractController {

	/** Returns "Paint Demo". */
	@Override
	public String getTitle() {
		return "Xmas App";
	}

	/** Returns the names of three buttons. */
	@Override
	public String[] getButtonNames() {
		return new String[] { "Print Tree"};
	}

    private final Random rand = new Random();

    /**
	 * Depending on the button number, some random shapes are drawn, a red cross
	 * is popped up for some moments, or a dialog box is shown.
	 */
	@Override
	public void onButtonPressed(PaintTool ptool, int button) {
		int cWidth = ptool.getCanvas().getWidth();
		int cHeight = ptool.getCanvas().getHeight();
        if (button == 0) {
            ptool.clearCanvas();
            // Baum erstellen
            ptool.setColor(Color.GREEN);
            int xLeft = (int) (cWidth * 0.25);
            int xmiddle = (int) (cWidth * 0.5);
            int xRight = (int) (cWidth * 0.75);
            int yLeft = (int) (cHeight * 0.9);
            int yMiddle = (int) (cHeight * 0.1);
            int yRight = (int) (cHeight * 0.9);
            int[] xCoord = {xLeft, xmiddle, xRight};
            int[] yCoord = {yLeft, yMiddle, yRight};
            ptool.addPolygon(xCoord, yCoord, true);

            // Baumstumpf erstellen
            Color brown = new Color(165, 42, 42);
            ptool.setColor(brown);
            int treeStumpX = (int) (cWidth * 0.475);
            int treeStumpY = (int) (cHeight * 0.9);
            int treeStumpWidth = (int) (cWidth * 0.05);
            int treeStumpHeight = (int) (cHeight * 0.05);
            ptool.addRectangle(treeStumpX, treeStumpY, treeStumpWidth, treeStumpHeight, true);

            // Kerzen erstellen
            int candleReactangleHeight = (int) (cHeight * 0.05);
            int candleReactangleWidth = (int) (cWidth * 0.025);
            int candleCircleRadius = (int) (candleReactangleWidth * 0.5 );
            int candleCircleX = (int ) (candleReactangleWidth * 0.5 );
            int candleCircleY = (int) (candleReactangleHeight * 0.5 );

            // Arrays zur Überprüfung ob Kerzen sich überlappen
            int[] candleX = new int[15];
            int[] candleY = new int[15];
            int candleCount = 0;

            // 15 Kerzen
            for (int i = 0; i < 15; i++) {
                int x, y;
                boolean overlaps;

                do {
                    x = rand.nextInt(xLeft, xRight);
                    y = rand.nextInt(yMiddle, yLeft);

                    // Punkt im Dreieck?
                    if (!isInsideTriangle(
                            x, y,
                            xLeft, yLeft,
                            xmiddle, yMiddle,
                            xRight, yRight)) {
                        overlaps = true;
                        continue;
                    }

                    overlaps = false;

                    // Überlappung mit vorhandenen Kerzen prüfen
                    for (int j = 0; j < candleCount; j++) {
                        if (rectanglesOverlap(
                                x, y,
                                candleReactangleWidth, candleReactangleHeight,
                                candleX[j], candleY[j],
                                candleReactangleWidth, candleReactangleHeight)) {
                            overlaps = true;
                            break;
                        }
                    }
                // solange bis es nicht mehr überlappt und innerhalb des Dreieckes ist
                } while (overlaps);

                // Position speichern
                candleX[candleCount] = x;
                candleY[candleCount] = y;
                candleCount++;

                // Kerze zeichnen
                ptool.setColor(Color.RED);
                ptool.addRectangle(
                        x, y,
                        candleReactangleWidth,
                        candleReactangleHeight,
                        true
                );
                ptool.setColor(Color.YELLOW);
                ptool.addCircle(x + candleCircleX , y - candleCircleY , candleCircleRadius, true);
            }
        }
	}

    // Prüft ob sich zwei Rechtecke überlappen
    private boolean rectanglesOverlap(
            int x1, int y1, int w1, int h1,
            int x2, int y2, int w2, int h2) {

        return x1 < x2 + w2 &&
                x1 + w1 > x2 &&
                y1 < y2 + h2 &&
                y1 + h1 > y2;
    }

    // Prüft ob der Punkt (px, py) im Dreieck liegt
    private boolean isInsideTriangle(
            int px, int py,
            int ax, int ay,
            int bx, int by,
            int cx, int cy) {

        int d1 = sign(px, py, ax, ay, bx, by);
        int d2 = sign(px, py, bx, by, cx, cy);
        int d3 = sign(px, py, cx, cy, ax, ay);
        // true wenn alle Vorzeichen gleich sind
        return !((d1 < 0 || d2 < 0 || d3 < 0) &&
                (d1 > 0 || d2 > 0 || d3 > 0));
    }

    // Berechnet ein Vorzeichen für zwei Vektoren (Kreuzprodukt)
    private int sign(int px, int py, int ax, int ay, int bx, int by) {
        return (px - bx) * (ay - by) - (ax - bx) * (py - by);
    }
}
