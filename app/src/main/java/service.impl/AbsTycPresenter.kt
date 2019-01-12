package service.impl

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
 * Created by zhupei on 2019/1/10.
 * @author: zhupei
 * @email: 397826579@qq.com
 */
abstract class AbsTycPresenter: ITycService {
    val authorization:String = "0###oo34J0dv_aR36nehbWZ4k32tgSng###1546854913272###835e399f920b64890fc8adfbd81b0775"
    val version:String = "TYC-XCX-WX"
    val host:String = "api9.tianyancha.com"

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