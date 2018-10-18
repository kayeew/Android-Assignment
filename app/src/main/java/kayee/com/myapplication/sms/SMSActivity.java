package kayee.com.myapplication.sms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import kayee.com.myapplication.R;
import kayee.com.myapplication.googlemap.MapsActivity;

public class SMSActivity extends AppCompatActivity {

    private EditText txtMobile, txtMessage;
    private Button btnSms, btnGetGPS;
    private String latitude = "", longitude = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);


        txtMobile = (EditText)findViewById(R.id.txtMobile);
        txtMessage = (EditText)findViewById(R.id.txtMessage);
        btnSms = (Button)findViewById(R.id.btnSend);
        btnGetGPS = (Button)findViewById(R.id.btnGetGPS);


        Bundle extra = getIntent().getExtras();
        if(extra != null){
            latitude = extra.getString("latitude");
            longitude = extra.getString("longitude");
        }

        if(latitude != "" && longitude != "") {

            String locationLink = "My location: "
                    + "http://maps.google.com/maps?f=q&q=(" + latitude + "," + longitude + ")";
            txtMessage.setText(locationLink);
        }

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    SmsManager smgr = SmsManager.getDefault();
                    smgr.sendTextMessage(txtMobile.getText().toString(),null,txtMessage.getText().toString(),null,null);
                    Toast.makeText(SMSActivity.this, "SMS Sent Successfully", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(SMSActivity.this, "SMS Failed to Send, Please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnGetGPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openMap = new Intent(SMSActivity.this, MapsActivity.class);
                startActivity(openMap);
            }
        });
    }

}