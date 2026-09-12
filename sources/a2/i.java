package a2;

import android.net.Uri;
import androidx.media3.common.util.r0;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final long f166a;

    /* renamed from: b, reason: collision with root package name */
    public final long f167b;

    /* renamed from: c, reason: collision with root package name */
    private final String f168c;

    /* renamed from: d, reason: collision with root package name */
    private int f169d;

    public i(String str, long j11, long j12) {
        this.f168c = str == null ? "" : str;
        this.f166a = j11;
        this.f167b = j12;
    }

    public i a(i iVar, String str) {
        String c11 = c(str);
        if (iVar != null && c11.equals(iVar.c(str))) {
            long j11 = this.f167b;
            if (j11 != -1) {
                long j12 = this.f166a;
                if (j12 + j11 == iVar.f166a) {
                    long j13 = iVar.f167b;
                    return new i(c11, j12, j13 != -1 ? j11 + j13 : -1L);
                }
            }
            long j14 = iVar.f167b;
            if (j14 != -1) {
                long j15 = iVar.f166a;
                if (j15 + j14 == this.f166a) {
                    return new i(c11, j15, j11 != -1 ? j14 + j11 : -1L);
                }
            }
        }
        return null;
    }

    public Uri b(String str) {
        return r0.f(str, this.f168c);
    }

    public String c(String str) {
        return r0.e(str, this.f168c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f166a == iVar.f166a && this.f167b == iVar.f167b && this.f168c.equals(iVar.f168c);
    }

    public int hashCode() {
        if (this.f169d == 0) {
            this.f169d = ((((527 + ((int) this.f166a)) * 31) + ((int) this.f167b)) * 31) + this.f168c.hashCode();
        }
        return this.f169d;
    }

    public String toString() {
        return "RangedUri(referenceUri=" + this.f168c + ", start=" + this.f166a + ", length=" + this.f167b + ")";
    }
}
