package business;

public class Parts {
	private String gate;
	private Parts(){
		System.out.println("Constructor from parts");
	}
	public void setGate(String gate) {
		this.gate = gate;
	}
	public String getGate() {
		return gate;
	}
	
	

}
