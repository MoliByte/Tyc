package repos.model

/**
 * Created by zhupei on 2019/1/11.
 * @author: zhupei
 * @email: 397826579@qq.com
 */

data class CompanyInfoModel(
        var data: InfoData? = null
) : BaseInfoModel() {
    override fun toString(): String {
        return "CompanyInfoModel(state=$state, message=$message, special=$special, vipMessage=$vipMessage, isLogin=$isLogin, data=$data)"
    }
}

data class InfoData(
        var isBranch: String? = "",
        var staffNumRange: String? = "",
        var updatetime: String? = "",
        var phoneList: List<String>? = null,
        var portray: String? = null,
        var fromTime: String? = null,
        var type: String? = null,
        var entityType: String? = null,
        var emailList: List<String>? = null,
        var usedBondName: String? = null,
        var isHightTech: String? = null,
        var percentileScore: String? = null,
        var haveReport: String? = null,
        var regInstitute: String? = null,
        var regLocation: String? = null,
        var industry: String? = null,
        var businessScope: String? = null,
        var equityUrl: String? = null,
        var property3: String? = null,
        var orgNumber: String? = null,
        var regStatus: String? = null,
        var estiblishTime: String? = null,
        var bondType: String? = null,
        var legalPersonName: String? = null,
        var ownId: String? = null,
        var legalPersonId: String? = null,
        var sourceFlag: String? = null,
        var isClaimed: String? = null,
        var actualCapital: String? = null,
        var websiteList: String? = null,
        var flag: String? = null,
        var correctCompanyId: String? = null,
        var email: String? = null,
        var updateTimes: String? = null,
        var creditCode: String? = null,
        var historyNames: String? = null,
        var bondNum: String? = null,
        var weibo: String? = null,
        var categoryScore: String? = null,
        var bondName: String? = null,
        var isMicroEnt: String? = null,
        var id: String? = null,
        var regNumber: String? = null,
        var regCapital: String? = null,
        var name: String? = null,
        var approvedTime: String? = null,
        var socialStaffNum: String? = null,
        var tags: String? = null,
        var logo: String? = null,
        var taxNumber: String? = null,
        var alias: String? = null,
        var legalInfo: LegalInfo? = null,
        var baseInfo: String? = null,
        var toTime: String? = null,
        var companyOrgType: String? = null,
        var base: String? = null,
        var companyType: String? = null,
        var companyId: String? = null


) {
    override fun toString(): String {
        return "InfoData(isBranch=$isBranch, staffNumRange=$staffNumRange, updatetime=$updatetime, phoneList=$phoneList, portray=$portray, fromTime=$fromTime, entityType=$entityType, emailList=$emailList, usedBondName=$usedBondName, isHightTech=$isHightTech, percentileScore=$percentileScore, haveReport=$haveReport, regInstitute=$regInstitute, regLocation=$regLocation, industry=$industry, businessScope=$businessScope, equityUrl=$equityUrl, property3=$property3, orgNumber=$orgNumber, regStatus=$regStatus, estiblishTime=$estiblishTime, bondType=$bondType, legalPersonName=$legalPersonName, ownId=$ownId, legalPersonId=$legalPersonId, sourceFlag=$sourceFlag, isClaimed=$isClaimed, actualCapital=$actualCapital, websiteList=$websiteList, flag=$flag, correctCompanyId=$correctCompanyId, email=$email, updateTimes=$updateTimes, creditCode=$creditCode, historyNames=$historyNames, bondNum=$bondNum, weibo=$weibo, categoryScore=$categoryScore, bondName=$bondName, isMicroEnt=$isMicroEnt, id=$id, regNumber=$regNumber, regCapital=$regCapital, name=$name, approvedTime=$approvedTime, socialStaffNum=$socialStaffNum, tags=$tags, logo=$logo, taxNumber=$taxNumber, alias=$alias, legalInfo=$legalInfo, baseInfo=$baseInfo, toTime=$toTime, companyOrgType=$companyOrgType, base=$base, companyType=$companyType, companyId=$companyId)"
    }
}

data class LegalInfo(
        var hid: String? = null,
        var name: String? = null,
        var companyNum: String? = null,
        var cid: String? = null,
        var office: List<Office>? = null
) {
    override fun toString(): String {
        return "LegalInfo(hid=$hid, name=$name, companyNum=$companyNum, cid=$cid, office=$office)"
    }

}

data class Office(
        var total: String? = "",
        var area: String? = "",
        var score: String? = "",
        var companyName: String? = "",
        var cid: String? = ""

) {
    override fun toString(): String {
        return "Office(total=$total, area=$area, score=$score, companyName=$companyName, cid=$cid)"
    }
}