package com.transsion.videofloat.bean;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/transsion/videofloat/bean/FloatPlayType;", "", "<init>", "(Ljava/lang/String;I)V", "SHORT_TV", "STREAM", "LOCAL", "TRAILER", "VideoFloat_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class FloatPlayType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FloatPlayType[] $VALUES;
    public static final FloatPlayType SHORT_TV = new FloatPlayType("SHORT_TV", 0);
    public static final FloatPlayType STREAM = new FloatPlayType("STREAM", 1);
    public static final FloatPlayType LOCAL = new FloatPlayType("LOCAL", 2);
    public static final FloatPlayType TRAILER = new FloatPlayType("TRAILER", 3);

    private static final /* synthetic */ FloatPlayType[] $values() {
        return new FloatPlayType[]{SHORT_TV, STREAM, LOCAL, TRAILER};
    }

    static {
        FloatPlayType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private FloatPlayType(String str, int i11) {
    }

    public static EnumEntries<FloatPlayType> getEntries() {
        return $ENTRIES;
    }

    public static FloatPlayType valueOf(String str) {
        return (FloatPlayType) Enum.valueOf(FloatPlayType.class, str);
    }

    public static FloatPlayType[] values() {
        return (FloatPlayType[]) $VALUES.clone();
    }
}
