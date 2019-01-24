package belink.spark.com.tyc

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.ImageView
import android.widget.SearchView
import belink.adapter.CompanyAdapter
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
    lateinit var companyAdapter: CompanyAdapter
    lateinit var searchView: SearchView
    lateinit var recyclerView: RecyclerView

    lateinit var iv_back: ImageView

    override fun getLayoutId(): Int {
        return R.layout.activity_company_search_result
    }

    override fun initView() {
        searchView = findViewById(R.id.searchView)
        iv_back = findViewById(R.id.iv_back)
        iv_back.setOnClickListener {
            finish()
        }
        initSeachView(searchView)
        recyclerView = findViewById(R.id.recyclerView)
        companyAdapter = CompanyAdapter()
        recyclerView.adapter = companyAdapter
        companyAdapter.onItemClickListener = BaseQuickAdapter.OnItemClickListener { adapter, view, position ->
            var item: Any? = adapter.getItem(position)
            if (item is CompanyItem) {
                var bundle = Bundle()
                bundle.putString("companyId", item.id)
                goActivity(this@AbsCompanySearchResult, CompanyDetailsActivity::class.java, bundle)
            }
        }

        searchView.setOnQueryTextListener(this@AbsCompanySearchResult)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        TycPresenter.search_sNorV3(this@AbsCompanySearchResult, query, object : AbsView<SearchJsonModel>() {
            override fun success(data: SearchJsonModel) {
                val baseInfoModel: SearchJsonModel? = data
                Log.e(TAG, baseInfoModel?.state)
                companyAdapter.setNewData(baseInfoModel?.data?.companyList)
            }
        })
        return false
    }


    override fun onQueryTextChange(newText: String?): Boolean {
        return false
    }


}