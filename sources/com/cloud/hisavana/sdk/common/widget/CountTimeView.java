package com.cloud.hisavana.sdk.common.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.cloud.hisavana.sdk.R$dimen;
import com.cloud.hisavana.sdk.R$drawable;
import com.cloud.hisavana.sdk.e4;
import e7.e;

/* loaded from: classes3.dex */
public class CountTimeView extends View implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private Paint f22293a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f22294b;

    /* renamed from: c, reason: collision with root package name */
    private long f22295c;

    /* renamed from: d, reason: collision with root package name */
    private long f22296d;

    /* renamed from: e, reason: collision with root package name */
    private e f22297e;

    /* renamed from: f, reason: collision with root package name */
    private int f22298f;

    /* renamed from: g, reason: collision with root package name */
    private String f22299g;

    /* renamed from: h, reason: collision with root package name */
    private b f22300h;

    /* renamed from: i, reason: collision with root package name */
    private Bitmap f22301i;

    /* renamed from: j, reason: collision with root package name */
    private int f22302j;

    /* renamed from: k, reason: collision with root package name */
    private final Rect f22303k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends e {
        a(long j11, long j12) {
            super(j11, j12);
        }

        @Override // e7.e
        public void e() {
            if (CountTimeView.this.f22300h != null) {
                CountTimeView.this.f22300h.onFinish();
            }
        }

        @Override // e7.e
        public void f(long j11) {
            CountTimeView.this.f22299g = "SKIP " + (j11 / 1000);
            CountTimeView.this.f22302j = (int) j11;
            CountTimeView.this.invalidate();
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onClick();

        void onFinish();

        void onStart();
    }

    public CountTimeView(Context context) {
        this(context, null);
    }

    public CountTimeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CountTimeView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f22295c = 6L;
        this.f22296d = 0L;
        this.f22299g = "5s";
        this.f22303k = new Rect();
        setOnClickListener(this);
        try {
            this.f22298f = context.getResources().getDimensionPixelSize(R$dimen.ad_skip_text_size);
        } catch (Throwable unused) {
            this.f22298f = 13;
        }
        e();
    }

    private void d() {
        this.f22297e = new a(this.f22295c, 1000L);
    }

    private void e() {
        Paint paint = new Paint();
        this.f22293a = paint;
        paint.setAntiAlias(true);
        this.f22293a.setDither(true);
        this.f22293a.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f22294b = paint2;
        paint2.setAntiAlias(true);
        this.f22294b.setColor(-1);
        this.f22294b.setTextSize(this.f22298f);
        this.f22294b.setStrokeWidth(8.0f);
        this.f22294b.setTextAlign(Paint.Align.CENTER);
    }

    private Bitmap getBg() {
        try {
            Drawable drawable = getResources().getDrawable(R$drawable.ad_skip_button);
            if (drawable instanceof BitmapDrawable) {
                this.f22301i = ((BitmapDrawable) drawable).getBitmap();
            } else {
                this.f22301i = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(this.f22301i);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
            }
            return this.f22301i;
        } catch (Throwable th2) {
            e4.b().e(Log.getStackTraceString(th2));
            return null;
        }
    }

    public void cancel() {
        e eVar = this.f22297e;
        if (eVar != null) {
            eVar.d();
        }
    }

    public void changeFinishMode() {
        this.f22299g = "X";
        invalidate();
    }

    public long getRemainder() {
        return this.f22302j;
    }

    public long getSupposeFinishTime() {
        return this.f22296d;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f22297e.g();
        b bVar = this.f22300h;
        if (bVar != null) {
            bVar.onStart();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar = this.f22300h;
        if (bVar != null) {
            bVar.onClick();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e eVar = this.f22297e;
        if (eVar != null) {
            eVar.d();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            if (TextUtils.isEmpty(this.f22299g)) {
                return;
            }
            if (this.f22301i == null) {
                this.f22301i = getBg();
            }
            Rect rect = new Rect(0, 0, this.f22301i.getWidth(), this.f22301i.getHeight());
            canvas.drawBitmap(this.f22301i, rect, rect, this.f22293a);
            Paint.FontMetrics fontMetrics = this.f22294b.getFontMetrics();
            Rect rect2 = this.f22303k;
            canvas.drawText(this.f22299g, rect2.centerX(), ((int) (((rect2.bottom + rect2.top) - fontMetrics.bottom) - fontMetrics.top)) / 2, this.f22294b);
        } catch (Throwable th2) {
            e4.b().e(Log.getStackTraceString(th2));
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i11, int i12, int i13, int i14) {
        this.f22303k.set(0, 0, getWidth(), getHeight());
        super.onSizeChanged(i11, i12, i13, i14);
    }

    public void setCountDownTimerListener(b bVar) {
        this.f22300h = bVar;
    }

    public void setStartTime(int i11) {
        this.f22295c = (i11 * 1000) + 400;
        this.f22296d = System.currentTimeMillis() + this.f22295c + 1000;
        this.f22302j = i11;
        d();
    }

    public void start() {
        this.f22297e.g();
        this.f22296d = System.currentTimeMillis() + this.f22295c + 1000;
        b bVar = this.f22300h;
        if (bVar != null) {
            bVar.onStart();
        }
    }
}
