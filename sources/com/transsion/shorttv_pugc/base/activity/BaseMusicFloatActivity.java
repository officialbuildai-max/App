package com.transsion.shorttv_pugc.base.activity;

import android.view.MotionEvent;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import g4.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import st.g;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u000b8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u0002\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/transsion/shorttv_pugc/base/activity/BaseMusicFloatActivity;", "Lg4/a;", "T", "Lcom/transsion/shorttv_pugc/base/activity/BaseCommonActivity;", "<init>", "()V", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "Lst/g;", "c", "Lkotlin/Lazy;", "()Lst/g;", "shortMusicAudioProvider", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public abstract class BaseMusicFloatActivity<T extends g4.a> extends BaseCommonActivity<T> {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy shortMusicAudioProvider = LazyKt.b(new Function0() { // from class: com.transsion.shorttv_pugc.base.activity.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            g U;
            U = BaseMusicFloatActivity.U();
            return U;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final g U() {
        tt.a b11 = ys.a.f79179a.b();
        if (b11 != null) {
            return b11.g();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final g T() {
        return (g) this.shortMusicAudioProvider.getValue();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent ev2) {
        g T;
        Integer valueOf = ev2 != null ? Integer.valueOf(ev2.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0 && (T = T()) != null) {
            T.c(this, ev2);
        }
        return super.dispatchTouchEvent(ev2);
    }
}
