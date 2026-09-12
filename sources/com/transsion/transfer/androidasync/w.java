package com.transsion.transfer.androidasync;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

/* loaded from: classes6.dex */
public class w implements bv.d {

    /* renamed from: n, reason: collision with root package name */
    static Hashtable f55695n = new Hashtable();

    /* renamed from: i, reason: collision with root package name */
    p f55704i;

    /* renamed from: a, reason: collision with root package name */
    private l f55696a = new a(0);

    /* renamed from: b, reason: collision with root package name */
    private l f55697b = new b(1);

    /* renamed from: c, reason: collision with root package name */
    private l f55698c = new c(2);

    /* renamed from: d, reason: collision with root package name */
    private l f55699d = new d(4);

    /* renamed from: e, reason: collision with root package name */
    private l f55700e = new e(8);

    /* renamed from: f, reason: collision with root package name */
    private j f55701f = new f();

    /* renamed from: g, reason: collision with root package name */
    private j f55702g = new g();

    /* renamed from: h, reason: collision with root package name */
    private j f55703h = new h();

    /* renamed from: j, reason: collision with root package name */
    private LinkedList f55705j = new LinkedList();

    /* renamed from: k, reason: collision with root package name */
    private ArrayList f55706k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    ByteOrder f55707l = ByteOrder.BIG_ENDIAN;

    /* renamed from: m, reason: collision with root package name */
    ByteBufferList f55708m = new ByteBufferList();

    /* loaded from: classes6.dex */
    class a extends l {
        a(int i11) {
            super(i11);
        }

        @Override // com.transsion.transfer.androidasync.w.l
        public l a(p pVar, ByteBufferList byteBufferList) {
            w.this.f55706k.add(null);
            return null;
        }
    }

    /* loaded from: classes6.dex */
    class b extends l {
        b(int i11) {
            super(i11);
        }

        @Override // com.transsion.transfer.androidasync.w.l
        public l a(p pVar, ByteBufferList byteBufferList) {
            w.this.f55706k.add(Byte.valueOf(byteBufferList.e()));
            return null;
        }
    }

    /* loaded from: classes6.dex */
    class c extends l {
        c(int i11) {
            super(i11);
        }

        @Override // com.transsion.transfer.androidasync.w.l
        public l a(p pVar, ByteBufferList byteBufferList) {
            w.this.f55706k.add(Short.valueOf(byteBufferList.q()));
            return null;
        }
    }

    /* loaded from: classes6.dex */
    class d extends l {
        d(int i11) {
            super(i11);
        }

        @Override // com.transsion.transfer.androidasync.w.l
        public l a(p pVar, ByteBufferList byteBufferList) {
            w.this.f55706k.add(Integer.valueOf(byteBufferList.n()));
            return null;
        }
    }

    /* loaded from: classes6.dex */
    class e extends l {
        e(int i11) {
            super(i11);
        }

        @Override // com.transsion.transfer.androidasync.w.l
        public l a(p pVar, ByteBufferList byteBufferList) {
            w.this.f55706k.add(Long.valueOf(byteBufferList.o()));
            return null;
        }
    }

    /* loaded from: classes6.dex */
    class f implements j {
        f() {
        }

        @Override // com.transsion.transfer.androidasync.w.j
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(byte[] bArr) {
            w.this.f55706k.add(bArr);
        }
    }

    /* loaded from: classes6.dex */
    class g implements j {
        g() {
        }

        @Override // com.transsion.transfer.androidasync.w.j
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ByteBufferList byteBufferList) {
            w.this.f55706k.add(byteBufferList);
        }
    }

    /* loaded from: classes6.dex */
    class h implements j {
        h() {
        }

        @Override // com.transsion.transfer.androidasync.w.j
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(byte[] bArr) {
            w.this.f55706k.add(new String(bArr));
        }
    }

    /* loaded from: classes6.dex */
    static class i extends l {

        /* renamed from: b, reason: collision with root package name */
        j f55717b;

        public i(int i11, j jVar) {
            super(i11);
            if (i11 <= 0) {
                throw new IllegalArgumentException("length should be > 0");
            }
            this.f55717b = jVar;
        }

        @Override // com.transsion.transfer.androidasync.w.l
        public l a(p pVar, ByteBufferList byteBufferList) {
            byte[] bArr = new byte[this.f55720a];
            byteBufferList.h(bArr);
            this.f55717b.a(bArr);
            return null;
        }
    }

    /* loaded from: classes6.dex */
    public interface j {
        void a(Object obj);
    }

    /* loaded from: classes6.dex */
    static class k extends l {

        /* renamed from: b, reason: collision with root package name */
        byte f55718b;

        /* renamed from: c, reason: collision with root package name */
        bv.d f55719c;

        public k(byte b11, bv.d dVar) {
            super(1);
            this.f55718b = b11;
            this.f55719c = dVar;
        }

        @Override // com.transsion.transfer.androidasync.w.l
        public l a(p pVar, ByteBufferList byteBufferList) {
            ByteBufferList byteBufferList2 = new ByteBufferList();
            boolean z10 = true;
            while (true) {
                if (byteBufferList.E() <= 0) {
                    break;
                }
                ByteBuffer D = byteBufferList.D();
                D.mark();
                int i11 = 0;
                while (D.remaining() > 0) {
                    z10 = D.get() == this.f55718b;
                    if (z10) {
                        break;
                    }
                    i11++;
                }
                D.reset();
                if (z10) {
                    byteBufferList.c(D);
                    byteBufferList.g(byteBufferList2, i11);
                    byteBufferList.e();
                    break;
                }
                byteBufferList2.a(D);
            }
            this.f55719c.F(pVar, byteBufferList2);
            if (z10) {
                return null;
            }
            return this;
        }
    }

    /* loaded from: classes6.dex */
    static abstract class l {

        /* renamed from: a, reason: collision with root package name */
        int f55720a;

        public l(int i11) {
            this.f55720a = i11;
        }

        public abstract l a(p pVar, ByteBufferList byteBufferList);
    }

    public w(p pVar) {
        this.f55704i = pVar;
        pVar.t(this);
    }

    @Override // bv.d
    public void F(p pVar, ByteBufferList byteBufferList) {
        byteBufferList.f(this.f55708m);
        while (this.f55705j.size() > 0 && this.f55708m.C() >= ((l) this.f55705j.peek()).f55720a) {
            this.f55708m.u(this.f55707l);
            l a11 = ((l) this.f55705j.poll()).a(pVar, this.f55708m);
            if (a11 != null) {
                this.f55705j.addFirst(a11);
            }
        }
        if (this.f55705j.size() == 0) {
            this.f55708m.f(byteBufferList);
        }
    }

    public w b(int i11, j jVar) {
        this.f55705j.add(new i(i11, jVar));
        return this;
    }

    public w c(byte b11, bv.d dVar) {
        this.f55705j.add(new k(b11, dVar));
        return this;
    }
}
