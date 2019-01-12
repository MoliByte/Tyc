package repos.model

/**
 * Created by Univer Quie on 2019/1/12.
 * @author: Univer Quie
 * @email: 397826579@qq.com
 */
data class HomePageHotWordModel(
        var `data`: HomePageData = HomePageData()
):BaseInfoModel()

data class HomePageData(
        var hotHuman: HotHuman = HotHuman(),
        var hotRelation: List<HotRelation> = listOf(),
        var hotword: List<String> = listOf()
)

data class HotRelation(
        var fromnode: Fromnode = Fromnode(),
        var title: String = "",
        var tonode: Tonode = Tonode()
)

data class Tonode(
        var id: Long = 0,
        var name: String = "",
        var type: Int = 0
)

data class Fromnode(
        var id: Long = 0,
        var name: String = "",
        var type: Int = 0
)

data class HotHuman(
        var resultList: List<Result> = listOf()
)

data class Result(
        var cid: Long = 0,
        var code: String = "",
        var companyNum: Int = 0,
        var headUrl: String = "",
        var hid: Long = 0,
        var name: String = "",
        var office: List<HomePageOffice> = listOf(),
        var partners: List<Partner> = listOf()
)

data class HomePageOffice(
        var area: String = "",
        var cid: Long = 0,
        var companyName: String = "",
        var score: Int = 0,
        var total: Int = 0
)

data class Partner(
        var cid: Long = 0,
        var companyName: String = "",
        var headUrl: String = "",
        var hid: Long = 0,
        var name: String = ""
)