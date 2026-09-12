package com.transsion.publish.viewmodel;

import android.app.Application;
import androidx.view.b0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class d extends androidx.view.b {

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f50828b;

    /* renamed from: c, reason: collision with root package name */
    private b0 f50829c;

    /* renamed from: d, reason: collision with root package name */
    private final b0 f50830d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f50828b = LazyKt.b(new Function0() { // from class: com.transsion.publish.viewmodel.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                kp.b d11;
                d11 = d.d();
                return d11;
            }
        });
        this.f50829c = new b0();
        this.f50830d = new b0(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kp.b d() {
        return new kp.b();
    }
}
