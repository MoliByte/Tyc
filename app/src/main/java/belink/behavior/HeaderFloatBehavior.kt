package belink.behavior

import android.animation.ArgbEvaluator
import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.support.design.widget.CoordinatorLayout
import android.util.AttributeSet
import android.util.Log
import android.view.View
import belink.spark.com.tyc.R
import org.jetbrains.anko.backgroundColor
import java.lang.ref.WeakReference

/**
 * Created by Univer Quie on 2019/1/22.
 * @author: Univer Quie
 * @email: 397826579@qq.com
 *
 * linearlayout behavior
 */
class HeaderFloatBehavior(context: Context, attrs: AttributeSet) : CoordinatorLayout.Behavior<View>(context,attrs) {
    val TAG = "HeadFloatBehavior"
    private var dependentView: WeakReference<View>? = null


    override fun onDependentViewChanged(parent: CoordinatorLayout?, child: View?, dependency: View?): Boolean {
        val resource: Resources = getDependentView().resources
        val progress: Float = 1.0f - Math.abs(dependency?.translationY!! / (dependency.height.minus(resource.getDimension(R.dimen.collapsed_header_height))))

        val collapsedOffset: Float = resource.getDimension(R.dimen.collapsed_float_offset_y)
        val initOffset: Float = resource.getDimension(R.dimen.init_float_offset_y)
        val translateY: Float = collapsedOffset + (initOffset - collapsedOffset) * progress

        child?.translationY = translateY

        // margins
        val collapseMargin = resource.getDimension(R.dimen.collapsed_float_margin)
        val initMargin = resource.getDimension(R.dimen.init_float_margin)
        val margin: Int = (collapseMargin + (initMargin - collapseMargin) * progress).toInt()
        var lp: CoordinatorLayout.LayoutParams = child?.layoutParams as CoordinatorLayout.LayoutParams
        Log.e(TAG,"width = "+lp.width +",height = " + lp.height)
        lp.setMargins(margin, 0, margin, 0)
        child.layoutParams = lp

        val argb = ArgbEvaluator()
        val colorBg = argb.evaluate(progress,
                resource.getColor(R.color.search_bg),
                Color.TRANSPARENT) as Int
        parent?.backgroundColor = colorBg

        return true
    }


    override fun layoutDependsOn(parent: CoordinatorLayout?, child: View?, dependency: View?): Boolean {
        //Log.e(TAG, "dependency = "+dependency)
        if (dependency != null && dependency.id == R.id.scrolling_header) {
            dependentView = WeakReference(dependency)
            return true
        }
        return false
    }

    private fun getDependentView(): View {
        return dependentView?.get() as View
    }

}