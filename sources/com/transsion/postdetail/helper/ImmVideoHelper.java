package com.transsion.postdetail.helper;

import android.graphics.Insets;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import androidx.fragment.app.FragmentActivity;
import androidx.view.b0;
import com.blankj.utilcode.util.a0;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.player.orplayer.ORPlayerPreloadManager;
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
public final class ImmVideoHelper {

    /* renamed from: h, reason: collision with root package name */
    public static final a f48894h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    private static final Lazy f48895i = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.helper.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ImmVideoHelper m11;
            m11 = ImmVideoHelper.m();
            return m11;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private int f48897b;

    /* renamed from: e, reason: collision with root package name */
    private boolean f48900e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f48901f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f48902g;

    /* renamed from: a, reason: collision with root package name */
    private final List f48896a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final Map f48898c = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Lazy f48899d = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.helper.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b0 v11;
            v11 = ImmVideoHelper.v();
            return v11;
        }
    });

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ImmVideoHelper a() {
            return (ImmVideoHelper) ImmVideoHelper.f48895i.getValue();
        }
    }

    public ImmVideoHelper() {
        this.f48900e = true;
        this.f48901f = true;
        this.f48902g = true;
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
        this.f48900e = bVar.b().getBoolean("k_imm_video_guide", true);
        this.f48902g = bVar.b().getBoolean("k_short_tv_guide", true);
        this.f48901f = bVar.b().getBoolean("k_imm_video_guide_from_trending", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(FragmentActivity fragmentActivity, ImmVideoHelper immVideoHelper) {
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
                immVideoHelper.f48897b = i12;
                a.C0856a.f(lg.a.f68962a, "ImmVideoHelper", "on get navigation gesture height = " + i12, false, 4, null);
                return;
            }
        }
        a.C0856a.f(lg.a.f68962a, "ImmVideoHelper", "is open navigation bar 2", false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImmVideoHelper m() {
        return new ImmVideoHelper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(List list) {
        String url;
        if (list == null || !(!list.isEmpty()) || (url = ((Video) list.get(0)).getUrl()) == null) {
            return;
        }
        ORPlayerPreloadManager.f48463i.a().j(url, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 v() {
        return new b0();
    }

    public final void f() {
        this.f48896a.clear();
    }

    public final List g() {
        return this.f48896a;
    }

    public final int h() {
        return this.f48897b;
    }

    public final b0 i() {
        return (b0) this.f48899d.getValue();
    }

    public final Map j() {
        return this.f48898c;
    }

    public final void k(final FragmentActivity activity) {
        Intrinsics.h(activity, "activity");
        if (Build.VERSION.SDK_INT < 29) {
            this.f48897b = 0;
            return;
        }
        if (com.blankj.utilcode.util.d.a() > 50) {
            a.C0856a.f(lg.a.f68962a, "ImmVideoHelper", "is open navigation bar", false, 4, null);
            this.f48897b = 0;
            return;
        }
        Window window = activity.getWindow();
        View decorView = window != null ? window.getDecorView() : null;
        if (decorView != null) {
            decorView.post(new Runnable() { // from class: com.transsion.postdetail.helper.d
                @Override // java.lang.Runnable
                public final void run() {
                    ImmVideoHelper.l(FragmentActivity.this, this);
                }
            });
        }
    }

    public final boolean n() {
        return this.f48900e;
    }

    public final boolean o() {
        return this.f48901f;
    }

    public final void p() {
        kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new ImmVideoHelper$loadCache$1(this, null), 3, null);
    }

    public final void r(List list) {
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new ImmVideoHelper$saveCache$1(list, this, null), 3, null);
    }

    public final void s(PostSubjectItem data) {
        List<Video> video;
        Intrinsics.h(data, "data");
        Media media = data.getMedia();
        if (media == null || (video = media.getVideo()) == null || !(!video.isEmpty())) {
            return;
        }
        f();
        this.f48896a.add(PostSubjectItem.INSTANCE.a(data));
    }

    public final void t() {
        a.C0856a.v(lg.a.f68962a, "ImmVideoPlayer", "-- setVideoGuideShown", false, 4, null);
        this.f48900e = false;
        com.transsion.baselib.report.launch.b.f43424a.b().putBoolean("k_imm_video_guide", false);
    }

    public final void u() {
        a.C0856a.v(lg.a.f68962a, "ImmVideoPlayer", "-- setVideoGuideShownFromTrending", false, 4, null);
        this.f48901f = false;
        com.transsion.baselib.report.launch.b.f43424a.b().putBoolean("k_imm_video_guide_from_trending", false);
    }
}
