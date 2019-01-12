package repos.model

/**
 * Created by zhupei on 2019/1/12.
 * @author: zhupei
 * @email: 397826579@qq.com
 */
data class TokenModel(
        var `data`: TokenData = TokenData()
) : BaseInfoModel() {
    override fun toString(): String {
        return "TokenModel(`data`=$`data`, isLogin=$isLogin, message='$message', special='$special', state='$state', vipMessage='$vipMessage')"
    }
}

data class TokenData(
        var Authorization: String = ""
)