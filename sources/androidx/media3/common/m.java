package androidx.media3.common;

import androidx.media3.common.util.a1;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class m {

    /* renamed from: e, reason: collision with root package name */
    public static final m f10180e = new b(0).e();

    /* renamed from: f, reason: collision with root package name */
    private static final String f10181f = a1.C0(0);

    /* renamed from: g, reason: collision with root package name */
    private static final String f10182g = a1.C0(1);

    /* renamed from: h, reason: collision with root package name */
    private static final String f10183h = a1.C0(2);

    /* renamed from: i, reason: collision with root package name */
    private static final String f10184i = a1.C0(3);

    /* renamed from: a, reason: collision with root package name */
    public final int f10185a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10186b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10187c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10188d;

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final int f10189a;

        /* renamed from: b, reason: collision with root package name */
        private int f10190b;

        /* renamed from: c, reason: collision with root package name */
        private int f10191c;

        /* renamed from: d, reason: collision with root package name */
        private String f10192d;

        public b(int i11) {
            this.f10189a = i11;
        }

        public m e() {
            androidx.media3.common.util.a.a(this.f10190b <= this.f10191c);
            return new m(this);
        }

        public b f(int i11) {
            this.f10191c = i11;
            return this;
        }

        public b g(int i11) {
            this.f10190b = i11;
            return this;
        }
    }

    private m(b bVar) {
        this.f10185a = bVar.f10189a;
        this.f10186b = bVar.f10190b;
        this.f10187c = bVar.f10191c;
        this.f10188d = bVar.f10192d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f10185a == mVar.f10185a && this.f10186b == mVar.f10186b && this.f10187c == mVar.f10187c && Objects.equals(this.f10188d, mVar.f10188d);
    }

    public int hashCode() {
        int i11 = (((((527 + this.f10185a) * 31) + this.f10186b) * 31) + this.f10187c) * 31;
        String str = this.f10188d;
        return i11 + (str == null ? 0 : str.hashCode());
    }
}
