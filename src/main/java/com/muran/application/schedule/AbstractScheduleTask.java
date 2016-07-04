package com.muran.application.schedule;

import java.util.Calendar;

public abstract class AbstractScheduleTask {

	public final static int SECOND = 1;
	public final static int MINUTE = 60 * SECOND;
	public final static int HOUR = 60 * MINUTE;
	public final static int DAY = 24 * HOUR;


	private boolean runing = false;
	private int runCount = 0;

	public abstract String getTaskName();

	public void runTask()throws Exception {
		try {
			run();
		}catch (Exception e){
			throw e;
		}finally {
			runCount++;
			runTime = Calendar.getInstance();
			runing = false;
		}
	}

	protected abstract void run();

	public static final class Time {
		public int hour24;
		public int minutes;

		public Time(int hour24, int minutes) {
			if (hour24 > -1 && hour24 < 24 && minutes > -1 && minutes < 60) {
				this.hour24 = hour24;
				this.minutes = minutes;
			} else {
				throw new RuntimeException("时间格式错误");
			}
		}
	}

	public abstract TaskRuntimeExceptionListener getListener();

	public interface TaskRuntimeExceptionListener {
		 void catchException(Throwable throwable);
	}

	private Calendar runTime = Calendar.getInstance();

	public void setRunTime(Calendar time) {
		runTime = time;
	}

	public boolean needRun() {
		if(runing) return false;
		boolean needRun = false;
		Calendar now = Calendar.getInstance();
		//每日任务
		if(getDayRunTime()!=null){//如果今日还没有运行,那么只要时间超过了,就开始运行.
			Calendar desireRunTime = Calendar.getInstance();
			desireRunTime.set(Calendar.HOUR_OF_DAY, getDayRunTime().hour24);
			desireRunTime.set(Calendar.MINUTE, getDayRunTime().minutes);
			if(now.get(Calendar.DAY_OF_YEAR)!=runTime.get(Calendar.DAY_OF_YEAR))  needRun= (desireRunTime.getTimeInMillis() - now.getTimeInMillis()) > 0;
		}
		//循环任务...
		if (getFirstStartTime() == null || runCount > 0)//一般情况下上次运行跟现在间隔小于频率间隔就开始运行
			needRun= (now.getTimeInMillis() - runTime.getTimeInMillis()) > getFrequency() * 1000;
		else {//存在首次开始时间,首次运行的时候:
			Calendar desireRunTime = Calendar.getInstance();
			desireRunTime.set(Calendar.HOUR_OF_DAY, getFirstStartTime().hour24);
			desireRunTime.set(Calendar.MINUTE, getFirstStartTime().minutes);
			needRun= Math.abs(now.getTimeInMillis()-desireRunTime.getTimeInMillis())<5000;//5分钟内开始.
		}
		if(needRun) runing = true;
		return needRun;
	}
	/**
	 * 如果返回了这个,则每日都在这个点后运行.优先级最高.
	 * @return
     */
	public abstract Time getDayRunTime();
	/**
	 * 每隔多少秒运行一次
	 *
	 * @return
	 */
	public abstract int getFrequency();

	/**
	 * 首次运行时间,返回null 立即运行
	 *
	 * @return
	 */
	public abstract Time getFirstStartTime();
}
