package moritz.prog1.exercises.set09;

import rl.util.painttool.PaintTool;

/**
 * Starter for the Paint Demo Application.
 * 
 * @author Ruediger Lunde
 */
public class SortPaintDemoApp {
	/**
	 * Starts the application by creating a {@link MySortingTool},
	 * providing it to the constructor of {@link PaintTool}, and then
	 * making the window visible.
	 */
	public static void main(String[] args) {
		PaintTool ptool = new PaintTool(new MySortingTool());
		ptool.setVisible(true);
	}
}
