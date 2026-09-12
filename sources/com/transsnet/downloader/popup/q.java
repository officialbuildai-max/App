package com.transsnet.downloader.popup;

import android.view.View;
import com.blankj.utilcode.util.y;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f59691a = new q();

    private q() {
    }

    public final int[] a(View anchorView, View contentView) {
        Intrinsics.h(anchorView, "anchorView");
        Intrinsics.h(contentView, "contentView");
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        anchorView.getLocationOnScreen(iArr2);
        int height = anchorView.getHeight();
        int c11 = y.c();
        int e11 = y.e();
        contentView.measure(0, 0);
        int measuredHeight = contentView.getMeasuredHeight();
        int measuredWidth = contentView.getMeasuredWidth();
        int i11 = iArr2[1];
        if ((c11 - i11) - height < measuredHeight) {
            iArr[0] = e11 - measuredWidth;
            iArr[1] = i11 - measuredHeight;
        } else {
            iArr[0] = e11 - measuredWidth;
            iArr[1] = i11 + height;
        }
        return iArr;
    }
}
