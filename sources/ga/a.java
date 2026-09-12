package ga;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import ba.b;
import ba.h;
import ba.i;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import ga.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class a extends h {

    /* renamed from: t, reason: collision with root package name */
    private static final Pattern f63605t = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");

    /* renamed from: o, reason: collision with root package name */
    private final boolean f63606o;

    /* renamed from: p, reason: collision with root package name */
    private final b f63607p;

    /* renamed from: q, reason: collision with root package name */
    private Map f63608q;

    /* renamed from: r, reason: collision with root package name */
    private float f63609r;

    /* renamed from: s, reason: collision with root package name */
    private float f63610s;

    public a() {
        this(null);
    }

    public a(List list) {
        super("SsaDecoder");
        this.f63609r = -3.4028235E38f;
        this.f63610s = -3.4028235E38f;
        if (list == null || list.isEmpty()) {
            this.f63606o = false;
            this.f63607p = null;
            return;
        }
        this.f63606o = true;
        String D = p0.D((byte[]) list.get(0));
        com.google.android.exoplayer2.util.a.a(D.startsWith("Format:"));
        this.f63607p = (b) com.google.android.exoplayer2.util.a.e(b.a(D));
        C(new d0((byte[]) list.get(1)));
    }

    private void A(String str, b bVar, List list, List list2) {
        int i11;
        com.google.android.exoplayer2.util.a.a(str.startsWith("Dialogue:"));
        String[] split = str.substring(9).split(",", bVar.f63615e);
        if (split.length != bVar.f63615e) {
            s.i("SsaDecoder", "Skipping dialogue line with fewer columns than format: " + str);
            return;
        }
        long F = F(split[bVar.f63611a]);
        if (F == C.TIME_UNSET) {
            s.i("SsaDecoder", "Skipping invalid timing: " + str);
            return;
        }
        long F2 = F(split[bVar.f63612b]);
        if (F2 == C.TIME_UNSET) {
            s.i("SsaDecoder", "Skipping invalid timing: " + str);
            return;
        }
        Map map = this.f63608q;
        c cVar = (map == null || (i11 = bVar.f63613c) == -1) ? null : (c) map.get(split[i11].trim());
        String str2 = split[bVar.f63614d];
        ba.b z10 = z(c.b.d(str2).replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " "), cVar, c.b.b(str2), this.f63609r, this.f63610s);
        int x10 = x(F2, list2, list);
        for (int x11 = x(F, list2, list); x11 < x10; x11++) {
            ((List) list.get(x11)).add(z10);
        }
    }

    private void B(d0 d0Var, List list, List list2) {
        b bVar = this.f63606o ? this.f63607p : null;
        while (true) {
            String p11 = d0Var.p();
            if (p11 == null) {
                return;
            }
            if (p11.startsWith("Format:")) {
                bVar = b.a(p11);
            } else if (p11.startsWith("Dialogue:")) {
                if (bVar == null) {
                    s.i("SsaDecoder", "Skipping dialogue line before complete format: " + p11);
                } else {
                    A(p11, bVar, list, list2);
                }
            }
        }
    }

    private void C(d0 d0Var) {
        while (true) {
            String p11 = d0Var.p();
            if (p11 == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(p11)) {
                D(d0Var);
            } else if ("[V4+ Styles]".equalsIgnoreCase(p11)) {
                this.f63608q = E(d0Var);
            } else if ("[V4 Styles]".equalsIgnoreCase(p11)) {
                s.f("SsaDecoder", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(p11)) {
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
    private void D(com.google.android.exoplayer2.util.d0 r5) {
        /*
            r4 = this;
        L0:
            java.lang.String r0 = r5.p()
            if (r0 == 0) goto L59
            int r1 = r5.a()
            if (r1 == 0) goto L14
            int r1 = r5.h()
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
            r4.f63610s = r0     // Catch: java.lang.NumberFormatException -> L0
            goto L0
        L4c:
            r0 = r0[r2]     // Catch: java.lang.NumberFormatException -> L0
            java.lang.String r0 = r0.trim()     // Catch: java.lang.NumberFormatException -> L0
            float r0 = java.lang.Float.parseFloat(r0)     // Catch: java.lang.NumberFormatException -> L0
            r4.f63609r = r0     // Catch: java.lang.NumberFormatException -> L0
            goto L0
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ga.a.D(com.google.android.exoplayer2.util.d0):void");
    }

    private static Map E(d0 d0Var) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        c.a aVar = null;
        while (true) {
            String p11 = d0Var.p();
            if (p11 == null || (d0Var.a() != 0 && d0Var.h() == 91)) {
                break;
            }
            if (p11.startsWith("Format:")) {
                aVar = c.a.a(p11);
            } else if (p11.startsWith("Style:")) {
                if (aVar == null) {
                    s.i("SsaDecoder", "Skipping 'Style:' line before 'Format:' line: " + p11);
                } else {
                    c b11 = c.b(p11, aVar);
                    if (b11 != null) {
                        linkedHashMap.put(b11.f63616a, b11);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    private static long F(String str) {
        Matcher matcher = f63605t.matcher(str.trim());
        return !matcher.matches() ? C.TIME_UNSET : (Long.parseLong((String) p0.j(matcher.group(1))) * 3600000000L) + (Long.parseLong((String) p0.j(matcher.group(2))) * 60000000) + (Long.parseLong((String) p0.j(matcher.group(3))) * 1000000) + (Long.parseLong((String) p0.j(matcher.group(4))) * 10000);
    }

    private static int G(int i11) {
        switch (i11) {
            case -1:
                return Integer.MIN_VALUE;
            case 0:
            default:
                s.i("SsaDecoder", "Unknown alignment: " + i11);
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

    private static int H(int i11) {
        switch (i11) {
            case -1:
                return Integer.MIN_VALUE;
            case 0:
            default:
                s.i("SsaDecoder", "Unknown alignment: " + i11);
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

    private static Layout.Alignment I(int i11) {
        switch (i11) {
            case -1:
                return null;
            case 0:
            default:
                s.i("SsaDecoder", "Unknown alignment: " + i11);
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

    private static int x(long j11, List list, List list2) {
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

    private static float y(int i11) {
        if (i11 == 0) {
            return 0.05f;
        }
        if (i11 != 1) {
            return i11 != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    private static ba.b z(String str, c cVar, c.b bVar, float f11, float f12) {
        SpannableString spannableString = new SpannableString(str);
        b.C0151b o11 = new b.C0151b().o(spannableString);
        if (cVar != null) {
            if (cVar.f63618c != null) {
                spannableString.setSpan(new ForegroundColorSpan(cVar.f63618c.intValue()), 0, spannableString.length(), 33);
            }
            if (cVar.f63625j == 3 && cVar.f63619d != null) {
                spannableString.setSpan(new BackgroundColorSpan(cVar.f63619d.intValue()), 0, spannableString.length(), 33);
            }
            float f13 = cVar.f63620e;
            if (f13 != -3.4028235E38f && f12 != -3.4028235E38f) {
                o11.q(f13 / f12, 1);
            }
            boolean z10 = cVar.f63621f;
            if (z10 && cVar.f63622g) {
                spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
            } else if (z10) {
                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
            } else if (cVar.f63622g) {
                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
            }
            if (cVar.f63623h) {
                spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 33);
            }
            if (cVar.f63624i) {
                spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            }
        }
        int i11 = bVar.f63641a;
        if (i11 == -1) {
            i11 = cVar != null ? cVar.f63617b : -1;
        }
        o11.p(I(i11)).l(H(i11)).i(G(i11));
        PointF pointF = bVar.f63642b;
        if (pointF == null || f12 == -3.4028235E38f || f11 == -3.4028235E38f) {
            o11.k(y(o11.d()));
            o11.h(y(o11.c()), 0);
        } else {
            o11.k(pointF.x / f11);
            o11.h(bVar.f63642b.y / f12, 0);
        }
        return o11.a();
    }

    @Override // ba.h
    protected i v(byte[] bArr, int i11, boolean z10) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        d0 d0Var = new d0(bArr, i11);
        if (!this.f63606o) {
            C(d0Var);
        }
        B(d0Var, arrayList, arrayList2);
        return new d(arrayList, arrayList2);
    }
}
