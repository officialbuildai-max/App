package com.transsion.rewardscenter.task.dada;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    private DadaTaskState f51242a;

    /* JADX WARN: Multi-variable type inference failed */
    public r() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public r(DadaTaskState taskState) {
        Intrinsics.h(taskState, "taskState");
        this.f51242a = taskState;
    }

    public /* synthetic */ r(DadaTaskState dadaTaskState, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? DadaTaskState.NORMAL : dadaTaskState);
    }

    public final DadaTaskState a() {
        return this.f51242a;
    }

    public final void b(DadaTaskState dadaTaskState) {
        Intrinsics.h(dadaTaskState, "<set-?>");
        this.f51242a = dadaTaskState;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof r) && this.f51242a == ((r) obj).f51242a;
    }

    public int hashCode() {
        return this.f51242a.hashCode();
    }

    public String toString() {
        return "DadaTaskItem(taskState=" + this.f51242a + ")";
    }
}
