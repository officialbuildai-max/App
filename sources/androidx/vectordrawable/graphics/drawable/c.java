package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import y0.k;

/* loaded from: classes2.dex */
public class c extends g implements Animatable {

    /* renamed from: b, reason: collision with root package name */
    private C0136c f15215b;

    /* renamed from: c, reason: collision with root package name */
    private Context f15216c;

    /* renamed from: d, reason: collision with root package name */
    private ArgbEvaluator f15217d;

    /* renamed from: e, reason: collision with root package name */
    d f15218e;

    /* renamed from: f, reason: collision with root package name */
    private Animator.AnimatorListener f15219f;

    /* renamed from: g, reason: collision with root package name */
    ArrayList f15220g;

    /* renamed from: h, reason: collision with root package name */
    final Drawable.Callback f15221h;

    /* loaded from: classes2.dex */
    class a implements Drawable.Callback {
        a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            c.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j11) {
            c.this.scheduleSelf(runnable, j11);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            c.this.unscheduleSelf(runnable);
        }
    }

    /* loaded from: classes2.dex */
    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ArrayList arrayList = new ArrayList(c.this.f15220g);
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                ((androidx.vectordrawable.graphics.drawable.b) arrayList.get(i11)).onAnimationEnd(c.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ArrayList arrayList = new ArrayList(c.this.f15220g);
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                ((androidx.vectordrawable.graphics.drawable.b) arrayList.get(i11)).onAnimationStart(c.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.vectordrawable.graphics.drawable.c$c, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0136c extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        int f15224a;

        /* renamed from: b, reason: collision with root package name */
        h f15225b;

        /* renamed from: c, reason: collision with root package name */
        AnimatorSet f15226c;

        /* renamed from: d, reason: collision with root package name */
        ArrayList f15227d;

        /* renamed from: e, reason: collision with root package name */
        androidx.collection.a f15228e;

        public C0136c(Context context, C0136c c0136c, Drawable.Callback callback, Resources resources) {
            if (c0136c != null) {
                this.f15224a = c0136c.f15224a;
                h hVar = c0136c.f15225b;
                if (hVar != null) {
                    Drawable.ConstantState constantState = hVar.getConstantState();
                    if (resources != null) {
                        this.f15225b = (h) constantState.newDrawable(resources);
                    } else {
                        this.f15225b = (h) constantState.newDrawable();
                    }
                    h hVar2 = (h) this.f15225b.mutate();
                    this.f15225b = hVar2;
                    hVar2.setCallback(callback);
                    this.f15225b.setBounds(c0136c.f15225b.getBounds());
                    this.f15225b.h(false);
                }
                ArrayList arrayList = c0136c.f15227d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f15227d = new ArrayList(size);
                    this.f15228e = new androidx.collection.a(size);
                    for (int i11 = 0; i11 < size; i11++) {
                        Animator animator = (Animator) c0136c.f15227d.get(i11);
                        Animator clone = animator.clone();
                        String str = (String) c0136c.f15228e.get(animator);
                        clone.setTarget(this.f15225b.d(str));
                        this.f15227d.add(clone);
                        this.f15228e.put(clone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f15226c == null) {
                this.f15226c = new AnimatorSet();
            }
            this.f15226c.playTogether(this.f15227d);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f15224a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    /* loaded from: classes2.dex */
    private static class d extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        private final Drawable.ConstantState f15229a;

        public d(Drawable.ConstantState constantState) {
            this.f15229a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f15229a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f15229a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            c cVar = new c();
            Drawable newDrawable = this.f15229a.newDrawable();
            cVar.f15232a = newDrawable;
            newDrawable.setCallback(cVar.f15221h);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            c cVar = new c();
            Drawable newDrawable = this.f15229a.newDrawable(resources);
            cVar.f15232a = newDrawable;
            newDrawable.setCallback(cVar.f15221h);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            c cVar = new c();
            Drawable newDrawable = this.f15229a.newDrawable(resources, theme);
            cVar.f15232a = newDrawable;
            newDrawable.setCallback(cVar.f15221h);
            return cVar;
        }
    }

    c() {
        this(null, null, null);
    }

    private c(Context context) {
        this(context, null, null);
    }

    private c(Context context, C0136c c0136c, Resources resources) {
        this.f15217d = null;
        this.f15219f = null;
        this.f15220g = null;
        a aVar = new a();
        this.f15221h = aVar;
        this.f15216c = context;
        if (c0136c != null) {
            this.f15215b = c0136c;
        } else {
            this.f15215b = new C0136c(context, c0136c, aVar, resources);
        }
    }

    public static c a(Context context, int i11) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            c cVar = new c(context);
            Drawable e11 = y0.h.e(context.getResources(), i11, context.getTheme());
            cVar.f15232a = e11;
            e11.setCallback(cVar.f15221h);
            cVar.f15218e = new d(cVar.f15232a.getConstantState());
            return cVar;
        }
        try {
            XmlResourceParser xml = context.getResources().getXml(i11);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return b(context, context.getResources(), xml, asAttributeSet, context.getTheme());
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e12) {
            Log.e("AnimatedVDCompat", "parser error", e12);
            return null;
        } catch (XmlPullParserException e13) {
            Log.e("AnimatedVDCompat", "parser error", e13);
            return null;
        }
    }

    public static c b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        c cVar = new c(context);
        cVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return cVar;
    }

    private static void d(AnimatedVectorDrawable animatedVectorDrawable, androidx.vectordrawable.graphics.drawable.b bVar) {
        animatedVectorDrawable.registerAnimationCallback(bVar.getPlatformCallback());
    }

    private void e() {
        Animator.AnimatorListener animatorListener = this.f15219f;
        if (animatorListener != null) {
            this.f15215b.f15226c.removeListener(animatorListener);
            this.f15219f = null;
        }
    }

    private void f(String str, Animator animator) {
        animator.setTarget(this.f15215b.f15225b.d(str));
        C0136c c0136c = this.f15215b;
        if (c0136c.f15227d == null) {
            c0136c.f15227d = new ArrayList();
            this.f15215b.f15228e = new androidx.collection.a();
        }
        this.f15215b.f15227d.add(animator);
        this.f15215b.f15228e.put(animator, str);
    }

    private static boolean h(AnimatedVectorDrawable animatedVectorDrawable, androidx.vectordrawable.graphics.drawable.b bVar) {
        return animatedVectorDrawable.unregisterAnimationCallback(bVar.getPlatformCallback());
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f15232a;
        if (drawable != null) {
            a1.a.a(drawable, theme);
        }
    }

    public void c(androidx.vectordrawable.graphics.drawable.b bVar) {
        Drawable drawable = this.f15232a;
        if (drawable != null) {
            d((AnimatedVectorDrawable) drawable, bVar);
            return;
        }
        if (bVar == null) {
            return;
        }
        if (this.f15220g == null) {
            this.f15220g = new ArrayList();
        }
        if (this.f15220g.contains(bVar)) {
            return;
        }
        this.f15220g.add(bVar);
        if (this.f15219f == null) {
            this.f15219f = new b();
        }
        this.f15215b.f15226c.addListener(this.f15219f);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f15232a;
        if (drawable != null) {
            return a1.a.b(drawable);
        }
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f15232a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f15215b.f15225b.draw(canvas);
        if (this.f15215b.f15226c.isStarted()) {
            invalidateSelf();
        }
    }

    public boolean g(androidx.vectordrawable.graphics.drawable.b bVar) {
        Drawable drawable = this.f15232a;
        if (drawable != null) {
            h((AnimatedVectorDrawable) drawable, bVar);
        }
        ArrayList arrayList = this.f15220g;
        if (arrayList == null || bVar == null) {
            return false;
        }
        boolean remove = arrayList.remove(bVar);
        if (this.f15220g.size() == 0) {
            e();
        }
        return remove;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f15232a;
        return drawable != null ? a1.a.d(drawable) : this.f15215b.f15225b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f15232a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f15215b.f15224a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f15232a;
        return drawable != null ? a1.a.e(drawable) : this.f15215b.f15225b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f15232a == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new d(this.f15232a.getConstantState());
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f15232a;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f15215b.f15225b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f15232a;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f15215b.f15225b.getIntrinsicWidth();
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f15232a;
        return drawable != null ? drawable.getOpacity() : this.f15215b.f15225b.getOpacity();
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable = this.f15232a;
        if (drawable != null) {
            a1.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray k11 = k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f15206e);
                    int resourceId = k11.getResourceId(0, 0);
                    if (resourceId != 0) {
                        h b11 = h.b(resources, resourceId, theme);
                        b11.h(false);
                        b11.setCallback(this.f15221h);
                        h hVar = this.f15215b.f15225b;
                        if (hVar != null) {
                            hVar.setCallback(null);
                        }
                        this.f15215b.f15225b = b11;
                    }
                    k11.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.vectordrawable.graphics.drawable.a.f15207f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f15216c;
                        if (context == null) {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                        f(string, e.i(context, resourceId2));
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f15215b.a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f15232a;
        return drawable != null ? a1.a.h(drawable) : this.f15215b.f15225b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f15232a;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f15215b.f15226c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f15232a;
        return drawable != null ? drawable.isStateful() : this.f15215b.f15225b.isStateful();
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f15232a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f15232a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f15215b.f15225b.setBounds(rect);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i11) {
        Drawable drawable = this.f15232a;
        return drawable != null ? drawable.setLevel(i11) : this.f15215b.f15225b.setLevel(i11);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f15232a;
        return drawable != null ? drawable.setState(iArr) : this.f15215b.f15225b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        Drawable drawable = this.f15232a;
        if (drawable != null) {
            drawable.setAlpha(i11);
        } else {
            this.f15215b.f15225b.setAlpha(i11);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f15232a;
        if (drawable != null) {
            a1.a.j(drawable, z10);
        } else {
            this.f15215b.f15225b.setAutoMirrored(z10);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i11) {
        super.setChangingConfigurations(i11);
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i11, PorterDuff.Mode mode) {
        super.setColorFilter(i11, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f15232a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f15215b.f15225b.setColorFilter(colorFilter);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z10) {
        super.setFilterBitmap(z10);
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f11, float f12) {
        super.setHotspot(f11, f12);
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i11, int i12, int i13, int i14) {
        super.setHotspotBounds(i11, i12, i13, i14);
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i11) {
        Drawable drawable = this.f15232a;
        if (drawable != null) {
            a1.a.n(drawable, i11);
        } else {
            this.f15215b.f15225b.setTint(i11);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f15232a;
        if (drawable != null) {
            a1.a.o(drawable, colorStateList);
        } else {
            this.f15215b.f15225b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f15232a;
        if (drawable != null) {
            a1.a.p(drawable, mode);
        } else {
            this.f15215b.f15225b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f15232a;
        if (drawable != null) {
            return drawable.setVisible(z10, z11);
        }
        this.f15215b.f15225b.setVisible(z10, z11);
        return super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f15232a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else {
            if (this.f15215b.f15226c.isStarted()) {
                return;
            }
            this.f15215b.f15226c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f15232a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f15215b.f15226c.end();
        }
    }
}
