package com.transsion.ugcvideodetail.api;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.transsion.home.p004enum.BottomTabType;
import com.transsion.search.bean.HotRankItem;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/transsion/ugcvideodetail/api/UGCVideoType;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "MOVIE", HotRankItem.CATE_TV, "EDUCATION", BottomTabType.TAB_CODE_MUSIC, "SHORT_TV", "SPORT", "POST", "ROOM", BottomTabType.TAB_CODE_NOVEL, "LIVE", "KIDS", "RECREATION", "UGCVideoDetailApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class UGCVideoType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ UGCVideoType[] $VALUES;
    private final String value;
    public static final UGCVideoType MOVIE = new UGCVideoType("MOVIE", 0, HotRankItem.CATE_MOVIE);
    public static final UGCVideoType TV = new UGCVideoType(HotRankItem.CATE_TV, 1, "Tv");
    public static final UGCVideoType EDUCATION = new UGCVideoType("EDUCATION", 2, "Education");
    public static final UGCVideoType MUSIC = new UGCVideoType(BottomTabType.TAB_CODE_MUSIC, 3, HotRankItem.CATE_MUSIC);
    public static final UGCVideoType SHORT_TV = new UGCVideoType("SHORT_TV", 4, "ShortTV");
    public static final UGCVideoType SPORT = new UGCVideoType("SPORT", 5, "Sport");
    public static final UGCVideoType POST = new UGCVideoType("POST", 6, "Post");
    public static final UGCVideoType ROOM = new UGCVideoType("ROOM", 7, "Room");
    public static final UGCVideoType NOVEL = new UGCVideoType(BottomTabType.TAB_CODE_NOVEL, 8, "Novel");
    public static final UGCVideoType LIVE = new UGCVideoType("LIVE", 9, "Live");
    public static final UGCVideoType KIDS = new UGCVideoType("KIDS", 10, "Kids");
    public static final UGCVideoType RECREATION = new UGCVideoType("RECREATION", 11, "Recreation");

    private static final /* synthetic */ UGCVideoType[] $values() {
        return new UGCVideoType[]{MOVIE, TV, EDUCATION, MUSIC, SHORT_TV, SPORT, POST, ROOM, NOVEL, LIVE, KIDS, RECREATION};
    }

    static {
        UGCVideoType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private UGCVideoType(String str, int i11, String str2) {
        this.value = str2;
    }

    public static EnumEntries<UGCVideoType> getEntries() {
        return $ENTRIES;
    }

    public static UGCVideoType valueOf(String str) {
        return (UGCVideoType) Enum.valueOf(UGCVideoType.class, str);
    }

    public static UGCVideoType[] values() {
        return (UGCVideoType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
