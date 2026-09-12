package com.cloud.hisavana.sdk;

import android.view.View;

/* loaded from: classes3.dex */
public class h5 extends com.cloud.hisavana.sdk.common.tranmeasure.h {
    @Override // com.cloud.hisavana.sdk.common.tranmeasure.h
    protected int d(d5 d5Var, View view) {
        if (view == null || d5Var == null || !view.getGlobalVisibleRect(this.f22218a)) {
            return 0;
        }
        long height = this.f22218a.height() * this.f22218a.width();
        long height2 = view.getHeight() * view.getWidth();
        this.f22219b = this.f22218a.width() + "*" + this.f22218a.height();
        if (height2 <= 0) {
            return 0;
        }
        return (int) ((height * 100) / height2);
    }
}
