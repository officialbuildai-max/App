package androidx.appcompat.app;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.NonNull;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.b;
import androidx.appcompat.view.f;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.j0;
import androidx.appcompat.widget.t0;
import androidx.appcompat.widget.u0;
import androidx.collection.x0;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.WindowInsetsCompat;
import androidx.view.Lifecycle;
import com.cloud.tmc.offline.download.model.TaskResultKt;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;
import y0.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AppCompatDelegateImpl extends androidx.appcompat.app.f implements f.a, LayoutInflater.Factory2 {

    /* renamed from: j0, reason: collision with root package name */
    private static final x0 f1090j0 = new x0();

    /* renamed from: k0, reason: collision with root package name */
    private static final boolean f1091k0 = false;

    /* renamed from: l0, reason: collision with root package name */
    private static final int[] f1092l0 = {R.attr.windowBackground};

    /* renamed from: m0, reason: collision with root package name */
    private static final boolean f1093m0 = !"robolectric".equals(Build.FINGERPRINT);
    private boolean A;
    ViewGroup B;
    private TextView C;
    private View D;
    private boolean E;
    private boolean F;
    boolean G;
    boolean H;
    boolean I;
    boolean J;
    boolean K;
    private boolean L;
    private PanelFeatureState[] M;
    private PanelFeatureState N;
    private boolean O;
    private boolean P;
    private boolean Q;
    boolean R;
    private Configuration S;
    private int T;
    private int U;
    private int V;
    private boolean W;
    private n X;
    private n Y;
    boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    int f1094a0;

    /* renamed from: b0, reason: collision with root package name */
    private final Runnable f1095b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f1096c0;

    /* renamed from: d0, reason: collision with root package name */
    private Rect f1097d0;

    /* renamed from: e0, reason: collision with root package name */
    private Rect f1098e0;

    /* renamed from: f0, reason: collision with root package name */
    private x f1099f0;

    /* renamed from: g0, reason: collision with root package name */
    private y f1100g0;

    /* renamed from: h0, reason: collision with root package name */
    private OnBackInvokedDispatcher f1101h0;

    /* renamed from: i0, reason: collision with root package name */
    private OnBackInvokedCallback f1102i0;

    /* renamed from: j, reason: collision with root package name */
    final Object f1103j;

    /* renamed from: k, reason: collision with root package name */
    final Context f1104k;

    /* renamed from: l, reason: collision with root package name */
    Window f1105l;

    /* renamed from: m, reason: collision with root package name */
    private l f1106m;

    /* renamed from: n, reason: collision with root package name */
    final androidx.appcompat.app.d f1107n;

    /* renamed from: o, reason: collision with root package name */
    androidx.appcompat.app.a f1108o;

    /* renamed from: p, reason: collision with root package name */
    MenuInflater f1109p;

    /* renamed from: q, reason: collision with root package name */
    private CharSequence f1110q;

    /* renamed from: r, reason: collision with root package name */
    private androidx.appcompat.widget.s f1111r;

    /* renamed from: s, reason: collision with root package name */
    private f f1112s;

    /* renamed from: t, reason: collision with root package name */
    private q f1113t;

    /* renamed from: u, reason: collision with root package name */
    androidx.appcompat.view.b f1114u;

    /* renamed from: v, reason: collision with root package name */
    ActionBarContextView f1115v;

    /* renamed from: w, reason: collision with root package name */
    PopupWindow f1116w;

    /* renamed from: x, reason: collision with root package name */
    Runnable f1117x;

    /* renamed from: y, reason: collision with root package name */
    ViewPropertyAnimatorCompat f1118y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f1119z;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class PanelFeatureState {

        /* renamed from: a, reason: collision with root package name */
        int f1121a;

        /* renamed from: b, reason: collision with root package name */
        int f1122b;

        /* renamed from: c, reason: collision with root package name */
        int f1123c;

        /* renamed from: d, reason: collision with root package name */
        int f1124d;

        /* renamed from: e, reason: collision with root package name */
        int f1125e;

        /* renamed from: f, reason: collision with root package name */
        int f1126f;

        /* renamed from: g, reason: collision with root package name */
        ViewGroup f1127g;

        /* renamed from: h, reason: collision with root package name */
        View f1128h;

        /* renamed from: i, reason: collision with root package name */
        View f1129i;

        /* renamed from: j, reason: collision with root package name */
        androidx.appcompat.view.menu.f f1130j;

        /* renamed from: k, reason: collision with root package name */
        androidx.appcompat.view.menu.d f1131k;

        /* renamed from: l, reason: collision with root package name */
        Context f1132l;

        /* renamed from: m, reason: collision with root package name */
        boolean f1133m;

        /* renamed from: n, reason: collision with root package name */
        boolean f1134n;

        /* renamed from: o, reason: collision with root package name */
        boolean f1135o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f1136p;

        /* renamed from: q, reason: collision with root package name */
        boolean f1137q = false;

        /* renamed from: r, reason: collision with root package name */
        boolean f1138r;

        /* renamed from: s, reason: collision with root package name */
        Bundle f1139s;

        /* JADX INFO: Access modifiers changed from: private */
        @SuppressLint({"BanParcelableUsage"})
        /* loaded from: classes.dex */
        public static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();

            /* renamed from: a, reason: collision with root package name */
            int f1140a;

            /* renamed from: b, reason: collision with root package name */
            boolean f1141b;

            /* renamed from: c, reason: collision with root package name */
            Bundle f1142c;

            /* loaded from: classes.dex */
            class a implements Parcelable.ClassLoaderCreator {
                a() {
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.a(parcel, null);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.a(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public SavedState[] newArray(int i11) {
                    return new SavedState[i11];
                }
            }

            SavedState() {
            }

            static SavedState a(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.f1140a = parcel.readInt();
                boolean z10 = parcel.readInt() == 1;
                savedState.f1141b = z10;
                if (z10) {
                    savedState.f1142c = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i11) {
                parcel.writeInt(this.f1140a);
                parcel.writeInt(this.f1141b ? 1 : 0);
                if (this.f1141b) {
                    parcel.writeBundle(this.f1142c);
                }
            }
        }

        PanelFeatureState(int i11) {
            this.f1121a = i11;
        }

        androidx.appcompat.view.menu.m a(l.a aVar) {
            if (this.f1130j == null) {
                return null;
            }
            if (this.f1131k == null) {
                androidx.appcompat.view.menu.d dVar = new androidx.appcompat.view.menu.d(this.f1132l, R$layout.abc_list_menu_item_layout);
                this.f1131k = dVar;
                dVar.d(aVar);
                this.f1130j.b(this.f1131k);
            }
            return this.f1131k.l(this.f1127g);
        }

        public boolean b() {
            if (this.f1128h == null) {
                return false;
            }
            return this.f1129i != null || this.f1131k.a().getCount() > 0;
        }

        void c(androidx.appcompat.view.menu.f fVar) {
            androidx.appcompat.view.menu.d dVar;
            androidx.appcompat.view.menu.f fVar2 = this.f1130j;
            if (fVar == fVar2) {
                return;
            }
            if (fVar2 != null) {
                fVar2.R(this.f1131k);
            }
            this.f1130j = fVar;
            if (fVar == null || (dVar = this.f1131k) == null) {
                return;
            }
            fVar.b(dVar);
        }

        void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true);
            int i11 = typedValue.resourceId;
            if (i11 != 0) {
                newTheme.applyStyle(i11, true);
            }
            newTheme.resolveAttribute(R$attr.panelMenuListTheme, typedValue, true);
            int i12 = typedValue.resourceId;
            if (i12 != 0) {
                newTheme.applyStyle(i12, true);
            } else {
                newTheme.applyStyle(R$style.Theme_AppCompat_CompactMenu, true);
            }
            androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.f1132l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(R$styleable.AppCompatTheme);
            this.f1122b = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_panelBackground, 0);
            this.f1126f = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements OnApplyWindowInsetsListener {
        a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            int h12 = AppCompatDelegateImpl.this.h1(windowInsetsCompat, null);
            if (systemWindowInsetTop != h12) {
                windowInsetsCompat = windowInsetsCompat.replaceSystemWindowInsets(windowInsetsCompat.getSystemWindowInsetLeft(), h12, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            }
            return ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements ContentFrameLayout.a {
        b() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            AppCompatDelegateImpl.this.j0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends ViewPropertyAnimatorListenerAdapter {
        c() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            AppCompatDelegateImpl.this.f1115v.setAlpha(1.0f);
            AppCompatDelegateImpl.this.f1118y.setListener(null);
            AppCompatDelegateImpl.this.f1118y = null;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
            AppCompatDelegateImpl.this.f1115v.setVisibility(0);
            if (AppCompatDelegateImpl.this.f1115v.getParent() instanceof View) {
                ViewCompat.requestApplyInsets((View) AppCompatDelegateImpl.this.f1115v.getParent());
            }
        }
    }

    /* loaded from: classes.dex */
    private class d implements androidx.appcompat.app.b {
        d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        boolean a(int i11);

        View onCreatePanelView(int i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class f implements l.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.l.a
        public void b(androidx.appcompat.view.menu.f fVar, boolean z10) {
            AppCompatDelegateImpl.this.d0(fVar);
        }

        @Override // androidx.appcompat.view.menu.l.a
        public boolean c(androidx.appcompat.view.menu.f fVar) {
            Window.Callback y02 = AppCompatDelegateImpl.this.y0();
            if (y02 == null) {
                return true;
            }
            y02.onMenuOpened(TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY, fVar);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements b.a {

        /* renamed from: a, reason: collision with root package name */
        private b.a f1148a;

        /* loaded from: classes.dex */
        class a extends ViewPropertyAnimatorListenerAdapter {
            a() {
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                AppCompatDelegateImpl.this.f1115v.setVisibility(8);
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                PopupWindow popupWindow = appCompatDelegateImpl.f1116w;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (appCompatDelegateImpl.f1115v.getParent() instanceof View) {
                    ViewCompat.requestApplyInsets((View) AppCompatDelegateImpl.this.f1115v.getParent());
                }
                AppCompatDelegateImpl.this.f1115v.killMode();
                AppCompatDelegateImpl.this.f1118y.setListener(null);
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl2.f1118y = null;
                ViewCompat.requestApplyInsets(appCompatDelegateImpl2.B);
            }
        }

        public g(b.a aVar) {
            this.f1148a = aVar;
        }

        @Override // androidx.appcompat.view.b.a
        public void a(androidx.appcompat.view.b bVar) {
            this.f1148a.a(bVar);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.f1116w != null) {
                appCompatDelegateImpl.f1105l.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.f1117x);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl2.f1115v != null) {
                appCompatDelegateImpl2.m0();
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl3.f1118y = ViewCompat.animate(appCompatDelegateImpl3.f1115v).alpha(0.0f);
                AppCompatDelegateImpl.this.f1118y.setListener(new a());
            }
            AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
            androidx.appcompat.app.d dVar = appCompatDelegateImpl4.f1107n;
            if (dVar != null) {
                dVar.onSupportActionModeFinished(appCompatDelegateImpl4.f1114u);
            }
            AppCompatDelegateImpl appCompatDelegateImpl5 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl5.f1114u = null;
            ViewCompat.requestApplyInsets(appCompatDelegateImpl5.B);
            AppCompatDelegateImpl.this.f1();
        }

        @Override // androidx.appcompat.view.b.a
        public boolean b(androidx.appcompat.view.b bVar, Menu menu) {
            return this.f1148a.b(bVar, menu);
        }

        @Override // androidx.appcompat.view.b.a
        public boolean c(androidx.appcompat.view.b bVar, MenuItem menuItem) {
            return this.f1148a.c(bVar, menuItem);
        }

        @Override // androidx.appcompat.view.b.a
        public boolean d(androidx.appcompat.view.b bVar, Menu menu) {
            ViewCompat.requestApplyInsets(AppCompatDelegateImpl.this.B);
            return this.f1148a.d(bVar, menu);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class h {
        static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }

        static String b(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i {
        static void a(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
            LocaleList locales;
            LocaleList locales2;
            boolean equals;
            locales = configuration.getLocales();
            locales2 = configuration2.getLocales();
            equals = locales.equals(locales2);
            if (equals) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }

        static androidx.core.os.i b(Configuration configuration) {
            LocaleList locales;
            String languageTags;
            locales = configuration.getLocales();
            languageTags = locales.toLanguageTags();
            return androidx.core.os.i.c(languageTags);
        }

        public static void c(androidx.core.os.i iVar) {
            LocaleList forLanguageTags;
            forLanguageTags = LocaleList.forLanguageTags(iVar.h());
            LocaleList.setDefault(forLanguageTags);
        }

        static void d(Configuration configuration, androidx.core.os.i iVar) {
            LocaleList forLanguageTags;
            forLanguageTags = LocaleList.forLanguageTags(iVar.h());
            configuration.setLocales(forLanguageTags);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class j {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i11;
            int i12;
            int i13;
            int i14;
            int i15;
            int i16;
            int i17;
            int i18;
            i11 = configuration.colorMode;
            int i19 = i11 & 3;
            i12 = configuration2.colorMode;
            if (i19 != (i12 & 3)) {
                i17 = configuration3.colorMode;
                i18 = configuration2.colorMode;
                configuration3.colorMode = i17 | (i18 & 3);
            }
            i13 = configuration.colorMode;
            int i20 = i13 & 12;
            i14 = configuration2.colorMode;
            if (i20 != (i14 & 12)) {
                i15 = configuration3.colorMode;
                i16 = configuration2.colorMode;
                configuration3.colorMode = i15 | (i16 & 12);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class k {
        static OnBackInvokedDispatcher a(Activity activity) {
            OnBackInvokedDispatcher onBackInvokedDispatcher;
            onBackInvokedDispatcher = activity.getOnBackInvokedDispatcher();
            return onBackInvokedDispatcher;
        }

        static OnBackInvokedCallback b(Object obj, final AppCompatDelegateImpl appCompatDelegateImpl) {
            Objects.requireNonNull(appCompatDelegateImpl);
            OnBackInvokedCallback onBackInvokedCallback = new OnBackInvokedCallback() { // from class: androidx.appcompat.app.u
                public final void onBackInvoked() {
                    AppCompatDelegateImpl.this.G0();
                }
            };
            androidx.appcompat.app.q.a(obj).registerOnBackInvokedCallback(1000000, onBackInvokedCallback);
            return onBackInvokedCallback;
        }

        static void c(Object obj, Object obj2) {
            androidx.appcompat.app.q.a(obj).unregisterOnBackInvokedCallback(androidx.appcompat.app.p.a(obj2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class l extends androidx.appcompat.view.i {

        /* renamed from: b, reason: collision with root package name */
        private e f1151b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f1152c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f1153d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f1154e;

        l(Window.Callback callback) {
            super(callback);
        }

        public boolean b(Window.Callback callback, KeyEvent keyEvent) {
            try {
                this.f1153d = true;
                return callback.dispatchKeyEvent(keyEvent);
            } finally {
                this.f1153d = false;
            }
        }

        public void c(Window.Callback callback) {
            try {
                this.f1152c = true;
                callback.onContentChanged();
            } finally {
                this.f1152c = false;
            }
        }

        public void d(Window.Callback callback, int i11, Menu menu) {
            try {
                this.f1154e = true;
                callback.onPanelClosed(i11, menu);
            } finally {
                this.f1154e = false;
            }
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.f1153d ? a().dispatchKeyEvent(keyEvent) : AppCompatDelegateImpl.this.k0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.J0(keyEvent.getKeyCode(), keyEvent);
        }

        void e(e eVar) {
            this.f1151b = eVar;
        }

        final ActionMode f(ActionMode.Callback callback) {
            f.a aVar = new f.a(AppCompatDelegateImpl.this.f1104k, callback);
            androidx.appcompat.view.b T = AppCompatDelegateImpl.this.T(aVar);
            if (T != null) {
                return aVar.e(T);
            }
            return null;
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
            if (this.f1152c) {
                a().onContentChanged();
            }
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i11, Menu menu) {
            if (i11 != 0 || (menu instanceof androidx.appcompat.view.menu.f)) {
                return super.onCreatePanelMenu(i11, menu);
            }
            return false;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public View onCreatePanelView(int i11) {
            View onCreatePanelView;
            e eVar = this.f1151b;
            return (eVar == null || (onCreatePanelView = eVar.onCreatePanelView(i11)) == null) ? super.onCreatePanelView(i11) : onCreatePanelView;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onMenuOpened(int i11, Menu menu) {
            super.onMenuOpened(i11, menu);
            AppCompatDelegateImpl.this.M0(i11);
            return true;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public void onPanelClosed(int i11, Menu menu) {
            if (this.f1154e) {
                a().onPanelClosed(i11, menu);
            } else {
                super.onPanelClosed(i11, menu);
                AppCompatDelegateImpl.this.N0(i11);
            }
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onPreparePanel(int i11, View view, Menu menu) {
            androidx.appcompat.view.menu.f fVar = menu instanceof androidx.appcompat.view.menu.f ? (androidx.appcompat.view.menu.f) menu : null;
            if (i11 == 0 && fVar == null) {
                return false;
            }
            if (fVar != null) {
                fVar.f0(true);
            }
            e eVar = this.f1151b;
            boolean z10 = eVar != null && eVar.a(i11);
            if (!z10) {
                z10 = super.onPreparePanel(i11, view, menu);
            }
            if (fVar != null) {
                fVar.f0(false);
            }
            return z10;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List list, Menu menu, int i11) {
            androidx.appcompat.view.menu.f fVar;
            PanelFeatureState w02 = AppCompatDelegateImpl.this.w0(0, true);
            if (w02 == null || (fVar = w02.f1130j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i11);
            } else {
                super.onProvideKeyboardShortcuts(list, fVar, i11);
            }
        }

        @Override // android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i11) {
            return (AppCompatDelegateImpl.this.E0() && i11 == 0) ? f(callback) : super.onWindowStartingActionMode(callback, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class m extends n {

        /* renamed from: c, reason: collision with root package name */
        private final PowerManager f1156c;

        m(Context context) {
            super();
            this.f1156c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.n
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.n
        public int c() {
            return h.a(this.f1156c) ? 2 : 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.n
        public void d() {
            AppCompatDelegateImpl.this.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public abstract class n {

        /* renamed from: a, reason: collision with root package name */
        private BroadcastReceiver f1158a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends BroadcastReceiver {
            a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                n.this.d();
            }
        }

        n() {
        }

        void a() {
            BroadcastReceiver broadcastReceiver = this.f1158a;
            if (broadcastReceiver != null) {
                try {
                    AppCompatDelegateImpl.this.f1104k.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f1158a = null;
            }
        }

        abstract IntentFilter b();

        abstract int c();

        abstract void d();

        void e() {
            a();
            IntentFilter b11 = b();
            if (b11 == null || b11.countActions() == 0) {
                return;
            }
            if (this.f1158a == null) {
                this.f1158a = new a();
            }
            AppCompatDelegateImpl.this.f1104k.registerReceiver(this.f1158a, b11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class o extends n {

        /* renamed from: c, reason: collision with root package name */
        private final c0 f1161c;

        o(c0 c0Var) {
            super();
            this.f1161c = c0Var;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.n
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.n
        public int c() {
            return this.f1161c.d() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.n
        public void d() {
            AppCompatDelegateImpl.this.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class p extends ContentFrameLayout {
        public p(Context context) {
            super(context);
        }

        private boolean a(int i11, int i12) {
            return i11 < -5 || i12 < -5 || i11 > getWidth() + 5 || i12 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.k0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AppCompatDelegateImpl.this.f0(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i11) {
            setBackgroundDrawable(g.a.b(getContext(), i11));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class q implements l.a {
        q() {
        }

        @Override // androidx.appcompat.view.menu.l.a
        public void b(androidx.appcompat.view.menu.f fVar, boolean z10) {
            androidx.appcompat.view.menu.f F = fVar.F();
            boolean z11 = F != fVar;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z11) {
                fVar = F;
            }
            PanelFeatureState p02 = appCompatDelegateImpl.p0(fVar);
            if (p02 != null) {
                if (!z11) {
                    AppCompatDelegateImpl.this.g0(p02, z10);
                } else {
                    AppCompatDelegateImpl.this.c0(p02.f1121a, p02, F);
                    AppCompatDelegateImpl.this.g0(p02, true);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.l.a
        public boolean c(androidx.appcompat.view.menu.f fVar) {
            Window.Callback y02;
            if (fVar != fVar.F()) {
                return true;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.G || (y02 = appCompatDelegateImpl.y0()) == null || AppCompatDelegateImpl.this.R) {
                return true;
            }
            y02.onMenuOpened(TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY, fVar);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatDelegateImpl(Activity activity, androidx.appcompat.app.d dVar) {
        this(activity, null, dVar, activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatDelegateImpl(Dialog dialog, androidx.appcompat.app.d dVar) {
        this(dialog.getContext(), dialog.getWindow(), dVar, dialog);
    }

    private AppCompatDelegateImpl(Context context, Window window, androidx.appcompat.app.d dVar, Object obj) {
        AppCompatActivity c12;
        this.f1118y = null;
        this.f1119z = true;
        this.T = -100;
        this.f1095b0 = new Runnable() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.2
            @Override // java.lang.Runnable
            public void run() {
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                if ((appCompatDelegateImpl.f1094a0 & 1) != 0) {
                    appCompatDelegateImpl.l0(0);
                }
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                if ((appCompatDelegateImpl2.f1094a0 & 4096) != 0) {
                    appCompatDelegateImpl2.l0(TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY);
                }
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl3.Z = false;
                appCompatDelegateImpl3.f1094a0 = 0;
            }
        };
        this.f1104k = context;
        this.f1107n = dVar;
        this.f1103j = obj;
        if (this.T == -100 && (obj instanceof Dialog) && (c12 = c1()) != null) {
            this.T = c12.getDelegate().r();
        }
        if (this.T == -100) {
            x0 x0Var = f1090j0;
            Integer num = (Integer) x0Var.get(obj.getClass().getName());
            if (num != null) {
                this.T = num.intValue();
                x0Var.remove(obj.getClass().getName());
            }
        }
        if (window != null) {
            Z(window);
        }
        androidx.appcompat.widget.f.h();
    }

    private boolean A0(PanelFeatureState panelFeatureState) {
        View view = panelFeatureState.f1129i;
        if (view != null) {
            panelFeatureState.f1128h = view;
            return true;
        }
        if (panelFeatureState.f1130j == null) {
            return false;
        }
        if (this.f1113t == null) {
            this.f1113t = new q();
        }
        View view2 = (View) panelFeatureState.a(this.f1113t);
        panelFeatureState.f1128h = view2;
        return view2 != null;
    }

    private boolean B0(PanelFeatureState panelFeatureState) {
        panelFeatureState.d(r0());
        panelFeatureState.f1127g = new p(panelFeatureState.f1132l);
        panelFeatureState.f1123c = 81;
        return true;
    }

    private boolean C0(PanelFeatureState panelFeatureState) {
        Resources.Theme theme;
        Context context = this.f1104k;
        int i11 = panelFeatureState.f1121a;
        if ((i11 == 0 || i11 == 108) && this.f1111r != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme2 = context.getTheme();
            theme2.resolveAttribute(R$attr.actionBarTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                theme = context.getResources().newTheme();
                theme.setTo(theme2);
                theme.applyStyle(typedValue.resourceId, true);
                theme.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme2.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
                theme = null;
            }
            if (typedValue.resourceId != 0) {
                if (theme == null) {
                    theme = context.getResources().newTheme();
                    theme.setTo(theme2);
                }
                theme.applyStyle(typedValue.resourceId, true);
            }
            if (theme != null) {
                androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
                dVar.getTheme().setTo(theme);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.f fVar = new androidx.appcompat.view.menu.f(context);
        fVar.W(this);
        panelFeatureState.c(fVar);
        return true;
    }

    private void D0(int i11) {
        this.f1094a0 = (1 << i11) | this.f1094a0;
        if (this.Z) {
            return;
        }
        ViewCompat.postOnAnimation(this.f1105l.getDecorView(), this.f1095b0);
        this.Z = true;
    }

    private boolean I0(int i11, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        PanelFeatureState w02 = w0(i11, true);
        if (w02.f1135o) {
            return false;
        }
        return S0(w02, keyEvent);
    }

    private boolean L0(int i11, KeyEvent keyEvent) {
        boolean z10;
        androidx.appcompat.widget.s sVar;
        if (this.f1114u != null) {
            return false;
        }
        boolean z11 = true;
        PanelFeatureState w02 = w0(i11, true);
        if (i11 != 0 || (sVar = this.f1111r) == null || !sVar.canShowOverflowMenu() || ViewConfiguration.get(this.f1104k).hasPermanentMenuKey()) {
            boolean z12 = w02.f1135o;
            if (z12 || w02.f1134n) {
                g0(w02, true);
                z11 = z12;
            } else {
                if (w02.f1133m) {
                    if (w02.f1138r) {
                        w02.f1133m = false;
                        z10 = S0(w02, keyEvent);
                    } else {
                        z10 = true;
                    }
                    if (z10) {
                        P0(w02, keyEvent);
                    }
                }
                z11 = false;
            }
        } else if (this.f1111r.isOverflowMenuShowing()) {
            z11 = this.f1111r.hideOverflowMenu();
        } else {
            if (!this.R && S0(w02, keyEvent)) {
                z11 = this.f1111r.showOverflowMenu();
            }
            z11 = false;
        }
        if (z11) {
            AudioManager audioManager = (AudioManager) this.f1104k.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z11;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void P0(androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState r12, android.view.KeyEvent r13) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.P0(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, android.view.KeyEvent):void");
    }

    private boolean R0(PanelFeatureState panelFeatureState, int i11, KeyEvent keyEvent, int i12) {
        androidx.appcompat.view.menu.f fVar;
        boolean z10 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.f1133m || S0(panelFeatureState, keyEvent)) && (fVar = panelFeatureState.f1130j) != null) {
            z10 = fVar.performShortcut(i11, keyEvent, i12);
        }
        if (z10 && (i12 & 1) == 0 && this.f1111r == null) {
            g0(panelFeatureState, true);
        }
        return z10;
    }

    private boolean S0(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        androidx.appcompat.widget.s sVar;
        androidx.appcompat.widget.s sVar2;
        androidx.appcompat.widget.s sVar3;
        if (this.R) {
            return false;
        }
        if (panelFeatureState.f1133m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.N;
        if (panelFeatureState2 != null && panelFeatureState2 != panelFeatureState) {
            g0(panelFeatureState2, false);
        }
        Window.Callback y02 = y0();
        if (y02 != null) {
            panelFeatureState.f1129i = y02.onCreatePanelView(panelFeatureState.f1121a);
        }
        int i11 = panelFeatureState.f1121a;
        boolean z10 = i11 == 0 || i11 == 108;
        if (z10 && (sVar3 = this.f1111r) != null) {
            sVar3.setMenuPrepared();
        }
        if (panelFeatureState.f1129i == null && (!z10 || !(Q0() instanceof ToolbarActionBar))) {
            androidx.appcompat.view.menu.f fVar = panelFeatureState.f1130j;
            if (fVar == null || panelFeatureState.f1138r) {
                if (fVar == null && (!C0(panelFeatureState) || panelFeatureState.f1130j == null)) {
                    return false;
                }
                if (z10 && this.f1111r != null) {
                    if (this.f1112s == null) {
                        this.f1112s = new f();
                    }
                    this.f1111r.setMenu(panelFeatureState.f1130j, this.f1112s);
                }
                panelFeatureState.f1130j.i0();
                if (!y02.onCreatePanelMenu(panelFeatureState.f1121a, panelFeatureState.f1130j)) {
                    panelFeatureState.c(null);
                    if (z10 && (sVar = this.f1111r) != null) {
                        sVar.setMenu(null, this.f1112s);
                    }
                    return false;
                }
                panelFeatureState.f1138r = false;
            }
            panelFeatureState.f1130j.i0();
            Bundle bundle = panelFeatureState.f1139s;
            if (bundle != null) {
                panelFeatureState.f1130j.S(bundle);
                panelFeatureState.f1139s = null;
            }
            if (!y02.onPreparePanel(0, panelFeatureState.f1129i, panelFeatureState.f1130j)) {
                if (z10 && (sVar2 = this.f1111r) != null) {
                    sVar2.setMenu(null, this.f1112s);
                }
                panelFeatureState.f1130j.h0();
                return false;
            }
            boolean z11 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.f1136p = z11;
            panelFeatureState.f1130j.setQwertyMode(z11);
            panelFeatureState.f1130j.h0();
        }
        panelFeatureState.f1133m = true;
        panelFeatureState.f1134n = false;
        this.N = panelFeatureState;
        return true;
    }

    private void T0(boolean z10) {
        androidx.appcompat.widget.s sVar = this.f1111r;
        if (sVar == null || !sVar.canShowOverflowMenu() || (ViewConfiguration.get(this.f1104k).hasPermanentMenuKey() && !this.f1111r.isOverflowMenuShowPending())) {
            PanelFeatureState w02 = w0(0, true);
            w02.f1137q = true;
            g0(w02, false);
            P0(w02, null);
            return;
        }
        Window.Callback y02 = y0();
        if (this.f1111r.isOverflowMenuShowing() && z10) {
            this.f1111r.hideOverflowMenu();
            if (this.R) {
                return;
            }
            y02.onPanelClosed(TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY, w0(0, true).f1130j);
            return;
        }
        if (y02 == null || this.R) {
            return;
        }
        if (this.Z && (this.f1094a0 & 1) != 0) {
            this.f1105l.getDecorView().removeCallbacks(this.f1095b0);
            this.f1095b0.run();
        }
        PanelFeatureState w03 = w0(0, true);
        androidx.appcompat.view.menu.f fVar = w03.f1130j;
        if (fVar == null || w03.f1138r || !y02.onPreparePanel(0, w03.f1129i, fVar)) {
            return;
        }
        y02.onMenuOpened(TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY, w03.f1130j);
        this.f1111r.showOverflowMenu();
    }

    private int U0(int i11) {
        if (i11 == 8) {
            return TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY;
        }
        if (i11 == 9) {
            return 109;
        }
        return i11;
    }

    private boolean W(boolean z10) {
        return X(z10, true);
    }

    private boolean X(boolean z10, boolean z11) {
        if (this.R) {
            return false;
        }
        int b02 = b0();
        int F0 = F0(this.f1104k, b02);
        androidx.core.os.i a02 = Build.VERSION.SDK_INT < 33 ? a0(this.f1104k) : null;
        if (!z11 && a02 != null) {
            a02 = v0(this.f1104k.getResources().getConfiguration());
        }
        boolean e12 = e1(F0, a02, z10);
        if (b02 == 0) {
            u0(this.f1104k).e();
        } else {
            n nVar = this.X;
            if (nVar != null) {
                nVar.a();
            }
        }
        if (b02 == 3) {
            t0(this.f1104k).e();
        } else {
            n nVar2 = this.Y;
            if (nVar2 != null) {
                nVar2.a();
            }
        }
        return e12;
    }

    private void Y() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.B.findViewById(R.id.content);
        View decorView = this.f1105l.getDecorView();
        contentFrameLayout.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f1104k.obtainStyledAttributes(R$styleable.AppCompatTheme);
        obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private boolean Y0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f1105l.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || ((View) viewParent).isAttachedToWindow()) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private void Z(Window window) {
        if (this.f1105l != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof l) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        l lVar = new l(callback);
        this.f1106m = lVar;
        window.setCallback(lVar);
        j0 u11 = j0.u(this.f1104k, null, f1092l0);
        Drawable h11 = u11.h(0);
        if (h11 != null) {
            window.setBackgroundDrawable(h11);
        }
        u11.x();
        this.f1105l = window;
        if (Build.VERSION.SDK_INT < 33 || this.f1101h0 != null) {
            return;
        }
        P(null);
    }

    private int b0() {
        int i11 = this.T;
        return i11 != -100 ? i11 : androidx.appcompat.app.f.p();
    }

    private void b1() {
        if (this.A) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private AppCompatActivity c1() {
        for (Context context = this.f1104k; context != null; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof AppCompatActivity) {
                return (AppCompatActivity) context;
            }
            if (!(context instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void d1(Configuration configuration) {
        Activity activity = (Activity) this.f1103j;
        if (activity instanceof androidx.view.u) {
            if (((androidx.view.u) activity).getLifecycle().b().isAtLeast(Lifecycle.State.CREATED)) {
                activity.onConfigurationChanged(configuration);
            }
        } else {
            if (!this.Q || this.R) {
                return;
            }
            activity.onConfigurationChanged(configuration);
        }
    }

    private void e0() {
        n nVar = this.X;
        if (nVar != null) {
            nVar.a();
        }
        n nVar2 = this.Y;
        if (nVar2 != null) {
            nVar2.a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean e1(int r10, androidx.core.os.i r11, boolean r12) {
        /*
            r9 = this;
            android.content.Context r1 = r9.f1104k
            r4 = 0
            r5 = 0
            r0 = r9
            r2 = r10
            r3 = r11
            android.content.res.Configuration r0 = r0.h0(r1, r2, r3, r4, r5)
            android.content.Context r1 = r9.f1104k
            int r1 = r9.s0(r1)
            android.content.res.Configuration r2 = r9.S
            if (r2 != 0) goto L1f
            android.content.Context r2 = r9.f1104k
            android.content.res.Resources r2 = r2.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
        L1f:
            int r3 = r2.uiMode
            r3 = r3 & 48
            int r4 = r0.uiMode
            r4 = r4 & 48
            androidx.core.os.i r2 = r9.v0(r2)
            r5 = 0
            if (r11 != 0) goto L30
            r6 = r5
            goto L34
        L30:
            androidx.core.os.i r6 = r9.v0(r0)
        L34:
            r7 = 0
            if (r3 == r4) goto L3a
            r3 = 512(0x200, float:7.175E-43)
            goto L3b
        L3a:
            r3 = r7
        L3b:
            if (r6 == 0) goto L45
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto L45
            r3 = r3 | 8196(0x2004, float:1.1485E-41)
        L45:
            int r2 = ~r1
            r2 = r2 & r3
            r8 = 1
            if (r2 == 0) goto L8c
            if (r12 == 0) goto L8c
            boolean r12 = r9.P
            if (r12 == 0) goto L8c
            boolean r12 = androidx.appcompat.app.AppCompatDelegateImpl.f1093m0
            if (r12 != 0) goto L58
            boolean r12 = r9.Q
            if (r12 == 0) goto L8c
        L58:
            java.lang.Object r12 = r9.f1103j
            boolean r2 = r12 instanceof android.app.Activity
            if (r2 == 0) goto L8c
            android.app.Activity r12 = (android.app.Activity) r12
            boolean r12 = r12.isChild()
            if (r12 != 0) goto L8c
            int r12 = android.os.Build.VERSION.SDK_INT
            r2 = 31
            if (r12 < r2) goto L83
            r12 = r3 & 8192(0x2000, float:1.14794E-41)
            if (r12 == 0) goto L83
            java.lang.Object r12 = r9.f1103j
            android.app.Activity r12 = (android.app.Activity) r12
            android.view.Window r12 = r12.getWindow()
            android.view.View r12 = r12.getDecorView()
            int r0 = r0.getLayoutDirection()
            r12.setLayoutDirection(r0)
        L83:
            java.lang.Object r12 = r9.f1103j
            android.app.Activity r12 = (android.app.Activity) r12
            androidx.core.app.ActivityCompat.f(r12)
            r12 = r8
            goto L8d
        L8c:
            r12 = r7
        L8d:
            if (r12 != 0) goto L9a
            if (r3 == 0) goto L9a
            r12 = r3 & r1
            if (r12 != r3) goto L96
            r7 = r8
        L96:
            r9.g1(r4, r6, r7, r5)
            goto L9b
        L9a:
            r8 = r12
        L9b:
            if (r8 == 0) goto Lb7
            java.lang.Object r12 = r9.f1103j
            boolean r0 = r12 instanceof androidx.appcompat.app.AppCompatActivity
            if (r0 == 0) goto Lb7
            r0 = r3 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto Lac
            androidx.appcompat.app.AppCompatActivity r12 = (androidx.appcompat.app.AppCompatActivity) r12
            r12.onNightModeChanged(r10)
        Lac:
            r10 = r3 & 4
            if (r10 == 0) goto Lb7
            java.lang.Object r10 = r9.f1103j
            androidx.appcompat.app.AppCompatActivity r10 = (androidx.appcompat.app.AppCompatActivity) r10
            r10.onLocalesChanged(r11)
        Lb7:
            if (r6 == 0) goto Lca
            android.content.Context r10 = r9.f1104k
            android.content.res.Resources r10 = r10.getResources()
            android.content.res.Configuration r10 = r10.getConfiguration()
            androidx.core.os.i r10 = r9.v0(r10)
            r9.W0(r10)
        Lca:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.e1(int, androidx.core.os.i, boolean):boolean");
    }

    private void g1(int i11, androidx.core.os.i iVar, boolean z10, Configuration configuration) {
        Resources resources = this.f1104k.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i11 | (resources.getConfiguration().uiMode & (-49));
        if (iVar != null) {
            V0(configuration2, iVar);
        }
        resources.updateConfiguration(configuration2, null);
        if (Build.VERSION.SDK_INT < 26) {
            a0.a(resources);
        }
        int i12 = this.U;
        if (i12 != 0) {
            this.f1104k.setTheme(i12);
            this.f1104k.getTheme().applyStyle(this.U, true);
        }
        if (z10 && (this.f1103j instanceof Activity)) {
            d1(configuration2);
        }
    }

    private Configuration h0(Context context, int i11, androidx.core.os.i iVar, Configuration configuration, boolean z10) {
        int i12 = i11 != 1 ? i11 != 2 ? z10 ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i12 | (configuration2.uiMode & (-49));
        if (iVar != null) {
            V0(configuration2, iVar);
        }
        return configuration2;
    }

    private ViewGroup i0() {
        ViewGroup viewGroup;
        TypedArray obtainStyledAttributes = this.f1104k.obtainStyledAttributes(R$styleable.AppCompatTheme);
        if (!obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowActionBar)) {
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowNoTitle, false)) {
            K(1);
        } else if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionBar, false)) {
            K(TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY);
        }
        if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionBarOverlay, false)) {
            K(109);
        }
        if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            K(10);
        }
        this.J = obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_android_windowIsFloating, false);
        obtainStyledAttributes.recycle();
        o0();
        this.f1105l.getDecorView();
        LayoutInflater from = LayoutInflater.from(this.f1104k);
        if (this.K) {
            viewGroup = this.I ? (ViewGroup) from.inflate(R$layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(R$layout.abc_screen_simple, (ViewGroup) null);
        } else if (this.J) {
            viewGroup = (ViewGroup) from.inflate(R$layout.abc_dialog_title_material, (ViewGroup) null);
            this.H = false;
            this.G = false;
        } else if (this.G) {
            TypedValue typedValue = new TypedValue();
            this.f1104k.getTheme().resolveAttribute(R$attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new androidx.appcompat.view.d(this.f1104k, typedValue.resourceId) : this.f1104k).inflate(R$layout.abc_screen_toolbar, (ViewGroup) null);
            androidx.appcompat.widget.s sVar = (androidx.appcompat.widget.s) viewGroup.findViewById(R$id.decor_content_parent);
            this.f1111r = sVar;
            sVar.setWindowCallback(y0());
            if (this.H) {
                this.f1111r.initFeature(109);
            }
            if (this.E) {
                this.f1111r.initFeature(2);
            }
            if (this.F) {
                this.f1111r.initFeature(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.G + ", windowActionBarOverlay: " + this.H + ", android:windowIsFloating: " + this.J + ", windowActionModeOverlay: " + this.I + ", windowNoTitle: " + this.K + " }");
        }
        ViewCompat.setOnApplyWindowInsetsListener(viewGroup, new a());
        if (this.f1111r == null) {
            this.C = (TextView) viewGroup.findViewById(R$id.title);
        }
        u0.c(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R$id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.f1105l.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f1105l.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new b());
        return viewGroup;
    }

    private void i1(View view) {
        view.setBackgroundColor((ViewCompat.getWindowSystemUiVisibility(view) & 8192) != 0 ? androidx.core.content.b.getColor(this.f1104k, R$color.abc_decor_view_status_guard_light) : androidx.core.content.b.getColor(this.f1104k, R$color.abc_decor_view_status_guard));
    }

    private void n0() {
        if (this.A) {
            return;
        }
        this.B = i0();
        CharSequence x02 = x0();
        if (!TextUtils.isEmpty(x02)) {
            androidx.appcompat.widget.s sVar = this.f1111r;
            if (sVar != null) {
                sVar.setWindowTitle(x02);
            } else if (Q0() != null) {
                Q0().u(x02);
            } else {
                TextView textView = this.C;
                if (textView != null) {
                    textView.setText(x02);
                }
            }
        }
        Y();
        O0(this.B);
        this.A = true;
        PanelFeatureState w02 = w0(0, false);
        if (this.R) {
            return;
        }
        if (w02 == null || w02.f1130j == null) {
            D0(TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY);
        }
    }

    private void o0() {
        if (this.f1105l == null) {
            Object obj = this.f1103j;
            if (obj instanceof Activity) {
                Z(((Activity) obj).getWindow());
            }
        }
        if (this.f1105l == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private static Configuration q0(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f11 = configuration.fontScale;
            float f12 = configuration2.fontScale;
            if (f11 != f12) {
                configuration3.fontScale = f12;
            }
            int i11 = configuration.mcc;
            int i12 = configuration2.mcc;
            if (i11 != i12) {
                configuration3.mcc = i12;
            }
            int i13 = configuration.mnc;
            int i14 = configuration2.mnc;
            if (i13 != i14) {
                configuration3.mnc = i14;
            }
            int i15 = Build.VERSION.SDK_INT;
            if (i15 >= 24) {
                i.a(configuration, configuration2, configuration3);
            } else if (!androidx.core.util.d.a(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i16 = configuration.touchscreen;
            int i17 = configuration2.touchscreen;
            if (i16 != i17) {
                configuration3.touchscreen = i17;
            }
            int i18 = configuration.keyboard;
            int i19 = configuration2.keyboard;
            if (i18 != i19) {
                configuration3.keyboard = i19;
            }
            int i20 = configuration.keyboardHidden;
            int i21 = configuration2.keyboardHidden;
            if (i20 != i21) {
                configuration3.keyboardHidden = i21;
            }
            int i22 = configuration.navigation;
            int i23 = configuration2.navigation;
            if (i22 != i23) {
                configuration3.navigation = i23;
            }
            int i24 = configuration.navigationHidden;
            int i25 = configuration2.navigationHidden;
            if (i24 != i25) {
                configuration3.navigationHidden = i25;
            }
            int i26 = configuration.orientation;
            int i27 = configuration2.orientation;
            if (i26 != i27) {
                configuration3.orientation = i27;
            }
            int i28 = configuration.screenLayout & 15;
            int i29 = configuration2.screenLayout;
            if (i28 != (i29 & 15)) {
                configuration3.screenLayout |= i29 & 15;
            }
            int i30 = configuration.screenLayout & PsExtractor.AUDIO_STREAM;
            int i31 = configuration2.screenLayout;
            if (i30 != (i31 & PsExtractor.AUDIO_STREAM)) {
                configuration3.screenLayout |= i31 & PsExtractor.AUDIO_STREAM;
            }
            int i32 = configuration.screenLayout & 48;
            int i33 = configuration2.screenLayout;
            if (i32 != (i33 & 48)) {
                configuration3.screenLayout |= i33 & 48;
            }
            int i34 = configuration.screenLayout & 768;
            int i35 = configuration2.screenLayout;
            if (i34 != (i35 & 768)) {
                configuration3.screenLayout |= i35 & 768;
            }
            if (i15 >= 26) {
                j.a(configuration, configuration2, configuration3);
            }
            int i36 = configuration.uiMode & 15;
            int i37 = configuration2.uiMode;
            if (i36 != (i37 & 15)) {
                configuration3.uiMode |= i37 & 15;
            }
            int i38 = configuration.uiMode & 48;
            int i39 = configuration2.uiMode;
            if (i38 != (i39 & 48)) {
                configuration3.uiMode |= i39 & 48;
            }
            int i40 = configuration.screenWidthDp;
            int i41 = configuration2.screenWidthDp;
            if (i40 != i41) {
                configuration3.screenWidthDp = i41;
            }
            int i42 = configuration.screenHeightDp;
            int i43 = configuration2.screenHeightDp;
            if (i42 != i43) {
                configuration3.screenHeightDp = i43;
            }
            int i44 = configuration.smallestScreenWidthDp;
            int i45 = configuration2.smallestScreenWidthDp;
            if (i44 != i45) {
                configuration3.smallestScreenWidthDp = i45;
            }
            int i46 = configuration.densityDpi;
            int i47 = configuration2.densityDpi;
            if (i46 != i47) {
                configuration3.densityDpi = i47;
            }
        }
        return configuration3;
    }

    private int s0(Context context) {
        if (!this.W && (this.f1103j instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return 0;
            }
            try {
                int i11 = Build.VERSION.SDK_INT;
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, this.f1103j.getClass()), i11 >= 29 ? 269221888 : i11 >= 24 ? 786432 : 0);
                if (activityInfo != null) {
                    this.V = activityInfo.configChanges;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                this.V = 0;
            }
        }
        this.W = true;
        return this.V;
    }

    private n t0(Context context) {
        if (this.Y == null) {
            this.Y = new m(context);
        }
        return this.Y;
    }

    private n u0(Context context) {
        if (this.X == null) {
            this.X = new o(c0.a(context));
        }
        return this.X;
    }

    private void z0() {
        n0();
        if (this.G && this.f1108o == null) {
            Object obj = this.f1103j;
            if (obj instanceof Activity) {
                this.f1108o = new d0((Activity) this.f1103j, this.H);
            } else if (obj instanceof Dialog) {
                this.f1108o = new d0((Dialog) this.f1103j);
            }
            androidx.appcompat.app.a aVar = this.f1108o;
            if (aVar != null) {
                aVar.s(this.f1096c0);
            }
        }
    }

    @Override // androidx.appcompat.app.f
    public void A(Configuration configuration) {
        androidx.appcompat.app.a v11;
        if (this.G && this.A && (v11 = v()) != null) {
            v11.n(configuration);
        }
        androidx.appcompat.widget.f.b().g(this.f1104k);
        this.S = new Configuration(this.f1104k.getResources().getConfiguration());
        X(false, false);
    }

    @Override // androidx.appcompat.app.f
    public void B(Bundle bundle) {
        String str;
        this.P = true;
        W(false);
        o0();
        Object obj = this.f1103j;
        if (obj instanceof Activity) {
            try {
                str = androidx.core.app.n.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            if (str != null) {
                androidx.appcompat.app.a Q0 = Q0();
                if (Q0 == null) {
                    this.f1096c0 = true;
                } else {
                    Q0.s(true);
                }
            }
            androidx.appcompat.app.f.d(this);
        }
        this.S = new Configuration(this.f1104k.getResources().getConfiguration());
        this.Q = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0058  */
    @Override // androidx.appcompat.app.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void C() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f1103j
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L9
            androidx.appcompat.app.f.I(r3)
        L9:
            boolean r0 = r3.Z
            if (r0 == 0) goto L18
            android.view.Window r0 = r3.f1105l
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.f1095b0
            r0.removeCallbacks(r1)
        L18:
            r0 = 1
            r3.R = r0
            int r0 = r3.T
            r1 = -100
            if (r0 == r1) goto L45
            java.lang.Object r0 = r3.f1103j
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L45
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L45
            androidx.collection.x0 r0 = androidx.appcompat.app.AppCompatDelegateImpl.f1090j0
            java.lang.Object r1 = r3.f1103j
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.T
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L54
        L45:
            androidx.collection.x0 r0 = androidx.appcompat.app.AppCompatDelegateImpl.f1090j0
            java.lang.Object r1 = r3.f1103j
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L54:
            androidx.appcompat.app.a r0 = r3.f1108o
            if (r0 == 0) goto L5b
            r0.o()
        L5b:
            r3.e0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.C():void");
    }

    @Override // androidx.appcompat.app.f
    public void D(Bundle bundle) {
        n0();
    }

    @Override // androidx.appcompat.app.f
    public void E() {
        androidx.appcompat.app.a v11 = v();
        if (v11 != null) {
            v11.t(true);
        }
    }

    public boolean E0() {
        return this.f1119z;
    }

    @Override // androidx.appcompat.app.f
    public void F(Bundle bundle) {
    }

    int F0(Context context, int i11) {
        if (i11 == -100) {
            return -1;
        }
        if (i11 != -1) {
            if (i11 == 0) {
                if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                    return -1;
                }
                return u0(context).c();
            }
            if (i11 != 1 && i11 != 2) {
                if (i11 == 3) {
                    return t0(context).c();
                }
                throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
            }
        }
        return i11;
    }

    @Override // androidx.appcompat.app.f
    public void G() {
        X(true, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean G0() {
        boolean z10 = this.O;
        this.O = false;
        PanelFeatureState w02 = w0(0, false);
        if (w02 != null && w02.f1135o) {
            if (!z10) {
                g0(w02, true);
            }
            return true;
        }
        androidx.appcompat.view.b bVar = this.f1114u;
        if (bVar != null) {
            bVar.c();
            return true;
        }
        androidx.appcompat.app.a v11 = v();
        return v11 != null && v11.h();
    }

    @Override // androidx.appcompat.app.f
    public void H() {
        androidx.appcompat.app.a v11 = v();
        if (v11 != null) {
            v11.t(false);
        }
    }

    boolean H0(int i11, KeyEvent keyEvent) {
        if (i11 == 4) {
            this.O = (keyEvent.getFlags() & 128) != 0;
        } else if (i11 == 82) {
            I0(0, keyEvent);
            return true;
        }
        return false;
    }

    boolean J0(int i11, KeyEvent keyEvent) {
        androidx.appcompat.app.a v11 = v();
        if (v11 != null && v11.p(i11, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.N;
        if (panelFeatureState != null && R0(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            PanelFeatureState panelFeatureState2 = this.N;
            if (panelFeatureState2 != null) {
                panelFeatureState2.f1134n = true;
            }
            return true;
        }
        if (this.N == null) {
            PanelFeatureState w02 = w0(0, true);
            S0(w02, keyEvent);
            boolean R0 = R0(w02, keyEvent.getKeyCode(), keyEvent, 1);
            w02.f1133m = false;
            if (R0) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.app.f
    public boolean K(int i11) {
        int U0 = U0(i11);
        if (this.K && U0 == 108) {
            return false;
        }
        if (this.G && U0 == 1) {
            this.G = false;
        }
        if (U0 == 1) {
            b1();
            this.K = true;
            return true;
        }
        if (U0 == 2) {
            b1();
            this.E = true;
            return true;
        }
        if (U0 == 5) {
            b1();
            this.F = true;
            return true;
        }
        if (U0 == 10) {
            b1();
            this.I = true;
            return true;
        }
        if (U0 == 108) {
            b1();
            this.G = true;
            return true;
        }
        if (U0 != 109) {
            return this.f1105l.requestFeature(U0);
        }
        b1();
        this.H = true;
        return true;
    }

    boolean K0(int i11, KeyEvent keyEvent) {
        if (i11 != 4) {
            if (i11 == 82) {
                L0(0, keyEvent);
                return true;
            }
        } else if (G0()) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.f
    public void L(int i11) {
        n0();
        ViewGroup viewGroup = (ViewGroup) this.B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f1104k).inflate(i11, viewGroup);
        this.f1106m.c(this.f1105l.getCallback());
    }

    @Override // androidx.appcompat.app.f
    public void M(View view) {
        n0();
        ViewGroup viewGroup = (ViewGroup) this.B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f1106m.c(this.f1105l.getCallback());
    }

    void M0(int i11) {
        androidx.appcompat.app.a v11;
        if (i11 != 108 || (v11 = v()) == null) {
            return;
        }
        v11.i(true);
    }

    @Override // androidx.appcompat.app.f
    public void N(View view, ViewGroup.LayoutParams layoutParams) {
        n0();
        ViewGroup viewGroup = (ViewGroup) this.B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f1106m.c(this.f1105l.getCallback());
    }

    void N0(int i11) {
        if (i11 == 108) {
            androidx.appcompat.app.a v11 = v();
            if (v11 != null) {
                v11.i(false);
                return;
            }
            return;
        }
        if (i11 == 0) {
            PanelFeatureState w02 = w0(i11, true);
            if (w02.f1135o) {
                g0(w02, false);
            }
        }
    }

    void O0(ViewGroup viewGroup) {
    }

    @Override // androidx.appcompat.app.f
    public void P(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        OnBackInvokedCallback onBackInvokedCallback;
        super.P(onBackInvokedDispatcher);
        OnBackInvokedDispatcher onBackInvokedDispatcher2 = this.f1101h0;
        if (onBackInvokedDispatcher2 != null && (onBackInvokedCallback = this.f1102i0) != null) {
            k.c(onBackInvokedDispatcher2, onBackInvokedCallback);
            this.f1102i0 = null;
        }
        if (onBackInvokedDispatcher == null) {
            Object obj = this.f1103j;
            if ((obj instanceof Activity) && ((Activity) obj).getWindow() != null) {
                this.f1101h0 = k.a((Activity) this.f1103j);
                f1();
            }
        }
        this.f1101h0 = onBackInvokedDispatcher;
        f1();
    }

    @Override // androidx.appcompat.app.f
    public void Q(Toolbar toolbar) {
        if (this.f1103j instanceof Activity) {
            androidx.appcompat.app.a v11 = v();
            if (v11 instanceof d0) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.f1109p = null;
            if (v11 != null) {
                v11.o();
            }
            this.f1108o = null;
            if (toolbar != null) {
                ToolbarActionBar toolbarActionBar = new ToolbarActionBar(toolbar, x0(), this.f1106m);
                this.f1108o = toolbarActionBar;
                this.f1106m.e(toolbarActionBar.f1167c);
                toolbar.setBackInvokedCallbackEnabled(true);
            } else {
                this.f1106m.e(null);
            }
            x();
        }
    }

    final androidx.appcompat.app.a Q0() {
        return this.f1108o;
    }

    @Override // androidx.appcompat.app.f
    public void R(int i11) {
        this.U = i11;
    }

    @Override // androidx.appcompat.app.f
    public final void S(CharSequence charSequence) {
        this.f1110q = charSequence;
        androidx.appcompat.widget.s sVar = this.f1111r;
        if (sVar != null) {
            sVar.setWindowTitle(charSequence);
            return;
        }
        if (Q0() != null) {
            Q0().u(charSequence);
            return;
        }
        TextView textView = this.C;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // androidx.appcompat.app.f
    public androidx.appcompat.view.b T(b.a aVar) {
        androidx.appcompat.app.d dVar;
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        androidx.appcompat.view.b bVar = this.f1114u;
        if (bVar != null) {
            bVar.c();
        }
        g gVar = new g(aVar);
        androidx.appcompat.app.a v11 = v();
        if (v11 != null) {
            androidx.appcompat.view.b v12 = v11.v(gVar);
            this.f1114u = v12;
            if (v12 != null && (dVar = this.f1107n) != null) {
                dVar.onSupportActionModeStarted(v12);
            }
        }
        if (this.f1114u == null) {
            this.f1114u = a1(gVar);
        }
        f1();
        return this.f1114u;
    }

    void V0(Configuration configuration, androidx.core.os.i iVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            i.d(configuration, iVar);
        } else {
            configuration.setLocale(iVar.d(0));
            configuration.setLayoutDirection(iVar.d(0));
        }
    }

    void W0(androidx.core.os.i iVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            i.c(iVar);
        } else {
            Locale.setDefault(iVar.d(0));
        }
    }

    final boolean X0() {
        ViewGroup viewGroup;
        return this.A && (viewGroup = this.B) != null && viewGroup.isLaidOut();
    }

    boolean Z0() {
        if (this.f1101h0 == null) {
            return false;
        }
        PanelFeatureState w02 = w0(0, false);
        return (w02 != null && w02.f1135o) || this.f1114u != null;
    }

    @Override // androidx.appcompat.view.menu.f.a
    public boolean a(androidx.appcompat.view.menu.f fVar, MenuItem menuItem) {
        PanelFeatureState p02;
        Window.Callback y02 = y0();
        if (y02 == null || this.R || (p02 = p0(fVar.F())) == null) {
            return false;
        }
        return y02.onMenuItemSelected(p02.f1121a, menuItem);
    }

    androidx.core.os.i a0(Context context) {
        androidx.core.os.i u11;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 33 || (u11 = androidx.appcompat.app.f.u()) == null) {
            return null;
        }
        androidx.core.os.i v02 = v0(context.getApplicationContext().getResources().getConfiguration());
        androidx.core.os.i b11 = i11 >= 24 ? z.b(u11, v02) : u11.f() ? androidx.core.os.i.e() : androidx.core.os.i.c(h.b(u11.d(0)));
        return b11.f() ? v02 : b11;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.appcompat.view.b a1(androidx.appcompat.view.b.a r8) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.a1(androidx.appcompat.view.b$a):androidx.appcompat.view.b");
    }

    @Override // androidx.appcompat.view.menu.f.a
    public void b(androidx.appcompat.view.menu.f fVar) {
        T0(true);
    }

    void c0(int i11, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i11 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.M;
                if (i11 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i11];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.f1130j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.f1135o) && !this.R) {
            this.f1106m.d(this.f1105l.getCallback(), i11, menu);
        }
    }

    void d0(androidx.appcompat.view.menu.f fVar) {
        if (this.L) {
            return;
        }
        this.L = true;
        this.f1111r.dismissPopups();
        Window.Callback y02 = y0();
        if (y02 != null && !this.R) {
            y02.onPanelClosed(TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY, fVar);
        }
        this.L = false;
    }

    @Override // androidx.appcompat.app.f
    public void e(View view, ViewGroup.LayoutParams layoutParams) {
        n0();
        ((ViewGroup) this.B.findViewById(R.id.content)).addView(view, layoutParams);
        this.f1106m.c(this.f1105l.getCallback());
    }

    @Override // androidx.appcompat.app.f
    public boolean f() {
        return W(true);
    }

    void f0(int i11) {
        g0(w0(i11, true), true);
    }

    void f1() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean Z0 = Z0();
            if (Z0 && this.f1102i0 == null) {
                this.f1102i0 = k.b(this.f1101h0, this);
            } else {
                if (Z0 || (onBackInvokedCallback = this.f1102i0) == null) {
                    return;
                }
                k.c(this.f1101h0, onBackInvokedCallback);
                this.f1102i0 = null;
            }
        }
    }

    void g0(PanelFeatureState panelFeatureState, boolean z10) {
        ViewGroup viewGroup;
        androidx.appcompat.widget.s sVar;
        if (z10 && panelFeatureState.f1121a == 0 && (sVar = this.f1111r) != null && sVar.isOverflowMenuShowing()) {
            d0(panelFeatureState.f1130j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f1104k.getSystemService("window");
        if (windowManager != null && panelFeatureState.f1135o && (viewGroup = panelFeatureState.f1127g) != null) {
            windowManager.removeView(viewGroup);
            if (z10) {
                c0(panelFeatureState.f1121a, panelFeatureState, null);
            }
        }
        panelFeatureState.f1133m = false;
        panelFeatureState.f1134n = false;
        panelFeatureState.f1135o = false;
        panelFeatureState.f1128h = null;
        panelFeatureState.f1137q = true;
        if (this.N == panelFeatureState) {
            this.N = null;
        }
        if (panelFeatureState.f1121a == 0) {
            f1();
        }
    }

    final int h1(WindowInsetsCompat windowInsetsCompat, Rect rect) {
        boolean z10;
        boolean z11;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : rect != null ? rect.top : 0;
        ActionBarContextView actionBarContextView = this.f1115v;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z10 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1115v.getLayoutParams();
            if (this.f1115v.isShown()) {
                if (this.f1097d0 == null) {
                    this.f1097d0 = new Rect();
                    this.f1098e0 = new Rect();
                }
                Rect rect2 = this.f1097d0;
                Rect rect3 = this.f1098e0;
                if (windowInsetsCompat == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                }
                u0.a(this.B, rect2, rect3);
                int i11 = rect2.top;
                int i12 = rect2.left;
                int i13 = rect2.right;
                WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(this.B);
                int systemWindowInsetLeft = rootWindowInsets == null ? 0 : rootWindowInsets.getSystemWindowInsetLeft();
                int systemWindowInsetRight = rootWindowInsets == null ? 0 : rootWindowInsets.getSystemWindowInsetRight();
                if (marginLayoutParams.topMargin == i11 && marginLayoutParams.leftMargin == i12 && marginLayoutParams.rightMargin == i13) {
                    z11 = false;
                } else {
                    marginLayoutParams.topMargin = i11;
                    marginLayoutParams.leftMargin = i12;
                    marginLayoutParams.rightMargin = i13;
                    z11 = true;
                }
                if (i11 <= 0 || this.D != null) {
                    View view = this.D;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        int i14 = marginLayoutParams2.height;
                        int i15 = marginLayoutParams.topMargin;
                        if (i14 != i15 || marginLayoutParams2.leftMargin != systemWindowInsetLeft || marginLayoutParams2.rightMargin != systemWindowInsetRight) {
                            marginLayoutParams2.height = i15;
                            marginLayoutParams2.leftMargin = systemWindowInsetLeft;
                            marginLayoutParams2.rightMargin = systemWindowInsetRight;
                            this.D.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.f1104k);
                    this.D = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = systemWindowInsetLeft;
                    layoutParams.rightMargin = systemWindowInsetRight;
                    this.B.addView(this.D, -1, layoutParams);
                }
                View view3 = this.D;
                r5 = view3 != null;
                if (r5 && view3.getVisibility() != 0) {
                    i1(this.D);
                }
                if (!this.I && r5) {
                    systemWindowInsetTop = 0;
                }
                z10 = r5;
                r5 = z11;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z10 = false;
            } else {
                z10 = false;
                r5 = false;
            }
            if (r5) {
                this.f1115v.setLayoutParams(marginLayoutParams);
            }
        }
        View view4 = this.D;
        if (view4 != null) {
            view4.setVisibility(z10 ? 0 : 8);
        }
        return systemWindowInsetTop;
    }

    @Override // androidx.appcompat.app.f
    public Context i(Context context) {
        this.P = true;
        int F0 = F0(context, b0());
        if (androidx.appcompat.app.f.y(context)) {
            androidx.appcompat.app.f.V(context);
        }
        androidx.core.os.i a02 = a0(context);
        if (context instanceof ContextThemeWrapper) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(h0(context, F0, a02, null, false));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof androidx.appcompat.view.d) {
            try {
                ((androidx.appcompat.view.d) context).a(h0(context, F0, a02, null, false));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!f1093m0) {
            return super.i(context);
        }
        Configuration configuration = new Configuration();
        configuration.uiMode = -1;
        configuration.fontScale = 0.0f;
        Configuration configuration2 = context.createConfigurationContext(configuration).getResources().getConfiguration();
        Configuration configuration3 = context.getResources().getConfiguration();
        configuration2.uiMode = configuration3.uiMode;
        Configuration h02 = h0(context, F0, a02, !configuration2.equals(configuration3) ? q0(configuration2, configuration3) : null, true);
        androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, R$style.Theme_AppCompat_Empty);
        dVar.a(h02);
        try {
            if (context.getTheme() != null) {
                h.f.a(dVar.getTheme());
            }
        } catch (NullPointerException unused3) {
        }
        return super.i(dVar);
    }

    void j0() {
        androidx.appcompat.view.menu.f fVar;
        androidx.appcompat.widget.s sVar = this.f1111r;
        if (sVar != null) {
            sVar.dismissPopups();
        }
        if (this.f1116w != null) {
            this.f1105l.getDecorView().removeCallbacks(this.f1117x);
            if (this.f1116w.isShowing()) {
                try {
                    this.f1116w.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f1116w = null;
        }
        m0();
        PanelFeatureState w02 = w0(0, false);
        if (w02 == null || (fVar = w02.f1130j) == null) {
            return;
        }
        fVar.close();
    }

    boolean k0(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f1103j;
        if (((obj instanceof KeyEventDispatcher.Component) || (obj instanceof w)) && (decorView = this.f1105l.getDecorView()) != null && KeyEventDispatcher.dispatchBeforeHierarchy(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f1106m.b(this.f1105l.getCallback(), keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? H0(keyCode, keyEvent) : K0(keyCode, keyEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.app.f
    public View l(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z10;
        if (this.f1099f0 == null) {
            TypedArray obtainStyledAttributes = this.f1104k.obtainStyledAttributes(R$styleable.AppCompatTheme);
            String string = obtainStyledAttributes.getString(R$styleable.AppCompatTheme_viewInflaterClass);
            obtainStyledAttributes.recycle();
            if (string == null) {
                this.f1099f0 = new x();
            } else {
                try {
                    this.f1099f0 = (x) this.f1104k.getClassLoader().loadClass(string).getDeclaredConstructor(null).newInstance(null);
                } catch (Throwable unused) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to instantiate custom view inflater ");
                    sb2.append(string);
                    sb2.append(". Falling back to default.");
                    this.f1099f0 = new x();
                }
            }
        }
        boolean z11 = f1091k0;
        boolean z12 = false;
        if (z11) {
            if (this.f1100g0 == null) {
                this.f1100g0 = new y();
            }
            if (this.f1100g0.a(attributeSet)) {
                z10 = true;
                return this.f1099f0.r(view, str, context, attributeSet, z10, z11, true, t0.c());
            }
            if (!(attributeSet instanceof XmlPullParser)) {
                z12 = Y0((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                z12 = true;
            }
        }
        z10 = z12;
        return this.f1099f0.r(view, str, context, attributeSet, z10, z11, true, t0.c());
    }

    void l0(int i11) {
        PanelFeatureState w02;
        PanelFeatureState w03 = w0(i11, true);
        if (w03.f1130j != null) {
            Bundle bundle = new Bundle();
            w03.f1130j.U(bundle);
            if (bundle.size() > 0) {
                w03.f1139s = bundle;
            }
            w03.f1130j.i0();
            w03.f1130j.clear();
        }
        w03.f1138r = true;
        w03.f1137q = true;
        if ((i11 != 108 && i11 != 0) || this.f1111r == null || (w02 = w0(0, false)) == null) {
            return;
        }
        w02.f1133m = false;
        S0(w02, null);
    }

    @Override // androidx.appcompat.app.f
    public View m(int i11) {
        n0();
        return this.f1105l.findViewById(i11);
    }

    void m0() {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f1118y;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
        }
    }

    @Override // androidx.appcompat.app.f
    public Context o() {
        return this.f1104k;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return l(view, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    PanelFeatureState p0(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.M;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i11 = 0; i11 < length; i11++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i11];
            if (panelFeatureState != null && panelFeatureState.f1130j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.app.f
    public final androidx.appcompat.app.b q() {
        return new d();
    }

    @Override // androidx.appcompat.app.f
    public int r() {
        return this.T;
    }

    final Context r0() {
        androidx.appcompat.app.a v11 = v();
        Context k11 = v11 != null ? v11.k() : null;
        return k11 == null ? this.f1104k : k11;
    }

    @Override // androidx.appcompat.app.f
    public MenuInflater t() {
        if (this.f1109p == null) {
            z0();
            androidx.appcompat.app.a aVar = this.f1108o;
            this.f1109p = new androidx.appcompat.view.g(aVar != null ? aVar.k() : this.f1104k);
        }
        return this.f1109p;
    }

    @Override // androidx.appcompat.app.f
    public androidx.appcompat.app.a v() {
        z0();
        return this.f1108o;
    }

    androidx.core.os.i v0(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? i.b(configuration) : androidx.core.os.i.c(h.b(configuration.locale));
    }

    @Override // androidx.appcompat.app.f
    public void w() {
        LayoutInflater from = LayoutInflater.from(this.f1104k);
        if (from.getFactory() == null) {
            LayoutInflaterCompat.setFactory2(from, this);
        } else {
            boolean z10 = from.getFactory2() instanceof AppCompatDelegateImpl;
        }
    }

    protected PanelFeatureState w0(int i11, boolean z10) {
        PanelFeatureState[] panelFeatureStateArr = this.M;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i11) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i11 + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.M = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i11];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i11);
        panelFeatureStateArr[i11] = panelFeatureState2;
        return panelFeatureState2;
    }

    @Override // androidx.appcompat.app.f
    public void x() {
        if (Q0() == null || v().m()) {
            return;
        }
        D0(0);
    }

    final CharSequence x0() {
        Object obj = this.f1103j;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.f1110q;
    }

    final Window.Callback y0() {
        return this.f1105l.getCallback();
    }
}
