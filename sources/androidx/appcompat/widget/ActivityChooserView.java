package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.core.view.ActionProvider;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* loaded from: classes.dex */
public class ActivityChooserView extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    final f f1723a;

    /* renamed from: b, reason: collision with root package name */
    private final g f1724b;

    /* renamed from: c, reason: collision with root package name */
    private final View f1725c;

    /* renamed from: d, reason: collision with root package name */
    private final Drawable f1726d;

    /* renamed from: e, reason: collision with root package name */
    final FrameLayout f1727e;

    /* renamed from: f, reason: collision with root package name */
    private final ImageView f1728f;

    /* renamed from: g, reason: collision with root package name */
    final FrameLayout f1729g;

    /* renamed from: h, reason: collision with root package name */
    private final ImageView f1730h;

    /* renamed from: i, reason: collision with root package name */
    private final int f1731i;

    /* renamed from: j, reason: collision with root package name */
    ActionProvider f1732j;

    /* renamed from: k, reason: collision with root package name */
    final DataSetObserver f1733k;

    /* renamed from: l, reason: collision with root package name */
    private final ViewTreeObserver.OnGlobalLayoutListener f1734l;

    /* renamed from: m, reason: collision with root package name */
    private ListPopupWindow f1735m;

    /* renamed from: n, reason: collision with root package name */
    PopupWindow.OnDismissListener f1736n;

    /* renamed from: o, reason: collision with root package name */
    boolean f1737o;

    /* renamed from: p, reason: collision with root package name */
    int f1738p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f1739q;

    /* renamed from: r, reason: collision with root package name */
    private int f1740r;

    /* loaded from: classes.dex */
    public static class InnerLayout extends LinearLayout {

        /* renamed from: a, reason: collision with root package name */
        private static final int[] f1741a = {R.attr.background};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            j0 u11 = j0.u(context, attributeSet, f1741a);
            setBackgroundDrawable(u11.g(0));
            u11.x();
        }
    }

    /* loaded from: classes.dex */
    class a extends DataSetObserver {
        a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.f1723a.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            super.onInvalidated();
            ActivityChooserView.this.f1723a.notifyDataSetInvalidated();
        }
    }

    /* loaded from: classes.dex */
    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (ActivityChooserView.this.isShowingPopup()) {
                if (!ActivityChooserView.this.isShown()) {
                    ActivityChooserView.this.getListPopupWindow().dismiss();
                    return;
                }
                ActivityChooserView.this.getListPopupWindow().show();
                ActionProvider actionProvider = ActivityChooserView.this.f1732j;
                if (actionProvider != null) {
                    actionProvider.subUiVisibilityChanged(true);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    class c extends View.AccessibilityDelegate {
        c() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCanOpenPopup(true);
        }
    }

    /* loaded from: classes.dex */
    class d extends ForwardingListener {
        d(View view) {
            super(view);
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public androidx.appcompat.view.menu.o b() {
            return ActivityChooserView.this.getListPopupWindow();
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        protected boolean c() {
            ActivityChooserView.this.showPopup();
            return true;
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        protected boolean d() {
            ActivityChooserView.this.dismissPopup();
            return true;
        }
    }

    /* loaded from: classes.dex */
    class e extends DataSetObserver {
        e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private int f1747a = 4;

        /* renamed from: b, reason: collision with root package name */
        private boolean f1748b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f1749c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f1750d;

        f() {
        }

        public int a() {
            throw null;
        }

        public androidx.appcompat.widget.b b() {
            return null;
        }

        public ResolveInfo c() {
            throw null;
        }

        public int d() {
            throw null;
        }

        public boolean e() {
            return this.f1748b;
        }

        public void f(androidx.appcompat.widget.b bVar) {
            ActivityChooserView.this.f1723a.b();
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            throw null;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i11) {
            int itemViewType = getItemViewType(i11);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    return null;
                }
                throw new IllegalArgumentException();
            }
            if (this.f1748b) {
                throw null;
            }
            throw null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i11) {
            return i11;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i11) {
            return (this.f1750d && i11 == getCount() - 1) ? 1 : 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i11, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i11);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    throw new IllegalArgumentException();
                }
                if (view != null && view.getId() == 1) {
                    return view;
                }
                View inflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R$layout.abc_activity_chooser_view_list_item, viewGroup, false);
                inflate.setId(1);
                ((TextView) inflate.findViewById(R$id.title)).setText(ActivityChooserView.this.getContext().getString(R$string.abc_activity_chooser_view_see_all));
                return inflate;
            }
            if (view == null || view.getId() != R$id.list_item) {
                view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R$layout.abc_activity_chooser_view_list_item, viewGroup, false);
            }
            PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
            ImageView imageView = (ImageView) view.findViewById(R$id.icon);
            ResolveInfo resolveInfo = (ResolveInfo) getItem(i11);
            imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
            ((TextView) view.findViewById(R$id.title)).setText(resolveInfo.loadLabel(packageManager));
            if (this.f1748b && i11 == 0 && this.f1749c) {
                view.setActivated(true);
            } else {
                view.setActivated(false);
            }
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        g() {
        }

        private void a() {
            PopupWindow.OnDismissListener onDismissListener = ActivityChooserView.this.f1736n;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view == activityChooserView.f1729g) {
                activityChooserView.dismissPopup();
                ActivityChooserView.this.f1723a.c();
                ActivityChooserView.this.f1723a.b();
                throw null;
            }
            if (view != activityChooserView.f1727e) {
                throw new IllegalArgumentException();
            }
            activityChooserView.f1737o = false;
            activityChooserView.a(activityChooserView.f1738p);
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            a();
            ActionProvider actionProvider = ActivityChooserView.this.f1732j;
            if (actionProvider != null) {
                actionProvider.subUiVisibilityChanged(false);
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i11, long j11) {
            int itemViewType = ((f) adapterView.getAdapter()).getItemViewType(i11);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    throw new IllegalArgumentException();
                }
                ActivityChooserView.this.a(Integer.MAX_VALUE);
                return;
            }
            ActivityChooserView.this.dismissPopup();
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (!activityChooserView.f1737o) {
                activityChooserView.f1723a.e();
                ActivityChooserView.this.f1723a.b();
                throw null;
            }
            if (i11 <= 0) {
                return;
            }
            activityChooserView.f1723a.b();
            throw null;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view != activityChooserView.f1729g) {
                throw new IllegalArgumentException();
            }
            if (activityChooserView.f1723a.getCount() > 0) {
                ActivityChooserView activityChooserView2 = ActivityChooserView.this;
                activityChooserView2.f1737o = true;
                activityChooserView2.a(activityChooserView2.f1738p);
            }
            return true;
        }
    }

    public ActivityChooserView(@NonNull Context context) {
        this(context, null);
    }

    public ActivityChooserView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f1733k = new a();
        this.f1734l = new b();
        this.f1738p = 4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActivityChooserView, i11, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, R$styleable.ActivityChooserView, attributeSet, obtainStyledAttributes, i11, 0);
        this.f1738p = obtainStyledAttributes.getInt(R$styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R$layout.abc_activity_chooser_view, (ViewGroup) this, true);
        g gVar = new g();
        this.f1724b = gVar;
        View findViewById = findViewById(R$id.activity_chooser_view_content);
        this.f1725c = findViewById;
        this.f1726d = findViewById.getBackground();
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.default_activity_button);
        this.f1729g = frameLayout;
        frameLayout.setOnClickListener(gVar);
        frameLayout.setOnLongClickListener(gVar);
        this.f1730h = (ImageView) frameLayout.findViewById(R$id.image);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R$id.expand_activities_button);
        frameLayout2.setOnClickListener(gVar);
        frameLayout2.setAccessibilityDelegate(new c());
        frameLayout2.setOnTouchListener(new d(frameLayout2));
        this.f1727e = frameLayout2;
        ImageView imageView = (ImageView) frameLayout2.findViewById(R$id.image);
        this.f1728f = imageView;
        imageView.setImageDrawable(drawable);
        f fVar = new f();
        this.f1723a = fVar;
        fVar.registerDataSetObserver(new e());
        Resources resources = context.getResources();
        this.f1731i = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
    }

    void a(int i11) {
        this.f1723a.b();
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    void b() {
        if (this.f1723a.getCount() > 0) {
            this.f1727e.setEnabled(true);
        } else {
            this.f1727e.setEnabled(false);
        }
        int a11 = this.f1723a.a();
        int d11 = this.f1723a.d();
        if (a11 == 1 || (a11 > 1 && d11 > 0)) {
            this.f1729g.setVisibility(0);
            ResolveInfo c11 = this.f1723a.c();
            PackageManager packageManager = getContext().getPackageManager();
            this.f1730h.setImageDrawable(c11.loadIcon(packageManager));
            if (this.f1740r != 0) {
                this.f1729g.setContentDescription(getContext().getString(this.f1740r, c11.loadLabel(packageManager)));
            }
        } else {
            this.f1729g.setVisibility(8);
        }
        if (this.f1729g.getVisibility() == 0) {
            this.f1725c.setBackgroundDrawable(this.f1726d);
        } else {
            this.f1725c.setBackgroundDrawable(null);
        }
    }

    public boolean dismissPopup() {
        if (!isShowingPopup()) {
            return true;
        }
        getListPopupWindow().dismiss();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.f1734l);
        return true;
    }

    public androidx.appcompat.widget.b getDataModel() {
        this.f1723a.b();
        return null;
    }

    ListPopupWindow getListPopupWindow() {
        if (this.f1735m == null) {
            ListPopupWindow listPopupWindow = new ListPopupWindow(getContext());
            this.f1735m = listPopupWindow;
            listPopupWindow.m(this.f1723a);
            this.f1735m.C(this);
            this.f1735m.I(true);
            this.f1735m.K(this.f1724b);
            this.f1735m.J(this.f1724b);
        }
        return this.f1735m;
    }

    public boolean isShowingPopup() {
        return getListPopupWindow().a();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1723a.b();
        this.f1739q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f1723a.b();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f1734l);
        }
        if (isShowingPopup()) {
            dismissPopup();
        }
        this.f1739q = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        this.f1725c.layout(0, 0, i13 - i11, i14 - i12);
        if (isShowingPopup()) {
            return;
        }
        dismissPopup();
    }

    @Override // android.view.View
    protected void onMeasure(int i11, int i12) {
        View view = this.f1725c;
        if (this.f1729g.getVisibility() != 0) {
            i12 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i12), 1073741824);
        }
        measureChild(view, i11, i12);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(androidx.appcompat.widget.b bVar) {
        this.f1723a.f(bVar);
        if (isShowingPopup()) {
            dismissPopup();
            showPopup();
        }
    }

    public void setDefaultActionButtonContentDescription(int i11) {
        this.f1740r = i11;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i11) {
        this.f1728f.setContentDescription(getContext().getString(i11));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f1728f.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i11) {
        this.f1738p = i11;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f1736n = onDismissListener;
    }

    public void setProvider(ActionProvider actionProvider) {
        this.f1732j = actionProvider;
    }

    public boolean showPopup() {
        if (isShowingPopup() || !this.f1739q) {
            return false;
        }
        this.f1737o = false;
        a(this.f1738p);
        return true;
    }
}
