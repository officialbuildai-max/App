package com.cloud.hisavana.sdk;

import android.view.View;

/* loaded from: classes3.dex */
public class i5 extends com.cloud.hisavana.sdk.common.tranmeasure.h {
    @Override // com.cloud.hisavana.sdk.common.tranmeasure.h
    protected int d(d5 d5Var, View view) {
        if (view == null || d5Var == null || !view.getGlobalVisibleRect(this.f22218a)) {
            return 2;
        }
        long height = this.f22218a.height() * this.f22218a.width();
        long height2 = view.getHeight() * view.getWidth();
        this.f22219b = this.f22218a.width() + "*" + this.f22218a.height();
        return (height2 > 0 && height >= ((long) d5Var.f22457b)) ? 1 : 2;
    }
}
