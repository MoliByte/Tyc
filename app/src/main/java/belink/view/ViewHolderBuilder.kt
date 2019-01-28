package belink.view

import android.graphics.Bitmap
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.annotation.ColorInt
import android.support.annotation.DrawableRes
import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.text.util.Linkify
import android.util.Log
import android.util.SparseArray
import android.view.View
import android.view.animation.AlphaAnimation
import android.widget.*


/**
 * Created by Univer Quie on 2019/1/24.
 * @author: Univer Quie
 * @email: 397826579@qq.com
 */
class ViewHolderBuilder private constructor(private var rootView: View?) {
    /**
     * Views indexed with their IDs
     */
    private val views: SparseArray<View>?

    init {
        views = SparseArray()
    }


    /**
     * Sets the checked status of a checkable.
     *
     * @param viewId  The view id.
     * @param checked The checked status;
     * @return The ViewHolderBuilder for chaining.
     */
    fun setChecked(@IdRes viewId: Int, checked: Boolean): ViewHolderBuilder {
        val view = getView<View>(viewId)
        // View unable cast to Checkable
        if (view is Checkable) {
            (view as Checkable).isChecked = checked
        }
        return this
    }

    /**
     * Sets the rating (the number of stars filled) of a RatingBar.
     *
     * @param viewId The view id.
     * @param rating The rating.
     * @return The ViewHolderBuilder for chaining.
     */
    fun setRating(@IdRes viewId: Int, rating: Float): ViewHolderBuilder {
        val view = getView<RatingBar>(viewId)
        view.rating = rating
        return this
    }

    /**
     * Will set the text of a TextView.
     *
     * @param viewId The view id.
     * @param value  The text to put in the text view.
     * @return The ViewHolderBuilder for chaining.
     */
    fun setText(@IdRes viewId: Int, value: CharSequence): ViewHolderBuilder {
        val view = getView<TextView>(viewId)
        view.text = value
        return this
    }

    fun setText(@IdRes viewId: Int, @StringRes strId: Int): ViewHolderBuilder {
        val view = getView<TextView>(viewId)
        view.setText(strId)
        return this
    }

    /**
     * Will set the image of an ImageView from a resource id.
     *
     * @param viewId     The view id.
     * @param imageResId The image resource id.
     * @return The ViewHolderBuilder for chaining.
     */
    fun setImageResource(@IdRes viewId: Int, @DrawableRes imageResId: Int): ViewHolderBuilder {
        val view = getView<ImageView>(viewId)
        view.setImageResource(imageResId)
        return this
    }

    /**
     * Will set background color of a view.
     *
     * @param viewId The view id.
     * @param color  A color, not a resource id.
     * @return The ViewHolderBuilder for chaining.
     */
    fun setBackgroundColor(@IdRes viewId: Int, @ColorInt color: Int): ViewHolderBuilder {
        val view = getView<View>(viewId)
        view.setBackgroundColor(color)
        return this
    }

    /**
     * Will set background of a view.
     *
     * @param viewId        The view id.
     * @param backgroundRes A resource to use as a background.
     * @return The ViewHolderBuilder for chaining.
     */
    fun setBackgroundRes(@IdRes viewId: Int, @DrawableRes backgroundRes: Int): ViewHolderBuilder {
        val view = getView<View>(viewId)
        view.setBackgroundResource(backgroundRes)
        return this
    }

    /**
     * Will set text color of a TextView.
     *
     * @param viewId    The view id.
     * @param textColor The text color (not a resource id).
     * @return The ViewHolderBuilder for chaining.
     */
    fun setTextColor(@IdRes viewId: Int, @ColorInt textColor: Int): ViewHolderBuilder {
        val view = getView<TextView>(viewId)
        view.setTextColor(textColor)
        return this
    }


    /**
     * Will set the image of an ImageView from a drawable.
     *
     * @param viewId   The view id.
     * @param drawable The image drawable.
     * @return The ViewHolderBuilder for chaining.
     */
    fun setImageDrawable(@IdRes viewId: Int, drawable: Drawable): ViewHolderBuilder {
        val view = getView<ImageView>(viewId)
        view.setImageDrawable(drawable)
        return this
    }

    /**
     * Add an action to set the image of an image view. Can be called multiple times.
     */
    fun setImageBitmap(@IdRes viewId: Int, bitmap: Bitmap): ViewHolderBuilder {
        val view = getView<ImageView>(viewId)
        view.setImageBitmap(bitmap)
        return this
    }

    /**
     * Add an action to set the alpha of a view. Can be called multiple times.
     * Alpha between 0-1.
     */
    fun setAlpha(@IdRes viewId: Int, value: Float): ViewHolderBuilder {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getView<View>(viewId).setAlpha(value)
        } else {
            // Pre-honeycomb hack to set Alpha value
            val alpha = AlphaAnimation(value, value)
            alpha.duration = 0
            alpha.fillAfter = true
            getView<View>(viewId).startAnimation(alpha)
        }
        return this
    }

    /**
     * Set a view visibility to VISIBLE (true) or GONE (false).
     *
     * @param viewId  The view id.
     * @param visible True for VISIBLE, false for GONE.
     * @return The ViewHolderBuilder for chaining.
     */
    fun setGone(@IdRes viewId: Int, visible: Boolean): ViewHolderBuilder {
        val view = getView<View>(viewId)
        view.visibility = (if (visible) View.VISIBLE else View.GONE)
        return this
    }

    /**
     * Set a view visibility to VISIBLE (true) or INVISIBLE (false).
     *
     * @param viewId  The view id.
     * @param visible True for VISIBLE, false for INVISIBLE.
     * @return The ViewHolderBuilder for chaining.
     */
    fun setVisible(@IdRes viewId: Int, visible: Boolean): ViewHolderBuilder {
        val view = getView<View>(viewId)
        view.visibility = (if (visible) View.VISIBLE else View.INVISIBLE)
        return this
    }

    /**
     * Add links into a TextView.
     *
     * @param viewId The id of the TextView to linkify.
     * @return The ViewHolderBuilder for chaining.
     */
    fun linkify(@IdRes viewId: Int): ViewHolderBuilder {
        val view = getView<TextView>(viewId)
        Linkify.addLinks(view, Linkify.ALL)
        return this
    }

    /**
     * Apply the typeface to the given viewId, and enable subpixel rendering.
     */
    fun setTypeface(@IdRes viewId: Int, typeface: Typeface): ViewHolderBuilder {
        val view = getView<TextView>(viewId)
        view.typeface = (typeface)
        view.paintFlags = (view.getPaintFlags() or Paint.SUBPIXEL_TEXT_FLAG)
        return this
    }

    /**
     * Apply the typeface to all the given viewIds, and enable subpixel rendering.
     */
    fun setTypeface(typeface: Typeface, vararg viewIds: Int): ViewHolderBuilder {
        for (viewId in viewIds) {
            val view = getView<TextView>(viewId)
            view.typeface = (typeface)
            view.paintFlags = (view.getPaintFlags() or Paint.SUBPIXEL_TEXT_FLAG)
        }
        return this
    }

    /**
     * Sets the progress of a ProgressBar.
     *
     * @param viewId   The view id.
     * @param progress The progress.
     * @return The ViewHolderBuilder for chaining.
     */
    fun setProgress(@IdRes viewId: Int, progress: Int): ViewHolderBuilder {
        val view = getView<ProgressBar>(viewId)
        view.setProgress(progress)
        return this
    }

    /**
     * Sets the progress and max of a ProgressBar.
     *
     * @param viewId   The view id.
     * @param progress The progress.
     * @param max      The max value of a ProgressBar.
     * @return The ViewHolderBuilder for chaining.
     */
    fun setProgress(@IdRes viewId: Int, progress: Int, max: Int): ViewHolderBuilder {
        val view = getView<ProgressBar>(viewId)
        view.max = (max)
        view.progress = (progress)
        return this
    }

    /**
     * Sets the range of a ProgressBar to 0...max.
     *
     * @param viewId The view id.
     * @param max    The max value of a ProgressBar.
     * @return The ViewHolderBuilder for chaining.
     */
    fun setMax(@IdRes viewId: Int, max: Int): ViewHolderBuilder {
        val view = getView<ProgressBar>(viewId)
        view.max = (max)
        return this
    }

    /**
     * Sets the rating (the number of stars filled) and max of a RatingBar.
     *
     * @param viewId The view id.
     * @param rating The rating.
     * @param max    The range of the RatingBar to 0...max.
     * @return The ViewHolderBuilder for chaining.
     */
    fun setRating(@IdRes viewId: Int, rating: Float, max: Int): ViewHolderBuilder {
        val view = getView<RatingBar>(viewId)
        view.max = (max)
        view.rating = (rating)
        return this
    }

    /**
     * Sets the adapter of a adapter view.
     *
     * @param viewId  The view id.
     * @param adapter The adapter;
     * @return The ViewHolderBuilder for chaining.
     */
    fun setAdapter(@IdRes viewId: Int, adapter: Adapter): ViewHolderBuilder {
        val view = getView<AdapterView<Adapter>>(viewId)
        view.adapter = (adapter)
        return this
    }

    /**
     * add childView id
     *
     * @param viewId   add the child view id   can support childview click
     * @param listener The on long click listener;
     */
    fun addOnClickListener(@IdRes viewId: Int, listener: View.OnClickListener): ViewHolderBuilder {
        val view = getView<View>(viewId)
        view.setOnClickListener(listener)
        return this
    }

    /**
     * Sets the on long click listener of the view.
     *
     * @param viewId   The view id.
     * @param listener The on long click listener;
     */
    @Deprecated("")
    fun setOnLongClickListener(@IdRes viewId: Int, listener: View.OnLongClickListener): ViewHolderBuilder {
        val view = getView<View>(viewId)
        view.setOnLongClickListener(listener)
        return this
    }

    /**
     * Sets the tag of the view.
     *
     * @param viewId The view id.
     * @param tag    The tag;
     * @return The ViewHolderBuilder for chaining.
     */
    fun setTag(@IdRes viewId: Int, tag: Any): ViewHolderBuilder {
        val view = getView<View>(viewId)
        view.setTag(tag)
        return this
    }

    /**
     * Sets the tag of the view.
     *
     * @param viewId The view id.
     * @param key    The key of tag;
     * @param tag    The tag;
     * @return The ViewHolderBuilder for chaining.
     */
    fun setTag(@IdRes viewId: Int, key: Int, tag: Any): ViewHolderBuilder {
        val view = getView<View>(viewId)
        view.setTag(key, tag)
        return this
    }


    fun <T : View> getView(@IdRes viewId: Int): T {
        var view: View? = views!!.get(viewId)
        if (view == null) {
            view = rootView!!.findViewById(viewId)
            views.put(viewId, view)
        }
        return view as T
    }

    /**
     * 销毁holder
     */
    fun destroyView() {

        Log.d(TAG, "ViewHolderBuildeDestory....")
        if (views != null) {
            var i = 0
            val nsize = views.size()
            while (i < nsize) {
                var v: View? = views.valueAt(i)
                v = null
                i++
            }
            views.clear()
        }

        if (rootView != null) {
            rootView = null
        }

    }

    companion object {
        val TAG = ViewHolderBuilder::class.java.simpleName
        fun newBuild(view: View): ViewHolderBuilder {
            return ViewHolderBuilder(view)
        }
    }


}
