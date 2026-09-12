package d3;

import androidx.media3.common.ParserException;
import java.util.ArrayDeque;
import l2.s;

/* loaded from: classes2.dex */
final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f61269a = new byte[8];

    /* renamed from: b, reason: collision with root package name */
    private final ArrayDeque f61270b = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    private final g f61271c = new g();

    /* renamed from: d, reason: collision with root package name */
    private d3.b f61272d;

    /* renamed from: e, reason: collision with root package name */
    private int f61273e;

    /* renamed from: f, reason: collision with root package name */
    private int f61274f;

    /* renamed from: g, reason: collision with root package name */
    private long f61275g;

    /* loaded from: classes2.dex */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final int f61276a;

        /* renamed from: b, reason: collision with root package name */
        private final long f61277b;

        private b(int i11, long j11) {
            this.f61276a = i11;
            this.f61277b = j11;
        }
    }

    private long c(s sVar) {
        sVar.resetPeekPosition();
        while (true) {
            sVar.peekFully(this.f61269a, 0, 4);
            int c11 = g.c(this.f61269a[0]);
            if (c11 != -1 && c11 <= 4) {
                int a11 = (int) g.a(this.f61269a, c11, false);
                if (this.f61272d.isLevel1Element(a11)) {
                    sVar.skipFully(c11);
                    return a11;
                }
            }
            sVar.skipFully(1);
        }
    }

    private double d(s sVar, int i11) {
        return i11 == 4 ? Float.intBitsToFloat((int) r0) : Double.longBitsToDouble(e(sVar, i11));
    }

    private long e(s sVar, int i11) {
        sVar.readFully(this.f61269a, 0, i11);
        long j11 = 0;
        for (int i12 = 0; i12 < i11; i12++) {
            j11 = (j11 << 8) | (this.f61269a[i12] & 255);
        }
        return j11;
    }

    private static String f(s sVar, int i11) {
        if (i11 == 0) {
            return "";
        }
        byte[] bArr = new byte[i11];
        sVar.readFully(bArr, 0, i11);
        while (i11 > 0 && bArr[i11 - 1] == 0) {
            i11--;
        }
        return new String(bArr, 0, i11);
    }

    @Override // d3.c
    public boolean a(s sVar) {
        androidx.media3.common.util.a.i(this.f61272d);
        while (true) {
            b bVar = (b) this.f61270b.peek();
            if (bVar != null && sVar.getPosition() >= bVar.f61277b) {
                this.f61272d.endMasterElement(((b) this.f61270b.pop()).f61276a);
                return true;
            }
            if (this.f61273e == 0) {
                long d11 = this.f61271c.d(sVar, true, false, 4);
                if (d11 == -2) {
                    d11 = c(sVar);
                }
                if (d11 == -1) {
                    return false;
                }
                this.f61274f = (int) d11;
                this.f61273e = 1;
            }
            if (this.f61273e == 1) {
                this.f61275g = this.f61271c.d(sVar, false, true, 8);
                this.f61273e = 2;
            }
            int elementType = this.f61272d.getElementType(this.f61274f);
            if (elementType != 0) {
                if (elementType == 1) {
                    long position = sVar.getPosition();
                    this.f61270b.push(new b(this.f61274f, this.f61275g + position));
                    this.f61272d.startMasterElement(this.f61274f, position, this.f61275g);
                    this.f61273e = 0;
                    return true;
                }
                if (elementType == 2) {
                    long j11 = this.f61275g;
                    if (j11 <= 8) {
                        this.f61272d.integerElement(this.f61274f, e(sVar, (int) j11));
                        this.f61273e = 0;
                        return true;
                    }
                    throw ParserException.createForMalformedContainer("Invalid integer size: " + this.f61275g, null);
                }
                if (elementType == 3) {
                    long j12 = this.f61275g;
                    if (j12 <= 2147483647L) {
                        this.f61272d.stringElement(this.f61274f, f(sVar, (int) j12));
                        this.f61273e = 0;
                        return true;
                    }
                    throw ParserException.createForMalformedContainer("String element size: " + this.f61275g, null);
                }
                if (elementType == 4) {
                    this.f61272d.a(this.f61274f, (int) this.f61275g, sVar);
                    this.f61273e = 0;
                    return true;
                }
                if (elementType != 5) {
                    throw ParserException.createForMalformedContainer("Invalid element type " + elementType, null);
                }
                long j13 = this.f61275g;
                if (j13 == 4 || j13 == 8) {
                    this.f61272d.floatElement(this.f61274f, d(sVar, (int) j13));
                    this.f61273e = 0;
                    return true;
                }
                throw ParserException.createForMalformedContainer("Invalid float size: " + this.f61275g, null);
            }
            sVar.skipFully((int) this.f61275g);
            this.f61273e = 0;
        }
    }

    @Override // d3.c
    public void b(d3.b bVar) {
        this.f61272d = bVar;
    }

    @Override // d3.c
    public void reset() {
        this.f61273e = 0;
        this.f61270b.clear();
        this.f61271c.e();
    }
}
