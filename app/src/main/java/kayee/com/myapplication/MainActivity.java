package kayee.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import kayee.com.myapplication.bluetooth.BluetoothMainActivity;
import kayee.com.myapplication.camera.CameraMainActivity;
import kayee.com.myapplication.googlemap.MapsActivity;
import kayee.com.myapplication.sms.InboxActivity;
import kayee.com.myapplication.sms.SMSActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclickbtnSMS(View view) {
        Intent openSMS = new Intent(this, SMSActivity.class);
        startActivity(openSMS);
    }

    public void onclickbtnInbox(View view) {
        Intent openSMSInbox = new Intent(this, InboxActivity.class);
        startActivity(openSMSInbox);
    }

    public void onclickbtnGoogleMap(View view){
        Intent openMaps = new Intent(this, MapsActivity.class);
        startActivity(openMaps);
    }

    public void onclickbtnCamera(View view) {
        Intent openCamera = new Intent(this, CameraMainActivity.class);
        startActivity(openCamera);
    }

    public void onclickbtnBluetoothChat(View view) {
        Intent openBluetooth = new Intent(this, BluetoothMainActivity.class);
        startActivity(openBluetooth);
    }

    public void onclickbtnExit(View view) {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }



}
