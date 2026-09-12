package com.cloud.hisavana.sdk;

import com.cloud.hisavana.sdk.common.widget.video.AdVideoView;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.manager.VideoMeasureManager;
import com.cloud.sdk.commonutil.util.Preconditions;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class a5 {

    /* renamed from: a, reason: collision with root package name */
    private AdsDTO f21649a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference f21650b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference f21651c;

    public a5(AdsDTO key, AdVideoView view, e5 measureListener) {
        Intrinsics.h(key, "key");
        Intrinsics.h(view, "view");
        Intrinsics.h(measureListener, "measureListener");
        this.f21649a = key;
        this.f21650b = new WeakReference(view);
        this.f21651c = new WeakReference(measureListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(e5 e5Var, AdVideoView adVideoView) {
        e5Var.a(VideoMeasureManager.INSTANCE.d(adVideoView));
    }

    public final AdsDTO b() {
        return this.f21649a;
    }

    public final void d() {
        final AdVideoView adVideoView = (AdVideoView) this.f21650b.get();
        final e5 e5Var = (e5) this.f21651c.get();
        if (adVideoView == null || e5Var == null) {
            return;
        }
        Preconditions.d(new Preconditions.a() { // from class: com.cloud.hisavana.sdk.z4
            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public final void onRun() {
                a5.c(e5.this, adVideoView);
            }
        });
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.c(a5.class, obj != null ? obj.getClass() : null)) {
            return (obj instanceof a5) && Intrinsics.c(this.f21649a, ((a5) obj).f21649a);
        }
        return false;
    }

    public int hashCode() {
        return this.f21649a.hashCode();
    }
}
