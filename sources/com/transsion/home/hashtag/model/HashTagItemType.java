package com.transsion.home.hashtag.model;

import androidx.annotation.Keep;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Keep
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/transsion/home/hashtag/model/HashTagItemType;", "", "<init>", "(Ljava/lang/String;I)V", "TAGS", "HASHTAG_CARD", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class HashTagItemType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HashTagItemType[] $VALUES;
    public static final HashTagItemType TAGS = new HashTagItemType("TAGS", 0);
    public static final HashTagItemType HASHTAG_CARD = new HashTagItemType("HASHTAG_CARD", 1);

    private static final /* synthetic */ HashTagItemType[] $values() {
        return new HashTagItemType[]{TAGS, HASHTAG_CARD};
    }

    static {
        HashTagItemType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private HashTagItemType(String str, int i11) {
    }

    public static EnumEntries<HashTagItemType> getEntries() {
        return $ENTRIES;
    }

    public static HashTagItemType valueOf(String str) {
        return (HashTagItemType) Enum.valueOf(HashTagItemType.class, str);
    }

    public static HashTagItemType[] values() {
        return (HashTagItemType[]) $VALUES.clone();
    }
}
