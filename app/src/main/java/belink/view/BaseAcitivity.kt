package belink.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

/**
 * Created by Univer Quie on 2019/1/10.
 * @author: Univer Quie
 * @email: 397826579@qq.com
 */
abstract class BaseActivity : RxAppCompatActivity() {
    val TAG: String? = javaClass.simpleName

    /**
     * 初始化视图
     */
    abstract fun initView()

    /**
     * 初始化数据
     */
    abstract fun initData();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }


    fun <T> goActivity(activity: Activity, target: Class<T>) {
        val intent = Intent()
        intent.setClass(activity, target)
        startActivity(intent)
    }

    fun <T> goActivity(activity: Activity, target: Class<T>, bundle: Bundle) {
        val intent = Intent()
        intent.putExtras(bundle)
        intent.setClass(activity, target)
        startActivity(intent)
    }


}