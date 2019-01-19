package belink.spark.com.tyc

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.SearchView
import belink.view.AbsView
import belink.view.BaseActivity
import belink.view.recyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.searchView
import org.jetbrains.anko.verticalLayout
import repos.model.CompanyItem
import repos.model.SearchJsonModel
import service.impl.TycPresenter

/**
 * Created by Univer Quie on 2019/1/12.
 * @author: Univer Quie
 * @email: 397826579@qq.com
 */
abstract class AbsMainActivit : BaseActivity(), SearchView.OnQueryTextListener {

    lateinit var companyAdapter: CompanyAdapter
    lateinit var searchView: SearchView

    override fun initView() {
        verticalLayout {
            searchView = searchView()
            searchView.setIconifiedByDefault(false)
            searchView.isSubmitButtonEnabled = true
            searchView.queryHint = "查公司"
            searchView.setOnQueryTextListener(this@AbsMainActivit)
            recyclerView {
                layoutManager = LinearLayoutManager(this@AbsMainActivit)
                companyAdapter = CompanyAdapter()
                adapter = companyAdapter

                companyAdapter.onItemClickListener = BaseQuickAdapter.OnItemClickListener { adapter, view, position ->
                    var item: Any? = adapter.getItem(position)
                    if (item is CompanyItem) {
                        var bundle: Bundle = Bundle()

                        bundle.putString("companyId", item.id)
                        goActivity(this@AbsMainActivit, CompanyDetailsActivity::class.java, bundle)
                    }


                }

            }.lparams(width = matchParent) {
                height = matchParent
            }


        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {

        TycPresenter.search_sNorV3(this, query, object : AbsView<SearchJsonModel>() {
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


    class CompanyAdapter : BaseQuickAdapter<CompanyItem, BaseViewHolder>(R.layout.item_company) {

        override fun convert(helper: BaseViewHolder, item: CompanyItem) {
            helper.setText(R.id.tv_name, item.name)
        }


    }
}