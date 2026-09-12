package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.datepicker.MaterialCalendar;

/* loaded from: classes4.dex */
class n extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    private final CalendarConstraints f28953a;

    /* renamed from: b, reason: collision with root package name */
    private final DateSelector f28954b;

    /* renamed from: c, reason: collision with root package name */
    private final DayViewDecorator f28955c;

    /* renamed from: d, reason: collision with root package name */
    private final MaterialCalendar.k f28956d;

    /* renamed from: e, reason: collision with root package name */
    private final int f28957e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MaterialCalendarGridView f28958a;

        a(MaterialCalendarGridView materialCalendarGridView) {
            this.f28958a = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i11, long j11) {
            if (this.f28958a.getAdapter().r(i11)) {
                n.this.f28956d.a(this.f28958a.getAdapter().getItem(i11).longValue());
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends RecyclerView.b0 {

        /* renamed from: a, reason: collision with root package name */
        final TextView f28960a;

        /* renamed from: b, reason: collision with root package name */
        final MaterialCalendarGridView f28961b;

        b(LinearLayout linearLayout, boolean z10) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R$id.month_title);
            this.f28960a = textView;
            ViewCompat.setAccessibilityHeading(textView, true);
            this.f28961b = (MaterialCalendarGridView) linearLayout.findViewById(R$id.month_grid);
            if (z10) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context, DateSelector dateSelector, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator, MaterialCalendar.k kVar) {
        Month start = calendarConstraints.getStart();
        Month end = calendarConstraints.getEnd();
        Month openAt = calendarConstraints.getOpenAt();
        if (start.compareTo(openAt) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (openAt.compareTo(end) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f28957e = (m.f28945g * MaterialCalendar.k0(context)) + (MaterialDatePicker.m0(context) ? MaterialCalendar.k0(context) : 0);
        this.f28953a = calendarConstraints;
        this.f28954b = dateSelector;
        this.f28955c = dayViewDecorator;
        this.f28956d = kVar;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f28953a.getMonthSpan();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i11) {
        return this.f28953a.getStart().k(i11).j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month h(int i11) {
        return this.f28953a.getStart().k(i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence i(int i11) {
        return h(i11).i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j(Month month) {
        return this.f28953a.getStart().l(month);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i11) {
        Month k11 = this.f28953a.getStart().k(i11);
        bVar.f28960a.setText(k11.i());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.f28961b.findViewById(R$id.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !k11.equals(materialCalendarGridView.getAdapter().f28947a)) {
            m mVar = new m(k11, this.f28954b, this.f28953a, this.f28955c);
            materialCalendarGridView.setNumColumns(k11.f28898c);
            materialCalendarGridView.setAdapter((ListAdapter) mVar);
        } else {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter().q(materialCalendarGridView);
        }
        materialCalendarGridView.setOnItemClickListener(new a(materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i11) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!MaterialDatePicker.m0(viewGroup.getContext())) {
            return new b(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.n(-1, this.f28957e));
        return new b(linearLayout, true);
    }
}
