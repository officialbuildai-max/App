package androidx.constraintlayout.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.b;
import androidx.constraintlayout.core.widgets.f;
import androidx.constraintlayout.core.widgets.g;
import androidx.constraintlayout.core.widgets.i;
import androidx.core.view.InputDeviceCompat;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import com.tn.lib.view.FlowLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final boolean MEASURE = false;
    private static final boolean OPTIMIZE_HEIGHT_CHANGE = false;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.1.4";
    private static d sSharedValues;
    SparseArray<View> mChildrenByIds;
    private ArrayList<ConstraintHelper> mConstraintHelpers;
    protected androidx.constraintlayout.widget.a mConstraintLayoutSpec;
    private androidx.constraintlayout.widget.b mConstraintSet;
    private int mConstraintSetId;
    private androidx.constraintlayout.widget.c mConstraintsChangedListener;
    private HashMap<String, Integer> mDesignIds;
    protected boolean mDirtyHierarchy;
    private int mLastMeasureHeight;
    int mLastMeasureHeightMode;
    int mLastMeasureHeightSize;
    private int mLastMeasureWidth;
    int mLastMeasureWidthMode;
    int mLastMeasureWidthSize;
    protected androidx.constraintlayout.core.widgets.d mLayoutWidget;
    private int mMaxHeight;
    private int mMaxWidth;
    c mMeasurer;
    private androidx.constraintlayout.core.e mMetrics;
    private int mMinHeight;
    private int mMinWidth;
    private int mOnMeasureHeightMeasureSpec;
    private int mOnMeasureWidthMeasureSpec;
    private int mOptimizationLevel;
    private SparseArray<ConstraintWidget> mTempMapIdToWidget;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7736a;

        static {
            int[] iArr = new int[ConstraintWidget.DimensionBehaviour.values().length];
            f7736a = iArr;
            try {
                iArr[ConstraintWidget.DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7736a[ConstraintWidget.DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7736a[ConstraintWidget.DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7736a[ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends ViewGroup.MarginLayoutParams {
        public int A;
        public int B;
        public int C;
        public int D;
        boolean E;
        boolean F;
        public float G;
        public float H;
        public String I;
        float J;
        int K;
        public float L;
        public float M;
        public int N;
        public int O;
        public int P;
        public int Q;
        public int R;
        public int S;
        public int T;
        public int U;
        public float V;
        public float W;
        public int X;
        public int Y;
        public int Z;

        /* renamed from: a, reason: collision with root package name */
        public int f7737a;

        /* renamed from: a0, reason: collision with root package name */
        public boolean f7738a0;

        /* renamed from: b, reason: collision with root package name */
        public int f7739b;

        /* renamed from: b0, reason: collision with root package name */
        public boolean f7740b0;

        /* renamed from: c, reason: collision with root package name */
        public float f7741c;

        /* renamed from: c0, reason: collision with root package name */
        public String f7742c0;

        /* renamed from: d, reason: collision with root package name */
        public boolean f7743d;

        /* renamed from: d0, reason: collision with root package name */
        public int f7744d0;

        /* renamed from: e, reason: collision with root package name */
        public int f7745e;

        /* renamed from: e0, reason: collision with root package name */
        boolean f7746e0;

        /* renamed from: f, reason: collision with root package name */
        public int f7747f;

        /* renamed from: f0, reason: collision with root package name */
        boolean f7748f0;

        /* renamed from: g, reason: collision with root package name */
        public int f7749g;

        /* renamed from: g0, reason: collision with root package name */
        boolean f7750g0;

        /* renamed from: h, reason: collision with root package name */
        public int f7751h;

        /* renamed from: h0, reason: collision with root package name */
        boolean f7752h0;

        /* renamed from: i, reason: collision with root package name */
        public int f7753i;

        /* renamed from: i0, reason: collision with root package name */
        boolean f7754i0;

        /* renamed from: j, reason: collision with root package name */
        public int f7755j;

        /* renamed from: j0, reason: collision with root package name */
        boolean f7756j0;

        /* renamed from: k, reason: collision with root package name */
        public int f7757k;

        /* renamed from: k0, reason: collision with root package name */
        boolean f7758k0;

        /* renamed from: l, reason: collision with root package name */
        public int f7759l;

        /* renamed from: l0, reason: collision with root package name */
        int f7760l0;

        /* renamed from: m, reason: collision with root package name */
        public int f7761m;

        /* renamed from: m0, reason: collision with root package name */
        int f7762m0;

        /* renamed from: n, reason: collision with root package name */
        public int f7763n;

        /* renamed from: n0, reason: collision with root package name */
        int f7764n0;

        /* renamed from: o, reason: collision with root package name */
        public int f7765o;

        /* renamed from: o0, reason: collision with root package name */
        int f7766o0;

        /* renamed from: p, reason: collision with root package name */
        public int f7767p;

        /* renamed from: p0, reason: collision with root package name */
        int f7768p0;

        /* renamed from: q, reason: collision with root package name */
        public int f7769q;

        /* renamed from: q0, reason: collision with root package name */
        int f7770q0;

        /* renamed from: r, reason: collision with root package name */
        public float f7771r;

        /* renamed from: r0, reason: collision with root package name */
        float f7772r0;

        /* renamed from: s, reason: collision with root package name */
        public int f7773s;

        /* renamed from: s0, reason: collision with root package name */
        int f7774s0;

        /* renamed from: t, reason: collision with root package name */
        public int f7775t;

        /* renamed from: t0, reason: collision with root package name */
        int f7776t0;

        /* renamed from: u, reason: collision with root package name */
        public int f7777u;

        /* renamed from: u0, reason: collision with root package name */
        float f7778u0;

        /* renamed from: v, reason: collision with root package name */
        public int f7779v;

        /* renamed from: v0, reason: collision with root package name */
        ConstraintWidget f7780v0;

        /* renamed from: w, reason: collision with root package name */
        public int f7781w;

        /* renamed from: w0, reason: collision with root package name */
        public boolean f7782w0;

        /* renamed from: x, reason: collision with root package name */
        public int f7783x;

        /* renamed from: y, reason: collision with root package name */
        public int f7784y;

        /* renamed from: z, reason: collision with root package name */
        public int f7785z;

        /* loaded from: classes.dex */
        private static class a {

            /* renamed from: a, reason: collision with root package name */
            public static final SparseIntArray f7786a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f7786a = sparseIntArray;
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth, 64);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight, 65);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_toTopOf, 52);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBottomOf, 53);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_guidelineUseRtl, 67);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_android_orientation, 1);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginBaseline, 55);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_marginBaseline, 54);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintTag, 51);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_wrapBehaviorInParent, 66);
            }
        }

        public b(int i11, int i12) {
            super(i11, i12);
            this.f7737a = -1;
            this.f7739b = -1;
            this.f7741c = -1.0f;
            this.f7743d = true;
            this.f7745e = -1;
            this.f7747f = -1;
            this.f7749g = -1;
            this.f7751h = -1;
            this.f7753i = -1;
            this.f7755j = -1;
            this.f7757k = -1;
            this.f7759l = -1;
            this.f7761m = -1;
            this.f7763n = -1;
            this.f7765o = -1;
            this.f7767p = -1;
            this.f7769q = 0;
            this.f7771r = 0.0f;
            this.f7773s = -1;
            this.f7775t = -1;
            this.f7777u = -1;
            this.f7779v = -1;
            this.f7781w = Integer.MIN_VALUE;
            this.f7783x = Integer.MIN_VALUE;
            this.f7784y = Integer.MIN_VALUE;
            this.f7785z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.J = 0.0f;
            this.K = 1;
            this.L = -1.0f;
            this.M = -1.0f;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 1.0f;
            this.W = 1.0f;
            this.X = -1;
            this.Y = -1;
            this.Z = -1;
            this.f7738a0 = false;
            this.f7740b0 = false;
            this.f7742c0 = null;
            this.f7744d0 = 0;
            this.f7746e0 = true;
            this.f7748f0 = true;
            this.f7750g0 = false;
            this.f7752h0 = false;
            this.f7754i0 = false;
            this.f7756j0 = false;
            this.f7758k0 = false;
            this.f7760l0 = -1;
            this.f7762m0 = -1;
            this.f7764n0 = -1;
            this.f7766o0 = -1;
            this.f7768p0 = Integer.MIN_VALUE;
            this.f7770q0 = Integer.MIN_VALUE;
            this.f7772r0 = 0.5f;
            this.f7780v0 = new ConstraintWidget();
            this.f7782w0 = false;
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f7737a = -1;
            this.f7739b = -1;
            this.f7741c = -1.0f;
            this.f7743d = true;
            this.f7745e = -1;
            this.f7747f = -1;
            this.f7749g = -1;
            this.f7751h = -1;
            this.f7753i = -1;
            this.f7755j = -1;
            this.f7757k = -1;
            this.f7759l = -1;
            this.f7761m = -1;
            this.f7763n = -1;
            this.f7765o = -1;
            this.f7767p = -1;
            this.f7769q = 0;
            this.f7771r = 0.0f;
            this.f7773s = -1;
            this.f7775t = -1;
            this.f7777u = -1;
            this.f7779v = -1;
            this.f7781w = Integer.MIN_VALUE;
            this.f7783x = Integer.MIN_VALUE;
            this.f7784y = Integer.MIN_VALUE;
            this.f7785z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.J = 0.0f;
            this.K = 1;
            this.L = -1.0f;
            this.M = -1.0f;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 1.0f;
            this.W = 1.0f;
            this.X = -1;
            this.Y = -1;
            this.Z = -1;
            this.f7738a0 = false;
            this.f7740b0 = false;
            this.f7742c0 = null;
            this.f7744d0 = 0;
            this.f7746e0 = true;
            this.f7748f0 = true;
            this.f7750g0 = false;
            this.f7752h0 = false;
            this.f7754i0 = false;
            this.f7756j0 = false;
            this.f7758k0 = false;
            this.f7760l0 = -1;
            this.f7762m0 = -1;
            this.f7764n0 = -1;
            this.f7766o0 = -1;
            this.f7768p0 = Integer.MIN_VALUE;
            this.f7770q0 = Integer.MIN_VALUE;
            this.f7772r0 = 0.5f;
            this.f7780v0 = new ConstraintWidget();
            this.f7782w0 = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                int i12 = a.f7786a.get(index);
                switch (i12) {
                    case 1:
                        this.Z = obtainStyledAttributes.getInt(index, this.Z);
                        break;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.f7767p);
                        this.f7767p = resourceId;
                        if (resourceId == -1) {
                            this.f7767p = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.f7769q = obtainStyledAttributes.getDimensionPixelSize(index, this.f7769q);
                        break;
                    case 4:
                        float f11 = obtainStyledAttributes.getFloat(index, this.f7771r) % 360.0f;
                        this.f7771r = f11;
                        if (f11 < 0.0f) {
                            this.f7771r = (360.0f - f11) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.f7737a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f7737a);
                        break;
                    case 6:
                        this.f7739b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f7739b);
                        break;
                    case 7:
                        this.f7741c = obtainStyledAttributes.getFloat(index, this.f7741c);
                        break;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.f7745e);
                        this.f7745e = resourceId2;
                        if (resourceId2 == -1) {
                            this.f7745e = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.f7747f);
                        this.f7747f = resourceId3;
                        if (resourceId3 == -1) {
                            this.f7747f = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.f7749g);
                        this.f7749g = resourceId4;
                        if (resourceId4 == -1) {
                            this.f7749g = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.f7751h);
                        this.f7751h = resourceId5;
                        if (resourceId5 == -1) {
                            this.f7751h = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.f7753i);
                        this.f7753i = resourceId6;
                        if (resourceId6 == -1) {
                            this.f7753i = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.f7755j);
                        this.f7755j = resourceId7;
                        if (resourceId7 == -1) {
                            this.f7755j = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.f7757k);
                        this.f7757k = resourceId8;
                        if (resourceId8 == -1) {
                            this.f7757k = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.f7759l);
                        this.f7759l = resourceId9;
                        if (resourceId9 == -1) {
                            this.f7759l = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.f7761m);
                        this.f7761m = resourceId10;
                        if (resourceId10 == -1) {
                            this.f7761m = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.f7773s);
                        this.f7773s = resourceId11;
                        if (resourceId11 == -1) {
                            this.f7773s = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.f7775t);
                        this.f7775t = resourceId12;
                        if (resourceId12 == -1) {
                            this.f7775t = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.f7777u);
                        this.f7777u = resourceId13;
                        if (resourceId13 == -1) {
                            this.f7777u = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.f7779v);
                        this.f7779v = resourceId14;
                        if (resourceId14 == -1) {
                            this.f7779v = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.f7781w = obtainStyledAttributes.getDimensionPixelSize(index, this.f7781w);
                        break;
                    case 22:
                        this.f7783x = obtainStyledAttributes.getDimensionPixelSize(index, this.f7783x);
                        break;
                    case 23:
                        this.f7784y = obtainStyledAttributes.getDimensionPixelSize(index, this.f7784y);
                        break;
                    case 24:
                        this.f7785z = obtainStyledAttributes.getDimensionPixelSize(index, this.f7785z);
                        break;
                    case 25:
                        this.A = obtainStyledAttributes.getDimensionPixelSize(index, this.A);
                        break;
                    case 26:
                        this.B = obtainStyledAttributes.getDimensionPixelSize(index, this.B);
                        break;
                    case 27:
                        this.f7738a0 = obtainStyledAttributes.getBoolean(index, this.f7738a0);
                        break;
                    case 28:
                        this.f7740b0 = obtainStyledAttributes.getBoolean(index, this.f7740b0);
                        break;
                    case NOTIFICATION_REDIRECT_VALUE:
                        this.G = obtainStyledAttributes.getFloat(index, this.G);
                        break;
                    case 30:
                        this.H = obtainStyledAttributes.getFloat(index, this.H);
                        break;
                    case TEMPLATE_HTML_SIZE_VALUE:
                        int i13 = obtainStyledAttributes.getInt(index, 0);
                        this.P = i13;
                        if (i13 == 1) {
                            Log.e(ConstraintLayout.TAG, "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        int i14 = obtainStyledAttributes.getInt(index, 0);
                        this.Q = i14;
                        if (i14 == 1) {
                            Log.e(ConstraintLayout.TAG, "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 33:
                        try {
                            this.R = obtainStyledAttributes.getDimensionPixelSize(index, this.R);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.R) == -2) {
                                this.R = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.T = obtainStyledAttributes.getDimensionPixelSize(index, this.T);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.T) == -2) {
                                this.T = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.V = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.V));
                        this.P = 2;
                        break;
                    case 36:
                        try {
                            this.S = obtainStyledAttributes.getDimensionPixelSize(index, this.S);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.S) == -2) {
                                this.S = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.U = obtainStyledAttributes.getDimensionPixelSize(index, this.U);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.U) == -2) {
                                this.U = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.W = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.W));
                        this.Q = 2;
                        break;
                    default:
                        switch (i12) {
                            case 44:
                                androidx.constraintlayout.widget.b.M(this, obtainStyledAttributes.getString(index));
                                break;
                            case 45:
                                this.L = obtainStyledAttributes.getFloat(index, this.L);
                                break;
                            case 46:
                                this.M = obtainStyledAttributes.getFloat(index, this.M);
                                break;
                            case 47:
                                this.N = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE:
                                this.O = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                                this.X = obtainStyledAttributes.getDimensionPixelOffset(index, this.X);
                                break;
                            case 50:
                                this.Y = obtainStyledAttributes.getDimensionPixelOffset(index, this.Y);
                                break;
                            case AD_REWARD_USER_VALUE:
                                this.f7742c0 = obtainStyledAttributes.getString(index);
                                break;
                            case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
                                int resourceId15 = obtainStyledAttributes.getResourceId(index, this.f7763n);
                                this.f7763n = resourceId15;
                                if (resourceId15 == -1) {
                                    this.f7763n = obtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    break;
                                }
                            case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
                                int resourceId16 = obtainStyledAttributes.getResourceId(index, this.f7765o);
                                this.f7765o = resourceId16;
                                if (resourceId16 == -1) {
                                    this.f7765o = obtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    break;
                                }
                            case AD_BACKGROUND_BEFORE_IMPRESSION_VALUE:
                                this.D = obtainStyledAttributes.getDimensionPixelSize(index, this.D);
                                break;
                            case AD_CLOSED_BEFORE_IMPRESSION_VALUE:
                                this.C = obtainStyledAttributes.getDimensionPixelSize(index, this.C);
                                break;
                            default:
                                switch (i12) {
                                    case 64:
                                        androidx.constraintlayout.widget.b.K(this, obtainStyledAttributes, index, 0);
                                        this.E = true;
                                        break;
                                    case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                                        androidx.constraintlayout.widget.b.K(this, obtainStyledAttributes, index, 1);
                                        this.F = true;
                                        break;
                                    case 66:
                                        this.f7744d0 = obtainStyledAttributes.getInt(index, this.f7744d0);
                                        break;
                                    case 67:
                                        this.f7743d = obtainStyledAttributes.getBoolean(index, this.f7743d);
                                        break;
                                }
                        }
                }
            }
            obtainStyledAttributes.recycle();
            c();
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f7737a = -1;
            this.f7739b = -1;
            this.f7741c = -1.0f;
            this.f7743d = true;
            this.f7745e = -1;
            this.f7747f = -1;
            this.f7749g = -1;
            this.f7751h = -1;
            this.f7753i = -1;
            this.f7755j = -1;
            this.f7757k = -1;
            this.f7759l = -1;
            this.f7761m = -1;
            this.f7763n = -1;
            this.f7765o = -1;
            this.f7767p = -1;
            this.f7769q = 0;
            this.f7771r = 0.0f;
            this.f7773s = -1;
            this.f7775t = -1;
            this.f7777u = -1;
            this.f7779v = -1;
            this.f7781w = Integer.MIN_VALUE;
            this.f7783x = Integer.MIN_VALUE;
            this.f7784y = Integer.MIN_VALUE;
            this.f7785z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.J = 0.0f;
            this.K = 1;
            this.L = -1.0f;
            this.M = -1.0f;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 1.0f;
            this.W = 1.0f;
            this.X = -1;
            this.Y = -1;
            this.Z = -1;
            this.f7738a0 = false;
            this.f7740b0 = false;
            this.f7742c0 = null;
            this.f7744d0 = 0;
            this.f7746e0 = true;
            this.f7748f0 = true;
            this.f7750g0 = false;
            this.f7752h0 = false;
            this.f7754i0 = false;
            this.f7756j0 = false;
            this.f7758k0 = false;
            this.f7760l0 = -1;
            this.f7762m0 = -1;
            this.f7764n0 = -1;
            this.f7766o0 = -1;
            this.f7768p0 = Integer.MIN_VALUE;
            this.f7770q0 = Integer.MIN_VALUE;
            this.f7772r0 = 0.5f;
            this.f7780v0 = new ConstraintWidget();
            this.f7782w0 = false;
        }

        public String a() {
            return this.f7742c0;
        }

        public ConstraintWidget b() {
            return this.f7780v0;
        }

        public void c() {
            this.f7752h0 = false;
            this.f7746e0 = true;
            this.f7748f0 = true;
            int i11 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i11 == -2 && this.f7738a0) {
                this.f7746e0 = false;
                if (this.P == 0) {
                    this.P = 1;
                }
            }
            int i12 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i12 == -2 && this.f7740b0) {
                this.f7748f0 = false;
                if (this.Q == 0) {
                    this.Q = 1;
                }
            }
            if (i11 == 0 || i11 == -1) {
                this.f7746e0 = false;
                if (i11 == 0 && this.P == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.f7738a0 = true;
                }
            }
            if (i12 == 0 || i12 == -1) {
                this.f7748f0 = false;
                if (i12 == 0 && this.Q == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.f7740b0 = true;
                }
            }
            if (this.f7741c == -1.0f && this.f7737a == -1 && this.f7739b == -1) {
                return;
            }
            this.f7752h0 = true;
            this.f7746e0 = true;
            this.f7748f0 = true;
            if (!(this.f7780v0 instanceof f)) {
                this.f7780v0 = new f();
            }
            ((f) this.f7780v0).E1(this.Z);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0051  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x005e  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0082  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void resolveLayoutDirection(int r11) {
            /*
                Method dump skipped, instructions count: 259
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.b.resolveLayoutDirection(int):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements b.InterfaceC0060b {

        /* renamed from: a, reason: collision with root package name */
        ConstraintLayout f7787a;

        /* renamed from: b, reason: collision with root package name */
        int f7788b;

        /* renamed from: c, reason: collision with root package name */
        int f7789c;

        /* renamed from: d, reason: collision with root package name */
        int f7790d;

        /* renamed from: e, reason: collision with root package name */
        int f7791e;

        /* renamed from: f, reason: collision with root package name */
        int f7792f;

        /* renamed from: g, reason: collision with root package name */
        int f7793g;

        public c(ConstraintLayout constraintLayout) {
            this.f7787a = constraintLayout;
        }

        private boolean d(int i11, int i12, int i13) {
            if (i11 == i12) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i11);
            View.MeasureSpec.getSize(i11);
            int mode2 = View.MeasureSpec.getMode(i12);
            int size = View.MeasureSpec.getSize(i12);
            if (mode2 == 1073741824) {
                return (mode == Integer.MIN_VALUE || mode == 0) && i13 == size;
            }
            return false;
        }

        @Override // androidx.constraintlayout.core.widgets.analyzer.b.InterfaceC0060b
        public final void a() {
            int childCount = this.f7787a.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = this.f7787a.getChildAt(i11);
                if (childAt instanceof Placeholder) {
                    ((Placeholder) childAt).updatePostMeasure(this.f7787a);
                }
            }
            int size = this.f7787a.mConstraintHelpers.size();
            if (size > 0) {
                for (int i12 = 0; i12 < size; i12++) {
                    ((ConstraintHelper) this.f7787a.mConstraintHelpers.get(i12)).updatePostMeasure(this.f7787a);
                }
            }
        }

        @Override // androidx.constraintlayout.core.widgets.analyzer.b.InterfaceC0060b
        public final void b(ConstraintWidget constraintWidget, b.a aVar) {
            int makeMeasureSpec;
            int makeMeasureSpec2;
            int baseline;
            int max;
            int i11;
            int i12;
            int i13;
            if (constraintWidget == null) {
                return;
            }
            if (constraintWidget.X() == 8 && !constraintWidget.l0()) {
                aVar.f7019e = 0;
                aVar.f7020f = 0;
                aVar.f7021g = 0;
                return;
            }
            if (constraintWidget.M() == null) {
                return;
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = aVar.f7015a;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = aVar.f7016b;
            int i14 = aVar.f7017c;
            int i15 = aVar.f7018d;
            int i16 = this.f7788b + this.f7789c;
            int i17 = this.f7790d;
            View view = (View) constraintWidget.u();
            int[] iArr = a.f7736a;
            int i18 = iArr[dimensionBehaviour.ordinal()];
            if (i18 == 1) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i14, 1073741824);
            } else if (i18 == 2) {
                makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f7792f, i17, -2);
            } else if (i18 == 3) {
                makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f7792f, i17 + constraintWidget.D(), -1);
            } else if (i18 != 4) {
                makeMeasureSpec = 0;
            } else {
                makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f7792f, i17, -2);
                boolean z10 = constraintWidget.f6975w == 1;
                int i19 = aVar.f7024j;
                if (i19 == b.a.f7013l || i19 == b.a.f7014m) {
                    boolean z11 = view.getMeasuredHeight() == constraintWidget.z();
                    if (aVar.f7024j == b.a.f7014m || !z10 || ((z10 && z11) || (view instanceof Placeholder) || constraintWidget.p0())) {
                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(constraintWidget.Y(), 1073741824);
                    }
                }
            }
            int i20 = iArr[dimensionBehaviour2.ordinal()];
            if (i20 == 1) {
                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i15, 1073741824);
            } else if (i20 == 2) {
                makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f7793g, i16, -2);
            } else if (i20 == 3) {
                makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f7793g, i16 + constraintWidget.W(), -1);
            } else if (i20 != 4) {
                makeMeasureSpec2 = 0;
            } else {
                makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f7793g, i16, -2);
                boolean z12 = constraintWidget.f6977x == 1;
                int i21 = aVar.f7024j;
                if (i21 == b.a.f7013l || i21 == b.a.f7014m) {
                    boolean z13 = view.getMeasuredWidth() == constraintWidget.Y();
                    if (aVar.f7024j == b.a.f7014m || !z12 || ((z12 && z13) || (view instanceof Placeholder) || constraintWidget.q0())) {
                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(constraintWidget.z(), 1073741824);
                    }
                }
            }
            androidx.constraintlayout.core.widgets.d dVar = (androidx.constraintlayout.core.widgets.d) constraintWidget.M();
            if (dVar != null && g.b(ConstraintLayout.this.mOptimizationLevel, 256) && view.getMeasuredWidth() == constraintWidget.Y() && view.getMeasuredWidth() < dVar.Y() && view.getMeasuredHeight() == constraintWidget.z() && view.getMeasuredHeight() < dVar.z() && view.getBaseline() == constraintWidget.r() && !constraintWidget.o0() && d(constraintWidget.E(), makeMeasureSpec, constraintWidget.Y()) && d(constraintWidget.F(), makeMeasureSpec2, constraintWidget.z())) {
                aVar.f7019e = constraintWidget.Y();
                aVar.f7020f = constraintWidget.z();
                aVar.f7021g = constraintWidget.r();
                return;
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            boolean z14 = dimensionBehaviour == dimensionBehaviour3;
            boolean z15 = dimensionBehaviour2 == dimensionBehaviour3;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            boolean z16 = dimensionBehaviour2 == dimensionBehaviour4 || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.FIXED;
            boolean z17 = dimensionBehaviour == dimensionBehaviour4 || dimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED;
            boolean z18 = z14 && constraintWidget.f6942f0 > 0.0f;
            boolean z19 = z15 && constraintWidget.f6942f0 > 0.0f;
            if (view == null) {
                return;
            }
            b bVar = (b) view.getLayoutParams();
            int i22 = aVar.f7024j;
            if (i22 != b.a.f7013l && i22 != b.a.f7014m && z14 && constraintWidget.f6975w == 0 && z15 && constraintWidget.f6977x == 0) {
                i13 = -1;
                i12 = 0;
                baseline = 0;
                max = 0;
            } else {
                if ((view instanceof VirtualLayout) && (constraintWidget instanceof i)) {
                    ((VirtualLayout) view).onMeasure((i) constraintWidget, makeMeasureSpec, makeMeasureSpec2);
                } else {
                    view.measure(makeMeasureSpec, makeMeasureSpec2);
                }
                constraintWidget.Z0(makeMeasureSpec, makeMeasureSpec2);
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                baseline = view.getBaseline();
                int i23 = constraintWidget.f6981z;
                max = i23 > 0 ? Math.max(i23, measuredWidth) : measuredWidth;
                int i24 = constraintWidget.A;
                if (i24 > 0) {
                    max = Math.min(i24, max);
                }
                int i25 = constraintWidget.C;
                if (i25 > 0) {
                    i12 = Math.max(i25, measuredHeight);
                    i11 = makeMeasureSpec;
                } else {
                    i11 = makeMeasureSpec;
                    i12 = measuredHeight;
                }
                int i26 = constraintWidget.D;
                if (i26 > 0) {
                    i12 = Math.min(i26, i12);
                }
                if (!g.b(ConstraintLayout.this.mOptimizationLevel, 1)) {
                    if (z18 && z16) {
                        max = (int) ((i12 * constraintWidget.f6942f0) + 0.5f);
                    } else if (z19 && z17) {
                        i12 = (int) ((max / constraintWidget.f6942f0) + 0.5f);
                    }
                }
                if (measuredWidth != max || measuredHeight != i12) {
                    int makeMeasureSpec3 = measuredWidth != max ? View.MeasureSpec.makeMeasureSpec(max, 1073741824) : i11;
                    if (measuredHeight != i12) {
                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
                    }
                    view.measure(makeMeasureSpec3, makeMeasureSpec2);
                    constraintWidget.Z0(makeMeasureSpec3, makeMeasureSpec2);
                    max = view.getMeasuredWidth();
                    i12 = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                }
                i13 = -1;
            }
            boolean z20 = baseline != i13;
            aVar.f7023i = (max == aVar.f7017c && i12 == aVar.f7018d) ? false : true;
            if (bVar.f7750g0) {
                z20 = true;
            }
            if (z20 && baseline != -1 && constraintWidget.r() != baseline) {
                aVar.f7023i = true;
            }
            aVar.f7019e = max;
            aVar.f7020f = i12;
            aVar.f7022h = z20;
            aVar.f7021g = baseline;
        }

        public void c(int i11, int i12, int i13, int i14, int i15, int i16) {
            this.f7788b = i13;
            this.f7789c = i14;
            this.f7790d = i15;
            this.f7791e = i16;
            this.f7792f = i11;
            this.f7793g = i12;
        }
    }

    public ConstraintLayout(@NonNull Context context) {
        super(context);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new androidx.constraintlayout.core.widgets.d();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = InputDeviceCompat.SOURCE_KEYBOARD;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new c(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        b(null, 0, 0);
    }

    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new androidx.constraintlayout.core.widgets.d();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = InputDeviceCompat.SOURCE_KEYBOARD;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new c(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        b(attributeSet, 0, 0);
    }

    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new androidx.constraintlayout.core.widgets.d();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = InputDeviceCompat.SOURCE_KEYBOARD;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new c(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        b(attributeSet, i11, 0);
    }

    @TargetApi(21)
    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new androidx.constraintlayout.core.widgets.d();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = InputDeviceCompat.SOURCE_KEYBOARD;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new c(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        b(attributeSet, i11, i12);
    }

    private final ConstraintWidget a(int i11) {
        if (i11 == 0) {
            return this.mLayoutWidget;
        }
        View view = this.mChildrenByIds.get(i11);
        if (view == null && (view = findViewById(i11)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        return ((b) view.getLayoutParams()).f7780v0;
    }

    private void b(AttributeSet attributeSet, int i11, int i12) {
        this.mLayoutWidget.F0(this);
        this.mLayoutWidget.a2(this.mMeasurer);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout, i11, i12);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i13 = 0; i13 < indexCount; i13++) {
                int index = obtainStyledAttributes.getIndex(i13);
                if (index == R$styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.mMinWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.mMinHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.mMaxWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == R$styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.mOptimizationLevel = obtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                } else if (index == R$styleable.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            parseLayoutDescription(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.mConstraintLayoutSpec = null;
                        }
                    }
                } else if (index == R$styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        androidx.constraintlayout.widget.b bVar = new androidx.constraintlayout.widget.b();
                        this.mConstraintSet = bVar;
                        bVar.H(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.mLayoutWidget.b2(this.mOptimizationLevel);
    }

    private void c() {
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }

    private void e() {
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            ConstraintWidget viewWidget = getViewWidget(getChildAt(i11));
            if (viewWidget != null) {
                viewWidget.v0();
            }
        }
        if (isInEditMode) {
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    setDesignInformation(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    a(childAt.getId()).G0(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.mConstraintSetId != -1) {
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt2 = getChildAt(i13);
                if (childAt2.getId() == this.mConstraintSetId && (childAt2 instanceof Constraints)) {
                    this.mConstraintSet = ((Constraints) childAt2).getConstraintSet();
                }
            }
        }
        androidx.constraintlayout.widget.b bVar = this.mConstraintSet;
        if (bVar != null) {
            bVar.k(this, true);
        }
        this.mLayoutWidget.y1();
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i14 = 0; i14 < size; i14++) {
                this.mConstraintHelpers.get(i14).updatePreLayout(this);
            }
        }
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt3 = getChildAt(i15);
            if (childAt3 instanceof Placeholder) {
                ((Placeholder) childAt3).updatePreLayout(this);
            }
        }
        this.mTempMapIdToWidget.clear();
        this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
        this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt4 = getChildAt(i16);
            this.mTempMapIdToWidget.put(childAt4.getId(), getViewWidget(childAt4));
        }
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt5 = getChildAt(i17);
            ConstraintWidget viewWidget2 = getViewWidget(childAt5);
            if (viewWidget2 != null) {
                b bVar2 = (b) childAt5.getLayoutParams();
                this.mLayoutWidget.a(viewWidget2);
                applyConstraintsFromLayoutParams(isInEditMode, childAt5, viewWidget2, bVar2, this.mTempMapIdToWidget);
            }
        }
    }

    private void f(ConstraintWidget constraintWidget, b bVar, SparseArray sparseArray, int i11, ConstraintAnchor.Type type) {
        View view = this.mChildrenByIds.get(i11);
        ConstraintWidget constraintWidget2 = (ConstraintWidget) sparseArray.get(i11);
        if (constraintWidget2 == null || view == null || !(view.getLayoutParams() instanceof b)) {
            return;
        }
        bVar.f7750g0 = true;
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.BASELINE;
        if (type == type2) {
            b bVar2 = (b) view.getLayoutParams();
            bVar2.f7750g0 = true;
            bVar2.f7780v0.O0(true);
        }
        constraintWidget.q(type2).b(constraintWidget2.q(type), bVar.D, bVar.C, true);
        constraintWidget.O0(true);
        constraintWidget.q(ConstraintAnchor.Type.TOP).q();
        constraintWidget.q(ConstraintAnchor.Type.BOTTOM).q();
    }

    private boolean g() {
        int childCount = getChildCount();
        boolean z10 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= childCount) {
                break;
            }
            if (getChildAt(i11).isLayoutRequested()) {
                z10 = true;
                break;
            }
            i11++;
        }
        if (z10) {
            e();
        }
        return z10;
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int max2 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        return max2 > 0 ? max2 : max;
    }

    public static d getSharedValues() {
        if (sSharedValues == null) {
            sSharedValues = new d();
        }
        return sSharedValues;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyConstraintsFromLayoutParams(boolean z10, View view, ConstraintWidget constraintWidget, b bVar, SparseArray<ConstraintWidget> sparseArray) {
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5;
        int i11;
        bVar.c();
        bVar.f7782w0 = false;
        constraintWidget.n1(view.getVisibility());
        if (bVar.f7756j0) {
            constraintWidget.X0(true);
            constraintWidget.n1(8);
        }
        constraintWidget.F0(view);
        if (view instanceof ConstraintHelper) {
            ((ConstraintHelper) view).resolveRtl(constraintWidget, this.mLayoutWidget.U1());
        }
        if (bVar.f7752h0) {
            f fVar = (f) constraintWidget;
            int i12 = bVar.f7774s0;
            int i13 = bVar.f7776t0;
            float f11 = bVar.f7778u0;
            if (f11 != -1.0f) {
                fVar.D1(f11);
                return;
            } else if (i12 != -1) {
                fVar.B1(i12);
                return;
            } else {
                if (i13 != -1) {
                    fVar.C1(i13);
                    return;
                }
                return;
            }
        }
        int i14 = bVar.f7760l0;
        int i15 = bVar.f7762m0;
        int i16 = bVar.f7764n0;
        int i17 = bVar.f7766o0;
        int i18 = bVar.f7768p0;
        int i19 = bVar.f7770q0;
        float f12 = bVar.f7772r0;
        int i20 = bVar.f7767p;
        if (i20 != -1) {
            ConstraintWidget constraintWidget6 = sparseArray.get(i20);
            if (constraintWidget6 != null) {
                constraintWidget.m(constraintWidget6, bVar.f7771r, bVar.f7769q);
            }
        } else {
            if (i14 != -1) {
                ConstraintWidget constraintWidget7 = sparseArray.get(i14);
                if (constraintWidget7 != null) {
                    ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
                    constraintWidget.g0(type, constraintWidget7, type, ((ViewGroup.MarginLayoutParams) bVar).leftMargin, i18);
                }
            } else if (i15 != -1 && (constraintWidget2 = sparseArray.get(i15)) != null) {
                constraintWidget.g0(ConstraintAnchor.Type.LEFT, constraintWidget2, ConstraintAnchor.Type.RIGHT, ((ViewGroup.MarginLayoutParams) bVar).leftMargin, i18);
            }
            if (i16 != -1) {
                ConstraintWidget constraintWidget8 = sparseArray.get(i16);
                if (constraintWidget8 != null) {
                    constraintWidget.g0(ConstraintAnchor.Type.RIGHT, constraintWidget8, ConstraintAnchor.Type.LEFT, ((ViewGroup.MarginLayoutParams) bVar).rightMargin, i19);
                }
            } else if (i17 != -1 && (constraintWidget3 = sparseArray.get(i17)) != null) {
                ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
                constraintWidget.g0(type2, constraintWidget3, type2, ((ViewGroup.MarginLayoutParams) bVar).rightMargin, i19);
            }
            int i21 = bVar.f7753i;
            if (i21 != -1) {
                ConstraintWidget constraintWidget9 = sparseArray.get(i21);
                if (constraintWidget9 != null) {
                    ConstraintAnchor.Type type3 = ConstraintAnchor.Type.TOP;
                    constraintWidget.g0(type3, constraintWidget9, type3, ((ViewGroup.MarginLayoutParams) bVar).topMargin, bVar.f7783x);
                }
            } else {
                int i22 = bVar.f7755j;
                if (i22 != -1 && (constraintWidget4 = sparseArray.get(i22)) != null) {
                    constraintWidget.g0(ConstraintAnchor.Type.TOP, constraintWidget4, ConstraintAnchor.Type.BOTTOM, ((ViewGroup.MarginLayoutParams) bVar).topMargin, bVar.f7783x);
                }
            }
            int i23 = bVar.f7757k;
            if (i23 != -1) {
                ConstraintWidget constraintWidget10 = sparseArray.get(i23);
                if (constraintWidget10 != null) {
                    constraintWidget.g0(ConstraintAnchor.Type.BOTTOM, constraintWidget10, ConstraintAnchor.Type.TOP, ((ViewGroup.MarginLayoutParams) bVar).bottomMargin, bVar.f7785z);
                }
            } else {
                int i24 = bVar.f7759l;
                if (i24 != -1 && (constraintWidget5 = sparseArray.get(i24)) != null) {
                    ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
                    constraintWidget.g0(type4, constraintWidget5, type4, ((ViewGroup.MarginLayoutParams) bVar).bottomMargin, bVar.f7785z);
                }
            }
            int i25 = bVar.f7761m;
            if (i25 != -1) {
                f(constraintWidget, bVar, sparseArray, i25, ConstraintAnchor.Type.BASELINE);
            } else {
                int i26 = bVar.f7763n;
                if (i26 != -1) {
                    f(constraintWidget, bVar, sparseArray, i26, ConstraintAnchor.Type.TOP);
                } else {
                    int i27 = bVar.f7765o;
                    if (i27 != -1) {
                        f(constraintWidget, bVar, sparseArray, i27, ConstraintAnchor.Type.BOTTOM);
                    }
                }
            }
            if (f12 >= 0.0f) {
                constraintWidget.Q0(f12);
            }
            float f13 = bVar.H;
            if (f13 >= 0.0f) {
                constraintWidget.h1(f13);
            }
        }
        if (z10 && ((i11 = bVar.X) != -1 || bVar.Y != -1)) {
            constraintWidget.f1(i11, bVar.Y);
        }
        if (bVar.f7746e0) {
            constraintWidget.T0(ConstraintWidget.DimensionBehaviour.FIXED);
            constraintWidget.o1(((ViewGroup.MarginLayoutParams) bVar).width);
            if (((ViewGroup.MarginLayoutParams) bVar).width == -2) {
                constraintWidget.T0(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            }
        } else if (((ViewGroup.MarginLayoutParams) bVar).width == -1) {
            if (bVar.f7738a0) {
                constraintWidget.T0(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
            } else {
                constraintWidget.T0(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
            }
            constraintWidget.q(ConstraintAnchor.Type.LEFT).f6927g = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
            constraintWidget.q(ConstraintAnchor.Type.RIGHT).f6927g = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        } else {
            constraintWidget.T0(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
            constraintWidget.o1(0);
        }
        if (bVar.f7748f0) {
            constraintWidget.k1(ConstraintWidget.DimensionBehaviour.FIXED);
            constraintWidget.P0(((ViewGroup.MarginLayoutParams) bVar).height);
            if (((ViewGroup.MarginLayoutParams) bVar).height == -2) {
                constraintWidget.k1(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            }
        } else if (((ViewGroup.MarginLayoutParams) bVar).height == -1) {
            if (bVar.f7740b0) {
                constraintWidget.k1(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
            } else {
                constraintWidget.k1(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
            }
            constraintWidget.q(ConstraintAnchor.Type.TOP).f6927g = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
            constraintWidget.q(ConstraintAnchor.Type.BOTTOM).f6927g = ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        } else {
            constraintWidget.k1(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
            constraintWidget.P0(0);
        }
        constraintWidget.H0(bVar.I);
        constraintWidget.V0(bVar.L);
        constraintWidget.m1(bVar.M);
        constraintWidget.R0(bVar.N);
        constraintWidget.i1(bVar.O);
        constraintWidget.p1(bVar.f7744d0);
        constraintWidget.U0(bVar.P, bVar.R, bVar.T, bVar.V);
        constraintWidget.l1(bVar.Q, bVar.S, bVar.U, bVar.W);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<ConstraintHelper> arrayList = this.mConstraintHelpers;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i11 = 0; i11 < size; i11++) {
                this.mConstraintHelpers.get(i11).updatePreDraw(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i13 = (int) ((parseInt / 1080.0f) * width);
                        int i14 = (int) ((parseInt2 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(FlowLayout.SPACING_AUTO);
                        float f11 = i13;
                        float f12 = i14;
                        float f13 = i13 + ((int) ((parseInt3 / 1080.0f) * width));
                        canvas.drawLine(f11, f12, f13, f12, paint);
                        float parseInt4 = i14 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                        canvas.drawLine(f13, f12, f13, parseInt4, paint);
                        canvas.drawLine(f13, parseInt4, f11, parseInt4, paint);
                        canvas.drawLine(f11, parseInt4, f11, f12, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f11, f12, f13, parseInt4, paint);
                        canvas.drawLine(f11, parseInt4, f13, f12, paint);
                    }
                }
            }
        }
    }

    public void fillMetrics(androidx.constraintlayout.core.e eVar) {
        this.mMetrics = eVar;
        this.mLayoutWidget.M1(eVar);
    }

    @Override // android.view.View
    public void forceLayout() {
        c();
        super.forceLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public b generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    @Override // android.view.ViewGroup
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    public Object getDesignInformation(int i11, Object obj) {
        if (i11 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> hashMap = this.mDesignIds;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.mDesignIds.get(str);
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.O1();
    }

    public String getSceneString() {
        int id2;
        StringBuilder sb2 = new StringBuilder();
        if (this.mLayoutWidget.f6959o == null) {
            int id3 = getId();
            if (id3 != -1) {
                this.mLayoutWidget.f6959o = getContext().getResources().getResourceEntryName(id3);
            } else {
                this.mLayoutWidget.f6959o = "parent";
            }
        }
        if (this.mLayoutWidget.v() == null) {
            androidx.constraintlayout.core.widgets.d dVar = this.mLayoutWidget;
            dVar.G0(dVar.f6959o);
            Log.v(TAG, " setDebugName " + this.mLayoutWidget.v());
        }
        Iterator it = this.mLayoutWidget.v1().iterator();
        while (it.hasNext()) {
            ConstraintWidget constraintWidget = (ConstraintWidget) it.next();
            View view = (View) constraintWidget.u();
            if (view != null) {
                if (constraintWidget.f6959o == null && (id2 = view.getId()) != -1) {
                    constraintWidget.f6959o = getContext().getResources().getResourceEntryName(id2);
                }
                if (constraintWidget.v() == null) {
                    constraintWidget.G0(constraintWidget.f6959o);
                    Log.v(TAG, " setDebugName " + constraintWidget.v());
                }
            }
        }
        this.mLayoutWidget.Q(sb2);
        return sb2.toString();
    }

    public View getViewById(int i11) {
        return this.mChildrenByIds.get(i11);
    }

    public final ConstraintWidget getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof b) {
            return ((b) view.getLayoutParams()).f7780v0;
        }
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof b) {
            return ((b) view.getLayoutParams()).f7780v0;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isRtl() {
        return (getContext().getApplicationInfo().flags & 4194304) != 0 && 1 == getLayoutDirection();
    }

    public void loadLayoutDescription(int i11) {
        if (i11 == 0) {
            this.mConstraintLayoutSpec = null;
            return;
        }
        try {
            this.mConstraintLayoutSpec = new androidx.constraintlayout.widget.a(getContext(), this, i11);
        } catch (Resources.NotFoundException unused) {
            this.mConstraintLayoutSpec = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            b bVar = (b) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = bVar.f7780v0;
            if ((childAt.getVisibility() != 8 || bVar.f7752h0 || bVar.f7754i0 || bVar.f7758k0 || isInEditMode) && !bVar.f7756j0) {
                int Z = constraintWidget.Z();
                int a02 = constraintWidget.a0();
                int Y = constraintWidget.Y() + Z;
                int z11 = constraintWidget.z() + a02;
                childAt.layout(Z, a02, Y, z11);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(Z, a02, Y, z11);
                }
            }
        }
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i16 = 0; i16 < size; i16++) {
                this.mConstraintHelpers.get(i16).updatePostLayout(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        if (this.mOnMeasureWidthMeasureSpec == i11) {
            int i13 = this.mOnMeasureHeightMeasureSpec;
        }
        if (!this.mDirtyHierarchy) {
            int childCount = getChildCount();
            int i14 = 0;
            while (true) {
                if (i14 >= childCount) {
                    break;
                }
                if (getChildAt(i14).isLayoutRequested()) {
                    this.mDirtyHierarchy = true;
                    break;
                }
                i14++;
            }
        }
        this.mOnMeasureWidthMeasureSpec = i11;
        this.mOnMeasureHeightMeasureSpec = i12;
        this.mLayoutWidget.d2(isRtl());
        if (this.mDirtyHierarchy) {
            this.mDirtyHierarchy = false;
            if (g()) {
                this.mLayoutWidget.f2();
            }
        }
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, i11, i12);
        resolveMeasuredDimension(i11, i12, this.mLayoutWidget.Y(), this.mLayoutWidget.z(), this.mLayoutWidget.V1(), this.mLayoutWidget.T1());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        ConstraintWidget viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof f)) {
            b bVar = (b) view.getLayoutParams();
            f fVar = new f();
            bVar.f7780v0 = fVar;
            bVar.f7752h0 = true;
            fVar.E1(bVar.Z);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.validateParams();
            ((b) view.getLayoutParams()).f7754i0 = true;
            if (!this.mConstraintHelpers.contains(constraintHelper)) {
                this.mConstraintHelpers.add(constraintHelper);
            }
        }
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.mChildrenByIds.remove(view.getId());
        this.mLayoutWidget.x1(getViewWidget(view));
        this.mConstraintHelpers.remove(view);
        this.mDirtyHierarchy = true;
    }

    protected void parseLayoutDescription(int i11) {
        this.mConstraintLayoutSpec = new androidx.constraintlayout.widget.a(getContext(), this, i11);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        c();
        super.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resolveMeasuredDimension(int i11, int i12, int i13, int i14, boolean z10, boolean z11) {
        c cVar = this.mMeasurer;
        int i15 = cVar.f7791e;
        int resolveSizeAndState = View.resolveSizeAndState(i13 + cVar.f7790d, i11, 0);
        int resolveSizeAndState2 = View.resolveSizeAndState(i14 + i15, i12, 0) & 16777215;
        int min = Math.min(this.mMaxWidth, resolveSizeAndState & 16777215);
        int min2 = Math.min(this.mMaxHeight, resolveSizeAndState2);
        if (z10) {
            min |= 16777216;
        }
        if (z11) {
            min2 |= 16777216;
        }
        setMeasuredDimension(min, min2);
        this.mLastMeasureWidth = min;
        this.mLastMeasureHeight = min2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resolveSystem(androidx.constraintlayout.core.widgets.d dVar, int i11, int i12, int i13) {
        int mode = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i12);
        int mode2 = View.MeasureSpec.getMode(i13);
        int size2 = View.MeasureSpec.getSize(i13);
        int max = Math.max(0, getPaddingTop());
        int max2 = Math.max(0, getPaddingBottom());
        int i14 = max + max2;
        int paddingWidth = getPaddingWidth();
        this.mMeasurer.c(i12, i13, max, max2, paddingWidth, i14);
        int max3 = Math.max(0, getPaddingStart());
        int max4 = Math.max(0, getPaddingEnd());
        int max5 = (max3 > 0 || max4 > 0) ? isRtl() ? max4 : max3 : Math.max(0, getPaddingLeft());
        int i15 = size - paddingWidth;
        int i16 = size2 - i14;
        setSelfDimensionBehaviour(dVar, mode, i15, mode2, i16);
        dVar.W1(i11, mode, i15, mode2, i16, this.mLastMeasureWidth, this.mLastMeasureHeight, max5, max);
    }

    public void setConstraintSet(androidx.constraintlayout.widget.b bVar) {
        this.mConstraintSet = bVar;
    }

    public void setDesignInformation(int i11, Object obj, Object obj2) {
        if (i11 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.mDesignIds == null) {
                this.mDesignIds = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            Integer num = (Integer) obj2;
            num.intValue();
            this.mDesignIds.put(str, num);
        }
    }

    @Override // android.view.View
    public void setId(int i11) {
        this.mChildrenByIds.remove(getId());
        super.setId(i11);
        this.mChildrenByIds.put(getId(), this);
    }

    public void setMaxHeight(int i11) {
        if (i11 == this.mMaxHeight) {
            return;
        }
        this.mMaxHeight = i11;
        requestLayout();
    }

    public void setMaxWidth(int i11) {
        if (i11 == this.mMaxWidth) {
            return;
        }
        this.mMaxWidth = i11;
        requestLayout();
    }

    public void setMinHeight(int i11) {
        if (i11 == this.mMinHeight) {
            return;
        }
        this.mMinHeight = i11;
        requestLayout();
    }

    public void setMinWidth(int i11) {
        if (i11 == this.mMinWidth) {
            return;
        }
        this.mMinWidth = i11;
        requestLayout();
    }

    public void setOnConstraintsChanged(androidx.constraintlayout.widget.c cVar) {
        this.mConstraintsChangedListener = cVar;
        androidx.constraintlayout.widget.a aVar = this.mConstraintLayoutSpec;
        if (aVar != null) {
            aVar.c(cVar);
        }
    }

    public void setOptimizationLevel(int i11) {
        this.mOptimizationLevel = i11;
        this.mLayoutWidget.b2(i11);
    }

    protected void setSelfDimensionBehaviour(androidx.constraintlayout.core.widgets.d dVar, int i11, int i12, int i13, int i14) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        c cVar = this.mMeasurer;
        int i15 = cVar.f7791e;
        int i16 = cVar.f7790d;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
        int childCount = getChildCount();
        if (i11 == Integer.MIN_VALUE) {
            dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                i12 = Math.max(0, this.mMinWidth);
            }
        } else if (i11 == 0) {
            dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                i12 = Math.max(0, this.mMinWidth);
            }
            i12 = 0;
        } else if (i11 != 1073741824) {
            dimensionBehaviour = dimensionBehaviour2;
            i12 = 0;
        } else {
            i12 = Math.min(this.mMaxWidth - i16, i12);
            dimensionBehaviour = dimensionBehaviour2;
        }
        if (i13 == Integer.MIN_VALUE) {
            dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                i14 = Math.max(0, this.mMinHeight);
            }
        } else if (i13 != 0) {
            if (i13 == 1073741824) {
                i14 = Math.min(this.mMaxHeight - i15, i14);
            }
            i14 = 0;
        } else {
            dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                i14 = Math.max(0, this.mMinHeight);
            }
            i14 = 0;
        }
        if (i12 != dVar.Y() || i14 != dVar.z()) {
            dVar.S1();
        }
        dVar.q1(0);
        dVar.r1(0);
        dVar.b1(this.mMaxWidth - i16);
        dVar.a1(this.mMaxHeight - i15);
        dVar.e1(0);
        dVar.d1(0);
        dVar.T0(dimensionBehaviour);
        dVar.o1(i12);
        dVar.k1(dimensionBehaviour2);
        dVar.P0(i14);
        dVar.e1(this.mMinWidth - i16);
        dVar.d1(this.mMinHeight - i15);
    }

    public void setState(int i11, int i12, int i13) {
        androidx.constraintlayout.widget.a aVar = this.mConstraintLayoutSpec;
        if (aVar != null) {
            aVar.d(i11, i12, i13);
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
