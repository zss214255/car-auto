package com.zss;

import java.math.BigDecimal;

/**
 * @author zss214255
 * @Description 在一个长800M的操场上，A B两个人在同一个地点，同时同方向出发，A的速度是40米/分钟
 *              ，B的速度是60米/分钟，两个人都是每走200米休息两分钟 请问，B比A多走一圈追上A需要多少时间 （结果保留两位小数即可）
 * @CreateDate 2019年8月19日
 */

public class RunningCalculation {
	private static BigDecimal AVelocity = new BigDecimal(40);
	private static BigDecimal BVelocity = new BigDecimal(60);
	private static BigDecimal ALocal = new BigDecimal(800);
	private static BigDecimal BLocal = new BigDecimal(0);
	private static BigDecimal restJourney = new BigDecimal(200);
	private static BigDecimal restTime = new BigDecimal(2);

	public static void main(String[] args) {
		BigDecimal timeAll = new BigDecimal(0);// 总共经历的时间
		BigDecimal AJourney = new BigDecimal(0);// 第n次计算a走的的路径
		BigDecimal BJourney = new BigDecimal(0);// 第n次计算b走的的路径

		while (ALocal.compareTo(BLocal) > 0.01) {
			// 1.0 获取b到达a记录点的距离
			BJourney = ALocal.subtract(BLocal);
			BigDecimal[] list = BJourney.divideAndRemainder(restJourney);
			// 2.0 获取b到a记录点时间
			BigDecimal curTime = BJourney.divide(BVelocity, 2, BigDecimal.ROUND_DOWN)// 跑步时间
					.add(list[0].multiply(restTime))// 休息时间
					.setScale(2, BigDecimal.ROUND_DOWN);

			// 3.0 获取假设a此段时间完全在跑步需要的休息次数
			int MaximumRest = curTime.multiply(AVelocity).divideAndRemainder(restJourney)[0].intValue();
			int currentRest = MaximumRest;

			for (int i = 0; i < MaximumRest && i < currentRest; i++) {
				currentRest = curTime.subtract(new BigDecimal(i * 2)).multiply(AVelocity)
						.divideAndRemainder(restJourney)[0].intValue();
			}
			// 4.0 根据实际休息次数计算a在此段时间的跑步路程
			AJourney = curTime.subtract(new BigDecimal(currentRest * 2)).multiply(AVelocity);

			BLocal = BLocal.add(BJourney);
			ALocal = ALocal.add(AJourney);
			timeAll = timeAll.add(curTime);
		}

		System.out.println(timeAll);
	}

}
