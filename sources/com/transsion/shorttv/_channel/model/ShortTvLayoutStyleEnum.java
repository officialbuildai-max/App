package com.transsion.shorttv._channel.model;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/transsion/shorttv/_channel/model/ShortTvLayoutStyleEnum;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Vertical", "Horizontal", "Square", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class ShortTvLayoutStyleEnum {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ShortTvLayoutStyleEnum[] $VALUES;
    private final String value;
    public static final ShortTvLayoutStyleEnum Vertical = new ShortTvLayoutStyleEnum("Vertical", 0, "Vertical");
    public static final ShortTvLayoutStyleEnum Horizontal = new ShortTvLayoutStyleEnum("Horizontal", 1, "Horizontal");
    public static final ShortTvLayoutStyleEnum Square = new ShortTvLayoutStyleEnum("Square", 2, "Square");

    private static final /* synthetic */ ShortTvLayoutStyleEnum[] $values() {
        return new ShortTvLayoutStyleEnum[]{Vertical, Horizontal, Square};
    }

    static {
        ShortTvLayoutStyleEnum[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private ShortTvLayoutStyleEnum(String str, int i11, String str2) {
        this.value = str2;
    }

    public static EnumEntries<ShortTvLayoutStyleEnum> getEntries() {
        return $ENTRIES;
    }

    public static ShortTvLayoutStyleEnum valueOf(String str) {
        return (ShortTvLayoutStyleEnum) Enum.valueOf(ShortTvLayoutStyleEnum.class, str);
    }

    public static ShortTvLayoutStyleEnum[] values() {
        return (ShortTvLayoutStyleEnum[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
