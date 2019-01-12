package repos.model

/**
 * Created by Univer Quie on 2019/1/12.
 * @author: Univer Quie
 * @email: 397826579@qq.com
 * AnnuModel
 */

data class AnnuModel(
        var `data`: List<AnnuData?>?
) : BaseInfoModel()

data class AnnuData(
        var id: Long?,
        var reportYear: String?
)