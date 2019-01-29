package repos.model

/**
 * Created by Univer Quie on 2019/1/12.
 * @author: Univer Quie
 * @email: 397826579@qq.com
 *
 * tyc 热搜
 */
data class HotSearchModel(
        var data: List<WxHotWordCompanyData> = listOf()
) : BaseInfoModel() {
    override fun toString(): String {
        return "HotSearchModel(data=$data)"
    }
}

data class WxHotWordCompanyData(
        var alias: String = "",
        var cid: String = "",
        var companyName: String = "",
        var companyType: Int = 0,
        var legalPersonName: String = "",
        var logo: String = "",
        var regCapital: String = "",
        var title: String = "",
        var wordType: Int = 0
)