package com.transsion.player.longvideo.constants;

import com.transsion.home.p004enum.BottomTabType;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/transsion/player/longvideo/constants/LongVodPageType;", "", "<init>", "(Ljava/lang/String;I)V", "STREAM", "LOCAL_VIDEO", "TRAILER", BottomTabType.TAB_CODE_MUSIC, "LongVideo_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class LongVodPageType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LongVodPageType[] $VALUES;
    public static final LongVodPageType STREAM = new LongVodPageType("STREAM", 0);
    public static final LongVodPageType LOCAL_VIDEO = new LongVodPageType("LOCAL_VIDEO", 1);
    public static final LongVodPageType TRAILER = new LongVodPageType("TRAILER", 2);
    public static final LongVodPageType MUSIC = new LongVodPageType(BottomTabType.TAB_CODE_MUSIC, 3);

    private static final /* synthetic */ LongVodPageType[] $values() {
        return new LongVodPageType[]{STREAM, LOCAL_VIDEO, TRAILER, MUSIC};
    }

    static {
        LongVodPageType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private LongVodPageType(String str, int i11) {
    }

    public static EnumEntries<LongVodPageType> getEntries() {
        return $ENTRIES;
    }

    public static LongVodPageType valueOf(String str) {
        return (LongVodPageType) Enum.valueOf(LongVodPageType.class, str);
    }

    public static LongVodPageType[] values() {
        return (LongVodPageType[]) $VALUES.clone();
    }
}
