package com.example.posmessageformat;

import com.example.iso8583.core.Iso8583Message;
import com.example.iso8583.core.Iso8583MessageFactory;
import com.example.iso8583.quickstart.SingletonFactory;

public class Test {

    public static void main(String[] args) {
        Iso8583MessageFactory factory = SingletonFactory.forQuickStart();

        Iso8583Message message = new Iso8583Message(factory);

        message.setTpdu("600000000")
                .setHeader("62000000")
                .setMti("0200")
                .setValue(2, "1234567890123456")
                .setValue(11, "674712")
                .setValue(12, "232505")
                .setValue(60, "01160528");



        System.out.println("getBitmapString:" + message.getBitmapString());
        System.out.println("getBytesString:" + message.getBytesString());
        System.out.println("toFormatString:" + message.toFormatString());
    }
}
