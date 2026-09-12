package androidx.view;

import androidx.view.Lifecycle;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class d implements r {

    /* renamed from: a, reason: collision with root package name */
    private final k[] f9668a;

    public d(k[] generatedAdapters) {
        Intrinsics.h(generatedAdapters, "generatedAdapters");
        this.f9668a = generatedAdapters;
    }

    @Override // androidx.view.r
    public void onStateChanged(u source, Lifecycle.Event event) {
        Intrinsics.h(source, "source");
        Intrinsics.h(event, "event");
        new a0();
        k[] kVarArr = this.f9668a;
        if (kVarArr.length > 0) {
            k kVar = kVarArr[0];
            throw null;
        }
        if (kVarArr.length <= 0) {
            return;
        }
        k kVar2 = kVarArr[0];
        throw null;
    }
}
