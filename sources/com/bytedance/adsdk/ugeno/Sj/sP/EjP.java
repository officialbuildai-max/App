package com.bytedance.adsdk.ugeno.Sj.sP;

import android.animation.FloatEvaluator;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.Jcg.Dq;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes2.dex */
public class EjP extends Sj {
    private List<Keyframe> Dq;

    /* renamed from: com.bytedance.adsdk.ugeno.Sj.sP.EjP$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Sj;

        static {
            int[] iArr = new int[com.bytedance.adsdk.ugeno.Sj.EjP.values().length];
            Sj = iArr;
            try {
                iArr[com.bytedance.adsdk.ugeno.Sj.EjP.TRANSLATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Sj[com.bytedance.adsdk.ugeno.Sj.EjP.SCALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public EjP(Context context, com.bytedance.adsdk.ugeno.sP.TKC tkc, String str, Map<Float, String> map) {
        super(context, tkc, str, map);
        this.Dq = new ArrayList();
    }

    @Override // com.bytedance.adsdk.ugeno.Sj.sP.Sj
    public List<PropertyValuesHolder> HiB() {
        String sP = this.EjP.sP();
        EjP();
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(sP + "X", (Keyframe[]) this.HiB.toArray(new Keyframe[0]));
        this.vS.add(ofKeyframe);
        PropertyValuesHolder ofKeyframe2 = PropertyValuesHolder.ofKeyframe(sP + "Y", (Keyframe[]) this.Dq.toArray(new Keyframe[0]));
        this.vS.add(ofKeyframe2);
        TypeEvaluator vS = vS();
        if (vS != null) {
            ofKeyframe.setEvaluator(vS);
            ofKeyframe2.setEvaluator(vS);
        }
        return this.vS;
    }

    @Override // com.bytedance.adsdk.ugeno.Sj.sP.Sj
    public void Sj(float f11, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() != 2) {
                return;
            }
            float optDouble = (float) jSONArray.optDouble(0);
            float optDouble2 = (float) jSONArray.optDouble(1);
            if (this.EjP == com.bytedance.adsdk.ugeno.Sj.EjP.TRANSLATE) {
                optDouble = Dq.Sj(this.Sj, optDouble);
                optDouble2 = Dq.Sj(this.Sj, optDouble2);
            }
            this.HiB.add(Keyframe.ofFloat(f11, optDouble));
            this.Dq.add(Keyframe.ofFloat(f11, optDouble2));
        } catch (JSONException unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.Sj.sP.Sj
    public void sP() {
        Keyframe ofFloat;
        Keyframe ofFloat2;
        int i11 = AnonymousClass1.Sj[this.EjP.ordinal()];
        if (i11 == 1) {
            ofFloat = Keyframe.ofFloat(0.0f, this.Jcg.sef());
            ofFloat2 = Keyframe.ofFloat(0.0f, this.Jcg.Zq());
        } else if (i11 != 2) {
            ofFloat = null;
            ofFloat2 = null;
        } else {
            ofFloat = Keyframe.ofFloat(0.0f, this.Jcg.uvD());
            ofFloat2 = Keyframe.ofFloat(0.0f, this.Jcg.dNu());
        }
        if (ofFloat != null) {
            this.HiB.add(ofFloat);
        }
        if (ofFloat2 != null) {
            this.Dq.add(ofFloat2);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.Sj.sP.Sj
    public TypeEvaluator vS() {
        return new FloatEvaluator();
    }
}
