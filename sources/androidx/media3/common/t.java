package androidx.media3.common;

import android.net.Uri;
import android.os.Bundle;
import androidx.media3.common.util.a1;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class t {

    /* renamed from: i, reason: collision with root package name */
    public static final t f10285i = new c().a();

    /* renamed from: j, reason: collision with root package name */
    private static final String f10286j = a1.C0(0);

    /* renamed from: k, reason: collision with root package name */
    private static final String f10287k = a1.C0(1);

    /* renamed from: l, reason: collision with root package name */
    private static final String f10288l = a1.C0(2);

    /* renamed from: m, reason: collision with root package name */
    private static final String f10289m = a1.C0(3);

    /* renamed from: n, reason: collision with root package name */
    private static final String f10290n = a1.C0(4);

    /* renamed from: o, reason: collision with root package name */
    private static final String f10291o = a1.C0(5);

    /* renamed from: a, reason: collision with root package name */
    public final String f10292a;

    /* renamed from: b, reason: collision with root package name */
    public final h f10293b;

    /* renamed from: c, reason: collision with root package name */
    public final h f10294c;

    /* renamed from: d, reason: collision with root package name */
    public final g f10295d;

    /* renamed from: e, reason: collision with root package name */
    public final v f10296e;

    /* renamed from: f, reason: collision with root package name */
    public final d f10297f;

    /* renamed from: g, reason: collision with root package name */
    public final e f10298g;

    /* renamed from: h, reason: collision with root package name */
    public final i f10299h;

    /* loaded from: classes2.dex */
    public static final class b {
    }

    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private String f10300a;

        /* renamed from: b, reason: collision with root package name */
        private Uri f10301b;

        /* renamed from: c, reason: collision with root package name */
        private String f10302c;

        /* renamed from: d, reason: collision with root package name */
        private d.a f10303d;

        /* renamed from: e, reason: collision with root package name */
        private f.a f10304e;

        /* renamed from: f, reason: collision with root package name */
        private List f10305f;

        /* renamed from: g, reason: collision with root package name */
        private String f10306g;

        /* renamed from: h, reason: collision with root package name */
        private ImmutableList f10307h;

        /* renamed from: i, reason: collision with root package name */
        private Object f10308i;

        /* renamed from: j, reason: collision with root package name */
        private long f10309j;

        /* renamed from: k, reason: collision with root package name */
        private v f10310k;

        /* renamed from: l, reason: collision with root package name */
        private g.a f10311l;

        /* renamed from: m, reason: collision with root package name */
        private i f10312m;

        public c() {
            this.f10303d = new d.a();
            this.f10304e = new f.a();
            this.f10305f = Collections.emptyList();
            this.f10307h = ImmutableList.of();
            this.f10311l = new g.a();
            this.f10312m = i.f10394d;
            this.f10309j = C.TIME_UNSET;
        }

        private c(t tVar) {
            this();
            this.f10303d = tVar.f10297f.a();
            this.f10300a = tVar.f10292a;
            this.f10310k = tVar.f10296e;
            this.f10311l = tVar.f10295d.a();
            this.f10312m = tVar.f10299h;
            h hVar = tVar.f10293b;
            if (hVar != null) {
                this.f10306g = hVar.f10389e;
                this.f10302c = hVar.f10386b;
                this.f10301b = hVar.f10385a;
                this.f10305f = hVar.f10388d;
                this.f10307h = hVar.f10390f;
                this.f10308i = hVar.f10392h;
                f fVar = hVar.f10387c;
                this.f10304e = fVar != null ? fVar.b() : new f.a();
                this.f10309j = hVar.f10393i;
            }
        }

        public t a() {
            h hVar;
            androidx.media3.common.util.a.g(this.f10304e.f10354b == null || this.f10304e.f10353a != null);
            Uri uri = this.f10301b;
            if (uri != null) {
                hVar = new h(uri, this.f10302c, this.f10304e.f10353a != null ? this.f10304e.i() : null, null, this.f10305f, this.f10306g, this.f10307h, this.f10308i, this.f10309j);
            } else {
                hVar = null;
            }
            String str = this.f10300a;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            e g11 = this.f10303d.g();
            g f11 = this.f10311l.f();
            v vVar = this.f10310k;
            if (vVar == null) {
                vVar = v.I;
            }
            return new t(str2, g11, hVar, f11, vVar, this.f10312m);
        }

        public c b(String str) {
            this.f10306g = str;
            return this;
        }

        public c c(g gVar) {
            this.f10311l = gVar.a();
            return this;
        }

        public c d(String str) {
            this.f10300a = (String) androidx.media3.common.util.a.e(str);
            return this;
        }

        public c e(String str) {
            this.f10302c = str;
            return this;
        }

        public c f(List list) {
            this.f10305f = (list == null || list.isEmpty()) ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(list));
            return this;
        }

        public c g(List list) {
            this.f10307h = ImmutableList.copyOf((Collection) list);
            return this;
        }

        public c h(Object obj) {
            this.f10308i = obj;
            return this;
        }

        public c i(Uri uri) {
            this.f10301b = uri;
            return this;
        }

        public c j(String str) {
            return i(str == null ? null : Uri.parse(str));
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: h, reason: collision with root package name */
        public static final d f10313h = new a().f();

        /* renamed from: i, reason: collision with root package name */
        private static final String f10314i = a1.C0(0);

        /* renamed from: j, reason: collision with root package name */
        private static final String f10315j = a1.C0(1);

        /* renamed from: k, reason: collision with root package name */
        private static final String f10316k = a1.C0(2);

        /* renamed from: l, reason: collision with root package name */
        private static final String f10317l = a1.C0(3);

        /* renamed from: m, reason: collision with root package name */
        private static final String f10318m = a1.C0(4);

        /* renamed from: n, reason: collision with root package name */
        static final String f10319n = a1.C0(5);

        /* renamed from: o, reason: collision with root package name */
        static final String f10320o = a1.C0(6);

        /* renamed from: a, reason: collision with root package name */
        public final long f10321a;

        /* renamed from: b, reason: collision with root package name */
        public final long f10322b;

        /* renamed from: c, reason: collision with root package name */
        public final long f10323c;

        /* renamed from: d, reason: collision with root package name */
        public final long f10324d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f10325e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f10326f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f10327g;

        /* loaded from: classes2.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private long f10328a;

            /* renamed from: b, reason: collision with root package name */
            private long f10329b;

            /* renamed from: c, reason: collision with root package name */
            private boolean f10330c;

            /* renamed from: d, reason: collision with root package name */
            private boolean f10331d;

            /* renamed from: e, reason: collision with root package name */
            private boolean f10332e;

            public a() {
                this.f10329b = Long.MIN_VALUE;
            }

            private a(d dVar) {
                this.f10328a = dVar.f10322b;
                this.f10329b = dVar.f10324d;
                this.f10330c = dVar.f10325e;
                this.f10331d = dVar.f10326f;
                this.f10332e = dVar.f10327g;
            }

            public d f() {
                return new d(this);
            }

            public e g() {
                return new e(this);
            }
        }

        private d(a aVar) {
            this.f10321a = a1.y1(aVar.f10328a);
            this.f10323c = a1.y1(aVar.f10329b);
            this.f10322b = aVar.f10328a;
            this.f10324d = aVar.f10329b;
            this.f10325e = aVar.f10330c;
            this.f10326f = aVar.f10331d;
            this.f10327g = aVar.f10332e;
        }

        public a a() {
            return new a();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f10322b == dVar.f10322b && this.f10324d == dVar.f10324d && this.f10325e == dVar.f10325e && this.f10326f == dVar.f10326f && this.f10327g == dVar.f10327g;
        }

        public int hashCode() {
            long j11 = this.f10322b;
            int i11 = ((int) (j11 ^ (j11 >>> 32))) * 31;
            long j12 = this.f10324d;
            return ((((((i11 + ((int) ((j12 >>> 32) ^ j12))) * 31) + (this.f10325e ? 1 : 0)) * 31) + (this.f10326f ? 1 : 0)) * 31) + (this.f10327g ? 1 : 0);
        }
    }

    /* loaded from: classes2.dex */
    public static final class e extends d {

        /* renamed from: p, reason: collision with root package name */
        public static final e f10333p = new d.a().g();

        private e(d.a aVar) {
            super(aVar);
        }
    }

    /* loaded from: classes2.dex */
    public static final class f {

        /* renamed from: l, reason: collision with root package name */
        private static final String f10334l = a1.C0(0);

        /* renamed from: m, reason: collision with root package name */
        private static final String f10335m = a1.C0(1);

        /* renamed from: n, reason: collision with root package name */
        private static final String f10336n = a1.C0(2);

        /* renamed from: o, reason: collision with root package name */
        private static final String f10337o = a1.C0(3);

        /* renamed from: p, reason: collision with root package name */
        static final String f10338p = a1.C0(4);

        /* renamed from: q, reason: collision with root package name */
        private static final String f10339q = a1.C0(5);

        /* renamed from: r, reason: collision with root package name */
        private static final String f10340r = a1.C0(6);

        /* renamed from: s, reason: collision with root package name */
        private static final String f10341s = a1.C0(7);

        /* renamed from: a, reason: collision with root package name */
        public final UUID f10342a;

        /* renamed from: b, reason: collision with root package name */
        public final UUID f10343b;

        /* renamed from: c, reason: collision with root package name */
        public final Uri f10344c;

        /* renamed from: d, reason: collision with root package name */
        public final ImmutableMap f10345d;

        /* renamed from: e, reason: collision with root package name */
        public final ImmutableMap f10346e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f10347f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f10348g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f10349h;

        /* renamed from: i, reason: collision with root package name */
        public final ImmutableList f10350i;

        /* renamed from: j, reason: collision with root package name */
        public final ImmutableList f10351j;

        /* renamed from: k, reason: collision with root package name */
        private final byte[] f10352k;

        /* loaded from: classes2.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private UUID f10353a;

            /* renamed from: b, reason: collision with root package name */
            private Uri f10354b;

            /* renamed from: c, reason: collision with root package name */
            private ImmutableMap f10355c;

            /* renamed from: d, reason: collision with root package name */
            private boolean f10356d;

            /* renamed from: e, reason: collision with root package name */
            private boolean f10357e;

            /* renamed from: f, reason: collision with root package name */
            private boolean f10358f;

            /* renamed from: g, reason: collision with root package name */
            private ImmutableList f10359g;

            /* renamed from: h, reason: collision with root package name */
            private byte[] f10360h;

            private a() {
                this.f10355c = ImmutableMap.of();
                this.f10357e = true;
                this.f10359g = ImmutableList.of();
            }

            private a(f fVar) {
                this.f10353a = fVar.f10342a;
                this.f10354b = fVar.f10344c;
                this.f10355c = fVar.f10346e;
                this.f10356d = fVar.f10347f;
                this.f10357e = fVar.f10348g;
                this.f10358f = fVar.f10349h;
                this.f10359g = fVar.f10351j;
                this.f10360h = fVar.f10352k;
            }

            public f i() {
                return new f(this);
            }
        }

        private f(a aVar) {
            androidx.media3.common.util.a.g((aVar.f10358f && aVar.f10354b == null) ? false : true);
            UUID uuid = (UUID) androidx.media3.common.util.a.e(aVar.f10353a);
            this.f10342a = uuid;
            this.f10343b = uuid;
            this.f10344c = aVar.f10354b;
            this.f10345d = aVar.f10355c;
            this.f10346e = aVar.f10355c;
            this.f10347f = aVar.f10356d;
            this.f10349h = aVar.f10358f;
            this.f10348g = aVar.f10357e;
            this.f10350i = aVar.f10359g;
            this.f10351j = aVar.f10359g;
            this.f10352k = aVar.f10360h != null ? Arrays.copyOf(aVar.f10360h, aVar.f10360h.length) : null;
        }

        public a b() {
            return new a();
        }

        public byte[] c() {
            byte[] bArr = this.f10352k;
            if (bArr != null) {
                return Arrays.copyOf(bArr, bArr.length);
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.f10342a.equals(fVar.f10342a) && Objects.equals(this.f10344c, fVar.f10344c) && Objects.equals(this.f10346e, fVar.f10346e) && this.f10347f == fVar.f10347f && this.f10349h == fVar.f10349h && this.f10348g == fVar.f10348g && this.f10351j.equals(fVar.f10351j) && Arrays.equals(this.f10352k, fVar.f10352k);
        }

        public int hashCode() {
            int hashCode = this.f10342a.hashCode() * 31;
            Uri uri = this.f10344c;
            return ((((((((((((hashCode + (uri != null ? uri.hashCode() : 0)) * 31) + this.f10346e.hashCode()) * 31) + (this.f10347f ? 1 : 0)) * 31) + (this.f10349h ? 1 : 0)) * 31) + (this.f10348g ? 1 : 0)) * 31) + this.f10351j.hashCode()) * 31) + Arrays.hashCode(this.f10352k);
        }
    }

    /* loaded from: classes2.dex */
    public static final class g {

        /* renamed from: f, reason: collision with root package name */
        public static final g f10361f = new a().f();

        /* renamed from: g, reason: collision with root package name */
        private static final String f10362g = a1.C0(0);

        /* renamed from: h, reason: collision with root package name */
        private static final String f10363h = a1.C0(1);

        /* renamed from: i, reason: collision with root package name */
        private static final String f10364i = a1.C0(2);

        /* renamed from: j, reason: collision with root package name */
        private static final String f10365j = a1.C0(3);

        /* renamed from: k, reason: collision with root package name */
        private static final String f10366k = a1.C0(4);

        /* renamed from: a, reason: collision with root package name */
        public final long f10367a;

        /* renamed from: b, reason: collision with root package name */
        public final long f10368b;

        /* renamed from: c, reason: collision with root package name */
        public final long f10369c;

        /* renamed from: d, reason: collision with root package name */
        public final float f10370d;

        /* renamed from: e, reason: collision with root package name */
        public final float f10371e;

        /* loaded from: classes2.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private long f10372a;

            /* renamed from: b, reason: collision with root package name */
            private long f10373b;

            /* renamed from: c, reason: collision with root package name */
            private long f10374c;

            /* renamed from: d, reason: collision with root package name */
            private float f10375d;

            /* renamed from: e, reason: collision with root package name */
            private float f10376e;

            public a() {
                this.f10372a = C.TIME_UNSET;
                this.f10373b = C.TIME_UNSET;
                this.f10374c = C.TIME_UNSET;
                this.f10375d = -3.4028235E38f;
                this.f10376e = -3.4028235E38f;
            }

            private a(g gVar) {
                this.f10372a = gVar.f10367a;
                this.f10373b = gVar.f10368b;
                this.f10374c = gVar.f10369c;
                this.f10375d = gVar.f10370d;
                this.f10376e = gVar.f10371e;
            }

            public g f() {
                return new g(this);
            }

            public a g(long j11) {
                this.f10374c = j11;
                return this;
            }

            public a h(float f11) {
                this.f10376e = f11;
                return this;
            }

            public a i(long j11) {
                this.f10373b = j11;
                return this;
            }

            public a j(float f11) {
                this.f10375d = f11;
                return this;
            }

            public a k(long j11) {
                this.f10372a = j11;
                return this;
            }
        }

        public g(long j11, long j12, long j13, float f11, float f12) {
            this.f10367a = j11;
            this.f10368b = j12;
            this.f10369c = j13;
            this.f10370d = f11;
            this.f10371e = f12;
        }

        private g(a aVar) {
            this(aVar.f10372a, aVar.f10373b, aVar.f10374c, aVar.f10375d, aVar.f10376e);
        }

        public a a() {
            return new a();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return this.f10367a == gVar.f10367a && this.f10368b == gVar.f10368b && this.f10369c == gVar.f10369c && this.f10370d == gVar.f10370d && this.f10371e == gVar.f10371e;
        }

        public int hashCode() {
            long j11 = this.f10367a;
            long j12 = this.f10368b;
            int i11 = ((((int) (j11 ^ (j11 >>> 32))) * 31) + ((int) (j12 ^ (j12 >>> 32)))) * 31;
            long j13 = this.f10369c;
            int i12 = (i11 + ((int) ((j13 >>> 32) ^ j13))) * 31;
            float f11 = this.f10370d;
            int floatToIntBits = (i12 + (f11 != 0.0f ? Float.floatToIntBits(f11) : 0)) * 31;
            float f12 = this.f10371e;
            return floatToIntBits + (f12 != 0.0f ? Float.floatToIntBits(f12) : 0);
        }
    }

    /* loaded from: classes2.dex */
    public static final class h {

        /* renamed from: j, reason: collision with root package name */
        private static final String f10377j = a1.C0(0);

        /* renamed from: k, reason: collision with root package name */
        private static final String f10378k = a1.C0(1);

        /* renamed from: l, reason: collision with root package name */
        private static final String f10379l = a1.C0(2);

        /* renamed from: m, reason: collision with root package name */
        private static final String f10380m = a1.C0(3);

        /* renamed from: n, reason: collision with root package name */
        private static final String f10381n = a1.C0(4);

        /* renamed from: o, reason: collision with root package name */
        private static final String f10382o = a1.C0(5);

        /* renamed from: p, reason: collision with root package name */
        private static final String f10383p = a1.C0(6);

        /* renamed from: q, reason: collision with root package name */
        private static final String f10384q = a1.C0(7);

        /* renamed from: a, reason: collision with root package name */
        public final Uri f10385a;

        /* renamed from: b, reason: collision with root package name */
        public final String f10386b;

        /* renamed from: c, reason: collision with root package name */
        public final f f10387c;

        /* renamed from: d, reason: collision with root package name */
        public final List f10388d;

        /* renamed from: e, reason: collision with root package name */
        public final String f10389e;

        /* renamed from: f, reason: collision with root package name */
        public final ImmutableList f10390f;

        /* renamed from: g, reason: collision with root package name */
        public final List f10391g;

        /* renamed from: h, reason: collision with root package name */
        public final Object f10392h;

        /* renamed from: i, reason: collision with root package name */
        public final long f10393i;

        /* JADX WARN: Multi-variable type inference failed */
        private h(Uri uri, String str, f fVar, b bVar, List list, String str2, ImmutableList immutableList, Object obj, long j11) {
            this.f10385a = uri;
            this.f10386b = y.u(str);
            this.f10387c = fVar;
            this.f10388d = list;
            this.f10389e = str2;
            this.f10390f = immutableList;
            ImmutableList.a builder = ImmutableList.builder();
            for (int i11 = 0; i11 < immutableList.size(); i11++) {
                builder.a(((k) immutableList.get(i11)).a().i());
            }
            this.f10391g = builder.e();
            this.f10392h = obj;
            this.f10393i = j11;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return this.f10385a.equals(hVar.f10385a) && Objects.equals(this.f10386b, hVar.f10386b) && Objects.equals(this.f10387c, hVar.f10387c) && this.f10388d.equals(hVar.f10388d) && Objects.equals(this.f10389e, hVar.f10389e) && this.f10390f.equals(hVar.f10390f) && Objects.equals(this.f10392h, hVar.f10392h) && this.f10393i == hVar.f10393i;
        }

        public int hashCode() {
            int hashCode = this.f10385a.hashCode() * 31;
            String str = this.f10386b;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            f fVar = this.f10387c;
            int hashCode3 = (((hashCode2 + (fVar == null ? 0 : fVar.hashCode())) * 961) + this.f10388d.hashCode()) * 31;
            String str2 = this.f10389e;
            int hashCode4 = (((hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f10390f.hashCode()) * 31;
            return (int) (((hashCode4 + (this.f10392h != null ? r1.hashCode() : 0)) * 31) + this.f10393i);
        }
    }

    /* loaded from: classes2.dex */
    public static final class i {

        /* renamed from: d, reason: collision with root package name */
        public static final i f10394d = new a().d();

        /* renamed from: e, reason: collision with root package name */
        private static final String f10395e = a1.C0(0);

        /* renamed from: f, reason: collision with root package name */
        private static final String f10396f = a1.C0(1);

        /* renamed from: g, reason: collision with root package name */
        private static final String f10397g = a1.C0(2);

        /* renamed from: a, reason: collision with root package name */
        public final Uri f10398a;

        /* renamed from: b, reason: collision with root package name */
        public final String f10399b;

        /* renamed from: c, reason: collision with root package name */
        public final Bundle f10400c;

        /* loaded from: classes2.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private Uri f10401a;

            /* renamed from: b, reason: collision with root package name */
            private String f10402b;

            /* renamed from: c, reason: collision with root package name */
            private Bundle f10403c;

            public i d() {
                return new i(this);
            }
        }

        private i(a aVar) {
            this.f10398a = aVar.f10401a;
            this.f10399b = aVar.f10402b;
            this.f10400c = aVar.f10403c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            if (Objects.equals(this.f10398a, iVar.f10398a) && Objects.equals(this.f10399b, iVar.f10399b)) {
                if ((this.f10400c == null) == (iVar.f10400c == null)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            Uri uri = this.f10398a;
            int hashCode = (uri == null ? 0 : uri.hashCode()) * 31;
            String str = this.f10399b;
            return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + (this.f10400c != null ? 1 : 0);
        }
    }

    /* loaded from: classes2.dex */
    public static final class j extends k {
        private j(k.a aVar) {
            super(aVar);
        }
    }

    /* loaded from: classes2.dex */
    public static class k {

        /* renamed from: h, reason: collision with root package name */
        private static final String f10404h = a1.C0(0);

        /* renamed from: i, reason: collision with root package name */
        private static final String f10405i = a1.C0(1);

        /* renamed from: j, reason: collision with root package name */
        private static final String f10406j = a1.C0(2);

        /* renamed from: k, reason: collision with root package name */
        private static final String f10407k = a1.C0(3);

        /* renamed from: l, reason: collision with root package name */
        private static final String f10408l = a1.C0(4);

        /* renamed from: m, reason: collision with root package name */
        private static final String f10409m = a1.C0(5);

        /* renamed from: n, reason: collision with root package name */
        private static final String f10410n = a1.C0(6);

        /* renamed from: a, reason: collision with root package name */
        public final Uri f10411a;

        /* renamed from: b, reason: collision with root package name */
        public final String f10412b;

        /* renamed from: c, reason: collision with root package name */
        public final String f10413c;

        /* renamed from: d, reason: collision with root package name */
        public final int f10414d;

        /* renamed from: e, reason: collision with root package name */
        public final int f10415e;

        /* renamed from: f, reason: collision with root package name */
        public final String f10416f;

        /* renamed from: g, reason: collision with root package name */
        public final String f10417g;

        /* loaded from: classes2.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private Uri f10418a;

            /* renamed from: b, reason: collision with root package name */
            private String f10419b;

            /* renamed from: c, reason: collision with root package name */
            private String f10420c;

            /* renamed from: d, reason: collision with root package name */
            private int f10421d;

            /* renamed from: e, reason: collision with root package name */
            private int f10422e;

            /* renamed from: f, reason: collision with root package name */
            private String f10423f;

            /* renamed from: g, reason: collision with root package name */
            private String f10424g;

            private a(k kVar) {
                this.f10418a = kVar.f10411a;
                this.f10419b = kVar.f10412b;
                this.f10420c = kVar.f10413c;
                this.f10421d = kVar.f10414d;
                this.f10422e = kVar.f10415e;
                this.f10423f = kVar.f10416f;
                this.f10424g = kVar.f10417g;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public j i() {
                return new j(this);
            }
        }

        private k(a aVar) {
            this.f10411a = aVar.f10418a;
            this.f10412b = aVar.f10419b;
            this.f10413c = aVar.f10420c;
            this.f10414d = aVar.f10421d;
            this.f10415e = aVar.f10422e;
            this.f10416f = aVar.f10423f;
            this.f10417g = aVar.f10424g;
        }

        public a a() {
            return new a();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            return this.f10411a.equals(kVar.f10411a) && Objects.equals(this.f10412b, kVar.f10412b) && Objects.equals(this.f10413c, kVar.f10413c) && this.f10414d == kVar.f10414d && this.f10415e == kVar.f10415e && Objects.equals(this.f10416f, kVar.f10416f) && Objects.equals(this.f10417g, kVar.f10417g);
        }

        public int hashCode() {
            int hashCode = this.f10411a.hashCode() * 31;
            String str = this.f10412b;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f10413c;
            int hashCode3 = (((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f10414d) * 31) + this.f10415e) * 31;
            String str3 = this.f10416f;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f10417g;
            return hashCode4 + (str4 != null ? str4.hashCode() : 0);
        }
    }

    private t(String str, e eVar, h hVar, g gVar, v vVar, i iVar) {
        this.f10292a = str;
        this.f10293b = hVar;
        this.f10294c = hVar;
        this.f10295d = gVar;
        this.f10296e = vVar;
        this.f10297f = eVar;
        this.f10298g = eVar;
        this.f10299h = iVar;
    }

    public static t b(String str) {
        return new c().j(str).a();
    }

    public c a() {
        return new c();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return Objects.equals(this.f10292a, tVar.f10292a) && this.f10297f.equals(tVar.f10297f) && Objects.equals(this.f10293b, tVar.f10293b) && Objects.equals(this.f10295d, tVar.f10295d) && Objects.equals(this.f10296e, tVar.f10296e) && Objects.equals(this.f10299h, tVar.f10299h);
    }

    public int hashCode() {
        int hashCode = this.f10292a.hashCode() * 31;
        h hVar = this.f10293b;
        return ((((((((hashCode + (hVar != null ? hVar.hashCode() : 0)) * 31) + this.f10295d.hashCode()) * 31) + this.f10297f.hashCode()) * 31) + this.f10296e.hashCode()) * 31) + this.f10299h.hashCode();
    }
}
