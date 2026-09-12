package com.transsion.rewardscenterapi;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/transsion/rewardscenterapi/TopUpType;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "BANNER", "PHONE_CREDIT", "REDEEM", "RewardsCenterApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class TopUpType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TopUpType[] $VALUES;
    public static final TopUpType BANNER = new TopUpType("BANNER", 0, 0);
    public static final TopUpType PHONE_CREDIT = new TopUpType("PHONE_CREDIT", 1, 1);
    public static final TopUpType REDEEM = new TopUpType("REDEEM", 2, 2);
    private final int value;

    private static final /* synthetic */ TopUpType[] $values() {
        return new TopUpType[]{BANNER, PHONE_CREDIT, REDEEM};
    }

    static {
        TopUpType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private TopUpType(String str, int i11, int i12) {
        this.value = i12;
    }

    public static EnumEntries<TopUpType> getEntries() {
        return $ENTRIES;
    }

    public static TopUpType valueOf(String str) {
        return (TopUpType) Enum.valueOf(TopUpType.class, str);
    }

    public static TopUpType[] values() {
        return (TopUpType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}
