package com.bytedance.sdk.openadsdk.core.TEQ.sP.Sj;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.core.app.NotificationCompat;
import com.bytedance.adsdk.sP.EjP;
import com.bytedance.adsdk.sP.TEQ;
import com.bytedance.adsdk.ugeno.HiB;
import com.bytedance.adsdk.ugeno.Jcg.Dq;
import com.bytedance.adsdk.ugeno.Sj;
import com.bytedance.adsdk.ugeno.sP.TKC;
import com.google.android.gms.common.internal.ImagesContract;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class Sj extends TKC<sP> {
    protected HashMap<String, Bitmap> AVc;
    private float Ph;
    protected ImageView.ScaleType RrR;
    protected ImageView.ScaleType SP;
    protected String Sj;

    @Deprecated
    private boolean Xqg;
    private String dLt;

    /* renamed from: gq, reason: collision with root package name */
    private float f21113gq;

    /* renamed from: mj, reason: collision with root package name */
    private boolean f21114mj;
    private int oWa;
    private boolean zwV;

    /* renamed from: com.bytedance.sdk.openadsdk.core.TEQ.sP.Sj.Sj$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements EjP {
        AnonymousClass1() {
        }

        @Override // com.bytedance.adsdk.sP.EjP
        public Bitmap Sj(final TEQ teq) {
            final String str;
            if (teq == null) {
                return null;
            }
            String TEQ = teq.TEQ();
            String uA = teq.uA();
            if (!TextUtils.isEmpty(TEQ) && TextUtils.isEmpty(uA)) {
                str = com.bytedance.adsdk.ugeno.TKC.sP.Sj(TEQ, ((TKC) Sj.this).EjP);
            } else if (!TextUtils.isEmpty(uA) && TextUtils.isEmpty(TEQ)) {
                str = com.bytedance.adsdk.ugeno.TKC.sP.Sj(uA, ((TKC) Sj.this).EjP);
            } else if (TextUtils.isEmpty(uA) || TextUtils.isEmpty(TEQ)) {
                str = null;
            } else {
                str = com.bytedance.adsdk.ugeno.TKC.sP.Sj(TEQ, ((TKC) Sj.this).EjP) + com.bytedance.adsdk.ugeno.TKC.sP.Sj(uA, ((TKC) Sj.this).EjP);
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Bitmap bitmap = Sj.this.AVc.get(str);
            if (bitmap != null) {
                return bitmap;
            }
            HiB.Sj().sP().Sj(((TKC) Sj.this).uA, str, new Sj.InterfaceC0208Sj() { // from class: com.bytedance.sdk.openadsdk.core.TEQ.sP.Sj.Sj.1.1
                @Override // com.bytedance.adsdk.ugeno.Sj.InterfaceC0208Sj
                public void Sj(Bitmap bitmap2) {
                    if (bitmap2 != null) {
                        final Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap2, teq.Sj(), teq.sP(), false);
                        Sj.this.AVc.put(str, createScaledBitmap);
                        Dq.Sj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.TEQ.sP.Sj.Sj.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((sP) ((TKC) Sj.this).HiB).Sj(teq.Dq(), createScaledBitmap);
                            }
                        });
                    }
                }
            });
            return Sj.this.AVc.get(str);
        }
    }

    public Sj(Context context) {
        super(context);
        this.dLt = "images";
        this.Ph = 1.0f;
        this.RrR = ImageView.ScaleType.FIT_CENTER;
        this.SP = ImageView.ScaleType.FIT_XY;
        this.AVc = new HashMap<>();
    }

    private ImageView.ScaleType Dq(String str) {
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals(TtmlNode.CENTER)) {
                    c11 = 0;
                    break;
                }
                break;
            case -1274298614:
                if (str.equals("fitEnd")) {
                    c11 = 1;
                    break;
                }
                break;
            case -522179887:
                if (str.equals("fitStart")) {
                    c11 = 2;
                    break;
                }
                break;
            case -340708175:
                if (str.equals("centerInside")) {
                    c11 = 3;
                    break;
                }
                break;
            case 97441490:
                if (str.equals("fitXY")) {
                    c11 = 4;
                    break;
                }
                break;
            case 520762310:
                if (str.equals("fitCenter")) {
                    c11 = 5;
                    break;
                }
                break;
            case 1161480325:
                if (str.equals("centerCrop")) {
                    c11 = 6;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return ImageView.ScaleType.CENTER;
            case 1:
                return ImageView.ScaleType.FIT_END;
            case 2:
                return ImageView.ScaleType.FIT_START;
            case 3:
                return ImageView.ScaleType.CENTER_INSIDE;
            case 4:
            default:
                return scaleType;
            case 5:
                return ImageView.ScaleType.FIT_CENTER;
            case 6:
                return ImageView.ScaleType.CENTER_CROP;
        }
    }

    private String Jcg(String str) {
        return (!TextUtils.isEmpty(str) && str.contains(ImagesContract.LOCAL)) ? str.contains("shake_phone") ? "lottie_json/shake_phone.json" : str.contains("swipe_right") ? "lottie_json/swipe_right.json" : "" : "";
    }

    private ImageView.ScaleType uA(String str) {
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals(TtmlNode.CENTER)) {
                    c11 = 0;
                    break;
                }
                break;
            case 101393:
                if (str.equals("fit")) {
                    c11 = 1;
                    break;
                }
                break;
            case 3062416:
                if (str.equals("crop")) {
                    c11 = 2;
                    break;
                }
                break;
            case 3143043:
                if (str.equals("fill")) {
                    c11 = 3;
                    break;
                }
                break;
            case 3387192:
                if (str.equals("none")) {
                    c11 = 4;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 4:
                return ImageView.ScaleType.CENTER;
            case 1:
                return ImageView.ScaleType.FIT_CENTER;
            case 2:
                return ImageView.ScaleType.CENTER_CROP;
            case 3:
            default:
                return scaleType;
        }
    }

    protected void EjP() {
        ((sP) this.HiB).Sj();
    }

    @Override // com.bytedance.adsdk.ugeno.sP.TKC
    public void Sj(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.Sj(str, str2);
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1878130163:
                if (str.equals("scaleMode")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1877911644:
                if (str.equals("scaleType")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals(NotificationCompat.CATEGORY_PROGRESS)) {
                    c11 = 2;
                    break;
                }
                break;
            case -878289888:
                if (str.equals("imagePath")) {
                    c11 = 3;
                    break;
                }
                break;
            case -291235277:
                if (str.equals("autoReverse")) {
                    c11 = 4;
                    break;
                }
                break;
            case 114148:
                if (str.equals("src")) {
                    c11 = 5;
                    break;
                }
                break;
            case 3327652:
                if (str.equals("loop")) {
                    c11 = 6;
                    break;
                }
                break;
            case 109641799:
                if (str.equals("speed")) {
                    c11 = 7;
                    break;
                }
                break;
            case 1438608771:
                if (str.equals("autoPlay")) {
                    c11 = '\b';
                    break;
                }
                break;
            case 1439562083:
                if (str.equals("autoplay")) {
                    c11 = '\t';
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                this.SP = uA(str2);
                return;
            case 1:
                this.RrR = Dq(str2);
                return;
            case 2:
                this.f21113gq = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, 0.0f);
                return;
            case 3:
                this.dLt = str2;
                return;
            case 4:
                this.zwV = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, false);
                return;
            case 5:
                this.Sj = com.bytedance.sdk.openadsdk.core.TEQ.TKC.Sj(str2);
                return;
            case 6:
                if (LD()) {
                    this.oWa = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, 0);
                    return;
                } else {
                    this.Xqg = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, false);
                    return;
                }
            case 7:
                this.Ph = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, 1.0f);
                return;
            case '\b':
                this.f21114mj = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, false);
                return;
            case '\t':
                this.f21114mj = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, true);
                return;
            default:
                return;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.sP.TKC
    /* renamed from: TKC, reason: merged with bridge method [inline-methods] */
    public sP Sj() {
        sP sPVar = new sP(this.sP);
        sPVar.Sj(this);
        return sPVar;
    }

    @Override // com.bytedance.adsdk.ugeno.sP.TKC
    public void sP() {
        super.sP();
        ((sP) this.HiB).setProgress(this.f21113gq);
        if (this.Ph <= 0.0f) {
            this.Ph = 1.0f;
        }
        ((sP) this.HiB).setSpeed(this.Ph);
        if (this.Sj.startsWith(ImagesContract.LOCAL)) {
            ((sP) this.HiB).setAnimation(Jcg(this.Sj));
            ((sP) this.HiB).setImageAssetsFolder(this.dLt);
        } else {
            ((sP) this.HiB).setAnimationFromUrl(this.Sj);
        }
        ((sP) this.HiB).setImageAssetDelegate(new AnonymousClass1());
        if (LD()) {
            ((sP) this.HiB).setScaleType(this.SP);
        } else {
            ((sP) this.HiB).setScaleType(this.RrR);
        }
        if (LD()) {
            ((sP) this.HiB).setRepeatCount(this.oWa);
        } else {
            ((sP) this.HiB).Sj(this.Xqg);
        }
        EjP();
    }
}
