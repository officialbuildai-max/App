package com.bytedance.adsdk.sP.TKC.TKC;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.LongSparseArray;
import com.bytedance.adsdk.sP.TKC.TKC.HiB;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class sP extends Sj {
    private final List<Sj> Dq;
    private com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> Jcg;
    private final RectF TEQ;
    private final Paint Ym;

    /* renamed from: aa, reason: collision with root package name */
    private boolean f20868aa;
    private final RectF uA;

    /* renamed from: com.bytedance.adsdk.sP.TKC.TKC.sP$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Sj;

        static {
            int[] iArr = new int[HiB.sP.values().length];
            Sj = iArr;
            try {
                iArr[HiB.sP.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Sj[HiB.sP.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public sP(com.bytedance.adsdk.sP.uA uAVar, HiB hiB, List<HiB> list, com.bytedance.adsdk.sP.Jcg jcg, Context context) {
        super(uAVar, hiB);
        int i11;
        Sj sj2;
        HiB.sP aa2;
        int i12;
        this.Dq = new ArrayList();
        this.uA = new RectF();
        this.TEQ = new RectF();
        this.Ym = new Paint();
        this.f20868aa = true;
        com.bytedance.adsdk.sP.TKC.Sj.sP dx2 = hiB.dx();
        if (dx2 != null) {
            com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> Sj = dx2.Sj();
            this.Jcg = Sj;
            Sj(Sj);
            this.Jcg.Sj(this);
        } else {
            this.Jcg = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(jcg.Fmk().size());
        int size = list.size() - 1;
        Sj sj3 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            HiB hiB2 = list.get(size);
            Sj Sj2 = Sj.Sj(this, hiB2, uAVar, jcg, context);
            if (Sj2 != null) {
                longSparseArray.put(Sj2.sP().HiB(), Sj2);
                if (sj3 != null) {
                    sj3.Sj(Sj2);
                    sj3 = null;
                } else {
                    this.Dq.add(0, Sj2);
                    if (hiB2 != null && (aa2 = hiB2.aa()) != null && ((i12 = AnonymousClass1.Sj[aa2.ordinal()]) == 1 || i12 == 2)) {
                        sj3 = Sj2;
                    }
                }
            }
            size--;
        }
        for (i11 = 0; i11 < longSparseArray.size(); i11++) {
            Sj sj4 = (Sj) longSparseArray.get(longSparseArray.keyAt(i11));
            if (sj4 != null && (sj2 = (Sj) longSparseArray.get(sj4.sP().Fmk())) != null) {
                sj4.sP(sj2);
            }
        }
    }

    @Override // com.bytedance.adsdk.sP.TKC.TKC.Sj
    public void Sj(float f11) {
        super.Sj(f11);
        if (this.Jcg != null) {
            f11 = ((this.Jcg.Jcg().floatValue() * this.TKC.Sj().aa()) - this.TKC.Sj().vS()) / (this.sP.wE().dNu() + 0.01f);
        }
        if (this.Jcg == null) {
            f11 -= this.TKC.TKC();
        }
        if (this.TKC.sP() != 0.0f && !"__container".equals(this.TKC.vS())) {
            f11 /= this.TKC.sP();
        }
        for (int size = this.Dq.size() - 1; size >= 0; size--) {
            this.Dq.get(size).Sj(f11);
        }
    }

    @Override // com.bytedance.adsdk.sP.TKC.TKC.Sj, com.bytedance.adsdk.sP.Sj.Sj.HiB
    public void Sj(RectF rectF, Matrix matrix, boolean z10) {
        super.Sj(rectF, matrix, z10);
        for (int size = this.Dq.size() - 1; size >= 0; size--) {
            this.uA.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.Dq.get(size).Sj(this.uA, this.Sj, true);
            rectF.union(this.uA);
        }
    }

    @Override // com.bytedance.adsdk.sP.TKC.TKC.Sj
    public void Sj(boolean z10) {
        super.Sj(z10);
        Iterator<Sj> it = this.Dq.iterator();
        while (it.hasNext()) {
            it.next().Sj(z10);
        }
    }

    public List<Sj> aa() {
        return this.Dq;
    }

    @Override // com.bytedance.adsdk.sP.TKC.TKC.Sj
    public void sP(Canvas canvas, Matrix matrix, int i11) {
        super.sP(canvas, matrix, i11);
        com.bytedance.adsdk.sP.HiB.Sj("CompositionLayer#draw");
        this.TEQ.set(0.0f, 0.0f, this.TKC.Dq(), this.TKC.uA());
        matrix.mapRect(this.TEQ);
        boolean z10 = this.sP.uA() && this.Dq.size() > 1 && i11 != 255;
        if (z10) {
            this.Ym.setAlpha(i11);
            com.bytedance.adsdk.sP.vS.vS.Sj(canvas, this.TEQ, this.Ym);
        } else {
            canvas.save();
        }
        if (z10) {
            i11 = 255;
        }
        for (int size = this.Dq.size() - 1; size >= 0; size--) {
            if (((this.f20868aa || !"__container".equals(this.TKC.vS())) && !this.TEQ.isEmpty()) ? canvas.clipRect(this.TEQ) : true) {
                this.Dq.get(size).Sj(canvas, matrix, i11);
            }
        }
        canvas.restore();
        com.bytedance.adsdk.sP.HiB.sP("CompositionLayer#draw");
    }

    public void sP(boolean z10) {
        this.f20868aa = z10;
    }
}
