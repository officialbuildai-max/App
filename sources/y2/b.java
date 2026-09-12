package y2;

import androidx.media3.common.r;
import androidx.media3.common.v;
import androidx.media3.common.w;
import androidx.media3.common.x;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class b implements x.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f78937a;

    /* renamed from: b, reason: collision with root package name */
    public final String f78938b;

    /* renamed from: c, reason: collision with root package name */
    public final String f78939c;

    /* renamed from: d, reason: collision with root package name */
    public final String f78940d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f78941e;

    /* renamed from: f, reason: collision with root package name */
    public final int f78942f;

    public b(int i11, String str, String str2, String str3, boolean z10, int i12) {
        androidx.media3.common.util.a.a(i12 == -1 || i12 > 0);
        this.f78937a = i11;
        this.f78938b = str;
        this.f78939c = str2;
        this.f78940d = str3;
        this.f78941e = z10;
        this.f78942f = i12;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static y2.b b(java.util.Map r13) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.b.b(java.util.Map):y2.b");
    }

    @Override // androidx.media3.common.x.a
    public void a(v.b bVar) {
        String str = this.f78939c;
        if (str != null) {
            bVar.m0(str);
        }
        String str2 = this.f78938b;
        if (str2 != null) {
            bVar.c0(str2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f78937a == bVar.f78937a && Objects.equals(this.f78938b, bVar.f78938b) && Objects.equals(this.f78939c, bVar.f78939c) && Objects.equals(this.f78940d, bVar.f78940d) && this.f78941e == bVar.f78941e && this.f78942f == bVar.f78942f;
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
        int i11 = (527 + this.f78937a) * 31;
        String str = this.f78938b;
        int hashCode = (i11 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f78939c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f78940d;
        return ((((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.f78941e ? 1 : 0)) * 31) + this.f78942f;
    }

    public String toString() {
        return "IcyHeaders: name=\"" + this.f78939c + "\", genre=\"" + this.f78938b + "\", bitrate=" + this.f78937a + ", metadataInterval=" + this.f78942f;
    }
}
