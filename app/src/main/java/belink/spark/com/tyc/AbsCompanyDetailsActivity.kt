package belink.spark.com.tyc

import android.widget.ScrollView
import android.widget.TextView
import belink.view.BaseActivity
import org.jetbrains.anko.scrollView
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

/**
 * Created by Univer Quie on 2019/1/12.
 * @author: Univer Quie
 * @email: 397826579@qq.com
 */
abstract class AbsCompanyDetailsActivity : BaseActivity() {
    lateinit var scrollView: ScrollView
    lateinit var text: TextView
    override fun initView() {
        verticalLayout {
            scrollView {
                text = textView()
            }
        }
    }

}