package pl.sda.shop.aop;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import pl.sda.shop.domain.Product;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


@Aspect
@Component
public class ProductAOP {


    private static final Logger LOGGER = LogManager.getLogger();

    @Before("execution(* pl.sda.shop.service.ProductService.deleteProduct(..))")
    public void logBeforeV1(JoinPoint joinPoint) {
        LOGGER.info("ProductController.Product() : " + Arrays.toString(joinPoint.getArgs()));
    }

    @Around("execution(* pl.sda.shop.service.ProductService.listAllProducts(..))")
    public List<Product> logListAllTime(ProceedingJoinPoint joinPoint) {
        List<Product> products = new LinkedList<>();
        long startTime = System.currentTimeMillis();
        try {
            products = (List<Product>) joinPoint.proceed();
        } catch (Throwable throwable) {
            LOGGER.warn(throwable.getStackTrace());
        }
        long endTime = System.currentTimeMillis() - startTime;
        LOGGER.info("Time spend : " + endTime + "ms");
        return products;
    }

}
