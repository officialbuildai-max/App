package com.transsnet.login.country.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.b;
import com.tn.lib.widget.R$color;
import com.transsnet.login.R$dimen;
import java.util.List;

/* loaded from: classes7.dex */
public class SideBar extends View {

    /* renamed from: a, reason: collision with root package name */
    private List f60421a;

    /* renamed from: b, reason: collision with root package name */
    private TextPaint f60422b;

    /* renamed from: c, reason: collision with root package name */
    private int f60423c;

    /* renamed from: d, reason: collision with root package name */
    private a f60424d;

    /* renamed from: e, reason: collision with root package name */
    private float f60425e;

    /* renamed from: f, reason: collision with root package name */
    private int f60426f;

    /* renamed from: g, reason: collision with root package name */
    private int f60427g;

    /* renamed from: h, reason: collision with root package name */
    private float f60428h;

    /* loaded from: classes7.dex */
    public interface a {
        void g(String str);
    }

    public SideBar(Context context) {
        super(context.getApplicationContext());
        this.f60423c = -1;
        this.f60425e = -1.0f;
        this.f60426f = -1;
        this.f60427g = -1;
        this.f60428h = -1.0f;
    }

    public SideBar(Context context, AttributeSet attributeSet) {
        super(context.getApplicationContext(), attributeSet);
        this.f60423c = -1;
        this.f60425e = -1.0f;
        this.f60426f = -1;
        this.f60427g = -1;
        this.f60428h = -1.0f;
        setBackgroundColor(0);
    }

    private void a(Canvas canvas) {
        if (this.f60426f < 0) {
            this.f60426f = getContext().getResources().getDimensionPixelSize(R$dimen.side_bar_txt_size);
            this.f60427g = b.getColor(getContext(), R$color.text_03);
            this.f60425e = this.f60426f * 1.5f;
        }
        int i11 = 0;
        for (String str : this.f60421a) {
            this.f60422b.setTextSize(this.f60426f);
            this.f60422b.setAntiAlias(true);
            this.f60422b.setColor(this.f60427g);
            if (i11 == this.f60423c) {
                this.f60422b.setColor(b.getColor(getContext(), R$color.text_01));
                this.f60422b.setFakeBoldText(true);
            }
            if (this.f60428h < 0.0f) {
                this.f60428h = ((getWidth() * 1.0f) / 2.0f) - (this.f60422b.measureText(str) / 2.0f);
            }
            float f11 = this.f60425e;
            canvas.drawText(str, this.f60428h, (i11 * f11) + f11, this.f60422b);
            this.f60422b.reset();
            i11++;
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f60421a == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        motionEvent.getX();
        float y10 = motionEvent.getY();
        int i11 = this.f60423c;
        int height = (int) ((y10 / getHeight()) * this.f60421a.size());
        if (action == 1 || action == 3) {
            setBackgroundColor(0);
            invalidate();
        } else {
            setBackgroundColor(0);
            if (i11 != height && height >= 0 && height < this.f60421a.size()) {
                a aVar = this.f60424d;
                if (aVar != null) {
                    aVar.g((String) this.f60421a.get(height));
                }
                this.f60423c = height;
                invalidate();
            }
        }
        return true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        List list = this.f60421a;
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f60422b == null) {
            this.f60422b = new TextPaint(1);
        }
        a(canvas);
    }

    public void setIndexs(List<String> list) {
        this.f60421a = list;
        if (this.f60426f < 0) {
            this.f60426f = getContext().getResources().getDimensionPixelSize(R$dimen.side_bar_txt_size);
            this.f60427g = b.getColor(getContext(), R$color.text_03);
            this.f60425e = this.f60426f * 1.5f;
        }
        if (list != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.height = (int) (this.f60425e * list.size());
            setLayoutParams(layoutParams);
        }
        invalidate();
    }

    public void setScrollerListener(a aVar) {
        this.f60424d = aVar;
    }

    public void updateIndex(int i11) {
        this.f60423c = i11;
        invalidate();
    }
}
