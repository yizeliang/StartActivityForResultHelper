package cn.yzl.startactivityforesult.java;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class ActivityHelper {
    private static final String TAG = "StartActivityForResultHelperFragment_java";

    public final void startActivityForResult(FragmentActivity activity, Intent intent, int requestCode, Callback callback) {
        StartActivityForResultHelperFragment helperFragment = this.findOrAddFragment(this.getFragmentManager(activity));
        helperFragment.startActivityForResult(intent, requestCode, callback);
    }

    public final void startActivityForResult(Fragment fragment, Intent intent, int requestCode, Callback callback) {
        StartActivityForResultHelperFragment helperFragment = this.findOrAddFragment(this.getFragmentManager(fragment));
        helperFragment.startActivityForResult(intent, requestCode, callback);
    }

    private final FragmentManager getFragmentManager(Object object) {
        if (object instanceof FragmentActivity) {
            return ((FragmentActivity) object).getSupportFragmentManager();
        } else if (object instanceof Fragment) {
            return ((Fragment) object).getChildFragmentManager();
        } else {
            throw new IllegalArgumentException("只能接受 FragmentActivity/V4.Fragment 类型参数");
        }
    }

    private final StartActivityForResultHelperFragment findOrAddFragment(FragmentManager fragmentManager) {
        StartActivityForResultHelperFragment fragmentByTag = (StartActivityForResultHelperFragment) fragmentManager.findFragmentByTag(TAG);
        if (fragmentByTag != null) {
            return fragmentByTag;
        } else {
            fragmentByTag = new StartActivityForResultHelperFragment();
            fragmentManager.beginTransaction().add(fragmentByTag, TAG).commitNow();
            return fragmentByTag;
        }
    }

    interface Callback {
        void onResult(ActivityResult result);
    }
}
