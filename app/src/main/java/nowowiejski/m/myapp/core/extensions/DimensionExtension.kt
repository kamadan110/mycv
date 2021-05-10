package nowowiejski.m.myapp.core.extensions

import android.content.res.Resources

val Int.pxAsDp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()

val Int.dpAsPx: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

val Int.spAsPx: Int
    get() = (this * Resources.getSystem().displayMetrics.scaledDensity).toInt()

