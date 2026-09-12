package ff;

import com.tencent.tinker.android.dex.DexException;
import com.tencent.tinker.android.dex.MethodHandle;
import com.tencent.tinker.android.dex.c;
import com.tencent.tinker.android.dex.d;
import com.tencent.tinker.android.dex.e;
import com.tencent.tinker.android.dex.f;
import com.tencent.tinker.android.dex.g;
import com.tencent.tinker.android.dex.h;
import com.tencent.tinker.android.dex.i;
import com.tencent.tinker.android.dex.l;
import com.tencent.tinker.android.dex.n;
import com.tencent.tinker.android.dex.o;
import com.tencent.tinker.android.dex.p;
import com.tencent.tinker.android.dex.q;
import com.tencent.tinker.android.dex.r;
import com.tencent.tinker.android.dex.s;
import com.tencent.tinker.android.dex.t;
import com.tencent.tinker.android.dex.u;
import com.tencent.tinker.android.dex.w;
import gf.b;
import java.io.ByteArrayOutputStream;
import java.io.UTFDataFormatException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes5.dex */
public class a implements gf.a, b {

    /* renamed from: d, reason: collision with root package name */
    private static final short[] f62505d = new short[0];

    /* renamed from: e, reason: collision with root package name */
    private static final h.b[] f62506e = new h.b[0];

    /* renamed from: f, reason: collision with root package name */
    private static final h.a[] f62507f = new h.a[0];

    /* renamed from: a, reason: collision with root package name */
    private ByteBuffer f62508a;

    /* renamed from: b, reason: collision with root package name */
    private int f62509b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f62510c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ff.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0781a implements b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ByteArrayOutputStream f62511a;

        C0781a(ByteArrayOutputStream byteArrayOutputStream) {
            this.f62511a = byteArrayOutputStream;
        }

        @Override // gf.b
        public void writeByte(int i11) {
            this.f62511a.write(i11);
        }
    }

    public a() {
        ByteBuffer allocate = ByteBuffer.allocate(512);
        this.f62508a = allocate;
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        this.f62509b = this.f62508a.position();
        ByteBuffer byteBuffer = this.f62508a;
        this.f62510c = true;
    }

    public a(ByteBuffer byteBuffer) {
        this.f62508a = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        this.f62509b = byteBuffer.limit();
        this.f62510c = false;
    }

    private h.b[] F(int i11, h.a[] aVarArr) {
        h.b[] bVarArr = new h.b[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            bVarArr[i12] = new h.b(w(), J(), d(aVarArr, J()));
        }
        return bVarArr;
    }

    private void T(h.a aVar) {
        int i11 = aVar.f40658c;
        int[] iArr = aVar.f40656a;
        int[] iArr2 = aVar.f40657b;
        if (i11 != -1) {
            i0(-iArr.length);
        } else {
            i0(iArr.length);
        }
        for (int i12 = 0; i12 < iArr.length; i12++) {
            m0(iArr[i12]);
            m0(iArr2[i12]);
        }
        if (i11 != -1) {
            m0(i11);
        }
    }

    private int[] U(h.a[] aVarArr) {
        int position = this.f62508a.position();
        m0(aVarArr.length);
        int[] iArr = new int[aVarArr.length];
        for (int i11 = 0; i11 < aVarArr.length; i11++) {
            iArr[i11] = this.f62508a.position() - position;
            T(aVarArr[i11]);
        }
        return iArr;
    }

    private void b0(f.a[] aVarArr) {
        int i11 = 0;
        for (f.a aVar : aVarArr) {
            m0(aVar.f40636a - i11);
            i11 = aVar.f40636a;
            m0(aVar.f40637b);
        }
    }

    private void c(int i11) {
        if (this.f62508a.position() + i11 <= this.f62508a.limit() || !this.f62510c) {
            return;
        }
        byte[] array = this.f62508a.array();
        byte[] bArr = new byte[array.length + i11 + (array.length >> 1)];
        System.arraycopy(array, 0, bArr, 0, this.f62508a.position());
        int position = this.f62508a.position();
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f62508a = wrap;
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        ByteBuffer byteBuffer = this.f62508a;
    }

    private int d(h.a[] aVarArr, int i11) {
        for (int i12 = 0; i12 < aVarArr.length; i12++) {
            if (aVarArr[i12].f40659d == i11) {
                return i12;
            }
        }
        throw new IllegalArgumentException();
    }

    private byte[] e(int i11) {
        byte[] bArr = new byte[this.f62508a.position() - i11];
        this.f62508a.get(bArr);
        return bArr;
    }

    private void f0(f.b[] bVarArr) {
        int i11 = 0;
        for (f.b bVar : bVarArr) {
            m0(bVar.f40638a - i11);
            i11 = bVar.f40638a;
            m0(bVar.f40639b);
            m0(bVar.f40640c);
        }
    }

    private void k0(h.b[] bVarArr, int[] iArr) {
        for (h.b bVar : bVarArr) {
            c0(bVar.f40660a);
            o0(bVar.f40661b);
            o0(iArr[bVar.f40662c]);
        }
    }

    private h.a n(int i11) {
        int D = D();
        int abs = Math.abs(D);
        int[] iArr = new int[abs];
        int[] iArr2 = new int[abs];
        for (int i12 = 0; i12 < abs; i12++) {
            iArr[i12] = H();
            iArr2[i12] = H();
        }
        return new h.a(iArr, iArr2, D <= 0 ? H() : -1, i11);
    }

    private h.a[] o() {
        int position = this.f62508a.position();
        int H = H();
        h.a[] aVarArr = new h.a[H];
        for (int i11 = 0; i11 < H; i11++) {
            aVarArr[i11] = n(this.f62508a.position() - position);
        }
        return aVarArr;
    }

    private f.a[] v(int i11) {
        f.a[] aVarArr = new f.a[i11];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            i12 += H();
            aVarArr[i13] = new f.a(i12, H());
        }
        return aVarArr;
    }

    private f.b[] z(int i11) {
        f.b[] bVarArr = new f.b[i11];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            i12 += H();
            bVarArr[i13] = new f.b(i12, H(), H());
        }
        return bVarArr;
    }

    public s A() {
        return new s(this.f62508a.position(), w(), w(), w());
    }

    public short B() {
        return this.f62508a.getShort();
    }

    public short[] C(int i11) {
        if (i11 == 0) {
            return f62505d;
        }
        short[] sArr = new short[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            sArr[i12] = B();
        }
        return sArr;
    }

    public int D() {
        return p.a(this);
    }

    public u E() {
        int position = this.f62508a.position();
        try {
            int H = H();
            String b11 = r.b(this, new char[H]);
            if (b11.length() == H) {
                return new u(position, b11);
            }
            throw new DexException("Declared length " + H + " doesn't match decoded length of " + b11.length());
        } catch (UTFDataFormatException e11) {
            throw new DexException(e11);
        }
    }

    public w G() {
        return new w(this.f62508a.position(), C(w()));
    }

    public int H() {
        return p.b(this);
    }

    public int I() {
        return p.b(this) - 1;
    }

    public int J() {
        return B() & 65535;
    }

    public void K(int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException();
        }
        ByteBuffer byteBuffer = this.f62508a;
    }

    public void L(int i11) {
        c(i11);
        K(i11);
    }

    public void M(byte[] bArr) {
        c(bArr.length);
        this.f62508a.put(bArr);
        if (this.f62508a.position() > this.f62509b) {
            this.f62509b = this.f62508a.position();
        }
    }

    public void N(short[] sArr) {
        c(sArr.length * 2);
        for (short s11 : sArr) {
            h0(s11);
        }
        if (this.f62508a.position() > this.f62509b) {
            this.f62509b = this.f62508a.position();
        }
    }

    public int O(com.tencent.tinker.android.dex.a aVar) {
        int position = this.f62508a.position();
        writeByte(aVar.f40623b);
        Z(aVar.f40624c);
        return position;
    }

    public int P(com.tencent.tinker.android.dex.b bVar) {
        int position = this.f62508a.position();
        c0(bVar.f40625b.length);
        for (int i11 : bVar.f40625b) {
            c0(i11);
        }
        return position;
    }

    public int Q(c cVar) {
        int position = this.f62508a.position();
        c0(cVar.f40626b.length);
        for (int i11 : cVar.f40626b) {
            c0(i11);
        }
        return position;
    }

    public int R(d dVar) {
        int position = this.f62508a.position();
        c0(dVar.f40627b);
        c0(dVar.f40628c.length);
        c0(dVar.f40629d.length);
        c0(dVar.f40630e.length);
        for (int[] iArr : dVar.f40628c) {
            c0(iArr[0]);
            c0(iArr[1]);
        }
        for (int[] iArr2 : dVar.f40629d) {
            c0(iArr2[0]);
            c0(iArr2[1]);
        }
        for (int[] iArr3 : dVar.f40630e) {
            c0(iArr3[0]);
            c0(iArr3[1]);
        }
        return position;
    }

    public int S(e eVar) {
        int position = this.f62508a.position();
        c0(eVar.f40631b);
        return position;
    }

    public int V(f fVar) {
        int position = this.f62508a.position();
        m0(fVar.f40632b.length);
        m0(fVar.f40633c.length);
        m0(fVar.f40634d.length);
        m0(fVar.f40635e.length);
        b0(fVar.f40632b);
        b0(fVar.f40633c);
        f0(fVar.f40634d);
        f0(fVar.f40635e);
        return position;
    }

    public int W(g gVar) {
        int position = this.f62508a.position();
        c0(gVar.f40641b);
        c0(gVar.f40642c);
        c0(gVar.f40643d);
        c0(gVar.f40644e);
        c0(gVar.f40645f);
        c0(gVar.f40646g);
        c0(gVar.f40647h);
        c0(gVar.f40648i);
        return position;
    }

    public int X(h hVar) {
        int position = this.f62508a.position();
        o0(hVar.f40649b);
        o0(hVar.f40650c);
        o0(hVar.f40651d);
        o0(hVar.f40654g.length);
        c0(hVar.f40652e);
        c0(hVar.f40653f.length);
        N(hVar.f40653f);
        if (hVar.f40654g.length > 0) {
            if ((hVar.f40653f.length & 1) == 1) {
                h0((short) 0);
            }
            int position2 = this.f62508a.position();
            L(hVar.f40654g.length * 8);
            int[] U = U(hVar.f40655h);
            int position3 = this.f62508a.position();
            k0(hVar.f40654g, U);
        }
        return position;
    }

    public int Y(i iVar) {
        int position = this.f62508a.position();
        m0(iVar.f40663b);
        int length = iVar.f40664c.length;
        m0(length);
        for (int i11 = 0; i11 < length; i11++) {
            n0(iVar.f40664c[i11]);
        }
        M(iVar.f40665d);
        return position;
    }

    public int Z(l lVar) {
        int position = this.f62508a.position();
        M(lVar.f40691b);
        return position;
    }

    public void a() {
        ByteBuffer byteBuffer = this.f62508a;
    }

    public int a0(o oVar) {
        int position = this.f62508a.position();
        o0(oVar.f40698b);
        o0(oVar.f40699c);
        c0(oVar.f40700d);
        return position;
    }

    public void b() {
        c(t.a(this.f62508a.position()) - this.f62508a.position());
        while ((this.f62508a.position() & 3) != 0) {
            this.f62508a.put((byte) 0);
        }
        if (this.f62508a.position() > this.f62509b) {
            this.f62509b = this.f62508a.position();
        }
    }

    public void c0(int i11) {
        c(4);
        this.f62508a.putInt(i11);
        if (this.f62508a.position() > this.f62509b) {
            this.f62509b = this.f62508a.position();
        }
    }

    public int d0(MethodHandle methodHandle) {
        int position = this.f62508a.position();
        o0(methodHandle.f40618b.value);
        o0(methodHandle.f40619c);
        o0(methodHandle.f40620d);
        o0(methodHandle.f40621e);
        return position;
    }

    public int e0(q qVar) {
        int position = this.f62508a.position();
        o0(qVar.f40701b);
        o0(qVar.f40702c);
        c0(qVar.f40703d);
        return position;
    }

    public int f() {
        return this.f62508a.position();
    }

    public void g(int i11) {
    }

    public int g0(s sVar) {
        int position = this.f62508a.position();
        c0(sVar.f40704b);
        c0(sVar.f40705c);
        c0(sVar.f40706d);
        return position;
    }

    public com.tencent.tinker.android.dex.a h() {
        int position = this.f62508a.position();
        byte readByte = readByte();
        int position2 = this.f62508a.position();
        new n(this, 29).w();
        return new com.tencent.tinker.android.dex.a(position, readByte, new l(position2, e(position2)));
    }

    public void h0(short s11) {
        c(2);
        this.f62508a.putShort(s11);
        if (this.f62508a.position() > this.f62509b) {
            this.f62509b = this.f62508a.position();
        }
    }

    public com.tencent.tinker.android.dex.b i() {
        int position = this.f62508a.position();
        int w11 = w();
        int[] iArr = new int[w11];
        for (int i11 = 0; i11 < w11; i11++) {
            iArr[i11] = w();
        }
        return new com.tencent.tinker.android.dex.b(position, iArr);
    }

    public void i0(int i11) {
        p.d(this, i11);
    }

    public c j() {
        int position = this.f62508a.position();
        int w11 = w();
        int[] iArr = new int[w11];
        for (int i11 = 0; i11 < w11; i11++) {
            iArr[i11] = w();
        }
        return new c(position, iArr);
    }

    public int j0(u uVar) {
        int position = this.f62508a.position();
        try {
            m0(uVar.f40707b.length());
            M(r.d(uVar.f40707b));
            writeByte(0);
            return position;
        } catch (UTFDataFormatException e11) {
            throw new AssertionError(e11);
        }
    }

    public d k() {
        int position = this.f62508a.position();
        int w11 = w();
        int w12 = w();
        int w13 = w();
        int w14 = w();
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, w12, 2);
        for (int i11 = 0; i11 < w12; i11++) {
            iArr[i11][0] = w();
            iArr[i11][1] = w();
        }
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, w13, 2);
        for (int i12 = 0; i12 < w13; i12++) {
            iArr2[i12][0] = w();
            iArr2[i12][1] = w();
        }
        int[][] iArr3 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, w14, 2);
        for (int i13 = 0; i13 < w14; i13++) {
            iArr3[i13][0] = w();
            iArr3[i13][1] = w();
        }
        return new d(position, w11, iArr, iArr2, iArr3);
    }

    public byte[] l(int i11) {
        byte[] bArr = new byte[i11];
        this.f62508a.get(bArr);
        return bArr;
    }

    public int l0(w wVar) {
        int position = this.f62508a.position();
        short[] sArr = wVar.f40741b;
        c0(sArr.length);
        for (short s11 : sArr) {
            h0(s11);
        }
        return position;
    }

    public e m() {
        return new e(this.f62508a.position(), w());
    }

    public void m0(int i11) {
        p.e(this, i11);
    }

    public void n0(int i11) {
        m0(i11 + 1);
    }

    public void o0(int i11) {
        short s11 = (short) i11;
        if (i11 == (65535 & s11)) {
            h0(s11);
            return;
        }
        throw new IllegalArgumentException("Expected an unsigned short: " + i11);
    }

    public f p() {
        return new f(this.f62508a.position(), v(H()), v(H()), z(H()), z(H()));
    }

    public g q() {
        return new g(f(), w(), w(), w(), w(), w(), w(), w(), w());
    }

    public h r() {
        h.b[] bVarArr;
        h.a[] aVarArr;
        int position = this.f62508a.position();
        int J = J();
        int J2 = J();
        int J3 = J();
        int J4 = J();
        int w11 = w();
        short[] C = C(w());
        if (J4 > 0) {
            if ((C.length & 1) == 1) {
                K(2);
            }
            int position2 = this.f62508a.position();
            K(J4 * 8);
            h.a[] o11 = o();
            int position3 = this.f62508a.position();
            h.b[] F = F(J4, o11);
            aVarArr = o11;
            bVarArr = F;
        } else {
            bVarArr = f62506e;
            aVarArr = f62507f;
        }
        return new h(position, J, J2, J3, w11, C, bVarArr, aVarArr);
    }

    @Override // gf.a
    public byte readByte() {
        return this.f62508a.get();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x0034. Please report as an issue. */
    public i s() {
        int position = this.f62508a.position();
        int H = H();
        int H2 = H();
        int[] iArr = new int[H2];
        for (int i11 = 0; i11 < H2; i11++) {
            iArr[i11] = I();
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(64);
            try {
                C0781a c0781a = new C0781a(byteArrayOutputStream2);
                while (true) {
                    byte readByte = readByte();
                    byteArrayOutputStream2.write(readByte);
                    if (readByte != 9) {
                        switch (readByte) {
                            case 1:
                                p.e(c0781a, H());
                                break;
                            case 2:
                                p.d(c0781a, D());
                                break;
                            case 3:
                            case 4:
                                p.e(c0781a, H());
                                p.f(c0781a, I());
                                p.f(c0781a, I());
                                if (readByte == 4) {
                                    p.f(c0781a, I());
                                    break;
                                } else {
                                    break;
                                }
                            case 5:
                            case 6:
                                p.e(c0781a, H());
                                break;
                        }
                        i iVar = new i(position, H, iArr, byteArrayOutputStream2.toByteArray());
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Exception unused) {
                        }
                        return iVar;
                    }
                    p.f(c0781a, I());
                }
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = byteArrayOutputStream2;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public l t() {
        int position = this.f62508a.position();
        new n(this, 28).w();
        return new l(position, e(position));
    }

    public o u() {
        return new o(this.f62508a.position(), J(), J(), w());
    }

    public int w() {
        return this.f62508a.getInt();
    }

    @Override // gf.b
    public void writeByte(int i11) {
        c(1);
        this.f62508a.put((byte) i11);
        if (this.f62508a.position() > this.f62509b) {
            this.f62509b = this.f62508a.position();
        }
    }

    public MethodHandle x() {
        return new MethodHandle(this.f62508a.position(), MethodHandle.MethodHandleType.fromValue(J()), J(), J(), J());
    }

    public q y() {
        return new q(this.f62508a.position(), J(), J(), w());
    }
}
