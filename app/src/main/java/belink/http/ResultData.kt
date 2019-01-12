package belink.http;

/**
 * Created by zhupei on 2019/1/10.
 *
 * @author: zhupei
 * @email: 397826579@qq.com
 */
open class ResultData<T : Any> {
    lateinit var code: String
    lateinit var msg: String
    lateinit var data: T
}
