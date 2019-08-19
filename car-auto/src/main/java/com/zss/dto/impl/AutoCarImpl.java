package com.zss.dto.impl;

import java.util.Objects;

import com.zss.contants.AutoCarContants;
import com.zss.dto.Car;
import com.zss.dto.OperateSystem;

/**
 * @author zss214255
 * @Description 汽车操作实现类
 * @CreateDate 2019年8月18日
 */
public class AutoCarImpl implements Car {

	private OperateSystem opeSystem;

	private AutoCarImpl() {
	};

	/**
	 * @Description 初始化操作系统
	 */
	public AutoCarImpl(OperateSystem opeSystem) {
		this.opeSystem = opeSystem;
	};

	public void initialize(int[] location, int[] parkInfo) {
		opeSystem.setParkInfo(parkInfo);
		opeSystem.setLocation(location);
	}

	public void moveAuto(int x, int y) {
		opeSystem.moveAuto(x, y);
	}

	/**
	 * @Description 移动
	 */
	public void move(String command) {
		if (Objects.equals(command, AutoCarContants.OPERATE_PROCESS)) {
			opeSystem.process();
		} else if (Objects.equals(command, AutoCarContants.OPERATE_CHANGE_ORIENTATION)) {
			opeSystem.changeOrientation();
		}
	}

	/**
	 * @Description 获取当前x坐标
	 */
	public int getpositionx() {
		return opeSystem.getLocation().getY();
	}

	/**
	 * @Description 获取当前y坐标
	 */
	public int getpositiony() {
		return opeSystem.getLocation().getY();
	}

	/**
	 * @Description 获取当前位置
	 */
	public String getOrientation() {
		return opeSystem.getLocation().toString();
	}

}
