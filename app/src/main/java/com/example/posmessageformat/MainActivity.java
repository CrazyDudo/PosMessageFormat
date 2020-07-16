package com.example.posmessageformat;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.iso8583.core.Iso8583Message;
import com.iso8583.core.Iso8583MessageFactory;
import com.iso8583.quickstart.SingletonFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    public static final String MTI0810 = "007960000000006022000000000810003800010AC0001400017210014105100803099988303531303030303030323033303035303038303030313330393331303038333938353030380011000000420030004051DBA323AF60599287F61C7E5A9484AEEF8DE29BD3E614FCB51122D4E9B84E2A608CD9C2A4DAABF2";
    private TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


    }

    private void init() {
        tvContent = findViewById(R.id.tv_content);
        findViewById(R.id.button).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Iso8583MessageFactory factory = SingletonFactory.forQuickStart();
        Iso8583Message message = new Iso8583Message(factory);

        //encode message
        message.setTpdu("600000000")
                .setHeader("62000000")
                .setMti("0200")
                .setValue(2, "1234567890123456")
                .setValue(11, "674712")
                .setValue(12, "232505")
                .setValue(60, "01160528");
        Log.d(TAG, "onCreate: " + message.toFormatString());

        //decode message
        Iso8583Message message0810 = factory.parse(MTI0810);

        tvContent.setText(message0810.toFormatString());
    }
}