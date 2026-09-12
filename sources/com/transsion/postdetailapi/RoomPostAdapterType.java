package com.transsion.postdetailapi;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/transsion/postdetailapi/RoomPostAdapterType;", "", "<init>", "(Ljava/lang/String;I)V", "ROOM_HOME_EXPLORE", "ROOM_HOME_NEARBY", "ROOM_DETAIL_POST", "PostDetailApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class RoomPostAdapterType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RoomPostAdapterType[] $VALUES;
    public static final RoomPostAdapterType ROOM_HOME_EXPLORE = new RoomPostAdapterType("ROOM_HOME_EXPLORE", 0);
    public static final RoomPostAdapterType ROOM_HOME_NEARBY = new RoomPostAdapterType("ROOM_HOME_NEARBY", 1);
    public static final RoomPostAdapterType ROOM_DETAIL_POST = new RoomPostAdapterType("ROOM_DETAIL_POST", 2);

    private static final /* synthetic */ RoomPostAdapterType[] $values() {
        return new RoomPostAdapterType[]{ROOM_HOME_EXPLORE, ROOM_HOME_NEARBY, ROOM_DETAIL_POST};
    }

    static {
        RoomPostAdapterType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private RoomPostAdapterType(String str, int i11) {
    }

    public static EnumEntries<RoomPostAdapterType> getEntries() {
        return $ENTRIES;
    }

    public static RoomPostAdapterType valueOf(String str) {
        return (RoomPostAdapterType) Enum.valueOf(RoomPostAdapterType.class, str);
    }

    public static RoomPostAdapterType[] values() {
        return (RoomPostAdapterType[]) $VALUES.clone();
    }
}
