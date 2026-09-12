package com.transsion.ad.web;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/transsion/ad/web/H5AdStateEnum;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "MB_H5_AD_STATE_ON_FAIL", "MB_H5_AD_STATE_ON_REWARDED", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class H5AdStateEnum {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ H5AdStateEnum[] $VALUES;
    public static final H5AdStateEnum MB_H5_AD_STATE_ON_FAIL = new H5AdStateEnum("MB_H5_AD_STATE_ON_FAIL", 0, "fail");
    public static final H5AdStateEnum MB_H5_AD_STATE_ON_REWARDED = new H5AdStateEnum("MB_H5_AD_STATE_ON_REWARDED", 1, com.vungle.ads.internal.b.PLACEMENT_TYPE_REWARDED);
    private final String value;

    private static final /* synthetic */ H5AdStateEnum[] $values() {
        return new H5AdStateEnum[]{MB_H5_AD_STATE_ON_FAIL, MB_H5_AD_STATE_ON_REWARDED};
    }

    static {
        H5AdStateEnum[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private H5AdStateEnum(String str, int i11, String str2) {
        this.value = str2;
    }

    public static EnumEntries<H5AdStateEnum> getEntries() {
        return $ENTRIES;
    }

    public static H5AdStateEnum valueOf(String str) {
        return (H5AdStateEnum) Enum.valueOf(H5AdStateEnum.class, str);
    }

    public static H5AdStateEnum[] values() {
        return (H5AdStateEnum[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
