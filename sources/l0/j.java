package l0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class j extends ReplacementSpan {

    /* renamed from: k, reason: collision with root package name */
    public static final a f68551k = new a(null);

    /* renamed from: l, reason: collision with root package name */
    public static final int f68552l = 8;

    /* renamed from: a, reason: collision with root package name */
    private final float f68553a;

    /* renamed from: b, reason: collision with root package name */
    private final int f68554b;

    /* renamed from: c, reason: collision with root package name */
    private final float f68555c;

    /* renamed from: d, reason: collision with root package name */
    private final int f68556d;

    /* renamed from: e, reason: collision with root package name */
    private final float f68557e;

    /* renamed from: f, reason: collision with root package name */
    private final int f68558f;

    /* renamed from: g, reason: collision with root package name */
    private Paint.FontMetricsInt f68559g;

    /* renamed from: h, reason: collision with root package name */
    private int f68560h;

    /* renamed from: i, reason: collision with root package name */
    private int f68561i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f68562j;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final Paint.FontMetricsInt a() {
        Paint.FontMetricsInt fontMetricsInt = this.f68559g;
        if (fontMetricsInt != null) {
            return fontMetricsInt;
        }
        Intrinsics.z("fontMetrics");
        return null;
    }

    public final int b() {
        if (this.f68562j) {
            return this.f68561i;
        }
        throw new IllegalStateException("PlaceholderSpan is not laid out yet.");
    }

    public final int c() {
        return this.f68558f;
    }

    public final int d() {
        if (this.f68562j) {
            return this.f68560h;
        }
        throw new IllegalStateException("PlaceholderSpan is not laid out yet.");
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i11, int i12, float f11, int i13, int i14, int i15, Paint paint) {
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i11, int i12, Paint.FontMetricsInt fontMetricsInt) {
        float f11;
        int a11;
        this.f68562j = true;
        float textSize = paint.getTextSize();
        this.f68559g = paint.getFontMetricsInt();
        if (a().descent <= a().ascent) {
            throw new IllegalArgumentException("Invalid fontMetrics: line height can not be negative.");
        }
        int i13 = this.f68554b;
        if (i13 == 0) {
            f11 = this.f68553a * this.f68557e;
        } else {
            if (i13 != 1) {
                throw new IllegalArgumentException("Unsupported unit.");
            }
            f11 = this.f68553a * textSize;
        }
        this.f68560h = k.a(f11);
        int i14 = this.f68556d;
        if (i14 == 0) {
            a11 = k.a(this.f68555c * this.f68557e);
        } else {
            if (i14 != 1) {
                throw new IllegalArgumentException("Unsupported unit.");
            }
            a11 = k.a(this.f68555c * textSize);
        }
        this.f68561i = a11;
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = a().ascent;
            fontMetricsInt.descent = a().descent;
            fontMetricsInt.leading = a().leading;
            switch (this.f68558f) {
                case 0:
                    if (fontMetricsInt.ascent > (-b())) {
                        fontMetricsInt.ascent = -b();
                        break;
                    }
                    break;
                case 1:
                case 4:
                    if (fontMetricsInt.ascent + b() > fontMetricsInt.descent) {
                        fontMetricsInt.descent = fontMetricsInt.ascent + b();
                        break;
                    }
                    break;
                case 2:
                case 5:
                    if (fontMetricsInt.ascent > fontMetricsInt.descent - b()) {
                        fontMetricsInt.ascent = fontMetricsInt.descent - b();
                        break;
                    }
                    break;
                case 3:
                case 6:
                    if (fontMetricsInt.descent - fontMetricsInt.ascent < b()) {
                        int b11 = fontMetricsInt.ascent - ((b() - (fontMetricsInt.descent - fontMetricsInt.ascent)) / 2);
                        fontMetricsInt.ascent = b11;
                        fontMetricsInt.descent = b11 + b();
                        break;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Unknown verticalAlign.");
            }
            fontMetricsInt.top = Math.min(a().top, fontMetricsInt.ascent);
            fontMetricsInt.bottom = Math.max(a().bottom, fontMetricsInt.descent);
        }
        return d();
    }
}
