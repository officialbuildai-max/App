package com.transsion.videodetail.music.bean;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/transsion/videodetail/music/bean/MusicStateEnum;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "CLOSE", "OPEN", "VideoDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class MusicStateEnum {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MusicStateEnum[] $VALUES;
    public static final MusicStateEnum NORMAL = new MusicStateEnum("NORMAL", 0);
    public static final MusicStateEnum CLOSE = new MusicStateEnum("CLOSE", 1);
    public static final MusicStateEnum OPEN = new MusicStateEnum("OPEN", 2);

    private static final /* synthetic */ MusicStateEnum[] $values() {
        return new MusicStateEnum[]{NORMAL, CLOSE, OPEN};
    }

    static {
        MusicStateEnum[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private MusicStateEnum(String str, int i11) {
    }

    public static EnumEntries<MusicStateEnum> getEntries() {
        return $ENTRIES;
    }

    public static MusicStateEnum valueOf(String str) {
        return (MusicStateEnum) Enum.valueOf(MusicStateEnum.class, str);
    }

    public static MusicStateEnum[] values() {
        return (MusicStateEnum[]) $VALUES.clone();
    }
}
