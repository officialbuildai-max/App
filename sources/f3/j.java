package f3;

import androidx.media3.common.r;
import androidx.media3.common.util.j0;
import androidx.media3.common.x;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import l2.e0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class j {
    public static androidx.media3.container.b a(androidx.media3.common.x xVar, String str) {
        for (int i11 = 0; i11 < xVar.e(); i11++) {
            x.a d11 = xVar.d(i11);
            if (d11 instanceof androidx.media3.container.b) {
                androidx.media3.container.b bVar = (androidx.media3.container.b) d11;
                if (bVar.f10660a.equals(str)) {
                    return bVar;
                }
            }
        }
        return null;
    }

    private static z2.e b(int i11, j0 j0Var) {
        int q11 = j0Var.q();
        if (j0Var.q() == 1684108385) {
            j0Var.X(8);
            String C = j0Var.C(q11 - 16);
            return new z2.e(C.LANGUAGE_UNDETERMINED, C, C);
        }
        androidx.media3.common.util.u.h("MetadataUtil", "Failed to parse comment attribute: " + androidx.media3.container.d.a(i11));
        return null;
    }

    private static z2.a c(j0 j0Var) {
        int q11 = j0Var.q();
        if (j0Var.q() != 1684108385) {
            androidx.media3.common.util.u.h("MetadataUtil", "Failed to parse cover art attribute");
            return null;
        }
        int o11 = b.o(j0Var.q());
        String str = o11 == 13 ? "image/jpeg" : o11 == 14 ? "image/png" : null;
        if (str == null) {
            androidx.media3.common.util.u.h("MetadataUtil", "Unrecognized cover art flags: " + o11);
            return null;
        }
        j0Var.X(4);
        int i11 = q11 - 16;
        byte[] bArr = new byte[i11];
        j0Var.l(bArr, 0, i11);
        return new z2.a(str, null, 3, bArr);
    }

    public static x.a d(j0 j0Var) {
        int f11 = j0Var.f() + j0Var.q();
        int q11 = j0Var.q();
        int i11 = (q11 >> 24) & 255;
        try {
            if (i11 == 169 || i11 == 253) {
                int i12 = 16777215 & q11;
                if (i12 == 6516084) {
                    return b(q11, j0Var);
                }
                if (i12 == 7233901 || i12 == 7631467) {
                    return k(q11, "TIT2", j0Var);
                }
                if (i12 == 6516589 || i12 == 7828084) {
                    return k(q11, "TCOM", j0Var);
                }
                if (i12 == 6578553) {
                    return k(q11, "TDRC", j0Var);
                }
                if (i12 == 4280916) {
                    return k(q11, "TPE1", j0Var);
                }
                if (i12 == 7630703) {
                    return k(q11, "TSSE", j0Var);
                }
                if (i12 == 6384738) {
                    return k(q11, "TALB", j0Var);
                }
                if (i12 == 7108978) {
                    return k(q11, "USLT", j0Var);
                }
                if (i12 == 6776174) {
                    return k(q11, "TCON", j0Var);
                }
                if (i12 == 6779504) {
                    return k(q11, "TIT1", j0Var);
                }
            } else {
                if (q11 == 1735291493) {
                    return j(j0Var);
                }
                if (q11 == 1684632427) {
                    return e(q11, "TPOS", j0Var);
                }
                if (q11 == 1953655662) {
                    return e(q11, "TRCK", j0Var);
                }
                if (q11 == 1953329263) {
                    return g(q11, "TBPM", j0Var, true, false);
                }
                if (q11 == 1668311404) {
                    return g(q11, "TCMP", j0Var, true, true);
                }
                if (q11 == 1668249202) {
                    return c(j0Var);
                }
                if (q11 == 1631670868) {
                    return k(q11, "TPE2", j0Var);
                }
                if (q11 == 1936682605) {
                    return k(q11, "TSOT", j0Var);
                }
                if (q11 == 1936679276) {
                    return k(q11, "TSOA", j0Var);
                }
                if (q11 == 1936679282) {
                    return k(q11, "TSOP", j0Var);
                }
                if (q11 == 1936679265) {
                    return k(q11, "TSO2", j0Var);
                }
                if (q11 == 1936679791) {
                    return k(q11, "TSOC", j0Var);
                }
                if (q11 == 1920233063) {
                    return g(q11, "ITUNESADVISORY", j0Var, false, false);
                }
                if (q11 == 1885823344) {
                    return g(q11, "ITUNESGAPLESS", j0Var, false, true);
                }
                if (q11 == 1936683886) {
                    return k(q11, "TVSHOWSORT", j0Var);
                }
                if (q11 == 1953919848) {
                    return k(q11, "TVSHOW", j0Var);
                }
                if (q11 == 757935405) {
                    return h(j0Var, f11);
                }
            }
            androidx.media3.common.util.u.b("MetadataUtil", "Skipped unknown metadata entry: " + androidx.media3.container.d.a(q11));
            j0Var.W(f11);
            return null;
        } finally {
            j0Var.W(f11);
        }
    }

    private static z2.n e(int i11, String str, j0 j0Var) {
        int q11 = j0Var.q();
        if (j0Var.q() == 1684108385 && q11 >= 22) {
            j0Var.X(10);
            int P = j0Var.P();
            if (P > 0) {
                String str2 = "" + P;
                int P2 = j0Var.P();
                if (P2 > 0) {
                    str2 = str2 + "/" + P2;
                }
                return new z2.n(str, null, ImmutableList.of(str2));
            }
        }
        androidx.media3.common.util.u.h("MetadataUtil", "Failed to parse index/count attribute: " + androidx.media3.container.d.a(i11));
        return null;
    }

    private static int f(j0 j0Var) {
        int q11 = j0Var.q();
        if (j0Var.q() == 1684108385) {
            j0Var.X(8);
            int i11 = q11 - 16;
            if (i11 == 1) {
                return j0Var.H();
            }
            if (i11 == 2) {
                return j0Var.P();
            }
            if (i11 == 3) {
                return j0Var.K();
            }
            if (i11 == 4 && (j0Var.j() & 128) == 0) {
                return j0Var.L();
            }
        }
        androidx.media3.common.util.u.h("MetadataUtil", "Failed to parse data atom to int");
        return -1;
    }

    private static z2.i g(int i11, String str, j0 j0Var, boolean z10, boolean z11) {
        int f11 = f(j0Var);
        if (z11) {
            f11 = Math.min(1, f11);
        }
        if (f11 >= 0) {
            return z10 ? new z2.n(str, null, ImmutableList.of(Integer.toString(f11))) : new z2.e(C.LANGUAGE_UNDETERMINED, str, Integer.toString(f11));
        }
        androidx.media3.common.util.u.h("MetadataUtil", "Failed to parse uint8 attribute: " + androidx.media3.container.d.a(i11));
        return null;
    }

    private static z2.i h(j0 j0Var, int i11) {
        String str = null;
        String str2 = null;
        int i12 = -1;
        int i13 = -1;
        while (j0Var.f() < i11) {
            int f11 = j0Var.f();
            int q11 = j0Var.q();
            int q12 = j0Var.q();
            j0Var.X(4);
            if (q12 == 1835360622) {
                str = j0Var.C(q11 - 12);
            } else if (q12 == 1851878757) {
                str2 = j0Var.C(q11 - 12);
            } else {
                if (q12 == 1684108385) {
                    i12 = f11;
                    i13 = q11;
                }
                j0Var.X(q11 - 12);
            }
        }
        if (str == null || str2 == null || i12 == -1) {
            return null;
        }
        j0Var.W(i12);
        j0Var.X(16);
        return new z2.k(str, str2, j0Var.C(i13 - 16));
    }

    public static androidx.media3.container.b i(j0 j0Var, int i11, String str) {
        while (true) {
            int f11 = j0Var.f();
            if (f11 >= i11) {
                return null;
            }
            int q11 = j0Var.q();
            if (j0Var.q() == 1684108385) {
                int q12 = j0Var.q();
                int q13 = j0Var.q();
                int i12 = q11 - 16;
                byte[] bArr = new byte[i12];
                j0Var.l(bArr, 0, i12);
                return new androidx.media3.container.b(str, bArr, q13, q12);
            }
            j0Var.W(f11 + q11);
        }
    }

    private static z2.n j(j0 j0Var) {
        String a11 = z2.j.a(f(j0Var) - 1);
        if (a11 != null) {
            return new z2.n("TCON", null, ImmutableList.of(a11));
        }
        androidx.media3.common.util.u.h("MetadataUtil", "Failed to parse standard genre code");
        return null;
    }

    private static z2.n k(int i11, String str, j0 j0Var) {
        int q11 = j0Var.q();
        if (j0Var.q() == 1684108385) {
            j0Var.X(8);
            return new z2.n(str, null, ImmutableList.of(j0Var.C(q11 - 16)));
        }
        androidx.media3.common.util.u.h("MetadataUtil", "Failed to parse text attribute: " + androidx.media3.container.d.a(i11));
        return null;
    }

    public static void l(int i11, e0 e0Var, r.b bVar) {
        if (i11 == 1 && e0Var.a()) {
            bVar.Z(e0Var.f68688a).a0(e0Var.f68689b);
        }
    }

    public static void m(int i11, androidx.media3.common.x xVar, r.b bVar, androidx.media3.common.x xVar2, androidx.media3.common.x... xVarArr) {
        if (xVar2 == null) {
            xVar2 = new androidx.media3.common.x(new x.a[0]);
        }
        if (xVar != null) {
            for (int i12 = 0; i12 < xVar.e(); i12++) {
                x.a d11 = xVar.d(i12);
                if (d11 instanceof androidx.media3.container.b) {
                    androidx.media3.container.b bVar2 = (androidx.media3.container.b) d11;
                    if (!bVar2.f10660a.equals(MdtaMetadataEntry.KEY_ANDROID_CAPTURE_FPS)) {
                        xVar2 = xVar2.a(bVar2);
                    } else if (i11 == 2) {
                        xVar2 = xVar2.a(bVar2);
                    }
                }
            }
        }
        for (androidx.media3.common.x xVar3 : xVarArr) {
            xVar2 = xVar2.b(xVar3);
        }
        if (xVar2.e() > 0) {
            bVar.n0(xVar2);
        }
    }
}
