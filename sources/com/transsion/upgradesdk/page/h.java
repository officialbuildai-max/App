package com.transsion.upgradesdk.page;

import android.os.Bundle;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes6.dex */
public final class h extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ aw.i f56746a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(aw.i iVar) {
        super(0);
        this.f56746a = iVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Bundle arguments = this.f56746a.getArguments();
        if (arguments != null) {
            int i11 = arguments.getInt("confirmButtonTextColor", 0);
            Integer valueOf = Integer.valueOf(i11);
            if (i11 != 0) {
                return valueOf;
            }
        }
        return null;
    }
}
