package belink.view

import belink.http.BodyBuilder
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import repos.model.*

/**
 * Created by zhupei on 2019/1/12.
 * @author: zhupei
 * @email: 397826579@qq.com
 */
interface ITycService {
    /**
     * 登录
     */
    fun authLogin(context: RxAppCompatActivity, body: BodyBuilder?, lang: String?, iView: IView<BaseInfoModel>)

    /**
     * 首页热门搜索
     */

    fun searchHomePageHotWord(context: RxAppCompatActivity, iView: IView<HomePageHotWordModel>)

    /**
     * 热门搜索
     */
    fun hotSearchWxHotWord(context: RxAppCompatActivity, iView: IView<HotSearchModel>)

    /**
     * 搜索公司-列表
     */
    fun search_sNorV3(context: RxAppCompatActivity, searchName: String?, iView: IView<SearchJsonModel>)

    /**
     * 公司详情
     */
    fun tCommonBaseInfoV5(context: RxAppCompatActivity, companyId: String?, iView: IView<CompanyInfoModel>)

    /**
     * 公司详情
     */
    fun detailsAppComIcV3(context: RxAppCompatActivity, companyId: String?, pageSize: String?, iView: IView<CompanyBaseInfoDetails>)

    /**
     *
     * URL	https://api9.tianyancha.com/services/v3/expanse/allCountV3?id=720901373
     */
    fun expanseAllCountV3(context: RxAppCompatActivity, id: String?, pageSize: String?, iView: IView<ExpanseAllCountV3Model>)

    /**
     * 员工
     */
    fun expanseStaff(context: RxAppCompatActivity, id: String?, pageNum: String?, pageSize: String?, iView: IView<StaffModel>)

    /**
     * 股东
     */
    fun expanseHolder(context: RxAppCompatActivity, id: String?, pageNum: String?, pageSize: String?, iView: IView<HolderModel>)

    /**
     * 投资
     */
    fun expanseInverstV2(context: RxAppCompatActivity, id: String?, pageNum: String?, pageSize: String?, iView: IView<InverstV2Model>)

    /**
     *变更信息
     */
    fun expanseChangeinfoEm3(context: RxAppCompatActivity, id: String?, pageNum: String?, pageSize: String?, iView: IView<ChangeinfoEm3Model>)

    /**
     * Annu
     */
    fun expanseAnnu(context: RxAppCompatActivity, id: String?, pageNum: String?, pageSize: String?, iView: IView<AnnuModel>)

    /**
     * 历史融资
     */
    fun expanseFindHistoryRongzi(context: RxAppCompatActivity, name: String?, pageNum: String?, pageSize: String?, iView: IView<FindHistoryRongziModel>)

    /**
     * 风险
     */
    fun riskCompanyRiskInfoV4(context: RxAppCompatActivity, id: String?, iView: IView<CompanyRiskInfoV4Model>)

    /**
     * anre
     */
    fun arAnre(context: RxAppCompatActivity, id: String?, iView: IView<AnreModel>)

    /**
     * 投资
     */
    fun investInvAgencyInfos(context: RxAppCompatActivity, id: String?, iView: IView<InvAgencyInfosModel>)


}