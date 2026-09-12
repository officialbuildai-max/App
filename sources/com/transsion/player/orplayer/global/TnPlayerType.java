package com.transsion.player.orplayer.global;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/transsion/player/orplayer/global/TnPlayerType;", "", "<init>", "(Ljava/lang/String;I)V", "EXO", "ALIYUN", "LibPlayer_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class TnPlayerType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TnPlayerType[] $VALUES;
    public static final TnPlayerType EXO = new TnPlayerType("EXO", 0);
    public static final TnPlayerType ALIYUN = new TnPlayerType("ALIYUN", 1);

    private static final /* synthetic */ TnPlayerType[] $values() {
        return new TnPlayerType[]{EXO, ALIYUN};
    }

    static {
        TnPlayerType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private TnPlayerType(String str, int i11) {
    }

    public static EnumEntries<TnPlayerType> getEntries() {
        return $ENTRIES;
    }

    public static TnPlayerType valueOf(String str) {
        return (TnPlayerType) Enum.valueOf(TnPlayerType.class, str);
    }

    public static TnPlayerType[] values() {
        return (TnPlayerType[]) $VALUES.clone();
    }
}
