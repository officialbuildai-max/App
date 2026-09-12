package com.transsion.subroom.guide;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/transsion/subroom/guide/GuideStepEnum;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "GUIDE_STEP_1", "GUIDE_STEP_2", "app_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes.dex */
public final class GuideStepEnum {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GuideStepEnum[] $VALUES;
    public static final GuideStepEnum GUIDE_STEP_1 = new GuideStepEnum("GUIDE_STEP_1", 0, "guide_step_1");
    public static final GuideStepEnum GUIDE_STEP_2 = new GuideStepEnum("GUIDE_STEP_2", 1, "guide_step_2");
    private final String value;

    private static final /* synthetic */ GuideStepEnum[] $values() {
        return new GuideStepEnum[]{GUIDE_STEP_1, GUIDE_STEP_2};
    }

    static {
        GuideStepEnum[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private GuideStepEnum(String str, int i11, String str2) {
        this.value = str2;
    }

    public static EnumEntries<GuideStepEnum> getEntries() {
        return $ENTRIES;
    }

    public static GuideStepEnum valueOf(String str) {
        return (GuideStepEnum) Enum.valueOf(GuideStepEnum.class, str);
    }

    public static GuideStepEnum[] values() {
        return (GuideStepEnum[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
