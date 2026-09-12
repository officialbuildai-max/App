package com.transsion.pushapi;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/transsion/pushapi/TriggerSource;", "", "<init>", "(Ljava/lang/String;I)V", "APP_INNER", "SCREEN_ON", "UNLOCK", "NETWORK_CONNECTED", "PushApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class TriggerSource {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TriggerSource[] $VALUES;
    public static final TriggerSource APP_INNER = new TriggerSource("APP_INNER", 0);
    public static final TriggerSource SCREEN_ON = new TriggerSource("SCREEN_ON", 1);
    public static final TriggerSource UNLOCK = new TriggerSource("UNLOCK", 2);
    public static final TriggerSource NETWORK_CONNECTED = new TriggerSource("NETWORK_CONNECTED", 3);

    private static final /* synthetic */ TriggerSource[] $values() {
        return new TriggerSource[]{APP_INNER, SCREEN_ON, UNLOCK, NETWORK_CONNECTED};
    }

    static {
        TriggerSource[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private TriggerSource(String str, int i11) {
    }

    public static EnumEntries<TriggerSource> getEntries() {
        return $ENTRIES;
    }

    public static TriggerSource valueOf(String str) {
        return (TriggerSource) Enum.valueOf(TriggerSource.class, str);
    }

    public static TriggerSource[] values() {
        return (TriggerSource[]) $VALUES.clone();
    }
}
