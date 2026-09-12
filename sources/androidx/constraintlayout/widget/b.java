package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import com.mbridge.msdk.out.MBSupportMuteAdType;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class b {

    /* renamed from: h, reason: collision with root package name */
    private static final int[] f7828h = {0, 4, 8};

    /* renamed from: i, reason: collision with root package name */
    private static SparseIntArray f7829i = new SparseIntArray();

    /* renamed from: j, reason: collision with root package name */
    private static SparseIntArray f7830j = new SparseIntArray();

    /* renamed from: a, reason: collision with root package name */
    private boolean f7831a;

    /* renamed from: b, reason: collision with root package name */
    public String f7832b;

    /* renamed from: c, reason: collision with root package name */
    public String f7833c = "";

    /* renamed from: d, reason: collision with root package name */
    public int f7834d = 0;

    /* renamed from: e, reason: collision with root package name */
    private HashMap f7835e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private boolean f7836f = true;

    /* renamed from: g, reason: collision with root package name */
    private HashMap f7837g = new HashMap();

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f7838a;

        /* renamed from: b, reason: collision with root package name */
        String f7839b;

        /* renamed from: c, reason: collision with root package name */
        public final d f7840c = new d();

        /* renamed from: d, reason: collision with root package name */
        public final c f7841d = new c();

        /* renamed from: e, reason: collision with root package name */
        public final C0064b f7842e = new C0064b();

        /* renamed from: f, reason: collision with root package name */
        public final e f7843f = new e();

        /* renamed from: g, reason: collision with root package name */
        public HashMap f7844g = new HashMap();

        /* renamed from: h, reason: collision with root package name */
        C0063a f7845h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: androidx.constraintlayout.widget.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0063a {

            /* renamed from: a, reason: collision with root package name */
            int[] f7846a = new int[10];

            /* renamed from: b, reason: collision with root package name */
            int[] f7847b = new int[10];

            /* renamed from: c, reason: collision with root package name */
            int f7848c = 0;

            /* renamed from: d, reason: collision with root package name */
            int[] f7849d = new int[10];

            /* renamed from: e, reason: collision with root package name */
            float[] f7850e = new float[10];

            /* renamed from: f, reason: collision with root package name */
            int f7851f = 0;

            /* renamed from: g, reason: collision with root package name */
            int[] f7852g = new int[5];

            /* renamed from: h, reason: collision with root package name */
            String[] f7853h = new String[5];

            /* renamed from: i, reason: collision with root package name */
            int f7854i = 0;

            /* renamed from: j, reason: collision with root package name */
            int[] f7855j = new int[4];

            /* renamed from: k, reason: collision with root package name */
            boolean[] f7856k = new boolean[4];

            /* renamed from: l, reason: collision with root package name */
            int f7857l = 0;

            C0063a() {
            }

            void a(int i11, float f11) {
                int i12 = this.f7851f;
                int[] iArr = this.f7849d;
                if (i12 >= iArr.length) {
                    this.f7849d = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.f7850e;
                    this.f7850e = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.f7849d;
                int i13 = this.f7851f;
                iArr2[i13] = i11;
                float[] fArr2 = this.f7850e;
                this.f7851f = i13 + 1;
                fArr2[i13] = f11;
            }

            void b(int i11, int i12) {
                int i13 = this.f7848c;
                int[] iArr = this.f7846a;
                if (i13 >= iArr.length) {
                    this.f7846a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.f7847b;
                    this.f7847b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.f7846a;
                int i14 = this.f7848c;
                iArr3[i14] = i11;
                int[] iArr4 = this.f7847b;
                this.f7848c = i14 + 1;
                iArr4[i14] = i12;
            }

            void c(int i11, String str) {
                int i12 = this.f7854i;
                int[] iArr = this.f7852g;
                if (i12 >= iArr.length) {
                    this.f7852g = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.f7853h;
                    this.f7853h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.f7852g;
                int i13 = this.f7854i;
                iArr2[i13] = i11;
                String[] strArr2 = this.f7853h;
                this.f7854i = i13 + 1;
                strArr2[i13] = str;
            }

            void d(int i11, boolean z10) {
                int i12 = this.f7857l;
                int[] iArr = this.f7855j;
                if (i12 >= iArr.length) {
                    this.f7855j = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.f7856k;
                    this.f7856k = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.f7855j;
                int i13 = this.f7857l;
                iArr2[i13] = i11;
                boolean[] zArr2 = this.f7856k;
                this.f7857l = i13 + 1;
                zArr2[i13] = z10;
            }

            void e(a aVar) {
                for (int i11 = 0; i11 < this.f7848c; i11++) {
                    b.S(aVar, this.f7846a[i11], this.f7847b[i11]);
                }
                for (int i12 = 0; i12 < this.f7851f; i12++) {
                    b.R(aVar, this.f7849d[i12], this.f7850e[i12]);
                }
                for (int i13 = 0; i13 < this.f7854i; i13++) {
                    b.T(aVar, this.f7852g[i13], this.f7853h[i13]);
                }
                for (int i14 = 0; i14 < this.f7857l; i14++) {
                    b.U(aVar, this.f7855j[i14], this.f7856k[i14]);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(int i11, ConstraintLayout.b bVar) {
            this.f7838a = i11;
            C0064b c0064b = this.f7842e;
            c0064b.f7877j = bVar.f7745e;
            c0064b.f7879k = bVar.f7747f;
            c0064b.f7881l = bVar.f7749g;
            c0064b.f7883m = bVar.f7751h;
            c0064b.f7885n = bVar.f7753i;
            c0064b.f7887o = bVar.f7755j;
            c0064b.f7889p = bVar.f7757k;
            c0064b.f7891q = bVar.f7759l;
            c0064b.f7893r = bVar.f7761m;
            c0064b.f7894s = bVar.f7763n;
            c0064b.f7895t = bVar.f7765o;
            c0064b.f7896u = bVar.f7773s;
            c0064b.f7897v = bVar.f7775t;
            c0064b.f7898w = bVar.f7777u;
            c0064b.f7899x = bVar.f7779v;
            c0064b.f7900y = bVar.G;
            c0064b.f7901z = bVar.H;
            c0064b.A = bVar.I;
            c0064b.B = bVar.f7767p;
            c0064b.C = bVar.f7769q;
            c0064b.D = bVar.f7771r;
            c0064b.E = bVar.X;
            c0064b.F = bVar.Y;
            c0064b.G = bVar.Z;
            c0064b.f7873h = bVar.f7741c;
            c0064b.f7869f = bVar.f7737a;
            c0064b.f7871g = bVar.f7739b;
            c0064b.f7865d = ((ViewGroup.MarginLayoutParams) bVar).width;
            c0064b.f7867e = ((ViewGroup.MarginLayoutParams) bVar).height;
            c0064b.H = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
            c0064b.I = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
            c0064b.J = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
            c0064b.K = ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
            c0064b.N = bVar.D;
            c0064b.V = bVar.M;
            c0064b.W = bVar.L;
            c0064b.Y = bVar.O;
            c0064b.X = bVar.N;
            c0064b.f7886n0 = bVar.f7738a0;
            c0064b.f7888o0 = bVar.f7740b0;
            c0064b.Z = bVar.P;
            c0064b.f7860a0 = bVar.Q;
            c0064b.f7862b0 = bVar.T;
            c0064b.f7864c0 = bVar.U;
            c0064b.f7866d0 = bVar.R;
            c0064b.f7868e0 = bVar.S;
            c0064b.f7870f0 = bVar.V;
            c0064b.f7872g0 = bVar.W;
            c0064b.f7884m0 = bVar.f7742c0;
            c0064b.P = bVar.f7783x;
            c0064b.R = bVar.f7785z;
            c0064b.O = bVar.f7781w;
            c0064b.Q = bVar.f7784y;
            c0064b.T = bVar.A;
            c0064b.S = bVar.B;
            c0064b.U = bVar.C;
            c0064b.f7892q0 = bVar.f7744d0;
            c0064b.L = bVar.getMarginEnd();
            this.f7842e.M = bVar.getMarginStart();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(int i11, Constraints.a aVar) {
            g(i11, aVar);
            this.f7840c.f7920d = aVar.f7796x0;
            e eVar = this.f7843f;
            eVar.f7924b = aVar.A0;
            eVar.f7925c = aVar.B0;
            eVar.f7926d = aVar.C0;
            eVar.f7927e = aVar.D0;
            eVar.f7928f = aVar.E0;
            eVar.f7929g = aVar.F0;
            eVar.f7930h = aVar.G0;
            eVar.f7932j = aVar.H0;
            eVar.f7933k = aVar.I0;
            eVar.f7934l = aVar.J0;
            eVar.f7936n = aVar.f7798z0;
            eVar.f7935m = aVar.f7797y0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(ConstraintHelper constraintHelper, int i11, Constraints.a aVar) {
            h(i11, aVar);
            if (constraintHelper instanceof Barrier) {
                C0064b c0064b = this.f7842e;
                c0064b.f7878j0 = 1;
                Barrier barrier = (Barrier) constraintHelper;
                c0064b.f7874h0 = barrier.getType();
                this.f7842e.f7880k0 = barrier.getReferencedIds();
                this.f7842e.f7876i0 = barrier.getMargin();
            }
        }

        public void d(a aVar) {
            C0063a c0063a = this.f7845h;
            if (c0063a != null) {
                c0063a.e(aVar);
            }
        }

        public void e(ConstraintLayout.b bVar) {
            C0064b c0064b = this.f7842e;
            bVar.f7745e = c0064b.f7877j;
            bVar.f7747f = c0064b.f7879k;
            bVar.f7749g = c0064b.f7881l;
            bVar.f7751h = c0064b.f7883m;
            bVar.f7753i = c0064b.f7885n;
            bVar.f7755j = c0064b.f7887o;
            bVar.f7757k = c0064b.f7889p;
            bVar.f7759l = c0064b.f7891q;
            bVar.f7761m = c0064b.f7893r;
            bVar.f7763n = c0064b.f7894s;
            bVar.f7765o = c0064b.f7895t;
            bVar.f7773s = c0064b.f7896u;
            bVar.f7775t = c0064b.f7897v;
            bVar.f7777u = c0064b.f7898w;
            bVar.f7779v = c0064b.f7899x;
            ((ViewGroup.MarginLayoutParams) bVar).leftMargin = c0064b.H;
            ((ViewGroup.MarginLayoutParams) bVar).rightMargin = c0064b.I;
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = c0064b.J;
            ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = c0064b.K;
            bVar.A = c0064b.T;
            bVar.B = c0064b.S;
            bVar.f7783x = c0064b.P;
            bVar.f7785z = c0064b.R;
            bVar.G = c0064b.f7900y;
            bVar.H = c0064b.f7901z;
            bVar.f7767p = c0064b.B;
            bVar.f7769q = c0064b.C;
            bVar.f7771r = c0064b.D;
            bVar.I = c0064b.A;
            bVar.X = c0064b.E;
            bVar.Y = c0064b.F;
            bVar.M = c0064b.V;
            bVar.L = c0064b.W;
            bVar.O = c0064b.Y;
            bVar.N = c0064b.X;
            bVar.f7738a0 = c0064b.f7886n0;
            bVar.f7740b0 = c0064b.f7888o0;
            bVar.P = c0064b.Z;
            bVar.Q = c0064b.f7860a0;
            bVar.T = c0064b.f7862b0;
            bVar.U = c0064b.f7864c0;
            bVar.R = c0064b.f7866d0;
            bVar.S = c0064b.f7868e0;
            bVar.V = c0064b.f7870f0;
            bVar.W = c0064b.f7872g0;
            bVar.Z = c0064b.G;
            bVar.f7741c = c0064b.f7873h;
            bVar.f7737a = c0064b.f7869f;
            bVar.f7739b = c0064b.f7871g;
            ((ViewGroup.MarginLayoutParams) bVar).width = c0064b.f7865d;
            ((ViewGroup.MarginLayoutParams) bVar).height = c0064b.f7867e;
            String str = c0064b.f7884m0;
            if (str != null) {
                bVar.f7742c0 = str;
            }
            bVar.f7744d0 = c0064b.f7892q0;
            bVar.setMarginStart(c0064b.M);
            bVar.setMarginEnd(this.f7842e.L);
            bVar.c();
        }

        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a aVar = new a();
            aVar.f7842e.a(this.f7842e);
            aVar.f7841d.a(this.f7841d);
            aVar.f7840c.a(this.f7840c);
            aVar.f7843f.a(this.f7843f);
            aVar.f7838a = this.f7838a;
            aVar.f7845h = this.f7845h;
            return aVar;
        }
    }

    /* renamed from: androidx.constraintlayout.widget.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0064b {

        /* renamed from: r0, reason: collision with root package name */
        private static SparseIntArray f7858r0;

        /* renamed from: d, reason: collision with root package name */
        public int f7865d;

        /* renamed from: e, reason: collision with root package name */
        public int f7867e;

        /* renamed from: k0, reason: collision with root package name */
        public int[] f7880k0;

        /* renamed from: l0, reason: collision with root package name */
        public String f7882l0;

        /* renamed from: m0, reason: collision with root package name */
        public String f7884m0;

        /* renamed from: a, reason: collision with root package name */
        public boolean f7859a = false;

        /* renamed from: b, reason: collision with root package name */
        public boolean f7861b = false;

        /* renamed from: c, reason: collision with root package name */
        public boolean f7863c = false;

        /* renamed from: f, reason: collision with root package name */
        public int f7869f = -1;

        /* renamed from: g, reason: collision with root package name */
        public int f7871g = -1;

        /* renamed from: h, reason: collision with root package name */
        public float f7873h = -1.0f;

        /* renamed from: i, reason: collision with root package name */
        public boolean f7875i = true;

        /* renamed from: j, reason: collision with root package name */
        public int f7877j = -1;

        /* renamed from: k, reason: collision with root package name */
        public int f7879k = -1;

        /* renamed from: l, reason: collision with root package name */
        public int f7881l = -1;

        /* renamed from: m, reason: collision with root package name */
        public int f7883m = -1;

        /* renamed from: n, reason: collision with root package name */
        public int f7885n = -1;

        /* renamed from: o, reason: collision with root package name */
        public int f7887o = -1;

        /* renamed from: p, reason: collision with root package name */
        public int f7889p = -1;

        /* renamed from: q, reason: collision with root package name */
        public int f7891q = -1;

        /* renamed from: r, reason: collision with root package name */
        public int f7893r = -1;

        /* renamed from: s, reason: collision with root package name */
        public int f7894s = -1;

        /* renamed from: t, reason: collision with root package name */
        public int f7895t = -1;

        /* renamed from: u, reason: collision with root package name */
        public int f7896u = -1;

        /* renamed from: v, reason: collision with root package name */
        public int f7897v = -1;

        /* renamed from: w, reason: collision with root package name */
        public int f7898w = -1;

        /* renamed from: x, reason: collision with root package name */
        public int f7899x = -1;

        /* renamed from: y, reason: collision with root package name */
        public float f7900y = 0.5f;

        /* renamed from: z, reason: collision with root package name */
        public float f7901z = 0.5f;
        public String A = null;
        public int B = -1;
        public int C = 0;
        public float D = 0.0f;
        public int E = -1;
        public int F = -1;
        public int G = -1;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = 0;
        public int N = 0;
        public int O = Integer.MIN_VALUE;
        public int P = Integer.MIN_VALUE;
        public int Q = Integer.MIN_VALUE;
        public int R = Integer.MIN_VALUE;
        public int S = Integer.MIN_VALUE;
        public int T = Integer.MIN_VALUE;
        public int U = Integer.MIN_VALUE;
        public float V = -1.0f;
        public float W = -1.0f;
        public int X = 0;
        public int Y = 0;
        public int Z = 0;

        /* renamed from: a0, reason: collision with root package name */
        public int f7860a0 = 0;

        /* renamed from: b0, reason: collision with root package name */
        public int f7862b0 = 0;

        /* renamed from: c0, reason: collision with root package name */
        public int f7864c0 = 0;

        /* renamed from: d0, reason: collision with root package name */
        public int f7866d0 = 0;

        /* renamed from: e0, reason: collision with root package name */
        public int f7868e0 = 0;

        /* renamed from: f0, reason: collision with root package name */
        public float f7870f0 = 1.0f;

        /* renamed from: g0, reason: collision with root package name */
        public float f7872g0 = 1.0f;

        /* renamed from: h0, reason: collision with root package name */
        public int f7874h0 = -1;

        /* renamed from: i0, reason: collision with root package name */
        public int f7876i0 = 0;

        /* renamed from: j0, reason: collision with root package name */
        public int f7878j0 = -1;

        /* renamed from: n0, reason: collision with root package name */
        public boolean f7886n0 = false;

        /* renamed from: o0, reason: collision with root package name */
        public boolean f7888o0 = false;

        /* renamed from: p0, reason: collision with root package name */
        public boolean f7890p0 = true;

        /* renamed from: q0, reason: collision with root package name */
        public int f7892q0 = 0;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f7858r0 = sparseIntArray;
            sparseIntArray.append(R$styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            f7858r0.append(R$styleable.Layout_layout_constraintLeft_toRightOf, 25);
            f7858r0.append(R$styleable.Layout_layout_constraintRight_toLeftOf, 28);
            f7858r0.append(R$styleable.Layout_layout_constraintRight_toRightOf, 29);
            f7858r0.append(R$styleable.Layout_layout_constraintTop_toTopOf, 35);
            f7858r0.append(R$styleable.Layout_layout_constraintTop_toBottomOf, 34);
            f7858r0.append(R$styleable.Layout_layout_constraintBottom_toTopOf, 4);
            f7858r0.append(R$styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            f7858r0.append(R$styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            f7858r0.append(R$styleable.Layout_layout_editor_absoluteX, 6);
            f7858r0.append(R$styleable.Layout_layout_editor_absoluteY, 7);
            f7858r0.append(R$styleable.Layout_layout_constraintGuide_begin, 17);
            f7858r0.append(R$styleable.Layout_layout_constraintGuide_end, 18);
            f7858r0.append(R$styleable.Layout_layout_constraintGuide_percent, 19);
            f7858r0.append(R$styleable.Layout_guidelineUseRtl, 90);
            f7858r0.append(R$styleable.Layout_android_orientation, 26);
            f7858r0.append(R$styleable.Layout_layout_constraintStart_toEndOf, 31);
            f7858r0.append(R$styleable.Layout_layout_constraintStart_toStartOf, 32);
            f7858r0.append(R$styleable.Layout_layout_constraintEnd_toStartOf, 10);
            f7858r0.append(R$styleable.Layout_layout_constraintEnd_toEndOf, 9);
            f7858r0.append(R$styleable.Layout_layout_goneMarginLeft, 13);
            f7858r0.append(R$styleable.Layout_layout_goneMarginTop, 16);
            f7858r0.append(R$styleable.Layout_layout_goneMarginRight, 14);
            f7858r0.append(R$styleable.Layout_layout_goneMarginBottom, 11);
            f7858r0.append(R$styleable.Layout_layout_goneMarginStart, 15);
            f7858r0.append(R$styleable.Layout_layout_goneMarginEnd, 12);
            f7858r0.append(R$styleable.Layout_layout_constraintVertical_weight, 38);
            f7858r0.append(R$styleable.Layout_layout_constraintHorizontal_weight, 37);
            f7858r0.append(R$styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            f7858r0.append(R$styleable.Layout_layout_constraintVertical_chainStyle, 40);
            f7858r0.append(R$styleable.Layout_layout_constraintHorizontal_bias, 20);
            f7858r0.append(R$styleable.Layout_layout_constraintVertical_bias, 36);
            f7858r0.append(R$styleable.Layout_layout_constraintDimensionRatio, 5);
            f7858r0.append(R$styleable.Layout_layout_constraintLeft_creator, 91);
            f7858r0.append(R$styleable.Layout_layout_constraintTop_creator, 91);
            f7858r0.append(R$styleable.Layout_layout_constraintRight_creator, 91);
            f7858r0.append(R$styleable.Layout_layout_constraintBottom_creator, 91);
            f7858r0.append(R$styleable.Layout_layout_constraintBaseline_creator, 91);
            f7858r0.append(R$styleable.Layout_android_layout_marginLeft, 23);
            f7858r0.append(R$styleable.Layout_android_layout_marginRight, 27);
            f7858r0.append(R$styleable.Layout_android_layout_marginStart, 30);
            f7858r0.append(R$styleable.Layout_android_layout_marginEnd, 8);
            f7858r0.append(R$styleable.Layout_android_layout_marginTop, 33);
            f7858r0.append(R$styleable.Layout_android_layout_marginBottom, 2);
            f7858r0.append(R$styleable.Layout_android_layout_width, 22);
            f7858r0.append(R$styleable.Layout_android_layout_height, 21);
            f7858r0.append(R$styleable.Layout_layout_constraintWidth, 41);
            f7858r0.append(R$styleable.Layout_layout_constraintHeight, 42);
            f7858r0.append(R$styleable.Layout_layout_constrainedWidth, 41);
            f7858r0.append(R$styleable.Layout_layout_constrainedHeight, 42);
            f7858r0.append(R$styleable.Layout_layout_wrapBehaviorInParent, 76);
            f7858r0.append(R$styleable.Layout_layout_constraintCircle, 61);
            f7858r0.append(R$styleable.Layout_layout_constraintCircleRadius, 62);
            f7858r0.append(R$styleable.Layout_layout_constraintCircleAngle, 63);
            f7858r0.append(R$styleable.Layout_layout_constraintWidth_percent, 69);
            f7858r0.append(R$styleable.Layout_layout_constraintHeight_percent, 70);
            f7858r0.append(R$styleable.Layout_chainUseRtl, 71);
            f7858r0.append(R$styleable.Layout_barrierDirection, 72);
            f7858r0.append(R$styleable.Layout_barrierMargin, 73);
            f7858r0.append(R$styleable.Layout_constraint_referenced_ids, 74);
            f7858r0.append(R$styleable.Layout_barrierAllowsGoneWidgets, 75);
        }

        public void a(C0064b c0064b) {
            this.f7859a = c0064b.f7859a;
            this.f7865d = c0064b.f7865d;
            this.f7861b = c0064b.f7861b;
            this.f7867e = c0064b.f7867e;
            this.f7869f = c0064b.f7869f;
            this.f7871g = c0064b.f7871g;
            this.f7873h = c0064b.f7873h;
            this.f7875i = c0064b.f7875i;
            this.f7877j = c0064b.f7877j;
            this.f7879k = c0064b.f7879k;
            this.f7881l = c0064b.f7881l;
            this.f7883m = c0064b.f7883m;
            this.f7885n = c0064b.f7885n;
            this.f7887o = c0064b.f7887o;
            this.f7889p = c0064b.f7889p;
            this.f7891q = c0064b.f7891q;
            this.f7893r = c0064b.f7893r;
            this.f7894s = c0064b.f7894s;
            this.f7895t = c0064b.f7895t;
            this.f7896u = c0064b.f7896u;
            this.f7897v = c0064b.f7897v;
            this.f7898w = c0064b.f7898w;
            this.f7899x = c0064b.f7899x;
            this.f7900y = c0064b.f7900y;
            this.f7901z = c0064b.f7901z;
            this.A = c0064b.A;
            this.B = c0064b.B;
            this.C = c0064b.C;
            this.D = c0064b.D;
            this.E = c0064b.E;
            this.F = c0064b.F;
            this.G = c0064b.G;
            this.H = c0064b.H;
            this.I = c0064b.I;
            this.J = c0064b.J;
            this.K = c0064b.K;
            this.L = c0064b.L;
            this.M = c0064b.M;
            this.N = c0064b.N;
            this.O = c0064b.O;
            this.P = c0064b.P;
            this.Q = c0064b.Q;
            this.R = c0064b.R;
            this.S = c0064b.S;
            this.T = c0064b.T;
            this.U = c0064b.U;
            this.V = c0064b.V;
            this.W = c0064b.W;
            this.X = c0064b.X;
            this.Y = c0064b.Y;
            this.Z = c0064b.Z;
            this.f7860a0 = c0064b.f7860a0;
            this.f7862b0 = c0064b.f7862b0;
            this.f7864c0 = c0064b.f7864c0;
            this.f7866d0 = c0064b.f7866d0;
            this.f7868e0 = c0064b.f7868e0;
            this.f7870f0 = c0064b.f7870f0;
            this.f7872g0 = c0064b.f7872g0;
            this.f7874h0 = c0064b.f7874h0;
            this.f7876i0 = c0064b.f7876i0;
            this.f7878j0 = c0064b.f7878j0;
            this.f7884m0 = c0064b.f7884m0;
            int[] iArr = c0064b.f7880k0;
            if (iArr == null || c0064b.f7882l0 != null) {
                this.f7880k0 = null;
            } else {
                this.f7880k0 = Arrays.copyOf(iArr, iArr.length);
            }
            this.f7882l0 = c0064b.f7882l0;
            this.f7886n0 = c0064b.f7886n0;
            this.f7888o0 = c0064b.f7888o0;
            this.f7890p0 = c0064b.f7890p0;
            this.f7892q0 = c0064b.f7892q0;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Layout);
            this.f7861b = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                int i12 = f7858r0.get(index);
                switch (i12) {
                    case 1:
                        this.f7893r = b.J(obtainStyledAttributes, index, this.f7893r);
                        break;
                    case 2:
                        this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                        break;
                    case 3:
                        this.f7891q = b.J(obtainStyledAttributes, index, this.f7891q);
                        break;
                    case 4:
                        this.f7889p = b.J(obtainStyledAttributes, index, this.f7889p);
                        break;
                    case 5:
                        this.A = obtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.E = obtainStyledAttributes.getDimensionPixelOffset(index, this.E);
                        break;
                    case 7:
                        this.F = obtainStyledAttributes.getDimensionPixelOffset(index, this.F);
                        break;
                    case 8:
                        this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                        break;
                    case 9:
                        this.f7899x = b.J(obtainStyledAttributes, index, this.f7899x);
                        break;
                    case 10:
                        this.f7898w = b.J(obtainStyledAttributes, index, this.f7898w);
                        break;
                    case 11:
                        this.R = obtainStyledAttributes.getDimensionPixelSize(index, this.R);
                        break;
                    case 12:
                        this.S = obtainStyledAttributes.getDimensionPixelSize(index, this.S);
                        break;
                    case 13:
                        this.O = obtainStyledAttributes.getDimensionPixelSize(index, this.O);
                        break;
                    case 14:
                        this.Q = obtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                        break;
                    case 15:
                        this.T = obtainStyledAttributes.getDimensionPixelSize(index, this.T);
                        break;
                    case 16:
                        this.P = obtainStyledAttributes.getDimensionPixelSize(index, this.P);
                        break;
                    case 17:
                        this.f7869f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f7869f);
                        break;
                    case 18:
                        this.f7871g = obtainStyledAttributes.getDimensionPixelOffset(index, this.f7871g);
                        break;
                    case 19:
                        this.f7873h = obtainStyledAttributes.getFloat(index, this.f7873h);
                        break;
                    case 20:
                        this.f7900y = obtainStyledAttributes.getFloat(index, this.f7900y);
                        break;
                    case 21:
                        this.f7867e = obtainStyledAttributes.getLayoutDimension(index, this.f7867e);
                        break;
                    case 22:
                        this.f7865d = obtainStyledAttributes.getLayoutDimension(index, this.f7865d);
                        break;
                    case 23:
                        this.H = obtainStyledAttributes.getDimensionPixelSize(index, this.H);
                        break;
                    case 24:
                        this.f7877j = b.J(obtainStyledAttributes, index, this.f7877j);
                        break;
                    case 25:
                        this.f7879k = b.J(obtainStyledAttributes, index, this.f7879k);
                        break;
                    case 26:
                        this.G = obtainStyledAttributes.getInt(index, this.G);
                        break;
                    case 27:
                        this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                        break;
                    case 28:
                        this.f7881l = b.J(obtainStyledAttributes, index, this.f7881l);
                        break;
                    case NOTIFICATION_REDIRECT_VALUE:
                        this.f7883m = b.J(obtainStyledAttributes, index, this.f7883m);
                        break;
                    case 30:
                        this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                        break;
                    case TEMPLATE_HTML_SIZE_VALUE:
                        this.f7896u = b.J(obtainStyledAttributes, index, this.f7896u);
                        break;
                    case 32:
                        this.f7897v = b.J(obtainStyledAttributes, index, this.f7897v);
                        break;
                    case 33:
                        this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                        break;
                    case 34:
                        this.f7887o = b.J(obtainStyledAttributes, index, this.f7887o);
                        break;
                    case 35:
                        this.f7885n = b.J(obtainStyledAttributes, index, this.f7885n);
                        break;
                    case 36:
                        this.f7901z = obtainStyledAttributes.getFloat(index, this.f7901z);
                        break;
                    case 37:
                        this.W = obtainStyledAttributes.getFloat(index, this.W);
                        break;
                    case 38:
                        this.V = obtainStyledAttributes.getFloat(index, this.V);
                        break;
                    case 39:
                        this.X = obtainStyledAttributes.getInt(index, this.X);
                        break;
                    case 40:
                        this.Y = obtainStyledAttributes.getInt(index, this.Y);
                        break;
                    case 41:
                        b.K(this, obtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        b.K(this, obtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i12) {
                            case 61:
                                this.B = b.J(obtainStyledAttributes, index, this.B);
                                break;
                            case 62:
                                this.C = obtainStyledAttributes.getDimensionPixelSize(index, this.C);
                                break;
                            case 63:
                                this.D = obtainStyledAttributes.getFloat(index, this.D);
                                break;
                            default:
                                switch (i12) {
                                    case 69:
                                        this.f7870f0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 70:
                                        this.f7872g0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 71:
                                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                        break;
                                    case 72:
                                        this.f7874h0 = obtainStyledAttributes.getInt(index, this.f7874h0);
                                        break;
                                    case 73:
                                        this.f7876i0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f7876i0);
                                        break;
                                    case 74:
                                        this.f7882l0 = obtainStyledAttributes.getString(index);
                                        break;
                                    case 75:
                                        this.f7890p0 = obtainStyledAttributes.getBoolean(index, this.f7890p0);
                                        break;
                                    case 76:
                                        this.f7892q0 = obtainStyledAttributes.getInt(index, this.f7892q0);
                                        break;
                                    case 77:
                                        this.f7894s = b.J(obtainStyledAttributes, index, this.f7894s);
                                        break;
                                    case 78:
                                        this.f7895t = b.J(obtainStyledAttributes, index, this.f7895t);
                                        break;
                                    case 79:
                                        this.U = obtainStyledAttributes.getDimensionPixelSize(index, this.U);
                                        break;
                                    case 80:
                                        this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                                        break;
                                    case TmcConstants.NOTIFY_ADDHOME_GUIDE_TOP_SHOW /* 81 */:
                                        this.Z = obtainStyledAttributes.getInt(index, this.Z);
                                        break;
                                    case TmcConstants.NOTIFY_ADDHOME_GUIDE_BOTTOM_SHOW /* 82 */:
                                        this.f7860a0 = obtainStyledAttributes.getInt(index, this.f7860a0);
                                        break;
                                    case TmcConstants.NOTIFY_ADDHOME_GUIDE_BACK_SHOW /* 83 */:
                                        this.f7864c0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f7864c0);
                                        break;
                                    case 84:
                                        this.f7862b0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f7862b0);
                                        break;
                                    case 85:
                                        this.f7868e0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f7868e0);
                                        break;
                                    case 86:
                                        this.f7866d0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f7866d0);
                                        break;
                                    case 87:
                                        this.f7886n0 = obtainStyledAttributes.getBoolean(index, this.f7886n0);
                                        break;
                                    case 88:
                                        this.f7888o0 = obtainStyledAttributes.getBoolean(index, this.f7888o0);
                                        break;
                                    case TsExtractor.TS_STREAM_TYPE_DVBSUBS /* 89 */:
                                        this.f7884m0 = obtainStyledAttributes.getString(index);
                                        break;
                                    case TmcConstants.NOTIFY_ADDHOME_API_SHOW /* 90 */:
                                        this.f7875i = obtainStyledAttributes.getBoolean(index, this.f7875i);
                                        break;
                                    case 91:
                                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f7858r0.get(index));
                                        break;
                                    default:
                                        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f7858r0.get(index));
                                        break;
                                }
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: o, reason: collision with root package name */
        private static SparseIntArray f7902o;

        /* renamed from: a, reason: collision with root package name */
        public boolean f7903a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f7904b = -1;

        /* renamed from: c, reason: collision with root package name */
        public int f7905c = 0;

        /* renamed from: d, reason: collision with root package name */
        public String f7906d = null;

        /* renamed from: e, reason: collision with root package name */
        public int f7907e = -1;

        /* renamed from: f, reason: collision with root package name */
        public int f7908f = 0;

        /* renamed from: g, reason: collision with root package name */
        public float f7909g = Float.NaN;

        /* renamed from: h, reason: collision with root package name */
        public int f7910h = -1;

        /* renamed from: i, reason: collision with root package name */
        public float f7911i = Float.NaN;

        /* renamed from: j, reason: collision with root package name */
        public float f7912j = Float.NaN;

        /* renamed from: k, reason: collision with root package name */
        public int f7913k = -1;

        /* renamed from: l, reason: collision with root package name */
        public String f7914l = null;

        /* renamed from: m, reason: collision with root package name */
        public int f7915m = -3;

        /* renamed from: n, reason: collision with root package name */
        public int f7916n = -1;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f7902o = sparseIntArray;
            sparseIntArray.append(R$styleable.Motion_motionPathRotate, 1);
            f7902o.append(R$styleable.Motion_pathMotionArc, 2);
            f7902o.append(R$styleable.Motion_transitionEasing, 3);
            f7902o.append(R$styleable.Motion_drawPath, 4);
            f7902o.append(R$styleable.Motion_animateRelativeTo, 5);
            f7902o.append(R$styleable.Motion_animateCircleAngleTo, 6);
            f7902o.append(R$styleable.Motion_motionStagger, 7);
            f7902o.append(R$styleable.Motion_quantizeMotionSteps, 8);
            f7902o.append(R$styleable.Motion_quantizeMotionPhase, 9);
            f7902o.append(R$styleable.Motion_quantizeMotionInterpolator, 10);
        }

        public void a(c cVar) {
            this.f7903a = cVar.f7903a;
            this.f7904b = cVar.f7904b;
            this.f7906d = cVar.f7906d;
            this.f7907e = cVar.f7907e;
            this.f7908f = cVar.f7908f;
            this.f7911i = cVar.f7911i;
            this.f7909g = cVar.f7909g;
            this.f7910h = cVar.f7910h;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Motion);
            this.f7903a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                switch (f7902o.get(index)) {
                    case 1:
                        this.f7911i = obtainStyledAttributes.getFloat(index, this.f7911i);
                        break;
                    case 2:
                        this.f7907e = obtainStyledAttributes.getInt(index, this.f7907e);
                        break;
                    case 3:
                        if (obtainStyledAttributes.peekValue(index).type == 3) {
                            this.f7906d = obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            this.f7906d = androidx.constraintlayout.core.motion.utils.c.f6843c[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        this.f7908f = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f7904b = b.J(obtainStyledAttributes, index, this.f7904b);
                        break;
                    case 6:
                        this.f7905c = obtainStyledAttributes.getInteger(index, this.f7905c);
                        break;
                    case 7:
                        this.f7909g = obtainStyledAttributes.getFloat(index, this.f7909g);
                        break;
                    case 8:
                        this.f7913k = obtainStyledAttributes.getInteger(index, this.f7913k);
                        break;
                    case 9:
                        this.f7912j = obtainStyledAttributes.getFloat(index, this.f7912j);
                        break;
                    case 10:
                        int i12 = obtainStyledAttributes.peekValue(index).type;
                        if (i12 == 1) {
                            int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                            this.f7916n = resourceId;
                            if (resourceId != -1) {
                                this.f7915m = -2;
                                break;
                            } else {
                                break;
                            }
                        } else if (i12 == 3) {
                            String string = obtainStyledAttributes.getString(index);
                            this.f7914l = string;
                            if (string.indexOf("/") > 0) {
                                this.f7916n = obtainStyledAttributes.getResourceId(index, -1);
                                this.f7915m = -2;
                                break;
                            } else {
                                this.f7915m = -1;
                                break;
                            }
                        } else {
                            this.f7915m = obtainStyledAttributes.getInteger(index, this.f7916n);
                            break;
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public boolean f7917a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f7918b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f7919c = 0;

        /* renamed from: d, reason: collision with root package name */
        public float f7920d = 1.0f;

        /* renamed from: e, reason: collision with root package name */
        public float f7921e = Float.NaN;

        public void a(d dVar) {
            this.f7917a = dVar.f7917a;
            this.f7918b = dVar.f7918b;
            this.f7920d = dVar.f7920d;
            this.f7921e = dVar.f7921e;
            this.f7919c = dVar.f7919c;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PropertySet);
            this.f7917a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.PropertySet_android_alpha) {
                    this.f7920d = obtainStyledAttributes.getFloat(index, this.f7920d);
                } else if (index == R$styleable.PropertySet_android_visibility) {
                    this.f7918b = obtainStyledAttributes.getInt(index, this.f7918b);
                    this.f7918b = b.f7828h[this.f7918b];
                } else if (index == R$styleable.PropertySet_visibilityMode) {
                    this.f7919c = obtainStyledAttributes.getInt(index, this.f7919c);
                } else if (index == R$styleable.PropertySet_motionProgress) {
                    this.f7921e = obtainStyledAttributes.getFloat(index, this.f7921e);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: o, reason: collision with root package name */
        private static SparseIntArray f7922o;

        /* renamed from: a, reason: collision with root package name */
        public boolean f7923a = false;

        /* renamed from: b, reason: collision with root package name */
        public float f7924b = 0.0f;

        /* renamed from: c, reason: collision with root package name */
        public float f7925c = 0.0f;

        /* renamed from: d, reason: collision with root package name */
        public float f7926d = 0.0f;

        /* renamed from: e, reason: collision with root package name */
        public float f7927e = 1.0f;

        /* renamed from: f, reason: collision with root package name */
        public float f7928f = 1.0f;

        /* renamed from: g, reason: collision with root package name */
        public float f7929g = Float.NaN;

        /* renamed from: h, reason: collision with root package name */
        public float f7930h = Float.NaN;

        /* renamed from: i, reason: collision with root package name */
        public int f7931i = -1;

        /* renamed from: j, reason: collision with root package name */
        public float f7932j = 0.0f;

        /* renamed from: k, reason: collision with root package name */
        public float f7933k = 0.0f;

        /* renamed from: l, reason: collision with root package name */
        public float f7934l = 0.0f;

        /* renamed from: m, reason: collision with root package name */
        public boolean f7935m = false;

        /* renamed from: n, reason: collision with root package name */
        public float f7936n = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f7922o = sparseIntArray;
            sparseIntArray.append(R$styleable.Transform_android_rotation, 1);
            f7922o.append(R$styleable.Transform_android_rotationX, 2);
            f7922o.append(R$styleable.Transform_android_rotationY, 3);
            f7922o.append(R$styleable.Transform_android_scaleX, 4);
            f7922o.append(R$styleable.Transform_android_scaleY, 5);
            f7922o.append(R$styleable.Transform_android_transformPivotX, 6);
            f7922o.append(R$styleable.Transform_android_transformPivotY, 7);
            f7922o.append(R$styleable.Transform_android_translationX, 8);
            f7922o.append(R$styleable.Transform_android_translationY, 9);
            f7922o.append(R$styleable.Transform_android_translationZ, 10);
            f7922o.append(R$styleable.Transform_android_elevation, 11);
            f7922o.append(R$styleable.Transform_transformPivotTarget, 12);
        }

        public void a(e eVar) {
            this.f7923a = eVar.f7923a;
            this.f7924b = eVar.f7924b;
            this.f7925c = eVar.f7925c;
            this.f7926d = eVar.f7926d;
            this.f7927e = eVar.f7927e;
            this.f7928f = eVar.f7928f;
            this.f7929g = eVar.f7929g;
            this.f7930h = eVar.f7930h;
            this.f7931i = eVar.f7931i;
            this.f7932j = eVar.f7932j;
            this.f7933k = eVar.f7933k;
            this.f7934l = eVar.f7934l;
            this.f7935m = eVar.f7935m;
            this.f7936n = eVar.f7936n;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Transform);
            this.f7923a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                switch (f7922o.get(index)) {
                    case 1:
                        this.f7924b = obtainStyledAttributes.getFloat(index, this.f7924b);
                        break;
                    case 2:
                        this.f7925c = obtainStyledAttributes.getFloat(index, this.f7925c);
                        break;
                    case 3:
                        this.f7926d = obtainStyledAttributes.getFloat(index, this.f7926d);
                        break;
                    case 4:
                        this.f7927e = obtainStyledAttributes.getFloat(index, this.f7927e);
                        break;
                    case 5:
                        this.f7928f = obtainStyledAttributes.getFloat(index, this.f7928f);
                        break;
                    case 6:
                        this.f7929g = obtainStyledAttributes.getDimension(index, this.f7929g);
                        break;
                    case 7:
                        this.f7930h = obtainStyledAttributes.getDimension(index, this.f7930h);
                        break;
                    case 8:
                        this.f7932j = obtainStyledAttributes.getDimension(index, this.f7932j);
                        break;
                    case 9:
                        this.f7933k = obtainStyledAttributes.getDimension(index, this.f7933k);
                        break;
                    case 10:
                        this.f7934l = obtainStyledAttributes.getDimension(index, this.f7934l);
                        break;
                    case 11:
                        this.f7935m = true;
                        this.f7936n = obtainStyledAttributes.getDimension(index, this.f7936n);
                        break;
                    case 12:
                        this.f7931i = b.J(obtainStyledAttributes, index, this.f7931i);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    static {
        f7829i.append(R$styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        f7829i.append(R$styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        f7829i.append(R$styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        f7829i.append(R$styleable.Constraint_layout_constraintRight_toRightOf, 30);
        f7829i.append(R$styleable.Constraint_layout_constraintTop_toTopOf, 36);
        f7829i.append(R$styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        f7829i.append(R$styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        f7829i.append(R$styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        f7829i.append(R$styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        f7829i.append(R$styleable.Constraint_layout_constraintBaseline_toTopOf, 91);
        f7829i.append(R$styleable.Constraint_layout_constraintBaseline_toBottomOf, 92);
        f7829i.append(R$styleable.Constraint_layout_editor_absoluteX, 6);
        f7829i.append(R$styleable.Constraint_layout_editor_absoluteY, 7);
        f7829i.append(R$styleable.Constraint_layout_constraintGuide_begin, 17);
        f7829i.append(R$styleable.Constraint_layout_constraintGuide_end, 18);
        f7829i.append(R$styleable.Constraint_layout_constraintGuide_percent, 19);
        f7829i.append(R$styleable.Constraint_guidelineUseRtl, 99);
        f7829i.append(R$styleable.Constraint_android_orientation, 27);
        f7829i.append(R$styleable.Constraint_layout_constraintStart_toEndOf, 32);
        f7829i.append(R$styleable.Constraint_layout_constraintStart_toStartOf, 33);
        f7829i.append(R$styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        f7829i.append(R$styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        f7829i.append(R$styleable.Constraint_layout_goneMarginLeft, 13);
        f7829i.append(R$styleable.Constraint_layout_goneMarginTop, 16);
        f7829i.append(R$styleable.Constraint_layout_goneMarginRight, 14);
        f7829i.append(R$styleable.Constraint_layout_goneMarginBottom, 11);
        f7829i.append(R$styleable.Constraint_layout_goneMarginStart, 15);
        f7829i.append(R$styleable.Constraint_layout_goneMarginEnd, 12);
        f7829i.append(R$styleable.Constraint_layout_constraintVertical_weight, 40);
        f7829i.append(R$styleable.Constraint_layout_constraintHorizontal_weight, 39);
        f7829i.append(R$styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        f7829i.append(R$styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        f7829i.append(R$styleable.Constraint_layout_constraintHorizontal_bias, 20);
        f7829i.append(R$styleable.Constraint_layout_constraintVertical_bias, 37);
        f7829i.append(R$styleable.Constraint_layout_constraintDimensionRatio, 5);
        f7829i.append(R$styleable.Constraint_layout_constraintLeft_creator, 87);
        f7829i.append(R$styleable.Constraint_layout_constraintTop_creator, 87);
        f7829i.append(R$styleable.Constraint_layout_constraintRight_creator, 87);
        f7829i.append(R$styleable.Constraint_layout_constraintBottom_creator, 87);
        f7829i.append(R$styleable.Constraint_layout_constraintBaseline_creator, 87);
        f7829i.append(R$styleable.Constraint_android_layout_marginLeft, 24);
        f7829i.append(R$styleable.Constraint_android_layout_marginRight, 28);
        f7829i.append(R$styleable.Constraint_android_layout_marginStart, 31);
        f7829i.append(R$styleable.Constraint_android_layout_marginEnd, 8);
        f7829i.append(R$styleable.Constraint_android_layout_marginTop, 34);
        f7829i.append(R$styleable.Constraint_android_layout_marginBottom, 2);
        f7829i.append(R$styleable.Constraint_android_layout_width, 23);
        f7829i.append(R$styleable.Constraint_android_layout_height, 21);
        f7829i.append(R$styleable.Constraint_layout_constraintWidth, 95);
        f7829i.append(R$styleable.Constraint_layout_constraintHeight, 96);
        f7829i.append(R$styleable.Constraint_android_visibility, 22);
        f7829i.append(R$styleable.Constraint_android_alpha, 43);
        f7829i.append(R$styleable.Constraint_android_elevation, 44);
        f7829i.append(R$styleable.Constraint_android_rotationX, 45);
        f7829i.append(R$styleable.Constraint_android_rotationY, 46);
        f7829i.append(R$styleable.Constraint_android_rotation, 60);
        f7829i.append(R$styleable.Constraint_android_scaleX, 47);
        f7829i.append(R$styleable.Constraint_android_scaleY, 48);
        f7829i.append(R$styleable.Constraint_android_transformPivotX, 49);
        f7829i.append(R$styleable.Constraint_android_transformPivotY, 50);
        f7829i.append(R$styleable.Constraint_android_translationX, 51);
        f7829i.append(R$styleable.Constraint_android_translationY, 52);
        f7829i.append(R$styleable.Constraint_android_translationZ, 53);
        f7829i.append(R$styleable.Constraint_layout_constraintWidth_default, 54);
        f7829i.append(R$styleable.Constraint_layout_constraintHeight_default, 55);
        f7829i.append(R$styleable.Constraint_layout_constraintWidth_max, 56);
        f7829i.append(R$styleable.Constraint_layout_constraintHeight_max, 57);
        f7829i.append(R$styleable.Constraint_layout_constraintWidth_min, 58);
        f7829i.append(R$styleable.Constraint_layout_constraintHeight_min, 59);
        f7829i.append(R$styleable.Constraint_layout_constraintCircle, 61);
        f7829i.append(R$styleable.Constraint_layout_constraintCircleRadius, 62);
        f7829i.append(R$styleable.Constraint_layout_constraintCircleAngle, 63);
        f7829i.append(R$styleable.Constraint_animateRelativeTo, 64);
        f7829i.append(R$styleable.Constraint_transitionEasing, 65);
        f7829i.append(R$styleable.Constraint_drawPath, 66);
        f7829i.append(R$styleable.Constraint_transitionPathRotate, 67);
        f7829i.append(R$styleable.Constraint_motionStagger, 79);
        f7829i.append(R$styleable.Constraint_android_id, 38);
        f7829i.append(R$styleable.Constraint_motionProgress, 68);
        f7829i.append(R$styleable.Constraint_layout_constraintWidth_percent, 69);
        f7829i.append(R$styleable.Constraint_layout_constraintHeight_percent, 70);
        f7829i.append(R$styleable.Constraint_layout_wrapBehaviorInParent, 97);
        f7829i.append(R$styleable.Constraint_chainUseRtl, 71);
        f7829i.append(R$styleable.Constraint_barrierDirection, 72);
        f7829i.append(R$styleable.Constraint_barrierMargin, 73);
        f7829i.append(R$styleable.Constraint_constraint_referenced_ids, 74);
        f7829i.append(R$styleable.Constraint_barrierAllowsGoneWidgets, 75);
        f7829i.append(R$styleable.Constraint_pathMotionArc, 76);
        f7829i.append(R$styleable.Constraint_layout_constraintTag, 77);
        f7829i.append(R$styleable.Constraint_visibilityMode, 78);
        f7829i.append(R$styleable.Constraint_layout_constrainedWidth, 80);
        f7829i.append(R$styleable.Constraint_layout_constrainedHeight, 81);
        f7829i.append(R$styleable.Constraint_polarRelativeTo, 82);
        f7829i.append(R$styleable.Constraint_transformPivotTarget, 83);
        f7829i.append(R$styleable.Constraint_quantizeMotionSteps, 84);
        f7829i.append(R$styleable.Constraint_quantizeMotionPhase, 85);
        f7829i.append(R$styleable.Constraint_quantizeMotionInterpolator, 86);
        f7830j.append(R$styleable.ConstraintOverride_layout_editor_absoluteY, 6);
        f7830j.append(R$styleable.ConstraintOverride_layout_editor_absoluteY, 7);
        f7830j.append(R$styleable.ConstraintOverride_android_orientation, 27);
        f7830j.append(R$styleable.ConstraintOverride_layout_goneMarginLeft, 13);
        f7830j.append(R$styleable.ConstraintOverride_layout_goneMarginTop, 16);
        f7830j.append(R$styleable.ConstraintOverride_layout_goneMarginRight, 14);
        f7830j.append(R$styleable.ConstraintOverride_layout_goneMarginBottom, 11);
        f7830j.append(R$styleable.ConstraintOverride_layout_goneMarginStart, 15);
        f7830j.append(R$styleable.ConstraintOverride_layout_goneMarginEnd, 12);
        f7830j.append(R$styleable.ConstraintOverride_layout_constraintVertical_weight, 40);
        f7830j.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        f7830j.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        f7830j.append(R$styleable.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        f7830j.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        f7830j.append(R$styleable.ConstraintOverride_layout_constraintVertical_bias, 37);
        f7830j.append(R$styleable.ConstraintOverride_layout_constraintDimensionRatio, 5);
        f7830j.append(R$styleable.ConstraintOverride_layout_constraintLeft_creator, 87);
        f7830j.append(R$styleable.ConstraintOverride_layout_constraintTop_creator, 87);
        f7830j.append(R$styleable.ConstraintOverride_layout_constraintRight_creator, 87);
        f7830j.append(R$styleable.ConstraintOverride_layout_constraintBottom_creator, 87);
        f7830j.append(R$styleable.ConstraintOverride_layout_constraintBaseline_creator, 87);
        f7830j.append(R$styleable.ConstraintOverride_android_layout_marginLeft, 24);
        f7830j.append(R$styleable.ConstraintOverride_android_layout_marginRight, 28);
        f7830j.append(R$styleable.ConstraintOverride_android_layout_marginStart, 31);
        f7830j.append(R$styleable.ConstraintOverride_android_layout_marginEnd, 8);
        f7830j.append(R$styleable.ConstraintOverride_android_layout_marginTop, 34);
        f7830j.append(R$styleable.ConstraintOverride_android_layout_marginBottom, 2);
        f7830j.append(R$styleable.ConstraintOverride_android_layout_width, 23);
        f7830j.append(R$styleable.ConstraintOverride_android_layout_height, 21);
        f7830j.append(R$styleable.ConstraintOverride_layout_constraintWidth, 95);
        f7830j.append(R$styleable.ConstraintOverride_layout_constraintHeight, 96);
        f7830j.append(R$styleable.ConstraintOverride_android_visibility, 22);
        f7830j.append(R$styleable.ConstraintOverride_android_alpha, 43);
        f7830j.append(R$styleable.ConstraintOverride_android_elevation, 44);
        f7830j.append(R$styleable.ConstraintOverride_android_rotationX, 45);
        f7830j.append(R$styleable.ConstraintOverride_android_rotationY, 46);
        f7830j.append(R$styleable.ConstraintOverride_android_rotation, 60);
        f7830j.append(R$styleable.ConstraintOverride_android_scaleX, 47);
        f7830j.append(R$styleable.ConstraintOverride_android_scaleY, 48);
        f7830j.append(R$styleable.ConstraintOverride_android_transformPivotX, 49);
        f7830j.append(R$styleable.ConstraintOverride_android_transformPivotY, 50);
        f7830j.append(R$styleable.ConstraintOverride_android_translationX, 51);
        f7830j.append(R$styleable.ConstraintOverride_android_translationY, 52);
        f7830j.append(R$styleable.ConstraintOverride_android_translationZ, 53);
        f7830j.append(R$styleable.ConstraintOverride_layout_constraintWidth_default, 54);
        f7830j.append(R$styleable.ConstraintOverride_layout_constraintHeight_default, 55);
        f7830j.append(R$styleable.ConstraintOverride_layout_constraintWidth_max, 56);
        f7830j.append(R$styleable.ConstraintOverride_layout_constraintHeight_max, 57);
        f7830j.append(R$styleable.ConstraintOverride_layout_constraintWidth_min, 58);
        f7830j.append(R$styleable.ConstraintOverride_layout_constraintHeight_min, 59);
        f7830j.append(R$styleable.ConstraintOverride_layout_constraintCircleRadius, 62);
        f7830j.append(R$styleable.ConstraintOverride_layout_constraintCircleAngle, 63);
        f7830j.append(R$styleable.ConstraintOverride_animateRelativeTo, 64);
        f7830j.append(R$styleable.ConstraintOverride_transitionEasing, 65);
        f7830j.append(R$styleable.ConstraintOverride_drawPath, 66);
        f7830j.append(R$styleable.ConstraintOverride_transitionPathRotate, 67);
        f7830j.append(R$styleable.ConstraintOverride_motionStagger, 79);
        f7830j.append(R$styleable.ConstraintOverride_android_id, 38);
        f7830j.append(R$styleable.ConstraintOverride_motionTarget, 98);
        f7830j.append(R$styleable.ConstraintOverride_motionProgress, 68);
        f7830j.append(R$styleable.ConstraintOverride_layout_constraintWidth_percent, 69);
        f7830j.append(R$styleable.ConstraintOverride_layout_constraintHeight_percent, 70);
        f7830j.append(R$styleable.ConstraintOverride_chainUseRtl, 71);
        f7830j.append(R$styleable.ConstraintOverride_barrierDirection, 72);
        f7830j.append(R$styleable.ConstraintOverride_barrierMargin, 73);
        f7830j.append(R$styleable.ConstraintOverride_constraint_referenced_ids, 74);
        f7830j.append(R$styleable.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        f7830j.append(R$styleable.ConstraintOverride_pathMotionArc, 76);
        f7830j.append(R$styleable.ConstraintOverride_layout_constraintTag, 77);
        f7830j.append(R$styleable.ConstraintOverride_visibilityMode, 78);
        f7830j.append(R$styleable.ConstraintOverride_layout_constrainedWidth, 80);
        f7830j.append(R$styleable.ConstraintOverride_layout_constrainedHeight, 81);
        f7830j.append(R$styleable.ConstraintOverride_polarRelativeTo, 82);
        f7830j.append(R$styleable.ConstraintOverride_transformPivotTarget, 83);
        f7830j.append(R$styleable.ConstraintOverride_quantizeMotionSteps, 84);
        f7830j.append(R$styleable.ConstraintOverride_quantizeMotionPhase, 85);
        f7830j.append(R$styleable.ConstraintOverride_quantizeMotionInterpolator, 86);
        f7830j.append(R$styleable.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int J(TypedArray typedArray, int i11, int i12) {
        int resourceId = typedArray.getResourceId(i11, i12);
        return resourceId == -1 ? typedArray.getInt(i11, -1) : resourceId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void K(java.lang.Object r4, android.content.res.TypedArray r5, int r6, int r7) {
        /*
            if (r4 != 0) goto L3
            return
        L3:
            android.util.TypedValue r0 = r5.peekValue(r6)
            int r0 = r0.type
            r1 = 3
            if (r0 == r1) goto L71
            r1 = 5
            r2 = 0
            if (r0 == r1) goto L2a
            int r5 = r5.getInt(r6, r2)
            r6 = -4
            r0 = -2
            if (r5 == r6) goto L26
            r6 = -3
            if (r5 == r6) goto L20
            if (r5 == r0) goto L22
            r6 = -1
            if (r5 == r6) goto L22
        L20:
            r5 = r2
            goto L2f
        L22:
            r3 = r2
            r2 = r5
            r5 = r3
            goto L2f
        L26:
            r2 = 1
            r5 = r2
            r2 = r0
            goto L2f
        L2a:
            int r5 = r5.getDimensionPixelSize(r6, r2)
            goto L22
        L2f:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.ConstraintLayout.b
            if (r6 == 0) goto L41
            androidx.constraintlayout.widget.ConstraintLayout$b r4 = (androidx.constraintlayout.widget.ConstraintLayout.b) r4
            if (r7 != 0) goto L3c
            r4.width = r2
            r4.f7738a0 = r5
            goto L70
        L3c:
            r4.height = r2
            r4.f7740b0 = r5
            goto L70
        L41:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.b.C0064b
            if (r6 == 0) goto L53
            androidx.constraintlayout.widget.b$b r4 = (androidx.constraintlayout.widget.b.C0064b) r4
            if (r7 != 0) goto L4e
            r4.f7865d = r2
            r4.f7886n0 = r5
            goto L70
        L4e:
            r4.f7867e = r2
            r4.f7888o0 = r5
            goto L70
        L53:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.b.a.C0063a
            if (r6 == 0) goto L70
            androidx.constraintlayout.widget.b$a$a r4 = (androidx.constraintlayout.widget.b.a.C0063a) r4
            if (r7 != 0) goto L66
            r6 = 23
            r4.b(r6, r2)
            r6 = 80
            r4.d(r6, r5)
            goto L70
        L66:
            r6 = 21
            r4.b(r6, r2)
            r6 = 81
            r4.d(r6, r5)
        L70:
            return
        L71:
            java.lang.String r5 = r5.getString(r6)
            L(r4, r5, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.b.K(java.lang.Object, android.content.res.TypedArray, int, int):void");
    }

    static void L(Object obj, String str, int i11) {
        if (str == null) {
            return;
        }
        int indexOf = str.indexOf(61);
        int length = str.length();
        if (indexOf <= 0 || indexOf >= length - 1) {
            return;
        }
        String substring = str.substring(0, indexOf);
        String substring2 = str.substring(indexOf + 1);
        if (substring2.length() > 0) {
            String trim = substring.trim();
            String trim2 = substring2.trim();
            if ("ratio".equalsIgnoreCase(trim)) {
                if (obj instanceof ConstraintLayout.b) {
                    ConstraintLayout.b bVar = (ConstraintLayout.b) obj;
                    if (i11 == 0) {
                        ((ViewGroup.MarginLayoutParams) bVar).width = 0;
                    } else {
                        ((ViewGroup.MarginLayoutParams) bVar).height = 0;
                    }
                    M(bVar, trim2);
                    return;
                }
                if (obj instanceof C0064b) {
                    ((C0064b) obj).A = trim2;
                    return;
                } else {
                    if (obj instanceof a.C0063a) {
                        ((a.C0063a) obj).c(5, trim2);
                        return;
                    }
                    return;
                }
            }
            try {
                if ("weight".equalsIgnoreCase(trim)) {
                    float parseFloat = Float.parseFloat(trim2);
                    if (obj instanceof ConstraintLayout.b) {
                        ConstraintLayout.b bVar2 = (ConstraintLayout.b) obj;
                        if (i11 == 0) {
                            ((ViewGroup.MarginLayoutParams) bVar2).width = 0;
                            bVar2.L = parseFloat;
                        } else {
                            ((ViewGroup.MarginLayoutParams) bVar2).height = 0;
                            bVar2.M = parseFloat;
                        }
                    } else if (obj instanceof C0064b) {
                        C0064b c0064b = (C0064b) obj;
                        if (i11 == 0) {
                            c0064b.f7865d = 0;
                            c0064b.W = parseFloat;
                        } else {
                            c0064b.f7867e = 0;
                            c0064b.V = parseFloat;
                        }
                    } else if (obj instanceof a.C0063a) {
                        a.C0063a c0063a = (a.C0063a) obj;
                        if (i11 == 0) {
                            c0063a.b(23, 0);
                            c0063a.a(39, parseFloat);
                        } else {
                            c0063a.b(21, 0);
                            c0063a.a(40, parseFloat);
                        }
                    }
                } else {
                    if (!"parent".equalsIgnoreCase(trim)) {
                        return;
                    }
                    float max = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(trim2)));
                    if (obj instanceof ConstraintLayout.b) {
                        ConstraintLayout.b bVar3 = (ConstraintLayout.b) obj;
                        if (i11 == 0) {
                            ((ViewGroup.MarginLayoutParams) bVar3).width = 0;
                            bVar3.V = max;
                            bVar3.P = 2;
                        } else {
                            ((ViewGroup.MarginLayoutParams) bVar3).height = 0;
                            bVar3.W = max;
                            bVar3.Q = 2;
                        }
                    } else if (obj instanceof C0064b) {
                        C0064b c0064b2 = (C0064b) obj;
                        if (i11 == 0) {
                            c0064b2.f7865d = 0;
                            c0064b2.f7870f0 = max;
                            c0064b2.Z = 2;
                        } else {
                            c0064b2.f7867e = 0;
                            c0064b2.f7872g0 = max;
                            c0064b2.f7860a0 = 2;
                        }
                    } else if (obj instanceof a.C0063a) {
                        a.C0063a c0063a2 = (a.C0063a) obj;
                        if (i11 == 0) {
                            c0063a2.b(23, 0);
                            c0063a2.b(54, 2);
                        } else {
                            c0063a2.b(21, 0);
                            c0063a2.b(55, 2);
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void M(ConstraintLayout.b bVar, String str) {
        float f11 = Float.NaN;
        int i11 = -1;
        if (str != null) {
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i12 = 0;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                if (substring.equalsIgnoreCase("W")) {
                    i11 = 0;
                } else if (substring.equalsIgnoreCase("H")) {
                    i11 = 1;
                }
                i12 = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            try {
                if (indexOf2 < 0 || indexOf2 >= length - 1) {
                    String substring2 = str.substring(i12);
                    if (substring2.length() > 0) {
                        f11 = Float.parseFloat(substring2);
                    }
                } else {
                    String substring3 = str.substring(i12, indexOf2);
                    String substring4 = str.substring(indexOf2 + 1);
                    if (substring3.length() > 0 && substring4.length() > 0) {
                        float parseFloat = Float.parseFloat(substring3);
                        float parseFloat2 = Float.parseFloat(substring4);
                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                            f11 = i11 == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        bVar.I = str;
        bVar.J = f11;
        bVar.K = i11;
    }

    private void N(Context context, a aVar, TypedArray typedArray, boolean z10) {
        if (z10) {
            O(context, aVar, typedArray);
            return;
        }
        int indexCount = typedArray.getIndexCount();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = typedArray.getIndex(i11);
            if (index != R$styleable.Constraint_android_id && R$styleable.Constraint_android_layout_marginStart != index && R$styleable.Constraint_android_layout_marginEnd != index) {
                aVar.f7841d.f7903a = true;
                aVar.f7842e.f7861b = true;
                aVar.f7840c.f7917a = true;
                aVar.f7843f.f7923a = true;
            }
            switch (f7829i.get(index)) {
                case 1:
                    C0064b c0064b = aVar.f7842e;
                    c0064b.f7893r = J(typedArray, index, c0064b.f7893r);
                    break;
                case 2:
                    C0064b c0064b2 = aVar.f7842e;
                    c0064b2.K = typedArray.getDimensionPixelSize(index, c0064b2.K);
                    break;
                case 3:
                    C0064b c0064b3 = aVar.f7842e;
                    c0064b3.f7891q = J(typedArray, index, c0064b3.f7891q);
                    break;
                case 4:
                    C0064b c0064b4 = aVar.f7842e;
                    c0064b4.f7889p = J(typedArray, index, c0064b4.f7889p);
                    break;
                case 5:
                    aVar.f7842e.A = typedArray.getString(index);
                    break;
                case 6:
                    C0064b c0064b5 = aVar.f7842e;
                    c0064b5.E = typedArray.getDimensionPixelOffset(index, c0064b5.E);
                    break;
                case 7:
                    C0064b c0064b6 = aVar.f7842e;
                    c0064b6.F = typedArray.getDimensionPixelOffset(index, c0064b6.F);
                    break;
                case 8:
                    C0064b c0064b7 = aVar.f7842e;
                    c0064b7.L = typedArray.getDimensionPixelSize(index, c0064b7.L);
                    break;
                case 9:
                    C0064b c0064b8 = aVar.f7842e;
                    c0064b8.f7899x = J(typedArray, index, c0064b8.f7899x);
                    break;
                case 10:
                    C0064b c0064b9 = aVar.f7842e;
                    c0064b9.f7898w = J(typedArray, index, c0064b9.f7898w);
                    break;
                case 11:
                    C0064b c0064b10 = aVar.f7842e;
                    c0064b10.R = typedArray.getDimensionPixelSize(index, c0064b10.R);
                    break;
                case 12:
                    C0064b c0064b11 = aVar.f7842e;
                    c0064b11.S = typedArray.getDimensionPixelSize(index, c0064b11.S);
                    break;
                case 13:
                    C0064b c0064b12 = aVar.f7842e;
                    c0064b12.O = typedArray.getDimensionPixelSize(index, c0064b12.O);
                    break;
                case 14:
                    C0064b c0064b13 = aVar.f7842e;
                    c0064b13.Q = typedArray.getDimensionPixelSize(index, c0064b13.Q);
                    break;
                case 15:
                    C0064b c0064b14 = aVar.f7842e;
                    c0064b14.T = typedArray.getDimensionPixelSize(index, c0064b14.T);
                    break;
                case 16:
                    C0064b c0064b15 = aVar.f7842e;
                    c0064b15.P = typedArray.getDimensionPixelSize(index, c0064b15.P);
                    break;
                case 17:
                    C0064b c0064b16 = aVar.f7842e;
                    c0064b16.f7869f = typedArray.getDimensionPixelOffset(index, c0064b16.f7869f);
                    break;
                case 18:
                    C0064b c0064b17 = aVar.f7842e;
                    c0064b17.f7871g = typedArray.getDimensionPixelOffset(index, c0064b17.f7871g);
                    break;
                case 19:
                    C0064b c0064b18 = aVar.f7842e;
                    c0064b18.f7873h = typedArray.getFloat(index, c0064b18.f7873h);
                    break;
                case 20:
                    C0064b c0064b19 = aVar.f7842e;
                    c0064b19.f7900y = typedArray.getFloat(index, c0064b19.f7900y);
                    break;
                case 21:
                    C0064b c0064b20 = aVar.f7842e;
                    c0064b20.f7867e = typedArray.getLayoutDimension(index, c0064b20.f7867e);
                    break;
                case 22:
                    d dVar = aVar.f7840c;
                    dVar.f7918b = typedArray.getInt(index, dVar.f7918b);
                    d dVar2 = aVar.f7840c;
                    dVar2.f7918b = f7828h[dVar2.f7918b];
                    break;
                case 23:
                    C0064b c0064b21 = aVar.f7842e;
                    c0064b21.f7865d = typedArray.getLayoutDimension(index, c0064b21.f7865d);
                    break;
                case 24:
                    C0064b c0064b22 = aVar.f7842e;
                    c0064b22.H = typedArray.getDimensionPixelSize(index, c0064b22.H);
                    break;
                case 25:
                    C0064b c0064b23 = aVar.f7842e;
                    c0064b23.f7877j = J(typedArray, index, c0064b23.f7877j);
                    break;
                case 26:
                    C0064b c0064b24 = aVar.f7842e;
                    c0064b24.f7879k = J(typedArray, index, c0064b24.f7879k);
                    break;
                case 27:
                    C0064b c0064b25 = aVar.f7842e;
                    c0064b25.G = typedArray.getInt(index, c0064b25.G);
                    break;
                case 28:
                    C0064b c0064b26 = aVar.f7842e;
                    c0064b26.I = typedArray.getDimensionPixelSize(index, c0064b26.I);
                    break;
                case NOTIFICATION_REDIRECT_VALUE:
                    C0064b c0064b27 = aVar.f7842e;
                    c0064b27.f7881l = J(typedArray, index, c0064b27.f7881l);
                    break;
                case 30:
                    C0064b c0064b28 = aVar.f7842e;
                    c0064b28.f7883m = J(typedArray, index, c0064b28.f7883m);
                    break;
                case TEMPLATE_HTML_SIZE_VALUE:
                    C0064b c0064b29 = aVar.f7842e;
                    c0064b29.M = typedArray.getDimensionPixelSize(index, c0064b29.M);
                    break;
                case 32:
                    C0064b c0064b30 = aVar.f7842e;
                    c0064b30.f7896u = J(typedArray, index, c0064b30.f7896u);
                    break;
                case 33:
                    C0064b c0064b31 = aVar.f7842e;
                    c0064b31.f7897v = J(typedArray, index, c0064b31.f7897v);
                    break;
                case 34:
                    C0064b c0064b32 = aVar.f7842e;
                    c0064b32.J = typedArray.getDimensionPixelSize(index, c0064b32.J);
                    break;
                case 35:
                    C0064b c0064b33 = aVar.f7842e;
                    c0064b33.f7887o = J(typedArray, index, c0064b33.f7887o);
                    break;
                case 36:
                    C0064b c0064b34 = aVar.f7842e;
                    c0064b34.f7885n = J(typedArray, index, c0064b34.f7885n);
                    break;
                case 37:
                    C0064b c0064b35 = aVar.f7842e;
                    c0064b35.f7901z = typedArray.getFloat(index, c0064b35.f7901z);
                    break;
                case 38:
                    aVar.f7838a = typedArray.getResourceId(index, aVar.f7838a);
                    break;
                case 39:
                    C0064b c0064b36 = aVar.f7842e;
                    c0064b36.W = typedArray.getFloat(index, c0064b36.W);
                    break;
                case 40:
                    C0064b c0064b37 = aVar.f7842e;
                    c0064b37.V = typedArray.getFloat(index, c0064b37.V);
                    break;
                case 41:
                    C0064b c0064b38 = aVar.f7842e;
                    c0064b38.X = typedArray.getInt(index, c0064b38.X);
                    break;
                case 42:
                    C0064b c0064b39 = aVar.f7842e;
                    c0064b39.Y = typedArray.getInt(index, c0064b39.Y);
                    break;
                case 43:
                    d dVar3 = aVar.f7840c;
                    dVar3.f7920d = typedArray.getFloat(index, dVar3.f7920d);
                    break;
                case 44:
                    e eVar = aVar.f7843f;
                    eVar.f7935m = true;
                    eVar.f7936n = typedArray.getDimension(index, eVar.f7936n);
                    break;
                case 45:
                    e eVar2 = aVar.f7843f;
                    eVar2.f7925c = typedArray.getFloat(index, eVar2.f7925c);
                    break;
                case 46:
                    e eVar3 = aVar.f7843f;
                    eVar3.f7926d = typedArray.getFloat(index, eVar3.f7926d);
                    break;
                case 47:
                    e eVar4 = aVar.f7843f;
                    eVar4.f7927e = typedArray.getFloat(index, eVar4.f7927e);
                    break;
                case AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE:
                    e eVar5 = aVar.f7843f;
                    eVar5.f7928f = typedArray.getFloat(index, eVar5.f7928f);
                    break;
                case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                    e eVar6 = aVar.f7843f;
                    eVar6.f7929g = typedArray.getDimension(index, eVar6.f7929g);
                    break;
                case 50:
                    e eVar7 = aVar.f7843f;
                    eVar7.f7930h = typedArray.getDimension(index, eVar7.f7930h);
                    break;
                case AD_REWARD_USER_VALUE:
                    e eVar8 = aVar.f7843f;
                    eVar8.f7932j = typedArray.getDimension(index, eVar8.f7932j);
                    break;
                case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
                    e eVar9 = aVar.f7843f;
                    eVar9.f7933k = typedArray.getDimension(index, eVar9.f7933k);
                    break;
                case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
                    e eVar10 = aVar.f7843f;
                    eVar10.f7934l = typedArray.getDimension(index, eVar10.f7934l);
                    break;
                case AD_BACKGROUND_BEFORE_IMPRESSION_VALUE:
                    C0064b c0064b40 = aVar.f7842e;
                    c0064b40.Z = typedArray.getInt(index, c0064b40.Z);
                    break;
                case AD_CLOSED_BEFORE_IMPRESSION_VALUE:
                    C0064b c0064b41 = aVar.f7842e;
                    c0064b41.f7860a0 = typedArray.getInt(index, c0064b41.f7860a0);
                    break;
                case AD_VISIBILITY_VALUE:
                    C0064b c0064b42 = aVar.f7842e;
                    c0064b42.f7862b0 = typedArray.getDimensionPixelSize(index, c0064b42.f7862b0);
                    break;
                case 57:
                    C0064b c0064b43 = aVar.f7842e;
                    c0064b43.f7864c0 = typedArray.getDimensionPixelSize(index, c0064b43.f7864c0);
                    break;
                case INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE:
                    C0064b c0064b44 = aVar.f7842e;
                    c0064b44.f7866d0 = typedArray.getDimensionPixelSize(index, c0064b44.f7866d0);
                    break;
                case 59:
                    C0064b c0064b45 = aVar.f7842e;
                    c0064b45.f7868e0 = typedArray.getDimensionPixelSize(index, c0064b45.f7868e0);
                    break;
                case 60:
                    e eVar11 = aVar.f7843f;
                    eVar11.f7924b = typedArray.getFloat(index, eVar11.f7924b);
                    break;
                case 61:
                    C0064b c0064b46 = aVar.f7842e;
                    c0064b46.B = J(typedArray, index, c0064b46.B);
                    break;
                case 62:
                    C0064b c0064b47 = aVar.f7842e;
                    c0064b47.C = typedArray.getDimensionPixelSize(index, c0064b47.C);
                    break;
                case 63:
                    C0064b c0064b48 = aVar.f7842e;
                    c0064b48.D = typedArray.getFloat(index, c0064b48.D);
                    break;
                case 64:
                    c cVar = aVar.f7841d;
                    cVar.f7904b = J(typedArray, index, cVar.f7904b);
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (typedArray.peekValue(index).type == 3) {
                        aVar.f7841d.f7906d = typedArray.getString(index);
                        break;
                    } else {
                        aVar.f7841d.f7906d = androidx.constraintlayout.core.motion.utils.c.f6843c[typedArray.getInteger(index, 0)];
                        break;
                    }
                case 66:
                    aVar.f7841d.f7908f = typedArray.getInt(index, 0);
                    break;
                case 67:
                    c cVar2 = aVar.f7841d;
                    cVar2.f7911i = typedArray.getFloat(index, cVar2.f7911i);
                    break;
                case 68:
                    d dVar4 = aVar.f7840c;
                    dVar4.f7921e = typedArray.getFloat(index, dVar4.f7921e);
                    break;
                case 69:
                    aVar.f7842e.f7870f0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    aVar.f7842e.f7872g0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    C0064b c0064b49 = aVar.f7842e;
                    c0064b49.f7874h0 = typedArray.getInt(index, c0064b49.f7874h0);
                    break;
                case 73:
                    C0064b c0064b50 = aVar.f7842e;
                    c0064b50.f7876i0 = typedArray.getDimensionPixelSize(index, c0064b50.f7876i0);
                    break;
                case 74:
                    aVar.f7842e.f7882l0 = typedArray.getString(index);
                    break;
                case 75:
                    C0064b c0064b51 = aVar.f7842e;
                    c0064b51.f7890p0 = typedArray.getBoolean(index, c0064b51.f7890p0);
                    break;
                case 76:
                    c cVar3 = aVar.f7841d;
                    cVar3.f7907e = typedArray.getInt(index, cVar3.f7907e);
                    break;
                case 77:
                    aVar.f7842e.f7884m0 = typedArray.getString(index);
                    break;
                case 78:
                    d dVar5 = aVar.f7840c;
                    dVar5.f7919c = typedArray.getInt(index, dVar5.f7919c);
                    break;
                case 79:
                    c cVar4 = aVar.f7841d;
                    cVar4.f7909g = typedArray.getFloat(index, cVar4.f7909g);
                    break;
                case 80:
                    C0064b c0064b52 = aVar.f7842e;
                    c0064b52.f7886n0 = typedArray.getBoolean(index, c0064b52.f7886n0);
                    break;
                case TmcConstants.NOTIFY_ADDHOME_GUIDE_TOP_SHOW /* 81 */:
                    C0064b c0064b53 = aVar.f7842e;
                    c0064b53.f7888o0 = typedArray.getBoolean(index, c0064b53.f7888o0);
                    break;
                case TmcConstants.NOTIFY_ADDHOME_GUIDE_BOTTOM_SHOW /* 82 */:
                    c cVar5 = aVar.f7841d;
                    cVar5.f7905c = typedArray.getInteger(index, cVar5.f7905c);
                    break;
                case TmcConstants.NOTIFY_ADDHOME_GUIDE_BACK_SHOW /* 83 */:
                    e eVar12 = aVar.f7843f;
                    eVar12.f7931i = J(typedArray, index, eVar12.f7931i);
                    break;
                case 84:
                    c cVar6 = aVar.f7841d;
                    cVar6.f7913k = typedArray.getInteger(index, cVar6.f7913k);
                    break;
                case 85:
                    c cVar7 = aVar.f7841d;
                    cVar7.f7912j = typedArray.getFloat(index, cVar7.f7912j);
                    break;
                case 86:
                    int i12 = typedArray.peekValue(index).type;
                    if (i12 == 1) {
                        aVar.f7841d.f7916n = typedArray.getResourceId(index, -1);
                        c cVar8 = aVar.f7841d;
                        if (cVar8.f7916n != -1) {
                            cVar8.f7915m = -2;
                            break;
                        } else {
                            break;
                        }
                    } else if (i12 == 3) {
                        aVar.f7841d.f7914l = typedArray.getString(index);
                        if (aVar.f7841d.f7914l.indexOf("/") > 0) {
                            aVar.f7841d.f7916n = typedArray.getResourceId(index, -1);
                            aVar.f7841d.f7915m = -2;
                            break;
                        } else {
                            aVar.f7841d.f7915m = -1;
                            break;
                        }
                    } else {
                        c cVar9 = aVar.f7841d;
                        cVar9.f7915m = typedArray.getInteger(index, cVar9.f7916n);
                        break;
                    }
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f7829i.get(index));
                    break;
                case 88:
                case TsExtractor.TS_STREAM_TYPE_DVBSUBS /* 89 */:
                case TmcConstants.NOTIFY_ADDHOME_API_SHOW /* 90 */:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f7829i.get(index));
                    break;
                case 91:
                    C0064b c0064b54 = aVar.f7842e;
                    c0064b54.f7894s = J(typedArray, index, c0064b54.f7894s);
                    break;
                case 92:
                    C0064b c0064b55 = aVar.f7842e;
                    c0064b55.f7895t = J(typedArray, index, c0064b55.f7895t);
                    break;
                case 93:
                    C0064b c0064b56 = aVar.f7842e;
                    c0064b56.N = typedArray.getDimensionPixelSize(index, c0064b56.N);
                    break;
                case MBSupportMuteAdType.REWARD_VIDEO /* 94 */:
                    C0064b c0064b57 = aVar.f7842e;
                    c0064b57.U = typedArray.getDimensionPixelSize(index, c0064b57.U);
                    break;
                case 95:
                    K(aVar.f7842e, typedArray, index, 0);
                    break;
                case 96:
                    K(aVar.f7842e, typedArray, index, 1);
                    break;
                case 97:
                    C0064b c0064b58 = aVar.f7842e;
                    c0064b58.f7892q0 = typedArray.getInt(index, c0064b58.f7892q0);
                    break;
            }
        }
        C0064b c0064b59 = aVar.f7842e;
        if (c0064b59.f7882l0 != null) {
            c0064b59.f7880k0 = null;
        }
    }

    private static void O(Context context, a aVar, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        a.C0063a c0063a = new a.C0063a();
        aVar.f7845h = c0063a;
        aVar.f7841d.f7903a = false;
        aVar.f7842e.f7861b = false;
        aVar.f7840c.f7917a = false;
        aVar.f7843f.f7923a = false;
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = typedArray.getIndex(i11);
            switch (f7830j.get(index)) {
                case 2:
                    c0063a.b(2, typedArray.getDimensionPixelSize(index, aVar.f7842e.K));
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                case 25:
                case 26:
                case NOTIFICATION_REDIRECT_VALUE:
                case 30:
                case 32:
                case 33:
                case 35:
                case 36:
                case 61:
                case 88:
                case TsExtractor.TS_STREAM_TYPE_DVBSUBS /* 89 */:
                case TmcConstants.NOTIFY_ADDHOME_API_SHOW /* 90 */:
                case 91:
                case 92:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f7829i.get(index));
                    break;
                case 5:
                    c0063a.c(5, typedArray.getString(index));
                    break;
                case 6:
                    c0063a.b(6, typedArray.getDimensionPixelOffset(index, aVar.f7842e.E));
                    break;
                case 7:
                    c0063a.b(7, typedArray.getDimensionPixelOffset(index, aVar.f7842e.F));
                    break;
                case 8:
                    c0063a.b(8, typedArray.getDimensionPixelSize(index, aVar.f7842e.L));
                    break;
                case 11:
                    c0063a.b(11, typedArray.getDimensionPixelSize(index, aVar.f7842e.R));
                    break;
                case 12:
                    c0063a.b(12, typedArray.getDimensionPixelSize(index, aVar.f7842e.S));
                    break;
                case 13:
                    c0063a.b(13, typedArray.getDimensionPixelSize(index, aVar.f7842e.O));
                    break;
                case 14:
                    c0063a.b(14, typedArray.getDimensionPixelSize(index, aVar.f7842e.Q));
                    break;
                case 15:
                    c0063a.b(15, typedArray.getDimensionPixelSize(index, aVar.f7842e.T));
                    break;
                case 16:
                    c0063a.b(16, typedArray.getDimensionPixelSize(index, aVar.f7842e.P));
                    break;
                case 17:
                    c0063a.b(17, typedArray.getDimensionPixelOffset(index, aVar.f7842e.f7869f));
                    break;
                case 18:
                    c0063a.b(18, typedArray.getDimensionPixelOffset(index, aVar.f7842e.f7871g));
                    break;
                case 19:
                    c0063a.a(19, typedArray.getFloat(index, aVar.f7842e.f7873h));
                    break;
                case 20:
                    c0063a.a(20, typedArray.getFloat(index, aVar.f7842e.f7900y));
                    break;
                case 21:
                    c0063a.b(21, typedArray.getLayoutDimension(index, aVar.f7842e.f7867e));
                    break;
                case 22:
                    c0063a.b(22, f7828h[typedArray.getInt(index, aVar.f7840c.f7918b)]);
                    break;
                case 23:
                    c0063a.b(23, typedArray.getLayoutDimension(index, aVar.f7842e.f7865d));
                    break;
                case 24:
                    c0063a.b(24, typedArray.getDimensionPixelSize(index, aVar.f7842e.H));
                    break;
                case 27:
                    c0063a.b(27, typedArray.getInt(index, aVar.f7842e.G));
                    break;
                case 28:
                    c0063a.b(28, typedArray.getDimensionPixelSize(index, aVar.f7842e.I));
                    break;
                case TEMPLATE_HTML_SIZE_VALUE:
                    c0063a.b(31, typedArray.getDimensionPixelSize(index, aVar.f7842e.M));
                    break;
                case 34:
                    c0063a.b(34, typedArray.getDimensionPixelSize(index, aVar.f7842e.J));
                    break;
                case 37:
                    c0063a.a(37, typedArray.getFloat(index, aVar.f7842e.f7901z));
                    break;
                case 38:
                    int resourceId = typedArray.getResourceId(index, aVar.f7838a);
                    aVar.f7838a = resourceId;
                    c0063a.b(38, resourceId);
                    break;
                case 39:
                    c0063a.a(39, typedArray.getFloat(index, aVar.f7842e.W));
                    break;
                case 40:
                    c0063a.a(40, typedArray.getFloat(index, aVar.f7842e.V));
                    break;
                case 41:
                    c0063a.b(41, typedArray.getInt(index, aVar.f7842e.X));
                    break;
                case 42:
                    c0063a.b(42, typedArray.getInt(index, aVar.f7842e.Y));
                    break;
                case 43:
                    c0063a.a(43, typedArray.getFloat(index, aVar.f7840c.f7920d));
                    break;
                case 44:
                    c0063a.d(44, true);
                    c0063a.a(44, typedArray.getDimension(index, aVar.f7843f.f7936n));
                    break;
                case 45:
                    c0063a.a(45, typedArray.getFloat(index, aVar.f7843f.f7925c));
                    break;
                case 46:
                    c0063a.a(46, typedArray.getFloat(index, aVar.f7843f.f7926d));
                    break;
                case 47:
                    c0063a.a(47, typedArray.getFloat(index, aVar.f7843f.f7927e));
                    break;
                case AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE:
                    c0063a.a(48, typedArray.getFloat(index, aVar.f7843f.f7928f));
                    break;
                case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                    c0063a.a(49, typedArray.getDimension(index, aVar.f7843f.f7929g));
                    break;
                case 50:
                    c0063a.a(50, typedArray.getDimension(index, aVar.f7843f.f7930h));
                    break;
                case AD_REWARD_USER_VALUE:
                    c0063a.a(51, typedArray.getDimension(index, aVar.f7843f.f7932j));
                    break;
                case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
                    c0063a.a(52, typedArray.getDimension(index, aVar.f7843f.f7933k));
                    break;
                case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
                    c0063a.a(53, typedArray.getDimension(index, aVar.f7843f.f7934l));
                    break;
                case AD_BACKGROUND_BEFORE_IMPRESSION_VALUE:
                    c0063a.b(54, typedArray.getInt(index, aVar.f7842e.Z));
                    break;
                case AD_CLOSED_BEFORE_IMPRESSION_VALUE:
                    c0063a.b(55, typedArray.getInt(index, aVar.f7842e.f7860a0));
                    break;
                case AD_VISIBILITY_VALUE:
                    c0063a.b(56, typedArray.getDimensionPixelSize(index, aVar.f7842e.f7862b0));
                    break;
                case 57:
                    c0063a.b(57, typedArray.getDimensionPixelSize(index, aVar.f7842e.f7864c0));
                    break;
                case INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE:
                    c0063a.b(58, typedArray.getDimensionPixelSize(index, aVar.f7842e.f7866d0));
                    break;
                case 59:
                    c0063a.b(59, typedArray.getDimensionPixelSize(index, aVar.f7842e.f7868e0));
                    break;
                case 60:
                    c0063a.a(60, typedArray.getFloat(index, aVar.f7843f.f7924b));
                    break;
                case 62:
                    c0063a.b(62, typedArray.getDimensionPixelSize(index, aVar.f7842e.C));
                    break;
                case 63:
                    c0063a.a(63, typedArray.getFloat(index, aVar.f7842e.D));
                    break;
                case 64:
                    c0063a.b(64, J(typedArray, index, aVar.f7841d.f7904b));
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (typedArray.peekValue(index).type == 3) {
                        c0063a.c(65, typedArray.getString(index));
                        break;
                    } else {
                        c0063a.c(65, androidx.constraintlayout.core.motion.utils.c.f6843c[typedArray.getInteger(index, 0)]);
                        break;
                    }
                case 66:
                    c0063a.b(66, typedArray.getInt(index, 0));
                    break;
                case 67:
                    c0063a.a(67, typedArray.getFloat(index, aVar.f7841d.f7911i));
                    break;
                case 68:
                    c0063a.a(68, typedArray.getFloat(index, aVar.f7840c.f7921e));
                    break;
                case 69:
                    c0063a.a(69, typedArray.getFloat(index, 1.0f));
                    break;
                case 70:
                    c0063a.a(70, typedArray.getFloat(index, 1.0f));
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    c0063a.b(72, typedArray.getInt(index, aVar.f7842e.f7874h0));
                    break;
                case 73:
                    c0063a.b(73, typedArray.getDimensionPixelSize(index, aVar.f7842e.f7876i0));
                    break;
                case 74:
                    c0063a.c(74, typedArray.getString(index));
                    break;
                case 75:
                    c0063a.d(75, typedArray.getBoolean(index, aVar.f7842e.f7890p0));
                    break;
                case 76:
                    c0063a.b(76, typedArray.getInt(index, aVar.f7841d.f7907e));
                    break;
                case 77:
                    c0063a.c(77, typedArray.getString(index));
                    break;
                case 78:
                    c0063a.b(78, typedArray.getInt(index, aVar.f7840c.f7919c));
                    break;
                case 79:
                    c0063a.a(79, typedArray.getFloat(index, aVar.f7841d.f7909g));
                    break;
                case 80:
                    c0063a.d(80, typedArray.getBoolean(index, aVar.f7842e.f7886n0));
                    break;
                case TmcConstants.NOTIFY_ADDHOME_GUIDE_TOP_SHOW /* 81 */:
                    c0063a.d(81, typedArray.getBoolean(index, aVar.f7842e.f7888o0));
                    break;
                case TmcConstants.NOTIFY_ADDHOME_GUIDE_BOTTOM_SHOW /* 82 */:
                    c0063a.b(82, typedArray.getInteger(index, aVar.f7841d.f7905c));
                    break;
                case TmcConstants.NOTIFY_ADDHOME_GUIDE_BACK_SHOW /* 83 */:
                    c0063a.b(83, J(typedArray, index, aVar.f7843f.f7931i));
                    break;
                case 84:
                    c0063a.b(84, typedArray.getInteger(index, aVar.f7841d.f7913k));
                    break;
                case 85:
                    c0063a.a(85, typedArray.getFloat(index, aVar.f7841d.f7912j));
                    break;
                case 86:
                    int i12 = typedArray.peekValue(index).type;
                    if (i12 == 1) {
                        aVar.f7841d.f7916n = typedArray.getResourceId(index, -1);
                        c0063a.b(89, aVar.f7841d.f7916n);
                        c cVar = aVar.f7841d;
                        if (cVar.f7916n != -1) {
                            cVar.f7915m = -2;
                            c0063a.b(88, -2);
                            break;
                        } else {
                            break;
                        }
                    } else if (i12 == 3) {
                        aVar.f7841d.f7914l = typedArray.getString(index);
                        c0063a.c(90, aVar.f7841d.f7914l);
                        if (aVar.f7841d.f7914l.indexOf("/") > 0) {
                            aVar.f7841d.f7916n = typedArray.getResourceId(index, -1);
                            c0063a.b(89, aVar.f7841d.f7916n);
                            aVar.f7841d.f7915m = -2;
                            c0063a.b(88, -2);
                            break;
                        } else {
                            aVar.f7841d.f7915m = -1;
                            c0063a.b(88, -1);
                            break;
                        }
                    } else {
                        c cVar2 = aVar.f7841d;
                        cVar2.f7915m = typedArray.getInteger(index, cVar2.f7916n);
                        c0063a.b(88, aVar.f7841d.f7915m);
                        break;
                    }
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f7829i.get(index));
                    break;
                case 93:
                    c0063a.b(93, typedArray.getDimensionPixelSize(index, aVar.f7842e.N));
                    break;
                case MBSupportMuteAdType.REWARD_VIDEO /* 94 */:
                    c0063a.b(94, typedArray.getDimensionPixelSize(index, aVar.f7842e.U));
                    break;
                case 95:
                    K(c0063a, typedArray, index, 0);
                    break;
                case 96:
                    K(c0063a, typedArray, index, 1);
                    break;
                case 97:
                    c0063a.b(97, typedArray.getInt(index, aVar.f7842e.f7892q0));
                    break;
                case 98:
                    if (MotionLayout.IS_IN_EDIT_MODE) {
                        int resourceId2 = typedArray.getResourceId(index, aVar.f7838a);
                        aVar.f7838a = resourceId2;
                        if (resourceId2 == -1) {
                            aVar.f7839b = typedArray.getString(index);
                            break;
                        } else {
                            break;
                        }
                    } else if (typedArray.peekValue(index).type == 3) {
                        aVar.f7839b = typedArray.getString(index);
                        break;
                    } else {
                        aVar.f7838a = typedArray.getResourceId(index, aVar.f7838a);
                        break;
                    }
                case 99:
                    c0063a.d(99, typedArray.getBoolean(index, aVar.f7842e.f7875i));
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void R(a aVar, int i11, float f11) {
        if (i11 == 19) {
            aVar.f7842e.f7873h = f11;
            return;
        }
        if (i11 == 20) {
            aVar.f7842e.f7900y = f11;
            return;
        }
        if (i11 == 37) {
            aVar.f7842e.f7901z = f11;
            return;
        }
        if (i11 == 60) {
            aVar.f7843f.f7924b = f11;
            return;
        }
        if (i11 == 63) {
            aVar.f7842e.D = f11;
            return;
        }
        if (i11 == 79) {
            aVar.f7841d.f7909g = f11;
            return;
        }
        if (i11 == 85) {
            aVar.f7841d.f7912j = f11;
            return;
        }
        if (i11 != 87) {
            if (i11 == 39) {
                aVar.f7842e.W = f11;
                return;
            }
            if (i11 == 40) {
                aVar.f7842e.V = f11;
                return;
            }
            switch (i11) {
                case 43:
                    aVar.f7840c.f7920d = f11;
                    return;
                case 44:
                    e eVar = aVar.f7843f;
                    eVar.f7936n = f11;
                    eVar.f7935m = true;
                    return;
                case 45:
                    aVar.f7843f.f7925c = f11;
                    return;
                case 46:
                    aVar.f7843f.f7926d = f11;
                    return;
                case 47:
                    aVar.f7843f.f7927e = f11;
                    return;
                case AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE:
                    aVar.f7843f.f7928f = f11;
                    return;
                case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                    aVar.f7843f.f7929g = f11;
                    return;
                case 50:
                    aVar.f7843f.f7930h = f11;
                    return;
                case AD_REWARD_USER_VALUE:
                    aVar.f7843f.f7932j = f11;
                    return;
                case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
                    aVar.f7843f.f7933k = f11;
                    return;
                case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
                    aVar.f7843f.f7934l = f11;
                    return;
                default:
                    switch (i11) {
                        case 67:
                            aVar.f7841d.f7911i = f11;
                            return;
                        case 68:
                            aVar.f7840c.f7921e = f11;
                            return;
                        case 69:
                            aVar.f7842e.f7870f0 = f11;
                            return;
                        case 70:
                            aVar.f7842e.f7872g0 = f11;
                            return;
                        default:
                            Log.w("ConstraintSet", "Unknown attribute 0x");
                            return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void S(a aVar, int i11, int i12) {
        if (i11 == 6) {
            aVar.f7842e.E = i12;
            return;
        }
        if (i11 == 7) {
            aVar.f7842e.F = i12;
            return;
        }
        if (i11 == 8) {
            aVar.f7842e.L = i12;
            return;
        }
        if (i11 == 27) {
            aVar.f7842e.G = i12;
            return;
        }
        if (i11 == 28) {
            aVar.f7842e.I = i12;
            return;
        }
        if (i11 == 41) {
            aVar.f7842e.X = i12;
            return;
        }
        if (i11 == 42) {
            aVar.f7842e.Y = i12;
            return;
        }
        if (i11 == 61) {
            aVar.f7842e.B = i12;
            return;
        }
        if (i11 == 62) {
            aVar.f7842e.C = i12;
            return;
        }
        if (i11 == 72) {
            aVar.f7842e.f7874h0 = i12;
            return;
        }
        if (i11 == 73) {
            aVar.f7842e.f7876i0 = i12;
            return;
        }
        switch (i11) {
            case 2:
                aVar.f7842e.K = i12;
                return;
            case 11:
                aVar.f7842e.R = i12;
                return;
            case 12:
                aVar.f7842e.S = i12;
                return;
            case 13:
                aVar.f7842e.O = i12;
                return;
            case 14:
                aVar.f7842e.Q = i12;
                return;
            case 15:
                aVar.f7842e.T = i12;
                return;
            case 16:
                aVar.f7842e.P = i12;
                return;
            case 17:
                aVar.f7842e.f7869f = i12;
                return;
            case 18:
                aVar.f7842e.f7871g = i12;
                return;
            case TEMPLATE_HTML_SIZE_VALUE:
                aVar.f7842e.M = i12;
                return;
            case 34:
                aVar.f7842e.J = i12;
                return;
            case 38:
                aVar.f7838a = i12;
                return;
            case 64:
                aVar.f7841d.f7904b = i12;
                return;
            case 66:
                aVar.f7841d.f7908f = i12;
                return;
            case 76:
                aVar.f7841d.f7907e = i12;
                return;
            case 78:
                aVar.f7840c.f7919c = i12;
                return;
            case 93:
                aVar.f7842e.N = i12;
                return;
            case MBSupportMuteAdType.REWARD_VIDEO /* 94 */:
                aVar.f7842e.U = i12;
                return;
            case 97:
                aVar.f7842e.f7892q0 = i12;
                return;
            default:
                switch (i11) {
                    case 21:
                        aVar.f7842e.f7867e = i12;
                        return;
                    case 22:
                        aVar.f7840c.f7918b = i12;
                        return;
                    case 23:
                        aVar.f7842e.f7865d = i12;
                        return;
                    case 24:
                        aVar.f7842e.H = i12;
                        return;
                    default:
                        switch (i11) {
                            case AD_BACKGROUND_BEFORE_IMPRESSION_VALUE:
                                aVar.f7842e.Z = i12;
                                return;
                            case AD_CLOSED_BEFORE_IMPRESSION_VALUE:
                                aVar.f7842e.f7860a0 = i12;
                                return;
                            case AD_VISIBILITY_VALUE:
                                aVar.f7842e.f7862b0 = i12;
                                return;
                            case 57:
                                aVar.f7842e.f7864c0 = i12;
                                return;
                            case INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE:
                                aVar.f7842e.f7866d0 = i12;
                                return;
                            case 59:
                                aVar.f7842e.f7868e0 = i12;
                                return;
                            default:
                                switch (i11) {
                                    case TmcConstants.NOTIFY_ADDHOME_GUIDE_BOTTOM_SHOW /* 82 */:
                                        aVar.f7841d.f7905c = i12;
                                        return;
                                    case TmcConstants.NOTIFY_ADDHOME_GUIDE_BACK_SHOW /* 83 */:
                                        aVar.f7843f.f7931i = i12;
                                        return;
                                    case 84:
                                        aVar.f7841d.f7913k = i12;
                                        return;
                                    default:
                                        switch (i11) {
                                            case 87:
                                                return;
                                            case 88:
                                                aVar.f7841d.f7915m = i12;
                                                return;
                                            case TsExtractor.TS_STREAM_TYPE_DVBSUBS /* 89 */:
                                                aVar.f7841d.f7916n = i12;
                                                return;
                                            default:
                                                Log.w("ConstraintSet", "Unknown attribute 0x");
                                                return;
                                        }
                                }
                        }
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void T(a aVar, int i11, String str) {
        if (i11 == 5) {
            aVar.f7842e.A = str;
            return;
        }
        if (i11 == 65) {
            aVar.f7841d.f7906d = str;
            return;
        }
        if (i11 == 74) {
            C0064b c0064b = aVar.f7842e;
            c0064b.f7882l0 = str;
            c0064b.f7880k0 = null;
        } else if (i11 == 77) {
            aVar.f7842e.f7884m0 = str;
        } else if (i11 != 87) {
            if (i11 != 90) {
                Log.w("ConstraintSet", "Unknown attribute 0x");
            } else {
                aVar.f7841d.f7914l = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void U(a aVar, int i11, boolean z10) {
        if (i11 == 44) {
            aVar.f7843f.f7935m = z10;
            return;
        }
        if (i11 == 75) {
            aVar.f7842e.f7890p0 = z10;
            return;
        }
        if (i11 != 87) {
            if (i11 == 80) {
                aVar.f7842e.f7886n0 = z10;
            } else if (i11 != 81) {
                Log.w("ConstraintSet", "Unknown attribute 0x");
            } else {
                aVar.f7842e.f7888o0 = z10;
            }
        }
    }

    private String a0(int i11) {
        switch (i11) {
            case 1:
                return TtmlNode.LEFT;
            case 2:
                return TtmlNode.RIGHT;
            case 3:
                return IntegrationConstants.TAB_BAR_POSITION_TOP;
            case 4:
                return IntegrationConstants.TAB_BAR_POSITION_DEFAULT;
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return TtmlNode.END;
            default:
                return "undefined";
        }
    }

    public static a m(Context context, XmlPullParser xmlPullParser) {
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        a aVar = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(asAttributeSet, R$styleable.ConstraintOverride);
        O(context, aVar, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return aVar;
    }

    private int[] x(View view, String str) {
        int i11;
        Object designInformation;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i12 = 0;
        int i13 = 0;
        while (i12 < split.length) {
            String trim = split[i12].trim();
            try {
                i11 = R$id.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i11 = 0;
            }
            if (i11 == 0) {
                i11 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i11 == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (designInformation = ((ConstraintLayout) view.getParent()).getDesignInformation(0, trim)) != null && (designInformation instanceof Integer)) {
                i11 = ((Integer) designInformation).intValue();
            }
            iArr[i13] = i11;
            i12++;
            i13++;
        }
        return i13 != split.length ? Arrays.copyOf(iArr, i13) : iArr;
    }

    private a y(Context context, AttributeSet attributeSet, boolean z10) {
        a aVar = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z10 ? R$styleable.ConstraintOverride : R$styleable.Constraint);
        N(context, aVar, obtainStyledAttributes, z10);
        obtainStyledAttributes.recycle();
        return aVar;
    }

    private a z(int i11) {
        if (!this.f7837g.containsKey(Integer.valueOf(i11))) {
            this.f7837g.put(Integer.valueOf(i11), new a());
        }
        return (a) this.f7837g.get(Integer.valueOf(i11));
    }

    public a A(int i11) {
        if (this.f7837g.containsKey(Integer.valueOf(i11))) {
            return (a) this.f7837g.get(Integer.valueOf(i11));
        }
        return null;
    }

    public int B(int i11) {
        return z(i11).f7842e.f7867e;
    }

    public int[] C() {
        Integer[] numArr = (Integer[]) this.f7837g.keySet().toArray(new Integer[0]);
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = numArr[i11].intValue();
        }
        return iArr;
    }

    public a D(int i11) {
        return z(i11);
    }

    public int E(int i11) {
        return z(i11).f7840c.f7918b;
    }

    public int F(int i11) {
        return z(i11).f7840c.f7919c;
    }

    public int G(int i11) {
        return z(i11).f7842e.f7865d;
    }

    public void H(Context context, int i11) {
        XmlResourceParser xml = context.getResources().getXml(i11);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a y10 = y(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        y10.f7842e.f7859a = true;
                    }
                    this.f7837g.put(Integer.valueOf(y10.f7838a), y10);
                }
            }
        } catch (IOException e11) {
            e11.printStackTrace();
        } catch (XmlPullParserException e12) {
            e12.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x01cf, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void I(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            Method dump skipped, instructions count: 562
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.b.I(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public void P(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = constraintLayout.getChildAt(i11);
            ConstraintLayout.b bVar = (ConstraintLayout.b) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (this.f7836f && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f7837g.containsKey(Integer.valueOf(id2))) {
                this.f7837g.put(Integer.valueOf(id2), new a());
            }
            a aVar = (a) this.f7837g.get(Integer.valueOf(id2));
            if (aVar != null) {
                if (!aVar.f7842e.f7861b) {
                    aVar.g(id2, bVar);
                    if (childAt instanceof ConstraintHelper) {
                        aVar.f7842e.f7880k0 = ((ConstraintHelper) childAt).getReferencedIds();
                        if (childAt instanceof Barrier) {
                            Barrier barrier = (Barrier) childAt;
                            aVar.f7842e.f7890p0 = barrier.getAllowsGoneWidget();
                            aVar.f7842e.f7874h0 = barrier.getType();
                            aVar.f7842e.f7876i0 = barrier.getMargin();
                        }
                    }
                    aVar.f7842e.f7861b = true;
                }
                d dVar = aVar.f7840c;
                if (!dVar.f7917a) {
                    dVar.f7918b = childAt.getVisibility();
                    aVar.f7840c.f7920d = childAt.getAlpha();
                    aVar.f7840c.f7917a = true;
                }
                e eVar = aVar.f7843f;
                if (!eVar.f7923a) {
                    eVar.f7923a = true;
                    eVar.f7924b = childAt.getRotation();
                    aVar.f7843f.f7925c = childAt.getRotationX();
                    aVar.f7843f.f7926d = childAt.getRotationY();
                    aVar.f7843f.f7927e = childAt.getScaleX();
                    aVar.f7843f.f7928f = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (pivotX != 0.0d || pivotY != 0.0d) {
                        e eVar2 = aVar.f7843f;
                        eVar2.f7929g = pivotX;
                        eVar2.f7930h = pivotY;
                    }
                    aVar.f7843f.f7932j = childAt.getTranslationX();
                    aVar.f7843f.f7933k = childAt.getTranslationY();
                    aVar.f7843f.f7934l = childAt.getTranslationZ();
                    e eVar3 = aVar.f7843f;
                    if (eVar3.f7935m) {
                        eVar3.f7936n = childAt.getElevation();
                    }
                }
            }
        }
    }

    public void Q(b bVar) {
        for (Integer num : bVar.f7837g.keySet()) {
            num.intValue();
            a aVar = (a) bVar.f7837g.get(num);
            if (!this.f7837g.containsKey(num)) {
                this.f7837g.put(num, new a());
            }
            a aVar2 = (a) this.f7837g.get(num);
            if (aVar2 != null) {
                C0064b c0064b = aVar2.f7842e;
                if (!c0064b.f7861b) {
                    c0064b.a(aVar.f7842e);
                }
                d dVar = aVar2.f7840c;
                if (!dVar.f7917a) {
                    dVar.a(aVar.f7840c);
                }
                e eVar = aVar2.f7843f;
                if (!eVar.f7923a) {
                    eVar.a(aVar.f7843f);
                }
                c cVar = aVar2.f7841d;
                if (!cVar.f7903a) {
                    cVar.a(aVar.f7841d);
                }
                for (String str : aVar.f7844g.keySet()) {
                    if (!aVar2.f7844g.containsKey(str)) {
                        aVar2.f7844g.put(str, (ConstraintAttribute) aVar.f7844g.get(str));
                    }
                }
            }
        }
    }

    public void V(boolean z10) {
        this.f7836f = z10;
    }

    public void W(int i11, int i12) {
        z(i11).f7842e.f7871g = i12;
        z(i11).f7842e.f7869f = -1;
        z(i11).f7842e.f7873h = -1.0f;
    }

    public void X(int i11, int i12, int i13) {
        a z10 = z(i11);
        switch (i12) {
            case 1:
                z10.f7842e.H = i13;
                return;
            case 2:
                z10.f7842e.I = i13;
                return;
            case 3:
                z10.f7842e.J = i13;
                return;
            case 4:
                z10.f7842e.K = i13;
                return;
            case 5:
                z10.f7842e.N = i13;
                return;
            case 6:
                z10.f7842e.M = i13;
                return;
            case 7:
                z10.f7842e.L = i13;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void Y(boolean z10) {
        this.f7831a = z10;
    }

    public void Z(int i11, float f11) {
        z(i11).f7842e.f7901z = f11;
    }

    public void g(ConstraintLayout constraintLayout) {
        a aVar;
        int childCount = constraintLayout.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = constraintLayout.getChildAt(i11);
            int id2 = childAt.getId();
            if (!this.f7837g.containsKey(Integer.valueOf(id2))) {
                Log.w("ConstraintSet", "id unknown " + androidx.constraintlayout.motion.widget.a.d(childAt));
            } else {
                if (this.f7836f && id2 == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (this.f7837g.containsKey(Integer.valueOf(id2)) && (aVar = (a) this.f7837g.get(Integer.valueOf(id2))) != null) {
                    ConstraintAttribute.j(childAt, aVar.f7844g);
                }
            }
        }
    }

    public void h(b bVar) {
        for (a aVar : bVar.f7837g.values()) {
            if (aVar.f7845h != null) {
                if (aVar.f7839b != null) {
                    Iterator it = this.f7837g.keySet().iterator();
                    while (it.hasNext()) {
                        a A = A(((Integer) it.next()).intValue());
                        String str = A.f7842e.f7884m0;
                        if (str != null && aVar.f7839b.matches(str)) {
                            aVar.f7845h.e(A);
                            A.f7844g.putAll((HashMap) aVar.f7844g.clone());
                        }
                    }
                } else {
                    aVar.f7845h.e(A(aVar.f7838a));
                }
            }
        }
    }

    public void i(ConstraintLayout constraintLayout) {
        k(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public void j(ConstraintHelper constraintHelper, ConstraintWidget constraintWidget, ConstraintLayout.b bVar, SparseArray sparseArray) {
        a aVar;
        int id2 = constraintHelper.getId();
        if (this.f7837g.containsKey(Integer.valueOf(id2)) && (aVar = (a) this.f7837g.get(Integer.valueOf(id2))) != null && (constraintWidget instanceof t0.b)) {
            constraintHelper.loadParameters(aVar, (t0.b) constraintWidget, bVar, sparseArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ConstraintLayout constraintLayout, boolean z10) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f7837g.keySet());
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = constraintLayout.getChildAt(i11);
            int id2 = childAt.getId();
            if (!this.f7837g.containsKey(Integer.valueOf(id2))) {
                Log.w("ConstraintSet", "id unknown " + androidx.constraintlayout.motion.widget.a.d(childAt));
            } else {
                if (this.f7836f && id2 == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id2 != -1) {
                    if (this.f7837g.containsKey(Integer.valueOf(id2))) {
                        hashSet.remove(Integer.valueOf(id2));
                        a aVar = (a) this.f7837g.get(Integer.valueOf(id2));
                        if (aVar != null) {
                            if (childAt instanceof Barrier) {
                                aVar.f7842e.f7878j0 = 1;
                                Barrier barrier = (Barrier) childAt;
                                barrier.setId(id2);
                                barrier.setType(aVar.f7842e.f7874h0);
                                barrier.setMargin(aVar.f7842e.f7876i0);
                                barrier.setAllowsGoneWidget(aVar.f7842e.f7890p0);
                                C0064b c0064b = aVar.f7842e;
                                int[] iArr = c0064b.f7880k0;
                                if (iArr != null) {
                                    barrier.setReferencedIds(iArr);
                                } else {
                                    String str = c0064b.f7882l0;
                                    if (str != null) {
                                        c0064b.f7880k0 = x(barrier, str);
                                        barrier.setReferencedIds(aVar.f7842e.f7880k0);
                                    }
                                }
                            }
                            ConstraintLayout.b bVar = (ConstraintLayout.b) childAt.getLayoutParams();
                            bVar.c();
                            aVar.e(bVar);
                            if (z10) {
                                ConstraintAttribute.j(childAt, aVar.f7844g);
                            }
                            childAt.setLayoutParams(bVar);
                            d dVar = aVar.f7840c;
                            if (dVar.f7919c == 0) {
                                childAt.setVisibility(dVar.f7918b);
                            }
                            childAt.setAlpha(aVar.f7840c.f7920d);
                            childAt.setRotation(aVar.f7843f.f7924b);
                            childAt.setRotationX(aVar.f7843f.f7925c);
                            childAt.setRotationY(aVar.f7843f.f7926d);
                            childAt.setScaleX(aVar.f7843f.f7927e);
                            childAt.setScaleY(aVar.f7843f.f7928f);
                            e eVar = aVar.f7843f;
                            if (eVar.f7931i != -1) {
                                if (((View) childAt.getParent()).findViewById(aVar.f7843f.f7931i) != null) {
                                    float top = (r4.getTop() + r4.getBottom()) / 2.0f;
                                    float left = (r4.getLeft() + r4.getRight()) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        childAt.setPivotX(left - childAt.getLeft());
                                        childAt.setPivotY(top - childAt.getTop());
                                    }
                                }
                            } else {
                                if (!Float.isNaN(eVar.f7929g)) {
                                    childAt.setPivotX(aVar.f7843f.f7929g);
                                }
                                if (!Float.isNaN(aVar.f7843f.f7930h)) {
                                    childAt.setPivotY(aVar.f7843f.f7930h);
                                }
                            }
                            childAt.setTranslationX(aVar.f7843f.f7932j);
                            childAt.setTranslationY(aVar.f7843f.f7933k);
                            childAt.setTranslationZ(aVar.f7843f.f7934l);
                            e eVar2 = aVar.f7843f;
                            if (eVar2.f7935m) {
                                childAt.setElevation(eVar2.f7936n);
                            }
                        }
                    } else {
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id2);
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            a aVar2 = (a) this.f7837g.get(num);
            if (aVar2 != null) {
                if (aVar2.f7842e.f7878j0 == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    C0064b c0064b2 = aVar2.f7842e;
                    int[] iArr2 = c0064b2.f7880k0;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = c0064b2.f7882l0;
                        if (str2 != null) {
                            c0064b2.f7880k0 = x(barrier2, str2);
                            barrier2.setReferencedIds(aVar2.f7842e.f7880k0);
                        }
                    }
                    barrier2.setType(aVar2.f7842e.f7874h0);
                    barrier2.setMargin(aVar2.f7842e.f7876i0);
                    ConstraintLayout.b generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                    barrier2.validateParams();
                    aVar2.e(generateDefaultLayoutParams);
                    constraintLayout.addView(barrier2, generateDefaultLayoutParams);
                }
                if (aVar2.f7842e.f7859a) {
                    View guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout.b generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                    aVar2.e(generateDefaultLayoutParams2);
                    constraintLayout.addView(guideline, generateDefaultLayoutParams2);
                }
            }
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = constraintLayout.getChildAt(i12);
            if (childAt2 instanceof ConstraintHelper) {
                ((ConstraintHelper) childAt2).f(constraintLayout);
            }
        }
    }

    public void l(int i11, ConstraintLayout.b bVar) {
        a aVar;
        if (!this.f7837g.containsKey(Integer.valueOf(i11)) || (aVar = (a) this.f7837g.get(Integer.valueOf(i11))) == null) {
            return;
        }
        aVar.e(bVar);
    }

    public void n(int i11) {
        this.f7837g.remove(Integer.valueOf(i11));
    }

    public void o(int i11, int i12) {
        a aVar;
        if (!this.f7837g.containsKey(Integer.valueOf(i11)) || (aVar = (a) this.f7837g.get(Integer.valueOf(i11))) == null) {
            return;
        }
        switch (i12) {
            case 1:
                C0064b c0064b = aVar.f7842e;
                c0064b.f7879k = -1;
                c0064b.f7877j = -1;
                c0064b.H = -1;
                c0064b.O = Integer.MIN_VALUE;
                return;
            case 2:
                C0064b c0064b2 = aVar.f7842e;
                c0064b2.f7883m = -1;
                c0064b2.f7881l = -1;
                c0064b2.I = -1;
                c0064b2.Q = Integer.MIN_VALUE;
                return;
            case 3:
                C0064b c0064b3 = aVar.f7842e;
                c0064b3.f7887o = -1;
                c0064b3.f7885n = -1;
                c0064b3.J = 0;
                c0064b3.P = Integer.MIN_VALUE;
                return;
            case 4:
                C0064b c0064b4 = aVar.f7842e;
                c0064b4.f7889p = -1;
                c0064b4.f7891q = -1;
                c0064b4.K = 0;
                c0064b4.R = Integer.MIN_VALUE;
                return;
            case 5:
                C0064b c0064b5 = aVar.f7842e;
                c0064b5.f7893r = -1;
                c0064b5.f7894s = -1;
                c0064b5.f7895t = -1;
                c0064b5.N = 0;
                c0064b5.U = Integer.MIN_VALUE;
                return;
            case 6:
                C0064b c0064b6 = aVar.f7842e;
                c0064b6.f7896u = -1;
                c0064b6.f7897v = -1;
                c0064b6.M = 0;
                c0064b6.T = Integer.MIN_VALUE;
                return;
            case 7:
                C0064b c0064b7 = aVar.f7842e;
                c0064b7.f7898w = -1;
                c0064b7.f7899x = -1;
                c0064b7.L = 0;
                c0064b7.S = Integer.MIN_VALUE;
                return;
            case 8:
                C0064b c0064b8 = aVar.f7842e;
                c0064b8.D = -1.0f;
                c0064b8.C = -1;
                c0064b8.B = -1;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void p(Context context, int i11) {
        q((ConstraintLayout) LayoutInflater.from(context).inflate(i11, (ViewGroup) null));
    }

    public void q(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f7837g.clear();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = constraintLayout.getChildAt(i11);
            ConstraintLayout.b bVar = (ConstraintLayout.b) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (this.f7836f && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f7837g.containsKey(Integer.valueOf(id2))) {
                this.f7837g.put(Integer.valueOf(id2), new a());
            }
            a aVar = (a) this.f7837g.get(Integer.valueOf(id2));
            if (aVar != null) {
                aVar.f7844g = ConstraintAttribute.b(this.f7835e, childAt);
                aVar.g(id2, bVar);
                aVar.f7840c.f7918b = childAt.getVisibility();
                aVar.f7840c.f7920d = childAt.getAlpha();
                aVar.f7843f.f7924b = childAt.getRotation();
                aVar.f7843f.f7925c = childAt.getRotationX();
                aVar.f7843f.f7926d = childAt.getRotationY();
                aVar.f7843f.f7927e = childAt.getScaleX();
                aVar.f7843f.f7928f = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    e eVar = aVar.f7843f;
                    eVar.f7929g = pivotX;
                    eVar.f7930h = pivotY;
                }
                aVar.f7843f.f7932j = childAt.getTranslationX();
                aVar.f7843f.f7933k = childAt.getTranslationY();
                aVar.f7843f.f7934l = childAt.getTranslationZ();
                e eVar2 = aVar.f7843f;
                if (eVar2.f7935m) {
                    eVar2.f7936n = childAt.getElevation();
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    aVar.f7842e.f7890p0 = barrier.getAllowsGoneWidget();
                    aVar.f7842e.f7880k0 = barrier.getReferencedIds();
                    aVar.f7842e.f7874h0 = barrier.getType();
                    aVar.f7842e.f7876i0 = barrier.getMargin();
                }
            }
        }
    }

    public void r(b bVar) {
        this.f7837g.clear();
        for (Integer num : bVar.f7837g.keySet()) {
            a aVar = (a) bVar.f7837g.get(num);
            if (aVar != null) {
                this.f7837g.put(num, aVar.clone());
            }
        }
    }

    public void s(Constraints constraints) {
        int childCount = constraints.getChildCount();
        this.f7837g.clear();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = constraints.getChildAt(i11);
            Constraints.a aVar = (Constraints.a) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (this.f7836f && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f7837g.containsKey(Integer.valueOf(id2))) {
                this.f7837g.put(Integer.valueOf(id2), new a());
            }
            a aVar2 = (a) this.f7837g.get(Integer.valueOf(id2));
            if (aVar2 != null) {
                if (childAt instanceof ConstraintHelper) {
                    aVar2.i((ConstraintHelper) childAt, id2, aVar);
                }
                aVar2.h(id2, aVar);
            }
        }
    }

    public void t(int i11, int i12, int i13, int i14) {
        if (!this.f7837g.containsKey(Integer.valueOf(i11))) {
            this.f7837g.put(Integer.valueOf(i11), new a());
        }
        a aVar = (a) this.f7837g.get(Integer.valueOf(i11));
        if (aVar == null) {
            return;
        }
        switch (i12) {
            case 1:
                if (i14 == 1) {
                    C0064b c0064b = aVar.f7842e;
                    c0064b.f7877j = i13;
                    c0064b.f7879k = -1;
                    return;
                } else if (i14 == 2) {
                    C0064b c0064b2 = aVar.f7842e;
                    c0064b2.f7879k = i13;
                    c0064b2.f7877j = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("left to " + a0(i14) + " undefined");
                }
            case 2:
                if (i14 == 1) {
                    C0064b c0064b3 = aVar.f7842e;
                    c0064b3.f7881l = i13;
                    c0064b3.f7883m = -1;
                    return;
                } else if (i14 == 2) {
                    C0064b c0064b4 = aVar.f7842e;
                    c0064b4.f7883m = i13;
                    c0064b4.f7881l = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + a0(i14) + " undefined");
                }
            case 3:
                if (i14 == 3) {
                    C0064b c0064b5 = aVar.f7842e;
                    c0064b5.f7885n = i13;
                    c0064b5.f7887o = -1;
                    c0064b5.f7893r = -1;
                    c0064b5.f7894s = -1;
                    c0064b5.f7895t = -1;
                    return;
                }
                if (i14 != 4) {
                    throw new IllegalArgumentException("right to " + a0(i14) + " undefined");
                }
                C0064b c0064b6 = aVar.f7842e;
                c0064b6.f7887o = i13;
                c0064b6.f7885n = -1;
                c0064b6.f7893r = -1;
                c0064b6.f7894s = -1;
                c0064b6.f7895t = -1;
                return;
            case 4:
                if (i14 == 4) {
                    C0064b c0064b7 = aVar.f7842e;
                    c0064b7.f7891q = i13;
                    c0064b7.f7889p = -1;
                    c0064b7.f7893r = -1;
                    c0064b7.f7894s = -1;
                    c0064b7.f7895t = -1;
                    return;
                }
                if (i14 != 3) {
                    throw new IllegalArgumentException("right to " + a0(i14) + " undefined");
                }
                C0064b c0064b8 = aVar.f7842e;
                c0064b8.f7889p = i13;
                c0064b8.f7891q = -1;
                c0064b8.f7893r = -1;
                c0064b8.f7894s = -1;
                c0064b8.f7895t = -1;
                return;
            case 5:
                if (i14 == 5) {
                    C0064b c0064b9 = aVar.f7842e;
                    c0064b9.f7893r = i13;
                    c0064b9.f7891q = -1;
                    c0064b9.f7889p = -1;
                    c0064b9.f7885n = -1;
                    c0064b9.f7887o = -1;
                    return;
                }
                if (i14 == 3) {
                    C0064b c0064b10 = aVar.f7842e;
                    c0064b10.f7894s = i13;
                    c0064b10.f7891q = -1;
                    c0064b10.f7889p = -1;
                    c0064b10.f7885n = -1;
                    c0064b10.f7887o = -1;
                    return;
                }
                if (i14 != 4) {
                    throw new IllegalArgumentException("right to " + a0(i14) + " undefined");
                }
                C0064b c0064b11 = aVar.f7842e;
                c0064b11.f7895t = i13;
                c0064b11.f7891q = -1;
                c0064b11.f7889p = -1;
                c0064b11.f7885n = -1;
                c0064b11.f7887o = -1;
                return;
            case 6:
                if (i14 == 6) {
                    C0064b c0064b12 = aVar.f7842e;
                    c0064b12.f7897v = i13;
                    c0064b12.f7896u = -1;
                    return;
                } else if (i14 == 7) {
                    C0064b c0064b13 = aVar.f7842e;
                    c0064b13.f7896u = i13;
                    c0064b13.f7897v = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + a0(i14) + " undefined");
                }
            case 7:
                if (i14 == 7) {
                    C0064b c0064b14 = aVar.f7842e;
                    c0064b14.f7899x = i13;
                    c0064b14.f7898w = -1;
                    return;
                } else if (i14 == 6) {
                    C0064b c0064b15 = aVar.f7842e;
                    c0064b15.f7898w = i13;
                    c0064b15.f7899x = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + a0(i14) + " undefined");
                }
            default:
                throw new IllegalArgumentException(a0(i12) + " to " + a0(i14) + " unknown");
        }
    }

    public void u(int i11, int i12, int i13, float f11) {
        C0064b c0064b = z(i11).f7842e;
        c0064b.B = i12;
        c0064b.C = i13;
        c0064b.D = f11;
    }

    public void v(int i11, int i12) {
        z(i11).f7842e.f7867e = i12;
    }

    public void w(int i11, boolean z10) {
        z(i11).f7842e.f7888o0 = z10;
    }
}
