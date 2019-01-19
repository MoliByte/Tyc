package belink.adapter

import belink.spark.com.tyc.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import repos.model.CompanyItem
import repos.model.HotResult

/**
 * Created by Univer Quie on 2019/1/19.
 * @author: Univer Quie
 * @email: 397826579@qq.com
 */

//热搜
open class HotSearchAdapter : BaseQuickAdapter<HotResult, BaseViewHolder>(R.layout.item_hot_search_company) {

    override fun convert(helper: BaseViewHolder, item: HotResult) {
        helper.setText(R.id.tv_name, item.office[0].companyName)
    }
}

//公司搜索结果列表
open class CompanyAdapter : BaseQuickAdapter<CompanyItem, BaseViewHolder>(R.layout.item_company) {

    override fun convert(helper: BaseViewHolder, item: CompanyItem) {
        helper.setText(R.id.tv_name, item.name)
    }
}
