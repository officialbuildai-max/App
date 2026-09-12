package com.google.android.exoplayer2.decoder;

import android.media.MediaCodec;
import com.google.android.exoplayer2.util.p0;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f24917a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f24918b;

    /* renamed from: c, reason: collision with root package name */
    public int f24919c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f24920d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f24921e;

    /* renamed from: f, reason: collision with root package name */
    public int f24922f;

    /* renamed from: g, reason: collision with root package name */
    public int f24923g;

    /* renamed from: h, reason: collision with root package name */
    public int f24924h;

    /* renamed from: i, reason: collision with root package name */
    private final MediaCodec.CryptoInfo f24925i;

    /* renamed from: j, reason: collision with root package name */
    private final b f24926j;

    /* loaded from: classes3.dex */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final MediaCodec.CryptoInfo f24927a;

        /* renamed from: b, reason: collision with root package name */
        private final MediaCodec.CryptoInfo.Pattern f24928b;

        private b(MediaCodec.CryptoInfo cryptoInfo) {
            this.f24927a = cryptoInfo;
            this.f24928b = androidx.media3.decoder.d.a(0, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i11, int i12) {
            this.f24928b.set(i11, i12);
            this.f24927a.setPattern(this.f24928b);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.f24925i = cryptoInfo;
        this.f24926j = p0.f27680a >= 24 ? new b(cryptoInfo) : null;
    }

    public MediaCodec.CryptoInfo a() {
        return this.f24925i;
    }

    public void b(int i11) {
        if (i11 == 0) {
            return;
        }
        if (this.f24920d == null) {
            int[] iArr = new int[1];
            this.f24920d = iArr;
            this.f24925i.numBytesOfClearData = iArr;
        }
        int[] iArr2 = this.f24920d;
        iArr2[0] = iArr2[0] + i11;
    }

    public void c(int i11, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i12, int i13, int i14) {
        this.f24922f = i11;
        this.f24920d = iArr;
        this.f24921e = iArr2;
        this.f24918b = bArr;
        this.f24917a = bArr2;
        this.f24919c = i12;
        this.f24923g = i13;
        this.f24924h = i14;
        MediaCodec.CryptoInfo cryptoInfo = this.f24925i;
        cryptoInfo.numSubSamples = i11;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i12;
        if (p0.f27680a >= 24) {
            ((b) com.google.android.exoplayer2.util.a.e(this.f24926j)).b(i13, i14);
        }
    }
}
