package belink.view;

/**
 * Created by Univer Quie on 2019/1/10.
 *
 * @author: Univer Quie
 * @email: 397826579@qq.com
 */
import android.app.Dialog
import android.content.Context
import belink.spark.com.tyc.R

object LoadingDialog {
    private var dialog: Dialog? = null

    fun show(context: Context) {
        cancel()
        dialog = Dialog(context, R.style.LoadingDialog)
        dialog?.setContentView(R.layout.dialog_loading)
        dialog?.setCancelable(false)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.show()
    }

    fun cancel() {
        dialog?.dismiss()
    }
}