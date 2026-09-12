package x9;

import android.net.Uri;
import com.google.android.exoplayer2.util.n0;

/* loaded from: classes4.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final long f78229a;

    /* renamed from: b, reason: collision with root package name */
    public final long f78230b;

    /* renamed from: c, reason: collision with root package name */
    private final String f78231c;

    /* renamed from: d, reason: collision with root package name */
    private int f78232d;

    public i(String str, long j11, long j12) {
        this.f78231c = str == null ? "" : str;
        this.f78229a = j11;
        this.f78230b = j12;
    }

    public i a(i iVar, String str) {
        String c11 = c(str);
        if (iVar != null && c11.equals(iVar.c(str))) {
            long j11 = this.f78230b;
            if (j11 != -1) {
                long j12 = this.f78229a;
                if (j12 + j11 == iVar.f78229a) {
                    long j13 = iVar.f78230b;
                    return new i(c11, j12, j13 != -1 ? j11 + j13 : -1L);
                }
            }
            long j14 = iVar.f78230b;
            if (j14 != -1) {
                long j15 = iVar.f78229a;
                if (j15 + j14 == this.f78229a) {
                    return new i(c11, j15, j11 != -1 ? j14 + j11 : -1L);
                }
            }
        }
        return null;
    }

    public Uri b(String str) {
        return n0.e(str, this.f78231c);
    }

    public String c(String str) {
        return n0.d(str, this.f78231c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f78229a == iVar.f78229a && this.f78230b == iVar.f78230b && this.f78231c.equals(iVar.f78231c);
    }

    public int hashCode() {
        if (this.f78232d == 0) {
            this.f78232d = ((((527 + ((int) this.f78229a)) * 31) + ((int) this.f78230b)) * 31) + this.f78231c.hashCode();
        }
        return this.f78232d;
    }

    public String toString() {
        String str = this.f78231c;
        long j11 = this.f78229a;
        long j12 = this.f78230b;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 81);
        sb2.append("RangedUri(referenceUri=");
        sb2.append(str);
        sb2.append(", start=");
        sb2.append(j11);
        sb2.append(", length=");
        sb2.append(j12);
        sb2.append(")");
        return sb2.toString();
    }
}
