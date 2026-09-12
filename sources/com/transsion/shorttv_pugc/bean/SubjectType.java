package com.transsion.shorttv_pugc.bean;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.transsion.home.p004enum.BottomTabType;
import com.transsion.search.bean.HotRankItem;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/transsion/shorttv_pugc/bean/SubjectType;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "MOVIE", HotRankItem.CATE_TV, "VSHOW", "AUDIO", "EDUCATION", BottomTabType.TAB_CODE_MUSIC, "SHORT_TV", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class SubjectType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SubjectType[] $VALUES;
    private final int value;
    public static final SubjectType MOVIE = new SubjectType("MOVIE", 0, 1);
    public static final SubjectType TV = new SubjectType(HotRankItem.CATE_TV, 1, 2);
    public static final SubjectType VSHOW = new SubjectType("VSHOW", 2, 3);
    public static final SubjectType AUDIO = new SubjectType("AUDIO", 3, 4);
    public static final SubjectType EDUCATION = new SubjectType("EDUCATION", 4, 5);
    public static final SubjectType MUSIC = new SubjectType(BottomTabType.TAB_CODE_MUSIC, 5, 6);
    public static final SubjectType SHORT_TV = new SubjectType("SHORT_TV", 6, 7);

    private static final /* synthetic */ SubjectType[] $values() {
        return new SubjectType[]{MOVIE, TV, VSHOW, AUDIO, EDUCATION, MUSIC, SHORT_TV};
    }

    static {
        SubjectType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private SubjectType(String str, int i11, int i12) {
        this.value = i12;
    }

    public static EnumEntries<SubjectType> getEntries() {
        return $ENTRIES;
    }

    public static SubjectType valueOf(String str) {
        return (SubjectType) Enum.valueOf(SubjectType.class, str);
    }

    public static SubjectType[] values() {
        return (SubjectType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}
