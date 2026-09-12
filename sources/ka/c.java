package ka;

import android.text.TextUtils;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
final class c {

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f66807c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f66808d = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");

    /* renamed from: a, reason: collision with root package name */
    private final d0 f66809a = new d0();

    /* renamed from: b, reason: collision with root package name */
    private final StringBuilder f66810b = new StringBuilder();

    private void a(d dVar, String str) {
        if ("".equals(str)) {
            return;
        }
        int indexOf = str.indexOf(91);
        if (indexOf != -1) {
            Matcher matcher = f66807c.matcher(str.substring(indexOf));
            if (matcher.matches()) {
                dVar.z((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)));
            }
            str = str.substring(0, indexOf);
        }
        String[] S0 = p0.S0(str, "\\.");
        String str2 = S0[0];
        int indexOf2 = str2.indexOf(35);
        if (indexOf2 != -1) {
            dVar.y(str2.substring(0, indexOf2));
            dVar.x(str2.substring(indexOf2 + 1));
        } else {
            dVar.y(str2);
        }
        if (S0.length > 1) {
            dVar.w((String[]) p0.H0(S0, 1, S0.length));
        }
    }

    private static boolean b(d0 d0Var) {
        int e11 = d0Var.e();
        int f11 = d0Var.f();
        byte[] d11 = d0Var.d();
        if (e11 + 2 > f11) {
            return false;
        }
        int i11 = e11 + 1;
        if (d11[e11] != 47) {
            return false;
        }
        int i12 = e11 + 2;
        if (d11[i11] != 42) {
            return false;
        }
        while (true) {
            int i13 = i12 + 1;
            if (i13 >= f11) {
                d0Var.Q(f11 - d0Var.e());
                return true;
            }
            if (((char) d11[i12]) == '*' && ((char) d11[i13]) == '/') {
                i12 += 2;
                f11 = i12;
            } else {
                i12 = i13;
            }
        }
    }

    private static boolean c(d0 d0Var) {
        char k11 = k(d0Var, d0Var.e());
        if (k11 != '\t' && k11 != '\n' && k11 != '\f' && k11 != '\r' && k11 != ' ') {
            return false;
        }
        d0Var.Q(1);
        return true;
    }

    private static void e(String str, d dVar) {
        Matcher matcher = f66808d.matcher(com.google.common.base.a.e(str));
        if (!matcher.matches()) {
            s.i("WebvttCssParser", "Invalid font-size: '" + str + "'.");
            return;
        }
        String str2 = (String) com.google.android.exoplayer2.util.a.e(matcher.group(2));
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
                dVar.t(3);
                break;
            case 1:
                dVar.t(2);
                break;
            case 2:
                dVar.t(1);
                break;
            default:
                throw new IllegalStateException();
        }
        dVar.s(Float.parseFloat((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))));
    }

    private static String f(d0 d0Var, StringBuilder sb2) {
        boolean z10 = false;
        sb2.setLength(0);
        int e11 = d0Var.e();
        int f11 = d0Var.f();
        while (e11 < f11 && !z10) {
            char c11 = (char) d0Var.d()[e11];
            if ((c11 < 'A' || c11 > 'Z') && ((c11 < 'a' || c11 > 'z') && !((c11 >= '0' && c11 <= '9') || c11 == '#' || c11 == '-' || c11 == '.' || c11 == '_'))) {
                z10 = true;
            } else {
                e11++;
                sb2.append(c11);
            }
        }
        d0Var.Q(e11 - d0Var.e());
        return sb2.toString();
    }

    static String g(d0 d0Var, StringBuilder sb2) {
        n(d0Var);
        if (d0Var.a() == 0) {
            return null;
        }
        String f11 = f(d0Var, sb2);
        if (!"".equals(f11)) {
            return f11;
        }
        return "" + ((char) d0Var.D());
    }

    private static String h(d0 d0Var, StringBuilder sb2) {
        StringBuilder sb3 = new StringBuilder();
        boolean z10 = false;
        while (!z10) {
            int e11 = d0Var.e();
            String g11 = g(d0Var, sb2);
            if (g11 == null) {
                return null;
            }
            if ("}".equals(g11) || ";".equals(g11)) {
                d0Var.P(e11);
                z10 = true;
            } else {
                sb3.append(g11);
            }
        }
        return sb3.toString();
    }

    private static String i(d0 d0Var, StringBuilder sb2) {
        n(d0Var);
        if (d0Var.a() < 5 || !"::cue".equals(d0Var.A(5))) {
            return null;
        }
        int e11 = d0Var.e();
        String g11 = g(d0Var, sb2);
        if (g11 == null) {
            return null;
        }
        if ("{".equals(g11)) {
            d0Var.P(e11);
            return "";
        }
        String l11 = "(".equals(g11) ? l(d0Var) : null;
        if (")".equals(g(d0Var, sb2))) {
            return l11;
        }
        return null;
    }

    private static void j(d0 d0Var, d dVar, StringBuilder sb2) {
        n(d0Var);
        String f11 = f(d0Var, sb2);
        if (!"".equals(f11) && ":".equals(g(d0Var, sb2))) {
            n(d0Var);
            String h11 = h(d0Var, sb2);
            if (h11 == null || "".equals(h11)) {
                return;
            }
            int e11 = d0Var.e();
            String g11 = g(d0Var, sb2);
            if (!";".equals(g11)) {
                if (!"}".equals(g11)) {
                    return;
                } else {
                    d0Var.P(e11);
                }
            }
            if (TtmlNode.ATTR_TTS_COLOR.equals(f11)) {
                dVar.q(com.google.android.exoplayer2.util.g.b(h11));
                return;
            }
            if ("background-color".equals(f11)) {
                dVar.n(com.google.android.exoplayer2.util.g.b(h11));
                return;
            }
            boolean z10 = true;
            if ("ruby-position".equals(f11)) {
                if ("over".equals(h11)) {
                    dVar.v(1);
                    return;
                } else {
                    if ("under".equals(h11)) {
                        dVar.v(2);
                        return;
                    }
                    return;
                }
            }
            if ("text-combine-upright".equals(f11)) {
                if (!IntegrationConstants.NAVIGATION_BAR_ALL_ACTION.equals(h11) && !h11.startsWith("digits")) {
                    z10 = false;
                }
                dVar.p(z10);
                return;
            }
            if ("text-decoration".equals(f11)) {
                if (TtmlNode.UNDERLINE.equals(h11)) {
                    dVar.A(true);
                    return;
                }
                return;
            }
            if ("font-family".equals(f11)) {
                dVar.r(h11);
                return;
            }
            if ("font-weight".equals(f11)) {
                if (TtmlNode.BOLD.equals(h11)) {
                    dVar.o(true);
                }
            } else if ("font-style".equals(f11)) {
                if (TtmlNode.ITALIC.equals(h11)) {
                    dVar.u(true);
                }
            } else if ("font-size".equals(f11)) {
                e(h11, dVar);
            }
        }
    }

    private static char k(d0 d0Var, int i11) {
        return (char) d0Var.d()[i11];
    }

    private static String l(d0 d0Var) {
        int e11 = d0Var.e();
        int f11 = d0Var.f();
        boolean z10 = false;
        while (e11 < f11 && !z10) {
            int i11 = e11 + 1;
            z10 = ((char) d0Var.d()[e11]) == ')';
            e11 = i11;
        }
        return d0Var.A((e11 - 1) - d0Var.e()).trim();
    }

    static void m(d0 d0Var) {
        do {
        } while (!TextUtils.isEmpty(d0Var.p()));
    }

    static void n(d0 d0Var) {
        while (true) {
            for (boolean z10 = true; d0Var.a() > 0 && z10; z10 = false) {
                if (!c(d0Var) && !b(d0Var)) {
                }
            }
            return;
        }
    }

    public List d(d0 d0Var) {
        this.f66810b.setLength(0);
        int e11 = d0Var.e();
        m(d0Var);
        this.f66809a.N(d0Var.d(), d0Var.e());
        this.f66809a.P(e11);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String i11 = i(this.f66809a, this.f66810b);
            if (i11 == null || !"{".equals(g(this.f66809a, this.f66810b))) {
                return arrayList;
            }
            d dVar = new d();
            a(dVar, i11);
            String str = null;
            boolean z10 = false;
            while (!z10) {
                int e12 = this.f66809a.e();
                String g11 = g(this.f66809a, this.f66810b);
                boolean z11 = g11 == null || "}".equals(g11);
                if (!z11) {
                    this.f66809a.P(e12);
                    j(this.f66809a, dVar, this.f66810b);
                }
                str = g11;
                z10 = z11;
            }
            if ("}".equals(str)) {
                arrayList.add(dVar);
            }
        }
    }
}
