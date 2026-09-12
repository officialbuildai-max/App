package o9;

import com.google.android.exoplayer2.util.p0;
import org.mvel2.ast.ASTNode;

/* loaded from: classes4.dex */
final class r {

    /* renamed from: a, reason: collision with root package name */
    public final o f71033a;

    /* renamed from: b, reason: collision with root package name */
    public final int f71034b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f71035c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f71036d;

    /* renamed from: e, reason: collision with root package name */
    public final int f71037e;

    /* renamed from: f, reason: collision with root package name */
    public final long[] f71038f;

    /* renamed from: g, reason: collision with root package name */
    public final int[] f71039g;

    /* renamed from: h, reason: collision with root package name */
    public final long f71040h;

    public r(o oVar, long[] jArr, int[] iArr, int i11, long[] jArr2, int[] iArr2, long j11) {
        com.google.android.exoplayer2.util.a.a(iArr.length == jArr2.length);
        com.google.android.exoplayer2.util.a.a(jArr.length == jArr2.length);
        com.google.android.exoplayer2.util.a.a(iArr2.length == jArr2.length);
        this.f71033a = oVar;
        this.f71035c = jArr;
        this.f71036d = iArr;
        this.f71037e = i11;
        this.f71038f = jArr2;
        this.f71039g = iArr2;
        this.f71040h = j11;
        this.f71034b = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | ASTNode.DISCARD;
        }
    }

    public int a(long j11) {
        for (int i11 = p0.i(this.f71038f, j11, true, false); i11 >= 0; i11--) {
            if ((this.f71039g[i11] & 1) != 0) {
                return i11;
            }
        }
        return -1;
    }

    public int b(long j11) {
        for (int e11 = p0.e(this.f71038f, j11, true, false); e11 < this.f71038f.length; e11++) {
            if ((this.f71039g[e11] & 1) != 0) {
                return e11;
            }
        }
        return -1;
    }
}
