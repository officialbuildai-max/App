package com.transsion.ad.ps.distribute;

import com.cloud.hisavana.sdk.common.util.a0;
import com.cloud.tmc.kernel.framework.FrameworkConstants;
import com.transsion.ad.monopoly.model.MbAdImage;
import com.transsion.ad.ps.PSReportUtil;
import hi.f;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.y0;
import org.json.JSONObject;
import ti.h;

/* loaded from: classes5.dex */
public final class PsDistributeRequestManager {

    /* renamed from: a, reason: collision with root package name */
    public static final PsDistributeRequestManager f42245a = new PsDistributeRequestManager();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f42246b = LazyKt.b(new Function0() { // from class: com.transsion.ad.ps.distribute.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            qi.a p11;
            p11 = PsDistributeRequestManager.p();
            return p11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap f42247c = new ConcurrentHashMap();

    private PsDistributeRequestManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARN: Type inference failed for: r10v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0161 -> B:25:0x01a6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0175 -> B:22:0x0178). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(java.lang.String r23, java.lang.String r24, com.transsion.ad.ps.model.PsLinkDto r25, kotlin.coroutines.Continuation r26) {
        /*
            Method dump skipped, instructions count: 503
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.ps.distribute.PsDistributeRequestManager.h(java.lang.String, java.lang.String, com.transsion.ad.ps.model.PsLinkDto, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String i(String str) {
        String c11 = a0.c(str);
        String str2 = com.transsion.ad.a.f41834a.a() + File.separatorChar + c11 + ".mineType";
        return (h.f76382a.h(str2) || com.transsion.ad.strategy.h.f42288a.a(str, str2)) ? str2 : "";
    }

    private final boolean j(MbAdImage mbAdImage) {
        String url = mbAdImage.getUrl();
        String c11 = a0.c(url);
        String str = com.transsion.ad.a.f41834a.a() + File.separatorChar + c11 + ".mineType";
        File file = new File(str);
        if (file.isFile() && file.exists() && file.length() > 0) {
            mbAdImage.setPath(str);
            return true;
        }
        boolean a11 = com.transsion.ad.strategy.h.f42288a.a(url, str);
        long length = file.length();
        if (a11 && length > 0) {
            mbAdImage.setPath(str);
            return true;
        }
        oi.a.k(oi.a.f71145a, k() + " --> downloadAdPlan() --> 图片素材下载失败 --  downloadFileSuccess = " + a11 + " -- localFileSize = " + length + " -- destination = " + str, 6, false, 4, null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String k() {
        String simpleName = PsDistributeRequestManager.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject l(int i11, int i12, Integer num) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("bu", "mb");
        jSONObject.put("pageIndex", i11);
        jSONObject.put("pageSize", i12);
        jSONObject.put("media", 1);
        jSONObject.put(FrameworkConstants.GLOBAL_DATA_KEY_SCENE, num);
        for (Map.Entry entry : qi.a.INSTANCE.a(System.currentTimeMillis()).entrySet()) {
            jSONObject.put((String) entry.getKey(), entry.getValue());
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(java.lang.String r42, java.lang.String r43, com.transsion.ad.ps.model.RecommendInfo r44, kotlin.coroutines.Continuation r45) {
        /*
            Method dump skipped, instructions count: 545
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.ps.distribute.PsDistributeRequestManager.m(java.lang.String, java.lang.String, com.transsion.ad.ps.model.RecommendInfo, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final qi.a o() {
        return (qi.a) f42246b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qi.a p() {
        return (qi.a) zg.c.f79537e.a().h(qi.a.class);
    }

    public final Object n(int i11, int i12, Integer num, String str, Continuation continuation) {
        if (f42247c.putIfAbsent(num, Boxing.a(true)) == null) {
            PSReportUtil.f42224a.d(PSReportUtil.PSRequestState.REQUEST_TRIGGER, null, null, String.valueOf(num), PSReportUtil.PsDistributeSceneEnum.PS_DISTRIBUTE_SCENE_AD_PLAN.getValue());
            Object g11 = i.g(y0.b(), new PsDistributeRequestManager$getPsLinkListBySlot$2(i11, i12, num, str, null), continuation);
            return g11 == IntrinsicsKt.f() ? g11 : Unit.f67184a;
        }
        if (f.f64595a.b()) {
            oi.a.k(oi.a.f71145a, k() + " --> getPsLinkListBySlot() --> psScene=" + num + " --> 正在请求中，已拦截", 5, false, 4, null);
        }
        return Unit.f67184a;
    }
}
