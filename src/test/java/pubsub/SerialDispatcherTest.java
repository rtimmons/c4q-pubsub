package pubsub;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * @author rtimmons@
 * @since 5/20/17
 */
public class SerialDispatcherTest {
    Listener<String> one;
    Listener<String> two;

    Map<String, List<Listener<String>>> listeners;

    SerialDispatcher<String> dispatcher;

    @Before
    public void setup() {
        one = mock(Listener.class);
        two = mock(Listener.class);

        listeners = Collections.singletonMap("both", Arrays.asList(one, two));
        dispatcher = new SerialDispatcher<>(listeners);
    }

    @After
    public void noMoreInteractions() {
        verifyNoMoreInteractions(one, two);
    }

    @Test
    public void testDispatchesToBothInOrder() {
        dispatcher.submit("both", "foo");
        dispatcher.submit("both", "bar");

        // since we care about the order
        InOrder order = inOrder(one, two);

        order.verify(one).onMessage("foo");
        order.verify(two).onMessage("foo");
        order.verify(one).onMessage("bar");
        order.verify(two).onMessage("bar");
    }
}
