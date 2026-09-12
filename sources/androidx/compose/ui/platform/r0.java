package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.graphics.z4;
import androidx.compose.ui.text.style.i;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;

/* loaded from: classes.dex */
public final class r0 {

    /* renamed from: a, reason: collision with root package name */
    private final Parcel f5930a;

    public r0(String str) {
        Parcel obtain = Parcel.obtain();
        this.f5930a = obtain;
        byte[] decode = Base64.decode(str, 0);
        obtain.unmarshall(decode, 0, decode.length);
        obtain.setDataPosition(0);
    }

    private final int a() {
        return this.f5930a.dataAvail();
    }

    private final float b() {
        return androidx.compose.ui.text.style.a.c(e());
    }

    private final byte c() {
        return this.f5930a.readByte();
    }

    private final float e() {
        return this.f5930a.readFloat();
    }

    private final int i() {
        return this.f5930a.readInt();
    }

    private final z4 j() {
        return new z4(d(), y.h.a(e(), e()), e(), null);
    }

    private final String l() {
        return this.f5930a.readString();
    }

    private final androidx.compose.ui.text.style.i m() {
        int i11 = i();
        i.a aVar = androidx.compose.ui.text.style.i.f6484b;
        boolean z10 = (aVar.b().e() & i11) != 0;
        boolean z11 = (i11 & aVar.d().e()) != 0;
        return (z10 && z11) ? aVar.a(CollectionsKt.o(aVar.b(), aVar.d())) : z10 ? aVar.b() : z11 ? aVar.d() : aVar.c();
    }

    private final androidx.compose.ui.text.style.m n() {
        return new androidx.compose.ui.text.style.m(e(), e());
    }

    private final long p() {
        return ULong.b(this.f5930a.readLong());
    }

    public final long d() {
        return androidx.compose.ui.graphics.u1.h(p());
    }

    public final int f() {
        byte c11 = c();
        if (c11 != 0 && c11 == 1) {
            return androidx.compose.ui.text.font.n.f6214b.a();
        }
        return androidx.compose.ui.text.font.n.f6214b.b();
    }

    public final int g() {
        byte c11 = c();
        return c11 == 0 ? androidx.compose.ui.text.font.o.f6218b.b() : c11 == 1 ? androidx.compose.ui.text.font.o.f6218b.a() : c11 == 3 ? androidx.compose.ui.text.font.o.f6218b.c() : c11 == 2 ? androidx.compose.ui.text.font.o.f6218b.d() : androidx.compose.ui.text.font.o.f6218b.b();
    }

    public final androidx.compose.ui.text.font.p h() {
        return new androidx.compose.ui.text.font.p(i());
    }

    public final androidx.compose.ui.text.x k() {
        g1 g1Var;
        g1 g1Var2 = r15;
        g1 g1Var3 = new g1(0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, 16383, null);
        while (this.f5930a.dataAvail() > 1) {
            byte c11 = c();
            if (c11 != 1) {
                g1Var = g1Var2;
                if (c11 == 2) {
                    if (a() < 5) {
                        break;
                    }
                    g1Var.e(o());
                    g1Var2 = g1Var;
                } else if (c11 == 3) {
                    if (a() < 4) {
                        break;
                    }
                    g1Var.h(h());
                    g1Var2 = g1Var;
                } else if (c11 == 4) {
                    if (a() < 1) {
                        break;
                    }
                    g1Var.f(androidx.compose.ui.text.font.n.c(f()));
                    g1Var2 = g1Var;
                } else if (c11 != 5) {
                    if (c11 != 6) {
                        if (c11 != 7) {
                            if (c11 != 8) {
                                if (c11 != 9) {
                                    if (c11 != 10) {
                                        if (c11 != 11) {
                                            if (c11 == 12) {
                                                if (a() < 20) {
                                                    break;
                                                }
                                                g1Var.j(j());
                                            }
                                        } else {
                                            if (a() < 4) {
                                                break;
                                            }
                                            g1Var.k(m());
                                        }
                                    } else {
                                        if (a() < 8) {
                                            break;
                                        }
                                        g1Var.a(d());
                                    }
                                } else {
                                    if (a() < 8) {
                                        break;
                                    }
                                    g1Var.l(n());
                                }
                            } else {
                                if (a() < 4) {
                                    break;
                                }
                                g1Var.b(androidx.compose.ui.text.style.a.b(b()));
                            }
                        } else {
                            if (a() < 5) {
                                break;
                            }
                            g1Var.i(o());
                        }
                    } else {
                        g1Var.d(l());
                    }
                    g1Var2 = g1Var;
                } else {
                    if (a() < 1) {
                        break;
                    }
                    g1Var.g(androidx.compose.ui.text.font.o.e(g()));
                    g1Var2 = g1Var;
                }
            } else {
                if (a() < 8) {
                    break;
                }
                g1Var2.c(d());
            }
        }
        g1Var = g1Var2;
        return g1Var.m();
    }

    public final long o() {
        byte c11 = c();
        long b11 = c11 == 1 ? o0.y.f70755b.b() : c11 == 2 ? o0.y.f70755b.a() : o0.y.f70755b.c();
        return o0.y.g(b11, o0.y.f70755b.c()) ? o0.w.f70751b.a() : o0.x.a(e(), b11);
    }
}
