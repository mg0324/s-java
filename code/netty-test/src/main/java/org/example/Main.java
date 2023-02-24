package org.example;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.DefaultFileRegion;
import io.netty.channel.FileRegion;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes("hello netty!!!".getBytes(StandardCharsets.UTF_8));
        ByteBuf buf1 = buf.slice(1, 10);
        System.out.println(buf1.toString());
        //Unpooled.wrappedBuffer(byte[])
        CompositeByteBuf compositeByteBuf = new CompositeByteBuf(ByteBufAllocator.DEFAULT,true,8);
        compositeByteBuf.addComponent(buf);
        compositeByteBuf.addComponent(buf1);
        System.out.println(compositeByteBuf.toString());
       
        FileRegion fileRegion = new DefaultFileRegion();
        fileRegion.transferTo()
    }
}