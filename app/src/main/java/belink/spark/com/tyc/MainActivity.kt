package belink.spark.com.tyc

import android.util.Log
import belink.view.AbsView
import repos.model.HomePageHotWordModel
import service.impl.TycPresenter

class MainActivity : AbsMainActivit() {

    override fun initData() {
        TycPresenter.searchHomePageHotWord(this, object : AbsView<HomePageHotWordModel>() {
            override fun success(data: HomePageHotWordModel) {
                val baseInfoModel: HomePageHotWordModel? = data
                Log.e(TAG, baseInfoModel?.state)
                hotSearchAdapter?.setNewData(baseInfoModel?.data?.hotHuman?.resultList)
            }
        })
    }


}