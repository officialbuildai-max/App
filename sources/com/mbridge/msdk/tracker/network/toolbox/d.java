package com.mbridge.msdk.tracker.network.toolbox;

import android.text.TextUtils;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.mbridge.msdk.tracker.network.t;

/* loaded from: classes5.dex */
public class d {
    public static String a(String str, t<?> tVar) {
        if (TextUtils.isEmpty(str) || tVar == null) {
            return "";
        }
        byte[] b11 = tVar.b();
        if (b11 == null || b11.length == 0) {
            return str;
        }
        if (str.endsWith(UrlUtils.QUESTION_MARK)) {
            return str + new String(b11);
        }
        return str + UrlUtils.QUESTION_MARK + new String(b11);
    }
}
