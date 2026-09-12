package androidx.datastore.preferences.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    private Iterator f9003a;

    /* renamed from: b, reason: collision with root package name */
    private ByteBuffer f9004b;

    /* renamed from: c, reason: collision with root package name */
    private int f9005c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f9006d;

    /* renamed from: e, reason: collision with root package name */
    private int f9007e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f9008f;

    /* renamed from: g, reason: collision with root package name */
    private byte[] f9009g;

    /* renamed from: h, reason: collision with root package name */
    private int f9010h;

    /* renamed from: i, reason: collision with root package name */
    private long f9011i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(Iterable iterable) {
        this.f9003a = iterable.iterator();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            this.f9005c++;
        }
        this.f9006d = -1;
        if (d()) {
            return;
        }
        this.f9004b = w.f9001e;
        this.f9006d = 0;
        this.f9007e = 0;
        this.f9011i = 0L;
    }

    private boolean d() {
        this.f9006d++;
        if (!this.f9003a.hasNext()) {
            return false;
        }
        ByteBuffer byteBuffer = (ByteBuffer) this.f9003a.next();
        this.f9004b = byteBuffer;
        this.f9007e = byteBuffer.position();
        if (this.f9004b.hasArray()) {
            this.f9008f = true;
            this.f9009g = this.f9004b.array();
            this.f9010h = this.f9004b.arrayOffset();
        } else {
            this.f9008f = false;
            this.f9011i = k1.k(this.f9004b);
            this.f9009g = null;
        }
        return true;
    }

    private void h(int i11) {
        int i12 = this.f9007e + i11;
        this.f9007e = i12;
        if (i12 == this.f9004b.limit()) {
            d();
        }
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f9006d == this.f9005c) {
            return -1;
        }
        if (this.f9008f) {
            int i11 = this.f9009g[this.f9007e + this.f9010h] & 255;
            h(1);
            return i11;
        }
        int w11 = k1.w(this.f9007e + this.f9011i) & 255;
        h(1);
        return w11;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i11, int i12) {
        if (this.f9006d == this.f9005c) {
            return -1;
        }
        int limit = this.f9004b.limit();
        int i13 = this.f9007e;
        int i14 = limit - i13;
        if (i12 > i14) {
            i12 = i14;
        }
        if (this.f9008f) {
            System.arraycopy(this.f9009g, i13 + this.f9010h, bArr, i11, i12);
            h(i12);
        } else {
            int position = this.f9004b.position();
            y.c(this.f9004b, this.f9007e);
            this.f9004b.get(bArr, i11, i12);
            y.c(this.f9004b, position);
            h(i12);
        }
        return i12;
    }
}
