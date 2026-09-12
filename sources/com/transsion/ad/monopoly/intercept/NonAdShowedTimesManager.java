package com.transsion.ad.monopoly.intercept;

import android.text.TextUtils;
import com.transsion.ad.db.plan.MbAdDbPlans;
import java.util.concurrent.ConcurrentHashMap;
import ti.p;

/* loaded from: classes5.dex */
public final class NonAdShowedTimesManager {

    /* renamed from: a, reason: collision with root package name */
    public static final NonAdShowedTimesManager f42188a = new NonAdShowedTimesManager();

    /* renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap f42189b = new ConcurrentHashMap();

    private NonAdShowedTimesManager() {
    }

    public final int b(MbAdDbPlans mbAdDbPlans) {
        if (mbAdDbPlans == null) {
            return 0;
        }
        ConcurrentHashMap concurrentHashMap = f42189b;
        ShowedTimesMemoryBean showedTimesMemoryBean = (ShowedTimesMemoryBean) concurrentHashMap.get(mbAdDbPlans.getId());
        if (showedTimesMemoryBean != null) {
            if (TextUtils.equals(showedTimesMemoryBean.getDate(), p.f76389a.c())) {
                return showedTimesMemoryBean.getShowedTimes();
            }
            return 0;
        }
        String showDate = mbAdDbPlans.getShowDate();
        p pVar = p.f76389a;
        if (!TextUtils.equals(showDate, pVar.c())) {
            concurrentHashMap.put(mbAdDbPlans.getId(), new ShowedTimesMemoryBean(0, pVar.c()));
            return 0;
        }
        String id2 = mbAdDbPlans.getId();
        Integer showedTimes = mbAdDbPlans.getShowedTimes();
        concurrentHashMap.put(id2, new ShowedTimesMemoryBean(showedTimes != null ? showedTimes.intValue() : 0, pVar.c()));
        Integer showedTimes2 = mbAdDbPlans.getShowedTimes();
        if (showedTimes2 != null) {
            return showedTimes2.intValue();
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x004f, code lost:
    
        if (r2 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(com.transsion.ad.monopoly.model.AdPlans r11) {
        /*
            r10 = this;
            if (r11 != 0) goto L3
            return
        L3:
            com.transsion.ad.monopoly.plan.AdPlansTransform r0 = com.transsion.ad.monopoly.plan.AdPlansTransform.f42222a
            com.transsion.ad.db.plan.MbAdDbPlans r0 = r0.a(r11)
            java.util.concurrent.ConcurrentHashMap r1 = com.transsion.ad.monopoly.intercept.NonAdShowedTimesManager.f42189b
            java.lang.String r2 = r0.getId()
            java.lang.Object r2 = r1.get(r2)
            com.transsion.ad.monopoly.intercept.ShowedTimesMemoryBean r2 = (com.transsion.ad.monopoly.intercept.ShowedTimesMemoryBean) r2
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L51
            java.lang.String r5 = r2.getDate()
            ti.p r6 = ti.p.f76389a
            java.lang.String r7 = r6.c()
            boolean r5 = android.text.TextUtils.equals(r5, r7)
            if (r5 == 0) goto L3c
            int r5 = r2.getShowedTimes()
            int r5 = r5 + r4
            r2.setShowedTimes(r5)
            java.lang.String r5 = r0.getId()
            java.lang.Object r2 = r1.put(r5, r2)
            com.transsion.ad.monopoly.intercept.ShowedTimesMemoryBean r2 = (com.transsion.ad.monopoly.intercept.ShowedTimesMemoryBean) r2
            goto L4f
        L3c:
            java.lang.String r2 = r0.getId()
            com.transsion.ad.monopoly.intercept.ShowedTimesMemoryBean r5 = new com.transsion.ad.monopoly.intercept.ShowedTimesMemoryBean
            java.lang.String r6 = r6.c()
            r5.<init>(r4, r6)
            java.lang.Object r2 = r1.put(r2, r5)
            com.transsion.ad.monopoly.intercept.ShowedTimesMemoryBean r2 = (com.transsion.ad.monopoly.intercept.ShowedTimesMemoryBean) r2
        L4f:
            if (r2 != 0) goto La6
        L51:
            java.lang.String r2 = r0.getShowDate()
            ti.p r5 = ti.p.f76389a
            java.lang.String r6 = r5.c()
            boolean r2 = android.text.TextUtils.equals(r2, r6)
            if (r2 == 0) goto L93
            java.lang.Integer r2 = r0.getShowedTimes()
            if (r2 == 0) goto L71
            int r2 = r2.intValue()
            int r2 = r2 + r4
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L72
        L71:
            r2 = r3
        L72:
            r0.setShowedTimes(r2)
            java.lang.String r2 = r0.getId()
            com.transsion.ad.monopoly.intercept.ShowedTimesMemoryBean r6 = new com.transsion.ad.monopoly.intercept.ShowedTimesMemoryBean
            java.lang.Integer r7 = r0.getShowedTimes()
            if (r7 == 0) goto L85
            int r4 = r7.intValue()
        L85:
            java.lang.String r5 = r5.c()
            r6.<init>(r4, r5)
            java.lang.Object r1 = r1.put(r2, r6)
            com.transsion.ad.monopoly.intercept.ShowedTimesMemoryBean r1 = (com.transsion.ad.monopoly.intercept.ShowedTimesMemoryBean) r1
            goto La6
        L93:
            java.lang.String r2 = r0.getId()
            com.transsion.ad.monopoly.intercept.ShowedTimesMemoryBean r6 = new com.transsion.ad.monopoly.intercept.ShowedTimesMemoryBean
            java.lang.String r5 = r5.c()
            r6.<init>(r4, r5)
            java.lang.Object r1 = r1.put(r2, r6)
            com.transsion.ad.monopoly.intercept.ShowedTimesMemoryBean r1 = (com.transsion.ad.monopoly.intercept.ShowedTimesMemoryBean) r1
        La6:
            kotlinx.coroutines.i0 r1 = kotlinx.coroutines.y0.b()
            kotlinx.coroutines.n0 r4 = kotlinx.coroutines.o0.a(r1)
            com.transsion.ad.monopoly.intercept.NonAdShowedTimesManager$saveShowedTimes$3 r7 = new com.transsion.ad.monopoly.intercept.NonAdShowedTimesManager$saveShowedTimes$3
            r7.<init>(r0, r11, r3)
            r8 = 3
            r9 = 0
            r5 = 0
            r6 = 0
            kotlinx.coroutines.i.d(r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.intercept.NonAdShowedTimesManager.c(com.transsion.ad.monopoly.model.AdPlans):void");
    }
}
