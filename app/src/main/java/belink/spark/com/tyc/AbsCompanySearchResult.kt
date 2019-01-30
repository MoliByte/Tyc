package belink.spark.com.tyc

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.ImageView
import android.widget.SearchView
import belink.view.AbsView
import belink.view.AbsXmlAcitivity
import com.chad.library.adapter.base.BaseQuickAdapter
import repos.model.CompanyItem
import repos.model.SearchJsonModel
import service.impl.TycPresenter


/**
 * Created by Univer Quie on 2019/1/12.
 * @author: Univer Quie
 * @email: 397826579@qq.com
 *
 */
abstract class AbsCompanySearchResult : AbsXmlAcitivity(), SearchView.OnQueryTextListener {
    var mRecyclerView: RecyclerView? = null
    var mSearchView:SearchView? = null
    lateinit var iv_back: ImageView

    override fun getLayoutId(): Int {
        return R.layout.activity_company_search_result
    }

    override fun initView() {
        iv_back = findViewById(R.id.iv_back)
        iv_back.setOnClickListener {
            finish()
        }
        mSearchView = mViewHolder?.getView(R.id.searchView)
        initSeachView(mSearchView)
        mSearchView?.setOnQueryTextListener(this@AbsCompanySearchResult)

        mRecyclerView = mViewHolder?.getView(R.id.recyclerView)
        mRecyclerView?.adapter = mCompanyAdapter
        mCompanyAdapter?.onItemClickListener = BaseQuickAdapter.OnItemClickListener { adapter, view, position ->
            var item: Any? = adapter.getItem(position)
            if (item is CompanyItem) {
                var bundle = Bundle()
                bundle.putString("companyId", item.id)
                goActivity(this@AbsCompanySearchResult, CompanyDetailsActivity::class.java, bundle)
            }
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        TycPresenter.search_sNorV3(this@AbsCompanySearchResult, query, object : AbsView<SearchJsonModel>() {
            override fun success(data: SearchJsonModel) {
                val baseInfoModel: SearchJsonModel? = data
                Log.e(TAG, baseInfoModel?.state)
                mCompanyAdapter?.setNewData(baseInfoModel?.data?.companyList)
            }
        })
        return false
    }


    override fun onQueryTextChange(newText: String?): Boolean {
        return false
    }


}