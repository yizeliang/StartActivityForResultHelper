package cn.yzl.startactivityforesult.library

import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity

fun FragmentActivity.startActivityForResult(intent: Intent, requestCode: Int, callback: (ActivityResult) -> Unit) {
    ActivityHelper.startActivityForResult(this, intent, requestCode, callback)
}

fun Fragment.startActivityForResult(intent: Intent, requestCode: Int, callback: (ActivityResult) -> Unit) {
    ActivityHelper.startActivityForResult(this, intent, requestCode, callback)
}