package com.transsion.rewardscenter.utils;

import com.transsion.rewardscenter.R$layout;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public abstract class p {
    public static final void a(boolean z10, String string) {
        Intrinsics.h(string, "string");
        if (z10) {
            uh.b.f76876a.g(R$layout.toast_success_layout, string, (r13 & 4) != 0 ? 0 : 17, (r13 & 8) != 0 ? 0 : 0, (r13 & 16) != 0 ? 0 : 0);
        } else {
            uh.b.f76876a.g(R$layout.toast_warning_layout, string, (r13 & 4) != 0 ? 0 : 17, (r13 & 8) != 0 ? 0 : 0, (r13 & 16) != 0 ? 0 : 0);
        }
    }
}
