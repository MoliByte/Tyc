package belink.spark.com.tyc

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.widget.SearchView
import belink.adapter.HotSearchAdapter
import belink.view.AbsXmlAcitivity
import com.chad.library.adapter.base.BaseQuickAdapter
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
abstract class AbsMainActivit : AbsXmlAcitivity(), SearchView.OnQueryTextListener {
    lateinit var hotSearchAdapter: HotSearchAdapter
    lateinit var searchView: SearchView

    lateinit var recyclerView: RecyclerView

    override fun initView() {
        searchView = findViewById(R.id.searchView)
        initSeachView(searchView)
        searchView.setOnQueryTextListener(this@AbsMainActivit)
        recyclerView = findViewById(R.id.recyclerView)

        hotSearchAdapter = HotSearchAdapter()
        recyclerView.adapter = hotSearchAdapter
        hotSearchAdapter.onItemClickListener = BaseQuickAdapter.OnItemClickListener { adapter, view, position ->
            var item: Any? = adapter.getItem(position)
            if (item is HotResult) {
                var bundle = Bundle()

                bundle.putString("companyId", item.cid)
                goActivity(this@AbsMainActivit, CompanyDetailsActivity::class.java, bundle)
            }


        }
    }

    /**
     * route go search result page index
     */
    override fun onQueryTextSubmit(query: String?): Boolean {
        var bundle = Bundle()
        bundle.putString("query", query)
        goActivity(this@AbsMainActivit, CompanySearchResultActivity::class.java, bundle)
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return false
    }


    /*
    override fun initView(){
        coordinatorLayout {
           imageView{
               backgroundResource = R.mipmap.head_bg
           }.lparams(width = matchParent) {
               height = dip(200)
           } //end of bg img

           verticalLayout {
               relativeLayout {
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
                   textView.setTextColor(Color.WHITE)
                   textView.textSize = 16f
                   textView.hint = context.getString(R.string.search_hint)

                   searchView.isIconified = false
                   searchView.setIconifiedByDefault(false);
                   //searchView.onActionViewExpanded();
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
               }// end of relativeLayout 头部相对布局

           }// end of verticalLayout

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
           }// end of recyclerView
       }// end of coordinatorLayout


    }*/


}