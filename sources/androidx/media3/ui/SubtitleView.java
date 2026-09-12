package androidx.media3.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import u1.a;

/* loaded from: classes2.dex */
public final class SubtitleView extends FrameLayout {
    public static final float DEFAULT_BOTTOM_PADDING_FRACTION = 0.08f;
    public static final float DEFAULT_TEXT_SIZE_FRACTION = 0.0533f;
    public static final int VIEW_TYPE_CANVAS = 1;
    public static final int VIEW_TYPE_WEB = 2;

    /* renamed from: a, reason: collision with root package name */
    private List f13679a;

    /* renamed from: b, reason: collision with root package name */
    private b f13680b;

    /* renamed from: c, reason: collision with root package name */
    private int f13681c;

    /* renamed from: d, reason: collision with root package name */
    private float f13682d;

    /* renamed from: e, reason: collision with root package name */
    private float f13683e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f13684f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f13685g;

    /* renamed from: h, reason: collision with root package name */
    private int f13686h;

    /* renamed from: i, reason: collision with root package name */
    private a f13687i;

    /* renamed from: j, reason: collision with root package name */
    private View f13688j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        void a(List list, b bVar, float f11, int i11, float f12);
    }

    public SubtitleView(Context context) {
        this(context, null);
    }

    public SubtitleView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13679a = Collections.emptyList();
        this.f13680b = b.f13713g;
        this.f13681c = 0;
        this.f13682d = 0.0533f;
        this.f13683e = 0.08f;
        this.f13684f = true;
        this.f13685g = true;
        androidx.media3.ui.a aVar = new androidx.media3.ui.a(context);
        this.f13687i = aVar;
        this.f13688j = aVar;
        addView(aVar);
        this.f13686h = 1;
    }

    private u1.a a(u1.a aVar) {
        a.b a11 = aVar.a();
        if (!this.f13684f) {
            x0.e(a11);
        } else if (!this.f13685g) {
            x0.f(a11);
        }
        return a11.a();
    }

    private void b(int i11, float f11) {
        this.f13681c = i11;
        this.f13682d = f11;
        c();
    }

    private void c() {
        this.f13687i.a(getCuesWithStylingPreferencesApplied(), this.f13680b, this.f13682d, this.f13681c, this.f13683e);
    }

    private List<u1.a> getCuesWithStylingPreferencesApplied() {
        if (this.f13684f && this.f13685g) {
            return this.f13679a;
        }
        ArrayList arrayList = new ArrayList(this.f13679a.size());
        for (int i11 = 0; i11 < this.f13679a.size(); i11++) {
            arrayList.add(a((u1.a) this.f13679a.get(i11)));
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private b getUserCaptionStyle() {
        if (isInEditMode()) {
            return b.f13713g;
        }
        CaptioningManager captioningManager = (CaptioningManager) getContext().getSystemService("captioning");
        return (captioningManager == null || !captioningManager.isEnabled()) ? b.f13713g : b.a(captioningManager.getUserStyle());
    }

    private <T extends View & a> void setView(T t11) {
        removeView(this.f13688j);
        View view = this.f13688j;
        if (view instanceof b1) {
            ((b1) view).g();
        }
        this.f13688j = t11;
        this.f13687i = t11;
        addView(t11);
    }

    public void setApplyEmbeddedFontSizes(boolean z10) {
        this.f13685g = z10;
        c();
    }

    public void setApplyEmbeddedStyles(boolean z10) {
        this.f13684f = z10;
        c();
    }

    public void setBottomPaddingFraction(float f11) {
        this.f13683e = f11;
        c();
    }

    public void setCues(@Nullable List<u1.a> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        this.f13679a = list;
        c();
    }

    public void setFixedTextSize(int i11, float f11) {
        Context context = getContext();
        b(2, TypedValue.applyDimension(i11, f11, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }

    public void setFractionalTextSize(float f11) {
        setFractionalTextSize(f11, false);
    }

    public void setFractionalTextSize(float f11, boolean z10) {
        b(z10 ? 1 : 0, f11);
    }

    public void setStyle(b bVar) {
        this.f13680b = bVar;
        c();
    }

    public void setUserDefaultStyle() {
        setStyle(getUserCaptionStyle());
    }

    public void setUserDefaultTextSize() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    public void setViewType(int i11) {
        if (this.f13686h == i11) {
            return;
        }
        if (i11 == 1) {
            setView(new androidx.media3.ui.a(getContext()));
        } else {
            if (i11 != 2) {
                throw new IllegalArgumentException();
            }
            setView(new b1(getContext()));
        }
        this.f13686h = i11;
    }
}
