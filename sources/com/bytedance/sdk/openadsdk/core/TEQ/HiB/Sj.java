package com.bytedance.sdk.openadsdk.core.TEQ.HiB;

import com.bytedance.adsdk.ugeno.core.Zq;
import com.bytedance.sdk.component.adexpress.sP.Fmk;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Sj extends Fmk {
    private float EjP;
    private JSONObject Sj;
    private float TKC;
    private Zq sP;

    /* renamed from: com.bytedance.sdk.openadsdk.core.TEQ.HiB.Sj$Sj, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0266Sj extends Fmk.Sj {
        private float EjP;
        private JSONObject Sj;
        private float TKC;
        private Zq sP;

        public C0266Sj Sj(float f11) {
            this.TKC = f11;
            return this;
        }

        public C0266Sj Sj(Zq zq2) {
            this.sP = zq2;
            return this;
        }

        public C0266Sj Sj(JSONObject jSONObject) {
            this.Sj = jSONObject;
            return this;
        }

        public C0266Sj sP(float f11) {
            this.EjP = f11;
            return this;
        }

        @Override // com.bytedance.sdk.component.adexpress.sP.Fmk.Sj
        /* renamed from: sP, reason: merged with bridge method [inline-methods] */
        public Sj Sj() {
            return new Sj(this);
        }
    }

    public Sj(C0266Sj c0266Sj) {
        super(c0266Sj);
        this.Sj = c0266Sj.Sj;
        this.sP = c0266Sj.sP;
        this.TKC = c0266Sj.TKC;
        this.EjP = c0266Sj.EjP;
    }

    public JSONObject LD() {
        return this.Sj;
    }

    public float LqL() {
        return this.TKC;
    }

    public float Yf() {
        return this.EjP;
    }

    public Zq fF() {
        return this.sP;
    }
}
