package nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * can examine one or more Java NIO Channel instances,
 * and determine which channels are ready for e.g. reading or writing.
 *
 * Why Use a Selector?
 *
 *      Switching between threads is expensive for an operating system,
 *      and each thread takes up some resources (memory) in the operating system too.
 *      Therefore, the less threads you use, the better.
 *
 */
public class SelectorDemo {
    public static void main(String[] args) throws IOException {
        /**
         * Creating a Selector
         */
        Selector selector = Selector.open();

        /**
         * Registering Channels with the Selector, register()
         */
        //The Channel must be in non-blocking mode, so you cannot use FileChannel
        SocketChannel channel = SocketChannel.open();
        channel.configureBlocking(false);
        SelectionKey key = channel.register(selector, SelectionKey.OP_READ);
        //There are four different events you can listen for:
        // Connect      SelectionKey.OP_CONNECT
        // Accept       SelectionKey.OP_ACCEPT
        // Read         SelectionKey.OP_READ
        // Write        SelectionKey.OP_WRITE
        //If you are interested in more than one event, OR the constants together, like this:
        int interestSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE;
        //check a certain event is in the interest set.

        /**
         * SelectionKey
         */
        //Interested set
        interestSet = key.interestOps();
        boolean isInterestedInAccept  = (interestSet & SelectionKey.OP_ACCEPT)>0;
        //Ready Set
        int readySet = key.readyOps();
        key.isAcceptable();
        key.isConnectable();
        key.isReadable();
        key.isWritable();
        //Accessing the channel + selector from the SelectionKey
        Channel channel1 = key.channel();
        Selector selector1 = key.selector();
        //Attaching Objects
        key.attach((Object) "theObject");
        Object attachedObj = key.attachment();
        //or attach an object already while registering the Channel with the Selector, in the register() method.
        SelectionKey key1 = channel.register(selector, SelectionKey.OP_READ, "theObject");
        /**
         * Selecting Channels via a Selector
         * These methods return the channels that are "ready" for the events you are interested in (connect, accept, read or write).
         *       int select()        //blocks until at least one channel is ready for the events you registered for.    0,1
         *       int select(long timeout)       //it blocks for a maximum of timeout milliseconds
         *       int selectNow()        //doesn't block at all. It returns immediately with whatever channels are ready.
         *    The int returned by the select() methods tells how many channels are ready.
         */
        int nums = selector.select(3000);
        Set<SelectionKey> selectedKeys = selector.selectedKeys();

        /**
         * wakeUp():
         *  A thread that has called the select() method which is blocked,
         *  can be made to leave the select() method, even if no channels are yet ready.
         *
         *  If a different thread calls wakeup() and no thread is currently blocked inside select(),
         *  the next thread that calls select() will "wake up" immediately.
         */
        selector.wakeup();
        //When you are finished with the Selector you call its close() method.
        //This closes the Selector and invalidates all SelectionKey instances registered with this Selector.
        //The channels themselves are not closed.
        selector.close();
    }

    @Test
    public void testAll() throws IOException{
        Selector selector = Selector.open();

        SocketChannel channel = SocketChannel.open(new InetSocketAddress("localhost", 3030));
        channel.configureBlocking(true);

        channel.register(selector, SelectionKey.OP_READ|SelectionKey.OP_WRITE|
                SelectionKey.OP_ACCEPT|SelectionKey.OP_CONNECT);
        while (true){
            int readyChannels = selector.selectNow();
            if(readyChannels == 0){
                continue;
            }

            Set<SelectionKey> selectionKeys = selector.keys();
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                if (key.isAcceptable()) {
                    // a connection was accepted by a ServerSocketChannel.
                } else if (key.isConnectable()) {
                    // a connection was established with a remote server.
                } else if (key.isReadable()) {
                    //a channel is ready for reading
                } else if (key.isWritable()) {
                    //a channel is ready for writing
                }

                keyIterator.remove();
            }

        }
    }
}
