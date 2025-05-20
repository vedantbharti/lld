package commonLLDQuestions.distributedId.strategy;

import commonLLDQuestions.distributedId.random.RandomValueGenerator;

public class SnowflakeStrategy implements IdGenerationStrategy{

    private static final long EPOCH = 1672531200000L;
    private static final long DATA_CENTER_ID_BITS = 5L;
    private static final long WORKER_NODE_ID_BITS = 5L;
    private static final long SEQUENCE_BITS = 12L;
    private static final long MAX_DS_ID = ~(-1L<<DATA_CENTER_ID_BITS);
    private static final long MAX_WORKER_NODE_ID = ~(-1L<<WORKER_NODE_ID_BITS);
    private static final long MAX_SEQUENCE = 1<<SEQUENCE_BITS;
    private static final long WORKER_NODE_ID_SHIFT = SEQUENCE_BITS;
    private static final long DS_ID_SHIFT = WORKER_NODE_ID_BITS + WORKER_NODE_ID_SHIFT;
    private static final long TIMESTAMP_SHIFT = DATA_CENTER_ID_BITS + DS_ID_SHIFT;

    private final long nodeId = RandomValueGenerator.generateRandomNodeVal(MAX_WORKER_NODE_ID);
    private final long dsId = RandomValueGenerator.generateRandomDataCenterVal(MAX_DS_ID);
    private long lastTimestamp = -1L;
    private long sequence = 0L;

    private SnowflakeStrategy(){}

    private static class Initializer {
        private static final SnowflakeStrategy INSTANCE = new SnowflakeStrategy();
    }

    public static SnowflakeStrategy getInstance() {
        return Initializer.INSTANCE;
    }

    @Override
    public long generateId() {
        long currentTimestamp = System.currentTimeMillis();

        if (currentTimestamp < lastTimestamp) {
            throw new IllegalStateException("Clock moved backwards. Refusing to generate id.");
        } else if (currentTimestamp == lastTimestamp) {
            sequence = (sequence + 1) & MAX_SEQUENCE;
            if (sequence == 0) {
                // Sequence exhausted in this millisecond, wait for next millisecond
                currentTimestamp = waitNextMillis(currentTimestamp);
            }
        } else {
            sequence = 0;
        }

        lastTimestamp = currentTimestamp;

        return ((currentTimestamp - EPOCH) << TIMESTAMP_SHIFT)
                | (dsId << DS_ID_SHIFT)
                | (nodeId << WORKER_NODE_ID_SHIFT)
                | sequence;
    }

    private long waitNextMillis(long currentTimestamp) {
        while (currentTimestamp <= lastTimestamp) {
            currentTimestamp = System.currentTimeMillis();
        }
        return currentTimestamp;
    }
}
