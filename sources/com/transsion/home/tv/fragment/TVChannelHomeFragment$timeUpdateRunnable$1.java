package com.transsion.home.tv.fragment;

import android.os.Handler;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/transsion/home/tv/fragment/TVChannelHomeFragment$timeUpdateRunnable$1", "Ljava/lang/Runnable;", "run", "", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class TVChannelHomeFragment$timeUpdateRunnable$1 implements Runnable {
    final /* synthetic */ TVChannelHomeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TVChannelHomeFragment$timeUpdateRunnable$1(TVChannelHomeFragment tVChannelHomeFragment) {
        this.this$0 = tVChannelHomeFragment;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        this.this$0.Z0();
        long currentTimeMillis = System.currentTimeMillis();
        handler = this.this$0.timeHandler;
        long j11 = 60000;
        handler.postDelayed(this, (((currentTimeMillis / j11) + 1) * j11) - currentTimeMillis);
    }
}
