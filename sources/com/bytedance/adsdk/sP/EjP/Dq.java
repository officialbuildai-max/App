package com.bytedance.adsdk.sP.EjP;

import android.content.Context;
import android.util.Pair;
import com.bytedance.adsdk.sP.aa;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

/* loaded from: classes2.dex */
public class Dq {
    private final Jcg Sj;
    private final vS sP;

    public Dq(Jcg jcg, vS vSVar) {
        this.Sj = jcg;
        this.sP = vSVar;
    }

    private aa<com.bytedance.adsdk.sP.Jcg> Sj(Context context, String str, InputStream inputStream, String str2) throws IOException {
        Jcg jcg;
        return (str2 == null || (jcg = this.Sj) == null) ? com.bytedance.adsdk.sP.Dq.Sj(context, new ZipInputStream(inputStream), (String) null) : com.bytedance.adsdk.sP.Dq.Sj(context, new ZipInputStream(new FileInputStream(jcg.Sj(str, inputStream, TKC.ZIP))), str);
    }

    private aa<com.bytedance.adsdk.sP.Jcg> Sj(Context context, String str, InputStream inputStream, String str2, String str3) throws IOException {
        aa<com.bytedance.adsdk.sP.Jcg> Sj;
        TKC tkc;
        Jcg jcg;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (str2.contains("application/zip") || str2.contains("application/x-zip") || str2.contains("application/x-zip-compressed") || str.split("\\?")[0].endsWith(".lottie")) {
            TKC tkc2 = TKC.ZIP;
            Sj = Sj(context, str, inputStream, str3);
            tkc = tkc2;
        } else {
            tkc = TKC.JSON;
            Sj = Sj(str, inputStream, str3);
        }
        if (str3 != null && Sj.Sj() != null && (jcg = this.Sj) != null) {
            jcg.Sj(str, tkc);
        }
        return Sj;
    }

    private aa<com.bytedance.adsdk.sP.Jcg> Sj(String str, InputStream inputStream, String str2) throws IOException {
        Jcg jcg;
        return (str2 == null || (jcg = this.Sj) == null) ? com.bytedance.adsdk.sP.Dq.sP(inputStream, (String) null) : com.bytedance.adsdk.sP.Dq.sP(new FileInputStream(jcg.Sj(str, inputStream, TKC.JSON).getAbsolutePath()), str);
    }

    private aa<com.bytedance.adsdk.sP.Jcg> TKC(Context context, String str, String str2) {
        Closeable closeable = null;
        try {
            try {
                EjP Sj = this.sP.Sj(str);
                if (!Sj.Sj()) {
                    aa<com.bytedance.adsdk.sP.Jcg> aaVar = new aa<>(new IllegalArgumentException(Sj.EjP()));
                    try {
                        Sj.close();
                    } catch (IOException unused) {
                    }
                    return aaVar;
                }
                aa<com.bytedance.adsdk.sP.Jcg> Sj2 = Sj(context, str, Sj.sP(), Sj.TKC(), str2);
                Sj2.Sj();
                try {
                    Sj.close();
                } catch (IOException unused2) {
                }
                return Sj2;
            } catch (Throwable th2) {
                if (0 != 0) {
                    try {
                        closeable.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th2;
            }
        } catch (Exception e11) {
            aa<com.bytedance.adsdk.sP.Jcg> aaVar2 = new aa<>(e11);
            if (0 != 0) {
                try {
                    closeable.close();
                } catch (IOException unused4) {
                }
            }
            return aaVar2;
        }
    }

    private com.bytedance.adsdk.sP.Jcg sP(Context context, String str, String str2) {
        Jcg jcg;
        Pair<TKC, InputStream> Sj;
        if (str2 == null || (jcg = this.Sj) == null || (Sj = jcg.Sj(str)) == null) {
            return null;
        }
        TKC tkc = (TKC) Sj.first;
        InputStream inputStream = (InputStream) Sj.second;
        aa<com.bytedance.adsdk.sP.Jcg> Sj2 = tkc == TKC.ZIP ? com.bytedance.adsdk.sP.Dq.Sj(context, new ZipInputStream(inputStream), str2) : com.bytedance.adsdk.sP.Dq.sP(inputStream, str2);
        if (Sj2.Sj() != null) {
            return Sj2.Sj();
        }
        return null;
    }

    public aa<com.bytedance.adsdk.sP.Jcg> Sj(Context context, String str, String str2) {
        com.bytedance.adsdk.sP.Jcg sP = sP(context, str, str2);
        return sP != null ? new aa<>(sP) : TKC(context, str, str2);
    }
}
