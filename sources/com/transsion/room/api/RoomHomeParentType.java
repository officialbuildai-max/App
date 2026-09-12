package com.transsion.room.api;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/transsion/room/api/RoomHomeParentType;", "", "<init>", "(Ljava/lang/String;I)V", "BOTTOM_TAB", "TOP_TAB", "SINGLE_PAGE", "RoomApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class RoomHomeParentType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RoomHomeParentType[] $VALUES;
    public static final RoomHomeParentType BOTTOM_TAB = new RoomHomeParentType("BOTTOM_TAB", 0);
    public static final RoomHomeParentType TOP_TAB = new RoomHomeParentType("TOP_TAB", 1);
    public static final RoomHomeParentType SINGLE_PAGE = new RoomHomeParentType("SINGLE_PAGE", 2);

    private static final /* synthetic */ RoomHomeParentType[] $values() {
        return new RoomHomeParentType[]{BOTTOM_TAB, TOP_TAB, SINGLE_PAGE};
    }

    static {
        RoomHomeParentType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private RoomHomeParentType(String str, int i11) {
    }

    public static EnumEntries<RoomHomeParentType> getEntries() {
        return $ENTRIES;
    }

    public static RoomHomeParentType valueOf(String str) {
        return (RoomHomeParentType) Enum.valueOf(RoomHomeParentType.class, str);
    }

    public static RoomHomeParentType[] values() {
        return (RoomHomeParentType[]) $VALUES.clone();
    }
}
