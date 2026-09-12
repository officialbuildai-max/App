package x2;

import androidx.media3.common.r;
import androidx.media3.common.util.j0;
import androidx.media3.common.v;
import androidx.media3.common.w;
import androidx.media3.common.x;
import androidx.media3.common.y;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class a implements x.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f78152a;

    /* renamed from: b, reason: collision with root package name */
    public final String f78153b;

    /* renamed from: c, reason: collision with root package name */
    public final String f78154c;

    /* renamed from: d, reason: collision with root package name */
    public final int f78155d;

    /* renamed from: e, reason: collision with root package name */
    public final int f78156e;

    /* renamed from: f, reason: collision with root package name */
    public final int f78157f;

    /* renamed from: g, reason: collision with root package name */
    public final int f78158g;

    /* renamed from: h, reason: collision with root package name */
    public final byte[] f78159h;

    public a(int i11, String str, String str2, int i12, int i13, int i14, int i15, byte[] bArr) {
        this.f78152a = i11;
        this.f78153b = str;
        this.f78154c = str2;
        this.f78155d = i12;
        this.f78156e = i13;
        this.f78157f = i14;
        this.f78158g = i15;
        this.f78159h = bArr;
    }

    public static a b(j0 j0Var) {
        int q11 = j0Var.q();
        String u11 = y.u(j0Var.F(j0Var.q(), StandardCharsets.US_ASCII));
        String E = j0Var.E(j0Var.q());
        int q12 = j0Var.q();
        int q13 = j0Var.q();
        int q14 = j0Var.q();
        int q15 = j0Var.q();
        int q16 = j0Var.q();
        byte[] bArr = new byte[q16];
        j0Var.l(bArr, 0, q16);
        return new a(q11, u11, E, q12, q13, q14, q15, bArr);
    }

    @Override // androidx.media3.common.x.a
    public void a(v.b bVar) {
        bVar.K(this.f78159h, this.f78152a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.f78152a == aVar.f78152a && this.f78153b.equals(aVar.f78153b) && this.f78154c.equals(aVar.f78154c) && this.f78155d == aVar.f78155d && this.f78156e == aVar.f78156e && this.f78157f == aVar.f78157f && this.f78158g == aVar.f78158g && Arrays.equals(this.f78159h, aVar.f78159h);
    }

    @Override // androidx.media3.common.x.a
    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return w.a(this);
    }

    @Override // androidx.media3.common.x.a
    public /* synthetic */ r getWrappedMetadataFormat() {
        return w.b(this);
    }

    public int hashCode() {
        return ((((((((((((((527 + this.f78152a) * 31) + this.f78153b.hashCode()) * 31) + this.f78154c.hashCode()) * 31) + this.f78155d) * 31) + this.f78156e) * 31) + this.f78157f) * 31) + this.f78158g) * 31) + Arrays.hashCode(this.f78159h);
    }

    public String toString() {
        return "Picture: mimeType=" + this.f78153b + ", description=" + this.f78154c;
    }
}
