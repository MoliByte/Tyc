package repos.model

/**
 * Created by zhupei on 2019/1/12.
 * @author: zhupei
 * @email: 397826579@qq.com
 */
data class StaffModel(
        var `data`: StaffData?

):BaseInfoModel()

data class StaffData(
        var result: List<StaffResult?>?,
        var total: Int?
)

data class StaffResult(
        var id: Int?,
        var logo: String?,
        var name: String?,
        var toco: Int?,
        var type: Int?,
        var typeJoin: List<String?>?
)