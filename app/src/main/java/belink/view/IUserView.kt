package belink.view

import belink.http.ResultData
import repos.model.BaseInfoModel

/**
 * Created by zhupei on 2019/1/10.
 * @author: zhupei
 * @email: 397826579@qq.com
 */

/**
 * 登录
 */
interface ILogin {
    fun loginSuccess(data: ResultData<BaseInfoModel>)
}