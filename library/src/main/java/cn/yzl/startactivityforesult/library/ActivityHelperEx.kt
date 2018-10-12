package cn.yzl.startactivityforesult.library

import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity


fun FragmentActivity.startActivityForResult(intent: Intent, callback: (ActivityResult) -> Unit) {
    ActivityHelper.startActivityForResult(this, intent, ActivityHelper.DEFAULT_REQUEST_CODE,
            object : ActivityHelper.Callback() {
                override fun onResult(result: ActivityResult) {
                    callback(result)
                }
            })
}

fun FragmentActivity.startActivityForResult(intent: Intent,
                                            requestCode: Int,
                                            simple: Boolean,
                                            callback: (ActivityResult) -> Unit) {
    ActivityHelper.startActivityForResult(this, intent, requestCode, object : ActivityHelper.Callback(simple) {
        override fun onResult(result: ActivityResult) {
            callback(result)
        }
    })
}

fun FragmentActivity.startActivityForResult(intent: Intent,
                                            simple: Boolean,
                                            callback: (ActivityResult) -> Unit) {
    startActivityForResult(intent, ActivityHelper.DEFAULT_REQUEST_CODE, simple, callback)
}

fun Fragment.startActivityForResult(intent: Intent, callback: (ActivityResult) -> Unit) {
    ActivityHelper.startActivityForResult(this, intent, ActivityHelper.DEFAULT_REQUEST_CODE, object : ActivityHelper.Callback() {
        override fun onResult(result: ActivityResult) {
            callback(result)
        }
    })
}

fun Fragment.startActivityForResult(intent: Intent, requestCode: Int, simple: Boolean, callback: (ActivityResult) -> Unit) {
    ActivityHelper.startActivityForResult(this, intent, requestCode, object : ActivityHelper.Callback(simple) {
        override fun onResult(result: ActivityResult) {
            callback(result)
        }
    })
}

fun Fragment.startActivityForResult(intent: Intent, simple: Boolean, callback: (ActivityResult) -> Unit) {
    startActivityForResult(intent, ActivityHelper.DEFAULT_REQUEST_CODE, simple, callback)
}