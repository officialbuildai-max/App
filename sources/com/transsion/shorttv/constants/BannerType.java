package com.transsion.shorttv.constants;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/transsion/shorttv/constants/BannerType;", "", "<init>", "(Ljava/lang/String;I)V", "BANNER", "AD", "GUIDE", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class BannerType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BannerType[] $VALUES;
    public static final BannerType BANNER = new BannerType("BANNER", 0);
    public static final BannerType AD = new BannerType("AD", 1);
    public static final BannerType GUIDE = new BannerType("GUIDE", 2);

    private static final /* synthetic */ BannerType[] $values() {
        return new BannerType[]{BANNER, AD, GUIDE};
    }

    static {
        BannerType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private BannerType(String str, int i11) {
    }

    public static EnumEntries<BannerType> getEntries() {
        return $ENTRIES;
    }

    public static BannerType valueOf(String str) {
        return (BannerType) Enum.valueOf(BannerType.class, str);
    }

    public static BannerType[] values() {
        return (BannerType[]) $VALUES.clone();
    }
}
