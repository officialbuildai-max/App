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
import v0.f;

/* loaded from: classes.dex */
public class j extends d {

    /* renamed from: g, reason: collision with root package name */
    private String f7385g;

    /* renamed from: h, reason: collision with root package name */
    private int f7386h = -1;

    /* renamed from: i, reason: collision with root package name */
    private float f7387i = Float.NaN;

    /* renamed from: j, reason: collision with root package name */
    private float f7388j = Float.NaN;

    /* renamed from: k, reason: collision with root package name */
    private float f7389k = Float.NaN;

    /* renamed from: l, reason: collision with root package name */
    private float f7390l = Float.NaN;

    /* renamed from: m, reason: collision with root package name */
    private float f7391m = Float.NaN;

    /* renamed from: n, reason: collision with root package name */
    private float f7392n = Float.NaN;

    /* renamed from: o, reason: collision with root package name */
    private float f7393o = Float.NaN;

    /* renamed from: p, reason: collision with root package name */
    private float f7394p = Float.NaN;

    /* renamed from: q, reason: collision with root package name */
    private float f7395q = Float.NaN;

    /* renamed from: r, reason: collision with root package name */
    private float f7396r = Float.NaN;

    /* renamed from: s, reason: collision with root package name */
    private float f7397s = Float.NaN;

    /* renamed from: t, reason: collision with root package name */
    private float f7398t = Float.NaN;

    /* renamed from: u, reason: collision with root package name */
    private int f7399u = 0;

    /* renamed from: v, reason: collision with root package name */
    private String f7400v = null;

    /* renamed from: w, reason: collision with root package name */
    private float f7401w = Float.NaN;

    /* renamed from: x, reason: collision with root package name */
    private float f7402x = 0.0f;

    /* loaded from: classes.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static SparseIntArray f7403a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f7403a = sparseIntArray;
            sparseIntArray.append(R$styleable.KeyTimeCycle_android_alpha, 1);
            f7403a.append(R$styleable.KeyTimeCycle_android_elevation, 2);
            f7403a.append(R$styleable.KeyTimeCycle_android_rotation, 4);
            f7403a.append(R$styleable.KeyTimeCycle_android_rotationX, 5);
            f7403a.append(R$styleable.KeyTimeCycle_android_rotationY, 6);
            f7403a.append(R$styleable.KeyTimeCycle_android_scaleX, 7);
            f7403a.append(R$styleable.KeyTimeCycle_transitionPathRotate, 8);
            f7403a.append(R$styleable.KeyTimeCycle_transitionEasing, 9);
            f7403a.append(R$styleable.KeyTimeCycle_motionTarget, 10);
            f7403a.append(R$styleable.KeyTimeCycle_framePosition, 12);
            f7403a.append(R$styleable.KeyTimeCycle_curveFit, 13);
            f7403a.append(R$styleable.KeyTimeCycle_android_scaleY, 14);
            f7403a.append(R$styleable.KeyTimeCycle_android_translationX, 15);
            f7403a.append(R$styleable.KeyTimeCycle_android_translationY, 16);
            f7403a.append(R$styleable.KeyTimeCycle_android_translationZ, 17);
            f7403a.append(R$styleable.KeyTimeCycle_motionProgress, 18);
            f7403a.append(R$styleable.KeyTimeCycle_wavePeriod, 20);
            f7403a.append(R$styleable.KeyTimeCycle_waveOffset, 21);
            f7403a.append(R$styleable.KeyTimeCycle_waveShape, 19);
        }

        public static void a(j jVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArray.getIndex(i11);
                switch (f7403a.get(index)) {
                    case 1:
                        jVar.f7387i = typedArray.getFloat(index, jVar.f7387i);
                        break;
                    case 2:
                        jVar.f7388j = typedArray.getDimension(index, jVar.f7388j);
                        break;
                    case 3:
                    case 11:
                    default:
                        Log.e("KeyTimeCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + f7403a.get(index));
                        break;
                    case 4:
                        jVar.f7389k = typedArray.getFloat(index, jVar.f7389k);
                        break;
                    case 5:
                        jVar.f7390l = typedArray.getFloat(index, jVar.f7390l);
                        break;
                    case 6:
                        jVar.f7391m = typedArray.getFloat(index, jVar.f7391m);
                        break;
                    case 7:
                        jVar.f7393o = typedArray.getFloat(index, jVar.f7393o);
                        break;
                    case 8:
                        jVar.f7392n = typedArray.getFloat(index, jVar.f7392n);
                        break;
                    case 9:
                        jVar.f7385g = typedArray.getString(index);
                        break;
                    case 10:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, jVar.f7326b);
                            jVar.f7326b = resourceId;
                            if (resourceId == -1) {
                                jVar.f7327c = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            jVar.f7327c = typedArray.getString(index);
                            break;
                        } else {
                            jVar.f7326b = typedArray.getResourceId(index, jVar.f7326b);
                            break;
                        }
                    case 12:
                        jVar.f7325a = typedArray.getInt(index, jVar.f7325a);
                        break;
                    case 13:
                        jVar.f7386h = typedArray.getInteger(index, jVar.f7386h);
                        break;
                    case 14:
                        jVar.f7394p = typedArray.getFloat(index, jVar.f7394p);
                        break;
                    case 15:
                        jVar.f7395q = typedArray.getDimension(index, jVar.f7395q);
                        break;
                    case 16:
                        jVar.f7396r = typedArray.getDimension(index, jVar.f7396r);
                        break;
                    case 17:
                        jVar.f7397s = typedArray.getDimension(index, jVar.f7397s);
                        break;
                    case 18:
                        jVar.f7398t = typedArray.getFloat(index, jVar.f7398t);
                        break;
                    case 19:
                        if (typedArray.peekValue(index).type == 3) {
                            jVar.f7400v = typedArray.getString(index);
                            jVar.f7399u = 7;
                            break;
                        } else {
                            jVar.f7399u = typedArray.getInt(index, jVar.f7399u);
                            break;
                        }
                    case 20:
                        jVar.f7401w = typedArray.getFloat(index, jVar.f7401w);
                        break;
                    case 21:
                        if (typedArray.peekValue(index).type == 5) {
                            jVar.f7402x = typedArray.getDimension(index, jVar.f7402x);
                            break;
                        } else {
                            jVar.f7402x = typedArray.getFloat(index, jVar.f7402x);
                            break;
                        }
                }
            }
        }
    }

    public j() {
        this.f7328d = 3;
        this.f7329e = new HashMap();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x004a. Please report as an issue. */
    public void U(HashMap hashMap) {
        for (String str : hashMap.keySet()) {
            v0.f fVar = (v0.f) hashMap.get(str);
            if (fVar != null) {
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
                    }
                    switch (c11) {
                        case 0:
                            if (Float.isNaN(this.f7390l)) {
                                break;
                            } else {
                                fVar.b(this.f7325a, this.f7390l, this.f7401w, this.f7399u, this.f7402x);
                                break;
                            }
                        case 1:
                            if (Float.isNaN(this.f7391m)) {
                                break;
                            } else {
                                fVar.b(this.f7325a, this.f7391m, this.f7401w, this.f7399u, this.f7402x);
                                break;
                            }
                        case 2:
                            if (Float.isNaN(this.f7395q)) {
                                break;
                            } else {
                                fVar.b(this.f7325a, this.f7395q, this.f7401w, this.f7399u, this.f7402x);
                                break;
                            }
                        case 3:
                            if (Float.isNaN(this.f7396r)) {
                                break;
                            } else {
                                fVar.b(this.f7325a, this.f7396r, this.f7401w, this.f7399u, this.f7402x);
                                break;
                            }
                        case 4:
                            if (Float.isNaN(this.f7397s)) {
                                break;
                            } else {
                                fVar.b(this.f7325a, this.f7397s, this.f7401w, this.f7399u, this.f7402x);
                                break;
                            }
                        case 5:
                            if (Float.isNaN(this.f7398t)) {
                                break;
                            } else {
                                fVar.b(this.f7325a, this.f7398t, this.f7401w, this.f7399u, this.f7402x);
                                break;
                            }
                        case 6:
                            if (Float.isNaN(this.f7393o)) {
                                break;
                            } else {
                                fVar.b(this.f7325a, this.f7393o, this.f7401w, this.f7399u, this.f7402x);
                                break;
                            }
                        case 7:
                            if (Float.isNaN(this.f7394p)) {
                                break;
                            } else {
                                fVar.b(this.f7325a, this.f7394p, this.f7401w, this.f7399u, this.f7402x);
                                break;
                            }
                        case '\b':
                            if (Float.isNaN(this.f7389k)) {
                                break;
                            } else {
                                fVar.b(this.f7325a, this.f7389k, this.f7401w, this.f7399u, this.f7402x);
                                break;
                            }
                        case '\t':
                            if (Float.isNaN(this.f7388j)) {
                                break;
                            } else {
                                fVar.b(this.f7325a, this.f7388j, this.f7401w, this.f7399u, this.f7402x);
                                break;
                            }
                        case '\n':
                            if (Float.isNaN(this.f7392n)) {
                                break;
                            } else {
                                fVar.b(this.f7325a, this.f7392n, this.f7401w, this.f7399u, this.f7402x);
                                break;
                            }
                        case 11:
                            if (Float.isNaN(this.f7387i)) {
                                break;
                            } else {
                                fVar.b(this.f7325a, this.f7387i, this.f7401w, this.f7399u, this.f7402x);
                                break;
                            }
                        default:
                            Log.e("KeyTimeCycles", "UNKNOWN addValues \"" + str + "\"");
                            break;
                    }
                } else {
                    ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.f7329e.get(str.substring(7));
                    if (constraintAttribute != null) {
                        ((f.b) fVar).j(this.f7325a, constraintAttribute, this.f7401w, this.f7399u, this.f7402x);
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void a(HashMap hashMap) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    @Override // androidx.constraintlayout.motion.widget.d
    /* renamed from: b */
    public d clone() {
        return new j().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public d c(d dVar) {
        super.c(dVar);
        j jVar = (j) dVar;
        this.f7385g = jVar.f7385g;
        this.f7386h = jVar.f7386h;
        this.f7399u = jVar.f7399u;
        this.f7401w = jVar.f7401w;
        this.f7402x = jVar.f7402x;
        this.f7398t = jVar.f7398t;
        this.f7387i = jVar.f7387i;
        this.f7388j = jVar.f7388j;
        this.f7389k = jVar.f7389k;
        this.f7392n = jVar.f7392n;
        this.f7390l = jVar.f7390l;
        this.f7391m = jVar.f7391m;
        this.f7393o = jVar.f7393o;
        this.f7394p = jVar.f7394p;
        this.f7395q = jVar.f7395q;
        this.f7396r = jVar.f7396r;
        this.f7397s = jVar.f7397s;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void d(HashSet hashSet) {
        if (!Float.isNaN(this.f7387i)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f7388j)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f7389k)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f7390l)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f7391m)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f7395q)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f7396r)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f7397s)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.f7392n)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f7393o)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f7394p)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f7398t)) {
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
        a.a(this, context.obtainStyledAttributes(attributeSet, R$styleable.KeyTimeCycle));
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void h(HashMap hashMap) {
        if (this.f7386h == -1) {
            return;
        }
        if (!Float.isNaN(this.f7387i)) {
            hashMap.put("alpha", Integer.valueOf(this.f7386h));
        }
        if (!Float.isNaN(this.f7388j)) {
            hashMap.put("elevation", Integer.valueOf(this.f7386h));
        }
        if (!Float.isNaN(this.f7389k)) {
            hashMap.put("rotation", Integer.valueOf(this.f7386h));
        }
        if (!Float.isNaN(this.f7390l)) {
            hashMap.put("rotationX", Integer.valueOf(this.f7386h));
        }
        if (!Float.isNaN(this.f7391m)) {
            hashMap.put("rotationY", Integer.valueOf(this.f7386h));
        }
        if (!Float.isNaN(this.f7395q)) {
            hashMap.put("translationX", Integer.valueOf(this.f7386h));
        }
        if (!Float.isNaN(this.f7396r)) {
            hashMap.put("translationY", Integer.valueOf(this.f7386h));
        }
        if (!Float.isNaN(this.f7397s)) {
            hashMap.put("translationZ", Integer.valueOf(this.f7386h));
        }
        if (!Float.isNaN(this.f7392n)) {
            hashMap.put("transitionPathRotate", Integer.valueOf(this.f7386h));
        }
        if (!Float.isNaN(this.f7393o)) {
            hashMap.put("scaleX", Integer.valueOf(this.f7386h));
        }
        if (!Float.isNaN(this.f7393o)) {
            hashMap.put("scaleY", Integer.valueOf(this.f7386h));
        }
        if (!Float.isNaN(this.f7398t)) {
            hashMap.put(NotificationCompat.CATEGORY_PROGRESS, Integer.valueOf(this.f7386h));
        }
        if (this.f7329e.size() > 0) {
            Iterator it = this.f7329e.keySet().iterator();
            while (it.hasNext()) {
                hashMap.put("CUSTOM," + ((String) it.next()), Integer.valueOf(this.f7386h));
            }
        }
    }
}
