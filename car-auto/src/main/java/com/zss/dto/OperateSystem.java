package com.zss.dto;

import com.zss.dto.impl.Coordinate;

/**
 * @author zss214255
 * @Description 操作系統接口
 * @CreateDate 2019年8月19日
 */
public interface OperateSystem {

	int getModel();// 获取操作系统当前模式

	void changeModel(int model);// 改变操作系统模式

	void process();// 执行前进命令

	void changeOrientation();// 执行改变方向命令

	void setParkInfo(int[] location);// 初始化停车场数据

	Coordinate getParkInfo();// 获取停车场数据

	void setLocation(int[] location);// 初始化当前位置

	Coordinate getLocation();// 获取当前位置

	int getOrientation();// 获取当前方向

	void moveAuto(int x, int y);//自动驾驶
}
