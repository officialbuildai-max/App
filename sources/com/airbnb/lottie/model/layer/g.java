package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.collection.x;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.content.TextRangeUnits;
import com.airbnb.lottie.p0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import n4.o;
import n4.q;
import q4.k;
import q4.l;
import q4.m;

/* loaded from: classes2.dex */
public class g extends com.airbnb.lottie.model.layer.a {
    private final StringBuilder E;
    private final RectF F;
    private final Matrix G;
    private final Paint H;
    private final Paint I;
    private final Map J;
    private final x K;
    private final List L;
    private final o M;
    private final LottieDrawable N;
    private final h O;
    private TextRangeUnits P;
    private n4.a Q;
    private n4.a R;
    private n4.a S;
    private n4.a T;
    private n4.a U;
    private n4.a V;
    private n4.a W;
    private n4.a X;
    private n4.a Y;
    private n4.a Z;

    /* renamed from: a0, reason: collision with root package name */
    private n4.a f17969a0;

    /* renamed from: b0, reason: collision with root package name */
    private n4.a f17970b0;

    /* renamed from: c0, reason: collision with root package name */
    private n4.a f17971c0;

    /* renamed from: d0, reason: collision with root package name */
    private n4.a f17972d0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends Paint {
        a(int i11) {
            super(i11);
            setStyle(Paint.Style.FILL);
        }
    }

    /* loaded from: classes2.dex */
    class b extends Paint {
        b(int i11) {
            super(i11);
            setStyle(Paint.Style.STROKE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f17975a;

        static {
            int[] iArr = new int[DocumentData.Justification.values().length];
            f17975a = iArr;
            try {
                iArr[DocumentData.Justification.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17975a[DocumentData.Justification.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17975a[DocumentData.Justification.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private String f17976a;

        /* renamed from: b, reason: collision with root package name */
        private float f17977b;

        private d() {
            this.f17976a = "";
            this.f17977b = 0.0f;
        }

        /* synthetic */ d(a aVar) {
            this();
        }

        void c(String str, float f11) {
            this.f17976a = str;
            this.f17977b = f11;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        l lVar;
        l lVar2;
        q4.d dVar;
        l lVar3;
        q4.d dVar2;
        l lVar4;
        q4.d dVar3;
        m mVar;
        q4.d dVar4;
        m mVar2;
        q4.b bVar;
        m mVar3;
        q4.b bVar2;
        m mVar4;
        q4.a aVar;
        m mVar5;
        q4.a aVar2;
        this.E = new StringBuilder(2);
        this.F = new RectF();
        this.G = new Matrix();
        this.H = new a(1);
        this.I = new b(1);
        this.J = new HashMap();
        this.K = new x();
        this.L = new ArrayList();
        this.P = TextRangeUnits.INDEX;
        this.N = lottieDrawable;
        this.O = layer.c();
        o a11 = layer.t().a();
        this.M = a11;
        a11.a(this);
        i(a11);
        k u11 = layer.u();
        if (u11 != null && (mVar5 = u11.f73213a) != null && (aVar2 = mVar5.f73219a) != null) {
            n4.a a12 = aVar2.a();
            this.Q = a12;
            a12.a(this);
            i(this.Q);
        }
        if (u11 != null && (mVar4 = u11.f73213a) != null && (aVar = mVar4.f73220b) != null) {
            n4.a a13 = aVar.a();
            this.S = a13;
            a13.a(this);
            i(this.S);
        }
        if (u11 != null && (mVar3 = u11.f73213a) != null && (bVar2 = mVar3.f73221c) != null) {
            n4.d a14 = bVar2.a();
            this.U = a14;
            a14.a(this);
            i(this.U);
        }
        if (u11 != null && (mVar2 = u11.f73213a) != null && (bVar = mVar2.f73222d) != null) {
            n4.d a15 = bVar.a();
            this.W = a15;
            a15.a(this);
            i(this.W);
        }
        if (u11 != null && (mVar = u11.f73213a) != null && (dVar4 = mVar.f73223e) != null) {
            n4.a a16 = dVar4.a();
            this.Y = a16;
            a16.a(this);
            i(this.Y);
        }
        if (u11 != null && (lVar4 = u11.f73214b) != null && (dVar3 = lVar4.f73215a) != null) {
            n4.a a17 = dVar3.a();
            this.f17970b0 = a17;
            a17.a(this);
            i(this.f17970b0);
        }
        if (u11 != null && (lVar3 = u11.f73214b) != null && (dVar2 = lVar3.f73216b) != null) {
            n4.a a18 = dVar2.a();
            this.f17971c0 = a18;
            a18.a(this);
            i(this.f17971c0);
        }
        if (u11 != null && (lVar2 = u11.f73214b) != null && (dVar = lVar2.f73217c) != null) {
            n4.a a19 = dVar.a();
            this.f17972d0 = a19;
            a19.a(this);
            i(this.f17972d0);
        }
        if (u11 == null || (lVar = u11.f73214b) == null) {
            return;
        }
        this.P = lVar.f73218d;
    }

    private String P(String str, int i11) {
        int codePointAt = str.codePointAt(i11);
        int charCount = Character.charCount(codePointAt) + i11;
        while (charCount < str.length()) {
            int codePointAt2 = str.codePointAt(charCount);
            if (!e0(codePointAt2)) {
                break;
            }
            charCount += Character.charCount(codePointAt2);
            codePointAt = (codePointAt * 31) + codePointAt2;
        }
        long j11 = codePointAt;
        if (this.K.d(j11)) {
            return (String) this.K.e(j11);
        }
        this.E.setLength(0);
        while (i11 < charCount) {
            int codePointAt3 = str.codePointAt(i11);
            this.E.appendCodePoint(codePointAt3);
            i11 += Character.charCount(codePointAt3);
        }
        String sb2 = this.E.toString();
        this.K.k(j11, sb2);
        return sb2;
    }

    private void Q(DocumentData documentData, int i11, int i12) {
        n4.a aVar = this.R;
        if (aVar != null) {
            this.H.setColor(((Integer) aVar.h()).intValue());
        } else if (this.Q == null || !d0(i12)) {
            this.H.setColor(documentData.f17859h);
        } else {
            this.H.setColor(((Integer) this.Q.h()).intValue());
        }
        n4.a aVar2 = this.T;
        if (aVar2 != null) {
            this.I.setColor(((Integer) aVar2.h()).intValue());
        } else if (this.S == null || !d0(i12)) {
            this.I.setColor(documentData.f17860i);
        } else {
            this.I.setColor(((Integer) this.S.h()).intValue());
        }
        int i13 = 100;
        int intValue = this.f17963x.h() == null ? 100 : ((Integer) this.f17963x.h().h()).intValue();
        if (this.Y != null && d0(i12)) {
            i13 = ((Integer) this.Y.h()).intValue();
        }
        int round = Math.round(((((intValue * 255.0f) / 100.0f) * (i13 / 100.0f)) * i11) / 255.0f);
        this.H.setAlpha(round);
        this.I.setAlpha(round);
        n4.a aVar3 = this.V;
        if (aVar3 != null) {
            this.I.setStrokeWidth(((Float) aVar3.h()).floatValue());
        } else if (this.U == null || !d0(i12)) {
            this.I.setStrokeWidth(documentData.f17861j * v4.l.e());
        } else {
            this.I.setStrokeWidth(((Float) this.U.h()).floatValue());
        }
    }

    private void R(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private void S(p4.c cVar, float f11, DocumentData documentData, Canvas canvas, int i11, int i12) {
        Q(documentData, i12, i11);
        List a02 = a0(cVar);
        for (int i13 = 0; i13 < a02.size(); i13++) {
            Path path = ((m4.d) a02.get(i13)).getPath();
            path.computeBounds(this.F, false);
            this.G.reset();
            this.G.preTranslate(0.0f, (-documentData.f17858g) * v4.l.e());
            this.G.preScale(f11, f11);
            path.transform(this.G);
            if (documentData.f17862k) {
                V(path, this.H, canvas);
                V(path, this.I, canvas);
            } else {
                V(path, this.I, canvas);
                V(path, this.H, canvas);
            }
        }
    }

    private void T(String str, DocumentData documentData, Canvas canvas, int i11, int i12) {
        Q(documentData, i12, i11);
        if (documentData.f17862k) {
            R(str, this.H, canvas);
            R(str, this.I, canvas);
        } else {
            R(str, this.I, canvas);
            R(str, this.H, canvas);
        }
    }

    private void U(String str, DocumentData documentData, Canvas canvas, float f11, int i11, int i12) {
        int i13 = 0;
        while (i13 < str.length()) {
            String P = P(str, i13);
            T(P, documentData, canvas, i11 + i13, i12);
            canvas.translate(this.H.measureText(P) + f11, 0.0f);
            i13 += P.length();
        }
    }

    private void V(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void W(String str, DocumentData documentData, p4.b bVar, Canvas canvas, float f11, float f12, float f13, int i11) {
        for (int i12 = 0; i12 < str.length(); i12++) {
            p4.c cVar = (p4.c) this.O.c().f(p4.c.c(str.charAt(i12), bVar.a(), bVar.c()));
            if (cVar != null) {
                S(cVar, f12, documentData, canvas, i12, i11);
                canvas.translate((((float) cVar.b()) * f12 * v4.l.e()) + f13, 0.0f);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void X(com.airbnb.lottie.model.DocumentData r21, p4.b r22, android.graphics.Canvas r23, int r24) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.g.X(com.airbnb.lottie.model.DocumentData, p4.b, android.graphics.Canvas, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void Y(com.airbnb.lottie.model.DocumentData r22, android.graphics.Matrix r23, p4.b r24, android.graphics.Canvas r25, int r26) {
        /*
            r21 = this;
            r9 = r21
            r10 = r22
            n4.a r0 = r9.Z
            if (r0 == 0) goto L13
            java.lang.Object r0 = r0.h()
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            goto L15
        L13:
            float r0 = r10.f17854c
        L15:
            r1 = 1120403456(0x42c80000, float:100.0)
            float r11 = r0 / r1
            float r12 = v4.l.g(r23)
            java.lang.String r0 = r10.f17852a
            java.util.List r13 = r9.b0(r0)
            int r14 = r13.size()
            int r0 = r10.f17856e
            float r0 = (float) r0
            r1 = 1092616192(0x41200000, float:10.0)
            float r0 = r0 / r1
            n4.a r1 = r9.X
            if (r1 == 0) goto L3e
            java.lang.Object r1 = r1.h()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
        L3b:
            float r0 = r0 + r1
        L3c:
            r15 = r0
            goto L4d
        L3e:
            n4.a r1 = r9.W
            if (r1 == 0) goto L3c
            java.lang.Object r1 = r1.h()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            goto L3b
        L4d:
            r16 = 0
            r0 = -1
            r7 = r0
            r8 = r16
        L53:
            if (r8 >= r14) goto Lc6
            java.lang.Object r0 = r13.get(r8)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
            android.graphics.PointF r0 = r10.f17864m
            if (r0 != 0) goto L63
            r0 = 0
        L61:
            r2 = r0
            goto L66
        L63:
            float r0 = r0.x
            goto L61
        L66:
            r6 = 1
            r0 = r21
            r3 = r24
            r4 = r11
            r5 = r15
            java.util.List r6 = r0.g0(r1, r2, r3, r4, r5, r6)
            r5 = r16
        L73:
            int r0 = r6.size()
            if (r5 >= r0) goto Lc1
            java.lang.Object r0 = r6.get(r5)
            com.airbnb.lottie.model.layer.g$d r0 = (com.airbnb.lottie.model.layer.g.d) r0
            int r7 = r7 + 1
            r25.save()
            float r1 = com.airbnb.lottie.model.layer.g.d.a(r0)
            r4 = r25
            boolean r1 = r9.f0(r4, r10, r7, r1)
            if (r1 == 0) goto Lad
            java.lang.String r1 = com.airbnb.lottie.model.layer.g.d.b(r0)
            r0 = r21
            r2 = r22
            r3 = r24
            r4 = r25
            r17 = r5
            r5 = r12
            r18 = r6
            r6 = r11
            r19 = r7
            r7 = r15
            r20 = r8
            r8 = r26
            r0.W(r1, r2, r3, r4, r5, r6, r7, r8)
            goto Lb5
        Lad:
            r17 = r5
            r18 = r6
            r19 = r7
            r20 = r8
        Lb5:
            r25.restore()
            int r5 = r17 + 1
            r6 = r18
            r7 = r19
            r8 = r20
            goto L73
        Lc1:
            r20 = r8
            int r8 = r20 + 1
            goto L53
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.g.Y(com.airbnb.lottie.model.DocumentData, android.graphics.Matrix, p4.b, android.graphics.Canvas, int):void");
    }

    private d Z(int i11) {
        for (int size = this.L.size(); size < i11; size++) {
            this.L.add(new d(null));
        }
        return (d) this.L.get(i11 - 1);
    }

    private List a0(p4.c cVar) {
        if (this.J.containsKey(cVar)) {
            return (List) this.J.get(cVar);
        }
        List a11 = cVar.a();
        int size = a11.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i11 = 0; i11 < size; i11++) {
            arrayList.add(new m4.d(this.N, this, (r4.k) a11.get(i11), this.O));
        }
        this.J.put(cVar, arrayList);
        return arrayList;
    }

    private List b0(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\u0003", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private Typeface c0(p4.b bVar) {
        Typeface typeface;
        n4.a aVar = this.f17969a0;
        if (aVar != null && (typeface = (Typeface) aVar.h()) != null) {
            return typeface;
        }
        Typeface g02 = this.N.g0(bVar);
        return g02 != null ? g02 : bVar.d();
    }

    private boolean d0(int i11) {
        int length = ((DocumentData) this.M.h()).f17852a.length();
        n4.a aVar = this.f17970b0;
        if (aVar == null || this.f17971c0 == null) {
            return true;
        }
        int min = Math.min(((Integer) aVar.h()).intValue(), ((Integer) this.f17971c0.h()).intValue());
        int max = Math.max(((Integer) this.f17970b0.h()).intValue(), ((Integer) this.f17971c0.h()).intValue());
        n4.a aVar2 = this.f17972d0;
        if (aVar2 != null) {
            int intValue = ((Integer) aVar2.h()).intValue();
            min += intValue;
            max += intValue;
        }
        if (this.P == TextRangeUnits.INDEX) {
            return i11 >= min && i11 < max;
        }
        float f11 = (i11 / length) * 100.0f;
        return f11 >= ((float) min) && f11 < ((float) max);
    }

    private boolean e0(int i11) {
        return Character.getType(i11) == 16 || Character.getType(i11) == 27 || Character.getType(i11) == 6 || Character.getType(i11) == 28 || Character.getType(i11) == 8 || Character.getType(i11) == 19;
    }

    private boolean f0(Canvas canvas, DocumentData documentData, int i11, float f11) {
        PointF pointF = documentData.f17863l;
        PointF pointF2 = documentData.f17864m;
        float e11 = v4.l.e();
        float f12 = (i11 * documentData.f17857f * e11) + (pointF == null ? 0.0f : (documentData.f17857f * e11) + pointF.y);
        if (this.N.M() && pointF2 != null && pointF != null && f12 >= pointF.y + pointF2.y + documentData.f17854c) {
            return false;
        }
        float f13 = pointF == null ? 0.0f : pointF.x;
        float f14 = pointF2 != null ? pointF2.x : 0.0f;
        int i12 = c.f17975a[documentData.f17855d.ordinal()];
        if (i12 == 1) {
            canvas.translate(f13, f12);
        } else if (i12 == 2) {
            canvas.translate((f13 + f14) - f11, f12);
        } else if (i12 == 3) {
            canvas.translate((f13 + (f14 / 2.0f)) - (f11 / 2.0f), f12);
        }
        return true;
    }

    private List g0(String str, float f11, p4.b bVar, float f12, float f13, boolean z10) {
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
                p4.c cVar = (p4.c) this.O.c().f(p4.c.c(charAt, bVar.a(), bVar.c()));
                if (cVar != null) {
                    measureText = ((float) cVar.b()) * f12 * v4.l.e();
                }
            } else {
                measureText = this.H.measureText(str.substring(i14, i14 + 1));
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
                d Z = Z(i11);
                if (i13 == i12) {
                    Z.c(str.substring(i12, i14).trim(), (f14 - f17) - ((r9.length() - r7.length()) * f16));
                    i12 = i14;
                    i13 = i12;
                    f14 = f17;
                    f15 = f14;
                } else {
                    Z.c(str.substring(i12, i13 - 1).trim(), ((f14 - f15) - ((r7.length() - r13.length()) * f16)) - f16);
                    f14 = f15;
                    i12 = i13;
                }
            }
        }
        if (f14 > 0.0f) {
            i11++;
            Z(i11).c(str.substring(i12), f14);
        }
        return this.L.subList(0, i11);
    }

    @Override // com.airbnb.lottie.model.layer.a, p4.e
    public void b(Object obj, w4.c cVar) {
        super.b(obj, cVar);
        if (obj == p0.f17985a) {
            n4.a aVar = this.R;
            if (aVar != null) {
                H(aVar);
            }
            if (cVar == null) {
                this.R = null;
                return;
            }
            q qVar = new q(cVar);
            this.R = qVar;
            qVar.a(this);
            i(this.R);
            return;
        }
        if (obj == p0.f17986b) {
            n4.a aVar2 = this.T;
            if (aVar2 != null) {
                H(aVar2);
            }
            if (cVar == null) {
                this.T = null;
                return;
            }
            q qVar2 = new q(cVar);
            this.T = qVar2;
            qVar2.a(this);
            i(this.T);
            return;
        }
        if (obj == p0.f18003s) {
            n4.a aVar3 = this.V;
            if (aVar3 != null) {
                H(aVar3);
            }
            if (cVar == null) {
                this.V = null;
                return;
            }
            q qVar3 = new q(cVar);
            this.V = qVar3;
            qVar3.a(this);
            i(this.V);
            return;
        }
        if (obj == p0.f18004t) {
            n4.a aVar4 = this.X;
            if (aVar4 != null) {
                H(aVar4);
            }
            if (cVar == null) {
                this.X = null;
                return;
            }
            q qVar4 = new q(cVar);
            this.X = qVar4;
            qVar4.a(this);
            i(this.X);
            return;
        }
        if (obj == p0.F) {
            n4.a aVar5 = this.Z;
            if (aVar5 != null) {
                H(aVar5);
            }
            if (cVar == null) {
                this.Z = null;
                return;
            }
            q qVar5 = new q(cVar);
            this.Z = qVar5;
            qVar5.a(this);
            i(this.Z);
            return;
        }
        if (obj != p0.M) {
            if (obj == p0.O) {
                this.M.r(cVar);
                return;
            }
            return;
        }
        n4.a aVar6 = this.f17969a0;
        if (aVar6 != null) {
            H(aVar6);
        }
        if (cVar == null) {
            this.f17969a0 = null;
            return;
        }
        q qVar6 = new q(cVar);
        this.f17969a0 = qVar6;
        qVar6.a(this);
        i(this.f17969a0);
    }

    @Override // com.airbnb.lottie.model.layer.a, m4.e
    public void f(RectF rectF, Matrix matrix, boolean z10) {
        super.f(rectF, matrix, z10);
        rectF.set(0.0f, 0.0f, this.O.b().width(), this.O.b().height());
    }

    @Override // com.airbnb.lottie.model.layer.a
    void t(Canvas canvas, Matrix matrix, int i11) {
        DocumentData documentData = (DocumentData) this.M.h();
        p4.b bVar = (p4.b) this.O.g().get(documentData.f17853b);
        if (bVar == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        Q(documentData, i11, 0);
        if (this.N.C1()) {
            Y(documentData, matrix, bVar, canvas, i11);
        } else {
            X(documentData, bVar, canvas, i11);
        }
        canvas.restore();
    }
}
