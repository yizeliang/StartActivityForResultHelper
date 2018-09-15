package cn.yzl.startactivityforesult.java;

import android.content.Intent;

public class ActivityResult {

    ActivityResult() {
    }

    public int requestCode;
    public int resultCode;
    public Intent intent;

    ActivityResult(int requestCode, int resultCode, Intent intent) {
        this.requestCode = requestCode;
        this.resultCode = resultCode;
        this.intent = intent;
    }
}
