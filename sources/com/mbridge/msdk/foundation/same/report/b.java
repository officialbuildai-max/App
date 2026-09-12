package com.mbridge.msdk.foundation.same.report;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.o0;
import org.json.JSONArray;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static String f35574a = "DomainReport";

    public static boolean a(com.mbridge.msdk.setting.g gVar, String str) {
        if (gVar == null) {
            return true;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            int K = gVar.K();
            JSONArray I = gVar.I();
            JSONArray H = gVar.H();
            if (H != null) {
                for (int i11 = 0; i11 < H.length(); i11++) {
                    if (str.contains(H.getString(i11))) {
                        return false;
                    }
                }
            }
            if (K != 2) {
                return true;
            }
            if (I != null) {
                for (int i12 = 0; i12 < I.length(); i12++) {
                    if (str.contains(I.getString(i12))) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e11) {
            o0.b(f35574a, e11.getMessage());
            return true;
        }
    }
}
