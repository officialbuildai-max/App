package com.bytedance.sdk.component.HiB.EjP.TKC;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.HiB.EjP.TKC.TKC;
import com.bytedance.sdk.component.HiB.Fmk;
import com.bytedance.sdk.component.HiB.TEQ;
import com.bytedance.sdk.component.HiB.TzV;
import com.bytedance.sdk.component.HiB.Zq;
import com.bytedance.sdk.component.utils.uvD;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class sP implements Zq {
    private volatile vS Sj;

    private sP() {
    }

    public static Zq Sj(Context context, Fmk fmk) {
        sP sPVar = new sP();
        sPVar.sP(context, fmk);
        return sPVar;
    }

    private void sP(Context context, Fmk fmk) {
        if (this.Sj != null) {
            Log.w("ImageLoader", "already init!");
        }
        if (fmk == null) {
            fmk = HiB.Sj(context);
        }
        this.Sj = new vS(context, fmk);
    }

    @Override // com.bytedance.sdk.component.HiB.Zq
    public TEQ Sj(String str) {
        return new TKC.sP(this.Sj).TKC(str);
    }

    @Override // com.bytedance.sdk.component.HiB.Zq
    public InputStream Sj(String str, String str2) {
        byte[] Sj;
        if (this.Sj != null) {
            if (TextUtils.isEmpty(str2)) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                str2 = uvD.Sj(str);
            }
            TzV Sj2 = this.Sj.Sj();
            if (Sj2 != null && (Sj = Sj2.Sj(str2)) != null) {
                return new ByteArrayInputStream(Sj);
            }
            Collection<com.bytedance.sdk.component.HiB.TKC> sP = this.Sj.sP();
            if (sP != null) {
                Iterator<com.bytedance.sdk.component.HiB.TKC> it = sP.iterator();
                while (it.hasNext()) {
                    InputStream Sj3 = it.next().Sj(str2);
                    if (Sj3 != null) {
                        return Sj3;
                    }
                }
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.HiB.Zq
    public boolean Sj(String str, String str2, String str3) {
        if (this.Sj == null || TextUtils.isEmpty(str3)) {
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            str2 = uvD.Sj(str);
        }
        com.bytedance.sdk.component.HiB.TKC Sj = this.Sj.Sj(str3);
        if (Sj != null) {
            return Sj.sP(str2);
        }
        return false;
    }
}
