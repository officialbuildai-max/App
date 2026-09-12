package androidx.work.impl.model;

import androidx.work.BackoffPolicy;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes2.dex */
public final class j0 {
    private static final String A;
    public static final l.a B;

    /* renamed from: z, reason: collision with root package name */
    public static final a f15845z = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f15846a;

    /* renamed from: b, reason: collision with root package name */
    public WorkInfo.State f15847b;

    /* renamed from: c, reason: collision with root package name */
    public String f15848c;

    /* renamed from: d, reason: collision with root package name */
    public String f15849d;

    /* renamed from: e, reason: collision with root package name */
    public androidx.work.f f15850e;

    /* renamed from: f, reason: collision with root package name */
    public androidx.work.f f15851f;

    /* renamed from: g, reason: collision with root package name */
    public long f15852g;

    /* renamed from: h, reason: collision with root package name */
    public long f15853h;

    /* renamed from: i, reason: collision with root package name */
    public long f15854i;

    /* renamed from: j, reason: collision with root package name */
    public androidx.work.d f15855j;

    /* renamed from: k, reason: collision with root package name */
    public int f15856k;

    /* renamed from: l, reason: collision with root package name */
    public BackoffPolicy f15857l;

    /* renamed from: m, reason: collision with root package name */
    public long f15858m;

    /* renamed from: n, reason: collision with root package name */
    public long f15859n;

    /* renamed from: o, reason: collision with root package name */
    public long f15860o;

    /* renamed from: p, reason: collision with root package name */
    public long f15861p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f15862q;

    /* renamed from: r, reason: collision with root package name */
    public OutOfQuotaPolicy f15863r;

    /* renamed from: s, reason: collision with root package name */
    private int f15864s;

    /* renamed from: t, reason: collision with root package name */
    private final int f15865t;

    /* renamed from: u, reason: collision with root package name */
    private long f15866u;

    /* renamed from: v, reason: collision with root package name */
    private int f15867v;

    /* renamed from: w, reason: collision with root package name */
    private final int f15868w;

    /* renamed from: x, reason: collision with root package name */
    private String f15869x;

    /* renamed from: y, reason: collision with root package name */
    private Boolean f15870y;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a(boolean z10, int i11, BackoffPolicy backoffPolicy, long j11, long j12, int i12, boolean z11, long j13, long j14, long j15, long j16) {
            Intrinsics.h(backoffPolicy, "backoffPolicy");
            if (j16 != Long.MAX_VALUE && z11) {
                return i12 == 0 ? j16 : RangesKt.g(j16, 900000 + j12);
            }
            if (z10) {
                return j12 + RangesKt.j(backoffPolicy == BackoffPolicy.LINEAR ? i11 * j11 : Math.scalb((float) j11, i11 - 1), 18000000L);
            }
            if (!z11) {
                if (j12 == -1) {
                    return Long.MAX_VALUE;
                }
                return j12 + j13;
            }
            long j17 = i12 == 0 ? j12 + j13 : j12 + j15;
            if (j14 != j15 && i12 == 0) {
                j17 += j15 - j14;
            }
            return j17;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public String f15871a;

        /* renamed from: b, reason: collision with root package name */
        public WorkInfo.State f15872b;

        public b(String id2, WorkInfo.State state) {
            Intrinsics.h(id2, "id");
            Intrinsics.h(state, "state");
            this.f15871a = id2;
            this.f15872b = state;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.c(this.f15871a, bVar.f15871a) && this.f15872b == bVar.f15872b;
        }

        public int hashCode() {
            return (this.f15871a.hashCode() * 31) + this.f15872b.hashCode();
        }

        public String toString() {
            return "IdAndState(id=" + this.f15871a + ", state=" + this.f15872b + ')';
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final String f15873a;

        /* renamed from: b, reason: collision with root package name */
        private final WorkInfo.State f15874b;

        /* renamed from: c, reason: collision with root package name */
        private final androidx.work.f f15875c;

        /* renamed from: d, reason: collision with root package name */
        private final long f15876d;

        /* renamed from: e, reason: collision with root package name */
        private final long f15877e;

        /* renamed from: f, reason: collision with root package name */
        private final long f15878f;

        /* renamed from: g, reason: collision with root package name */
        private final androidx.work.d f15879g;

        /* renamed from: h, reason: collision with root package name */
        private final int f15880h;

        /* renamed from: i, reason: collision with root package name */
        private BackoffPolicy f15881i;

        /* renamed from: j, reason: collision with root package name */
        private long f15882j;

        /* renamed from: k, reason: collision with root package name */
        private long f15883k;

        /* renamed from: l, reason: collision with root package name */
        private int f15884l;

        /* renamed from: m, reason: collision with root package name */
        private final int f15885m;

        /* renamed from: n, reason: collision with root package name */
        private final long f15886n;

        /* renamed from: o, reason: collision with root package name */
        private final int f15887o;

        /* renamed from: p, reason: collision with root package name */
        private final List f15888p;

        /* renamed from: q, reason: collision with root package name */
        private final List f15889q;

        public c(String id2, WorkInfo.State state, androidx.work.f output, long j11, long j12, long j13, androidx.work.d constraints, int i11, BackoffPolicy backoffPolicy, long j14, long j15, int i12, int i13, long j16, int i14, List tags, List progress) {
            Intrinsics.h(id2, "id");
            Intrinsics.h(state, "state");
            Intrinsics.h(output, "output");
            Intrinsics.h(constraints, "constraints");
            Intrinsics.h(backoffPolicy, "backoffPolicy");
            Intrinsics.h(tags, "tags");
            Intrinsics.h(progress, "progress");
            this.f15873a = id2;
            this.f15874b = state;
            this.f15875c = output;
            this.f15876d = j11;
            this.f15877e = j12;
            this.f15878f = j13;
            this.f15879g = constraints;
            this.f15880h = i11;
            this.f15881i = backoffPolicy;
            this.f15882j = j14;
            this.f15883k = j15;
            this.f15884l = i12;
            this.f15885m = i13;
            this.f15886n = j16;
            this.f15887o = i14;
            this.f15888p = tags;
            this.f15889q = progress;
        }

        private final long a() {
            if (this.f15874b == WorkInfo.State.ENQUEUED) {
                return j0.f15845z.a(c(), this.f15880h, this.f15881i, this.f15882j, this.f15883k, this.f15884l, d(), this.f15876d, this.f15878f, this.f15877e, this.f15886n);
            }
            return Long.MAX_VALUE;
        }

        private final WorkInfo.b b() {
            long j11 = this.f15877e;
            if (j11 != 0) {
                return new WorkInfo.b(j11, this.f15878f);
            }
            return null;
        }

        public final boolean c() {
            return this.f15874b == WorkInfo.State.ENQUEUED && this.f15880h > 0;
        }

        public final boolean d() {
            return this.f15877e != 0;
        }

        public final WorkInfo e() {
            androidx.work.f fVar = !this.f15889q.isEmpty() ? (androidx.work.f) this.f15889q.get(0) : androidx.work.f.f15566c;
            UUID fromString = UUID.fromString(this.f15873a);
            Intrinsics.g(fromString, "fromString(...)");
            return new WorkInfo(fromString, this.f15874b, new HashSet(this.f15888p), this.f15875c, fVar, this.f15880h, this.f15885m, this.f15879g, this.f15876d, b(), a(), this.f15887o);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return Intrinsics.c(this.f15873a, cVar.f15873a) && this.f15874b == cVar.f15874b && Intrinsics.c(this.f15875c, cVar.f15875c) && this.f15876d == cVar.f15876d && this.f15877e == cVar.f15877e && this.f15878f == cVar.f15878f && Intrinsics.c(this.f15879g, cVar.f15879g) && this.f15880h == cVar.f15880h && this.f15881i == cVar.f15881i && this.f15882j == cVar.f15882j && this.f15883k == cVar.f15883k && this.f15884l == cVar.f15884l && this.f15885m == cVar.f15885m && this.f15886n == cVar.f15886n && this.f15887o == cVar.f15887o && Intrinsics.c(this.f15888p, cVar.f15888p) && Intrinsics.c(this.f15889q, cVar.f15889q);
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((((this.f15873a.hashCode() * 31) + this.f15874b.hashCode()) * 31) + this.f15875c.hashCode()) * 31) + androidx.collection.s.a(this.f15876d)) * 31) + androidx.collection.s.a(this.f15877e)) * 31) + androidx.collection.s.a(this.f15878f)) * 31) + this.f15879g.hashCode()) * 31) + this.f15880h) * 31) + this.f15881i.hashCode()) * 31) + androidx.collection.s.a(this.f15882j)) * 31) + androidx.collection.s.a(this.f15883k)) * 31) + this.f15884l) * 31) + this.f15885m) * 31) + androidx.collection.s.a(this.f15886n)) * 31) + this.f15887o) * 31) + this.f15888p.hashCode()) * 31) + this.f15889q.hashCode();
        }

        public String toString() {
            return "WorkInfoPojo(id=" + this.f15873a + ", state=" + this.f15874b + ", output=" + this.f15875c + ", initialDelay=" + this.f15876d + ", intervalDuration=" + this.f15877e + ", flexDuration=" + this.f15878f + ", constraints=" + this.f15879g + ", runAttemptCount=" + this.f15880h + ", backoffPolicy=" + this.f15881i + ", backoffDelayDuration=" + this.f15882j + ", lastEnqueueTime=" + this.f15883k + ", periodCount=" + this.f15884l + ", generation=" + this.f15885m + ", nextScheduleTimeOverride=" + this.f15886n + ", stopReason=" + this.f15887o + ", tags=" + this.f15888p + ", progress=" + this.f15889q + ')';
        }
    }

    static {
        String i11 = androidx.work.t.i("WorkSpec");
        Intrinsics.g(i11, "tagWithPrefix(...)");
        A = i11;
        B = new l.a() { // from class: androidx.work.impl.model.i0
            @Override // l.a
            public final Object apply(Object obj) {
                List b11;
                b11 = j0.b((List) obj);
                return b11;
            }
        };
    }

    public j0(String id2, WorkInfo.State state, String workerClassName, String inputMergerClassName, androidx.work.f input, androidx.work.f output, long j11, long j12, long j13, androidx.work.d constraints, int i11, BackoffPolicy backoffPolicy, long j14, long j15, long j16, long j17, boolean z10, OutOfQuotaPolicy outOfQuotaPolicy, int i12, int i13, long j18, int i14, int i15, String str, Boolean bool) {
        Intrinsics.h(id2, "id");
        Intrinsics.h(state, "state");
        Intrinsics.h(workerClassName, "workerClassName");
        Intrinsics.h(inputMergerClassName, "inputMergerClassName");
        Intrinsics.h(input, "input");
        Intrinsics.h(output, "output");
        Intrinsics.h(constraints, "constraints");
        Intrinsics.h(backoffPolicy, "backoffPolicy");
        Intrinsics.h(outOfQuotaPolicy, "outOfQuotaPolicy");
        this.f15846a = id2;
        this.f15847b = state;
        this.f15848c = workerClassName;
        this.f15849d = inputMergerClassName;
        this.f15850e = input;
        this.f15851f = output;
        this.f15852g = j11;
        this.f15853h = j12;
        this.f15854i = j13;
        this.f15855j = constraints;
        this.f15856k = i11;
        this.f15857l = backoffPolicy;
        this.f15858m = j14;
        this.f15859n = j15;
        this.f15860o = j16;
        this.f15861p = j17;
        this.f15862q = z10;
        this.f15863r = outOfQuotaPolicy;
        this.f15864s = i12;
        this.f15865t = i13;
        this.f15866u = j18;
        this.f15867v = i14;
        this.f15868w = i15;
        this.f15869x = str;
        this.f15870y = bool;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ j0(java.lang.String r37, androidx.work.WorkInfo.State r38, java.lang.String r39, java.lang.String r40, androidx.work.f r41, androidx.work.f r42, long r43, long r45, long r47, androidx.work.d r49, int r50, androidx.work.BackoffPolicy r51, long r52, long r54, long r56, long r58, boolean r60, androidx.work.OutOfQuotaPolicy r61, int r62, int r63, long r64, int r66, int r67, java.lang.String r68, java.lang.Boolean r69, int r70, kotlin.jvm.internal.DefaultConstructorMarker r71) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.j0.<init>(java.lang.String, androidx.work.WorkInfo$State, java.lang.String, java.lang.String, androidx.work.f, androidx.work.f, long, long, long, androidx.work.d, int, androidx.work.BackoffPolicy, long, long, long, long, boolean, androidx.work.OutOfQuotaPolicy, int, int, long, int, int, java.lang.String, java.lang.Boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j0(String newId, j0 other) {
        this(newId, other.f15847b, other.f15848c, other.f15849d, new androidx.work.f(other.f15850e), new androidx.work.f(other.f15851f), other.f15852g, other.f15853h, other.f15854i, new androidx.work.d(other.f15855j), other.f15856k, other.f15857l, other.f15858m, other.f15859n, other.f15860o, other.f15861p, other.f15862q, other.f15863r, other.f15864s, 0, other.f15866u, other.f15867v, other.f15868w, other.f15869x, other.f15870y, 524288, null);
        Intrinsics.h(newId, "newId");
        Intrinsics.h(other, "other");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j0(String id2, String workerClassName_) {
        this(id2, null, workerClassName_, null, null, null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 0L, 0, 0, null, null, 33554426, null);
        Intrinsics.h(id2, "id");
        Intrinsics.h(workerClassName_, "workerClassName_");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List b(List list) {
        if (list == null) {
            return null;
        }
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.v(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((c) it.next()).e());
        }
        return arrayList;
    }

    public static /* synthetic */ j0 e(j0 j0Var, String str, WorkInfo.State state, String str2, String str3, androidx.work.f fVar, androidx.work.f fVar2, long j11, long j12, long j13, androidx.work.d dVar, int i11, BackoffPolicy backoffPolicy, long j14, long j15, long j16, long j17, boolean z10, OutOfQuotaPolicy outOfQuotaPolicy, int i12, int i13, long j18, int i14, int i15, String str4, Boolean bool, int i16, Object obj) {
        String str5 = (i16 & 1) != 0 ? j0Var.f15846a : str;
        WorkInfo.State state2 = (i16 & 2) != 0 ? j0Var.f15847b : state;
        String str6 = (i16 & 4) != 0 ? j0Var.f15848c : str2;
        String str7 = (i16 & 8) != 0 ? j0Var.f15849d : str3;
        androidx.work.f fVar3 = (i16 & 16) != 0 ? j0Var.f15850e : fVar;
        androidx.work.f fVar4 = (i16 & 32) != 0 ? j0Var.f15851f : fVar2;
        long j19 = (i16 & 64) != 0 ? j0Var.f15852g : j11;
        long j20 = (i16 & 128) != 0 ? j0Var.f15853h : j12;
        long j21 = (i16 & 256) != 0 ? j0Var.f15854i : j13;
        androidx.work.d dVar2 = (i16 & 512) != 0 ? j0Var.f15855j : dVar;
        return j0Var.d(str5, state2, str6, str7, fVar3, fVar4, j19, j20, j21, dVar2, (i16 & 1024) != 0 ? j0Var.f15856k : i11, (i16 & 2048) != 0 ? j0Var.f15857l : backoffPolicy, (i16 & 4096) != 0 ? j0Var.f15858m : j14, (i16 & 8192) != 0 ? j0Var.f15859n : j15, (i16 & 16384) != 0 ? j0Var.f15860o : j16, (i16 & 32768) != 0 ? j0Var.f15861p : j17, (i16 & 65536) != 0 ? j0Var.f15862q : z10, (131072 & i16) != 0 ? j0Var.f15863r : outOfQuotaPolicy, (i16 & 262144) != 0 ? j0Var.f15864s : i12, (i16 & 524288) != 0 ? j0Var.f15865t : i13, (i16 & 1048576) != 0 ? j0Var.f15866u : j18, (i16 & 2097152) != 0 ? j0Var.f15867v : i14, (4194304 & i16) != 0 ? j0Var.f15868w : i15, (i16 & 8388608) != 0 ? j0Var.f15869x : str4, (i16 & 16777216) != 0 ? j0Var.f15870y : bool);
    }

    public final long c() {
        return f15845z.a(n(), this.f15856k, this.f15857l, this.f15858m, this.f15859n, this.f15864s, o(), this.f15852g, this.f15854i, this.f15853h, this.f15866u);
    }

    public final j0 d(String id2, WorkInfo.State state, String workerClassName, String inputMergerClassName, androidx.work.f input, androidx.work.f output, long j11, long j12, long j13, androidx.work.d constraints, int i11, BackoffPolicy backoffPolicy, long j14, long j15, long j16, long j17, boolean z10, OutOfQuotaPolicy outOfQuotaPolicy, int i12, int i13, long j18, int i14, int i15, String str, Boolean bool) {
        Intrinsics.h(id2, "id");
        Intrinsics.h(state, "state");
        Intrinsics.h(workerClassName, "workerClassName");
        Intrinsics.h(inputMergerClassName, "inputMergerClassName");
        Intrinsics.h(input, "input");
        Intrinsics.h(output, "output");
        Intrinsics.h(constraints, "constraints");
        Intrinsics.h(backoffPolicy, "backoffPolicy");
        Intrinsics.h(outOfQuotaPolicy, "outOfQuotaPolicy");
        return new j0(id2, state, workerClassName, inputMergerClassName, input, output, j11, j12, j13, constraints, i11, backoffPolicy, j14, j15, j16, j17, z10, outOfQuotaPolicy, i12, i13, j18, i14, i15, str, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j0)) {
            return false;
        }
        j0 j0Var = (j0) obj;
        return Intrinsics.c(this.f15846a, j0Var.f15846a) && this.f15847b == j0Var.f15847b && Intrinsics.c(this.f15848c, j0Var.f15848c) && Intrinsics.c(this.f15849d, j0Var.f15849d) && Intrinsics.c(this.f15850e, j0Var.f15850e) && Intrinsics.c(this.f15851f, j0Var.f15851f) && this.f15852g == j0Var.f15852g && this.f15853h == j0Var.f15853h && this.f15854i == j0Var.f15854i && Intrinsics.c(this.f15855j, j0Var.f15855j) && this.f15856k == j0Var.f15856k && this.f15857l == j0Var.f15857l && this.f15858m == j0Var.f15858m && this.f15859n == j0Var.f15859n && this.f15860o == j0Var.f15860o && this.f15861p == j0Var.f15861p && this.f15862q == j0Var.f15862q && this.f15863r == j0Var.f15863r && this.f15864s == j0Var.f15864s && this.f15865t == j0Var.f15865t && this.f15866u == j0Var.f15866u && this.f15867v == j0Var.f15867v && this.f15868w == j0Var.f15868w && Intrinsics.c(this.f15869x, j0Var.f15869x) && Intrinsics.c(this.f15870y, j0Var.f15870y);
    }

    public final Boolean f() {
        return this.f15870y;
    }

    public final int g() {
        return this.f15865t;
    }

    public final long h() {
        return this.f15866u;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((((((((((((((((((((((((this.f15846a.hashCode() * 31) + this.f15847b.hashCode()) * 31) + this.f15848c.hashCode()) * 31) + this.f15849d.hashCode()) * 31) + this.f15850e.hashCode()) * 31) + this.f15851f.hashCode()) * 31) + androidx.collection.s.a(this.f15852g)) * 31) + androidx.collection.s.a(this.f15853h)) * 31) + androidx.collection.s.a(this.f15854i)) * 31) + this.f15855j.hashCode()) * 31) + this.f15856k) * 31) + this.f15857l.hashCode()) * 31) + androidx.collection.s.a(this.f15858m)) * 31) + androidx.collection.s.a(this.f15859n)) * 31) + androidx.collection.s.a(this.f15860o)) * 31) + androidx.collection.s.a(this.f15861p)) * 31) + androidx.compose.foundation.e.a(this.f15862q)) * 31) + this.f15863r.hashCode()) * 31) + this.f15864s) * 31) + this.f15865t) * 31) + androidx.collection.s.a(this.f15866u)) * 31) + this.f15867v) * 31) + this.f15868w) * 31;
        String str = this.f15869x;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.f15870y;
        return hashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public final int i() {
        return this.f15867v;
    }

    public final int j() {
        return this.f15864s;
    }

    public final int k() {
        return this.f15868w;
    }

    public final String l() {
        return this.f15869x;
    }

    public final boolean m() {
        return !Intrinsics.c(androidx.work.d.f15544k, this.f15855j);
    }

    public final boolean n() {
        return this.f15847b == WorkInfo.State.ENQUEUED && this.f15856k > 0;
    }

    public final boolean o() {
        return this.f15853h != 0;
    }

    public final void p(long j11) {
        this.f15866u = j11;
    }

    public final void q(int i11) {
        this.f15867v = i11;
    }

    public final void r(long j11) {
        if (j11 < 900000) {
            androidx.work.t.e().k(A, "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        s(RangesKt.g(j11, 900000L), RangesKt.g(j11, 900000L));
    }

    public final void s(long j11, long j12) {
        if (j11 < 900000) {
            androidx.work.t.e().k(A, "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        this.f15853h = RangesKt.g(j11, 900000L);
        if (j12 < 300000) {
            androidx.work.t.e().k(A, "Flex duration lesser than minimum allowed value; Changed to 300000");
        }
        if (j12 > this.f15853h) {
            androidx.work.t.e().k(A, "Flex duration greater than interval duration; Changed to " + j11);
        }
        this.f15854i = RangesKt.n(j12, 300000L, this.f15853h);
    }

    public final void t(String str) {
        this.f15869x = str;
    }

    public String toString() {
        return "{WorkSpec: " + this.f15846a + '}';
    }
}
