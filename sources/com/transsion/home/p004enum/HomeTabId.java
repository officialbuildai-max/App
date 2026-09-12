package com.transsion.home.p004enum;

import ak.g;
import ak.o;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.transsion.search.bean.HotRankItem;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b!\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006#"}, d2 = {"Lcom/transsion/home/enum/HomeTabId;", "", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "<init>", "(Ljava/lang/String;II)V", "I", "getValue", "()I", "Companion", "a", "Trending", HotRankItem.CATE_MOVIE, "Education", HotRankItem.CATE_MUSIC, "TVShow", "Apps", "ShortTV", "Animation", "Midnight", "AD", "Game", "MusicOperate", "ShortTVDiscover", "TVChannel", "UGC_Trending", "UGC_Movie", "UGC_Education", "UGC_Music", "UGC_TVShow", "UGC_ShortTV", "UGC_TVChannel", "UGC_Kids_Education", "UGC_Kids_Movie", "UGC_Kids_Animation", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class HomeTabId {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HomeTabId[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static Set<Integer> educationList;
    private final int value;
    public static final HomeTabId Trending = new HomeTabId("Trending", 0, 1);
    public static final HomeTabId Movie = new HomeTabId(HotRankItem.CATE_MOVIE, 1, 2);
    public static final HomeTabId Education = new HomeTabId("Education", 2, 3);
    public static final HomeTabId Music = new HomeTabId(HotRankItem.CATE_MUSIC, 3, 4);
    public static final HomeTabId TVShow = new HomeTabId("TVShow", 4, 5);
    public static final HomeTabId Apps = new HomeTabId("Apps", 5, 6);
    public static final HomeTabId ShortTV = new HomeTabId("ShortTV", 6, 7);
    public static final HomeTabId Animation = new HomeTabId("Animation", 7, 8);
    public static final HomeTabId Midnight = new HomeTabId("Midnight", 8, 9);
    public static final HomeTabId AD = new HomeTabId("AD", 9, 10);
    public static final HomeTabId Game = new HomeTabId("Game", 10, 11);
    public static final HomeTabId MusicOperate = new HomeTabId("MusicOperate", 11, 12);
    public static final HomeTabId ShortTVDiscover = new HomeTabId("ShortTVDiscover", 12, 13);
    public static final HomeTabId TVChannel = new HomeTabId("TVChannel", 13, 42);
    public static final HomeTabId UGC_Trending = new HomeTabId("UGC_Trending", 14, 1000);
    public static final HomeTabId UGC_Movie = new HomeTabId("UGC_Movie", 15, 1001);
    public static final HomeTabId UGC_Education = new HomeTabId("UGC_Education", 16, 1002);
    public static final HomeTabId UGC_Music = new HomeTabId("UGC_Music", 17, 1003);
    public static final HomeTabId UGC_TVShow = new HomeTabId("UGC_TVShow", 18, 1004);
    public static final HomeTabId UGC_ShortTV = new HomeTabId("UGC_ShortTV", 19, 1005);
    public static final HomeTabId UGC_TVChannel = new HomeTabId("UGC_TVChannel", 20, 1033);
    public static final HomeTabId UGC_Kids_Education = new HomeTabId("UGC_Kids_Education", 21, 1012);
    public static final HomeTabId UGC_Kids_Movie = new HomeTabId("UGC_Kids_Movie", 22, 1023);
    public static final HomeTabId UGC_Kids_Animation = new HomeTabId("UGC_Kids_Animation", 23, 1024);

    /* renamed from: com.transsion.home.enum.HomeTabId$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int c() {
            return g.f714a.b() ? o.f721a.i() ? HomeTabId.UGC_Kids_Education.getValue() : HomeTabId.UGC_Education.getValue() : HomeTabId.Education.getValue();
        }

        public final void a(Integer num) {
            if (num != null) {
                HomeTabId.educationList.add(Integer.valueOf(num.intValue()));
            }
        }

        public final int b() {
            return o.f721a.i() ? HomeTabId.UGC_Kids_Animation.getValue() : HomeTabId.Animation.getValue();
        }

        public final int d() {
            return g.f714a.b() ? o.f721a.i() ? HomeTabId.UGC_Kids_Movie.getValue() : HomeTabId.UGC_Movie.getValue() : HomeTabId.Movie.getValue();
        }

        public final int e() {
            return g.f714a.b() ? HomeTabId.UGC_Music.getValue() : HomeTabId.MusicOperate.getValue();
        }

        public final int f() {
            return g.f714a.b() ? HomeTabId.UGC_TVShow.getValue() : HomeTabId.TVShow.getValue();
        }

        public final int g() {
            return g.f714a.b() ? HomeTabId.UGC_Trending.getValue() : HomeTabId.Trending.getValue();
        }

        public final boolean h(Integer num, boolean z10) {
            if (z10) {
                return (num != null && num.intValue() == HomeTabId.Education.getValue()) || CollectionsKt.b0(HomeTabId.educationList, num);
            }
            return (num != null && num.intValue() == c()) || CollectionsKt.b0(HomeTabId.educationList, num);
        }
    }

    private static final /* synthetic */ HomeTabId[] $values() {
        return new HomeTabId[]{Trending, Movie, Education, Music, TVShow, Apps, ShortTV, Animation, Midnight, AD, Game, MusicOperate, ShortTVDiscover, TVChannel, UGC_Trending, UGC_Movie, UGC_Education, UGC_Music, UGC_TVShow, UGC_ShortTV, UGC_TVChannel, UGC_Kids_Education, UGC_Kids_Movie, UGC_Kids_Animation};
    }

    static {
        HomeTabId[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
        INSTANCE = new Companion(null);
        educationList = new LinkedHashSet();
    }

    private HomeTabId(String str, int i11, int i12) {
        this.value = i12;
    }

    public static EnumEntries<HomeTabId> getEntries() {
        return $ENTRIES;
    }

    public static HomeTabId valueOf(String str) {
        return (HomeTabId) Enum.valueOf(HomeTabId.class, str);
    }

    public static HomeTabId[] values() {
        return (HomeTabId[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}
