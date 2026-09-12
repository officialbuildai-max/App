package com.transsion.moviedetailapi.bean;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b4\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5¨\u00066"}, d2 = {"Lcom/transsion/moviedetailapi/bean/PostItemType;", "", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Companion", "a", "FILTER", "BANNER", "CUSTOM_DATA", "APPOINTMENT_LIST", "OP_SUBJECTS_MOVIE", "RANKING_MOVIE_HORIZONTAL", "SPORT_LIVE", "SINGLE_IMAGE", "SUBJECT", "RANKING_LIST_MULTI_TAB", "POST_LIST", "MY_COURSE", "RANKING_LIST", "EDUCATION_SUBJECT", "OP_RANKING", "RANKING_LIST_MUSIC", "TRENDING_FEES_GRID", "TRENDING_FEES_BIG", "HASH_TAG", "UGC_BANNER", "UGC_MOVIE_RANK", "UGC_MUSIC_RANK", "UGC_FILTER", "UGC_SINGLE_IMAGE", "UGC_CUSTOM", "UGC_SPORT_LIVE", "UGC_RANKING_LIST", "UGC_SUBJECT_LIST", "UGC_PORTRAIT_GRID", "UGC_VERTICAL_OPT_LIST", "MULTILINE_SUBJECTS_LIST", "HORIZONTAL_BANNER", "SINGLE_SUBJECT", "GRID_SUBJECT", "NO_NETWORK", "TRENDING_NATIVE_AD", "FEEDS_TITLE", "TRENDING_MARGIN", "ROOM", "PREFERENCES", "MEMBER_BANNER", "TV_CHANNEL_ITEM", "TV_CHANNEL_HEADER", "MovieDetailApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes.dex */
public final class PostItemType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PostItemType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String value;
    public static final PostItemType FILTER = new PostItemType("FILTER", 0, "FILTER");
    public static final PostItemType BANNER = new PostItemType("BANNER", 1, "BANNER");
    public static final PostItemType CUSTOM_DATA = new PostItemType("CUSTOM_DATA", 2, "CUSTOM");
    public static final PostItemType APPOINTMENT_LIST = new PostItemType("APPOINTMENT_LIST", 3, "APPOINTMENT_LIST");
    public static final PostItemType OP_SUBJECTS_MOVIE = new PostItemType("OP_SUBJECTS_MOVIE", 4, "SUBJECTS_MOVIE");
    public static final PostItemType RANKING_MOVIE_HORIZONTAL = new PostItemType("RANKING_MOVIE_HORIZONTAL", 5, "SUBJ_MOVIE_HORIZ");
    public static final PostItemType SPORT_LIVE = new PostItemType("SPORT_LIVE", 6, "SPORT_LIVE");
    public static final PostItemType SINGLE_IMAGE = new PostItemType("SINGLE_IMAGE", 7, "SINGLE_IMAGE");
    public static final PostItemType SUBJECT = new PostItemType("SUBJECT", 8, "SUBJECT");
    public static final PostItemType RANKING_LIST_MULTI_TAB = new PostItemType("RANKING_LIST_MULTI_TAB", 9, "RANKING_LIST_MULTI_TAB");
    public static final PostItemType POST_LIST = new PostItemType("POST_LIST", 10, "POST_LIST");
    public static final PostItemType MY_COURSE = new PostItemType("MY_COURSE", 11, "MY_COURSE");
    public static final PostItemType RANKING_LIST = new PostItemType("RANKING_LIST", 12, "RANKING_LIST");
    public static final PostItemType EDUCATION_SUBJECT = new PostItemType("EDUCATION_SUBJECT", 13, "EDUCATION_SUBJECT");
    public static final PostItemType OP_RANKING = new PostItemType("OP_RANKING", 14, "RANKING");
    public static final PostItemType RANKING_LIST_MUSIC = new PostItemType("RANKING_LIST_MUSIC", 15, "MUSIC_CHARTS");
    public static final PostItemType TRENDING_FEES_GRID = new PostItemType("TRENDING_FEES_GRID", 16, "TRENDING_FEES_GRID");
    public static final PostItemType TRENDING_FEES_BIG = new PostItemType("TRENDING_FEES_BIG", 17, "TRENDING_FEES_BIG");
    public static final PostItemType HASH_TAG = new PostItemType("HASH_TAG", 18, "UGC_VIDEO_HASHTAG");
    public static final PostItemType UGC_BANNER = new PostItemType("UGC_BANNER", 19, "UGC_VIDEO_BANNER");
    public static final PostItemType UGC_MOVIE_RANK = new PostItemType("UGC_MOVIE_RANK", 20, "UGC_VIDEO_SUBJECTS_MOVIE");
    public static final PostItemType UGC_MUSIC_RANK = new PostItemType("UGC_MUSIC_RANK", 21, "UGC_VIDEO_MUSIC_CHARTS");
    public static final PostItemType UGC_FILTER = new PostItemType("UGC_FILTER", 22, "UGC_VIDEO_FILTER");
    public static final PostItemType UGC_SINGLE_IMAGE = new PostItemType("UGC_SINGLE_IMAGE", 23, "UGC_VIDEO_SINGLE_IMAGE");
    public static final PostItemType UGC_CUSTOM = new PostItemType("UGC_CUSTOM", 24, "UGC_VIDEO_CUSTOM");
    public static final PostItemType UGC_SPORT_LIVE = new PostItemType("UGC_SPORT_LIVE", 25, "UGC_VIDEO_SPORT_LIVE");
    public static final PostItemType UGC_RANKING_LIST = new PostItemType("UGC_RANKING_LIST", 26, "UGC_VIDEO_RANKING_LIST");
    public static final PostItemType UGC_SUBJECT_LIST = new PostItemType("UGC_SUBJECT_LIST", 27, "UGC_VIDEO_SUBJECTS_LIST");
    public static final PostItemType UGC_PORTRAIT_GRID = new PostItemType("UGC_PORTRAIT_GRID", 28, "UGC_VIDEO_SUBJECTS_LIST_PORTRAIT_GRID");
    public static final PostItemType UGC_VERTICAL_OPT_LIST = new PostItemType("UGC_VERTICAL_OPT_LIST", 29, "UGC_VERTICA_VIDEO_SUBJECTS_MOVIE");
    public static final PostItemType MULTILINE_SUBJECTS_LIST = new PostItemType("MULTILINE_SUBJECTS_LIST", 30, "MULTILINE_SUBJECTS_LIST");
    public static final PostItemType HORIZONTAL_BANNER = new PostItemType("HORIZONTAL_BANNER", 31, "HORIZONTAL_BANNER");
    public static final PostItemType SINGLE_SUBJECT = new PostItemType("SINGLE_SUBJECT", 32, "SINGLE_SUBJECT");
    public static final PostItemType GRID_SUBJECT = new PostItemType("GRID_SUBJECT", 33, "GRID_SUBJECT");
    public static final PostItemType NO_NETWORK = new PostItemType("NO_NETWORK", 34, "no_network");
    public static final PostItemType TRENDING_NATIVE_AD = new PostItemType("TRENDING_NATIVE_AD", 35, "TRENDING_NATIVE_AD");
    public static final PostItemType FEEDS_TITLE = new PostItemType("FEEDS_TITLE", 36, "FEEDS_TITLE");
    public static final PostItemType TRENDING_MARGIN = new PostItemType("TRENDING_MARGIN", 37, "TRENDING_MARGIN");
    public static final PostItemType ROOM = new PostItemType("ROOM", 38, "ROOM");
    public static final PostItemType PREFERENCES = new PostItemType("PREFERENCES", 39, "PREFERENCES");
    public static final PostItemType MEMBER_BANNER = new PostItemType("MEMBER_BANNER", 40, "MEMBER_BANNER");
    public static final PostItemType TV_CHANNEL_ITEM = new PostItemType("TV_CHANNEL_ITEM", 41, "TV_CHANNEL_ITEM");
    public static final PostItemType TV_CHANNEL_HEADER = new PostItemType("TV_CHANNEL_HEADER", 42, "TV_CHANNEL_HEADER");

    /* renamed from: com.transsion.moviedetailapi.bean.PostItemType$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PostItemType a(String value) {
            Intrinsics.h(value, "value");
            for (PostItemType postItemType : PostItemType.values()) {
                if (Intrinsics.c(postItemType.getValue(), value)) {
                    return postItemType;
                }
            }
            return null;
        }
    }

    private static final /* synthetic */ PostItemType[] $values() {
        return new PostItemType[]{FILTER, BANNER, CUSTOM_DATA, APPOINTMENT_LIST, OP_SUBJECTS_MOVIE, RANKING_MOVIE_HORIZONTAL, SPORT_LIVE, SINGLE_IMAGE, SUBJECT, RANKING_LIST_MULTI_TAB, POST_LIST, MY_COURSE, RANKING_LIST, EDUCATION_SUBJECT, OP_RANKING, RANKING_LIST_MUSIC, TRENDING_FEES_GRID, TRENDING_FEES_BIG, HASH_TAG, UGC_BANNER, UGC_MOVIE_RANK, UGC_MUSIC_RANK, UGC_FILTER, UGC_SINGLE_IMAGE, UGC_CUSTOM, UGC_SPORT_LIVE, UGC_RANKING_LIST, UGC_SUBJECT_LIST, UGC_PORTRAIT_GRID, UGC_VERTICAL_OPT_LIST, MULTILINE_SUBJECTS_LIST, HORIZONTAL_BANNER, SINGLE_SUBJECT, GRID_SUBJECT, NO_NETWORK, TRENDING_NATIVE_AD, FEEDS_TITLE, TRENDING_MARGIN, ROOM, PREFERENCES, MEMBER_BANNER, TV_CHANNEL_ITEM, TV_CHANNEL_HEADER};
    }

    static {
        PostItemType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
        INSTANCE = new Companion(null);
    }

    private PostItemType(String str, int i11, String str2) {
        this.value = str2;
    }

    public static EnumEntries<PostItemType> getEntries() {
        return $ENTRIES;
    }

    public static PostItemType valueOf(String str) {
        return (PostItemType) Enum.valueOf(PostItemType.class, str);
    }

    public static PostItemType[] values() {
        return (PostItemType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
