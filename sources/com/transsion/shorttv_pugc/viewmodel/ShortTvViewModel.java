package com.transsion.shorttv_pugc.viewmodel;

import android.content.Context;
import androidx.view.LiveData;
import androidx.view.b0;
import androidx.view.t0;
import androidx.view.u0;
import com.transsion.shorttv.R$string;
import com.transsion.shorttv_pugc.ShorttvModel;
import com.transsion.shorttv_pugc.utils.ShortTvExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.k1;
import kotlinx.coroutines.m1;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;
import lg.a;
import st.i;

/* loaded from: classes6.dex */
public final class ShortTvViewModel extends t0 {
    public static final a M = new a(null);
    private final Lazy A;
    private final Lazy B;
    private final Lazy C;
    private final Lazy D;
    private final Lazy E;
    private final List F;
    private final List G;
    private String H;
    private List I;
    private String J;
    private boolean K;
    private String L;

    /* renamed from: a */
    private final rt.a f54520a = (rt.a) zg.c.f79537e.a().h(rt.a.class);

    /* renamed from: b */
    private final k1 f54521b;

    /* renamed from: c */
    private final b0 f54522c;

    /* renamed from: d */
    private final b0 f54523d;

    /* renamed from: e */
    private final b0 f54524e;

    /* renamed from: f */
    private final b0 f54525f;

    /* renamed from: g */
    private final b0 f54526g;

    /* renamed from: h */
    private final b0 f54527h;

    /* renamed from: i */
    private final LiveData f54528i;

    /* renamed from: j */
    private final b0 f54529j;

    /* renamed from: k */
    private final LiveData f54530k;

    /* renamed from: l */
    private final b0 f54531l;

    /* renamed from: m */
    private final LiveData f54532m;

    /* renamed from: n */
    private final b0 f54533n;

    /* renamed from: o */
    private final LiveData f54534o;

    /* renamed from: p */
    private final b0 f54535p;

    /* renamed from: q */
    private final LiveData f54536q;

    /* renamed from: r */
    private final b0 f54537r;

    /* renamed from: s */
    private final LiveData f54538s;

    /* renamed from: t */
    private final b0 f54539t;

    /* renamed from: u */
    private LiveData f54540u;

    /* renamed from: v */
    private final b0 f54541v;

    /* renamed from: w */
    private final LiveData f54542w;

    /* renamed from: x */
    private final tt.a f54543x;

    /* renamed from: y */
    private final Lazy f54544y;

    /* renamed from: z */
    private final Lazy f54545z;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ShortTvViewModel() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.g(newSingleThreadExecutor, "newSingleThreadExecutor(...)");
        this.f54521b = m1.c(newSingleThreadExecutor);
        this.f54522c = new b0();
        this.f54523d = new b0();
        this.f54524e = new b0();
        this.f54525f = new b0();
        this.f54526g = new b0();
        b0 b0Var = new b0();
        this.f54527h = b0Var;
        this.f54528i = b0Var;
        b0 b0Var2 = new b0();
        this.f54529j = b0Var2;
        this.f54530k = b0Var2;
        b0 b0Var3 = new b0();
        this.f54531l = b0Var3;
        this.f54532m = b0Var3;
        b0 b0Var4 = new b0();
        this.f54533n = b0Var4;
        this.f54534o = b0Var4;
        b0 b0Var5 = new b0();
        this.f54535p = b0Var5;
        this.f54536q = b0Var5;
        b0 b0Var6 = new b0();
        this.f54537r = b0Var6;
        this.f54538s = b0Var6;
        b0 b0Var7 = new b0();
        this.f54539t = b0Var7;
        this.f54540u = b0Var7;
        b0 b0Var8 = new b0();
        this.f54541v = b0Var8;
        this.f54542w = b0Var8;
        this.f54543x = ys.a.f79179a.b();
        this.f54544y = LazyKt.b(new Function0() { // from class: com.transsion.shorttv_pugc.viewmodel.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                st.c j02;
                j02 = ShortTvViewModel.j0(ShortTvViewModel.this);
                return j02;
            }
        });
        this.f54545z = LazyKt.b(new Function0() { // from class: com.transsion.shorttv_pugc.viewmodel.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                st.e l02;
                l02 = ShortTvViewModel.l0(ShortTvViewModel.this);
                return l02;
            }
        });
        this.A = LazyKt.b(new Function0() { // from class: com.transsion.shorttv_pugc.viewmodel.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                st.d k02;
                k02 = ShortTvViewModel.k0(ShortTvViewModel.this);
                return k02;
            }
        });
        this.B = LazyKt.b(new Function0() { // from class: com.transsion.shorttv_pugc.viewmodel.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                st.a o02;
                o02 = ShortTvViewModel.o0(ShortTvViewModel.this);
                return o02;
            }
        });
        this.C = LazyKt.b(new Function0() { // from class: com.transsion.shorttv_pugc.viewmodel.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                st.f m02;
                m02 = ShortTvViewModel.m0(ShortTvViewModel.this);
                return m02;
            }
        });
        this.D = LazyKt.b(new Function0() { // from class: com.transsion.shorttv_pugc.viewmodel.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                i p02;
                p02 = ShortTvViewModel.p0(ShortTvViewModel.this);
                return p02;
            }
        });
        this.E = LazyKt.b(new Function0() { // from class: com.transsion.shorttv_pugc.viewmodel.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                st.h n02;
                n02 = ShortTvViewModel.n0(ShortTvViewModel.this);
                return n02;
            }
        });
        this.F = new ArrayList();
        this.G = new ArrayList();
        this.H = "";
    }

    public static /* synthetic */ void a0(ShortTvViewModel shortTvViewModel, String str, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            str = shortTvViewModel.H;
        }
        shortTvViewModel.Z(str, i11, i12);
    }

    public static final st.c j0(ShortTvViewModel shortTvViewModel) {
        tt.a aVar = shortTvViewModel.f54543x;
        if (aVar != null) {
            return aVar.b();
        }
        return null;
    }

    public static final st.d k0(ShortTvViewModel shortTvViewModel) {
        tt.a aVar = shortTvViewModel.f54543x;
        if (aVar != null) {
            return aVar.e();
        }
        return null;
    }

    public static final st.e l0(ShortTvViewModel shortTvViewModel) {
        tt.a aVar = shortTvViewModel.f54543x;
        if (aVar != null) {
            return aVar.f();
        }
        return null;
    }

    public static final st.f m0(ShortTvViewModel shortTvViewModel) {
        tt.a aVar = shortTvViewModel.f54543x;
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }

    public static final st.h n0(ShortTvViewModel shortTvViewModel) {
        tt.a aVar = shortTvViewModel.f54543x;
        if (aVar != null) {
            return aVar.d();
        }
        return null;
    }

    public static final st.a o0(ShortTvViewModel shortTvViewModel) {
        tt.a aVar = shortTvViewModel.f54543x;
        if (aVar != null) {
            return aVar.i();
        }
        return null;
    }

    public static final i p0(ShortTvViewModel shortTvViewModel) {
        tt.a aVar = shortTvViewModel.f54543x;
        if (aVar != null) {
            return aVar.c();
        }
        return null;
    }

    public final LiveData A() {
        return this.f54540u;
    }

    public final LiveData B() {
        return this.f54530k;
    }

    public final Object C(String str, Continuation continuation) {
        st.f O = O();
        if (O != null) {
            return O.c(str, continuation);
        }
        return null;
    }

    public final LiveData D() {
        return this.f54538s;
    }

    public final LiveData E() {
        return this.f54532m;
    }

    public final int F() {
        ShorttvModel.UGCVideo uGCVideo = (ShorttvModel.UGCVideo) CollectionsKt.k0(this.G);
        if (uGCVideo != null) {
            return uGCVideo.getEp();
        }
        return -1;
    }

    public final int G() {
        ShorttvModel.UGCVideo uGCVideo = (ShorttvModel.UGCVideo) CollectionsKt.v0(this.G);
        if (uGCVideo != null) {
            return uGCVideo.getEp();
        }
        return -1;
    }

    public final void H(int i11) {
    }

    public final String I() {
        return this.J;
    }

    public final LiveData J() {
        return this.f54534o;
    }

    public final void K(String nextPage, int i11, boolean z10) {
        Intrinsics.h(nextPage, "nextPage");
    }

    public final st.c L() {
        return (st.c) this.f54544y.getValue();
    }

    public final st.d M() {
        return (st.d) this.A.getValue();
    }

    public final st.e N() {
        return (st.e) this.f54545z.getValue();
    }

    public final st.f O() {
        return (st.f) this.C.getValue();
    }

    public final st.h P() {
        return (st.h) this.E.getValue();
    }

    public final st.a Q() {
        return (st.a) this.B.getValue();
    }

    public final i R() {
        return (i) this.D.getValue();
    }

    public final LiveData S() {
        return this.f54536q;
    }

    public final b0 T() {
        return this.f54522c;
    }

    public final boolean U() {
        return this.K;
    }

    public final void V(ShorttvModel.UGCVideo uGCVideo) {
        String ugcVideoId;
        ShorttvModel.UGCVideoInteractiveInfo interactiveInfo;
        Boolean hasLike;
        String likeNum;
        if (uGCVideo == null || (ugcVideoId = uGCVideo.getUgcVideoId()) == null || (interactiveInfo = uGCVideo.getInteractiveInfo()) == null || (hasLike = interactiveInfo.getHasLike()) == null) {
            return;
        }
        boolean booleanValue = hasLike.booleanValue();
        interactiveInfo.setHasLike(Boolean.valueOf(!booleanValue));
        ShorttvModel.UGCVideoInteractiveInfo interactiveInfo2 = uGCVideo.getInteractiveInfo();
        interactiveInfo.setLikeNum(String.valueOf(((interactiveInfo2 == null || (likeNum = interactiveInfo2.getLikeNum()) == null) ? 0L : Long.parseLong(likeNum)) + (booleanValue ? -1 : 1)));
        this.f54531l.q(Boolean.valueOf(!booleanValue));
        ShortTvExtKt.m(!booleanValue ? R$string.short_tv_liked : R$string.short_tv_liked_removed);
        k.d(u0.a(this), null, null, new ShortTvViewModel$like$1(this, ugcVideoId, booleanValue, null), 3, null);
    }

    public final void W(Context context) {
        Intrinsics.h(context, "context");
    }

    public final void X() {
        this.f54525f.q(this.f54524e.f());
    }

    public final t1 Y(String str, String str2, String str3) {
        t1 d11;
        d11 = k.d(u0.a(this), null, null, new ShortTvViewModel$requestFirstVideo$1(str, this, str3, str2, null), 3, null);
        return d11;
    }

    public final void Z(String str, int i11, int i12) {
        k.d(u0.a(this), this.f54521b, null, new ShortTvViewModel$requestVideoCollection$1(str, i11, i12, this, null), 2, null);
    }

    public final void b0(ShorttvModel.UGCVideo uGCVideo, long j11) {
        if (uGCVideo == null) {
            return;
        }
        k.d(u0.a(this), y0.b(), null, new ShortTvViewModel$saveHistory$1(this, uGCVideo, j11, null), 2, null);
    }

    public final void c0(int i11) {
        Iterator it = this.F.iterator();
        int i12 = 0;
        while (true) {
            if (!it.hasNext()) {
                i12 = -1;
                break;
            } else if (((ShorttvModel.UGCVideo) it.next()).getEp() == i11) {
                break;
            } else {
                i12++;
            }
        }
        if (i12 >= 0 || this.f54524e.f() == null) {
            Integer num = (Integer) this.f54524e.f();
            if (num != null && i11 == num.intValue()) {
                return;
            }
            this.f54524e.n(Integer.valueOf(i11));
            return;
        }
        a.C0856a.f(lg.a.f68962a, "ShortTvViewModel", "scrollToEp：" + i11 + " 当前不存在该集", false, 4, null);
    }

    public final void d0(String str) {
        this.L = str;
    }

    public final void e0(String str) {
        this.H = str;
    }

    public final void f0(List list) {
        this.I = list;
    }

    public final void g0(String str) {
        this.J = str;
    }

    public final void h0(boolean z10) {
        this.K = z10;
    }

    public final void i0(ShorttvModel.UGCVideo uGCVideo) {
    }

    public final void m() {
        this.f54537r.q(null);
    }

    public final void n(ShorttvModel.UGCVideo uGCVideo) {
        ShorttvModel.UGCVideoInteractiveInfo interactiveInfo;
        Boolean hasFavorite;
        String favoriteNum;
        if (uGCVideo == null || (interactiveInfo = uGCVideo.getInteractiveInfo()) == null || (hasFavorite = interactiveInfo.getHasFavorite()) == null) {
            return;
        }
        boolean booleanValue = hasFavorite.booleanValue();
        String ugcVideoId = uGCVideo.getUgcVideoId();
        if (ugcVideoId == null) {
            return;
        }
        ShorttvModel.UGCVideoInteractiveInfo interactiveInfo2 = uGCVideo.getInteractiveInfo();
        if (interactiveInfo2 != null) {
            interactiveInfo2.setHasFavorite(Boolean.valueOf(!booleanValue));
        }
        ShorttvModel.UGCVideoInteractiveInfo interactiveInfo3 = uGCVideo.getInteractiveInfo();
        if (interactiveInfo3 != null) {
            ShorttvModel.UGCVideoInteractiveInfo interactiveInfo4 = uGCVideo.getInteractiveInfo();
            interactiveInfo3.setFavoriteNum(String.valueOf(((interactiveInfo4 == null || (favoriteNum = interactiveInfo4.getFavoriteNum()) == null) ? 0L : Long.parseLong(favoriteNum)) + (booleanValue ? -1 : 1)));
        }
        this.f54527h.q(Boolean.valueOf(!booleanValue));
        ShortTvExtKt.m(!booleanValue ? R$string.short_tv_favorite : R$string.short_tv_favorite_removed);
        k.d(u0.a(this), null, null, new ShortTvViewModel$favorite$1(this, ugcVideoId, booleanValue, null), 3, null);
    }

    public final void o(ShorttvModel.UGCVideo uGCVideo) {
        ShorttvModel.UGCVideoCreator creator;
        String uid;
        Boolean hasSubscribe;
        if (uGCVideo == null || (creator = uGCVideo.getCreator()) == null || (uid = creator.getUid()) == null || (hasSubscribe = creator.getHasSubscribe()) == null) {
            return;
        }
        boolean booleanValue = hasSubscribe.booleanValue();
        creator.setHasSubscribe(Boolean.valueOf(!booleanValue));
        this.f54529j.q(Boolean.valueOf(!booleanValue));
        ShortTvExtKt.m(!booleanValue ? R$string.short_tv_subscribe : R$string.short_tv_unsubscribe);
        k.d(u0.a(this), null, null, new ShortTvViewModel$follow$1(this, uid, booleanValue, null), 3, null);
    }

    public final List p() {
        return this.F;
    }

    public final String q() {
        return this.L;
    }

    public final void q0(boolean z10) {
        this.f54535p.q(Boolean.valueOf(z10));
    }

    public final String r() {
        return this.H;
    }

    public final b0 s() {
        return this.f54524e;
    }

    public final ShorttvModel.UGCVideo t() {
        Integer num = (Integer) this.f54524e.f();
        if (num == null) {
            return null;
        }
        return (ShorttvModel.UGCVideo) this.F.get(ShortTvExtKt.d(num.intValue()));
    }

    public final LiveData u() {
        return this.f54542w;
    }

    public final List v() {
        return this.I;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object w(java.lang.String r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.transsion.shorttv_pugc.viewmodel.ShortTvViewModel$getDownloadVideo$1
            if (r0 == 0) goto L13
            r0 = r6
            com.transsion.shorttv_pugc.viewmodel.ShortTvViewModel$getDownloadVideo$1 r0 = (com.transsion.shorttv_pugc.viewmodel.ShortTvViewModel$getDownloadVideo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.shorttv_pugc.viewmodel.ShortTvViewModel$getDownloadVideo$1 r0 = new com.transsion.shorttv_pugc.viewmodel.ShortTvViewModel$getDownloadVideo$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r6)
            goto L43
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.b(r6)
            st.c r6 = r4.L()
            if (r6 == 0) goto L53
            r0.label = r3
            java.lang.Object r6 = r6.e(r5, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            com.transsion.shorttv_pugc.ShorttvModel$UGCVideo r6 = (com.transsion.shorttv_pugc.ShorttvModel.UGCVideo) r6
            if (r6 == 0) goto L53
            java.util.List r5 = r4.I
            if (r5 == 0) goto L54
            boolean r5 = r5.add(r6)
            kotlin.coroutines.jvm.internal.Boxing.a(r5)
            goto L54
        L53:
            r6 = 0
        L54:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv_pugc.viewmodel.ShortTvViewModel.w(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final b0 x() {
        return this.f54523d;
    }

    public final LiveData y() {
        return this.f54528i;
    }

    public final List z() {
        return this.G;
    }
}
