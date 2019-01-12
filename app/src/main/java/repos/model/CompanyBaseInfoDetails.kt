package repos.model

/**
 * Created by zhupei on 2019/1/12.
 * @author: zhupei
 * @email: 397826579@qq.com
 */
data class CompanyBaseInfoDetails(
        var `data`: CompanyBaseInfoDetailsData = CompanyBaseInfoDetailsData()
):BaseInfoModel()

data class CompanyBaseInfoDetailsData(
        var baseInfo: BaseInfo = BaseInfo(),
        var branchList: List<Branch> = listOf(),
        var comChanInfoList: List<ComChanInfo> = listOf(),
        var investorList: List<Investor> = listOf(),
        var managerList: List<Any> = listOf(),
        var staffList: List<Staff> = listOf()
)

data class Branch(
        var alias: String = "",
        var base: String = "",
        var category: String = "",
        var estiblishTime: Long = 0,
        var id: Long = 0,
        var legalPersonId: Int = 0,
        var legalPersonName: String = "",
        var name: String = "",
        var pencertileScore: Int = 0,
        var personType: Int = 0,
        var regCapital: String = "",
        var regStatus: String = "",
        var type: Int = 0
)

data class ComChanInfo(
        var changeItem: String = "",
        var changeTime: String = "",
        var contentAfter: String = "",
        var contentBefore: String = ""
)

data class BaseInfo(
        var actualCapital: String = "",
        var alias: String = "",
        var approvedTime: Long = 0,
        var base: String = "",
        var baseInfo: String = "",
        var businessScope: String = "",
        var categoryScore: Int = 0,
        var companyId: Int = 0,
        var companyOrgType: String = "",
        var companyType: Int = 0,
        var correctCompanyId: String = "",
        var creditCode: String = "",
        var email: String = "",
        var emailList: List<String> = listOf(),
        var entityType: Int = 0,
        var equityUrl: String = "",
        var estiblishTime: Long = 0,
        var flag: Int = 0,
        var fromTime: Long = 0,
        var haveReport: Boolean = false,
        var id: Int = 0,
        var industry: String = "",
        var isClaimed: Int = 0,
        var isHightTech: String = "",
        var isMicroEnt: Int = 0,
        var legalPersonId: Int = 0,
        var legalPersonName: String = "",
        var logo: String = "",
        var name: String = "",
        var orgNumber: String = "",
        var ownId: String = "",
        var percentileScore: Int = 0,
        var phoneList: List<String> = listOf(),
        var phoneNumber: String = "",
        var portray: String = "",
        var regCapital: String = "",
        var regInstitute: String = "",
        var regLocation: String = "",
        var regNumber: String = "",
        var regStatus: String = "",
        var socialStaffNum: Int = 0,
        var sourceFlag: String = "",
        var staffNumRange: String = "",
        var taxNumber: String = "",
        var toTime: Long = 0,
        var toco: Int = 0,
        var type: Int = 0,
        var updateTimes: Long = 0,
        var updatetime: Long = 0,
        var websiteList: String = ""
)

data class Staff(
        var id: Int = 0,
        var logo: String = "",
        var name: String = "",
        var toco: Int = 0,
        var type: Int = 0,
        var typeJoin: List<String> = listOf()
)

data class Investor(
        var alias: String = "",
        var capital: List<Capital> = listOf(),
        var capitalActl: List<Any> = listOf(),
        var id: Long = 0,
        var logo: String = "",
        var name: String = "",
        var toco: Int = 0,
        var type: Int = 0
)

data class Capital(
        var amomon: String = "",
        var percent: String = ""
)