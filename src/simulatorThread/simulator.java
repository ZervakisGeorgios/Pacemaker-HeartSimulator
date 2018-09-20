package simulatorThread;

import heart.heart;
import heart.heart.HeartState;
import pacemaker.pacemaker;
import pacemaker.pacemaker.pacemakerConfig;
import pacemaker.pacemaker.pacemakerState;
import wirelessConfig.wirelessConfig;

import java.util.Random;

import batery.batery;

public class simulator implements Runnable{

	heart heartRuning = new heart();
	pacemaker pacemakerRunning = new pacemaker();
	batery bateryRunning = new batery();
	wirelessConfig wirelessRunning = new wirelessConfig();

	public simulator()
	{
		heartRuning = new heart();
		pacemakerRunning = new pacemaker();
		bateryRunning = new batery();
		wirelessRunning = new wirelessConfig();
		
	}

	public simulator(heart heartRuning, pacemaker pacemakeRunning, batery bateryRunning, wirelessConfig wirelessRunning)
	{
		this.heartRuning = heartRuning;
		this.pacemakerRunning = pacemakeRunning;
		this.bateryRunning = bateryRunning;
		this.wirelessRunning = wirelessRunning;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.heartRunningStage();	
		try {
			Thread.sleep((long) heartRuning.getTimerVA() * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void heartRunningStage()
	{
		this.pacemakerProcess(this.pacemakerRunning, this.wirelessRunning);
		this.changeHeartStage(this.heartRuning);
	}

	public void changeHeartStage(heart heartRunning)
	{
		if(heartRunning.getStage() == HeartState.A)
		{			
			pacemakerRunning.setHeartStage(pacemakerState.A);
			pacemakerRunning.setReadStage(pacemakerState.A);
			heartRunning.setStage(HeartState.V);
		}
		else
		{			
			pacemakerRunning.setHeartStage(pacemakerState.V);
			pacemakerRunning.setReadStage(pacemakerState.V);
			heartRunning.setStage(HeartState.A);
		}
	}

	public void pacemakerProcess(pacemaker pacemakerRunning, wirelessConfig wirelessRunning)
	{
		Random executeWireless = new Random();
		int  executeWirelessYesOrNo = executeWireless.nextInt(1) + 1;

		switch (pacemakerRunning.getPacemakerConfig()) {
		case SimgleChamber:
			pacemakerRunning.setResponseStage(pacemakerState.O);
			if(executeWirelessYesOrNo == 0)
			{
				bateryRunning.consumeBatery(wirelessRunning.getBateryConsuption());
			}
			bateryRunning.consumeBatery(0.002);
			break;

		case DoubleChamber:
			pacemakerRunning.setResponseStage(pacemakerState.D);
			if(executeWirelessYesOrNo == 0)
			{
				bateryRunning.consumeBatery(wirelessRunning.getBateryConsuption());
			}
			bateryRunning.consumeBatery(0.002);
			break;

		default:
			pacemakerRunning.setResponseStage(pacemakerState.T);
			if(executeWirelessYesOrNo == 0)
			{
				bateryRunning.consumeBatery(wirelessRunning.getBateryConsuption());
			}
			bateryRunning.consumeBatery(0.001);
			break;
		}
	}
}
