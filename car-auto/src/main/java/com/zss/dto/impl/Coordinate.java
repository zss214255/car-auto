package com.zss.dto.impl;

/**
 * @author zss214255
 * @Description 坐标系对象
 * @CreateDate 2019年8月19日
 */
public class Coordinate {
	private int x;
	private int y;

	private int preX;
	private int preY;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Coordinate() {
		super();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.preX = this.x;
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.preY = this.y;
		this.y = y;
	}

	/**
	 * @Description 修改回撤(主要针对越界异常)
	 */
	public void back() {
		this.x = this.preX;
		this.y = this.preY;
	}

	public void add(int[] pole) {
		setX(this.x + pole[0]);
		setY(this.y + pole[1]);
	}

	@Override
	public String toString() {
		return "Coordinate [" + x + "," + y + "]";
	};

}
