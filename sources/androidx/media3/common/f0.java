package androidx.media3.common;

import androidx.media3.common.util.a1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class f0 {

    /* renamed from: f, reason: collision with root package name */
    private static final String f10051f = a1.C0(0);

    /* renamed from: g, reason: collision with root package name */
    private static final String f10052g = a1.C0(1);

    /* renamed from: a, reason: collision with root package name */
    public final int f10053a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10054b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10055c;

    /* renamed from: d, reason: collision with root package name */
    private final r[] f10056d;

    /* renamed from: e, reason: collision with root package name */
    private int f10057e;

    public f0(String str, r... rVarArr) {
        androidx.media3.common.util.a.a(rVarArr.length > 0);
        this.f10054b = str;
        this.f10056d = rVarArr;
        this.f10053a = rVarArr.length;
        int k11 = y.k(rVarArr[0].f10243o);
        this.f10055c = k11 == -1 ? y.k(rVarArr[0].f10242n) : k11;
        f();
    }

    public f0(r... rVarArr) {
        this("", rVarArr);
    }

    private static void c(String str, String str2, String str3, int i11) {
        androidx.media3.common.util.u.d("TrackGroup", "", new IllegalStateException("Different " + str + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i11 + ")"));
    }

    private static String d(String str) {
        return (str == null || str.equals(C.LANGUAGE_UNDETERMINED)) ? "" : str;
    }

    private static int e(int i11) {
        return i11 | 16384;
    }

    private void f() {
        String d11 = d(this.f10056d[0].f10232d);
        int e11 = e(this.f10056d[0].f10234f);
        int i11 = 1;
        while (true) {
            r[] rVarArr = this.f10056d;
            if (i11 >= rVarArr.length) {
                return;
            }
            if (!d11.equals(d(rVarArr[i11].f10232d))) {
                r[] rVarArr2 = this.f10056d;
                c("languages", rVarArr2[0].f10232d, rVarArr2[i11].f10232d, i11);
                return;
            } else {
                if (e11 != e(this.f10056d[i11].f10234f)) {
                    c("role flags", Integer.toBinaryString(this.f10056d[0].f10234f), Integer.toBinaryString(this.f10056d[i11].f10234f), i11);
                    return;
                }
                i11++;
            }
        }
    }

    public r a(int i11) {
        return this.f10056d[i11];
    }

    public int b(r rVar) {
        int i11 = 0;
        while (true) {
            r[] rVarArr = this.f10056d;
            if (i11 >= rVarArr.length) {
                return -1;
            }
            if (rVar == rVarArr[i11]) {
                return i11;
            }
            i11++;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f0.class != obj.getClass()) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return this.f10054b.equals(f0Var.f10054b) && Arrays.equals(this.f10056d, f0Var.f10056d);
    }

    public int hashCode() {
        if (this.f10057e == 0) {
            this.f10057e = ((527 + this.f10054b.hashCode()) * 31) + Arrays.hashCode(this.f10056d);
        }
        return this.f10057e;
    }

    public String toString() {
        return this.f10054b + ": " + Arrays.toString(this.f10056d);
    }
}
