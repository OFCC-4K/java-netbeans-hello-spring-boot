package com.overflow.hellospringboot.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// 인터셉팅 후 @Around 어노테이션 설정에 따라 특정 패키지 또는 모든 패키지에 속한 함수 관리 가능
@Aspect
@Component
public class TimeTraceAop {
    
    @Around("execution(* com.overflow.hellospringboot..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long result = (finish - start);
            
            System.out.println("END : " + joinPoint.toString() + " / " + result + "ms");
        }
    }
}
