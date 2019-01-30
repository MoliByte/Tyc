package belink.spark.com.tyc

import belink.view.AbsView
import repos.model.HomePageHotWordModel
import repos.model.HotSearchModel
import service.impl.TycPresenter

class MainActivity : AbsMainActivit() {

    override fun initData() {
        TycPresenter.searchHomePageHotWord(this, object : AbsView<HomePageHotWordModel>() {
            override fun success(data: HomePageHotWordModel) {
                val baseInfoModel: HomePageHotWordModel? = data
                mHotSearchAdapter?.setNewData(baseInfoModel?.data?.hotHuman?.resultList)
            }
        })

        TycPresenter.hotSearchWxHotWord(this, object : AbsView<HotSearchModel>() {
            override fun success(data: HotSearchModel) {
                val baseInfoModel: HotSearchModel? = data
                mWxHotSearchAdapter?.setNewData(baseInfoModel?.data)
            }
        })
    }


}