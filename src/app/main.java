package app;

import heart.heart;
import heart.heart.HeartState;
import pacemaker.pacemaker;
import pacemaker.pacemaker.pacemakerConfig;
import pacemaker.pacemaker.pacemakerState;
import simulatorThread.simulator;
import wirelessConfig.wirelessConfig;
import wirelessConfig.wirelessConfig.wirelessConfiguration;
import batery.batery;


class main {

	public static void main(String[] args) {

		heart heartRuning = new heart();
		pacemaker pacemakerRunning = new pacemaker(pacemakerState.A, pacemakerState.A, pacemakerState.A, pacemakerConfig.DoubleChamber, 0, 1);
		wirelessConfig wirelessRunning = new wirelessConfig(wirelessConfiguration.Simple);
		batery bateryRunning = new batery();		
		simulator heartSimulator = new simulator(heartRuning, pacemakerRunning, bateryRunning, wirelessRunning);
		int band = 0;

		while(true)
		{
			if(band == 6)
			{
				break;
			}
			System.out.println("Heart in: " + heartRuning.getStage());
			heartSimulator.run();			
			System.out.println("pacemaker face: " + pacemakerRunning.getHeartStage());
			System.out.println("pacemaker sense: " + pacemakerRunning.getReadStage());
			System.out.println("pacemaker response: " + pacemakerRunning.getResponseStage());
			System.out.println("batery charge: " + bateryRunning.getPercentaje());
			band++;
		}

		System.out.println("Terminated");

	}

}
