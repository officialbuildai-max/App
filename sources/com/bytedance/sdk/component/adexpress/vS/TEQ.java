package com.bytedance.sdk.component.adexpress.vS;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class TEQ extends com.bytedance.adsdk.sP.vS {
    private Map<String, Bitmap> Sj;
    private String sP;

    /* loaded from: classes2.dex */
    private static class Sj implements com.bytedance.sdk.component.HiB.uvD<Bitmap> {
        private final Map<String, Bitmap> EjP;
        private final WeakReference<TEQ> Sj;
        private final String TKC;
        private final com.bytedance.adsdk.sP.TEQ sP;

        public Sj(TEQ teq, com.bytedance.adsdk.sP.TEQ teq2, String str, Map<String, Bitmap> map) {
            this.Sj = new WeakReference<>(teq);
            this.sP = teq2;
            this.TKC = str;
            this.EjP = map;
        }

        @Override // com.bytedance.sdk.component.HiB.uvD
        public void Sj(int i11, String str, Throwable th2) {
        }

        @Override // com.bytedance.sdk.component.HiB.uvD
        public void Sj(com.bytedance.sdk.component.HiB.Ym<Bitmap> ym2) {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(ym2.sP(), this.sP.Sj(), this.sP.sP(), false);
            this.EjP.put(this.TKC, createScaledBitmap);
            TEQ teq = this.Sj.get();
            if (teq != null) {
                teq.Sj(this.sP.Dq(), createScaledBitmap);
            }
        }
    }

    public TEQ(Context context) {
        super(context);
        this.Sj = new HashMap();
    }

    public void Dq() {
        if (TextUtils.isEmpty(this.sP)) {
            return;
        }
        setProgress(0.0f);
        Sj(true);
        setAnimationFromUrl(this.sP);
        setImageAssetDelegate(new com.bytedance.adsdk.sP.EjP() { // from class: com.bytedance.sdk.component.adexpress.vS.TEQ.1
            @Override // com.bytedance.adsdk.sP.EjP
            public Bitmap Sj(final com.bytedance.adsdk.sP.TEQ teq) {
                final String Dq = teq.Dq();
                String TEQ = teq.TEQ();
                String uA = teq.uA();
                if (TextUtils.equals(Dq, "image_0") && TextUtils.equals(uA, "Lark20201123-180048_2.png")) {
                    uA = "hand.png";
                }
                Bitmap bitmap = (Bitmap) TEQ.this.Sj.get(Dq);
                if (bitmap != null) {
                    return bitmap;
                }
                if (TextUtils.isEmpty(TEQ) || !TextUtils.isEmpty(uA)) {
                    if (!TextUtils.isEmpty(uA) && TextUtils.isEmpty(TEQ)) {
                        TEQ = uA;
                    } else if (TextUtils.isEmpty(uA) || TextUtils.isEmpty(TEQ)) {
                        TEQ = "";
                    } else {
                        TEQ = TEQ + uA;
                    }
                }
                if (TextUtils.isEmpty(TEQ)) {
                    return null;
                }
                com.bytedance.sdk.component.HiB.TEQ Sj2 = com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().HiB().Sj(TEQ).Sj(new com.bytedance.sdk.component.HiB.Dq() { // from class: com.bytedance.sdk.component.adexpress.vS.TEQ.1.1
                    @Override // com.bytedance.sdk.component.HiB.Dq
                    public Bitmap Sj(Bitmap bitmap2) {
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap2, teq.Sj(), teq.sP(), false);
                        TEQ.this.Sj.put(Dq, createScaledBitmap);
                        return createScaledBitmap;
                    }
                });
                TEQ teq2 = TEQ.this;
                Sj2.Sj(new Sj(teq2, teq, Dq, teq2.Sj));
                return (Bitmap) TEQ.this.Sj.get(Dq);
            }
        });
        Sj();
    }

    public void setAnimationsLoop(boolean z10) {
    }

    public void setData(Map<String, String> map) {
    }

    public void setImageLottieTosPath(String str) {
        this.sP = str;
    }

    public void setLottieAdDescMaxLength(int i11) {
    }

    public void setLottieAdTitleMaxLength(int i11) {
    }

    public void setLottieAppNameMaxLength(int i11) {
    }
}
