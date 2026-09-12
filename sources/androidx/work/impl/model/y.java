package androidx.work.impl.model;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    private final String f15960a;

    /* renamed from: b, reason: collision with root package name */
    private final String f15961b;

    public y(String name, String workSpecId) {
        Intrinsics.h(name, "name");
        Intrinsics.h(workSpecId, "workSpecId");
        this.f15960a = name;
        this.f15961b = workSpecId;
    }

    public final String a() {
        return this.f15960a;
    }

    public final String b() {
        return this.f15961b;
    }
}
