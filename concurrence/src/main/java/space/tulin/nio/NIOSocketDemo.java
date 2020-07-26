package space.tulin.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * NIO Socket
 */
public class NIOSocketDemo {

    /** 通道选择器（管理器） */
    private Selector selector;


    public void initServer(int port) throws IOException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();

        serverChannel.configureBlocking(false);//非阻塞
        serverChannel.socket().bind(new InetSocketAddress(port));

        this.selector = Selector.open();
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        //      Connect, 即连接事件(TCP 连接), 对应于SelectionKey.OP_CONNECT
        //		Accept, 即确认事件, 对应于SelectionKey.OP_ACCEPT
        //		Read, 即读事件, 对应于SelectionKey.OP_READ, 表示 bufferChar 可读.
        //		Write, 即写事件, 对应于SelectionKey.OP_WRITE, 表示 bufferChar 可写.

        //使用或运算|来组合多个事件
        //int interestSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE;


        System.out.println("服务已启动...");
    }

    public void listenSelector() throws IOException {
        //轮询监听selector
        while (true){
            //等待客户连接            //阻塞点
            //select 模型，多路复用
            this.selector.select(); //阻塞到至少会有一个客户端连接。返回的int值表示有多少通道已经就绪。亦即，自上次调用select()方法后有多少通道变成就绪状态。
            //this.selector.select(long timeout);  //+ 最长阻塞到timeout毫秒
            //selector.selectNow(); //selectNow()不会阻塞，不管什么通道就绪都立刻返回（此方法执行非阻塞的选择操作。如果自从前一次选择操作后，没有通道变成可选择的，则此方法直接返回零）


            System.out.println("收到新客户端连接...");
            Iterator<SelectionKey> iteKey = this.selector.selectedKeys().iterator();
            while (iteKey.hasNext()){
                SelectionKey key =  iteKey.next();
                iteKey.remove();    //避免重复执行
                //处理请求
                handler(key);
            }
        }
    }

    /**
     * 处理客户端请求
     * @param key
     */
    private void handler(SelectionKey key) throws IOException {
        if(key.isAcceptable()){
            //处理客户端连接请求事件
            //在 OP_ACCEPT 事件中, 从 key.channel() 返回的 Channel 是 ServerSocketChannel.而在 OP_WRITE 和 OP_READ 中, 从 key.channel() 返回的是 SocketChannel.
            ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
            SocketChannel socketChannel = serverChannel.accept();
            //接收客户端发送的信息时，需要给通道设置读的权限
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_READ);
        }else if(key.isReadable()){
            //处理读的事件
            SocketChannel socketChannel = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int readData = socketChannel.read(buffer);
            if(readData > 0){
                String info = new String(buffer.array(), "GBK").trim();
                System.out.println("服务端收到数据：" + info);
            }else {
                System.out.println("客户端关闭了...");
                key.cancel();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        NIOSocketDemo nio = new NIOSocketDemo();
        nio.initServer(9999);
        nio.listenSelector();
    }
}
