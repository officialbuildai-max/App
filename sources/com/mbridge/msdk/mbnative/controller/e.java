package com.mbridge.msdk.mbnative.controller;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.n;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.same.report.o;
import com.mbridge.msdk.foundation.tools.o0;
import java.util.List;

/* loaded from: classes5.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f36452a = "com.mbridge.msdk.mbnative.controller.e";

    public static void a(Context context, String str) {
        if (context != null) {
            try {
                n a11 = n.a(g.a(context));
                if (TextUtils.isEmpty(str) || a11 == null || a11.a() <= 0) {
                    return;
                }
                List<m> a12 = a11.a("m_download_end");
                List<m> a13 = a11.a("2000021");
                List<m> a14 = a11.a("m_download_end");
                o.e(a13);
                o.a(a12);
                o.b(a14);
            } catch (Exception e11) {
                o0.b(f36452a, e11.getMessage());
            }
        }
    }
}
