package com.zss.dto;

/**
 * @author zss214255
 * @Description 汽车操作接口
 * @CreateDate 2019年8月18日
 */
public interface Car {
	
	void move(String command);

	int getpositionx();

	int getpositiony();

	String getOrientation();
}
