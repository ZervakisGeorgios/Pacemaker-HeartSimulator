package heart;

public class heart {
	private HeartState stage;
	private double timerAV;
	private double timerVA;

	public heart()
	{
		this.stage = HeartState.A;
		this.timerAV = 1;
		this.timerVA = 2;		
	}

	public heart(HeartState InitialStage, double timerAV, double timerVA)
	{
		this.stage = InitialStage;
		this.timerAV = timerAV;
		this.timerVA = timerVA;		
	}

	public HeartState getStage() {
		return stage;
	}

	public void setStage(HeartState stage) {
		this.stage = stage;
	}

	public double getTimerAV() {
		return timerAV;
	}

	public void setTimerAV(double timerAV) {
		this.timerAV = timerAV;
	}

	public double getTimerVA() {
		return timerVA;
	}

	public void setTimerVA(double timerVA) {
		this.timerVA = timerVA;
	}


	public static enum HeartState
	{
		A,  V;

		private HeartState() {}
	}

	public void changeofStage(HeartState state)
	{
		this.stage = state;		
	}

	public String toString()
	{
		return "Heart in: " + this.stage + ".";
	}
}

