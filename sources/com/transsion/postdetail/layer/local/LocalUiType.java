package com.transsion.postdetail.layer.local;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/transsion/postdetail/layer/local/LocalUiType;", "", "<init>", "(Ljava/lang/String;I)V", "LAND", "PORTRAIT", "MIDDLE", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class LocalUiType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LocalUiType[] $VALUES;
    public static final LocalUiType LAND = new LocalUiType("LAND", 0);
    public static final LocalUiType PORTRAIT = new LocalUiType("PORTRAIT", 1);
    public static final LocalUiType MIDDLE = new LocalUiType("MIDDLE", 2);

    private static final /* synthetic */ LocalUiType[] $values() {
        return new LocalUiType[]{LAND, PORTRAIT, MIDDLE};
    }

    static {
        LocalUiType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private LocalUiType(String str, int i11) {
    }

    public static EnumEntries<LocalUiType> getEntries() {
        return $ENTRIES;
    }

    public static LocalUiType valueOf(String str) {
        return (LocalUiType) Enum.valueOf(LocalUiType.class, str);
    }

    public static LocalUiType[] values() {
        return (LocalUiType[]) $VALUES.clone();
    }
}
