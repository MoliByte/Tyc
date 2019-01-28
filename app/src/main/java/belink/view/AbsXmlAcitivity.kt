package belink.view

import android.os.Bundle
import belink.spark.com.tyc.R

/**
 * Created by Univer Quie on 2019/1/10.
 * @author: Univer Quie
 * @email: 397826579@qq.com
 */
abstract class AbsXmlAcitivity : BaseActivity() {


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        viewHolder = ViewHolderBuilder.newBuild(window.decorView)
        initView()
        initData()
    }

}