package g9;

import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.p0;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class f implements m {

    /* renamed from: b, reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.g f63518b;

    /* renamed from: c, reason: collision with root package name */
    private final long f63519c;

    /* renamed from: d, reason: collision with root package name */
    private long f63520d;

    /* renamed from: f, reason: collision with root package name */
    private int f63522f;

    /* renamed from: g, reason: collision with root package name */
    private int f63523g;

    /* renamed from: e, reason: collision with root package name */
    private byte[] f63521e = new byte[65536];

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f63517a = new byte[4096];

    static {
        m1.a("goog.exo.extractor");
    }

    public f(com.google.android.exoplayer2.upstream.g gVar, long j11, long j12) {
        this.f63518b = gVar;
        this.f63520d = j11;
        this.f63519c = j12;
    }

    private void f(int i11) {
        if (i11 != -1) {
            this.f63520d += i11;
        }
    }

    private void h(int i11) {
        int i12 = this.f63522f + i11;
        byte[] bArr = this.f63521e;
        if (i12 > bArr.length) {
            this.f63521e = Arrays.copyOf(this.f63521e, p0.q(bArr.length * 2, 65536 + i12, i12 + 524288));
        }
    }

    private int i(byte[] bArr, int i11, int i12) {
        int i13 = this.f63523g;
        if (i13 == 0) {
            return 0;
        }
        int min = Math.min(i13, i12);
        System.arraycopy(this.f63521e, 0, bArr, i11, min);
        m(min);
        return min;
    }

    private int j(byte[] bArr, int i11, int i12, int i13, boolean z10) {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        int read = this.f63518b.read(bArr, i11 + i13, i12 - i13);
        if (read != -1) {
            return i13 + read;
        }
        if (i13 == 0 && z10) {
            return -1;
        }
        throw new EOFException();
    }

    private int k(int i11) {
        int min = Math.min(this.f63523g, i11);
        m(min);
        return min;
    }

    private void m(int i11) {
        int i12 = this.f63523g - i11;
        this.f63523g = i12;
        this.f63522f = 0;
        byte[] bArr = this.f63521e;
        byte[] bArr2 = i12 < bArr.length - 524288 ? new byte[65536 + i12] : bArr;
        System.arraycopy(bArr, i11, bArr2, 0, i12);
        this.f63521e = bArr2;
    }

    @Override // g9.m
    public void advancePeekPosition(int i11) {
        advancePeekPosition(i11, false);
    }

    @Override // g9.m
    public boolean advancePeekPosition(int i11, boolean z10) {
        h(i11);
        int i12 = this.f63523g - this.f63522f;
        while (i12 < i11) {
            i12 = j(this.f63521e, this.f63522f, i11, i12, z10);
            if (i12 == -1) {
                return false;
            }
            this.f63523g = this.f63522f + i12;
        }
        this.f63522f += i11;
        return true;
    }

    @Override // g9.m
    public int b(byte[] bArr, int i11, int i12) {
        int min;
        h(i12);
        int i13 = this.f63523g;
        int i14 = this.f63522f;
        int i15 = i13 - i14;
        if (i15 == 0) {
            min = j(this.f63521e, i14, i12, 0, true);
            if (min == -1) {
                return -1;
            }
            this.f63523g += min;
        } else {
            min = Math.min(i12, i15);
        }
        System.arraycopy(this.f63521e, this.f63522f, bArr, i11, min);
        this.f63522f += min;
        return min;
    }

    @Override // g9.m
    public long getLength() {
        return this.f63519c;
    }

    @Override // g9.m
    public long getPeekPosition() {
        return this.f63520d + this.f63522f;
    }

    @Override // g9.m
    public long getPosition() {
        return this.f63520d;
    }

    public boolean l(int i11, boolean z10) {
        int k11 = k(i11);
        while (k11 < i11 && k11 != -1) {
            k11 = j(this.f63517a, -k11, Math.min(i11, this.f63517a.length + k11), k11, z10);
        }
        f(k11);
        return k11 != -1;
    }

    @Override // g9.m
    public void peekFully(byte[] bArr, int i11, int i12) {
        peekFully(bArr, i11, i12, false);
    }

    @Override // g9.m
    public boolean peekFully(byte[] bArr, int i11, int i12, boolean z10) {
        if (!advancePeekPosition(i12, z10)) {
            return false;
        }
        System.arraycopy(this.f63521e, this.f63522f - i12, bArr, i11, i12);
        return true;
    }

    @Override // g9.m, com.google.android.exoplayer2.upstream.g
    public int read(byte[] bArr, int i11, int i12) {
        int i13 = i(bArr, i11, i12);
        if (i13 == 0) {
            i13 = j(bArr, i11, i12, 0, true);
        }
        f(i13);
        return i13;
    }

    @Override // g9.m
    public void readFully(byte[] bArr, int i11, int i12) {
        readFully(bArr, i11, i12, false);
    }

    @Override // g9.m
    public boolean readFully(byte[] bArr, int i11, int i12, boolean z10) {
        int i13 = i(bArr, i11, i12);
        while (i13 < i12 && i13 != -1) {
            i13 = j(bArr, i11, i12, i13, z10);
        }
        f(i13);
        return i13 != -1;
    }

    @Override // g9.m
    public void resetPeekPosition() {
        this.f63522f = 0;
    }

    @Override // g9.m
    public int skip(int i11) {
        int k11 = k(i11);
        if (k11 == 0) {
            byte[] bArr = this.f63517a;
            k11 = j(bArr, 0, Math.min(i11, bArr.length), 0, true);
        }
        f(k11);
        return k11;
    }

    @Override // g9.m
    public void skipFully(int i11) {
        l(i11, false);
    }
}
