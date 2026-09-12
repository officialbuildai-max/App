package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.b;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class ConstraintHelper extends View {

    /* renamed from: a, reason: collision with root package name */
    protected int[] f7727a;

    /* renamed from: b, reason: collision with root package name */
    protected int f7728b;

    /* renamed from: c, reason: collision with root package name */
    protected Context f7729c;

    /* renamed from: d, reason: collision with root package name */
    protected t0.a f7730d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f7731e;

    /* renamed from: f, reason: collision with root package name */
    protected String f7732f;

    /* renamed from: g, reason: collision with root package name */
    protected String f7733g;

    /* renamed from: h, reason: collision with root package name */
    private View[] f7734h;

    /* renamed from: i, reason: collision with root package name */
    protected HashMap f7735i;

    public ConstraintHelper(Context context) {
        super(context);
        this.f7727a = new int[32];
        this.f7731e = false;
        this.f7734h = null;
        this.f7735i = new HashMap();
        this.f7729c = context;
        k(null);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7727a = new int[32];
        this.f7731e = false;
        this.f7734h = null;
        this.f7735i = new HashMap();
        this.f7729c = context;
        k(attributeSet);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f7727a = new int[32];
        this.f7731e = false;
        this.f7734h = null;
        this.f7735i = new HashMap();
        this.f7729c = context;
        k(attributeSet);
    }

    private void a(String str) {
        if (str == null || str.length() == 0 || this.f7729c == null) {
            return;
        }
        String trim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
        }
        int i11 = i(trim);
        if (i11 != 0) {
            this.f7735i.put(Integer.valueOf(i11), trim);
            b(i11);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
    }

    private void b(int i11) {
        if (i11 == getId()) {
            return;
        }
        int i12 = this.f7728b + 1;
        int[] iArr = this.f7727a;
        if (i12 > iArr.length) {
            this.f7727a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f7727a;
        int i13 = this.f7728b;
        iArr2[i13] = i11;
        this.f7728b = i13 + 1;
    }

    private void c(String str) {
        if (str == null || str.length() == 0 || this.f7729c == null) {
            return;
        }
        String trim = str.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = constraintLayout.getChildAt(i11);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof ConstraintLayout.b) && trim.equals(((ConstraintLayout.b) layoutParams).f7742c0)) {
                if (childAt.getId() == -1) {
                    Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                } else {
                    b(childAt.getId());
                }
            }
        }
    }

    private int[] g(View view, String str) {
        String[] split = str.split(",");
        view.getContext();
        int[] iArr = new int[split.length];
        int i11 = 0;
        for (String str2 : split) {
            int i12 = i(str2.trim());
            if (i12 != 0) {
                iArr[i11] = i12;
                i11++;
            }
        }
        return i11 != split.length ? Arrays.copyOf(iArr, i11) : iArr;
    }

    private int h(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String str2;
        if (str == null || constraintLayout == null || (resources = this.f7729c.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = constraintLayout.getChildAt(i11);
            if (childAt.getId() != -1) {
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                    str2 = null;
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    private int i(String str) {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int i11 = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object designInformation = constraintLayout.getDesignInformation(0, str);
            if (designInformation instanceof Integer) {
                i11 = ((Integer) designInformation).intValue();
            }
        }
        if (i11 == 0 && constraintLayout != null) {
            i11 = h(constraintLayout, str);
        }
        if (i11 == 0) {
            try {
                i11 = R$id.class.getField(str).getInt(null);
            } catch (Exception unused) {
            }
        }
        return i11 == 0 ? this.f7729c.getResources().getIdentifier(str, "id", this.f7729c.getPackageName()) : i11;
    }

    public void addView(View view) {
        if (view == this) {
            return;
        }
        if (view.getId() == -1) {
            Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have an id");
        } else {
            if (view.getParent() == null) {
                Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have a parent");
                return;
            }
            this.f7732f = null;
            b(view.getId());
            requestLayout();
        }
    }

    public boolean containsId(int i11) {
        for (int i12 : this.f7727a) {
            if (i12 == i11) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        e((ConstraintLayout) parent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i11 = 0; i11 < this.f7728b; i11++) {
            View viewById = constraintLayout.getViewById(this.f7727a[i11]);
            if (viewById != null) {
                viewById.setVisibility(visibility);
                if (elevation > 0.0f) {
                    viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(ConstraintLayout constraintLayout) {
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f7727a, this.f7728b);
    }

    public int indexFromId(int i11) {
        int i12 = -1;
        for (int i13 : this.f7727a) {
            i12++;
            if (i13 == i11) {
                return i12;
            }
        }
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View[] j(ConstraintLayout constraintLayout) {
        View[] viewArr = this.f7734h;
        if (viewArr == null || viewArr.length != this.f7728b) {
            this.f7734h = new View[this.f7728b];
        }
        for (int i11 = 0; i11 < this.f7728b; i11++) {
            this.f7734h[i11] = constraintLayout.getViewById(this.f7727a[i11]);
        }
        return this.f7734h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f7732f = string;
                    setIds(string);
                } else if (index == R$styleable.ConstraintLayout_Layout_constraint_referenced_tags) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.f7733g = string2;
                    setReferenceTags(string2);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void loadParameters(b.a aVar, t0.b bVar, ConstraintLayout.b bVar2, SparseArray<ConstraintWidget> sparseArray) {
        b.C0064b c0064b = aVar.f7842e;
        int[] iArr = c0064b.f7880k0;
        if (iArr != null) {
            setReferencedIds(iArr);
        } else {
            String str = c0064b.f7882l0;
            if (str != null) {
                if (str.length() > 0) {
                    b.C0064b c0064b2 = aVar.f7842e;
                    c0064b2.f7880k0 = g(this, c0064b2.f7882l0);
                } else {
                    aVar.f7842e.f7880k0 = null;
                }
            }
        }
        if (bVar == null) {
            return;
        }
        bVar.b();
        if (aVar.f7842e.f7880k0 == null) {
            return;
        }
        int i11 = 0;
        while (true) {
            int[] iArr2 = aVar.f7842e.f7880k0;
            if (i11 >= iArr2.length) {
                return;
            }
            ConstraintWidget constraintWidget = sparseArray.get(iArr2[i11]);
            if (constraintWidget != null) {
                bVar.a(constraintWidget);
            }
            i11++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f7732f;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f7733g;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int i11, int i12) {
        if (this.f7731e) {
            super.onMeasure(i11, i12);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public int removeView(View view) {
        int i11;
        int id2 = view.getId();
        int i12 = -1;
        if (id2 == -1) {
            return -1;
        }
        this.f7732f = null;
        int i13 = 0;
        while (true) {
            if (i13 >= this.f7728b) {
                break;
            }
            if (this.f7727a[i13] == id2) {
                int i14 = i13;
                while (true) {
                    i11 = this.f7728b;
                    if (i14 >= i11 - 1) {
                        break;
                    }
                    int[] iArr = this.f7727a;
                    int i15 = i14 + 1;
                    iArr[i14] = iArr[i15];
                    i14 = i15;
                }
                this.f7727a[i11 - 1] = 0;
                this.f7728b = i11 - 1;
                i12 = i13;
            } else {
                i13++;
            }
        }
        requestLayout();
        return i12;
    }

    public void resolveRtl(ConstraintWidget constraintWidget, boolean z10) {
    }

    protected void setIds(String str) {
        this.f7732f = str;
        if (str == null) {
            return;
        }
        int i11 = 0;
        this.f7728b = 0;
        while (true) {
            int indexOf = str.indexOf(44, i11);
            if (indexOf == -1) {
                a(str.substring(i11));
                return;
            } else {
                a(str.substring(i11, indexOf));
                i11 = indexOf + 1;
            }
        }
    }

    protected void setReferenceTags(String str) {
        this.f7733g = str;
        if (str == null) {
            return;
        }
        int i11 = 0;
        this.f7728b = 0;
        while (true) {
            int indexOf = str.indexOf(44, i11);
            if (indexOf == -1) {
                c(str.substring(i11));
                return;
            } else {
                c(str.substring(i11, indexOf));
                i11 = indexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f7732f = null;
        this.f7728b = 0;
        for (int i11 : iArr) {
            b(i11);
        }
    }

    @Override // android.view.View
    public void setTag(int i11, Object obj) {
        super.setTag(i11, obj);
        if (obj == null && this.f7732f == null) {
            b(i11);
        }
    }

    public void updatePostConstraints(ConstraintLayout constraintLayout) {
    }

    public void updatePostLayout(ConstraintLayout constraintLayout) {
    }

    public void updatePostMeasure(ConstraintLayout constraintLayout) {
    }

    public void updatePreDraw(ConstraintLayout constraintLayout) {
    }

    public void updatePreLayout(androidx.constraintlayout.core.widgets.d dVar, t0.a aVar, SparseArray<ConstraintWidget> sparseArray) {
        aVar.b();
        for (int i11 = 0; i11 < this.f7728b; i11++) {
            aVar.a(sparseArray.get(this.f7727a[i11]));
        }
    }

    public void updatePreLayout(ConstraintLayout constraintLayout) {
        String str;
        int h11;
        if (isInEditMode()) {
            setIds(this.f7732f);
        }
        t0.a aVar = this.f7730d;
        if (aVar == null) {
            return;
        }
        aVar.b();
        for (int i11 = 0; i11 < this.f7728b; i11++) {
            int i12 = this.f7727a[i11];
            View viewById = constraintLayout.getViewById(i12);
            if (viewById == null && (h11 = h(constraintLayout, (str = (String) this.f7735i.get(Integer.valueOf(i12))))) != 0) {
                this.f7727a[i11] = h11;
                this.f7735i.put(Integer.valueOf(h11), str);
                viewById = constraintLayout.getViewById(h11);
            }
            if (viewById != null) {
                this.f7730d.a(constraintLayout.getViewWidget(viewById));
            }
        }
        this.f7730d.c(constraintLayout.mLayoutWidget);
    }

    public void validateParams() {
        if (this.f7730d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.b) {
            ((ConstraintLayout.b) layoutParams).f7780v0 = (ConstraintWidget) this.f7730d;
        }
    }
}
