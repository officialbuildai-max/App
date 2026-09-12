package com.transsion.base.infras_config.model;

import com.google.gson.annotations.SerializedName;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/transsion/base/infras_config/model/InfrasSourceType;", "", "<init>", "(Ljava/lang/String;I)V", "ST_UNKNOWN", "ST_EMBEDDED", "ST_PROBER", "ST_PUSH", "ST_SNIFFER", "base_infras_config_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class InfrasSourceType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ InfrasSourceType[] $VALUES;

    @SerializedName("ST_UNKNOWN")
    public static final InfrasSourceType ST_UNKNOWN = new InfrasSourceType("ST_UNKNOWN", 0);

    @SerializedName("ST_EMBEDDED")
    public static final InfrasSourceType ST_EMBEDDED = new InfrasSourceType("ST_EMBEDDED", 1);

    @SerializedName("ST_PROBER")
    public static final InfrasSourceType ST_PROBER = new InfrasSourceType("ST_PROBER", 2);

    @SerializedName("ST_PUSH")
    public static final InfrasSourceType ST_PUSH = new InfrasSourceType("ST_PUSH", 3);

    @SerializedName("ST_SNIFFER")
    public static final InfrasSourceType ST_SNIFFER = new InfrasSourceType("ST_SNIFFER", 4);

    private static final /* synthetic */ InfrasSourceType[] $values() {
        return new InfrasSourceType[]{ST_UNKNOWN, ST_EMBEDDED, ST_PROBER, ST_PUSH, ST_SNIFFER};
    }

    static {
        InfrasSourceType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private InfrasSourceType(String str, int i11) {
    }

    public static EnumEntries<InfrasSourceType> getEntries() {
        return $ENTRIES;
    }

    public static InfrasSourceType valueOf(String str) {
        return (InfrasSourceType) Enum.valueOf(InfrasSourceType.class, str);
    }

    public static InfrasSourceType[] values() {
        return (InfrasSourceType[]) $VALUES.clone();
    }
}
