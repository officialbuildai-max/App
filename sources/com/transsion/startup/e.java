package com.transsion.startup;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: classes6.dex */
public final /* synthetic */ class e implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StartupManager f54568a;

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Unit M;
        M = StartupManager.M(this.f54568a, ((Boolean) obj).booleanValue(), (com.google.firebase.remoteconfig.a) obj2);
        return M;
    }
}
