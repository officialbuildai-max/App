package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.j;
import androidx.constraintlayout.core.widgets.analyzer.l;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ConstraintWidget {
    public static float U0 = 0.5f;
    int A0;
    int B0;
    boolean C0;
    boolean D0;
    boolean E0;
    public boolean F;
    boolean F0;
    public boolean G;
    boolean G0;
    boolean H0;
    boolean I0;
    int J0;
    int K0;
    boolean L0;
    private boolean M;
    boolean M0;
    public float[] N0;
    protected ConstraintWidget[] O0;
    protected ConstraintWidget[] P0;
    ConstraintWidget Q0;
    ConstraintWidget R0;
    public int S0;
    public int T0;
    public ConstraintAnchor X;
    public ConstraintAnchor[] Y;
    protected ArrayList Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean[] f6932a0;

    /* renamed from: b0, reason: collision with root package name */
    public DimensionBehaviour[] f6934b0;

    /* renamed from: c, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.analyzer.c f6935c;

    /* renamed from: c0, reason: collision with root package name */
    public ConstraintWidget f6936c0;

    /* renamed from: d, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.analyzer.c f6937d;

    /* renamed from: d0, reason: collision with root package name */
    int f6938d0;

    /* renamed from: e0, reason: collision with root package name */
    int f6940e0;

    /* renamed from: f0, reason: collision with root package name */
    public float f6942f0;

    /* renamed from: g0, reason: collision with root package name */
    protected int f6944g0;

    /* renamed from: h0, reason: collision with root package name */
    protected int f6946h0;

    /* renamed from: i0, reason: collision with root package name */
    protected int f6948i0;

    /* renamed from: j0, reason: collision with root package name */
    int f6950j0;

    /* renamed from: k0, reason: collision with root package name */
    int f6952k0;

    /* renamed from: l0, reason: collision with root package name */
    protected int f6954l0;

    /* renamed from: m0, reason: collision with root package name */
    protected int f6956m0;

    /* renamed from: n0, reason: collision with root package name */
    int f6958n0;

    /* renamed from: o, reason: collision with root package name */
    public String f6959o;

    /* renamed from: o0, reason: collision with root package name */
    protected int f6960o0;

    /* renamed from: p0, reason: collision with root package name */
    protected int f6962p0;

    /* renamed from: q0, reason: collision with root package name */
    float f6964q0;

    /* renamed from: r0, reason: collision with root package name */
    float f6966r0;

    /* renamed from: s0, reason: collision with root package name */
    private Object f6968s0;

    /* renamed from: t0, reason: collision with root package name */
    private int f6970t0;

    /* renamed from: u0, reason: collision with root package name */
    private int f6972u0;

    /* renamed from: v0, reason: collision with root package name */
    private boolean f6974v0;

    /* renamed from: w0, reason: collision with root package name */
    private String f6976w0;

    /* renamed from: x0, reason: collision with root package name */
    private String f6978x0;

    /* renamed from: y0, reason: collision with root package name */
    int f6980y0;

    /* renamed from: z0, reason: collision with root package name */
    int f6982z0;

    /* renamed from: a, reason: collision with root package name */
    public boolean f6931a = false;

    /* renamed from: b, reason: collision with root package name */
    public WidgetRun[] f6933b = new WidgetRun[2];

    /* renamed from: e, reason: collision with root package name */
    public j f6939e = null;

    /* renamed from: f, reason: collision with root package name */
    public l f6941f = null;

    /* renamed from: g, reason: collision with root package name */
    public boolean[] f6943g = {true, true};

    /* renamed from: h, reason: collision with root package name */
    boolean f6945h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f6947i = true;

    /* renamed from: j, reason: collision with root package name */
    private boolean f6949j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f6951k = true;

    /* renamed from: l, reason: collision with root package name */
    private int f6953l = -1;

    /* renamed from: m, reason: collision with root package name */
    private int f6955m = -1;

    /* renamed from: n, reason: collision with root package name */
    public s0.a f6957n = new s0.a(this);

    /* renamed from: p, reason: collision with root package name */
    private boolean f6961p = false;

    /* renamed from: q, reason: collision with root package name */
    private boolean f6963q = false;

    /* renamed from: r, reason: collision with root package name */
    private boolean f6965r = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f6967s = false;

    /* renamed from: t, reason: collision with root package name */
    public int f6969t = -1;

    /* renamed from: u, reason: collision with root package name */
    public int f6971u = -1;

    /* renamed from: v, reason: collision with root package name */
    private int f6973v = 0;

    /* renamed from: w, reason: collision with root package name */
    public int f6975w = 0;

    /* renamed from: x, reason: collision with root package name */
    public int f6977x = 0;

    /* renamed from: y, reason: collision with root package name */
    public int[] f6979y = new int[2];

    /* renamed from: z, reason: collision with root package name */
    public int f6981z = 0;
    public int A = 0;
    public float B = 1.0f;
    public int C = 0;
    public int D = 0;
    public float E = 1.0f;
    int H = -1;
    float I = 1.0f;
    private int[] J = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    private float K = 0.0f;
    private boolean L = false;
    private boolean N = false;
    private int O = 0;
    private int P = 0;
    public ConstraintAnchor Q = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
    public ConstraintAnchor R = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
    public ConstraintAnchor S = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
    public ConstraintAnchor T = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
    public ConstraintAnchor U = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
    ConstraintAnchor V = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
    ConstraintAnchor W = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);

    /* loaded from: classes.dex */
    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6983a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f6984b;

        static {
            int[] iArr = new int[DimensionBehaviour.values().length];
            f6984b = iArr;
            try {
                iArr[DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6984b[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6984b[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6984b[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ConstraintAnchor.Type.values().length];
            f6983a = iArr2;
            try {
                iArr2[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6983a[ConstraintAnchor.Type.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6983a[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f6983a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f6983a[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f6983a[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f6983a[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f6983a[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f6983a[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public ConstraintWidget() {
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.X = constraintAnchor;
        this.Y = new ConstraintAnchor[]{this.Q, this.S, this.R, this.T, this.U, constraintAnchor};
        this.Z = new ArrayList();
        this.f6932a0 = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.f6934b0 = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.f6936c0 = null;
        this.f6938d0 = 0;
        this.f6940e0 = 0;
        this.f6942f0 = 0.0f;
        this.f6944g0 = -1;
        this.f6946h0 = 0;
        this.f6948i0 = 0;
        this.f6950j0 = 0;
        this.f6952k0 = 0;
        this.f6954l0 = 0;
        this.f6956m0 = 0;
        this.f6958n0 = 0;
        float f11 = U0;
        this.f6964q0 = f11;
        this.f6966r0 = f11;
        this.f6970t0 = 0;
        this.f6972u0 = 0;
        this.f6974v0 = false;
        this.f6976w0 = null;
        this.f6978x0 = null;
        this.I0 = false;
        this.J0 = 0;
        this.K0 = 0;
        this.N0 = new float[]{-1.0f, -1.0f};
        this.O0 = new ConstraintWidget[]{null, null};
        this.P0 = new ConstraintWidget[]{null, null};
        this.Q0 = null;
        this.R0 = null;
        this.S0 = -1;
        this.T0 = -1;
        d();
    }

    private void A0(StringBuilder sb2, String str, float f11, float f12) {
        if (f11 == f12) {
            return;
        }
        sb2.append(str);
        sb2.append(" :   ");
        sb2.append(f11);
        sb2.append(",\n");
    }

    private void B0(StringBuilder sb2, String str, int i11, int i12) {
        if (i11 == i12) {
            return;
        }
        sb2.append(str);
        sb2.append(" :   ");
        sb2.append(i11);
        sb2.append(",\n");
    }

    private void C0(StringBuilder sb2, String str, float f11, int i11) {
        if (f11 == 0.0f) {
            return;
        }
        sb2.append(str);
        sb2.append(" :  [");
        sb2.append(f11);
        sb2.append(",");
        sb2.append(i11);
        sb2.append("");
        sb2.append("],\n");
    }

    private void R(StringBuilder sb2, String str, int i11, int i12, int i13, int i14, int i15, int i16, float f11, float f12) {
        sb2.append(str);
        sb2.append(" :  {\n");
        B0(sb2, "      size", i11, 0);
        B0(sb2, "      min", i12, 0);
        B0(sb2, "      max", i13, Integer.MAX_VALUE);
        B0(sb2, "      matchMin", i15, 0);
        B0(sb2, "      matchDef", i16, 0);
        A0(sb2, "      matchPercent", f11, 1.0f);
        sb2.append("    },\n");
    }

    private void S(StringBuilder sb2, String str, ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.f6926f == null) {
            return;
        }
        sb2.append("    ");
        sb2.append(str);
        sb2.append(" : [ '");
        sb2.append(constraintAnchor.f6926f);
        sb2.append("'");
        if (constraintAnchor.f6928h != Integer.MIN_VALUE || constraintAnchor.f6927g != 0) {
            sb2.append(",");
            sb2.append(constraintAnchor.f6927g);
            if (constraintAnchor.f6928h != Integer.MIN_VALUE) {
                sb2.append(",");
                sb2.append(constraintAnchor.f6928h);
                sb2.append(",");
            }
        }
        sb2.append(" ] ,\n");
    }

    private void d() {
        this.Z.add(this.Q);
        this.Z.add(this.R);
        this.Z.add(this.S);
        this.Z.add(this.T);
        this.Z.add(this.V);
        this.Z.add(this.W);
        this.Z.add(this.X);
        this.Z.add(this.U);
    }

    private boolean h0(int i11) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        int i12 = i11 * 2;
        ConstraintAnchor[] constraintAnchorArr = this.Y;
        ConstraintAnchor constraintAnchor3 = constraintAnchorArr[i12];
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f6926f;
        return (constraintAnchor4 == null || constraintAnchor4.f6926f == constraintAnchor3 || (constraintAnchor2 = (constraintAnchor = constraintAnchorArr[i12 + 1]).f6926f) == null || constraintAnchor2.f6926f != constraintAnchor) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03a3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0433 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0497  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x04a9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:244:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x04fd  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x04cd A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void i(androidx.constraintlayout.core.d r32, boolean r33, boolean r34, boolean r35, boolean r36, androidx.constraintlayout.core.SolverVariable r37, androidx.constraintlayout.core.SolverVariable r38, androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour r39, boolean r40, androidx.constraintlayout.core.widgets.ConstraintAnchor r41, androidx.constraintlayout.core.widgets.ConstraintAnchor r42, int r43, int r44, int r45, int r46, float r47, boolean r48, boolean r49, boolean r50, boolean r51, boolean r52, int r53, int r54, int r55, int r56, float r57, boolean r58) {
        /*
            Method dump skipped, instructions count: 1353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.i(androidx.constraintlayout.core.d, boolean, boolean, boolean, boolean, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour, boolean, androidx.constraintlayout.core.widgets.ConstraintAnchor, androidx.constraintlayout.core.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public float A() {
        return this.f6964q0;
    }

    public int B() {
        return this.J0;
    }

    public DimensionBehaviour C() {
        return this.f6934b0[0];
    }

    public int D() {
        ConstraintAnchor constraintAnchor = this.Q;
        int i11 = constraintAnchor != null ? constraintAnchor.f6927g : 0;
        ConstraintAnchor constraintAnchor2 = this.S;
        return constraintAnchor2 != null ? i11 + constraintAnchor2.f6927g : i11;
    }

    public void D0(boolean z10) {
        this.f6974v0 = z10;
    }

    public int E() {
        return this.O;
    }

    public void E0(int i11) {
        this.f6958n0 = i11;
        this.L = i11 > 0;
    }

    public int F() {
        return this.P;
    }

    public void F0(Object obj) {
        this.f6968s0 = obj;
    }

    public int G(int i11) {
        if (i11 == 0) {
            return Y();
        }
        if (i11 == 1) {
            return z();
        }
        return 0;
    }

    public void G0(String str) {
        this.f6976w0 = str;
    }

    public int H() {
        return this.J[1];
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0086 -> B:31:0x0087). Please report as a decompilation issue!!! */
    public void H0(String str) {
        float f11;
        int i11 = 0;
        if (str == null || str.length() == 0) {
            this.f6942f0 = 0.0f;
            return;
        }
        int length = str.length();
        int indexOf = str.indexOf(44);
        int i12 = -1;
        if (indexOf > 0 && indexOf < length - 1) {
            String substring = str.substring(0, indexOf);
            i12 = substring.equalsIgnoreCase("W") ? 0 : substring.equalsIgnoreCase("H") ? 1 : -1;
            r3 = indexOf + 1;
        }
        int indexOf2 = str.indexOf(58);
        if (indexOf2 < 0 || indexOf2 >= length - 1) {
            String substring2 = str.substring(r3);
            if (substring2.length() > 0) {
                f11 = Float.parseFloat(substring2);
            }
            f11 = i11;
        } else {
            String substring3 = str.substring(r3, indexOf2);
            String substring4 = str.substring(indexOf2 + 1);
            if (substring3.length() > 0 && substring4.length() > 0) {
                float parseFloat = Float.parseFloat(substring3);
                float parseFloat2 = Float.parseFloat(substring4);
                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                    f11 = i12 == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                }
            }
            f11 = i11;
        }
        i11 = (f11 > i11 ? 1 : (f11 == i11 ? 0 : -1));
        if (i11 > 0) {
            this.f6942f0 = f11;
            this.f6944g0 = i12;
        }
    }

    public int I() {
        return this.J[0];
    }

    public void I0(int i11) {
        if (this.L) {
            int i12 = i11 - this.f6958n0;
            int i13 = this.f6940e0 + i12;
            this.f6948i0 = i12;
            this.R.t(i12);
            this.T.t(i13);
            this.U.t(i11);
            this.f6963q = true;
        }
    }

    public int J() {
        return this.f6962p0;
    }

    public void J0(int i11, int i12) {
        if (this.f6961p) {
            return;
        }
        this.Q.t(i11);
        this.S.t(i12);
        this.f6946h0 = i11;
        this.f6938d0 = i12 - i11;
        this.f6961p = true;
    }

    public int K() {
        return this.f6960o0;
    }

    public void K0(int i11) {
        this.Q.t(i11);
        this.f6946h0 = i11;
    }

    public ConstraintWidget L(int i11) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i11 != 0) {
            if (i11 == 1 && (constraintAnchor2 = (constraintAnchor = this.T).f6926f) != null && constraintAnchor2.f6926f == constraintAnchor) {
                return constraintAnchor2.f6924d;
            }
            return null;
        }
        ConstraintAnchor constraintAnchor3 = this.S;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f6926f;
        if (constraintAnchor4 == null || constraintAnchor4.f6926f != constraintAnchor3) {
            return null;
        }
        return constraintAnchor4.f6924d;
    }

    public void L0(int i11) {
        this.R.t(i11);
        this.f6948i0 = i11;
    }

    public ConstraintWidget M() {
        return this.f6936c0;
    }

    public void M0(int i11, int i12) {
        if (this.f6963q) {
            return;
        }
        this.R.t(i11);
        this.T.t(i12);
        this.f6948i0 = i11;
        this.f6940e0 = i12 - i11;
        if (this.L) {
            this.U.t(i11 + this.f6958n0);
        }
        this.f6963q = true;
    }

    public ConstraintWidget N(int i11) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i11 != 0) {
            if (i11 == 1 && (constraintAnchor2 = (constraintAnchor = this.R).f6926f) != null && constraintAnchor2.f6926f == constraintAnchor) {
                return constraintAnchor2.f6924d;
            }
            return null;
        }
        ConstraintAnchor constraintAnchor3 = this.Q;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f6926f;
        if (constraintAnchor4 == null || constraintAnchor4.f6926f != constraintAnchor3) {
            return null;
        }
        return constraintAnchor4.f6924d;
    }

    public void N0(int i11, int i12, int i13, int i14) {
        int i15;
        int i16;
        int i17 = i13 - i11;
        int i18 = i14 - i12;
        this.f6946h0 = i11;
        this.f6948i0 = i12;
        if (this.f6972u0 == 8) {
            this.f6938d0 = 0;
            this.f6940e0 = 0;
            return;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.f6934b0;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        if (dimensionBehaviour == dimensionBehaviour2 && i17 < (i16 = this.f6938d0)) {
            i17 = i16;
        }
        if (dimensionBehaviourArr[1] == dimensionBehaviour2 && i18 < (i15 = this.f6940e0)) {
            i18 = i15;
        }
        this.f6938d0 = i17;
        this.f6940e0 = i18;
        int i19 = this.f6962p0;
        if (i18 < i19) {
            this.f6940e0 = i19;
        }
        int i20 = this.f6960o0;
        if (i17 < i20) {
            this.f6938d0 = i20;
        }
        int i21 = this.A;
        if (i21 > 0 && dimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.f6938d0 = Math.min(this.f6938d0, i21);
        }
        int i22 = this.D;
        if (i22 > 0 && this.f6934b0[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.f6940e0 = Math.min(this.f6940e0, i22);
        }
        int i23 = this.f6938d0;
        if (i17 != i23) {
            this.f6953l = i23;
        }
        int i24 = this.f6940e0;
        if (i18 != i24) {
            this.f6955m = i24;
        }
    }

    public int O() {
        return Z() + this.f6938d0;
    }

    public void O0(boolean z10) {
        this.L = z10;
    }

    public WidgetRun P(int i11) {
        if (i11 == 0) {
            return this.f6939e;
        }
        if (i11 == 1) {
            return this.f6941f;
        }
        return null;
    }

    public void P0(int i11) {
        this.f6940e0 = i11;
        int i12 = this.f6962p0;
        if (i11 < i12) {
            this.f6940e0 = i12;
        }
    }

    public void Q(StringBuilder sb2) {
        sb2.append("  " + this.f6959o + ":{\n");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("    actualWidth:");
        sb3.append(this.f6938d0);
        sb2.append(sb3.toString());
        sb2.append("\n");
        sb2.append("    actualHeight:" + this.f6940e0);
        sb2.append("\n");
        sb2.append("    actualLeft:" + this.f6946h0);
        sb2.append("\n");
        sb2.append("    actualTop:" + this.f6948i0);
        sb2.append("\n");
        S(sb2, TtmlNode.LEFT, this.Q);
        S(sb2, IntegrationConstants.TAB_BAR_POSITION_TOP, this.R);
        S(sb2, TtmlNode.RIGHT, this.S);
        S(sb2, IntegrationConstants.TAB_BAR_POSITION_DEFAULT, this.T);
        S(sb2, "baseline", this.U);
        S(sb2, "centerX", this.V);
        S(sb2, "centerY", this.W);
        R(sb2, "    width", this.f6938d0, this.f6960o0, this.J[0], this.f6953l, this.f6981z, this.f6975w, this.B, this.N0[0]);
        R(sb2, "    height", this.f6940e0, this.f6962p0, this.J[1], this.f6955m, this.C, this.f6977x, this.E, this.N0[1]);
        C0(sb2, "    dimensionRatio", this.f6942f0, this.f6944g0);
        A0(sb2, "    horizontalBias", this.f6964q0, U0);
        A0(sb2, "    verticalBias", this.f6966r0, U0);
        B0(sb2, "    horizontalChainStyle", this.J0, 0);
        B0(sb2, "    verticalChainStyle", this.K0, 0);
        sb2.append("  }");
    }

    public void Q0(float f11) {
        this.f6964q0 = f11;
    }

    public void R0(int i11) {
        this.J0 = i11;
    }

    public void S0(int i11, int i12) {
        this.f6946h0 = i11;
        int i13 = i12 - i11;
        this.f6938d0 = i13;
        int i14 = this.f6960o0;
        if (i13 < i14) {
            this.f6938d0 = i14;
        }
    }

    public float T() {
        return this.f6966r0;
    }

    public void T0(DimensionBehaviour dimensionBehaviour) {
        this.f6934b0[0] = dimensionBehaviour;
    }

    public int U() {
        return this.K0;
    }

    public void U0(int i11, int i12, int i13, float f11) {
        this.f6975w = i11;
        this.f6981z = i12;
        if (i13 == Integer.MAX_VALUE) {
            i13 = 0;
        }
        this.A = i13;
        this.B = f11;
        if (f11 <= 0.0f || f11 >= 1.0f || i11 != 0) {
            return;
        }
        this.f6975w = 2;
    }

    public DimensionBehaviour V() {
        return this.f6934b0[1];
    }

    public void V0(float f11) {
        this.N0[0] = f11;
    }

    public int W() {
        int i11 = this.Q != null ? this.R.f6927g : 0;
        return this.S != null ? i11 + this.T.f6927g : i11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void W0(int i11, boolean z10) {
        this.f6932a0[i11] = z10;
    }

    public int X() {
        return this.f6972u0;
    }

    public void X0(boolean z10) {
        this.M = z10;
    }

    public int Y() {
        if (this.f6972u0 == 8) {
            return 0;
        }
        return this.f6938d0;
    }

    public void Y0(boolean z10) {
        this.N = z10;
    }

    public int Z() {
        ConstraintWidget constraintWidget = this.f6936c0;
        return (constraintWidget == null || !(constraintWidget instanceof d)) ? this.f6946h0 : ((d) constraintWidget).f7093d1 + this.f6946h0;
    }

    public void Z0(int i11, int i12) {
        this.O = i11;
        this.P = i12;
        c1(false);
    }

    public int a0() {
        ConstraintWidget constraintWidget = this.f6936c0;
        return (constraintWidget == null || !(constraintWidget instanceof d)) ? this.f6948i0 : ((d) constraintWidget).f7094e1 + this.f6948i0;
    }

    public void a1(int i11) {
        this.J[1] = i11;
    }

    public boolean b0() {
        return this.L;
    }

    public void b1(int i11) {
        this.J[0] = i11;
    }

    public boolean c0(int i11) {
        if (i11 == 0) {
            return (this.Q.f6926f != null ? 1 : 0) + (this.S.f6926f != null ? 1 : 0) < 2;
        }
        return ((this.R.f6926f != null ? 1 : 0) + (this.T.f6926f != null ? 1 : 0)) + (this.U.f6926f != null ? 1 : 0) < 2;
    }

    public void c1(boolean z10) {
        this.f6947i = z10;
    }

    public boolean d0() {
        int size = this.Z.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (((ConstraintAnchor) this.Z.get(i11)).m()) {
                return true;
            }
        }
        return false;
    }

    public void d1(int i11) {
        if (i11 < 0) {
            this.f6962p0 = 0;
        } else {
            this.f6962p0 = i11;
        }
    }

    public void e(d dVar, androidx.constraintlayout.core.d dVar2, HashSet hashSet, int i11, boolean z10) {
        if (z10) {
            if (!hashSet.contains(this)) {
                return;
            }
            g.a(dVar, dVar2, this);
            hashSet.remove(this);
            g(dVar2, dVar.Y1(64));
        }
        if (i11 == 0) {
            HashSet d11 = this.Q.d();
            if (d11 != null) {
                Iterator it = d11.iterator();
                while (it.hasNext()) {
                    ((ConstraintAnchor) it.next()).f6924d.e(dVar, dVar2, hashSet, i11, true);
                }
            }
            HashSet d12 = this.S.d();
            if (d12 != null) {
                Iterator it2 = d12.iterator();
                while (it2.hasNext()) {
                    ((ConstraintAnchor) it2.next()).f6924d.e(dVar, dVar2, hashSet, i11, true);
                }
                return;
            }
            return;
        }
        HashSet d13 = this.R.d();
        if (d13 != null) {
            Iterator it3 = d13.iterator();
            while (it3.hasNext()) {
                ((ConstraintAnchor) it3.next()).f6924d.e(dVar, dVar2, hashSet, i11, true);
            }
        }
        HashSet d14 = this.T.d();
        if (d14 != null) {
            Iterator it4 = d14.iterator();
            while (it4.hasNext()) {
                ((ConstraintAnchor) it4.next()).f6924d.e(dVar, dVar2, hashSet, i11, true);
            }
        }
        HashSet d15 = this.U.d();
        if (d15 != null) {
            Iterator it5 = d15.iterator();
            while (it5.hasNext()) {
                ((ConstraintAnchor) it5.next()).f6924d.e(dVar, dVar2, hashSet, i11, true);
            }
        }
    }

    public boolean e0() {
        return (this.f6953l == -1 && this.f6955m == -1) ? false : true;
    }

    public void e1(int i11) {
        if (i11 < 0) {
            this.f6960o0 = 0;
        } else {
            this.f6960o0 = i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return (this instanceof i) || (this instanceof f);
    }

    public boolean f0(int i11, int i12) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i11 == 0) {
            ConstraintAnchor constraintAnchor3 = this.Q.f6926f;
            return constraintAnchor3 != null && constraintAnchor3.n() && (constraintAnchor2 = this.S.f6926f) != null && constraintAnchor2.n() && (this.S.f6926f.e() - this.S.f()) - (this.Q.f6926f.e() + this.Q.f()) >= i12;
        }
        ConstraintAnchor constraintAnchor4 = this.R.f6926f;
        return constraintAnchor4 != null && constraintAnchor4.n() && (constraintAnchor = this.T.f6926f) != null && constraintAnchor.n() && (this.T.f6926f.e() - this.T.f()) - (this.R.f6926f.e() + this.R.f()) >= i12;
        return false;
    }

    public void f1(int i11, int i12) {
        this.f6946h0 = i11;
        this.f6948i0 = i12;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x04c3  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x04c8  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0563  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x05af  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x05dd  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0566  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x04c5  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x019f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(androidx.constraintlayout.core.d r54, boolean r55) {
        /*
            Method dump skipped, instructions count: 1539
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.g(androidx.constraintlayout.core.d, boolean):void");
    }

    public void g0(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i11, int i12) {
        q(type).b(constraintWidget.q(type2), i11, i12, true);
    }

    public void g1(ConstraintWidget constraintWidget) {
        this.f6936c0 = constraintWidget;
    }

    public boolean h() {
        return this.f6972u0 != 8;
    }

    public void h1(float f11) {
        this.f6966r0 = f11;
    }

    public boolean i0() {
        return this.f6965r;
    }

    public void i1(int i11) {
        this.K0 = i11;
    }

    public void j(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        k(type, constraintWidget, type2, 0);
    }

    public boolean j0(int i11) {
        return this.f6932a0[i11];
    }

    public void j1(int i11, int i12) {
        this.f6948i0 = i11;
        int i13 = i12 - i11;
        this.f6940e0 = i13;
        int i14 = this.f6962p0;
        if (i13 < i14) {
            this.f6940e0 = i14;
        }
    }

    public void k(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i11) {
        ConstraintAnchor.Type type3;
        ConstraintAnchor.Type type4;
        boolean z10;
        ConstraintAnchor.Type type5 = ConstraintAnchor.Type.CENTER;
        if (type == type5) {
            if (type2 != type5) {
                ConstraintAnchor.Type type6 = ConstraintAnchor.Type.LEFT;
                if (type2 == type6 || type2 == ConstraintAnchor.Type.RIGHT) {
                    k(type6, constraintWidget, type2, 0);
                    k(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0);
                    q(type5).a(constraintWidget.q(type2), 0);
                    return;
                }
                ConstraintAnchor.Type type7 = ConstraintAnchor.Type.TOP;
                if (type2 == type7 || type2 == ConstraintAnchor.Type.BOTTOM) {
                    k(type7, constraintWidget, type2, 0);
                    k(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0);
                    q(type5).a(constraintWidget.q(type2), 0);
                    return;
                }
                return;
            }
            ConstraintAnchor.Type type8 = ConstraintAnchor.Type.LEFT;
            ConstraintAnchor q11 = q(type8);
            ConstraintAnchor.Type type9 = ConstraintAnchor.Type.RIGHT;
            ConstraintAnchor q12 = q(type9);
            ConstraintAnchor.Type type10 = ConstraintAnchor.Type.TOP;
            ConstraintAnchor q13 = q(type10);
            ConstraintAnchor.Type type11 = ConstraintAnchor.Type.BOTTOM;
            ConstraintAnchor q14 = q(type11);
            boolean z11 = true;
            if ((q11 == null || !q11.o()) && (q12 == null || !q12.o())) {
                k(type8, constraintWidget, type8, 0);
                k(type9, constraintWidget, type9, 0);
                z10 = true;
            } else {
                z10 = false;
            }
            if ((q13 == null || !q13.o()) && (q14 == null || !q14.o())) {
                k(type10, constraintWidget, type10, 0);
                k(type11, constraintWidget, type11, 0);
            } else {
                z11 = false;
            }
            if (z10 && z11) {
                q(type5).a(constraintWidget.q(type5), 0);
                return;
            }
            if (z10) {
                ConstraintAnchor.Type type12 = ConstraintAnchor.Type.CENTER_X;
                q(type12).a(constraintWidget.q(type12), 0);
                return;
            } else {
                if (z11) {
                    ConstraintAnchor.Type type13 = ConstraintAnchor.Type.CENTER_Y;
                    q(type13).a(constraintWidget.q(type13), 0);
                    return;
                }
                return;
            }
        }
        ConstraintAnchor.Type type14 = ConstraintAnchor.Type.CENTER_X;
        if (type == type14 && (type2 == (type4 = ConstraintAnchor.Type.LEFT) || type2 == ConstraintAnchor.Type.RIGHT)) {
            ConstraintAnchor q15 = q(type4);
            ConstraintAnchor q16 = constraintWidget.q(type2);
            ConstraintAnchor q17 = q(ConstraintAnchor.Type.RIGHT);
            q15.a(q16, 0);
            q17.a(q16, 0);
            q(type14).a(q16, 0);
            return;
        }
        ConstraintAnchor.Type type15 = ConstraintAnchor.Type.CENTER_Y;
        if (type == type15 && (type2 == (type3 = ConstraintAnchor.Type.TOP) || type2 == ConstraintAnchor.Type.BOTTOM)) {
            ConstraintAnchor q18 = constraintWidget.q(type2);
            q(type3).a(q18, 0);
            q(ConstraintAnchor.Type.BOTTOM).a(q18, 0);
            q(type15).a(q18, 0);
            return;
        }
        if (type == type14 && type2 == type14) {
            ConstraintAnchor.Type type16 = ConstraintAnchor.Type.LEFT;
            q(type16).a(constraintWidget.q(type16), 0);
            ConstraintAnchor.Type type17 = ConstraintAnchor.Type.RIGHT;
            q(type17).a(constraintWidget.q(type17), 0);
            q(type14).a(constraintWidget.q(type2), 0);
            return;
        }
        if (type == type15 && type2 == type15) {
            ConstraintAnchor.Type type18 = ConstraintAnchor.Type.TOP;
            q(type18).a(constraintWidget.q(type18), 0);
            ConstraintAnchor.Type type19 = ConstraintAnchor.Type.BOTTOM;
            q(type19).a(constraintWidget.q(type19), 0);
            q(type15).a(constraintWidget.q(type2), 0);
            return;
        }
        ConstraintAnchor q19 = q(type);
        ConstraintAnchor q20 = constraintWidget.q(type2);
        if (q19.p(q20)) {
            ConstraintAnchor.Type type20 = ConstraintAnchor.Type.BASELINE;
            if (type == type20) {
                ConstraintAnchor q21 = q(ConstraintAnchor.Type.TOP);
                ConstraintAnchor q22 = q(ConstraintAnchor.Type.BOTTOM);
                if (q21 != null) {
                    q21.q();
                }
                if (q22 != null) {
                    q22.q();
                }
            } else if (type == ConstraintAnchor.Type.TOP || type == ConstraintAnchor.Type.BOTTOM) {
                ConstraintAnchor q23 = q(type20);
                if (q23 != null) {
                    q23.q();
                }
                ConstraintAnchor q24 = q(type5);
                if (q24.j() != q20) {
                    q24.q();
                }
                ConstraintAnchor g11 = q(type).g();
                ConstraintAnchor q25 = q(type15);
                if (q25.o()) {
                    g11.q();
                    q25.q();
                }
            } else if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                ConstraintAnchor q26 = q(type5);
                if (q26.j() != q20) {
                    q26.q();
                }
                ConstraintAnchor g12 = q(type).g();
                ConstraintAnchor q27 = q(type14);
                if (q27.o()) {
                    g12.q();
                    q27.q();
                }
            }
            q19.a(q20, i11);
        }
    }

    public boolean k0() {
        ConstraintAnchor constraintAnchor = this.Q;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f6926f;
        if (constraintAnchor2 != null && constraintAnchor2.f6926f == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.S;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f6926f;
        return constraintAnchor4 != null && constraintAnchor4.f6926f == constraintAnchor3;
    }

    public void k1(DimensionBehaviour dimensionBehaviour) {
        this.f6934b0[1] = dimensionBehaviour;
    }

    public void l(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i11) {
        if (constraintAnchor.h() == this) {
            k(constraintAnchor.k(), constraintAnchor2.h(), constraintAnchor2.k(), i11);
        }
    }

    public boolean l0() {
        return this.M;
    }

    public void l1(int i11, int i12, int i13, float f11) {
        this.f6977x = i11;
        this.C = i12;
        if (i13 == Integer.MAX_VALUE) {
            i13 = 0;
        }
        this.D = i13;
        this.E = f11;
        if (f11 <= 0.0f || f11 >= 1.0f || i11 != 0) {
            return;
        }
        this.f6977x = 2;
    }

    public void m(ConstraintWidget constraintWidget, float f11, int i11) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
        g0(type, constraintWidget, type, i11, 0);
        this.K = f11;
    }

    public boolean m0() {
        ConstraintAnchor constraintAnchor = this.R;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f6926f;
        if (constraintAnchor2 != null && constraintAnchor2.f6926f == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.T;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f6926f;
        return constraintAnchor4 != null && constraintAnchor4.f6926f == constraintAnchor3;
    }

    public void m1(float f11) {
        this.N0[1] = f11;
    }

    public void n(ConstraintWidget constraintWidget, HashMap hashMap) {
        this.f6969t = constraintWidget.f6969t;
        this.f6971u = constraintWidget.f6971u;
        this.f6975w = constraintWidget.f6975w;
        this.f6977x = constraintWidget.f6977x;
        int[] iArr = this.f6979y;
        int[] iArr2 = constraintWidget.f6979y;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.f6981z = constraintWidget.f6981z;
        this.A = constraintWidget.A;
        this.C = constraintWidget.C;
        this.D = constraintWidget.D;
        this.E = constraintWidget.E;
        this.F = constraintWidget.F;
        this.G = constraintWidget.G;
        this.H = constraintWidget.H;
        this.I = constraintWidget.I;
        int[] iArr3 = constraintWidget.J;
        this.J = Arrays.copyOf(iArr3, iArr3.length);
        this.K = constraintWidget.K;
        this.L = constraintWidget.L;
        this.M = constraintWidget.M;
        this.Q.q();
        this.R.q();
        this.S.q();
        this.T.q();
        this.U.q();
        this.V.q();
        this.W.q();
        this.X.q();
        this.f6934b0 = (DimensionBehaviour[]) Arrays.copyOf(this.f6934b0, 2);
        this.f6936c0 = this.f6936c0 == null ? null : (ConstraintWidget) hashMap.get(constraintWidget.f6936c0);
        this.f6938d0 = constraintWidget.f6938d0;
        this.f6940e0 = constraintWidget.f6940e0;
        this.f6942f0 = constraintWidget.f6942f0;
        this.f6944g0 = constraintWidget.f6944g0;
        this.f6946h0 = constraintWidget.f6946h0;
        this.f6948i0 = constraintWidget.f6948i0;
        this.f6950j0 = constraintWidget.f6950j0;
        this.f6952k0 = constraintWidget.f6952k0;
        this.f6954l0 = constraintWidget.f6954l0;
        this.f6956m0 = constraintWidget.f6956m0;
        this.f6958n0 = constraintWidget.f6958n0;
        this.f6960o0 = constraintWidget.f6960o0;
        this.f6962p0 = constraintWidget.f6962p0;
        this.f6964q0 = constraintWidget.f6964q0;
        this.f6966r0 = constraintWidget.f6966r0;
        this.f6968s0 = constraintWidget.f6968s0;
        this.f6970t0 = constraintWidget.f6970t0;
        this.f6972u0 = constraintWidget.f6972u0;
        this.f6974v0 = constraintWidget.f6974v0;
        this.f6976w0 = constraintWidget.f6976w0;
        this.f6978x0 = constraintWidget.f6978x0;
        this.f6980y0 = constraintWidget.f6980y0;
        this.f6982z0 = constraintWidget.f6982z0;
        this.A0 = constraintWidget.A0;
        this.B0 = constraintWidget.B0;
        this.C0 = constraintWidget.C0;
        this.D0 = constraintWidget.D0;
        this.E0 = constraintWidget.E0;
        this.F0 = constraintWidget.F0;
        this.G0 = constraintWidget.G0;
        this.H0 = constraintWidget.H0;
        this.J0 = constraintWidget.J0;
        this.K0 = constraintWidget.K0;
        this.L0 = constraintWidget.L0;
        this.M0 = constraintWidget.M0;
        float[] fArr = this.N0;
        float[] fArr2 = constraintWidget.N0;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        ConstraintWidget[] constraintWidgetArr = this.O0;
        ConstraintWidget[] constraintWidgetArr2 = constraintWidget.O0;
        constraintWidgetArr[0] = constraintWidgetArr2[0];
        constraintWidgetArr[1] = constraintWidgetArr2[1];
        ConstraintWidget[] constraintWidgetArr3 = this.P0;
        ConstraintWidget[] constraintWidgetArr4 = constraintWidget.P0;
        constraintWidgetArr3[0] = constraintWidgetArr4[0];
        constraintWidgetArr3[1] = constraintWidgetArr4[1];
        ConstraintWidget constraintWidget2 = constraintWidget.Q0;
        this.Q0 = constraintWidget2 == null ? null : (ConstraintWidget) hashMap.get(constraintWidget2);
        ConstraintWidget constraintWidget3 = constraintWidget.R0;
        this.R0 = constraintWidget3 != null ? (ConstraintWidget) hashMap.get(constraintWidget3) : null;
    }

    public boolean n0() {
        return this.N;
    }

    public void n1(int i11) {
        this.f6972u0 = i11;
    }

    public void o(androidx.constraintlayout.core.d dVar) {
        dVar.q(this.Q);
        dVar.q(this.R);
        dVar.q(this.S);
        dVar.q(this.T);
        if (this.f6958n0 > 0) {
            dVar.q(this.U);
        }
    }

    public boolean o0() {
        return this.f6947i && this.f6972u0 != 8;
    }

    public void o1(int i11) {
        this.f6938d0 = i11;
        int i12 = this.f6960o0;
        if (i11 < i12) {
            this.f6938d0 = i12;
        }
    }

    public void p() {
        if (this.f6939e == null) {
            this.f6939e = new j(this);
        }
        if (this.f6941f == null) {
            this.f6941f = new l(this);
        }
    }

    public boolean p0() {
        return this.f6961p || (this.Q.n() && this.S.n());
    }

    public void p1(int i11) {
        if (i11 < 0 || i11 > 3) {
            return;
        }
        this.f6973v = i11;
    }

    public ConstraintAnchor q(ConstraintAnchor.Type type) {
        switch (a.f6983a[type.ordinal()]) {
            case 1:
                return this.Q;
            case 2:
                return this.R;
            case 3:
                return this.S;
            case 4:
                return this.T;
            case 5:
                return this.U;
            case 6:
                return this.X;
            case 7:
                return this.V;
            case 8:
                return this.W;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public boolean q0() {
        return this.f6963q || (this.R.n() && this.T.n());
    }

    public void q1(int i11) {
        this.f6946h0 = i11;
    }

    public int r() {
        return this.f6958n0;
    }

    public boolean r0() {
        return this.f6967s;
    }

    public void r1(int i11) {
        this.f6948i0 = i11;
    }

    public float s(int i11) {
        if (i11 == 0) {
            return this.f6964q0;
        }
        if (i11 == 1) {
            return this.f6966r0;
        }
        return -1.0f;
    }

    public void s0() {
        this.f6965r = true;
    }

    public void s1(boolean z10, boolean z11, boolean z12, boolean z13) {
        if (this.H == -1) {
            if (z12 && !z13) {
                this.H = 0;
            } else if (!z12 && z13) {
                this.H = 1;
                if (this.f6944g0 == -1) {
                    this.I = 1.0f / this.I;
                }
            }
        }
        if (this.H == 0 && (!this.R.o() || !this.T.o())) {
            this.H = 1;
        } else if (this.H == 1 && (!this.Q.o() || !this.S.o())) {
            this.H = 0;
        }
        if (this.H == -1 && (!this.R.o() || !this.T.o() || !this.Q.o() || !this.S.o())) {
            if (this.R.o() && this.T.o()) {
                this.H = 0;
            } else if (this.Q.o() && this.S.o()) {
                this.I = 1.0f / this.I;
                this.H = 1;
            }
        }
        if (this.H == -1) {
            int i11 = this.f6981z;
            if (i11 > 0 && this.C == 0) {
                this.H = 0;
            } else {
                if (i11 != 0 || this.C <= 0) {
                    return;
                }
                this.I = 1.0f / this.I;
                this.H = 1;
            }
        }
    }

    public int t() {
        return a0() + this.f6940e0;
    }

    public void t0() {
        this.f6967s = true;
    }

    public void t1(boolean z10, boolean z11) {
        int i11;
        int i12;
        boolean k11 = z10 & this.f6939e.k();
        boolean k12 = z11 & this.f6941f.k();
        j jVar = this.f6939e;
        int i13 = jVar.f7005h.f6992g;
        l lVar = this.f6941f;
        int i14 = lVar.f7005h.f6992g;
        int i15 = jVar.f7006i.f6992g;
        int i16 = lVar.f7006i.f6992g;
        int i17 = i16 - i14;
        if (i15 - i13 < 0 || i17 < 0 || i13 == Integer.MIN_VALUE || i13 == Integer.MAX_VALUE || i14 == Integer.MIN_VALUE || i14 == Integer.MAX_VALUE || i15 == Integer.MIN_VALUE || i15 == Integer.MAX_VALUE || i16 == Integer.MIN_VALUE || i16 == Integer.MAX_VALUE) {
            i15 = 0;
            i13 = 0;
            i16 = 0;
            i14 = 0;
        }
        int i18 = i15 - i13;
        int i19 = i16 - i14;
        if (k11) {
            this.f6946h0 = i13;
        }
        if (k12) {
            this.f6948i0 = i14;
        }
        if (this.f6972u0 == 8) {
            this.f6938d0 = 0;
            this.f6940e0 = 0;
            return;
        }
        if (k11) {
            if (this.f6934b0[0] == DimensionBehaviour.FIXED && i18 < (i12 = this.f6938d0)) {
                i18 = i12;
            }
            this.f6938d0 = i18;
            int i20 = this.f6960o0;
            if (i18 < i20) {
                this.f6938d0 = i20;
            }
        }
        if (k12) {
            if (this.f6934b0[1] == DimensionBehaviour.FIXED && i19 < (i11 = this.f6940e0)) {
                i19 = i11;
            }
            this.f6940e0 = i19;
            int i21 = this.f6962p0;
            if (i19 < i21) {
                this.f6940e0 = i21;
            }
        }
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        String str2 = "";
        if (this.f6978x0 != null) {
            str = "type: " + this.f6978x0 + " ";
        } else {
            str = "";
        }
        sb2.append(str);
        if (this.f6976w0 != null) {
            str2 = "id: " + this.f6976w0 + " ";
        }
        sb2.append(str2);
        sb2.append("(");
        sb2.append(this.f6946h0);
        sb2.append(", ");
        sb2.append(this.f6948i0);
        sb2.append(") - (");
        sb2.append(this.f6938d0);
        sb2.append(" x ");
        sb2.append(this.f6940e0);
        sb2.append(")");
        return sb2.toString();
    }

    public Object u() {
        return this.f6968s0;
    }

    public boolean u0() {
        DimensionBehaviour[] dimensionBehaviourArr = this.f6934b0;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
        return dimensionBehaviour == dimensionBehaviour2 && dimensionBehaviourArr[1] == dimensionBehaviour2;
    }

    public void u1(androidx.constraintlayout.core.d dVar, boolean z10) {
        l lVar;
        j jVar;
        int y10 = dVar.y(this.Q);
        int y11 = dVar.y(this.R);
        int y12 = dVar.y(this.S);
        int y13 = dVar.y(this.T);
        if (z10 && (jVar = this.f6939e) != null) {
            DependencyNode dependencyNode = jVar.f7005h;
            if (dependencyNode.f6995j) {
                DependencyNode dependencyNode2 = jVar.f7006i;
                if (dependencyNode2.f6995j) {
                    y10 = dependencyNode.f6992g;
                    y12 = dependencyNode2.f6992g;
                }
            }
        }
        if (z10 && (lVar = this.f6941f) != null) {
            DependencyNode dependencyNode3 = lVar.f7005h;
            if (dependencyNode3.f6995j) {
                DependencyNode dependencyNode4 = lVar.f7006i;
                if (dependencyNode4.f6995j) {
                    y11 = dependencyNode3.f6992g;
                    y13 = dependencyNode4.f6992g;
                }
            }
        }
        int i11 = y13 - y11;
        if (y12 - y10 < 0 || i11 < 0 || y10 == Integer.MIN_VALUE || y10 == Integer.MAX_VALUE || y11 == Integer.MIN_VALUE || y11 == Integer.MAX_VALUE || y12 == Integer.MIN_VALUE || y12 == Integer.MAX_VALUE || y13 == Integer.MIN_VALUE || y13 == Integer.MAX_VALUE) {
            y10 = 0;
            y13 = 0;
            y11 = 0;
            y12 = 0;
        }
        N0(y10, y11, y12, y13);
    }

    public String v() {
        return this.f6976w0;
    }

    public void v0() {
        this.Q.q();
        this.R.q();
        this.S.q();
        this.T.q();
        this.U.q();
        this.V.q();
        this.W.q();
        this.X.q();
        this.f6936c0 = null;
        this.K = 0.0f;
        this.f6938d0 = 0;
        this.f6940e0 = 0;
        this.f6942f0 = 0.0f;
        this.f6944g0 = -1;
        this.f6946h0 = 0;
        this.f6948i0 = 0;
        this.f6954l0 = 0;
        this.f6956m0 = 0;
        this.f6958n0 = 0;
        this.f6960o0 = 0;
        this.f6962p0 = 0;
        float f11 = U0;
        this.f6964q0 = f11;
        this.f6966r0 = f11;
        DimensionBehaviour[] dimensionBehaviourArr = this.f6934b0;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.f6968s0 = null;
        this.f6970t0 = 0;
        this.f6972u0 = 0;
        this.f6978x0 = null;
        this.G0 = false;
        this.H0 = false;
        this.J0 = 0;
        this.K0 = 0;
        this.L0 = false;
        this.M0 = false;
        float[] fArr = this.N0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f6969t = -1;
        this.f6971u = -1;
        int[] iArr = this.J;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f6975w = 0;
        this.f6977x = 0;
        this.B = 1.0f;
        this.E = 1.0f;
        this.A = Integer.MAX_VALUE;
        this.D = Integer.MAX_VALUE;
        this.f6981z = 0;
        this.C = 0;
        this.f6945h = false;
        this.H = -1;
        this.I = 1.0f;
        this.I0 = false;
        boolean[] zArr = this.f6943g;
        zArr[0] = true;
        zArr[1] = true;
        this.N = false;
        boolean[] zArr2 = this.f6932a0;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f6947i = true;
        int[] iArr2 = this.f6979y;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.f6953l = -1;
        this.f6955m = -1;
    }

    public DimensionBehaviour w(int i11) {
        if (i11 == 0) {
            return C();
        }
        if (i11 == 1) {
            return V();
        }
        return null;
    }

    public void w0() {
        x0();
        h1(U0);
        Q0(U0);
    }

    public float x() {
        return this.f6942f0;
    }

    public void x0() {
        ConstraintWidget M = M();
        if (M != null && (M instanceof d) && ((d) M()).Q1()) {
            return;
        }
        int size = this.Z.size();
        for (int i11 = 0; i11 < size; i11++) {
            ((ConstraintAnchor) this.Z.get(i11)).q();
        }
    }

    public int y() {
        return this.f6944g0;
    }

    public void y0() {
        this.f6961p = false;
        this.f6963q = false;
        this.f6965r = false;
        this.f6967s = false;
        int size = this.Z.size();
        for (int i11 = 0; i11 < size; i11++) {
            ((ConstraintAnchor) this.Z.get(i11)).r();
        }
    }

    public int z() {
        if (this.f6972u0 == 8) {
            return 0;
        }
        return this.f6940e0;
    }

    public void z0(androidx.constraintlayout.core.c cVar) {
        this.Q.s(cVar);
        this.R.s(cVar);
        this.S.s(cVar);
        this.T.s(cVar);
        this.U.s(cVar);
        this.X.s(cVar);
        this.V.s(cVar);
        this.W.s(cVar);
    }
}
