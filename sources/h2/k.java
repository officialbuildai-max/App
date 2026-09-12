package h2;

import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Arrays;

/* loaded from: classes2.dex */
public abstract class k extends e {

    /* renamed from: j, reason: collision with root package name */
    private byte[] f64466j;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f64467k;

    public k(androidx.media3.datasource.a aVar, w1.h hVar, int i11, r rVar, int i12, Object obj, byte[] bArr) {
        super(aVar, hVar, i11, rVar, i12, obj, C.TIME_UNSET, C.TIME_UNSET);
        k kVar;
        byte[] bArr2;
        if (bArr == null) {
            bArr2 = a1.f10437f;
            kVar = this;
        } else {
            kVar = this;
            bArr2 = bArr;
        }
        kVar.f64466j = bArr2;
    }

    private void g(int i11) {
        byte[] bArr = this.f64466j;
        if (bArr.length < i11 + 16384) {
            this.f64466j = Arrays.copyOf(bArr, bArr.length + 16384);
        }
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.d
    public final void cancelLoad() {
        this.f64467k = true;
    }

    protected abstract void e(byte[] bArr, int i11);

    public byte[] f() {
        return this.f64466j;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.d
    public final void load() {
        try {
            this.f64427i.a(this.f64420b);
            int i11 = 0;
            int i12 = 0;
            while (i11 != -1 && !this.f64467k) {
                g(i12);
                i11 = this.f64427i.read(this.f64466j, i12, 16384);
                if (i11 != -1) {
                    i12 += i11;
                }
            }
            if (!this.f64467k) {
                e(this.f64466j, i12);
            }
            w1.g.a(this.f64427i);
        } catch (Throwable th2) {
            w1.g.a(this.f64427i);
            throw th2;
        }
    }
}
