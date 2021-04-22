package com.ajws.aquajoss.util

import android.content.Context
import androidx.core.content.ContextCompat

fun Context.getColorById(colorId: Int) = ContextCompat.getColor(this, colorId)