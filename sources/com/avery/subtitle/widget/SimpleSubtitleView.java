package com.avery.subtitle.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.avery.subtitle.DefaultSubtitleEngine;
import com.avery.subtitle.b;
import com.avery.subtitle.widget.BgBubbleDrawable;
import i5.a;

/* loaded from: classes2.dex */
public class SimpleSubtitleView extends AppCompatTextView implements b, b.a, b.InterfaceC0190b {

    /* renamed from: a, reason: collision with root package name */
    private b f20019a;

    /* renamed from: b, reason: collision with root package name */
    private String f20020b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f20021c;

    /* renamed from: d, reason: collision with root package name */
    private BgBubbleDrawable f20022d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f20023e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f20024f;

    /* renamed from: g, reason: collision with root package name */
    private int f20025g;

    /* renamed from: h, reason: collision with root package name */
    private int f20026h;

    /* renamed from: i, reason: collision with root package name */
    private int f20027i;

    public SimpleSubtitleView(Context context) {
        super(context);
        this.f20023e = false;
        this.f20024f = false;
        this.f20025g = 0;
        this.f20026h = 0;
        this.f20027i = 0;
        b();
    }

    public SimpleSubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20023e = false;
        this.f20024f = false;
        this.f20025g = 0;
        this.f20026h = 0;
        this.f20027i = 0;
        b();
    }

    public SimpleSubtitleView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f20023e = false;
        this.f20024f = false;
        this.f20025g = 0;
        this.f20026h = 0;
        this.f20027i = 0;
        b();
    }

    private void b() {
        DefaultSubtitleEngine defaultSubtitleEngine = new DefaultSubtitleEngine();
        this.f20019a = defaultSubtitleEngine;
        defaultSubtitleEngine.setOnSubtitlePreparedListener(this);
        this.f20019a.setOnSubtitleChangeListener(this);
    }

    private void c() {
        d(getWidth(), getHeight());
    }

    private void d(int i11, int i12) {
        e(0, i11, 0, i12);
    }

    private void e(int i11, int i12, int i13, int i14) {
        if (this.f20023e || this.f20024f) {
            this.f20024f = false;
            BgBubbleDrawable t11 = new BgBubbleDrawable.b().u(new RectF(i11, i13, i12, i14)).s(BgBubbleDrawable.BubbleType.COLOR).p(this.f20027i).q(BgBubbleDrawable.ArrowLocation.NONE).r(this.f20025g).t();
            this.f20022d = t11;
            t11.setAlpha(this.f20026h);
        }
    }

    public void closeBg() {
        this.f20023e = false;
        this.f20024f = true;
        this.f20025g = 0;
        this.f20026h = 0;
        this.f20027i = 0;
        requestLayout();
    }

    @Override // com.avery.subtitle.b
    public void destroy() {
        this.f20019a.destroy();
    }

    @Override // com.avery.subtitle.b
    public void initSubtitle(a aVar, boolean z10) {
        this.f20019a.initSubtitle(aVar, z10);
    }

    @Override // android.view.View
    public void layout(int i11, int i12, int i13, int i14) {
        super.layout(i11, i12, i13, i14);
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        BgBubbleDrawable bgBubbleDrawable = this.f20022d;
        if (bgBubbleDrawable != null) {
            bgBubbleDrawable.draw(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // com.avery.subtitle.b.InterfaceC0190b
    public void onRefreshSubtitle() {
        refreshImmediately();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        if (i11 <= 0 || i12 <= 0) {
            return;
        }
        d(i11, i12);
    }

    @Override // com.avery.subtitle.b.a
    public void onSubtitleChanged(@Nullable k5.b bVar) {
        if (this.f20021c) {
            return;
        }
        if (bVar == null || TextUtils.isEmpty(bVar.f66776d)) {
            setText("");
            setVisibility(4);
        } else {
            if (TextUtils.equals(this.f20020b, bVar.f66776d)) {
                return;
            }
            setVisibility(0);
            String replace = bVar.f66776d.replace("\\N", "\n");
            bVar.f66776d = replace;
            this.f20020b = replace;
            if (l5.b.b(replace).booleanValue()) {
                setText(Html.fromHtml(bVar.f66776d));
            } else {
                setText(bVar.f66776d);
            }
        }
    }

    @Override // com.avery.subtitle.b.InterfaceC0190b
    public void onSubtitlePrepared() {
        start();
    }

    public void openBg() {
        this.f20023e = true;
        requestLayout();
    }

    @Override // com.avery.subtitle.b
    public void pause() {
        this.f20019a.pause();
    }

    @Override // com.avery.subtitle.b
    public void refreshImmediately() {
        this.f20019a.refreshImmediately();
    }

    @Override // com.avery.subtitle.b
    public void reset() {
        this.f20019a.reset();
    }

    @Override // com.avery.subtitle.b
    public void resume() {
        this.f20019a.resume();
    }

    @Override // com.avery.subtitle.b
    public void selectSubtitle(String str, String str2, i5.b bVar) {
        this.f20019a.selectSubtitle(str, str2, bVar);
    }

    public void setBgAlpha(int i11) {
        if (this.f20023e) {
            this.f20026h = i11;
            requestLayout();
        }
    }

    public void setBgColor(int i11) {
        if (this.f20023e) {
            this.f20025g = i11;
            requestLayout();
        }
    }

    public void setBgdRadius(int i11) {
        if (this.f20023e) {
            this.f20027i = i11;
            requestLayout();
        }
    }

    @Override // com.avery.subtitle.b
    public void setDefaultSubtitle(String str) {
        this.f20019a.setDefaultSubtitle(str);
    }

    @Override // com.avery.subtitle.b
    public void setOnSubtitleChangeListener(b.a aVar) {
        this.f20019a.setOnSubtitleChangeListener(aVar);
    }

    @Override // com.avery.subtitle.b
    public void setOnSubtitlePreparedListener(b.InterfaceC0190b interfaceC0190b) {
        this.f20019a.setOnSubtitlePreparedListener(interfaceC0190b);
    }

    @Override // com.avery.subtitle.b
    public void setSubtitlePath(String str, String str2) {
        this.f20019a.setSubtitlePath(str, str2);
    }

    @Override // com.avery.subtitle.b
    public void start() {
        this.f20019a.start();
    }

    @Override // com.avery.subtitle.b
    public void stop() {
        this.f20019a.stop();
    }

    @Override // com.avery.subtitle.b
    public void subtitleDelay(long j11) {
        this.f20019a.subtitleDelay(j11);
    }

    public void turnOff(boolean z10) {
        this.f20021c = z10;
        setText("");
        setVisibility(4);
    }
}
