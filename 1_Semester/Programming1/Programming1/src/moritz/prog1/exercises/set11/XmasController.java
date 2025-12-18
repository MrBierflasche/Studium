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

    private Random rand = new Random();

    /**
	 * Depending on the button number, some random shapes are drawn, a red cross
	 * is popped up for some moments, or a dialog box is shown.
	 */
	@Override
	public void onButtonPressed(PaintTool ptool, int button) {
		int cWidth = ptool.getCanvas().getWidth();
		int cHeight = ptool.getCanvas().getHeight();
		switch (button) {
		case 0:
			ptool.clearCanvas();
            // Baum erstellen
            ptool.setColor(Color.GREEN);
            int xLeft = (int) (cWidth * 0.25);
            int xmiddle = (int) (cWidth * 0.5);
            int xRight = (int) (cWidth * 0.75);
            int yLeft = (int) (cHeight * 0.9);
            int yMiddle = (int) (cHeight * 0.1);
            int yRight = (int) (cHeight * 0.9);
            int[] xCoord = { xLeft, xmiddle, xRight };
            int[] yCoord = {yLeft, yMiddle, yRight };
            ptool.addPolygon(xCoord, yCoord, true);

            // Baumstumpf
            Color brown = new Color(165, 42, 42);
            ptool.setColor(brown);
            int treeStumpX = (int) (cWidth * 0.475);
            int treeStumpY = (int) (cHeight * 0.9);
            int treeStumpWidth = (int) (cWidth * 0.05);
            int treeStumpHeight = (int) (cHeight * 0.05);
            ptool.addRectangle(treeStumpX, treeStumpY, treeStumpWidth, treeStumpHeight, true );

            // Kerzen
            int candleReactangleHeight = (int) (cHeight * 0.05);
            int candleReactangleWidth = (int) (cWidth * 0.025);
            int candleCircle;
            for(int i = 0; i < 15; i++) {
                ptool.setColor(Color.RED);
                ptool.addRectangle(rand.nextInt(xLeft , xRight),rand.nextInt(yMiddle , yLeft), candleReactangleWidth, candleReactangleHeight,true );
            }

			break;
		}
	}
}
