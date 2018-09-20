package pacemaker;

public class pacemaker {
	private pacemakerState heartStage;
	private pacemakerState readStage;
	private pacemakerState responseStage;
	private pacemakerConfig pacemakerConfig;
	private double timerDelayRecived;
	private double timerDelaySend;


	public pacemaker(){
		this.heartStage = pacemakerState.A;
		this.readStage = pacemakerState.A;
		this.responseStage = pacemakerState.T;
		this.pacemakerConfig = pacemakerConfig.Default;
		this.timerDelayRecived = 0;
		this.timerDelaySend = 0;
	}	

	public pacemaker(pacemakerState heartStage, pacemakerState readStage, pacemakerState responseStage, pacemakerConfig pacemakerConfig, double timerDelayRecived,
			double timerDelaySend) {
		this.heartStage = heartStage;
		this.readStage = readStage;
		this.responseStage = responseStage;
		this.pacemakerConfig = pacemakerConfig;
		this.timerDelayRecived = timerDelayRecived;
		this.timerDelaySend = timerDelaySend;
	}

	public pacemakerState getHeartStage() {
		return heartStage;
	}

	public void setHeartStage(pacemakerState heartStage) {
		this.heartStage = heartStage;

	}

	public pacemakerState getReadStage() {
		return readStage;
	}

	public void setReadStage(pacemakerState readStage) {
		if(this.timerDelayRecived < 1)
		{
			this.readStage = readStage;
		}
	}

	public pacemakerState getResponseStage() {
		return responseStage;
	}

	public void setResponseStage(pacemakerState responseStage) {
		if(this.heartStage == this.readStage)
		{
			this.responseStage = responseStage;
		}
		else
		{
			this.responseStage = pacemakerState.I;
		}		
	}

	public pacemakerConfig getPacemakerConfig() {
		return pacemakerConfig;
	}

	public void setPacemakerConfig(pacemakerConfig pacemakerConfig) {
		this.pacemakerConfig = pacemakerConfig;
	}

	public double getTimerDelayRecived() {
		return timerDelayRecived;
	}

	public void setTimerDelayRecived(double timerDelayRecived) {
		this.timerDelayRecived = timerDelayRecived;
	}

	public double getTimerDelaySend() {
		return timerDelaySend;
	}

	public void setTimerDelaySend(double timerDelaySend) {
		this.timerDelaySend = timerDelaySend;
	}

	public static enum pacemakerState
	{
		A,  V, D, T, I, O;

		private pacemakerState() {}
	}

	public static enum pacemakerConfig
	{
		Default, SimgleChamber, DoubleChamber, VVI, VVT, VOO, AAI, AAT, AOO;

		private pacemakerConfig() {}
	}

}
