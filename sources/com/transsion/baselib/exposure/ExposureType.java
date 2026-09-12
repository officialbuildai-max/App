package com.transsion.baselib.exposure;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/transsion/baselib/exposure/ExposureType;", "", "<init>", "(Ljava/lang/String;I)V", "VERTICAL_FEED", "NEST_HORIZONTAL", "BaseLib_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class ExposureType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ExposureType[] $VALUES;
    public static final ExposureType VERTICAL_FEED = new ExposureType("VERTICAL_FEED", 0);
    public static final ExposureType NEST_HORIZONTAL = new ExposureType("NEST_HORIZONTAL", 1);

    private static final /* synthetic */ ExposureType[] $values() {
        return new ExposureType[]{VERTICAL_FEED, NEST_HORIZONTAL};
    }

    static {
        ExposureType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private ExposureType(String str, int i11) {
    }

    public static EnumEntries<ExposureType> getEntries() {
        return $ENTRIES;
    }

    public static ExposureType valueOf(String str) {
        return (ExposureType) Enum.valueOf(ExposureType.class, str);
    }

    public static ExposureType[] values() {
        return (ExposureType[]) $VALUES.clone();
    }
}
