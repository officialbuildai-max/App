package com.transsnet.downloader.adapter;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/transsnet/downloader/adapter/LayoutType;", "", "<init>", "(Ljava/lang/String;I)V", "NO_DONE_LAYOUT", "DONE_LAYOUT", "ALL_EP_BTN", "FOR_YOU", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class LayoutType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LayoutType[] $VALUES;
    public static final LayoutType NO_DONE_LAYOUT = new LayoutType("NO_DONE_LAYOUT", 0);
    public static final LayoutType DONE_LAYOUT = new LayoutType("DONE_LAYOUT", 1);
    public static final LayoutType ALL_EP_BTN = new LayoutType("ALL_EP_BTN", 2);
    public static final LayoutType FOR_YOU = new LayoutType("FOR_YOU", 3);

    private static final /* synthetic */ LayoutType[] $values() {
        return new LayoutType[]{NO_DONE_LAYOUT, DONE_LAYOUT, ALL_EP_BTN, FOR_YOU};
    }

    static {
        LayoutType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private LayoutType(String str, int i11) {
    }

    public static EnumEntries<LayoutType> getEntries() {
        return $ENTRIES;
    }

    public static LayoutType valueOf(String str) {
        return (LayoutType) Enum.valueOf(LayoutType.class, str);
    }

    public static LayoutType[] values() {
        return (LayoutType[]) $VALUES.clone();
    }
}
