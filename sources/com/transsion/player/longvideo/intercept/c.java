package com.transsion.player.longvideo.intercept;

import android.app.Activity;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.view.LifecycleCoroutineScope;
import com.transsion.player.longvideo.constants.LongVodPageType;
import com.transsion.player.longvideo.ui.LongVodPlayerView;
import com.transsion.postdetail.layer.local.LocalBackAdHelper;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private LongVodPageType f48171a;

    /* renamed from: b, reason: collision with root package name */
    private LongVodPlayerView f48172b;

    /* renamed from: c, reason: collision with root package name */
    private LifecycleCoroutineScope f48173c;

    /* renamed from: d, reason: collision with root package name */
    private String f48174d;

    /* renamed from: e, reason: collision with root package name */
    private LocalBackAdHelper f48175e;

    private final LocalBackAdHelper d() {
        LongVodPlayerView longVodPlayerView = this.f48172b;
        Context context = longVodPlayerView != null ? longVodPlayerView.getContext() : null;
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        LifecycleCoroutineScope a11 = appCompatActivity != null ? androidx.view.v.a(appCompatActivity) : null;
        this.f48173c = a11;
        LocalBackAdHelper localBackAdHelper = this.f48175e;
        if (localBackAdHelper != null) {
            return localBackAdHelper;
        }
        Intrinsics.e(a11);
        LocalBackAdHelper localBackAdHelper2 = new LocalBackAdHelper("StreamVideoBackInterstitialScene", a11, new Function0() { // from class: com.transsion.player.longvideo.intercept.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Activity e11;
                e11 = c.e(c.this);
                return e11;
            }
        }, new Function0() { // from class: com.transsion.player.longvideo.intercept.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit f11;
                f11 = c.f(c.this);
                return f11;
            }
        }, true);
        this.f48175e = localBackAdHelper2;
        return localBackAdHelper2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Activity e(c cVar) {
        LongVodPlayerView longVodPlayerView = cVar.f48172b;
        Context context = longVodPlayerView != null ? longVodPlayerView.getContext() : null;
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity == null || appCompatActivity.isDestroyed() || appCompatActivity.isFinishing()) {
            return null;
        }
        return appCompatActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(c cVar) {
        LongVodPlayerView longVodPlayerView = cVar.f48172b;
        if (longVodPlayerView != null) {
            LongVodPlayerView.backClick$default(longVodPlayerView, false, false, 3, null);
        }
        return Unit.f67184a;
    }

    public final void c() {
        LocalBackAdHelper localBackAdHelper = this.f48175e;
        if (localBackAdHelper != null) {
            localBackAdHelper.o();
        }
        this.f48175e = null;
    }

    public final void g() {
        if (this.f48171a != LongVodPageType.STREAM) {
            return;
        }
        d().q(this.f48174d);
    }

    public final void h(String str) {
        this.f48174d = str;
    }

    public final void i(LongVodPlayerView longVodPlayerView) {
        this.f48172b = longVodPlayerView;
    }

    public final void j(LongVodPageType pageType) {
        Intrinsics.h(pageType, "pageType");
        this.f48171a = pageType;
    }

    public final boolean k() {
        if (this.f48171a != LongVodPageType.STREAM) {
            return false;
        }
        int k11 = com.transsion.ad.scene.a.f42255a.k("StreamVideoBackInterstitialScene");
        if (System.currentTimeMillis() - com.transsion.baselib.report.launch.b.f43424a.b().getLong("show_StreamVideoBackInterstitialScene_timestamp", 0L) < k11 * 60 * 1000) {
            ii.b.d(ii.b.f65371a, "StreamVideoBackInterstitialScene", false, 2, null);
            return false;
        }
        d().r(this.f48174d);
        return true;
    }
}
