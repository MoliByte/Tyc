package belink.view

import android.support.v7.widget.RecyclerView
import android.view.ViewManager
import belink.spark.tyc.App
import org.jetbrains.anko.custom.ankoView

/**
 * Created by Univer Quie on 2019/1/19.
 * @author: Univer Quie
 * @email: 397826579@qq.com
 * recycleview 的扩展
 */
inline fun ViewManager.recyclerView() = RecyclerView(App.instance,null,-1)
inline fun ViewManager.recyclerView(init: RecyclerView.() -> Unit): RecyclerView {
    return ankoView({RecyclerView(App.instance,null)},0,init)
}
