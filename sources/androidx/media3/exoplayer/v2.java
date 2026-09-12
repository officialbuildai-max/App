package androidx.media3.exoplayer;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class v2 {

    /* renamed from: a, reason: collision with root package name */
    public final long f13132a;

    /* renamed from: b, reason: collision with root package name */
    public final float f13133b;

    /* renamed from: c, reason: collision with root package name */
    public final long f13134c;

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private long f13135a;

        /* renamed from: b, reason: collision with root package name */
        private float f13136b;

        /* renamed from: c, reason: collision with root package name */
        private long f13137c;

        public b() {
            this.f13135a = C.TIME_UNSET;
            this.f13136b = -3.4028235E38f;
            this.f13137c = C.TIME_UNSET;
        }

        private b(v2 v2Var) {
            this.f13135a = v2Var.f13132a;
            this.f13136b = v2Var.f13133b;
            this.f13137c = v2Var.f13134c;
        }

        public v2 d() {
            return new v2(this);
        }

        public b e(long j11) {
            androidx.media3.common.util.a.a(j11 >= 0 || j11 == C.TIME_UNSET);
            this.f13137c = j11;
            return this;
        }

        public b f(long j11) {
            this.f13135a = j11;
            return this;
        }

        public b g(float f11) {
            androidx.media3.common.util.a.a(f11 > 0.0f || f11 == -3.4028235E38f);
            this.f13136b = f11;
            return this;
        }
    }

    private v2(b bVar) {
        this.f13132a = bVar.f13135a;
        this.f13133b = bVar.f13136b;
        this.f13134c = bVar.f13137c;
    }

    public b a() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v2)) {
            return false;
        }
        v2 v2Var = (v2) obj;
        return this.f13132a == v2Var.f13132a && this.f13133b == v2Var.f13133b && this.f13134c == v2Var.f13134c;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.f13132a), Float.valueOf(this.f13133b), Long.valueOf(this.f13134c));
    }
}
