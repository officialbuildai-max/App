package com.transsion.room.api;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/transsion/room/api/RoomTabId;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "EXPLORE", "NEARBY", "DISCOVER", "IMAGES", "RoomApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class RoomTabId {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RoomTabId[] $VALUES;
    private final String value;
    public static final RoomTabId EXPLORE = new RoomTabId("EXPLORE", 0, "explore");
    public static final RoomTabId NEARBY = new RoomTabId("NEARBY", 1, "nearby");
    public static final RoomTabId DISCOVER = new RoomTabId("DISCOVER", 2, "discover");
    public static final RoomTabId IMAGES = new RoomTabId("IMAGES", 3, "images");

    private static final /* synthetic */ RoomTabId[] $values() {
        return new RoomTabId[]{EXPLORE, NEARBY, DISCOVER, IMAGES};
    }

    static {
        RoomTabId[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private RoomTabId(String str, int i11, String str2) {
        this.value = str2;
    }

    public static EnumEntries<RoomTabId> getEntries() {
        return $ENTRIES;
    }

    public static RoomTabId valueOf(String str) {
        return (RoomTabId) Enum.valueOf(RoomTabId.class, str);
    }

    public static RoomTabId[] values() {
        return (RoomTabId[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
