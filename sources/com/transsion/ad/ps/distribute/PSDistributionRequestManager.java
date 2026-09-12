package com.transsion.ad.ps.distribute;

import android.text.TextUtils;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public final class PSDistributionRequestManager {

    /* renamed from: a, reason: collision with root package name */
    public static final PSDistributionRequestManager f42239a = new PSDistributionRequestManager();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f42240b = LazyKt.b(new Function0() { // from class: com.transsion.ad.ps.distribute.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            qi.a f11;
            f11 = PSDistributionRequestManager.f();
            return f11;
        }
    });

    private PSDistributionRequestManager() {
    }

    private final String b() {
        String simpleName = PSDistributionRequestManager.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final JSONObject c(int i11, int i12, String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("bu", "mb");
        jSONObject.put("pageIndex", i11);
        jSONObject.put("pageSize", i12);
        jSONObject.put("recommendCode", "mb_apps");
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put("pushModel", str);
        }
        for (Map.Entry entry : qi.a.INSTANCE.a(System.currentTimeMillis()).entrySet()) {
            jSONObject.put((String) entry.getKey(), entry.getValue());
        }
        return jSONObject;
    }

    private final qi.a e() {
        return (qi.a) f42240b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qi.a f() {
        return (qi.a) zg.c.f79537e.a().h(qi.a.class);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0116 A[Catch: all -> 0x003c, TryCatch #2 {all -> 0x003c, blocks: (B:12:0x0037, B:13:0x00d2, B:15:0x00da, B:17:0x00e0, B:18:0x00ea, B:20:0x0104, B:22:0x010a, B:23:0x0110, B:25:0x0116, B:27:0x0124, B:30:0x012f, B:39:0x0135, B:40:0x013c), top: B:11:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0135 A[Catch: all -> 0x003c, TryCatch #2 {all -> 0x003c, blocks: (B:12:0x0037, B:13:0x00d2, B:15:0x00da, B:17:0x00e0, B:18:0x00ea, B:20:0x0104, B:22:0x010a, B:23:0x0110, B:25:0x0116, B:27:0x0124, B:30:0x012f, B:39:0x0135, B:40:0x013c), top: B:11:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(int r21, int r22, java.lang.String r23, java.lang.String r24, di.a r25, kotlin.coroutines.Continuation r26) {
        /*
            Method dump skipped, instructions count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.ps.distribute.PSDistributionRequestManager.d(int, int, java.lang.String, java.lang.String, di.a, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
