package belink.view

import android.util.Log
import android.widget.Toast
import belink.http.ApiErrorModel
import belink.spark.tyc.App

/**
 * Created by Univer Quie on 2019/1/10.
 * @author: Univer Quie
 * @email: 397826579@qq.com
 */
abstract class AbsView<T : Any> : IView<T> {
    /**
     * 请求失败
     */
    override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) {
        Log.e("AbsView", statusCode.toString())
        Toast.makeText(App.instance.applicationContext, "${apiErrorModel.message}!", Toast.LENGTH_LONG).show()
    }


}