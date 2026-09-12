package com.transsion.payment.lib.bean;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/transsion/payment/lib/bean/SkuCategory;", "", "<init>", "(Ljava/lang/String;I)V", "_SkuCategory", "SkuCategoryCoin", "SkuCategoryOnceRecharge", "SkuCategoryAutoRenew", "LibPayment_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class SkuCategory {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SkuCategory[] $VALUES;
    public static final SkuCategory _SkuCategory = new SkuCategory("_SkuCategory", 0);
    public static final SkuCategory SkuCategoryCoin = new SkuCategory("SkuCategoryCoin", 1);
    public static final SkuCategory SkuCategoryOnceRecharge = new SkuCategory("SkuCategoryOnceRecharge", 2);
    public static final SkuCategory SkuCategoryAutoRenew = new SkuCategory("SkuCategoryAutoRenew", 3);

    private static final /* synthetic */ SkuCategory[] $values() {
        return new SkuCategory[]{_SkuCategory, SkuCategoryCoin, SkuCategoryOnceRecharge, SkuCategoryAutoRenew};
    }

    static {
        SkuCategory[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private SkuCategory(String str, int i11) {
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
}
