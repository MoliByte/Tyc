package repos.model

/**
 * Created by Univer Quie on 2019/1/12.
 * @author: Univer Quie
 * @email: 397826579@qq.com
 *
 * AnreModel
 */
data class AnreModel(
        var `data`: AnreData?,
        var isLogin: Int?,
        var message: String?,
        var special: String?,
        var state: String?,
        var vipMessage: String?
)

data class AnreData(
        var baseInfo: AnreBaseInfo?,
        var changeRecordList: List<Any?>?,
        var companyId: String?,
        var equityChangeInfoList: List<Any?>?,
        var govReport: Any?,
        var outGuaranteeInfoList: List<Any?>?,
        var outboundInvestmentList: List<Any?>?,
        var reportSocialSecurityInfo: ReportSocialSecurityInfo?,
        var shareholderList: List<Shareholder?>?,
        var type: Int?,
        var webInfoList: List<WebInfo?>?
)

data class ReportSocialSecurityInfo(
        var annaulreportId: Long?,
        var createTime: Long?,
        var employmentInjuryInsurance: String?,
        var employmentInjuryInsuranceOweAmount: String?,
        var employmentInjuryInsurancePayAmount: String?,
        var endowmentInsurance: String?,
        var endowmentInsuranceBase: String?,
        var endowmentInsuranceOweAmount: String?,
        var endowmentInsurancePayAmount: String?,
        var id: Any?,
        var maternityInsurance: String?,
        var maternityInsuranceBase: String?,
        var maternityInsuranceOweAmount: String?,
        var maternityInsurancePayAmount: String?,
        var medicalInsurance: String?,
        var medicalInsuranceBase: String?,
        var medicalInsuranceOweAmount: String?,
        var medicalInsurancePayAmount: String?,
        var unemploymentInsurance: String?,
        var unemploymentInsuranceBase: String?,
        var unemploymentInsuranceOweAmount: String?,
        var unemploymentInsurancePayAmount: String?
)

data class AnreBaseInfo(
        var companyName: String?,
        var creditCode: String?,
        var email: String?,
        var employeeNum: String?,
        var manageState: String?,
        var operatorName: String?,
        var phoneNumber: String?,
        var postalAddress: String?,
        var postcode: String?,
        var primeBusProfit: String?,
        var regNumber: String?,
        var reportYear: String?,
        var retainedProfit: String?,
        var totalAssets: String?,
        var totalEquity: String?,
        var totalLiability: String?,
        var totalProfit: String?,
        var totalSales: String?,
        var totalTax: String?
)

data class Shareholder(
        var clickId: String?,
        var investorName: String?,
        var paidAmount: String?,
        var paidTime: String?,
        var paidType: String?,
        var reportYear: Any?,
        var subscribeAmount: String?,
        var subscribeTime: String?,
        var subscribeType: String?,
        var toco: Any?,
        var type: String?
)

data class WebInfo(
        var name: String?,
        var reportYear: Any?,
        var webType: String?,
        var website: String?
)