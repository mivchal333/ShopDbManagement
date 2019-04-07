package pl.sda.shop.aop;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
public class ProductAOP {


    private static final Logger LOGGER = LogManager.getLogger();

    @Before("execution(* pl.sda.shop.service.ProductService.deleteProduct(..))")
    public void logBeforeV1(JoinPoint joinPoint) {
        LOGGER.info("ProductController.Product() : " + Arrays.toString(joinPoint.getArgs()));
    }
    @Around("execution(* pl.sda.shop.service.ProductService.listAllProducts(..))")
    public void logAround(ProceedingJoinPoint joinPoint) {
        long startTime = System.currentTimeMillis();
        try{
            joinPoint.proceed();
        } catch (Throwable throwable) {

        }
        long endTime = System.currentTimeMillis() - startTime;
        LOGGER.info("Time spend : " + endTime  + "ms");
    }

}
