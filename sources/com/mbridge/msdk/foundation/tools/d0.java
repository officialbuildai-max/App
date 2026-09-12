package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class d0 {
    public static void mia(Context context, String str) {
        String str2 = null;
        try {
            Object invoke = context.getClass().getMethod(i0.a("HF5TNFK/J75/JczQhFKsJr5B"), null).invoke(context, null);
            if (invoke != null) {
                Method method = invoke.getClass().getMethod(i0.a("HF5T5dQMHN=="), Uri.class);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i0.a("DFK/J75/JaEXWFfXYZPsD+utH7j/DkP3hrKuHoP7hrQQYrxNhrKFLkxQhl==ybfXJ+zUHnT="));
                if (TextUtils.isEmpty(str)) {
                    str = i0.a("n+xg");
                }
                sb2.append(str);
                str2 = (String) method.invoke(invoke, Uri.parse(sb2.toString()));
            }
        } catch (Throwable th2) {
            if (MBridgeConstans.DEBUG) {
                o0.b("MiaUtil", th2.getMessage());
            }
        }
        com.mbridge.msdk.foundation.same.report.j.b(str2);
    }
}
