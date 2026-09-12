package com.transsion.wrapperad.install.open;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/transsion/wrapperad/install/open/ChangeType;", "", "<init>", "(Ljava/lang/String;I)V", "INSTALLED", "UNINSTALLED", "UPDATED", "wrapperad_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class ChangeType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ChangeType[] $VALUES;
    public static final ChangeType INSTALLED = new ChangeType("INSTALLED", 0);
    public static final ChangeType UNINSTALLED = new ChangeType("UNINSTALLED", 1);
    public static final ChangeType UPDATED = new ChangeType("UPDATED", 2);

    private static final /* synthetic */ ChangeType[] $values() {
        return new ChangeType[]{INSTALLED, UNINSTALLED, UPDATED};
    }

    static {
        ChangeType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private ChangeType(String str, int i11) {
    }

    public static EnumEntries<ChangeType> getEntries() {
        return $ENTRIES;
    }

    public static ChangeType valueOf(String str) {
        return (ChangeType) Enum.valueOf(ChangeType.class, str);
    }

    public static ChangeType[] values() {
        return (ChangeType[]) $VALUES.clone();
    }
}
