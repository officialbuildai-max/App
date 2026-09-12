package com.bytedance.adsdk.ugeno.Sj.Sj;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class Sj {
    protected JSONObject Sj;
    private String TKC;
    protected com.bytedance.adsdk.ugeno.sP.TKC sP;

    /* renamed from: com.bytedance.adsdk.ugeno.Sj.Sj.Sj$Sj, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0209Sj {
        public static Sj Sj(com.bytedance.adsdk.ugeno.sP.TKC tkc, JSONObject jSONObject) {
            if (tkc == null || jSONObject == null) {
                return null;
            }
            String optString = jSONObject.optString(NativeComponentConstants.KEY_COMPONENT_TYPE);
            optString.hashCode();
            char c11 = 65535;
            switch (optString.hashCode()) {
                case -1881872635:
                    if (optString.equals("stretch")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -930826704:
                    if (optString.equals("ripple")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case -920177947:
                    if (optString.equals("rub_in")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 109407595:
                    if (optString.equals("shine")) {
                        c11 = 3;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    return new HiB(tkc, jSONObject);
                case 1:
                    return new sP(tkc, jSONObject);
                case 2:
                    return new TKC(tkc, jSONObject);
                case 3:
                    return new EjP(tkc, jSONObject);
                default:
                    return null;
            }
        }
    }

    public Sj(com.bytedance.adsdk.ugeno.sP.TKC tkc, JSONObject jSONObject) {
        this.Sj = jSONObject;
        this.sP = tkc;
        Sj();
    }

    public String EjP() {
        return this.TKC;
    }

    public void Sj() {
        this.TKC = this.Sj.optString(NativeComponentConstants.KEY_COMPONENT_TYPE);
        sP();
    }

    public abstract void Sj(int i11, int i12);

    public abstract void Sj(Canvas canvas);

    public abstract List<PropertyValuesHolder> TKC();

    public abstract void sP();

    public abstract void sP(Canvas canvas);
}
