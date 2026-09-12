package com.transsion.player.longvideo.constants;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/transsion/player/longvideo/constants/LongVodPlayerConfigType;", "", "<init>", "(Ljava/lang/String;I)V", "SPEED", "BITRATE", "LongVideo_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class LongVodPlayerConfigType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LongVodPlayerConfigType[] $VALUES;
    public static final LongVodPlayerConfigType SPEED = new LongVodPlayerConfigType("SPEED", 0);
    public static final LongVodPlayerConfigType BITRATE = new LongVodPlayerConfigType("BITRATE", 1);

    private static final /* synthetic */ LongVodPlayerConfigType[] $values() {
        return new LongVodPlayerConfigType[]{SPEED, BITRATE};
    }

    static {
        LongVodPlayerConfigType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private LongVodPlayerConfigType(String str, int i11) {
    }

    public static EnumEntries<LongVodPlayerConfigType> getEntries() {
        return $ENTRIES;
    }

    public static LongVodPlayerConfigType valueOf(String str) {
        return (LongVodPlayerConfigType) Enum.valueOf(LongVodPlayerConfigType.class, str);
    }

    public static LongVodPlayerConfigType[] values() {
        return (LongVodPlayerConfigType[]) $VALUES.clone();
    }
}
