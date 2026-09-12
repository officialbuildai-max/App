package ha;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import ba.b;
import ba.h;
import ba.i;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.t;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class a extends h {

    /* renamed from: q, reason: collision with root package name */
    private static final Pattern f64529q = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");

    /* renamed from: r, reason: collision with root package name */
    private static final Pattern f64530r = Pattern.compile("\\{\\\\.*?\\}");

    /* renamed from: o, reason: collision with root package name */
    private final StringBuilder f64531o;

    /* renamed from: p, reason: collision with root package name */
    private final ArrayList f64532p;

    public a() {
        super("SubripDecoder");
        this.f64531o = new StringBuilder();
        this.f64532p = new ArrayList();
    }

    private String A(String str, ArrayList arrayList) {
        String trim = str.trim();
        StringBuilder sb2 = new StringBuilder(trim);
        Matcher matcher = f64530r.matcher(trim);
        int i11 = 0;
        while (matcher.find()) {
            String group = matcher.group();
            arrayList.add(group);
            int start = matcher.start() - i11;
            int length = group.length();
            sb2.replace(start, start + length, "");
            i11 += length;
        }
        return sb2.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private ba.b x(Spanned spanned, String str) {
        char c11;
        char c12;
        b.C0151b o11 = new b.C0151b().o(spanned);
        if (str == null) {
            return o11.a();
        }
        switch (str.hashCode()) {
            case -685620710:
                if (str.equals("{\\an1}")) {
                    c11 = 0;
                    break;
                }
                c11 = 65535;
                break;
            case -685620679:
                if (str.equals("{\\an2}")) {
                    c11 = 6;
                    break;
                }
                c11 = 65535;
                break;
            case -685620648:
                if (str.equals("{\\an3}")) {
                    c11 = 3;
                    break;
                }
                c11 = 65535;
                break;
            case -685620617:
                if (str.equals("{\\an4}")) {
                    c11 = 1;
                    break;
                }
                c11 = 65535;
                break;
            case -685620586:
                if (str.equals("{\\an5}")) {
                    c11 = 7;
                    break;
                }
                c11 = 65535;
                break;
            case -685620555:
                if (str.equals("{\\an6}")) {
                    c11 = 4;
                    break;
                }
                c11 = 65535;
                break;
            case -685620524:
                if (str.equals("{\\an7}")) {
                    c11 = 2;
                    break;
                }
                c11 = 65535;
                break;
            case -685620493:
                if (str.equals("{\\an8}")) {
                    c11 = '\b';
                    break;
                }
                c11 = 65535;
                break;
            case -685620462:
                if (str.equals("{\\an9}")) {
                    c11 = 5;
                    break;
                }
                c11 = 65535;
                break;
            default:
                c11 = 65535;
                break;
        }
        if (c11 == 0 || c11 == 1 || c11 == 2) {
            o11.l(0);
        } else if (c11 == 3 || c11 == 4 || c11 == 5) {
            o11.l(2);
        } else {
            o11.l(1);
        }
        switch (str.hashCode()) {
            case -685620710:
                if (str.equals("{\\an1}")) {
                    c12 = 0;
                    break;
                }
                c12 = 65535;
                break;
            case -685620679:
                if (str.equals("{\\an2}")) {
                    c12 = 1;
                    break;
                }
                c12 = 65535;
                break;
            case -685620648:
                if (str.equals("{\\an3}")) {
                    c12 = 2;
                    break;
                }
                c12 = 65535;
                break;
            case -685620617:
                if (str.equals("{\\an4}")) {
                    c12 = 6;
                    break;
                }
                c12 = 65535;
                break;
            case -685620586:
                if (str.equals("{\\an5}")) {
                    c12 = 7;
                    break;
                }
                c12 = 65535;
                break;
            case -685620555:
                if (str.equals("{\\an6}")) {
                    c12 = '\b';
                    break;
                }
                c12 = 65535;
                break;
            case -685620524:
                if (str.equals("{\\an7}")) {
                    c12 = 3;
                    break;
                }
                c12 = 65535;
                break;
            case -685620493:
                if (str.equals("{\\an8}")) {
                    c12 = 4;
                    break;
                }
                c12 = 65535;
                break;
            case -685620462:
                if (str.equals("{\\an9}")) {
                    c12 = 5;
                    break;
                }
                c12 = 65535;
                break;
            default:
                c12 = 65535;
                break;
        }
        if (c12 == 0 || c12 == 1 || c12 == 2) {
            o11.i(2);
        } else if (c12 == 3 || c12 == 4 || c12 == 5) {
            o11.i(0);
        } else {
            o11.i(1);
        }
        return o11.k(y(o11.d())).h(y(o11.c()), 0).a();
    }

    static float y(int i11) {
        if (i11 == 0) {
            return 0.08f;
        }
        if (i11 == 1) {
            return 0.5f;
        }
        if (i11 == 2) {
            return 0.92f;
        }
        throw new IllegalArgumentException();
    }

    private static long z(Matcher matcher, int i11) {
        String group = matcher.group(i11 + 1);
        long parseLong = (group != null ? Long.parseLong(group) * 3600000 : 0L) + (Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(i11 + 2))) * 60000) + (Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(i11 + 3))) * 1000);
        String group2 = matcher.group(i11 + 4);
        if (group2 != null) {
            parseLong += Long.parseLong(group2);
        }
        return parseLong * 1000;
    }

    @Override // ba.h
    protected i v(byte[] bArr, int i11, boolean z10) {
        String str;
        ArrayList arrayList = new ArrayList();
        t tVar = new t();
        d0 d0Var = new d0(bArr, i11);
        while (true) {
            String p11 = d0Var.p();
            int i12 = 0;
            if (p11 == null) {
                break;
            }
            if (p11.length() != 0) {
                try {
                    Integer.parseInt(p11);
                    String p12 = d0Var.p();
                    if (p12 == null) {
                        s.i("SubripDecoder", "Unexpected end");
                        break;
                    }
                    Matcher matcher = f64529q.matcher(p12);
                    if (matcher.matches()) {
                        tVar.a(z(matcher, 1));
                        tVar.a(z(matcher, 6));
                        this.f64531o.setLength(0);
                        this.f64532p.clear();
                        for (String p13 = d0Var.p(); !TextUtils.isEmpty(p13); p13 = d0Var.p()) {
                            if (this.f64531o.length() > 0) {
                                this.f64531o.append("<br>");
                            }
                            this.f64531o.append(A(p13, this.f64532p));
                        }
                        Spanned fromHtml = Html.fromHtml(this.f64531o.toString());
                        while (true) {
                            if (i12 >= this.f64532p.size()) {
                                str = null;
                                break;
                            }
                            str = (String) this.f64532p.get(i12);
                            if (str.matches("\\{\\\\an[1-9]\\}")) {
                                break;
                            }
                            i12++;
                        }
                        arrayList.add(x(fromHtml, str));
                        arrayList.add(ba.b.f16331r);
                    } else {
                        s.i("SubripDecoder", "Skipping invalid timing: " + p12);
                    }
                } catch (NumberFormatException unused) {
                    s.i("SubripDecoder", "Skipping invalid index: " + p11);
                }
            }
        }
        return new b((ba.b[]) arrayList.toArray(new ba.b[0]), tVar.d());
    }
}
