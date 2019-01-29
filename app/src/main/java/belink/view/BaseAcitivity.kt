package belink.view

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import belink.adapter.AbsTycAdapter
import belink.spark.com.tyc.R
import belink.spark.tyc.App
import com.chad.library.adapter.base.BaseViewHolder
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import org.jetbrains.anko.dip
import repos.model.CompanyItem
import repos.model.HotResult
import repos.model.WxHotWordCompanyData

/**
 * Created by Univer Quie on 2019/1/10.
 * @author: Univer Quie
 * @email: 397826579@qq.com
 */
abstract class BaseActivity : RxAppCompatActivity() {
    val TAG: String? = javaClass.simpleName
    var viewHolder: ViewHolderBuilder? = null

    val toolbarHeight: Int = App.instance.dip(60)

    /**
     * 初始化视图
     */
    abstract fun initView()

    abstract fun getLayoutId(): Int;

    /**
     * 初始化数据
     */
    abstract fun initData();


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

    // 初始化搜索样式
    fun initSeachView(searchView: SearchView?) {
        //搜索icon
        val searchIconId = searchView?.context!!.resources.getIdentifier("android:id/search_mag_icon", null, null)
        val searchButton = searchView.findViewById(searchIconId) as ImageView
        searchButton.setImageResource(R.mipmap.search_icon)

        //搜索 清除 icon
        val searchCloseId = searchView.context.resources.getIdentifier("android:id/search_close_btn", null, null)
        val closeButton = searchView.findViewById(searchCloseId) as ImageView
        closeButton.setImageResource(R.mipmap.search_clear)

        val txtId = searchView.context.resources.getIdentifier("android:id/search_src_text", null, null)
        val searchText = searchView.findViewById(txtId) as TextView
        searchText.setHintTextColor(resources.getColor(R.color.search_hint_color))
        searchText.setTextColor(Color.WHITE)
        searchText.textSize = 16f
        searchText.hint = getString(R.string.search_hint)

        searchView.isIconified = false
        searchView.setIconifiedByDefault(false)
        //searchView.onActionViewExpanded();
        searchView.isSubmitButtonEnabled = false
        //光标颜色
        try {
            val mCursorDrawableRes = TextView::class.java.getDeclaredField("mCursorDrawableRes")
            mCursorDrawableRes.isAccessible = true
            mCursorDrawableRes.set(searchText, R.drawable.search_cursor)
        } catch (e: Exception) {

        }

        //默认收起键盘
        searchView.clearFocus()
    }

// ================= begin all app adapters view handler =========================
    /**
     * 天眼查微信小程序热搜公司adapter
     */
    var wxHotSearchAdapter: AbsTycAdapter<WxHotWordCompanyData>? = object : AbsTycAdapter<WxHotWordCompanyData>(R.layout.item_hot_search_company) {
        override fun initItemData(helper: BaseViewHolder, item: WxHotWordCompanyData) {
            helper.setText(R.id.tv_name, item.companyName)
        }
    }

    /**
     * 天眼查热搜公司adapter
     */
    var hotSearchAdapter: AbsTycAdapter<HotResult>? = object : AbsTycAdapter<HotResult>(R.layout.item_hot_search_company) {
        override fun initItemData(helper: BaseViewHolder, item: HotResult) {
            helper.setText(R.id.tv_name, item.office[0].companyName)
        }
    }

    /**
     * 搜索公司名称返回的结果列表
     */
    var companyAdapter: AbsTycAdapter<CompanyItem>? = object : AbsTycAdapter<CompanyItem>(R.layout.item_company) {

        override fun initItemData(helper: BaseViewHolder, item: CompanyItem) {
            helper.setText(R.id.tv_name, item.name)
        }
    }


// ================= end of all app adapters view handler =========================

}