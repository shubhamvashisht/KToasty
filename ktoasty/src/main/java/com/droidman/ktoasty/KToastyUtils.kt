package com.droidman.ktoasty

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.graphics.drawable.NinePatchDrawable
import android.os.Build
import android.support.annotation.ColorInt
import android.support.annotation.DrawableRes
import android.support.annotation.NonNull
import android.view.View

internal class KToastyUtils private constructor(){

    companion object {
        fun tintIcon(@NonNull drawable: Drawable,@ColorInt tintColor: Int): Drawable{
            drawable.setColorFilter(tintColor, PorterDuff.Mode.SRC_IN);
            return drawable
        }

        fun tint9PatchDrawableFrame(@NonNull context: Context, @ColorInt tintColor: Int): Drawable{
            val toastDrawable = getDrawable(context, R.drawable.toast_frame) as NinePatchDrawable;
            return tintIcon(toastDrawable, tintColor)
        }

        fun setBackground(view: View, drawable: Drawable){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
                view.background = drawable
            else
                view.setBackgroundDrawable(drawable)
        }

        fun getDrawable(@NonNull context: Context, @DrawableRes id: Int): Drawable{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                return context.getDrawable(id)
            else
                return context.resources.getDrawable(id)
        }
    }
}