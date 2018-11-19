public class Owl {

	private double bodyLength, wingLength, bodyWidth, wingWidth;
	private String type;
	
	public Owl(double bodyLength, double wingLength, double bodyWidth, double wingWidth, String type) {
		super();
		this.bodyLength = bodyLength;
		this.wingLength = wingLength;
		this.bodyWidth = bodyWidth;
		this.wingWidth = wingWidth;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBodyLength() {
		return bodyLength;
	}

	public void setBodyLength(double bodyLength) {
		this.bodyLength = bodyLength;
	}

	public double getWingLength() {
		return wingLength;
	}

	public void setWingLength(double wingLength) {
		this.wingLength = wingLength;
	}

	public double getBodyWidth() {
		return bodyWidth;
	}

	public void setBodyWidth(double bodyWidth) {
		this.bodyWidth = bodyWidth;
	}

	public double getWingWidth() {
		return wingWidth;
	}

	public void setWingWidth(double wingWidth) {
		this.wingWidth = wingWidth;
	}
	
	
}
