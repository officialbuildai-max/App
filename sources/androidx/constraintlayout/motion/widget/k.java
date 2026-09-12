package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R$styleable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

/* loaded from: classes.dex */
public class k extends d {
    HashMap A;

    /* renamed from: g, reason: collision with root package name */
    private int f7404g = -1;

    /* renamed from: h, reason: collision with root package name */
    private String f7405h = null;

    /* renamed from: i, reason: collision with root package name */
    private int f7406i;

    /* renamed from: j, reason: collision with root package name */
    private String f7407j;

    /* renamed from: k, reason: collision with root package name */
    private String f7408k;

    /* renamed from: l, reason: collision with root package name */
    private int f7409l;

    /* renamed from: m, reason: collision with root package name */
    private int f7410m;

    /* renamed from: n, reason: collision with root package name */
    private View f7411n;

    /* renamed from: o, reason: collision with root package name */
    float f7412o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f7413p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f7414q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f7415r;

    /* renamed from: s, reason: collision with root package name */
    private float f7416s;

    /* renamed from: t, reason: collision with root package name */
    private float f7417t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f7418u;

    /* renamed from: v, reason: collision with root package name */
    int f7419v;

    /* renamed from: w, reason: collision with root package name */
    int f7420w;

    /* renamed from: x, reason: collision with root package name */
    int f7421x;

    /* renamed from: y, reason: collision with root package name */
    RectF f7422y;

    /* renamed from: z, reason: collision with root package name */
    RectF f7423z;

    /* loaded from: classes.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static SparseIntArray f7424a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f7424a = sparseIntArray;
            sparseIntArray.append(R$styleable.KeyTrigger_framePosition, 8);
            f7424a.append(R$styleable.KeyTrigger_onCross, 4);
            f7424a.append(R$styleable.KeyTrigger_onNegativeCross, 1);
            f7424a.append(R$styleable.KeyTrigger_onPositiveCross, 2);
            f7424a.append(R$styleable.KeyTrigger_motionTarget, 7);
            f7424a.append(R$styleable.KeyTrigger_triggerId, 6);
            f7424a.append(R$styleable.KeyTrigger_triggerSlack, 5);
            f7424a.append(R$styleable.KeyTrigger_motion_triggerOnCollision, 9);
            f7424a.append(R$styleable.KeyTrigger_motion_postLayoutCollision, 10);
            f7424a.append(R$styleable.KeyTrigger_triggerReceiver, 11);
            f7424a.append(R$styleable.KeyTrigger_viewTransitionOnCross, 12);
            f7424a.append(R$styleable.KeyTrigger_viewTransitionOnNegativeCross, 13);
            f7424a.append(R$styleable.KeyTrigger_viewTransitionOnPositiveCross, 14);
        }

        public static void a(k kVar, TypedArray typedArray, Context context) {
            int indexCount = typedArray.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArray.getIndex(i11);
                switch (f7424a.get(index)) {
                    case 1:
                        kVar.f7407j = typedArray.getString(index);
                        break;
                    case 2:
                        kVar.f7408k = typedArray.getString(index);
                        break;
                    case 3:
                    default:
                        Log.e("KeyTrigger", "unused attribute 0x" + Integer.toHexString(index) + "   " + f7424a.get(index));
                        break;
                    case 4:
                        kVar.f7405h = typedArray.getString(index);
                        break;
                    case 5:
                        kVar.f7412o = typedArray.getFloat(index, kVar.f7412o);
                        break;
                    case 6:
                        kVar.f7409l = typedArray.getResourceId(index, kVar.f7409l);
                        break;
                    case 7:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, kVar.f7326b);
                            kVar.f7326b = resourceId;
                            if (resourceId == -1) {
                                kVar.f7327c = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            kVar.f7327c = typedArray.getString(index);
                            break;
                        } else {
                            kVar.f7326b = typedArray.getResourceId(index, kVar.f7326b);
                            break;
                        }
                    case 8:
                        int integer = typedArray.getInteger(index, kVar.f7325a);
                        kVar.f7325a = integer;
                        kVar.f7416s = (integer + 0.5f) / 100.0f;
                        break;
                    case 9:
                        kVar.f7410m = typedArray.getResourceId(index, kVar.f7410m);
                        break;
                    case 10:
                        kVar.f7418u = typedArray.getBoolean(index, kVar.f7418u);
                        break;
                    case 11:
                        kVar.f7406i = typedArray.getResourceId(index, kVar.f7406i);
                        break;
                    case 12:
                        kVar.f7421x = typedArray.getResourceId(index, kVar.f7421x);
                        break;
                    case 13:
                        kVar.f7419v = typedArray.getResourceId(index, kVar.f7419v);
                        break;
                    case 14:
                        kVar.f7420w = typedArray.getResourceId(index, kVar.f7420w);
                        break;
                }
            }
        }
    }

    public k() {
        int i11 = d.f7324f;
        this.f7406i = i11;
        this.f7407j = null;
        this.f7408k = null;
        this.f7409l = i11;
        this.f7410m = i11;
        this.f7411n = null;
        this.f7412o = 0.1f;
        this.f7413p = true;
        this.f7414q = true;
        this.f7415r = true;
        this.f7416s = Float.NaN;
        this.f7418u = false;
        this.f7419v = i11;
        this.f7420w = i11;
        this.f7421x = i11;
        this.f7422y = new RectF();
        this.f7423z = new RectF();
        this.A = new HashMap();
        this.f7328d = 5;
        this.f7329e = new HashMap();
    }

    private void A(String str, View view) {
        boolean z10 = str.length() == 1;
        if (!z10) {
            str = str.substring(1).toLowerCase(Locale.ROOT);
        }
        for (String str2 : this.f7329e.keySet()) {
            String lowerCase = str2.toLowerCase(Locale.ROOT);
            if (z10 || lowerCase.matches(str)) {
                ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.f7329e.get(str2);
                if (constraintAttribute != null) {
                    constraintAttribute.a(view);
                }
            }
        }
    }

    private void B(RectF rectF, View view, boolean z10) {
        rectF.top = view.getTop();
        rectF.bottom = view.getBottom();
        rectF.left = view.getLeft();
        rectF.right = view.getRight();
        if (z10) {
            view.getMatrix().mapRect(rectF);
        }
    }

    private void z(String str, View view) {
        Method method;
        if (str == null) {
            return;
        }
        if (str.startsWith(".")) {
            A(str, view);
            return;
        }
        if (this.A.containsKey(str)) {
            method = (Method) this.A.get(str);
            if (method == null) {
                return;
            }
        } else {
            method = null;
        }
        if (method == null) {
            try {
                method = view.getClass().getMethod(str, null);
                this.A.put(str, method);
            } catch (NoSuchMethodException unused) {
                this.A.put(str, null);
                Log.e("KeyTrigger", "Could not find method \"" + str + "\"on class " + view.getClass().getSimpleName() + " " + androidx.constraintlayout.motion.widget.a.d(view));
                return;
            }
        }
        try {
            method.invoke(view, null);
        } catch (Exception unused2) {
            Log.e("KeyTrigger", "Exception in call \"" + this.f7405h + "\"on class " + view.getClass().getSimpleName() + " " + androidx.constraintlayout.motion.widget.a.d(view));
        }
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void a(HashMap hashMap) {
    }

    @Override // androidx.constraintlayout.motion.widget.d
    /* renamed from: b */
    public d clone() {
        return new k().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public d c(d dVar) {
        super.c(dVar);
        k kVar = (k) dVar;
        this.f7404g = kVar.f7404g;
        this.f7405h = kVar.f7405h;
        this.f7406i = kVar.f7406i;
        this.f7407j = kVar.f7407j;
        this.f7408k = kVar.f7408k;
        this.f7409l = kVar.f7409l;
        this.f7410m = kVar.f7410m;
        this.f7411n = kVar.f7411n;
        this.f7412o = kVar.f7412o;
        this.f7413p = kVar.f7413p;
        this.f7414q = kVar.f7414q;
        this.f7415r = kVar.f7415r;
        this.f7416s = kVar.f7416s;
        this.f7417t = kVar.f7417t;
        this.f7418u = kVar.f7418u;
        this.f7422y = kVar.f7422y;
        this.f7423z = kVar.f7423z;
        this.A = kVar.A;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void d(HashSet hashSet) {
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void e(Context context, AttributeSet attributeSet) {
        a.a(this, context.obtainStyledAttributes(attributeSet, R$styleable.KeyTrigger), context);
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void y(float r10, android.view.View r11) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.k.y(float, android.view.View):void");
    }
}
