package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Ym;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* loaded from: classes2.dex */
public class TKC {
    private int EjP;
    private int HiB;
    Paint Sj;
    private int vS;
    Path sP = new Path();
    Path TKC = new Path();

    public TKC() {
        Paint paint = new Paint();
        this.Sj = paint;
        paint.setAntiAlias(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void Sj(android.graphics.Canvas r22, com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation r23, android.view.View r24) {
        /*
            Method dump skipped, instructions count: 460
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.animation.view.TKC.Sj(android.graphics.Canvas, com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation, android.view.View):void");
    }

    public void Sj(View view, float f11) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) (this.vS * f11);
        view.setTranslationX((r1 - r6) / 2);
        if (view instanceof Ym) {
            int i11 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i11 >= viewGroup.getChildCount()) {
                    break;
                }
                viewGroup.getChildAt(i11).setTranslationX((-(this.vS - layoutParams.width)) / 2);
                i11++;
            }
        }
        view.setLayoutParams(layoutParams);
    }

    public void Sj(View view, int i11, int i12) {
        String str;
        this.EjP = i11 / 2;
        this.HiB = i12 / 2;
        if (this.vS == 0 && view.getLayoutParams().width > 0) {
            this.vS = view.getLayoutParams().width;
        }
        try {
            str = (String) view.getTag(2097610710);
            try {
                this.TKC.addRoundRect(new RectF(0.0f, 0.0f, i11, i12), i12 / 2, i12 / 2, Path.Direction.CW);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            str = "";
        }
        if (TtmlNode.RIGHT.equals(str)) {
            view.setPivotX(this.EjP * 2);
            view.setPivotY(this.HiB);
        } else if (TtmlNode.LEFT.equals(str)) {
            view.setPivotX(0.0f);
            view.setPivotY(this.HiB);
        } else {
            view.setPivotX(this.EjP);
            view.setPivotY(this.HiB);
        }
    }
}
