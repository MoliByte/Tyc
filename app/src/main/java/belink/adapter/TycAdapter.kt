package belink.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by Univer Quie on 2019/1/19.
 * @author: Univer Quie
 * @email: 397826579@qq.com
 */

// parent abs adapter 抽象类，具体实现请到initItemData实现，实例请看 BaseActivity

abstract class AbsTycAdapter<T : Any>(id: Int) : BaseQuickAdapter<T, BaseViewHolder>(id) {

    override fun convert(helper: BaseViewHolder, item: T) {
        initItemData(helper, item)
    }

    //初始化item数据
    abstract fun initItemData(helper: BaseViewHolder, item: T)
}
