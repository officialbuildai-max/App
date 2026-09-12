package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class m extends BaseAdapter {

    /* renamed from: g, reason: collision with root package name */
    static final int f28945g = x.s().getMaximum(4);

    /* renamed from: h, reason: collision with root package name */
    private static final int f28946h = (x.s().getMaximum(5) + x.s().getMaximum(7)) - 1;

    /* renamed from: a, reason: collision with root package name */
    final Month f28947a;

    /* renamed from: b, reason: collision with root package name */
    final DateSelector f28948b;

    /* renamed from: c, reason: collision with root package name */
    private Collection f28949c;

    /* renamed from: d, reason: collision with root package name */
    b f28950d;

    /* renamed from: e, reason: collision with root package name */
    final CalendarConstraints f28951e;

    /* renamed from: f, reason: collision with root package name */
    final DayViewDecorator f28952f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Month month, DateSelector dateSelector, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator) {
        this.f28947a = month;
        this.f28948b = dateSelector;
        this.f28951e = calendarConstraints;
        this.f28952f = dayViewDecorator;
        this.f28949c = dateSelector.getSelectedDays();
    }

    private String c(Context context, long j11) {
        return j.e(context, j11, l(j11), k(j11), g(j11));
    }

    private void f(Context context) {
        if (this.f28950d == null) {
            this.f28950d = new b(context);
        }
    }

    private boolean j(long j11) {
        Iterator<Long> it = this.f28948b.getSelectedDays().iterator();
        while (it.hasNext()) {
            if (x.a(j11) == x.a(it.next().longValue())) {
                return true;
            }
        }
        return false;
    }

    private boolean l(long j11) {
        return x.q().getTimeInMillis() == j11;
    }

    private void o(TextView textView, long j11, int i11) {
        boolean z10;
        a aVar;
        if (textView == null) {
            return;
        }
        Context context = textView.getContext();
        String c11 = c(context, j11);
        textView.setContentDescription(c11);
        boolean isValid = this.f28951e.getDateValidator().isValid(j11);
        if (isValid) {
            textView.setEnabled(true);
            boolean j12 = j(j11);
            textView.setSelected(j12);
            aVar = j12 ? this.f28950d.f28919b : l(j11) ? this.f28950d.f28920c : this.f28950d.f28918a;
            z10 = j12;
        } else {
            textView.setEnabled(false);
            z10 = false;
            aVar = this.f28950d.f28924g;
        }
        DayViewDecorator dayViewDecorator = this.f28952f;
        if (dayViewDecorator == null || i11 == -1) {
            aVar.d(textView);
            return;
        }
        Month month = this.f28947a;
        int i12 = month.f28897b;
        int i13 = month.f28896a;
        ColorStateList backgroundColor = dayViewDecorator.getBackgroundColor(context, i12, i13, i11, isValid, z10);
        boolean z11 = z10;
        aVar.e(textView, backgroundColor, this.f28952f.getTextColor(context, i12, i13, i11, isValid, z11));
        Drawable compoundDrawableLeft = this.f28952f.getCompoundDrawableLeft(context, i12, i13, i11, isValid, z11);
        Drawable compoundDrawableTop = this.f28952f.getCompoundDrawableTop(context, i12, i13, i11, isValid, z11);
        Drawable compoundDrawableRight = this.f28952f.getCompoundDrawableRight(context, i12, i13, i11, isValid, z11);
        boolean z12 = z10;
        textView.setCompoundDrawables(compoundDrawableLeft, compoundDrawableTop, compoundDrawableRight, this.f28952f.getCompoundDrawableBottom(context, i12, i13, i11, isValid, z12));
        textView.setContentDescription(this.f28952f.getContentDescription(context, i12, i13, i11, isValid, z12, c11));
    }

    private void p(MaterialCalendarGridView materialCalendarGridView, long j11) {
        if (Month.d(j11).equals(this.f28947a)) {
            int h11 = this.f28947a.h(j11);
            o((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().a(h11) - materialCalendarGridView.getFirstVisiblePosition()), j11, h11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i11) {
        return b() + (i11 - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f28947a.f(this.f28951e.getFirstDayOfWeek());
    }

    @Override // android.widget.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Long getItem(int i11) {
        if (i11 < b() || i11 > m()) {
            return null;
        }
        return Long.valueOf(this.f28947a.g(n(i11)));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
    @Override // android.widget.Adapter
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.widget.TextView getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            r0 = 1
            android.content.Context r1 = r8.getContext()
            r5.f(r1)
            r1 = r7
            android.widget.TextView r1 = (android.widget.TextView) r1
            r2 = 0
            if (r7 != 0) goto L1f
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r1 = com.google.android.material.R$layout.mtrl_calendar_day
            android.view.View r7 = r7.inflate(r1, r8, r2)
            r1 = r7
            android.widget.TextView r1 = (android.widget.TextView) r1
        L1f:
            int r7 = r5.b()
            int r7 = r6 - r7
            if (r7 < 0) goto L54
            com.google.android.material.datepicker.Month r8 = r5.f28947a
            int r3 = r8.f28899d
            if (r7 < r3) goto L2e
            goto L54
        L2e:
            int r7 = r7 + r0
            r1.setTag(r8)
            android.content.res.Resources r8 = r1.getResources()
            android.content.res.Configuration r8 = r8.getConfiguration()
            java.util.Locale r8 = r8.locale
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r4 = new java.lang.Object[r0]
            r4[r2] = r3
            java.lang.String r3 = "%d"
            java.lang.String r8 = java.lang.String.format(r8, r3, r4)
            r1.setText(r8)
            r1.setVisibility(r2)
            r1.setEnabled(r0)
            goto L5d
        L54:
            r7 = 8
            r1.setVisibility(r7)
            r1.setEnabled(r2)
            r7 = -1
        L5d:
            java.lang.Long r6 = r5.getItem(r6)
            if (r6 != 0) goto L64
            return r1
        L64:
            long r2 = r6.longValue()
            r5.o(r1, r2, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.m.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    boolean g(long j11) {
        Iterator<androidx.core.util.e> it = this.f28948b.getSelectedRanges().iterator();
        while (it.hasNext()) {
            Object obj = it.next().f8348b;
            if (obj != null && ((Long) obj).longValue() == j11) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return f28946h;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i11) {
        return i11 / this.f28947a.f28898c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(int i11) {
        return i11 % this.f28947a.f28898c == 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i(int i11) {
        return (i11 + 1) % this.f28947a.f28898c == 0;
    }

    boolean k(long j11) {
        Iterator<androidx.core.util.e> it = this.f28948b.getSelectedRanges().iterator();
        while (it.hasNext()) {
            Object obj = it.next().f8347a;
            if (obj != null && ((Long) obj).longValue() == j11) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m() {
        return (b() + this.f28947a.f28899d) - 1;
    }

    int n(int i11) {
        return (i11 - b()) + 1;
    }

    public void q(MaterialCalendarGridView materialCalendarGridView) {
        Iterator it = this.f28949c.iterator();
        while (it.hasNext()) {
            p(materialCalendarGridView, ((Long) it.next()).longValue());
        }
        DateSelector dateSelector = this.f28948b;
        if (dateSelector != null) {
            Iterator<Long> it2 = dateSelector.getSelectedDays().iterator();
            while (it2.hasNext()) {
                p(materialCalendarGridView, it2.next().longValue());
            }
            this.f28949c = this.f28948b.getSelectedDays();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r(int i11) {
        return i11 >= b() && i11 <= m();
    }
}
