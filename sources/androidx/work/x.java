package androidx.work;

import androidx.view.LiveData;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
final class x implements w {

    /* renamed from: c, reason: collision with root package name */
    private final LiveData f16143c;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.common.util.concurrent.r f16144d;

    public x(LiveData state, com.google.common.util.concurrent.r future) {
        Intrinsics.h(state, "state");
        Intrinsics.h(future, "future");
        this.f16143c = state;
        this.f16144d = future;
    }

    @Override // androidx.work.w
    public com.google.common.util.concurrent.r a() {
        return this.f16144d;
    }
}
