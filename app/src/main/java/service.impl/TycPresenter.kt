package service.impl

import belink.http.ApiClient
import belink.http.BodyBuilder
import belink.view.IView
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import repos.model.*

/**
 * Created by Univer Quie on 2019/1/11.
 * @author: Univer Quie
 * @email: 397826579@qq.com
 */
object TycPresenter : AbsTycPresenter() {


    /**
     * 登录
     */
    override fun authLogin(context: RxAppCompatActivity, body: BodyBuilder?, lang: String?, iView: IView<BaseInfoModel>) {
//        var bodyBuilder = BodyBuilder()
//        bodyBuilder.device = "HUAWEI NXT-TL00"
//        bodyBuilder.identifyCode = "868403023301291212"
//        bodyBuilder.os = "HUAWEI NXT-TL00"
//        bodyBuilder.platform = "android"
//        bodyBuilder.channel = ""
//        bodyBuilder.channelCode = ""
//        bodyBuilder.type = "F"
//        bodyBuilder.email = "univer.zhu@croninfo.com"
//        bodyBuilder.password = "111111"
        getObserver(context, ApiClient.instance.service.authLogin(body, lang))
                .subscribe(CallBack(context, iView).callback)
    }

    //首页热门搜索
    override fun searchHomePageHotWord(context: RxAppCompatActivity, iView: IView<HomePageHotWordModel>) {
        getObserver(context, ApiClient.instance.service.searchhHomePageHotWord(authorization, version))
                .subscribe(CallBack(context, iView).callback)
    }


    //热门搜索
    override fun hotSearchWxHotWord(context: RxAppCompatActivity, iView: IView<HotSearchModel>) {
        getObserver(context, ApiClient.instance.service.hotSearchWxHotWord(authorization, version))
                .subscribe(CallBack(context, iView).callback)
    }


    //公司搜索
    override fun search_sNorV3(context: RxAppCompatActivity, searchName: String?, iView: IView<SearchJsonModel>) {
        getObserver(context, ApiClient.instance.service.search_sNorV3(authorization, version, searchName))
                .subscribe(CallBack(context, iView).callback)
    }

    //公司详情
    override fun tCommonBaseInfoV5(context: RxAppCompatActivity, companyId: String?, iView: IView<CompanyInfoModel>) {
        getObserver(context, ApiClient.instance.service.tCommonBaseInfoV5(authorization, version, companyId))
                .subscribe(CallBack(context, iView).callback)
    }

    /**
     * 公司详情
     */
    override fun detailsAppComIcV3(context: RxAppCompatActivity, companyId: String?, pageSize: String?, iView: IView<CompanyBaseInfoDetails>) {
        getObserver(context, ApiClient.instance.service.detailsAppComIcV3(authorization, version, companyId, pageSize))
                .subscribe(CallBack(context, iView).callback)
    }

    /**
     *
     * URL	https://api9.tianyancha.com/services/v3/expanse/allCountV3?id=720901373
     */
    override fun expanseAllCountV3(context: RxAppCompatActivity, id: String?, pageSize: String?, iView: IView<ExpanseAllCountV3Model>) {
        getObserver(context, ApiClient.instance.service.expanseAllCountV3(authorization, version, id, pageSize))
                .subscribe(CallBack(context, iView).callback)
    }

    /**
     * 员工
     */
    override fun expanseStaff(context: RxAppCompatActivity, id: String?, pageNum: String?, pageSize: String?, iView: IView<StaffModel>) {
        getObserver(context, ApiClient.instance.service.expanseStaff(authorization, version, id, pageNum, pageSize))
                .subscribe(CallBack(context, iView).callback)
    }

    /**
     * 股东
     */
    override fun expanseHolder(context: RxAppCompatActivity, id: String?, pageNum: String?, pageSize: String?, iView: IView<HolderModel>) {
        getObserver(context, ApiClient.instance.service.expanseHolder(authorization, version, id, pageNum, pageSize))
                .subscribe(CallBack(context, iView).callback)
    }

    /**
     * 投资
     */
    override fun expanseInverstV2(context: RxAppCompatActivity, id: String?, pageNum: String?, pageSize: String?, iView: IView<InverstV2Model>) {
        getObserver(context, ApiClient.instance.service.expanseInverstV2(authorization, version, id, pageNum, pageSize))
                .subscribe(CallBack(context, iView).callback)
    }

    /**
     *变更信息
     */
    override fun expanseChangeinfoEm3(context: RxAppCompatActivity, id: String?, pageNum: String?, pageSize: String?, iView: IView<ChangeinfoEm3Model>) {
        getObserver(context, ApiClient.instance.service.expanseChangeinfoEm3(authorization, version, id, pageNum, pageSize))
                .subscribe(CallBack(context, iView).callback)
    }

    /**
     * Annu
     */
    override fun expanseAnnu(context: RxAppCompatActivity, id: String?, pageNum: String?, pageSize: String?, iView: IView<AnnuModel>) {
        getObserver(context, ApiClient.instance.service.expanseAnnu(authorization, version, id, pageNum, pageSize))
                .subscribe(CallBack(context, iView).callback)
    }

    /**
     * 历史融资
     */
    override fun expanseFindHistoryRongzi(context: RxAppCompatActivity, name: String?, pageNum: String?, pageSize: String?, iView: IView<FindHistoryRongziModel>) {
        getObserver(context, ApiClient.instance.service.expanseFindHistoryRongzi(authorization, version, name, pageNum, pageSize))
                .subscribe(CallBack(context, iView).callback)
    }

    /**
     * 风险
     */
    override fun riskCompanyRiskInfoV4(context: RxAppCompatActivity, id: String?, iView: IView<CompanyRiskInfoV4Model>) {
        getObserver(context, ApiClient.instance.service.riskCompanyRiskInfoV4(authorization, version, id))
                .subscribe(CallBack(context, iView).callback)
    }

    /**
     * anre
     */
    override fun arAnre(context: RxAppCompatActivity, id: String?, iView: IView<AnreModel>) {
        getObserver(context, ApiClient.instance.service.arAnre(authorization, version, id))
                .subscribe(CallBack(context, iView).callback)
    }

    /**
     * 投资
     */
    override fun investInvAgencyInfos(context: RxAppCompatActivity, id: String?, iView: IView<InvAgencyInfosModel>) {
        getObserver(context, ApiClient.instance.service.investInvAgencyInfos(authorization, version, id))
                .subscribe(CallBack(context, iView).callback)
    }
}