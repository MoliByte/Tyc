package belink.spark.tyc;

import android.app.Application
import belink.http.ApiClient

/**
 * Created by zhupei on 2019/1/10.
 *
 * @author: zhupei
 * @email: 397826579@qq.com
 */
open class App : Application() {

    override fun onCreate() {
        super.onCreate()
        ApiClient.instance.init()
    }

}