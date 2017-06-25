package com.larry.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created by huang on 2017/6/11.
 */
public class LoggerUtil {

    public static void log(Class cla,String info){
        Logger logger = getlogger(cla);
        logger.info(info);
    }

    public static void info(Class cla,String info){
        Logger logger = getlogger(cla);
        logger.info(info);
    }

    public static void info(Class cla,String info,Throwable th){
        Logger logger = getlogger(cla);
        logger.info(info,th);
    }

    public static void error(Class cla,String info,Throwable th){
        Logger logger = getlogger(cla);
        logger.error(info,th);
    }
    public static void error(Class cla,String info){
        Logger logger = getlogger(cla);
        logger.error(info);
    }

    private static Logger getlogger(Class cla){
        Logger logger = LogManager.getLogger(cla);
        return logger;
    }
}
