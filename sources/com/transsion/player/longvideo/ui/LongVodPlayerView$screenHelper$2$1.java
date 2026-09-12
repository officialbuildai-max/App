package com.transsion.player.longvideo.ui;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public /* synthetic */ class LongVodPlayerView$screenHelper$2$1 extends FunctionReferenceImpl implements Function0<Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LongVodPlayerView$screenHelper$2$1(Object obj) {
        super(0, obj, LongVodPlayerView.class, "isCloseAutoRotation", "isCloseAutoRotation()Z", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        boolean h12;
        h12 = ((LongVodPlayerView) this.receiver).h1();
        return Boolean.valueOf(h12);
    }
}
