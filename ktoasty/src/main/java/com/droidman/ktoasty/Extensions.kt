package com.droidman.ktoasty

import android.content.Context;
import android.graphics.drawable.Drawable
import android.widget.Toast

fun Context.showSuccessToast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT, withIcon: Boolean) {
    KToasty.success(this, message, duration, withIcon).show()
}

fun Context.showSuccessToast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    KToasty.success(this, message, duration).show()
}

fun Context.showSuccessToast(message: CharSequence) {
    KToasty.success(this, message).show()
}

fun Context.showNormalToast(message: CharSequence){
    KToasty.normal(this, message).show()
}

fun Context.showNormalToast(message: CharSequence, icon: Drawable){
    KToasty.normal(this, message, icon).show()
}

fun Context.showNormalToast(message: CharSequence, duration: Int){
    KToasty.normal(this, message, duration).show()
}

fun Context.showNormalToast(message: CharSequence, duration: Int, icon: Drawable){
    KToasty.normal(this, message, duration, icon).show()
}

fun Context.showNormalToast(message: CharSequence, duration: Int, icon: Drawable?, withIcon: Boolean){
    KToasty.normal(this, message, duration, icon, withIcon);
}

fun Context.showErrorToast(message: CharSequence){
    KToasty.error(this, message).show()
}

fun Context.showErrorToast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT){
    KToasty.error(this, message, duration).show()
}

fun Context.showErrorToast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT, withIcon: Boolean){
    KToasty.error(this, message, duration, withIcon).show()
}

fun Context.showInfoToast(message: CharSequence){
    KToasty.info(this, message).show()
}

fun Context.showInfoToast(message: CharSequence, duration: Int){
    KToasty.info(this, message, duration).show()
}

fun Context.showInfoToast(message: CharSequence, duration: Int, withIcon: Boolean){
    KToasty.info(this, message, duration).show()
}

fun Context.showWarningToast(message: CharSequence){
    KToasty.warning(this, message)
}

fun Context.showWarningToast(message: CharSequence, duration: Int){
    KToasty.warning(this, message, duration)
}

fun Context.showWarningToast(message: CharSequence, duration: Int, withIcon: Boolean){
    KToasty.warning(this, message, duration, withIcon)
}



