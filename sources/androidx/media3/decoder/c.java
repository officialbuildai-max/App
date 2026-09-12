package androidx.media3.decoder;

import android.media.MediaCodec;
import androidx.media3.common.util.a1;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f11029a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f11030b;

    /* renamed from: c, reason: collision with root package name */
    public int f11031c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f11032d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f11033e;

    /* renamed from: f, reason: collision with root package name */
    public int f11034f;

    /* renamed from: g, reason: collision with root package name */
    public int f11035g;

    /* renamed from: h, reason: collision with root package name */
    public int f11036h;

    /* renamed from: i, reason: collision with root package name */
    private final MediaCodec.CryptoInfo f11037i;

    /* renamed from: j, reason: collision with root package name */
    private final b f11038j;

    /* loaded from: classes2.dex */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final MediaCodec.CryptoInfo f11039a;

        /* renamed from: b, reason: collision with root package name */
        private final MediaCodec.CryptoInfo.Pattern f11040b;

        private b(MediaCodec.CryptoInfo cryptoInfo) {
            this.f11039a = cryptoInfo;
            this.f11040b = d.a(0, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i11, int i12) {
            this.f11040b.set(i11, i12);
            this.f11039a.setPattern(this.f11040b);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.f11037i = cryptoInfo;
        this.f11038j = a1.f10432a >= 24 ? new b(cryptoInfo) : null;
    }

    public MediaCodec.CryptoInfo a() {
        return this.f11037i;
    }

    public void b(int i11) {
        if (i11 == 0) {
            return;
        }
        if (this.f11032d == null) {
            int[] iArr = new int[1];
            this.f11032d = iArr;
            this.f11037i.numBytesOfClearData = iArr;
        }
        int[] iArr2 = this.f11032d;
        iArr2[0] = iArr2[0] + i11;
    }

    public void c(int i11, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i12, int i13, int i14) {
        this.f11034f = i11;
        this.f11032d = iArr;
        this.f11033e = iArr2;
        this.f11030b = bArr;
        this.f11029a = bArr2;
        this.f11031c = i12;
        this.f11035g = i13;
        this.f11036h = i14;
        MediaCodec.CryptoInfo cryptoInfo = this.f11037i;
        cryptoInfo.numSubSamples = i11;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i12;
        if (a1.f10432a >= 24) {
            ((b) androidx.media3.common.util.a.e(this.f11038j)).b(i13, i14);
        }
    }
}
