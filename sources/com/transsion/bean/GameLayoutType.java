package com.transsion.bean;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/transsion/bean/GameLayoutType;", "", "<init>", "(Ljava/lang/String;I)V", "ITEM_INFO", "ITEM_AD", "ITEM_TITLE", "PEOPLE_PLAYING", "CommercializationApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes.dex */
public final class GameLayoutType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GameLayoutType[] $VALUES;
    public static final GameLayoutType ITEM_INFO = new GameLayoutType("ITEM_INFO", 0);
    public static final GameLayoutType ITEM_AD = new GameLayoutType("ITEM_AD", 1);
    public static final GameLayoutType ITEM_TITLE = new GameLayoutType("ITEM_TITLE", 2);
    public static final GameLayoutType PEOPLE_PLAYING = new GameLayoutType("PEOPLE_PLAYING", 3);

    private static final /* synthetic */ GameLayoutType[] $values() {
        return new GameLayoutType[]{ITEM_INFO, ITEM_AD, ITEM_TITLE, PEOPLE_PLAYING};
    }

    static {
        GameLayoutType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private GameLayoutType(String str, int i11) {
    }

    public static EnumEntries<GameLayoutType> getEntries() {
        return $ENTRIES;
    }

    public static GameLayoutType valueOf(String str) {
        return (GameLayoutType) Enum.valueOf(GameLayoutType.class, str);
    }

    public static GameLayoutType[] values() {
        return (GameLayoutType[]) $VALUES.clone();
    }
}
