package cn.yzl.startactivityforesult.library

import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity


fun androidx.fragment.app.FragmentActivity.startActivityForResult(intent: Intent, callback: (ActivityResult) -> Unit) {
    ActivityHelper.startActivityForResult(this, intent, ActivityHelper.DEFAULT_REQUEST_CODE,
            object : ActivityHelper.Callback() {
                override fun onResult(result: ActivityResult) {
                    callback(result)
                }
            })
}

fun androidx.fragment.app.FragmentActivity.startActivityForResult(intent: Intent,
                                                                  requestCode: Int,
                                                                  simple: Boolean,
                                                                  callback: (ActivityResult) -> Unit) {
    ActivityHelper.startActivityForResult(this, intent, requestCode, object : ActivityHelper.Callback(simple) {
        override fun onResult(result: ActivityResult) {
            callback(result)
        }
    })
}

fun androidx.fragment.app.FragmentActivity.startActivityForResult(intent: Intent,
                                                                  simple: Boolean,
                                                                  callback: (ActivityResult) -> Unit) {
    startActivityForResult(intent, ActivityHelper.DEFAULT_REQUEST_CODE, simple, callback)
}

fun androidx.fragment.app.Fragment.startActivityForResult(intent: Intent, callback: (ActivityResult) -> Unit) {
    ActivityHelper.startActivityForResult(this, intent, ActivityHelper.DEFAULT_REQUEST_CODE, object : ActivityHelper.Callback() {
        override fun onResult(result: ActivityResult) {
            callback(result)
        }
    })
}

fun androidx.fragment.app.Fragment.startActivityForResult(intent: Intent, requestCode: Int, simple: Boolean, callback: (ActivityResult) -> Unit) {
    ActivityHelper.startActivityForResult(this, intent, requestCode, object : ActivityHelper.Callback(simple) {
        override fun onResult(result: ActivityResult) {
            callback(result)
        }
    })
}

fun androidx.fragment.app.Fragment.startActivityForResult(intent: Intent, simple: Boolean, callback: (ActivityResult) -> Unit) {
    startActivityForResult(intent, ActivityHelper.DEFAULT_REQUEST_CODE, simple, callback)
}