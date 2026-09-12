package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.R$styleable;

/* loaded from: classes.dex */
public class MockView extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f7662a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f7663b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f7664c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f7665d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f7666e;

    /* renamed from: f, reason: collision with root package name */
    protected String f7667f;

    /* renamed from: g, reason: collision with root package name */
    private Rect f7668g;

    /* renamed from: h, reason: collision with root package name */
    private int f7669h;

    /* renamed from: i, reason: collision with root package name */
    private int f7670i;

    /* renamed from: j, reason: collision with root package name */
    private int f7671j;

    /* renamed from: k, reason: collision with root package name */
    private int f7672k;

    public MockView(Context context) {
        super(context);
        this.f7662a = new Paint();
        this.f7663b = new Paint();
        this.f7664c = new Paint();
        this.f7665d = true;
        this.f7666e = true;
        this.f7667f = null;
        this.f7668g = new Rect();
        this.f7669h = Color.argb(255, 0, 0, 0);
        this.f7670i = Color.argb(255, 200, 200, 200);
        this.f7671j = Color.argb(255, 50, 50, 50);
        this.f7672k = 4;
        a(context, null);
    }

    public MockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7662a = new Paint();
        this.f7663b = new Paint();
        this.f7664c = new Paint();
        this.f7665d = true;
        this.f7666e = true;
        this.f7667f = null;
        this.f7668g = new Rect();
        this.f7669h = Color.argb(255, 0, 0, 0);
        this.f7670i = Color.argb(255, 200, 200, 200);
        this.f7671j = Color.argb(255, 50, 50, 50);
        this.f7672k = 4;
        a(context, attributeSet);
    }

    public MockView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f7662a = new Paint();
        this.f7663b = new Paint();
        this.f7664c = new Paint();
        this.f7665d = true;
        this.f7666e = true;
        this.f7667f = null;
        this.f7668g = new Rect();
        this.f7669h = Color.argb(255, 0, 0, 0);
        this.f7670i = Color.argb(255, 200, 200, 200);
        this.f7671j = Color.argb(255, 50, 50, 50);
        this.f7672k = 4;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MockView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.MockView_mock_label) {
                    this.f7667f = obtainStyledAttributes.getString(index);
                } else if (index == R$styleable.MockView_mock_showDiagonals) {
                    this.f7665d = obtainStyledAttributes.getBoolean(index, this.f7665d);
                } else if (index == R$styleable.MockView_mock_diagonalsColor) {
                    this.f7669h = obtainStyledAttributes.getColor(index, this.f7669h);
                } else if (index == R$styleable.MockView_mock_labelBackgroundColor) {
                    this.f7671j = obtainStyledAttributes.getColor(index, this.f7671j);
                } else if (index == R$styleable.MockView_mock_labelColor) {
                    this.f7670i = obtainStyledAttributes.getColor(index, this.f7670i);
                } else if (index == R$styleable.MockView_mock_showLabel) {
                    this.f7666e = obtainStyledAttributes.getBoolean(index, this.f7666e);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.f7667f == null) {
            try {
                this.f7667f = context.getResources().getResourceEntryName(getId());
            } catch (Exception unused) {
            }
        }
        this.f7662a.setColor(this.f7669h);
        this.f7662a.setAntiAlias(true);
        this.f7663b.setColor(this.f7670i);
        this.f7663b.setAntiAlias(true);
        this.f7664c.setColor(this.f7671j);
        this.f7672k = Math.round(this.f7672k * (getResources().getDisplayMetrics().xdpi / 160.0f));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f7665d) {
            width--;
            height--;
            float f11 = width;
            float f12 = height;
            canvas.drawLine(0.0f, 0.0f, f11, f12, this.f7662a);
            canvas.drawLine(0.0f, f12, f11, 0.0f, this.f7662a);
            canvas.drawLine(0.0f, 0.0f, f11, 0.0f, this.f7662a);
            canvas.drawLine(f11, 0.0f, f11, f12, this.f7662a);
            canvas.drawLine(f11, f12, 0.0f, f12, this.f7662a);
            canvas.drawLine(0.0f, f12, 0.0f, 0.0f, this.f7662a);
        }
        String str = this.f7667f;
        if (str == null || !this.f7666e) {
            return;
        }
        this.f7663b.getTextBounds(str, 0, str.length(), this.f7668g);
        float width2 = (width - this.f7668g.width()) / 2.0f;
        float height2 = ((height - this.f7668g.height()) / 2.0f) + this.f7668g.height();
        this.f7668g.offset((int) width2, (int) height2);
        Rect rect = this.f7668g;
        int i11 = rect.left;
        int i12 = this.f7672k;
        rect.set(i11 - i12, rect.top - i12, rect.right + i12, rect.bottom + i12);
        canvas.drawRect(this.f7668g, this.f7664c);
        canvas.drawText(this.f7667f, width2, height2, this.f7663b);
    }
}
