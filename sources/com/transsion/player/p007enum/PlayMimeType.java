package com.transsion.player.p007enum;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/transsion/player/enum/PlayMimeType;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "DASH", "HLS", "RTMP", "LibPlayer_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class PlayMimeType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PlayMimeType[] $VALUES;
    public static final PlayMimeType DEFAULT = new PlayMimeType("DEFAULT", 0);
    public static final PlayMimeType DASH = new PlayMimeType("DASH", 1);
    public static final PlayMimeType HLS = new PlayMimeType("HLS", 2);
    public static final PlayMimeType RTMP = new PlayMimeType("RTMP", 3);

    private static final /* synthetic */ PlayMimeType[] $values() {
        return new PlayMimeType[]{DEFAULT, DASH, HLS, RTMP};
    }

    static {
        PlayMimeType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private PlayMimeType(String str, int i11) {
    }

    public static EnumEntries<PlayMimeType> getEntries() {
        return $ENTRIES;
    }

    public static PlayMimeType valueOf(String str) {
        return (PlayMimeType) Enum.valueOf(PlayMimeType.class, str);
    }

    public static PlayMimeType[] values() {
        return (PlayMimeType[]) $VALUES.clone();
    }
}
