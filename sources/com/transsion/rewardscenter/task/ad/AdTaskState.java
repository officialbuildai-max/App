package com.transsion.rewardscenter.task.ad;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/transsion/rewardscenter/task/ad/AdTaskState;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "DOWNLOADING", "INSTALLED", "CLAIMED_STAGE1", "PLAYING", "PLAYED", "COMPLETED", "RewardsCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class AdTaskState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AdTaskState[] $VALUES;
    public static final AdTaskState NORMAL = new AdTaskState("NORMAL", 0);
    public static final AdTaskState DOWNLOADING = new AdTaskState("DOWNLOADING", 1);
    public static final AdTaskState INSTALLED = new AdTaskState("INSTALLED", 2);
    public static final AdTaskState CLAIMED_STAGE1 = new AdTaskState("CLAIMED_STAGE1", 3);
    public static final AdTaskState PLAYING = new AdTaskState("PLAYING", 4);
    public static final AdTaskState PLAYED = new AdTaskState("PLAYED", 5);
    public static final AdTaskState COMPLETED = new AdTaskState("COMPLETED", 6);

    private static final /* synthetic */ AdTaskState[] $values() {
        return new AdTaskState[]{NORMAL, DOWNLOADING, INSTALLED, CLAIMED_STAGE1, PLAYING, PLAYED, COMPLETED};
    }

    static {
        AdTaskState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private AdTaskState(String str, int i11) {
    }

    public static EnumEntries<AdTaskState> getEntries() {
        return $ENTRIES;
    }

    public static AdTaskState valueOf(String str) {
        return (AdTaskState) Enum.valueOf(AdTaskState.class, str);
    }

    public static AdTaskState[] values() {
        return (AdTaskState[]) $VALUES.clone();
    }
}
