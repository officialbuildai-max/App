package nl;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final C0879a f70602c = new C0879a(null);

    /* renamed from: d, reason: collision with root package name */
    public static final int f70603d = 8;

    /* renamed from: a, reason: collision with root package name */
    private final ImageView f70604a;

    /* renamed from: b, reason: collision with root package name */
    private final View f70605b;

    /* renamed from: nl.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0879a {
        private C0879a() {
        }

        public /* synthetic */ C0879a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(ImageView imageView, View view) {
        this.f70604a = imageView;
        this.f70605b = view;
    }

    private final int b(int i11, float f11) {
        return (i11 & 16777215) | (((int) (RangesKt.l(f11, 0.0f, 1.0f) * 255)) << 24);
    }

    public final void a(Integer num) {
        View view = this.f70605b;
        if (view == null || num == null) {
            return;
        }
        view.setBackground(il.a.b(new int[]{num.intValue(), num.intValue(), b(num.intValue(), 0.3f)}, GradientDrawable.Orientation.LEFT_RIGHT));
    }
}
