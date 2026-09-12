package com.transsion.member.promotion;

import com.transsion.memberapi.MemberPriceItem;
import com.transsion.memberapi.SkuPromotionContent;
import com.transsion.memberapi.SkuPromotionItem;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes5.dex */
public final class PromotionSelectionHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final PromotionSelectionHelper f46725a = new PromotionSelectionHelper();

    private PromotionSelectionHelper() {
    }

    public final Pair a(List matchedPairs) {
        Object obj;
        Intrinsics.h(matchedPairs, "matchedPairs");
        Iterator it = CollectionsKt.I0(matchedPairs, new Comparator() { // from class: com.transsion.member.promotion.PromotionSelectionHelper$findBestNonExpiredPair$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t11, T t12) {
                Double discountPrice = ((MemberPriceItem) ((Pair) t11).getFirst()).getDiscountPrice();
                Double valueOf = Double.valueOf(discountPrice != null ? discountPrice.doubleValue() : Double.MAX_VALUE);
                Double discountPrice2 = ((MemberPriceItem) ((Pair) t12).getFirst()).getDiscountPrice();
                return ComparisonsKt.d(valueOf, Double.valueOf(discountPrice2 != null ? discountPrice2.doubleValue() : Double.MAX_VALUE));
            }
        }).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!f46725a.b((SkuPromotionItem) ((Pair) obj).getSecond())) {
                break;
            }
        }
        return (Pair) obj;
    }

    public final boolean b(SkuPromotionItem promotionItem) {
        Integer countdownHours;
        Intrinsics.h(promotionItem, "promotionItem");
        long a11 = m.f46755a.a();
        if (a11 <= 0) {
            return false;
        }
        SkuPromotionContent promotionContent = promotionItem.getPromotionContent();
        return RangesKt.g((a11 + (((long) ((promotionContent == null || (countdownHours = promotionContent.getCountdownHours()) == null) ? 12 : RangesKt.f(countdownHours.intValue(), 0))) * 3600000)) - System.currentTimeMillis(), 0L) == 0;
    }
}
