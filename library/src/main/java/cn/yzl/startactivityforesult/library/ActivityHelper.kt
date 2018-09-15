package cn.yzl.startactivityforesult.library

import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager

object ActivityHelper {

    private val TAG = "StartActivityForResultHelperFragment"

    fun startActivityForResult(activity: FragmentActivity, intent: Intent, requestCode: Int, callback: (ActivityResult) -> Unit) {
        val helperFragment = findOrAddFragment(getFragmentManager(activity))
        helperFragment.startActivityForResult(intent, requestCode, callback)
    }

    fun startActivityForResult(fragment: Fragment, intent: Intent, requestCode: Int, callback: (ActivityResult) -> Unit) {
        val helperFragment = findOrAddFragment(getFragmentManager(fragment))
        helperFragment.startActivityForResult(intent, requestCode, callback)
    }


    private fun getFragmentManager(`object`: Any): FragmentManager {
        if (`object` is FragmentActivity) {
            return `object`.supportFragmentManager
        }
        if (`object` is Fragment) {
            return `object`.childFragmentManager
        }
        throw IllegalArgumentException("只能接受 FragmentActivity/V4.Fragment 类型参数")
    }


    private fun findOrAddFragment(fragmentManager: FragmentManager): StartActivityForResultHelperFragment {
        var fragmentByTag = fragmentManager.findFragmentByTag(TAG) as StartActivityForResultHelperFragment?
        if (fragmentByTag != null) {
            return fragmentByTag
        }
        fragmentByTag = StartActivityForResultHelperFragment()
        fragmentManager.beginTransaction()
                .add(fragmentByTag, TAG)
                .commitNow()
        return fragmentByTag
    }
}

fun FragmentActivity.startActivityForResult(intent: Intent, requestCode: Int, callback: (ActivityResult) -> Unit) {
    ActivityHelper.startActivityForResult(this, intent, requestCode, callback)
}

fun Fragment.startActivityForResult(intent: Intent, requestCode: Int, callback: (ActivityResult) -> Unit) {
    ActivityHelper.startActivityForResult(this, intent, requestCode, callback)
}
