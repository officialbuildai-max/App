package com.transsion.bean;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/transsion/bean/GameInfoType;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PS", "AHA", "CommercializationApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class GameInfoType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GameInfoType[] $VALUES;
    private final String value;
    public static final GameInfoType PS = new GameInfoType("PS", 0, "PSGame");
    public static final GameInfoType AHA = new GameInfoType("AHA", 1, "AHAGame");

    private static final /* synthetic */ GameInfoType[] $values() {
        return new GameInfoType[]{PS, AHA};
    }

    static {
        GameInfoType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private GameInfoType(String str, int i11, String str2) {
        this.value = str2;
    }

    public static EnumEntries<GameInfoType> getEntries() {
        return $ENTRIES;
    }

    public static GameInfoType valueOf(String str) {
        return (GameInfoType) Enum.valueOf(GameInfoType.class, str);
    }

    public static GameInfoType[] values() {
        return (GameInfoType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
