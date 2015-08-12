package com.dcharm.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by wangqiang on 2015/8/12.
 */
public class NIOExample {
    public static void main(String[] args) throws IOException {

    }

    private static void netNio1() throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(9999));
        ssc.configureBlocking(false);
        while (true) {
            SocketChannel sc = ssc.accept();
            if(sc != null) {
                //do something
            }
        }
    }

    private static void netNio() throws IOException {
        ServerSocketChannel server = ServerSocketChannel.open();
        server.configureBlocking(false);

        server.socket().bind(new InetSocketAddress(9000));
        Selector selector = Selector.open();
        server.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            selector.select();
            Set readyKeys = selector.selectedKeys();
            Iterator iterator = readyKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = (SelectionKey) iterator.next();
                iterator.remove();
                if (key.isAcceptable()) {//server socket channel event
                    SocketChannel client = server.accept();
                    System.out.println("Accepted connection from " + client);
                    client.configureBlocking(false);
                    ByteBuffer source = ByteBuffer.allocate(1024);
                    //register the event to the selector
                    SelectionKey key2 = client.register(selector, SelectionKey.OP_WRITE);
                    key2.attach(source);
                } else if (key.isWritable()) {//socket channel event
                    SocketChannel client = (SocketChannel) key.channel();
                    ByteBuffer output = (ByteBuffer) key.attachment();
                    if (!output.hasRemaining()) {
                        output.rewind();
                    }
                    client.write(output);
                }
                key.channel().close();
            }
        }
    }

    private static void fileNio() throws IOException {
        FileInputStream fi = new FileInputStream("test.py");
        FileChannel inChannel = fi.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
//        MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_WRITE, 0, 1024);
        while(inChannel.read(buffer) > 0)
        {
            // The flip() method prepares the buffer to have the newly-read data written to another channel.
            buffer.flip();
//            buffer.asReadOnlyBuffer();
            for (int i = 0; i < buffer.limit(); i++)
            {
                System.out.print((char) buffer.get());
            }
            //The clear() method resets the buffer, making it ready to have data read into it.
            buffer.clear();
        }
        inChannel.close();
        fi.close();
    }

}
