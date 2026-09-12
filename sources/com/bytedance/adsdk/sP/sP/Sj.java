package com.bytedance.adsdk.sP.sP;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.adsdk.sP.TKC;
import com.bytedance.adsdk.sP.TKC.Jcg;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class Sj {
    private final AssetManager EjP;
    private TKC HiB;
    private final Jcg<String> Sj = new Jcg<>();
    private final Map<Jcg<String>, Typeface> sP = new HashMap();
    private final Map<String, Typeface> TKC = new HashMap();
    private String vS = ".ttf";

    public Sj(Drawable.Callback callback, TKC tkc) {
        this.HiB = tkc;
        if (callback instanceof View) {
            this.EjP = ((View) callback).getContext().getAssets();
        } else {
            this.EjP = null;
        }
    }

    private Typeface Sj(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i11 = (contains && contains2) ? 3 : contains ? 2 : contains2 ? 1 : 0;
        return typeface.getStyle() == i11 ? typeface : Typeface.create(typeface, i11);
    }

    private Typeface sP(com.bytedance.adsdk.sP.TKC.TKC tkc) {
        Typeface typeface;
        String Sj = tkc.Sj();
        Typeface typeface2 = this.TKC.get(Sj);
        if (typeface2 != null) {
            return typeface2;
        }
        String TKC = tkc.TKC();
        String sP = tkc.sP();
        TKC tkc2 = this.HiB;
        if (tkc2 != null) {
            typeface = tkc2.Sj(Sj, TKC, sP);
            if (typeface == null) {
                typeface = this.HiB.Sj(Sj);
            }
        } else {
            typeface = null;
        }
        TKC tkc3 = this.HiB;
        if (tkc3 != null && typeface == null) {
            String sP2 = tkc3.sP(Sj, TKC, sP);
            if (sP2 == null) {
                sP2 = this.HiB.sP(Sj);
            }
            if (sP2 != null) {
                try {
                    typeface = Typeface.createFromAsset(this.EjP, sP2);
                } catch (Throwable unused) {
                    typeface = Typeface.DEFAULT;
                }
            }
        }
        if (tkc.EjP() != null) {
            return tkc.EjP();
        }
        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(this.EjP, "fonts/" + Sj + this.vS);
            } catch (Throwable unused2) {
                typeface = Typeface.DEFAULT;
            }
        }
        this.TKC.put(Sj, typeface);
        return typeface;
    }

    public Typeface Sj(com.bytedance.adsdk.sP.TKC.TKC tkc) {
        this.Sj.Sj(tkc.Sj(), tkc.TKC());
        Typeface typeface = this.sP.get(this.Sj);
        if (typeface != null) {
            return typeface;
        }
        Typeface Sj = Sj(sP(tkc), tkc.TKC());
        this.sP.put(this.Sj, Sj);
        return Sj;
    }

    public void Sj(TKC tkc) {
        this.HiB = tkc;
    }

    public void Sj(String str) {
        this.vS = str;
    }
}
