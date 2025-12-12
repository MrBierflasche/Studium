package moritz.prog1.exercises.set10;

public class Vector2D {
    double x;
    double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    /**
     * Multiplies the elements of this vector with scalar factor and
     * returns the result. The vector is not changed by this operation!
     */
    public Vector2D mult(double factor) {
        return new Vector2D(this.x * factor, this.y * factor);
    }

    /**
     * Adds this vector and vec and returns the result.
     * Input vectors are not changed.
     */
    public Vector2D plus(Vector2D vec) {
        return new Vector2D(this.x + vec.x, this.y + vec.y);
    }

    /**
     * Subtracts vec from this vector and returns the result.
     * Input vectors are not changed.
     */
    public Vector2D minus(Vector2D vec) {
        return new Vector2D(this.x - vec.x, this.y - vec.y);
    }

    /**
     * Rotates this vector by deg degrees and returns the result.
     */
    public Vector2D rotate(int deg) {
        double rad = Math.toRadians(deg);            // Umrechnung in Bogenmaß
        double cos = Math.cos(rad);
        double sin = Math.sin(rad);

        double newX = this.x * cos - this.y * sin;   // Rotationsmatrix
        double newY = this.x * sin + this.y * cos;

        return new Vector2D(newX, newY);
    }

    /** Returns the Euclidean norm of this vector. */
    public double vlength() {
        return Math.sqrt(x * x + y * y);
    }
}
