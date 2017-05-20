package pubsub;

/**
 * @author rtimmons@
 * @since 5/20/17
 */
public interface Dispatcher<M> {
    void submit(String topic, M msg);
}
