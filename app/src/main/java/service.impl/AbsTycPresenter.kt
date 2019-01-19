package service.impl

import android.util.Log
import belink.http.ApiErrorModel
import belink.http.ApiResponse
import belink.http.NetworkScheduler
import belink.view.ITycService
import belink.view.IView
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import com.trello.rxlifecycle2.kotlin.bindUntilEvent
import io.reactivex.Observable

/**
 * Created by Univer Quie on 2019/1/10.
 * @author: Univer Quie
 * @email: 397826579@qq.com
 */
abstract class AbsTycPresenter : ITycService {
    val auth = "0###oo34J0dv_aR36nehbWZ4k32tgSng###%d###835e399f920b64890fc8adfbd81b0775"
    var authorization: String? = ""
        get() {
            var formatAuth = String.format(auth, System.currentTimeMillis())
            Log.e("Presenter", formatAuth)
            return formatAuth
        }
    val version: String = "TYC-XCX-WX"
    val host: String = "api9.tianyancha.com"

    fun <T : Any> getObserver(context: RxAppCompatActivity, observable: io.reactivex.Observable<T>): Observable<T> {
        return observable.compose(NetworkScheduler.compose())
                .bindUntilEvent(context, ActivityEvent.DESTROY)
    }

    class CallBack<T : Any>(private var context: RxAppCompatActivity, iView: IView<T>) {
        var callback = object : ApiResponse<T>(context) {
            override fun success(data: T) {
                iView.success(data)
            }

            override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) {
                iView.failure(statusCode, apiErrorModel)
            }
        }
    }


}