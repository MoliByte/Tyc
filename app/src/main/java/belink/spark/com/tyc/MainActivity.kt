package belink.spark.com.tyc

import android.util.Log
import belink.view.AbsView
import repos.model.HomePageHotWordModel
import service.impl.TycPresenter

class MainActivity : AbsMainActivit() {

    override fun initData() {
//        TycPresenter.authLogin(this, bodyBuilder, loginCallBack)
//        TycPresenter.search_sNorV3(this, "平安科技有限公司", searchCallBack)
//        TycPresenter.tCommonBaseInfoV5(this, "199557844", baseInfoCallBack)
//        TycPresenter.hotSearchWxHotWord(this, hotSearchCallBack)
        TycPresenter.searchHomePageHotWord(this, object : AbsView<HomePageHotWordModel>() {
            override fun success(data: HomePageHotWordModel) {
                val baseInfoModel: HomePageHotWordModel? = data
                Log.e(TAG, baseInfoModel?.state)
            }
        })
    }
}