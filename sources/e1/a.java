package e1;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.window.SplashScreenView;
import androidx.core.splashscreen.R$attr;
import androidx.core.splashscreen.R$dimen;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final C0764a f61592b = new C0764a(null);

    /* renamed from: a, reason: collision with root package name */
    private final c f61593a;

    /* renamed from: e1.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0764a {
        private C0764a() {
        }

        public /* synthetic */ C0764a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a(Activity activity) {
            Intrinsics.h(activity, "<this>");
            a aVar = new a(activity, null);
            aVar.b();
            return aVar;
        }
    }

    /* loaded from: classes2.dex */
    private static final class b extends c {

        /* renamed from: h, reason: collision with root package name */
        private boolean f61594h;

        /* renamed from: i, reason: collision with root package name */
        private final ViewGroup.OnHierarchyChangeListener f61595i;

        /* renamed from: e1.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class ViewGroupOnHierarchyChangeListenerC0765a implements ViewGroup.OnHierarchyChangeListener {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Activity f61597b;

            ViewGroupOnHierarchyChangeListenerC0765a(Activity activity) {
                this.f61597b = activity;
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
                if (f.a(view2)) {
                    b bVar = b.this;
                    bVar.e(bVar.d(g.a(view2)));
                    ((ViewGroup) this.f61597b.getWindow().getDecorView()).setOnHierarchyChangeListener(null);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Activity activity) {
            super(activity);
            Intrinsics.h(activity, "activity");
            this.f61594h = true;
            this.f61595i = new ViewGroupOnHierarchyChangeListenerC0765a(activity);
        }

        @Override // e1.a.c
        public void b() {
            Resources.Theme theme = a().getTheme();
            Intrinsics.g(theme, "activity.theme");
            c(theme, new TypedValue());
            ((ViewGroup) a().getWindow().getDecorView()).setOnHierarchyChangeListener(this.f61595i);
        }

        public final boolean d(SplashScreenView child) {
            WindowInsets build;
            View rootView;
            Intrinsics.h(child, "child");
            build = e1.c.a().build();
            Intrinsics.g(build, "Builder().build()");
            Rect rect = new Rect(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
            rootView = child.getRootView();
            return (build == rootView.computeSystemWindowInsets(build, rect) && rect.isEmpty()) ? false : true;
        }

        public final void e(boolean z10) {
            this.f61594h = z10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private final Activity f61598a;

        /* renamed from: b, reason: collision with root package name */
        private int f61599b;

        /* renamed from: c, reason: collision with root package name */
        private Integer f61600c;

        /* renamed from: d, reason: collision with root package name */
        private Integer f61601d;

        /* renamed from: e, reason: collision with root package name */
        private Drawable f61602e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f61603f;

        /* renamed from: g, reason: collision with root package name */
        private d f61604g;

        public c(Activity activity) {
            Intrinsics.h(activity, "activity");
            this.f61598a = activity;
            this.f61604g = new d() { // from class: e1.b
            };
        }

        public final Activity a() {
            return this.f61598a;
        }

        public void b() {
            TypedValue typedValue = new TypedValue();
            Resources.Theme currentTheme = this.f61598a.getTheme();
            if (currentTheme.resolveAttribute(R$attr.windowSplashScreenBackground, typedValue, true)) {
                this.f61600c = Integer.valueOf(typedValue.resourceId);
                this.f61601d = Integer.valueOf(typedValue.data);
            }
            if (currentTheme.resolveAttribute(R$attr.windowSplashScreenAnimatedIcon, typedValue, true)) {
                this.f61602e = currentTheme.getDrawable(typedValue.resourceId);
            }
            if (currentTheme.resolveAttribute(R$attr.splashScreenIconSize, typedValue, true)) {
                this.f61603f = typedValue.resourceId == R$dimen.splashscreen_icon_size_with_background;
            }
            Intrinsics.g(currentTheme, "currentTheme");
            c(currentTheme, typedValue);
        }

        protected final void c(Resources.Theme currentTheme, TypedValue typedValue) {
            Intrinsics.h(currentTheme, "currentTheme");
            Intrinsics.h(typedValue, "typedValue");
            if (currentTheme.resolveAttribute(R$attr.postSplashScreenTheme, typedValue, true)) {
                int i11 = typedValue.resourceId;
                this.f61599b = i11;
                if (i11 != 0) {
                    this.f61598a.setTheme(i11);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
    }

    private a(Activity activity) {
        this.f61593a = Build.VERSION.SDK_INT >= 31 ? new b(activity) : new c(activity);
    }

    public /* synthetic */ a(Activity activity, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        this.f61593a.b();
    }
}
