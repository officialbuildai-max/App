package r3;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.j0;
import androidx.media3.common.util.u;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import r3.e;
import u1.a;

/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f74183a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f74184b = Pattern.compile("(\\S+?):(\\S+)");

    /* renamed from: c, reason: collision with root package name */
    private static final Map f74185c;

    /* renamed from: d, reason: collision with root package name */
    private static final Map f74186d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: c, reason: collision with root package name */
        private static final Comparator f74187c = new Comparator() { // from class: r3.f
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int e11;
                e11 = e.b.e((e.b) obj, (e.b) obj2);
                return e11;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        private final c f74188a;

        /* renamed from: b, reason: collision with root package name */
        private final int f74189b;

        private b(c cVar, int i11) {
            this.f74188a = cVar;
            this.f74189b = i11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int e(b bVar, b bVar2) {
            return Integer.compare(bVar.f74188a.f74191b, bVar2.f74188a.f74191b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f74190a;

        /* renamed from: b, reason: collision with root package name */
        public final int f74191b;

        /* renamed from: c, reason: collision with root package name */
        public final String f74192c;

        /* renamed from: d, reason: collision with root package name */
        public final Set f74193d;

        private c(String str, int i11, String str2, Set set) {
            this.f74191b = i11;
            this.f74190a = str;
            this.f74192c = str2;
            this.f74193d = set;
        }

        public static c a(String str, int i11) {
            String str2;
            String trim = str.trim();
            androidx.media3.common.util.a.a(!trim.isEmpty());
            int indexOf = trim.indexOf(" ");
            if (indexOf == -1) {
                str2 = "";
            } else {
                String trim2 = trim.substring(indexOf).trim();
                trim = trim.substring(0, indexOf);
                str2 = trim2;
            }
            String[] o12 = a1.o1(trim, "\\.");
            String str3 = o12[0];
            HashSet hashSet = new HashSet();
            for (int i12 = 1; i12 < o12.length; i12++) {
                hashSet.add(o12[i12]);
            }
            return new c(str3, i11, str2, hashSet);
        }

        public static c b() {
            return new c("", 0, "", Collections.emptySet());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class d implements Comparable {

        /* renamed from: a, reason: collision with root package name */
        public final int f74194a;

        /* renamed from: b, reason: collision with root package name */
        public final r3.c f74195b;

        public d(int i11, r3.c cVar) {
            this.f74194a = i11;
            this.f74195b = cVar;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            return Integer.compare(this.f74194a, dVar.f74194a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r3.e$e, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0928e {

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f74198c;

        /* renamed from: a, reason: collision with root package name */
        public long f74196a = 0;

        /* renamed from: b, reason: collision with root package name */
        public long f74197b = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f74199d = 2;

        /* renamed from: e, reason: collision with root package name */
        public float f74200e = -3.4028235E38f;

        /* renamed from: f, reason: collision with root package name */
        public int f74201f = 1;

        /* renamed from: g, reason: collision with root package name */
        public int f74202g = 0;

        /* renamed from: h, reason: collision with root package name */
        public float f74203h = -3.4028235E38f;

        /* renamed from: i, reason: collision with root package name */
        public int f74204i = Integer.MIN_VALUE;

        /* renamed from: j, reason: collision with root package name */
        public float f74205j = 1.0f;

        /* renamed from: k, reason: collision with root package name */
        public int f74206k = Integer.MIN_VALUE;

        private static float b(float f11, int i11) {
            if (f11 == -3.4028235E38f || i11 != 0 || (f11 >= 0.0f && f11 <= 1.0f)) {
                return f11 != -3.4028235E38f ? f11 : i11 == 0 ? 1.0f : -3.4028235E38f;
            }
            return 1.0f;
        }

        private static Layout.Alignment c(int i11) {
            if (i11 != 1) {
                if (i11 == 2) {
                    return Layout.Alignment.ALIGN_CENTER;
                }
                if (i11 != 3) {
                    if (i11 != 4) {
                        if (i11 != 5) {
                            u.h("WebvttCueParser", "Unknown textAlignment: " + i11);
                            return null;
                        }
                    }
                }
                return Layout.Alignment.ALIGN_OPPOSITE;
            }
            return Layout.Alignment.ALIGN_NORMAL;
        }

        private static float d(int i11, float f11) {
            if (i11 == 0) {
                return 1.0f - f11;
            }
            if (i11 == 1) {
                return f11 <= 0.5f ? f11 * 2.0f : (1.0f - f11) * 2.0f;
            }
            if (i11 == 2) {
                return f11;
            }
            throw new IllegalStateException(String.valueOf(i11));
        }

        private static float e(int i11) {
            if (i11 != 4) {
                return i11 != 5 ? 0.5f : 1.0f;
            }
            return 0.0f;
        }

        private static int f(int i11) {
            if (i11 == 1) {
                return 0;
            }
            if (i11 == 3) {
                return 2;
            }
            if (i11 != 4) {
                return i11 != 5 ? 1 : 2;
            }
            return 0;
        }

        public r3.d a() {
            return new r3.d(g().a(), this.f74196a, this.f74197b);
        }

        public a.b g() {
            float f11 = this.f74203h;
            if (f11 == -3.4028235E38f) {
                f11 = e(this.f74199d);
            }
            int i11 = this.f74204i;
            if (i11 == Integer.MIN_VALUE) {
                i11 = f(this.f74199d);
            }
            a.b r11 = new a.b().p(c(this.f74199d)).h(b(this.f74200e, this.f74201f), this.f74201f).i(this.f74202g).k(f11).l(i11).n(Math.min(this.f74205j, d(i11, f11))).r(this.f74206k);
            CharSequence charSequence = this.f74198c;
            if (charSequence != null) {
                r11.o(charSequence);
            }
            return r11;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        f74185c = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        f74186d = Collections.unmodifiableMap(hashMap2);
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, Set set, int i11, int i12) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Map map = f74185c;
            if (map.containsKey(str)) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(((Integer) map.get(str)).intValue()), i11, i12, 33);
            } else {
                Map map2 = f74186d;
                if (map2.containsKey(str)) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(((Integer) map2.get(str)).intValue()), i11, i12, 33);
                }
            }
        }
    }

    private static void b(String str, SpannableStringBuilder spannableStringBuilder) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 3309:
                if (str.equals("gt")) {
                    c11 = 0;
                    break;
                }
                break;
            case 3464:
                if (str.equals("lt")) {
                    c11 = 1;
                    break;
                }
                break;
            case 96708:
                if (str.equals("amp")) {
                    c11 = 2;
                    break;
                }
                break;
            case 3374865:
                if (str.equals("nbsp")) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                spannableStringBuilder.append('>');
                return;
            case 1:
                spannableStringBuilder.append('<');
                return;
            case 2:
                spannableStringBuilder.append('&');
                return;
            case 3:
                spannableStringBuilder.append(' ');
                return;
            default:
                u.h("WebvttCueParser", "ignoring unsupported entity: '&" + str + ";'");
                return;
        }
    }

    private static void c(SpannableStringBuilder spannableStringBuilder, String str, c cVar, List list, List list2) {
        int j11 = j(list2, str, cVar);
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        Collections.sort(arrayList, b.f74187c);
        int i11 = cVar.f74191b;
        int i12 = 0;
        for (int i13 = 0; i13 < arrayList.size(); i13++) {
            if ("rt".equals(((b) arrayList.get(i13)).f74188a.f74190a)) {
                b bVar = (b) arrayList.get(i13);
                int h11 = h(j(list2, str, bVar.f74188a), j11, 1);
                int i14 = bVar.f74188a.f74191b - i12;
                int i15 = bVar.f74189b - i12;
                CharSequence subSequence = spannableStringBuilder.subSequence(i14, i15);
                spannableStringBuilder.delete(i14, i15);
                spannableStringBuilder.setSpan(new u1.f(subSequence.toString(), h11), i11, i14, 33);
                i12 += subSequence.length();
                i11 = i14;
            }
        }
    }

    private static void d(String str, c cVar, List list, SpannableStringBuilder spannableStringBuilder, List list2) {
        int i11 = cVar.f74191b;
        int length = spannableStringBuilder.length();
        String str2 = cVar.f74190a;
        str2.hashCode();
        char c11 = 65535;
        switch (str2.hashCode()) {
            case 0:
                if (str2.equals("")) {
                    c11 = 0;
                    break;
                }
                break;
            case 98:
                if (str2.equals(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B)) {
                    c11 = 1;
                    break;
                }
                break;
            case 99:
                if (str2.equals("c")) {
                    c11 = 2;
                    break;
                }
                break;
            case 105:
                if (str2.equals("i")) {
                    c11 = 3;
                    break;
                }
                break;
            case ASSET_FAILED_STATUS_CODE_VALUE:
                if (str2.equals(TmcStartParams.KEY_URL_SHORT)) {
                    c11 = 4;
                    break;
                }
                break;
            case PROTOBUF_SERIALIZATION_ERROR_VALUE:
                if (str2.equals("v")) {
                    c11 = 5;
                    break;
                }
                break;
            case 3314158:
                if (str2.equals("lang")) {
                    c11 = 6;
                    break;
                }
                break;
            case 3511770:
                if (str2.equals("ruby")) {
                    c11 = 7;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 6:
                break;
            case 1:
                spannableStringBuilder.setSpan(new StyleSpan(1), i11, length, 33);
                break;
            case 2:
                a(spannableStringBuilder, cVar.f74193d, i11, length);
                break;
            case 3:
                spannableStringBuilder.setSpan(new StyleSpan(2), i11, length, 33);
                break;
            case 4:
                spannableStringBuilder.setSpan(new UnderlineSpan(), i11, length, 33);
                break;
            case 5:
                f(spannableStringBuilder, cVar.f74192c, i11, length);
                break;
            case 7:
                c(spannableStringBuilder, str, cVar, list, list2);
                break;
            default:
                return;
        }
        List i12 = i(list2, str, cVar);
        for (int i13 = 0; i13 < i12.size(); i13++) {
            e(spannableStringBuilder, ((d) i12.get(i13)).f74195b, i11, length);
        }
    }

    private static void e(SpannableStringBuilder spannableStringBuilder, r3.c cVar, int i11, int i12) {
        if (cVar == null) {
            return;
        }
        if (cVar.i() != -1) {
            u1.g.b(spannableStringBuilder, new StyleSpan(cVar.i()), i11, i12, 33);
        }
        if (cVar.l()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i11, i12, 33);
        }
        if (cVar.m()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i11, i12, 33);
        }
        if (cVar.k()) {
            u1.g.b(spannableStringBuilder, new ForegroundColorSpan(cVar.c()), i11, i12, 33);
        }
        if (cVar.j()) {
            u1.g.b(spannableStringBuilder, new BackgroundColorSpan(cVar.a()), i11, i12, 33);
        }
        if (cVar.d() != null) {
            u1.g.b(spannableStringBuilder, new TypefaceSpan(cVar.d()), i11, i12, 33);
        }
        int f11 = cVar.f();
        if (f11 == 1) {
            u1.g.b(spannableStringBuilder, new AbsoluteSizeSpan((int) cVar.e(), true), i11, i12, 33);
        } else if (f11 == 2) {
            u1.g.b(spannableStringBuilder, new RelativeSizeSpan(cVar.e()), i11, i12, 33);
        } else if (f11 == 3) {
            u1.g.b(spannableStringBuilder, new RelativeSizeSpan(cVar.e() / 100.0f), i11, i12, 33);
        }
        if (cVar.b()) {
            spannableStringBuilder.setSpan(new u1.d(), i11, i12, 33);
        }
    }

    private static void f(SpannableStringBuilder spannableStringBuilder, String str, int i11, int i12) {
        spannableStringBuilder.setSpan(new u1.i(str), i11, i12, 33);
    }

    private static int g(String str, int i11) {
        int indexOf = str.indexOf(62, i11);
        return indexOf == -1 ? str.length() : indexOf + 1;
    }

    private static int h(int i11, int i12, int i13) {
        if (i11 != -1) {
            return i11;
        }
        if (i12 != -1) {
            return i12;
        }
        if (i13 != -1) {
            return i13;
        }
        throw new IllegalArgumentException();
    }

    private static List i(List list, String str, c cVar) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            r3.c cVar2 = (r3.c) list.get(i11);
            int h11 = cVar2.h(str, cVar.f74190a, cVar.f74193d, cVar.f74192c);
            if (h11 > 0) {
                arrayList.add(new d(h11, cVar2));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static int j(List list, String str, c cVar) {
        List i11 = i(list, str, cVar);
        for (int i12 = 0; i12 < i11.size(); i12++) {
            r3.c cVar2 = ((d) i11.get(i12)).f74195b;
            if (cVar2.g() != -1) {
                return cVar2.g();
            }
        }
        return -1;
    }

    private static String k(String str) {
        String trim = str.trim();
        androidx.media3.common.util.a.a(!trim.isEmpty());
        return a1.p1(trim, "[ \\.]")[0];
    }

    private static boolean l(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 98:
                if (str.equals(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B)) {
                    c11 = 0;
                    break;
                }
                break;
            case 99:
                if (str.equals("c")) {
                    c11 = 1;
                    break;
                }
                break;
            case 105:
                if (str.equals("i")) {
                    c11 = 2;
                    break;
                }
                break;
            case ASSET_FAILED_STATUS_CODE_VALUE:
                if (str.equals(TmcStartParams.KEY_URL_SHORT)) {
                    c11 = 3;
                    break;
                }
                break;
            case PROTOBUF_SERIALIZATION_ERROR_VALUE:
                if (str.equals("v")) {
                    c11 = 4;
                    break;
                }
                break;
            case 3650:
                if (str.equals("rt")) {
                    c11 = 5;
                    break;
                }
                break;
            case 3314158:
                if (str.equals("lang")) {
                    c11 = 6;
                    break;
                }
                break;
            case 3511770:
                if (str.equals("ruby")) {
                    c11 = 7;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return true;
            default:
                return false;
        }
    }

    public static u1.a m(CharSequence charSequence) {
        C0928e c0928e = new C0928e();
        c0928e.f74198c = charSequence;
        return c0928e.g().a();
    }

    public static r3.d n(j0 j0Var, List list) {
        String s11 = j0Var.s();
        if (s11 == null) {
            return null;
        }
        Pattern pattern = f74183a;
        Matcher matcher = pattern.matcher(s11);
        if (matcher.matches()) {
            return o(null, matcher, j0Var, list);
        }
        String s12 = j0Var.s();
        if (s12 == null) {
            return null;
        }
        Matcher matcher2 = pattern.matcher(s12);
        if (matcher2.matches()) {
            return o(s11.trim(), matcher2, j0Var, list);
        }
        return null;
    }

    private static r3.d o(String str, Matcher matcher, j0 j0Var, List list) {
        C0928e c0928e = new C0928e();
        try {
            c0928e.f74196a = h.d((String) androidx.media3.common.util.a.e(matcher.group(1)));
            c0928e.f74197b = h.d((String) androidx.media3.common.util.a.e(matcher.group(2)));
            q((String) androidx.media3.common.util.a.e(matcher.group(3)), c0928e);
            StringBuilder sb2 = new StringBuilder();
            String s11 = j0Var.s();
            while (!TextUtils.isEmpty(s11)) {
                if (sb2.length() > 0) {
                    sb2.append("\n");
                }
                sb2.append(s11.trim());
                s11 = j0Var.s();
            }
            c0928e.f74198c = r(str, sb2.toString(), list);
            return c0928e.a();
        } catch (IllegalArgumentException unused) {
            u.h("WebvttCueParser", "Skipping cue with bad header: " + matcher.group());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a.b p(String str) {
        C0928e c0928e = new C0928e();
        q(str, c0928e);
        return c0928e.g();
    }

    private static void q(String str, C0928e c0928e) {
        Matcher matcher = f74184b.matcher(str);
        while (matcher.find()) {
            String str2 = (String) androidx.media3.common.util.a.e(matcher.group(1));
            String str3 = (String) androidx.media3.common.util.a.e(matcher.group(2));
            try {
                if ("line".equals(str2)) {
                    t(str3, c0928e);
                } else if ("align".equals(str2)) {
                    c0928e.f74199d = w(str3);
                } else if (RequestParameters.POSITION.equals(str2)) {
                    v(str3, c0928e);
                } else if ("size".equals(str2)) {
                    c0928e.f74205j = h.c(str3);
                } else if ("vertical".equals(str2)) {
                    c0928e.f74206k = x(str3);
                } else {
                    u.h("WebvttCueParser", "Unknown cue setting " + str2 + ":" + str3);
                }
            } catch (NumberFormatException unused) {
                u.h("WebvttCueParser", "Skipping bad cue setting: " + matcher.group());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpannedString r(String str, String str2, List list) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (i11 < str2.length()) {
            char charAt = str2.charAt(i11);
            if (charAt == '&') {
                i11++;
                int indexOf = str2.indexOf(59, i11);
                int indexOf2 = str2.indexOf(32, i11);
                if (indexOf == -1) {
                    indexOf = indexOf2;
                } else if (indexOf2 != -1) {
                    indexOf = Math.min(indexOf, indexOf2);
                }
                if (indexOf != -1) {
                    b(str2.substring(i11, indexOf), spannableStringBuilder);
                    if (indexOf == indexOf2) {
                        spannableStringBuilder.append((CharSequence) " ");
                    }
                    i11 = indexOf + 1;
                } else {
                    spannableStringBuilder.append(charAt);
                }
            } else if (charAt != '<') {
                spannableStringBuilder.append(charAt);
                i11++;
            } else {
                int i12 = i11 + 1;
                if (i12 < str2.length()) {
                    boolean z10 = str2.charAt(i12) == '/';
                    i12 = g(str2, i12);
                    int i13 = i12 - 2;
                    boolean z11 = str2.charAt(i13) == '/';
                    int i14 = i11 + (z10 ? 2 : 1);
                    if (!z11) {
                        i13 = i12 - 1;
                    }
                    String substring = str2.substring(i14, i13);
                    if (!substring.trim().isEmpty()) {
                        String k11 = k(substring);
                        if (l(k11)) {
                            if (!z10) {
                                if (!z11) {
                                    arrayDeque.push(c.a(substring, spannableStringBuilder.length()));
                                }
                            }
                            while (!arrayDeque.isEmpty()) {
                                c cVar = (c) arrayDeque.pop();
                                d(str, cVar, arrayList, spannableStringBuilder, list);
                                if (arrayDeque.isEmpty()) {
                                    arrayList.clear();
                                } else {
                                    arrayList.add(new b(cVar, spannableStringBuilder.length()));
                                }
                                if (cVar.f74190a.equals(k11)) {
                                    break;
                                }
                            }
                        }
                    }
                }
                i11 = i12;
            }
        }
        while (!arrayDeque.isEmpty()) {
            d(str, (c) arrayDeque.pop(), arrayList, spannableStringBuilder, list);
        }
        d(str, c.b(), Collections.emptyList(), spannableStringBuilder, list);
        return SpannedString.valueOf(spannableStringBuilder);
    }

    private static int s(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals(TtmlNode.CENTER)) {
                    c11 = 0;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c11 = 1;
                    break;
                }
                break;
            case 100571:
                if (str.equals(TtmlNode.END)) {
                    c11 = 2;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 0;
            default:
                u.h("WebvttCueParser", "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    private static void t(String str, C0928e c0928e) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            c0928e.f74202g = s(str.substring(indexOf + 1));
            str = str.substring(0, indexOf);
        }
        if (str.endsWith("%")) {
            c0928e.f74200e = h.c(str);
            c0928e.f74201f = 0;
        } else {
            c0928e.f74200e = Integer.parseInt(str);
            c0928e.f74201f = 1;
        }
    }

    private static int u(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1842484672:
                if (str.equals("line-left")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1364013995:
                if (str.equals(TtmlNode.CENTER)) {
                    c11 = 1;
                    break;
                }
                break;
            case -1276788989:
                if (str.equals("line-right")) {
                    c11 = 2;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c11 = 3;
                    break;
                }
                break;
            case 100571:
                if (str.equals(TtmlNode.END)) {
                    c11 = 4;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c11 = 5;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 5:
                return 0;
            case 1:
            case 3:
                return 1;
            case 2:
            case 4:
                return 2;
            default:
                u.h("WebvttCueParser", "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    private static void v(String str, C0928e c0928e) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            c0928e.f74204i = u(str.substring(indexOf + 1));
            str = str.substring(0, indexOf);
        }
        c0928e.f74203h = h.c(str);
    }

    private static int w(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals(TtmlNode.CENTER)) {
                    c11 = 0;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c11 = 1;
                    break;
                }
                break;
            case 100571:
                if (str.equals(TtmlNode.END)) {
                    c11 = 2;
                    break;
                }
                break;
            case 3317767:
                if (str.equals(TtmlNode.LEFT)) {
                    c11 = 3;
                    break;
                }
                break;
            case 108511772:
                if (str.equals(TtmlNode.RIGHT)) {
                    c11 = 4;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c11 = 5;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 1;
            default:
                u.h("WebvttCueParser", "Invalid alignment value: " + str);
                return 2;
        }
    }

    private static int x(String str) {
        str.hashCode();
        if (str.equals("lr")) {
            return 2;
        }
        if (str.equals("rl")) {
            return 1;
        }
        u.h("WebvttCueParser", "Invalid 'vertical' value: " + str);
        return Integer.MIN_VALUE;
    }
}
