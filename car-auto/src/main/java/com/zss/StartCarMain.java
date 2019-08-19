package com.zss;

import java.util.Scanner;

import com.zss.contants.AutoCarContants;
import com.zss.dto.impl.AutoCarImpl;
import com.zss.dto.impl.OperateSystemImpl;

/**
 * @author zss214255
 * @Description 测试类
 * @CreateDate 2019年8月19日
 */
public class StartCarMain {
	public static void main(String[] args) {

		AutoCarImpl car = new AutoCarImpl(new OperateSystemImpl());
		int[] parkInfo = new int[] { 8, 10 };
		int[] localInfo = new int[] { 1, 2 };
		car.initialize(localInfo, parkInfo);
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------AutoCar system-------------");
		System.out.println("-------------current model: manual-------------");

		boolean flag = true;
		while (flag) {
			System.out.println("current position:[" + localInfo[0] + "," + localInfo[1] + "]");
			System.out.println("Current park size:[" + parkInfo[0] + "," + parkInfo[1] + "]");
			System.out.println("please input your command");
			System.out.println("1.manual model");
			System.out.println("2.auto model");
			System.out.println("3.set parkInfo");
			System.out.println("4.set localInfo");
			System.out.println("5.change orientation");
			System.out.println("6.exit");

			int num = sc.nextInt();
			switch (num) {
			case 1:
				boolean flag1 = true;
				while (flag1) {
					System.out.println("please input your command");
					System.out.println("1.process");
					System.out.println("2.change orientation");
					System.out.println("3.back");
					num = sc.nextInt();
					switch (num) {
					case 1:
						car.move(AutoCarContants.OPERATE_PROCESS);
						break;
					case 2:
						car.move(AutoCarContants.OPERATE_CHANGE_ORIENTATION);
						break;
					case 3:
						flag1 = false;
						break;
					default:
						System.out.println("Error command");
						break;
					}
				}
				break;
			case 2:
				System.out.println("Please set the X-axis of the target");
				int x = sc.nextInt();
				System.out.println("Please set the Y-axis of the target");
				int y = sc.nextInt();

				if (x < parkInfo[0] && y < parkInfo[1]) {
					car.moveAuto(x, y);
					localInfo[0] = x;
					localInfo[1] = y;
					System.out.println("success!");
				} else {
					System.out.println("Set coordinates beyond the boundary");
				}
				break;
			case 3:
				System.out.println("Please set the X-axis of the parkInfo");
				x = sc.nextInt();
				System.out.println("Please set the Y-axis of the parkInfo");
				y = sc.nextInt();
				parkInfo[0] = x;
				parkInfo[1] = y;

				if (x < localInfo[0] || y < localInfo[1]) {
					localInfo[0] = 0;
					localInfo[1] = 0;
					System.out.println("The current Location coordinate  is out of bounds and has been reset to 0,0");
				}
				System.out.println("success!");
				break;
			case 4:
				System.out.println("Please set the X-axis of the parkInfo");
				x = sc.nextInt();
				System.out.println("Please set the Y-axis of the parkInfo");
				y = sc.nextInt();
				if (x > parkInfo[0] || y > parkInfo[1]) {
					System.out.println("Set coordinates beyond the boundary");
				} else {
					localInfo[0] = x;
					localInfo[1] = y;
					System.out.println("success!");
				}
				break;
			case 5:
				car.move(AutoCarContants.OPERATE_CHANGE_ORIENTATION);
				break;
			case 6:
				System.out.println("Exit the success");
				sc.close();
				flag = false;
				break;
			default:
				System.out.println("Error command");

			}

		}
	}
}
