package com.vungle.ads.internal.presenter;

import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.vungle.ads.VungleError;
import com.vungle.ads.internal.util.o;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public class a {
    public static final C0739a Companion = new C0739a(null);
    private static final String TAG = "AdEventListener";
    private boolean adRewarded;
    private com.vungle.ads.internal.model.g placement;
    private final b playAdCallback;

    /* renamed from: com.vungle.ads.internal.presenter.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0739a {
        private C0739a() {
        }

        public /* synthetic */ C0739a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(b bVar, com.vungle.ads.internal.model.g gVar) {
        this.playAdCallback = bVar;
        this.placement = gVar;
    }

    public final void onError(VungleError error, String str) {
        Intrinsics.h(error, "error");
        b bVar = this.playAdCallback;
        if (bVar != null) {
            bVar.onFailure(error);
            o.Companion.e(TAG, "AdEventListener#PlayAdCallback " + str, error);
        }
    }

    public final void onNext(String s11, String str, String str2) {
        com.vungle.ads.internal.model.g gVar;
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        Intrinsics.h(s11, "s");
        o.Companion.d(TAG, "s=" + s11 + ", value=" + str + ", id=" + str2);
        switch (s11.hashCode()) {
            case -1912374177:
                if (s11.equals(MRAIDPresenter.SUCCESSFUL_VIEW) && (gVar = this.placement) != null && gVar.isRewardedVideo() && !this.adRewarded) {
                    this.adRewarded = true;
                    b bVar5 = this.playAdCallback;
                    if (bVar5 != null) {
                        bVar5.onAdRewarded(str2);
                        return;
                    }
                    return;
                }
                return;
            case -1627831289:
                if (s11.equals("adViewed") && (bVar = this.playAdCallback) != null) {
                    bVar.onAdImpression(str2);
                    return;
                }
                return;
            case 100571:
                if (s11.equals(TtmlNode.END) && (bVar2 = this.playAdCallback) != null) {
                    bVar2.onAdEnd(str2);
                    return;
                }
                return;
            case 3417674:
                if (s11.equals(MRAIDPresenter.OPEN)) {
                    if (Intrinsics.c(str, "adClick")) {
                        b bVar6 = this.playAdCallback;
                        if (bVar6 != null) {
                            bVar6.onAdClick(str2);
                            return;
                        }
                        return;
                    }
                    if (!Intrinsics.c(str, "adLeftApplication") || (bVar3 = this.playAdCallback) == null) {
                        return;
                    }
                    bVar3.onAdLeftApplication(str2);
                    return;
                }
                return;
            case 109757538:
                if (s11.equals("start") && (bVar4 = this.playAdCallback) != null) {
                    bVar4.onAdStart(str2);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
