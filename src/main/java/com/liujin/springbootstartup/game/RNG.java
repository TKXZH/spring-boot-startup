package com.liujin.springbootstartup.game;

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
		return minimumValue + (int) (Math.random() * (maximumValue - minimumValue + 1));
	}
}
