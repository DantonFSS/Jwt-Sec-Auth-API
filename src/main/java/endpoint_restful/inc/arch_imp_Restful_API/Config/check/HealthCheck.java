package endpoint_restful.inc.arch_imp_Restful_API.Config.check;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

@Component
public class HealthCheck implements HealthIndicator {

    @Override
    public Health health() {
        try {
            InetAddress address = InetAddress.getByName("localhost");
            if (address.isReachable(10000))
                return Health.up().build();
        } catch (Exception ex) {
            return Health.down().withDetail("Reason", ex.getMessage()).build();
        }
        return Health.down().withDetail("Reason", "Reason unknown...").build();
    }
}
