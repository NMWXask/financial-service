package fin.org.trst.monitoring;

public interface MonitoringService {

    /**
     * Метод регистрации обращения к методу
     * @param metricName наименование метрики
     */
    void increment(final String metricName);

    /**
     * Метод регистрации успешного события в мониторинге
     * @param metricName наименование метрики
     */
    void success(final String metricName);

    /**
     * Метод регистрации не успешного события в мониторинге
     * @param metricName наименование метрики
     */
    void failure(final String metricName);
}
