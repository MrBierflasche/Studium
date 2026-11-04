package blatt04;

/** Represents a photo with filename and contrast category*/
public class Photo {
	private String filename;
	private Contrast contrast;
	
	public Photo(Contrast contrast, String filename) {
		this.contrast = contrast;
		this.filename = filename;
	}
	
	public String toString() {
		return filename + " (" + contrast + ")";
	}

	public Contrast getContrast() {
		return contrast;
	}

	public String getFilename() {
		return filename;
	}
	
	
}