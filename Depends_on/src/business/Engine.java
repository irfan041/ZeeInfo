package business;

public class Engine {
	private String modelyear;
	private Parts parts;
	Engine() {
		System.out.println("Engine Default Consructor");
	}
	public void setModelyear(String modelyear) {
		this.modelyear = modelyear;
	}

	public String getModelyear() {
		return modelyear;
	}

	public void setParts(Parts parts) {
		this.parts = parts;
	}
	public Parts getParts() {
		return parts;
	}
}
