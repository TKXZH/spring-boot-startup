package com.liujin.springbootstartup.game;

import java.util.Random;

/**
 * @author zonghuixu
 */
public class RNG {
	private int maximumValue;
	private int minimumValue;

	public RNG(int maximumValue, int minimumValue) {
		this.maximumValue = maximumValue;
		this.minimumValue = minimumValue;

	}

	public int randomValue() {
		Random random = new Random();
		return random.nextInt(maximumValue + 1) + minimumValue;
	}
}
