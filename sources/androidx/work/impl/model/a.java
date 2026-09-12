package androidx.work.impl.model;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f15791a;

    /* renamed from: b, reason: collision with root package name */
    private final String f15792b;

    public a(String workSpecId, String prerequisiteId) {
        Intrinsics.h(workSpecId, "workSpecId");
        Intrinsics.h(prerequisiteId, "prerequisiteId");
        this.f15791a = workSpecId;
        this.f15792b = prerequisiteId;
    }

    public final String a() {
        return this.f15792b;
    }

    public final String b() {
        return this.f15791a;
    }
}
