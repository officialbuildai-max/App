package com.transsion.ad.ps.model;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/transsion/ad/ps/model/PSAdTypeEnum;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "PS_AD_TYPE_USER_ACQUISITION_0", "PS_AD_TYPE_USER_RETENTION_1", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class PSAdTypeEnum {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PSAdTypeEnum[] $VALUES;
    public static final PSAdTypeEnum PS_AD_TYPE_USER_ACQUISITION_0 = new PSAdTypeEnum("PS_AD_TYPE_USER_ACQUISITION_0", 0, 0);
    public static final PSAdTypeEnum PS_AD_TYPE_USER_RETENTION_1 = new PSAdTypeEnum("PS_AD_TYPE_USER_RETENTION_1", 1, 1);
    private final int value;

    private static final /* synthetic */ PSAdTypeEnum[] $values() {
        return new PSAdTypeEnum[]{PS_AD_TYPE_USER_ACQUISITION_0, PS_AD_TYPE_USER_RETENTION_1};
    }

    static {
        PSAdTypeEnum[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private PSAdTypeEnum(String str, int i11, int i12) {
        this.value = i12;
    }

    public static EnumEntries<PSAdTypeEnum> getEntries() {
        return $ENTRIES;
    }

    public static PSAdTypeEnum valueOf(String str) {
        return (PSAdTypeEnum) Enum.valueOf(PSAdTypeEnum.class, str);
    }

    public static PSAdTypeEnum[] values() {
        return (PSAdTypeEnum[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}
