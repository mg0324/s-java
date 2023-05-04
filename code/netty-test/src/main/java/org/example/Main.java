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
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

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

        boolean[] bb = sieveOfEratosthenes(60);
        for(int i=0;i<bb.length;i++){
            if(bb[i]){
                System.out.print(i+",");
            }
        }
    }

    public static boolean[] sieveOfEratosthenes(int n) {
        Character
        Set set = new HashSet();
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    System.out.println(j + " set false");
                    isPrime[j] = false;
                }
            }
        }
        new PriorityQueue<String>((o1, o2) -> o1.compareTo(o2) );
        return isPrime;
    }

}