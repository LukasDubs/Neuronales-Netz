public class Connection {
	
	public Neuron a;
	public Neuron b;
	public double weight;
	double lernfact;
	public Connection(Neuron a, Neuron b, double weight) {
		this.a = a;
		this.b = b;
		this.weight = weight;
		lernfact = 0.0001;
	}
	public Connection(Neuron a, Neuron b, double weight, double lernfact) {
		this.a = a;
		this.b = b;
		this.weight = weight;
		this.lernfact = lernfact;
	}
	public void update() {
		b.setVal(a.getVal()*weight);
	}
	public void update_weights() {
		//
		/*updatet das nächste zu updatende Neuron
		*/
		a.htb+=b.htb*delta();
		
		//korrigiert das Gewicht
		weight+=delta();
	}
	public double delta() {
		return lernfact*(b.htb-b.value)*a.value;
	}
	

}
