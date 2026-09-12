package ya;

import ab.i;
import ab.n;
import ab.q;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* loaded from: classes5.dex */
public class a extends Drawable implements q {

    /* renamed from: a, reason: collision with root package name */
    private b f79076a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        i f79077a;

        /* renamed from: b, reason: collision with root package name */
        boolean f79078b;

        public b(i iVar) {
            this.f79077a = iVar;
            this.f79078b = false;
        }

        public b(b bVar) {
            this.f79077a = (i) bVar.f79077a.getConstantState().newDrawable();
            this.f79078b = bVar.f79078b;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a newDrawable() {
            return new a(new b(this));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }
    }

    public a(n nVar) {
        this(new b(new i(nVar)));
    }

    private a(b bVar) {
        this.f79076a = bVar;
    }

    @Override // android.graphics.drawable.Drawable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a mutate() {
        this.f79076a = new b(this.f79076a);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b bVar = this.f79076a;
        if (bVar.f79078b) {
            bVar.f79077a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f79076a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f79076a.f79077a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f79076a.f79077a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        if (this.f79076a.f79077a.setState(iArr)) {
            onStateChange = true;
        }
        boolean e11 = ya.b.e(iArr);
        b bVar = this.f79076a;
        if (bVar.f79078b == e11) {
            return onStateChange;
        }
        bVar.f79078b = e11;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        this.f79076a.f79077a.setAlpha(i11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f79076a.f79077a.setColorFilter(colorFilter);
    }

    @Override // ab.q
    public void setShapeAppearanceModel(n nVar) {
        this.f79076a.f79077a.setShapeAppearanceModel(nVar);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i11) {
        this.f79076a.f79077a.setTint(i11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f79076a.f79077a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f79076a.f79077a.setTintMode(mode);
    }
}
