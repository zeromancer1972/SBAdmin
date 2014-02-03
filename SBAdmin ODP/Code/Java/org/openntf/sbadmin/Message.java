package org.openntf.sbadmin;

import java.io.Serializable;
import java.util.Random;

public class Message implements Serializable {

	private static final long serialVersionUID = 1L;
	private int messageCount;

	public Message() {
		this.messageCount = randInt(0, 10);
	}

	private int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	public String getMessageCount() {
		return String.valueOf(messageCount);
	}
}
