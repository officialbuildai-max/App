package com.bytedance.adsdk.sP.Sj.Sj;

import android.annotation.TargetApi;
import android.graphics.Path;
import com.bytedance.adsdk.sP.TKC.sP.uA;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@TargetApi(19)
/* loaded from: classes2.dex */
public class aa implements Fmk, TEQ {
    private final String EjP;
    private final com.bytedance.adsdk.sP.TKC.sP.uA vS;
    private final Path Sj = new Path();
    private final Path sP = new Path();
    private final Path TKC = new Path();
    private final List<Fmk> HiB = new ArrayList();

    /* renamed from: com.bytedance.adsdk.sP.Sj.Sj.aa$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Sj;

        static {
            int[] iArr = new int[uA.Sj.values().length];
            Sj = iArr;
            try {
                iArr[uA.Sj.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Sj[uA.Sj.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Sj[uA.Sj.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Sj[uA.Sj.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                Sj[uA.Sj.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public aa(com.bytedance.adsdk.sP.TKC.sP.uA uAVar) {
        this.EjP = uAVar.Sj();
        this.vS = uAVar;
    }

    private void Sj() {
        for (int i11 = 0; i11 < this.HiB.size(); i11++) {
            this.TKC.addPath(this.HiB.get(i11).EjP());
        }
    }

    @TargetApi(19)
    private void Sj(Path.Op op2) {
        this.sP.reset();
        this.Sj.reset();
        for (int size = this.HiB.size() - 1; size > 0; size--) {
            Fmk fmk = this.HiB.get(size);
            if (fmk instanceof EjP) {
                EjP ejP = (EjP) fmk;
                List<Fmk> sP = ejP.sP();
                for (int size2 = sP.size() - 1; size2 >= 0; size2--) {
                    Path EjP = sP.get(size2).EjP();
                    EjP.transform(ejP.TKC());
                    this.sP.addPath(EjP);
                }
            } else {
                this.sP.addPath(fmk.EjP());
            }
        }
        Fmk fmk2 = this.HiB.get(0);
        if (fmk2 instanceof EjP) {
            EjP ejP2 = (EjP) fmk2;
            List<Fmk> sP2 = ejP2.sP();
            for (int i11 = 0; i11 < sP2.size(); i11++) {
                Path EjP2 = sP2.get(i11).EjP();
                EjP2.transform(ejP2.TKC());
                this.Sj.addPath(EjP2);
            }
        } else {
            this.Sj.set(fmk2.EjP());
        }
        this.TKC.op(this.Sj, this.sP, op2);
    }

    @Override // com.bytedance.adsdk.sP.Sj.Sj.Fmk
    public Path EjP() {
        this.TKC.reset();
        if (this.vS.TKC()) {
            return this.TKC;
        }
        int i11 = AnonymousClass1.Sj[this.vS.sP().ordinal()];
        if (i11 == 1) {
            Sj();
        } else if (i11 == 2) {
            Sj(Path.Op.UNION);
        } else if (i11 == 3) {
            Sj(Path.Op.REVERSE_DIFFERENCE);
        } else if (i11 == 4) {
            Sj(Path.Op.INTERSECT);
        } else if (i11 == 5) {
            Sj(Path.Op.XOR);
        }
        return this.TKC;
    }

    @Override // com.bytedance.adsdk.sP.Sj.Sj.TKC
    public void Sj(List<TKC> list, List<TKC> list2) {
        for (int i11 = 0; i11 < this.HiB.size(); i11++) {
            this.HiB.get(i11).Sj(list, list2);
        }
    }

    @Override // com.bytedance.adsdk.sP.Sj.Sj.TEQ
    public void Sj(ListIterator<TKC> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            TKC previous = listIterator.previous();
            if (previous instanceof Fmk) {
                this.HiB.add((Fmk) previous);
                listIterator.remove();
            }
        }
    }
}
