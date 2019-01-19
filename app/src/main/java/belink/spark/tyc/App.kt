package belink.spark.tyc;

import android.app.Application
import belink.http.ApiClient

/**
 * Created by Univer Quie on 2019/1/10.
 *
 * @author: Univer Quie
 * @email: 397826579@qq.com
 */
open class App : Application() {
    companion object {
        lateinit var instance: App
            private set
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
        ApiClient.instance.init()
    }
}
