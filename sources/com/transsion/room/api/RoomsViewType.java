package com.transsion.room.api;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/transsion/room/api/RoomsViewType;", "", "<init>", "(Ljava/lang/String;I)V", "TYPE_ROOM_HOME", "TYPE_TRENDING", "TYPE_SUBJECT_DETAIL", "RoomApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class RoomsViewType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RoomsViewType[] $VALUES;
    public static final RoomsViewType TYPE_ROOM_HOME = new RoomsViewType("TYPE_ROOM_HOME", 0);
    public static final RoomsViewType TYPE_TRENDING = new RoomsViewType("TYPE_TRENDING", 1);
    public static final RoomsViewType TYPE_SUBJECT_DETAIL = new RoomsViewType("TYPE_SUBJECT_DETAIL", 2);

    private static final /* synthetic */ RoomsViewType[] $values() {
        return new RoomsViewType[]{TYPE_ROOM_HOME, TYPE_TRENDING, TYPE_SUBJECT_DETAIL};
    }

    static {
        RoomsViewType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private RoomsViewType(String str, int i11) {
    }

    public static EnumEntries<RoomsViewType> getEntries() {
        return $ENTRIES;
    }

    public static RoomsViewType valueOf(String str) {
        return (RoomsViewType) Enum.valueOf(RoomsViewType.class, str);
    }

    public static RoomsViewType[] values() {
        return (RoomsViewType[]) $VALUES.clone();
    }
}
