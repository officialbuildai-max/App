package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;

/* loaded from: classes.dex */
public class h extends i {

    /* renamed from: h, reason: collision with root package name */
    String f7371h = null;

    /* renamed from: i, reason: collision with root package name */
    int f7372i = d.f7324f;

    /* renamed from: j, reason: collision with root package name */
    int f7373j = 0;

    /* renamed from: k, reason: collision with root package name */
    float f7374k = Float.NaN;

    /* renamed from: l, reason: collision with root package name */
    float f7375l = Float.NaN;

    /* renamed from: m, reason: collision with root package name */
    float f7376m = Float.NaN;

    /* renamed from: n, reason: collision with root package name */
    float f7377n = Float.NaN;

    /* renamed from: o, reason: collision with root package name */
    float f7378o = Float.NaN;

    /* renamed from: p, reason: collision with root package name */
    float f7379p = Float.NaN;

    /* renamed from: q, reason: collision with root package name */
    int f7380q = 0;

    /* renamed from: r, reason: collision with root package name */
    private float f7381r = Float.NaN;

    /* renamed from: s, reason: collision with root package name */
    private float f7382s = Float.NaN;

    /* loaded from: classes.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static SparseIntArray f7383a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f7383a = sparseIntArray;
            sparseIntArray.append(R$styleable.KeyPosition_motionTarget, 1);
            f7383a.append(R$styleable.KeyPosition_framePosition, 2);
            f7383a.append(R$styleable.KeyPosition_transitionEasing, 3);
            f7383a.append(R$styleable.KeyPosition_curveFit, 4);
            f7383a.append(R$styleable.KeyPosition_drawPath, 5);
            f7383a.append(R$styleable.KeyPosition_percentX, 6);
            f7383a.append(R$styleable.KeyPosition_percentY, 7);
            f7383a.append(R$styleable.KeyPosition_keyPositionType, 9);
            f7383a.append(R$styleable.KeyPosition_sizePercent, 8);
            f7383a.append(R$styleable.KeyPosition_percentWidth, 11);
            f7383a.append(R$styleable.KeyPosition_percentHeight, 12);
            f7383a.append(R$styleable.KeyPosition_pathMotionArc, 10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(h hVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArray.getIndex(i11);
                switch (f7383a.get(index)) {
                    case 1:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, hVar.f7326b);
                            hVar.f7326b = resourceId;
                            if (resourceId == -1) {
                                hVar.f7327c = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            hVar.f7327c = typedArray.getString(index);
                            break;
                        } else {
                            hVar.f7326b = typedArray.getResourceId(index, hVar.f7326b);
                            break;
                        }
                    case 2:
                        hVar.f7325a = typedArray.getInt(index, hVar.f7325a);
                        break;
                    case 3:
                        if (typedArray.peekValue(index).type == 3) {
                            hVar.f7371h = typedArray.getString(index);
                            break;
                        } else {
                            hVar.f7371h = androidx.constraintlayout.core.motion.utils.c.f6843c[typedArray.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        hVar.f7384g = typedArray.getInteger(index, hVar.f7384g);
                        break;
                    case 5:
                        hVar.f7373j = typedArray.getInt(index, hVar.f7373j);
                        break;
                    case 6:
                        hVar.f7376m = typedArray.getFloat(index, hVar.f7376m);
                        break;
                    case 7:
                        hVar.f7377n = typedArray.getFloat(index, hVar.f7377n);
                        break;
                    case 8:
                        float f11 = typedArray.getFloat(index, hVar.f7375l);
                        hVar.f7374k = f11;
                        hVar.f7375l = f11;
                        break;
                    case 9:
                        hVar.f7380q = typedArray.getInt(index, hVar.f7380q);
                        break;
                    case 10:
                        hVar.f7372i = typedArray.getInt(index, hVar.f7372i);
                        break;
                    case 11:
                        hVar.f7374k = typedArray.getFloat(index, hVar.f7374k);
                        break;
                    case 12:
                        hVar.f7375l = typedArray.getFloat(index, hVar.f7375l);
                        break;
                    default:
                        Log.e("KeyPosition", "unused attribute 0x" + Integer.toHexString(index) + "   " + f7383a.get(index));
                        break;
                }
            }
            if (hVar.f7325a == -1) {
                Log.e("KeyPosition", "no frame position");
            }
        }
    }

    public h() {
        this.f7328d = 2;
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void a(HashMap hashMap) {
    }

    @Override // androidx.constraintlayout.motion.widget.d
    /* renamed from: b */
    public d clone() {
        return new h().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public d c(d dVar) {
        super.c(dVar);
        h hVar = (h) dVar;
        this.f7371h = hVar.f7371h;
        this.f7372i = hVar.f7372i;
        this.f7373j = hVar.f7373j;
        this.f7374k = hVar.f7374k;
        this.f7375l = Float.NaN;
        this.f7376m = hVar.f7376m;
        this.f7377n = hVar.f7377n;
        this.f7378o = hVar.f7378o;
        this.f7379p = hVar.f7379p;
        this.f7381r = hVar.f7381r;
        this.f7382s = hVar.f7382s;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void e(Context context, AttributeSet attributeSet) {
        a.b(this, context.obtainStyledAttributes(attributeSet, R$styleable.KeyPosition));
    }

    public void m(int i11) {
        this.f7380q = i11;
    }

    public void n(String str, Object obj) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1127236479:
                if (str.equals("percentWidth")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1017587252:
                if (str.equals("percentHeight")) {
                    c11 = 2;
                    break;
                }
                break;
            case -827014263:
                if (str.equals("drawPath")) {
                    c11 = 3;
                    break;
                }
                break;
            case -200259324:
                if (str.equals("sizePercent")) {
                    c11 = 4;
                    break;
                }
                break;
            case 428090547:
                if (str.equals("percentX")) {
                    c11 = 5;
                    break;
                }
                break;
            case 428090548:
                if (str.equals("percentY")) {
                    c11 = 6;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                this.f7371h = obj.toString();
                return;
            case 1:
                this.f7374k = k(obj);
                return;
            case 2:
                this.f7375l = k(obj);
                return;
            case 3:
                this.f7373j = l(obj);
                return;
            case 4:
                float k11 = k(obj);
                this.f7374k = k11;
                this.f7375l = k11;
                return;
            case 5:
                this.f7376m = k(obj);
                return;
            case 6:
                this.f7377n = k(obj);
                return;
            default:
                return;
        }
    }
}
