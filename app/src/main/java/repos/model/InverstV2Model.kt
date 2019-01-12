package repos.model

/**
 * Created by zhupei on 2019/1/12.
 * @author: zhupei
 * @email: 397826579@qq.com
 */
data class InverstV2Model(
        var `data`: InverstV2Data?
) : BaseInfoModel()

data class InverstV2Data(
        var result: List<Any?>?,
        var total: Int?
)