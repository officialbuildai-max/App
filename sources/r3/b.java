package r3;

import android.text.TextUtils;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.j0;
import androidx.media3.common.util.k;
import androidx.media3.common.util.u;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
final class b {

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f74159c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f74160d = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");

    /* renamed from: a, reason: collision with root package name */
    private final j0 f74161a = new j0();

    /* renamed from: b, reason: collision with root package name */
    private final StringBuilder f74162b = new StringBuilder();

    private void a(c cVar, String str) {
        if ("".equals(str)) {
            return;
        }
        int indexOf = str.indexOf(91);
        if (indexOf != -1) {
            Matcher matcher = f74159c.matcher(str.substring(indexOf));
            if (matcher.matches()) {
                cVar.z((String) androidx.media3.common.util.a.e(matcher.group(1)));
            }
            str = str.substring(0, indexOf);
        }
        String[] o12 = a1.o1(str, "\\.");
        String str2 = o12[0];
        int indexOf2 = str2.indexOf(35);
        if (indexOf2 != -1) {
            cVar.y(str2.substring(0, indexOf2));
            cVar.x(str2.substring(indexOf2 + 1));
        } else {
            cVar.y(str2);
        }
        if (o12.length > 1) {
            cVar.w((String[]) a1.Y0(o12, 1, o12.length));
        }
    }

    private static boolean b(j0 j0Var) {
        int f11 = j0Var.f();
        int g11 = j0Var.g();
        byte[] e11 = j0Var.e();
        if (f11 + 2 > g11) {
            return false;
        }
        int i11 = f11 + 1;
        if (e11[f11] != 47) {
            return false;
        }
        int i12 = f11 + 2;
        if (e11[i11] != 42) {
            return false;
        }
        while (true) {
            int i13 = i12 + 1;
            if (i13 >= g11) {
                j0Var.X(g11 - j0Var.f());
                return true;
            }
            if (((char) e11[i12]) == '*' && ((char) e11[i13]) == '/') {
                i12 += 2;
                g11 = i12;
            } else {
                i12 = i13;
            }
        }
    }

    private static boolean c(j0 j0Var) {
        char k11 = k(j0Var, j0Var.f());
        if (k11 != '\t' && k11 != '\n' && k11 != '\f' && k11 != '\r' && k11 != ' ') {
            return false;
        }
        j0Var.X(1);
        return true;
    }

    private static void e(String str, c cVar) {
        Matcher matcher = f74160d.matcher(com.google.common.base.a.e(str));
        if (!matcher.matches()) {
            u.h("WebvttCssParser", "Invalid font-size: '" + str + "'.");
            return;
        }
        String str2 = (String) androidx.media3.common.util.a.e(matcher.group(2));
        str2.hashCode();
        char c11 = 65535;
        switch (str2.hashCode()) {
            case 37:
                if (str2.equals("%")) {
                    c11 = 0;
                    break;
                }
                break;
            case 3240:
                if (str2.equals("em")) {
                    c11 = 1;
                    break;
                }
                break;
            case 3592:
                if (str2.equals("px")) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                cVar.t(3);
                break;
            case 1:
                cVar.t(2);
                break;
            case 2:
                cVar.t(1);
                break;
            default:
                throw new IllegalStateException();
        }
        cVar.s(Float.parseFloat((String) androidx.media3.common.util.a.e(matcher.group(1))));
    }

    private static String f(j0 j0Var, StringBuilder sb2) {
        boolean z10 = false;
        sb2.setLength(0);
        int f11 = j0Var.f();
        int g11 = j0Var.g();
        while (f11 < g11 && !z10) {
            char c11 = (char) j0Var.e()[f11];
            if ((c11 < 'A' || c11 > 'Z') && ((c11 < 'a' || c11 > 'z') && !((c11 >= '0' && c11 <= '9') || c11 == '#' || c11 == '-' || c11 == '.' || c11 == '_'))) {
                z10 = true;
            } else {
                f11++;
                sb2.append(c11);
            }
        }
        j0Var.X(f11 - j0Var.f());
        return sb2.toString();
    }

    static String g(j0 j0Var, StringBuilder sb2) {
        n(j0Var);
        if (j0Var.a() == 0) {
            return null;
        }
        String f11 = f(j0Var, sb2);
        if (!"".equals(f11)) {
            return f11;
        }
        return "" + ((char) j0Var.H());
    }

    private static String h(j0 j0Var, StringBuilder sb2) {
        StringBuilder sb3 = new StringBuilder();
        boolean z10 = false;
        while (!z10) {
            int f11 = j0Var.f();
            String g11 = g(j0Var, sb2);
            if (g11 == null) {
                return null;
            }
            if ("}".equals(g11) || ";".equals(g11)) {
                j0Var.W(f11);
                z10 = true;
            } else {
                sb3.append(g11);
            }
        }
        return sb3.toString();
    }

    private static String i(j0 j0Var, StringBuilder sb2) {
        n(j0Var);
        if (j0Var.a() < 5 || !"::cue".equals(j0Var.E(5))) {
            return null;
        }
        int f11 = j0Var.f();
        String g11 = g(j0Var, sb2);
        if (g11 == null) {
            return null;
        }
        if ("{".equals(g11)) {
            j0Var.W(f11);
            return "";
        }
        String l11 = "(".equals(g11) ? l(j0Var) : null;
        if (")".equals(g(j0Var, sb2))) {
            return l11;
        }
        return null;
    }

    private static void j(j0 j0Var, c cVar, StringBuilder sb2) {
        n(j0Var);
        String f11 = f(j0Var, sb2);
        if (!"".equals(f11) && ":".equals(g(j0Var, sb2))) {
            n(j0Var);
            String h11 = h(j0Var, sb2);
            if (h11 == null || "".equals(h11)) {
                return;
            }
            int f12 = j0Var.f();
            String g11 = g(j0Var, sb2);
            if (!";".equals(g11)) {
                if (!"}".equals(g11)) {
                    return;
                } else {
                    j0Var.W(f12);
                }
            }
            if (TtmlNode.ATTR_TTS_COLOR.equals(f11)) {
                cVar.q(k.b(h11));
                return;
            }
            if ("background-color".equals(f11)) {
                cVar.n(k.b(h11));
                return;
            }
            boolean z10 = true;
            if ("ruby-position".equals(f11)) {
                if ("over".equals(h11)) {
                    cVar.v(1);
                    return;
                } else {
                    if ("under".equals(h11)) {
                        cVar.v(2);
                        return;
                    }
                    return;
                }
            }
            if ("text-combine-upright".equals(f11)) {
                if (!IntegrationConstants.NAVIGATION_BAR_ALL_ACTION.equals(h11) && !h11.startsWith("digits")) {
                    z10 = false;
                }
                cVar.p(z10);
                return;
            }
            if ("text-decoration".equals(f11)) {
                if (TtmlNode.UNDERLINE.equals(h11)) {
                    cVar.A(true);
                    return;
                }
                return;
            }
            if ("font-family".equals(f11)) {
                cVar.r(h11);
                return;
            }
            if ("font-weight".equals(f11)) {
                if (TtmlNode.BOLD.equals(h11)) {
                    cVar.o(true);
                }
            } else if ("font-style".equals(f11)) {
                if (TtmlNode.ITALIC.equals(h11)) {
                    cVar.u(true);
                }
            } else if ("font-size".equals(f11)) {
                e(h11, cVar);
            }
        }
    }

    private static char k(j0 j0Var, int i11) {
        return (char) j0Var.e()[i11];
    }

    private static String l(j0 j0Var) {
        int f11 = j0Var.f();
        int g11 = j0Var.g();
        boolean z10 = false;
        while (f11 < g11 && !z10) {
            int i11 = f11 + 1;
            z10 = ((char) j0Var.e()[f11]) == ')';
            f11 = i11;
        }
        return j0Var.E((f11 - 1) - j0Var.f()).trim();
    }

    static void m(j0 j0Var) {
        do {
        } while (!TextUtils.isEmpty(j0Var.s()));
    }

    static void n(j0 j0Var) {
        while (true) {
            for (boolean z10 = true; j0Var.a() > 0 && z10; z10 = false) {
                if (!c(j0Var) && !b(j0Var)) {
                }
            }
            return;
        }
    }

    public List d(j0 j0Var) {
        this.f74162b.setLength(0);
        int f11 = j0Var.f();
        m(j0Var);
        this.f74161a.U(j0Var.e(), j0Var.f());
        this.f74161a.W(f11);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String i11 = i(this.f74161a, this.f74162b);
            if (i11 == null || !"{".equals(g(this.f74161a, this.f74162b))) {
                return arrayList;
            }
            c cVar = new c();
            a(cVar, i11);
            String str = null;
            boolean z10 = false;
            while (!z10) {
                int f12 = this.f74161a.f();
                String g11 = g(this.f74161a, this.f74162b);
                boolean z11 = g11 == null || "}".equals(g11);
                if (!z11) {
                    this.f74161a.W(f12);
                    j(this.f74161a, cVar, this.f74162b);
                }
                str = g11;
                z10 = z11;
            }
            if ("}".equals(str)) {
                arrayList.add(cVar);
            }
        }
    }
}
