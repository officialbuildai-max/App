package com.transsion.upgradesdk.page;

import android.os.Bundle;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes6.dex */
public final class g extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ aw.i f56745a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(aw.i iVar) {
        super(0);
        this.f56745a = iVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Bundle arguments = this.f56745a.getArguments();
        if (arguments != null) {
            int i11 = arguments.getInt("cancelButtonTextColor", 0);
            Integer valueOf = Integer.valueOf(i11);
            if (i11 != 0) {
                return valueOf;
            }
        }
        return null;
    }
}
