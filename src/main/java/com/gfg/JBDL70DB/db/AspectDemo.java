package com.gfg.JBDL70DB.db;

import com.gfg.JBDL70DB.ControllerDemo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectDemo {

    private static final Log logger = LogFactory.getLog(AspectDemo.class);


    @Before("execution(* com.gfg.JBDL70DB.db.DbService.getPersonsData(..) )")
    public void printSomethingBeforeExecution(){
        logger.info("trying to print this statement");
    }

    @Around("@annotation(com.gfg.JBDL70DB.db.LoggerStats)")
    public Object getLogStats(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // before statements
        long startTime = System.currentTimeMillis();


        // during statements
        Object o = proceedingJoinPoint.proceed();

        // after statement
        long endTime = System.currentTimeMillis();
        logger.info("total time taken :" + (endTime-startTime));
        return o;

    }


}
