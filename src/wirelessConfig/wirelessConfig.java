package wirelessConfig;

public class wirelessConfig {
	private wirelessConfiguration wirelessConfig;
	
	public wirelessConfig()
	{
		this.wirelessConfig = wirelessConfiguration.Simple;
	}
	
	public wirelessConfig(wirelessConfiguration wirelessConfig)
	{
		this.wirelessConfig = wirelessConfig;
	}

	public wirelessConfiguration getWirelessConfig() {
		return wirelessConfig;
	}

	public void setWirelessConfig(wirelessConfiguration wirelessConfig) {
		this.wirelessConfig = wirelessConfig;
	}

	public double getBateryConsuption(){
		if(this.getWirelessConfig()==wirelessConfiguration.Simple)
		{
			return 0.01;
		}
		else
		{
			return 0.02;
		}
	}

	public static enum wirelessConfiguration
	{
		Simple, Encription;

		private wirelessConfiguration() {}
	}

}
