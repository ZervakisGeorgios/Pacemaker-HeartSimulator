package batery;

public class batery {
	double percentaje;

	public batery() {
		percentaje = 100;
	}	
	
	public double getPercentaje() {
		return percentaje;
	}

	public void setPercentaje(double percentaje) {
		this.percentaje = percentaje;
	}

	public void consumeBatery(double percentage)
	{
		this.percentaje = this.percentaje - (percentage/100);
	}
	
}
