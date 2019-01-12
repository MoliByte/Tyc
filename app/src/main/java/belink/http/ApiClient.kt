package belink.http

import belink.spark.com.tyc.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by zhupei on 2019/1/10.
 * @author: zhupei
 * @email: 397826579@qq.com
 */
class ApiClient private constructor() {

    val baseUrl: String = "https://api9.tianyancha.com/services/v3/"
//    val baseUrl:String = "https://kmilesapi.listensky.com/api/v1/"

    lateinit var service: AppService

    private object Holder {
        val INSTANCE = ApiClient()
    }

    companion object {
        val instance by lazy { Holder.INSTANCE }
    }

    //在Application的onCreate中调用一次即可
    fun init() {
        val okHttpClient = OkHttpClient().newBuilder()
                //输入http连接时的log，也可添加更多的Interceptor
                .addInterceptor(HttpLoggingInterceptor().setLevel(
                        if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                        else HttpLoggingInterceptor.Level.NONE
                ))
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()

        service = retrofit.create(AppService::class.java)
    }
}
