package com.transsion.memberapi;

import androidx.annotation.Keep;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Keep
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0087\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/transsion/memberapi/SkuCategory;", "", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Companion", "a", "Coin", "ONCE_RECHARGE", "AUTO_RENEW", "MemberApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class SkuCategory {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SkuCategory[] $VALUES;
    private final String value;
    public static final SkuCategory Coin = new SkuCategory("Coin", 0, "SkuCategoryCoin");
    public static final SkuCategory ONCE_RECHARGE = new SkuCategory("ONCE_RECHARGE", 1, "SkuCategoryRecharge");
    public static final SkuCategory AUTO_RENEW = new SkuCategory("AUTO_RENEW", 2, "SkuCategoryAutoRenew");

    private static final /* synthetic */ SkuCategory[] $values() {
        return new SkuCategory[]{Coin, ONCE_RECHARGE, AUTO_RENEW};
    }

    static {
        SkuCategory[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
        INSTANCE = new Companion(null);
    }

    private SkuCategory(String str, int i11, String str2) {
        this.value = str2;
    }

    public static EnumEntries<SkuCategory> getEntries() {
        return $ENTRIES;
    }

    public static SkuCategory valueOf(String str) {
        return (SkuCategory) Enum.valueOf(SkuCategory.class, str);
    }

    public static SkuCategory[] values() {
        return (SkuCategory[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
