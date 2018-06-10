package com.droidman.ktoasty

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.support.annotation.CheckResult
import android.support.annotation.ColorInt
import android.support.annotation.DrawableRes
import android.support.annotation.NonNull
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class KToasty private constructor(){

    companion object {
        @ColorInt
        var DEFAULT_TEXT_COLOR = Color.parseColor("#FFFFFF")
        @ColorInt
        var ERROR_COLOR = Color.parseColor("#D50000")
        @ColorInt
        var INFO_COLOR = Color.parseColor("#3F51B5")
        @ColorInt
        var SUCCESS_COLOR = Color.parseColor("#388E3C")
        @ColorInt
        var WARNING_COLOR = Color.parseColor("#FFA900")
        @ColorInt
        var NORMAL_COLOR = Color.parseColor("#353A3E")

        var LOADED_TOAST_TYPEFACE = Typeface.create("sans-serif-condensed", Typeface.NORMAL)
        var currentTypeface = LOADED_TOAST_TYPEFACE
        var textSize = 16
        var tintIcon = true

        @CheckResult
        fun normal(@NonNull context: Context, @NonNull message: CharSequence): Toast {
            return normal(context, message, Toast.LENGTH_SHORT, null, false);
        }

        @CheckResult
        fun normal(context: Context, message: CharSequence, icon: Drawable): Toast {
            return normal(context, message, Toast.LENGTH_SHORT, icon, true)
        }

        @CheckResult
        fun normal(context: Context, message: CharSequence, duration: Int): Toast {
            return normal(context, message, duration, null, false)
        }

        @CheckResult
        fun normal(context: Context, message: CharSequence, duration: Int,
                   icon: Drawable): Toast {
            return normal(context, message, duration, icon, true)
        }

        @CheckResult
        fun normal(context: Context, message: CharSequence, duration: Int,
                   icon: Drawable?, withIcon: Boolean): Toast {
            return custom(context, message, icon, NORMAL_COLOR, duration, withIcon, true)
        }

        @CheckResult
        fun warning(context: Context, message: CharSequence): Toast {
            return warning(context, message, Toast.LENGTH_SHORT, true)
        }

        @CheckResult
        fun warning(context: Context, message: CharSequence, duration: Int): Toast {
            return warning(context, message, duration, true)
        }

        @CheckResult
        fun warning(context: Context, message: CharSequence, duration: Int, withIcon: Boolean): Toast {
            return custom(context, message, KToastyUtils.getDrawable(context, R.drawable.ic_error_outline_white_48dp),
                    WARNING_COLOR, duration, withIcon, true)
        }

        @CheckResult
        fun info(context: Context, message: CharSequence): Toast {
            return info(context, message, Toast.LENGTH_SHORT, true)
        }

        @CheckResult
        fun info(context: Context, message: CharSequence, duration: Int): Toast {
            return info(context, message, duration, true)
        }

        @CheckResult
        fun info(context: Context, message: CharSequence, duration: Int, withIcon: Boolean): Toast {
            return custom(context, message, KToastyUtils.getDrawable(context, R.drawable.ic_info_outline_white_48dp),
                    INFO_COLOR, duration, withIcon, true)
        }

        @CheckResult
        fun success(context: Context, message: CharSequence): Toast {
            return success(context, message, Toast.LENGTH_SHORT, true)
        }

        @CheckResult
        fun success(context: Context, message: CharSequence, duration: Int): Toast {
            return success(context, message, duration, true)
        }

        @CheckResult
        fun success(context: Context, message: CharSequence, duration: Int, withIcon: Boolean): Toast {
            return custom(context, message, KToastyUtils.getDrawable(context, R.drawable.ic_check_white_48dp),
                    SUCCESS_COLOR, duration, withIcon, true)
        }

        @CheckResult
        fun error(context: Context, message: CharSequence): Toast {
            return error(context, message, Toast.LENGTH_SHORT, true)
        }

        @CheckResult
        fun error(context: Context, message: CharSequence, duration: Int): Toast {
            return error(context, message, duration, true)
        }

        @CheckResult
        fun error(context: Context, message: CharSequence, duration: Int, withIcon: Boolean): Toast {
            return custom(context, message, KToastyUtils.getDrawable(context, R.drawable.ic_clear_white_48dp),
                    ERROR_COLOR, duration, withIcon, true)
        }

        @CheckResult
        fun custom(context: Context, message: CharSequence, icon: Drawable,
                   duration: Int, withIcon: Boolean): Toast {
            return custom(context, message, icon, -1, duration, withIcon, false)
        }

        @CheckResult
        fun custom(context: Context, message: CharSequence, @DrawableRes iconRes: Int,
                   @ColorInt tintColor: Int, duration: Int,
                   withIcon: Boolean, shouldTint: Boolean): Toast {
            return custom(context, message, KToastyUtils.getDrawable(context, iconRes),
                    tintColor, duration, withIcon, shouldTint)
        }

        @SuppressLint("ShowToast")
        @CheckResult
        fun custom(context: Context, message: CharSequence, icon: Drawable?,
                   @ColorInt tintColor: Int, duration: Int,
                   withIcon: Boolean, shouldTint: Boolean): Toast {
            var icon = icon
            val currentToast = Toast.makeText(context, "", duration)
            val toastLayout = (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
                    .inflate(R.layout.toast_layout, null)
            val toastIcon = toastLayout.findViewById(R.id.toast_icon) as ImageView
            val toastTextView = toastLayout.findViewById(R.id.toast_text) as TextView
            val drawableFrame: Drawable

            if (shouldTint)
                drawableFrame = KToastyUtils.tint9PatchDrawableFrame(context, tintColor)
            else
                drawableFrame = KToastyUtils.getDrawable(context, R.drawable.toast_frame)
            KToastyUtils.setBackground(toastLayout, drawableFrame)

            if (withIcon) {
                if (icon == null)
                    throw IllegalArgumentException("Avoid passing 'icon' as null if 'withIcon' is set to true")
                if (tintIcon)
                    icon = KToastyUtils.tintIcon(icon, DEFAULT_TEXT_COLOR)
                KToastyUtils.setBackground(toastIcon, icon)
            } else {
                toastIcon.setVisibility(View.GONE)
            }

            toastTextView.setText(message)
            toastTextView.setTextColor(DEFAULT_TEXT_COLOR)
            toastTextView.setTypeface(currentTypeface)
            toastTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize.toFloat())

            currentToast.view = toastLayout
            return currentToast
        }
    }

    class Config private constructor(){
        @ColorInt
        private var DEFAULT_TEXT_COLOR = KToasty.DEFAULT_TEXT_COLOR
        @ColorInt
        private var ERROR_COLOR = KToasty.ERROR_COLOR
        @ColorInt
        private var INFO_COLOR = KToasty.INFO_COLOR
        @ColorInt
        private var SUCCESS_COLOR = KToasty.SUCCESS_COLOR
        @ColorInt
        private var WARNING_COLOR = KToasty.WARNING_COLOR

        private var typeface = KToasty.currentTypeface
        private var textSize = KToasty.textSize

        private var tintIcon = KToasty.tintIcon
        companion object {
            fun getInstance(): Config{
                return Config();
            }

            fun reset(){
                KToasty.DEFAULT_TEXT_COLOR = Color.parseColor("#FFFFFF");
                KToasty.ERROR_COLOR = Color.parseColor("#D50000");
                KToasty.INFO_COLOR = Color.parseColor("#3F51B5");
                KToasty.SUCCESS_COLOR = Color.parseColor("#388E3C");
                KToasty.WARNING_COLOR = Color.parseColor("#FFA900");
                KToasty.currentTypeface = LOADED_TOAST_TYPEFACE;
                KToasty.textSize = 16;
                KToasty.tintIcon = true;
            }
        }

        @CheckResult
        fun setTextColor(@ColorInt textColor: Int): Config{
            DEFAULT_TEXT_COLOR = textColor
            return this
        }

        @CheckResult
        fun setErrorColor(@ColorInt errorColor: Int): Config {
            ERROR_COLOR = errorColor
            return this
        }

        @CheckResult
        fun setInfoColor(@ColorInt infoColor: Int): Config {
            INFO_COLOR = infoColor
            return this
        }

        @CheckResult
        fun setSuccessColor(@ColorInt successColor: Int): Config {
            SUCCESS_COLOR = successColor
            return this
        }

        @CheckResult
        fun setWarningColor(@ColorInt warningColor: Int): Config {
            WARNING_COLOR = warningColor
            return this
        }

        @CheckResult
        fun setToastTypeface(typeface: Typeface): Config {
            this.typeface = typeface
            return this
        }

        @CheckResult
        fun setTextSize(sizeInSp: Int): Config {
            this.textSize = sizeInSp
            return this
        }

        @CheckResult
        fun tintIcon(tintIcon: Boolean): Config {
            this.tintIcon = tintIcon
            return this
        }

        fun apply() {
            KToasty.DEFAULT_TEXT_COLOR = DEFAULT_TEXT_COLOR
            KToasty.ERROR_COLOR = ERROR_COLOR
            KToasty.INFO_COLOR = INFO_COLOR
            KToasty.SUCCESS_COLOR = SUCCESS_COLOR
            KToasty.WARNING_COLOR = WARNING_COLOR
            KToasty.currentTypeface = typeface
            KToasty.textSize = textSize
            KToasty.tintIcon = tintIcon
        }
    }
}