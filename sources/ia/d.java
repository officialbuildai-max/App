package ia;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import ba.b;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f65227a;

    /* renamed from: b, reason: collision with root package name */
    public final String f65228b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f65229c;

    /* renamed from: d, reason: collision with root package name */
    public final long f65230d;

    /* renamed from: e, reason: collision with root package name */
    public final long f65231e;

    /* renamed from: f, reason: collision with root package name */
    public final g f65232f;

    /* renamed from: g, reason: collision with root package name */
    private final String[] f65233g;

    /* renamed from: h, reason: collision with root package name */
    public final String f65234h;

    /* renamed from: i, reason: collision with root package name */
    public final String f65235i;

    /* renamed from: j, reason: collision with root package name */
    public final d f65236j;

    /* renamed from: k, reason: collision with root package name */
    private final HashMap f65237k;

    /* renamed from: l, reason: collision with root package name */
    private final HashMap f65238l;

    /* renamed from: m, reason: collision with root package name */
    private List f65239m;

    private d(String str, String str2, long j11, long j12, g gVar, String[] strArr, String str3, String str4, d dVar) {
        this.f65227a = str;
        this.f65228b = str2;
        this.f65235i = str4;
        this.f65232f = gVar;
        this.f65233g = strArr;
        this.f65229c = str2 != null;
        this.f65230d = j11;
        this.f65231e = j12;
        this.f65234h = (String) com.google.android.exoplayer2.util.a.e(str3);
        this.f65236j = dVar;
        this.f65237k = new HashMap();
        this.f65238l = new HashMap();
    }

    private void b(Map map, b.C0151b c0151b, int i11, int i12, int i13) {
        g f11 = f.f(this.f65232f, this.f65233g, map);
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) c0151b.e();
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder();
            c0151b.o(spannableStringBuilder);
        }
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        if (f11 != null) {
            f.a(spannableStringBuilder2, i11, i12, f11, this.f65236j, map, i13);
            if (TtmlNode.TAG_P.equals(this.f65227a)) {
                if (f11.k() != Float.MAX_VALUE) {
                    c0151b.m((f11.k() * (-90.0f)) / 100.0f);
                }
                if (f11.m() != null) {
                    c0151b.p(f11.m());
                }
                if (f11.h() != null) {
                    c0151b.j(f11.h());
                }
            }
        }
    }

    public static d c(String str, long j11, long j12, g gVar, String[] strArr, String str2, String str3, d dVar) {
        return new d(str, null, j11, j12, gVar, strArr, str2, str3, dVar);
    }

    public static d d(String str) {
        return new d(null, f.b(str), C.TIME_UNSET, C.TIME_UNSET, null, null, "", null, null);
    }

    private static void e(SpannableStringBuilder spannableStringBuilder) {
        for (a aVar : (a[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), a.class)) {
            spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(aVar), spannableStringBuilder.getSpanEnd(aVar), "");
        }
        for (int i11 = 0; i11 < spannableStringBuilder.length(); i11++) {
            if (spannableStringBuilder.charAt(i11) == ' ') {
                int i12 = i11 + 1;
                int i13 = i12;
                while (i13 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i13) == ' ') {
                    i13++;
                }
                int i14 = i13 - i12;
                if (i14 > 0) {
                    spannableStringBuilder.delete(i11, i14 + i11);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
        }
        for (int i15 = 0; i15 < spannableStringBuilder.length() - 1; i15++) {
            if (spannableStringBuilder.charAt(i15) == '\n') {
                int i16 = i15 + 1;
                if (spannableStringBuilder.charAt(i16) == ' ') {
                    spannableStringBuilder.delete(i16, i15 + 2);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
        for (int i17 = 0; i17 < spannableStringBuilder.length() - 1; i17++) {
            if (spannableStringBuilder.charAt(i17) == ' ') {
                int i18 = i17 + 1;
                if (spannableStringBuilder.charAt(i18) == '\n') {
                    spannableStringBuilder.delete(i17, i18);
                }
            }
        }
        if (spannableStringBuilder.length() <= 0 || spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) != '\n') {
            return;
        }
        spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
    }

    private void i(TreeSet treeSet, boolean z10) {
        boolean equals = TtmlNode.TAG_P.equals(this.f65227a);
        boolean equals2 = TtmlNode.TAG_DIV.equals(this.f65227a);
        if (z10 || equals || (equals2 && this.f65235i != null)) {
            long j11 = this.f65230d;
            if (j11 != C.TIME_UNSET) {
                treeSet.add(Long.valueOf(j11));
            }
            long j12 = this.f65231e;
            if (j12 != C.TIME_UNSET) {
                treeSet.add(Long.valueOf(j12));
            }
        }
        if (this.f65239m == null) {
            return;
        }
        for (int i11 = 0; i11 < this.f65239m.size(); i11++) {
            ((d) this.f65239m.get(i11)).i(treeSet, z10 || equals);
        }
    }

    private static SpannableStringBuilder k(String str, Map map) {
        if (!map.containsKey(str)) {
            b.C0151b c0151b = new b.C0151b();
            c0151b.o(new SpannableStringBuilder());
            map.put(str, c0151b);
        }
        return (SpannableStringBuilder) com.google.android.exoplayer2.util.a.e(((b.C0151b) map.get(str)).e());
    }

    private void n(long j11, String str, List list) {
        if (!"".equals(this.f65234h)) {
            str = this.f65234h;
        }
        if (m(j11) && TtmlNode.TAG_DIV.equals(this.f65227a) && this.f65235i != null) {
            list.add(new Pair(str, this.f65235i));
            return;
        }
        for (int i11 = 0; i11 < g(); i11++) {
            f(i11).n(j11, str, list);
        }
    }

    private void o(long j11, Map map, Map map2, String str, Map map3) {
        int i11;
        if (m(j11)) {
            String str2 = "".equals(this.f65234h) ? str : this.f65234h;
            Iterator it = this.f65238l.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String str3 = (String) entry.getKey();
                int intValue = this.f65237k.containsKey(str3) ? ((Integer) this.f65237k.get(str3)).intValue() : 0;
                int intValue2 = ((Integer) entry.getValue()).intValue();
                if (intValue != intValue2) {
                    b(map, (b.C0151b) com.google.android.exoplayer2.util.a.e((b.C0151b) map3.get(str3)), intValue, intValue2, ((e) com.google.android.exoplayer2.util.a.e((e) map2.get(str2))).f65249j);
                }
            }
            while (i11 < g()) {
                f(i11).o(j11, map, map2, str2, map3);
                i11++;
            }
        }
    }

    private void p(long j11, boolean z10, String str, Map map) {
        this.f65237k.clear();
        this.f65238l.clear();
        if (TtmlNode.TAG_METADATA.equals(this.f65227a)) {
            return;
        }
        if (!"".equals(this.f65234h)) {
            str = this.f65234h;
        }
        if (this.f65229c && z10) {
            k(str, map).append((CharSequence) com.google.android.exoplayer2.util.a.e(this.f65228b));
            return;
        }
        if (TtmlNode.TAG_BR.equals(this.f65227a) && z10) {
            k(str, map).append('\n');
            return;
        }
        if (m(j11)) {
            for (Map.Entry entry : map.entrySet()) {
                this.f65237k.put((String) entry.getKey(), Integer.valueOf(((CharSequence) com.google.android.exoplayer2.util.a.e(((b.C0151b) entry.getValue()).e())).length()));
            }
            boolean equals = TtmlNode.TAG_P.equals(this.f65227a);
            for (int i11 = 0; i11 < g(); i11++) {
                f(i11).p(j11, z10 || equals, str, map);
            }
            if (equals) {
                f.c(k(str, map));
            }
            for (Map.Entry entry2 : map.entrySet()) {
                this.f65238l.put((String) entry2.getKey(), Integer.valueOf(((CharSequence) com.google.android.exoplayer2.util.a.e(((b.C0151b) entry2.getValue()).e())).length()));
            }
        }
    }

    public void a(d dVar) {
        if (this.f65239m == null) {
            this.f65239m = new ArrayList();
        }
        this.f65239m.add(dVar);
    }

    public d f(int i11) {
        List list = this.f65239m;
        if (list != null) {
            return (d) list.get(i11);
        }
        throw new IndexOutOfBoundsException();
    }

    public int g() {
        List list = this.f65239m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List h(long j11, Map map, Map map2, Map map3) {
        List<Pair> arrayList = new ArrayList();
        n(j11, this.f65234h, arrayList);
        TreeMap treeMap = new TreeMap();
        p(j11, false, this.f65234h, treeMap);
        o(j11, map, map2, this.f65234h, treeMap);
        ArrayList arrayList2 = new ArrayList();
        for (Pair pair : arrayList) {
            String str = (String) map3.get(pair.second);
            if (str != null) {
                byte[] decode = Base64.decode(str, 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                e eVar = (e) com.google.android.exoplayer2.util.a.e((e) map2.get(pair.first));
                arrayList2.add(new b.C0151b().f(decodeByteArray).k(eVar.f65241b).l(0).h(eVar.f65242c, 0).i(eVar.f65244e).n(eVar.f65245f).g(eVar.f65246g).r(eVar.f65249j).a());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            e eVar2 = (e) com.google.android.exoplayer2.util.a.e((e) map2.get(entry.getKey()));
            b.C0151b c0151b = (b.C0151b) entry.getValue();
            e((SpannableStringBuilder) com.google.android.exoplayer2.util.a.e(c0151b.e()));
            c0151b.h(eVar2.f65242c, eVar2.f65243d);
            c0151b.i(eVar2.f65244e);
            c0151b.k(eVar2.f65241b);
            c0151b.n(eVar2.f65245f);
            c0151b.q(eVar2.f65248i, eVar2.f65247h);
            c0151b.r(eVar2.f65249j);
            arrayList2.add(c0151b.a());
        }
        return arrayList2;
    }

    public long[] j() {
        TreeSet treeSet = new TreeSet();
        int i11 = 0;
        i(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i11] = ((Long) it.next()).longValue();
            i11++;
        }
        return jArr;
    }

    public String[] l() {
        return this.f65233g;
    }

    public boolean m(long j11) {
        long j12 = this.f65230d;
        return (j12 == C.TIME_UNSET && this.f65231e == C.TIME_UNSET) || (j12 <= j11 && this.f65231e == C.TIME_UNSET) || ((j12 == C.TIME_UNSET && j11 < this.f65231e) || (j12 <= j11 && j11 < this.f65231e));
    }
}
