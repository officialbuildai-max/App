package com.mbridge.msdk.video.dynview.widget;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.mbridge.msdk.video.dynview.moffer.b;
import com.mbridge.msdk.video.dynview.moffer.d;

/* loaded from: classes5.dex */
public class MBridgeRelativeLayout extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private d f39197a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f39198b;

    /* renamed from: c, reason: collision with root package name */
    private AnimatorSet f39199c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f39200d;

    /* renamed from: e, reason: collision with root package name */
    private b f39201e;

    public MBridgeRelativeLayout(Context context) {
        super(context);
    }

    public MBridgeRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBridgeRelativeLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        AnimatorSet animatorSet = this.f39199c;
        if (animatorSet != null) {
            try {
                animatorSet.start();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        d dVar;
        super.onDetachedFromWindow();
        if (!this.f39198b && (dVar = this.f39197a) != null) {
            this.f39198b = true;
            dVar.a();
        }
        AnimatorSet animatorSet = this.f39199c;
        if (animatorSet != null) {
            try {
                animatorSet.cancel();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i11) {
        b bVar;
        super.onVisibilityChanged(view, i11);
        if (!(view instanceof MBridgeRelativeLayout) || i11 != 0 || (bVar = this.f39201e) == null || this.f39200d) {
            return;
        }
        this.f39200d = true;
        bVar.a();
    }

    public void setAnimatorSet(AnimatorSet animatorSet) {
        this.f39199c = animatorSet;
    }

    public void setMoreOfferCacheReportCallBack(b bVar) {
        this.f39201e = bVar;
    }

    public void setMoreOfferShowFailedCallBack(d dVar) {
        this.f39197a = dVar;
    }
}
