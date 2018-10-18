package kayee.com.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class SplashActivity extends Activity {

    LinearLayout l1;
    Animation uptodown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        l1 = (LinearLayout) findViewById(R.id.l1);
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);

        Thread timer = new Thread() {
            public void run() {
                try{
                    l1.setAnimation(uptodown);
                    sleep(3000);
                }catch(InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    Intent openMainActivity = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(openMainActivity);
                }
            }
        };
        timer.start();
    }

}
