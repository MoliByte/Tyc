package repos.model

/**
 * Created by Univer Quie on 2019/1/12.
 * @author: Univer Quie
 * @email: 397826579@qq.com
 */
data class InverstV2Model(
        var `data`: InverstV2Data?
) : BaseInfoModel()

data class InverstV2Data(
        var result: List<Any?>?,
        var total: Int?
)