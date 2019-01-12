package repos.model

/**
 * Created by zhupei on 2019/1/12.
 * @author: zhupei
 * @email: 397826579@qq.com
 * InvAgencyInfosModel
 */

data class InvAgencyInfosModel(
        var `data`: InvAgencyInfosData?,
        var isLogin: Int?,
        var message: String?,
        var special: String?,
        var state: String?,
        var vipMessage: String?
)

data class InvAgencyInfosData(
        var base_info: InvAgencyInfosBaseInfo?,
        var business_event: BusinessEvent?,
        var ext_funds: ExtFunds?,
        var fund_manager: FundManager?,
        var funds: Funds?,
        var public_invest: PublicInvest?,
        var secret_invest: SecretInvest?,
        var stastics: String?,
        var team_member: TeamMember?
)

data class BusinessEvent(
        var business_event_count: Int?,
        var business_event_list: List<BusinessEventList?>?
)

data class BusinessEventList(
        var alias: String?,
        var invest_time: String?,
        var percentage: String?,
        var source_id: String?,
        var source_logo: String?,
        var source_name: String?,
        var target_id: String?,
        var target_name: String?
)

data class SecretInvest(
        var secret_invest_count: Int?,
        var secret_invest_list: List<SecretInvestList?>?
)

data class SecretInvestList(
        var alias: String?,
        var company_id: Int?,
        var company_logo: String?,
        var company_name: String?,
        var estiblish_date: String?,
        var investor_list: List<InvAgencyInfosInvestor?>?,
        var legal_person_id: Int?,
        var legal_person_name: String?,
        var legal_person_toco: Int?,
        var legal_person_type: Int?,
        var reg_capital: String?
)

data class InvAgencyInfosInvestor(
        var investor_id: Long?,
        var investor_name: String?
)

data class InvAgencyInfosBaseInfo(
        var base: String?,
        var desc: String?,
        var found_date: String?,
        var id: Int?,
        var logo: String?,
        var name: String?,
        var stage: String?,
        var type: String?
)

data class TeamMember(
        var member_count: Int?,
        var member_list: List<Member?>?
)

data class Member(
        var desc: String?,
        var logo: String?,
        var name: String?,
        var position: String?,
        var position_list: List<String?>?
)

data class ExtFunds(
        var ex_fund_count: Int?,
        var ex_fund_list: List<ExFund?>?
)

data class ExFund(
        var alias: String?,
        var company_id: Long?,
        var company_logo: String?,
        var company_name: String?,
        var estiblish_date: String?,
        var investor_list: List<Investor?>?,
        var legal_person_id: Long?,
        var legal_person_name: String?,
        var legal_person_toco: Int?,
        var legal_person_type: Int?,
        var reg_capital: String?
)


data class Funds(
        var fund_count: Int?,
        var fund_list: List<Fund?>?
)

data class Fund(
        var alias: String?,
        var company_id: Int?,
        var company_logo: String?,
        var company_name: String?,
        var estiblish_date: String?,
        var legal_person_id: Int?,
        var legal_person_name: String?,
        var legal_person_toco: Int?,
        var legal_person_type: Int?
)

data class PublicInvest(
        var invest_count: Int?,
        var invest_list: List<Invest?>?
)

data class Invest(
        var intro: String?,
        var invest_date: String?,
        var logo: String?,
        var money: String?,
        var product: String?,
        var product_id: String?,
        var round: String?,
        var tag_list: List<String?>?
)

data class FundManager(
        var fund_manager_count: Int?,
        var fund_manager_list: List<FundManagerList?>?
)

data class FundManagerList(
        var alias: String?,
        var company_id: Long?,
        var company_logo: String?,
        var company_name: String?,
        var estiblish_date: String?,
        var legal_person_id: Int?,
        var legal_person_name: String?,
        var legal_person_toco: Int?,
        var legal_person_type: Int?,
        var reg_capital: String?
)
