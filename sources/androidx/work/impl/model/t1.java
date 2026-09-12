package androidx.work.impl.model;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class t1 {

    /* renamed from: a, reason: collision with root package name */
    private final String f15937a;

    /* renamed from: b, reason: collision with root package name */
    private final String f15938b;

    public t1(String tag, String workSpecId) {
        Intrinsics.h(tag, "tag");
        Intrinsics.h(workSpecId, "workSpecId");
        this.f15937a = tag;
        this.f15938b = workSpecId;
    }

    public final String a() {
        return this.f15937a;
    }

    public final String b() {
        return this.f15938b;
    }
}
