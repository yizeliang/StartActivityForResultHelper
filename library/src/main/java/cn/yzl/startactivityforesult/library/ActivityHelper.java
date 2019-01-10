package cn.yzl.startactivityforesult.library;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class ActivityHelper {
    private static String TAG = "StartActivityForResultHelperFragment_java";

    public static final int DEFAULT_REQUEST_CODE = 101;

    public static void startActivityForResult(FragmentActivity activity, Intent intent, int requestCode, Callback callback) {
        StartActivityForResultHelperFragment helperFragment = findOrAddFragment(getFragmentManager(activity));
        helperFragment.startActivityForResult(intent, requestCode, callback);
    }

    public static void startActivityForResult(Fragment fragment, Intent intent, int requestCode, Callback callback) {
        StartActivityForResultHelperFragment helperFragment = findOrAddFragment(getFragmentManager(fragment));
        helperFragment.startActivityForResult(intent, requestCode, callback);
    }


    public static void startActivityForResult(FragmentActivity activity, Intent intent, Callback callback) {
        StartActivityForResultHelperFragment helperFragment = findOrAddFragment(getFragmentManager(activity));
        helperFragment.startActivityForResult(intent, DEFAULT_REQUEST_CODE, callback);
    }

    public static void startActivityForResult(Fragment fragment, Intent intent, Callback callback) {
        StartActivityForResultHelperFragment helperFragment = findOrAddFragment(getFragmentManager(fragment));
        helperFragment.startActivityForResult(intent, DEFAULT_REQUEST_CODE, callback);
    }


    private static FragmentManager getFragmentManager(Object object) {
        if (object instanceof FragmentActivity) {
            return ((FragmentActivity) object).getSupportFragmentManager();
        } else if (object instanceof Fragment) {
            return ((Fragment) object).getChildFragmentManager();
        } else {
            throw new IllegalArgumentException("只能接受 FragmentActivity/V4.Fragment 类型参数");
        }
    }

    private static StartActivityForResultHelperFragment findOrAddFragment(FragmentManager fragmentManager) {
        StartActivityForResultHelperFragment fragmentByTag = (StartActivityForResultHelperFragment) fragmentManager.findFragmentByTag(TAG);
        if (fragmentByTag != null) {
            return fragmentByTag;
        } else {
            fragmentByTag = new StartActivityForResultHelperFragment();
            fragmentManager.beginTransaction().add(fragmentByTag, TAG)
                    .commitNowAllowingStateLoss();
            return fragmentByTag;
        }
    }

    public static abstract class Callback {

        public Callback() {
        }

        public Callback(boolean simple) {
            this.simple = simple;
        }

        /**
         * 如果简洁模式,只有RESULT_OK 才会执行,默认为true
         */
        private boolean simple = true;

        protected abstract void onResult(ActivityResult result);

        public boolean isSimple() {
            return simple;
        }

        public void setSimple(boolean simple) {
            this.simple = simple;
        }
    }
}
