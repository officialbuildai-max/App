package com.transsion.rewardscenter.task.dada;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/transsion/rewardscenter/task/dada/DadaTaskState;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "DOWNLOADING", "INSTALLED", "CLAIMED_STAGE1", "SETTING", "SET_DEFAULT", "COMPLETED", "RewardsCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class DadaTaskState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DadaTaskState[] $VALUES;
    public static final DadaTaskState NORMAL = new DadaTaskState("NORMAL", 0);
    public static final DadaTaskState DOWNLOADING = new DadaTaskState("DOWNLOADING", 1);
    public static final DadaTaskState INSTALLED = new DadaTaskState("INSTALLED", 2);
    public static final DadaTaskState CLAIMED_STAGE1 = new DadaTaskState("CLAIMED_STAGE1", 3);
    public static final DadaTaskState SETTING = new DadaTaskState("SETTING", 4);
    public static final DadaTaskState SET_DEFAULT = new DadaTaskState("SET_DEFAULT", 5);
    public static final DadaTaskState COMPLETED = new DadaTaskState("COMPLETED", 6);

    private static final /* synthetic */ DadaTaskState[] $values() {
        return new DadaTaskState[]{NORMAL, DOWNLOADING, INSTALLED, CLAIMED_STAGE1, SETTING, SET_DEFAULT, COMPLETED};
    }

    static {
        DadaTaskState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private DadaTaskState(String str, int i11) {
    }

    public static EnumEntries<DadaTaskState> getEntries() {
        return $ENTRIES;
    }

    public static DadaTaskState valueOf(String str) {
        return (DadaTaskState) Enum.valueOf(DadaTaskState.class, str);
    }

    public static DadaTaskState[] values() {
        return (DadaTaskState[]) $VALUES.clone();
    }
}
