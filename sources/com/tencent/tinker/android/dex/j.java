package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.v;
import com.transsion.api.gateway.utils.EncoderUtil;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.AbstractList;
import java.util.RandomAccess;
import java.util.zip.Adler32;

/* loaded from: classes5.dex */
public final class j {

    /* renamed from: n, reason: collision with root package name */
    static final short[] f40666n = new short[0];

    /* renamed from: a, reason: collision with root package name */
    private final v f40667a;

    /* renamed from: b, reason: collision with root package name */
    private final i f40668b;

    /* renamed from: c, reason: collision with root package name */
    private final C0583j f40669c;

    /* renamed from: d, reason: collision with root package name */
    private final k f40670d;

    /* renamed from: e, reason: collision with root package name */
    private final g f40671e;

    /* renamed from: f, reason: collision with root package name */
    private final d f40672f;

    /* renamed from: g, reason: collision with root package name */
    private final f f40673g;

    /* renamed from: h, reason: collision with root package name */
    private final b f40674h;

    /* renamed from: i, reason: collision with root package name */
    private final e f40675i;

    /* renamed from: j, reason: collision with root package name */
    private final c f40676j;

    /* renamed from: k, reason: collision with root package name */
    private ByteBuffer f40677k;

    /* renamed from: l, reason: collision with root package name */
    private int f40678l;

    /* renamed from: m, reason: collision with root package name */
    private byte[] f40679m;

    /* loaded from: classes5.dex */
    private final class b extends AbstractList implements RandomAccess {
        private b() {
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.tencent.tinker.android.dex.e get(int i11) {
            j.d(i11, j.this.f40667a.f40715h.f40736c);
            j jVar = j.this;
            return jVar.l(jVar.f40667a.f40715h.f40737d + (i11 * 4)).m();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return j.this.f40667a.f40715h.f40736c;
        }
    }

    /* loaded from: classes5.dex */
    private final class c extends AbstractList implements RandomAccess {
        private c() {
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.tencent.tinker.android.dex.g get(int i11) {
            j.d(i11, j.this.f40667a.f40714g.f40736c);
            j jVar = j.this;
            return jVar.l(jVar.f40667a.f40714g.f40737d + (i11 * 32)).q();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return j.this.f40667a.f40714g.f40736c;
        }
    }

    /* loaded from: classes5.dex */
    private final class d extends AbstractList implements RandomAccess {
        private d() {
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public o get(int i11) {
            j.d(i11, j.this.f40667a.f40712e.f40736c);
            j jVar = j.this;
            return jVar.l(jVar.f40667a.f40712e.f40737d + (i11 * 8)).u();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return j.this.f40667a.f40712e.f40736c;
        }
    }

    /* loaded from: classes5.dex */
    private final class e extends AbstractList implements RandomAccess {
        private e() {
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MethodHandle get(int i11) {
            j.d(i11, j.this.f40667a.f40716i.f40736c);
            j jVar = j.this;
            return jVar.l(jVar.f40667a.f40716i.f40737d + (i11 * 8)).x();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return j.this.f40667a.f40716i.f40736c;
        }
    }

    /* loaded from: classes5.dex */
    private final class f extends AbstractList implements RandomAccess {
        private f() {
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public q get(int i11) {
            j.d(i11, j.this.f40667a.f40713f.f40736c);
            j jVar = j.this;
            return jVar.l(jVar.f40667a.f40713f.f40737d + (i11 * 8)).y();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return j.this.f40667a.f40713f.f40736c;
        }
    }

    /* loaded from: classes5.dex */
    private final class g extends AbstractList implements RandomAccess {
        private g() {
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public s get(int i11) {
            j.d(i11, j.this.f40667a.f40711d.f40736c);
            j jVar = j.this;
            return jVar.l(jVar.f40667a.f40711d.f40737d + (i11 * 12)).A();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return j.this.f40667a.f40711d.f40736c;
        }
    }

    /* loaded from: classes5.dex */
    public final class h extends ff.a {

        /* renamed from: g, reason: collision with root package name */
        private final String f40686g;

        private h(String str, ByteBuffer byteBuffer) {
            super(byteBuffer);
            this.f40686g = str;
        }

        private void p0(v.a aVar, boolean z10) {
            if (aVar.f40735b) {
                if (z10) {
                    b();
                } else {
                    a();
                }
            }
        }

        @Override // ff.a
        public s A() {
            p0(j.this.f40667a.f40711d, false);
            return super.A();
        }

        @Override // ff.a
        public u E() {
            p0(j.this.f40667a.f40723p, false);
            return super.E();
        }

        @Override // ff.a
        public w G() {
            p0(j.this.f40667a.f40718k, false);
            return super.G();
        }

        @Override // ff.a
        public int O(com.tencent.tinker.android.dex.a aVar) {
            p0(j.this.f40667a.f40725r, true);
            return super.O(aVar);
        }

        @Override // ff.a
        public int P(com.tencent.tinker.android.dex.b bVar) {
            p0(j.this.f40667a.f40720m, true);
            return super.P(bVar);
        }

        @Override // ff.a
        public int Q(com.tencent.tinker.android.dex.c cVar) {
            p0(j.this.f40667a.f40719l, true);
            return super.Q(cVar);
        }

        @Override // ff.a
        public int R(com.tencent.tinker.android.dex.d dVar) {
            p0(j.this.f40667a.f40727t, true);
            return super.R(dVar);
        }

        @Override // ff.a
        public int V(com.tencent.tinker.android.dex.f fVar) {
            p0(j.this.f40667a.f40721n, true);
            return super.V(fVar);
        }

        @Override // ff.a
        public int W(com.tencent.tinker.android.dex.g gVar) {
            p0(j.this.f40667a.f40714g, true);
            return super.W(gVar);
        }

        @Override // ff.a
        public int X(com.tencent.tinker.android.dex.h hVar) {
            p0(j.this.f40667a.f40722o, true);
            return super.X(hVar);
        }

        @Override // ff.a
        public int Y(com.tencent.tinker.android.dex.i iVar) {
            p0(j.this.f40667a.f40724q, true);
            return super.Y(iVar);
        }

        @Override // ff.a
        public int Z(l lVar) {
            p0(j.this.f40667a.f40726s, true);
            return super.Z(lVar);
        }

        @Override // ff.a
        public int a0(o oVar) {
            p0(j.this.f40667a.f40712e, true);
            return super.a0(oVar);
        }

        @Override // ff.a
        public int e0(q qVar) {
            p0(j.this.f40667a.f40713f, true);
            return super.e0(qVar);
        }

        @Override // ff.a
        public int g0(s sVar) {
            p0(j.this.f40667a.f40711d, true);
            return super.g0(sVar);
        }

        @Override // ff.a
        public com.tencent.tinker.android.dex.a h() {
            p0(j.this.f40667a.f40725r, false);
            return super.h();
        }

        @Override // ff.a
        public com.tencent.tinker.android.dex.b i() {
            p0(j.this.f40667a.f40720m, false);
            return super.i();
        }

        @Override // ff.a
        public com.tencent.tinker.android.dex.c j() {
            p0(j.this.f40667a.f40719l, false);
            return super.j();
        }

        @Override // ff.a
        public int j0(u uVar) {
            p0(j.this.f40667a.f40723p, true);
            return super.j0(uVar);
        }

        @Override // ff.a
        public com.tencent.tinker.android.dex.d k() {
            p0(j.this.f40667a.f40727t, false);
            return super.k();
        }

        @Override // ff.a
        public int l0(w wVar) {
            p0(j.this.f40667a.f40718k, true);
            return super.l0(wVar);
        }

        @Override // ff.a
        public com.tencent.tinker.android.dex.f p() {
            p0(j.this.f40667a.f40721n, false);
            return super.p();
        }

        @Override // ff.a
        public com.tencent.tinker.android.dex.g q() {
            p0(j.this.f40667a.f40714g, false);
            return super.q();
        }

        @Override // ff.a
        public com.tencent.tinker.android.dex.h r() {
            p0(j.this.f40667a.f40722o, false);
            return super.r();
        }

        @Override // ff.a
        public com.tencent.tinker.android.dex.i s() {
            p0(j.this.f40667a.f40724q, false);
            return super.s();
        }

        @Override // ff.a
        public l t() {
            p0(j.this.f40667a.f40726s, false);
            return super.t();
        }

        @Override // ff.a
        public o u() {
            p0(j.this.f40667a.f40712e, false);
            return super.u();
        }

        @Override // ff.a
        public q y() {
            p0(j.this.f40667a.f40713f, false);
            return super.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class i extends AbstractList implements RandomAccess {
        private i() {
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String get(int i11) {
            j.d(i11, j.this.f40667a.f40709b.f40736c);
            j jVar = j.this;
            return j.this.l(jVar.l(jVar.f40667a.f40709b.f40737d + (i11 * 4)).w()).E().f40707b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return j.this.f40667a.f40709b.f40736c;
        }
    }

    /* renamed from: com.tencent.tinker.android.dex.j$j, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private final class C0583j extends AbstractList implements RandomAccess {
        private C0583j() {
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(int i11) {
            return Integer.valueOf(j.this.g(i11));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return j.this.f40667a.f40710c.f40736c;
        }
    }

    /* loaded from: classes5.dex */
    private final class k extends AbstractList implements RandomAccess {
        private k() {
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String get(int i11) {
            return j.this.f40668b.get(j.this.g(i11));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return j.this.f40667a.f40710c.f40736c;
        }
    }

    public j(int i11) {
        v vVar = new v();
        this.f40667a = vVar;
        this.f40668b = new i();
        this.f40669c = new C0583j();
        this.f40670d = new k();
        this.f40671e = new g();
        this.f40672f = new d();
        this.f40673g = new f();
        this.f40674h = new b();
        this.f40675i = new e();
        this.f40676j = new c();
        this.f40678l = 0;
        this.f40679m = null;
        ByteBuffer wrap = ByteBuffer.wrap(new byte[i11]);
        this.f40677k = wrap;
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        vVar.f40732y = i11;
    }

    public j(InputStream inputStream) {
        this.f40667a = new v();
        this.f40668b = new i();
        this.f40669c = new C0583j();
        this.f40670d = new k();
        this.f40671e = new g();
        this.f40672f = new d();
        this.f40673g = new f();
        this.f40674h = new b();
        this.f40675i = new e();
        this.f40676j = new c();
        this.f40678l = 0;
        this.f40679m = null;
        j(inputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(int i11, int i12) {
        if (i11 < 0 || i11 >= i12) {
            throw new IndexOutOfBoundsException("index:" + i11 + ", length=" + i12);
        }
    }

    private void j(InputStream inputStream) {
        k(inputStream, 0);
    }

    private void k(InputStream inputStream, int i11) {
        ByteBuffer wrap = ByteBuffer.wrap(gf.d.b(inputStream, i11));
        this.f40677k = wrap;
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        this.f40667a.c(this);
    }

    public int e() {
        Adler32 adler32 = new Adler32();
        byte[] bArr = new byte[8192];
        ByteBuffer duplicate = this.f40677k.duplicate();
        while (duplicate.hasRemaining()) {
            int min = Math.min(8192, duplicate.remaining());
            duplicate.get(bArr, 0, min);
            adler32.update(bArr, 0, min);
        }
        return (int) adler32.getValue();
    }

    public byte[] f(boolean z10) {
        byte[] bArr = this.f40679m;
        if (bArr != null && !z10) {
            return bArr;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(EncoderUtil.ALGORITHM_SHA_1);
            byte[] bArr2 = new byte[8192];
            ByteBuffer duplicate = this.f40677k.duplicate();
            while (duplicate.hasRemaining()) {
                int min = Math.min(8192, duplicate.remaining());
                duplicate.get(bArr2, 0, min);
                messageDigest.update(bArr2, 0, min);
            }
            byte[] digest = messageDigest.digest();
            this.f40679m = digest;
            return digest;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public int g(int i11) {
        d(i11, this.f40667a.f40710c.f40736c);
        return this.f40677k.getInt(this.f40667a.f40710c.f40737d + (i11 * 4));
    }

    public v h() {
        return this.f40667a;
    }

    public short[] i(com.tencent.tinker.android.dex.g gVar) {
        int i11 = gVar.f40644e;
        if (i11 == 0) {
            return f40666n;
        }
        int i12 = this.f40677k.getInt(i11);
        if (i12 <= 0) {
            throw new AssertionError("Unexpected interfaces list size: " + i12);
        }
        int i13 = i11 + 4;
        short[] sArr = new short[i12];
        for (int i14 = 0; i14 < i12; i14++) {
            sArr[i14] = this.f40677k.getShort(i13);
            i13 += 2;
        }
        return sArr;
    }

    public h l(int i11) {
        if (i11 >= 0 && i11 < this.f40677k.capacity()) {
            ByteBuffer duplicate = this.f40677k.duplicate();
            duplicate.order(ByteOrder.LITTLE_ENDIAN);
            return new h("temp-section", duplicate);
        }
        throw new IllegalArgumentException("position=" + i11 + " length=" + this.f40677k.capacity());
    }

    public h m(v.a aVar) {
        int i11 = aVar.f40737d;
        if (i11 >= 0 && i11 < this.f40677k.capacity()) {
            ByteBuffer duplicate = this.f40677k.duplicate();
            duplicate.order(ByteOrder.LITTLE_ENDIAN);
            return new h("section", duplicate);
        }
        throw new IllegalArgumentException("position=" + i11 + " length=" + this.f40677k.capacity());
    }

    public void n() {
        l(12).M(f(true));
        l(8).c0(e());
    }

    public void o(OutputStream outputStream) {
        outputStream.write(this.f40677k.array());
        outputStream.flush();
    }
}
