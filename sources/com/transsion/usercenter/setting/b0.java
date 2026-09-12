package com.transsion.usercenter.setting;

import android.app.Application;
import androidx.view.LiveData;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b0 extends androidx.view.b {

    /* renamed from: b, reason: collision with root package name */
    private final androidx.view.b0 f57497b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.view.b0 f57498c;

    /* renamed from: d, reason: collision with root package name */
    private final androidx.view.b0 f57499d;

    /* renamed from: e, reason: collision with root package name */
    private final Lazy f57500e;

    /* renamed from: f, reason: collision with root package name */
    private io.reactivex.rxjava3.disposables.c f57501f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f57497b = new androidx.view.b0();
        this.f57498c = new androidx.view.b0();
        this.f57499d = new androidx.view.b0();
        this.f57500e = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.setting.a0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                yw.c d11;
                d11 = b0.d();
                return d11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final yw.c d() {
        return new yw.c();
    }

    private final void e() {
        io.reactivex.rxjava3.disposables.c cVar;
        io.reactivex.rxjava3.disposables.c cVar2 = this.f57501f;
        if (cVar2 == null || cVar2.isDisposed() || (cVar = this.f57501f) == null) {
            return;
        }
        cVar.dispose();
    }

    public final LiveData f() {
        return this.f57497b;
    }

    public final LiveData g() {
        return this.f57498c;
    }

    public final LiveData h() {
        return this.f57499d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.view.t0
    public void onCleared() {
        super.onCleared();
        e();
    }
}
