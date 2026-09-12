package androidx.work.impl.utils;

import android.net.NetworkRequest;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class v {

    /* renamed from: b, reason: collision with root package name */
    public static final a f16077b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final String f16078c;

    /* renamed from: a, reason: collision with root package name */
    private final Object f16079a;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return v.f16078c;
        }
    }

    static {
        String i11 = androidx.work.t.i("NetworkRequestCompat");
        Intrinsics.g(i11, "tagWithPrefix(...)");
        f16078c = i11;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public v() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.v.<init>():void");
    }

    public v(Object obj) {
        this.f16079a = obj;
    }

    public /* synthetic */ v(Object obj, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : obj);
    }

    public final NetworkRequest b() {
        return (NetworkRequest) this.f16079a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof v) && Intrinsics.c(this.f16079a, ((v) obj).f16079a);
    }

    public int hashCode() {
        Object obj = this.f16079a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return "NetworkRequestCompat(wrapped=" + this.f16079a + ')';
    }
}
