package com.bytedance.adsdk.ugeno.uA.EjP;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.drawable.b;
import com.bumptech.glide.load.resource.drawable.c;
import com.bytedance.adsdk.ugeno.HiB;
import com.bytedance.adsdk.ugeno.Jcg.Dq;
import com.bytedance.adsdk.ugeno.Jcg.EjP;
import com.bytedance.adsdk.ugeno.Sj;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* loaded from: classes2.dex */
public class TKC extends com.bytedance.adsdk.ugeno.sP.TKC<Sj> {
    protected ImageView.ScaleType AVc;
    protected boolean RrR;
    private int SP;
    protected String Sj;
    private float dLt;
    private float zwV;

    public TKC(Context context) {
        super(context);
        this.AVc = ImageView.ScaleType.FIT_XY;
        this.SP = -1;
        this.dLt = -1.0f;
        this.zwV = -1.0f;
    }

    private void EjP() {
        if (TextUtils.isEmpty(this.Sj)) {
            return;
        }
        ((Sj) this.HiB).setImageDrawable(null);
        if (this.Sj.startsWith("local://")) {
            try {
                ((Sj) this.HiB).setImageResource(EjP.Sj(this.sP, this.Sj.replace("local://", "")));
            } catch (Throwable unused) {
            }
        } else {
            if (!this.Sj.startsWith("@")) {
                uA();
                return;
            }
            try {
                ((Sj) this.HiB).setImageResource(Integer.parseInt(this.Sj.substring(1)));
            } catch (Exception unused2) {
            }
        }
    }

    private ImageView.ScaleType Jcg(String str) {
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
            case 101393:
                if (str.equals("fit")) {
                    c11 = 4;
                    break;
                }
                break;
            case 3062416:
                if (str.equals("crop")) {
                    c11 = 5;
                    break;
                }
                break;
            case 3143043:
                if (str.equals("fill")) {
                    c11 = 6;
                    break;
                }
                break;
            case 97441490:
                if (str.equals("fitXY")) {
                    c11 = 7;
                    break;
                }
                break;
            case 520762310:
                if (str.equals("fitCenter")) {
                    c11 = '\b';
                    break;
                }
                break;
            case 1161480325:
                if (str.equals("centerCrop")) {
                    c11 = '\t';
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
            case '\b':
                return ImageView.ScaleType.FIT_CENTER;
            case 5:
            case '\t':
                return ImageView.ScaleType.CENTER_CROP;
            case 6:
            case 7:
            default:
                return scaleType;
        }
    }

    private void uA() {
        if (this.dLt > 0.0f) {
            HiB.Sj().sP().Sj(this.uA, this.Sj, new Sj.InterfaceC0208Sj() { // from class: com.bytedance.adsdk.ugeno.uA.EjP.TKC.1
                @Override // com.bytedance.adsdk.ugeno.Sj.InterfaceC0208Sj
                public void Sj(Bitmap bitmap) {
                    if (bitmap == null) {
                        return;
                    }
                    final Bitmap Sj = Dq.Sj(((com.bytedance.adsdk.ugeno.sP.TKC) TKC.this).sP, bitmap, (int) TKC.this.dLt);
                    if (Sj != null) {
                        Dq.Sj(new Runnable() { // from class: com.bytedance.adsdk.ugeno.uA.EjP.TKC.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((Sj) ((com.bytedance.adsdk.ugeno.sP.TKC) TKC.this).HiB).setImageBitmap(Sj);
                            }
                        });
                    }
                    TKC tkc = TKC.this;
                    if (tkc.RrR || tkc.zwV > 0.0f) {
                        Bitmap Sj2 = Dq.Sj(((com.bytedance.adsdk.ugeno.sP.TKC) TKC.this).sP, bitmap, TKC.this.zwV > 0.0f ? (int) TKC.this.zwV : 10);
                        if (Sj2 != null) {
                            final BitmapDrawable bitmapDrawable = new BitmapDrawable(((com.bytedance.adsdk.ugeno.sP.TKC) TKC.this).sP.getResources(), Sj2);
                            Dq.Sj(new Runnable() { // from class: com.bytedance.adsdk.ugeno.uA.EjP.TKC.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((Sj) ((com.bytedance.adsdk.ugeno.sP.TKC) TKC.this).HiB).setBackground(bitmapDrawable);
                                }
                            });
                        }
                    }
                }
            });
            return;
        }
        com.bytedance.adsdk.ugeno.Sj sP = HiB.Sj().sP();
        com.bytedance.adsdk.ugeno.core.Dq dq2 = this.uA;
        String str = this.Sj;
        T t11 = this.HiB;
        sP.Sj(dq2, str, (ImageView) t11, ((Sj) t11).getWidth(), ((Sj) this.HiB).getHeight());
        if (this.RrR || this.zwV > 0.0f) {
            HiB.Sj().sP().Sj(this.uA, this.Sj, new Sj.InterfaceC0208Sj() { // from class: com.bytedance.adsdk.ugeno.uA.EjP.TKC.2
                @Override // com.bytedance.adsdk.ugeno.Sj.InterfaceC0208Sj
                public void Sj(Bitmap bitmap) {
                    if (bitmap == null) {
                        return;
                    }
                    final Bitmap Sj = Dq.Sj(((com.bytedance.adsdk.ugeno.sP.TKC) TKC.this).sP, bitmap, TKC.this.zwV > 0.0f ? (int) TKC.this.zwV : 10);
                    Dq.Sj(new Runnable() { // from class: com.bytedance.adsdk.ugeno.uA.EjP.TKC.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (Sj != null) {
                                ((Sj) ((com.bytedance.adsdk.ugeno.sP.TKC) TKC.this).HiB).setBackground(new BitmapDrawable(((com.bytedance.adsdk.ugeno.sP.TKC) TKC.this).sP.getResources(), Sj));
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // com.bytedance.adsdk.ugeno.sP.TKC, com.bytedance.adsdk.ugeno.EjP
    public void Dq() {
        super.Dq();
        Drawable drawable = ((Sj) this.HiB).getDrawable();
        if (Build.VERSION.SDK_INT < 28 || !b.a(drawable)) {
            return;
        }
        c.a(drawable).stop();
    }

    public void Dq(String str) {
        this.Sj = str;
    }

    @Override // com.bytedance.adsdk.ugeno.sP.TKC, com.bytedance.adsdk.ugeno.EjP
    public void Jcg() {
        super.Jcg();
        ((Sj) this.HiB).post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.uA.EjP.TKC.3
            @Override // java.lang.Runnable
            public void run() {
                Drawable drawable = ((Sj) ((com.bytedance.adsdk.ugeno.sP.TKC) TKC.this).HiB).getDrawable();
                if (Build.VERSION.SDK_INT < 28 || !b.a(drawable)) {
                    return;
                }
                c.a(drawable).start();
            }
        });
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
            case -878696350:
                if (str.equals("imageBlur")) {
                    c11 = 2;
                    break;
                }
                break;
            case -372324943:
                if (str.equals("isBgGaussianBlur")) {
                    c11 = 3;
                    break;
                }
                break;
            case 114148:
                if (str.equals("src")) {
                    c11 = 4;
                    break;
                }
                break;
            case 1327599912:
                if (str.equals("tintColor")) {
                    c11 = 5;
                    break;
                }
                break;
            case 1675225991:
                if (str.equals("imageBgBlur")) {
                    c11 = 6;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 1:
                this.AVc = Jcg(str2);
                return;
            case 2:
                this.dLt = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, -1.0f);
                return;
            case 3:
                this.RrR = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, false);
                return;
            case 4:
                this.Sj = str2;
                return;
            case 5:
                this.SP = com.bytedance.adsdk.ugeno.Jcg.Sj.Sj(str2);
                return;
            case 6:
                this.zwV = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, -1.0f);
                return;
            default:
                return;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.sP.TKC
    /* renamed from: TKC, reason: merged with bridge method [inline-methods] */
    public Sj Sj() {
        Sj sj2 = new Sj(this.sP);
        sj2.Sj(this);
        return sj2;
    }

    @Override // com.bytedance.adsdk.ugeno.sP.TKC
    public void sP() {
        super.sP();
        EjP();
        ((Sj) this.HiB).setScaleType(this.AVc);
        ((Sj) this.HiB).setBorderColor(this.EZ);
        ((Sj) this.HiB).setCornerRadius(this.xhi);
        ((Sj) this.HiB).setBorderWidth(this.pfr);
        int i11 = this.SP;
        if (i11 != -1) {
            ((Sj) this.HiB).setColorFilter(i11);
        }
    }
}
