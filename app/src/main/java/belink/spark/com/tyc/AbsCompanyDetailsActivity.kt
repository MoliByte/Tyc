package belink.spark.com.tyc

import android.widget.TextView
import belink.view.AbsAnkoAcitivity
import org.jetbrains.anko.scrollView
import org.jetbrains.anko.textView

/**
 * Created by Univer Quie on 2019/1/12.
 * @author: Univer Quie
 * @email: 397826579@qq.com
 */
abstract class AbsCompanyDetailsActivity : AbsAnkoAcitivity() {
    lateinit var text: TextView
    override fun initView() {
        scrollView {
            text = textView()
        }
    }

}