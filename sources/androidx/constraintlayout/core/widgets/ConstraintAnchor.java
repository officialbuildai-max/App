package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.analyzer.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ConstraintAnchor {

    /* renamed from: b, reason: collision with root package name */
    private int f6922b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6923c;

    /* renamed from: d, reason: collision with root package name */
    public final ConstraintWidget f6924d;

    /* renamed from: e, reason: collision with root package name */
    public final Type f6925e;

    /* renamed from: f, reason: collision with root package name */
    public ConstraintAnchor f6926f;

    /* renamed from: i, reason: collision with root package name */
    SolverVariable f6929i;

    /* renamed from: a, reason: collision with root package name */
    private HashSet f6921a = null;

    /* renamed from: g, reason: collision with root package name */
    public int f6927g = 0;

    /* renamed from: h, reason: collision with root package name */
    int f6928h = Integer.MIN_VALUE;

    /* loaded from: classes.dex */
    public enum Type {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6930a;

        static {
            int[] iArr = new int[Type.values().length];
            f6930a = iArr;
            try {
                iArr[Type.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6930a[Type.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6930a[Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6930a[Type.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6930a[Type.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6930a[Type.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6930a[Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f6930a[Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f6930a[Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.f6924d = constraintWidget;
        this.f6925e = type;
    }

    public boolean a(ConstraintAnchor constraintAnchor, int i11) {
        return b(constraintAnchor, i11, Integer.MIN_VALUE, false);
    }

    public boolean b(ConstraintAnchor constraintAnchor, int i11, int i12, boolean z10) {
        if (constraintAnchor == null) {
            q();
            return true;
        }
        if (!z10 && !p(constraintAnchor)) {
            return false;
        }
        this.f6926f = constraintAnchor;
        if (constraintAnchor.f6921a == null) {
            constraintAnchor.f6921a = new HashSet();
        }
        HashSet hashSet = this.f6926f.f6921a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.f6927g = i11;
        this.f6928h = i12;
        return true;
    }

    public void c(int i11, ArrayList arrayList, m mVar) {
        HashSet hashSet = this.f6921a;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                androidx.constraintlayout.core.widgets.analyzer.g.a(((ConstraintAnchor) it.next()).f6924d, i11, arrayList, mVar);
            }
        }
    }

    public HashSet d() {
        return this.f6921a;
    }

    public int e() {
        if (this.f6923c) {
            return this.f6922b;
        }
        return 0;
    }

    public int f() {
        ConstraintAnchor constraintAnchor;
        if (this.f6924d.X() == 8) {
            return 0;
        }
        return (this.f6928h == Integer.MIN_VALUE || (constraintAnchor = this.f6926f) == null || constraintAnchor.f6924d.X() != 8) ? this.f6927g : this.f6928h;
    }

    public final ConstraintAnchor g() {
        switch (a.f6930a[this.f6925e.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
            case 2:
                return this.f6924d.S;
            case 3:
                return this.f6924d.Q;
            case 4:
                return this.f6924d.T;
            case 5:
                return this.f6924d.R;
            default:
                throw new AssertionError(this.f6925e.name());
        }
    }

    public ConstraintWidget h() {
        return this.f6924d;
    }

    public SolverVariable i() {
        return this.f6929i;
    }

    public ConstraintAnchor j() {
        return this.f6926f;
    }

    public Type k() {
        return this.f6925e;
    }

    public boolean l() {
        HashSet hashSet = this.f6921a;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((ConstraintAnchor) it.next()).g().o()) {
                return true;
            }
        }
        return false;
    }

    public boolean m() {
        HashSet hashSet = this.f6921a;
        return hashSet != null && hashSet.size() > 0;
    }

    public boolean n() {
        return this.f6923c;
    }

    public boolean o() {
        return this.f6926f != null;
    }

    public boolean p(ConstraintAnchor constraintAnchor) {
        if (constraintAnchor == null) {
            return false;
        }
        Type k11 = constraintAnchor.k();
        Type type = this.f6925e;
        if (k11 == type) {
            return type != Type.BASELINE || (constraintAnchor.h().b0() && h().b0());
        }
        switch (a.f6930a[type.ordinal()]) {
            case 1:
                return (k11 == Type.BASELINE || k11 == Type.CENTER_X || k11 == Type.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z10 = k11 == Type.LEFT || k11 == Type.RIGHT;
                if (constraintAnchor.h() instanceof f) {
                    return z10 || k11 == Type.CENTER_X;
                }
                return z10;
            case 4:
            case 5:
                boolean z11 = k11 == Type.TOP || k11 == Type.BOTTOM;
                if (constraintAnchor.h() instanceof f) {
                    return z11 || k11 == Type.CENTER_Y;
                }
                return z11;
            case 6:
                return (k11 == Type.LEFT || k11 == Type.RIGHT) ? false : true;
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.f6925e.name());
        }
    }

    public void q() {
        HashSet hashSet;
        ConstraintAnchor constraintAnchor = this.f6926f;
        if (constraintAnchor != null && (hashSet = constraintAnchor.f6921a) != null) {
            hashSet.remove(this);
            if (this.f6926f.f6921a.size() == 0) {
                this.f6926f.f6921a = null;
            }
        }
        this.f6921a = null;
        this.f6926f = null;
        this.f6927g = 0;
        this.f6928h = Integer.MIN_VALUE;
        this.f6923c = false;
        this.f6922b = 0;
    }

    public void r() {
        this.f6923c = false;
        this.f6922b = 0;
    }

    public void s(androidx.constraintlayout.core.c cVar) {
        SolverVariable solverVariable = this.f6929i;
        if (solverVariable == null) {
            this.f6929i = new SolverVariable(SolverVariable.Type.UNRESTRICTED, null);
        } else {
            solverVariable.f();
        }
    }

    public void t(int i11) {
        this.f6922b = i11;
        this.f6923c = true;
    }

    public String toString() {
        return this.f6924d.v() + ":" + this.f6925e.toString();
    }

    public void u(int i11) {
        if (o()) {
            this.f6928h = i11;
        }
    }
}
