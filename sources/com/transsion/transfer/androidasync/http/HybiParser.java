package com.transsion.transfer.androidasync.http;

import android.util.Log;
import com.transsion.transfer.androidasync.ByteBufferList;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public abstract class HybiParser {

    /* renamed from: w, reason: collision with root package name */
    private static final List f55404w = Arrays.asList(0, 1, 2, 8, 9, 10);

    /* renamed from: x, reason: collision with root package name */
    private static final List f55405x = Arrays.asList(0, 1, 2);

    /* renamed from: c, reason: collision with root package name */
    private int f55408c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f55409d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f55410e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f55411f;

    /* renamed from: g, reason: collision with root package name */
    private int f55412g;

    /* renamed from: h, reason: collision with root package name */
    private int f55413h;

    /* renamed from: i, reason: collision with root package name */
    private int f55414i;

    /* renamed from: j, reason: collision with root package name */
    private int f55415j;

    /* renamed from: v, reason: collision with root package name */
    private com.transsion.transfer.androidasync.r f55427v;

    /* renamed from: a, reason: collision with root package name */
    private boolean f55406a = true;

    /* renamed from: b, reason: collision with root package name */
    private boolean f55407b = false;

    /* renamed from: k, reason: collision with root package name */
    private byte[] f55416k = new byte[0];

    /* renamed from: l, reason: collision with root package name */
    private byte[] f55417l = new byte[0];

    /* renamed from: m, reason: collision with root package name */
    private boolean f55418m = false;

    /* renamed from: n, reason: collision with root package name */
    private ByteArrayOutputStream f55419n = new ByteArrayOutputStream();

    /* renamed from: o, reason: collision with root package name */
    private Inflater f55420o = new Inflater(true);

    /* renamed from: p, reason: collision with root package name */
    private byte[] f55421p = new byte[4096];

    /* renamed from: q, reason: collision with root package name */
    bv.d f55422q = new a();

    /* renamed from: r, reason: collision with root package name */
    bv.d f55423r = new b();

    /* renamed from: s, reason: collision with root package name */
    bv.d f55424s = new c();

    /* renamed from: t, reason: collision with root package name */
    bv.d f55425t = new d();

    /* renamed from: u, reason: collision with root package name */
    bv.d f55426u = new e();

    /* loaded from: classes6.dex */
    public static class ProtocolError extends IOException {
        public ProtocolError(String str) {
            super(str);
        }
    }

    /* loaded from: classes6.dex */
    class a implements bv.d {
        a() {
        }

        @Override // bv.d
        public void F(com.transsion.transfer.androidasync.p pVar, ByteBufferList byteBufferList) {
            try {
                HybiParser.this.F(byteBufferList.e());
            } catch (ProtocolError e11) {
                HybiParser.this.H(e11);
                e11.printStackTrace();
            }
            HybiParser.this.C();
        }
    }

    /* loaded from: classes6.dex */
    class b implements bv.d {
        b() {
        }

        @Override // bv.d
        public void F(com.transsion.transfer.androidasync.p pVar, ByteBufferList byteBufferList) {
            HybiParser.this.E(byteBufferList.e());
            HybiParser.this.C();
        }
    }

    /* loaded from: classes6.dex */
    class c implements bv.d {
        c() {
        }

        @Override // bv.d
        public void F(com.transsion.transfer.androidasync.p pVar, ByteBufferList byteBufferList) {
            byte[] bArr = new byte[HybiParser.this.f55413h];
            byteBufferList.h(bArr);
            try {
                HybiParser.this.D(bArr);
            } catch (ProtocolError e11) {
                HybiParser.this.H(e11);
                e11.printStackTrace();
            }
            HybiParser.this.C();
        }
    }

    /* loaded from: classes6.dex */
    class d implements bv.d {
        d() {
        }

        @Override // bv.d
        public void F(com.transsion.transfer.androidasync.p pVar, ByteBufferList byteBufferList) {
            HybiParser.this.f55416k = new byte[4];
            byteBufferList.h(HybiParser.this.f55416k);
            HybiParser.this.f55408c = 4;
            HybiParser.this.C();
        }
    }

    /* loaded from: classes6.dex */
    class e implements bv.d {
        e() {
        }

        @Override // bv.d
        public void F(com.transsion.transfer.androidasync.p pVar, ByteBufferList byteBufferList) {
            HybiParser hybiParser = HybiParser.this;
            hybiParser.f55417l = new byte[hybiParser.f55414i];
            byteBufferList.h(HybiParser.this.f55417l);
            try {
                HybiParser.this.n();
            } catch (IOException e11) {
                HybiParser.this.H(e11);
                e11.printStackTrace();
            }
            HybiParser.this.f55408c = 0;
            HybiParser.this.C();
        }
    }

    public HybiParser(com.transsion.transfer.androidasync.p pVar) {
        com.transsion.transfer.androidasync.r rVar = new com.transsion.transfer.androidasync.r();
        this.f55427v = rVar;
        pVar.t(rVar);
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(byte[] bArr) {
        this.f55414i = u(bArr);
        this.f55408c = this.f55410e ? 3 : 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(byte b11) {
        boolean z10 = (b11 & 128) == 128;
        this.f55410e = z10;
        int i11 = b11 & Byte.MAX_VALUE;
        this.f55414i = i11;
        if (i11 >= 0 && i11 <= 125) {
            this.f55408c = z10 ? 3 : 4;
        } else {
            this.f55413h = i11 == 126 ? 2 : 8;
            this.f55408c = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(byte b11) {
        boolean z10 = (b11 & 64) == 64;
        boolean z11 = (b11 & 32) == 32;
        boolean z12 = (b11 & 16) == 16;
        if ((!this.f55407b && z10) || z11 || z12) {
            throw new ProtocolError("RSV not zero");
        }
        this.f55409d = (b11 & 128) == 128;
        int i11 = b11 & 15;
        this.f55412g = i11;
        this.f55411f = z10;
        this.f55416k = new byte[0];
        this.f55417l = new byte[0];
        if (!f55404w.contains(Integer.valueOf(i11))) {
            throw new ProtocolError("Bad opcode");
        }
        if (!f55405x.contains(Integer.valueOf(this.f55412g)) && !this.f55409d) {
            throw new ProtocolError("Expected non-final packet");
        }
        this.f55408c = 1;
    }

    private void I() {
        this.f55415j = 0;
        this.f55419n.reset();
    }

    private byte[] M(byte[] bArr, int i11) {
        byte[] bArr2 = new byte[bArr.length - i11];
        System.arraycopy(bArr, i11, bArr2, 0, bArr.length - i11);
        return bArr2;
    }

    private static long l(byte[] bArr, int i11, int i12) {
        if (bArr.length < i12) {
            throw new IllegalArgumentException("length must be less than or equal to b.length");
        }
        long j11 = 0;
        for (int i13 = 0; i13 < i12; i13++) {
            j11 += (bArr[i13 + i11] & 255) << (((i12 - 1) - i13) * 8);
        }
        return j11;
    }

    private byte[] m(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e11) {
            throw new RuntimeException(e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        byte[] w11 = w(this.f55417l, this.f55416k, 0);
        if (this.f55411f) {
            try {
                w11 = v(w11);
            } catch (DataFormatException unused) {
                throw new IOException("Invalid deflated data");
            }
        }
        int i11 = this.f55412g;
        if (i11 == 0) {
            if (this.f55415j == 0) {
                throw new ProtocolError("Mode was not set.");
            }
            this.f55419n.write(w11);
            if (this.f55409d) {
                byte[] byteArray = this.f55419n.toByteArray();
                if (this.f55415j == 1) {
                    y(o(byteArray));
                } else {
                    z(byteArray);
                }
                I();
                return;
            }
            return;
        }
        if (i11 == 1) {
            if (this.f55409d) {
                y(o(w11));
                return;
            } else {
                this.f55415j = 1;
                this.f55419n.write(w11);
                return;
            }
        }
        if (i11 == 2) {
            if (this.f55409d) {
                z(w11);
                return;
            } else {
                this.f55415j = 2;
                this.f55419n.write(w11);
                return;
            }
        }
        if (i11 == 8) {
            x(w11.length >= 2 ? (w11[1] & 255) + ((w11[0] & 255) * 256) : 0, w11.length > 2 ? o(M(w11, 2)) : null);
            return;
        }
        if (i11 != 9) {
            if (i11 == 10) {
                B(o(w11));
            }
        } else {
            if (w11.length > 125) {
                throw new ProtocolError("Ping payload too large");
            }
            String o11 = o(w11);
            J(q(10, w11, -1));
            A(o11);
        }
    }

    private String o(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e11) {
            throw new RuntimeException(e11);
        }
    }

    private byte[] p(int i11, String str, int i12) {
        return q(i11, m(str), i12);
    }

    private byte[] q(int i11, byte[] bArr, int i12) {
        return r(i11, bArr, i12, 0, bArr.length);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private byte[] r(int r21, byte[] r22, int r23, int r24, int r25) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.transfer.androidasync.http.HybiParser.r(int, byte[], int, int, int):byte[]");
    }

    private int u(byte[] bArr) {
        long l11 = l(bArr, 0, bArr.length);
        if (l11 >= 0 && l11 <= 2147483647L) {
            return (int) l11;
        }
        throw new ProtocolError("Bad integer: " + l11);
    }

    private byte[] v(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f55420o.setInput(bArr);
        while (!this.f55420o.needsInput()) {
            byteArrayOutputStream.write(this.f55421p, 0, this.f55420o.inflate(this.f55421p));
        }
        this.f55420o.setInput(new byte[]{0, 0, -1, -1});
        while (!this.f55420o.needsInput()) {
            byteArrayOutputStream.write(this.f55421p, 0, this.f55420o.inflate(this.f55421p));
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static byte[] w(byte[] bArr, byte[] bArr2, int i11) {
        if (bArr2.length == 0) {
            return bArr;
        }
        for (int i12 = 0; i12 < bArr.length - i11; i12++) {
            int i13 = i11 + i12;
            bArr[i13] = (byte) (bArr[i13] ^ bArr2[i12 % 4]);
        }
        return bArr;
    }

    protected abstract void A(String str);

    protected abstract void B(String str);

    void C() {
        int i11 = this.f55408c;
        if (i11 == 0) {
            this.f55427v.b(1, this.f55422q);
            return;
        }
        if (i11 == 1) {
            this.f55427v.b(1, this.f55423r);
            return;
        }
        if (i11 == 2) {
            this.f55427v.b(this.f55413h, this.f55424s);
        } else if (i11 == 3) {
            this.f55427v.b(4, this.f55425t);
        } else {
            if (i11 != 4) {
                return;
            }
            this.f55427v.b(this.f55414i, this.f55426u);
        }
    }

    public byte[] G(String str) {
        return p(9, str, -1);
    }

    protected abstract void H(Exception exc);

    protected abstract void J(byte[] bArr);

    public void K(boolean z10) {
        this.f55407b = z10;
    }

    public void L(boolean z10) {
        this.f55406a = z10;
    }

    protected void finalize() {
        Inflater inflater = this.f55420o;
        if (inflater != null) {
            try {
                inflater.end();
            } catch (Exception e11) {
                Log.e("HybiParser", "inflater.end failed", e11);
            }
        }
        super.finalize();
    }

    public byte[] s(String str) {
        return p(1, str, -1);
    }

    public byte[] t(byte[] bArr) {
        return q(2, bArr, -1);
    }

    protected abstract void x(int i11, String str);

    protected abstract void y(String str);

    protected abstract void z(byte[] bArr);
}
