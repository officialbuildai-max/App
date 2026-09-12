package androidx.core.view.insets;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final View f8496a;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList f8497b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private z0.c f8498c;

    /* renamed from: d, reason: collision with root package name */
    private z0.c f8499d;

    /* renamed from: e, reason: collision with root package name */
    private int f8500e;

    /* loaded from: classes.dex */
    class a extends View {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f8501a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, ViewGroup viewGroup) {
            super(context);
            this.f8501a = viewGroup;
        }

        @Override // android.view.View
        protected void onConfigurationChanged(Configuration configuration) {
            Drawable background = this.f8501a.getBackground();
            int color = background instanceof ColorDrawable ? ((ColorDrawable) background).getColor() : 0;
            if (f.this.f8500e != color) {
                f.this.f8500e = color;
                for (int size = f.this.f8497b.size() - 1; size >= 0; size--) {
                    ((c) f.this.f8497b.get(size)).e(color);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    class b extends WindowInsetsAnimationCompat.Callback {

        /* renamed from: a, reason: collision with root package name */
        private final HashMap f8503a;

        b(int i11) {
            super(i11);
            this.f8503a = new HashMap();
        }

        private boolean a(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
            return (windowInsetsAnimationCompat.getTypeMask() & WindowInsetsCompat.Type.systemBars()) != 0;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        public void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
            if (a(windowInsetsAnimationCompat)) {
                this.f8503a.remove(windowInsetsAnimationCompat);
                for (int size = f.this.f8497b.size() - 1; size >= 0; size--) {
                    ((c) f.this.f8497b.get(size)).a();
                }
            }
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        public void onPrepare(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
            if (a(windowInsetsAnimationCompat)) {
                for (int size = f.this.f8497b.size() - 1; size >= 0; size--) {
                    ((c) f.this.f8497b.get(size)).d();
                }
            }
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        public WindowInsetsCompat onProgress(WindowInsetsCompat windowInsetsCompat, List list) {
            RectF rectF = new RectF(1.0f, 1.0f, 1.0f, 1.0f);
            int i11 = 0;
            for (int size = list.size() - 1; size >= 0; size--) {
                WindowInsetsAnimationCompat windowInsetsAnimationCompat = (WindowInsetsAnimationCompat) list.get(size);
                Integer num = (Integer) this.f8503a.get(windowInsetsAnimationCompat);
                if (num != null) {
                    int intValue = num.intValue();
                    float alpha = windowInsetsAnimationCompat.getAlpha();
                    if ((intValue & 1) != 0) {
                        rectF.left = alpha;
                    }
                    if ((intValue & 2) != 0) {
                        rectF.top = alpha;
                    }
                    if ((intValue & 4) != 0) {
                        rectF.right = alpha;
                    }
                    if ((intValue & 8) != 0) {
                        rectF.bottom = alpha;
                    }
                    i11 |= intValue;
                }
            }
            z0.c i12 = f.this.i(windowInsetsCompat);
            for (int size2 = f.this.f8497b.size() - 1; size2 >= 0; size2--) {
                ((c) f.this.f8497b.get(size2)).b(i11, i12, rectF);
            }
            return windowInsetsCompat;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        public WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsAnimationCompat.BoundsCompat boundsCompat) {
            if (!a(windowInsetsAnimationCompat)) {
                return boundsCompat;
            }
            z0.c upperBound = boundsCompat.getUpperBound();
            z0.c lowerBound = boundsCompat.getLowerBound();
            int i11 = upperBound.f79248a != lowerBound.f79248a ? 1 : 0;
            if (upperBound.f79249b != lowerBound.f79249b) {
                i11 |= 2;
            }
            if (upperBound.f79250c != lowerBound.f79250c) {
                i11 |= 4;
            }
            if (upperBound.f79251d != lowerBound.f79251d) {
                i11 |= 8;
            }
            this.f8503a.put(windowInsetsAnimationCompat, Integer.valueOf(i11));
            return boundsCompat;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface c {
        void a();

        void b(int i11, z0.c cVar, RectF rectF);

        void c(z0.c cVar, z0.c cVar2);

        void d();

        void e(int i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ViewGroup viewGroup) {
        z0.c cVar = z0.c.f79247e;
        this.f8498c = cVar;
        this.f8499d = cVar;
        Drawable background = viewGroup.getBackground();
        this.f8500e = background instanceof ColorDrawable ? ((ColorDrawable) background).getColor() : 0;
        a aVar = new a(viewGroup.getContext(), viewGroup);
        this.f8496a = aVar;
        aVar.setWillNotDraw(true);
        ViewCompat.setOnApplyWindowInsetsListener(aVar, new OnApplyWindowInsetsListener() { // from class: androidx.core.view.insets.d
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat m11;
                m11 = f.this.m(view, windowInsetsCompat);
                return m11;
            }
        });
        ViewCompat.setWindowInsetsAnimationCallback(aVar, new b(0));
        viewGroup.addView(aVar, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public z0.c i(WindowInsetsCompat windowInsetsCompat) {
        return z0.c.b(windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()), windowInsetsCompat.getInsets(WindowInsetsCompat.Type.tappableElement()));
    }

    private z0.c j(WindowInsetsCompat windowInsetsCompat) {
        return z0.c.b(windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.systemBars()), windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.tappableElement()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        ViewParent parent = this.f8496a.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f8496a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WindowInsetsCompat m(View view, WindowInsetsCompat windowInsetsCompat) {
        z0.c i11 = i(windowInsetsCompat);
        z0.c j11 = j(windowInsetsCompat);
        if (!i11.equals(this.f8498c) || !j11.equals(this.f8499d)) {
            this.f8498c = i11;
            this.f8499d = j11;
            for (int size = this.f8497b.size() - 1; size >= 0; size--) {
                ((c) this.f8497b.get(size)).c(i11, j11);
            }
        }
        return windowInsetsCompat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(c cVar) {
        if (this.f8497b.contains(cVar)) {
            return;
        }
        this.f8497b.add(cVar);
        cVar.c(this.f8498c, this.f8499d);
        cVar.e(this.f8500e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        this.f8496a.post(new Runnable() { // from class: androidx.core.view.insets.e
            @Override // java.lang.Runnable
            public final void run() {
                f.this.l();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return !this.f8497b.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(c cVar) {
        this.f8497b.remove(cVar);
    }
}
