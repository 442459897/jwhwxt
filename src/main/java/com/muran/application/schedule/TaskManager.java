package com.muran.application.schedule;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskManager {

	private final static Logger log = Logger.getLogger(TaskManager.class);
	static ExecutorService es = Executors.newCachedThreadPool();
	
	private static List<AbstractScheduleTask> tasks = new ArrayList<AbstractScheduleTask>();
	public static void registerScheduleTask(AbstractScheduleTask task) {
		tasks.add(task);
	}
	public static void shutdown(){
		es.shutdown();
	}
	public static void runTask(){
		es.execute(new Runnable() {
			@Override
			public void run() {
				for(AbstractScheduleTask task : tasks){
					if(task.needRun()){
						try {
							task.runTask();
						} catch (Exception e) {
							if(task.getListener()!=null)task.getListener().catchException(e);
							log.error("定时任务执行失败,异常如下:");
							e.printStackTrace();
						}
					}
				}
			}
		});
		
	}
}
