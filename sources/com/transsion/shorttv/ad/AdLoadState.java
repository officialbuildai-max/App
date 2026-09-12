package com.transsion.shorttv.ad;

import com.transsion.wrapperad.view.secondfloor.CustomSwipeRefreshLayout;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/transsion/shorttv/ad/AdLoadState;", "", "<init>", "(Ljava/lang/String;I)V", CustomSwipeRefreshLayout.IDLE, "LOADING", "SUCCEED", "FAILED", "CLOSED", "DESTROYED", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class AdLoadState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AdLoadState[] $VALUES;
    public static final AdLoadState IDLE = new AdLoadState(CustomSwipeRefreshLayout.IDLE, 0);
    public static final AdLoadState LOADING = new AdLoadState("LOADING", 1);
    public static final AdLoadState SUCCEED = new AdLoadState("SUCCEED", 2);
    public static final AdLoadState FAILED = new AdLoadState("FAILED", 3);
    public static final AdLoadState CLOSED = new AdLoadState("CLOSED", 4);
    public static final AdLoadState DESTROYED = new AdLoadState("DESTROYED", 5);

    private static final /* synthetic */ AdLoadState[] $values() {
        return new AdLoadState[]{IDLE, LOADING, SUCCEED, FAILED, CLOSED, DESTROYED};
    }

    static {
        AdLoadState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private AdLoadState(String str, int i11) {
    }

    public static EnumEntries<AdLoadState> getEntries() {
        return $ENTRIES;
    }

    public static AdLoadState valueOf(String str) {
        return (AdLoadState) Enum.valueOf(AdLoadState.class, str);
    }

    public static AdLoadState[] values() {
        return (AdLoadState[]) $VALUES.clone();
    }
}
