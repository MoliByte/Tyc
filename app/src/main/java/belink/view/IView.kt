package belink.view

import belink.http.ApiErrorModel

/**
 * Created by zhupei on 2019/1/10.
 * @author: zhupei
 * @email: 397826579@qq.com
 */
interface IView<T : Any> {
    /**
     * 请求成功
     */
    fun success(data: T)

    /**
     * 请求失败
     */
    fun failure(statusCode: Int, apiErrorModel: ApiErrorModel)


}