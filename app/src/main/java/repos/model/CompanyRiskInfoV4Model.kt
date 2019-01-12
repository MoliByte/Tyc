package repos.model

/**
 * Created by Univer Quie on 2019/1/12.
 * @author: Univer Quie
 * @email: 397826579@qq.com
 * CompanyRiskInfoV4Model
 */
data class CompanyRiskInfoV4Model(
        var `data`: List<CompanyRiskInfoV4Data?>?,
        var isLogin: Int?,
        var message: String?,
        var special: String?,
        var state: String?,
        var vipMessage: String?
)

data class CompanyRiskInfoV4Data(
        var count: Int?,
        var list: List<X?>?,
        var name: String?,
        var otherCount: Int?,
        var type: Int?
)

data class X(
        var id: Int?,
        var riskCount: Int?,
        var title: String?,
        var type: Int?
)