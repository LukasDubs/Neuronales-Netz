import java.util.Random;

public class Neuron {
	
	public double value;
	public double htb = 0.0;
	boolean sig = false;
	public Connection[] inputs;
	
	public Neuron(Neuron[] in) {
		Random r = new Random();
		inputs = new Connection[in.length];
		for(int i = 0;i<inputs.length;i++) {
			inputs[i] = new Connection(in[i],this,r.nextInt(0xf));
		}
	}
	public Neuron() {
		
	}
	public void update() {
		for(int i = 0;i<inputs.length;i++) {
			inputs[i].update();
		}
	}
	public void updateWeights() {
		for(int i = 0;i<inputs.length;i++) {
			inputs[i].update_weights();
		}
	}
	public void setVal(double val) {
		value = val;
	}
	public double getVal() {
		if(sig)return sig(value);
		return value;
	}
	public double sig(double d) {
		return 1.0/(1.0+Math.exp(-d));
	}

}
