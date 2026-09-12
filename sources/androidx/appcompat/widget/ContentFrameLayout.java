package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private TypedValue f1818a;

    /* renamed from: b, reason: collision with root package name */
    private TypedValue f1819b;

    /* renamed from: c, reason: collision with root package name */
    private TypedValue f1820c;

    /* renamed from: d, reason: collision with root package name */
    private TypedValue f1821d;

    /* renamed from: e, reason: collision with root package name */
    private TypedValue f1822e;

    /* renamed from: f, reason: collision with root package name */
    private TypedValue f1823f;

    /* renamed from: g, reason: collision with root package name */
    private final Rect f1824g;

    /* renamed from: h, reason: collision with root package name */
    private a f1825h;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public ContentFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f1824g = new Rect();
    }

    public void dispatchFitSystemWindows(Rect rect) {
        fitSystemWindows(rect);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f1822e == null) {
            this.f1822e = new TypedValue();
        }
        return this.f1822e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f1823f == null) {
            this.f1823f = new TypedValue();
        }
        return this.f1823f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f1820c == null) {
            this.f1820c = new TypedValue();
        }
        return this.f1820c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f1821d == null) {
            this.f1821d = new TypedValue();
        }
        return this.f1821d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f1818a == null) {
            this.f1818a = new TypedValue();
        }
        return this.f1818a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f1819b == null) {
            this.f1819b = new TypedValue();
        }
        return this.f1819b;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f1825h;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f1825h;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ae  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(a aVar) {
        this.f1825h = aVar;
    }

    public void setDecorPadding(int i11, int i12, int i13, int i14) {
        this.f1824g.set(i11, i12, i13, i14);
        if (isLaidOut()) {
            requestLayout();
        }
    }
}
