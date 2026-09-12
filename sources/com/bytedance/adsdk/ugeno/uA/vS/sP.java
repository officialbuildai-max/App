package com.bytedance.adsdk.ugeno.uA.vS;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.ugeno.Jcg.Dq;
import com.bytedance.adsdk.ugeno.sP.TKC;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* loaded from: classes2.dex */
public class sP extends TKC<Sj> {
    protected int AVc;
    private float Aw;
    private float GMp;

    @Deprecated
    private float Grp;
    private float Ov;
    private TextUtils.TruncateAt Ph;
    protected int RrR;
    private float SP;
    protected String Sj;
    private int TX;
    private float WxP;
    private int Xqg;
    private int dLt;

    /* renamed from: gq, reason: collision with root package name */
    @Deprecated
    private TextUtils.TruncateAt f20926gq;
    private float hzV;

    /* renamed from: mj, reason: collision with root package name */
    private int f20927mj;
    private int oWa;
    private float tPD;

    @Deprecated
    private float tX;

    /* renamed from: vb, reason: collision with root package name */
    private boolean f20928vb;
    private int zwV;

    public sP(Context context) {
        super(context);
        this.AVc = ViewCompat.MEASURED_STATE_MASK;
        this.SP = 12.0f;
        this.zwV = Integer.MAX_VALUE;
        this.oWa = 2;
        this.RrR = 3;
        this.Ph = TextUtils.TruncateAt.END;
        this.GMp = -1.0f;
        this.hzV = 400.0f;
    }

    private TextUtils.TruncateAt Dq(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals(TtmlNode.CENTER)) {
                    c11 = 0;
                    break;
                }
                break;
            case 100571:
                if (str.equals(TtmlNode.END)) {
                    c11 = 1;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                this.f20926gq = TextUtils.TruncateAt.MIDDLE;
                break;
            case 1:
                this.f20926gq = TextUtils.TruncateAt.END;
                break;
            case 2:
                this.f20926gq = TextUtils.TruncateAt.START;
                break;
            default:
                this.f20926gq = null;
                break;
        }
        return this.f20926gq;
    }

    private void EjP() {
        ((Sj) this.HiB).setLineSpacing(0.0f, this.GMp);
    }

    private int TEQ(String str) {
        char c11;
        int hashCode = str.hashCode();
        if (hashCode == -1178781136) {
            if (str.equals(TtmlNode.ITALIC)) {
                c11 = 1;
            }
            c11 = 65535;
        } else if (hashCode != -1039745817) {
            if (hashCode == 3029637 && str.equals(TtmlNode.BOLD)) {
                c11 = 0;
            }
            c11 = 65535;
        } else {
            if (str.equals("normal")) {
                c11 = 2;
            }
            c11 = 65535;
        }
        if (c11 != 0) {
            return c11 != 1 ? 0 : 2;
        }
        return 1;
    }

    private int Ym(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals(TtmlNode.CENTER)) {
                    c11 = 0;
                    break;
                }
                break;
            case 3317767:
                if (str.equals(TtmlNode.LEFT)) {
                    c11 = 1;
                    break;
                }
                break;
            case 108511772:
                if (str.equals(TtmlNode.RIGHT)) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return 17;
            case 1:
                return 3;
            case 2:
                return 5;
            default:
                return 2;
        }
    }

    private int aa(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1026963764:
                if (str.equals(TtmlNode.UNDERLINE)) {
                    c11 = 0;
                    break;
                }
                break;
            case -972521773:
                if (str.equals("strikethrough")) {
                    c11 = 1;
                    break;
                }
                break;
            case 3387192:
                if (str.equals("none")) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return 8;
            case 1:
                return 16;
            case 2:
            default:
                return Integer.MAX_VALUE;
        }
    }

    private TextUtils.TruncateAt uA(String str) {
        if (TextUtils.equals(str, "none")) {
            return null;
        }
        return TextUtils.TruncateAt.END;
    }

    private void uA() {
        float f11 = this.GMp;
        if (f11 <= 3.0f) {
            ((Sj) this.HiB).setLineSpacing(0.0f, f11);
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            int round = Math.round(Dq.Sj(this.sP, (f11 - (this.SP * 1.2f)) / 2.0f));
            int paddingTop = ((Sj) this.HiB).getPaddingTop() + round;
            int paddingBottom = ((Sj) this.HiB).getPaddingBottom() + round;
            T t11 = this.HiB;
            ((Sj) t11).setPadding(((Sj) t11).getPaddingLeft(), paddingTop, ((Sj) this.HiB).getPaddingRight(), paddingBottom);
            ((Sj) this.HiB).setLineHeight(Math.round(Dq.Sj(this.sP, this.GMp)));
        }
    }

    public void Jcg(String str) {
        this.Sj = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.equals("null", str)) {
            this.Sj = "";
        }
        ((Sj) this.HiB).setText(this.Sj);
    }

    public void Sj(int i11) {
        this.f20927mj = i11;
        if (i11 == Integer.MAX_VALUE) {
            return;
        }
        ((Sj) this.HiB).setPaintFlags(i11);
    }

    public void Sj(TextUtils.TruncateAt truncateAt) {
        if (truncateAt == null) {
            return;
        }
        ((Sj) this.HiB).setEllipsize(truncateAt);
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
            case -1621067310:
                if (str.equals("shadowRadius")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1589741021:
                if (str.equals("shadowColor")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1230714651:
                if (str.equals("shadowOffsetX")) {
                    c11 = 2;
                    break;
                }
                break;
            case -1230714650:
                if (str.equals("shadowOffsetY")) {
                    c11 = 3;
                    break;
                }
                break;
            case -1065511464:
                if (str.equals(TtmlNode.ATTR_TTS_TEXT_ALIGN)) {
                    c11 = 4;
                    break;
                }
                break;
            case -1063571914:
                if (str.equals("textColor")) {
                    c11 = 5;
                    break;
                }
                break;
            case -1048634236:
                if (str.equals("textStyle")) {
                    c11 = 6;
                    break;
                }
                break;
            case -1021145689:
                if (str.equals("shadowBlur")) {
                    c11 = 7;
                    break;
                }
                break;
            case -1003668786:
                if (str.equals("textSize")) {
                    c11 = '\b';
                    break;
                }
                break;
            case -879295043:
                if (str.equals(TtmlNode.ATTR_TTS_TEXT_DECORATION)) {
                    c11 = '\t';
                    break;
                }
                break;
            case -756368940:
                if (str.equals("shadowDx")) {
                    c11 = '\n';
                    break;
                }
                break;
            case -756368939:
                if (str.equals("shadowDy")) {
                    c11 = 11;
                    break;
                }
                break;
            case -734428249:
                if (str.equals(TtmlNode.ATTR_TTS_FONT_WEIGHT)) {
                    c11 = '\f';
                    break;
                }
                break;
            case -515807685:
                if (str.equals("lineHeight")) {
                    c11 = '\r';
                    break;
                }
                break;
            case 3556653:
                if (str.equals(MimeTypes.BASE_TYPE_TEXT)) {
                    c11 = 14;
                    break;
                }
                break;
            case 102977279:
                if (str.equals("lines")) {
                    c11 = 15;
                    break;
                }
                break;
            case 188702929:
                if (str.equals("ellipsis")) {
                    c11 = 16;
                    break;
                }
                break;
            case 390232059:
                if (str.equals("maxLines")) {
                    c11 = 17;
                    break;
                }
                break;
            case 1554823821:
                if (str.equals("ellipsize")) {
                    c11 = 18;
                    break;
                }
                break;
            case 2111078717:
                if (str.equals("letterSpacing")) {
                    c11 = 19;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 7:
                this.tPD = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, 0.0f);
                return;
            case 1:
                this.TX = com.bytedance.adsdk.ugeno.Jcg.Sj.Sj(str2);
                this.f20928vb = true;
                return;
            case 2:
                this.Aw = Dq.Sj(this.sP, com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, 0.0f));
                return;
            case 3:
                this.Ov = Dq.Sj(this.sP, com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, 0.0f));
                return;
            case 4:
                this.oWa = Ym(str2);
                return;
            case 5:
                this.AVc = com.bytedance.adsdk.ugeno.Jcg.Sj.Sj(str2);
                return;
            case 6:
                this.dLt = TEQ(str2);
                return;
            case '\b':
                this.SP = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, 0.0f);
                return;
            case '\t':
                this.f20927mj = aa(str2);
                return;
            case '\n':
                this.Grp = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, 0.0f);
                return;
            case 11:
                this.tX = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, 0.0f);
                return;
            case '\f':
                float Sj = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, -1.0f);
                this.hzV = Sj;
                if (Sj < 1.0f || Sj > 1000.0f) {
                    this.hzV = 400.0f;
                    return;
                }
                return;
            case '\r':
                this.GMp = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, 1.0f);
                return;
            case 14:
                this.Sj = str2;
                return;
            case 15:
                this.Xqg = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, 0);
                return;
            case 16:
                this.Ph = uA(str2);
                return;
            case 17:
                int Sj2 = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, Integer.MAX_VALUE);
                this.zwV = Sj2 > 0 ? Sj2 : Integer.MAX_VALUE;
                return;
            case 18:
                this.f20926gq = Dq(str2);
                return;
            case 19:
                this.WxP = Dq.Sj(this.sP, com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(str2, 0.0f));
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
        Typeface create;
        super.sP();
        if (TextUtils.equals("null", this.Sj)) {
            this.Sj = "";
        }
        Jcg(this.Sj);
        ((Sj) this.HiB).setTextSize(1, this.SP);
        ((Sj) this.HiB).setTextColor(this.AVc);
        ((Sj) this.HiB).setLines(this.Xqg);
        ((Sj) this.HiB).setMaxLines(this.zwV);
        ((Sj) this.HiB).setGravity(this.oWa);
        ((Sj) this.HiB).setIncludeFontPadding(false);
        Sj(this.f20927mj);
        if (LD()) {
            Sj(this.Ph);
        } else {
            Sj(this.f20926gq);
        }
        if (this.GMp > 0.0f) {
            if (LD()) {
                uA();
            } else {
                EjP();
            }
        }
        int i11 = Build.VERSION.SDK_INT;
        ((Sj) this.HiB).setBreakStrategy(0);
        if (!LD()) {
            ((Sj) this.HiB).setShadowLayer(this.tPD, this.Grp, this.tX, this.TX);
        } else if (this.f20928vb) {
            if (this.tPD <= 0.0f) {
                this.tPD = 1.0E-5f;
            }
            ((Sj) this.HiB).setShadowLayer(this.tPD, this.Aw, this.Ov, this.TX);
        }
        int i12 = this.dLt;
        if (i12 == 1) {
            ((Sj) this.HiB).setTypeface(Typeface.DEFAULT, i12);
        } else if (i11 >= 28) {
            create = Typeface.create(Typeface.DEFAULT, (int) this.hzV, i12 == 2);
            ((Sj) this.HiB).setTypeface(create);
        } else if (this.hzV >= 500.0f) {
            ((Sj) this.HiB).setTypeface(Typeface.DEFAULT, 1);
        }
        if (Dq.Sj(this.sP, this.SP) > 0.0f) {
            ((Sj) this.HiB).setLetterSpacing(this.WxP / Dq.Sj(this.sP, this.SP));
        }
    }
}
