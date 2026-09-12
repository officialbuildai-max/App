package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.g3;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class d extends y9.d {

    /* renamed from: d, reason: collision with root package name */
    public final int f26177d;

    /* renamed from: e, reason: collision with root package name */
    public final long f26178e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f26179f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f26180g;

    /* renamed from: h, reason: collision with root package name */
    public final long f26181h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f26182i;

    /* renamed from: j, reason: collision with root package name */
    public final int f26183j;

    /* renamed from: k, reason: collision with root package name */
    public final long f26184k;

    /* renamed from: l, reason: collision with root package name */
    public final int f26185l;

    /* renamed from: m, reason: collision with root package name */
    public final long f26186m;

    /* renamed from: n, reason: collision with root package name */
    public final long f26187n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f26188o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f26189p;

    /* renamed from: q, reason: collision with root package name */
    public final DrmInitData f26190q;

    /* renamed from: r, reason: collision with root package name */
    public final List f26191r;

    /* renamed from: s, reason: collision with root package name */
    public final List f26192s;

    /* renamed from: t, reason: collision with root package name */
    public final Map f26193t;

    /* renamed from: u, reason: collision with root package name */
    public final long f26194u;

    /* renamed from: v, reason: collision with root package name */
    public final f f26195v;

    /* loaded from: classes3.dex */
    public static final class b extends e {

        /* renamed from: l, reason: collision with root package name */
        public final boolean f26196l;

        /* renamed from: m, reason: collision with root package name */
        public final boolean f26197m;

        public b(String str, C0374d c0374d, long j11, int i11, long j12, DrmInitData drmInitData, String str2, String str3, long j13, long j14, boolean z10, boolean z11, boolean z12) {
            super(str, c0374d, j11, i11, j12, drmInitData, str2, str3, j13, j14, z10);
            this.f26196l = z11;
            this.f26197m = z12;
        }

        public b b(long j11, int i11) {
            return new b(this.f26203a, this.f26204b, this.f26205c, i11, j11, this.f26208f, this.f26209g, this.f26210h, this.f26211i, this.f26212j, this.f26213k, this.f26196l, this.f26197m);
        }
    }

    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f26198a;

        /* renamed from: b, reason: collision with root package name */
        public final long f26199b;

        /* renamed from: c, reason: collision with root package name */
        public final int f26200c;

        public c(Uri uri, long j11, int i11) {
            this.f26198a = uri;
            this.f26199b = j11;
            this.f26200c = i11;
        }
    }

    /* renamed from: com.google.android.exoplayer2.source.hls.playlist.d$d, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0374d extends e {

        /* renamed from: l, reason: collision with root package name */
        public final String f26201l;

        /* renamed from: m, reason: collision with root package name */
        public final List f26202m;

        public C0374d(String str, long j11, long j12, String str2, String str3) {
            this(str, null, "", 0L, -1, C.TIME_UNSET, null, str2, str3, j11, j12, false, ImmutableList.of());
        }

        public C0374d(String str, C0374d c0374d, String str2, long j11, int i11, long j12, DrmInitData drmInitData, String str3, String str4, long j13, long j14, boolean z10, List list) {
            super(str, c0374d, j11, i11, j12, drmInitData, str3, str4, j13, j14, z10);
            this.f26201l = str2;
            this.f26202m = ImmutableList.copyOf((Collection) list);
        }

        public C0374d b(long j11, int i11) {
            ArrayList arrayList = new ArrayList();
            long j12 = j11;
            for (int i12 = 0; i12 < this.f26202m.size(); i12++) {
                b bVar = (b) this.f26202m.get(i12);
                arrayList.add(bVar.b(j12, i11));
                j12 += bVar.f26205c;
            }
            return new C0374d(this.f26203a, this.f26204b, this.f26201l, this.f26205c, i11, j11, this.f26208f, this.f26209g, this.f26210h, this.f26211i, this.f26212j, this.f26213k, arrayList);
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements Comparable {

        /* renamed from: a, reason: collision with root package name */
        public final String f26203a;

        /* renamed from: b, reason: collision with root package name */
        public final C0374d f26204b;

        /* renamed from: c, reason: collision with root package name */
        public final long f26205c;

        /* renamed from: d, reason: collision with root package name */
        public final int f26206d;

        /* renamed from: e, reason: collision with root package name */
        public final long f26207e;

        /* renamed from: f, reason: collision with root package name */
        public final DrmInitData f26208f;

        /* renamed from: g, reason: collision with root package name */
        public final String f26209g;

        /* renamed from: h, reason: collision with root package name */
        public final String f26210h;

        /* renamed from: i, reason: collision with root package name */
        public final long f26211i;

        /* renamed from: j, reason: collision with root package name */
        public final long f26212j;

        /* renamed from: k, reason: collision with root package name */
        public final boolean f26213k;

        private e(String str, C0374d c0374d, long j11, int i11, long j12, DrmInitData drmInitData, String str2, String str3, long j13, long j14, boolean z10) {
            this.f26203a = str;
            this.f26204b = c0374d;
            this.f26205c = j11;
            this.f26206d = i11;
            this.f26207e = j12;
            this.f26208f = drmInitData;
            this.f26209g = str2;
            this.f26210h = str3;
            this.f26211i = j13;
            this.f26212j = j14;
            this.f26213k = z10;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(Long l11) {
            if (this.f26207e > l11.longValue()) {
                return 1;
            }
            return this.f26207e < l11.longValue() ? -1 : 0;
        }
    }

    /* loaded from: classes3.dex */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        public final long f26214a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f26215b;

        /* renamed from: c, reason: collision with root package name */
        public final long f26216c;

        /* renamed from: d, reason: collision with root package name */
        public final long f26217d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f26218e;

        public f(long j11, boolean z10, long j12, long j13, boolean z11) {
            this.f26214a = j11;
            this.f26215b = z10;
            this.f26216c = j12;
            this.f26217d = j13;
            this.f26218e = z11;
        }
    }

    public d(int i11, String str, List list, long j11, boolean z10, long j12, boolean z11, int i12, long j13, int i13, long j14, long j15, boolean z12, boolean z13, boolean z14, DrmInitData drmInitData, List list2, List list3, f fVar, Map map) {
        super(str, list, z12);
        this.f26177d = i11;
        this.f26181h = j12;
        this.f26180g = z10;
        this.f26182i = z11;
        this.f26183j = i12;
        this.f26184k = j13;
        this.f26185l = i13;
        this.f26186m = j14;
        this.f26187n = j15;
        this.f26188o = z13;
        this.f26189p = z14;
        this.f26190q = drmInitData;
        this.f26191r = ImmutableList.copyOf((Collection) list2);
        this.f26192s = ImmutableList.copyOf((Collection) list3);
        this.f26193t = ImmutableMap.copyOf(map);
        if (!list3.isEmpty()) {
            b bVar = (b) g3.g(list3);
            this.f26194u = bVar.f26207e + bVar.f26205c;
        } else if (list2.isEmpty()) {
            this.f26194u = 0L;
        } else {
            C0374d c0374d = (C0374d) g3.g(list2);
            this.f26194u = c0374d.f26207e + c0374d.f26205c;
        }
        this.f26178e = j11 != C.TIME_UNSET ? j11 >= 0 ? Math.min(this.f26194u, j11) : Math.max(0L, this.f26194u + j11) : C.TIME_UNSET;
        this.f26179f = j11 >= 0;
        this.f26195v = fVar;
    }

    @Override // com.google.android.exoplayer2.offline.c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public d copy(List list) {
        return this;
    }

    public d b(long j11, int i11) {
        return new d(this.f26177d, this.f79073a, this.f79074b, this.f26178e, this.f26180g, j11, true, i11, this.f26184k, this.f26185l, this.f26186m, this.f26187n, this.f79075c, this.f26188o, this.f26189p, this.f26190q, this.f26191r, this.f26192s, this.f26195v, this.f26193t);
    }

    public d c() {
        return this.f26188o ? this : new d(this.f26177d, this.f79073a, this.f79074b, this.f26178e, this.f26180g, this.f26181h, this.f26182i, this.f26183j, this.f26184k, this.f26185l, this.f26186m, this.f26187n, this.f79075c, true, this.f26189p, this.f26190q, this.f26191r, this.f26192s, this.f26195v, this.f26193t);
    }

    public long d() {
        return this.f26181h + this.f26194u;
    }

    public boolean e(d dVar) {
        if (dVar == null) {
            return true;
        }
        long j11 = this.f26184k;
        long j12 = dVar.f26184k;
        if (j11 > j12) {
            return true;
        }
        if (j11 < j12) {
            return false;
        }
        int size = this.f26191r.size() - dVar.f26191r.size();
        if (size != 0) {
            return size > 0;
        }
        int size2 = this.f26192s.size();
        int size3 = dVar.f26192s.size();
        if (size2 <= size3) {
            return size2 == size3 && this.f26188o && !dVar.f26188o;
        }
        return true;
    }
}
