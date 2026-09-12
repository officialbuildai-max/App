package com.transsion.player.longvideo.helper;

import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.view.v0;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.video.UGCVideoDetailPlayDao;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsion.player.longvideo.ui.LongVodUiType;
import com.transsion.subtitle.R$string;
import com.transsion.subtitle.VideoSubtitleControl;
import com.transsion.subtitle.h;
import com.transsion.subtitle.helper.LocalVideoUiType;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoBelongToCollection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.y0;
import lg.a;
import okhttp3.internal.http2.Settings;

/* loaded from: classes6.dex */
public final class LongVodSubtitleHelper {

    /* renamed from: a, reason: collision with root package name */
    private final ho.j f47993a;

    /* renamed from: b, reason: collision with root package name */
    private final String f47994b;

    /* renamed from: c, reason: collision with root package name */
    private List f47995c;

    /* renamed from: d, reason: collision with root package name */
    private final x f47996d;

    /* renamed from: e, reason: collision with root package name */
    private final Function1 f47997e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f47998f;

    /* renamed from: g, reason: collision with root package name */
    private List f47999g;

    /* renamed from: h, reason: collision with root package name */
    private final VideoSubtitleControl f48000h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f48001i;

    /* renamed from: j, reason: collision with root package name */
    private DownloadBean f48002j;

    /* renamed from: k, reason: collision with root package name */
    private go.a f48003k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f48004l;

    /* renamed from: m, reason: collision with root package name */
    private View f48005m;

    /* renamed from: n, reason: collision with root package name */
    private ViewGroup f48006n;

    /* renamed from: o, reason: collision with root package name */
    private final o0 f48007o;

    /* renamed from: p, reason: collision with root package name */
    private final kotlinx.coroutines.n0 f48008p;

    /* renamed from: q, reason: collision with root package name */
    private final Lazy f48009q;

    /* renamed from: r, reason: collision with root package name */
    private final Lazy f48010r;

    /* loaded from: classes6.dex */
    public static final class a implements hu.a {
        a() {
        }
    }

    /* loaded from: classes6.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f48012a;

        static {
            int[] iArr = new int[LongVodUiType.values().length];
            try {
                iArr[LongVodUiType.LAND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LongVodUiType.PORTRAIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f48012a = iArr;
        }
    }

    /* loaded from: classes6.dex */
    static final class c implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f48013a;

        c(Function1 function) {
            Intrinsics.h(function, "function");
            this.f48013a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f48013a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.view.c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.view.c0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f48013a.invoke(obj);
        }
    }

    public LongVodSubtitleHelper(ho.j viewBinding, String str, List dubs, x callback, Function1 function1, boolean z10) {
        Intrinsics.h(viewBinding, "viewBinding");
        Intrinsics.h(dubs, "dubs");
        Intrinsics.h(callback, "callback");
        this.f47993a = viewBinding;
        this.f47994b = str;
        this.f47995c = dubs;
        this.f47996d = callback;
        this.f47997e = function1;
        this.f47998f = z10;
        this.f47999g = new ArrayList();
        this.f48004l = true;
        this.f48008p = kotlinx.coroutines.o0.a(y0.b());
        this.f48009q = LazyKt.b(new Function0() { // from class: com.transsion.player.longvideo.helper.h0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoDetailPlayDao k02;
                k02 = LongVodSubtitleHelper.k0();
                return k02;
            }
        });
        this.f48010r = LazyKt.b(new Function0() { // from class: com.transsion.player.longvideo.helper.j0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                UGCVideoDetailPlayDao g02;
                g02 = LongVodSubtitleHelper.g0();
                return g02;
            }
        });
        Context context = viewBinding.getRoot().getContext();
        Intrinsics.f(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        o0 o0Var = (o0) new v0((FragmentActivity) context).a(o0.class);
        this.f48007o = o0Var;
        this.f48004l = com.transsion.baselib.report.launch.b.f43424a.b().getBoolean("subtitle_land_guide", true);
        Context context2 = viewBinding.getRoot().getContext();
        Intrinsics.f(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        VideoSubtitleControl videoSubtitleControl = new VideoSubtitleControl((FragmentActivity) context2, str, com.transsion.baselib.helper.d.f43319a.d(), this.f47995c, new Function1() { // from class: com.transsion.player.longvideo.helper.k0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit r11;
                r11 = LongVodSubtitleHelper.r(((Boolean) obj).booleanValue());
                return r11;
            }
        }, new Function2() { // from class: com.transsion.player.longvideo.helper.l0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit s11;
                s11 = LongVodSubtitleHelper.s(LongVodSubtitleHelper.this, ((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
                return s11;
            }
        }, new Function3() { // from class: com.transsion.player.longvideo.helper.m0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit t11;
                t11 = LongVodSubtitleHelper.t(LongVodSubtitleHelper.this, (String) obj, (String) obj2, ((Integer) obj3).intValue());
                return t11;
            }
        }, new Function1() { // from class: com.transsion.player.longvideo.helper.n0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit u11;
                u11 = LongVodSubtitleHelper.u(LongVodSubtitleHelper.this, (DubsInfo) obj);
                return u11;
            }
        }, new Function1() { // from class: com.transsion.player.longvideo.helper.z
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit v11;
                v11 = LongVodSubtitleHelper.v(LongVodSubtitleHelper.this, (List) obj);
                return v11;
            }
        }, new Function1() { // from class: com.transsion.player.longvideo.helper.a0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit w11;
                w11 = LongVodSubtitleHelper.w(LongVodSubtitleHelper.this, (String) obj);
                return w11;
            }
        }, new Function2() { // from class: com.transsion.player.longvideo.helper.b0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit x10;
                x10 = LongVodSubtitleHelper.x(LongVodSubtitleHelper.this, (String) obj, (String) obj2);
                return x10;
            }
        });
        videoSubtitleControl.P(LocalVideoUiType.MIDDLE);
        videoSubtitleControl.i0(new a());
        videoSubtitleControl.e0(new Function1() { // from class: com.transsion.player.longvideo.helper.c0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit P;
                P = LongVodSubtitleHelper.P(LongVodSubtitleHelper.this, (String) obj);
                return P;
            }
        });
        this.f48000h = videoSubtitleControl;
        if (this.f47998f) {
            this.f48004l = false;
        }
        androidx.view.b0 b11 = o0Var.b();
        Context context3 = viewBinding.getRoot().getContext();
        Intrinsics.f(context3, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        b11.j((FragmentActivity) context3, new c(new Function1() { // from class: com.transsion.player.longvideo.helper.i0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit q11;
                q11 = LongVodSubtitleHelper.q(LongVodSubtitleHelper.this, (eu.a) obj);
                return q11;
            }
        }));
    }

    public /* synthetic */ LongVodSubtitleHelper(ho.j jVar, String str, List list, x xVar, Function1 function1, boolean z10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(jVar, str, list, xVar, function1, (i11 & 32) != 0 ? true : z10);
    }

    private final void E() {
        if (this.f47999g.isEmpty() && this.f48004l) {
            com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
            if (bVar.b().getBoolean("subtitle_is_search_downloaded", false)) {
                this.f48004l = false;
                bVar.b().putBoolean("subtitle_land_guide", false);
            } else {
                this.f48004l = false;
                bVar.b().putBoolean("subtitle_land_guide", false);
                this.f47996d.b(true, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(DownloadBean downloadBean) {
        this.f48001i = true;
        lg.a.f68962a.c(com.transsion.baselib.report.a.f43394a.a(), "流媒体，开始播放检测字幕，name:" + downloadBean.getTotalTitleName() + " subjectId:" + downloadBean.getSubjectId() + " subtitleResId:" + downloadBean.getSubtitleResId(), true);
        com.transsion.subtitle.h.f55010a.b().e(downloadBean, new Function1() { // from class: com.transsion.player.longvideo.helper.d0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit G;
                G = LongVodSubtitleHelper.G(LongVodSubtitleHelper.this, ((Boolean) obj).booleanValue());
                return G;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(LongVodSubtitleHelper longVodSubtitleHelper, boolean z10) {
        if (!z10 && longVodSubtitleHelper.f47999g.isEmpty()) {
            longVodSubtitleHelper.f47993a.getRoot().post(new Runnable() { // from class: com.transsion.player.longvideo.helper.e0
                @Override // java.lang.Runnable
                public final void run() {
                    LongVodSubtitleHelper.H();
                }
            });
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H() {
    }

    private final ImageView J() {
        return null;
    }

    private final TextView K() {
        if (this.f47998f) {
            return this.f47993a.f64741h.f64782x;
        }
        return null;
    }

    private final TextView L() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UGCVideoDetailPlayDao N() {
        return (UGCVideoDetailPlayDao) this.f48010r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoDetailPlayDao O() {
        return (VideoDetailPlayDao) this.f48009q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(LongVodSubtitleHelper longVodSubtitleHelper, String str) {
        longVodSubtitleHelper.f47996d.f(str);
        return Unit.f67184a;
    }

    private final void Q(DownloadBean downloadBean) {
        kotlinx.coroutines.k.d(this.f48008p, null, null, new LongVodSubtitleHelper$loadFromDB$1(downloadBean, this, null), 3, null);
    }

    private final void U(View view) {
        ho.k kVar = this.f47993a.f64741h;
        View view2 = this.f48005m;
        if (view2 != null) {
            jg.c.g(view2);
        }
    }

    private final void V(View view, boolean z10) {
        this.f47996d.b(true, true);
        x xVar = this.f47996d;
        String string = Utils.a().getString(z10 ? R$string.subtitle_turn_on_toast : R$string.subtitle_turn_off_toast);
        Intrinsics.g(string, "getString(...)");
        xVar.c(string);
    }

    private final void a0(VideoSubtitleControl videoSubtitleControl) {
        LocalVideoUiType localVideoUiType = LocalVideoUiType.MIDDLE;
        TextView K = K();
        ho.j jVar = this.f47993a;
        videoSubtitleControl.b0(localVideoUiType, K, jVar.f64753t, jVar.f64752s, jVar.f64738e, false);
        videoSubtitleControl.k0(new Function1() { // from class: com.transsion.player.longvideo.helper.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit b02;
                b02 = LongVodSubtitleHelper.b0(LongVodSubtitleHelper.this, ((Boolean) obj).booleanValue());
                return b02;
            }
        });
        videoSubtitleControl.F(localVideoUiType, new Function2() { // from class: com.transsion.player.longvideo.helper.f0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit c02;
                c02 = LongVodSubtitleHelper.c0(LongVodSubtitleHelper.this, (View) obj, ((Boolean) obj2).booleanValue());
                return c02;
            }
        }, new Function1() { // from class: com.transsion.player.longvideo.helper.g0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit d02;
                d02 = LongVodSubtitleHelper.d0(LongVodSubtitleHelper.this, (View) obj);
                return d02;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(LongVodSubtitleHelper longVodSubtitleHelper, boolean z10) {
        View I = longVodSubtitleHelper.I();
        if (I != null) {
            I.setVisibility(z10 ? 0 : 8);
        }
        ImageView J = longVodSubtitleHelper.J();
        if (J != null) {
            J.setVisibility(z10 ? 8 : 0);
        }
        TextView L = longVodSubtitleHelper.L();
        if (L != null) {
            L.setText(Utils.a().getString(z10 ? com.transsion.postdetail.R$string.play_loading : com.transsion.postdetail.R$string.turn_on_short));
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0(LongVodSubtitleHelper longVodSubtitleHelper, View switchView, boolean z10) {
        Intrinsics.h(switchView, "switchView");
        longVodSubtitleHelper.V(switchView, z10);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(LongVodSubtitleHelper longVodSubtitleHelper, View settingView) {
        Intrinsics.h(settingView, "settingView");
        longVodSubtitleHelper.U(settingView);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UGCVideoDetailPlayDao g0() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).C1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoDetailPlayDao k0() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).D1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(LongVodSubtitleHelper longVodSubtitleHelper, eu.a aVar) {
        VideoSubtitleControl videoSubtitleControl = longVodSubtitleHelper.f48000h;
        Intrinsics.e(aVar);
        videoSubtitleControl.O(aVar);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(boolean z10) {
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(LongVodSubtitleHelper longVodSubtitleHelper, boolean z10, boolean z11) {
        if (z10) {
            longVodSubtitleHelper.f47996d.b(true, z11);
        } else {
            longVodSubtitleHelper.f47996d.b(false, true);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(LongVodSubtitleHelper longVodSubtitleHelper, String lanName, String lan, int i11) {
        Intrinsics.h(lanName, "lanName");
        Intrinsics.h(lan, "lan");
        longVodSubtitleHelper.f48007o.d().n(new Pair(lanName, lan));
        longVodSubtitleHelper.f47996d.g(lanName, lan, i11);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(LongVodSubtitleHelper longVodSubtitleHelper, DubsInfo it) {
        Intrinsics.h(it, "it");
        Function1 function1 = longVodSubtitleHelper.f47997e;
        if (function1 != null) {
            function1.invoke(it);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(LongVodSubtitleHelper longVodSubtitleHelper, List list) {
        Intrinsics.h(list, "list");
        longVodSubtitleHelper.f48007o.c().n(list);
        longVodSubtitleHelper.f47996d.e(list);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(LongVodSubtitleHelper longVodSubtitleHelper, String str) {
        x xVar = longVodSubtitleHelper.f47996d;
        if (str == null) {
            str = "";
        }
        xVar.c(str);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(LongVodSubtitleHelper longVodSubtitleHelper, String str, String str2) {
        longVodSubtitleHelper.f47996d.d(str, str2);
        return Unit.f67184a;
    }

    public final View I() {
        return null;
    }

    public final Map M() {
        return this.f48000h.G();
    }

    public final void R() {
        this.f48000h.N();
    }

    public final void S() {
        DownloadBean downloadBean;
        if (this.f48001i || (downloadBean = this.f48002j) == null) {
            return;
        }
        this.f48001i = true;
        lg.a.f68962a.c(com.transsion.baselib.report.a.f43394a.a(), "流媒体，网络连接成功开始检测字幕，name:" + downloadBean.getTotalTitleName() + " subjectId:" + downloadBean.getSubjectId() + " subtitleResId:" + downloadBean.getSubtitleResId(), true);
        h.b.a(com.transsion.subtitle.h.f55010a.b(), downloadBean, null, 2, null);
    }

    public final void T(go.a bean, go.c playStream) {
        UGCVideoBelongToCollection belongToCollection;
        UGCVideoBelongToCollection belongToCollection2;
        UGCVideoBelongToCollection belongToCollection3;
        Intrinsics.h(bean, "bean");
        Intrinsics.h(playStream, "playStream");
        this.f48001i = false;
        this.f48003k = bean;
        if (bean.d() != null) {
            this.f48002j = bean.d();
        } else {
            DownloadBean downloadBean = new DownloadBean(playStream.h(), playStream.c(), bean.p(), "", StringsKt.x(playStream.g()), null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, bean.e(), bean.l(), 0, 0, 0, 0, 0, 0, 0, bean.o(), this.f47994b, null, bean.p(), 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, -1477181472, -1, Settings.DEFAULT_INITIAL_WINDOW_SIZE, null);
            downloadBean.setStream(playStream.k());
            downloadBean.setStreamVideoDetail(true);
            UGCVideo u11 = bean.u();
            downloadBean.setUgcVideoId(u11 != null ? u11.getUgcVideoId() : null);
            UGCVideo u12 = bean.u();
            downloadBean.setUgcVideoCollectionId((u12 == null || (belongToCollection3 = u12.getBelongToCollection()) == null) ? null : belongToCollection3.getCollectionId());
            UGCVideo u13 = bean.u();
            downloadBean.setUgcVideoName(u13 != null ? u13.getTitle() : null);
            UGCVideo u14 = bean.u();
            downloadBean.setUgcVideoCollectionName((u14 == null || (belongToCollection2 = u14.getBelongToCollection()) == null) ? null : belongToCollection2.getCollectionName());
            UGCVideo u15 = bean.u();
            downloadBean.setUgcVideoPosition((u15 == null || (belongToCollection = u15.getBelongToCollection()) == null) ? null : belongToCollection.getPosition());
            UGCVideo u16 = bean.u();
            downloadBean.setUgcVideoType(u16 != null ? u16.getCategory() : null);
            downloadBean.setOps(bean.q());
            downloadBean.setSubtitleIdType(playStream.d());
            this.f48002j = downloadBean;
        }
        a.C0856a c0856a = lg.a.f68962a;
        String a11 = com.transsion.baselib.report.a.f43394a.a();
        DownloadBean downloadBean2 = this.f48002j;
        String ugcVideoId = downloadBean2 != null ? downloadBean2.getUgcVideoId() : null;
        DownloadBean downloadBean3 = this.f48002j;
        c0856a.c(a11, "subtitle onSetNewDataSource，ugcVideoId:" + ugcVideoId + " CollectionId:" + (downloadBean3 != null ? downloadBean3.getUgcVideoCollectionId() : null), true);
        this.f48000h.j0(this.f48002j);
        DownloadBean downloadBean4 = this.f48002j;
        Intrinsics.e(downloadBean4);
        Q(downloadBean4);
    }

    public final void W(LongVodUiType uiType) {
        Intrinsics.h(uiType, "uiType");
        if (uiType == LongVodUiType.LAND) {
            E();
        }
        int i11 = b.f48012a[uiType.ordinal()];
        this.f48000h.P(i11 != 1 ? i11 != 2 ? LocalVideoUiType.MIDDLE : LocalVideoUiType.PORTRAIT : LocalVideoUiType.LAND);
    }

    public final void X(long j11) {
        this.f48000h.S(j11);
    }

    public final void Y() {
        this.f48000h.U();
    }

    public final void Z() {
        VideoSubtitleControl videoSubtitleControl = this.f48000h;
        if (videoSubtitleControl != null) {
            videoSubtitleControl.Z();
        }
    }

    public final void e0(boolean z10) {
        this.f48000h.d0(z10);
    }

    public final void f0(ViewGroup viewGroup) {
        this.f48006n = viewGroup;
        a0(this.f48000h);
    }

    public final void h0(List dubs) {
        Intrinsics.h(dubs, "dubs");
        this.f47995c = dubs;
        this.f48000h.r0(dubs);
    }

    public final void i0(long j11) {
        this.f48000h.s0(j11);
    }

    public final void j0(float f11) {
        this.f48000h.t0(f11);
    }
}
