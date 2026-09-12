package androidx.window.layout;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    private final List f15415a;

    public a0(List displayFeatures) {
        Intrinsics.h(displayFeatures, "displayFeatures");
        this.f15415a = displayFeatures;
    }

    public final List a() {
        return this.f15415a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.c(a0.class, obj.getClass())) {
            return false;
        }
        return Intrinsics.c(this.f15415a, ((a0) obj).f15415a);
    }

    public int hashCode() {
        return this.f15415a.hashCode();
    }

    public String toString() {
        return CollectionsKt.s0(this.f15415a, ", ", "WindowLayoutInfo{ DisplayFeatures[", "] }", 0, null, null, 56, null);
    }
}
