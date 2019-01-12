package repos.model

/**
 * Created by zhupei on 2019/1/12.
 * @author: zhupei
 * @email: 397826579@qq.com
 */
data class HolderModel(
        var `data`: HolderData?
) : BaseInfoModel()

data class HolderData(
        var result: List<HolderResult?>?,
        var total: Int?
)

data class HolderResult(
        var alias: String?,
        var capital: List<HolderCapital?>?,
        var capitalActl: List<Any?>?,
        var id: Long?,
        var logo: String?,
        var name: String?,
        var toco: Int?,
        var type: Int?
)

data class HolderCapital(
        var amomon: String?,
        var percent: String?
)