package com.transsion.player.longvideo.constants;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/transsion/player/longvideo/constants/LongVodContentType;", "", "<init>", "(Ljava/lang/String;I)V", "SUBJECT", "UGC_VIDEO_LOCAL", "UGC_VIDEO_ONLINE", "LongVideo_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class LongVodContentType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LongVodContentType[] $VALUES;
    public static final LongVodContentType SUBJECT = new LongVodContentType("SUBJECT", 0);
    public static final LongVodContentType UGC_VIDEO_LOCAL = new LongVodContentType("UGC_VIDEO_LOCAL", 1);
    public static final LongVodContentType UGC_VIDEO_ONLINE = new LongVodContentType("UGC_VIDEO_ONLINE", 2);

    private static final /* synthetic */ LongVodContentType[] $values() {
        return new LongVodContentType[]{SUBJECT, UGC_VIDEO_LOCAL, UGC_VIDEO_ONLINE};
    }

    static {
        LongVodContentType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private LongVodContentType(String str, int i11) {
    }

    public static EnumEntries<LongVodContentType> getEntries() {
        return $ENTRIES;
    }

    public static LongVodContentType valueOf(String str) {
        return (LongVodContentType) Enum.valueOf(LongVodContentType.class, str);
    }

    public static LongVodContentType[] values() {
        return (LongVodContentType[]) $VALUES.clone();
    }
}
