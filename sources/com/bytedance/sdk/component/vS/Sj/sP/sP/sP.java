package com.bytedance.sdk.component.vS.Sj.sP.sP;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.vS.Sj.Dq;
import com.bytedance.sdk.component.vS.Sj.Sj.Sj.Jcg;
import com.bytedance.sdk.component.vS.Sj.vS;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class sP {
    public static vS Sj;

    private static String EjP() {
        return Jcg.sP + "/ad_log_event/";
    }

    public static vS Sj(Context context) {
        try {
            if (Sj == null) {
                Sj = Dq.Jcg().uvD().Ym();
            }
        } catch (Exception unused) {
        }
        return Sj;
    }

    public static void Sj() {
        if (Dq.Jcg().vS() == null) {
            return;
        }
        try {
            vS Sj2 = Sj(Dq.Jcg().vS());
            if (Sj2 != null) {
                Sj2.Sj(Uri.parse(EjP() + "adLogStart"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void Sj(com.bytedance.sdk.component.vS.Sj.EjP.Sj sj2) {
        if (sj2 == null) {
            return;
        }
        try {
            vS Sj2 = Sj(Dq.Jcg().vS());
            if (Sj2 != null) {
                Sj2.Sj(Uri.parse(EjP() + "adLogDispatch?event=" + com.bytedance.sdk.component.vS.Sj.Sj.Sj.vS.Sj(sj2.vS())));
            }
        } catch (Throwable th2) {
            th2.toString();
        }
    }

    public static void Sj(String str, List<String> list, boolean z10, int i11, String str2) {
        if (list != null && !list.isEmpty()) {
            try {
                StringBuilder sb2 = new StringBuilder();
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    sb2.append(com.bytedance.sdk.component.vS.Sj.Sj.Sj.vS.Sj(it.next()));
                    sb2.append(",");
                }
                String str3 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(com.bytedance.sdk.component.vS.Sj.Sj.Sj.vS.Sj(sb2.toString())) + "&replace=" + String.valueOf(z10) + "&urlType=" + String.valueOf(i11) + "&adId=" + str2;
                vS Sj2 = Sj(Dq.Jcg().vS());
                if (Sj2 == null) {
                    return;
                }
                Sj2.Sj(Uri.parse(EjP() + "trackAdUrl" + str3));
            } catch (Throwable unused) {
            }
        }
    }

    public static void Sj(String str, boolean z10) {
        if (Dq.Jcg().uvD().vS() == 0 && TextUtils.isEmpty(str)) {
            return;
        }
        try {
            vS Sj2 = Sj(Dq.Jcg().vS());
            if (Sj2 != null) {
                Sj2.Sj(Uri.parse(EjP() + "trackAdFailed?did=" + String.valueOf(str) + "&triggerOnInit=" + z10));
            }
        } catch (Throwable unused) {
        }
    }

    public static void sP() {
        if (Dq.Jcg().vS() == null) {
            return;
        }
        try {
            vS Sj2 = Sj(Dq.Jcg().vS());
            if (Sj2 != null) {
                Sj2.Sj(Uri.parse(EjP() + "adLogStop"));
            }
        } catch (Throwable unused) {
        }
    }

    public int Sj(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public int Sj(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public Cursor Sj(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public Uri Sj(Uri uri, ContentValues contentValues) {
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x003a, code lost:
    
        if (r1.equals("adLogStop") == false) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String Sj(android.net.Uri r13) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.vS.Sj.sP.sP.sP.Sj(android.net.Uri):java.lang.String");
    }

    public String TKC() {
        return "ad_log_event";
    }
}
