package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p {

    /* renamed from: l, reason: collision with root package name */
    private static final RectF f2160l = new RectF();

    /* renamed from: m, reason: collision with root package name */
    private static ConcurrentHashMap f2161m = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    private int f2162a = 0;

    /* renamed from: b, reason: collision with root package name */
    private boolean f2163b = false;

    /* renamed from: c, reason: collision with root package name */
    private float f2164c = -1.0f;

    /* renamed from: d, reason: collision with root package name */
    private float f2165d = -1.0f;

    /* renamed from: e, reason: collision with root package name */
    private float f2166e = -1.0f;

    /* renamed from: f, reason: collision with root package name */
    private int[] f2167f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    private boolean f2168g = false;

    /* renamed from: h, reason: collision with root package name */
    private TextPaint f2169h;

    /* renamed from: i, reason: collision with root package name */
    private final TextView f2170i;

    /* renamed from: j, reason: collision with root package name */
    private final Context f2171j;

    /* renamed from: k, reason: collision with root package name */
    private final d f2172k;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {
        @NonNull
        static StaticLayout a(@NonNull CharSequence charSequence, @NonNull Layout.Alignment alignment, int i11, int i12, @NonNull TextView textView, @NonNull TextPaint textPaint, @NonNull d dVar) {
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i11);
            StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (i12 == -1) {
                i12 = Integer.MAX_VALUE;
            }
            hyphenationFrequency.setMaxLines(i12);
            try {
                dVar.a(obtain, textView);
            } catch (ClassCastException unused) {
                Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            return obtain.build();
        }
    }

    /* loaded from: classes.dex */
    private static class b extends d {
        b() {
        }

        @Override // androidx.appcompat.widget.p.d
        void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) p.m(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    /* loaded from: classes.dex */
    private static class c extends b {
        c() {
        }

        @Override // androidx.appcompat.widget.p.b, androidx.appcompat.widget.p.d
        void a(StaticLayout.Builder builder, TextView textView) {
            TextDirectionHeuristic textDirectionHeuristic;
            textDirectionHeuristic = textView.getTextDirectionHeuristic();
            builder.setTextDirection(textDirectionHeuristic);
        }

        @Override // androidx.appcompat.widget.p.d
        boolean b(TextView textView) {
            boolean isHorizontallyScrollable;
            isHorizontallyScrollable = textView.isHorizontallyScrollable();
            return isHorizontallyScrollable;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {
        d() {
        }

        abstract void a(StaticLayout.Builder builder, TextView textView);

        boolean b(TextView textView) {
            return ((Boolean) p.m(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TextView textView) {
        this.f2170i = textView;
        this.f2171j = textView.getContext();
        if (Build.VERSION.SDK_INT >= 29) {
            this.f2172k = new c();
        } else {
            this.f2172k = new b();
        }
    }

    private int[] b(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i11 : iArr) {
            if (i11 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i11)) < 0) {
                arrayList.add(Integer.valueOf(i11));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i12 = 0; i12 < size; i12++) {
            iArr2[i12] = ((Integer) arrayList.get(i12)).intValue();
        }
        return iArr2;
    }

    private void c() {
        this.f2162a = 0;
        this.f2165d = -1.0f;
        this.f2166e = -1.0f;
        this.f2164c = -1.0f;
        this.f2167f = new int[0];
        this.f2163b = false;
    }

    private int e(RectF rectF) {
        int length = this.f2167f.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i11 = 1;
        int i12 = length - 1;
        int i13 = 0;
        while (i11 <= i12) {
            int i14 = (i11 + i12) / 2;
            if (x(this.f2167f[i14], rectF)) {
                int i15 = i14 + 1;
                i13 = i11;
                i11 = i15;
            } else {
                i13 = i14 - 1;
                i12 = i13;
            }
        }
        return this.f2167f[i13];
    }

    private static Method k(String str) {
        try {
            Method method = (Method) f2161m.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, null)) != null) {
                method.setAccessible(true);
                f2161m.put(str, method);
            }
            return method;
        } catch (Exception e11) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e11);
            return null;
        }
    }

    static Object m(Object obj, String str, Object obj2) {
        try {
            return k(str).invoke(obj, null);
        } catch (Exception e11) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e11);
            return obj2;
        }
    }

    private void s(float f11) {
        if (f11 != this.f2170i.getPaint().getTextSize()) {
            this.f2170i.getPaint().setTextSize(f11);
            boolean isInLayout = this.f2170i.isInLayout();
            if (this.f2170i.getLayout() != null) {
                this.f2163b = false;
                try {
                    Method k11 = k("nullLayouts");
                    if (k11 != null) {
                        k11.invoke(this.f2170i, null);
                    }
                } catch (Exception e11) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e11);
                }
                if (isInLayout) {
                    this.f2170i.forceLayout();
                } else {
                    this.f2170i.requestLayout();
                }
                this.f2170i.invalidate();
            }
        }
    }

    private boolean u() {
        if (y() && this.f2162a == 1) {
            if (!this.f2168g || this.f2167f.length == 0) {
                int floor = ((int) Math.floor((this.f2166e - this.f2165d) / this.f2164c)) + 1;
                int[] iArr = new int[floor];
                for (int i11 = 0; i11 < floor; i11++) {
                    iArr[i11] = Math.round(this.f2165d + (i11 * this.f2164c));
                }
                this.f2167f = b(iArr);
            }
            this.f2163b = true;
        } else {
            this.f2163b = false;
        }
        return this.f2163b;
    }

    private void v(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i11 = 0; i11 < length; i11++) {
                iArr[i11] = typedArray.getDimensionPixelSize(i11, -1);
            }
            this.f2167f = b(iArr);
            w();
        }
    }

    private boolean w() {
        boolean z10 = this.f2167f.length > 0;
        this.f2168g = z10;
        if (z10) {
            this.f2162a = 1;
            this.f2165d = r0[0];
            this.f2166e = r0[r1 - 1];
            this.f2164c = -1.0f;
        }
        return z10;
    }

    private boolean x(int i11, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f2170i.getText();
        TransformationMethod transformationMethod = this.f2170i.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f2170i)) != null) {
            text = transformation;
        }
        int maxLines = this.f2170i.getMaxLines();
        l(i11);
        StaticLayout d11 = d(text, (Layout.Alignment) m(this.f2170i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (d11.getLineCount() <= maxLines && d11.getLineEnd(d11.getLineCount() - 1) == text.length())) && ((float) d11.getHeight()) <= rectF.bottom;
    }

    private boolean y() {
        return !(this.f2170i instanceof AppCompatEditText);
    }

    private void z(float f11, float f12, float f13) {
        if (f11 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f11 + "px) is less or equal to (0px)");
        }
        if (f12 <= f11) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f12 + "px) is less or equal to minimum auto-size text size (" + f11 + "px)");
        }
        if (f13 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f13 + "px) is less or equal to (0px)");
        }
        this.f2162a = 1;
        this.f2165d = f11;
        this.f2166e = f12;
        this.f2164c = f13;
        this.f2168g = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (n()) {
            if (this.f2163b) {
                if (this.f2170i.getMeasuredHeight() <= 0 || this.f2170i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f2172k.b(this.f2170i) ? 1048576 : (this.f2170i.getMeasuredWidth() - this.f2170i.getTotalPaddingLeft()) - this.f2170i.getTotalPaddingRight();
                int height = (this.f2170i.getHeight() - this.f2170i.getCompoundPaddingBottom()) - this.f2170i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f2160l;
                synchronized (rectF) {
                    try {
                        rectF.setEmpty();
                        rectF.right = measuredWidth;
                        rectF.bottom = height;
                        float e11 = e(rectF);
                        if (e11 != this.f2170i.getTextSize()) {
                            t(0, e11);
                        }
                    } finally {
                    }
                }
            }
            this.f2163b = true;
        }
    }

    StaticLayout d(CharSequence charSequence, Layout.Alignment alignment, int i11, int i12) {
        return a.a(charSequence, alignment, i11, i12, this.f2170i, this.f2169h, this.f2172k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return Math.round(this.f2166e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return Math.round(this.f2165d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return Math.round(this.f2164c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] i() {
        return this.f2167f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.f2162a;
    }

    void l(int i11) {
        TextPaint textPaint = this.f2169h;
        if (textPaint == null) {
            this.f2169h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f2169h.set(this.f2170i.getPaint());
        this.f2169h.setTextSize(i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n() {
        return y() && this.f2162a != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(AttributeSet attributeSet, int i11) {
        int resourceId;
        TypedArray obtainStyledAttributes = this.f2171j.obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView, i11, 0);
        TextView textView = this.f2170i;
        ViewCompat.saveAttributeDataForStyleable(textView, textView.getContext(), R$styleable.AppCompatTextView, attributeSet, obtainStyledAttributes, i11, 0);
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTextView_autoSizeTextType)) {
            this.f2162a = obtainStyledAttributes.getInt(R$styleable.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = obtainStyledAttributes.hasValue(R$styleable.AppCompatTextView_autoSizeStepGranularity) ? obtainStyledAttributes.getDimension(R$styleable.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = obtainStyledAttributes.hasValue(R$styleable.AppCompatTextView_autoSizeMinTextSize) ? obtainStyledAttributes.getDimension(R$styleable.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = obtainStyledAttributes.hasValue(R$styleable.AppCompatTextView_autoSizeMaxTextSize) ? obtainStyledAttributes.getDimension(R$styleable.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTextView_autoSizePresetSizes) && (resourceId = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTextView_autoSizePresetSizes, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            v(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (!y()) {
            this.f2162a = 0;
            return;
        }
        if (this.f2162a == 1) {
            if (!this.f2168g) {
                DisplayMetrics displayMetrics = this.f2171j.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                z(dimension2, dimension3, dimension);
            }
            u();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(int i11, int i12, int i13, int i14) {
        if (y()) {
            DisplayMetrics displayMetrics = this.f2171j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(i14, i11, displayMetrics), TypedValue.applyDimension(i14, i12, displayMetrics), TypedValue.applyDimension(i14, i13, displayMetrics));
            if (u()) {
                a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(int[] iArr, int i11) {
        if (y()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i11 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f2171j.getResources().getDisplayMetrics();
                    for (int i12 = 0; i12 < length; i12++) {
                        iArr2[i12] = Math.round(TypedValue.applyDimension(i11, iArr[i12], displayMetrics));
                    }
                }
                this.f2167f = b(iArr2);
                if (!w()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f2168g = false;
            }
            if (u()) {
                a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(int i11) {
        if (y()) {
            if (i11 == 0) {
                c();
                return;
            }
            if (i11 != 1) {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i11);
            }
            DisplayMetrics displayMetrics = this.f2171j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (u()) {
                a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int i11, float f11) {
        Context context = this.f2171j;
        s(TypedValue.applyDimension(i11, f11, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }
}
