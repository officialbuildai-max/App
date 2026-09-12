package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.activity.ImmLeaksCleaner;
import androidx.view.Lifecycle;
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class ImmLeaksCleaner implements androidx.view.r {

    /* renamed from: b, reason: collision with root package name */
    public static final b f916b = new b(null);

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f917c = LazyKt.b(new Function0<a>() { // from class: androidx.activity.ImmLeaksCleaner$Companion$cleaner$2
        @Override // kotlin.jvm.functions.Function0
        public final ImmLeaksCleaner.a invoke() {
            try {
                Field servedViewField = InputMethodManager.class.getDeclaredField("mServedView");
                servedViewField.setAccessible(true);
                Field nextServedViewField = InputMethodManager.class.getDeclaredField("mNextServedView");
                nextServedViewField.setAccessible(true);
                Field hField = InputMethodManager.class.getDeclaredField("mH");
                hField.setAccessible(true);
                Intrinsics.g(hField, "hField");
                Intrinsics.g(servedViewField, "servedViewField");
                Intrinsics.g(nextServedViewField, "nextServedViewField");
                return new ImmLeaksCleaner.d(hField, servedViewField, nextServedViewField);
            } catch (NoSuchFieldException unused) {
                return ImmLeaksCleaner.c.f919a;
            }
        }
    });

    /* renamed from: a, reason: collision with root package name */
    private final Activity f918a;

    /* loaded from: classes.dex */
    public static abstract class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract boolean a(InputMethodManager inputMethodManager);

        public abstract Object b(InputMethodManager inputMethodManager);

        public abstract View c(InputMethodManager inputMethodManager);
    }

    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a() {
            return (a) ImmLeaksCleaner.f917c.getValue();
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends a {

        /* renamed from: a, reason: collision with root package name */
        public static final c f919a = new c();

        private c() {
            super(null);
        }

        @Override // androidx.activity.ImmLeaksCleaner.a
        public boolean a(InputMethodManager inputMethodManager) {
            Intrinsics.h(inputMethodManager, "<this>");
            return false;
        }

        @Override // androidx.activity.ImmLeaksCleaner.a
        public Object b(InputMethodManager inputMethodManager) {
            Intrinsics.h(inputMethodManager, "<this>");
            return null;
        }

        @Override // androidx.activity.ImmLeaksCleaner.a
        public View c(InputMethodManager inputMethodManager) {
            Intrinsics.h(inputMethodManager, "<this>");
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends a {

        /* renamed from: a, reason: collision with root package name */
        private final Field f920a;

        /* renamed from: b, reason: collision with root package name */
        private final Field f921b;

        /* renamed from: c, reason: collision with root package name */
        private final Field f922c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Field hField, Field servedViewField, Field nextServedViewField) {
            super(null);
            Intrinsics.h(hField, "hField");
            Intrinsics.h(servedViewField, "servedViewField");
            Intrinsics.h(nextServedViewField, "nextServedViewField");
            this.f920a = hField;
            this.f921b = servedViewField;
            this.f922c = nextServedViewField;
        }

        @Override // androidx.activity.ImmLeaksCleaner.a
        public boolean a(InputMethodManager inputMethodManager) {
            Intrinsics.h(inputMethodManager, "<this>");
            try {
                this.f922c.set(inputMethodManager, null);
                return true;
            } catch (IllegalAccessException unused) {
                return false;
            }
        }

        @Override // androidx.activity.ImmLeaksCleaner.a
        public Object b(InputMethodManager inputMethodManager) {
            Intrinsics.h(inputMethodManager, "<this>");
            try {
                return this.f920a.get(inputMethodManager);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        @Override // androidx.activity.ImmLeaksCleaner.a
        public View c(InputMethodManager inputMethodManager) {
            Intrinsics.h(inputMethodManager, "<this>");
            try {
                return (View) this.f921b.get(inputMethodManager);
            } catch (ClassCastException | IllegalAccessException unused) {
                return null;
            }
        }
    }

    public ImmLeaksCleaner(Activity activity) {
        Intrinsics.h(activity, "activity");
        this.f918a = activity;
    }

    @Override // androidx.view.r
    public void onStateChanged(androidx.view.u source, Lifecycle.Event event) {
        Intrinsics.h(source, "source");
        Intrinsics.h(event, "event");
        if (event != Lifecycle.Event.ON_DESTROY) {
            return;
        }
        Object systemService = this.f918a.getSystemService("input_method");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        a a11 = f916b.a();
        Object b11 = a11.b(inputMethodManager);
        if (b11 == null) {
            return;
        }
        synchronized (b11) {
            View c11 = a11.c(inputMethodManager);
            if (c11 == null) {
                return;
            }
            if (c11.isAttachedToWindow()) {
                return;
            }
            boolean a12 = a11.a(inputMethodManager);
            if (a12) {
                inputMethodManager.isActive();
            }
        }
    }
}
