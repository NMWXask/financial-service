package fin.org.trst.aspect;

import fin.org.trst.annotation.Monitor;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class MonitoringAspect {

    private final MeterRegistry meterRegistry;


    @Around("@annotation(monitor)")
    public Object monitorMethod(ProceedingJoinPoint joinPoint, Monitor monitor) throws Throwable {
        String metricName = monitor.metricName();
        meterRegistry.counter(metricName).increment();
        try {
            Object result = joinPoint.proceed();
            meterRegistry.counter(metricName + "_success_total").increment();
            return result;
        } catch (Exception e) {
            meterRegistry.counter(metricName + "_failure_total").increment();
            throw e;
        }
    }
}