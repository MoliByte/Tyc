package belink.spark.com.tyc

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.SearchView
import belink.adapter.CompanyAdapter
import belink.view.AbsAnkoAcitivity
import belink.view.AbsView
import com.chad.library.adapter.base.BaseQuickAdapter
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.dip
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.verticalLayout
import org.jetbrains.anko.wrapContent
import repos.model.CompanyItem
import repos.model.SearchJsonModel
import service.impl.TycPresenter

/**
 * Created by Univer Quie on 2019/1/23.
 * @author: Univer Quie
 * @email: 397826579@qq.com
 */
abstract class DemoAnkoInitView : AbsAnkoAcitivity() {
    lateinit var companyAdapter: CompanyAdapter
    lateinit var searchView: SearchView

    override fun initView() {
        constraintLayout {
            verticalLayout().lparams {
                width = matchParent
                height = dip(40)
                background = resources.getDrawable(android.R.color.white)
                searchView = searchView.lparams {
                    width = matchParent
                    height = wrapContent
                    background = resources.getDrawable(R.drawable.search_shape)
                }
                initSeachView(searchView)
                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        TycPresenter.search_sNorV3(this@DemoAnkoInitView, query, object : AbsView<SearchJsonModel>() {
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
                })
            }

            recyclerView {
                layoutManager = LinearLayoutManager(this@DemoAnkoInitView)
                companyAdapter = CompanyAdapter()
                adapter = companyAdapter

                companyAdapter.onItemClickListener = BaseQuickAdapter.OnItemClickListener { adapter, view, position ->
                    var item: Any? = adapter.getItem(position)
                    if (item is CompanyItem) {
                        var bundle = Bundle()
                        bundle.putString("companyId", item.id)
                        goActivity(this@DemoAnkoInitView, CompanyDetailsActivity::class.java, bundle)
                    }
                }

            }.lparams(width = matchParent) {
                height = matchParent
            }

        }

    }
}