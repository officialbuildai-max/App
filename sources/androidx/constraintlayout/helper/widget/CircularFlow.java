package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import androidx.constraintlayout.widget.VirtualLayout;
import androidx.constraintlayout.widget.b;
import java.util.Arrays;

/* loaded from: classes.dex */
public class CircularFlow extends VirtualLayout {

    /* renamed from: v, reason: collision with root package name */
    private static int f7178v;

    /* renamed from: w, reason: collision with root package name */
    private static float f7179w;

    /* renamed from: l, reason: collision with root package name */
    ConstraintLayout f7180l;

    /* renamed from: m, reason: collision with root package name */
    int f7181m;

    /* renamed from: n, reason: collision with root package name */
    private float[] f7182n;

    /* renamed from: o, reason: collision with root package name */
    private int[] f7183o;

    /* renamed from: p, reason: collision with root package name */
    private int f7184p;

    /* renamed from: q, reason: collision with root package name */
    private int f7185q;

    /* renamed from: r, reason: collision with root package name */
    private String f7186r;

    /* renamed from: s, reason: collision with root package name */
    private String f7187s;

    /* renamed from: t, reason: collision with root package name */
    private Float f7188t;

    /* renamed from: u, reason: collision with root package name */
    private Integer f7189u;

    public CircularFlow(Context context) {
        super(context);
    }

    public CircularFlow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CircularFlow(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    private void l(String str) {
        float[] fArr;
        if (str == null || str.length() == 0 || this.f7729c == null || (fArr = this.f7182n) == null) {
            return;
        }
        if (this.f7185q + 1 > fArr.length) {
            this.f7182n = Arrays.copyOf(fArr, fArr.length + 1);
        }
        this.f7182n[this.f7185q] = Integer.parseInt(str);
        this.f7185q++;
    }

    private void m(String str) {
        int[] iArr;
        if (str == null || str.length() == 0 || this.f7729c == null || (iArr = this.f7183o) == null) {
            return;
        }
        if (this.f7184p + 1 > iArr.length) {
            this.f7183o = Arrays.copyOf(iArr, iArr.length + 1);
        }
        this.f7183o[this.f7184p] = (int) (Integer.parseInt(str) * this.f7729c.getResources().getDisplayMetrics().density);
        this.f7184p++;
    }

    private void n() {
        this.f7180l = (ConstraintLayout) getParent();
        for (int i11 = 0; i11 < this.f7728b; i11++) {
            View viewById = this.f7180l.getViewById(this.f7727a[i11]);
            if (viewById != null) {
                int i12 = f7178v;
                float f11 = f7179w;
                int[] iArr = this.f7183o;
                if (iArr == null || i11 >= iArr.length) {
                    Integer num = this.f7189u;
                    if (num == null || num.intValue() == -1) {
                        Log.e("CircularFlow", "Added radius to view with id: " + ((String) this.f7735i.get(Integer.valueOf(viewById.getId()))));
                    } else {
                        this.f7184p++;
                        if (this.f7183o == null) {
                            this.f7183o = new int[1];
                        }
                        int[] radius = getRadius();
                        this.f7183o = radius;
                        radius[this.f7184p - 1] = i12;
                    }
                } else {
                    i12 = iArr[i11];
                }
                float[] fArr = this.f7182n;
                if (fArr == null || i11 >= fArr.length) {
                    Float f12 = this.f7188t;
                    if (f12 == null || f12.floatValue() == -1.0f) {
                        Log.e("CircularFlow", "Added angle to view with id: " + ((String) this.f7735i.get(Integer.valueOf(viewById.getId()))));
                    } else {
                        this.f7185q++;
                        if (this.f7182n == null) {
                            this.f7182n = new float[1];
                        }
                        float[] angles = getAngles();
                        this.f7182n = angles;
                        angles[this.f7185q - 1] = f11;
                    }
                } else {
                    f11 = fArr[i11];
                }
                ConstraintLayout.b bVar = (ConstraintLayout.b) viewById.getLayoutParams();
                bVar.f7771r = f11;
                bVar.f7767p = this.f7181m;
                bVar.f7769q = i12;
                viewById.setLayoutParams(bVar);
            }
        }
        d();
    }

    private float[] o(float[] fArr, int i11) {
        return (fArr == null || i11 < 0 || i11 >= this.f7185q) ? fArr : removeElementFromArray(fArr, i11);
    }

    private int[] p(int[] iArr, int i11) {
        return (iArr == null || i11 < 0 || i11 >= this.f7184p) ? iArr : removeElementFromArray(iArr, i11);
    }

    public static float[] removeElementFromArray(float[] fArr, int i11) {
        float[] fArr2 = new float[fArr.length - 1];
        int i12 = 0;
        for (int i13 = 0; i13 < fArr.length; i13++) {
            if (i13 != i11) {
                fArr2[i12] = fArr[i13];
                i12++;
            }
        }
        return fArr2;
    }

    public static int[] removeElementFromArray(int[] iArr, int i11) {
        int[] iArr2 = new int[iArr.length - 1];
        int i12 = 0;
        for (int i13 = 0; i13 < iArr.length; i13++) {
            if (i13 != i11) {
                iArr2[i12] = iArr[i13];
                i12++;
            }
        }
        return iArr2;
    }

    private void setAngles(String str) {
        if (str == null) {
            return;
        }
        int i11 = 0;
        this.f7185q = 0;
        while (true) {
            int indexOf = str.indexOf(44, i11);
            if (indexOf == -1) {
                l(str.substring(i11).trim());
                return;
            } else {
                l(str.substring(i11, indexOf).trim());
                i11 = indexOf + 1;
            }
        }
    }

    private void setRadius(String str) {
        if (str == null) {
            return;
        }
        int i11 = 0;
        this.f7184p = 0;
        while (true) {
            int indexOf = str.indexOf(44, i11);
            if (indexOf == -1) {
                m(str.substring(i11).trim());
                return;
            } else {
                m(str.substring(i11, indexOf).trim());
                i11 = indexOf + 1;
            }
        }
    }

    public void addViewToCircularFlow(View view, int i11, float f11) {
        if (containsId(view.getId())) {
            return;
        }
        addView(view);
        this.f7185q++;
        float[] angles = getAngles();
        this.f7182n = angles;
        angles[this.f7185q - 1] = f11;
        this.f7184p++;
        int[] radius = getRadius();
        this.f7183o = radius;
        radius[this.f7184p - 1] = (int) (i11 * this.f7729c.getResources().getDisplayMetrics().density);
        n();
    }

    public float[] getAngles() {
        return Arrays.copyOf(this.f7182n, this.f7185q);
    }

    public int[] getRadius() {
        return Arrays.copyOf(this.f7183o, this.f7184p);
    }

    public boolean isUpdatable(View view) {
        return containsId(view.getId()) && indexFromId(view.getId()) != -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public void k(AttributeSet attributeSet) {
        super.k(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.ConstraintLayout_Layout_circularflow_viewCenter) {
                    this.f7181m = obtainStyledAttributes.getResourceId(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_circularflow_angles) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f7186r = string;
                    setAngles(string);
                } else if (index == R$styleable.ConstraintLayout_Layout_circularflow_radiusInDP) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.f7187s = string2;
                    setRadius(string2);
                } else if (index == R$styleable.ConstraintLayout_Layout_circularflow_defaultAngle) {
                    Float valueOf = Float.valueOf(obtainStyledAttributes.getFloat(index, f7179w));
                    this.f7188t = valueOf;
                    setDefaultAngle(valueOf.floatValue());
                } else if (index == R$styleable.ConstraintLayout_Layout_circularflow_defaultRadius) {
                    Integer valueOf2 = Integer.valueOf(obtainStyledAttributes.getDimensionPixelSize(index, f7178v));
                    this.f7189u = valueOf2;
                    setDefaultRadius(valueOf2.intValue());
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f7186r;
        if (str != null) {
            this.f7182n = new float[1];
            setAngles(str);
        }
        String str2 = this.f7187s;
        if (str2 != null) {
            this.f7183o = new int[1];
            setRadius(str2);
        }
        Float f11 = this.f7188t;
        if (f11 != null) {
            setDefaultAngle(f11.floatValue());
        }
        Integer num = this.f7189u;
        if (num != null) {
            setDefaultRadius(num.intValue());
        }
        n();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public int removeView(View view) {
        int removeView = super.removeView(view);
        if (removeView == -1) {
            return removeView;
        }
        b bVar = new b();
        bVar.q(this.f7180l);
        bVar.o(view.getId(), 8);
        bVar.i(this.f7180l);
        float[] fArr = this.f7182n;
        if (removeView < fArr.length) {
            this.f7182n = o(fArr, removeView);
            this.f7185q--;
        }
        int[] iArr = this.f7183o;
        if (removeView < iArr.length) {
            this.f7183o = p(iArr, removeView);
            this.f7184p--;
        }
        n();
        return removeView;
    }

    public void setDefaultAngle(float f11) {
        f7179w = f11;
    }

    public void setDefaultRadius(int i11) {
        f7178v = i11;
    }

    public void updateAngle(View view, float f11) {
        if (!isUpdatable(view)) {
            Log.e("CircularFlow", "It was not possible to update angle to view with id: " + view.getId());
            return;
        }
        int indexFromId = indexFromId(view.getId());
        if (indexFromId > this.f7182n.length) {
            return;
        }
        float[] angles = getAngles();
        this.f7182n = angles;
        angles[indexFromId] = f11;
        n();
    }

    public void updateRadius(View view, int i11) {
        if (!isUpdatable(view)) {
            Log.e("CircularFlow", "It was not possible to update radius to view with id: " + view.getId());
            return;
        }
        int indexFromId = indexFromId(view.getId());
        if (indexFromId > this.f7183o.length) {
            return;
        }
        int[] radius = getRadius();
        this.f7183o = radius;
        radius[indexFromId] = (int) (i11 * this.f7729c.getResources().getDisplayMetrics().density);
        n();
    }

    public void updateReference(View view, int i11, float f11) {
        if (!isUpdatable(view)) {
            Log.e("CircularFlow", "It was not possible to update radius and angle to view with id: " + view.getId());
            return;
        }
        int indexFromId = indexFromId(view.getId());
        if (getAngles().length > indexFromId) {
            float[] angles = getAngles();
            this.f7182n = angles;
            angles[indexFromId] = f11;
        }
        if (getRadius().length > indexFromId) {
            int[] radius = getRadius();
            this.f7183o = radius;
            radius[indexFromId] = (int) (i11 * this.f7729c.getResources().getDisplayMetrics().density);
        }
        n();
    }
}
