package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.graphics.u1;
import androidx.compose.ui.graphics.z4;
import androidx.compose.ui.text.font.n;
import androidx.compose.ui.text.font.o;
import o0.w;
import o0.y;

/* loaded from: classes.dex */
public final class w0 {

    /* renamed from: a, reason: collision with root package name */
    private Parcel f5944a = Parcel.obtain();

    public final void a(byte b11) {
        this.f5944a.writeByte(b11);
    }

    public final void b(float f11) {
        this.f5944a.writeFloat(f11);
    }

    public final void c(int i11) {
        this.f5944a.writeInt(i11);
    }

    public final void d(z4 z4Var) {
        m(z4Var.c());
        b(y.g.m(z4Var.d()));
        b(y.g.n(z4Var.d()));
        b(z4Var.b());
    }

    public final void e(androidx.compose.ui.text.x xVar) {
        long g11 = xVar.g();
        u1.a aVar = androidx.compose.ui.graphics.u1.f4733b;
        if (!androidx.compose.ui.graphics.u1.m(g11, aVar.e())) {
            a((byte) 1);
            m(xVar.g());
        }
        long k11 = xVar.k();
        w.a aVar2 = o0.w.f70751b;
        if (!o0.w.e(k11, aVar2.a())) {
            a((byte) 2);
            j(xVar.k());
        }
        androidx.compose.ui.text.font.p n11 = xVar.n();
        if (n11 != null) {
            a((byte) 3);
            f(n11);
        }
        androidx.compose.ui.text.font.n l11 = xVar.l();
        if (l11 != null) {
            int i11 = l11.i();
            a((byte) 4);
            o(i11);
        }
        androidx.compose.ui.text.font.o m11 = xVar.m();
        if (m11 != null) {
            int k12 = m11.k();
            a((byte) 5);
            l(k12);
        }
        String j11 = xVar.j();
        if (j11 != null) {
            a((byte) 6);
            i(j11);
        }
        if (!o0.w.e(xVar.o(), aVar2.a())) {
            a((byte) 7);
            j(xVar.o());
        }
        androidx.compose.ui.text.style.a e11 = xVar.e();
        if (e11 != null) {
            float h11 = e11.h();
            a((byte) 8);
            k(h11);
        }
        androidx.compose.ui.text.style.m u11 = xVar.u();
        if (u11 != null) {
            a((byte) 9);
            h(u11);
        }
        if (!androidx.compose.ui.graphics.u1.m(xVar.d(), aVar.e())) {
            a((byte) 10);
            m(xVar.d());
        }
        androidx.compose.ui.text.style.i s11 = xVar.s();
        if (s11 != null) {
            a((byte) 11);
            g(s11);
        }
        z4 r11 = xVar.r();
        if (r11 != null) {
            a((byte) 12);
            d(r11);
        }
    }

    public final void f(androidx.compose.ui.text.font.p pVar) {
        c(pVar.h());
    }

    public final void g(androidx.compose.ui.text.style.i iVar) {
        c(iVar.e());
    }

    public final void h(androidx.compose.ui.text.style.m mVar) {
        b(mVar.b());
        b(mVar.c());
    }

    public final void i(String str) {
        this.f5944a.writeString(str);
    }

    public final void j(long j11) {
        long g11 = o0.w.g(j11);
        y.a aVar = o0.y.f70755b;
        byte b11 = 0;
        if (!o0.y.g(g11, aVar.c())) {
            if (o0.y.g(g11, aVar.b())) {
                b11 = 1;
            } else if (o0.y.g(g11, aVar.a())) {
                b11 = 2;
            }
        }
        a(b11);
        if (o0.y.g(o0.w.g(j11), aVar.c())) {
            return;
        }
        b(o0.w.h(j11));
    }

    public final void k(float f11) {
        b(f11);
    }

    public final void l(int i11) {
        o.a aVar = androidx.compose.ui.text.font.o.f6218b;
        byte b11 = 0;
        if (!androidx.compose.ui.text.font.o.h(i11, aVar.b())) {
            if (androidx.compose.ui.text.font.o.h(i11, aVar.a())) {
                b11 = 1;
            } else if (androidx.compose.ui.text.font.o.h(i11, aVar.d())) {
                b11 = 2;
            } else if (androidx.compose.ui.text.font.o.h(i11, aVar.c())) {
                b11 = 3;
            }
        }
        a(b11);
    }

    public final void m(long j11) {
        n(j11);
    }

    public final void n(long j11) {
        this.f5944a.writeLong(j11);
    }

    public final void o(int i11) {
        n.a aVar = androidx.compose.ui.text.font.n.f6214b;
        byte b11 = 0;
        if (!androidx.compose.ui.text.font.n.f(i11, aVar.b()) && androidx.compose.ui.text.font.n.f(i11, aVar.a())) {
            b11 = 1;
        }
        a(b11);
    }

    public final String p() {
        return Base64.encodeToString(this.f5944a.marshall(), 0);
    }

    public final void q() {
        this.f5944a.recycle();
        this.f5944a = Parcel.obtain();
    }
}
