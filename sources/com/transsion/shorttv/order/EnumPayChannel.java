package com.transsion.shorttv.order;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/transsion/shorttv/order/EnumPayChannel;", "", "values", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValues", "()Ljava/lang/String;", "PAY_CHANNEL_PAYNICORN", "PAY_CHANNEL_GP", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class EnumPayChannel {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ EnumPayChannel[] $VALUES;
    private final String values;
    public static final EnumPayChannel PAY_CHANNEL_PAYNICORN = new EnumPayChannel("PAY_CHANNEL_PAYNICORN", 0, "paynicorn");
    public static final EnumPayChannel PAY_CHANNEL_GP = new EnumPayChannel("PAY_CHANNEL_GP", 1, "gp");

    private static final /* synthetic */ EnumPayChannel[] $values() {
        return new EnumPayChannel[]{PAY_CHANNEL_PAYNICORN, PAY_CHANNEL_GP};
    }

    static {
        EnumPayChannel[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private EnumPayChannel(String str, int i11, String str2) {
        this.values = str2;
    }

    public static EnumEntries<EnumPayChannel> getEntries() {
        return $ENTRIES;
    }

    public static EnumPayChannel valueOf(String str) {
        return (EnumPayChannel) Enum.valueOf(EnumPayChannel.class, str);
    }

    public static EnumPayChannel[] values() {
        return (EnumPayChannel[]) $VALUES.clone();
    }

    public final String getValues() {
        return this.values;
    }
}
