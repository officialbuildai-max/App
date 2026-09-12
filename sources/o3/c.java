package o3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import u1.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f70787a;

    /* renamed from: b, reason: collision with root package name */
    public final String f70788b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f70789c;

    /* renamed from: d, reason: collision with root package name */
    public final long f70790d;

    /* renamed from: e, reason: collision with root package name */
    public final long f70791e;

    /* renamed from: f, reason: collision with root package name */
    public final g f70792f;

    /* renamed from: g, reason: collision with root package name */
    private final String[] f70793g;

    /* renamed from: h, reason: collision with root package name */
    public final String f70794h;

    /* renamed from: i, reason: collision with root package name */
    public final String f70795i;

    /* renamed from: j, reason: collision with root package name */
    public final c f70796j;

    /* renamed from: k, reason: collision with root package name */
    private final HashMap f70797k;

    /* renamed from: l, reason: collision with root package name */
    private final HashMap f70798l;

    /* renamed from: m, reason: collision with root package name */
    private List f70799m;

    private c(String str, String str2, long j11, long j12, g gVar, String[] strArr, String str3, String str4, c cVar) {
        this.f70787a = str;
        this.f70788b = str2;
        this.f70795i = str4;
        this.f70792f = gVar;
        this.f70793g = strArr;
        this.f70789c = str2 != null;
        this.f70790d = j11;
        this.f70791e = j12;
        this.f70794h = (String) androidx.media3.common.util.a.e(str3);
        this.f70796j = cVar;
        this.f70797k = new HashMap();
        this.f70798l = new HashMap();
    }

    private void b(Map map, a.b bVar, int i11, int i12, int i13) {
        g f11 = f.f(this.f70792f, this.f70793g, map);
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) bVar.e();
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder();
            bVar.o(spannableStringBuilder);
        }
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        if (f11 != null) {
            f.a(spannableStringBuilder2, i11, i12, f11, this.f70796j, map, i13);
            if (TtmlNode.TAG_P.equals(this.f70787a)) {
                if (f11.m() != Float.MAX_VALUE) {
                    bVar.m((f11.m() * (-90.0f)) / 100.0f);
                }
                if (f11.o() != null) {
                    bVar.p(f11.o());
                }
                if (f11.i() != null) {
                    bVar.j(f11.i());
                }
            }
        }
    }

    public static c c(String str, long j11, long j12, g gVar, String[] strArr, String str2, String str3, c cVar) {
        return new c(str, null, j11, j12, gVar, strArr, str2, str3, cVar);
    }

    public static c d(String str) {
        return new c(null, f.b(str), C.TIME_UNSET, C.TIME_UNSET, null, null, "", null, null);
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
        boolean equals = TtmlNode.TAG_P.equals(this.f70787a);
        boolean equals2 = TtmlNode.TAG_DIV.equals(this.f70787a);
        if (z10 || equals || (equals2 && this.f70795i != null)) {
            long j11 = this.f70790d;
            if (j11 != C.TIME_UNSET) {
                treeSet.add(Long.valueOf(j11));
            }
            long j12 = this.f70791e;
            if (j12 != C.TIME_UNSET) {
                treeSet.add(Long.valueOf(j12));
            }
        }
        if (this.f70799m == null) {
            return;
        }
        for (int i11 = 0; i11 < this.f70799m.size(); i11++) {
            ((c) this.f70799m.get(i11)).i(treeSet, z10 || equals);
        }
    }

    private static SpannableStringBuilder k(String str, Map map) {
        if (!map.containsKey(str)) {
            a.b bVar = new a.b();
            bVar.o(new SpannableStringBuilder());
            map.put(str, bVar);
        }
        return (SpannableStringBuilder) androidx.media3.common.util.a.e(((a.b) map.get(str)).e());
    }

    private void n(long j11, String str, List list) {
        if (!"".equals(this.f70794h)) {
            str = this.f70794h;
        }
        if (m(j11) && TtmlNode.TAG_DIV.equals(this.f70787a) && this.f70795i != null) {
            list.add(new Pair(str, this.f70795i));
            return;
        }
        for (int i11 = 0; i11 < g(); i11++) {
            f(i11).n(j11, str, list);
        }
    }

    private void o(long j11, Map map, Map map2, String str, Map map3) {
        int i11;
        if (m(j11)) {
            String str2 = "".equals(this.f70794h) ? str : this.f70794h;
            Iterator it = this.f70798l.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String str3 = (String) entry.getKey();
                int intValue = this.f70797k.containsKey(str3) ? ((Integer) this.f70797k.get(str3)).intValue() : 0;
                int intValue2 = ((Integer) entry.getValue()).intValue();
                if (intValue != intValue2) {
                    b(map, (a.b) androidx.media3.common.util.a.e((a.b) map3.get(str3)), intValue, intValue2, ((e) androidx.media3.common.util.a.e((e) map2.get(str2))).f70823j);
                }
            }
            while (i11 < g()) {
                f(i11).o(j11, map, map2, str2, map3);
                i11++;
            }
        }
    }

    private void p(long j11, boolean z10, String str, Map map) {
        this.f70797k.clear();
        this.f70798l.clear();
        if (TtmlNode.TAG_METADATA.equals(this.f70787a)) {
            return;
        }
        if (!"".equals(this.f70794h)) {
            str = this.f70794h;
        }
        if (this.f70789c && z10) {
            k(str, map).append((CharSequence) androidx.media3.common.util.a.e(this.f70788b));
            return;
        }
        if (TtmlNode.TAG_BR.equals(this.f70787a) && z10) {
            k(str, map).append('\n');
            return;
        }
        if (m(j11)) {
            for (Map.Entry entry : map.entrySet()) {
                this.f70797k.put((String) entry.getKey(), Integer.valueOf(((CharSequence) androidx.media3.common.util.a.e(((a.b) entry.getValue()).e())).length()));
            }
            boolean equals = TtmlNode.TAG_P.equals(this.f70787a);
            for (int i11 = 0; i11 < g(); i11++) {
                f(i11).p(j11, z10 || equals, str, map);
            }
            if (equals) {
                f.c(k(str, map));
            }
            for (Map.Entry entry2 : map.entrySet()) {
                this.f70798l.put((String) entry2.getKey(), Integer.valueOf(((CharSequence) androidx.media3.common.util.a.e(((a.b) entry2.getValue()).e())).length()));
            }
        }
    }

    public void a(c cVar) {
        if (this.f70799m == null) {
            this.f70799m = new ArrayList();
        }
        this.f70799m.add(cVar);
    }

    public c f(int i11) {
        List list = this.f70799m;
        if (list != null) {
            return (c) list.get(i11);
        }
        throw new IndexOutOfBoundsException();
    }

    public int g() {
        List list = this.f70799m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List h(long j11, Map map, Map map2, Map map3) {
        List<Pair> arrayList = new ArrayList();
        n(j11, this.f70794h, arrayList);
        TreeMap treeMap = new TreeMap();
        p(j11, false, this.f70794h, treeMap);
        o(j11, map, map2, this.f70794h, treeMap);
        ArrayList arrayList2 = new ArrayList();
        for (Pair pair : arrayList) {
            String str = (String) map3.get(pair.second);
            if (str != null) {
                byte[] decode = Base64.decode(str, 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                e eVar = (e) androidx.media3.common.util.a.e((e) map2.get(pair.first));
                arrayList2.add(new a.b().f(decodeByteArray).k(eVar.f70815b).l(0).h(eVar.f70816c, 0).i(eVar.f70818e).n(eVar.f70819f).g(eVar.f70820g).r(eVar.f70823j).a());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            e eVar2 = (e) androidx.media3.common.util.a.e((e) map2.get(entry.getKey()));
            a.b bVar = (a.b) entry.getValue();
            e((SpannableStringBuilder) androidx.media3.common.util.a.e(bVar.e()));
            bVar.h(eVar2.f70816c, eVar2.f70817d);
            bVar.i(eVar2.f70818e);
            bVar.k(eVar2.f70815b);
            bVar.n(eVar2.f70819f);
            bVar.q(eVar2.f70822i, eVar2.f70821h);
            bVar.r(eVar2.f70823j);
            arrayList2.add(bVar.a());
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
        return this.f70793g;
    }

    public boolean m(long j11) {
        long j12 = this.f70790d;
        return (j12 == C.TIME_UNSET && this.f70791e == C.TIME_UNSET) || (j12 <= j11 && this.f70791e == C.TIME_UNSET) || ((j12 == C.TIME_UNSET && j11 < this.f70791e) || (j12 <= j11 && j11 < this.f70791e));
    }
}
