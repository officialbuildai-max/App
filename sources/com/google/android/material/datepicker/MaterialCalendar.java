package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$integer;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class MaterialCalendar<S> extends p {

    /* renamed from: o, reason: collision with root package name */
    static final Object f28822o = "MONTHS_VIEW_GROUP_TAG";

    /* renamed from: p, reason: collision with root package name */
    static final Object f28823p = "NAVIGATION_PREV_TAG";

    /* renamed from: q, reason: collision with root package name */
    static final Object f28824q = "NAVIGATION_NEXT_TAG";

    /* renamed from: r, reason: collision with root package name */
    static final Object f28825r = "SELECTOR_TOGGLE_TAG";

    /* renamed from: b, reason: collision with root package name */
    private int f28826b;

    /* renamed from: c, reason: collision with root package name */
    private DateSelector f28827c;

    /* renamed from: d, reason: collision with root package name */
    private CalendarConstraints f28828d;

    /* renamed from: e, reason: collision with root package name */
    private DayViewDecorator f28829e;

    /* renamed from: f, reason: collision with root package name */
    private Month f28830f;

    /* renamed from: g, reason: collision with root package name */
    private CalendarSelector f28831g;

    /* renamed from: h, reason: collision with root package name */
    private com.google.android.material.datepicker.b f28832h;

    /* renamed from: i, reason: collision with root package name */
    private RecyclerView f28833i;

    /* renamed from: j, reason: collision with root package name */
    private RecyclerView f28834j;

    /* renamed from: k, reason: collision with root package name */
    private View f28835k;

    /* renamed from: l, reason: collision with root package name */
    private View f28836l;

    /* renamed from: m, reason: collision with root package name */
    private View f28837m;

    /* renamed from: n, reason: collision with root package name */
    private View f28838n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public enum CalendarSelector {
        DAY,
        YEAR
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n f28839a;

        a(n nVar) {
            this.f28839a = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int findLastVisibleItemPosition = MaterialCalendar.this.m0().findLastVisibleItemPosition() - 1;
            if (findLastVisibleItemPosition >= 0) {
                MaterialCalendar.this.p0(this.f28839a.h(findLastVisibleItemPosition));
            }
        }
    }

    /* loaded from: classes4.dex */
    class b extends AccessibilityDelegateCompat {
        b() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo(null);
        }
    }

    /* loaded from: classes4.dex */
    class c extends q {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f28842a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Context context, int i11, boolean z10, int i12) {
            super(context, i11, z10);
            this.f28842a = i12;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void calculateExtraLayoutSpace(RecyclerView.y yVar, int[] iArr) {
            if (this.f28842a == 0) {
                iArr[0] = MaterialCalendar.this.f28834j.getWidth();
                iArr[1] = MaterialCalendar.this.f28834j.getWidth();
            } else {
                iArr[0] = MaterialCalendar.this.f28834j.getHeight();
                iArr[1] = MaterialCalendar.this.f28834j.getHeight();
            }
        }
    }

    /* loaded from: classes4.dex */
    class d implements k {
        d() {
        }

        @Override // com.google.android.material.datepicker.MaterialCalendar.k
        public void a(long j11) {
            if (MaterialCalendar.this.f28828d.getDateValidator().isValid(j11)) {
                MaterialCalendar.this.f28827c.select(j11);
                Iterator it = MaterialCalendar.this.f28962a.iterator();
                while (it.hasNext()) {
                    ((o) it.next()).b(MaterialCalendar.this.f28827c.getSelection());
                }
                MaterialCalendar.this.f28834j.getAdapter().notifyDataSetChanged();
                if (MaterialCalendar.this.f28833i != null) {
                    MaterialCalendar.this.f28833i.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e extends AccessibilityDelegateCompat {
        e() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setScrollable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class f extends RecyclerView.l {

        /* renamed from: a, reason: collision with root package name */
        private final Calendar f28846a = x.s();

        /* renamed from: b, reason: collision with root package name */
        private final Calendar f28847b = x.s();

        f() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.y yVar) {
            if ((recyclerView.getAdapter() instanceof y) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                y yVar2 = (y) recyclerView.getAdapter();
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                for (androidx.core.util.e eVar : MaterialCalendar.this.f28827c.getSelectedRanges()) {
                    Object obj = eVar.f8347a;
                    if (obj != null && eVar.f8348b != null) {
                        this.f28846a.setTimeInMillis(((Long) obj).longValue());
                        this.f28847b.setTimeInMillis(((Long) eVar.f8348b).longValue());
                        int i11 = yVar2.i(this.f28846a.get(1));
                        int i12 = yVar2.i(this.f28847b.get(1));
                        View findViewByPosition = gridLayoutManager.findViewByPosition(i11);
                        View findViewByPosition2 = gridLayoutManager.findViewByPosition(i12);
                        int U = i11 / gridLayoutManager.U();
                        int U2 = i12 / gridLayoutManager.U();
                        int i13 = U;
                        while (i13 <= U2) {
                            if (gridLayoutManager.findViewByPosition(gridLayoutManager.U() * i13) != null) {
                                canvas.drawRect((i13 != U || findViewByPosition == null) ? 0 : findViewByPosition.getLeft() + (findViewByPosition.getWidth() / 2), r9.getTop() + MaterialCalendar.this.f28832h.f28921d.c(), (i13 != U2 || findViewByPosition2 == null) ? recyclerView.getWidth() : findViewByPosition2.getLeft() + (findViewByPosition2.getWidth() / 2), r9.getBottom() - MaterialCalendar.this.f28832h.f28921d.b(), MaterialCalendar.this.f28832h.f28925h);
                            }
                            i13++;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class g extends AccessibilityDelegateCompat {
        g() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setHintText(MaterialCalendar.this.f28838n.getVisibility() == 0 ? MaterialCalendar.this.getString(R$string.mtrl_picker_toggle_to_year_selection) : MaterialCalendar.this.getString(R$string.mtrl_picker_toggle_to_day_selection));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class h extends RecyclerView.r {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n f28850a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MaterialButton f28851b;

        h(n nVar, MaterialButton materialButton) {
            this.f28850a = nVar;
            this.f28851b = materialButton;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            if (i11 == 0) {
                recyclerView.announceForAccessibility(this.f28851b.getText());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            int findFirstVisibleItemPosition = i11 < 0 ? MaterialCalendar.this.m0().findFirstVisibleItemPosition() : MaterialCalendar.this.m0().findLastVisibleItemPosition();
            MaterialCalendar.this.f28830f = this.f28850a.h(findFirstVisibleItemPosition);
            this.f28851b.setText(this.f28850a.i(findFirstVisibleItemPosition));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MaterialCalendar.this.s0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class j implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n f28854a;

        j(n nVar) {
            this.f28854a = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int findFirstVisibleItemPosition = MaterialCalendar.this.m0().findFirstVisibleItemPosition() + 1;
            if (findFirstVisibleItemPosition < MaterialCalendar.this.f28834j.getAdapter().getItemCount()) {
                MaterialCalendar.this.p0(this.f28854a.h(findFirstVisibleItemPosition));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface k {
        void a(long j11);
    }

    private void e0(View view, n nVar) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.month_navigation_fragment_toggle);
        materialButton.setTag(f28825r);
        ViewCompat.setAccessibilityDelegate(materialButton, new g());
        View findViewById = view.findViewById(R$id.month_navigation_previous);
        this.f28835k = findViewById;
        findViewById.setTag(f28823p);
        View findViewById2 = view.findViewById(R$id.month_navigation_next);
        this.f28836l = findViewById2;
        findViewById2.setTag(f28824q);
        this.f28837m = view.findViewById(R$id.mtrl_calendar_year_selector_frame);
        this.f28838n = view.findViewById(R$id.mtrl_calendar_day_selector_frame);
        q0(CalendarSelector.DAY);
        materialButton.setText(this.f28830f.i());
        this.f28834j.addOnScrollListener(new h(nVar, materialButton));
        materialButton.setOnClickListener(new i());
        this.f28836l.setOnClickListener(new j(nVar));
        this.f28835k.setOnClickListener(new a(nVar));
    }

    private RecyclerView.l f0() {
        return new f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int k0(Context context) {
        return context.getResources().getDimensionPixelSize(R$dimen.mtrl_calendar_day_height);
    }

    private static int l0(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.mtrl_calendar_navigation_height) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_navigation_bottom_padding);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.mtrl_calendar_days_of_week_height);
        int i11 = m.f28945g;
        return dimensionPixelSize + dimensionPixelSize2 + (resources.getDimensionPixelSize(R$dimen.mtrl_calendar_day_height) * i11) + ((i11 - 1) * resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_month_vertical_padding)) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_bottom_padding);
    }

    public static MaterialCalendar n0(DateSelector dateSelector, int i11, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator) {
        MaterialCalendar materialCalendar = new MaterialCalendar();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i11);
        bundle.putParcelable("GRID_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", dayViewDecorator);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.getOpenAt());
        materialCalendar.setArguments(bundle);
        return materialCalendar;
    }

    private void o0(final int i11) {
        this.f28834j.post(new Runnable() { // from class: com.google.android.material.datepicker.MaterialCalendar.11
            @Override // java.lang.Runnable
            public void run() {
                MaterialCalendar.this.f28834j.smoothScrollToPosition(i11);
            }
        });
    }

    private void r0() {
        ViewCompat.setAccessibilityDelegate(this.f28834j, new e());
    }

    @Override // com.google.android.material.datepicker.p
    public boolean V(o oVar) {
        return super.V(oVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CalendarConstraints g0() {
        return this.f28828d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.android.material.datepicker.b h0() {
        return this.f28832h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month i0() {
        return this.f28830f;
    }

    public DateSelector j0() {
        return this.f28827c;
    }

    LinearLayoutManager m0() {
        return (LinearLayoutManager) this.f28834j.getLayoutManager();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f28826b = bundle.getInt("THEME_RES_ID_KEY");
        this.f28827c = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.f28828d = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f28829e = (DayViewDecorator) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f28830f = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i11;
        int i12;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f28826b);
        this.f28832h = new com.google.android.material.datepicker.b(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month start = this.f28828d.getStart();
        if (MaterialDatePicker.m0(contextThemeWrapper)) {
            i11 = R$layout.mtrl_calendar_vertical;
            i12 = 1;
        } else {
            i11 = R$layout.mtrl_calendar_horizontal;
            i12 = 0;
        }
        View inflate = cloneInContext.inflate(i11, viewGroup, false);
        inflate.setMinimumHeight(l0(requireContext()));
        GridView gridView = (GridView) inflate.findViewById(R$id.mtrl_calendar_days_of_week);
        ViewCompat.setAccessibilityDelegate(gridView, new b());
        int firstDayOfWeek = this.f28828d.getFirstDayOfWeek();
        gridView.setAdapter((ListAdapter) (firstDayOfWeek > 0 ? new com.google.android.material.datepicker.k(firstDayOfWeek) : new com.google.android.material.datepicker.k()));
        gridView.setNumColumns(start.f28898c);
        gridView.setEnabled(false);
        this.f28834j = (RecyclerView) inflate.findViewById(R$id.mtrl_calendar_months);
        this.f28834j.setLayoutManager(new c(getContext(), i12, false, i12));
        this.f28834j.setTag(f28822o);
        n nVar = new n(contextThemeWrapper, this.f28827c, this.f28828d, this.f28829e, new d());
        this.f28834j.setAdapter(nVar);
        int integer = contextThemeWrapper.getResources().getInteger(R$integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R$id.mtrl_calendar_year_selector_frame);
        this.f28833i = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f28833i.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.f28833i.setAdapter(new y(this));
            this.f28833i.addItemDecoration(f0());
        }
        if (inflate.findViewById(R$id.month_navigation_fragment_toggle) != null) {
            e0(inflate, nVar);
        }
        if (!MaterialDatePicker.m0(contextThemeWrapper)) {
            new androidx.recyclerview.widget.n().attachToRecyclerView(this.f28834j);
        }
        this.f28834j.scrollToPosition(nVar.j(this.f28830f));
        r0();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f28826b);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.f28827c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f28828d);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f28829e);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f28830f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p0(Month month) {
        n nVar = (n) this.f28834j.getAdapter();
        int j11 = nVar.j(month);
        int j12 = j11 - nVar.j(this.f28830f);
        boolean z10 = Math.abs(j12) > 3;
        boolean z11 = j12 > 0;
        this.f28830f = month;
        if (z10 && z11) {
            this.f28834j.scrollToPosition(j11 - 3);
            o0(j11);
        } else if (!z10) {
            o0(j11);
        } else {
            this.f28834j.scrollToPosition(j11 + 3);
            o0(j11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q0(CalendarSelector calendarSelector) {
        this.f28831g = calendarSelector;
        if (calendarSelector == CalendarSelector.YEAR) {
            this.f28833i.getLayoutManager().scrollToPosition(((y) this.f28833i.getAdapter()).i(this.f28830f.f28897b));
            this.f28837m.setVisibility(0);
            this.f28838n.setVisibility(8);
            this.f28835k.setVisibility(8);
            this.f28836l.setVisibility(8);
            return;
        }
        if (calendarSelector == CalendarSelector.DAY) {
            this.f28837m.setVisibility(8);
            this.f28838n.setVisibility(0);
            this.f28835k.setVisibility(0);
            this.f28836l.setVisibility(0);
            p0(this.f28830f);
        }
    }

    void s0() {
        CalendarSelector calendarSelector = this.f28831g;
        CalendarSelector calendarSelector2 = CalendarSelector.YEAR;
        if (calendarSelector == calendarSelector2) {
            q0(CalendarSelector.DAY);
        } else if (calendarSelector == CalendarSelector.DAY) {
            q0(calendarSelector2);
        }
    }
}
