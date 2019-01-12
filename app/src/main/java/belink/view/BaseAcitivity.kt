package belink.view

import android.os.Bundle
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

/**
 * Created by Univer Quie on 2019/1/10.
 * @author: Univer Quie
 * @email: 397826579@qq.com
 */
abstract class BaseActivity : RxAppCompatActivity() {
    val TAG: String? = javaClass.simpleName

    abstract fun initView()

    /**
     * 初始化数据
     */
    abstract fun initData();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }


}