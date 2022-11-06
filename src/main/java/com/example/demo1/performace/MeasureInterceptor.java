package com.example.demo1.performace;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Measurable
public class MeasureInterceptor {

    @Inject
    private Logger log;

    @AroundInvoke
    private Object intercept(InvocationContext ic) throws Exception {
        long start = System.nanoTime();
        Object obj = ic.proceed();
        long end = System.nanoTime();
        long durationInMs = TimeUnit.NANOSECONDS.toMillis(end - start);

        log.info(ic.getMethod().getName() + " - " + durationInMs + " ms");
        return obj;
    }
}
