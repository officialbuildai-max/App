package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.rtsp.o;
import com.google.android.exoplayer2.util.p0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.r4;
import com.transsion.home.p004enum.BottomTabType;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class y {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f26565a = Pattern.compile("([A-Z_]+) (.*) RTSP/1\\.0");

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f26566b = Pattern.compile("RTSP/1\\.0 (\\d+) (.+)");

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f26567c = Pattern.compile("Content-Length:\\s?(\\d+)", 2);

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f26568d = Pattern.compile("([\\w$\\-_.+]+)(?:;\\s?timeout=(\\d+))?");

    /* renamed from: e, reason: collision with root package name */
    private static final Pattern f26569e = Pattern.compile("Digest realm=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\",\\s?(?:domain=\"(.+)\",\\s?)?nonce=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\"(?:,\\s?opaque=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\")?");

    /* renamed from: f, reason: collision with root package name */
    private static final Pattern f26570f = Pattern.compile("Basic realm=\"([^\"\\x00-\\x08\\x0A-\\x1f\\x7f]+)\"");

    /* renamed from: g, reason: collision with root package name */
    private static final String f26571g = new String(new byte[]{10});

    /* renamed from: h, reason: collision with root package name */
    private static final String f26572h = new String(new byte[]{13, 10});

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f26573a;

        /* renamed from: b, reason: collision with root package name */
        public final String f26574b;

        public a(String str, String str2) {
            this.f26573a = str;
            this.f26574b = str2;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f26575a;

        /* renamed from: b, reason: collision with root package name */
        public final long f26576b;

        public b(String str, long j11) {
            this.f26575a = str;
            this.f26576b = j11;
        }
    }

    public static byte[] a(List list) {
        return com.google.common.base.g.h(f26572h).d(list).getBytes(u.f26542g);
    }

    private static String b(int i11) {
        if (i11 == 200) {
            return "OK";
        }
        if (i11 == 461) {
            return "Unsupported Transport";
        }
        if (i11 == 500) {
            return "Internal Server Error";
        }
        if (i11 == 505) {
            return "RTSP Version Not Supported";
        }
        if (i11 == 301) {
            return "Move Permanently";
        }
        if (i11 == 302) {
            return "Move Temporarily";
        }
        if (i11 == 400) {
            return "Bad Request";
        }
        if (i11 == 401) {
            return "Unauthorized";
        }
        if (i11 == 404) {
            return "Not Found";
        }
        if (i11 == 405) {
            return "Method Not Allowed";
        }
        switch (i11) {
            case 454:
                return "Session Not Found";
            case 455:
                return "Method Not Valid In This State";
            case 456:
                return "Header Field Not Valid";
            case 457:
                return "Invalid Range";
            default:
                throw new IllegalArgumentException();
        }
    }

    public static byte[] c(String str) {
        return str.getBytes(u.f26542g);
    }

    public static boolean d(List list) {
        return f26566b.matcher((CharSequence) list.get(0)).matches();
    }

    public static boolean e(String str) {
        return f26565a.matcher(str).matches() || f26566b.matcher(str).matches();
    }

    public static long f(String str) {
        try {
            Matcher matcher = f26567c.matcher(str);
            if (matcher.find()) {
                return Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)));
            }
            return -1L;
        } catch (NumberFormatException e11) {
            throw ParserException.createForMalformedManifest(str, e11);
        }
    }

    public static int g(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e11) {
            throw ParserException.createForMalformedManifest(str, e11);
        }
    }

    private static int h(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1881579439:
                if (str.equals("RECORD")) {
                    c11 = 0;
                    break;
                }
                break;
            case -880847356:
                if (str.equals("TEARDOWN")) {
                    c11 = 1;
                    break;
                }
                break;
            case -702888512:
                if (str.equals("GET_PARAMETER")) {
                    c11 = 2;
                    break;
                }
                break;
            case -531492226:
                if (str.equals("OPTIONS")) {
                    c11 = 3;
                    break;
                }
                break;
            case -84360524:
                if (str.equals("PLAY_NOTIFY")) {
                    c11 = 4;
                    break;
                }
                break;
            case 2458420:
                if (str.equals("PLAY")) {
                    c11 = 5;
                    break;
                }
                break;
            case 6481884:
                if (str.equals(BottomTabType.TAB_OPEN_TYPE_TAB)) {
                    c11 = 6;
                    break;
                }
                break;
            case 71242700:
                if (str.equals("SET_PARAMETER")) {
                    c11 = 7;
                    break;
                }
                break;
            case 75902422:
                if (str.equals("PAUSE")) {
                    c11 = '\b';
                    break;
                }
                break;
            case 78791261:
                if (str.equals("SETUP")) {
                    c11 = '\t';
                    break;
                }
                break;
            case 133006441:
                if (str.equals("ANNOUNCE")) {
                    c11 = '\n';
                    break;
                }
                break;
            case 1800840907:
                if (str.equals("DESCRIBE")) {
                    c11 = 11;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return 8;
            case 1:
                return 12;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 7;
            case 5:
                return 6;
            case 6:
                return 9;
            case 7:
                return 11;
            case '\b':
                return 5;
            case '\t':
                return 10;
            case '\n':
                return 1;
            case 11:
                return 2;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static ImmutableList i(String str) {
        if (str == null) {
            return ImmutableList.of();
        }
        ImmutableList.a aVar = new ImmutableList.a();
        for (String str2 : p0.S0(str, ",\\s?")) {
            aVar.a(Integer.valueOf(h(str2)));
        }
        return aVar.e();
    }

    public static b0 j(List list) {
        Matcher matcher = f26565a.matcher((CharSequence) list.get(0));
        com.google.android.exoplayer2.util.a.a(matcher.matches());
        int h11 = h((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)));
        Uri parse = Uri.parse((String) com.google.android.exoplayer2.util.a.e(matcher.group(2)));
        int indexOf = list.indexOf("");
        com.google.android.exoplayer2.util.a.a(indexOf > 0);
        return new b0(parse, h11, new o.b().c(list.subList(1, indexOf)).e(), com.google.common.base.g.h(f26572h).d(list.subList(indexOf + 1, list.size())));
    }

    public static c0 k(List list) {
        Matcher matcher = f26566b.matcher((CharSequence) list.get(0));
        com.google.android.exoplayer2.util.a.a(matcher.matches());
        int parseInt = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)));
        int indexOf = list.indexOf("");
        com.google.android.exoplayer2.util.a.a(indexOf > 0);
        return new c0(parseInt, new o.b().c(list.subList(1, indexOf)).e(), com.google.common.base.g.h(f26572h).d(list.subList(indexOf + 1, list.size())));
    }

    public static b l(String str) {
        long parseInt;
        Matcher matcher = f26568d.matcher(str);
        if (!matcher.matches()) {
            throw ParserException.createForMalformedManifest(str, null);
        }
        String str2 = (String) com.google.android.exoplayer2.util.a.e(matcher.group(1));
        if (matcher.group(2) != null) {
            try {
                parseInt = Integer.parseInt(r0) * 1000;
            } catch (NumberFormatException e11) {
                throw ParserException.createForMalformedManifest(str, e11);
            }
        } else {
            parseInt = 60000;
        }
        return new b(str2, parseInt);
    }

    public static a m(Uri uri) {
        String userInfo = uri.getUserInfo();
        if (userInfo == null || !userInfo.contains(":")) {
            return null;
        }
        String[] T0 = p0.T0(userInfo, ":");
        return new a(T0[0], T0[1]);
    }

    public static l n(String str) {
        Matcher matcher = f26569e.matcher(str);
        if (matcher.find()) {
            return new l(2, (String) com.google.android.exoplayer2.util.a.e(matcher.group(1)), (String) com.google.android.exoplayer2.util.a.e(matcher.group(3)), com.google.common.base.p.e(matcher.group(4)));
        }
        Matcher matcher2 = f26570f.matcher(str);
        if (matcher2.matches()) {
            return new l(1, (String) com.google.android.exoplayer2.util.a.e(matcher2.group(1)), "", "");
        }
        String valueOf = String.valueOf(str);
        throw ParserException.createForMalformedManifest(valueOf.length() != 0 ? "Invalid WWW-Authenticate header ".concat(valueOf) : new String("Invalid WWW-Authenticate header "), null);
    }

    public static Uri o(Uri uri) {
        if (uri.getUserInfo() == null) {
            return uri;
        }
        String str = (String) com.google.android.exoplayer2.util.a.e(uri.getAuthority());
        com.google.android.exoplayer2.util.a.a(str.contains("@"));
        return uri.buildUpon().encodedAuthority(p0.S0(str, "@")[1]).build();
    }

    public static ImmutableList p(b0 b0Var) {
        com.google.android.exoplayer2.util.a.a(b0Var.f26385c.d("CSeq") != null);
        ImmutableList.a aVar = new ImmutableList.a();
        aVar.a(p0.C("%s %s %s", s(b0Var.f26384b), b0Var.f26383a, "RTSP/1.0"));
        ImmutableListMultimap b11 = b0Var.f26385c.b();
        r4 it = b11.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            ImmutableList immutableList = b11.get((ImmutableListMultimap) str);
            for (int i11 = 0; i11 < immutableList.size(); i11++) {
                aVar.a(p0.C("%s: %s", str, immutableList.get(i11)));
            }
        }
        aVar.a("");
        aVar.a(b0Var.f26386d);
        return aVar.e();
    }

    public static ImmutableList q(c0 c0Var) {
        com.google.android.exoplayer2.util.a.a(c0Var.f26388b.d("CSeq") != null);
        ImmutableList.a aVar = new ImmutableList.a();
        aVar.a(p0.C("%s %s %s", "RTSP/1.0", Integer.valueOf(c0Var.f26387a), b(c0Var.f26387a)));
        ImmutableListMultimap b11 = c0Var.f26388b.b();
        r4 it = b11.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            ImmutableList immutableList = b11.get((ImmutableListMultimap) str);
            for (int i11 = 0; i11 < immutableList.size(); i11++) {
                aVar.a(p0.C("%s: %s", str, immutableList.get(i11)));
            }
        }
        aVar.a("");
        aVar.a(c0Var.f26389c);
        return aVar.e();
    }

    public static String[] r(String str) {
        String str2 = f26572h;
        if (!str.contains(str2)) {
            str2 = f26571g;
        }
        return p0.S0(str, str2);
    }

    public static String s(int i11) {
        switch (i11) {
            case 1:
                return "ANNOUNCE";
            case 2:
                return "DESCRIBE";
            case 3:
                return "GET_PARAMETER";
            case 4:
                return "OPTIONS";
            case 5:
                return "PAUSE";
            case 6:
                return "PLAY";
            case 7:
                return "PLAY_NOTIFY";
            case 8:
                return "RECORD";
            case 9:
                return BottomTabType.TAB_OPEN_TYPE_TAB;
            case 10:
                return "SETUP";
            case 11:
                return "SET_PARAMETER";
            case 12:
                return "TEARDOWN";
            default:
                throw new IllegalStateException();
        }
    }
}
