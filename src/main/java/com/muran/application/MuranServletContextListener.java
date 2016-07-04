package com.muran.application;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.muran.application.cache.ServerCache;
import com.muran.application.schedule.TaskManager;
import org.apache.log4j.Logger;

public class MuranServletContextListener implements ServletContextListener {
    private static final Logger log = Logger
            .getLogger(MuranServletContextListener.class);

    ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        log.info("contextDestroyed");
        stopScheduleService();
        ServerCache.getCache().persistCache();
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        log.info("contextInitialized");
        GlobalConfig.getInstance(arg0.getServletContext());
        startScheduleService();
    }

    private void startScheduleService() {
        Runnable runnable = new Runnable() {
            public void run() {
                log.info("执行定时任务");
                TaskManager.runTask();
            }
        };
        service.scheduleAtFixedRate(runnable,0,1, TimeUnit.MINUTES);
    }

    private void stopScheduleService() {
        TaskManager.shutdown();
    }

}
