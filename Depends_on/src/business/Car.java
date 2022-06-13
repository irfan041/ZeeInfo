package business;

public class Car {
	private String cname;
	private Engine engine;
	private Parts parts;

	Car() {
		System.out.println("Car Default Consructor");
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	

	public Parts getParts() {
		return parts;
	}

	public void setParts(Parts parts) {
		this.parts = parts;
	}

	public String getCname() {
		return cname;
	}

	public Engine getEngine() {
		return engine;
	}

	public void printData() {
		System.out.println("Car name : " + cname);
		System.out.println("Car name : " + engine.getModelyear());
		System.out.println("Car gate : " + parts.getGate());
	}
}
