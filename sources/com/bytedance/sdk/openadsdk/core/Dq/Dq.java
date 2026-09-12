package com.bytedance.sdk.openadsdk.core.Dq;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.model.TEQ;
import com.bytedance.sdk.openadsdk.core.sP.TKC;
import com.bytedance.sdk.openadsdk.utils.FPG;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class Dq extends com.bytedance.sdk.openadsdk.core.sP.Sj {
    public Dq(@NonNull Context context, @NonNull com.bytedance.sdk.openadsdk.core.model.sU sUVar, @NonNull String str, int i11) {
        super(context, sUVar, str, i11);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.sP.sP
    public com.bytedance.sdk.openadsdk.core.model.TEQ Sj(float f11, float f12, float f13, float f14, SparseArray<TKC.Sj> sparseArray, long j11, long j12, View view, View view2, String str, float f15, int i11, float f16, int i12, JSONObject jSONObject, JSONObject jSONObject2) {
        float f17;
        float f18;
        float f19;
        float f20;
        int i13;
        int i14;
        int i15;
        long j13;
        long j14;
        char c11;
        int i16;
        int i17;
        int[] Sj = FPG.Sj(view);
        int i18 = 0;
        if (Sj == null || Sj.length != 2) {
            f17 = f11;
            f18 = f12;
            f19 = f13;
            f20 = f14;
            i13 = 0;
            i14 = 0;
        } else {
            i13 = Sj[0];
            i14 = Sj[1];
            if (this.sU == 0) {
                f20 = (FPG.sP(this.EjP, f14) + i14) - 0.5f;
                f19 = (FPG.sP(this.EjP, f13) + i13) - 0.5f;
                f17 = (FPG.sP(this.EjP, f11) + i13) - 0.5f;
                f18 = (FPG.sP(this.EjP, f12) + i14) - 0.5f;
            } else {
                f17 = f11;
                f18 = f12;
                f19 = f13;
                f20 = f14;
            }
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        com.bytedance.sdk.openadsdk.core.model.sef sefVar = this.HiB;
        if (sefVar != null) {
            j13 = sefVar.HiB;
            j14 = sefVar.vS;
            if (this.sU == 0) {
                iArr[0] = FPG.sP(this.EjP, sefVar.Jcg) + i13;
                iArr[1] = FPG.sP(this.EjP, this.HiB.Dq) + i14;
                i16 = FPG.sP(this.EjP, this.HiB.uA);
                i17 = FPG.sP(this.EjP, this.HiB.TEQ);
                c11 = 0;
                i15 = 1;
            } else {
                c11 = 0;
                iArr[0] = sefVar.Jcg;
                i15 = 1;
                iArr[1] = sefVar.Dq;
                i16 = sefVar.uA;
                i17 = sefVar.TEQ;
            }
            iArr2[c11] = i16;
            iArr2[i15] = i17;
            if (i16 == 0 && i17 == 0 && view2 != null) {
                iArr = FPG.Sj(view2);
                iArr2 = FPG.TKC(view2);
            }
            i18 = 0;
        } else {
            i15 = 1;
            j13 = j11;
            j14 = j12;
        }
        this.sU = i18;
        return new TEQ.Sj().vS(f17).HiB(f18).EjP(f19).TKC(f20).sP(j13).Sj(j14).sP(Sj).Sj(iArr).TKC(FPG.TKC(view)).EjP(iArr2).EjP(this.ley).HiB(this.LqL).vS(this.Yf).sP(com.bytedance.sdk.openadsdk.core.uA.sP().Sj() ? i15 : 2).Sj(sparseArray).Sj(str).Sj(f15).TKC(i11).sP(f16).Sj(i12).Sj(jSONObject).sP(jSONObject2).Sj();
    }

    public void Sj(com.bytedance.sdk.openadsdk.core.model.sef sefVar) {
        this.HiB = sefVar;
    }
}
