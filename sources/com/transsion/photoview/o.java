package com.transsion.photoview;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import androidx.core.view.MotionEventCompat;

/* loaded from: classes6.dex */
abstract class o {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(float f11, float f12, float f13) {
        if (f11 >= f12) {
            throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
        }
        if (f12 >= f13) {
            throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i11) {
        return (i11 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(ImageView imageView) {
        return imageView.getDrawable() != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if (scaleType != ImageView.ScaleType.MATRIX) {
            return true;
        }
        throw new IllegalStateException("Matrix scale type is not supported");
    }
}
