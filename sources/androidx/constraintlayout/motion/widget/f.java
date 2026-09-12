package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R$styleable;
import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class f extends d {

    /* renamed from: g, reason: collision with root package name */
    private String f7348g = null;

    /* renamed from: h, reason: collision with root package name */
    private int f7349h = 0;

    /* renamed from: i, reason: collision with root package name */
    private int f7350i = -1;

    /* renamed from: j, reason: collision with root package name */
    private String f7351j = null;

    /* renamed from: k, reason: collision with root package name */
    private float f7352k = Float.NaN;

    /* renamed from: l, reason: collision with root package name */
    private float f7353l = 0.0f;

    /* renamed from: m, reason: collision with root package name */
    private float f7354m = 0.0f;

    /* renamed from: n, reason: collision with root package name */
    private float f7355n = Float.NaN;

    /* renamed from: o, reason: collision with root package name */
    private int f7356o = -1;

    /* renamed from: p, reason: collision with root package name */
    private float f7357p = Float.NaN;

    /* renamed from: q, reason: collision with root package name */
    private float f7358q = Float.NaN;

    /* renamed from: r, reason: collision with root package name */
    private float f7359r = Float.NaN;

    /* renamed from: s, reason: collision with root package name */
    private float f7360s = Float.NaN;

    /* renamed from: t, reason: collision with root package name */
    private float f7361t = Float.NaN;

    /* renamed from: u, reason: collision with root package name */
    private float f7362u = Float.NaN;

    /* renamed from: v, reason: collision with root package name */
    private float f7363v = Float.NaN;

    /* renamed from: w, reason: collision with root package name */
    private float f7364w = Float.NaN;

    /* renamed from: x, reason: collision with root package name */
    private float f7365x = Float.NaN;

    /* renamed from: y, reason: collision with root package name */
    private float f7366y = Float.NaN;

    /* renamed from: z, reason: collision with root package name */
    private float f7367z = Float.NaN;

    /* loaded from: classes.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static SparseIntArray f7368a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f7368a = sparseIntArray;
            sparseIntArray.append(R$styleable.KeyCycle_motionTarget, 1);
            f7368a.append(R$styleable.KeyCycle_framePosition, 2);
            f7368a.append(R$styleable.KeyCycle_transitionEasing, 3);
            f7368a.append(R$styleable.KeyCycle_curveFit, 4);
            f7368a.append(R$styleable.KeyCycle_waveShape, 5);
            f7368a.append(R$styleable.KeyCycle_wavePeriod, 6);
            f7368a.append(R$styleable.KeyCycle_waveOffset, 7);
            f7368a.append(R$styleable.KeyCycle_waveVariesBy, 8);
            f7368a.append(R$styleable.KeyCycle_android_alpha, 9);
            f7368a.append(R$styleable.KeyCycle_android_elevation, 10);
            f7368a.append(R$styleable.KeyCycle_android_rotation, 11);
            f7368a.append(R$styleable.KeyCycle_android_rotationX, 12);
            f7368a.append(R$styleable.KeyCycle_android_rotationY, 13);
            f7368a.append(R$styleable.KeyCycle_transitionPathRotate, 14);
            f7368a.append(R$styleable.KeyCycle_android_scaleX, 15);
            f7368a.append(R$styleable.KeyCycle_android_scaleY, 16);
            f7368a.append(R$styleable.KeyCycle_android_translationX, 17);
            f7368a.append(R$styleable.KeyCycle_android_translationY, 18);
            f7368a.append(R$styleable.KeyCycle_android_translationZ, 19);
            f7368a.append(R$styleable.KeyCycle_motionProgress, 20);
            f7368a.append(R$styleable.KeyCycle_wavePhase, 21);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(f fVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArray.getIndex(i11);
                switch (f7368a.get(index)) {
                    case 1:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, fVar.f7326b);
                            fVar.f7326b = resourceId;
                            if (resourceId == -1) {
                                fVar.f7327c = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            fVar.f7327c = typedArray.getString(index);
                            break;
                        } else {
                            fVar.f7326b = typedArray.getResourceId(index, fVar.f7326b);
                            break;
                        }
                    case 2:
                        fVar.f7325a = typedArray.getInt(index, fVar.f7325a);
                        break;
                    case 3:
                        fVar.f7348g = typedArray.getString(index);
                        break;
                    case 4:
                        fVar.f7349h = typedArray.getInteger(index, fVar.f7349h);
                        break;
                    case 5:
                        if (typedArray.peekValue(index).type == 3) {
                            fVar.f7351j = typedArray.getString(index);
                            fVar.f7350i = 7;
                            break;
                        } else {
                            fVar.f7350i = typedArray.getInt(index, fVar.f7350i);
                            break;
                        }
                    case 6:
                        fVar.f7352k = typedArray.getFloat(index, fVar.f7352k);
                        break;
                    case 7:
                        if (typedArray.peekValue(index).type == 5) {
                            fVar.f7353l = typedArray.getDimension(index, fVar.f7353l);
                            break;
                        } else {
                            fVar.f7353l = typedArray.getFloat(index, fVar.f7353l);
                            break;
                        }
                    case 8:
                        fVar.f7356o = typedArray.getInt(index, fVar.f7356o);
                        break;
                    case 9:
                        fVar.f7357p = typedArray.getFloat(index, fVar.f7357p);
                        break;
                    case 10:
                        fVar.f7358q = typedArray.getDimension(index, fVar.f7358q);
                        break;
                    case 11:
                        fVar.f7359r = typedArray.getFloat(index, fVar.f7359r);
                        break;
                    case 12:
                        fVar.f7361t = typedArray.getFloat(index, fVar.f7361t);
                        break;
                    case 13:
                        fVar.f7362u = typedArray.getFloat(index, fVar.f7362u);
                        break;
                    case 14:
                        fVar.f7360s = typedArray.getFloat(index, fVar.f7360s);
                        break;
                    case 15:
                        fVar.f7363v = typedArray.getFloat(index, fVar.f7363v);
                        break;
                    case 16:
                        fVar.f7364w = typedArray.getFloat(index, fVar.f7364w);
                        break;
                    case 17:
                        fVar.f7365x = typedArray.getDimension(index, fVar.f7365x);
                        break;
                    case 18:
                        fVar.f7366y = typedArray.getDimension(index, fVar.f7366y);
                        break;
                    case 19:
                        fVar.f7367z = typedArray.getDimension(index, fVar.f7367z);
                        break;
                    case 20:
                        fVar.f7355n = typedArray.getFloat(index, fVar.f7355n);
                        break;
                    case 21:
                        fVar.f7354m = typedArray.getFloat(index, fVar.f7354m) / 360.0f;
                        break;
                    default:
                        Log.e("KeyCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + f7368a.get(index));
                        break;
                }
            }
        }
    }

    public f() {
        this.f7328d = 4;
        this.f7329e = new HashMap();
    }

    public void Y(HashMap hashMap) {
        v0.c cVar;
        v0.c cVar2;
        for (String str : hashMap.keySet()) {
            if (str.startsWith("CUSTOM")) {
                ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.f7329e.get(str.substring(7));
                if (constraintAttribute != null && constraintAttribute.d() == ConstraintAttribute.AttributeType.FLOAT_TYPE && (cVar = (v0.c) hashMap.get(str)) != null) {
                    cVar.e(this.f7325a, this.f7350i, this.f7351j, this.f7356o, this.f7352k, this.f7353l, this.f7354m, constraintAttribute.e(), constraintAttribute);
                }
            } else {
                float Z = Z(str);
                if (!Float.isNaN(Z) && (cVar2 = (v0.c) hashMap.get(str)) != null) {
                    cVar2.d(this.f7325a, this.f7350i, this.f7351j, this.f7356o, this.f7352k, this.f7353l, this.f7354m, Z);
                }
            }
        }
    }

    public float Z(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c11 = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c11 = 3;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c11 = 4;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals(NotificationCompat.CATEGORY_PROGRESS)) {
                    c11 = 5;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c11 = 6;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c11 = 7;
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c11 = '\b';
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c11 = '\t';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c11 = '\n';
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c11 = 11;
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c11 = '\f';
                    break;
                }
                break;
            case 1530034690:
                if (str.equals("wavePhase")) {
                    c11 = '\r';
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return this.f7361t;
            case 1:
                return this.f7362u;
            case 2:
                return this.f7365x;
            case 3:
                return this.f7366y;
            case 4:
                return this.f7367z;
            case 5:
                return this.f7355n;
            case 6:
                return this.f7363v;
            case 7:
                return this.f7364w;
            case '\b':
                return this.f7359r;
            case '\t':
                return this.f7358q;
            case '\n':
                return this.f7360s;
            case 11:
                return this.f7357p;
            case '\f':
                return this.f7353l;
            case '\r':
                return this.f7354m;
            default:
                if (str.startsWith("CUSTOM")) {
                    return Float.NaN;
                }
                Log.v("WARNING! KeyCycle", "  UNKNOWN  " + str);
                return Float.NaN;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0045. Please report as an issue. */
    @Override // androidx.constraintlayout.motion.widget.d
    public void a(HashMap hashMap) {
        androidx.constraintlayout.motion.widget.a.g("KeyCycle", "add " + hashMap.size() + " values", 2);
        for (String str : hashMap.keySet()) {
            androidx.constraintlayout.core.motion.utils.i iVar = (androidx.constraintlayout.core.motion.utils.i) hashMap.get(str);
            if (iVar != null) {
                str.hashCode();
                char c11 = 65535;
                switch (str.hashCode()) {
                    case -1249320806:
                        if (str.equals("rotationX")) {
                            c11 = 0;
                            break;
                        }
                        break;
                    case -1249320805:
                        if (str.equals("rotationY")) {
                            c11 = 1;
                            break;
                        }
                        break;
                    case -1225497657:
                        if (str.equals("translationX")) {
                            c11 = 2;
                            break;
                        }
                        break;
                    case -1225497656:
                        if (str.equals("translationY")) {
                            c11 = 3;
                            break;
                        }
                        break;
                    case -1225497655:
                        if (str.equals("translationZ")) {
                            c11 = 4;
                            break;
                        }
                        break;
                    case -1001078227:
                        if (str.equals(NotificationCompat.CATEGORY_PROGRESS)) {
                            c11 = 5;
                            break;
                        }
                        break;
                    case -908189618:
                        if (str.equals("scaleX")) {
                            c11 = 6;
                            break;
                        }
                        break;
                    case -908189617:
                        if (str.equals("scaleY")) {
                            c11 = 7;
                            break;
                        }
                        break;
                    case -40300674:
                        if (str.equals("rotation")) {
                            c11 = '\b';
                            break;
                        }
                        break;
                    case -4379043:
                        if (str.equals("elevation")) {
                            c11 = '\t';
                            break;
                        }
                        break;
                    case 37232917:
                        if (str.equals("transitionPathRotate")) {
                            c11 = '\n';
                            break;
                        }
                        break;
                    case 92909918:
                        if (str.equals("alpha")) {
                            c11 = 11;
                            break;
                        }
                        break;
                    case 156108012:
                        if (str.equals("waveOffset")) {
                            c11 = '\f';
                            break;
                        }
                        break;
                    case 1530034690:
                        if (str.equals("wavePhase")) {
                            c11 = '\r';
                            break;
                        }
                        break;
                }
                switch (c11) {
                    case 0:
                        iVar.c(this.f7325a, this.f7361t);
                        break;
                    case 1:
                        iVar.c(this.f7325a, this.f7362u);
                        break;
                    case 2:
                        iVar.c(this.f7325a, this.f7365x);
                        break;
                    case 3:
                        iVar.c(this.f7325a, this.f7366y);
                        break;
                    case 4:
                        iVar.c(this.f7325a, this.f7367z);
                        break;
                    case 5:
                        iVar.c(this.f7325a, this.f7355n);
                        break;
                    case 6:
                        iVar.c(this.f7325a, this.f7363v);
                        break;
                    case 7:
                        iVar.c(this.f7325a, this.f7364w);
                        break;
                    case '\b':
                        iVar.c(this.f7325a, this.f7359r);
                        break;
                    case '\t':
                        iVar.c(this.f7325a, this.f7358q);
                        break;
                    case '\n':
                        iVar.c(this.f7325a, this.f7360s);
                        break;
                    case 11:
                        iVar.c(this.f7325a, this.f7357p);
                        break;
                    case '\f':
                        iVar.c(this.f7325a, this.f7353l);
                        break;
                    case '\r':
                        iVar.c(this.f7325a, this.f7354m);
                        break;
                    default:
                        if (str.startsWith("CUSTOM")) {
                            break;
                        } else {
                            Log.v("WARNING KeyCycle", "  UNKNOWN  " + str);
                            break;
                        }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.d
    /* renamed from: b */
    public d clone() {
        return new f().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public d c(d dVar) {
        super.c(dVar);
        f fVar = (f) dVar;
        this.f7348g = fVar.f7348g;
        this.f7349h = fVar.f7349h;
        this.f7350i = fVar.f7350i;
        this.f7351j = fVar.f7351j;
        this.f7352k = fVar.f7352k;
        this.f7353l = fVar.f7353l;
        this.f7354m = fVar.f7354m;
        this.f7355n = fVar.f7355n;
        this.f7356o = fVar.f7356o;
        this.f7357p = fVar.f7357p;
        this.f7358q = fVar.f7358q;
        this.f7359r = fVar.f7359r;
        this.f7360s = fVar.f7360s;
        this.f7361t = fVar.f7361t;
        this.f7362u = fVar.f7362u;
        this.f7363v = fVar.f7363v;
        this.f7364w = fVar.f7364w;
        this.f7365x = fVar.f7365x;
        this.f7366y = fVar.f7366y;
        this.f7367z = fVar.f7367z;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void d(HashSet hashSet) {
        if (!Float.isNaN(this.f7357p)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f7358q)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f7359r)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f7361t)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f7362u)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f7363v)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f7364w)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f7360s)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f7365x)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f7366y)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f7367z)) {
            hashSet.add("translationZ");
        }
        if (this.f7329e.size() > 0) {
            Iterator it = this.f7329e.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + ((String) it.next()));
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void e(Context context, AttributeSet attributeSet) {
        a.b(this, context.obtainStyledAttributes(attributeSet, R$styleable.KeyCycle));
    }
}
