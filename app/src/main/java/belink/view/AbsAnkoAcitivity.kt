package belink.view

import android.os.Bundle
import android.widget.ImageView
import belink.spark.com.tyc.R
import org.jetbrains.anko.*

/**
 * Created by Univer Quie on 2019/1/10.
 * @author: Univer Quie
 * @email: 397826579@qq.com
 * Anko 布局父类
 */
abstract class AbsAnkoAcitivity : BaseActivity() {


    override fun getLayoutId(): Int {
        return -1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initData()
    }


    fun initVerticalView() {
        verticalLayout {
            //header
            relativeLayout {
                backgroundResource = R.color.title_bg
                imageView {
                    imageResource = R.mipmap.icon_white_back
                    scaleType = ImageView.ScaleType.CENTER_INSIDE
                    adjustViewBounds = true
                    setOnClickListener { finish() }
                }.lparams(wrapContent, toolbarHeight) {
                    centerVertically()
                    alignParentStart()
                }
            }.lparams(matchParent, toolbarHeight)


        }
    }


}