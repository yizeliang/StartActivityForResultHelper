package cn.yzl.startactivityforresulthelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cn.yzl.startactivityforesult.library.ActivityHelper;
import cn.yzl.startactivityforesult.library.ActivityResult;

public class JavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        ActivityHelper.startActivityForResult(this, new Intent(this, MainActivity.class), 100,
                new ActivityHelper.Callback() {
                    @Override
                    public void onResult(ActivityResult result) {

                    }
                });
    }
}
