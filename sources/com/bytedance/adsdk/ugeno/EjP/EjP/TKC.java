package com.bytedance.adsdk.ugeno.EjP.EjP;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.EjP.Ym;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.Map;

/* loaded from: classes2.dex */
public class TKC extends Sj {
    private int Fmk;
    private float Ym;

    /* renamed from: aa, reason: collision with root package name */
    private float f20890aa;
    private String sef;

    public TKC(Context context) {
        super(context);
        this.Fmk = 0;
        this.sef = "up";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean Sj(com.bytedance.adsdk.ugeno.sP.TKC tkc, MotionEvent motionEvent) {
        char c11;
        Ym ym2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.Ym = motionEvent.getX();
            this.f20890aa = motionEvent.getY();
        } else if (action == 1 || action == 3) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            if (this.Fmk == 0 && (ym2 = this.Sj) != null) {
                ym2.Sj(tkc, this.vS, this.TKC.sP());
                return true;
            }
            int sP = com.bytedance.adsdk.ugeno.Jcg.Dq.sP(this.TEQ, x10 - this.Ym);
            int sP2 = com.bytedance.adsdk.ugeno.Jcg.Dq.sP(this.TEQ, y10 - this.f20890aa);
            String str = this.sef;
            switch (str.hashCode()) {
                case 3739:
                    if (str.equals("up")) {
                        c11 = 0;
                        break;
                    }
                    c11 = 65535;
                    break;
                case 96673:
                    if (str.equals(IntegrationConstants.NAVIGATION_BAR_ALL_ACTION)) {
                        c11 = 4;
                        break;
                    }
                    c11 = 65535;
                    break;
                case 3089570:
                    if (str.equals("down")) {
                        c11 = 1;
                        break;
                    }
                    c11 = 65535;
                    break;
                case 3317767:
                    if (str.equals(TtmlNode.LEFT)) {
                        c11 = 2;
                        break;
                    }
                    c11 = 65535;
                    break;
                case 108511772:
                    if (str.equals(TtmlNode.RIGHT)) {
                        c11 = 3;
                        break;
                    }
                    c11 = 65535;
                    break;
                default:
                    c11 = 65535;
                    break;
            }
            if (c11 == 0) {
                sP = -sP2;
            } else if (c11 == 1) {
                sP = sP2;
            } else if (c11 == 2) {
                sP = -sP;
            } else if (c11 != 3) {
                sP = (int) Math.abs(Math.sqrt(Math.pow(sP, 2.0d) + Math.pow(sP2, 2.0d)));
            }
            if (sP < this.Fmk) {
                return false;
            }
            Ym ym3 = this.Sj;
            if (ym3 != null) {
                this.Ym = 0.0f;
                this.f20890aa = 0.0f;
                ym3.Sj(tkc, this.vS, this.TKC.sP());
                return true;
            }
        }
        return true;
    }

    @Override // com.bytedance.adsdk.ugeno.EjP.EjP.Sj
    public boolean Sj(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        Map<String, String> map = this.HiB;
        if (map != null) {
            this.sef = TextUtils.isEmpty(map.get("direction")) ? IntegrationConstants.NAVIGATION_BAR_ALL_ACTION : this.HiB.get("direction");
            this.Fmk = com.bytedance.adsdk.ugeno.Jcg.TKC.Sj(this.HiB.get("distance"), 0);
        }
        return Sj(this.sP, (MotionEvent) objArr[0]);
    }
}
