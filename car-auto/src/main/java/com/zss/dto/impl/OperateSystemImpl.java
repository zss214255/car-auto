package com.zss.dto.impl;

import com.zss.contants.AutoCarContants;
import com.zss.dto.OperateSystem;

/**
 * @author zss214255
 * @Description 操作系統实现类
 * @CreateDate 2019年8月18日
 */
public class OperateSystemImpl implements OperateSystem {

	private int model = AutoCarContants.MODEL_MANUAL;
	private Coordinate parkInfo;
	private int orientation;
	private Coordinate location;

	public int getModel() {
		return model;
	}

	public void changeModel(int model) {
		this.model = model;
	}

	/*
	 * @Description 前进
	 */
	public void process() {

		location.add(AutoCarContants.PROCESSVALUE[orientation]);

		if (!(parkInfo.getX() > location.getX() && parkInfo.getY() > location.getY())) {

			location.back();
			throw new RuntimeException("beyond border!!");
		}

		System.out.println("process, now the location is " + location.toString());

	}

	/*
	 * @Description 改变方向
	 */
	public void changeOrientation() {
		System.out.println("The current direction is " + AutoCarContants.PROCESSNAME[orientation]);
		this.orientation = (orientation + 1) % 4;
		System.out.println("Change the direction, now the direction is " + AutoCarContants.PROCESSNAME[orientation]);
	}

	/*
	 * @Description 自动驾驶到目标地点
	 */
	public void moveAuto(int x, int y) {

		while (!(x - location.getX() == 0 && y - location.getY() == 0)) {

			while (!(Math.abs(x - (AutoCarContants.PROCESSVALUE[orientation][0] + location.getX())) < Math
					.abs(x - location.getX())
					|| Math.abs(y - (AutoCarContants.PROCESSVALUE[orientation][1] + location.getY())) < Math
							.abs(y - location.getY()))) {
				changeOrientation();
			}
			process();
		}

		changeModel(AutoCarContants.MODEL_MANUAL);
		System.out.println("Destination reached, switch to manual mode");
	}

	public Coordinate getParkInfo() {
		return this.parkInfo;
	}

	/* 
	 * @Description 获取方向
	 */
	public int getOrientation() {
		return this.orientation;
	}


	/* 
	 * @Description 停车场信息
	 */
	public void setParkInfo(int[] parkInfo) {
		this.parkInfo = new Coordinate(parkInfo[0], parkInfo[1]);
	}

	/* 
	 * @Description 设置当前位置坐标
	 */
	public void setLocation(int[] location) {
		this.location = new Coordinate(location[0], location[1]);
	}

	/* 
	 * @Description 获取当前位置坐标
	 */
	public Coordinate getLocation() {
		return location;
	}

}
