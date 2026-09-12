package com.transsion.moviedetailapi.p006enum;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/transsion/moviedetailapi/enum/PostListSource;", "", "<init>", "(Ljava/lang/String;I)V", "SUBJECT", "ROOM", "PROFILE", "POSTLIST", "MovieDetailApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class PostListSource {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PostListSource[] $VALUES;
    public static final PostListSource SUBJECT = new PostListSource("SUBJECT", 0);
    public static final PostListSource ROOM = new PostListSource("ROOM", 1);
    public static final PostListSource PROFILE = new PostListSource("PROFILE", 2);
    public static final PostListSource POSTLIST = new PostListSource("POSTLIST", 3);

    private static final /* synthetic */ PostListSource[] $values() {
        return new PostListSource[]{SUBJECT, ROOM, PROFILE, POSTLIST};
    }

    static {
        PostListSource[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private PostListSource(String str, int i11) {
    }

    public static EnumEntries<PostListSource> getEntries() {
        return $ENTRIES;
    }

    public static PostListSource valueOf(String str) {
        return (PostListSource) Enum.valueOf(PostListSource.class, str);
    }

    public static PostListSource[] values() {
        return (PostListSource[]) $VALUES.clone();
    }
}
