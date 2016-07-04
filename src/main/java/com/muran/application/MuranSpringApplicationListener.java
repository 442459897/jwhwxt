package com.muran.application;

import com.muran.application.cache.ServerCache;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

/**
 * Created by Steven on 5/4/16.
 */
@Service
public class MuranSpringApplicationListener implements ApplicationListener<ContextRefreshedEvent>{
    private final static Logger log = Logger.getLogger(MuranSpringApplicationListener.class);
    private static int runTime = 0;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        log.info("muran spring context listener: runtime="+runTime);
//
//        if(runTime==0)
//        {
//            ServerCache.getCache().loadCache();
//        }
//        runTime ++;
    }
}
