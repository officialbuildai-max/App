package f3;

import androidx.media3.common.util.a1;
import org.mvel2.ast.ASTNode;

/* loaded from: classes2.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final t f62449a;

    /* renamed from: b, reason: collision with root package name */
    public final int f62450b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f62451c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f62452d;

    /* renamed from: e, reason: collision with root package name */
    public final int f62453e;

    /* renamed from: f, reason: collision with root package name */
    public final long[] f62454f;

    /* renamed from: g, reason: collision with root package name */
    public final int[] f62455g;

    /* renamed from: h, reason: collision with root package name */
    public final long f62456h;

    public w(t tVar, long[] jArr, int[] iArr, int i11, long[] jArr2, int[] iArr2, long j11) {
        androidx.media3.common.util.a.a(iArr.length == jArr2.length);
        androidx.media3.common.util.a.a(jArr.length == jArr2.length);
        androidx.media3.common.util.a.a(iArr2.length == jArr2.length);
        this.f62449a = tVar;
        this.f62451c = jArr;
        this.f62452d = iArr;
        this.f62453e = i11;
        this.f62454f = jArr2;
        this.f62455g = iArr2;
        this.f62456h = j11;
        this.f62450b = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | ASTNode.DISCARD;
        }
    }

    public int a(long j11) {
        for (int h11 = a1.h(this.f62454f, j11, true, false); h11 >= 0; h11--) {
            if ((this.f62455g[h11] & 1) != 0) {
                return h11;
            }
        }
        return -1;
    }

    public int b(long j11) {
        for (int d11 = a1.d(this.f62454f, j11, true, false); d11 < this.f62454f.length; d11++) {
            if ((this.f62455g[d11] & 1) != 0) {
                return d11;
            }
        }
        return -1;
    }
}
