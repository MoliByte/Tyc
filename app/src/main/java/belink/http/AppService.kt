package belink.http

import io.reactivex.Observable
import repos.model.*
import retrofit2.http.*

/**
 * Created by zhupei on 2019/1/10.
 * @author: zhupei
 * @email: 397826579@qq.com
 */
interface AppService {

    /**
     * 登录
     */
    @POST("auth/login")
    fun authLogin(@Body body: BodyBuilder?,
                  @Query("lang") lang: String?)
            : Observable<BaseInfoModel>

    /**
     * 首页热门搜索
     */
    @GET("search/homePageHotWord")
    fun searchhHomePageHotWord(
            @Header("authorization") authorization: String?,
            @Header("version") version: String?)
            : Observable<HomePageHotWordModel>

    /**
     * 热门搜索
     */
    @GET("hotSearch/wxHotWord")
    fun hotSearchWxHotWord(
            @Header("authorization") authorization: String?,
            @Header("version") version: String?)
            : Observable<HotSearchModel>

    /**
     * 搜索公司列表
     */
    @GET("search/sNorV3/{company}")
    fun search_sNorV3(
            @Header("authorization") authorization: String?,
            @Header("version") version: String?,
            //@Header("host") host: String?,
            @Path("company") company: String?)
            : Observable<SearchJsonModel>

    /**
     * 公司详情
     */
    @GET("t/common/baseinfoV5/{companyId}")
    fun tCommonBaseInfoV5(
            @Header("authorization") authorization: String?,
            @Header("version") version: String?,
            //@Header("host") host: String?,
            @Path("companyId") companyId: String?)
            : Observable<CompanyInfoModel>

    /**
     * 公司详情
     * URL	https://api9.tianyancha.com/services/v3/t/details/appComIcV3/720901373?pageSize=1000
     */
    @GET("t/details/appComIcV3/{companyId}")
    fun detailsAppComIcV3(
            @Header("authorization") authorization: String?,
            @Header("version") version: String?,
            @Path("companyId") companyId: String?,
            @Query("pageSize") pageSize: String?)
            : Observable<CompanyBaseInfoDetails>

    /**
     *
     * URL	https://api9.tianyancha.com/services/v3/expanse/allCountV3?id=720901373
     */
    @GET("expanse/allCountV3")
    fun expanseAllCountV3(
            @Header("authorization") authorization: String?,
            @Header("version") version: String?,
            @Query("id") id: String?,
            @Query("pageSize") pageSize: String?)
            : Observable<ExpanseAllCountV3Model>

    /**
     *
     * 员工
     * URL	https://api9.tianyancha.com/services/v3/expanse/staff?id=720901373&pageNum=1&pageSize=20
     */
    @GET("expanse/staff")
    fun expanseStaff(
            @Header("authorization") authorization: String?,
            @Header("version") version: String?,
            @Query("id") id: String?,
            @Query("pageNum") pageNum: String?,
            @Query("pageSize") pageSize: String?)
            : Observable<StaffModel>

    /**
     *
     * holder 股东
     * URL	https://api9.tianyancha.com/services/v3/expanse/holder?id=720901373&pageNum=1&pageSize=20
     */
    @GET("expanse/holder")
    fun expanseHolder(
            @Header("authorization") authorization: String?,
            @Header("version") version: String?,
            @Query("id") id: String?,
            @Query("pageNum") pageNum: String?,
            @Query("pageSize") pageSize: String?)
            : Observable<HolderModel>

    /**
     * inverstV2
     * URL	https://api9.tianyancha.com/services/v3/expanse/inverstV2?id=720901373&pageNum=1&pageSize=20
     */

    @GET("expanse/inverstV2")
    fun expanseInverstV2(
            @Header("authorization") authorization: String?,
            @Header("version") version: String?,
            @Query("id") id: String?,
            @Query("pageNum") pageNum: String?,
            @Query("pageSize") pageSize: String?)
            : Observable<InverstV2Model>

    /**
     * changeinfoEm3
     * URL	https://api9.tianyancha.com/services/v3/expanse/changeinfoEm3?id=720901373&pageNum=1&pageSize=20
     */

    @GET("expanse/changeinfoEm3")
    fun expanseChangeinfoEm3(
            @Header("authorization") authorization: String?,
            @Header("version") version: String?,
            @Query("id") id: String?,
            @Query("pageNum") pageNum: String?,
            @Query("pageSize") pageSize: String?)
            : Observable<ChangeinfoEm3Model>


    /**
     * annu
     * URL	https://api9.tianyancha.com/services/v3/expanse/annu?id=720901373&pageNum=1&pageSize=20
     */

    @GET("expanse/annu")
    fun expanseAnnu(
            @Header("authorization") authorization: String?,
            @Header("version") version: String?,
            @Query("id") id: String?,
            @Query("pageNum") pageNum: String?,
            @Query("pageSize") pageSize: String?)
            : Observable<AnnuModel>

    /**
     * findHistoryRongzi
     * URL	https://api9.tianyancha.com/services/v3/expanse/findHistoryRongzi?name=%E5%8C%97%E4%BA%AC%E6%8B%9C%E5%85%8B%E6%B4%9B%E5%85%8B%E7%A7%91%E6%8A%80%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&pageNum=1&pageSize=10
     */

    @GET("expanse/findHistoryRongzi")
    fun expanseFindHistoryRongzi(
            @Header("authorization") authorization: String?,
            @Header("version") version: String?,
            @Query("name") name: String?,
            @Query("pageNum") pageNum: String?,
            @Query("pageSize") pageSize: String?)
            : Observable<FindHistoryRongziModel>

    /**
     * 风险信息
     * URL	https://api9.tianyancha.com/services/v3/risk/companyRiskInfoV4/?id=720901373
     */

    @GET("risk/companyRiskInfoV4")
    fun riskCompanyRiskInfoV4(
            @Header("authorization") authorization: String?,
            @Header("version") version: String?,
            @Query("id") id: String?)
            : Observable<CompanyRiskInfoV4Model>

    /**
     * anre
     * URL	https://api9.tianyancha.com/services/v3/ar/anre/2858406117
     */

    @GET("ar/anre")
    fun arAnre(
            @Header("authorization") authorization: String?,
            @Header("version") version: String?,
            @Path("id") id: String?)
            : Observable<AnreModel>

    /**
     * invest
     * URL	https://api9.tianyancha.com/services/v3/invest/invAgencyInfos?id=b61f42891
     */

    @GET("invest/invAgencyInfos")
    fun investInvAgencyInfos(
            @Header("authorization") authorization: String?,
            @Header("version") version: String?,
            @Query("id") id: String?)
            : Observable<InvAgencyInfosModel>


}