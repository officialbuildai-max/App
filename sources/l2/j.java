package l2;

import androidx.media3.common.util.a1;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class j implements s {

    /* renamed from: b, reason: collision with root package name */
    private final androidx.media3.common.j f68737b;

    /* renamed from: c, reason: collision with root package name */
    private final long f68738c;

    /* renamed from: d, reason: collision with root package name */
    private long f68739d;

    /* renamed from: f, reason: collision with root package name */
    private int f68741f;

    /* renamed from: g, reason: collision with root package name */
    private int f68742g;

    /* renamed from: e, reason: collision with root package name */
    private byte[] f68740e = new byte[65536];

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f68736a = new byte[4096];

    static {
        androidx.media3.common.u.a("media3.extractor");
    }

    public j(androidx.media3.common.j jVar, long j11, long j12) {
        this.f68737b = jVar;
        this.f68739d = j11;
        this.f68738c = j12;
    }

    private void d(int i11) {
        if (i11 != -1) {
            this.f68739d += i11;
        }
    }

    private void e(int i11) {
        int i12 = this.f68741f + i11;
        byte[] bArr = this.f68740e;
        if (i12 > bArr.length) {
            this.f68740e = Arrays.copyOf(this.f68740e, a1.p(bArr.length * 2, 65536 + i12, i12 + 524288));
        }
    }

    private int f(byte[] bArr, int i11, int i12) {
        int i13 = this.f68742g;
        if (i13 == 0) {
            return 0;
        }
        int min = Math.min(i13, i12);
        System.arraycopy(this.f68740e, 0, bArr, i11, min);
        j(min);
        return min;
    }

    private int g(byte[] bArr, int i11, int i12, int i13, boolean z10) {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        int read = this.f68737b.read(bArr, i11 + i13, i12 - i13);
        if (read != -1) {
            return i13 + read;
        }
        if (i13 == 0 && z10) {
            return -1;
        }
        throw new EOFException();
    }

    private int h(int i11) {
        int min = Math.min(this.f68742g, i11);
        j(min);
        return min;
    }

    private void j(int i11) {
        int i12 = this.f68742g - i11;
        this.f68742g = i12;
        this.f68741f = 0;
        byte[] bArr = this.f68740e;
        byte[] bArr2 = i12 < bArr.length - 524288 ? new byte[65536 + i12] : bArr;
        System.arraycopy(bArr, i11, bArr2, 0, i12);
        this.f68740e = bArr2;
    }

    @Override // l2.s
    public void advancePeekPosition(int i11) {
        advancePeekPosition(i11, false);
    }

    @Override // l2.s
    public boolean advancePeekPosition(int i11, boolean z10) {
        e(i11);
        int i12 = this.f68742g - this.f68741f;
        while (i12 < i11) {
            i12 = g(this.f68740e, this.f68741f, i11, i12, z10);
            if (i12 == -1) {
                return false;
            }
            this.f68742g = this.f68741f + i12;
        }
        this.f68741f += i11;
        return true;
    }

    @Override // l2.s
    public int b(byte[] bArr, int i11, int i12) {
        int min;
        e(i12);
        int i13 = this.f68742g;
        int i14 = this.f68741f;
        int i15 = i13 - i14;
        if (i15 == 0) {
            min = g(this.f68740e, i14, i12, 0, true);
            if (min == -1) {
                return -1;
            }
            this.f68742g += min;
        } else {
            min = Math.min(i12, i15);
        }
        System.arraycopy(this.f68740e, this.f68741f, bArr, i11, min);
        this.f68741f += min;
        return min;
    }

    @Override // l2.s
    public long getLength() {
        return this.f68738c;
    }

    @Override // l2.s
    public long getPeekPosition() {
        return this.f68739d + this.f68741f;
    }

    @Override // l2.s
    public long getPosition() {
        return this.f68739d;
    }

    public boolean i(int i11, boolean z10) {
        int h11 = h(i11);
        while (h11 < i11 && h11 != -1) {
            h11 = g(this.f68736a, -h11, Math.min(i11, this.f68736a.length + h11), h11, z10);
        }
        d(h11);
        return h11 != -1;
    }

    @Override // l2.s
    public void peekFully(byte[] bArr, int i11, int i12) {
        peekFully(bArr, i11, i12, false);
    }

    @Override // l2.s
    public boolean peekFully(byte[] bArr, int i11, int i12, boolean z10) {
        if (!advancePeekPosition(i12, z10)) {
            return false;
        }
        System.arraycopy(this.f68740e, this.f68741f - i12, bArr, i11, i12);
        return true;
    }

    @Override // l2.s, androidx.media3.common.j
    public int read(byte[] bArr, int i11, int i12) {
        int f11 = f(bArr, i11, i12);
        if (f11 == 0) {
            f11 = g(bArr, i11, i12, 0, true);
        }
        d(f11);
        return f11;
    }

    @Override // l2.s
    public void readFully(byte[] bArr, int i11, int i12) {
        readFully(bArr, i11, i12, false);
    }

    @Override // l2.s
    public boolean readFully(byte[] bArr, int i11, int i12, boolean z10) {
        int f11 = f(bArr, i11, i12);
        while (f11 < i12 && f11 != -1) {
            f11 = g(bArr, i11, i12, f11, z10);
        }
        d(f11);
        return f11 != -1;
    }

    @Override // l2.s
    public void resetPeekPosition() {
        this.f68741f = 0;
    }

    @Override // l2.s
    public int skip(int i11) {
        int h11 = h(i11);
        if (h11 == 0) {
            byte[] bArr = this.f68736a;
            h11 = g(bArr, 0, Math.min(i11, bArr.length), 0, true);
        }
        d(h11);
        return h11;
    }

    @Override // l2.s
    public void skipFully(int i11) {
        i(i11, false);
    }
}
