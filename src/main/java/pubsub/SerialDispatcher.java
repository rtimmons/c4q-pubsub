package pubsub;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author rtimmons@
 * @since 5/20/17
 */
public class SerialDispatcher<M> implements Dispatcher<M> {
    private final Map<String, List<Listener<M>>> byTopic;

    public SerialDispatcher(Map<String, List<Listener<M>>> byTopic) {
        this.byTopic = byTopic;
    }

    @Override
    public void submit(String topic, M msg) {
        List<Listener<M>> listeners = byTopic.get(topic);
        listeners = listeners == null ? Collections.emptyList() : listeners;
        for(Listener<M> l : listeners) {
            l.onMessage(msg);
        }
    }
}
