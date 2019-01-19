package belink.spark.com.tyc

import android.util.Log
import belink.view.AbsView
import repos.model.CompanyInfoModel
import repos.model.CompanyRiskInfoV4Model
import service.impl.TycPresenter

class CompanyDetailsActivity : AbsCompanyDetailsActivity() {

    val mContent: StringBuffer = StringBuffer()

    override fun initData() {
        val companyId = intent.getStringExtra("companyId")
        Log.e(TAG, "companyId = " + companyId)
        TycPresenter.tCommonBaseInfoV5(this, companyId, object : AbsView<CompanyInfoModel>() {
            override fun success(data: CompanyInfoModel) {
                val baseInfoModel: CompanyInfoModel? = data
                Log.e(TAG, baseInfoModel?.state)
                mContent.append(baseInfoModel.toString())
                text.text = mContent.toString()
            }
        })

        TycPresenter.riskCompanyRiskInfoV4(this, companyId, object : AbsView<CompanyRiskInfoV4Model>() {
            override fun success(data: CompanyRiskInfoV4Model) {
                val baseInfoModel: CompanyRiskInfoV4Model? = data
                mContent.append(baseInfoModel.toString())
                text.text = mContent.toString()
            }
        })


    }
}