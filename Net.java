public class Net {
	public Neuron[][] net;
	public int[] size;
	public String type;
	
	public Net(int[] sizes,String type) {
		this.size = sizes;
		net = new Neuron[sizes.length][];
		for(int i = 0;i<sizes.length;i++) {
			net[i] = new Neuron[sizes[i]];
		}
	}
	
	public void create() {
		for(int i = 0;i<net[0].length;i++) {
			net[0][i] = new Neuron();
		}
		for(int i = 1;i<net.length;i++) {
			for(int j = 0;j<net[i].length;j++) {
				net[i][j] = new Neuron(net[i-1]);
			}
		}
	}
	
	public void train(double[] in, double[] right, int repeat) {
		for(int q = 0;q<repeat;q++) {
			for(int i = 0;i<in.length;i++) {
				net[0][i].setVal(in[i]);
			}
			for(int i = 1;i<net.length;i++) {
				for(int j = 0;j<net[i].length;j++) {
					net[i][j].update();
					if(i==net.length-1) {
						//setzt den "has to be" wert auf den gewünschten outputwert
						net[i][j].htb = right[j];
					}
				}
			}
			System.out.println(net[net.length-1][0].getVal());
			for(int i = net.length-1;i>0;i--) {
				for(int j = 0;j<net[i].length;j++) {
					net[i][j].updateWeights();
				}
			}
		}
	}
	
	public double[] predict(double[]in) {
		double[] out = new double[net[net.length-1].length];
		for(int i = 0;i<in.length;i++) {
			net[0][i].setVal(in[i]);
		}
		for(int i = 1;i<net.length;i++) {
			for(int j = 0;j<net[i].length;j++) {
				net[i][j].update();
				if(i==net.length-1) {
					out[j] = net[i][j].getVal();
				}
			}
		}
		return out;
	}
}
