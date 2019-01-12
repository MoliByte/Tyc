package belink.spark.com.tyc

import android.widget.EditText
import belink.view.BaseActivity
import org.jetbrains.anko.button
import org.jetbrains.anko.editText
import org.jetbrains.anko.verticalLayout

/**
 * Created by zhupei on 2019/1/12.
 * @author: zhupei
 * @email: 397826579@qq.com
 */
abstract class AbsMainActivit:BaseActivity() {
    lateinit var etName: EditText
    override fun initView() {
        verticalLayout {
            etName = editText()
            button("Login").setOnClickListener {

            }

            initData()
        }
    }
}