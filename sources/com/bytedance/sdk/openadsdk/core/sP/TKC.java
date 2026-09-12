package com.bytedance.sdk.openadsdk.core.sP;

import android.graphics.Point;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.bytedance.sdk.openadsdk.core.settings.uA;

/* loaded from: classes2.dex */
public abstract class TKC implements View.OnClickListener, View.OnTouchListener {
    private static float EjP = 0.0f;
    private static long HiB = 0;
    protected static int LD = 8;
    private static float Sj;
    private static float TKC;
    private static float sP;
    protected View JcM;

    /* renamed from: dx, reason: collision with root package name */
    protected float f21173dx = -1.0f;
    protected float zR = -1.0f;

    /* renamed from: ib, reason: collision with root package name */
    protected float f21174ib = -1.0f;
    protected float kF = -1.0f;
    protected long uP = -1;
    protected long wE = -1;
    protected int ley = -1;
    protected int LqL = -1024;
    protected int Yf = -1;
    protected boolean fF = true;
    public SparseArray<Sj> WMZ = new SparseArray<>();
    private int vS = 0;
    private int Jcg = 0;

    /* loaded from: classes3.dex */
    public static class Sj {
        public long EjP;
        public int Sj;
        public double TKC;
        public double sP;

        public Sj(int i11, double d11, double d12, long j11) {
            this.Sj = i11;
            this.sP = d11;
            this.TKC = d12;
            this.EjP = j11;
        }
    }

    static {
        if (dNu.Sj() != null) {
            LD = dNu.sP();
        }
        Sj = 0.0f;
        sP = 0.0f;
        TKC = 0.0f;
        EjP = 0.0f;
        HiB = 0L;
    }

    private boolean Sj(View view, Point point) {
        int i11;
        int i12;
        int i13;
        int i14;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i15 = 0; i15 < viewGroup.getChildCount(); i15++) {
                View childAt = viewGroup.getChildAt(i15);
                if (sP.TKC(childAt)) {
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    return view.isShown() && (i11 = point.x) >= (i12 = iArr[0]) && i11 <= i12 + childAt.getWidth() && (i13 = point.y) >= (i14 = iArr[1]) && i13 <= i14 + childAt.getHeight();
                }
                if (Sj(childAt, point)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean Jcg() {
        return this.fF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void Sj(View view, float f11, float f12, float f13, float f14, SparseArray<Sj> sparseArray, boolean z10);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (uA.Sj()) {
            Sj(view, this.f21173dx, this.zR, this.f21174ib, this.kF, this.WMZ, this.fF);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006f, code lost:
    
        if (com.bytedance.sdk.openadsdk.core.sP.TKC.EjP <= r3) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r14, android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.sP.TKC.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
