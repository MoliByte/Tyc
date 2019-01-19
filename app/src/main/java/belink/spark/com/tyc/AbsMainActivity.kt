package belink.spark.com.tyc

import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import belink.adapter.HotSearchAdapter
import belink.view.BaseActivity
import belink.view.recyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import org.jetbrains.anko.*
import repos.model.HotResult


/**
 * Created by Univer Quie on 2019/1/12.
 * @author: Univer Quie
 * @email: 397826579@qq.com

TycPresenter.authLogin(this, bodyBuilder, loginCallBack)
TycPresenter.search_sNorV3(this, "平安科技有限公司", searchCallBack)
TycPresenter.tCommonBaseInfoV5(this, "199557844", baseInfoCallBack)
TycPresenter.hotSearchWxHotWord(this, hotSearchCallBack)
 *
 */
abstract class AbsMainActivit : BaseActivity(), SearchView.OnQueryTextListener {
    lateinit var hotSearchAdapter: HotSearchAdapter
    lateinit var searchView: SearchView

    override fun initView() {
        verticalLayout {
            relativeLayout {
                backgroundResource = R.mipmap.head_bg
                searchView = searchView().lparams {
                    width = matchParent
                    height = dip(60)
                    alignParentBottom()
                }

                val imgId = searchView.context.resources.getIdentifier("android:id/search_mag_icon", null, null)
                val searchButton = searchView.findViewById(imgId) as ImageView
                searchButton.setImageResource(R.mipmap.search_icon)

                val txtId = searchView.context.resources.getIdentifier("android:id/search_src_text", null, null)
                val textView = searchView.findViewById(txtId) as TextView
                textView.setHintTextColor(context.resources.getColor(R.color.search_hint_color))
                textView.setTextColor(Color.WHITE)//字体颜色
                textView.textSize = 16f//字体、提示字体大小
                textView.hint = context.getString(R.string.search_hint)

                searchView.isIconified = false
                searchView.setIconifiedByDefault(false);
//                searchView.onActionViewExpanded();
                searchView.isSubmitButtonEnabled = false
                searchView.setOnQueryTextListener(this@AbsMainActivit)

                //中间图片
                imageView {
                    backgroundResource = R.mipmap.cc_txt
                    scaleType = ImageView.ScaleType.FIT_XY
                }.lparams {
                    width = wrapContent
                    height = wrapContent
                    centerInParent()
                }

            }.lparams(width = matchParent) {
                height = dip(200)
            }// 头部相对布局

            recyclerView {
                layoutManager = LinearLayoutManager(this@AbsMainActivit)
                hotSearchAdapter = HotSearchAdapter()
                adapter = hotSearchAdapter

                hotSearchAdapter.onItemClickListener = BaseQuickAdapter.OnItemClickListener { adapter, view, position ->
                    var item: Any? = adapter.getItem(position)
                    if (item is HotResult) {
                        var bundle = Bundle()

                        bundle.putString("companyId", item.cid)
                        goActivity(this@AbsMainActivit, CompanyDetailsActivity::class.java, bundle)
                    }


                }

            }.lparams(width = matchParent) {
                height = matchParent
            }

            initData()
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        var bundle = Bundle()
        bundle.putString("query", query)
        goActivity(this@AbsMainActivit, CompanySearchResultActivity::class.java, bundle)
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return false
    }


}