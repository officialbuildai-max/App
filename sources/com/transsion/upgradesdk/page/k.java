package com.transsion.upgradesdk.page;

import android.os.Bundle;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes6.dex */
public final class k extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ aw.i f56749a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(aw.i iVar) {
        super(0);
        this.f56749a = iVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Bundle arguments = this.f56749a.getArguments();
        return Boolean.valueOf(arguments != null ? arguments.getBoolean("isManualClick") : false);
    }
}
