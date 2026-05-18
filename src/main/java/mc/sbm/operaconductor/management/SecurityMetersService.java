package mc.sbm.operaconductor.management;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class SecurityMetersService {

    public static final String INVALID_TOKENS_METER_NAME = "security.authentication.invalid-tokens";
    public static final String INVALID_TOKENS_METER_DESCRIPTION =
        "Indicates validation error count of the tokens presented by the clients.";
    public static final String INVALID_TOKENS_METER_BASE_UNIT = "errors";
    public static final String INVALID_TOKENS_METER_CAUSE_DIMENSION = "cause";

    private final Counter tokenInvalidSignatureCounter;
    private final Counter tokenExpiredCounter;
    private final Counter tokenUnsupportedCounter;
    private final Counter tokenMalformedCounter;

    /** Creates a new SecurityMetersService and registers Micrometer counters. */
    public SecurityMetersService(MeterRegistry registry) {
        this.tokenInvalidSignatureCounter = invalidTokensCounterForCauseBuilder("invalid-signature").register(registry);
        this.tokenExpiredCounter = invalidTokensCounterForCauseBuilder("expired").register(registry);
        this.tokenUnsupportedCounter = invalidTokensCounterForCauseBuilder("unsupported").register(registry);
        this.tokenMalformedCounter = invalidTokensCounterForCauseBuilder("malformed").register(registry);
    }

    private Counter.Builder invalidTokensCounterForCauseBuilder(String cause) {
        return Counter.builder(INVALID_TOKENS_METER_NAME)
            .baseUnit(INVALID_TOKENS_METER_BASE_UNIT)
            .description(INVALID_TOKENS_METER_DESCRIPTION)
            .tag(INVALID_TOKENS_METER_CAUSE_DIMENSION, cause);
    }

    /** Records a token invalid-signature authentication failure. */
    public void trackTokenInvalidSignature() {
        this.tokenInvalidSignatureCounter.increment();
    }

    /** Records an expired token authentication failure. */
    public void trackTokenExpired() {
        this.tokenExpiredCounter.increment();
    }

    /** Records an unsupported token authentication failure. */
    public void trackTokenUnsupported() {
        this.tokenUnsupportedCounter.increment();
    }

    /** Records a malformed token authentication failure. */
    public void trackTokenMalformed() {
        this.tokenMalformedCounter.increment();
    }
}
