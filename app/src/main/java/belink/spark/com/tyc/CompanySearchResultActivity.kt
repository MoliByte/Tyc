package belink.spark.com.tyc

import android.util.Log
import belink.view.AbsView
import repos.model.SearchJsonModel
import service.impl.TycPresenter

/**
 * 搜索查询结果页面
 */
class CompanySearchResultActivity : AbsCompanySearchResult() {

    override fun initData() {
        val query = intent.getStringExtra("query")
        Log.e(TAG, "query = " + query)
        mSearchView?.setQuery(query,false)
        TycPresenter.search_sNorV3(this, query, object : AbsView<SearchJsonModel>() {
            override fun success(data: SearchJsonModel) {
                val baseInfoModel: SearchJsonModel? = data
                Log.e(TAG, baseInfoModel?.state)
                mCompanyAdapter?.setNewData(baseInfoModel?.data?.companyList)
            }
        })
    }
}