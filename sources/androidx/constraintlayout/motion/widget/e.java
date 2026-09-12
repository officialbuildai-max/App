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
import v0.d;

/* loaded from: classes.dex */
public class e extends d {

    /* renamed from: g, reason: collision with root package name */
    private String f7330g;

    /* renamed from: h, reason: collision with root package name */
    private int f7331h = -1;

    /* renamed from: i, reason: collision with root package name */
    private boolean f7332i = false;

    /* renamed from: j, reason: collision with root package name */
    private float f7333j = Float.NaN;

    /* renamed from: k, reason: collision with root package name */
    private float f7334k = Float.NaN;

    /* renamed from: l, reason: collision with root package name */
    private float f7335l = Float.NaN;

    /* renamed from: m, reason: collision with root package name */
    private float f7336m = Float.NaN;

    /* renamed from: n, reason: collision with root package name */
    private float f7337n = Float.NaN;

    /* renamed from: o, reason: collision with root package name */
    private float f7338o = Float.NaN;

    /* renamed from: p, reason: collision with root package name */
    private float f7339p = Float.NaN;

    /* renamed from: q, reason: collision with root package name */
    private float f7340q = Float.NaN;

    /* renamed from: r, reason: collision with root package name */
    private float f7341r = Float.NaN;

    /* renamed from: s, reason: collision with root package name */
    private float f7342s = Float.NaN;

    /* renamed from: t, reason: collision with root package name */
    private float f7343t = Float.NaN;

    /* renamed from: u, reason: collision with root package name */
    private float f7344u = Float.NaN;

    /* renamed from: v, reason: collision with root package name */
    private float f7345v = Float.NaN;

    /* renamed from: w, reason: collision with root package name */
    private float f7346w = Float.NaN;

    /* loaded from: classes.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static SparseIntArray f7347a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f7347a = sparseIntArray;
            sparseIntArray.append(R$styleable.KeyAttribute_android_alpha, 1);
            f7347a.append(R$styleable.KeyAttribute_android_elevation, 2);
            f7347a.append(R$styleable.KeyAttribute_android_rotation, 4);
            f7347a.append(R$styleable.KeyAttribute_android_rotationX, 5);
            f7347a.append(R$styleable.KeyAttribute_android_rotationY, 6);
            f7347a.append(R$styleable.KeyAttribute_android_transformPivotX, 19);
            f7347a.append(R$styleable.KeyAttribute_android_transformPivotY, 20);
            f7347a.append(R$styleable.KeyAttribute_android_scaleX, 7);
            f7347a.append(R$styleable.KeyAttribute_transitionPathRotate, 8);
            f7347a.append(R$styleable.KeyAttribute_transitionEasing, 9);
            f7347a.append(R$styleable.KeyAttribute_motionTarget, 10);
            f7347a.append(R$styleable.KeyAttribute_framePosition, 12);
            f7347a.append(R$styleable.KeyAttribute_curveFit, 13);
            f7347a.append(R$styleable.KeyAttribute_android_scaleY, 14);
            f7347a.append(R$styleable.KeyAttribute_android_translationX, 15);
            f7347a.append(R$styleable.KeyAttribute_android_translationY, 16);
            f7347a.append(R$styleable.KeyAttribute_android_translationZ, 17);
            f7347a.append(R$styleable.KeyAttribute_motionProgress, 18);
        }

        public static void a(e eVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArray.getIndex(i11);
                switch (f7347a.get(index)) {
                    case 1:
                        eVar.f7333j = typedArray.getFloat(index, eVar.f7333j);
                        break;
                    case 2:
                        eVar.f7334k = typedArray.getDimension(index, eVar.f7334k);
                        break;
                    case 3:
                    case 11:
                    default:
                        Log.e("KeyAttribute", "unused attribute 0x" + Integer.toHexString(index) + "   " + f7347a.get(index));
                        break;
                    case 4:
                        eVar.f7335l = typedArray.getFloat(index, eVar.f7335l);
                        break;
                    case 5:
                        eVar.f7336m = typedArray.getFloat(index, eVar.f7336m);
                        break;
                    case 6:
                        eVar.f7337n = typedArray.getFloat(index, eVar.f7337n);
                        break;
                    case 7:
                        eVar.f7341r = typedArray.getFloat(index, eVar.f7341r);
                        break;
                    case 8:
                        eVar.f7340q = typedArray.getFloat(index, eVar.f7340q);
                        break;
                    case 9:
                        eVar.f7330g = typedArray.getString(index);
                        break;
                    case 10:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, eVar.f7326b);
                            eVar.f7326b = resourceId;
                            if (resourceId == -1) {
                                eVar.f7327c = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            eVar.f7327c = typedArray.getString(index);
                            break;
                        } else {
                            eVar.f7326b = typedArray.getResourceId(index, eVar.f7326b);
                            break;
                        }
                    case 12:
                        eVar.f7325a = typedArray.getInt(index, eVar.f7325a);
                        break;
                    case 13:
                        eVar.f7331h = typedArray.getInteger(index, eVar.f7331h);
                        break;
                    case 14:
                        eVar.f7342s = typedArray.getFloat(index, eVar.f7342s);
                        break;
                    case 15:
                        eVar.f7343t = typedArray.getDimension(index, eVar.f7343t);
                        break;
                    case 16:
                        eVar.f7344u = typedArray.getDimension(index, eVar.f7344u);
                        break;
                    case 17:
                        eVar.f7345v = typedArray.getDimension(index, eVar.f7345v);
                        break;
                    case 18:
                        eVar.f7346w = typedArray.getFloat(index, eVar.f7346w);
                        break;
                    case 19:
                        eVar.f7338o = typedArray.getDimension(index, eVar.f7338o);
                        break;
                    case 20:
                        eVar.f7339p = typedArray.getDimension(index, eVar.f7339p);
                        break;
                }
            }
        }
    }

    public e() {
        this.f7328d = 1;
        this.f7329e = new HashMap();
    }

    public void R(String str, Object obj) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1913008125:
                if (str.equals("motionProgress")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1249320806:
                if (str.equals("rotationX")) {
                    c11 = 2;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c11 = 3;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c11 = 4;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c11 = 5;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c11 = 6;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c11 = 7;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c11 = '\b';
                    break;
                }
                break;
            case -760884510:
                if (str.equals("transformPivotX")) {
                    c11 = '\t';
                    break;
                }
                break;
            case -760884509:
                if (str.equals("transformPivotY")) {
                    c11 = '\n';
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c11 = 11;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c11 = '\f';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c11 = '\r';
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c11 = 14;
                    break;
                }
                break;
            case 579057826:
                if (str.equals("curveFit")) {
                    c11 = 15;
                    break;
                }
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    c11 = 16;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                this.f7346w = k(obj);
                return;
            case 1:
                this.f7330g = obj.toString();
                return;
            case 2:
                this.f7336m = k(obj);
                return;
            case 3:
                this.f7337n = k(obj);
                return;
            case 4:
                this.f7343t = k(obj);
                return;
            case 5:
                this.f7344u = k(obj);
                return;
            case 6:
                this.f7345v = k(obj);
                return;
            case 7:
                this.f7341r = k(obj);
                return;
            case '\b':
                this.f7342s = k(obj);
                return;
            case '\t':
                this.f7338o = k(obj);
                return;
            case '\n':
                this.f7339p = k(obj);
                return;
            case 11:
                this.f7335l = k(obj);
                return;
            case '\f':
                this.f7334k = k(obj);
                return;
            case '\r':
                this.f7340q = k(obj);
                return;
            case 14:
                this.f7333j = k(obj);
                return;
            case 15:
                this.f7331h = l(obj);
                return;
            case 16:
                this.f7332i = j(obj);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0041. Please report as an issue. */
    @Override // androidx.constraintlayout.motion.widget.d
    public void a(HashMap hashMap) {
        for (String str : hashMap.keySet()) {
            androidx.constraintlayout.core.motion.utils.i iVar = (androidx.constraintlayout.core.motion.utils.i) hashMap.get(str);
            if (iVar != null) {
                if (!str.startsWith("CUSTOM")) {
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
                        case -760884510:
                            if (str.equals("transformPivotX")) {
                                c11 = '\b';
                                break;
                            }
                            break;
                        case -760884509:
                            if (str.equals("transformPivotY")) {
                                c11 = '\t';
                                break;
                            }
                            break;
                        case -40300674:
                            if (str.equals("rotation")) {
                                c11 = '\n';
                                break;
                            }
                            break;
                        case -4379043:
                            if (str.equals("elevation")) {
                                c11 = 11;
                                break;
                            }
                            break;
                        case 37232917:
                            if (str.equals("transitionPathRotate")) {
                                c11 = '\f';
                                break;
                            }
                            break;
                        case 92909918:
                            if (str.equals("alpha")) {
                                c11 = '\r';
                                break;
                            }
                            break;
                    }
                    switch (c11) {
                        case 0:
                            if (Float.isNaN(this.f7336m)) {
                                break;
                            } else {
                                iVar.c(this.f7325a, this.f7336m);
                                break;
                            }
                        case 1:
                            if (Float.isNaN(this.f7337n)) {
                                break;
                            } else {
                                iVar.c(this.f7325a, this.f7337n);
                                break;
                            }
                        case 2:
                            if (Float.isNaN(this.f7343t)) {
                                break;
                            } else {
                                iVar.c(this.f7325a, this.f7343t);
                                break;
                            }
                        case 3:
                            if (Float.isNaN(this.f7344u)) {
                                break;
                            } else {
                                iVar.c(this.f7325a, this.f7344u);
                                break;
                            }
                        case 4:
                            if (Float.isNaN(this.f7345v)) {
                                break;
                            } else {
                                iVar.c(this.f7325a, this.f7345v);
                                break;
                            }
                        case 5:
                            if (Float.isNaN(this.f7346w)) {
                                break;
                            } else {
                                iVar.c(this.f7325a, this.f7346w);
                                break;
                            }
                        case 6:
                            if (Float.isNaN(this.f7341r)) {
                                break;
                            } else {
                                iVar.c(this.f7325a, this.f7341r);
                                break;
                            }
                        case 7:
                            if (Float.isNaN(this.f7342s)) {
                                break;
                            } else {
                                iVar.c(this.f7325a, this.f7342s);
                                break;
                            }
                        case '\b':
                            if (Float.isNaN(this.f7336m)) {
                                break;
                            } else {
                                iVar.c(this.f7325a, this.f7338o);
                                break;
                            }
                        case '\t':
                            if (Float.isNaN(this.f7337n)) {
                                break;
                            } else {
                                iVar.c(this.f7325a, this.f7339p);
                                break;
                            }
                        case '\n':
                            if (Float.isNaN(this.f7335l)) {
                                break;
                            } else {
                                iVar.c(this.f7325a, this.f7335l);
                                break;
                            }
                        case 11:
                            if (Float.isNaN(this.f7334k)) {
                                break;
                            } else {
                                iVar.c(this.f7325a, this.f7334k);
                                break;
                            }
                        case '\f':
                            if (Float.isNaN(this.f7340q)) {
                                break;
                            } else {
                                iVar.c(this.f7325a, this.f7340q);
                                break;
                            }
                        case '\r':
                            if (Float.isNaN(this.f7333j)) {
                                break;
                            } else {
                                iVar.c(this.f7325a, this.f7333j);
                                break;
                            }
                    }
                } else {
                    ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.f7329e.get(str.substring(7));
                    if (constraintAttribute != null) {
                        ((d.b) iVar).i(this.f7325a, constraintAttribute);
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.d
    /* renamed from: b */
    public d clone() {
        return new e().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public d c(d dVar) {
        super.c(dVar);
        e eVar = (e) dVar;
        this.f7331h = eVar.f7331h;
        this.f7332i = eVar.f7332i;
        this.f7333j = eVar.f7333j;
        this.f7334k = eVar.f7334k;
        this.f7335l = eVar.f7335l;
        this.f7336m = eVar.f7336m;
        this.f7337n = eVar.f7337n;
        this.f7338o = eVar.f7338o;
        this.f7339p = eVar.f7339p;
        this.f7340q = eVar.f7340q;
        this.f7341r = eVar.f7341r;
        this.f7342s = eVar.f7342s;
        this.f7343t = eVar.f7343t;
        this.f7344u = eVar.f7344u;
        this.f7345v = eVar.f7345v;
        this.f7346w = eVar.f7346w;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void d(HashSet hashSet) {
        if (!Float.isNaN(this.f7333j)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f7334k)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f7335l)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f7336m)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f7337n)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f7338o)) {
            hashSet.add("transformPivotX");
        }
        if (!Float.isNaN(this.f7339p)) {
            hashSet.add("transformPivotY");
        }
        if (!Float.isNaN(this.f7343t)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f7344u)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f7345v)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.f7340q)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f7341r)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f7342s)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f7346w)) {
            hashSet.add(NotificationCompat.CATEGORY_PROGRESS);
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
        a.a(this, context.obtainStyledAttributes(attributeSet, R$styleable.KeyAttribute));
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void h(HashMap hashMap) {
        if (this.f7331h == -1) {
            return;
        }
        if (!Float.isNaN(this.f7333j)) {
            hashMap.put("alpha", Integer.valueOf(this.f7331h));
        }
        if (!Float.isNaN(this.f7334k)) {
            hashMap.put("elevation", Integer.valueOf(this.f7331h));
        }
        if (!Float.isNaN(this.f7335l)) {
            hashMap.put("rotation", Integer.valueOf(this.f7331h));
        }
        if (!Float.isNaN(this.f7336m)) {
            hashMap.put("rotationX", Integer.valueOf(this.f7331h));
        }
        if (!Float.isNaN(this.f7337n)) {
            hashMap.put("rotationY", Integer.valueOf(this.f7331h));
        }
        if (!Float.isNaN(this.f7338o)) {
            hashMap.put("transformPivotX", Integer.valueOf(this.f7331h));
        }
        if (!Float.isNaN(this.f7339p)) {
            hashMap.put("transformPivotY", Integer.valueOf(this.f7331h));
        }
        if (!Float.isNaN(this.f7343t)) {
            hashMap.put("translationX", Integer.valueOf(this.f7331h));
        }
        if (!Float.isNaN(this.f7344u)) {
            hashMap.put("translationY", Integer.valueOf(this.f7331h));
        }
        if (!Float.isNaN(this.f7345v)) {
            hashMap.put("translationZ", Integer.valueOf(this.f7331h));
        }
        if (!Float.isNaN(this.f7340q)) {
            hashMap.put("transitionPathRotate", Integer.valueOf(this.f7331h));
        }
        if (!Float.isNaN(this.f7341r)) {
            hashMap.put("scaleX", Integer.valueOf(this.f7331h));
        }
        if (!Float.isNaN(this.f7342s)) {
            hashMap.put("scaleY", Integer.valueOf(this.f7331h));
        }
        if (!Float.isNaN(this.f7346w)) {
            hashMap.put(NotificationCompat.CATEGORY_PROGRESS, Integer.valueOf(this.f7331h));
        }
        if (this.f7329e.size() > 0) {
            Iterator it = this.f7329e.keySet().iterator();
            while (it.hasNext()) {
                hashMap.put("CUSTOM," + ((String) it.next()), Integer.valueOf(this.f7331h));
            }
        }
    }
}
