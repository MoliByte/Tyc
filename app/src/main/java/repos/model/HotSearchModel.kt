package repos.model

/**
 * Created by zhupei on 2019/1/12.
 * @author: zhupei
 * @email: 397826579@qq.com
 *
 * tyc 热搜
 */
data class HotSearchModel(
        var data: List<Data> = listOf()
) : BaseInfoModel() {
    override fun toString(): String {
        return "HotSearchModel(data=$data)"
    }
}

data class Data(
        var alias: String = "",
        var cid: Long = 0,
        var companyName: String = "",
        var companyType: Int = 0,
        var legalPersonName: String = "",
        var logo: String = "",
        var regCapital: String = "",
        var title: String = "",
        var wordType: Int = 0
)