package cn.yzl.startactivityforesult.library;

import android.content.Intent;

public class ActivityResult {

    ActivityResult() {

    }

    public int requestCode;
    public int resultCode;
    public Intent data;

    ActivityResult(int requestCode, int resultCode, Intent data) {
        this.requestCode = requestCode;
        this.resultCode = resultCode;
        this.data = data;
    }
}
