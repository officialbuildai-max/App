package m9;

import com.google.android.exoplayer2.ParserException;
import g9.m;
import java.util.ArrayDeque;

/* loaded from: classes4.dex */
final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f69471a = new byte[8];

    /* renamed from: b, reason: collision with root package name */
    private final ArrayDeque f69472b = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    private final g f69473c = new g();

    /* renamed from: d, reason: collision with root package name */
    private m9.b f69474d;

    /* renamed from: e, reason: collision with root package name */
    private int f69475e;

    /* renamed from: f, reason: collision with root package name */
    private int f69476f;

    /* renamed from: g, reason: collision with root package name */
    private long f69477g;

    /* loaded from: classes4.dex */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final int f69478a;

        /* renamed from: b, reason: collision with root package name */
        private final long f69479b;

        private b(int i11, long j11) {
            this.f69478a = i11;
            this.f69479b = j11;
        }
    }

    private long c(m mVar) {
        mVar.resetPeekPosition();
        while (true) {
            mVar.peekFully(this.f69471a, 0, 4);
            int c11 = g.c(this.f69471a[0]);
            if (c11 != -1 && c11 <= 4) {
                int a11 = (int) g.a(this.f69471a, c11, false);
                if (this.f69474d.isLevel1Element(a11)) {
                    mVar.skipFully(c11);
                    return a11;
                }
            }
            mVar.skipFully(1);
        }
    }

    private double d(m mVar, int i11) {
        return i11 == 4 ? Float.intBitsToFloat((int) r0) : Double.longBitsToDouble(e(mVar, i11));
    }

    private long e(m mVar, int i11) {
        mVar.readFully(this.f69471a, 0, i11);
        long j11 = 0;
        for (int i12 = 0; i12 < i11; i12++) {
            j11 = (j11 << 8) | (this.f69471a[i12] & 255);
        }
        return j11;
    }

    private static String f(m mVar, int i11) {
        if (i11 == 0) {
            return "";
        }
        byte[] bArr = new byte[i11];
        mVar.readFully(bArr, 0, i11);
        while (i11 > 0 && bArr[i11 - 1] == 0) {
            i11--;
        }
        return new String(bArr, 0, i11);
    }

    @Override // m9.c
    public boolean a(m mVar) {
        com.google.android.exoplayer2.util.a.i(this.f69474d);
        while (true) {
            b bVar = (b) this.f69472b.peek();
            if (bVar != null && mVar.getPosition() >= bVar.f69479b) {
                this.f69474d.endMasterElement(((b) this.f69472b.pop()).f69478a);
                return true;
            }
            if (this.f69475e == 0) {
                long d11 = this.f69473c.d(mVar, true, false, 4);
                if (d11 == -2) {
                    d11 = c(mVar);
                }
                if (d11 == -1) {
                    return false;
                }
                this.f69476f = (int) d11;
                this.f69475e = 1;
            }
            if (this.f69475e == 1) {
                this.f69477g = this.f69473c.d(mVar, false, true, 8);
                this.f69475e = 2;
            }
            int elementType = this.f69474d.getElementType(this.f69476f);
            if (elementType != 0) {
                if (elementType == 1) {
                    long position = mVar.getPosition();
                    this.f69472b.push(new b(this.f69476f, this.f69477g + position));
                    this.f69474d.startMasterElement(this.f69476f, position, this.f69477g);
                    this.f69475e = 0;
                    return true;
                }
                if (elementType == 2) {
                    long j11 = this.f69477g;
                    if (j11 <= 8) {
                        this.f69474d.integerElement(this.f69476f, e(mVar, (int) j11));
                        this.f69475e = 0;
                        return true;
                    }
                    throw ParserException.createForMalformedContainer("Invalid integer size: " + this.f69477g, null);
                }
                if (elementType == 3) {
                    long j12 = this.f69477g;
                    if (j12 <= 2147483647L) {
                        this.f69474d.stringElement(this.f69476f, f(mVar, (int) j12));
                        this.f69475e = 0;
                        return true;
                    }
                    throw ParserException.createForMalformedContainer("String element size: " + this.f69477g, null);
                }
                if (elementType == 4) {
                    this.f69474d.a(this.f69476f, (int) this.f69477g, mVar);
                    this.f69475e = 0;
                    return true;
                }
                if (elementType != 5) {
                    throw ParserException.createForMalformedContainer("Invalid element type " + elementType, null);
                }
                long j13 = this.f69477g;
                if (j13 == 4 || j13 == 8) {
                    this.f69474d.floatElement(this.f69476f, d(mVar, (int) j13));
                    this.f69475e = 0;
                    return true;
                }
                throw ParserException.createForMalformedContainer("Invalid float size: " + this.f69477g, null);
            }
            mVar.skipFully((int) this.f69477g);
            this.f69475e = 0;
        }
    }

    @Override // m9.c
    public void b(m9.b bVar) {
        this.f69474d = bVar;
    }

    @Override // m9.c
    public void reset() {
        this.f69475e = 0;
        this.f69472b.clear();
        this.f69473c.e();
    }
}
