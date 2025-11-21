package moritz.prog1.exercises.set08;

import rl.util.painttool.AbstractController;
import rl.util.painttool.DrawableObject;
import rl.util.painttool.PaintTool;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

/**
 * This class implements a controller for the Paint Tool. Its main purpose is to
 * demonstrate some of the features of the Paint Tool.
 * 
 * @author Ruediger Lunde
 * 
 */
public class MyPaintDemoController extends AbstractController {

    private final List<Point> points = new ArrayList<>();
    private LeastSquaresEstimator estimator;


    /** Returns "Paint Demo". */
	@Override
	public String getTitle() {
		return "Linear Regression Paint Demo";
	}

	/** Returns the names of three buttons. */
	@Override
	public String[] getButtonNames() {
		return new String[] { "Perform Linear Regression"};
	}

	/**
	 * Depending on the button number, some random shapes are drawn, a red cross
	 * is popped up for some moments, or a dialog box is shown.
	 */
	@Override
	public void onButtonPressed(PaintTool ptool, int button) {
        switch (button) {
            case -1: // Clear-Button
                ptool.clearCanvas();
                points.clear();
                break;

            case 0:
                if (points.size() >= 2) {
                    LeastSquaresEstimator estimator = new LeastSquaresEstimator(
                            points.toArray(new Point[0])
                    );
                    int width = ptool.getCanvas().getWidth();
                    double y1 = estimator.predictY(0); // y-Koordinate auf der Geraden bei X = 0 => Startpunkt
                    double y2 = estimator.predictY(width); // y bei rechte Seite des Canvas => Endpunkt

                    ptool.setColor(Color.BLUE);
                    ptool.addLine(0, (int) y1, width, (int) y2);
                }
                break;
        }
	}

	/**
	 * Prints a text on the canvas at the point where the click was done. It
	 * describes the state of the mouse.
	 */
	@Override
	public void onMouseClick(PaintTool ptool, int x, int y, int mouseButton,
			boolean isShiftDown, boolean isControlDown) {
		ptool.setColor(Color.RED);
        ptool.addCircle(x, y, 5, true);
        points.add(new Point(x, y));
    }
}
