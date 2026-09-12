package com.tn.lib.net.env;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/tn/lib/net/env/HostType;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOW", "TEST", "RELEASE", "lib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes3.dex */
public final class HostType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HostType[] $VALUES;
    public static final HostType UNKNOW = new HostType("UNKNOW", 0);
    public static final HostType TEST = new HostType("TEST", 1);
    public static final HostType RELEASE = new HostType("RELEASE", 2);

    private static final /* synthetic */ HostType[] $values() {
        return new HostType[]{UNKNOW, TEST, RELEASE};
    }

    static {
        HostType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private HostType(String str, int i11) {
    }

    public static EnumEntries<HostType> getEntries() {
        return $ENTRIES;
    }

    public static HostType valueOf(String str) {
        return (HostType) Enum.valueOf(HostType.class, str);
    }

    public static HostType[] values() {
        return (HostType[]) $VALUES.clone();
    }
}
