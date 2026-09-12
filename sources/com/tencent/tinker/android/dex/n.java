package com.tencent.tinker.android.dex;

/* loaded from: classes5.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    protected final gf.a f40694a;

    /* renamed from: b, reason: collision with root package name */
    private int f40695b;

    /* renamed from: c, reason: collision with root package name */
    private int f40696c;

    /* renamed from: d, reason: collision with root package name */
    private int f40697d;

    public n(l lVar, int i11) {
        this(lVar.a(), i11);
    }

    public n(gf.a aVar, int i11) {
        this.f40694a = aVar;
        this.f40695b = i11;
    }

    private void a(int i11) {
        if (c() != i11) {
            throw new IllegalStateException(String.format("Expected %x but was %x", Integer.valueOf(i11), Integer.valueOf(c())));
        }
    }

    public int b() {
        return this.f40696c;
    }

    public int c() {
        if (this.f40695b == -1) {
            byte readByte = this.f40694a.readByte();
            this.f40695b = readByte & 31;
            this.f40697d = (readByte & 224) >> 5;
        }
        return this.f40695b;
    }

    public int d() {
        a(29);
        this.f40695b = -1;
        this.f40696c = p.b(this.f40694a);
        return p.b(this.f40694a);
    }

    public int e() {
        return p.b(this.f40694a);
    }

    public int f() {
        a(28);
        this.f40695b = -1;
        return p.b(this.f40694a);
    }

    public boolean g() {
        a(31);
        this.f40695b = -1;
        return this.f40697d != 0;
    }

    public byte h() {
        a(0);
        this.f40695b = -1;
        return (byte) m.a(this.f40694a, this.f40697d);
    }

    public char i() {
        a(3);
        this.f40695b = -1;
        return (char) m.c(this.f40694a, this.f40697d, false);
    }

    public double j() {
        a(17);
        this.f40695b = -1;
        return Double.longBitsToDouble(m.d(this.f40694a, this.f40697d, true));
    }

    public int k() {
        a(27);
        this.f40695b = -1;
        return m.c(this.f40694a, this.f40697d, false);
    }

    public int l() {
        a(25);
        this.f40695b = -1;
        return m.c(this.f40694a, this.f40697d, false);
    }

    public float m() {
        a(16);
        this.f40695b = -1;
        return Float.intBitsToFloat(m.c(this.f40694a, this.f40697d, true));
    }

    public int n() {
        a(4);
        this.f40695b = -1;
        return m.a(this.f40694a, this.f40697d);
    }

    public long o() {
        a(6);
        this.f40695b = -1;
        return m.b(this.f40694a, this.f40697d);
    }

    public int p() {
        a(26);
        this.f40695b = -1;
        return m.c(this.f40694a, this.f40697d, false);
    }

    public int q() {
        a(22);
        this.f40695b = -1;
        return m.c(this.f40694a, this.f40697d, false);
    }

    public int r() {
        a(21);
        this.f40695b = -1;
        return m.c(this.f40694a, this.f40697d, false);
    }

    public void s() {
        a(30);
        this.f40695b = -1;
    }

    public short t() {
        a(2);
        this.f40695b = -1;
        return (short) m.a(this.f40694a, this.f40697d);
    }

    public int u() {
        a(23);
        this.f40695b = -1;
        return m.c(this.f40694a, this.f40697d, false);
    }

    public int v() {
        a(24);
        this.f40695b = -1;
        return m.c(this.f40694a, this.f40697d, false);
    }

    public void w() {
        int c11 = c();
        if (c11 == 0) {
            h();
            return;
        }
        if (c11 == 6) {
            o();
            return;
        }
        if (c11 == 2) {
            t();
            return;
        }
        if (c11 == 3) {
            i();
            return;
        }
        if (c11 == 4) {
            n();
            return;
        }
        if (c11 == 16) {
            m();
            return;
        }
        if (c11 == 17) {
            j();
            return;
        }
        int i11 = 0;
        switch (c11) {
            case 21:
                r();
                return;
            case 22:
                q();
                return;
            case 23:
                u();
                return;
            case 24:
                v();
                return;
            case 25:
                l();
                return;
            case 26:
                p();
                return;
            case 27:
                k();
                return;
            case 28:
                int f11 = f();
                while (i11 < f11) {
                    w();
                    i11++;
                }
                return;
            case NOTIFICATION_REDIRECT_VALUE:
                int d11 = d();
                while (i11 < d11) {
                    e();
                    w();
                    i11++;
                }
                return;
            case 30:
                s();
                return;
            case TEMPLATE_HTML_SIZE_VALUE:
                g();
                return;
            default:
                throw new DexException("Unexpected type: " + Integer.toHexString(this.f40695b));
        }
    }
}
