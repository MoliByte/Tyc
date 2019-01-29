package belink.spark.com.tyc

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.widget.SearchView
import belink.view.AbsXmlAcitivity
import com.chad.library.adapter.base.BaseQuickAdapter
import repos.model.WxHotWordCompanyData


/**
 * Created by Univer Quie on 2019/1/12.
 * @author: Univer Quie
 * @email: 397826579@qq.com
 */
abstract class AbsMainActivit : AbsXmlAcitivity(), SearchView.OnQueryTextListener {

    var searchView: SearchView? = null
    var recyclerView: RecyclerView? = null

    override fun initView() {
        searchView = viewHolder?.getView(R.id.searchView)
        recyclerView = viewHolder?.getView(R.id.recyclerView)
        initSeachView(searchView)
        searchView?.setOnQueryTextListener(this@AbsMainActivit)

        recyclerView?.adapter = wxHotSearchAdapter

        wxHotSearchAdapter?.onItemClickListener = BaseQuickAdapter.OnItemClickListener { adapter, view, position ->
            val item: Any? = adapter.getItem(position)
            if (item is WxHotWordCompanyData) {
                val bundle = Bundle()

                bundle.putString("companyId", item.cid)
                goActivity(this@AbsMainActivit, CompanyDetailsActivity::class.java, bundle)
            }
        }
    }

    /**
     * Route go search result page index
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

}