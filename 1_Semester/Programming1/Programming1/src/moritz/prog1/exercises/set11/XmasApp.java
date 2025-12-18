package moritz.prog1.exercises.set11;

import rl.util.painttool.PaintTool;

/**
 * Starter for the Paint Demo Application.
 * 
 * @author Ruediger Lunde
 */
public class XmasApp {
	/**
	 * Starts the application by creating a {@link XmasController},
	 * providing it to the constructor of {@link PaintTool}, and then
	 * making the window visible.
	 */
	public static void main(String[] args) {
		PaintTool ptool = new PaintTool(new XmasController());
		ptool.setVisible(true);
	}
}
