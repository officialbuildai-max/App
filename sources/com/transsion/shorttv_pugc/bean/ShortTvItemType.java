package com.transsion.shorttv_pugc.bean;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\"\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#¨\u0006$"}, d2 = {"Lcom/transsion/shorttv_pugc/bean/ShortTvItemType;", "", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Companion", "a", "TRENDING", "FAVORITE", "OP_RANKING", "FILTER", "BANNER", "CUSTOM_DATA", "APPOINTMENT_LIST", "OP_SUBJECTS_MOVIE", "RANKING_MOVIE_HORIZONTAL", "RANKING_LIST", "RANKING_LIST_MUSIC", "SPORT_LIVE", "SINGLE_IMAGE", "PLAY_LIST", "RANKING_LIST_NUMBER", "HORIZONTAL_BANNER", "SINGLE_SUBJECT", "EDUCATION_SUBJECT", "GAME_LIST", "NO_NETWORK", "TRENDING_NATIVE_AD", "HONOR", "TRENDING_TITLE", "MY_COURSE", "ROOM", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class ShortTvItemType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ShortTvItemType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String value;
    public static final ShortTvItemType TRENDING = new ShortTvItemType("TRENDING", 0, "TRENDING");
    public static final ShortTvItemType FAVORITE = new ShortTvItemType("FAVORITE", 1, "FAVORITE");
    public static final ShortTvItemType OP_RANKING = new ShortTvItemType("OP_RANKING", 2, "RANKING");
    public static final ShortTvItemType FILTER = new ShortTvItemType("FILTER", 3, "FILTER");
    public static final ShortTvItemType BANNER = new ShortTvItemType("BANNER", 4, "BANNER");
    public static final ShortTvItemType CUSTOM_DATA = new ShortTvItemType("CUSTOM_DATA", 5, "CUSTOM");
    public static final ShortTvItemType APPOINTMENT_LIST = new ShortTvItemType("APPOINTMENT_LIST", 6, "APPOINTMENT_LIST");
    public static final ShortTvItemType OP_SUBJECTS_MOVIE = new ShortTvItemType("OP_SUBJECTS_MOVIE", 7, "SUBJECTS_MOVIE");
    public static final ShortTvItemType RANKING_MOVIE_HORIZONTAL = new ShortTvItemType("RANKING_MOVIE_HORIZONTAL", 8, "SUBJ_MOVIE_HORIZ");
    public static final ShortTvItemType RANKING_LIST = new ShortTvItemType("RANKING_LIST", 9, "RANKING_LIST");
    public static final ShortTvItemType RANKING_LIST_MUSIC = new ShortTvItemType("RANKING_LIST_MUSIC", 10, "MUSIC_CHARTS");
    public static final ShortTvItemType SPORT_LIVE = new ShortTvItemType("SPORT_LIVE", 11, "SPORT_LIVE");
    public static final ShortTvItemType SINGLE_IMAGE = new ShortTvItemType("SINGLE_IMAGE", 12, "SINGLE_IMAGE");
    public static final ShortTvItemType PLAY_LIST = new ShortTvItemType("PLAY_LIST", 13, "PLAY_LIST");
    public static final ShortTvItemType RANKING_LIST_NUMBER = new ShortTvItemType("RANKING_LIST_NUMBER", 14, "RANKING_HORIZ");
    public static final ShortTvItemType HORIZONTAL_BANNER = new ShortTvItemType("HORIZONTAL_BANNER", 15, "HORIZONTAL_BANNER");
    public static final ShortTvItemType SINGLE_SUBJECT = new ShortTvItemType("SINGLE_SUBJECT", 16, "SINGLE_SUBJECT");
    public static final ShortTvItemType EDUCATION_SUBJECT = new ShortTvItemType("EDUCATION_SUBJECT", 17, "EDUCATION_SUBJECT");
    public static final ShortTvItemType GAME_LIST = new ShortTvItemType("GAME_LIST", 18, "GAME_LIST");
    public static final ShortTvItemType NO_NETWORK = new ShortTvItemType("NO_NETWORK", 19, "no_network");
    public static final ShortTvItemType TRENDING_NATIVE_AD = new ShortTvItemType("TRENDING_NATIVE_AD", 20, "TRENDING_NATIVE_AD");
    public static final ShortTvItemType HONOR = new ShortTvItemType("HONOR", 21, "HONOR");
    public static final ShortTvItemType TRENDING_TITLE = new ShortTvItemType("TRENDING_TITLE", 22, "TRENDING_TITLE");
    public static final ShortTvItemType MY_COURSE = new ShortTvItemType("MY_COURSE", 23, "MY_COURSE");
    public static final ShortTvItemType ROOM = new ShortTvItemType("ROOM", 24, "ROOM");

    /* renamed from: com.transsion.shorttv_pugc.bean.ShortTvItemType$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ShortTvItemType a(String value) {
            Intrinsics.h(value, "value");
            for (ShortTvItemType shortTvItemType : ShortTvItemType.values()) {
                if (Intrinsics.c(shortTvItemType.getValue(), value)) {
                    return shortTvItemType;
                }
            }
            return null;
        }
    }

    private static final /* synthetic */ ShortTvItemType[] $values() {
        return new ShortTvItemType[]{TRENDING, FAVORITE, OP_RANKING, FILTER, BANNER, CUSTOM_DATA, APPOINTMENT_LIST, OP_SUBJECTS_MOVIE, RANKING_MOVIE_HORIZONTAL, RANKING_LIST, RANKING_LIST_MUSIC, SPORT_LIVE, SINGLE_IMAGE, PLAY_LIST, RANKING_LIST_NUMBER, HORIZONTAL_BANNER, SINGLE_SUBJECT, EDUCATION_SUBJECT, GAME_LIST, NO_NETWORK, TRENDING_NATIVE_AD, HONOR, TRENDING_TITLE, MY_COURSE, ROOM};
    }

    static {
        ShortTvItemType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
        INSTANCE = new Companion(null);
    }

    private ShortTvItemType(String str, int i11, String str2) {
        this.value = str2;
    }

    public static EnumEntries<ShortTvItemType> getEntries() {
        return $ENTRIES;
    }

    public static ShortTvItemType valueOf(String str) {
        return (ShortTvItemType) Enum.valueOf(ShortTvItemType.class, str);
    }

    public static ShortTvItemType[] values() {
        return (ShortTvItemType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
