package repos.model

/**
 * Created by Univer Quie on 2019/1/11.
 * @author: Univer Quie
 * @email: 397826579@qq.com
 */

data class SearchJsonModel(
    var data: SearchData? = null
):BaseInfoModel() {
    override fun toString(): String {
        return "SearchJsonModel(data=$data)"
    }
}

data class SearchData (
    var modifiedQuery: String? = "",
    var companyTotalPage: String? = "",
    var humanCount: String? = "",
    var companyList: List<CompanyList>? = null
){
    override fun toString(): String {
        return "SearchData(modifiedQuery=$modifiedQuery, companyTotalPage=$companyTotalPage, humanCount=$humanCount, companyList=$companyList)"
    }

}

class CompanyList {
    var id: String? = ""
    var name: String? = ""
    var type: String? = ""
    var matchType: String? = ""
    var base: String? = ""
    var legalPersonName: String? = ""
    var estiblishTime: String? = ""
    var regCapital: String? = ""
    var regStatus: String? = ""
    var creditCode: String? = ""
    var businessScope: String? = ""
    var regLocation: String? = ""
    var phone: String? = ""
    var phoneList: List<String>? = null
    var phoneNum: String? = ""
    var logo: String? = ""
    var city: String? = ""
    var emails: String? = ""
    var emailList: List<String>? = null
    var websites: String? = ""
    var tagList: List<String>? = null
    var companyType: String? = ""
    var companyOrgType: String? = ""

    var labelList: List<String>? = null
    var latitude: Double? = 0.0000
    var longitude: Double? = 0.0000

    var legalPersonType: String? = ""
    var categoryStr: String? = ""
    var isClaimed: String? = ""
    var isBranch: String? = ""
    var alias: String? = ""
    override fun toString(): String {
        return "CompanyList(id=$id, name=$name, type=$type, matchType=$matchType, base=$base, legalPersonName=$legalPersonName, estiblishTime=$estiblishTime, regCapital=$regCapital, regStatus=$regStatus, creditCode=$creditCode, businessScope=$businessScope, regLocation=$regLocation, phone=$phone, phoneList=$phoneList, phoneNum=$phoneNum, logo=$logo, city=$city, emails=$emails, emailList=$emailList, websites=$websites, tagList=$tagList, companyType=$companyType, companyOrgType=$companyOrgType, labelList=$labelList, latitude=$latitude, longitude=$longitude, legalPersonType=$legalPersonType, categoryStr=$categoryStr, isClaimed=$isClaimed, isBranch=$isBranch, alias=$alias)"
    }


}