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
 */
abstract class AbsMainActivit : AbsXmlAcitivity(), SearchView.OnQueryTextListener {
    var hotSearchAdapter: HotSearchAdapter? = null
    var searchView: SearchView? = null
    var recyclerView: RecyclerView? = null

    override fun initView() {
        searchView = viewHolder?.getView(R.id.searchView)
        recyclerView = viewHolder?.getView(R.id.recyclerView)
        initSeachView(searchView)
        searchView?.setOnQueryTextListener(this@AbsMainActivit)

        hotSearchAdapter = HotSearchAdapter()
        recyclerView?.adapter = hotSearchAdapter
        hotSearchAdapter?.onItemClickListener = BaseQuickAdapter.OnItemClickListener { adapter, view, position ->
            val item: Any? = adapter.getItem(position)
            if (item is HotResult) {
                val bundle = Bundle()

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

}