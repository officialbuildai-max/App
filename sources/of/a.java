package of;

import com.tencent.tinker.android.dex.DexException;
import com.tencent.tinker.android.dex.MethodHandle;
import com.tencent.tinker.android.dex.f;
import com.tencent.tinker.android.dex.g;
import com.tencent.tinker.android.dex.h;
import com.tencent.tinker.android.dex.i;
import com.tencent.tinker.android.dex.l;
import com.tencent.tinker.android.dex.m;
import com.tencent.tinker.android.dex.n;
import com.tencent.tinker.android.dex.o;
import com.tencent.tinker.android.dex.p;
import com.tencent.tinker.android.dex.q;
import com.tencent.tinker.android.dex.s;
import com.tencent.tinker.android.dex.w;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;

/* loaded from: classes5.dex */
public abstract class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: of.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0889a implements gf.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ByteArrayInputStream f71096a;

        C0889a(ByteArrayInputStream byteArrayInputStream) {
            this.f71096a = byteArrayInputStream;
        }

        @Override // gf.a
        public byte readByte() {
            return (byte) (this.f71096a.read() & 255);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements gf.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ByteArrayOutputStream f71098a;

        b(ByteArrayOutputStream byteArrayOutputStream) {
            this.f71098a = byteArrayOutputStream;
        }

        @Override // gf.b
        public void writeByte(int i11) {
            this.f71098a.write(i11);
        }
    }

    /* loaded from: classes5.dex */
    class c implements gf.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ByteArrayOutputStream f71100a;

        c(ByteArrayOutputStream byteArrayOutputStream) {
            this.f71100a = byteArrayOutputStream;
        }

        @Override // gf.b
        public void writeByte(int i11) {
            this.f71100a.write(i11);
        }
    }

    /* loaded from: classes5.dex */
    class d implements gf.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ByteArrayOutputStream f71102a;

        d(ByteArrayOutputStream byteArrayOutputStream) {
            this.f71102a = byteArrayOutputStream;
        }

        @Override // gf.b
        public void writeByte(int i11) {
            this.f71102a.write(i11);
        }
    }

    /* loaded from: classes5.dex */
    private final class e {

        /* renamed from: a, reason: collision with root package name */
        private final gf.b f71104a;

        e(gf.b bVar) {
            this.f71104a = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(n nVar) {
            int d11 = nVar.d();
            p.e(this.f71104a, a.this.J(nVar.b()));
            p.e(this.f71104a, d11);
            for (int i11 = 0; i11 < d11; i11++) {
                p.e(this.f71104a, a.this.I(nVar.e()));
                c(nVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(n nVar) {
            int f11 = nVar.f();
            p.e(this.f71104a, f11);
            for (int i11 = 0; i11 < f11; i11++) {
                c(nVar);
            }
        }

        private void f(int i11, int i12) {
            this.f71104a.writeByte(i11 | (i12 << 5));
        }

        public void c(n nVar) {
            int c11 = nVar.c();
            if (c11 == 0) {
                m.f(this.f71104a, 0, nVar.h());
                return;
            }
            if (c11 == 6) {
                m.f(this.f71104a, 6, nVar.o());
                return;
            }
            if (c11 == 2) {
                m.f(this.f71104a, 2, nVar.t());
                return;
            }
            if (c11 == 3) {
                m.g(this.f71104a, 3, nVar.i());
                return;
            }
            if (c11 == 4) {
                m.f(this.f71104a, 4, nVar.n());
                return;
            }
            if (c11 == 16) {
                m.e(this.f71104a, 16, Float.floatToIntBits(nVar.m()) << 32);
                return;
            }
            if (c11 == 17) {
                m.e(this.f71104a, 17, Double.doubleToLongBits(nVar.j()));
                return;
            }
            switch (c11) {
                case 21:
                    m.g(this.f71104a, 21, a.this.G(nVar.r()));
                    return;
                case 22:
                    m.g(this.f71104a, 22, a.this.C(nVar.q()));
                    return;
                case 23:
                    m.g(this.f71104a, 23, a.this.I(nVar.u()));
                    return;
                case 24:
                    m.g(this.f71104a, 24, a.this.J(nVar.v()));
                    return;
                case 25:
                    m.g(this.f71104a, 25, a.this.z(nVar.l()));
                    return;
                case 26:
                    m.g(this.f71104a, 26, a.this.D(nVar.p()));
                    return;
                case 27:
                    m.g(this.f71104a, 27, a.this.z(nVar.k()));
                    return;
                case 28:
                    f(28, 0);
                    e(nVar);
                    return;
                case NOTIFICATION_REDIRECT_VALUE:
                    f(29, 0);
                    d(nVar);
                    return;
                case 30:
                    nVar.s();
                    f(30, 0);
                    return;
                case TEMPLATE_HTML_SIZE_VALUE:
                    f(31, nVar.g() ? 1 : 0);
                    return;
                default:
                    throw new DexException("Unexpected type: " + Integer.toHexString(nVar.c()));
            }
        }
    }

    private f.a[] A(f.a[] aVarArr) {
        f.a[] aVarArr2 = new f.a[aVarArr.length];
        for (int i11 = 0; i11 < aVarArr.length; i11++) {
            f.a aVar = aVarArr[i11];
            aVarArr2[i11] = new f.a(z(aVar.f40636a), aVar.f40637b);
        }
        return aVarArr2;
    }

    private short[] B(short[] sArr) {
        return (sArr == null || sArr.length == 0) ? sArr : new of.b(this).b(sArr);
    }

    private f.b[] E(f.b[] bVarArr) {
        f.b[] bVarArr2 = new f.b[bVarArr.length];
        for (int i11 = 0; i11 < bVarArr.length; i11++) {
            f.b bVar = bVarArr[i11];
            bVarArr2[i11] = new f.b(D(bVar.f40638a), bVar.f40639b, w(bVar.f40640c));
        }
        return bVarArr2;
    }

    private int[] F(int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr2[i11] = I(iArr[i11]);
        }
        return iArr2;
    }

    private h.a[] u(h.a[] aVarArr) {
        if (aVarArr == null || aVarArr.length == 0) {
            return aVarArr;
        }
        h.a[] aVarArr2 = new h.a[aVarArr.length];
        for (int i11 = 0; i11 < aVarArr.length; i11++) {
            h.a aVar = aVarArr[i11];
            int length = aVar.f40656a.length;
            int[] iArr = new int[length];
            for (int i12 = 0; i12 < length; i12++) {
                iArr[i12] = J(aVar.f40656a[i12]);
            }
            aVarArr2[i11] = new h.a(iArr, aVar.f40657b, aVar.f40658c, aVar.f40659d);
        }
        return aVarArr2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0070, code lost:
    
        return r2.toByteArray();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private byte[] y(byte[] r6) {
        /*
            r5 = this;
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
            r0.<init>(r6)
            of.a$a r1 = new of.a$a
            r1.<init>(r0)
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream
            int r6 = r6.length
            int r6 = r6 + 512
            r2.<init>(r6)
            of.a$b r6 = new of.a$b
            r6.<init>(r2)
        L17:
            int r3 = r0.read()
            r3 = r3 & 255(0xff, float:3.57E-43)
            r2.write(r3)
            r4 = 9
            if (r3 == r4) goto L71
            switch(r3) {
                case 0: goto L6c;
                case 1: goto L64;
                case 2: goto L5c;
                case 3: goto L30;
                case 4: goto L30;
                case 5: goto L28;
                case 6: goto L28;
                default: goto L27;
            }
        L27:
            goto L17
        L28:
            int r3 = com.tencent.tinker.android.dex.p.b(r1)
            com.tencent.tinker.android.dex.p.e(r6, r3)
            goto L17
        L30:
            int r4 = com.tencent.tinker.android.dex.p.b(r1)
            com.tencent.tinker.android.dex.p.e(r6, r4)
            int r4 = com.tencent.tinker.android.dex.p.c(r1)
            int r4 = r5.I(r4)
            com.tencent.tinker.android.dex.p.f(r6, r4)
            int r4 = com.tencent.tinker.android.dex.p.c(r1)
            int r4 = r5.J(r4)
            com.tencent.tinker.android.dex.p.f(r6, r4)
            r4 = 4
            if (r3 != r4) goto L17
            int r3 = com.tencent.tinker.android.dex.p.c(r1)
            int r3 = r5.I(r3)
            com.tencent.tinker.android.dex.p.f(r6, r3)
            goto L17
        L5c:
            int r3 = com.tencent.tinker.android.dex.p.a(r1)
            com.tencent.tinker.android.dex.p.d(r6, r3)
            goto L17
        L64:
            int r3 = com.tencent.tinker.android.dex.p.b(r1)
            com.tencent.tinker.android.dex.p.e(r6, r3)
            goto L17
        L6c:
            byte[] r6 = r2.toByteArray()
            return r6
        L71:
            int r3 = com.tencent.tinker.android.dex.p.c(r1)
            int r3 = r5.I(r3)
            com.tencent.tinker.android.dex.p.f(r6, r3)
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: of.a.y(byte[]):byte[]");
    }

    public abstract int C(int i11);

    public abstract int D(int i11);

    public abstract int G(int i11);

    public abstract int H(int i11);

    public abstract int I(int i11);

    public abstract int J(int i11);

    public abstract int K(int i11);

    public com.tencent.tinker.android.dex.a a(com.tencent.tinker.android.dex.a aVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(aVar.f40624c.f40691b.length);
        new e(new d(byteArrayOutputStream)).d(aVar.b());
        return new com.tencent.tinker.android.dex.a(aVar.f40739a, aVar.f40623b, new l(aVar.f40624c.f40739a, byteArrayOutputStream.toByteArray()));
    }

    public com.tencent.tinker.android.dex.b b(com.tencent.tinker.android.dex.b bVar) {
        int length = bVar.f40625b.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = p(bVar.f40625b[i11]);
        }
        return new com.tencent.tinker.android.dex.b(bVar.f40739a, iArr);
    }

    public com.tencent.tinker.android.dex.c c(com.tencent.tinker.android.dex.c cVar) {
        int length = cVar.f40626b.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = q(cVar.f40626b[i11]);
        }
        return new com.tencent.tinker.android.dex.c(cVar.f40739a, iArr);
    }

    public com.tencent.tinker.android.dex.d d(com.tencent.tinker.android.dex.d dVar) {
        int q11 = q(dVar.f40627b);
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, dVar.f40628c.length, 2);
        for (int i11 = 0; i11 < iArr.length; i11++) {
            iArr[i11][0] = z(dVar.f40628c[i11][0]);
            iArr[i11][1] = q(dVar.f40628c[i11][1]);
        }
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, dVar.f40629d.length, 2);
        for (int i12 = 0; i12 < iArr2.length; i12++) {
            iArr2[i12][0] = D(dVar.f40629d[i12][0]);
            iArr2[i12][1] = q(dVar.f40629d[i12][1]);
        }
        int[][] iArr3 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, dVar.f40630e.length, 2);
        for (int i13 = 0; i13 < iArr3.length; i13++) {
            iArr3[i13][0] = D(dVar.f40630e[i13][0]);
            iArr3[i13][1] = r(dVar.f40630e[i13][1]);
        }
        return new com.tencent.tinker.android.dex.d(dVar.f40739a, q11, iArr, iArr2, iArr3);
    }

    public com.tencent.tinker.android.dex.e e(com.tencent.tinker.android.dex.e eVar) {
        return new com.tencent.tinker.android.dex.e(eVar.f40739a, H(eVar.f40631b));
    }

    public f f(f fVar) {
        return new f(fVar.f40739a, A(fVar.f40632b), A(fVar.f40633c), E(fVar.f40634d), E(fVar.f40635e));
    }

    public g g(g gVar) {
        return new g(gVar.f40739a, J(gVar.f40641b), gVar.f40642c, J(gVar.f40643d), K(gVar.f40644e), I(gVar.f40645f), s(gVar.f40646g), v(gVar.f40647h), H(gVar.f40648i));
    }

    public h h(h hVar) {
        return new h(hVar.f40739a, hVar.f40649b, hVar.f40650c, hVar.f40651d, x(hVar.f40652e), B(hVar.f40653f), hVar.f40654g, u(hVar.f40655h));
    }

    public i i(i iVar) {
        return new i(iVar.f40739a, iVar.f40663b, F(iVar.f40664c), y(iVar.f40665d));
    }

    public l j(l lVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(lVar.f40691b.length);
        new e(new c(byteArrayOutputStream)).e(new n(lVar, 28));
        return new l(lVar.f40739a, byteArrayOutputStream.toByteArray());
    }

    public o k(o oVar) {
        return new o(oVar.f40739a, J(oVar.f40698b), J(oVar.f40699c), I(oVar.f40700d));
    }

    public MethodHandle l(MethodHandle methodHandle) {
        return new MethodHandle(methodHandle.f40739a, methodHandle.f40618b, methodHandle.f40619c, methodHandle.f40618b.isField() ? z(methodHandle.f40620d) : D(methodHandle.f40620d), methodHandle.f40621e);
    }

    public q m(q qVar) {
        return new q(qVar.f40739a, J(qVar.f40701b), G(qVar.f40702c), I(qVar.f40703d));
    }

    public s n(s sVar) {
        return new s(sVar.f40739a, I(sVar.f40704b), J(sVar.f40705c), K(sVar.f40706d));
    }

    public w o(w wVar) {
        if (wVar == w.f40740c) {
            return wVar;
        }
        int length = wVar.f40741b.length;
        short[] sArr = new short[length];
        for (int i11 = 0; i11 < length; i11++) {
            sArr[i11] = (short) J(wVar.f40741b[i11]);
        }
        return new w(wVar.f40739a, sArr);
    }

    public abstract int p(int i11);

    public abstract int q(int i11);

    public abstract int r(int i11);

    public abstract int s(int i11);

    public abstract int t(int i11);

    public abstract int v(int i11);

    public abstract int w(int i11);

    public abstract int x(int i11);

    public abstract int z(int i11);
}
