package com.bytedance.sdk.component.adexpress.dynamic.TKC;

import android.content.Context;
import android.text.TextUtils;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;

/* loaded from: classes2.dex */
public class TEQ {
    public static Jcg Sj(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.HiB hiB, com.bytedance.sdk.component.adexpress.dynamic.EjP.Jcg jcg, com.bytedance.sdk.component.adexpress.dynamic.EjP.TEQ teq, com.bytedance.sdk.component.adexpress.sP.Fmk fmk) {
        Jcg riZ;
        String str = null;
        if (context == null || hiB == null || jcg == null) {
            return null;
        }
        String Ei = jcg.Ei();
        String kF = fmk.kF();
        Ei.hashCode();
        char c11 = 65535;
        switch (Ei.hashCode()) {
            case AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE:
                if (Ei.equals("0")) {
                    c11 = 0;
                    break;
                }
                break;
            case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                if (Ei.equals("1")) {
                    c11 = 1;
                    break;
                }
                break;
            case 50:
                if (Ei.equals("2")) {
                    c11 = 2;
                    break;
                }
                break;
            case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
                if (Ei.equals("5")) {
                    c11 = 3;
                    break;
                }
                break;
            case AD_BACKGROUND_BEFORE_IMPRESSION_VALUE:
                if (Ei.equals(PrepareException.ERROR_NO_URL)) {
                    c11 = 4;
                    break;
                }
                break;
            case AD_CLOSED_BEFORE_IMPRESSION_VALUE:
                if (Ei.equals("7")) {
                    c11 = 5;
                    break;
                }
                break;
            case AD_VISIBILITY_VALUE:
                if (Ei.equals(PrepareException.ERROR_MANIFEST_INFO)) {
                    c11 = 6;
                    break;
                }
                break;
            case 57:
                if (Ei.equals(PrepareException.ERROR_MINI_APP_CLOSE)) {
                    c11 = 7;
                    break;
                }
                break;
            case 1567:
                if (Ei.equals("10")) {
                    c11 = '\b';
                    break;
                }
                break;
            case 1568:
                if (Ei.equals(PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY)) {
                    c11 = '\t';
                    break;
                }
                break;
            case 1569:
                if (Ei.equals("12")) {
                    c11 = '\n';
                    break;
                }
                break;
            case 1570:
                if (Ei.equals(PrepareException.ERROR_WARMUP_DOWNLOAD_EXCEPTION)) {
                    c11 = 11;
                    break;
                }
                break;
            case 1571:
                if (Ei.equals("14")) {
                    c11 = '\f';
                    break;
                }
                break;
            case 1573:
                if (Ei.equals("16")) {
                    c11 = '\r';
                    break;
                }
                break;
            case 1574:
                if (Ei.equals("17")) {
                    c11 = 14;
                    break;
                }
                break;
            case 1575:
                if (Ei.equals("18")) {
                    c11 = 15;
                    break;
                }
                break;
            case 1598:
                if (Ei.equals("20")) {
                    c11 = 16;
                    break;
                }
                break;
            case 1600:
                if (Ei.equals("22")) {
                    c11 = 17;
                    break;
                }
                break;
            case 1601:
                if (Ei.equals("23")) {
                    c11 = 18;
                    break;
                }
                break;
            case 1602:
                if (Ei.equals("24")) {
                    c11 = 19;
                    break;
                }
                break;
            case 1603:
                if (Ei.equals("25")) {
                    c11 = 20;
                    break;
                }
                break;
            case 1607:
                if (Ei.equals("29")) {
                    c11 = 21;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return new HiB(context, hiB, jcg);
            case 1:
                return new TKC(context, hiB, jcg);
            case 2:
                return new sP(context, hiB, jcg);
            case 3:
                return jcg.xhi() == 1 ? new dNu(context, hiB, jcg, jcg.Chv()) : new uvD(context, hiB, jcg);
            case 4:
            case '\t':
                return new sef(context, hiB, jcg);
            case 5:
            case '\f':
                return new aa(context, hiB, jcg);
            case 6:
                return new Fmk(context, hiB, jcg);
            case 7:
            case '\r':
                return new Zq(context, hiB, jcg, Ei, teq.Sj(), teq.sP(), teq.EjP(), teq.Jcg());
            case '\b':
                return new EjP(context, hiB, jcg);
            case '\n':
                return new uvD(context, hiB, jcg);
            case 11:
                return new dNu(context, hiB, jcg);
            case 14:
            case 15:
                riZ = new RiZ(context, hiB, jcg, Ei, teq);
                break;
            case 16:
                if (!com.bytedance.sdk.component.adexpress.EjP.sP()) {
                    if (!TextUtils.isEmpty(kF)) {
                        str = kF + "brush_mask.json";
                    }
                    riZ = new Ym(context, hiB, jcg, str, "20");
                    break;
                } else {
                    riZ = new Ym(context, hiB, jcg, kF + "static/lotties/glass-swipe/glass-swipe.json", "20");
                    break;
                }
            case 17:
                if (!com.bytedance.sdk.component.adexpress.EjP.sP()) {
                    return new TzV(context, hiB, jcg);
                }
                riZ = new Ym(context, hiB, jcg, kF + "static/lotties/202327swiper-up-star/index.json", "22");
                break;
            case 18:
                if (!com.bytedance.sdk.component.adexpress.EjP.sP()) {
                    return null;
                }
                riZ = new Ym(context, hiB, jcg, kF + "static/lotties/202327swiper-up-star/click.json", "23");
                break;
            case 19:
                if (!com.bytedance.sdk.component.adexpress.EjP.sP()) {
                    if (!TextUtils.isEmpty(kF)) {
                        str = kF + "swiper_up_star.json";
                    }
                    riZ = new Ym(context, hiB, jcg, str, "24");
                    break;
                } else {
                    return new Sj(context, hiB, jcg);
                }
            case 20:
                if (!com.bytedance.sdk.component.adexpress.EjP.sP()) {
                    return null;
                }
                riZ = new Ym(context, hiB, jcg, kF + "static/lotties/gesture-slide.json", "25");
                break;
            case 21:
                return new vS(context, hiB, jcg, teq.Sj(), teq.sP(), teq.EjP(), teq.Jcg());
            default:
                return null;
        }
        return riZ;
    }
}
