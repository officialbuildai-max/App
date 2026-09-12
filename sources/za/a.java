package za;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import androidx.core.view.ViewCompat;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f79510i = new int[3];

    /* renamed from: j, reason: collision with root package name */
    private static final float[] f79511j = {0.0f, 0.5f, 1.0f};

    /* renamed from: k, reason: collision with root package name */
    private static final int[] f79512k = new int[4];

    /* renamed from: l, reason: collision with root package name */
    private static final float[] f79513l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    private final Paint f79514a;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f79515b;

    /* renamed from: c, reason: collision with root package name */
    private final Paint f79516c;

    /* renamed from: d, reason: collision with root package name */
    private int f79517d;

    /* renamed from: e, reason: collision with root package name */
    private int f79518e;

    /* renamed from: f, reason: collision with root package name */
    private int f79519f;

    /* renamed from: g, reason: collision with root package name */
    private final Path f79520g;

    /* renamed from: h, reason: collision with root package name */
    private final Paint f79521h;

    public a() {
        this(ViewCompat.MEASURED_STATE_MASK);
    }

    public a(int i11) {
        this.f79520g = new Path();
        Paint paint = new Paint();
        this.f79521h = paint;
        this.f79514a = new Paint();
        d(i11);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.f79515b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f79516c = new Paint(paint2);
    }

    public void a(Canvas canvas, Matrix matrix, RectF rectF, int i11, float f11, float f12) {
        boolean z10 = f12 < 0.0f;
        Path path = this.f79520g;
        if (z10) {
            int[] iArr = f79512k;
            iArr[0] = 0;
            iArr[1] = this.f79519f;
            iArr[2] = this.f79518e;
            iArr[3] = this.f79517d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f11, f12);
            path.close();
            float f13 = -i11;
            rectF.inset(f13, f13);
            int[] iArr2 = f79512k;
            iArr2[0] = 0;
            iArr2[1] = this.f79517d;
            iArr2[2] = this.f79518e;
            iArr2[3] = this.f79519f;
        }
        float width = rectF.width() / 2.0f;
        if (width <= 0.0f) {
            return;
        }
        float f14 = 1.0f - (i11 / width);
        float[] fArr = f79513l;
        fArr[1] = f14;
        fArr[2] = ((1.0f - f14) / 2.0f) + f14;
        this.f79515b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, f79512k, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z10) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.f79521h);
        }
        canvas.drawArc(rectF, f11, f12, true, this.f79515b);
        canvas.restore();
    }

    public void b(Canvas canvas, Matrix matrix, RectF rectF, int i11) {
        rectF.bottom += i11;
        rectF.offset(0.0f, -i11);
        int[] iArr = f79510i;
        iArr[0] = this.f79519f;
        iArr[1] = this.f79518e;
        iArr[2] = this.f79517d;
        Paint paint = this.f79516c;
        float f11 = rectF.left;
        paint.setShader(new LinearGradient(f11, rectF.top, f11, rectF.bottom, iArr, f79511j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f79516c);
        canvas.restore();
    }

    public Paint c() {
        return this.f79514a;
    }

    public void d(int i11) {
        this.f79517d = z0.b.p(i11, 68);
        this.f79518e = z0.b.p(i11, 20);
        this.f79519f = z0.b.p(i11, 0);
        this.f79514a.setColor(this.f79517d);
    }
}
