package ga;

import android.graphics.Color;
import android.graphics.PointF;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f63616a;

    /* renamed from: b, reason: collision with root package name */
    public final int f63617b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f63618c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f63619d;

    /* renamed from: e, reason: collision with root package name */
    public final float f63620e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f63621f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f63622g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f63623h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f63624i;

    /* renamed from: j, reason: collision with root package name */
    public final int f63625j;

    /* loaded from: classes4.dex */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f63626a;

        /* renamed from: b, reason: collision with root package name */
        public final int f63627b;

        /* renamed from: c, reason: collision with root package name */
        public final int f63628c;

        /* renamed from: d, reason: collision with root package name */
        public final int f63629d;

        /* renamed from: e, reason: collision with root package name */
        public final int f63630e;

        /* renamed from: f, reason: collision with root package name */
        public final int f63631f;

        /* renamed from: g, reason: collision with root package name */
        public final int f63632g;

        /* renamed from: h, reason: collision with root package name */
        public final int f63633h;

        /* renamed from: i, reason: collision with root package name */
        public final int f63634i;

        /* renamed from: j, reason: collision with root package name */
        public final int f63635j;

        /* renamed from: k, reason: collision with root package name */
        public final int f63636k;

        private a(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21) {
            this.f63626a = i11;
            this.f63627b = i12;
            this.f63628c = i13;
            this.f63629d = i14;
            this.f63630e = i15;
            this.f63631f = i16;
            this.f63632g = i17;
            this.f63633h = i18;
            this.f63634i = i19;
            this.f63635j = i20;
            this.f63636k = i21;
        }

        public static a a(String str) {
            char c11;
            String[] split = TextUtils.split(str.substring(7), ",");
            int i11 = -1;
            int i12 = -1;
            int i13 = -1;
            int i14 = -1;
            int i15 = -1;
            int i16 = -1;
            int i17 = -1;
            int i18 = -1;
            int i19 = -1;
            int i20 = -1;
            for (int i21 = 0; i21 < split.length; i21++) {
                String e11 = com.google.common.base.a.e(split[i21].trim());
                e11.hashCode();
                switch (e11.hashCode()) {
                    case -1178781136:
                        if (e11.equals(TtmlNode.ITALIC)) {
                            c11 = 0;
                            break;
                        }
                        break;
                    case -1026963764:
                        if (e11.equals(TtmlNode.UNDERLINE)) {
                            c11 = 1;
                            break;
                        }
                        break;
                    case -192095652:
                        if (e11.equals("strikeout")) {
                            c11 = 2;
                            break;
                        }
                        break;
                    case -70925746:
                        if (e11.equals("primarycolour")) {
                            c11 = 3;
                            break;
                        }
                        break;
                    case 3029637:
                        if (e11.equals(TtmlNode.BOLD)) {
                            c11 = 4;
                            break;
                        }
                        break;
                    case 3373707:
                        if (e11.equals("name")) {
                            c11 = 5;
                            break;
                        }
                        break;
                    case 366554320:
                        if (e11.equals("fontsize")) {
                            c11 = 6;
                            break;
                        }
                        break;
                    case 767321349:
                        if (e11.equals("borderstyle")) {
                            c11 = 7;
                            break;
                        }
                        break;
                    case 1767875043:
                        if (e11.equals("alignment")) {
                            c11 = '\b';
                            break;
                        }
                        break;
                    case 1988365454:
                        if (e11.equals("outlinecolour")) {
                            c11 = '\t';
                            break;
                        }
                        break;
                }
                c11 = 65535;
                switch (c11) {
                    case 0:
                        i17 = i21;
                        break;
                    case 1:
                        i18 = i21;
                        break;
                    case 2:
                        i19 = i21;
                        break;
                    case 3:
                        i13 = i21;
                        break;
                    case 4:
                        i16 = i21;
                        break;
                    case 5:
                        i11 = i21;
                        break;
                    case 6:
                        i15 = i21;
                        break;
                    case 7:
                        i20 = i21;
                        break;
                    case '\b':
                        i12 = i21;
                        break;
                    case '\t':
                        i14 = i21;
                        break;
                }
            }
            if (i11 != -1) {
                return new a(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, split.length);
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    static final class b {

        /* renamed from: c, reason: collision with root package name */
        private static final Pattern f63637c = Pattern.compile("\\{([^}]*)\\}");

        /* renamed from: d, reason: collision with root package name */
        private static final Pattern f63638d = Pattern.compile(p0.C("\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));

        /* renamed from: e, reason: collision with root package name */
        private static final Pattern f63639e = Pattern.compile(p0.C("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));

        /* renamed from: f, reason: collision with root package name */
        private static final Pattern f63640f = Pattern.compile("\\\\an(\\d+)");

        /* renamed from: a, reason: collision with root package name */
        public final int f63641a;

        /* renamed from: b, reason: collision with root package name */
        public final PointF f63642b;

        private b(int i11, PointF pointF) {
            this.f63641a = i11;
            this.f63642b = pointF;
        }

        private static int a(String str) {
            Matcher matcher = f63640f.matcher(str);
            if (matcher.find()) {
                return c.e((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)));
            }
            return -1;
        }

        public static b b(String str) {
            Matcher matcher = f63637c.matcher(str);
            PointF pointF = null;
            int i11 = -1;
            while (matcher.find()) {
                String str2 = (String) com.google.android.exoplayer2.util.a.e(matcher.group(1));
                try {
                    PointF c11 = c(str2);
                    if (c11 != null) {
                        pointF = c11;
                    }
                } catch (RuntimeException unused) {
                }
                try {
                    int a11 = a(str2);
                    if (a11 != -1) {
                        i11 = a11;
                    }
                } catch (RuntimeException unused2) {
                }
            }
            return new b(i11, pointF);
        }

        private static PointF c(String str) {
            String group;
            String group2;
            Matcher matcher = f63638d.matcher(str);
            Matcher matcher2 = f63639e.matcher(str);
            boolean find = matcher.find();
            boolean find2 = matcher2.find();
            if (find) {
                if (find2) {
                    s.f("SsaStyle.Overrides", "Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='" + str + "'");
                }
                group = matcher.group(1);
                group2 = matcher.group(2);
            } else {
                if (!find2) {
                    return null;
                }
                group = matcher2.group(1);
                group2 = matcher2.group(2);
            }
            return new PointF(Float.parseFloat(((String) com.google.android.exoplayer2.util.a.e(group)).trim()), Float.parseFloat(((String) com.google.android.exoplayer2.util.a.e(group2)).trim()));
        }

        public static String d(String str) {
            return f63637c.matcher(str).replaceAll("");
        }
    }

    private c(String str, int i11, Integer num, Integer num2, float f11, boolean z10, boolean z11, boolean z12, boolean z13, int i12) {
        this.f63616a = str;
        this.f63617b = i11;
        this.f63618c = num;
        this.f63619d = num2;
        this.f63620e = f11;
        this.f63621f = z10;
        this.f63622g = z11;
        this.f63623h = z12;
        this.f63624i = z13;
        this.f63625j = i12;
    }

    public static c b(String str, a aVar) {
        com.google.android.exoplayer2.util.a.a(str.startsWith("Style:"));
        String[] split = TextUtils.split(str.substring(6), ",");
        int length = split.length;
        int i11 = aVar.f63636k;
        if (length != i11) {
            s.i("SsaStyle", p0.C("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", Integer.valueOf(i11), Integer.valueOf(split.length), str));
            return null;
        }
        try {
            String trim = split[aVar.f63626a].trim();
            int i12 = aVar.f63627b;
            int e11 = i12 != -1 ? e(split[i12].trim()) : -1;
            int i13 = aVar.f63628c;
            Integer h11 = i13 != -1 ? h(split[i13].trim()) : null;
            int i14 = aVar.f63629d;
            Integer h12 = i14 != -1 ? h(split[i14].trim()) : null;
            int i15 = aVar.f63630e;
            float i16 = i15 != -1 ? i(split[i15].trim()) : -3.4028235E38f;
            int i17 = aVar.f63631f;
            boolean z10 = i17 != -1 && f(split[i17].trim());
            int i18 = aVar.f63632g;
            boolean z11 = i18 != -1 && f(split[i18].trim());
            int i19 = aVar.f63633h;
            boolean z12 = i19 != -1 && f(split[i19].trim());
            int i20 = aVar.f63634i;
            boolean z13 = i20 != -1 && f(split[i20].trim());
            int i21 = aVar.f63635j;
            return new c(trim, e11, h11, h12, i16, z10, z11, z12, z13, i21 != -1 ? g(split[i21].trim()) : -1);
        } catch (RuntimeException e12) {
            s.j("SsaStyle", "Skipping malformed 'Style:' line: '" + str + "'", e12);
            return null;
        }
    }

    private static boolean c(int i11) {
        switch (i11) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    private static boolean d(int i11) {
        return i11 == 1 || i11 == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int e(String str) {
        try {
            int parseInt = Integer.parseInt(str.trim());
            if (c(parseInt)) {
                return parseInt;
            }
        } catch (NumberFormatException unused) {
        }
        s.i("SsaStyle", "Ignoring unknown alignment: " + str);
        return -1;
    }

    private static boolean f(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            return parseInt == 1 || parseInt == -1;
        } catch (NumberFormatException e11) {
            s.j("SsaStyle", "Failed to parse boolean value: '" + str + "'", e11);
            return false;
        }
    }

    private static int g(String str) {
        try {
            int parseInt = Integer.parseInt(str.trim());
            if (d(parseInt)) {
                return parseInt;
            }
        } catch (NumberFormatException unused) {
        }
        s.i("SsaStyle", "Ignoring unknown BorderStyle: " + str);
        return -1;
    }

    public static Integer h(String str) {
        try {
            long parseLong = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            com.google.android.exoplayer2.util.a.a(parseLong <= 4294967295L);
            return Integer.valueOf(Color.argb(Ints.d(((parseLong >> 24) & 255) ^ 255), Ints.d(parseLong & 255), Ints.d((parseLong >> 8) & 255), Ints.d((parseLong >> 16) & 255)));
        } catch (IllegalArgumentException e11) {
            s.j("SsaStyle", "Failed to parse color expression: '" + str + "'", e11);
            return null;
        }
    }

    private static float i(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e11) {
            s.j("SsaStyle", "Failed to parse font size: '" + str + "'", e11);
            return -3.4028235E38f;
        }
    }
}
