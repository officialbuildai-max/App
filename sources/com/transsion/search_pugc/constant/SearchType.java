package com.transsion.search_pugc.constant;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/transsion/search_pugc/constant/SearchType;", "", "<init>", "(Ljava/lang/String;I)V", "UGC_COLLECTION", "VERTICAL_RANK", "VERTICAL_RANK_TYPE2", "HASH_TAG", "UGC_VIDEO", "UNKNOW", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class SearchType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SearchType[] $VALUES;
    public static final SearchType UGC_COLLECTION = new SearchType("UGC_COLLECTION", 0);
    public static final SearchType VERTICAL_RANK = new SearchType("VERTICAL_RANK", 1);
    public static final SearchType VERTICAL_RANK_TYPE2 = new SearchType("VERTICAL_RANK_TYPE2", 2);
    public static final SearchType HASH_TAG = new SearchType("HASH_TAG", 3);
    public static final SearchType UGC_VIDEO = new SearchType("UGC_VIDEO", 4);
    public static final SearchType UNKNOW = new SearchType("UNKNOW", 5);

    private static final /* synthetic */ SearchType[] $values() {
        return new SearchType[]{UGC_COLLECTION, VERTICAL_RANK, VERTICAL_RANK_TYPE2, HASH_TAG, UGC_VIDEO, UNKNOW};
    }

    static {
        SearchType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private SearchType(String str, int i11) {
    }

    public static EnumEntries<SearchType> getEntries() {
        return $ENTRIES;
    }

    public static SearchType valueOf(String str) {
        return (SearchType) Enum.valueOf(SearchType.class, str);
    }

    public static SearchType[] values() {
        return (SearchType[]) $VALUES.clone();
    }
}
