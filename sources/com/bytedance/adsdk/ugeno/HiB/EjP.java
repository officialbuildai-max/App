package com.bytedance.adsdk.ugeno.HiB;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
class EjP {
    static final /* synthetic */ boolean TKC = true;
    private final com.bytedance.adsdk.ugeno.HiB.Sj EjP;
    private boolean[] HiB;
    int[] Sj;
    long[] sP;
    private long[] vS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class Sj {
        List<TKC> Sj;
        int sP;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void Sj() {
            this.Sj = null;
            this.sP = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class sP implements Comparable<sP> {
        int Sj;
        int sP;

        private sP() {
        }

        @Override // java.lang.Comparable
        /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
        public int compareTo(sP sPVar) {
            int i11 = this.sP;
            int i12 = sPVar.sP;
            return i11 != i12 ? i11 - i12 : this.Sj - sPVar.Sj;
        }

        public String toString() {
            return "Order{order=" + this.sP + ", index=" + this.Sj + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EjP(com.bytedance.adsdk.ugeno.HiB.Sj sj2) {
        this.EjP = sj2;
    }

    private int EjP(com.bytedance.adsdk.ugeno.HiB.sP sPVar, boolean z10) {
        return z10 ? sPVar.Zq() : sPVar.uvD();
    }

    private int EjP(boolean z10) {
        return z10 ? this.EjP.getPaddingBottom() : this.EjP.getPaddingEnd();
    }

    private int HiB(com.bytedance.adsdk.ugeno.HiB.sP sPVar, boolean z10) {
        return z10 ? sPVar.sef() : sPVar.Fmk();
    }

    private int Sj(int i11, com.bytedance.adsdk.ugeno.HiB.sP sPVar, int i12) {
        com.bytedance.adsdk.ugeno.HiB.Sj sj2 = this.EjP;
        int Sj2 = sj2.Sj(i11, sj2.getPaddingLeft() + this.EjP.getPaddingRight() + sPVar.Fmk() + sPVar.Zq() + i12, sPVar.Sj());
        int size = View.MeasureSpec.getSize(Sj2);
        return size > sPVar.uA() ? View.MeasureSpec.makeMeasureSpec(sPVar.uA(), View.MeasureSpec.getMode(Sj2)) : size < sPVar.Jcg() ? View.MeasureSpec.makeMeasureSpec(sPVar.Jcg(), View.MeasureSpec.getMode(Sj2)) : Sj2;
    }

    private int Sj(View view, boolean z10) {
        return z10 ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    private int Sj(com.bytedance.adsdk.ugeno.HiB.sP sPVar, boolean z10) {
        return z10 ? sPVar.Sj() : sPVar.sP();
    }

    private int Sj(boolean z10) {
        return z10 ? this.EjP.getPaddingStart() : this.EjP.getPaddingTop();
    }

    private List<TKC> Sj(List<TKC> list, int i11, int i12) {
        int i13 = (i11 - i12) / 2;
        ArrayList arrayList = new ArrayList();
        TKC tkc = new TKC();
        tkc.Jcg = i13;
        int size = list.size();
        for (int i14 = 0; i14 < size; i14++) {
            if (i14 == 0) {
                arrayList.add(tkc);
            }
            arrayList.add(list.get(i14));
            if (i14 == list.size() - 1) {
                arrayList.add(tkc);
            }
        }
        return arrayList;
    }

    private void Sj(int i11, int i12, int i13, View view) {
        long[] jArr = this.sP;
        if (jArr != null) {
            jArr[i11] = sP(i12, i13);
        }
        long[] jArr2 = this.vS;
        if (jArr2 != null) {
            jArr2[i11] = sP(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    private void Sj(int i11, int i12, TKC tkc, int i13, int i14, boolean z10) {
        int i15;
        int i16;
        int i17;
        double d11;
        int i18;
        double d12;
        float f11 = tkc.TEQ;
        float f12 = 0.0f;
        if (f11 <= 0.0f || i13 < (i15 = tkc.HiB)) {
            return;
        }
        float f13 = (i13 - i15) / f11;
        tkc.HiB = i14 + tkc.vS;
        if (!z10) {
            tkc.Jcg = Integer.MIN_VALUE;
        }
        int i19 = 0;
        boolean z11 = false;
        int i20 = 0;
        float f14 = 0.0f;
        while (i19 < tkc.Dq) {
            int i21 = tkc.Zq + i19;
            View sP2 = this.EjP.sP(i21);
            if (sP2 == null || sP2.getVisibility() == 8) {
                i16 = i15;
            } else {
                com.bytedance.adsdk.ugeno.HiB.sP sPVar = (com.bytedance.adsdk.ugeno.HiB.sP) sP2.getLayoutParams();
                int flexDirection = this.EjP.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    int i22 = i15;
                    int measuredWidth = sP2.getMeasuredWidth();
                    long[] jArr = this.vS;
                    if (jArr != null) {
                        measuredWidth = Sj(jArr[i21]);
                    }
                    int measuredHeight = sP2.getMeasuredHeight();
                    long[] jArr2 = this.vS;
                    i16 = i22;
                    if (jArr2 != null) {
                        measuredHeight = sP(jArr2[i21]);
                    }
                    if (!this.HiB[i21] && sPVar.EjP() > 0.0f) {
                        float EjP = measuredWidth + (sPVar.EjP() * f13);
                        if (i19 == tkc.Dq - 1) {
                            EjP += f14;
                            f14 = 0.0f;
                        }
                        int round = Math.round(EjP);
                        if (round > sPVar.uA()) {
                            round = sPVar.uA();
                            this.HiB[i21] = true;
                            tkc.TEQ -= sPVar.EjP();
                            z11 = true;
                        } else {
                            f14 += EjP - round;
                            double d13 = f14;
                            if (d13 > 1.0d) {
                                round++;
                                d11 = d13 - 1.0d;
                            } else if (d13 < -1.0d) {
                                round--;
                                d11 = d13 + 1.0d;
                            }
                            f14 = (float) d11;
                        }
                        int sP3 = sP(i12, sPVar, tkc.Fmk);
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                        sP2.measure(makeMeasureSpec, sP3);
                        int measuredWidth2 = sP2.getMeasuredWidth();
                        int measuredHeight2 = sP2.getMeasuredHeight();
                        Sj(i21, makeMeasureSpec, sP3, sP2);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int max = Math.max(i20, measuredHeight + sPVar.sef() + sPVar.uvD() + this.EjP.Sj(sP2));
                    tkc.HiB += measuredWidth + sPVar.Fmk() + sPVar.Zq();
                    i17 = max;
                } else {
                    int measuredHeight3 = sP2.getMeasuredHeight();
                    long[] jArr3 = this.vS;
                    if (jArr3 != null) {
                        measuredHeight3 = sP(jArr3[i21]);
                    }
                    int measuredWidth3 = sP2.getMeasuredWidth();
                    long[] jArr4 = this.vS;
                    if (jArr4 != null) {
                        measuredWidth3 = Sj(jArr4[i21]);
                    }
                    if (this.HiB[i21] || sPVar.EjP() <= f12) {
                        i18 = i15;
                    } else {
                        float EjP2 = measuredHeight3 + (sPVar.EjP() * f13);
                        if (i19 == tkc.Dq - 1) {
                            EjP2 += f14;
                            f14 = f12;
                        }
                        int round2 = Math.round(EjP2);
                        if (round2 > sPVar.TEQ()) {
                            round2 = sPVar.TEQ();
                            this.HiB[i21] = true;
                            tkc.TEQ -= sPVar.EjP();
                            i18 = i15;
                            z11 = true;
                        } else {
                            f14 += EjP2 - round2;
                            i18 = i15;
                            double d14 = f14;
                            if (d14 > 1.0d) {
                                round2++;
                                d12 = d14 - 1.0d;
                            } else if (d14 < -1.0d) {
                                round2--;
                                d12 = d14 + 1.0d;
                            }
                            f14 = (float) d12;
                        }
                        int Sj2 = Sj(i11, sPVar, tkc.Fmk);
                        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                        sP2.measure(Sj2, makeMeasureSpec2);
                        measuredWidth3 = sP2.getMeasuredWidth();
                        int measuredHeight4 = sP2.getMeasuredHeight();
                        Sj(i21, Sj2, makeMeasureSpec2, sP2);
                        measuredHeight3 = measuredHeight4;
                    }
                    i17 = Math.max(i20, measuredWidth3 + sPVar.Fmk() + sPVar.Zq() + this.EjP.Sj(sP2));
                    tkc.HiB += measuredHeight3 + sPVar.sef() + sPVar.uvD();
                    i16 = i18;
                }
                tkc.Jcg = Math.max(tkc.Jcg, i17);
                i20 = i17;
            }
            i19++;
            i15 = i16;
            f12 = 0.0f;
        }
        int i23 = i15;
        if (!z11 || i23 == tkc.HiB) {
            return;
        }
        Sj(i11, i12, tkc, i13, i14, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void Sj(android.view.View r7, int r8) {
        /*
            r6 = this;
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            com.bytedance.adsdk.ugeno.HiB.sP r0 = (com.bytedance.adsdk.ugeno.HiB.sP) r0
            int r1 = r7.getMeasuredWidth()
            int r2 = r7.getMeasuredHeight()
            int r3 = r0.Jcg()
            r4 = 1
            if (r1 >= r3) goto L1b
            int r1 = r0.Jcg()
        L19:
            r3 = r4
            goto L27
        L1b:
            int r3 = r0.uA()
            if (r1 <= r3) goto L26
            int r1 = r0.uA()
            goto L19
        L26:
            r3 = 0
        L27:
            int r5 = r0.Dq()
            if (r2 >= r5) goto L32
            int r2 = r0.Dq()
            goto L3e
        L32:
            int r5 = r0.TEQ()
            if (r2 <= r5) goto L3d
            int r2 = r0.TEQ()
            goto L3e
        L3d:
            r4 = r3
        L3e:
            if (r4 == 0) goto L50
            r0 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r0)
            r7.measure(r1, r0)
            r6.Sj(r8, r1, r0, r7)
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.HiB.EjP.Sj(android.view.View, int):void");
    }

    private void Sj(View view, int i11, int i12) {
        com.bytedance.adsdk.ugeno.HiB.sP sPVar = (com.bytedance.adsdk.ugeno.HiB.sP) view.getLayoutParams();
        int min = Math.min(Math.max(((i11 - sPVar.sef()) - sPVar.uvD()) - this.EjP.Sj(view), sPVar.Dq()), sPVar.TEQ());
        long[] jArr = this.vS;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? Sj(jArr[i12]) : view.getMeasuredWidth(), 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        Sj(i12, makeMeasureSpec, makeMeasureSpec2, view);
    }

    private void Sj(CompoundButton compoundButton) {
        com.bytedance.adsdk.ugeno.HiB.sP sPVar = (com.bytedance.adsdk.ugeno.HiB.sP) compoundButton.getLayoutParams();
        int Jcg = sPVar.Jcg();
        int Dq = sPVar.Dq();
        Drawable Sj2 = com.bytedance.adsdk.ugeno.Jcg.HiB.Sj(compoundButton);
        int minimumWidth = Sj2 == null ? 0 : Sj2.getMinimumWidth();
        int minimumHeight = Sj2 != null ? Sj2.getMinimumHeight() : 0;
        if (Jcg == -1) {
            Jcg = minimumWidth;
        }
        sPVar.Sj(Jcg);
        if (Dq == -1) {
            Dq = minimumHeight;
        }
        sPVar.sP(Dq);
    }

    private void Sj(List<TKC> list, TKC tkc, int i11, int i12) {
        tkc.Fmk = i12;
        this.EjP.Sj(tkc);
        tkc.uvD = i11;
        list.add(tkc);
    }

    private boolean Sj(int i11, int i12, TKC tkc) {
        return i11 == i12 - 1 && tkc.sP() != 0;
    }

    private boolean Sj(View view, int i11, int i12, int i13, int i14, com.bytedance.adsdk.ugeno.HiB.sP sPVar, int i15, int i16, int i17) {
        if (this.EjP.getFlexWrap() == 0) {
            return false;
        }
        if (sPVar.Ym()) {
            return true;
        }
        if (i11 == 0) {
            return false;
        }
        int maxLine = this.EjP.getMaxLine();
        if (maxLine != -1 && maxLine <= i17 + 1) {
            return false;
        }
        int Sj2 = this.EjP.Sj(view, i15, i16);
        if (Sj2 > 0) {
            i14 += Sj2;
        }
        return i12 < i13 + i14;
    }

    private int[] Sj(int i11, List<sP> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i11];
        int i12 = 0;
        for (sP sPVar : list) {
            int i13 = sPVar.Sj;
            iArr[i12] = i13;
            sparseIntArray.append(i13, sPVar.sP);
            i12++;
        }
        return iArr;
    }

    private int TKC(com.bytedance.adsdk.ugeno.HiB.sP sPVar, boolean z10) {
        return z10 ? sPVar.Fmk() : sPVar.sef();
    }

    private int TKC(boolean z10) {
        return z10 ? this.EjP.getPaddingTop() : this.EjP.getPaddingStart();
    }

    private void TKC(int i11) {
        boolean[] zArr = this.HiB;
        if (zArr == null) {
            this.HiB = new boolean[Math.max(i11, 10)];
        } else if (zArr.length < i11) {
            this.HiB = new boolean[Math.max(zArr.length * 2, i11)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    private int sP(int i11, com.bytedance.adsdk.ugeno.HiB.sP sPVar, int i12) {
        com.bytedance.adsdk.ugeno.HiB.Sj sj2 = this.EjP;
        int sP2 = sj2.sP(i11, sj2.getPaddingTop() + this.EjP.getPaddingBottom() + sPVar.sef() + sPVar.uvD() + i12, sPVar.sP());
        int size = View.MeasureSpec.getSize(sP2);
        return size > sPVar.TEQ() ? View.MeasureSpec.makeMeasureSpec(sPVar.TEQ(), View.MeasureSpec.getMode(sP2)) : size < sPVar.Dq() ? View.MeasureSpec.makeMeasureSpec(sPVar.Dq(), View.MeasureSpec.getMode(sP2)) : sP2;
    }

    private int sP(View view, boolean z10) {
        return z10 ? view.getMeasuredHeight() : view.getMeasuredWidth();
    }

    private int sP(com.bytedance.adsdk.ugeno.HiB.sP sPVar, boolean z10) {
        return z10 ? sPVar.sP() : sPVar.Sj();
    }

    private int sP(boolean z10) {
        return z10 ? this.EjP.getPaddingEnd() : this.EjP.getPaddingBottom();
    }

    private List<sP> sP(int i11) {
        ArrayList arrayList = new ArrayList(i11);
        for (int i12 = 0; i12 < i11; i12++) {
            com.bytedance.adsdk.ugeno.HiB.sP sPVar = (com.bytedance.adsdk.ugeno.HiB.sP) this.EjP.Sj(i12).getLayoutParams();
            sP sPVar2 = new sP();
            sPVar2.sP = sPVar.TKC();
            sPVar2.Sj = i12;
            arrayList.add(sPVar2);
        }
        return arrayList;
    }

    private void sP(int i11, int i12, TKC tkc, int i13, int i14, boolean z10) {
        int i15;
        int i16;
        int i17;
        int i18 = tkc.HiB;
        float f11 = tkc.Ym;
        float f12 = 0.0f;
        if (f11 <= 0.0f || i13 > i18) {
            return;
        }
        float f13 = (i18 - i13) / f11;
        tkc.HiB = i14 + tkc.vS;
        if (!z10) {
            tkc.Jcg = Integer.MIN_VALUE;
        }
        int i19 = 0;
        boolean z11 = false;
        int i20 = 0;
        float f14 = 0.0f;
        while (i19 < tkc.Dq) {
            int i21 = tkc.Zq + i19;
            View sP2 = this.EjP.sP(i21);
            if (sP2 == null || sP2.getVisibility() == 8) {
                i15 = i18;
                i16 = i19;
            } else {
                com.bytedance.adsdk.ugeno.HiB.sP sPVar = (com.bytedance.adsdk.ugeno.HiB.sP) sP2.getLayoutParams();
                int flexDirection = this.EjP.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    i15 = i18;
                    int i22 = i19;
                    int measuredWidth = sP2.getMeasuredWidth();
                    long[] jArr = this.vS;
                    if (jArr != null) {
                        measuredWidth = Sj(jArr[i21]);
                    }
                    int measuredHeight = sP2.getMeasuredHeight();
                    long[] jArr2 = this.vS;
                    if (jArr2 != null) {
                        measuredHeight = sP(jArr2[i21]);
                    }
                    if (this.HiB[i21] || sPVar.HiB() <= 0.0f) {
                        i16 = i22;
                    } else {
                        float HiB = measuredWidth - (sPVar.HiB() * f13);
                        i16 = i22;
                        if (i16 == tkc.Dq - 1) {
                            HiB += f14;
                            f14 = 0.0f;
                        }
                        int round = Math.round(HiB);
                        if (round < sPVar.Jcg()) {
                            round = sPVar.Jcg();
                            this.HiB[i21] = true;
                            tkc.Ym -= sPVar.HiB();
                            z11 = true;
                        } else {
                            f14 += HiB - round;
                            double d11 = f14;
                            if (d11 > 1.0d) {
                                round++;
                                f14 -= 1.0f;
                            } else if (d11 < -1.0d) {
                                round--;
                                f14 += 1.0f;
                            }
                        }
                        int sP3 = sP(i12, sPVar, tkc.Fmk);
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                        sP2.measure(makeMeasureSpec, sP3);
                        int measuredWidth2 = sP2.getMeasuredWidth();
                        int measuredHeight2 = sP2.getMeasuredHeight();
                        Sj(i21, makeMeasureSpec, sP3, sP2);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int max = Math.max(i20, measuredHeight + sPVar.sef() + sPVar.uvD() + this.EjP.Sj(sP2));
                    tkc.HiB += measuredWidth + sPVar.Fmk() + sPVar.Zq();
                    i17 = max;
                } else {
                    int measuredHeight3 = sP2.getMeasuredHeight();
                    long[] jArr3 = this.vS;
                    if (jArr3 != null) {
                        measuredHeight3 = sP(jArr3[i21]);
                    }
                    int measuredWidth3 = sP2.getMeasuredWidth();
                    long[] jArr4 = this.vS;
                    if (jArr4 != null) {
                        measuredWidth3 = Sj(jArr4[i21]);
                    }
                    if (this.HiB[i21] || sPVar.HiB() <= f12) {
                        i15 = i18;
                        i16 = i19;
                    } else {
                        float HiB2 = measuredHeight3 - (sPVar.HiB() * f13);
                        if (i19 == tkc.Dq - 1) {
                            HiB2 += f14;
                            f14 = f12;
                        }
                        int round2 = Math.round(HiB2);
                        if (round2 < sPVar.Dq()) {
                            round2 = sPVar.Dq();
                            this.HiB[i21] = true;
                            tkc.Ym -= sPVar.HiB();
                            i15 = i18;
                            i16 = i19;
                            z11 = true;
                        } else {
                            f14 += HiB2 - round2;
                            i15 = i18;
                            i16 = i19;
                            double d12 = f14;
                            if (d12 > 1.0d) {
                                round2++;
                                f14 -= 1.0f;
                            } else if (d12 < -1.0d) {
                                round2--;
                                f14 += 1.0f;
                            }
                        }
                        int Sj2 = Sj(i11, sPVar, tkc.Fmk);
                        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                        sP2.measure(Sj2, makeMeasureSpec2);
                        measuredWidth3 = sP2.getMeasuredWidth();
                        int measuredHeight4 = sP2.getMeasuredHeight();
                        Sj(i21, Sj2, makeMeasureSpec2, sP2);
                        measuredHeight3 = measuredHeight4;
                    }
                    i17 = Math.max(i20, measuredWidth3 + sPVar.Fmk() + sPVar.Zq() + this.EjP.Sj(sP2));
                    tkc.HiB += measuredHeight3 + sPVar.sef() + sPVar.uvD();
                }
                tkc.Jcg = Math.max(tkc.Jcg, i17);
                i20 = i17;
            }
            i19 = i16 + 1;
            i18 = i15;
            f12 = 0.0f;
        }
        int i23 = i18;
        if (!z11 || i23 == tkc.HiB) {
            return;
        }
        sP(i11, i12, tkc, i13, i14, true);
    }

    private void sP(View view, int i11, int i12) {
        com.bytedance.adsdk.ugeno.HiB.sP sPVar = (com.bytedance.adsdk.ugeno.HiB.sP) view.getLayoutParams();
        int min = Math.min(Math.max(((i11 - sPVar.Fmk()) - sPVar.Zq()) - this.EjP.Sj(view), sPVar.Jcg()), sPVar.uA());
        long[] jArr = this.vS;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? sP(jArr[i12]) : view.getMeasuredHeight(), 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        Sj(i12, makeMeasureSpec2, makeMeasureSpec, view);
    }

    private int vS(com.bytedance.adsdk.ugeno.HiB.sP sPVar, boolean z10) {
        return z10 ? sPVar.uvD() : sPVar.Zq();
    }

    int Sj(long j11) {
        return (int) j11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Sj() {
        Sj(0);
    }

    void Sj(int i11) {
        View sP2;
        if (i11 >= this.EjP.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.EjP.getFlexDirection();
        if (this.EjP.getAlignItems() != 4) {
            for (TKC tkc : this.EjP.getFlexLinesInternal()) {
                for (Integer num : tkc.sef) {
                    View sP3 = this.EjP.sP(num.intValue());
                    if (flexDirection == 0 || flexDirection == 1) {
                        Sj(sP3, tkc.Jcg, num.intValue());
                    } else {
                        if (flexDirection != 2 && flexDirection != 3) {
                            throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                        }
                        sP(sP3, tkc.Jcg, num.intValue());
                    }
                }
            }
            return;
        }
        int[] iArr = this.Sj;
        List<TKC> flexLinesInternal = this.EjP.getFlexLinesInternal();
        int size = flexLinesInternal.size();
        for (int i12 = iArr != null ? iArr[i11] : 0; i12 < size; i12++) {
            TKC tkc2 = flexLinesInternal.get(i12);
            int i13 = tkc2.Dq;
            for (int i14 = 0; i14 < i13; i14++) {
                int i15 = tkc2.Zq + i14;
                if (i14 < this.EjP.getFlexItemCount() && (sP2 = this.EjP.sP(i15)) != null && sP2.getVisibility() != 8) {
                    com.bytedance.adsdk.ugeno.HiB.sP sPVar = (com.bytedance.adsdk.ugeno.HiB.sP) sP2.getLayoutParams();
                    if (sPVar.vS() == -1 || sPVar.vS() == 4) {
                        if (flexDirection == 0 || flexDirection == 1) {
                            Sj(sP2, tkc2.Jcg, i15);
                        } else {
                            if (flexDirection != 2 && flexDirection != 3) {
                                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                            }
                            sP(sP2, tkc2.Jcg, i15);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Sj(int i11, int i12) {
        Sj(i11, i12, 0);
    }

    void Sj(int i11, int i12, int i13) {
        int size;
        int paddingLeft;
        int paddingRight;
        TKC(this.EjP.getFlexItemCount());
        if (i13 >= this.EjP.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.EjP.getFlexDirection();
        int flexDirection2 = this.EjP.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(i11);
            size = View.MeasureSpec.getSize(i11);
            int largestMainSize = this.EjP.getLargestMainSize();
            if (mode != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.EjP.getPaddingLeft();
            paddingRight = this.EjP.getPaddingRight();
        } else {
            if (flexDirection2 != 2 && flexDirection2 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
            }
            int mode2 = View.MeasureSpec.getMode(i12);
            size = View.MeasureSpec.getSize(i12);
            if (mode2 != 1073741824) {
                size = this.EjP.getLargestMainSize();
            }
            paddingLeft = this.EjP.getPaddingTop();
            paddingRight = this.EjP.getPaddingBottom();
        }
        int i14 = paddingLeft + paddingRight;
        int[] iArr = this.Sj;
        List<TKC> flexLinesInternal = this.EjP.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i15 = iArr != null ? iArr[i13] : 0; i15 < size2; i15++) {
            TKC tkc = flexLinesInternal.get(i15);
            int i16 = tkc.HiB;
            if (i16 < size && tkc.dNu) {
                Sj(i11, i12, tkc, size, i14, false);
            } else if (i16 > size && tkc.TzV) {
                sP(i11, i12, tkc, size, i14, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Sj(View view, TKC tkc, int i11, int i12, int i13, int i14) {
        com.bytedance.adsdk.ugeno.HiB.sP sPVar = (com.bytedance.adsdk.ugeno.HiB.sP) view.getLayoutParams();
        int alignItems = this.EjP.getAlignItems();
        if (sPVar.vS() != -1) {
            alignItems = sPVar.vS();
        }
        int i15 = tkc.Jcg;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.EjP.getFlexWrap() == 2) {
                    view.layout(i11, (i12 - i15) + view.getMeasuredHeight() + sPVar.sef(), i13, (i14 - i15) + view.getMeasuredHeight() + sPVar.sef());
                    return;
                } else {
                    int i16 = i12 + i15;
                    view.layout(i11, (i16 - view.getMeasuredHeight()) - sPVar.uvD(), i13, i16 - sPVar.uvD());
                    return;
                }
            }
            if (alignItems == 2) {
                int measuredHeight = (((i15 - view.getMeasuredHeight()) + sPVar.sef()) - sPVar.uvD()) / 2;
                if (this.EjP.getFlexWrap() != 2) {
                    int i17 = i12 + measuredHeight;
                    view.layout(i11, i17, i13, view.getMeasuredHeight() + i17);
                    return;
                } else {
                    int i18 = i12 - measuredHeight;
                    view.layout(i11, i18, i13, view.getMeasuredHeight() + i18);
                    return;
                }
            }
            if (alignItems == 3) {
                if (this.EjP.getFlexWrap() != 2) {
                    int max = Math.max(tkc.f20893aa - view.getBaseline(), sPVar.sef());
                    view.layout(i11, i12 + max, i13, i14 + max);
                    return;
                } else {
                    int max2 = Math.max((tkc.f20893aa - view.getMeasuredHeight()) + view.getBaseline(), sPVar.uvD());
                    view.layout(i11, i12 - max2, i13, i14 - max2);
                    return;
                }
            }
            if (alignItems != 4) {
                return;
            }
        }
        if (this.EjP.getFlexWrap() != 2) {
            view.layout(i11, i12 + sPVar.sef(), i13, i14 + sPVar.sef());
        } else {
            view.layout(i11, i12 - sPVar.uvD(), i13, i14 - sPVar.uvD());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Sj(View view, TKC tkc, boolean z10, int i11, int i12, int i13, int i14) {
        com.bytedance.adsdk.ugeno.HiB.sP sPVar = (com.bytedance.adsdk.ugeno.HiB.sP) view.getLayoutParams();
        int alignItems = this.EjP.getAlignItems();
        if (sPVar.vS() != -1) {
            alignItems = sPVar.vS();
        }
        int i15 = tkc.Jcg;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (z10) {
                    view.layout((i11 - i15) + view.getMeasuredWidth() + sPVar.Fmk(), i12, (i13 - i15) + view.getMeasuredWidth() + sPVar.Fmk(), i14);
                    return;
                } else {
                    view.layout(((i11 + i15) - view.getMeasuredWidth()) - sPVar.Zq(), i12, ((i13 + i15) - view.getMeasuredWidth()) - sPVar.Zq(), i14);
                    return;
                }
            }
            if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i15 - view.getMeasuredWidth()) + com.bytedance.adsdk.ugeno.Jcg.vS.Sj(marginLayoutParams)) - com.bytedance.adsdk.ugeno.Jcg.vS.sP(marginLayoutParams)) / 2;
                if (z10) {
                    view.layout(i11 - measuredWidth, i12, i13 - measuredWidth, i14);
                    return;
                } else {
                    view.layout(i11 + measuredWidth, i12, i13 + measuredWidth, i14);
                    return;
                }
            }
            if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (z10) {
            view.layout(i11 - sPVar.Zq(), i12, i13 - sPVar.Zq(), i14);
        } else {
            view.layout(i11 + sPVar.Fmk(), i12, i13 + sPVar.Fmk(), i14);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Sj(Sj sj2, int i11, int i12) {
        Sj(sj2, i11, i12, Integer.MAX_VALUE, 0, -1, (List<TKC>) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void Sj(Sj sj2, int i11, int i12, int i13, int i14, int i15, List<TKC> list) {
        int i16;
        Sj sj3;
        int i17;
        int i18;
        int i19;
        List<TKC> list2;
        int i20;
        int i21;
        View view;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30 = i11;
        int i31 = i12;
        int i32 = i15;
        boolean Sj2 = this.EjP.Sj();
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        List<TKC> arrayList = list == null ? new ArrayList() : list;
        sj2.Sj = arrayList;
        int i33 = i32 == -1 ? 1 : 0;
        int Sj3 = Sj(Sj2);
        int sP2 = sP(Sj2);
        int TKC2 = TKC(Sj2);
        int EjP = EjP(Sj2);
        TKC tkc = new TKC();
        int i34 = i14;
        tkc.Zq = i34;
        int i35 = sP2 + Sj3;
        tkc.HiB = i35;
        int flexItemCount = this.EjP.getFlexItemCount();
        int i36 = i33;
        int i37 = Integer.MIN_VALUE;
        int i38 = 0;
        int i39 = 0;
        int i40 = 0;
        while (true) {
            if (i34 >= flexItemCount) {
                i16 = i39;
                sj3 = sj2;
                break;
            }
            View sP3 = this.EjP.sP(i34);
            if (sP3 != null) {
                if (sP3.getVisibility() != 8) {
                    if (sP3 instanceof CompoundButton) {
                        Sj((CompoundButton) sP3);
                    }
                    com.bytedance.adsdk.ugeno.HiB.sP sPVar = (com.bytedance.adsdk.ugeno.HiB.sP) sP3.getLayoutParams();
                    int i41 = flexItemCount;
                    if (sPVar.vS() == 4) {
                        tkc.sef.add(Integer.valueOf(i34));
                    }
                    int Sj4 = Sj(sPVar, Sj2);
                    if (sPVar.aa() != -1.0f && mode == 1073741824) {
                        Sj4 = Math.round(size * sPVar.aa());
                    }
                    if (Sj2) {
                        int Sj5 = this.EjP.Sj(i30, i35 + TKC(sPVar, true) + EjP(sPVar, true), Sj4);
                        i17 = size;
                        i18 = mode;
                        int sP4 = this.EjP.sP(i31, TKC2 + EjP + HiB(sPVar, true) + vS(sPVar, true) + i38, sP(sPVar, true));
                        sP3.measure(Sj5, sP4);
                        Sj(i34, Sj5, sP4, sP3);
                        i19 = Sj5;
                    } else {
                        i17 = size;
                        i18 = mode;
                        int Sj6 = this.EjP.Sj(i31, TKC2 + EjP + HiB(sPVar, false) + vS(sPVar, false) + i38, sP(sPVar, false));
                        int sP5 = this.EjP.sP(i30, TKC(sPVar, false) + i35 + EjP(sPVar, false), Sj4);
                        sP3.measure(Sj6, sP5);
                        Sj(i34, Sj6, sP5, sP3);
                        i19 = sP5;
                    }
                    Sj(sP3, i34);
                    i39 = View.combineMeasuredStates(i39, sP3.getMeasuredState());
                    int i42 = i38;
                    int i43 = i35;
                    TKC tkc2 = tkc;
                    int i44 = i34;
                    list2 = arrayList;
                    int i45 = i19;
                    if (Sj(sP3, i18, i17, tkc.HiB, EjP(sPVar, Sj2) + Sj(sP3, Sj2) + TKC(sPVar, Sj2), sPVar, i44, i40, arrayList.size())) {
                        if (tkc2.sP() > 0) {
                            Sj(list2, tkc2, i44 > 0 ? i44 - 1 : 0, i42);
                            i38 = tkc2.Jcg + i42;
                        } else {
                            i38 = i42;
                        }
                        if (!Sj2) {
                            i20 = i12;
                            i21 = i44;
                            view = sP3;
                            i22 = -1;
                            if (sPVar.Sj() == -1) {
                                com.bytedance.adsdk.ugeno.HiB.Sj sj4 = this.EjP;
                                view.measure(sj4.Sj(i20, sj4.getPaddingLeft() + this.EjP.getPaddingRight() + sPVar.Fmk() + sPVar.Zq() + i38, sPVar.Sj()), i45);
                                Sj(view, i21);
                            }
                        } else if (sPVar.sP() == -1) {
                            com.bytedance.adsdk.ugeno.HiB.Sj sj5 = this.EjP;
                            i20 = i12;
                            i22 = -1;
                            view = sP3;
                            view.measure(i45, sj5.sP(i20, sj5.getPaddingTop() + this.EjP.getPaddingBottom() + sPVar.sef() + sPVar.uvD() + i38, sPVar.sP()));
                            i21 = i44;
                            Sj(view, i21);
                        } else {
                            i20 = i12;
                            i21 = i44;
                            view = sP3;
                            i22 = -1;
                        }
                        tkc = new TKC();
                        i24 = 1;
                        tkc.Dq = 1;
                        i23 = i43;
                        tkc.HiB = i23;
                        tkc.Zq = i21;
                        i26 = Integer.MIN_VALUE;
                        i25 = 0;
                    } else {
                        i20 = i12;
                        i21 = i44;
                        view = sP3;
                        i22 = -1;
                        tkc = tkc2;
                        i23 = i43;
                        i24 = 1;
                        tkc.Dq++;
                        i25 = i40 + 1;
                        i38 = i42;
                        i26 = i37;
                    }
                    tkc.dNu = (tkc.dNu ? 1 : 0) | (sPVar.EjP() != 0.0f ? i24 : 0);
                    tkc.TzV = (tkc.TzV ? 1 : 0) | (sPVar.HiB() != 0.0f ? i24 : 0);
                    int[] iArr = this.Sj;
                    if (iArr != null) {
                        iArr[i21] = list2.size();
                    }
                    tkc.HiB += Sj(view, Sj2) + TKC(sPVar, Sj2) + EjP(sPVar, Sj2);
                    tkc.TEQ += sPVar.EjP();
                    tkc.Ym += sPVar.HiB();
                    this.EjP.Sj(view, i21, i25, tkc);
                    int max = Math.max(i26, sP(view, Sj2) + HiB(sPVar, Sj2) + vS(sPVar, Sj2) + this.EjP.Sj(view));
                    tkc.Jcg = Math.max(tkc.Jcg, max);
                    if (Sj2) {
                        if (this.EjP.getFlexWrap() != 2) {
                            tkc.f20893aa = Math.max(tkc.f20893aa, view.getBaseline() + sPVar.sef());
                        } else {
                            tkc.f20893aa = Math.max(tkc.f20893aa, (view.getMeasuredHeight() - view.getBaseline()) + sPVar.uvD());
                        }
                    }
                    i27 = i41;
                    if (Sj(i21, i27, tkc)) {
                        Sj(list2, tkc, i21, i38);
                        i38 += tkc.Jcg;
                    }
                    i28 = i15;
                    if (i28 == i22 || list2.size() <= 0 || list2.get(list2.size() - i24).uvD < i28 || i21 < i28 || i36 != 0) {
                        i29 = i13;
                    } else {
                        i38 = -tkc.Sj();
                        i29 = i13;
                        i36 = i24;
                    }
                    if (i38 > i29 && i36 != 0) {
                        sj3 = sj2;
                        i16 = i39;
                        break;
                    }
                    i40 = i25;
                    i37 = max;
                    i30 = i11;
                    i34 = i21 + 1;
                    flexItemCount = i27;
                    i31 = i20;
                    i35 = i23;
                    arrayList = list2;
                    size = i17;
                    mode = i18;
                    i32 = i28;
                } else {
                    tkc.uA++;
                    tkc.Dq++;
                    if (Sj(i34, flexItemCount, tkc)) {
                        Sj(arrayList, tkc, i34, i38);
                    }
                }
            } else if (Sj(i34, flexItemCount, tkc)) {
                Sj(arrayList, tkc, i34, i38);
            }
            i17 = size;
            i18 = mode;
            i20 = i31;
            i28 = i32;
            i23 = i35;
            list2 = arrayList;
            i27 = flexItemCount;
            i21 = i34;
            i30 = i11;
            i34 = i21 + 1;
            flexItemCount = i27;
            i31 = i20;
            i35 = i23;
            arrayList = list2;
            size = i17;
            mode = i18;
            i32 = i28;
        }
        sj3.sP = i16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] Sj(SparseIntArray sparseIntArray) {
        int flexItemCount = this.EjP.getFlexItemCount();
        return Sj(flexItemCount, sP(flexItemCount), sparseIntArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public int[] Sj(View view, int i11, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.EjP.getFlexItemCount();
        List<sP> sP2 = sP(flexItemCount);
        sP sPVar = new sP();
        if (view == null || !(layoutParams instanceof com.bytedance.adsdk.ugeno.HiB.sP)) {
            sPVar.sP = 1;
        } else {
            sPVar.sP = ((com.bytedance.adsdk.ugeno.HiB.sP) layoutParams).TKC();
        }
        if (i11 == -1 || i11 == flexItemCount) {
            sPVar.Sj = flexItemCount;
        } else if (i11 < this.EjP.getFlexItemCount()) {
            sPVar.Sj = i11;
            while (i11 < flexItemCount) {
                sP2.get(i11).Sj++;
                i11++;
            }
        } else {
            sPVar.Sj = flexItemCount;
        }
        sP2.add(sPVar);
        return Sj(flexItemCount + 1, sP2, sparseIntArray);
    }

    int sP(long j11) {
        return (int) (j11 >> 32);
    }

    long sP(int i11, int i12) {
        return (i11 & 4294967295L) | (i12 << 32);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sP(int i11, int i12, int i13) {
        int i14;
        int i15;
        int flexDirection = this.EjP.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode = View.MeasureSpec.getMode(i12);
            int size = View.MeasureSpec.getSize(i12);
            i14 = mode;
            i15 = size;
        } else {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
            }
            i14 = View.MeasureSpec.getMode(i11);
            i15 = View.MeasureSpec.getSize(i11);
        }
        List<TKC> flexLinesInternal = this.EjP.getFlexLinesInternal();
        if (i14 == 1073741824) {
            int sumOfCrossSize = this.EjP.getSumOfCrossSize() + i13;
            int i16 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).Jcg = i15 - i13;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.EjP.getAlignContent();
                if (alignContent == 1) {
                    int i17 = i15 - sumOfCrossSize;
                    TKC tkc = new TKC();
                    tkc.Jcg = i17;
                    flexLinesInternal.add(0, tkc);
                    return;
                }
                if (alignContent == 2) {
                    this.EjP.setFlexLines(Sj(flexLinesInternal, i15, sumOfCrossSize));
                    return;
                }
                if (alignContent == 3) {
                    if (sumOfCrossSize < i15) {
                        float size2 = (i15 - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                        ArrayList arrayList = new ArrayList();
                        int size3 = flexLinesInternal.size();
                        float f11 = 0.0f;
                        while (i16 < size3) {
                            arrayList.add(flexLinesInternal.get(i16));
                            if (i16 != flexLinesInternal.size() - 1) {
                                TKC tkc2 = new TKC();
                                if (i16 == flexLinesInternal.size() - 2) {
                                    tkc2.Jcg = Math.round(f11 + size2);
                                    f11 = 0.0f;
                                } else {
                                    tkc2.Jcg = Math.round(size2);
                                }
                                int i18 = tkc2.Jcg;
                                f11 += size2 - i18;
                                if (f11 > 1.0f) {
                                    tkc2.Jcg = i18 + 1;
                                    f11 -= 1.0f;
                                } else if (f11 < -1.0f) {
                                    tkc2.Jcg = i18 - 1;
                                    f11 += 1.0f;
                                }
                                arrayList.add(tkc2);
                            }
                            i16++;
                        }
                        this.EjP.setFlexLines(arrayList);
                        return;
                    }
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= i15) {
                        this.EjP.setFlexLines(Sj(flexLinesInternal, i15, sumOfCrossSize));
                        return;
                    }
                    int size4 = (i15 - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    TKC tkc3 = new TKC();
                    tkc3.Jcg = size4;
                    for (TKC tkc4 : flexLinesInternal) {
                        arrayList2.add(tkc3);
                        arrayList2.add(tkc4);
                        arrayList2.add(tkc3);
                    }
                    this.EjP.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < i15) {
                    float size5 = (i15 - sumOfCrossSize) / flexLinesInternal.size();
                    int size6 = flexLinesInternal.size();
                    float f12 = 0.0f;
                    while (i16 < size6) {
                        TKC tkc5 = flexLinesInternal.get(i16);
                        float f13 = tkc5.Jcg + size5;
                        if (i16 == flexLinesInternal.size() - 1) {
                            f13 += f12;
                            f12 = 0.0f;
                        }
                        int round = Math.round(f13);
                        f12 += f13 - round;
                        if (f12 > 1.0f) {
                            round++;
                            f12 -= 1.0f;
                        } else if (f12 < -1.0f) {
                            round--;
                            f12 += 1.0f;
                        }
                        tkc5.Jcg = round;
                        i16++;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sP(Sj sj2, int i11, int i12) {
        Sj(sj2, i12, i11, Integer.MAX_VALUE, 0, -1, (List<TKC>) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean sP(SparseIntArray sparseIntArray) {
        int flexItemCount = this.EjP.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i11 = 0; i11 < flexItemCount; i11++) {
            View Sj2 = this.EjP.Sj(i11);
            if (Sj2 != null && ((com.bytedance.adsdk.ugeno.HiB.sP) Sj2.getLayoutParams()).TKC() != sparseIntArray.get(i11)) {
                return true;
            }
        }
        return false;
    }
}
