package repos.model

/**
 * Created by Univer Quie on 2019/1/12.
 * @author: Univer Quie
 * @email: 397826579@qq.com
 *
 * ChangeinfoEm3Model
 */
data class ChangeinfoEm3Model(
    var `data`: ChangeinfoEm3Data?,
    var isLogin: Int?,
    var message: String?,
    var special: String?,
    var state: String?,
    var vipMessage: String?
)

data class ChangeinfoEm3Data(
    var changeItem_lmbx: List<ChangeItemLmbx?>?,
    var ishide: Boolean?,
    var result: List<ChangeinfoEm3Result?>?,
    var total: Int?
)

data class ChangeinfoEm3Result(
    var changeItem: String?,
    var changeTime: String?,
    var contentAfter: String?,
    var contentBefore: String?,
    var createTime: String?
)

data class ChangeItemLmbx(
    var key: String?,
    var value: String?
)