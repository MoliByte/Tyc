package repos.model

/**
 * Created by Univer Quie on 2019/1/12.
 * @author: Univer Quie
 * @email: 397826579@qq.com
 * FindHistoryRongziModel
 */
data class FindHistoryRongziModel(
        var `data`: FindHistoryRongziData?,
        var isLogin: Int?,
        var message: String?,
        var special: String?,
        var state: String?,
        var vipMessage: String?
)

data class FindHistoryRongziData(
        var page: Page?
)

data class Page(
        var pageNo: Int?,
        var pageSize: Int?,
        var rows: List<Row?>?,
        var total: Int?
)

data class Row(
        var companyId: Int?,
        var companyName: String?,
        var createTime: Any?,
        var date: Long?,
        var graphId: Any?,
        var id: Any?,
        var investId: Any?,
        var investorGid: Any?,
        var investorName: String?,
        var isDeleted: Int?,
        var money: String?,
        var moneyNumber: Any?,
        var newsTitle: String?,
        var newsUrl: String?,
        var organizationName: String?,
        var rongziMap: Any?,
        var round: String?,
        var share: String?,
        var shareNumber: Any?,
        var sourceWeb: Int?,
        var tzrIds: String?,
        var updateTime: Any?,
        var value: String?,
        var valueNumber: Any?
)