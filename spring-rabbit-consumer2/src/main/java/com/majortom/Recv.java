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
    public void RecvDirectListen2(String info){
        System.out.println("RecvDirectListen2收到消息："+info );
    }

    public void RecvFanoutListen2(String info){
        System.out.println("RecvFanoutListen2收到消息："+info );
    }

    public void RecvTopicListen2(String info){
        System.out.println("RecvTopicListen2收到消息："+info );
    }

}
