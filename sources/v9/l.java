package v9;

import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Arrays;

/* loaded from: classes3.dex */
public abstract class l extends f {

    /* renamed from: j, reason: collision with root package name */
    private byte[] f77300j;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f77301k;

    public l(com.google.android.exoplayer2.upstream.k kVar, com.google.android.exoplayer2.upstream.n nVar, int i11, o1 o1Var, int i12, Object obj, byte[] bArr) {
        super(kVar, nVar, i11, o1Var, i12, obj, C.TIME_UNSET, C.TIME_UNSET);
        l lVar;
        byte[] bArr2;
        if (bArr == null) {
            bArr2 = p0.f27685f;
            lVar = this;
        } else {
            lVar = this;
            bArr2 = bArr;
        }
        lVar.f77300j = bArr2;
    }

    private void g(int i11) {
        byte[] bArr = this.f77300j;
        if (bArr.length < i11 + 16384) {
            this.f77300j = Arrays.copyOf(bArr, bArr.length + 16384);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public final void cancelLoad() {
        this.f77301k = true;
    }

    protected abstract void e(byte[] bArr, int i11);

    public byte[] f() {
        return this.f77300j;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public final void load() {
        try {
            this.f77263i.a(this.f77256b);
            int i11 = 0;
            int i12 = 0;
            while (i11 != -1 && !this.f77301k) {
                g(i12);
                i11 = this.f77263i.read(this.f77300j, i12, 16384);
                if (i11 != -1) {
                    i12 += i11;
                }
            }
            if (!this.f77301k) {
                e(this.f77300j, i12);
            }
            com.google.android.exoplayer2.upstream.m.a(this.f77263i);
        } catch (Throwable th2) {
            com.google.android.exoplayer2.upstream.m.a(this.f77263i);
            throw th2;
        }
    }
}
