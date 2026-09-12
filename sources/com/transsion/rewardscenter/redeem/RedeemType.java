package com.transsion.rewardscenter.redeem;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/transsion/rewardscenter/redeem/RedeemType;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "TITLE", "SKU", "LOTTERY", "RewardsCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class RedeemType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RedeemType[] $VALUES;
    private final int value;
    public static final RedeemType TITLE = new RedeemType("TITLE", 0, 0);
    public static final RedeemType SKU = new RedeemType("SKU", 1, 1);
    public static final RedeemType LOTTERY = new RedeemType("LOTTERY", 2, 2);

    private static final /* synthetic */ RedeemType[] $values() {
        return new RedeemType[]{TITLE, SKU, LOTTERY};
    }

    static {
        RedeemType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private RedeemType(String str, int i11, int i12) {
        this.value = i12;
    }

    public static EnumEntries<RedeemType> getEntries() {
        return $ENTRIES;
    }

    public static RedeemType valueOf(String str) {
        return (RedeemType) Enum.valueOf(RedeemType.class, str);
    }

    public static RedeemType[] values() {
        return (RedeemType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}
