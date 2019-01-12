package belink.view

import android.util.Log
import belink.http.ApiErrorModel
import belink.http.ResultData
import org.jetbrains.anko.toast
import repos.model.BaseInfoModel

/**
 * Created by zhupei on 2019/1/10.
 * @author: zhupei
 * @email: 397826579@qq.com
 */
abstract class BaseUserActivity : BaseActivity(), ILogin {

//    external fun stringFromJNI(): String
//
//    companion object {
//        init {
//            System.loadLibrary("native-lib")
//        }
//    }


    /**
     * 登录回调
     */
    var loginCallBack = object : IView<ResultData<BaseInfoModel>> {
        override fun success(data: ResultData<BaseInfoModel>) {
            loginSuccess(data)
        }

        override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) {
            Log.e(TAG, statusCode.toString())
            toast("${apiErrorModel.message}!")
        }
    }
}