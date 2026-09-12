package com.transsion.ad.monopoly.manager;

import android.text.TextUtils;
import com.cloud.hisavana.sdk.common.util.a0;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.model.MbAdImage;
import com.transsion.ad.monopoly.model.MbAdVideo;
import com.transsion.ad.monopoly.plan.AdPlanSourceManager;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ti.h;

/* loaded from: classes5.dex */
public final class AdPlansRequestManager {

    /* renamed from: a, reason: collision with root package name */
    public static final AdPlansRequestManager f42204a = new AdPlansRequestManager();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f42205b = LazyKt.b(new Function0() { // from class: com.transsion.ad.monopoly.manager.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            pi.a s11;
            s11 = AdPlansRequestManager.s();
            return s11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private static AtomicBoolean f42206c = new AtomicBoolean(false);

    private AdPlansRequestManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b2, code lost:
    
        r4.element = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x006d -> B:10:0x0070). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(java.util.List r11, kotlin.coroutines.Continuation r12) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.manager.AdPlansRequestManager.h(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(com.transsion.ad.monopoly.model.MbAdPlansDto r13, java.lang.String r14, kotlin.coroutines.Continuation r15) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.manager.AdPlansRequestManager.i(com.transsion.ad.monopoly.model.MbAdPlansDto, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(java.lang.String r7, java.lang.String r8, kotlin.coroutines.Continuation r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.transsion.ad.monopoly.manager.AdPlansRequestManager$deleteExpireAdPlan$1
            if (r0 == 0) goto L13
            r0 = r9
            com.transsion.ad.monopoly.manager.AdPlansRequestManager$deleteExpireAdPlan$1 r0 = (com.transsion.ad.monopoly.manager.AdPlansRequestManager$deleteExpireAdPlan$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.ad.monopoly.manager.AdPlansRequestManager$deleteExpireAdPlan$1 r0 = new com.transsion.ad.monopoly.manager.AdPlansRequestManager$deleteExpireAdPlan$1
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r7 = r0.L$1
            r8 = r7
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.ResultKt.b(r9)
            goto L55
        L32:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3a:
            kotlin.ResultKt.b(r9)
            boolean r9 = android.text.TextUtils.isEmpty(r7)
            if (r9 == 0) goto L46
            kotlin.Unit r7 = kotlin.Unit.f67184a
            return r7
        L46:
            com.transsion.ad.monopoly.manager.AdPlansStorageManager r9 = com.transsion.ad.monopoly.manager.AdPlansStorageManager.f42207a
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r9 = r9.f(r7, r0)
            if (r9 != r1) goto L55
            return r1
        L55:
            oi.a r0 = oi.a.f71145a
            java.lang.String r9 = r6.p()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r9)
            java.lang.String r9 = " --> deleteExpireAdPlan() --> newVersion = "
            r1.append(r9)
            r1.append(r7)
            java.lang.String r7 = " -- lastVersion = "
            r1.append(r7)
            r1.append(r8)
            java.lang.String r7 = " --> 删除过期计划 -- success"
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            r4 = 6
            r5 = 0
            r2 = 0
            r3 = 0
            oi.a.c(r0, r1, r2, r3, r4, r5)
            kotlin.Unit r7 = kotlin.Unit.f67184a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.manager.AdPlansRequestManager.j(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void k(List list) {
        HashSet hashSet = new HashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AdPlans adPlans = (AdPlans) it.next();
            List<AdMaterialList> adMaterialList = adPlans.getAdMaterialList();
            if (adMaterialList != null) {
                for (AdMaterialList adMaterialList2 : adMaterialList) {
                    if (Intrinsics.c(AdMaterialList.NON_AD_TYPE_TEXT, adMaterialList2.getType())) {
                        MbAdImage image = adMaterialList2.getImage();
                        hashSet.add(image != null ? image.getPath() : null);
                    } else {
                        MbAdVideo video = adMaterialList2.getVideo();
                        hashSet.add(video != null ? video.getPath() : null);
                    }
                }
            }
            if (!TextUtils.isEmpty(adPlans.getAdvertiserAvatarPath())) {
                hashSet.add(adPlans.getAdvertiserAvatarPath());
            }
        }
        h.f76382a.c(new File(com.transsion.ad.a.f41834a.b() + File.separatorChar), hashSet);
        oi.a.c(oi.a.f71145a, p() + " --> deleteExpireMaterial() --> 删除过期资源 -- success", 0, false, 6, null);
    }

    private final boolean l(AdPlans adPlans) {
        List<AdMaterialList> adMaterialList;
        Integer size;
        String str = null;
        String m11 = m(adPlans != null ? adPlans.getAdvertiserAvatar() : null);
        if (adPlans != null) {
            adPlans.setAdvertiserAvatarPath(m11);
        }
        n(adPlans != null ? adPlans.getExtImage() : null);
        if (adPlans != null && (adMaterialList = adPlans.getAdMaterialList()) != null) {
            Iterator<T> it = adMaterialList.iterator();
            if (it.hasNext()) {
                AdMaterialList adMaterialList2 = (AdMaterialList) it.next();
                if (Intrinsics.c(adMaterialList2.getType(), AdMaterialList.NON_AD_TYPE_TEXT)) {
                    MbAdImage image = adMaterialList2.getImage();
                    if (image != null) {
                        str = image.getUrl();
                    }
                } else {
                    MbAdVideo video = adMaterialList2.getVideo();
                    if (video != null) {
                        str = video.getUrl();
                    }
                }
                String c11 = a0.c(str);
                String str2 = com.transsion.ad.a.f41834a.b() + File.separatorChar + c11 + ".mineType";
                File file = new File(str2);
                if (Intrinsics.c(adMaterialList2.getType(), AdMaterialList.NON_AD_TYPE_VIDEO)) {
                    MbAdVideo video2 = adMaterialList2.getVideo();
                    int intValue = (video2 == null || (size = video2.getSize()) == null) ? 1 : size.intValue();
                    if (file.isFile() && file.exists() && file.length() > 0) {
                        MbAdVideo video3 = adMaterialList2.getVideo();
                        if (video3 != null) {
                            video3.setPath(str2);
                        }
                        adMaterialList2.setDownloadMaterialSuccess(true);
                        return true;
                    }
                    boolean a11 = com.transsion.ad.strategy.h.f42288a.a(str, str2);
                    long length = file.length();
                    if (a11 && length >= intValue) {
                        MbAdVideo video4 = adMaterialList2.getVideo();
                        if (video4 != null) {
                            video4.setPath(str2);
                        }
                        adMaterialList2.setDownloadMaterialSuccess(true);
                        return true;
                    }
                    oi.a.c(oi.a.f71145a, f42204a.p() + " --> downloadAdPlan() --> 视频素材下载失败 -- adPlans.id = " + adPlans.getId() + " downloadFileSuccess = " + a11 + " -- localFileSize = " + length + " -- remoteFileSize = " + intValue + " destination = " + str2, 6, false, 4, null);
                    return false;
                }
                if (file.isFile() && file.exists() && file.length() > 0) {
                    MbAdImage image2 = adMaterialList2.getImage();
                    if (image2 != null) {
                        image2.setPath(str2);
                    }
                    adMaterialList2.setDownloadMaterialSuccess(true);
                    return true;
                }
                boolean a12 = com.transsion.ad.strategy.h.f42288a.a(str, str2);
                long length2 = file.length();
                if (a12 && length2 > 0) {
                    MbAdImage image3 = adMaterialList2.getImage();
                    if (image3 != null) {
                        image3.setPath(str2);
                    }
                    adMaterialList2.setDownloadMaterialSuccess(true);
                    return true;
                }
                oi.a.c(oi.a.f71145a, f42204a.p() + " --> downloadAdPlan() --> 图片素材下载失败 -- adPlans.id = " + adPlans.getId() + " downloadFileSuccess = " + a12 + " -- localFileSize = " + length2 + " -- destination = " + str2, 6, false, 4, null);
            }
        }
        return false;
    }

    private final String m(String str) {
        String c11 = a0.c(str);
        String str2 = com.transsion.ad.a.f41834a.b() + File.separatorChar + c11 + ".mineType";
        return (h.f76382a.h(str2) || com.transsion.ad.strategy.h.f42288a.a(str, str2)) ? str2 : "";
    }

    private final void n(MbAdImage mbAdImage) {
        if (mbAdImage == null || TextUtils.isEmpty(mbAdImage.getUrl())) {
            return;
        }
        String url = mbAdImage.getUrl();
        String c11 = a0.c(url);
        String str = com.transsion.ad.a.f41834a.b() + File.separatorChar + c11 + ".mineType";
        if (h.f76382a.h(str)) {
            mbAdImage.setPath(str);
        } else if (com.transsion.ad.strategy.h.f42288a.a(url, str)) {
            mbAdImage.setPath(str);
        }
    }

    private final Object o(AdPlans adPlans, Continuation continuation) {
        Object w11;
        AdPlanSourceManager adPlanSourceManager = AdPlanSourceManager.f42220a;
        if (!adPlanSourceManager.j(adPlans) && !adPlanSourceManager.e(adPlans) && !adPlanSourceManager.g(adPlans) && !adPlanSourceManager.l(adPlans)) {
            return (l(adPlans) && (w11 = w(adPlans, continuation)) == IntrinsicsKt.f()) ? w11 : Unit.f67184a;
        }
        oi.a.c(oi.a.f71145a, p() + " --> downloadMaterialAndSaveAdPlans() --> PS虚拟计划和、Hi虚拟计划 --> 不需要下载素材的 --> " + adPlans.getAdSource() + " --> adPlan.name = " + adPlans.getName() + " --> adPlan.id = " + adPlans.getId(), 0, false, 6, null);
        AdMaterialList adMaterialList = new AdMaterialList(null, null, null, null, null, null, null, null, null, false, null, null, null, 8191, null);
        adMaterialList.setDownloadMaterialSuccess(true);
        adPlans.setAdMaterialList(CollectionsKt.e(adMaterialList));
        Object w12 = w(adPlans, continuation);
        return w12 == IntrinsicsKt.f() ? w12 : Unit.f67184a;
    }

    private final String p() {
        String simpleName = AdPlansRequestManager.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final pi.a q() {
        return (pi.a) f42205b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x01c1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x01af A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r(com.transsion.ad.monopoly.model.MbAdPlansDto r22, java.lang.String r23, kotlin.coroutines.Continuation r24) {
        /*
            Method dump skipped, instructions count: 455
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.manager.AdPlansRequestManager.r(com.transsion.ad.monopoly.model.MbAdPlansDto, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final pi.a s() {
        return (pi.a) zg.c.f79537e.a().h(pi.a.class);
    }

    public static /* synthetic */ Object u(AdPlansRequestManager adPlansRequestManager, String str, Function1 function1, Continuation continuation, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function1 = null;
        }
        return adPlansRequestManager.t(str, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x0250 -> B:13:0x0253). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v(com.transsion.ad.monopoly.model.MbAdPlansDto r26, kotlin.coroutines.Continuation r27) {
        /*
            Method dump skipped, instructions count: 604
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.manager.AdPlansRequestManager.v(com.transsion.ad.monopoly.model.MbAdPlansDto, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object w(com.transsion.ad.monopoly.model.AdPlans r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.transsion.ad.monopoly.manager.AdPlansRequestManager$updateAdPlanToDatabase$1
            if (r0 == 0) goto L13
            r0 = r6
            com.transsion.ad.monopoly.manager.AdPlansRequestManager$updateAdPlanToDatabase$1 r0 = (com.transsion.ad.monopoly.manager.AdPlansRequestManager$updateAdPlanToDatabase$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.ad.monopoly.manager.AdPlansRequestManager$updateAdPlanToDatabase$1 r0 = new com.transsion.ad.monopoly.manager.AdPlansRequestManager$updateAdPlanToDatabase$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r6)
            goto L45
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.b(r6)
            com.transsion.ad.monopoly.plan.AdPlansTransform r6 = com.transsion.ad.monopoly.plan.AdPlansTransform.f42222a
            com.transsion.ad.db.plan.MbAdDbPlans r5 = r6.a(r5)
            com.transsion.ad.monopoly.manager.AdPlansStorageManager r6 = com.transsion.ad.monopoly.manager.AdPlansStorageManager.f42207a
            r0.label = r3
            java.lang.Object r5 = r6.p(r5, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.manager.AdPlansRequestManager.w(com.transsion.ad.monopoly.model.AdPlans, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(6:5|6|7|(1:(1:(1:(7:12|13|14|15|(3:17|(1:19)|20)|21|22)(2:25|26))(11:27|28|29|(1:31)|32|(1:34)|14|15|(0)|21|22))(4:35|36|37|38))(2:47|(2:49|50)(12:51|52|53|(1:55)(1:79)|56|(1:58)(2:74|(1:78))|59|(4:64|(1:66)(1:72)|67|(1:69)(1:70))|73|(0)(0)|67|(0)(0)))|39|(1:41)(10:42|29|(0)|32|(0)|14|15|(0)|21|22)))|83|6|7|(0)(0)|39|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x003e, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0178 A[Catch: all -> 0x003e, TryCatch #2 {all -> 0x003e, blocks: (B:13:0x0039, B:14:0x0190, B:28:0x004d, B:29:0x0170, B:31:0x0178, B:32:0x0182), top: B:7:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x018f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x016e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0159 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002f  */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t(java.lang.String r23, kotlin.jvm.functions.Function1 r24, kotlin.coroutines.Continuation r25) {
        /*
            Method dump skipped, instructions count: 486
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.manager.AdPlansRequestManager.t(java.lang.String, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
