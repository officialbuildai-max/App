package com.transsion.moviedetailapi;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/transsion/moviedetailapi/PostRankType;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "POST_RANK_TYPE_DEFAULT", "POST_RANK_TYPE_HOT", "POST_RANK_TYPE_NEW", "MovieDetailApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes.dex */
public final class PostRankType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PostRankType[] $VALUES;
    public static final PostRankType POST_RANK_TYPE_DEFAULT = new PostRankType("POST_RANK_TYPE_DEFAULT", 0, "PostRankTypeDefault");
    public static final PostRankType POST_RANK_TYPE_HOT = new PostRankType("POST_RANK_TYPE_HOT", 1, "PostRankTypeHot");
    public static final PostRankType POST_RANK_TYPE_NEW = new PostRankType("POST_RANK_TYPE_NEW", 2, "PostRankTypeNew");
    private String value;

    private static final /* synthetic */ PostRankType[] $values() {
        return new PostRankType[]{POST_RANK_TYPE_DEFAULT, POST_RANK_TYPE_HOT, POST_RANK_TYPE_NEW};
    }

    static {
        PostRankType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private PostRankType(String str, int i11, String str2) {
        this.value = str2;
    }

    public static EnumEntries<PostRankType> getEntries() {
        return $ENTRIES;
    }

    public static PostRankType valueOf(String str) {
        return (PostRankType) Enum.valueOf(PostRankType.class, str);
    }

    public static PostRankType[] values() {
        return (PostRankType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(String str) {
        Intrinsics.h(str, "<set-?>");
        this.value = str;
    }
}
