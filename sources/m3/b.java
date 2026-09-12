package m3;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.j0;
import androidx.media3.common.util.m;
import androidx.media3.common.util.u;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import i3.e;
import i3.k;
import i3.r;
import i3.s;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import m3.c;
import u1.a;

/* loaded from: classes2.dex */
public final class b implements s {

    /* renamed from: g, reason: collision with root package name */
    private static final Pattern f69251g = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");

    /* renamed from: a, reason: collision with root package name */
    private final boolean f69252a;

    /* renamed from: b, reason: collision with root package name */
    private final a f69253b;

    /* renamed from: c, reason: collision with root package name */
    private final j0 f69254c;

    /* renamed from: d, reason: collision with root package name */
    private Map f69255d;

    /* renamed from: e, reason: collision with root package name */
    private float f69256e;

    /* renamed from: f, reason: collision with root package name */
    private float f69257f;

    public b() {
        this(null);
    }

    public b(List list) {
        this.f69256e = -3.4028235E38f;
        this.f69257f = -3.4028235E38f;
        this.f69254c = new j0();
        if (list == null || list.isEmpty()) {
            this.f69252a = false;
            this.f69253b = null;
            return;
        }
        this.f69252a = true;
        String H = a1.H((byte[]) list.get(0));
        androidx.media3.common.util.a.a(H.startsWith("Format:"));
        this.f69253b = (a) androidx.media3.common.util.a.e(a.a(H));
        j(new j0((byte[]) list.get(1)), StandardCharsets.UTF_8);
    }

    private static int d(long j11, List list, List list2) {
        int i11;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                i11 = 0;
                break;
            }
            if (((Long) list.get(size)).longValue() == j11) {
                return size;
            }
            if (((Long) list.get(size)).longValue() < j11) {
                i11 = size + 1;
                break;
            }
            size--;
        }
        list.add(i11, Long.valueOf(j11));
        list2.add(i11, i11 == 0 ? new ArrayList() : new ArrayList((Collection) list2.get(i11 - 1)));
        return i11;
    }

    private static float e(int i11) {
        if (i11 == 0) {
            return 0.05f;
        }
        if (i11 != 1) {
            return i11 != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    private static u1.a f(String str, c cVar, c.b bVar, float f11, float f12) {
        SpannableString spannableString = new SpannableString(str);
        a.b o11 = new a.b().o(spannableString);
        if (cVar != null) {
            if (cVar.f69260c != null) {
                spannableString.setSpan(new ForegroundColorSpan(cVar.f69260c.intValue()), 0, spannableString.length(), 33);
            }
            if (cVar.f69267j == 3 && cVar.f69261d != null) {
                spannableString.setSpan(new BackgroundColorSpan(cVar.f69261d.intValue()), 0, spannableString.length(), 33);
            }
            float f13 = cVar.f69262e;
            if (f13 != -3.4028235E38f && f12 != -3.4028235E38f) {
                o11.q(f13 / f12, 1);
            }
            boolean z10 = cVar.f69263f;
            if (z10 && cVar.f69264g) {
                spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
            } else if (z10) {
                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
            } else if (cVar.f69264g) {
                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
            }
            if (cVar.f69265h) {
                spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 33);
            }
            if (cVar.f69266i) {
                spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            }
        }
        int i11 = bVar.f69283a;
        if (i11 == -1) {
            i11 = cVar != null ? cVar.f69259b : -1;
        }
        o11.p(p(i11)).l(o(i11)).i(n(i11));
        PointF pointF = bVar.f69284b;
        if (pointF == null || f12 == -3.4028235E38f || f11 == -3.4028235E38f) {
            o11.k(e(o11.d()));
            o11.h(e(o11.c()), 0);
        } else {
            o11.k(pointF.x / f11);
            o11.h(bVar.f69284b.y / f12, 0);
        }
        return o11.a();
    }

    private Charset g(j0 j0Var) {
        Charset R = j0Var.R();
        return R != null ? R : StandardCharsets.UTF_8;
    }

    private void h(String str, a aVar, List list, List list2) {
        int i11;
        androidx.media3.common.util.a.a(str.startsWith("Dialogue:"));
        String[] split = str.substring(9).split(",", aVar.f69250e);
        if (split.length != aVar.f69250e) {
            u.h("SsaParser", "Skipping dialogue line with fewer columns than format: " + str);
            return;
        }
        long m11 = m(split[aVar.f69246a]);
        if (m11 == C.TIME_UNSET) {
            u.h("SsaParser", "Skipping invalid timing: " + str);
            return;
        }
        long m12 = m(split[aVar.f69247b]);
        if (m12 == C.TIME_UNSET || m12 <= m11) {
            u.h("SsaParser", "Skipping invalid timing: " + str);
            return;
        }
        Map map = this.f69255d;
        c cVar = (map == null || (i11 = aVar.f69248c) == -1) ? null : (c) map.get(split[i11].trim());
        String str2 = split[aVar.f69249d];
        u1.a f11 = f(c.b.d(str2).replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " "), cVar, c.b.b(str2), this.f69256e, this.f69257f);
        int d11 = d(m12, list2, list);
        for (int d12 = d(m11, list2, list); d12 < d11; d12++) {
            ((List) list.get(d12)).add(f11);
        }
    }

    private void i(j0 j0Var, List list, List list2, Charset charset) {
        a aVar = this.f69252a ? this.f69253b : null;
        while (true) {
            String t11 = j0Var.t(charset);
            if (t11 == null) {
                return;
            }
            if (t11.startsWith("Format:")) {
                aVar = a.a(t11);
            } else if (t11.startsWith("Dialogue:")) {
                if (aVar == null) {
                    u.h("SsaParser", "Skipping dialogue line before complete format: " + t11);
                } else {
                    h(t11, aVar, list, list2);
                }
            }
        }
    }

    private void j(j0 j0Var, Charset charset) {
        while (true) {
            String t11 = j0Var.t(charset);
            if (t11 == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(t11)) {
                k(j0Var, charset);
            } else if ("[V4+ Styles]".equalsIgnoreCase(t11)) {
                this.f69255d = l(j0Var, charset);
            } else if ("[V4 Styles]".equalsIgnoreCase(t11)) {
                u.f("SsaParser", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(t11)) {
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:3:0x0006  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void k(androidx.media3.common.util.j0 r5, java.nio.charset.Charset r6) {
        /*
            r4 = this;
        L0:
            java.lang.String r0 = r5.t(r6)
            if (r0 == 0) goto L59
            int r1 = r5.a()
            if (r1 == 0) goto L14
            char r1 = r5.h(r6)
            r2 = 91
            if (r1 == r2) goto L59
        L14:
            java.lang.String r1 = ":"
            java.lang.String[] r0 = r0.split(r1)
            int r1 = r0.length
            r2 = 2
            if (r1 == r2) goto L1f
            goto L0
        L1f:
            r1 = 0
            r1 = r0[r1]
            java.lang.String r1 = r1.trim()
            java.lang.String r1 = com.google.common.base.a.e(r1)
            r1.hashCode()
            r2 = 1
            java.lang.String r3 = "playresx"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L4c
            java.lang.String r3 = "playresy"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L3f
            goto L0
        L3f:
            r0 = r0[r2]     // Catch: java.lang.NumberFormatException -> L0
            java.lang.String r0 = r0.trim()     // Catch: java.lang.NumberFormatException -> L0
            float r0 = java.lang.Float.parseFloat(r0)     // Catch: java.lang.NumberFormatException -> L0
            r4.f69257f = r0     // Catch: java.lang.NumberFormatException -> L0
            goto L0
        L4c:
            r0 = r0[r2]     // Catch: java.lang.NumberFormatException -> L0
            java.lang.String r0 = r0.trim()     // Catch: java.lang.NumberFormatException -> L0
            float r0 = java.lang.Float.parseFloat(r0)     // Catch: java.lang.NumberFormatException -> L0
            r4.f69256e = r0     // Catch: java.lang.NumberFormatException -> L0
            goto L0
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m3.b.k(androidx.media3.common.util.j0, java.nio.charset.Charset):void");
    }

    private static Map l(j0 j0Var, Charset charset) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        c.a aVar = null;
        while (true) {
            String t11 = j0Var.t(charset);
            if (t11 == null || (j0Var.a() != 0 && j0Var.h(charset) == '[')) {
                break;
            }
            if (t11.startsWith("Format:")) {
                aVar = c.a.a(t11);
            } else if (t11.startsWith("Style:")) {
                if (aVar == null) {
                    u.h("SsaParser", "Skipping 'Style:' line before 'Format:' line: " + t11);
                } else {
                    c b11 = c.b(t11, aVar);
                    if (b11 != null) {
                        linkedHashMap.put(b11.f69258a, b11);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    private static long m(String str) {
        Matcher matcher = f69251g.matcher(str.trim());
        return !matcher.matches() ? C.TIME_UNSET : (Long.parseLong((String) a1.i(matcher.group(1))) * 3600000000L) + (Long.parseLong((String) a1.i(matcher.group(2))) * 60000000) + (Long.parseLong((String) a1.i(matcher.group(3))) * 1000000) + (Long.parseLong((String) a1.i(matcher.group(4))) * 10000);
    }

    private static int n(int i11) {
        switch (i11) {
            case -1:
                return Integer.MIN_VALUE;
            case 0:
            default:
                u.h("SsaParser", "Unknown alignment: " + i11);
                return Integer.MIN_VALUE;
            case 1:
            case 2:
            case 3:
                return 2;
            case 4:
            case 5:
            case 6:
                return 1;
            case 7:
            case 8:
            case 9:
                return 0;
        }
    }

    private static int o(int i11) {
        switch (i11) {
            case -1:
                return Integer.MIN_VALUE;
            case 0:
            default:
                u.h("SsaParser", "Unknown alignment: " + i11);
                return Integer.MIN_VALUE;
            case 1:
            case 4:
            case 7:
                return 0;
            case 2:
            case 5:
            case 8:
                return 1;
            case 3:
            case 6:
            case 9:
                return 2;
        }
    }

    private static Layout.Alignment p(int i11) {
        switch (i11) {
            case -1:
                return null;
            case 0:
            default:
                u.h("SsaParser", "Unknown alignment: " + i11);
                return null;
            case 1:
            case 4:
            case 7:
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
            case 5:
            case 8:
                return Layout.Alignment.ALIGN_CENTER;
            case 3:
            case 6:
            case 9:
                return Layout.Alignment.ALIGN_OPPOSITE;
        }
    }

    @Override // i3.s
    public void a(byte[] bArr, int i11, int i12, s.b bVar, m mVar) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        this.f69254c.U(bArr, i11 + i12);
        this.f69254c.W(i11);
        Charset g11 = g(this.f69254c);
        if (!this.f69252a) {
            j(this.f69254c, g11);
        }
        i(this.f69254c, arrayList3, arrayList4, g11);
        ArrayList arrayList5 = (bVar.f65048a == C.TIME_UNSET || !bVar.f65049b) ? null : new ArrayList();
        int i13 = 0;
        while (i13 < arrayList3.size()) {
            List list = (List) arrayList3.get(i13);
            if (list.isEmpty() && i13 != 0) {
                arrayList = arrayList3;
                arrayList2 = arrayList4;
            } else {
                if (i13 == arrayList3.size() - 1) {
                    throw new IllegalStateException();
                }
                long longValue = ((Long) arrayList4.get(i13)).longValue();
                long longValue2 = ((Long) arrayList4.get(i13 + 1)).longValue() - ((Long) arrayList4.get(i13)).longValue();
                arrayList = arrayList3;
                arrayList2 = arrayList4;
                long j11 = bVar.f65048a;
                if (j11 == C.TIME_UNSET || longValue >= j11) {
                    mVar.accept(new e(list, longValue, longValue2));
                } else if (arrayList5 != null) {
                    arrayList5.add(new e(list, longValue, longValue2));
                }
            }
            i13++;
            arrayList3 = arrayList;
            arrayList4 = arrayList2;
        }
        if (arrayList5 != null) {
            Iterator it = arrayList5.iterator();
            while (it.hasNext()) {
                mVar.accept((e) it.next());
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
