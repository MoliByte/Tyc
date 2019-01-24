package belink.behavior

import android.content.Context
import android.os.Handler
import android.support.design.widget.CoordinatorLayout
import android.support.v4.view.ViewCompat
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.View
import android.widget.Scroller
import belink.spark.com.tyc.R
import java.lang.ref.WeakReference

/**
 * Created by Univer Quie on 2019/1/22.
 * @author: Univer Quie
 * @email: 397826579@qq.com
 */
class HeaderScrollingBehavior : CoordinatorLayout.Behavior<RecyclerView> {
    private var isExpanded = false
    private var isScrolling = false

    private var dependentView: WeakReference<View>? = null
    private var scroller: Scroller? = null;
    private var handler: Handler? = null;

    constructor (context: Context, attrs: AttributeSet) : super(context, attrs) {
        scroller = Scroller(context)
        handler = Handler()
    }

    override fun layoutDependsOn(parent: CoordinatorLayout?, child: RecyclerView?, dependency: View?): Boolean {
        if (dependency != null && dependency.id == R.id.scrolling_header) {
            //头部图片
            dependentView = WeakReference(dependency)
            return true
        }
        return false
    }

    override fun onLayoutChild(parent: CoordinatorLayout?, child: RecyclerView?, layoutDirection: Int): Boolean {
        val lp = child!!.layoutParams as CoordinatorLayout.LayoutParams
        if (lp.height == CoordinatorLayout.LayoutParams.MATCH_PARENT) {
            val h: Int = getDependentViewCollapsedHeight().toInt()
            val b: Int = (parent?.height!!.minus(h))
            child.layout(0, 0, parent.width, b)
            return true
        }
        return super.onLayoutChild(parent, child, layoutDirection)
    }

    override fun onDependentViewChanged(parent: CoordinatorLayout?, child: RecyclerView?, dependency: View?): Boolean {
        val resources = getDependentView().getResources()
        val progress = 1f - Math.abs(dependency!!.translationY / (dependency.height - resources.getDimension(R.dimen.collapsed_header_height)))

        child!!.translationY = dependency.height + dependency.translationY

        val scale = 1 + 0.4f * (1f - progress)
        dependency.scaleX = scale
        dependency.scaleY = scale

        dependency.alpha = progress

        return true
    }

    private fun getDependentViewCollapsedHeight(): Float {
        return getDependentView().resources.getDimension(R.dimen.collapsed_header_height)
    }

    private fun getDependentView(): View {
        return dependentView?.get() as View
    }

    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: RecyclerView, directTargetChild: View, target: View, nestedScrollAxes: Int): Boolean {
        return nestedScrollAxes and ViewCompat.SCROLL_AXIS_VERTICAL != 0
    }

    override fun onNestedScrollAccepted(coordinatorLayout: CoordinatorLayout, child: RecyclerView, directTargetChild: View, target: View, nestedScrollAxes: Int) {
        scroller?.abortAnimation()
        isScrolling = false
        super.onNestedScrollAccepted(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes)
    }

    override fun onNestedPreScroll(coordinatorLayout: CoordinatorLayout, child: RecyclerView, target: View, dx: Int, dy: Int, consumed: IntArray) {
        if (dy < 0) {
            return
        }
        val dependentView = getDependentView()
        val newTranslateY = dependentView.translationY - dy
        val minHeaderTranslate = -(dependentView.height - getDependentViewCollapsedHeight())
        if (newTranslateY > minHeaderTranslate) {
            dependentView.translationY = newTranslateY
            consumed[1] = dy
        }
    }

    override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: RecyclerView, target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int) {
        if (dyUnconsumed > 0) {
            return
        }
        val dependentView = getDependentView()
        val newTranslateY = dependentView.translationY - dyUnconsumed
        val maxHeaderTranslate = 0f
        if (newTranslateY < maxHeaderTranslate) {
            dependentView.translationY = newTranslateY
        }
    }

    override fun onNestedPreFling(coordinatorLayout: CoordinatorLayout, child: RecyclerView, target: View, velocityX: Float, velocityY: Float): Boolean {
        return onUserStopDragging(velocityY)
    }

    override fun onStopNestedScroll(coordinatorLayout: CoordinatorLayout, child: RecyclerView, target: View) {
        if (!isScrolling) {
            onUserStopDragging(800f)
        }
    }

    private fun onUserStopDragging(velocity: Float): Boolean {
        var velocity:Float = velocity
        val dependentView = getDependentView()
        val translateY = dependentView.translationY
        val minHeaderTranslate = -(dependentView.height - getDependentViewCollapsedHeight())

        if (translateY == 0f || translateY == minHeaderTranslate) {
            return false
        }

        val targetState: Boolean // Flag indicates whether to expand the content.
        if (Math.abs(velocity) <= 800) {
            if (Math.abs(translateY) < Math.abs(translateY - minHeaderTranslate)) {
                targetState = false
            } else {
                targetState = true
            }
            velocity = 800f // Limit velocity's minimum value.
        } else {
            if (velocity > 0) {
                targetState = true
            } else {
                targetState = false
            }
        }

        val targetTranslateY: Float = if (targetState) minHeaderTranslate else 0f
        val dy: Int = (targetTranslateY - translateY).toInt()
        scroller?.startScroll(0, translateY.toInt(), 0, dy, (1000000 / Math.abs(velocity)).toInt())
        handler?.post(flingRunnable)
        isScrolling = true

        return true
    }

    private val flingRunnable = object : Runnable {
        override fun run() {
            if (scroller?.computeScrollOffset() as Boolean) {
                var translateY: Float = scroller?.getCurrY()!!.toFloat()
                getDependentView().setTranslationY(translateY)
                handler?.post(this)
            } else {
                isExpanded = getDependentView().translationY != 0f
                isScrolling = false
            }
        }
    }

}