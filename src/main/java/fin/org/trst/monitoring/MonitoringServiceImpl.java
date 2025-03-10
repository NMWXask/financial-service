package fin.org.trst.monitoring;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MonitoringServiceImpl implements MonitoringService {

    private final MeterRegistry meterRegistry;

    @Override
    public void increment(String metricName) {
        meterRegistry.counter(metricName).increment();
    }

    @Override
    public void success(String metricName) {
        meterRegistry.counter(metricName + "_success_total").increment();
    }

    @Override
    public void failure(String metricName) {
        meterRegistry.counter(metricName + "_failure_total").increment();
    }
}
