package com.transsion.room.adapter;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/transsion/room/adapter/RoomListFrom;", "", "<init>", "(Ljava/lang/String;I)V", "MY_ROOM", "ROOM_LIST", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class RoomListFrom {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RoomListFrom[] $VALUES;
    public static final RoomListFrom MY_ROOM = new RoomListFrom("MY_ROOM", 0);
    public static final RoomListFrom ROOM_LIST = new RoomListFrom("ROOM_LIST", 1);

    private static final /* synthetic */ RoomListFrom[] $values() {
        return new RoomListFrom[]{MY_ROOM, ROOM_LIST};
    }

    static {
        RoomListFrom[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private RoomListFrom(String str, int i11) {
    }

    public static EnumEntries<RoomListFrom> getEntries() {
        return $ENTRIES;
    }

    public static RoomListFrom valueOf(String str) {
        return (RoomListFrom) Enum.valueOf(RoomListFrom.class, str);
    }

    public static RoomListFrom[] values() {
        return (RoomListFrom[]) $VALUES.clone();
    }
}
