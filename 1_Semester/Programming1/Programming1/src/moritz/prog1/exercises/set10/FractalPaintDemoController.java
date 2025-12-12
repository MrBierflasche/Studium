package moritz.prog1.exercises.set10;

import rl.util.painttool.AbstractController;
import rl.util.painttool.DrawableObject;
import rl.util.painttool.PaintTool;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Vector;

/**
 * This class implements a controller for the Paint Tool. Its main purpose is to
 * demonstrate some of the features of the Paint Tool.
 * 
 * @author Ruediger Lunde
 * 
 */
public class FractalPaintDemoController extends AbstractController {

	/** Returns "Paint Demo". */
	@Override
	public String getTitle() {
		return "Fractal Demo";
	}

	/** Returns the names of three buttons. */
	@Override
	public String[] getButtonNames() {
		return new String[] { "30 Deg", "42 Deg", "45 Deg", "Random Deg", "Depth 1", "Depth 5", "Depth 10", "Depth 20", "Simple Fractal1", "Simple Fractal2", "Pythagoras Tree" };
	}
    // Standard Werte
    private int degree = 30;
    private int maxDepth = 10;
    private PaintTool ptool;

	/**
	 * Depending on the button number, some random shapes are drawn, a red cross
	 * is popped up for some moments, or a dialog box is shown.
	 */
	@Override
	public void onButtonPressed(PaintTool ptool, int button) {
        if(this.ptool == null){
            this.ptool = ptool;
        }
		switch (button) {
		case 0:
			this.setDegree(30);
			break;
		case 1:
			this.setDegree(42);
			break;
        case 2:
            this.setDegree(45);
            break;
        case 3:
            Random rand = new Random();
            this.setDegree(rand.nextInt(0, 90));
            break;
        case 4:
            this.setMaxDepth(1);
            break;
        case 5:
            this.setMaxDepth(5);
            break;
        case 6:
            this.setMaxDepth(10);
            break;
        case 7:
            this.setMaxDepth(20);
            break;
        case 8:
            ptool.clearCanvas();
            ptool.setColor(Color.BLACK);
            ptool.addText(10, 20, "Max Depth: " + this.maxDepth);
            simpleFractal();
            break;
        case 9:
            ptool.clearCanvas();
            ptool.setColor(Color.BLACK);
            ptool.addText(10, 20, "Max Depth: " + this.maxDepth);
            simpleFractal2();
            break;
        case 10:
            ptool.clearCanvas();
            ptool.setColor(Color.BLACK);
            ptool.addText(10, 20, "Max Depth: " + this.maxDepth);
            phythagorasTree();
		}
	}

    private void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }
    private void phythagorasTree() {
        int width = ptool.getCanvas().getWidth();
        int height = ptool.getCanvas().getHeight();

        Vector2D a = new Vector2D(width * 0.5, height * 0.8);
        Vector2D b = new Vector2D(width * 0.6, height * 0.8);

        drawPythagorasTree(a, b, 0);
    }

    private void drawPythagorasTree(Vector2D a, Vector2D b, int depth) {
        if (depth >= this.maxDepth) {
            return;
        }

        Vector2D ab = b.minus(a); // Grundlinie
        double side = ab.vlength(); // Länge der Quadratseite
        Vector2D rotated = ab.rotate(-90); // Drehung des Grundlinienvektors (Bildschirm-Koordinaten: -90 Grad
        Vector2D normalized = rotated.mult(1.0 / side); // Normalisieren
        Vector2D heightVec = normalized.mult(side); // Auf Quadrat-Seitenlänge skalieren

        // Quadrateckpunkte
        Vector2D p0 = a;
        Vector2D p1 = b;
        Vector2D p2 = b.plus(heightVec);
        Vector2D p3 = a.plus(heightVec);

        // Farbe je nach Tiefe (immer grüner)
        Color color = getBrownToGreenColor(depth);
        ptool.setColor(color);
        // Quadrat zeichnen
        int[] xs = {(int)p0.getX(), (int)p1.getX(), (int)p2.getX(), (int)p3.getX()};
        int[] ys = {(int)p0.getY(), (int)p1.getY(), (int)p2.getY(), (int)p3.getY()};
        ptool.addPolygon(xs, ys, true);

        // Zwei neue Grundlinien berechnen
        // linke Seite
        Vector2D top = computeThirdPoint(p3, p2, degree);
        drawPythagorasTree(p3, top, depth + 1);

        // rechte Seite
        drawPythagorasTree(top, p2, depth + 1);
        ptool.sleep(10);
    }

    private Color getBrownToGreenColor(int depth) {
        // Startfarbe (braun)
        int rStart = 139;
        int gStart = 69;
        int bStart = 19;

        // Zielfarbe (grün)
        int rEnd = 0;
        int gEnd = 255;
        int bEnd = 0;

        // Mischfaktor abhängig von depth zw. 0 bis 1
        double t = Math.min(1.0, depth / 15.0);

        int r = (int)(rStart + t * (rEnd - rStart));
        int g = (int)(gStart + t * (gEnd - gStart));
        int b = (int)(bStart + t * (bEnd - bStart));

        return new Color(r, g, b);
    }

    private void simpleFractal2() {
        int cWidth = ptool.getCanvas().getWidth();
        int cHeight = ptool.getCanvas().getHeight();

        // Startpunkte der Grundlinie dynamisch anhand der Canvas-Größe
        Vector2D start = new Vector2D(cWidth * 0.2, cHeight * 0.8);
        Vector2D end = new Vector2D(cWidth * 0.8, cHeight * 0.8);

        // Nur die Grundlinie zeichnen
        if (this.maxDepth == 0){
            ptool.addLine((int)start.getX(), (int)start.getY(), (int)end.getX(), (int)end.getY());
            return;
        }
        drawFractalColored(start, end, 0);
    }

    private void drawFractalColored(Vector2D a, Vector2D b, int depth) {
        // Rekursion beenden
        if (depth >= this.maxDepth) {
            return;
        }

        Vector2D c = computeThirdPoint(a, b, this.degree);

        // Zwei Farben im Wechsel
        Color col = (depth % 2 == 0) ? Color.RED : Color.BLUE;
        ptool.setColor(col);

        // Dreieck ausfüllen
        int[] xCoord = {(int)a.getX(), (int)b.getX(), (int)c.getX()};
        int[] yCoord = {(int)a.getY(), (int)b.getY(), (int)c.getY()};
        ptool.addPolygon(xCoord, yCoord, true);

        // Rekursion
        drawFractalColored(a, c, depth + 1);
        drawFractalColored(c, b, depth + 1);
        ptool.sleep(10);
    }


    private void simpleFractal() {
        int cWidth = ptool.getCanvas().getWidth();
        int cHeight = ptool.getCanvas().getHeight();

        // Startpunkte der Grundlinie dynamisch anhand der Canvas-Größe
        Vector2D start = new Vector2D(cWidth * 0.2, cHeight * 0.8);
        Vector2D end = new Vector2D(cWidth * 0.8, cHeight * 0.8);

        // Nur die Grundlinie zeichnen
        if (this.maxDepth == 0){
            ptool.addLine((int)start.getX(), (int)start.getY(), (int)end.getX(), (int)end.getY());
            return;
        }
        drawFractal(start, end, 0);
    }

    private void drawFractal(Vector2D a, Vector2D b, int depth) {
        // Rekursion beenden
        if (depth >= this.maxDepth) {
            return;
        }

        // Nur die Grundlinie zeichnen
        if (this.maxDepth == 0){
            ptool.addLine((int)a.getX(), (int)a.getY(), (int)b.getX(), (int)b.getY());
            return;
        }
        // dritter Punkt, oben auf dem Dreieck
        Vector2D c = computeThirdPoint(a, b, this.degree);

        Color color = getColor(depth);
        ptool.setColor(color);

        // Linien zeichnen
        this.ptool.addLine((int)a.getX(), (int)a.getY(), (int)b.getX(), (int)b.getY()); // a -> b = Grundlinie
        this.ptool.addLine((int)b.getX(), (int)b.getY(), (int)c.getX(), (int)c.getY()); // rechte Kathete
        this.ptool.addLine((int)c.getX(), (int)c.getY(), (int)a.getX(), (int)a.getY()); // linke Kathete

        // Rekursive Aufrufe auf Katheten
        drawFractal(a, c, depth + 1);
        drawFractal( c, b, depth + 1);
        ptool.sleep(10);
    }

    // Farbe abhängig von Tiefe
    private Color getColor(int depth) {
        int r = (int)(255.0 * depth / this.maxDepth); // Rot-Anteil abhängig von Rekursionstiefe
        int g = (int)(255.0 * (this.maxDepth - depth) / this.maxDepth); // Grün-Anteil abhängig von Tiefe
        int bCol = 150; // Blau immer 150 -> mittleres blau
        return new Color(r, g, bCol);
    }

    private Vector2D computeThirdPoint(Vector2D a, Vector2D b, int angleDeg) {
        Vector2D ab = b.minus(a);                  // Differenzvektor => Vektor von a nach b (Grundlinie)
        double length = ab.vlength() * Math.sin(Math.toRadians(angleDeg)); // Höhe des Dreickes, Abstand von Punkt c zur Grundlinie
        Vector2D dir = ab.rotate(-angleDeg);       // Drehung - wegen Bildschirmkoordinatensystem
        double scale = length / dir.vlength();     // nach Drehung Vektor auf richtige Länge skalieren
        return a.plus(dir.mult(scale));            // dritter Punkt
    }

    private void setDegree(int degree) {
        this.degree = degree;
    }
}
