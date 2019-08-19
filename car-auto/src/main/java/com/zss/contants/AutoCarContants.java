package com.zss.contants;

/**
 * @author zss214255
 * @Description 驾驶常量类
 * @CreateDate 2019年8月19日
 */
public class AutoCarContants {

	/**
	 * 模式 0.自动 1.手动
	 */
	public static final int MODEL_AUTO = 1;
	public static final int MODEL_MANUAL = 0;

	/**
	 * 前进矢量变化值和方向值
	 */
	public static final int[][] PROCESSVALUE = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
	public static final String[] PROCESSNAME = { "north", "east", "south", "west" };

	/**
	 * 方向常量
	 */
	public static final int DIRECTION_NORTH = 0;
	public static final int DIRECTION_EAST = 1;
	public static final int DIRECTION_SOUTH = 2;
	public static final int DIRECTION_WEST = 3;

	/**
	 * 操作指令 0.前进 1.转向(顺时针)
	 */
	public static final String OPERATE_PROCESS = "0";
	public static final String OPERATE_CHANGE_ORIENTATION = "1";

}
