package com.bytedance.sdk.component.adexpress.dynamic.EjP;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.adexpress.dynamic.HiB.Ym;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class Jcg {
    private vS EjP;
    private HiB HiB;
    public int Sj;
    public JSONObject TKC;
    public String sP;
    private String vS;

    public Jcg(HiB hiB) {
        this.HiB = hiB;
        this.Sj = hiB.Sj();
        this.sP = hiB.TKC();
        this.TKC = hiB.HiB().Uc();
        this.vS = hiB.EjP();
        if (com.bytedance.sdk.component.adexpress.EjP.TKC() == 1) {
            this.EjP = hiB.Jcg();
        } else {
            this.EjP = hiB.HiB();
        }
        if (com.bytedance.sdk.component.adexpress.EjP.sP()) {
            this.EjP = hiB.HiB();
        }
    }

    private boolean HcZ() {
        if (com.bytedance.sdk.component.adexpress.EjP.sP()) {
            return false;
        }
        return (!TextUtils.isEmpty(this.sP) && this.sP.contains("adx:")) || Ym.sP();
    }

    public static int Sj(String str) {
        String[] split;
        if (TextUtils.isEmpty(str)) {
            return ViewCompat.MEASURED_STATE_MASK;
        }
        if (str.equals(TmcStartParams.KEY_TRANSPARENT)) {
            return 0;
        }
        if (str.charAt(0) == '#' && str.length() == 7) {
            return Color.parseColor(str);
        }
        if (str.charAt(0) == '#' && str.length() == 9) {
            return Color.parseColor(str);
        }
        if (str.startsWith("rgba") && (split = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",")) != null) {
            try {
                if (split.length == 4) {
                    return (((int) ((Float.parseFloat(split[3]) * 255.0f) + 0.5f)) << 24) | (((int) Float.parseFloat(split[0])) << 16) | (((int) Float.parseFloat(split[1])) << 8) | ((int) Float.parseFloat(split[2]));
                }
            } catch (NumberFormatException unused) {
                return 0;
            }
        }
        return ViewCompat.MEASURED_STATE_MASK;
    }

    private boolean mZN() {
        return (com.bytedance.sdk.component.adexpress.EjP.sP() && (this.HiB.sP().contains("logo-union") || this.HiB.sP().contains("logounion") || this.HiB.sP().contains("logoad"))) || "logo-union".equals(this.HiB.sP()) || "logounion".equals(this.HiB.sP()) || "logoad".equals(this.HiB.sP());
    }

    public static float[] sP(String str) {
        String[] split = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",");
        return (split == null || split.length != 4) ? new float[]{0.0f, 0.0f, 0.0f, 0.0f} : new float[]{Float.parseFloat(split[0]), Float.parseFloat(split[1]), Float.parseFloat(split[2]), Float.parseFloat(split[3])};
    }

    public int Bml() {
        return this.EjP.WMZ();
    }

    public int Chv() {
        return this.EjP.JcM();
    }

    public int Dq() {
        String dx2 = this.EjP.dx();
        if (TtmlNode.LEFT.equals(dx2)) {
            return 17;
        }
        if (TtmlNode.CENTER.equals(dx2)) {
            return 4;
        }
        return TtmlNode.RIGHT.equals(dx2) ? 3 : 2;
    }

    public boolean EZ() {
        return this.EjP.fF();
    }

    public String Ei() {
        return this.EjP.Wjd();
    }

    public int EjP() {
        return (int) this.EjP.uvD();
    }

    public String FPG() {
        return this.EjP.TEQ();
    }

    public int Fm() {
        return this.EjP.aZ();
    }

    public double Fmk() {
        if (this.Sj == 11) {
            try {
                return !com.bytedance.sdk.component.adexpress.EjP.sP() ? (int) r0 : Double.parseDouble(this.sP);
            } catch (NumberFormatException unused) {
            }
        }
        return -1.0d;
    }

    public int HS() {
        return this.EjP.nP();
    }

    public float HiB() {
        return this.EjP.TzV();
    }

    public boolean HpB() {
        return this.EjP.AVc();
    }

    public String IOh() {
        return this.EjP.tX();
    }

    public int Ir() {
        return this.EjP.tY();
    }

    public int JcM() {
        return this.EjP.HiB();
    }

    public int Jcg() {
        return Sj(this.EjP.zR());
    }

    public int LD() {
        return this.EjP.TKC();
    }

    public int LqL() {
        return Sj(this.EjP.ib());
    }

    public int Mts() {
        return this.EjP.uA();
    }

    public String MuB() {
        return this.EjP.dLt();
    }

    public int RiZ() {
        return this.EjP.hzV();
    }

    public int Sj() {
        return (int) this.EjP.sef();
    }

    public void Sj(float f11) {
        this.EjP.Sj(f11);
    }

    public boolean Sj(int i11) {
        HiB hiB = this.HiB;
        if (hiB == null) {
            return false;
        }
        if (i11 == 1) {
            this.EjP = hiB.Jcg();
        } else {
            this.EjP = hiB.HiB();
        }
        return this.EjP != null;
    }

    public String TEQ() {
        int i11 = this.Sj;
        return (i11 == 2 || i11 == 13) ? this.sP : "";
    }

    public String TFd() {
        return this.EjP.uP();
    }

    public int TKC() {
        return (int) this.EjP.Zq();
    }

    public int TzV() {
        return this.EjP.Ph();
    }

    public int UHs() {
        return this.EjP.TO();
    }

    public String Uc() {
        return this.EjP.tPD();
    }

    public int WMZ() {
        return this.EjP.EjP();
    }

    public String Wjd() {
        return this.EjP.Fm();
    }

    public double Yf() {
        return this.EjP.Dq();
    }

    public String Ym() {
        return this.Sj == 1 ? this.sP : "";
    }

    public float Zq() {
        return this.EjP.Ym();
    }

    public double aNB() {
        return this.EjP.Mts();
    }

    public int aZ() {
        return this.EjP.liH();
    }

    public String aa() {
        return this.vS;
    }

    public double cX() {
        return this.EjP.FPG();
    }

    public float dNu() {
        return this.EjP.aa();
    }

    public int db() {
        return this.EjP.gq();
    }

    public boolean dwU() {
        return this.EjP.SP();
    }

    public String dx() {
        return this.EjP.kF();
    }

    public int fF() {
        return this.EjP.sP();
    }

    public boolean gR() {
        return this.EjP.QZ();
    }

    public String gY() {
        return this.EjP.LD();
    }

    public int ib() {
        return this.EjP.xhi();
    }

    public int jb() {
        return this.EjP.Ir();
    }

    public String kF() {
        return this.EjP.xD();
    }

    public int kb() {
        return this.EjP.zwV();
    }

    public int ley() {
        String xD = this.EjP.xD();
        if ("skip-with-time-skip-btn".equals(this.HiB.sP()) || "skip".equals(this.HiB.sP()) || TextUtils.equals("skip-with-countdowns-skip-btn", this.HiB.sP())) {
            return 6;
        }
        if (!"skip-with-time-countdown".equals(this.HiB.sP()) && !"skip-with-time".equals(this.HiB.sP())) {
            if (this.Sj == 10 && TextUtils.equals(this.EjP.Fm(), "click")) {
                return 5;
            }
            if (mZN() && HcZ()) {
                return 0;
            }
            if (mZN()) {
                return 7;
            }
            if ("feedback-dislike".equals(this.HiB.sP())) {
                return 3;
            }
            if (!TextUtils.isEmpty(xD) && !xD.equals("none")) {
                if (xD.equals("video") || (this.HiB.Sj() == 7 && TextUtils.equals(xD, "normal"))) {
                    return (com.bytedance.sdk.component.adexpress.EjP.sP() && this.HiB.HiB() != null && this.HiB.HiB().vb()) ? 11 : 4;
                }
                if (xD.equals("normal")) {
                    return 1;
                }
                return (xD.equals("creative") || "slide".equals(this.EjP.Fm())) ? 2 : 0;
            }
        }
        return 0;
    }

    public int ndK() {
        return this.EjP.Grp();
    }

    public boolean pfr() {
        return this.EjP.Fmk();
    }

    public int qRN() {
        return this.EjP.RrR();
    }

    public int sP() {
        return (int) this.EjP.dNu();
    }

    public boolean sU() {
        return this.EjP.GMp();
    }

    public String sdp() {
        return this.EjP.Yf();
    }

    public double sef() {
        return this.EjP.RiZ();
    }

    public boolean tz() {
        return this.EjP.SP();
    }

    public int uA() {
        int Dq = Dq();
        if (Dq == 4) {
            return 17;
        }
        return Dq == 3 ? GravityCompat.END : GravityCompat.START;
    }

    public String uP() {
        return this.EjP.DPc();
    }

    public int uvD() {
        return Sj(this.EjP.wE());
    }

    public String vS() {
        return this.Sj == 0 ? !TextUtils.isEmpty(this.sP) ? this.sP : this.TKC.optString(com.bytedance.sdk.component.adexpress.EjP.Jcg.TKC(com.bytedance.sdk.component.adexpress.EjP.Sj())) : "";
    }

    public long wE() {
        return this.EjP.xzt();
    }

    public boolean xD() {
        return this.EjP.gR();
    }

    public int xhi() {
        return this.EjP.Jcg();
    }

    public String xu() {
        return this.EjP.eI();
    }

    public boolean zR() {
        return this.EjP.HpB();
    }
}
