package belink.spark.com.tyc

import android.util.Log
import belink.view.AbsView
import repos.model.CompanyInfoModel
import repos.model.CompanyRiskInfoV4Model
import repos.model.HolderModel
import service.impl.TycPresenter

class CompanyDetailsActivity : AbsCompanyDetailsActivity() {

    val mContent: StringBuffer = StringBuffer()

    override fun initData() {
        val companyId = intent.getStringExtra("companyId")
        Log.e(TAG, "companyId = " + companyId)

        companyId?.let {
            //公司基础信息
            TycPresenter.tCommonBaseInfoV5(this, companyId, object : AbsView<CompanyInfoModel>() {
                override fun success(data: CompanyInfoModel) {
                    val baseInfoModel: CompanyInfoModel? = data
                    Log.e(TAG, baseInfoModel?.state)
                    mContent.append(baseInfoModel.toString())
                    text.text = mContent.toString()
                }
            })

            //公司风险信息
            TycPresenter.riskCompanyRiskInfoV4(this, companyId, object : AbsView<CompanyRiskInfoV4Model>() {
                override fun success(data: CompanyRiskInfoV4Model) {
                    val baseInfoModel: CompanyRiskInfoV4Model? = data
                    mContent.append(baseInfoModel.toString())
                    text.text = mContent.toString()
                }
            })

            //股东信息
            TycPresenter.expanseHolder(this, companyId, "1", "20", object : AbsView<HolderModel>() {
                override fun success(data: HolderModel) {
                    val baseInfoModel: HolderModel? = data
                    mContent.append(baseInfoModel.toString())
                    text.text = mContent.toString()
                }
            })
        }
    }
}