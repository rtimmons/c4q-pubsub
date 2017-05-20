package pubsub;

/**
 * @author rtimmons@
 * @since 5/20/17
 */
public interface Listener<M> {
    void onMessage(M msg);
}
