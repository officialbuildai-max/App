package com.bytedance.adsdk.ugeno.HiB;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.HiB.EjP;
import com.bytedance.adsdk.ugeno.Jcg.Jcg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class HiB extends ViewGroup implements com.bytedance.adsdk.ugeno.HiB.Sj {
    private Drawable Dq;
    private int EjP;
    private int[] Fmk;
    private int HiB;
    private Drawable Jcg;
    private int Sj;
    private int TEQ;
    private int TKC;
    private EjP.Sj TzV;
    private int Ym;
    private EjP Zq;

    /* renamed from: aa, reason: collision with root package name */
    private int f20892aa;
    private com.bytedance.adsdk.ugeno.EjP dNu;
    private int sP;
    private SparseIntArray sef;
    private int uA;
    private List<TKC> uvD;
    private int vS;

    /* loaded from: classes2.dex */
    public static class Sj extends ViewGroup.MarginLayoutParams implements sP {
        public static final Parcelable.Creator<Sj> CREATOR = new Parcelable.Creator<Sj>() { // from class: com.bytedance.adsdk.ugeno.HiB.HiB.Sj.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
            public Sj createFromParcel(Parcel parcel) {
                return new Sj(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
            public Sj[] newArray(int i11) {
                return new Sj[i11];
            }
        };
        private int Dq;
        private int EjP;
        private float HiB;
        private int Jcg;
        private int Sj;
        private boolean TEQ;
        private float TKC;
        private float sP;
        private int uA;
        private int vS;

        public Sj(int i11, int i12) {
            super(new ViewGroup.LayoutParams(i11, i12));
            this.Sj = 1;
            this.sP = 0.0f;
            this.TKC = 0.0f;
            this.EjP = -1;
            this.HiB = -1.0f;
            this.vS = -1;
            this.Jcg = -1;
            this.Dq = 16777215;
            this.uA = 16777215;
        }

        protected Sj(Parcel parcel) {
            super(0, 0);
            this.Sj = 1;
            this.sP = 0.0f;
            this.TKC = 0.0f;
            this.EjP = -1;
            this.HiB = -1.0f;
            this.vS = -1;
            this.Jcg = -1;
            this.Dq = 16777215;
            this.uA = 16777215;
            this.Sj = parcel.readInt();
            this.sP = parcel.readFloat();
            this.TKC = parcel.readFloat();
            this.EjP = parcel.readInt();
            this.HiB = parcel.readFloat();
            this.vS = parcel.readInt();
            this.Jcg = parcel.readInt();
            this.Dq = parcel.readInt();
            this.uA = parcel.readInt();
            this.TEQ = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }

        public Sj(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.Sj = 1;
            this.sP = 0.0f;
            this.TKC = 0.0f;
            this.EjP = -1;
            this.HiB = -1.0f;
            this.vS = -1;
            this.Jcg = -1;
            this.Dq = 16777215;
            this.uA = 16777215;
        }

        public Sj(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.Sj = 1;
            this.sP = 0.0f;
            this.TKC = 0.0f;
            this.EjP = -1;
            this.HiB = -1.0f;
            this.vS = -1;
            this.Jcg = -1;
            this.Dq = 16777215;
            this.uA = 16777215;
        }

        public Sj(Sj sj2) {
            super((ViewGroup.MarginLayoutParams) sj2);
            this.Sj = 1;
            this.sP = 0.0f;
            this.TKC = 0.0f;
            this.EjP = -1;
            this.HiB = -1.0f;
            this.vS = -1;
            this.Jcg = -1;
            this.Dq = 16777215;
            this.uA = 16777215;
            this.Sj = sj2.Sj;
            this.sP = sj2.sP;
            this.TKC = sj2.TKC;
            this.EjP = sj2.EjP;
            this.HiB = sj2.HiB;
            this.vS = sj2.vS;
            this.Jcg = sj2.Jcg;
            this.Dq = sj2.Dq;
            this.uA = sj2.uA;
            this.TEQ = sj2.TEQ;
        }

        @Override // com.bytedance.adsdk.ugeno.HiB.sP
        public int Dq() {
            return this.Jcg;
        }

        @Override // com.bytedance.adsdk.ugeno.HiB.sP
        public float EjP() {
            return this.sP;
        }

        public void EjP(int i11) {
            this.EjP = i11;
        }

        @Override // com.bytedance.adsdk.ugeno.HiB.sP
        public int Fmk() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.HiB.sP
        public float HiB() {
            return this.TKC;
        }

        @Override // com.bytedance.adsdk.ugeno.HiB.sP
        public int Jcg() {
            return this.vS;
        }

        @Override // com.bytedance.adsdk.ugeno.HiB.sP
        public int Sj() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        public void Sj(float f11) {
            this.sP = f11;
        }

        @Override // com.bytedance.adsdk.ugeno.HiB.sP
        public void Sj(int i11) {
            this.vS = i11;
        }

        @Override // com.bytedance.adsdk.ugeno.HiB.sP
        public int TEQ() {
            return this.uA;
        }

        @Override // com.bytedance.adsdk.ugeno.HiB.sP
        public int TKC() {
            return this.Sj;
        }

        public void TKC(float f11) {
            this.HiB = f11;
        }

        public void TKC(int i11) {
            this.Sj = i11;
        }

        @Override // com.bytedance.adsdk.ugeno.HiB.sP
        public boolean Ym() {
            return this.TEQ;
        }

        @Override // com.bytedance.adsdk.ugeno.HiB.sP
        public int Zq() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.HiB.sP
        public float aa() {
            return this.HiB;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.bytedance.adsdk.ugeno.HiB.sP
        public int sP() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        public void sP(float f11) {
            this.TKC = f11;
        }

        @Override // com.bytedance.adsdk.ugeno.HiB.sP
        public void sP(int i11) {
            this.Jcg = i11;
        }

        @Override // com.bytedance.adsdk.ugeno.HiB.sP
        public int sef() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.HiB.sP
        public int uA() {
            return this.Dq;
        }

        @Override // com.bytedance.adsdk.ugeno.HiB.sP
        public int uvD() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.HiB.sP
        public int vS() {
            return this.EjP;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(this.Sj);
            parcel.writeFloat(this.sP);
            parcel.writeFloat(this.TKC);
            parcel.writeInt(this.EjP);
            parcel.writeFloat(this.HiB);
            parcel.writeInt(this.vS);
            parcel.writeInt(this.Jcg);
            parcel.writeInt(this.Dq);
            parcel.writeInt(this.uA);
            parcel.writeByte(this.TEQ ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }
    }

    public HiB(Context context) {
        super(context, null);
        this.vS = -1;
        this.Zq = new EjP(this);
        this.uvD = new ArrayList();
        this.TzV = new EjP.Sj();
    }

    private boolean EjP(int i11) {
        if (i11 >= 0 && i11 < this.uvD.size()) {
            if (HiB(i11)) {
                return Sj() ? (this.uA & 1) != 0 : (this.TEQ & 1) != 0;
            }
            if (Sj()) {
                return (this.uA & 2) != 0;
            }
            if ((this.TEQ & 2) != 0) {
                return true;
            }
        }
        return false;
    }

    private boolean EjP(int i11, int i12) {
        return HiB(i11, i12) ? Sj() ? (this.TEQ & 1) != 0 : (this.uA & 1) != 0 : Sj() ? (this.TEQ & 2) != 0 : (this.uA & 2) != 0;
    }

    private boolean HiB(int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            if (this.uvD.get(i12).sP() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean HiB(int i11, int i12) {
        for (int i13 = 1; i13 <= i12; i13++) {
            View TKC = TKC(i11 - i13);
            if (TKC != null && TKC.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private void Sj(int i11, int i12) {
        if (this.sef == null) {
            this.sef = new SparseIntArray(getChildCount());
        }
        if (this.Zq.sP(this.sef)) {
            this.Fmk = this.Zq.Sj(this.sef);
        }
        int i13 = this.Sj;
        if (i13 == 0 || i13 == 1) {
            sP(i11, i12);
        } else if (i13 == 2 || i13 == 3) {
            TKC(i11, i12);
        } else {
            throw new IllegalStateException("Invalid value for the flex direction is set: " + this.Sj);
        }
    }

    private void Sj(int i11, int i12, int i13, int i14) {
        int sumOfCrossSize;
        int largestMainSize;
        int resolveSizeAndState;
        int resolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i12);
        int mode2 = View.MeasureSpec.getMode(i13);
        int size2 = View.MeasureSpec.getSize(i13);
        if (i11 == 0 || i11 == 1) {
            sumOfCrossSize = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            largestMainSize = getLargestMainSize();
        } else {
            if (i11 != 2 && i11 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(i11)));
            }
            sumOfCrossSize = getLargestMainSize();
            largestMainSize = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                i14 = View.combineMeasuredStates(i14, 16777216);
            } else {
                size = largestMainSize;
            }
            resolveSizeAndState = View.resolveSizeAndState(size, i12, i14);
        } else if (mode == 0) {
            resolveSizeAndState = View.resolveSizeAndState(largestMainSize, i12, i14);
        } else {
            if (mode != 1073741824) {
                throw new IllegalStateException("Unknown width mode is set: ".concat(String.valueOf(mode)));
            }
            if (size < largestMainSize) {
                i14 = View.combineMeasuredStates(i14, 16777216);
            }
            resolveSizeAndState = View.resolveSizeAndState(size, i12, i14);
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < sumOfCrossSize) {
                i14 = View.combineMeasuredStates(i14, 256);
            } else {
                size2 = sumOfCrossSize;
            }
            resolveSizeAndState2 = View.resolveSizeAndState(size2, i13, i14);
        } else if (mode2 == 0) {
            resolveSizeAndState2 = View.resolveSizeAndState(sumOfCrossSize, i13, i14);
        } else {
            if (mode2 != 1073741824) {
                throw new IllegalStateException("Unknown height mode is set: ".concat(String.valueOf(mode2)));
            }
            if (size2 < sumOfCrossSize) {
                i14 = View.combineMeasuredStates(i14, 256);
            }
            resolveSizeAndState2 = View.resolveSizeAndState(size2, i13, i14);
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    private void Sj(Canvas canvas, int i11, int i12, int i13) {
        Drawable drawable = this.Dq;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i11, i12, this.f20892aa + i11, i13 + i12);
        this.Dq.draw(canvas);
    }

    private void Sj(Canvas canvas, boolean z10, boolean z11) {
        int paddingLeft = getPaddingLeft();
        int max = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.uvD.size();
        for (int i11 = 0; i11 < size; i11++) {
            TKC tkc = this.uvD.get(i11);
            for (int i12 = 0; i12 < tkc.Dq; i12++) {
                int i13 = tkc.Zq + i12;
                View TKC = TKC(i13);
                if (TKC != null && TKC.getVisibility() != 8) {
                    Sj sj2 = (Sj) TKC.getLayoutParams();
                    if (EjP(i13, i12)) {
                        Sj(canvas, z10 ? TKC.getRight() + ((ViewGroup.MarginLayoutParams) sj2).rightMargin : (TKC.getLeft() - ((ViewGroup.MarginLayoutParams) sj2).leftMargin) - this.f20892aa, tkc.sP, tkc.Jcg);
                    }
                    if (i12 == tkc.Dq - 1 && (this.TEQ & 4) > 0) {
                        Sj(canvas, z10 ? (TKC.getLeft() - ((ViewGroup.MarginLayoutParams) sj2).leftMargin) - this.f20892aa : TKC.getRight() + ((ViewGroup.MarginLayoutParams) sj2).rightMargin, tkc.sP, tkc.Jcg);
                    }
                }
            }
            if (EjP(i11)) {
                sP(canvas, paddingLeft, z11 ? tkc.EjP : tkc.sP - this.Ym, max);
            }
            if (vS(i11) && (this.uA & 4) > 0) {
                sP(canvas, paddingLeft, z11 ? tkc.sP - this.Ym : tkc.EjP, max);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0181  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void Sj(boolean r29, int r30, int r31, int r32, int r33) {
        /*
            Method dump skipped, instructions count: 556
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.HiB.HiB.Sj(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x017b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void Sj(boolean r30, boolean r31, int r32, int r33, int r34, int r35) {
        /*
            Method dump skipped, instructions count: 538
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.HiB.HiB.Sj(boolean, boolean, int, int, int, int):void");
    }

    private void TKC(int i11, int i12) {
        this.uvD.clear();
        this.TzV.Sj();
        this.Zq.sP(this.TzV, i11, i12);
        this.uvD = this.TzV.Sj;
        this.Zq.Sj(i11, i12);
        this.Zq.sP(i11, i12, getPaddingLeft() + getPaddingRight());
        this.Zq.Sj();
        Sj(this.Sj, i11, i12, this.TzV.sP);
    }

    private void sP() {
        if (this.Jcg == null && this.Dq == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private void sP(int i11, int i12) {
        this.uvD.clear();
        this.TzV.Sj();
        this.Zq.Sj(this.TzV, i11, i12);
        this.uvD = this.TzV.Sj;
        this.Zq.Sj(i11, i12);
        if (this.EjP == 3) {
            for (TKC tkc : this.uvD) {
                int i13 = Integer.MIN_VALUE;
                for (int i14 = 0; i14 < tkc.Dq; i14++) {
                    View TKC = TKC(tkc.Zq + i14);
                    if (TKC != null && TKC.getVisibility() != 8) {
                        Sj sj2 = (Sj) TKC.getLayoutParams();
                        i13 = this.sP != 2 ? Math.max(i13, TKC.getMeasuredHeight() + Math.max(tkc.f20893aa - TKC.getBaseline(), ((ViewGroup.MarginLayoutParams) sj2).topMargin) + ((ViewGroup.MarginLayoutParams) sj2).bottomMargin) : Math.max(i13, TKC.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) sj2).topMargin + Math.max((tkc.f20893aa - TKC.getMeasuredHeight()) + TKC.getBaseline(), ((ViewGroup.MarginLayoutParams) sj2).bottomMargin));
                    }
                }
                tkc.Jcg = i13;
            }
        }
        this.Zq.sP(i11, i12, getPaddingTop() + getPaddingBottom());
        this.Zq.Sj();
        Sj(this.Sj, i11, i12, this.TzV.sP);
    }

    private void sP(Canvas canvas, int i11, int i12, int i13) {
        Drawable drawable = this.Jcg;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i11, i12, i13 + i11, this.Ym + i12);
        this.Jcg.draw(canvas);
    }

    private void sP(Canvas canvas, boolean z10, boolean z11) {
        int paddingTop = getPaddingTop();
        int max = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.uvD.size();
        for (int i11 = 0; i11 < size; i11++) {
            TKC tkc = this.uvD.get(i11);
            for (int i12 = 0; i12 < tkc.Dq; i12++) {
                int i13 = tkc.Zq + i12;
                View TKC = TKC(i13);
                if (TKC != null && TKC.getVisibility() != 8) {
                    Sj sj2 = (Sj) TKC.getLayoutParams();
                    if (EjP(i13, i12)) {
                        sP(canvas, tkc.Sj, z11 ? TKC.getBottom() + ((ViewGroup.MarginLayoutParams) sj2).bottomMargin : (TKC.getTop() - ((ViewGroup.MarginLayoutParams) sj2).topMargin) - this.Ym, tkc.Jcg);
                    }
                    if (i12 == tkc.Dq - 1 && (this.uA & 4) > 0) {
                        sP(canvas, tkc.Sj, z11 ? (TKC.getTop() - ((ViewGroup.MarginLayoutParams) sj2).topMargin) - this.Ym : TKC.getBottom() + ((ViewGroup.MarginLayoutParams) sj2).bottomMargin, tkc.Jcg);
                    }
                }
            }
            if (EjP(i11)) {
                Sj(canvas, z10 ? tkc.TKC : tkc.Sj - this.f20892aa, paddingTop, max);
            }
            if (vS(i11) && (this.TEQ & 4) > 0) {
                Sj(canvas, z10 ? tkc.Sj - this.f20892aa : tkc.TKC, paddingTop, max);
            }
        }
    }

    private boolean vS(int i11) {
        if (i11 >= 0 && i11 < this.uvD.size()) {
            for (int i12 = i11 + 1; i12 < this.uvD.size(); i12++) {
                if (this.uvD.get(i12).sP() > 0) {
                    return false;
                }
            }
            if (Sj()) {
                return (this.uA & 4) != 0;
            }
            if ((this.TEQ & 4) != 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.adsdk.ugeno.HiB.Sj
    public int Sj(int i11, int i12, int i13) {
        return ViewGroup.getChildMeasureSpec(i11, i12, i13);
    }

    @Override // com.bytedance.adsdk.ugeno.HiB.Sj
    public int Sj(View view) {
        return 0;
    }

    @Override // com.bytedance.adsdk.ugeno.HiB.Sj
    public int Sj(View view, int i11, int i12) {
        int i13;
        int i14;
        if (Sj()) {
            i13 = EjP(i11, i12) ? this.f20892aa : 0;
            if ((this.TEQ & 4) <= 0) {
                return i13;
            }
            i14 = this.f20892aa;
        } else {
            i13 = EjP(i11, i12) ? this.Ym : 0;
            if ((this.uA & 4) <= 0) {
                return i13;
            }
            i14 = this.Ym;
        }
        return i13 + i14;
    }

    @Override // com.bytedance.adsdk.ugeno.HiB.Sj
    public View Sj(int i11) {
        return getChildAt(i11);
    }

    @Override // com.bytedance.adsdk.ugeno.HiB.Sj
    public void Sj(View view, int i11, int i12, TKC tkc) {
        if (EjP(i11, i12)) {
            if (Sj()) {
                int i13 = tkc.HiB;
                int i14 = this.f20892aa;
                tkc.HiB = i13 + i14;
                tkc.vS += i14;
                return;
            }
            int i15 = tkc.HiB;
            int i16 = this.Ym;
            tkc.HiB = i15 + i16;
            tkc.vS += i16;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.HiB.Sj
    public void Sj(TKC tkc) {
        if (Sj()) {
            if ((this.TEQ & 4) > 0) {
                int i11 = tkc.HiB;
                int i12 = this.f20892aa;
                tkc.HiB = i11 + i12;
                tkc.vS += i12;
                return;
            }
            return;
        }
        if ((this.uA & 4) > 0) {
            int i13 = tkc.HiB;
            int i14 = this.Ym;
            tkc.HiB = i13 + i14;
            tkc.vS += i14;
        }
    }

    public void Sj(com.bytedance.adsdk.ugeno.sP.TKC tkc) {
        this.dNu = tkc;
    }

    @Override // com.bytedance.adsdk.ugeno.HiB.Sj
    public boolean Sj() {
        int i11 = this.Sj;
        return i11 == 0 || i11 == 1;
    }

    public View TKC(int i11) {
        if (i11 < 0) {
            return null;
        }
        int[] iArr = this.Fmk;
        if (i11 >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i11]);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        if (this.sef == null) {
            this.sef = new SparseIntArray(getChildCount());
        }
        this.Fmk = this.Zq.Sj(view, i11, layoutParams, this.sef);
        super.addView(view, i11, layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof Sj;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof Sj ? new Sj((Sj) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new Sj((ViewGroup.MarginLayoutParams) layoutParams) : new Sj(layoutParams);
    }

    @Override // com.bytedance.adsdk.ugeno.HiB.Sj
    public int getAlignContent() {
        return this.HiB;
    }

    @Override // com.bytedance.adsdk.ugeno.HiB.Sj
    public int getAlignItems() {
        return this.EjP;
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.Jcg;
    }

    public Drawable getDividerDrawableVertical() {
        return this.Dq;
    }

    @Override // com.bytedance.adsdk.ugeno.HiB.Sj
    public int getFlexDirection() {
        return this.Sj;
    }

    @Override // com.bytedance.adsdk.ugeno.HiB.Sj
    public int getFlexItemCount() {
        return getChildCount();
    }

    public List<TKC> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.uvD.size());
        for (TKC tkc : this.uvD) {
            if (tkc.sP() != 0) {
                arrayList.add(tkc);
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.adsdk.ugeno.HiB.Sj
    public List<TKC> getFlexLinesInternal() {
        return this.uvD;
    }

    @Override // com.bytedance.adsdk.ugeno.HiB.Sj
    public int getFlexWrap() {
        return this.sP;
    }

    public int getJustifyContent() {
        return this.TKC;
    }

    @Override // com.bytedance.adsdk.ugeno.HiB.Sj
    public int getLargestMainSize() {
        Iterator<TKC> it = this.uvD.iterator();
        int i11 = Integer.MIN_VALUE;
        while (it.hasNext()) {
            i11 = Math.max(i11, it.next().HiB);
        }
        return i11;
    }

    @Override // com.bytedance.adsdk.ugeno.HiB.Sj
    public int getMaxLine() {
        return this.vS;
    }

    public int getShowDividerHorizontal() {
        return this.uA;
    }

    public int getShowDividerVertical() {
        return this.TEQ;
    }

    @Override // com.bytedance.adsdk.ugeno.HiB.Sj
    public int getSumOfCrossSize() {
        int size = this.uvD.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            TKC tkc = this.uvD.get(i12);
            if (EjP(i12)) {
                i11 += Sj() ? this.Ym : this.f20892aa;
            }
            if (vS(i12)) {
                i11 += Sj() ? this.Ym : this.f20892aa;
            }
            i11 += tkc.Jcg;
        }
        return i11;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.adsdk.ugeno.EjP ejP = this.dNu;
        if (ejP != null) {
            ejP.Jcg();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.adsdk.ugeno.EjP ejP = this.dNu;
        if (ejP != null) {
            ejP.Dq();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.Dq == null && this.Jcg == null) {
            return;
        }
        if (this.uA == 0 && this.TEQ == 0) {
            return;
        }
        int Sj2 = Jcg.Sj(this);
        int i11 = this.Sj;
        if (i11 == 0) {
            Sj(canvas, Sj2 == 1, this.sP == 2);
            return;
        }
        if (i11 == 1) {
            Sj(canvas, Sj2 != 1, this.sP == 2);
            return;
        }
        if (i11 == 2) {
            boolean z10 = Sj2 == 1;
            if (this.sP == 2) {
                z10 = !z10;
            }
            sP(canvas, z10, false);
            return;
        }
        if (i11 != 3) {
            return;
        }
        boolean z11 = Sj2 == 1;
        if (this.sP == 2) {
            z11 = !z11;
        }
        sP(canvas, z11, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        boolean z11;
        com.bytedance.adsdk.ugeno.EjP ejP = this.dNu;
        if (ejP != null) {
            ejP.vS();
        }
        int Sj2 = Jcg.Sj(this);
        int i15 = this.Sj;
        if (i15 == 0) {
            Sj(Sj2 == 1, i11, i12, i13, i14);
        } else if (i15 == 1) {
            Sj(Sj2 != 1, i11, i12, i13, i14);
        } else if (i15 == 2) {
            z11 = Sj2 == 1;
            Sj(this.sP == 2 ? !z11 : z11, false, i11, i12, i13, i14);
        } else {
            if (i15 != 3) {
                throw new IllegalStateException("Invalid flex direction is set: " + this.Sj);
            }
            z11 = Sj2 == 1;
            Sj(this.sP == 2 ? !z11 : z11, true, i11, i12, i13, i14);
        }
        com.bytedance.adsdk.ugeno.EjP ejP2 = this.dNu;
        if (ejP2 != null) {
            ejP2.Sj(i11, i12, i13, i14);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i11, int i12) {
        com.bytedance.adsdk.ugeno.EjP ejP = this.dNu;
        if (ejP != null) {
            int[] Sj2 = ejP.Sj(i11, i12);
            Sj(Sj2[0], Sj2[1]);
        } else {
            Sj(i11, i12);
        }
        com.bytedance.adsdk.ugeno.EjP ejP2 = this.dNu;
        if (ejP2 != null) {
            ejP2.HiB();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        com.bytedance.adsdk.ugeno.EjP ejP = this.dNu;
        if (ejP != null) {
            ejP.sP(i11, i12, i13, i14);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
    }

    @Override // com.bytedance.adsdk.ugeno.HiB.Sj
    public int sP(int i11, int i12, int i13) {
        return ViewGroup.getChildMeasureSpec(i11, i12, i13);
    }

    @Override // com.bytedance.adsdk.ugeno.HiB.Sj
    public View sP(int i11) {
        return TKC(i11);
    }

    public void setAlignContent(int i11) {
        if (this.HiB != i11) {
            this.HiB = i11;
            requestLayout();
        }
    }

    public void setAlignItems(int i11) {
        if (this.EjP != i11) {
            this.EjP = i11;
            requestLayout();
        }
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(Drawable drawable) {
        if (drawable == this.Jcg) {
            return;
        }
        this.Jcg = drawable;
        if (drawable != null) {
            this.Ym = drawable.getIntrinsicHeight();
        } else {
            this.Ym = 0;
        }
        sP();
        requestLayout();
    }

    public void setDividerDrawableVertical(Drawable drawable) {
        if (drawable == this.Dq) {
            return;
        }
        this.Dq = drawable;
        if (drawable != null) {
            this.f20892aa = drawable.getIntrinsicWidth();
        } else {
            this.f20892aa = 0;
        }
        sP();
        requestLayout();
    }

    public void setFlexDirection(int i11) {
        if (this.Sj != i11) {
            this.Sj = i11;
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.HiB.Sj
    public void setFlexLines(List<TKC> list) {
        this.uvD = list;
    }

    public void setFlexWrap(int i11) {
        if (this.sP != i11) {
            this.sP = i11;
            requestLayout();
        }
    }

    public void setJustifyContent(int i11) {
        if (this.TKC != i11) {
            this.TKC = i11;
            requestLayout();
        }
    }

    public void setMaxLine(int i11) {
        if (this.vS != i11) {
            this.vS = i11;
            requestLayout();
        }
    }

    public void setShowDivider(int i11) {
        setShowDividerVertical(i11);
        setShowDividerHorizontal(i11);
    }

    public void setShowDividerHorizontal(int i11) {
        if (i11 != this.uA) {
            this.uA = i11;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int i11) {
        if (i11 != this.TEQ) {
            this.TEQ = i11;
            requestLayout();
        }
    }
}
