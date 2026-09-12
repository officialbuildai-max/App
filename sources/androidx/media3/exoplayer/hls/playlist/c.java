package androidx.media3.exoplayer.hls.playlist;

import android.net.Uri;
import androidx.media3.common.DrmInitData;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.g3;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class c extends c2.d {

    /* renamed from: d, reason: collision with root package name */
    public final int f11953d;

    /* renamed from: e, reason: collision with root package name */
    public final long f11954e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f11955f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f11956g;

    /* renamed from: h, reason: collision with root package name */
    public final long f11957h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f11958i;

    /* renamed from: j, reason: collision with root package name */
    public final int f11959j;

    /* renamed from: k, reason: collision with root package name */
    public final long f11960k;

    /* renamed from: l, reason: collision with root package name */
    public final int f11961l;

    /* renamed from: m, reason: collision with root package name */
    public final long f11962m;

    /* renamed from: n, reason: collision with root package name */
    public final long f11963n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f11964o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f11965p;

    /* renamed from: q, reason: collision with root package name */
    public final DrmInitData f11966q;

    /* renamed from: r, reason: collision with root package name */
    public final List f11967r;

    /* renamed from: s, reason: collision with root package name */
    public final List f11968s;

    /* renamed from: t, reason: collision with root package name */
    public final Map f11969t;

    /* renamed from: u, reason: collision with root package name */
    public final long f11970u;

    /* renamed from: v, reason: collision with root package name */
    public final h f11971v;

    /* renamed from: w, reason: collision with root package name */
    public final ImmutableList f11972w;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f11973a;

        /* renamed from: b, reason: collision with root package name */
        public final int f11974b;

        /* renamed from: c, reason: collision with root package name */
        private final double f11975c;

        /* renamed from: d, reason: collision with root package name */
        private final String f11976d;

        public b(String str, double d11) {
            this.f11973a = str;
            this.f11974b = 2;
            this.f11975c = d11;
            this.f11976d = null;
        }

        public b(String str, String str2, int i11) {
            boolean z10 = true;
            if (i11 == 1 && !str2.startsWith("0x") && !str2.startsWith("0X")) {
                z10 = false;
            }
            androidx.media3.common.util.a.g(z10);
            this.f11973a = str;
            this.f11974b = i11;
            this.f11976d = str2;
            this.f11975c = 0.0d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f11974b == bVar.f11974b && Double.compare(this.f11975c, bVar.f11975c) == 0 && Objects.equals(this.f11973a, bVar.f11973a) && Objects.equals(this.f11976d, bVar.f11976d);
        }

        public int hashCode() {
            return Objects.hash(this.f11973a, Integer.valueOf(this.f11974b), Double.valueOf(this.f11975c), this.f11976d);
        }
    }

    /* renamed from: androidx.media3.exoplayer.hls.playlist.c$c, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0107c {

        /* renamed from: a, reason: collision with root package name */
        public final String f11977a;

        /* renamed from: b, reason: collision with root package name */
        public final Uri f11978b;

        /* renamed from: c, reason: collision with root package name */
        public final Uri f11979c;

        /* renamed from: d, reason: collision with root package name */
        public final long f11980d;

        /* renamed from: e, reason: collision with root package name */
        public final long f11981e;

        /* renamed from: f, reason: collision with root package name */
        public final long f11982f;

        /* renamed from: g, reason: collision with root package name */
        public final long f11983g;

        /* renamed from: h, reason: collision with root package name */
        public final List f11984h;

        /* renamed from: i, reason: collision with root package name */
        public final boolean f11985i;

        /* renamed from: j, reason: collision with root package name */
        public final long f11986j;

        /* renamed from: k, reason: collision with root package name */
        public final long f11987k;

        /* renamed from: l, reason: collision with root package name */
        public final ImmutableList f11988l;

        /* renamed from: m, reason: collision with root package name */
        public final ImmutableList f11989m;

        /* renamed from: n, reason: collision with root package name */
        public final ImmutableList f11990n;

        public C0107c(String str, Uri uri, Uri uri2, long j11, long j12, long j13, long j14, List list, boolean z10, long j15, long j16, List list2, List list3, List list4) {
            androidx.media3.common.util.a.a((uri == null || uri2 == null) && !(uri == null && uri2 == null));
            this.f11977a = str;
            this.f11978b = uri;
            this.f11979c = uri2;
            this.f11980d = j11;
            this.f11981e = j12;
            this.f11982f = j13;
            this.f11983g = j14;
            this.f11984h = list;
            this.f11985i = z10;
            this.f11986j = j15;
            this.f11987k = j16;
            this.f11988l = ImmutableList.copyOf((Collection) list2);
            this.f11989m = ImmutableList.copyOf((Collection) list3);
            this.f11990n = ImmutableList.copyOf((Collection) list4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0107c)) {
                return false;
            }
            C0107c c0107c = (C0107c) obj;
            return this.f11980d == c0107c.f11980d && this.f11981e == c0107c.f11981e && this.f11982f == c0107c.f11982f && this.f11983g == c0107c.f11983g && this.f11985i == c0107c.f11985i && this.f11986j == c0107c.f11986j && this.f11987k == c0107c.f11987k && Objects.equals(this.f11977a, c0107c.f11977a) && Objects.equals(this.f11978b, c0107c.f11978b) && Objects.equals(this.f11979c, c0107c.f11979c) && Objects.equals(this.f11984h, c0107c.f11984h) && Objects.equals(this.f11988l, c0107c.f11988l) && Objects.equals(this.f11989m, c0107c.f11989m) && Objects.equals(this.f11990n, c0107c.f11990n);
        }

        public int hashCode() {
            return Objects.hash(this.f11977a, this.f11978b, this.f11979c, Long.valueOf(this.f11980d), Long.valueOf(this.f11981e), Long.valueOf(this.f11982f), Long.valueOf(this.f11983g), this.f11984h, Boolean.valueOf(this.f11985i), Long.valueOf(this.f11986j), Long.valueOf(this.f11987k), this.f11988l, this.f11989m, this.f11990n);
        }
    }

    /* loaded from: classes2.dex */
    public static final class d extends g {

        /* renamed from: l, reason: collision with root package name */
        public final boolean f11991l;

        /* renamed from: m, reason: collision with root package name */
        public final boolean f11992m;

        public d(String str, f fVar, long j11, int i11, long j12, DrmInitData drmInitData, String str2, String str3, long j13, long j14, boolean z10, boolean z11, boolean z12) {
            super(str, fVar, j11, i11, j12, drmInitData, str2, str3, j13, j14, z10);
            this.f11991l = z11;
            this.f11992m = z12;
        }

        public d b(long j11, int i11) {
            return new d(this.f11998a, this.f11999b, this.f12000c, i11, j11, this.f12003f, this.f12004g, this.f12005h, this.f12006i, this.f12007j, this.f12008k, this.f11991l, this.f11992m);
        }
    }

    /* loaded from: classes2.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f11993a;

        /* renamed from: b, reason: collision with root package name */
        public final long f11994b;

        /* renamed from: c, reason: collision with root package name */
        public final int f11995c;

        public e(Uri uri, long j11, int i11) {
            this.f11993a = uri;
            this.f11994b = j11;
            this.f11995c = i11;
        }
    }

    /* loaded from: classes2.dex */
    public static final class f extends g {

        /* renamed from: l, reason: collision with root package name */
        public final String f11996l;

        /* renamed from: m, reason: collision with root package name */
        public final List f11997m;

        public f(String str, long j11, long j12, String str2, String str3) {
            this(str, null, "", 0L, -1, C.TIME_UNSET, null, str2, str3, j11, j12, false, ImmutableList.of());
        }

        public f(String str, f fVar, String str2, long j11, int i11, long j12, DrmInitData drmInitData, String str3, String str4, long j13, long j14, boolean z10, List list) {
            super(str, fVar, j11, i11, j12, drmInitData, str3, str4, j13, j14, z10);
            this.f11996l = str2;
            this.f11997m = ImmutableList.copyOf((Collection) list);
        }

        public f b(long j11, int i11) {
            ArrayList arrayList = new ArrayList();
            long j12 = j11;
            for (int i12 = 0; i12 < this.f11997m.size(); i12++) {
                d dVar = (d) this.f11997m.get(i12);
                arrayList.add(dVar.b(j12, i11));
                j12 += dVar.f12000c;
            }
            return new f(this.f11998a, this.f11999b, this.f11996l, this.f12000c, i11, j11, this.f12003f, this.f12004g, this.f12005h, this.f12006i, this.f12007j, this.f12008k, arrayList);
        }
    }

    /* loaded from: classes2.dex */
    public static class g implements Comparable {

        /* renamed from: a, reason: collision with root package name */
        public final String f11998a;

        /* renamed from: b, reason: collision with root package name */
        public final f f11999b;

        /* renamed from: c, reason: collision with root package name */
        public final long f12000c;

        /* renamed from: d, reason: collision with root package name */
        public final int f12001d;

        /* renamed from: e, reason: collision with root package name */
        public final long f12002e;

        /* renamed from: f, reason: collision with root package name */
        public final DrmInitData f12003f;

        /* renamed from: g, reason: collision with root package name */
        public final String f12004g;

        /* renamed from: h, reason: collision with root package name */
        public final String f12005h;

        /* renamed from: i, reason: collision with root package name */
        public final long f12006i;

        /* renamed from: j, reason: collision with root package name */
        public final long f12007j;

        /* renamed from: k, reason: collision with root package name */
        public final boolean f12008k;

        private g(String str, f fVar, long j11, int i11, long j12, DrmInitData drmInitData, String str2, String str3, long j13, long j14, boolean z10) {
            this.f11998a = str;
            this.f11999b = fVar;
            this.f12000c = j11;
            this.f12001d = i11;
            this.f12002e = j12;
            this.f12003f = drmInitData;
            this.f12004g = str2;
            this.f12005h = str3;
            this.f12006i = j13;
            this.f12007j = j14;
            this.f12008k = z10;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(Long l11) {
            if (this.f12002e > l11.longValue()) {
                return 1;
            }
            return this.f12002e < l11.longValue() ? -1 : 0;
        }
    }

    /* loaded from: classes2.dex */
    public static final class h {

        /* renamed from: a, reason: collision with root package name */
        public final long f12009a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f12010b;

        /* renamed from: c, reason: collision with root package name */
        public final long f12011c;

        /* renamed from: d, reason: collision with root package name */
        public final long f12012d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f12013e;

        public h(long j11, boolean z10, long j12, long j13, boolean z11) {
            this.f12009a = j11;
            this.f12010b = z10;
            this.f12011c = j12;
            this.f12012d = j13;
            this.f12013e = z11;
        }
    }

    public c(int i11, String str, List list, long j11, boolean z10, long j12, boolean z11, int i12, long j13, int i13, long j14, long j15, boolean z12, boolean z13, boolean z14, DrmInitData drmInitData, List list2, List list3, h hVar, Map map, List list4) {
        super(str, list, z12);
        this.f11953d = i11;
        this.f11957h = j12;
        this.f11956g = z10;
        this.f11958i = z11;
        this.f11959j = i12;
        this.f11960k = j13;
        this.f11961l = i13;
        this.f11962m = j14;
        this.f11963n = j15;
        this.f11964o = z13;
        this.f11965p = z14;
        this.f11966q = drmInitData;
        this.f11967r = ImmutableList.copyOf((Collection) list2);
        this.f11968s = ImmutableList.copyOf((Collection) list3);
        this.f11969t = ImmutableMap.copyOf(map);
        this.f11972w = ImmutableList.copyOf((Collection) list4);
        if (!list3.isEmpty()) {
            d dVar = (d) g3.g(list3);
            this.f11970u = dVar.f12002e + dVar.f12000c;
        } else if (list2.isEmpty()) {
            this.f11970u = 0L;
        } else {
            f fVar = (f) g3.g(list2);
            this.f11970u = fVar.f12002e + fVar.f12000c;
        }
        this.f11954e = j11 != C.TIME_UNSET ? j11 >= 0 ? Math.min(this.f11970u, j11) : Math.max(0L, this.f11970u + j11) : C.TIME_UNSET;
        this.f11955f = j11 >= 0;
        this.f11971v = hVar;
    }

    @Override // androidx.media3.exoplayer.offline.q
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c copy(List list) {
        return this;
    }

    public c b(long j11, int i11) {
        return new c(this.f11953d, this.f17066a, this.f17067b, this.f11954e, this.f11956g, j11, true, i11, this.f11960k, this.f11961l, this.f11962m, this.f11963n, this.f17068c, this.f11964o, this.f11965p, this.f11966q, this.f11967r, this.f11968s, this.f11971v, this.f11969t, this.f11972w);
    }

    public c c() {
        return this.f11964o ? this : new c(this.f11953d, this.f17066a, this.f17067b, this.f11954e, this.f11956g, this.f11957h, this.f11958i, this.f11959j, this.f11960k, this.f11961l, this.f11962m, this.f11963n, this.f17068c, true, this.f11965p, this.f11966q, this.f11967r, this.f11968s, this.f11971v, this.f11969t, this.f11972w);
    }

    public long d() {
        return this.f11957h + this.f11970u;
    }

    public boolean e(c cVar) {
        if (cVar == null) {
            return true;
        }
        long j11 = this.f11960k;
        long j12 = cVar.f11960k;
        if (j11 > j12) {
            return true;
        }
        if (j11 < j12) {
            return false;
        }
        int size = this.f11967r.size() - cVar.f11967r.size();
        if (size != 0) {
            return size > 0;
        }
        int size2 = this.f11968s.size();
        int size3 = cVar.f11968s.size();
        if (size2 <= size3) {
            return size2 == size3 && this.f11964o && !cVar.f11964o;
        }
        return true;
    }
}
