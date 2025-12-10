package moritz.prog1.exercises.set10;

import rl.util.painttool.PaintTool;

/**
 * Starter for the Paint Demo Application.
 * 
 * @author Ruediger Lunde
 */
public class FractalPaintDemoApp {
	/**
	 * Starts the application by creating a {@link FractalPaintDemoController},
	 * providing it to the constructor of {@link PaintTool}, and then
	 * making the window visible.
	 */
	public static void main(String[] args) {
		PaintTool ptool = new PaintTool(new FractalPaintDemoController());
		ptool.setVisible(true);
	}
}
