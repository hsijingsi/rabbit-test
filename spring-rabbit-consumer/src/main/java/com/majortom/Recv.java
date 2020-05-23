package com.majortom;

/**
 * @author 李文海
 * @version 1.0
 * @desc
 * @date 2020.05.22. \ 21:43
 * @copyright &copy; xuetang9
 * @address
 */
public class Recv {
    public void RecvDirectListen1(String info){
        System.out.println("RecvDirectListen1收到消息："+info );
    }

    public void RecvFanoutListen1(String info){

        System.out.println("RecvFanoutListen1收到消息："+info );
    }

    public void RecvTopicListen1(String info){

        System.out.println("RecvTopicListen1收到消息："+info );
    }
}
