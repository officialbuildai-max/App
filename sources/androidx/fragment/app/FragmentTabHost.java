package androidx.fragment.app;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

@Deprecated
/* loaded from: classes.dex */
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList f9462a;

    /* renamed from: b, reason: collision with root package name */
    private FrameLayout f9463b;

    /* renamed from: c, reason: collision with root package name */
    private Context f9464c;

    /* renamed from: d, reason: collision with root package name */
    private FragmentManager f9465d;

    /* renamed from: e, reason: collision with root package name */
    private int f9466e;

    /* renamed from: f, reason: collision with root package name */
    private TabHost.OnTabChangeListener f9467f;

    /* renamed from: g, reason: collision with root package name */
    private b f9468g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f9469h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        String f9470a;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f9470a = parcel.readString();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f9470a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeString(this.f9470a);
        }
    }

    /* loaded from: classes.dex */
    static class a implements TabHost.TabContentFactory {

        /* renamed from: a, reason: collision with root package name */
        private final Context f9471a;

        public a(Context context) {
            this.f9471a = context;
        }

        @Override // android.widget.TabHost.TabContentFactory
        public View createTabContent(String str) {
            View view = new View(this.f9471a);
            view.setMinimumWidth(0);
            view.setMinimumHeight(0);
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final String f9472a;

        /* renamed from: b, reason: collision with root package name */
        final Class f9473b;

        /* renamed from: c, reason: collision with root package name */
        final Bundle f9474c;

        /* renamed from: d, reason: collision with root package name */
        Fragment f9475d;

        b(String str, Class cls, Bundle bundle) {
            this.f9472a = str;
            this.f9473b = cls;
            this.f9474c = bundle;
        }
    }

    @Deprecated
    public FragmentTabHost(@NonNull Context context) {
        super(context, null);
        this.f9462a = new ArrayList();
        e(context, null);
    }

    @Deprecated
    public FragmentTabHost(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9462a = new ArrayList();
        e(context, attributeSet);
    }

    private w a(String str, w wVar) {
        Fragment fragment;
        b d11 = d(str);
        if (this.f9468g != d11) {
            if (wVar == null) {
                wVar = this.f9465d.p();
            }
            b bVar = this.f9468g;
            if (bVar != null && (fragment = bVar.f9475d) != null) {
                wVar.m(fragment);
            }
            if (d11 != null) {
                Fragment fragment2 = d11.f9475d;
                if (fragment2 == null) {
                    Fragment instantiate = this.f9465d.w0().instantiate(this.f9464c.getClassLoader(), d11.f9473b.getName());
                    d11.f9475d = instantiate;
                    instantiate.setArguments(d11.f9474c);
                    wVar.c(this.f9466e, d11.f9475d, d11.f9472a);
                } else {
                    wVar.h(fragment2);
                }
            }
            this.f9468g = d11;
        }
        return wVar;
    }

    private void b() {
        if (this.f9463b == null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(this.f9466e);
            this.f9463b = frameLayout;
            if (frameLayout != null) {
                return;
            }
            throw new IllegalStateException("No tab content FrameLayout found for id " + this.f9466e);
        }
    }

    private void c(Context context) {
        if (findViewById(R.id.tabs) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
            TabWidget tabWidget = new TabWidget(context);
            tabWidget.setId(R.id.tabs);
            tabWidget.setOrientation(0);
            linearLayout.addView(tabWidget, new LinearLayout.LayoutParams(-1, -2, 0.0f));
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setId(R.id.tabcontent);
            linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(0, 0, 0.0f));
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.f9463b = frameLayout2;
            frameLayout2.setId(this.f9466e);
            linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    private b d(String str) {
        int size = this.f9462a.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = (b) this.f9462a.get(i11);
            if (bVar.f9472a.equals(str)) {
                return bVar;
            }
        }
        return null;
    }

    private void e(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.inflatedId}, 0, 0);
        this.f9466e = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Deprecated
    public void addTab(@NonNull TabHost.TabSpec tabSpec, @NonNull Class<?> cls, @Nullable Bundle bundle) {
        tabSpec.setContent(new a(this.f9464c));
        String tag = tabSpec.getTag();
        b bVar = new b(tag, cls, bundle);
        if (this.f9469h) {
            Fragment k02 = this.f9465d.k0(tag);
            bVar.f9475d = k02;
            if (k02 != null && !k02.isDetached()) {
                w p11 = this.f9465d.p();
                p11.m(bVar.f9475d);
                p11.i();
            }
        }
        this.f9462a.add(bVar);
        addTab(tabSpec);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.f9462a.size();
        w wVar = null;
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = (b) this.f9462a.get(i11);
            Fragment k02 = this.f9465d.k0(bVar.f9472a);
            bVar.f9475d = k02;
            if (k02 != null && !k02.isDetached()) {
                if (bVar.f9472a.equals(currentTabTag)) {
                    this.f9468g = bVar;
                } else {
                    if (wVar == null) {
                        wVar = this.f9465d.p();
                    }
                    wVar.m(bVar.f9475d);
                }
            }
        }
        this.f9469h = true;
        w a11 = a(currentTabTag, wVar);
        if (a11 != null) {
            a11.i();
            this.f9465d.g0();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f9469h = false;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f9470a);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f9470a = getCurrentTabTag();
        return savedState;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    @Deprecated
    public void onTabChanged(@Nullable String str) {
        w a11;
        if (this.f9469h && (a11 = a(str, null)) != null) {
            a11.i();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.f9467f;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setOnTabChangedListener(@Nullable TabHost.OnTabChangeListener onTabChangeListener) {
        this.f9467f = onTabChangeListener;
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public void setup(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        c(context);
        super.setup();
        this.f9464c = context;
        this.f9465d = fragmentManager;
        b();
    }

    @Deprecated
    public void setup(@NonNull Context context, @NonNull FragmentManager fragmentManager, int i11) {
        c(context);
        super.setup();
        this.f9464c = context;
        this.f9465d = fragmentManager;
        this.f9466e = i11;
        b();
        this.f9463b.setId(i11);
        if (getId() == -1) {
            setId(R.id.tabhost);
        }
    }
}
