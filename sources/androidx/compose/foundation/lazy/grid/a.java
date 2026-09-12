package androidx.compose.foundation.lazy.grid;

import androidx.collection.s;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final long f3025a;

    private /* synthetic */ a(long j11) {
        this.f3025a = j11;
    }

    public static final /* synthetic */ a a(long j11) {
        return new a(j11);
    }

    public static boolean b(long j11, Object obj) {
        return (obj instanceof a) && j11 == ((a) obj).e();
    }

    public static int c(long j11) {
        return s.a(j11);
    }

    public static String d(long j11) {
        return "GridItemSpan(packedValue=" + j11 + ')';
    }

    public final /* synthetic */ long e() {
        return this.f3025a;
    }

    public boolean equals(Object obj) {
        return b(this.f3025a, obj);
    }

    public int hashCode() {
        return c(this.f3025a);
    }

    public String toString() {
        return d(this.f3025a);
    }
}
