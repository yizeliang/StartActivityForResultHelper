package cn.yzl.startactivityforesult.library

import android.content.Intent
import android.support.v4.app.Fragment
import android.util.SparseArray

class StartActivityForResultHelperFragment : Fragment() {

    private val callbacks = SparseArray<(ActivityResult) -> Unit>()

    fun startActivityForResult(intent: Intent, requestCode: Int, callback: (ActivityResult) -> Unit) {
        val fragmentActivity = activity
                ?: throw IllegalStateException("This fragment must be attached to an activity.")
        callbacks.put(requestCode, callback)
        startActivityForResult(intent, requestCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (isDetached) {
            return
        }
        val callback = callbacks.get(requestCode) ?: return
        val activityResult = ActivityResult(requestCode, resultCode, data)
        callback(activityResult)
    }

    override fun onDetach() {
        super.onDetach()
        callbacks.clear()
    }
}
