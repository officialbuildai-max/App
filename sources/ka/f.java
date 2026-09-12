package ka;

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
import ba.b;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
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
import ka.f;

/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f66831a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f66832b = Pattern.compile("(\\S+?):(\\S+)");

    /* renamed from: c, reason: collision with root package name */
    private static final Map f66833c;

    /* renamed from: d, reason: collision with root package name */
    private static final Map f66834d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: c, reason: collision with root package name */
        private static final Comparator f66835c = new Comparator() { // from class: ka.g
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int e11;
                e11 = f.b.e((f.b) obj, (f.b) obj2);
                return e11;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        private final c f66836a;

        /* renamed from: b, reason: collision with root package name */
        private final int f66837b;

        private b(c cVar, int i11) {
            this.f66836a = cVar;
            this.f66837b = i11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int e(b bVar, b bVar2) {
            return Integer.compare(bVar.f66836a.f66839b, bVar2.f66836a.f66839b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f66838a;

        /* renamed from: b, reason: collision with root package name */
        public final int f66839b;

        /* renamed from: c, reason: collision with root package name */
        public final String f66840c;

        /* renamed from: d, reason: collision with root package name */
        public final Set f66841d;

        private c(String str, int i11, String str2, Set set) {
            this.f66839b = i11;
            this.f66838a = str;
            this.f66840c = str2;
            this.f66841d = set;
        }

        public static c a(String str, int i11) {
            String str2;
            String trim = str.trim();
            com.google.android.exoplayer2.util.a.a(!trim.isEmpty());
            int indexOf = trim.indexOf(" ");
            if (indexOf == -1) {
                str2 = "";
            } else {
                String trim2 = trim.substring(indexOf).trim();
                trim = trim.substring(0, indexOf);
                str2 = trim2;
            }
            String[] S0 = p0.S0(trim, "\\.");
            String str3 = S0[0];
            HashSet hashSet = new HashSet();
            for (int i12 = 1; i12 < S0.length; i12++) {
                hashSet.add(S0[i12]);
            }
            return new c(str3, i11, str2, hashSet);
        }

        public static c b() {
            return new c("", 0, "", Collections.emptySet());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class d implements Comparable {

        /* renamed from: a, reason: collision with root package name */
        public final int f66842a;

        /* renamed from: b, reason: collision with root package name */
        public final ka.d f66843b;

        public d(int i11, ka.d dVar) {
            this.f66842a = i11;
            this.f66843b = dVar;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            return Integer.compare(this.f66842a, dVar.f66842a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class e {

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f66846c;

        /* renamed from: a, reason: collision with root package name */
        public long f66844a = 0;

        /* renamed from: b, reason: collision with root package name */
        public long f66845b = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f66847d = 2;

        /* renamed from: e, reason: collision with root package name */
        public float f66848e = -3.4028235E38f;

        /* renamed from: f, reason: collision with root package name */
        public int f66849f = 1;

        /* renamed from: g, reason: collision with root package name */
        public int f66850g = 0;

        /* renamed from: h, reason: collision with root package name */
        public float f66851h = -3.4028235E38f;

        /* renamed from: i, reason: collision with root package name */
        public int f66852i = Integer.MIN_VALUE;

        /* renamed from: j, reason: collision with root package name */
        public float f66853j = 1.0f;

        /* renamed from: k, reason: collision with root package name */
        public int f66854k = Integer.MIN_VALUE;

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
                            s.i("WebvttCueParser", "Unknown textAlignment: " + i11);
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

        public ka.e a() {
            return new ka.e(g().a(), this.f66844a, this.f66845b);
        }

        public b.C0151b g() {
            float f11 = this.f66851h;
            if (f11 == -3.4028235E38f) {
                f11 = e(this.f66847d);
            }
            int i11 = this.f66852i;
            if (i11 == Integer.MIN_VALUE) {
                i11 = f(this.f66847d);
            }
            b.C0151b r11 = new b.C0151b().p(c(this.f66847d)).h(b(this.f66848e, this.f66849f), this.f66849f).i(this.f66850g).k(f11).l(i11).n(Math.min(this.f66853j, d(i11, f11))).r(this.f66854k);
            CharSequence charSequence = this.f66846c;
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
        f66833c = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        f66834d = Collections.unmodifiableMap(hashMap2);
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, Set set, int i11, int i12) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Map map = f66833c;
            if (map.containsKey(str)) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(((Integer) map.get(str)).intValue()), i11, i12, 33);
            } else {
                Map map2 = f66834d;
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
                s.i("WebvttCueParser", "ignoring unsupported entity: '&" + str + ";'");
                return;
        }
    }

    private static void c(SpannableStringBuilder spannableStringBuilder, String str, c cVar, List list, List list2) {
        int i11 = i(list2, str, cVar);
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        Collections.sort(arrayList, b.f66835c);
        int i12 = cVar.f66839b;
        int i13 = 0;
        for (int i14 = 0; i14 < arrayList.size(); i14++) {
            if ("rt".equals(((b) arrayList.get(i14)).f66836a.f66838a)) {
                b bVar = (b) arrayList.get(i14);
                int g11 = g(i(list2, str, bVar.f66836a), i11, 1);
                int i15 = bVar.f66836a.f66839b - i13;
                int i16 = bVar.f66837b - i13;
                CharSequence subSequence = spannableStringBuilder.subSequence(i15, i16);
                spannableStringBuilder.delete(i15, i16);
                spannableStringBuilder.setSpan(new fa.c(subSequence.toString(), g11), i12, i15, 33);
                i13 += subSequence.length();
                i12 = i15;
            }
        }
    }

    private static void d(String str, c cVar, List list, SpannableStringBuilder spannableStringBuilder, List list2) {
        int i11 = cVar.f66839b;
        int length = spannableStringBuilder.length();
        String str2 = cVar.f66838a;
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
            case 5:
            case 6:
                break;
            case 1:
                spannableStringBuilder.setSpan(new StyleSpan(1), i11, length, 33);
                break;
            case 2:
                a(spannableStringBuilder, cVar.f66841d, i11, length);
                break;
            case 3:
                spannableStringBuilder.setSpan(new StyleSpan(2), i11, length, 33);
                break;
            case 4:
                spannableStringBuilder.setSpan(new UnderlineSpan(), i11, length, 33);
                break;
            case 7:
                c(spannableStringBuilder, str, cVar, list, list2);
                break;
            default:
                return;
        }
        List h11 = h(list2, str, cVar);
        for (int i12 = 0; i12 < h11.size(); i12++) {
            e(spannableStringBuilder, ((d) h11.get(i12)).f66843b, i11, length);
        }
    }

    private static void e(SpannableStringBuilder spannableStringBuilder, ka.d dVar, int i11, int i12) {
        if (dVar == null) {
            return;
        }
        if (dVar.i() != -1) {
            fa.d.a(spannableStringBuilder, new StyleSpan(dVar.i()), i11, i12, 33);
        }
        if (dVar.l()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i11, i12, 33);
        }
        if (dVar.m()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i11, i12, 33);
        }
        if (dVar.k()) {
            fa.d.a(spannableStringBuilder, new ForegroundColorSpan(dVar.c()), i11, i12, 33);
        }
        if (dVar.j()) {
            fa.d.a(spannableStringBuilder, new BackgroundColorSpan(dVar.a()), i11, i12, 33);
        }
        if (dVar.d() != null) {
            fa.d.a(spannableStringBuilder, new TypefaceSpan(dVar.d()), i11, i12, 33);
        }
        int f11 = dVar.f();
        if (f11 == 1) {
            fa.d.a(spannableStringBuilder, new AbsoluteSizeSpan((int) dVar.e(), true), i11, i12, 33);
        } else if (f11 == 2) {
            fa.d.a(spannableStringBuilder, new RelativeSizeSpan(dVar.e()), i11, i12, 33);
        } else if (f11 == 3) {
            fa.d.a(spannableStringBuilder, new RelativeSizeSpan(dVar.e() / 100.0f), i11, i12, 33);
        }
        if (dVar.b()) {
            spannableStringBuilder.setSpan(new fa.a(), i11, i12, 33);
        }
    }

    private static int f(String str, int i11) {
        int indexOf = str.indexOf(62, i11);
        return indexOf == -1 ? str.length() : indexOf + 1;
    }

    private static int g(int i11, int i12, int i13) {
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

    private static List h(List list, String str, c cVar) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            ka.d dVar = (ka.d) list.get(i11);
            int h11 = dVar.h(str, cVar.f66838a, cVar.f66841d, cVar.f66840c);
            if (h11 > 0) {
                arrayList.add(new d(h11, dVar));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static int i(List list, String str, c cVar) {
        List h11 = h(list, str, cVar);
        for (int i11 = 0; i11 < h11.size(); i11++) {
            ka.d dVar = ((d) h11.get(i11)).f66843b;
            if (dVar.g() != -1) {
                return dVar.g();
            }
        }
        return -1;
    }

    private static String j(String str) {
        String trim = str.trim();
        com.google.android.exoplayer2.util.a.a(!trim.isEmpty());
        return p0.T0(trim, "[ \\.]")[0];
    }

    private static boolean k(String str) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ba.b l(CharSequence charSequence) {
        e eVar = new e();
        eVar.f66846c = charSequence;
        return eVar.g().a();
    }

    public static ka.e m(d0 d0Var, List list) {
        String p11 = d0Var.p();
        if (p11 == null) {
            return null;
        }
        Pattern pattern = f66831a;
        Matcher matcher = pattern.matcher(p11);
        if (matcher.matches()) {
            return n(null, matcher, d0Var, list);
        }
        String p12 = d0Var.p();
        if (p12 == null) {
            return null;
        }
        Matcher matcher2 = pattern.matcher(p12);
        if (matcher2.matches()) {
            return n(p11.trim(), matcher2, d0Var, list);
        }
        return null;
    }

    private static ka.e n(String str, Matcher matcher, d0 d0Var, List list) {
        e eVar = new e();
        try {
            eVar.f66844a = i.d((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)));
            eVar.f66845b = i.d((String) com.google.android.exoplayer2.util.a.e(matcher.group(2)));
            p((String) com.google.android.exoplayer2.util.a.e(matcher.group(3)), eVar);
            StringBuilder sb2 = new StringBuilder();
            String p11 = d0Var.p();
            while (!TextUtils.isEmpty(p11)) {
                if (sb2.length() > 0) {
                    sb2.append("\n");
                }
                sb2.append(p11.trim());
                p11 = d0Var.p();
            }
            eVar.f66846c = q(str, sb2.toString(), list);
            return eVar.a();
        } catch (NumberFormatException unused) {
            s.i("WebvttCueParser", "Skipping cue with bad header: " + matcher.group());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b.C0151b o(String str) {
        e eVar = new e();
        p(str, eVar);
        return eVar.g();
    }

    private static void p(String str, e eVar) {
        Matcher matcher = f66832b.matcher(str);
        while (matcher.find()) {
            String str2 = (String) com.google.android.exoplayer2.util.a.e(matcher.group(1));
            String str3 = (String) com.google.android.exoplayer2.util.a.e(matcher.group(2));
            try {
                if ("line".equals(str2)) {
                    s(str3, eVar);
                } else if ("align".equals(str2)) {
                    eVar.f66847d = v(str3);
                } else if (RequestParameters.POSITION.equals(str2)) {
                    u(str3, eVar);
                } else if ("size".equals(str2)) {
                    eVar.f66853j = i.c(str3);
                } else if ("vertical".equals(str2)) {
                    eVar.f66854k = w(str3);
                } else {
                    s.i("WebvttCueParser", "Unknown cue setting " + str2 + ":" + str3);
                }
            } catch (NumberFormatException unused) {
                s.i("WebvttCueParser", "Skipping bad cue setting: " + matcher.group());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpannedString q(String str, String str2, List list) {
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
                    i12 = f(str2, i12);
                    int i13 = i12 - 2;
                    boolean z11 = str2.charAt(i13) == '/';
                    int i14 = i11 + (z10 ? 2 : 1);
                    if (!z11) {
                        i13 = i12 - 1;
                    }
                    String substring = str2.substring(i14, i13);
                    if (!substring.trim().isEmpty()) {
                        String j11 = j(substring);
                        if (k(j11)) {
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
                                if (cVar.f66838a.equals(j11)) {
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

    private static int r(String str) {
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
                s.i("WebvttCueParser", "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    private static void s(String str, e eVar) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            eVar.f66850g = r(str.substring(indexOf + 1));
            str = str.substring(0, indexOf);
        }
        if (str.endsWith("%")) {
            eVar.f66848e = i.c(str);
            eVar.f66849f = 0;
        } else {
            eVar.f66848e = Integer.parseInt(str);
            eVar.f66849f = 1;
        }
    }

    private static int t(String str) {
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
                s.i("WebvttCueParser", "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    private static void u(String str, e eVar) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            eVar.f66852i = t(str.substring(indexOf + 1));
            str = str.substring(0, indexOf);
        }
        eVar.f66851h = i.c(str);
    }

    private static int v(String str) {
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
                s.i("WebvttCueParser", "Invalid alignment value: " + str);
                return 2;
        }
    }

    private static int w(String str) {
        str.hashCode();
        if (str.equals("lr")) {
            return 2;
        }
        if (str.equals("rl")) {
            return 1;
        }
        s.i("WebvttCueParser", "Invalid 'vertical' value: " + str);
        return Integer.MIN_VALUE;
    }
}
