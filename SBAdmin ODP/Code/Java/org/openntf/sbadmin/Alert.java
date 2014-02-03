package org.openntf.sbadmin;

import java.io.Serializable;
import java.util.Random;

public class Alert implements Serializable {

	private static final long serialVersionUID = 5468248541775783196L;
	private int alertCount;

	public Alert() {
		this.alertCount = randInt(0, 10);
	}

	private int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	public String getAlertCount() {
		return String.valueOf(alertCount);
	}
}
