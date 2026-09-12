package com.tn.lib.net.cons;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/tn/lib/net/cons/HeaderType;", "", "<init>", "(Ljava/lang/String;I)V", "ONE_ROOM", "lib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes.dex */
public final class HeaderType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HeaderType[] $VALUES;
    public static final HeaderType ONE_ROOM = new HeaderType("ONE_ROOM", 0);

    private static final /* synthetic */ HeaderType[] $values() {
        return new HeaderType[]{ONE_ROOM};
    }

    static {
        HeaderType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private HeaderType(String str, int i11) {
    }

    public static EnumEntries<HeaderType> getEntries() {
        return $ENTRIES;
    }

    public static HeaderType valueOf(String str) {
        return (HeaderType) Enum.valueOf(HeaderType.class, str);
    }

    public static HeaderType[] values() {
        return (HeaderType[]) $VALUES.clone();
    }
}
