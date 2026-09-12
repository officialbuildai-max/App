package n3;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.media3.common.util.j0;
import androidx.media3.common.util.m;
import androidx.media3.common.util.u;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import i3.e;
import i3.k;
import i3.r;
import i3.s;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import u1.a;

/* loaded from: classes2.dex */
public final class a implements s {

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f70294d = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d{3}))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d{3}))?)\\s*");

    /* renamed from: e, reason: collision with root package name */
    private static final Pattern f70295e = Pattern.compile("\\{\\\\.*?\\}");

    /* renamed from: a, reason: collision with root package name */
    private final StringBuilder f70296a = new StringBuilder();

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList f70297b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final j0 f70298c = new j0();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private u1.a d(Spanned spanned, String str) {
        char c11;
        char c12;
        a.b o11 = new a.b().o(spanned);
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
        return o11.k(f(o11.d())).h(f(o11.c()), 0).a();
    }

    private Charset e(j0 j0Var) {
        Charset R = j0Var.R();
        return R != null ? R : StandardCharsets.UTF_8;
    }

    public static float f(int i11) {
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

    private static long g(Matcher matcher, int i11) {
        String group = matcher.group(i11 + 1);
        long parseLong = (group != null ? Long.parseLong(group) * 3600000 : 0L) + (Long.parseLong((String) androidx.media3.common.util.a.e(matcher.group(i11 + 2))) * 60000) + (Long.parseLong((String) androidx.media3.common.util.a.e(matcher.group(i11 + 3))) * 1000);
        String group2 = matcher.group(i11 + 4);
        if (group2 != null) {
            parseLong += Long.parseLong(group2);
        }
        return parseLong * 1000;
    }

    private String h(String str, ArrayList arrayList) {
        String trim = str.trim();
        StringBuilder sb2 = new StringBuilder(trim);
        Matcher matcher = f70295e.matcher(trim);
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

    @Override // i3.s
    public void a(byte[] bArr, int i11, int i12, s.b bVar, m mVar) {
        String str;
        m mVar2;
        String t11;
        String str2;
        String str3;
        m mVar3;
        m mVar4 = mVar;
        String str4 = "SubripParser";
        this.f70298c.U(bArr, i11 + i12);
        this.f70298c.W(i11);
        Charset e11 = e(this.f70298c);
        ArrayList arrayList = (bVar.f65048a == C.TIME_UNSET || !bVar.f65049b) ? null : new ArrayList();
        while (true) {
            String t12 = this.f70298c.t(e11);
            if (t12 == null) {
                break;
            }
            if (t12.length() != 0) {
                try {
                    Integer.parseInt(t12);
                    t11 = this.f70298c.t(e11);
                } catch (NumberFormatException unused) {
                    str = str4;
                    mVar2 = mVar4;
                    u.h(str, "Skipping invalid index: " + t12);
                }
                if (t11 == null) {
                    u.h(str4, "Unexpected end");
                    break;
                }
                Matcher matcher = f70294d.matcher(t11);
                if (matcher.matches()) {
                    long g11 = g(matcher, 1);
                    long g12 = g(matcher, 6);
                    int i13 = 0;
                    this.f70296a.setLength(0);
                    this.f70297b.clear();
                    String t13 = this.f70298c.t(e11);
                    while (!TextUtils.isEmpty(t13)) {
                        if (this.f70296a.length() > 0) {
                            this.f70296a.append("<br>");
                        }
                        this.f70296a.append(h(t13, this.f70297b));
                        t13 = this.f70298c.t(e11);
                    }
                    Spanned fromHtml = Html.fromHtml(this.f70296a.toString());
                    while (true) {
                        if (i13 >= this.f70297b.size()) {
                            str2 = str4;
                            str3 = null;
                            break;
                        } else {
                            str3 = (String) this.f70297b.get(i13);
                            if (str3.matches("\\{\\\\an[1-9]\\}")) {
                                str2 = str4;
                                break;
                            }
                            i13++;
                        }
                    }
                    long j11 = bVar.f65048a;
                    if (j11 == C.TIME_UNSET || g11 >= j11) {
                        mVar3 = mVar;
                        mVar3.accept(new e(ImmutableList.of(d(fromHtml, str3)), g11, g12 - g11));
                    } else {
                        if (arrayList != null) {
                            arrayList.add(new e(ImmutableList.of(d(fromHtml, str3)), g11, g12 - g11));
                        }
                        mVar3 = mVar;
                    }
                    mVar4 = mVar3;
                    str4 = str2;
                } else {
                    String str5 = str4;
                    mVar2 = mVar4;
                    str = str5;
                    u.h(str, "Skipping invalid timing: " + t11);
                    mVar4 = mVar2;
                    str4 = str;
                }
            }
        }
        m mVar5 = mVar4;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                mVar5.accept((e) it.next());
            }
        }
    }

    @Override // i3.s
    public /* synthetic */ k b(byte[] bArr, int i11, int i12) {
        return r.a(this, bArr, i11, i12);
    }

    @Override // i3.s
    public int c() {
        return 1;
    }

    @Override // i3.s
    public /* synthetic */ void reset() {
        r.b(this);
    }
}
