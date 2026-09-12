package com.bytedance.adsdk.sP.TKC.TKC;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.LongSparseArray;
import com.bytedance.adsdk.sP.Sj.sP.Zq;
import com.bytedance.adsdk.sP.TKC.Sj.Ym;
import com.bytedance.adsdk.sP.TKC.sP;
import com.bytedance.adsdk.sP.TKC.sP.uvD;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class uA extends com.bytedance.adsdk.sP.TKC.TKC.Sj {
    private final RectF Dq;
    private final LongSparseArray<String> Fmk;
    private final StringBuilder Jcg;
    private com.bytedance.adsdk.sP.Sj.sP.Sj<Integer, Integer> RiZ;
    private final Paint TEQ;
    private com.bytedance.adsdk.sP.Sj.sP.Sj<Integer, Integer> TzV;
    private final Paint Ym;
    private final Zq Zq;

    /* renamed from: aa, reason: collision with root package name */
    private final Map<com.bytedance.adsdk.sP.TKC.EjP, List<com.bytedance.adsdk.sP.Sj.Sj.EjP>> f20869aa;
    private final com.bytedance.adsdk.sP.Jcg dNu;

    /* renamed from: dx, reason: collision with root package name */
    private com.bytedance.adsdk.sP.Sj.sP.Sj<Integer, Integer> f20870dx;

    /* renamed from: ib, reason: collision with root package name */
    private com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> f20871ib;
    private com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> kF;
    private com.bytedance.adsdk.sP.Sj.sP.Sj<Typeface, Typeface> ley;
    private com.bytedance.adsdk.sP.Sj.sP.Sj<Integer, Integer> sU;
    private final List<Sj> sef;
    private final Matrix uA;
    private com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> uP;
    private final com.bytedance.adsdk.sP.uA uvD;
    private com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> wE;
    private com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> zR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.adsdk.sP.TKC.TKC.uA$3, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] Sj;

        static {
            int[] iArr = new int[sP.Sj.values().length];
            Sj = iArr;
            try {
                iArr[sP.Sj.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Sj[sP.Sj.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Sj[sP.Sj.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class Sj {
        private String Sj;
        private float sP;

        private Sj() {
            this.Sj = "";
            this.sP = 0.0f;
        }

        void Sj(String str, float f11) {
            this.Sj = str;
            this.sP = f11;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public uA(com.bytedance.adsdk.sP.uA uAVar, HiB hiB) {
        super(uAVar, hiB);
        com.bytedance.adsdk.sP.TKC.Sj.sP sPVar;
        com.bytedance.adsdk.sP.TKC.Sj.sP sPVar2;
        com.bytedance.adsdk.sP.TKC.Sj.Sj sj2;
        com.bytedance.adsdk.sP.TKC.Sj.Sj sj3;
        this.Jcg = new StringBuilder(2);
        this.Dq = new RectF();
        this.uA = new Matrix();
        int i11 = 1;
        this.TEQ = new Paint(i11) { // from class: com.bytedance.adsdk.sP.TKC.TKC.uA.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.Ym = new Paint(i11) { // from class: com.bytedance.adsdk.sP.TKC.TKC.uA.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.f20869aa = new HashMap();
        this.Fmk = new LongSparseArray<>();
        this.sef = new ArrayList();
        this.uvD = uAVar;
        this.dNu = hiB.Sj();
        Zq Sj2 = hiB.RiZ().Sj();
        this.Zq = Sj2;
        Sj2.Sj(this);
        Sj(Sj2);
        Ym sU = hiB.sU();
        if (sU != null && (sj3 = sU.Sj) != null) {
            com.bytedance.adsdk.sP.Sj.sP.Sj<Integer, Integer> Sj3 = sj3.Sj();
            this.TzV = Sj3;
            Sj3.Sj(this);
            Sj(this.TzV);
        }
        if (sU != null && (sj2 = sU.sP) != null) {
            com.bytedance.adsdk.sP.Sj.sP.Sj<Integer, Integer> Sj4 = sj2.Sj();
            this.sU = Sj4;
            Sj4.Sj(this);
            Sj(this.sU);
        }
        if (sU != null && (sPVar2 = sU.TKC) != null) {
            com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> Sj5 = sPVar2.Sj();
            this.zR = Sj5;
            Sj5.Sj(this);
            Sj(this.zR);
        }
        if (sU == null || (sPVar = sU.EjP) == null) {
            return;
        }
        com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> Sj6 = sPVar.Sj();
        this.kF = Sj6;
        Sj6.Sj(this);
        Sj(this.kF);
    }

    private Typeface Sj(com.bytedance.adsdk.sP.TKC.TKC tkc) {
        Typeface Jcg;
        com.bytedance.adsdk.sP.Sj.sP.Sj<Typeface, Typeface> sj2 = this.ley;
        if (sj2 != null && (Jcg = sj2.Jcg()) != null) {
            return Jcg;
        }
        Typeface Sj2 = this.uvD.Sj(tkc);
        return Sj2 != null ? Sj2 : tkc.EjP();
    }

    private String Sj(String str, int i11) {
        int codePointAt = str.codePointAt(i11);
        int charCount = Character.charCount(codePointAt) + i11;
        while (charCount < str.length()) {
            int codePointAt2 = str.codePointAt(charCount);
            if (!TKC(codePointAt2)) {
                break;
            }
            charCount += Character.charCount(codePointAt2);
            codePointAt = (codePointAt * 31) + codePointAt2;
        }
        long j11 = codePointAt;
        if (this.Fmk.indexOfKey(j11) >= 0) {
            return this.Fmk.get(j11);
        }
        this.Jcg.setLength(0);
        while (i11 < charCount) {
            int codePointAt3 = str.codePointAt(i11);
            this.Jcg.appendCodePoint(codePointAt3);
            i11 += Character.charCount(codePointAt3);
        }
        String sb2 = this.Jcg.toString();
        this.Fmk.put(j11, sb2);
        return sb2;
    }

    private List<com.bytedance.adsdk.sP.Sj.Sj.EjP> Sj(com.bytedance.adsdk.sP.TKC.EjP ejP) {
        if (this.f20869aa.containsKey(ejP)) {
            return this.f20869aa.get(ejP);
        }
        List<uvD> Sj2 = ejP.Sj();
        int size = Sj2.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i11 = 0; i11 < size; i11++) {
            arrayList.add(new com.bytedance.adsdk.sP.Sj.Sj.EjP(this.uvD, this, Sj2.get(i11), this.dNu));
        }
        this.f20869aa.put(ejP, arrayList);
        return arrayList;
    }

    private List<String> Sj(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\u0003", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private List<Sj> Sj(String str, float f11, com.bytedance.adsdk.sP.TKC.TKC tkc, float f12, float f13, boolean z10) {
        float measureText;
        int i11 = 0;
        int i12 = 0;
        boolean z11 = false;
        int i13 = 0;
        float f14 = 0.0f;
        float f15 = 0.0f;
        float f16 = 0.0f;
        for (int i14 = 0; i14 < str.length(); i14++) {
            char charAt = str.charAt(i14);
            if (z10) {
                com.bytedance.adsdk.sP.TKC.EjP ejP = this.dNu.sef().get(com.bytedance.adsdk.sP.TKC.EjP.Sj(charAt, tkc.Sj(), tkc.TKC()));
                if (ejP != null) {
                    measureText = ((float) ejP.sP()) * f12 * com.bytedance.adsdk.sP.vS.vS.Sj();
                }
            } else {
                measureText = this.TEQ.measureText(str.substring(i14, i14 + 1));
            }
            float f17 = measureText + f13;
            if (charAt == ' ') {
                z11 = true;
                f16 = f17;
            } else if (z11) {
                z11 = false;
                i13 = i14;
                f15 = f17;
            } else {
                f15 += f17;
            }
            f14 += f17;
            if (f11 > 0.0f && f14 >= f11 && charAt != ' ') {
                i11++;
                Sj sP = sP(i11);
                if (i13 == i12) {
                    sP.Sj(str.substring(i12, i14).trim(), (f14 - f17) - ((r9.length() - r7.length()) * f16));
                    i12 = i14;
                    i13 = i12;
                    f14 = f17;
                    f15 = f14;
                } else {
                    sP.Sj(str.substring(i12, i13 - 1).trim(), ((f14 - f15) - ((r7.length() - r13.length()) * f16)) - f16);
                    f14 = f15;
                    i12 = i13;
                }
            }
        }
        if (f14 > 0.0f) {
            i11++;
            sP(i11).Sj(str.substring(i12), f14);
        }
        return this.sef.subList(0, i11);
    }

    private void Sj(Canvas canvas, com.bytedance.adsdk.sP.TKC.sP sPVar, int i11, float f11) {
        PointF pointF = sPVar.f20872aa;
        PointF pointF2 = sPVar.Fmk;
        float Sj2 = com.bytedance.adsdk.sP.vS.vS.Sj();
        float f12 = (i11 * sPVar.vS * Sj2) + (pointF == null ? 0.0f : (sPVar.vS * 0.6f * Sj2) + pointF.y);
        float f13 = pointF == null ? 0.0f : pointF.x;
        float f14 = pointF2 != null ? pointF2.x : 0.0f;
        int i12 = AnonymousClass3.Sj[sPVar.EjP.ordinal()];
        if (i12 == 1) {
            canvas.translate(f13, f12);
        } else if (i12 == 2) {
            canvas.translate((f13 + f14) - f11, f12);
        } else {
            if (i12 != 3) {
                return;
            }
            canvas.translate((f13 + (f14 / 2.0f)) - (f11 / 2.0f), f12);
        }
    }

    private void Sj(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void Sj(com.bytedance.adsdk.sP.TKC.EjP ejP, float f11, com.bytedance.adsdk.sP.TKC.sP sPVar, Canvas canvas) {
        List<com.bytedance.adsdk.sP.Sj.Sj.EjP> Sj2 = Sj(ejP);
        for (int i11 = 0; i11 < Sj2.size(); i11++) {
            Path EjP = Sj2.get(i11).EjP();
            EjP.computeBounds(this.Dq, false);
            this.uA.reset();
            this.uA.preTranslate(0.0f, (-sPVar.Jcg) * com.bytedance.adsdk.sP.vS.vS.Sj());
            this.uA.preScale(f11, f11);
            EjP.transform(this.uA);
            if (sPVar.Ym) {
                Sj(EjP, this.TEQ, canvas);
                Sj(EjP, this.Ym, canvas);
            } else {
                Sj(EjP, this.Ym, canvas);
                Sj(EjP, this.TEQ, canvas);
            }
        }
    }

    private void Sj(com.bytedance.adsdk.sP.TKC.sP sPVar, Matrix matrix) {
        com.bytedance.adsdk.sP.Sj.sP.Sj<Integer, Integer> sj2 = this.RiZ;
        if (sj2 != null) {
            this.TEQ.setColor(sj2.Jcg().intValue());
        } else {
            com.bytedance.adsdk.sP.Sj.sP.Sj<Integer, Integer> sj3 = this.TzV;
            if (sj3 != null) {
                this.TEQ.setColor(sj3.Jcg().intValue());
            } else {
                this.TEQ.setColor(sPVar.Dq);
            }
        }
        com.bytedance.adsdk.sP.Sj.sP.Sj<Integer, Integer> sj4 = this.f20870dx;
        if (sj4 != null) {
            this.Ym.setColor(sj4.Jcg().intValue());
        } else {
            com.bytedance.adsdk.sP.Sj.sP.Sj<Integer, Integer> sj5 = this.sU;
            if (sj5 != null) {
                this.Ym.setColor(sj5.Jcg().intValue());
            } else {
                this.Ym.setColor(sPVar.uA);
            }
        }
        int intValue = ((this.EjP.Sj() == null ? 100 : this.EjP.Sj().Jcg().intValue()) * 255) / 100;
        this.TEQ.setAlpha(intValue);
        this.Ym.setAlpha(intValue);
        com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> sj6 = this.f20871ib;
        if (sj6 != null) {
            this.Ym.setStrokeWidth(sj6.Jcg().floatValue());
            return;
        }
        com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> sj7 = this.zR;
        if (sj7 != null) {
            this.Ym.setStrokeWidth(sj7.Jcg().floatValue());
        } else {
            this.Ym.setStrokeWidth(sPVar.TEQ * com.bytedance.adsdk.sP.vS.vS.Sj());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void Sj(com.bytedance.adsdk.sP.TKC.sP r21, android.graphics.Matrix r22, com.bytedance.adsdk.sP.TKC.TKC r23, android.graphics.Canvas r24) {
        /*
            r20 = this;
            r8 = r20
            r9 = r21
            com.bytedance.adsdk.sP.Sj.sP.Sj<java.lang.Float, java.lang.Float> r0 = r8.wE
            if (r0 == 0) goto L13
            java.lang.Object r0 = r0.Jcg()
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            goto L15
        L13:
            float r0 = r9.TKC
        L15:
            r1 = 1120403456(0x42c80000, float:100.0)
            float r10 = r0 / r1
            float r11 = com.bytedance.adsdk.sP.vS.vS.Sj(r22)
            java.lang.String r0 = r9.Sj
            java.util.List r12 = r8.Sj(r0)
            int r13 = r12.size()
            int r0 = r9.HiB
            float r0 = (float) r0
            r1 = 1092616192(0x41200000, float:10.0)
            float r0 = r0 / r1
            com.bytedance.adsdk.sP.Sj.sP.Sj<java.lang.Float, java.lang.Float> r1 = r8.uP
            if (r1 == 0) goto L3e
            java.lang.Object r1 = r1.Jcg()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
        L3b:
            float r0 = r0 + r1
        L3c:
            r14 = r0
            goto L4d
        L3e:
            com.bytedance.adsdk.sP.Sj.sP.Sj<java.lang.Float, java.lang.Float> r1 = r8.kF
            if (r1 == 0) goto L3c
            java.lang.Object r1 = r1.Jcg()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            goto L3b
        L4d:
            r15 = 0
            r0 = -1
            r7 = r0
            r6 = r15
        L51:
            if (r6 >= r13) goto Lb2
            java.lang.Object r0 = r12.get(r6)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
            android.graphics.PointF r0 = r9.Fmk
            if (r0 != 0) goto L61
            r0 = 0
        L5f:
            r2 = r0
            goto L64
        L61:
            float r0 = r0.x
            goto L5f
        L64:
            r16 = 1
            r0 = r20
            r3 = r23
            r4 = r10
            r5 = r14
            r17 = r6
            r6 = r16
            java.util.List r6 = r0.Sj(r1, r2, r3, r4, r5, r6)
            r5 = r15
        L75:
            int r0 = r6.size()
            if (r5 >= r0) goto Laf
            java.lang.Object r0 = r6.get(r5)
            com.bytedance.adsdk.sP.TKC.TKC.uA$Sj r0 = (com.bytedance.adsdk.sP.TKC.TKC.uA.Sj) r0
            int r7 = r7 + 1
            r24.save()
            float r1 = com.bytedance.adsdk.sP.TKC.TKC.uA.Sj.Sj(r0)
            r4 = r24
            r8.Sj(r4, r9, r7, r1)
            java.lang.String r1 = com.bytedance.adsdk.sP.TKC.TKC.uA.Sj.sP(r0)
            r0 = r20
            r2 = r21
            r3 = r23
            r16 = r5
            r5 = r11
            r18 = r6
            r6 = r10
            r19 = r7
            r7 = r14
            r0.Sj(r1, r2, r3, r4, r5, r6, r7)
            r24.restore()
            int r5 = r16 + 1
            r6 = r18
            r7 = r19
            goto L75
        Laf:
            int r6 = r17 + 1
            goto L51
        Lb2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.sP.TKC.TKC.uA.Sj(com.bytedance.adsdk.sP.TKC.sP, android.graphics.Matrix, com.bytedance.adsdk.sP.TKC.TKC, android.graphics.Canvas):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void Sj(com.bytedance.adsdk.sP.TKC.sP r19, com.bytedance.adsdk.sP.TKC.TKC r20, android.graphics.Canvas r21) {
        /*
            r18 = this;
            r7 = r18
            r8 = r19
            r9 = r20
            r10 = r21
            android.graphics.Typeface r0 = r7.Sj(r9)
            if (r0 != 0) goto Lf
            return
        Lf:
            java.lang.String r1 = r8.Sj
            com.bytedance.adsdk.sP.uA r2 = r7.uvD
            com.bytedance.adsdk.sP.sU r2 = r2.kF()
            if (r2 == 0) goto L21
            java.lang.String r3 = r18.uA()
            java.lang.String r1 = r2.sP(r3, r1)
        L21:
            android.graphics.Paint r2 = r7.TEQ
            r2.setTypeface(r0)
            com.bytedance.adsdk.sP.Sj.sP.Sj<java.lang.Float, java.lang.Float> r0 = r7.wE
            if (r0 == 0) goto L35
            java.lang.Object r0 = r0.Jcg()
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            goto L37
        L35:
            float r0 = r8.TKC
        L37:
            android.graphics.Paint r2 = r7.TEQ
            float r3 = com.bytedance.adsdk.sP.vS.vS.Sj()
            float r3 = r3 * r0
            r2.setTextSize(r3)
            android.graphics.Paint r2 = r7.Ym
            android.graphics.Paint r3 = r7.TEQ
            android.graphics.Typeface r3 = r3.getTypeface()
            r2.setTypeface(r3)
            android.graphics.Paint r2 = r7.Ym
            android.graphics.Paint r3 = r7.TEQ
            float r3 = r3.getTextSize()
            r2.setTextSize(r3)
            int r2 = r8.HiB
            float r2 = (float) r2
            r3 = 1092616192(0x41200000, float:10.0)
            float r2 = r2 / r3
            com.bytedance.adsdk.sP.Sj.sP.Sj<java.lang.Float, java.lang.Float> r3 = r7.uP
            if (r3 == 0) goto L6d
            java.lang.Object r3 = r3.Jcg()
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
        L6b:
            float r2 = r2 + r3
            goto L7c
        L6d:
            com.bytedance.adsdk.sP.Sj.sP.Sj<java.lang.Float, java.lang.Float> r3 = r7.kF
            if (r3 == 0) goto L7c
            java.lang.Object r3 = r3.Jcg()
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            goto L6b
        L7c:
            float r3 = com.bytedance.adsdk.sP.vS.vS.Sj()
            float r2 = r2 * r3
            float r2 = r2 * r0
            r0 = 1120403456(0x42c80000, float:100.0)
            float r11 = r2 / r0
            java.util.List r12 = r7.Sj(r1)
            int r13 = r12.size()
            r14 = 0
            r0 = -1
            r15 = r0
            r6 = r14
        L92:
            if (r6 >= r13) goto Lde
            java.lang.Object r0 = r12.get(r6)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
            android.graphics.PointF r0 = r8.Fmk
            if (r0 != 0) goto La2
            r0 = 0
        La0:
            r2 = r0
            goto La5
        La2:
            float r0 = r0.x
            goto La0
        La5:
            r4 = 0
            r16 = 0
            r0 = r18
            r3 = r20
            r5 = r11
            r17 = r6
            r6 = r16
            java.util.List r0 = r0.Sj(r1, r2, r3, r4, r5, r6)
            r1 = r14
        Lb6:
            int r2 = r0.size()
            if (r1 >= r2) goto Ldb
            java.lang.Object r2 = r0.get(r1)
            com.bytedance.adsdk.sP.TKC.TKC.uA$Sj r2 = (com.bytedance.adsdk.sP.TKC.TKC.uA.Sj) r2
            int r15 = r15 + 1
            r21.save()
            float r3 = com.bytedance.adsdk.sP.TKC.TKC.uA.Sj.Sj(r2)
            r7.Sj(r10, r8, r15, r3)
            java.lang.String r2 = com.bytedance.adsdk.sP.TKC.TKC.uA.Sj.sP(r2)
            r7.Sj(r2, r8, r10, r11)
            r21.restore()
            int r1 = r1 + 1
            goto Lb6
        Ldb:
            int r6 = r17 + 1
            goto L92
        Lde:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.sP.TKC.TKC.uA.Sj(com.bytedance.adsdk.sP.TKC.sP, com.bytedance.adsdk.sP.TKC.TKC, android.graphics.Canvas):void");
    }

    private void Sj(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private void Sj(String str, com.bytedance.adsdk.sP.TKC.sP sPVar, Canvas canvas) {
        if (sPVar.Ym) {
            Sj(str, this.TEQ, canvas);
            Sj(str, this.Ym, canvas);
        } else {
            Sj(str, this.Ym, canvas);
            Sj(str, this.TEQ, canvas);
        }
    }

    private void Sj(String str, com.bytedance.adsdk.sP.TKC.sP sPVar, Canvas canvas, float f11) {
        int i11 = 0;
        while (i11 < str.length()) {
            String Sj2 = Sj(str, i11);
            i11 += Sj2.length();
            Sj(Sj2, sPVar, canvas);
            canvas.translate(this.TEQ.measureText(Sj2) + f11, 0.0f);
        }
    }

    private void Sj(String str, com.bytedance.adsdk.sP.TKC.sP sPVar, com.bytedance.adsdk.sP.TKC.TKC tkc, Canvas canvas, float f11, float f12, float f13) {
        for (int i11 = 0; i11 < str.length(); i11++) {
            com.bytedance.adsdk.sP.TKC.EjP ejP = this.dNu.sef().get(com.bytedance.adsdk.sP.TKC.EjP.Sj(str.charAt(i11), tkc.Sj(), tkc.TKC()));
            if (ejP != null) {
                Sj(ejP, f12, sPVar, canvas);
                canvas.translate((((float) ejP.sP()) * f12 * com.bytedance.adsdk.sP.vS.vS.Sj()) + f13, 0.0f);
            }
        }
    }

    private boolean TKC(int i11) {
        return Character.getType(i11) == 16 || Character.getType(i11) == 27 || Character.getType(i11) == 6 || Character.getType(i11) == 28 || Character.getType(i11) == 8 || Character.getType(i11) == 19;
    }

    private Sj sP(int i11) {
        for (int size = this.sef.size(); size < i11; size++) {
            this.sef.add(new Sj());
        }
        return this.sef.get(i11 - 1);
    }

    @Override // com.bytedance.adsdk.sP.TKC.TKC.Sj, com.bytedance.adsdk.sP.Sj.Sj.HiB
    public void Sj(RectF rectF, Matrix matrix, boolean z10) {
        super.Sj(rectF, matrix, z10);
        rectF.set(0.0f, 0.0f, this.dNu.EjP().width(), this.dNu.EjP().height());
    }

    @Override // com.bytedance.adsdk.sP.TKC.TKC.Sj
    public void sP(Canvas canvas, Matrix matrix, int i11) {
        super.sP(canvas, matrix, i11);
        com.bytedance.adsdk.sP.TKC.sP Jcg = this.Zq.Jcg();
        com.bytedance.adsdk.sP.TKC.TKC tkc = this.dNu.Zq().get(Jcg.sP);
        if (tkc == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        Sj(Jcg, matrix);
        if (this.uvD.uP()) {
            Sj(Jcg, matrix, tkc, canvas);
        } else {
            Sj(Jcg, tkc, canvas);
        }
        canvas.restore();
    }
}
