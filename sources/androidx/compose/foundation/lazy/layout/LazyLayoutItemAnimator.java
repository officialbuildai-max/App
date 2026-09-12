package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableScatterSet;
import androidx.collection.n0;
import androidx.collection.v0;
import androidx.collection.w0;
import androidx.compose.ui.f;
import androidx.compose.ui.graphics.a4;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class LazyLayoutItemAnimator {

    /* renamed from: b, reason: collision with root package name */
    private p f3033b;

    /* renamed from: c, reason: collision with root package name */
    private int f3034c;

    /* renamed from: j, reason: collision with root package name */
    private androidx.compose.ui.node.n f3041j;

    /* renamed from: a, reason: collision with root package name */
    private final n0 f3032a = v0.d();

    /* renamed from: d, reason: collision with root package name */
    private final MutableScatterSet f3035d = w0.a();

    /* renamed from: e, reason: collision with root package name */
    private final List f3036e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private final List f3037f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private final List f3038g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private final List f3039h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private final List f3040i = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    private final androidx.compose.ui.f f3042k = new DisplayingDisappearingItemsElement(this);

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsElement;", "Landroidx/compose/ui/node/l0;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$a;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "animator", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;)V", com.mbridge.msdk.foundation.same.report.j.f35620b, "()Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$a;", "node", "", CampaignEx.JSON_KEY_AD_K, "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$a;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_OTHER, "", "equals", "(Ljava/lang/Object;)Z", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes.dex */
    private static final /* data */ class DisplayingDisappearingItemsElement extends androidx.compose.ui.node.l0 {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final LazyLayoutItemAnimator animator;

        public DisplayingDisappearingItemsElement(LazyLayoutItemAnimator lazyLayoutItemAnimator) {
            this.animator = lazyLayoutItemAnimator;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DisplayingDisappearingItemsElement) && Intrinsics.c(this.animator, ((DisplayingDisappearingItemsElement) other).animator);
        }

        public int hashCode() {
            return this.animator.hashCode();
        }

        @Override // androidx.compose.ui.node.l0
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public a getNode() {
            return new a(this.animator);
        }

        @Override // androidx.compose.ui.node.l0
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(a node) {
            node.D1(this.animator);
        }

        public String toString() {
            return "DisplayingDisappearingItemsElement(animator=" + this.animator + ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a extends f.c implements androidx.compose.ui.node.n {

        /* renamed from: n, reason: collision with root package name */
        private LazyLayoutItemAnimator f3044n;

        public a(LazyLayoutItemAnimator lazyLayoutItemAnimator) {
            this.f3044n = lazyLayoutItemAnimator;
        }

        public final void D1(LazyLayoutItemAnimator lazyLayoutItemAnimator) {
            if (Intrinsics.c(this.f3044n, lazyLayoutItemAnimator) || !getNode().k1()) {
                return;
            }
            this.f3044n.n();
            lazyLayoutItemAnimator.f3041j = this;
            this.f3044n = lazyLayoutItemAnimator;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.c(this.f3044n, ((a) obj).f3044n);
        }

        public int hashCode() {
            return this.f3044n.hashCode();
        }

        @Override // androidx.compose.ui.node.n
        public void n(z.c cVar) {
            List list = this.f3044n.f3040i;
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                k kVar = (k) list.get(i11);
                GraphicsLayer e11 = kVar.e();
                if (e11 != null) {
                    float h11 = o0.p.h(kVar.d());
                    float h12 = h11 - o0.p.h(e11.w());
                    float i12 = o0.p.i(kVar.d()) - o0.p.i(e11.w());
                    cVar.H0().c().c(h12, i12);
                    try {
                        androidx.compose.ui.graphics.layer.d.a(cVar, e11);
                    } finally {
                        cVar.H0().c().c(-h12, -i12);
                    }
                }
            }
            cVar.Y0();
        }

        @Override // androidx.compose.ui.f.c
        public void n1() {
            this.f3044n.f3041j = this;
        }

        @Override // androidx.compose.ui.f.c
        public void o1() {
            this.f3044n.n();
        }

        public String toString() {
            return "DisplayingDisappearingItemsNode(animator=" + this.f3044n + ')';
        }

        @Override // androidx.compose.ui.node.n
        public /* synthetic */ void w0() {
            androidx.compose.ui.node.m.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b {

        /* renamed from: a, reason: collision with root package name */
        private k[] f3045a;

        /* renamed from: b, reason: collision with root package name */
        private o0.b f3046b;

        /* renamed from: c, reason: collision with root package name */
        private int f3047c;

        /* renamed from: d, reason: collision with root package name */
        private int f3048d;

        /* renamed from: e, reason: collision with root package name */
        private int f3049e;

        /* renamed from: f, reason: collision with root package name */
        private int f3050f;

        /* renamed from: g, reason: collision with root package name */
        private int f3051g;

        public b() {
            k[] kVarArr;
            kVarArr = l.f3136a;
            this.f3045a = kVarArr;
            this.f3049e = 1;
        }

        private final boolean h() {
            for (k kVar : this.f3045a) {
            }
            return false;
        }

        public static /* synthetic */ void l(b bVar, s sVar, kotlinx.coroutines.n0 n0Var, a4 a4Var, int i11, int i12, int i13, int i14, Object obj) {
            if ((i14 & 32) != 0) {
                i13 = LazyLayoutItemAnimator.this.e(sVar);
            }
            bVar.k(sVar, n0Var, a4Var, i11, i12, i13);
        }

        public final k[] a() {
            return this.f3045a;
        }

        public final o0.b b() {
            return this.f3046b;
        }

        public final int c() {
            return this.f3047c;
        }

        public final int d() {
            return this.f3048d;
        }

        public final int e() {
            return this.f3051g;
        }

        public final int f() {
            return this.f3050f;
        }

        public final int g() {
            return this.f3049e;
        }

        public final void i(int i11) {
            this.f3048d = i11;
        }

        public final void j(int i11) {
            this.f3049e = i11;
        }

        public final void k(s sVar, kotlinx.coroutines.n0 n0Var, a4 a4Var, int i11, int i12, int i13) {
            if (!h()) {
                this.f3050f = i11;
                this.f3051g = i12;
            }
            int length = this.f3045a.length;
            for (int b11 = sVar.b(); b11 < length; b11++) {
                k kVar = this.f3045a[b11];
            }
            if (this.f3045a.length != sVar.b()) {
                Object[] copyOf = Arrays.copyOf(this.f3045a, sVar.b());
                Intrinsics.g(copyOf, "copyOf(this, newSize)");
                this.f3045a = (k[]) copyOf;
            }
            this.f3046b = o0.b.a(sVar.a());
            this.f3047c = i13;
            this.f3048d = sVar.k();
            this.f3049e = sVar.d();
            int b12 = sVar.b();
            for (int i14 = 0; i14 < b12; i14++) {
                l.b(sVar.i(i14));
                k kVar2 = this.f3045a[i14];
                this.f3045a[i14] = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int e(s sVar) {
        long j11 = sVar.j(0);
        return !sVar.e() ? o0.p.i(j11) : o0.p.h(j11);
    }

    private final boolean f(s sVar) {
        int b11 = sVar.b();
        for (int i11 = 0; i11 < b11; i11++) {
            l.b(sVar.i(i11));
        }
        return false;
    }

    private final int g(s sVar) {
        long j11 = sVar.j(0);
        return sVar.e() ? o0.p.i(j11) : o0.p.h(j11);
    }

    private final void j(s sVar, int i11, b bVar) {
        long j11 = sVar.j(0);
        if (sVar.e()) {
            o0.p.e(j11, 0, i11, 1, null);
        } else {
            o0.p.e(j11, i11, 0, 2, null);
        }
        for (k kVar : bVar.a()) {
        }
    }

    static /* synthetic */ void k(LazyLayoutItemAnimator lazyLayoutItemAnimator, s sVar, int i11, b bVar, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            Object b11 = lazyLayoutItemAnimator.f3032a.b(sVar.getKey());
            Intrinsics.e(b11);
            bVar = (b) b11;
        }
        lazyLayoutItemAnimator.j(sVar, i11, bVar);
    }

    private final void m(Object obj) {
        k[] a11;
        b bVar = (b) this.f3032a.o(obj);
        if (bVar == null || (a11 = bVar.a()) == null) {
            return;
        }
        for (k kVar : a11) {
        }
    }

    private final void o(s sVar, boolean z10) {
        Object b11 = this.f3032a.b(sVar.getKey());
        Intrinsics.e(b11);
        for (k kVar : ((b) b11).a()) {
        }
    }

    static /* synthetic */ void p(LazyLayoutItemAnimator lazyLayoutItemAnimator, s sVar, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        lazyLayoutItemAnimator.o(sVar, z10);
    }

    private final int q(int[] iArr, s sVar) {
        int k11 = sVar.k();
        int d11 = sVar.d() + k11;
        int i11 = 0;
        while (k11 < d11) {
            int h11 = iArr[k11] + sVar.h();
            iArr[k11] = h11;
            i11 = Math.max(i11, h11);
            k11++;
        }
        return i11;
    }

    public final k d(Object obj, int i11) {
        k[] a11;
        b bVar = (b) this.f3032a.b(obj);
        if (bVar == null || (a11 = bVar.a()) == null) {
            return null;
        }
        return a11[i11];
    }

    public final long h() {
        long a11 = o0.t.f70747b.a();
        List list = this.f3040i;
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            k kVar = (k) list.get(i11);
            GraphicsLayer e11 = kVar.e();
            if (e11 != null) {
                a11 = o0.u.a(Math.max(o0.t.g(a11), o0.p.h(kVar.h()) + o0.t.g(e11.v())), Math.max(o0.t.f(a11), o0.p.i(kVar.h()) + o0.t.f(e11.v())));
            }
        }
        return a11;
    }

    public final androidx.compose.ui.f i() {
        return this.f3042k;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0228, code lost:
    
        r30 = r3;
        r14 = r5;
        kotlin.collections.ArraysKt.y(r30, 0, 0, 0, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0246, code lost:
    
        if (r40.f3037f.isEmpty() != false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0248, code lost:
    
        r0 = r40.f3037f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x024f, code lost:
    
        if (r0.size() <= 1) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0251, code lost:
    
        kotlin.collections.CollectionsKt.A(r0, new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortBy$1(r15));
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0259, code lost:
    
        r13 = r40.f3037f;
        r5 = r13.size();
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0260, code lost:
    
        if (r4 >= r5) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0262, code lost:
    
        r3 = (androidx.compose.foundation.lazy.layout.s) r13.get(r4);
        k(r40, r3, (r52 + q(r30, r3)) - r3.h(), null, 4, null);
        p(r40, r3, false, r14, null);
        r4 = r4 + 1;
        r5 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0046, code lost:
    
        r40.f3034c = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x029d, code lost:
    
        kotlin.collections.ArraysKt.y(r30, 0, 0, 0, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x02b0, code lost:
    
        r0 = r40.f3035d;
        r1 = r0.f2322b;
        r0 = r0.f2321a;
        r2 = r0.length - r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x02b8, code lost:
    
        if (r2 < 0) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x02ba, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x02bb, code lost:
    
        r12 = r0[r4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x02c5, code lost:
    
        if (((((~r12) << 7) & r12) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x02c7, code lost:
    
        r3 = 8 - ((~(r4 - r2)) >>> 31);
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x02d1, code lost:
    
        if (r5 >= r3) goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x02d7, code lost:
    
        if ((r12 & 255) >= 128) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0048, code lost:
    
        if (r47 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x02d9, code lost:
    
        r7 = r1[(r4 << 3) + r5];
        r8 = r40.f3032a.b(r7);
        kotlin.jvm.internal.Intrinsics.e(r8);
        r8 = (androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.b) r8;
        r14 = r45.a(r7);
        r41 = r0;
        r8.j(java.lang.Math.min(r11, r8.g()));
        r39 = r1;
        r8.i(java.lang.Math.min(r11 - r8.g(), r8.d()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x030e, code lost:
    
        if (r14 != (-1)) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0310, code lost:
    
        r1 = r8.a();
        r8 = r1.length;
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0316, code lost:
    
        if (r14 >= r8) goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0318, code lost:
    
        r24 = r1[r14];
        r14 = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x031f, code lost:
    
        m(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0387, code lost:
    
        r12 = r12 >> 8;
        r5 = r5 + 1;
        r0 = r41;
        r11 = r49;
        r1 = r39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0323, code lost:
    
        r1 = r8.b();
        kotlin.jvm.internal.Intrinsics.e(r1);
        r1 = r46.a(r14, r8.d(), r8.g(), r1.r());
        r1.c(true);
        r0 = r8.a();
        r11 = r0.length;
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x004a, code lost:
    
        o0.q.a(0, r41);
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0348, code lost:
    
        if (r9 >= r11) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x034a, code lost:
    
        r24 = r0[r9];
        r9 = r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0351, code lost:
    
        if (r15 == null) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0357, code lost:
    
        if (r14 != r15.a(r7)) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0359, code lost:
    
        m(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x035d, code lost:
    
        r8.k(r1, r53, r54, r51, r52, r8.c());
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0372, code lost:
    
        if (r14 >= r40.f3034c) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0374, code lost:
    
        r40.f3038g.add(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0051, code lost:
    
        if (r48 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x037a, code lost:
    
        r40.f3039h.add(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0382, code lost:
    
        r41 = r0;
        r39 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0394, code lost:
    
        r41 = r0;
        r39 = r1;
        r1 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x039b, code lost:
    
        if (r3 != 8) goto L197;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x03a5, code lost:
    
        if (r4 == r2) goto L198;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x03a7, code lost:
    
        r4 = r4 + r1;
        r0 = r41;
        r11 = r49;
        r1 = r39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x039e, code lost:
    
        r41 = r0;
        r39 = r1;
        r1 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0053, code lost:
    
        if (r50 != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x03be, code lost:
    
        if (r40.f3038g.isEmpty() != false) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x03c0, code lost:
    
        r0 = r40.f3038g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x03c7, code lost:
    
        if (r0.size() <= 1) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x03c9, code lost:
    
        kotlin.collections.CollectionsKt.A(r0, new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortByDescending$2(r45));
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x03d1, code lost:
    
        r0 = r40.f3038g;
        r1 = r0.size();
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x03d8, code lost:
    
        if (r4 >= r1) goto L202;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x03da, code lost:
    
        r2 = (androidx.compose.foundation.lazy.layout.s) r0.get(r4);
        r3 = r40.f3032a.b(r2.getKey());
        kotlin.jvm.internal.Intrinsics.e(r3);
        r3 = (androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.b) r3;
        r5 = r30;
        r7 = q(r5, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x03f5, code lost:
    
        if (r48 == false) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x03f7, code lost:
    
        r8 = g((androidx.compose.foundation.lazy.layout.s) kotlin.collections.CollectionsKt.i0(r44));
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0056, code lost:
    
        r15 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0406, code lost:
    
        r2.f(r8 - r7, r3.c(), r42, r43);
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0413, code lost:
    
        if (r47 == false) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0415, code lost:
    
        o(r2, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0418, code lost:
    
        r4 = r4 + 1;
        r30 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0402, code lost:
    
        r8 = r3.f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x041c, code lost:
    
        r7 = r42;
        r9 = r43;
        r5 = r30;
        kotlin.collections.ArraysKt.y(r5, 0, 0, 0, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
    
        r0 = r40.f3032a;
        r2 = r0.f2420b;
        r0 = r0.f2419a;
        r3 = r0.length - 2;
        r4 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0440, code lost:
    
        if (r40.f3039h.isEmpty() != false) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0442, code lost:
    
        r0 = r40.f3039h;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0449, code lost:
    
        if (r0.size() <= 1) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x044b, code lost:
    
        kotlin.collections.CollectionsKt.A(r0, new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortBy$2(r45));
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0453, code lost:
    
        r0 = r40.f3039h;
        r1 = r0.size();
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x045a, code lost:
    
        if (r4 >= r1) goto L205;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x045c, code lost:
    
        r2 = (androidx.compose.foundation.lazy.layout.s) r0.get(r4);
        r3 = r40.f3032a.b(r2.getKey());
        kotlin.jvm.internal.Intrinsics.e(r3);
        r3 = (androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.b) r3;
        r8 = q(r5, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0475, code lost:
    
        if (r48 == false) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0477, code lost:
    
        r10 = g((androidx.compose.foundation.lazy.layout.s) kotlin.collections.CollectionsKt.u0(r44));
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x048b, code lost:
    
        r2.f(r10 + r8, r3.c(), r7, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006f, code lost:
    
        if (r3 < 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0494, code lost:
    
        if (r47 == false) goto L207;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0496, code lost:
    
        o(r2, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0499, code lost:
    
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0482, code lost:
    
        r10 = r3.e() - r2.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x049b, code lost:
    
        r0 = r40.f3038g;
        kotlin.collections.CollectionsKt.Y(r0);
        r1 = kotlin.Unit.f67184a;
        r44.addAll(0, r0);
        r44.addAll(r40.f3039h);
        r40.f3036e.clear();
        r40.f3037f.clear();
        r40.f3038g.clear();
        r40.f3039h.clear();
        r40.f3035d.m();
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x04ca, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0071, code lost:
    
        r5 = 0;
        r47 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0432, code lost:
    
        r7 = r42;
        r9 = r43;
        r5 = r30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x023b, code lost:
    
        r30 = r3;
        r14 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x02ad, code lost:
    
        r30 = r3;
        r14 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x00b0, code lost:
    
        r25 = r0;
        r0 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x00bc, code lost:
    
        r24 = r13;
        r47 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x0058, code lost:
    
        r15 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x004e, code lost:
    
        o0.q.a(r41, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0045, code lost:
    
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0074, code lost:
    
        r14 = r0[r5];
        r24 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0080, code lost:
    
        if (((((~r14) << 7) & r14) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0082, code lost:
    
        r12 = 8 - ((~(r5 - r3)) >>> 31);
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008a, code lost:
    
        if (r13 >= r12) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0090, code lost:
    
        if ((r14 & 255) >= 128) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0092, code lost:
    
        r25 = r0;
        r40.f3035d.h(r2[(r5 << 3) + r13]);
        r4 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a4, code lost:
    
        r14 = r14 >> r4;
        r13 = r13 + 1;
        r0 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a2, code lost:
    
        r25 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00aa, code lost:
    
        r25 = r0;
        r0 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ad, code lost:
    
        if (r12 != r4) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b3, code lost:
    
        if (r5 == r3) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b5, code lost:
    
        r5 = r5 + r0;
        r13 = r24;
        r0 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c0, code lost:
    
        r0 = r44.size();
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c7, code lost:
    
        if (r2 >= r0) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c9, code lost:
    
        r3 = (androidx.compose.foundation.lazy.layout.s) r44.get(r2);
        r40.f3035d.x(r3.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00dc, code lost:
    
        if (f(r3) == false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00de, code lost:
    
        r5 = (androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.b) r40.f3032a.b(r3.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ea, code lost:
    
        if (r24 == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ec, code lost:
    
        r15 = r24;
        r14 = r15.a(r3.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00fa, code lost:
    
        if (r14 != (-1)) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00fc, code lost:
    
        if (r15 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00fe, code lost:
    
        r24 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0103, code lost:
    
        if (r5 != null) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0105, code lost:
    
        r5 = new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.b(r40);
        androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.b.l(r5, r3, r53, r54, r51, r52, 0, 32, null);
        r40.f3032a.r(r3.getKey(), r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x012c, code lost:
    
        if (r3.getIndex() == r14) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x012e, code lost:
    
        if (r14 == (-1)) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0130, code lost:
    
        if (r14 >= r1) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0132, code lost:
    
        r40.f3036e.add(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0137, code lost:
    
        r13 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01b1, code lost:
    
        r2 = r2 + r13;
        r24 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x013c, code lost:
    
        r40.f3037f.add(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0142, code lost:
    
        r12 = r3.j(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x014b, code lost:
    
        if (r3.e() == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x014d, code lost:
    
        r4 = o0.p.i(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0156, code lost:
    
        j(r3, r4, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0159, code lost:
    
        if (r24 == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x015b, code lost:
    
        r3 = r5.a();
        r4 = r3.length;
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0161, code lost:
    
        if (r5 >= r4) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0163, code lost:
    
        r12 = r3[r5];
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0152, code lost:
    
        r4 = o0.p.h(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0168, code lost:
    
        if (r47 == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x016a, code lost:
    
        androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.b.l(r5, r3, r53, r54, r51, r52, 0, 32, null);
        r4 = r5.a();
        r13 = r4.length;
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0185, code lost:
    
        if (r14 >= r13) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0187, code lost:
    
        r25 = r4[r14];
        r14 = r14 + 1;
        r13 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0190, code lost:
    
        r13 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0191, code lost:
    
        if (r24 == false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0193, code lost:
    
        r4 = r5.a();
        r5 = r4.length;
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0199, code lost:
    
        if (r14 >= r5) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x019b, code lost:
    
        r23 = r4[r14];
        r14 = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x019f, code lost:
    
        p(r40, r3, false, 2, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0036, code lost:
    
        r1 = r40.f3034c;
        r2 = (androidx.compose.foundation.lazy.layout.s) kotlin.collections.CollectionsKt.k0(r44);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0101, code lost:
    
        r24 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00f7, code lost:
    
        r15 = r24;
        r14 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01a5, code lost:
    
        r15 = r24;
        r13 = 1;
        m(r3.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01b8, code lost:
    
        r15 = r24;
        r4 = 0;
        r5 = 2;
        r3 = new int[r11];
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01c1, code lost:
    
        if (r0 >= r11) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01c3, code lost:
    
        r3[r0] = r4;
        r0 = r0 + 1;
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01c8, code lost:
    
        if (r47 == false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x003e, code lost:
    
        if (r2 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01ca, code lost:
    
        if (r15 == null) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01d4, code lost:
    
        if (r40.f3036e.isEmpty() != false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01d6, code lost:
    
        r0 = r40.f3036e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01dc, code lost:
    
        if (r0.size() <= 1) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01de, code lost:
    
        kotlin.collections.CollectionsKt.A(r0, new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortByDescending$1(r15));
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01e6, code lost:
    
        r13 = r40.f3036e;
        r4 = r13.size();
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01ed, code lost:
    
        if (r2 >= r4) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01ef, code lost:
    
        r1 = (androidx.compose.foundation.lazy.layout.s) r13.get(r2);
        r14 = r5;
        k(r40, r1, r51 - q(r3, r1), null, 4, null);
        p(r40, r1, false, r14, null);
        r2 = r2 + 1;
        r5 = r14;
        r4 = r4;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0040, code lost:
    
        r2 = r2.getIndex();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(int r41, int r42, int r43, java.util.List r44, final androidx.compose.foundation.lazy.layout.p r45, androidx.compose.foundation.lazy.layout.t r46, boolean r47, boolean r48, int r49, boolean r50, int r51, int r52, kotlinx.coroutines.n0 r53, androidx.compose.ui.graphics.a4 r54) {
        /*
            Method dump skipped, instructions count: 1227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.l(int, int, int, java.util.List, androidx.compose.foundation.lazy.layout.p, androidx.compose.foundation.lazy.layout.t, boolean, boolean, int, boolean, int, int, kotlinx.coroutines.n0, androidx.compose.ui.graphics.a4):void");
    }

    public final void n() {
        if (this.f3032a.f()) {
            n0 n0Var = this.f3032a;
            Object[] objArr = n0Var.f2421c;
            long[] jArr = n0Var.f2419a;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i11 = 0;
                while (true) {
                    long j11 = jArr[i11];
                    if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i12 = 8 - ((~(i11 - length)) >>> 31);
                        for (int i13 = 0; i13 < i12; i13++) {
                            if ((255 & j11) < 128) {
                                for (k kVar : ((b) objArr[(i11 << 3) + i13]).a()) {
                                }
                            }
                            j11 >>= 8;
                        }
                        if (i12 != 8) {
                            break;
                        }
                    }
                    if (i11 == length) {
                        break;
                    } else {
                        i11++;
                    }
                }
            }
            this.f3032a.h();
        }
        this.f3033b = p.f3141a;
        this.f3034c = -1;
    }
}
