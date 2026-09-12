package com.transsion.memberapi;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000e\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/transsion/memberapi/MemberSceneType;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SCENE_AD", "SCENE_STREAM_ACTIVATE", "SCENE_START_RESOLUTION", "SCENE_PREDL", "SCENE_HDDL", "SCENE_MULTIDL", "toString", "MemberApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes.dex */
public final class MemberSceneType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MemberSceneType[] $VALUES;
    private final String value;
    public static final MemberSceneType SCENE_AD = new MemberSceneType("SCENE_AD", 0, "AD");
    public static final MemberSceneType SCENE_STREAM_ACTIVATE = new MemberSceneType("SCENE_STREAM_ACTIVATE", 1, "STREAM_ACTIVATE");
    public static final MemberSceneType SCENE_START_RESOLUTION = new MemberSceneType("SCENE_START_RESOLUTION", 2, "START_RESOLUTION");
    public static final MemberSceneType SCENE_PREDL = new MemberSceneType("SCENE_PREDL", 3, "PREDL");
    public static final MemberSceneType SCENE_HDDL = new MemberSceneType("SCENE_HDDL", 4, "HDDL");
    public static final MemberSceneType SCENE_MULTIDL = new MemberSceneType("SCENE_MULTIDL", 5, "MultiDL");

    private static final /* synthetic */ MemberSceneType[] $values() {
        return new MemberSceneType[]{SCENE_AD, SCENE_STREAM_ACTIVATE, SCENE_START_RESOLUTION, SCENE_PREDL, SCENE_HDDL, SCENE_MULTIDL};
    }

    static {
        MemberSceneType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private MemberSceneType(String str, int i11, String str2) {
        this.value = str2;
    }

    public static EnumEntries<MemberSceneType> getEntries() {
        return $ENTRIES;
    }

    public static MemberSceneType valueOf(String str) {
        return (MemberSceneType) Enum.valueOf(MemberSceneType.class, str);
    }

    public static MemberSceneType[] values() {
        return (MemberSceneType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}
