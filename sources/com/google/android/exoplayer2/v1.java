package com.google.android.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.v1;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* loaded from: classes3.dex */
public final class v1 implements com.google.android.exoplayer2.k {

    /* renamed from: i, reason: collision with root package name */
    public static final v1 f27760i = new c().a();

    /* renamed from: j, reason: collision with root package name */
    public static final k.a f27761j = new k.a() { // from class: com.google.android.exoplayer2.u1
        @Override // com.google.android.exoplayer2.k.a
        public final k a(Bundle bundle) {
            v1 c11;
            c11 = v1.c(bundle);
            return c11;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final String f27762a;

    /* renamed from: b, reason: collision with root package name */
    public final h f27763b;

    /* renamed from: c, reason: collision with root package name */
    public final i f27764c;

    /* renamed from: d, reason: collision with root package name */
    public final g f27765d;

    /* renamed from: e, reason: collision with root package name */
    public final a2 f27766e;

    /* renamed from: f, reason: collision with root package name */
    public final d f27767f;

    /* renamed from: g, reason: collision with root package name */
    public final e f27768g;

    /* renamed from: h, reason: collision with root package name */
    public final j f27769h;

    /* loaded from: classes3.dex */
    public static final class b {
    }

    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private String f27770a;

        /* renamed from: b, reason: collision with root package name */
        private Uri f27771b;

        /* renamed from: c, reason: collision with root package name */
        private String f27772c;

        /* renamed from: d, reason: collision with root package name */
        private d.a f27773d;

        /* renamed from: e, reason: collision with root package name */
        private f.a f27774e;

        /* renamed from: f, reason: collision with root package name */
        private List f27775f;

        /* renamed from: g, reason: collision with root package name */
        private String f27776g;

        /* renamed from: h, reason: collision with root package name */
        private ImmutableList f27777h;

        /* renamed from: i, reason: collision with root package name */
        private Object f27778i;

        /* renamed from: j, reason: collision with root package name */
        private a2 f27779j;

        /* renamed from: k, reason: collision with root package name */
        private g.a f27780k;

        /* renamed from: l, reason: collision with root package name */
        private j f27781l;

        public c() {
            this.f27773d = new d.a();
            this.f27774e = new f.a();
            this.f27775f = Collections.emptyList();
            this.f27777h = ImmutableList.of();
            this.f27780k = new g.a();
            this.f27781l = j.f27834d;
        }

        private c(v1 v1Var) {
            this();
            this.f27773d = v1Var.f27767f.b();
            this.f27770a = v1Var.f27762a;
            this.f27779j = v1Var.f27766e;
            this.f27780k = v1Var.f27765d.b();
            this.f27781l = v1Var.f27769h;
            h hVar = v1Var.f27763b;
            if (hVar != null) {
                this.f27776g = hVar.f27830e;
                this.f27772c = hVar.f27827b;
                this.f27771b = hVar.f27826a;
                this.f27775f = hVar.f27829d;
                this.f27777h = hVar.f27831f;
                this.f27778i = hVar.f27833h;
                f fVar = hVar.f27828c;
                this.f27774e = fVar != null ? fVar.b() : new f.a();
            }
        }

        public v1 a() {
            i iVar;
            com.google.android.exoplayer2.util.a.g(this.f27774e.f27807b == null || this.f27774e.f27806a != null);
            Uri uri = this.f27771b;
            if (uri != null) {
                iVar = new i(uri, this.f27772c, this.f27774e.f27806a != null ? this.f27774e.i() : null, null, this.f27775f, this.f27776g, this.f27777h, this.f27778i);
            } else {
                iVar = null;
            }
            String str = this.f27770a;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            e g11 = this.f27773d.g();
            g f11 = this.f27780k.f();
            a2 a2Var = this.f27779j;
            if (a2Var == null) {
                a2Var = a2.G;
            }
            return new v1(str2, g11, iVar, f11, a2Var, this.f27781l);
        }

        public c b(String str) {
            this.f27776g = str;
            return this;
        }

        public c c(g gVar) {
            this.f27780k = gVar.b();
            return this;
        }

        public c d(String str) {
            this.f27770a = (String) com.google.android.exoplayer2.util.a.e(str);
            return this;
        }

        public c e(String str) {
            this.f27772c = str;
            return this;
        }

        public c f(List list) {
            this.f27775f = (list == null || list.isEmpty()) ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(list));
            return this;
        }

        public c g(List list) {
            this.f27777h = ImmutableList.copyOf((Collection) list);
            return this;
        }

        public c h(Object obj) {
            this.f27778i = obj;
            return this;
        }

        public c i(Uri uri) {
            this.f27771b = uri;
            return this;
        }

        public c j(String str) {
            return i(str == null ? null : Uri.parse(str));
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements com.google.android.exoplayer2.k {

        /* renamed from: f, reason: collision with root package name */
        public static final d f27782f = new a().f();

        /* renamed from: g, reason: collision with root package name */
        public static final k.a f27783g = new k.a() { // from class: com.google.android.exoplayer2.w1
            @Override // com.google.android.exoplayer2.k.a
            public final k a(Bundle bundle) {
                v1.e d11;
                d11 = v1.d.d(bundle);
                return d11;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public final long f27784a;

        /* renamed from: b, reason: collision with root package name */
        public final long f27785b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f27786c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f27787d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f27788e;

        /* loaded from: classes3.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private long f27789a;

            /* renamed from: b, reason: collision with root package name */
            private long f27790b;

            /* renamed from: c, reason: collision with root package name */
            private boolean f27791c;

            /* renamed from: d, reason: collision with root package name */
            private boolean f27792d;

            /* renamed from: e, reason: collision with root package name */
            private boolean f27793e;

            public a() {
                this.f27790b = Long.MIN_VALUE;
            }

            private a(d dVar) {
                this.f27789a = dVar.f27784a;
                this.f27790b = dVar.f27785b;
                this.f27791c = dVar.f27786c;
                this.f27792d = dVar.f27787d;
                this.f27793e = dVar.f27788e;
            }

            public d f() {
                return g();
            }

            public e g() {
                return new e(this);
            }

            public a h(long j11) {
                com.google.android.exoplayer2.util.a.a(j11 == Long.MIN_VALUE || j11 >= 0);
                this.f27790b = j11;
                return this;
            }

            public a i(boolean z10) {
                this.f27792d = z10;
                return this;
            }

            public a j(boolean z10) {
                this.f27791c = z10;
                return this;
            }

            public a k(long j11) {
                com.google.android.exoplayer2.util.a.a(j11 >= 0);
                this.f27789a = j11;
                return this;
            }

            public a l(boolean z10) {
                this.f27793e = z10;
                return this;
            }
        }

        private d(a aVar) {
            this.f27784a = aVar.f27789a;
            this.f27785b = aVar.f27790b;
            this.f27786c = aVar.f27791c;
            this.f27787d = aVar.f27792d;
            this.f27788e = aVar.f27793e;
        }

        private static String c(int i11) {
            return Integer.toString(i11, 36);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ e d(Bundle bundle) {
            return new a().k(bundle.getLong(c(0), 0L)).h(bundle.getLong(c(1), Long.MIN_VALUE)).j(bundle.getBoolean(c(2), false)).i(bundle.getBoolean(c(3), false)).l(bundle.getBoolean(c(4), false)).g();
        }

        public a b() {
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
            return this.f27784a == dVar.f27784a && this.f27785b == dVar.f27785b && this.f27786c == dVar.f27786c && this.f27787d == dVar.f27787d && this.f27788e == dVar.f27788e;
        }

        public int hashCode() {
            long j11 = this.f27784a;
            int i11 = ((int) (j11 ^ (j11 >>> 32))) * 31;
            long j12 = this.f27785b;
            return ((((((i11 + ((int) ((j12 >>> 32) ^ j12))) * 31) + (this.f27786c ? 1 : 0)) * 31) + (this.f27787d ? 1 : 0)) * 31) + (this.f27788e ? 1 : 0);
        }

        @Override // com.google.android.exoplayer2.k
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong(c(0), this.f27784a);
            bundle.putLong(c(1), this.f27785b);
            bundle.putBoolean(c(2), this.f27786c);
            bundle.putBoolean(c(3), this.f27787d);
            bundle.putBoolean(c(4), this.f27788e);
            return bundle;
        }
    }

    /* loaded from: classes3.dex */
    public static final class e extends d {

        /* renamed from: h, reason: collision with root package name */
        public static final e f27794h = new d.a().g();

        private e(d.a aVar) {
            super(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        public final UUID f27795a;

        /* renamed from: b, reason: collision with root package name */
        public final UUID f27796b;

        /* renamed from: c, reason: collision with root package name */
        public final Uri f27797c;

        /* renamed from: d, reason: collision with root package name */
        public final ImmutableMap f27798d;

        /* renamed from: e, reason: collision with root package name */
        public final ImmutableMap f27799e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f27800f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f27801g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f27802h;

        /* renamed from: i, reason: collision with root package name */
        public final ImmutableList f27803i;

        /* renamed from: j, reason: collision with root package name */
        public final ImmutableList f27804j;

        /* renamed from: k, reason: collision with root package name */
        private final byte[] f27805k;

        /* loaded from: classes3.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private UUID f27806a;

            /* renamed from: b, reason: collision with root package name */
            private Uri f27807b;

            /* renamed from: c, reason: collision with root package name */
            private ImmutableMap f27808c;

            /* renamed from: d, reason: collision with root package name */
            private boolean f27809d;

            /* renamed from: e, reason: collision with root package name */
            private boolean f27810e;

            /* renamed from: f, reason: collision with root package name */
            private boolean f27811f;

            /* renamed from: g, reason: collision with root package name */
            private ImmutableList f27812g;

            /* renamed from: h, reason: collision with root package name */
            private byte[] f27813h;

            private a() {
                this.f27808c = ImmutableMap.of();
                this.f27812g = ImmutableList.of();
            }

            private a(f fVar) {
                this.f27806a = fVar.f27795a;
                this.f27807b = fVar.f27797c;
                this.f27808c = fVar.f27799e;
                this.f27809d = fVar.f27800f;
                this.f27810e = fVar.f27801g;
                this.f27811f = fVar.f27802h;
                this.f27812g = fVar.f27804j;
                this.f27813h = fVar.f27805k;
            }

            public f i() {
                return new f(this);
            }
        }

        private f(a aVar) {
            com.google.android.exoplayer2.util.a.g((aVar.f27811f && aVar.f27807b == null) ? false : true);
            UUID uuid = (UUID) com.google.android.exoplayer2.util.a.e(aVar.f27806a);
            this.f27795a = uuid;
            this.f27796b = uuid;
            this.f27797c = aVar.f27807b;
            this.f27798d = aVar.f27808c;
            this.f27799e = aVar.f27808c;
            this.f27800f = aVar.f27809d;
            this.f27802h = aVar.f27811f;
            this.f27801g = aVar.f27810e;
            this.f27803i = aVar.f27812g;
            this.f27804j = aVar.f27812g;
            this.f27805k = aVar.f27813h != null ? Arrays.copyOf(aVar.f27813h, aVar.f27813h.length) : null;
        }

        public a b() {
            return new a();
        }

        public byte[] c() {
            byte[] bArr = this.f27805k;
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
            return this.f27795a.equals(fVar.f27795a) && com.google.android.exoplayer2.util.p0.c(this.f27797c, fVar.f27797c) && com.google.android.exoplayer2.util.p0.c(this.f27799e, fVar.f27799e) && this.f27800f == fVar.f27800f && this.f27802h == fVar.f27802h && this.f27801g == fVar.f27801g && this.f27804j.equals(fVar.f27804j) && Arrays.equals(this.f27805k, fVar.f27805k);
        }

        public int hashCode() {
            int hashCode = this.f27795a.hashCode() * 31;
            Uri uri = this.f27797c;
            return ((((((((((((hashCode + (uri != null ? uri.hashCode() : 0)) * 31) + this.f27799e.hashCode()) * 31) + (this.f27800f ? 1 : 0)) * 31) + (this.f27802h ? 1 : 0)) * 31) + (this.f27801g ? 1 : 0)) * 31) + this.f27804j.hashCode()) * 31) + Arrays.hashCode(this.f27805k);
        }
    }

    /* loaded from: classes3.dex */
    public static final class g implements com.google.android.exoplayer2.k {

        /* renamed from: f, reason: collision with root package name */
        public static final g f27814f = new a().f();

        /* renamed from: g, reason: collision with root package name */
        public static final k.a f27815g = new k.a() { // from class: com.google.android.exoplayer2.x1
            @Override // com.google.android.exoplayer2.k.a
            public final k a(Bundle bundle) {
                v1.g d11;
                d11 = v1.g.d(bundle);
                return d11;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public final long f27816a;

        /* renamed from: b, reason: collision with root package name */
        public final long f27817b;

        /* renamed from: c, reason: collision with root package name */
        public final long f27818c;

        /* renamed from: d, reason: collision with root package name */
        public final float f27819d;

        /* renamed from: e, reason: collision with root package name */
        public final float f27820e;

        /* loaded from: classes3.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private long f27821a;

            /* renamed from: b, reason: collision with root package name */
            private long f27822b;

            /* renamed from: c, reason: collision with root package name */
            private long f27823c;

            /* renamed from: d, reason: collision with root package name */
            private float f27824d;

            /* renamed from: e, reason: collision with root package name */
            private float f27825e;

            public a() {
                this.f27821a = C.TIME_UNSET;
                this.f27822b = C.TIME_UNSET;
                this.f27823c = C.TIME_UNSET;
                this.f27824d = -3.4028235E38f;
                this.f27825e = -3.4028235E38f;
            }

            private a(g gVar) {
                this.f27821a = gVar.f27816a;
                this.f27822b = gVar.f27817b;
                this.f27823c = gVar.f27818c;
                this.f27824d = gVar.f27819d;
                this.f27825e = gVar.f27820e;
            }

            public g f() {
                return new g(this);
            }

            public a g(long j11) {
                this.f27823c = j11;
                return this;
            }

            public a h(float f11) {
                this.f27825e = f11;
                return this;
            }

            public a i(long j11) {
                this.f27822b = j11;
                return this;
            }

            public a j(float f11) {
                this.f27824d = f11;
                return this;
            }

            public a k(long j11) {
                this.f27821a = j11;
                return this;
            }
        }

        public g(long j11, long j12, long j13, float f11, float f12) {
            this.f27816a = j11;
            this.f27817b = j12;
            this.f27818c = j13;
            this.f27819d = f11;
            this.f27820e = f12;
        }

        private g(a aVar) {
            this(aVar.f27821a, aVar.f27822b, aVar.f27823c, aVar.f27824d, aVar.f27825e);
        }

        private static String c(int i11) {
            return Integer.toString(i11, 36);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ g d(Bundle bundle) {
            return new g(bundle.getLong(c(0), C.TIME_UNSET), bundle.getLong(c(1), C.TIME_UNSET), bundle.getLong(c(2), C.TIME_UNSET), bundle.getFloat(c(3), -3.4028235E38f), bundle.getFloat(c(4), -3.4028235E38f));
        }

        public a b() {
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
            return this.f27816a == gVar.f27816a && this.f27817b == gVar.f27817b && this.f27818c == gVar.f27818c && this.f27819d == gVar.f27819d && this.f27820e == gVar.f27820e;
        }

        public int hashCode() {
            long j11 = this.f27816a;
            long j12 = this.f27817b;
            int i11 = ((((int) (j11 ^ (j11 >>> 32))) * 31) + ((int) (j12 ^ (j12 >>> 32)))) * 31;
            long j13 = this.f27818c;
            int i12 = (i11 + ((int) ((j13 >>> 32) ^ j13))) * 31;
            float f11 = this.f27819d;
            int floatToIntBits = (i12 + (f11 != 0.0f ? Float.floatToIntBits(f11) : 0)) * 31;
            float f12 = this.f27820e;
            return floatToIntBits + (f12 != 0.0f ? Float.floatToIntBits(f12) : 0);
        }

        @Override // com.google.android.exoplayer2.k
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong(c(0), this.f27816a);
            bundle.putLong(c(1), this.f27817b);
            bundle.putLong(c(2), this.f27818c);
            bundle.putFloat(c(3), this.f27819d);
            bundle.putFloat(c(4), this.f27820e);
            return bundle;
        }
    }

    /* loaded from: classes3.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f27826a;

        /* renamed from: b, reason: collision with root package name */
        public final String f27827b;

        /* renamed from: c, reason: collision with root package name */
        public final f f27828c;

        /* renamed from: d, reason: collision with root package name */
        public final List f27829d;

        /* renamed from: e, reason: collision with root package name */
        public final String f27830e;

        /* renamed from: f, reason: collision with root package name */
        public final ImmutableList f27831f;

        /* renamed from: g, reason: collision with root package name */
        public final List f27832g;

        /* renamed from: h, reason: collision with root package name */
        public final Object f27833h;

        /* JADX WARN: Multi-variable type inference failed */
        private h(Uri uri, String str, f fVar, b bVar, List list, String str2, ImmutableList immutableList, Object obj) {
            this.f27826a = uri;
            this.f27827b = str;
            this.f27828c = fVar;
            this.f27829d = list;
            this.f27830e = str2;
            this.f27831f = immutableList;
            ImmutableList.a builder = ImmutableList.builder();
            for (int i11 = 0; i11 < immutableList.size(); i11++) {
                builder.a(((l) immutableList.get(i11)).a().i());
            }
            this.f27832g = builder.e();
            this.f27833h = obj;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return this.f27826a.equals(hVar.f27826a) && com.google.android.exoplayer2.util.p0.c(this.f27827b, hVar.f27827b) && com.google.android.exoplayer2.util.p0.c(this.f27828c, hVar.f27828c) && com.google.android.exoplayer2.util.p0.c(null, null) && this.f27829d.equals(hVar.f27829d) && com.google.android.exoplayer2.util.p0.c(this.f27830e, hVar.f27830e) && this.f27831f.equals(hVar.f27831f) && com.google.android.exoplayer2.util.p0.c(this.f27833h, hVar.f27833h);
        }

        public int hashCode() {
            int hashCode = this.f27826a.hashCode() * 31;
            String str = this.f27827b;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            f fVar = this.f27828c;
            int hashCode3 = (((hashCode2 + (fVar == null ? 0 : fVar.hashCode())) * 961) + this.f27829d.hashCode()) * 31;
            String str2 = this.f27830e;
            int hashCode4 = (((hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f27831f.hashCode()) * 31;
            Object obj = this.f27833h;
            return hashCode4 + (obj != null ? obj.hashCode() : 0);
        }
    }

    /* loaded from: classes3.dex */
    public static final class i extends h {
        private i(Uri uri, String str, f fVar, b bVar, List list, String str2, ImmutableList immutableList, Object obj) {
            super(uri, str, fVar, bVar, list, str2, immutableList, obj);
        }
    }

    /* loaded from: classes3.dex */
    public static final class j implements com.google.android.exoplayer2.k {

        /* renamed from: d, reason: collision with root package name */
        public static final j f27834d = new a().d();

        /* renamed from: e, reason: collision with root package name */
        public static final k.a f27835e = new k.a() { // from class: com.google.android.exoplayer2.y1
            @Override // com.google.android.exoplayer2.k.a
            public final k a(Bundle bundle) {
                v1.j c11;
                c11 = v1.j.c(bundle);
                return c11;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public final Uri f27836a;

        /* renamed from: b, reason: collision with root package name */
        public final String f27837b;

        /* renamed from: c, reason: collision with root package name */
        public final Bundle f27838c;

        /* loaded from: classes3.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private Uri f27839a;

            /* renamed from: b, reason: collision with root package name */
            private String f27840b;

            /* renamed from: c, reason: collision with root package name */
            private Bundle f27841c;

            public j d() {
                return new j(this);
            }

            public a e(Bundle bundle) {
                this.f27841c = bundle;
                return this;
            }

            public a f(Uri uri) {
                this.f27839a = uri;
                return this;
            }

            public a g(String str) {
                this.f27840b = str;
                return this;
            }
        }

        private j(a aVar) {
            this.f27836a = aVar.f27839a;
            this.f27837b = aVar.f27840b;
            this.f27838c = aVar.f27841c;
        }

        private static String b(int i11) {
            return Integer.toString(i11, 36);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ j c(Bundle bundle) {
            return new a().f((Uri) bundle.getParcelable(b(0))).g(bundle.getString(b(1))).e(bundle.getBundle(b(2))).d();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            return com.google.android.exoplayer2.util.p0.c(this.f27836a, jVar.f27836a) && com.google.android.exoplayer2.util.p0.c(this.f27837b, jVar.f27837b);
        }

        public int hashCode() {
            Uri uri = this.f27836a;
            int hashCode = (uri == null ? 0 : uri.hashCode()) * 31;
            String str = this.f27837b;
            return hashCode + (str != null ? str.hashCode() : 0);
        }

        @Override // com.google.android.exoplayer2.k
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            if (this.f27836a != null) {
                bundle.putParcelable(b(0), this.f27836a);
            }
            if (this.f27837b != null) {
                bundle.putString(b(1), this.f27837b);
            }
            if (this.f27838c != null) {
                bundle.putBundle(b(2), this.f27838c);
            }
            return bundle;
        }
    }

    /* loaded from: classes3.dex */
    public static final class k extends l {
        private k(l.a aVar) {
            super(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public static class l {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f27842a;

        /* renamed from: b, reason: collision with root package name */
        public final String f27843b;

        /* renamed from: c, reason: collision with root package name */
        public final String f27844c;

        /* renamed from: d, reason: collision with root package name */
        public final int f27845d;

        /* renamed from: e, reason: collision with root package name */
        public final int f27846e;

        /* renamed from: f, reason: collision with root package name */
        public final String f27847f;

        /* renamed from: g, reason: collision with root package name */
        public final String f27848g;

        /* loaded from: classes3.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private Uri f27849a;

            /* renamed from: b, reason: collision with root package name */
            private String f27850b;

            /* renamed from: c, reason: collision with root package name */
            private String f27851c;

            /* renamed from: d, reason: collision with root package name */
            private int f27852d;

            /* renamed from: e, reason: collision with root package name */
            private int f27853e;

            /* renamed from: f, reason: collision with root package name */
            private String f27854f;

            /* renamed from: g, reason: collision with root package name */
            private String f27855g;

            private a(l lVar) {
                this.f27849a = lVar.f27842a;
                this.f27850b = lVar.f27843b;
                this.f27851c = lVar.f27844c;
                this.f27852d = lVar.f27845d;
                this.f27853e = lVar.f27846e;
                this.f27854f = lVar.f27847f;
                this.f27855g = lVar.f27848g;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public k i() {
                return new k(this);
            }
        }

        private l(a aVar) {
            this.f27842a = aVar.f27849a;
            this.f27843b = aVar.f27850b;
            this.f27844c = aVar.f27851c;
            this.f27845d = aVar.f27852d;
            this.f27846e = aVar.f27853e;
            this.f27847f = aVar.f27854f;
            this.f27848g = aVar.f27855g;
        }

        public a a() {
            return new a();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return this.f27842a.equals(lVar.f27842a) && com.google.android.exoplayer2.util.p0.c(this.f27843b, lVar.f27843b) && com.google.android.exoplayer2.util.p0.c(this.f27844c, lVar.f27844c) && this.f27845d == lVar.f27845d && this.f27846e == lVar.f27846e && com.google.android.exoplayer2.util.p0.c(this.f27847f, lVar.f27847f) && com.google.android.exoplayer2.util.p0.c(this.f27848g, lVar.f27848g);
        }

        public int hashCode() {
            int hashCode = this.f27842a.hashCode() * 31;
            String str = this.f27843b;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f27844c;
            int hashCode3 = (((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f27845d) * 31) + this.f27846e) * 31;
            String str3 = this.f27847f;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f27848g;
            return hashCode4 + (str4 != null ? str4.hashCode() : 0);
        }
    }

    private v1(String str, e eVar, i iVar, g gVar, a2 a2Var, j jVar) {
        this.f27762a = str;
        this.f27763b = iVar;
        this.f27764c = iVar;
        this.f27765d = gVar;
        this.f27766e = a2Var;
        this.f27767f = eVar;
        this.f27768g = eVar;
        this.f27769h = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static v1 c(Bundle bundle) {
        String str = (String) com.google.android.exoplayer2.util.a.e(bundle.getString(f(0), ""));
        Bundle bundle2 = bundle.getBundle(f(1));
        g gVar = bundle2 == null ? g.f27814f : (g) g.f27815g.a(bundle2);
        Bundle bundle3 = bundle.getBundle(f(2));
        a2 a2Var = bundle3 == null ? a2.G : (a2) a2.H.a(bundle3);
        Bundle bundle4 = bundle.getBundle(f(3));
        e eVar = bundle4 == null ? e.f27794h : (e) d.f27783g.a(bundle4);
        Bundle bundle5 = bundle.getBundle(f(4));
        return new v1(str, eVar, null, gVar, a2Var, bundle5 == null ? j.f27834d : (j) j.f27835e.a(bundle5));
    }

    public static v1 d(Uri uri) {
        return new c().i(uri).a();
    }

    public static v1 e(String str) {
        return new c().j(str).a();
    }

    private static String f(int i11) {
        return Integer.toString(i11, 36);
    }

    public c b() {
        return new c();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v1)) {
            return false;
        }
        v1 v1Var = (v1) obj;
        return com.google.android.exoplayer2.util.p0.c(this.f27762a, v1Var.f27762a) && this.f27767f.equals(v1Var.f27767f) && com.google.android.exoplayer2.util.p0.c(this.f27763b, v1Var.f27763b) && com.google.android.exoplayer2.util.p0.c(this.f27765d, v1Var.f27765d) && com.google.android.exoplayer2.util.p0.c(this.f27766e, v1Var.f27766e) && com.google.android.exoplayer2.util.p0.c(this.f27769h, v1Var.f27769h);
    }

    public int hashCode() {
        int hashCode = this.f27762a.hashCode() * 31;
        h hVar = this.f27763b;
        return ((((((((hashCode + (hVar != null ? hVar.hashCode() : 0)) * 31) + this.f27765d.hashCode()) * 31) + this.f27767f.hashCode()) * 31) + this.f27766e.hashCode()) * 31) + this.f27769h.hashCode();
    }

    @Override // com.google.android.exoplayer2.k
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(f(0), this.f27762a);
        bundle.putBundle(f(1), this.f27765d.toBundle());
        bundle.putBundle(f(2), this.f27766e.toBundle());
        bundle.putBundle(f(3), this.f27767f.toBundle());
        bundle.putBundle(f(4), this.f27769h.toBundle());
        return bundle;
    }
}
