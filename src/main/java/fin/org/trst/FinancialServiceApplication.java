package fin.org.trst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"fin.org"})
public class FinancialServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinancialServiceApplication.class, args);
    }

}
