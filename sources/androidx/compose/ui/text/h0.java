package androidx.compose.ui.text;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class h0 extends f0 {

    /* renamed from: a, reason: collision with root package name */
    private final String f6254a;

    public h0(String str) {
        super(null);
        this.f6254a = str;
    }

    public final String a() {
        return this.f6254a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h0) && Intrinsics.c(this.f6254a, ((h0) obj).f6254a);
    }

    public int hashCode() {
        return this.f6254a.hashCode();
    }

    public String toString() {
        return "VerbatimTtsAnnotation(verbatim=" + this.f6254a + ')';
    }
}
