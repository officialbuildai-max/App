package com.transsion.postdetail.helper;

import android.content.Context;
import android.graphics.Insets;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;
import androidx.fragment.app.FragmentActivity;
import androidx.view.b0;
import com.blankj.utilcode.util.a0;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.player.orplayer.ORPlayerPreloadManager;
import com.transsion.postdetail.R$layout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;

/* loaded from: classes6.dex */
public final class ShortTvImmVideoHelper {

    /* renamed from: k, reason: collision with root package name */
    public static final a f48908k = new a(null);

    /* renamed from: l, reason: collision with root package name */
    private static final Lazy f48909l = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.helper.h
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ShortTvImmVideoHelper r11;
            r11 = ShortTvImmVideoHelper.r();
            return r11;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private int f48911b;

    /* renamed from: e, reason: collision with root package name */
    private boolean f48914e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f48915f;

    /* renamed from: i, reason: collision with root package name */
    private List f48918i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f48919j;

    /* renamed from: a, reason: collision with root package name */
    private final List f48910a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final Map f48912c = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Lazy f48913d = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.helper.g
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b0 B;
            B = ShortTvImmVideoHelper.B();
            return B;
        }
    });

    /* renamed from: g, reason: collision with root package name */
    private List f48916g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private List f48917h = new ArrayList();

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ShortTvImmVideoHelper a() {
            return (ShortTvImmVideoHelper) ShortTvImmVideoHelper.f48909l.getValue();
        }
    }

    public ShortTvImmVideoHelper() {
        this.f48914e = true;
        this.f48915f = true;
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
        this.f48914e = bVar.b().getBoolean("k_imm_video_guide", true);
        this.f48915f = bVar.b().getBoolean("k_short_tv_guide", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 B() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(FragmentActivity fragmentActivity, ShortTvImmVideoHelper shortTvImmVideoHelper) {
        int i11;
        int i12;
        View decorView;
        WindowInsets rootWindowInsets;
        if (fragmentActivity.isFinishing()) {
            return;
        }
        Window window = fragmentActivity.getWindow();
        Insets mandatorySystemGestureInsets = (window == null || (decorView = window.getDecorView()) == null || (rootWindowInsets = decorView.getRootWindowInsets()) == null) ? null : rootWindowInsets.getMandatorySystemGestureInsets();
        if (mandatorySystemGestureInsets != null) {
            i11 = mandatorySystemGestureInsets.bottom;
            if (i11 <= a0.a(40.0f)) {
                i12 = mandatorySystemGestureInsets.bottom;
                shortTvImmVideoHelper.f48911b = i12;
                a.C0856a.f(lg.a.f68962a, "ImmVideoHelper", "on get navigation gesture height = " + i12, false, 4, null);
                return;
            }
        }
        a.C0856a.f(lg.a.f68962a, "ImmVideoHelper", "is open navigation bar 2", false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShortTvImmVideoHelper r() {
        return new ShortTvImmVideoHelper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(Video video) {
        String url;
        if (video == null || (url = video.getUrl()) == null) {
            return;
        }
        ORPlayerPreloadManager.f48463i.a().j(url, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(ShortTvImmVideoHelper shortTvImmVideoHelper, View view, int i11, ViewGroup viewGroup) {
        Intrinsics.h(view, "view");
        a.C0856a.f(lg.a.f68962a, "ShortTvImmVideoPlayer", "for you preloadItemViews completion, " + view, false, 4, null);
        if (shortTvImmVideoHelper.f48919j) {
            return;
        }
        shortTvImmVideoHelper.f48916g.add(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(ShortTvImmVideoHelper shortTvImmVideoHelper, View view, int i11, ViewGroup viewGroup) {
        Intrinsics.h(view, "view");
        a.C0856a.f(lg.a.f68962a, "ShortTvImmVideoPlayer", "detail preloadItemViews completion, " + view, false, 4, null);
        if (shortTvImmVideoHelper.f48919j) {
            return;
        }
        shortTvImmVideoHelper.f48917h.add(view);
    }

    public final void A() {
        a.C0856a.v(lg.a.f68962a, "ImmVideoPlayer", "-- setVideoGuideShown", false, 4, null);
        this.f48914e = false;
        com.transsion.baselib.report.launch.b.f43424a.b().putBoolean("k_imm_video_guide", false);
    }

    public final void j() {
        this.f48910a.clear();
    }

    public final List k() {
        return this.f48910a;
    }

    public final List l() {
        return this.f48916g;
    }

    public final int m() {
        return this.f48911b;
    }

    public final b0 n() {
        return (b0) this.f48913d.getValue();
    }

    public final Map o() {
        return this.f48912c;
    }

    public final void p(final FragmentActivity activity) {
        Intrinsics.h(activity, "activity");
        if (Build.VERSION.SDK_INT < 29) {
            this.f48911b = 0;
            return;
        }
        if (com.blankj.utilcode.util.d.a() > 50) {
            a.C0856a.f(lg.a.f68962a, "ImmVideoHelper", "is open navigation bar", false, 4, null);
            this.f48911b = 0;
            return;
        }
        Window window = activity.getWindow();
        View decorView = window != null ? window.getDecorView() : null;
        if (decorView != null) {
            decorView.post(new Runnable() { // from class: com.transsion.postdetail.helper.i
                @Override // java.lang.Runnable
                public final void run() {
                    ShortTvImmVideoHelper.q(FragmentActivity.this, this);
                }
            });
        }
    }

    public final boolean s() {
        return this.f48914e;
    }

    public final void t() {
        List list = (List) n().f();
        if ((list != null ? list.size() : 0) > 0) {
            return;
        }
        kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new ShortTvImmVideoHelper$loadCache$1(this, null), 3, null);
    }

    public final void v(Context context) {
        Intrinsics.h(context, "context");
        this.f48919j = false;
        for (int i11 = 0; i11 < 2; i11++) {
            new AsyncLayoutInflater(context).a(R$layout.item_short_tv_immersion_video, null, new AsyncLayoutInflater.d() { // from class: com.transsion.postdetail.helper.j
                @Override // androidx.asynclayoutinflater.view.AsyncLayoutInflater.d
                public final void a(View view, int i12, ViewGroup viewGroup) {
                    ShortTvImmVideoHelper.w(ShortTvImmVideoHelper.this, view, i12, viewGroup);
                }
            });
        }
        for (int i12 = 0; i12 < 2; i12++) {
            new AsyncLayoutInflater(context).a(com.transsion.shorttv.R$layout.short_tv_item_video, null, new AsyncLayoutInflater.d() { // from class: com.transsion.postdetail.helper.k
                @Override // androidx.asynclayoutinflater.view.AsyncLayoutInflater.d
                public final void a(View view, int i13, ViewGroup viewGroup) {
                    ShortTvImmVideoHelper.x(ShortTvImmVideoHelper.this, view, i13, viewGroup);
                }
            });
        }
    }

    public final void y() {
        this.f48919j = true;
        this.f48916g.clear();
        this.f48917h.clear();
    }

    public final void z(List list) {
        List list2 = list;
        if (list2 == null || list2.isEmpty() || Intrinsics.c(list, n().f())) {
            return;
        }
        kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new ShortTvImmVideoHelper$saveCache$1(list, this, null), 3, null);
    }
}
