package com.tn.lib.view;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/tn/lib/view/RoomJoinStatus;", "", "<init>", "(Ljava/lang/String;I)V", "JOIN", "LOADING", "JOINED", "UI_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes4.dex */
public final class RoomJoinStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RoomJoinStatus[] $VALUES;
    public static final RoomJoinStatus JOIN = new RoomJoinStatus("JOIN", 0);
    public static final RoomJoinStatus LOADING = new RoomJoinStatus("LOADING", 1);
    public static final RoomJoinStatus JOINED = new RoomJoinStatus("JOINED", 2);

    private static final /* synthetic */ RoomJoinStatus[] $values() {
        return new RoomJoinStatus[]{JOIN, LOADING, JOINED};
    }

    static {
        RoomJoinStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private RoomJoinStatus(String str, int i11) {
    }

    public static EnumEntries<RoomJoinStatus> getEntries() {
        return $ENTRIES;
    }

    public static RoomJoinStatus valueOf(String str) {
        return (RoomJoinStatus) Enum.valueOf(RoomJoinStatus.class, str);
    }

    public static RoomJoinStatus[] values() {
        return (RoomJoinStatus[]) $VALUES.clone();
    }
}
