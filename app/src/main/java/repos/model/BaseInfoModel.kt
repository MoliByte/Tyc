package repos.model;

/**
 * Created by zhupei on 2019/1/10.
 *
 * @author: zhupei
 * @email: 397826579@qq.com
 */
open class BaseInfoModel {
    lateinit var uid: String
    lateinit var userName: String

    open var state: String? = ""
    open var message: String? = ""
    open var special: String? = ""
    open var vipMessage: String? = ""
    open var isLogin: String? = ""
}
