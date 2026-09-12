package com.bytedance.adsdk.ugeno.EjP.EjP;

import android.content.Context;
import com.bytedance.adsdk.ugeno.EjP.vS;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class vS extends Sj {
    private int Fmk;
    private int Ym;

    /* renamed from: aa, reason: collision with root package name */
    private int f20891aa;

    public vS(Context context) {
        super(context);
        this.Ym = -1;
        this.f20891aa = -1;
        this.Fmk = -1;
    }

    @Override // com.bytedance.adsdk.ugeno.EjP.EjP.Sj
    public boolean Sj(Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            int Sj = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(String.valueOf(objArr[0]), -1);
            int Sj2 = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(String.valueOf(objArr[1]), -1);
            int Sj3 = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(String.valueOf(objArr[2]), -1);
            Map<String, String> map = this.HiB;
            if (map == null || map.isEmpty()) {
                HashMap hashMap = new HashMap();
                hashMap.put("fromIndex", Integer.valueOf(Sj));
                hashMap.put("toIndex", Integer.valueOf(Sj2));
                hashMap.put(NativeComponentConstants.KEY_COMPONENT_TYPE, Integer.valueOf(Sj3));
                Iterator<vS.Sj> it = this.TKC.sP().iterator();
                while (it.hasNext()) {
                    it.next().sP(hashMap);
                }
                this.Sj.Sj(this.sP, this.vS, this.TKC.sP());
            } else {
                this.Ym = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(this.HiB.get("fromIndex"), -1);
                this.f20891aa = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(this.HiB.get("toIndex"), -1);
                int Sj4 = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(this.HiB.get(NativeComponentConstants.KEY_COMPONENT_TYPE), -1);
                this.Fmk = Sj4;
                if (Sj == this.Ym && Sj2 == this.f20891aa && Sj3 == Sj4) {
                    this.Sj.Sj(this.sP, this.vS, this.TKC.sP());
                }
            }
        }
        return false;
    }
}
